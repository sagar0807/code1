package gov.naco.soch.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.projection.OrwProjection;
import gov.naco.soch.projection.UserBasicProjection;
import gov.naco.soch.projection.UserDetailsProjection;
import gov.naco.soch.projection.UserListProjection;
import gov.naco.soch.projection.UserRoleAccessProjection;

//repository mapped with entity class

@Repository
public interface UserMasterRepository
		extends JpaRepository<UserMaster, Long>, JpaSpecificationExecutor<UserMaster>, CustomRepository {

	@Query(nativeQuery = true, value = "select * from soch.user_master where is_delete=false order by id desc limit 1000")
	List<UserMaster> findAll();

	@Query(nativeQuery = true, value = "select um.id as userId, um.firstname as firstname, \r\n"
			+ "um.lastname as lastname, um.division_id as divisionId, \r\n"
			+ "um.facility_type_id as facilityTypeId, \r\n" + "um.facility_id as facilityId, \r\n"
			+ "f.name as facilityName, f.code as facilityCode, \r\n" + "um.designation_id as designationId, \r\n"
			+ "dsgn.title as designation, \r\n" + "ua.username as username, \r\n"
			+ "ua.password as password, rl.id as roleId, rl.name as roleName, \r\n"
			+ "ua.last_login_time as lastLoginTime, f.c_b_status as facilityCbStatus \r\n"
			+ "from soch.user_master as um \r\n" + "join soch.user_auth as ua on ua.user_id = um.id \r\n"
			+ "left join soch.designation as dsgn \r\n" + "on um.designation_id = dsgn.id \r\n"
			+ "join soch.user_role_mapping urm on urm.user_id = um.id \r\n"
			+ "join soch.role rl on rl.id = urm.role_id \r\n" + "join soch.facility f on f.id = um.facility_id \r\n"
			+ "where lower(ua.username)=lower(:username) and ua.is_delete=false and um.status=1")
	List<UserDetailsProjection> findUserDetails(@Param("username") String username);

	@Query(nativeQuery = true, value = "select ram.access_code as accessCode, \r\n" + "am.is_primary as isPrimary "
			+ "from role_access_mapping ram \r\n"
			+ "join access_master am on am.code = ram.access_code join role rl \r\n"
			+ "on rl.id = ram.role_id join user_role_mapping urm on urm.role_id = rl.id\r\n"
			+ "where urm.user_id = :userId")
	List<UserRoleAccessProjection> getUserRoleAccessByUserId(@Param("userId") Long userId);

	// to get user details from user_master corresponding to facilityType_id
	@Query(nativeQuery = true, value = "select u.id,u.firstName,u.lastName from soch.user_master u join "
			+ "soch.facility_type f on f.id=u.facility_type_id join soch.user_role_mapping urm"
			+ " on urm.user_id=u.id join soch.role r on r.id=urm.role_id where u.facility_type_id=?1 and r.is_primary=true order by u.firstName asc")
	List<Object[]> findUserByFacilityTypeId(Long id);

	@Query(value = "select u from UserMaster u where facility.id=?1")
	ArrayList<UserMaster> findByFacilityId(Long id);

	@Query(nativeQuery = true, value = "select * from soch.user_master u where u.is_delete=false and u.firstname=:firstname")
	UserMaster findByName(@Param("firstname") String firstname);

	@Query(nativeQuery = true, value = "select * from soch.user_master where is_delete=false and id=?1")
	UserMaster findByUserId(Long id);

	Set<UserMaster> findAllByFacilityId(Long facilityId);

	// @Query(nativeQuery = true, value = "select * from soch.user_master where
	// mobile_number=?1")
	// ArrayList<UserMaster> searchUserByMobileNumber(String mobileNumber);

	@Query(nativeQuery = true, value = "select * from soch.user_master where mobile_number=:mobileNumber")
	ArrayList<UserMaster> searchUserByMobileNumber(@Param("mobileNumber") String mobileNumber);

	@Query(nativeQuery = true, value = "select * from soch.user_master where firstname=:name or lastname=:name")
	ArrayList<UserMaster> searchUserByName(@Param("name") String name);

	@Query(nativeQuery = true, value = "select * from soch.user_master where email=:emailId")
	ArrayList<UserMaster> searchUserByEmailId(@Param("emailId") String emailId);

	@Query(nativeQuery = true, value = "select * from soch.user_master where id = (select id from soch.user_auth where username=:username)")
	ArrayList<UserMaster> searchUserByUserName(@Param("username") String username);

	List<UserMaster> findAllByFacilityIdAndIsDelete(Long facilityId, Boolean false1);

	/**
	 * Search Queries
	 * 
	 * @param searchValue
	 * @param userId
	 * @param pageable
	 * @return
	 */

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,"
			+ "u.mobile_number as mobile,"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR u.mobile_number LIKE :searchValue) AND \r\n"
			+ "u.is_delete=false and u.id!=:userId ")
	Page<UserListProjection> userNormalSearch(@Param("searchValue") String searchValue, @Param("userId") Long userId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR\r\n" + "u.mobile_number LIKE :searchValue) AND \r\n"
			+ "u.is_delete=false and u.id!=:userId")
	int userNormalSearchActualRecordCount(@Param("searchValue") String searchValue, @Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,"
			+ "u.mobile_number as mobile,"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR\r\n" + "u.mobile_number LIKE :searchValue) AND \r\n"
			+ "u.is_delete=false AND u.facility_id=:facilityId and u.id!=:userId")
	Page<UserListProjection> userNormalSearchBasedOnFacility(@Param("searchValue") String searchValue,
			@Param("facilityId") Long facilityId, @Param("userId") Long userId, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR\r\n" + "u.mobile_number LIKE :searchValue) AND \r\n"
			+ "u.is_delete=false AND u.facility_id=:facilityId and u.id!=:userId")
	int userNormalSearchBasedOnFacilityActualRecordCount(@Param("searchValue") String searchValue,
			@Param("facilityId") Long facilityId, @Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select u.* from soch.user_master as u \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "join soch.role_access_mapping as ram on ram.role_id = r.id \r\n"
			+ "where ram.access_code=:accessCode AND u.facility_id=:facilityId AND u.is_delete=false "
			+ "group by u.id")
	List<UserMaster> findUsersListByAccessCodeAndFacilityId(@Param("accessCode") String accessCode,
			@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,ua.username as userName,u.division_id as divisionId,\r\n" + 
			"r.id as roleId,r.name as roleName,u.pe_code as peCode,u.orw_code as orwCode,\r\n" + 
			"u.email as email,u.facility_type_id as facilityTypeId,u.typology_id as typologyId,\r\n" + 
			"u.is_trained as isTrained,u.mobile_number as mobileNumber,u.status as status,\r\n" + 
			"u.facility_id as facilityId,u.sms_enabled as smsEnabled,u.whatsapp_enabled as whatsappEnabled,\r\n" + 
			"u.last_training_date as lastDateOfTraining,u.type_of_training_id as typeOfTraining,u.is_active as isActive "
			+ "from soch.user_master as u \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "join soch.role_access_mapping as ram on ram.role_id = r.id \r\n"
			+ "where ram.access_code=:accessCode AND u.facility_id=:facilityId AND u.is_delete=false "
			+ "group by u.id,ua.id,r.id")
	List<UserBasicProjection> findBasicUsersListByAccessCodeAndFacilityId(@Param("accessCode") String accessCode,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select u.* from soch.user_master as u \r\n"
			+ "join soch.orw_pe_mapping as opm on opm.pe_user_id=u.id \r\n"
			+ "where opm.orw_user_id = :orwId and opm.is_delete=false and u.is_delete=false \r\n" + "group by u.id")
	List<UserMaster> findPeByOrw(@Param("orwId") Long orwId);

	// to get user details from user_master corresponding to facilityType_id
	@Query(nativeQuery = true, value = "select u.id,u.firstName,u.lastName,u.email,u.mobile_number as mobileNumber from soch.user_master u where u.id  = ?")
	UserDetailsProjection getUserDetailById(Long id);

	Page<UserMaster> findAllByIsDelete(boolean b, Pageable pageable);

	Page<UserMaster> findAllByFacilityIdAndIsDelete(Long facilityId, Boolean false1, Pageable pageable);

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,\r\n"
			+ "u.mobile_number as mobile,\r\n"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u  \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where u.is_delete=false and u.id!=:userId")
	Page<UserListProjection> findAllUserList(@Param("userId") Long userId, Pageable pageable);

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,\r\n"
			+ "u.mobile_number as mobile,\r\n"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u  \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "where u.is_delete=false and u.facility_id=:facilityId and u.id!=:userId")
	Page<UserListProjection> findAllUserList(@Param("userId") Long userId, @Param("facilityId") Long facilityId,
			Pageable pageabl);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u  \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where u.is_delete=false and u.id!=:userId")
	int findCountOfTotalRecord(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u  \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where u.is_delete=false and u.facility_id=:facilityId and u.id!=:userId")
	int findCountOfTotalRecord(@Param("userId") Long userId, @Param("facilityId") Long facilityId);
	
	
	@Query(nativeQuery = true, value = "select u.id,u.orw_code,u.firstname,r.id as roleId from soch.user_master as u \r\n" 
			+ " join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ " join soch.role r on urm.role_id=r.id \r\n"
			+ " where u.facility_id=:facilityId AND u.typology_id=:typologyId AND u.is_delete=false")
	List<OrwProjection> findUsersListByFacilityIdAndTypologyId(@Param("facilityId") Long facilityId, 
			@Param("typologyId") Long  typologyId);

}
