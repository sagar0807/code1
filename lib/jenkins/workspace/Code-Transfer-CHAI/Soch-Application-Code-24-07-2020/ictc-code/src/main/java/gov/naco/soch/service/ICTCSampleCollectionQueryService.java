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

import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ICTCSampleCollectionRepository;
import gov.naco.soch.service.dto.ICTCSampleCollectionCriteria;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;

/**
 * Service for executing complex queries for {@link ICTCSampleCollection} entities in the database.
 * The main input is a {@link ICTCSampleCollectionCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCSampleCollectionDTO} or a {@link Page} of {@link ICTCSampleCollectionDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCSampleCollectionQueryService extends QueryService<ICTCSampleCollection> {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionQueryService.class);

    private final ICTCSampleCollectionRepository iCTCSampleCollectionRepository;

    private final ICTCSampleCollectionMapper iCTCSampleCollectionMapper;

    public ICTCSampleCollectionQueryService(ICTCSampleCollectionRepository iCTCSampleCollectionRepository, ICTCSampleCollectionMapper iCTCSampleCollectionMapper) {
        this.iCTCSampleCollectionRepository = iCTCSampleCollectionRepository;
        this.iCTCSampleCollectionMapper = iCTCSampleCollectionMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCSampleCollectionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCSampleCollectionDTO> findByCriteria(ICTCSampleCollectionCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCSampleCollection> specification = createSpecification(criteria);
        return iCTCSampleCollectionMapper.toDto(iCTCSampleCollectionRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCSampleCollectionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCSampleCollectionDTO> findByCriteria(ICTCSampleCollectionCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCSampleCollection> specification = createSpecification(criteria);
        return iCTCSampleCollectionRepository.findAll(specification, page)
            .map(iCTCSampleCollectionMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCSampleCollectionCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCSampleCollection> specification = createSpecification(criteria);
        return iCTCSampleCollectionRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCSampleCollectionCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCSampleCollection> createSpecification(ICTCSampleCollectionCriteria criteria) {
        Specification<ICTCSampleCollection> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCSampleCollection_.id));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBarcode(), ICTCSampleCollection_.barcode));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTestType(), ICTCSampleCollection_.testType));
            }
//            if (criteria.getSampleCollectionDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getSampleCollectionDate(), ICTCSampleCollection_.sampleCollectionDate));
//            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSampleCollectionStatus(), ICTCSampleCollection_.sampleCollectionStatus));
            }
            if (criteria.getIsDispatched() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDispatched(), ICTCSampleCollection_.isDispatched));
            }
//            if (criteria.getDispatchedToLabId() != null) {
//                specification = specification.and(buildSpecification(criteria.getDispatchedToLabId(), ICTCSampleCollection_.dispatchedToLabId));
//            }
//            if (criteria.getDispatchDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getDispatchDate(), ICTCSampleCollection_.dispatchDate));
//            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCSampleCollection_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCSampleCollection_.isDeleted));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ICTCSampleCollection_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), ICTCSampleCollection_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), ICTCSampleCollection_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), ICTCSampleCollection_.modifiedTime));
            }
           
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getIctcBeneficiaryId(),
                    root -> root.join(ICTCSampleCollection_.ictcBeneficiary, JoinType.LEFT).get(ICTCBeneficiary_.id)));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildSpecification(criteria.getVisitId(),
                    root -> root.join(ICTCSampleCollection_.visit, JoinType.LEFT).get(ICTCVisit_.id)));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and(buildSpecification(criteria.getBatchId(),
                    root -> root.join(ICTCSampleCollection_.batch, JoinType.LEFT).get(ICTCSampleBatch_.id)));
            }
            
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityId(),
                    root -> root.join(ICTCSampleCollection_.facility, JoinType.LEFT).get(Facility_.id)));
            }
        }
        return specification;
    }
}
