package gov.naco.soch.service;

import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.ICTCBeneficiaryVisit}.
 */
public interface ICTCBeneficiaryVisitService {

    /**
     * Save a iCTCBeneficiaryVisit.
     *
     * @param iCTCBeneficiaryVisitDTO the entity to save.
     * @return the persisted entity.
     */
    ICTCBeneficiaryVisitDTO save(ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO);

    /**
     * Get all the iCTCBeneficiaryVisits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ICTCBeneficiaryVisitDTO> findAll(Pageable pageable);

    /**
     * Get the "id" iCTCBeneficiaryVisit.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ICTCBeneficiaryVisitDTO> findOne(Long id);

    /**
     * Delete the "id" iCTCBeneficiaryVisit.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
