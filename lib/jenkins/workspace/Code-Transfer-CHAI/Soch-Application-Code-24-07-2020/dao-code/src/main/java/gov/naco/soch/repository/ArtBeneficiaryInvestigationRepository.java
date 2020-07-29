package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryInvestigation;
import gov.naco.soch.projection.ArtBeneficiaryInvestigationProjection;

@Repository
public interface ArtBeneficiaryInvestigationRepository extends JpaRepository<ArtBeneficiaryInvestigation, Long> {

	// select * from soch.art_beneficiary_investigation
	// where beneficiary_id=1 and visit_register_id in(3,2,1) order by
	// visit_register_id DESC;

//	@Query(value = "select * from soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
//			+ "and bi.facility_id=:facilityId and visit_register_id IN :visitRegisterIds "
//			+ "order by visit_register_id ASC", nativeQuery = true)
//	List<ArtBeneficiaryInvestigation> findInvestigationByByBeneficiaryIdAndvisitRegisterIds(@Param("beneficiaryId") Long beneficiaryId,
//			@Param("facilityId") Long facilityId, @Param("visitRegisterIds") List<Long> visitRegisterIds);

	@Query(value = "select distinct investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
			+ "and bi.facility_id=:facilityId and visit_register_id IN :visitRegisterIds order by visit_register_id ASC", nativeQuery = true)
	List<ArtBeneficiaryInvestigationProjection> findInvestigationDates(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("visitRegisterIds") List<Long> visitRegisterIds);

	@Query(value = "select beneficiary_id as beneficiaryId, facility_id as facilityId, "
			+ "investigation_id as investigationId, investigation_value as investigationValue, "
			+ "investigation_date as investigationDate, visit_register_id as visitRegisterId from "
			+ "soch.art_beneficiary_investigation bi where bi.beneficiary_id=:beneficiaryId "
			+ "and bi.facility_id=:facilityId and visit_register_id IN :visitRegisterIds "
			+ "order by visit_register_id ASC", nativeQuery = true)
	List<ArtBeneficiaryInvestigationProjection> findInvestigationByBeneficiaryIdAndVisitRegisterIds(
			@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId,
			@Param("visitRegisterIds") List<Long> visitRegisterIds);

	@Query(value = "select * from soch.art_beneficiary_investigation bi "
			+ "where visit_register_id = :visitRegisterId", nativeQuery = true)
	List<ArtBeneficiaryInvestigation> findExistingInvestigationByVisitRegisterId(
			@Param("visitRegisterId") Long visitRegisterIds);

}
