package gov.naco.soch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCSampleCollection}.
 */
public interface ICTCSampleCollectionService {

    /**
     * Save a iCTCSampleCollection.
     *
     * @param iCTCSampleCollectionDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCSampleCollectionDTO save(ICTCSampleCollectionDTO iCTCSampleCollectionDTO);

    /**
     * Get all the iCTCSampleCollections.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCSampleCollectionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCSampleCollection.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCSampleCollectionDTO> findOne(Long id);
    
    Optional<ICTCSampleCollection> find(Long id);
    
    ICTCSampleCollectionDTO getOne(Long id);

    /**
     * Delete the "id" iCTCSampleCollection.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * Save list of sample collections
     * 
     * @param samples list of sample
     * @return the saved entities
     */
    List<ICTCSampleCollectionDTO> saveListOfSamples(List<CreateSampleDTO> samples);
    
    void deactivate(Long id);
}
