package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.LabTestSampleBatch;

/**
 * Spring Data  repository for the LabTestSampleBatch entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LabTestSampleBatchRepository extends JpaRepository<LabTestSampleBatch, Long>, JpaSpecificationExecutor<LabTestSampleBatch> {
	List<LabTestSampleBatch> findByBdnSerialNumberOrderByIdDesc(String consignmentId);
}
