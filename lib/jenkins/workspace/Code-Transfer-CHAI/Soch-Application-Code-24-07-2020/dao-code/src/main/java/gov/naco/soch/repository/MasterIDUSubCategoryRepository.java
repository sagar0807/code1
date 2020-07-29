package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterIDUSubCategory;

@Repository
public interface MasterIDUSubCategoryRepository extends JpaRepository<MasterIDUSubCategory, Long> {

	List<MasterIDUSubCategory> findByIsDelete(Boolean isDelete);

}