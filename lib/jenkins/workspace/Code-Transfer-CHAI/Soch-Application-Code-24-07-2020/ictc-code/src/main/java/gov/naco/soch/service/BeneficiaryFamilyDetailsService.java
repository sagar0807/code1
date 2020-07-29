package gov.naco.soch.service;

import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.BeneficiaryFamilyDetails}.
 */
public interface BeneficiaryFamilyDetailsService {

    /**
     * Save a beneficiaryFamilyDetails.
     *
     * @param beneficiaryFamilyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    BeneficiaryFamilyDetailsDTO save(BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO);

    /**
     * Get all the beneficiaryFamilyDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BeneficiaryFamilyDetailsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" beneficiaryFamilyDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BeneficiaryFamilyDetailsDTO> findOne(Long id);
    
    Optional<BeneficiaryFamilyDetails> findById(Long id);

    /**
     * Delete the "id" beneficiaryFamilyDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
