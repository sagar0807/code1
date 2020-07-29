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
import gov.naco.soch.domain.IctcRPQMapping;
import gov.naco.soch.domain.IctcRPQMapping_;
import gov.naco.soch.repository.IctcRPQMappingRepository;
import gov.naco.soch.service.dto.IctcRPQMappingCriteria;
import gov.naco.soch.service.dto.IctcRPQMappingDTO;
import gov.naco.soch.service.mapper.IctcRPQMappingMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link IctcRPQMapping} entities in the database.
 * The main input is a {@link IctcRPQMappingCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link IctcRPQMappingDTO} or a {@link Page} of {@link IctcRPQMappingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class IctcRPQMappingQueryService extends QueryService<IctcRPQMapping> {

    private final Logger log = LoggerFactory.getLogger(IctcRPQMappingQueryService.class);

    private final IctcRPQMappingRepository ictcRPQMappingRepository;

    private final IctcRPQMappingMapper ictcRPQMappingMapper;

    public IctcRPQMappingQueryService(IctcRPQMappingRepository ictcRPQMappingRepository, IctcRPQMappingMapper ictcRPQMappingMapper) {
        this.ictcRPQMappingRepository = ictcRPQMappingRepository;
        this.ictcRPQMappingMapper = ictcRPQMappingMapper;
    }

    /**
     * Return a {@link List} of {@link IctcRPQMappingDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<IctcRPQMappingDTO> findByCriteria(IctcRPQMappingCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<IctcRPQMapping> specification = createSpecification(criteria);
        return ictcRPQMappingMapper.toDto(ictcRPQMappingRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link IctcRPQMappingDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<IctcRPQMappingDTO> findByCriteria(IctcRPQMappingCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<IctcRPQMapping> specification = createSpecification(criteria);
        return ictcRPQMappingRepository.findAll(specification, page)
            .map(ictcRPQMappingMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(IctcRPQMappingCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<IctcRPQMapping> specification = createSpecification(criteria);
        return ictcRPQMappingRepository.count(specification);
    }

    /**
     * Function to convert {@link IctcRPQMappingCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<IctcRPQMapping> createSpecification(IctcRPQMappingCriteria criteria) {
        Specification<IctcRPQMapping> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), IctcRPQMapping_.id));
            }
            if (criteria.getPid() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPid(), IctcRPQMapping_.pid));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitId(), IctcRPQMapping_.visitId));
            }
            if (criteria.getRpqId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRpqId(), IctcRPQMapping_.rpqId));
            }
            if (criteria.getAnswer() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAnswer(), IctcRPQMapping_.answer));
            }
        }
        return specification;
    }
}
