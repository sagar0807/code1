package gov.naco.soch.service;

import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ICTCBeneficiaryFollowUpView.
 */
public interface ICTCBeneficiaryFollowUpViewService {

    /**
     * Save a iCTCBeneficiaryFollowUpView.
     *
     * @param iCTCBeneficiaryFollowUpViewDTO the entity to save
     * @return the persisted entity
     */
    ICTCBeneficiaryFollowUpViewDTO save(ICTCBeneficiaryFollowUpViewDTO iCTCBeneficiaryFollowUpViewDTO);

    /**
     * Get all the iCTCBeneficiaryFollowUpViews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ICTCBeneficiaryFollowUpViewDTO> findAll(Pageable pageable);


    /**
     * Get the "id" iCTCBeneficiaryFollowUpView.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ICTCBeneficiaryFollowUpViewDTO> findOne(Long id);

    /**
     * Delete the "id" iCTCBeneficiaryFollowUpView.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    void disable(Long id);
}
