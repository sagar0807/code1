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
import gov.naco.soch.domain.State;
import gov.naco.soch.domain.State_;
import gov.naco.soch.repository.StateRepository;
import gov.naco.soch.service.dto.StateCriteria;
import gov.naco.soch.service.dto.StateDTO;
import gov.naco.soch.service.mapper.StateMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link State} entities in the database.
 * The main input is a {@link StateCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link StateDTO} or a {@link Page} of {@link StateDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StateQueryService extends QueryService<State> {

    private final Logger log = LoggerFactory.getLogger(StateQueryService.class);

    private final StateRepository stateRepository;

    private final StateMapper stateMapper;

    public StateQueryService(StateRepository stateRepository, StateMapper stateMapper) {
        this.stateRepository = stateRepository;
        this.stateMapper = stateMapper;
    }

    /**
     * Return a {@link List} of {@link StateDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<StateDTO> findByCriteria(StateCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<State> specification = createSpecification(criteria);
        return stateMapper.toDto(stateRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link StateDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StateDTO> findByCriteria(StateCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<State> specification = createSpecification(criteria);
        return stateRepository.findAll(specification, page)
            .map(stateMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StateCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<State> specification = createSpecification(criteria);
        return stateRepository.count(specification);
    }

    /**
     * Function to convert {@link StateCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<State> createSpecification(StateCriteria criteria) {
        Specification<State> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), State_.id));
            }
            if (criteria.getAlternateName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAlternateName(), State_.alternateName));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), State_.name));
            }
        }
        return specification;
    }
}
