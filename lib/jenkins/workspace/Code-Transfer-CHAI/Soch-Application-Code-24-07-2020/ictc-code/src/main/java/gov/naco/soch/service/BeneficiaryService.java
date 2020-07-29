package gov.naco.soch.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.service.dto.BeneficiaryDTO;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.Beneficiary}.
 */
public interface BeneficiaryService {

    /**
     * Save a beneficiary.
     *
     * @param beneficiaryDTO the entity to save.
     * @return the persisted entity.
     */
    BeneficiaryDTO save(BeneficiaryDTO beneficiaryDTO);
    
    Beneficiary saveBeneficiary(Beneficiary beneficiary);

    /**
     * Get all the beneficiaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BeneficiaryDTO> findAll(Pageable pageable);

    /**
     * Get the "id" beneficiary.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BeneficiaryDTO> findOne(Long id);
    
    Optional<Beneficiary> find(Long id);
    
    BeneficiaryDTO getOne(Long id);
    

    /**
     * Delete the "id" beneficiary.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
