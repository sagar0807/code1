package gov.naco.soch.service;

import gov.naco.soch.service.dto.LabTestSampleDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.LabTestSample}.
 */
public interface LabTestSampleService {

    /**
     * Save a labTestSample.
     *
     * @param labTestSampleDTO the entity to save.
     * @return the persisted entity.
     */
    LabTestSampleDTO save(LabTestSampleDTO labTestSampleDTO);

    /**
     * Get all the labTestSamples.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LabTestSampleDTO> findAll(Pageable pageable);

    /**
     * Get the "id" labTestSample.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LabTestSampleDTO> findOne(Long id);

    /**
     * Delete the "id" labTestSample.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
