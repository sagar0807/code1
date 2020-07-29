package gov.naco.soch.service;

import gov.naco.soch.domain.ICTCTestResultView;
import gov.naco.soch.service.dto.ICTCTestResultViewDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ICTCTestResultView.
 */
public interface ICTCTestResultViewService {

    /**
     * Save a iCTCTestResultView.
     *
     * @param iCTCTestResultViewDTO the entity to save
     * @return the persisted entity
     */
    ICTCTestResultViewDTO save(ICTCTestResultViewDTO iCTCTestResultViewDTO);

    /**
     * Get all the iCTCTestResultViews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ICTCTestResultViewDTO> findAll(Pageable pageable);


    /**
     * Get the "id" iCTCTestResultView.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ICTCTestResultView> findOne(Long id);

    /**
     * Delete the "id" iCTCTestResultView.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
