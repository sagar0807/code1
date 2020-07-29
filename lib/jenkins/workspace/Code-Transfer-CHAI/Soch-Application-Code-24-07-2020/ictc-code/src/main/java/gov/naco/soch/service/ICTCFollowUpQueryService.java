package gov.naco.soch.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ICTCFollowUpRepository;
import gov.naco.soch.service.dto.ICTCFollowUpCriteria;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;
import gov.naco.soch.service.mapper.ICTCFollowUpMapper;

/**
 * Service for executing complex queries for {@link ICTCFollowUp} entities in the database.
 * The main input is a {@link ICTCFollowUpCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCFollowUpDTO} or a {@link Page} of {@link ICTCFollowUpDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCFollowUpQueryService extends QueryService<ICTCFollowUp> {

    private final Logger log = LoggerFactory.getLogger(ICTCFollowUpQueryService.class);

    private final ICTCFollowUpRepository iCTCFollowUpRepository;

    private final ICTCFollowUpMapper iCTCFollowUpMapper;

    public ICTCFollowUpQueryService(ICTCFollowUpRepository iCTCFollowUpRepository, ICTCFollowUpMapper iCTCFollowUpMapper) {
        this.iCTCFollowUpRepository = iCTCFollowUpRepository;
        this.iCTCFollowUpMapper = iCTCFollowUpMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCFollowUpDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCFollowUpDTO> findByCriteria(ICTCFollowUpCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCFollowUp> specification = createSpecification(criteria);
        return iCTCFollowUpMapper.toDto(iCTCFollowUpRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCFollowUpDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCFollowUpDTO> findByCriteria(ICTCFollowUpCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCFollowUp> specification = createSpecification(criteria);
        return iCTCFollowUpRepository.findAll(specification, page)
            .map(iCTCFollowUpMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCFollowUpCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCFollowUp> specification = createSpecification(criteria);
        return iCTCFollowUpRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCFollowUpCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCFollowUp> createSpecification(ICTCFollowUpCriteria criteria) {
        Specification<ICTCFollowUp> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCFollowUp_.id));
            }
            if (criteria.getFollowUpType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFollowUpType(), ICTCFollowUp_.followUpType));
            }
            if (criteria.getFollowUpDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFollowUpDate(), ICTCFollowUp_.followUpDate));
            }
//            if (criteria.getRemarks() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getRemarks(), ICTCFollowUp_.remarks));
//            }
            if (criteria.getIsCompleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsCompleted(), ICTCFollowUp_.isCompleted));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ICTCFollowUp_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), ICTCFollowUp_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), ICTCFollowUp_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), ICTCFollowUp_.modifiedTime));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCFollowUp_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCFollowUp_.isDeleted));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildSpecification(criteria.getVisitId(),
                    root -> root.join(ICTCFollowUp_.visit, JoinType.LEFT).get(ICTCVisit_.id)));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityId(),
                    root -> root.join(ICTCFollowUp_.facility, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getIctcBeneficiaryId(),
                    root -> root.join(ICTCFollowUp_.ictcBeneficiary, JoinType.LEFT).get(ICTCBeneficiary_.id)));
            }
            if (criteria.getTestResultId() != null) {
                specification = specification.and(buildSpecification(criteria.getTestResultId(),
                    root -> root.join(ICTCFollowUp_.testResult, JoinType.LEFT).get(ICTCTestResult_.id)));
            }
        }
        return specification;
    }
}
