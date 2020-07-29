package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterClientStatus;

@Repository
public interface MasterClientStatusRepository extends JpaRepository<MasterClientStatus, Long> {

	
	 List<MasterClientStatus> findByIsDelete(Boolean isDelete);

	List<MasterClientStatus> findByFacilityTypeIdAndIsDelete(Long facilityTypeId, Boolean isDelete);

}