package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFSWSubCategory;

@Repository
public interface MasterFSWSubCategoryRepository extends JpaRepository<MasterFSWSubCategory, Long> {

	List<MasterFSWSubCategory> findByIsDelete(Boolean isDelete);

}
