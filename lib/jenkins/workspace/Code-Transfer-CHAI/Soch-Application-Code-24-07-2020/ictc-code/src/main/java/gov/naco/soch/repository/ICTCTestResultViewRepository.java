package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCTestResultView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ICTCTestResultView entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCTestResultViewRepository extends JpaRepository<ICTCTestResultView, Long>, JpaSpecificationExecutor<ICTCTestResultView> {

}
