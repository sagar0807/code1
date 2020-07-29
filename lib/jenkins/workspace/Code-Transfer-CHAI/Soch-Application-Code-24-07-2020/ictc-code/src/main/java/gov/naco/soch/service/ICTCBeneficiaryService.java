package gov.naco.soch.service;

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCBeneficiary}.
 */
public interface ICTCBeneficiaryService {

    /**
     * Save a iCTCBeneficiary.
     *
     * @param iCTCBeneficiaryDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCBeneficiaryDTO save(ICTCBeneficiaryDTO iCTCBeneficiaryDTO);
    
    ICTCBeneficiary save(ICTCBeneficiary ictcBeneficiary);

    /**
     * Get all the iCTCBeneficiaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCBeneficiaryDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCBeneficiary.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCBeneficiaryDTO> findOne(Long id);
    
    Optional<ICTCBeneficiary> find(Long id);

    /**
     * Delete the "id" iCTCBeneficiary.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
