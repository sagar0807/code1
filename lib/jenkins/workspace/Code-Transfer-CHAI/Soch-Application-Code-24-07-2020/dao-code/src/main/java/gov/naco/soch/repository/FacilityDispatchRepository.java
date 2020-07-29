package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatch;

@Repository
public interface FacilityDispatchRepository extends JpaRepository<FacilityDispatch, Long>,CustomRepository {

	@Query(value = "select f.* from soch.facility_dispatch f where  f.consignor_facility_id = :consignorId", nativeQuery = true)
	List<FacilityDispatch> findAllByConsignorId(@Param("consignorId") Long consignorId);

	FacilityDispatch findByFacilityDispatchId(Long facilityDispatchId);

	@Query(value = "select f.* from soch.facility_dispatch f where lower(f.dispatch_type) = 'relocate' and f.consignor_facility_id IN :consignorIds order by f.facility_dispatch_id desc", nativeQuery = true)
	List<FacilityDispatch> findByConsignorIdsForRelocate(@Param("consignorIds") List<Long> consignorIds);

	List<FacilityDispatch> findAllByConsignee_IdAndFacilityDispatchStatusMaster_IdInAndConsignor_FacilityType_IdInOrderByFacilityDispatchIdDesc(
			Long facilityId, List<Long> statusIds, List<Long> facilityTypeIds);

	List<FacilityDispatch> findAllByConsignee_IdAndFacilityDispatchStatusMaster_IdInAndConsignor_FacilityType_IdNotInOrderByFacilityDispatchIdDesc(
			Long facilityId, List<Long> statusIds, List<Long> excludedFacilityTypeIds);

	

}
