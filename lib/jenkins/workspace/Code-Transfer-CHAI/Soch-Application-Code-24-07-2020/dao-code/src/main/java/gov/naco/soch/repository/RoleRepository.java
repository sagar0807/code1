package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Role;

//repository mapped with entity class

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "select count(id) from soch.role where (LOWER(name)=LOWER(?1) and facility_type_id=?2) and id!=?3")
	int foundDuplicateInEdit(String name, Long divisionId, Long id);

	@Query(nativeQuery = true, value = " select count(id) from soch.role where is_delete = false and LOWER(name)=LOWER(?1) and facility_type_id=?2")
	int foundDuplicateRoleNameInAdd(String name, Long id);

	@Query(nativeQuery = true, value = "select r.id,r.name from soch.role r join"
			+ " soch.user_role_mapping urm on r.id=urm.role_id join soch.user_master u "
			+ "on u.id=urm.user_id where u.id=?1 and r.is_primary=true ")
	List<Object[]> findRoleByUserId(Long id);

	List<Role> findByIsDeleteOrderByIdAsc(Boolean b);

	List<Role> findByFacilityTypeIdAndIsDelete(Long facilityTypeId, Boolean b);

	@Query(nativeQuery = true, value = "select count(r.role_id) from soch.user_role_mapping r join soch.user_master u on u.id = r.user_id where r.role_id =?1 and u.is_delete = false")
	int findDeleteUser(Long id);

	List<Role> findByFacilityTypeIdAndIsDeleteAndIsPrimaryOrderByNameAsc(Long facilityTypeId, Boolean isDelete, Boolean isPrimary);

}
