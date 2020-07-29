package gov.naco.soch.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.SummaryDto;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.projection.StatisticsProjection;

/**
 * Spring Data repository for the TIBeneficiary entity.
 */
@Repository
public interface TIBeneficiaryRepository
		extends JpaRepository<TIBeneficiary, Long>, JpaSpecificationExecutor<TIBeneficiary> {
        @Override
        @EntityGraph(value = "tiBeneficiaryGraph")
        Page<TIBeneficiary> findAll(Specification<TIBeneficiary> spec, Pageable pageable);

	@Query(nativeQuery = true, value = "select * from soch.ti_beneficiary where beneficiary_id=:beneficiaryId")
	TIBeneficiary findbyBenficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select registrations,plhivs,active_plhivs,active_hrgs from soch.SUMMARYDATA()")
	Object getSummaryData();

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_reg),'MONTH') AS name, "
			+ " COUNT(ti_core_beneficiary_id) AS value FROM soch.ti_core_beneficiary "
			+ " WHERE facility_id=:facilityId and to_char(date_of_reg,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseRegistrationCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',date_of_screening),'MONTH') AS name, "
			+ " COUNT(tcb.beneficiary_id) AS value FROM soch.ti_screening_details tsd join soch.ti_core_beneficiary tcb on tcb.beneficiary_id="
			+ " tsd.beneficiary_id "
			+ " WHERE facility_id=:facilityId  and lower(screening_status_hiv)='positive' and to_char(date_of_screening,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivReactiveCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name, "
			+ " COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br join soch.art_beneficiary_details ab on ab.beneficiary_id=br.beneficiary_id "
			+ " WHERE refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ " and   refered_from =:facilityId "
			+ " and   to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getMonthwiseBeneficiaryReferralsCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',isc.tested_date),'MONTH') AS name, "
			+ " COUNT(isc.beneficiary_id) AS value " + " FROM soch.ictc_sample_collection isc "
			+ " WHERE lower(isc.hiv_status)='tested' and  to_char(isc.tested_date,'YYYY')=to_char(now(),'YYYY')GROUP BY 1")
	List<StatisticsProjection> getMonthwiseHivTestsCount();

	@Query(nativeQuery = true, value = "SELECT TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name , "
			+ " COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br "
			+ " WHERE NOT EXISTS(SELECT FROM soch.art_beneficiary_details where beneficiary_id=br.beneficiary_id) "
			+ " and refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ " and refered_from=:facilityId" + " and   to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY') GROUP BY 1")
	List<StatisticsProjection> getArtReferredButNotLinkedCount(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT  TO_CHAR(DATE_TRUNC('month',br.refer_date),'MONTH') AS name, "
			+ "  COUNT(br.beneficiary_id) AS value FROM soch.beneficiary_referral br "
			+ "  join soch.art_beneficiary_details  abd on br.beneficiary_id=abd.beneficiary_id "
			+ "  WHERE  refered_to in (select id from soch.facility where facility_type_id in (15,16,17,18)) "
			+ "  and    refered_from=:facilityId and lower(patient_art_status)=:status "
			+ "  and  to_char(br.refer_date,'YYYY')=to_char(now(),'YYYY')" + "  GROUP BY 1")
	List<StatisticsProjection> getArtRefferedLinkedBasedOnStatusCount(@Param("facilityId") Long facilityId,
			@Param("status") String status);

	default SummaryDto getSummaryDashboardDetails() {

		Object object = getSummaryData();
		SummaryDto summaryDto = new SummaryDto();
		if (object instanceof Object[]) {
			Object[] values = (Object[]) object;
			summaryDto.setRegistrations((BigInteger) values[0]);
			summaryDto.setPlhivs((BigInteger) values[1]);
			summaryDto.setActivePlhivs((BigInteger) values[2]);
			summaryDto.setActive_hrgs((BigInteger) values[3]);
		}
		return summaryDto;

	}
	boolean existsByTiCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeleted(String tiCode,
			Long facilityId, boolean b);

	Optional<TIBeneficiary> findByTiCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
			String tiCode, Long facilityId, boolean isDeleted,Long beneficiaryId);

	Long countByPeCodeAndFacility_Id(String peCode, Long facilityId);

}
