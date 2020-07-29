package gov.naco.soch.service;

import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.service.dto.ICTCVisitDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCVisit}.
 */
public interface ICTCVisitService {

    /**
     * Save a iCTCVisit.
     *
     * @param iCTCVisitDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCVisitDTO save(ICTCVisitDTO iCTCVisitDTO);
    
    ICTCVisit save(ICTCVisit ictcVisit);
    
    /**
     * Get all the iCTCVisits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCVisitDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCVisit.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCVisitDTO> findOne(Long id);
    
    Optional<ICTCVisit> find(Long id);
    
    ICTCVisitDTO getOne(Long id);

    /**
     * Delete the "id" iCTCVisit.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
