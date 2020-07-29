package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterInventoryUnregisteredSource;

@Repository
public interface MasterInventoryUnregisteredSourceRepository
		extends JpaRepository<MasterInventoryUnregisteredSource, Long> {

	List<MasterInventoryUnregisteredSource> findByIsDelete(Boolean isDelete);

	List<MasterInventoryUnregisteredSource> findByIsDeleteAndIsFacility(Boolean isDelete, Boolean isFacility);

}
