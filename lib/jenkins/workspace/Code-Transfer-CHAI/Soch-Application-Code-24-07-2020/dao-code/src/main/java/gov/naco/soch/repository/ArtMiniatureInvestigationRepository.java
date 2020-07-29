package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface ArtMiniatureInvestigationRepository extends JpaRepository<Beneficiary, Long> {

	@Query(nativeQuery = true , value ="select  TO_CHAR(DATE_TRUNC('month',abi.investigation_date),'MONTH') AS name, "
			+ " count(abi.id) as value from soch.beneficiary b "
			+ " inner join soch.art_beneficiary ab on b.id = ab.beneficiary_id "
			+ " inner join soch.art_beneficiary_investigation abi on abi.beneficiary_id = ab.beneficiary_id and abi.facility_id = ab.facility_id "
			+ " inner join soch.master_investigation mi on abi.investigation_id = mi.id "
			+ " where ab.facility_id  = :facilityId and abi.is_active = true and abi.is_delete=false "
			+ " and b.id = :beneficiaryId and mi.id = :investigationId "
			+ " and abi.investigation_date >= date_trunc('month', now())- interval '11 month' GROUP BY 1 ")
	List<StatisticsProjection> getInvestigationDetails(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId , @Param("investigationId") Long investigationId);

    @Query(nativeQuery = true, value = "select id from soch.master_investigation fetch first 1 row only")
	Long getFirstInvestigationId();

    @Query(nativeQuery = true, value = "select mi.id as value, mi.name as name from soch.master_investigation mi")
	List<StatisticsProjection> getMasterInvestigationDetails();


}
