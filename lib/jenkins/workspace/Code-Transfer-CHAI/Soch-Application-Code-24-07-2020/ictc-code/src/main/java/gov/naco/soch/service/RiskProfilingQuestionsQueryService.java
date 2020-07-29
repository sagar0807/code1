package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// for static metamodels
import gov.naco.soch.domain.RiskProfilingQuestions;
import gov.naco.soch.domain.RiskProfilingQuestions_;
import gov.naco.soch.repository.RiskProfilingQuestionsRepository;
import gov.naco.soch.service.dto.RiskProfilingQuestionsCriteria;
import gov.naco.soch.service.dto.RiskProfilingQuestionsDTO;
import gov.naco.soch.service.mapper.RiskProfilingQuestionsMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link RiskProfilingQuestions} entities in the database.
 * The main input is a {@link RiskProfilingQuestionsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link RiskProfilingQuestionsDTO} or a {@link Page} of {@link RiskProfilingQuestionsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class RiskProfilingQuestionsQueryService extends QueryService<RiskProfilingQuestions> {

    private final Logger log = LoggerFactory.getLogger(RiskProfilingQuestionsQueryService.class);

    private final RiskProfilingQuestionsRepository riskProfilingQuestionsRepository;

    private final RiskProfilingQuestionsMapper riskProfilingQuestionsMapper;

    public RiskProfilingQuestionsQueryService(RiskProfilingQuestionsRepository riskProfilingQuestionsRepository, RiskProfilingQuestionsMapper riskProfilingQuestionsMapper) {
        this.riskProfilingQuestionsRepository = riskProfilingQuestionsRepository;
        this.riskProfilingQuestionsMapper = riskProfilingQuestionsMapper;
    }

    /**
     * Return a {@link List} of {@link RiskProfilingQuestionsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<RiskProfilingQuestionsDTO> findByCriteria(RiskProfilingQuestionsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<RiskProfilingQuestions> specification = createSpecification(criteria);
        return riskProfilingQuestionsMapper.toDto(riskProfilingQuestionsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link RiskProfilingQuestionsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<RiskProfilingQuestionsDTO> findByCriteria(RiskProfilingQuestionsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<RiskProfilingQuestions> specification = createSpecification(criteria);
        return riskProfilingQuestionsRepository.findAll(specification, page)
            .map(riskProfilingQuestionsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(RiskProfilingQuestionsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<RiskProfilingQuestions> specification = createSpecification(criteria);
        return riskProfilingQuestionsRepository.count(specification);
    }

    /**
     * Function to convert {@link RiskProfilingQuestionsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<RiskProfilingQuestions> createSpecification(RiskProfilingQuestionsCriteria criteria) {
        Specification<RiskProfilingQuestions> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), RiskProfilingQuestions_.id));
            }
            if (criteria.getQuestion() != null) {
                specification = specification.and(buildStringSpecification(criteria.getQuestion(), RiskProfilingQuestions_.question));
            }
            if (criteria.getAnswers() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAnswers(), RiskProfilingQuestions_.answers));
            }
        }
        return specification;
    }
}
