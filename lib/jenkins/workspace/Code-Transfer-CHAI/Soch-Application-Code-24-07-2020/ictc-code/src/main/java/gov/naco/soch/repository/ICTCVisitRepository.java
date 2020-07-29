package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCVisit;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ICTCVisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCVisitRepository extends JpaRepository<ICTCVisit, Long>, JpaSpecificationExecutor<ICTCVisit> {
}
