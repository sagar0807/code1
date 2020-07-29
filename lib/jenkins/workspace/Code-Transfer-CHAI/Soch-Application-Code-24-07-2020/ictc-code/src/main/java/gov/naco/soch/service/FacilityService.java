package gov.naco.soch.service;

import gov.naco.soch.service.dto.FacilityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.Facility}.
 */
public interface FacilityService {

    /**
     * Save a facility.
     *
     * @param facilityDTO the entity to save.
     * @return the persisted entity.
     */
    FacilityDTO save(FacilityDTO facilityDTO);

    /**
     * Get all the facilities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FacilityDTO> findAll(Pageable pageable);

    /**
     * Get the "id" facility.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FacilityDTO> findOne(Long id);

    /**
     * Delete the "id" facility.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    
    /**
     * Get facility name from facility id
     * 
     * @param id the id of the entity
     * @return
     */
    String getFacilityFromFacilityId(Long id);
}
