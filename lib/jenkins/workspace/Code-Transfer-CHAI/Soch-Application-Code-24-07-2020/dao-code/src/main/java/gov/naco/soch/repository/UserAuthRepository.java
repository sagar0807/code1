package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.UserAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

	@Query(nativeQuery=true,value="select count(id) from soch.user_auth where is_delete = false and lower(username)=lower(:username)")
	int existsByUsernameIgnoreCase(@Param("username")String username);

	@Query(nativeQuery=true,value="select * from soch.user_auth where user_id=:userId")
	UserAuth findByUserMaster(@Param("userId") Long userId);
	
	@Query(nativeQuery=true,value="select active_token from soch.user_auth where user_id=:userId")
	String findActiveTokenByUserId(@Param("userId") Long userId);

	@Query(nativeQuery=true,value="select * from soch.user_auth where user_id=:userId")
	UserAuth findUserAuthByUserId(@Param("userId") Long userId);
	
	@Query(nativeQuery = true, value = "select * from soch.user_auth where username=:username")
	UserAuth findByUserName(@Param("username") String username);

}
