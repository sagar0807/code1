package gov.naco.soch.service;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.BeneficiaryReferral}.
 */
public interface BeneficiaryReferralService {

    /**
     * Save a beneficiaryReferral.
     *
     * @param beneficiaryReferralDTO the entity to save.
     * @return the persisted entity.
     */
    BeneficiaryReferralDTO save(BeneficiaryReferralDTO beneficiaryReferralDTO);

    /**
     * Get all the beneficiaryReferrals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BeneficiaryReferralDTO> findAll(Pageable pageable);

    /**
     * Get the "id" beneficiaryReferral.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BeneficiaryReferralDTO> findOne(Long id);
    
    Optional<BeneficiaryReferral> find(Long id);

    /**
     * Delete the "id" beneficiaryReferral.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    /**
     * decline the "id" beneficiaryReferral.
     *
     * @param id the id of the entity.
     */
    void declineBeneficiaryReferral(Long id);
    
    BeneficiaryReferralDTO saveReferral(BeneficiaryReferralDTO beneficiaryReferralDTO);
    
    List<BeneficiaryReferralDTO> getActiveReferralsForABeneficiary(Long beneficiaryId);
}
