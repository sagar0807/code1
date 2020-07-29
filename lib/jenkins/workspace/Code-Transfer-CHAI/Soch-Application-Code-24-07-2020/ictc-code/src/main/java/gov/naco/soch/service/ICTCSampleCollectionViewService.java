package gov.naco.soch.service;

import gov.naco.soch.service.dto.ICTCSampleCollectionViewDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ICTCSampleCollectionView.
 */
public interface ICTCSampleCollectionViewService {

    /**
     * Save a iCTCSampleCollectionView.
     *
     * @param iCTCSampleCollectionViewDTO the entity to save
     * @return the persisted entity
     */
    ICTCSampleCollectionViewDTO save(ICTCSampleCollectionViewDTO iCTCSampleCollectionViewDTO);

    /**
     * Get all the iCTCSampleCollectionViews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ICTCSampleCollectionViewDTO> findAll(Pageable pageable);


    /**
     * Get the "id" iCTCSampleCollectionView.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ICTCSampleCollectionViewDTO> findOne(Long id);

    /**
     * Delete the "id" iCTCSampleCollectionView.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
