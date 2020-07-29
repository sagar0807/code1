package gov.naco.soch.service;

import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.IctcLinkedFacility}.
 */
public interface IctcLinkedFacilityService {

    /**
     * Save a ictcLinkedFacility.
     *
     * @param ictcLinkedFacilityDTO the entity to save.
     * @return the persisted entity.
     */
    IctcLinkedFacilityDTO save(IctcLinkedFacilityDTO ictcLinkedFacilityDTO);

    /**
     * Get all the ictcLinkedFacilities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<IctcLinkedFacilityDTO> findAll(Pageable pageable);

    /**
     * Get the "id" ictcLinkedFacility.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IctcLinkedFacilityDTO> findOne(Long id);

    /**
     * Delete the "id" ictcLinkedFacility.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
