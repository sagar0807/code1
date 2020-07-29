package gov.naco.soch.service;

import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCFollowUp}.
 */
public interface ICTCFollowUpService {

    /**
     * Save a iCTCFollowUp.
     *
     * @param iCTCFollowUpDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCFollowUpDTO save(ICTCFollowUpDTO iCTCFollowUpDTO);

    /**
     * Get all the iCTCFollowUps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCFollowUpDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCFollowUp.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCFollowUpDTO> findOne(Long id);

    /**
     * Delete the "id" iCTCFollowUp.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    Optional<ICTCFollowUp> find(Long id);
    
    ICTCFollowUpDTO saveFollowUpForInfant(ICTCFollowUpDTO iCTCFollowUpDTO);
}
