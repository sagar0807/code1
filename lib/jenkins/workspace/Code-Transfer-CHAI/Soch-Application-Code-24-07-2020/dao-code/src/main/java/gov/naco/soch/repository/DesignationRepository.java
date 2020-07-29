package gov.naco.soch.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Designation;

//repository mapped with entity class

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

	// function to findAll by isDelete
	ArrayList<Designation> findByIsDelete(Boolean isdelete);

	// Query to find duplicate for edit
	@Query(nativeQuery = true, value = "select count(d.id) from soch.designation d where LOWER(d.title)=LOWER(?1) and d.id!=?2")
	int existsByTitleInEdit(String title, Long id);

	// Query to find duplicate for add
	@Query(nativeQuery = true, value = "select count(d.id) from soch.designation d where is_delete = false and  LOWER(d.title)=LOWER(?1)")
	int existsByOtherTitleInAdd(String title);

	@Query(nativeQuery = true, value = "select title from soch.designation  where is_delete = false and  is_active = true order by id asc")
	List<Designation> findByIsActive();

	@Query(nativeQuery = true, value = "select count(designation_id) from soch.user_master where designation_id =?1 and is_delete=false")
	int findDeleteUser(Long id);

	@Query(nativeQuery = true, value = "select d.* from soch.designation d \r\n"
			+ "join soch.designation_facility_type_mapping dftm on dftm.designation_id=d.id \r\n"
			+ "where dftm.facility_type_id=:facilityType and d.is_active=true and d.is_delete=false \r\n"
			+ "group by d.id order by d.title asc")
	List<Designation> findAllByFacilityTypeId(@Param("facilityType") Long facilityType);

	List<Designation> findByIsDeleteOrderByIdAsc(boolean b);

}
