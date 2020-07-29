package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterCounsellingType;

@Repository
public interface MasterCounsellingTypeRepository extends JpaRepository<MasterCounsellingType, Long> {

	List<MasterCounsellingType> findByIsDelete(Boolean isDelete);

}