package gov.naco.soch.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.projection.FacilityDetailedProjection;
import gov.naco.soch.projection.FacilityPerformanceDetailProjection;
import gov.naco.soch.projection.FacilityProjection;

//repository mapped with entity class

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>, CustomRepository {

	// Method to list all facilities where isDelete=false
	List<Facility> findByIsDelete(Boolean b);

	// Method to check whether the facility name is already exist or not-In add
	boolean existsByNameIgnoreCase(String name);

	// Method to check whether the facility name is already exist or not-In edit
	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and  LOWER(name)=LOWER(?1) and id!=?2 ")
	Integer existsByNameInEdit(String name, Long id);

	// Method to retrieve facilities based on division and facility type
	// @Query(value = "select f from Facility f where f.division.id=:divisionId and
	// f.facilityType.id=:facilityTypeId and is_delete=false and status='Active'")
	@Query(nativeQuery = true, value = "select f.* from soch.facility f where f.division_id = :divisionId and f.facility_type_id = :facilityTypeId and is_delete=false and is_active=true")
	List<Facility> findByDivisionAndFacilityType(@Param("divisionId") Long divisionId,
			@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select f.division_id,f.facility_type_id,f.id,f.name from soch.facility f where f.division_id = :divisionId and f.facility_type_id = :facilityTypeId and is_delete=false and is_active=true order by f.name")
	List<Object[]> findByDivisionAndFacilityTypeToObject(@Param("divisionId") Long divisionId,
			@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =11 or f.facility_type_id =13")
	List<Facility> findByICTC();

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =12")
	List<Facility> findByDSRC();

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =27")
	List<Facility> findByRNTCP();

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =7 or f.facility_type_id =8 or f.facility_type_id =9 or f.facility_type_id =10")
	List<Facility> findByTI();

	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(name) = LOWER(?1)")
	int existsByOtherNameInAdd(String name);

	@Query(nativeQuery = true, value = "select * from soch.facility where parent_facility_id=?1 and is_delete=false and is_active=true")
	ArrayList<Facility> findLacByArt(Long facilityId);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f join soch.address a \r\n"
			+ "on f.address_id = a.id where a.district_id = :districtId \r\n"
			+ "and f.is_delete=false and f.parent_facility_id is null")
	List<Facility> findFacilitiesByDistrictId(@Param("districtId") Long districtId);

	@Query(nativeQuery = true, value = "select count(facility_id) from soch.user_master where facility_id =?1 and is_delete=false")
	int findDeleteUser(Long facilityId);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId from Facility f where f.facilityType.id=2")
	List<FacilityProjection> findSacsFacilities();

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId from Facility f where f.facilityType.id=6 and f.address.district.id=:districtId")
	List<FacilityProjection> findWareHouseFacilities(@Param("districtId") Long districtId);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId from Facility f where f.facilityType.id not in (2,3,6)")
	List<FacilityProjection> findFacilities();

	@Query("select f.id as id,f.name as name,f.code as code,f.address.state.id as stateId,f.address.state.name as state,"
			+ "f.address.address as address, f.address.district.name as district,f.address.pincode as pincode "
			+ "from Facility f where f.facilityType.id=2 and f.isActive=true and isDelete=false order by f.name asc")
	List<FacilityDetailedProjection> findAllSacs();

	@Query(value = "select f.* from soch.facility f where f.is_active = true and f.division_id IN :divisionIds and f.sacs_id=:facilityId", nativeQuery = true)
	List<Facility> findByDivisionIds(@Param("divisionIds") List<Long> divisionIds,
			@Param("facilityId") Long facilityId);

	List<Facility> findBySacsIdAndIsDeleteAndIsActive(Long sacsId, Boolean isDelete, Boolean isActive);

	@Query(nativeQuery = true, value = "select * from facility where facility_type_id =:facilityTypeId")
	List<Facility> findByfacilityTypeId(@Param("facilityTypeId") int facilityTypeId);

	List<Facility> findByFacilityTypeIdAndIsDelete(Long facilityTypeId, Boolean isDelete);

	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(name) = LOWER(?1) and id != ?2")
	int existsByOtherNameInEdit(String name, Long id);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f where f.sacs_id=:sacsId and f.is_delete=:isDelete and f.facility_type_id NOT IN :facilityTypes and (f.is_external is NULL or f.is_external=false )")
	Page<Facility> findBySacsIdAndIsDeleteAndNotInFacilityTypes(@Param("sacsId") Long sacsId,
			@Param("isDelete") Boolean isDelete, @Param("facilityTypes") List<Long> facilityTypes, Pageable pageable);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete = false and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	Page<Facility> findByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId, Pageable pageable);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId ,f.address.state.name as state,"
			+ "f.address.address as address, f.address.state.name as district,f.address.pincode as pincode "
			+ "from Facility f where f.facilityType.id in (:facilityTypeIds) ")
	List<FacilityDetailedProjection> findAllLabs(@Param("facilityTypeIds") List<Long> facilityTypeIds);

	List<Facility> findByFacilityTypeIdAndSacsIdAndIsDelete(Long facilityTypeId, Long sacsId, Boolean false1);

	Facility findByIdAndIsDelete(Long facilityId, Boolean false1);

	@Query(nativeQuery = true, value = "select f.id,f.name  as name,f.code as ostCode,ft.facility_type_name as facilityTypeName,\r\n"
			+ "a.address,a.pincode,s.id as stateId,s.name as state,d.name as district,t.town_name as town,a.city,a.block,\r\n"
			+ "dv.head_email_id as centerEmailId,dv.head_phone_number as centerPhNo from soch.facility f left join  \r\n"
			+ "soch.facility_type ft on f.facility_type_id = ft.id inner join soch.address a on f.address_id =a.id left join\r\n"
			+ "soch.state s on s.id = a.state_id left join soch.district d on a.district_id  = d.id left join \r\n"
			+ "soch.town t on t.town_id = a.town_id left join soch.division dv on f.division_id = dv.id\r\n"
			+ "where f.id =  :facilityId ")
	FacilityPerformanceDetailProjection getFacilityById(@Param("facilityId") Long facilityId);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId ,f.address.state.name as state,"
			+ "f.address.address as address, f.address.state.name as district,f.address.pincode as pincode "
			+ "from Facility f where f.sacsId=:sacsId and f.isActive=true and f.facilityType.id in (:facilityTypeIds) ")
	List<FacilityDetailedProjection> findFacilitiesBySacsIdAndFacilityType_IdIn(@Param("sacsId") Long sacsId,
			@Param("facilityTypeIds") List<Long> facilityTypeIds);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId ,f.address.state.name as state,"
			+ "f.address.address as address, f.address.state.name as district,f.address.pincode as pincode "
			+ "from Facility f where f.sacsId=:sacsId and f.isActive=true and f.facilityType.id not in (:excludedFacilityTypeIds) ")
	List<FacilityDetailedProjection> findFacilitiesBySacsIdAndFacilityType_IdNotIn(@Param("sacsId") Long sacsId,
			@Param("excludedFacilityTypeIds") List<Long> excludedFacilityTypeIds);

	List<Facility> findByFacilityTypeIdInAndFacilityIdAndIsDelete(List<Long> facilityTypeId, Long facilityId,
			Boolean false1);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete =:isDelete and parent_facility_id=:parentId and facility_type_id=:facilityTypeId and (f.is_external is NULL or f.is_external=false ) ")
	Page<Facility> findAllByFacilityIdAndFacilityTypeIdAndIsDelete(@Param("parentId") Long parentId,
			@Param("facilityTypeId") Long facilityTypeId, @Param("isDelete") Boolean isDelete, Pageable pageable);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f \r\n"
			+ "join soch.address as addr on addr.id=f.address_id \r\n"
			+ "where addr.district_id=:district and f.facility_type_id=:facilityType and f.is_delete=false and addr.is_delete=false;")
	List<Facility> findAllByDistrictIdAndFacilityTypeId(@Param("district") Long district,
			@Param("facilityType") Long facilityType);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f \r\n"
			+ "join soch.address as addr on addr.id=f.address_id \r\n"
			+ "where addr.district_id=:district and f.is_delete=false and addr.is_delete=false;")
	List<Facility> findAllByDistrictId(@Param("district") Long district);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "join soch.mapping_lab_facility mlf on mlf.facility_id=f.id \r\n"
			+ "where f.is_delete=false and f.is_active=true and mlf.is_delete=false \r\n"
			+ "and mlf.lab_id=:facilityId and f.facility_type_id=:facilityType \r\n"
			+ "group by f.id order by f.name asc")
	List<Facility> findMappedFacilityByFacilityIdAndFacilityType(@Param("facilityId") Long facilityId,
			@Param("facilityType") Long facilityType);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "join soch.mapping_lab_facility mlf on mlf.lab_id=f.id \r\n"
			+ "where f.is_delete=false and f.is_active=true and mlf.is_delete=false \r\n"
			+ "and mlf.facility_id=:facilityId and f.facility_type_id in :facilityType \r\n"
			+ "group by f.id order by f.name asc")
	List<Facility> findMappedVlLabsByFacilityId(@Param("facilityId") Long facilityId,
			@Param("facilityType") List<Long> facilityType);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility f where f.sacs_id=:sacsId and f.is_delete=:false1 and f.facility_type_id NOT IN :facilityTypes and (f.is_external is NULL or f.is_external=false )")
	int findCountIdBySacsIdAndIsDeleteNotInFacilityTypes(@Param("sacsId") Long sacsId, @Param("false1") Boolean false1,
			@Param("facilityTypes") List<Long> facilityTypes);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete = false and sacs_id=:sacsId and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	Page<Facility> findBySacsIdAndFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			@Param("sacsId") Long sacsId, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete = false and sacs_id=:sacsId and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	int CountBySacsIdAndFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			@Param("sacsId") Long sacsId);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete = false and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	int CountByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete =:isDelete and parent_facility_id=:parentId and facility_type_id=:facilityTypeId and (f.is_external is NULL or f.is_external=false ) ")
	int countByFacilityIdAndFacilityTypeIdAndIsDelete(@Param("parentId") Long parentId,
			@Param("facilityTypeId") Long facilityTypeId, @Param("isDelete") Boolean isDelete);

	Optional<Facility> findByCode(String facilityCode);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "where f.is_delete=false and f.is_active=true and f.facility_type_id= :facilityTypeId \r\n"
			+ "and LOWER(f.name) like '%mhl%'  order by f.name asc")
	List<Facility> findMHLFacilities(@Param("facilityTypeId") Long facilityTypeId);

	List<Facility> findByFacilityType_IdAndIsDelete(Long facilityType, boolean b);

	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(facility_no) = LOWER(:facilityNo) and is_active=true")
	int existsByFacilityNumberInAdd(@Param("facilityNo") String facilityNo);

	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(facility_no) = LOWER(:facilityNo) and id !=:id and is_active=true")
	int existsByFacilityNumberInEdit(@Param("facilityNo") String facilityNo, @Param("id") Long id);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "join soch.typology_facility_mapping tfm on tfm.facility_id=f.id \r\n"
			+ "where f.is_delete=false and f.is_active=true \r\n"
			+ "and tfm.typology_id=4 and f.facility_type_id=:facilityType and f.sacs_id=:sacsId \r\n"
			+ "group by f.id order by f.name asc")
	List<Facility> findTiCenterUnderIDU(@Param("facilityType") Long facilityType, @Param("sacsId") Long sacsId);

	@Query("select facilityType.id from Facility where id=:referredToFacility")
	Long getFacilityType(@Param("referredToFacility") Long referredToFacility);
	
	@Query(nativeQuery = true, value = "select f.id as facilityId,f.name,ft.id,ft.facility_type_name from soch.facility as f "
			+ "join soch.facility_type ft on ft.id=f.facility_type_id "
			+ "where f.is_delete =false and f.is_active=true and f.parent_facility_id=:parentId and "
			+ "f.facility_type_id=:facilityTypeId and (f.is_external is NULL or f.is_external=false ) order by f.name asc ")
	List<Object[]> findFacilityByParentId(@Param("parentId") Long parentId,@Param("facilityTypeId") Long facilityTypeId);
}
