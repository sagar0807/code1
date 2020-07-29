package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterMSMSubCategory;

@Repository
public interface MasterMSMSubCategoryRepository extends JpaRepository<MasterMSMSubCategory, Long> {

	List<MasterMSMSubCategory> findByIsDelete(Boolean isDelete);

}