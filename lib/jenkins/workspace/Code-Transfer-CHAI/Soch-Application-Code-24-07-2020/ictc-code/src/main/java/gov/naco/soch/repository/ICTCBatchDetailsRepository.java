package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCBatchDetails;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ICTCBatchDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCBatchDetailsRepository extends JpaRepository<ICTCBatchDetails, Long>, JpaSpecificationExecutor<ICTCBatchDetails> {
}
