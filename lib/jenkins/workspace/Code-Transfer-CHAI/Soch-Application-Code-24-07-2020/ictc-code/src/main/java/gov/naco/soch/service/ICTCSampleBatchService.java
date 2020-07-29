package gov.naco.soch.service;

import gov.naco.soch.service.dto.CreateSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCSampleBatch}.
 */
public interface ICTCSampleBatchService {

    /**
     * Save a iCTCSampleBatch.
     *
     * @param iCTCSampleBatchDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCSampleBatchDTO save(ICTCSampleBatchDTO iCTCSampleBatchDTO);

    /**
     * Get all the iCTCSampleBatches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCSampleBatchDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCSampleBatch.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCSampleBatchDTO> findOne(Long id);

    /**
     * Delete the "id" iCTCSampleBatch.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * To create a new batch
     * 
     * @param batch batch
     * @return
     */
    ICTCSampleBatchDTO createBatch(CreateSampleBatchDTO batchDetails);
}
