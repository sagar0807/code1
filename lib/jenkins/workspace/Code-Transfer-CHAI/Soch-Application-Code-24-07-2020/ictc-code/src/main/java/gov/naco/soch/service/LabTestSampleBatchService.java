package gov.naco.soch.service;

import gov.naco.soch.service.dto.LabTestSampleBatchDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.LabTestSampleBatch}.
 */
public interface LabTestSampleBatchService {

    /**
     * Save a labTestSampleBatch.
     *
     * @param labTestSampleBatchDTO the entity to save.
     * @return the persisted entity.
     */
    LabTestSampleBatchDTO save(LabTestSampleBatchDTO labTestSampleBatchDTO);

    /**
     * Get all the labTestSampleBatches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LabTestSampleBatchDTO> findAll(Pageable pageable);

    /**
     * Get the "id" labTestSampleBatch.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LabTestSampleBatchDTO> findOne(Long id);

    /**
     * Delete the "id" labTestSampleBatch.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
