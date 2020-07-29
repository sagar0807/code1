package gov.naco.soch.service;

import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.service.dto.ICTCTestDetails;
import gov.naco.soch.service.dto.ICTCTestResultDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ICTCTestResult.
 */
public interface ICTCTestResultService {

    /**
     * Save a iCTCTestResult.
     *
     * @param iCTCTestResultDTO the entity to save
     * @return the persisted entity
     */
    ICTCTestResultDTO save(ICTCTestResultDTO iCTCTestResultDTO);

    /**
     * Get all the iCTCTestResults.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ICTCTestResultDTO> findAll(Pageable pageable);


    /**
     * Get the "id" iCTCTestResult.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ICTCTestResultDTO> findOne(Long id);
    
    Optional<ICTCTestResult> find(Long id);

    /**
     * Delete the "id" iCTCTestResult.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    
    ICTCTestResultDTO getOne(Long id);
    
    ICTCTestDetails getTestDetails(Long id);
}
