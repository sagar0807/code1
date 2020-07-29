/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSocialWelfare;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-21 12:11:55 pm 
 * 
 */
@Repository
public interface MasterSocialWelfareRepository  extends JpaRepository<MasterSocialWelfare, Long>{
	List<MasterSocialWelfare> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true,value = "select * from soch.master_social_welfare where sacs_id=:sacsId and is_delete=false")
	List<MasterSocialWelfare> findByIsDeleteAndSacsId(@Param("sacsId")Long sacsId);

}
