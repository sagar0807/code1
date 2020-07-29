package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTGSubCategory;

@Repository
public interface MasterTGSubCategoryRepository extends JpaRepository<MasterTGSubCategory, Long> {

	List<MasterTGSubCategory> findByIsDelete(Boolean isDelete);

}