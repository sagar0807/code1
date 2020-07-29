package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityReceipt;

@Repository
public interface FacilityReceiptRepository extends JpaRepository<FacilityReceipt, Long>,CustomRepository {

	FacilityReceipt findByFacilityDispatch_FacilityDispatchId(Long facilityDispatchId);

	FacilityReceipt findByFacilityReceiptId(Long facilityReceiptId);

	@Query(value = "select fr from FacilityReceipt fr where (fr.facilityDispatch.consignor.id IN :consignorIds or "
			+ "fr.facilityDispatch.consignee.id IN :consignorIds) and fr.facilityReceiptStatusMaster.id in (5,8)")
	List<FacilityReceipt> findReconcilationList(@Param("consignorIds") List<Long> consignorIds);

	@Query(value = "select r.* from soch.facility_receipt as r where r.facility_dispatch_id IN :facilityDispatchIds", nativeQuery = true)
	List<FacilityReceipt> findByFacilityDispatchIds(@Param("facilityDispatchIds") List<Long> facilityDispatchIds);


	List<FacilityReceipt> findAllByFacilityDispatch_Consignee_IdAndFacilityDispatch_Consignor_FacilityType_IdNotInOrderByFacilityReceiptIdDesc(
			Long facilityId, List<Long> excludedFacilityTypeIds);

	List<FacilityReceipt> findAllByFacilityDispatch_Consignee_IdAndFacilityDispatch_Consignor_FacilityType_IdInOrderByFacilityReceiptIdDesc(
			Long facilityId, List<Long> facilityTypeIds);
	
	@Query(value = "select f.* from soch.facility_receipt f where f.received_facility_id IN :facilityIds", nativeQuery = true)
	List<FacilityReceipt> findByReceivedFacilityIds(@Param("facilityIds") List<Long> facilityIds);



	


}
