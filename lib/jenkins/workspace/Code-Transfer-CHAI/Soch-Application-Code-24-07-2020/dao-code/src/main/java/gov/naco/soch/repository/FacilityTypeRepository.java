/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.MasterTreatmentOutcome;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long> {

	// method to check duplication in facilityTypeName in add
	@Query(nativeQuery = true, value = "select count(id) from soch.facility_type where LOWER(facility_type_name)=LOWER(?1)")
	int existsByFacilityTypeNameIgnoreCase(String facilityTypeName);

	// to get all facility types
	@Query(nativeQuery = true, value = "select * from soch.facility_type order by id asc")
	List<FacilityType> findAll();

	// method to check duplication in facilityTypeName in edit
	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility_type f where "
			+ "LOWER(f.facility_type_name)=LOWER(?1) and f.id!=?2")
	int existsByFacilityTypeNameInEdit(String facilityTypeName, Long id);

	@Query(nativeQuery = true, value = "select * from soch.facility_type where is_Active=?1")
	List<FacilityType> findByIsActive(boolean b);

	// to get all facility types
	@Query(nativeQuery = true, value = "select f.* from soch.facility_type f left join soch.facility_type_division_mapping m on \r\n"
			+ "(m.facility_type_id = f.id) where m.facility_type_id is null or m.is_delete=true order by id asc")
	List<FacilityType> findAllNotDivisionMappedFacTypes();

	@Query(nativeQuery = true, value = "select f.facility_type_id from soch.facility_type_division_mapping f  where f.is_delete=false")
	List<Integer> findByIsDelete();

	@Query(value = "select * from soch.facility_type d where d.id NOT IN (:facilityTypeList) and d.is_active=true and d.is_delete=false", nativeQuery = true)
	List<FacilityType> getList(@Param("facilityTypeList") List<Integer> facilityTypeList);

	@Query(nativeQuery = true, value = "select ft.* from soch.facility_type as ft \r\n"
			+ "join soch.facility_type_division_mapping as ftdm on ftdm.facility_type_id = ft.id \r\n"
			+ "where ftdm.division_id=:divisionid and ft.is_active=true and ftdm.is_delete=false;")
	List<FacilityType> findByDivisionId(@Param("divisionid") Long divisionid);

	List<FacilityType> findAllByIsDeleteAndIsActive(boolean b, boolean c);

	@Query(nativeQuery = true, value = "select id,facility_type_name from soch.facility_type where is_Active=true")
	List<Object[]> findLitByIsActive();

	List<FacilityType> findByIsDelete(Boolean isDelete);
	

	@Query(nativeQuery = true, value = "select count(d.id) from soch.facility_type d where is_delete = false  and is_active = true and  LOWER(d.facility_type_name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name);

}
