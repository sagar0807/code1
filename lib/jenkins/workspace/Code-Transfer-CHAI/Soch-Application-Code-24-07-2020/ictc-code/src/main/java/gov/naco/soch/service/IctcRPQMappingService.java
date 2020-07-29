package gov.naco.soch.service;

import gov.naco.soch.service.dto.IctcRPQMappingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.IctcRPQMapping}.
 */
public interface IctcRPQMappingService {

    /**
     * Save a ictcRPQMapping.
     *
     * @param ictcRPQMappingDTO the entity to save.
     * @return the persisted entity.
     */
    IctcRPQMappingDTO save(IctcRPQMappingDTO ictcRPQMappingDTO);

    /**
     * Get all the ictcRPQMappings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<IctcRPQMappingDTO> findAll(Pageable pageable);

    /**
     * Get the "id" ictcRPQMapping.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IctcRPQMappingDTO> findOne(Long id);

    /**
     * Delete the "id" ictcRPQMapping.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
