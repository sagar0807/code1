package gov.naco.soch.service;

import gov.naco.soch.service.dto.TransfersDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.Transfers}.
 */
public interface TransfersService {

    /**
     * Save a transfers.
     *
     * @param transfersDTO the entity to save.
     * @return the persisted entity.
     */
    TransfersDTO save(TransfersDTO transfersDTO);

    /**
     * Get all the transfers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TransfersDTO> findAll(Pageable pageable);

    /**
     * Get the "id" transfers.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TransfersDTO> findOne(Long id);

    /**
     * Delete the "id" transfers.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
