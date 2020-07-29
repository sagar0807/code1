package gov.naco.soch.service;

import gov.naco.soch.service.dto.ArtBeneficiaryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ArtBeneficiary.
 */
public interface ArtBeneficiaryService {

    /**
     * Save a artBeneficiary.
     *
     * @param artBeneficiaryDTO the entity to save
     * @return the persisted entity
     */
    ArtBeneficiaryDTO save(ArtBeneficiaryDTO artBeneficiaryDTO);

    /**
     * Get all the artBeneficiaries.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ArtBeneficiaryDTO> findAll(Pageable pageable);


    /**
     * Get the "id" artBeneficiary.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ArtBeneficiaryDTO> findOne(Long id);

    /**
     * Delete the "id" artBeneficiary.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
