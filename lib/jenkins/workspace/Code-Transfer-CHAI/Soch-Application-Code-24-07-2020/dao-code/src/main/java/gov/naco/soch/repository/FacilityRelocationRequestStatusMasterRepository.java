package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.naco.soch.entity.FacilityRelocationRequestStatusMaster;

public interface FacilityRelocationRequestStatusMasterRepository
		extends JpaRepository<FacilityRelocationRequestStatusMaster, Long> {

	FacilityRelocationRequestStatusMaster findByStatusAndIsDelete(String status, Boolean isDelete);

}
