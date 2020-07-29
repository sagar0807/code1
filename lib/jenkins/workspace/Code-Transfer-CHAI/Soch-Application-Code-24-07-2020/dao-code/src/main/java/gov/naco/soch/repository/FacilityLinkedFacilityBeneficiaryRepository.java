package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.FacilityLinkedFacilityBeneficiary;

@Repository
public interface FacilityLinkedFacilityBeneficiaryRepository
		extends JpaRepository<FacilityLinkedFacilityBeneficiary, Long> {

	@Query(nativeQuery = true, value = "select * from soch.facility_linked_facility_beneficiary f where f.beneficiary_id=:beneficiaryId and f.parent_facility_id=:facilityId and f.is_delete=:isDelete order by f.id desc limit 1")
	Optional<FacilityLinkedFacilityBeneficiary> findByBeneficiaryAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("isDelete") boolean isDelete);

	@Query(nativeQuery = true, value = "select count(id) from soch.facility_linked_facility_beneficiary where is_linked=true and  linked_facility_id=:facilityId ")
	int findFacilityCountLinkedBeneficiary(@Param("facilityId") Long facilityId);

}
