package gov.naco.soch.service;

import gov.naco.soch.service.dto.RiskProfilingQuestionsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.RiskProfilingQuestions}.
 */
public interface RiskProfilingQuestionsService {

    /**
     * Save a riskProfilingQuestions.
     *
     * @param riskProfilingQuestionsDTO the entity to save.
     * @return the persisted entity.
     */
    RiskProfilingQuestionsDTO save(RiskProfilingQuestionsDTO riskProfilingQuestionsDTO);

    /**
     * Get all the riskProfilingQuestions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<RiskProfilingQuestionsDTO> findAll(Pageable pageable);

    /**
     * Get the "id" riskProfilingQuestions.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RiskProfilingQuestionsDTO> findOne(Long id);

    /**
     * Delete the "id" riskProfilingQuestions.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
