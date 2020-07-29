package gov.naco.soch.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gov.naco.soch.service.dto.ReferralsDTO;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.Referrals}.
 */
public interface ReferralsService {

    /**
     * Save a referrals.
     *
     * @param referralsDTO the entity to save.
     * @return the persisted entity.
     */
    ReferralsDTO save(ReferralsDTO referralsDTO);

    /**
     * Get all the referrals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReferralsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" referrals.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReferralsDTO> findOne(Long id);

    /**
     * Delete the "id" referrals.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
