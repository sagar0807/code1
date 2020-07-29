package gov.naco.soch.repository;

import gov.naco.soch.domain.ICTCSampleBatch;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ICTCSampleBatch entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCSampleBatchRepository extends JpaRepository<ICTCSampleBatch, Long>, JpaSpecificationExecutor<ICTCSampleBatch> {
	Long countByConsignmentId(String consignmentId);
}
