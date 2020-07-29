package gov.naco.soch.service;

import gov.naco.soch.service.dto.ICTCBatchDetailsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCBatchDetails}.
 */
public interface ICTCBatchDetailsService {

    /**
     * Save a iCTCBatchDetails.
     *
     * @param iCTCBatchDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCBatchDetailsDTO save(ICTCBatchDetailsDTO iCTCBatchDetailsDTO);

    /**
     * Get all the iCTCBatchDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCBatchDetailsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCBatchDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCBatchDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" iCTCBatchDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    ICTCBatchDetailsDTO getBatchDetails(Long id);
}
