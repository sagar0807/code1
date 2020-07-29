package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.UserRoleMapping;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long> {

	UserRoleMapping findByUserMasterId(Long userId);

	void deleteByUserMasterId(Long userId);

	@Query(value = "select * from soch.user_role_mapping ur " + "where role_id = :roleId", nativeQuery = true)
	List<UserRoleMapping> findUserIdByRole(@Param("roleId") Long roleId);

}
