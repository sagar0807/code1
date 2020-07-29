/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterScreeningStatus;
import gov.naco.soch.entity.MasterTrainingType;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jun-11 5:18:41 pm 
 * 
 */
@Repository
public interface MasterTrainingTypeRepository extends JpaRepository<MasterTrainingType, Long> {

	List< MasterTrainingType> findByIsDelete(Boolean isDelete);

}
