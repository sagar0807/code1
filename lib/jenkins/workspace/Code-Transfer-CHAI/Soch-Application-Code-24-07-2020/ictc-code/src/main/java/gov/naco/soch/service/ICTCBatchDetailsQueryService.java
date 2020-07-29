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
import gov.naco.soch.domain.ICTCBatchDetails;
import gov.naco.soch.domain.ICTCBatchDetails_;
import gov.naco.soch.repository.ICTCBatchDetailsRepository;
import gov.naco.soch.service.dto.ICTCBatchDetailsCriteria;
import gov.naco.soch.service.dto.ICTCBatchDetailsDTO;
import gov.naco.soch.service.mapper.ICTCBatchDetailsMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ICTCBatchDetails} entities in the database.
 * The main input is a {@link ICTCBatchDetailsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCBatchDetailsDTO} or a {@link Page} of {@link ICTCBatchDetailsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCBatchDetailsQueryService extends QueryService<ICTCBatchDetails> {

    private final Logger log = LoggerFactory.getLogger(ICTCBatchDetailsQueryService.class);

    private final ICTCBatchDetailsRepository iCTCBatchDetailsRepository;

    private final ICTCBatchDetailsMapper iCTCBatchDetailsMapper;

    public ICTCBatchDetailsQueryService(ICTCBatchDetailsRepository iCTCBatchDetailsRepository, ICTCBatchDetailsMapper iCTCBatchDetailsMapper) {
        this.iCTCBatchDetailsRepository = iCTCBatchDetailsRepository;
        this.iCTCBatchDetailsMapper = iCTCBatchDetailsMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCBatchDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBatchDetailsDTO> findByCriteria(ICTCBatchDetailsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBatchDetails> specification = createSpecification(criteria);
        return iCTCBatchDetailsMapper.toDto(iCTCBatchDetailsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCBatchDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBatchDetailsDTO> findByCriteria(ICTCBatchDetailsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBatchDetails> specification = createSpecificationBasic(criteria);
        return iCTCBatchDetailsRepository.findAll(specification, page)
            .map(iCTCBatchDetailsMapper::toDto);
    }
    
    @Transactional(readOnly = true)
    public Page<ICTCBatchDetailsDTO> findByCriteriaAdvanced(ICTCBatchDetailsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBatchDetails> specification = createSpecification(criteria);
        return iCTCBatchDetailsRepository.findAll(specification, page)
            .map(iCTCBatchDetailsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCBatchDetailsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCBatchDetails> specification = createSpecification(criteria);
        return iCTCBatchDetailsRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCBatchDetailsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    
    
    protected Specification<ICTCBatchDetails> createSpecificationBasic(ICTCBatchDetailsCriteria criteria) {
        Specification<ICTCBatchDetails> specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getEidLabName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getEidLabName(), ICTCBatchDetails_.eidLabName));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.or(buildStringSpecification(criteria.getConsignmentId(), ICTCBatchDetails_.consignmentId));
            }

            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCBatchDetails_.id));
            }
            
            if (criteria.getSampleCount() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSampleCount(), ICTCBatchDetails_.sampleCount));
            }
            if (criteria.getAcceptedSampleCount() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAcceptedSampleCount(), ICTCBatchDetails_.acceptedSampleCount));
            }
            if (criteria.getRejectedSampleCount() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRejectedSampleCount(), ICTCBatchDetails_.rejectedSampleCount));
            }
            if (criteria.getBatchStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBatchStatus(), ICTCBatchDetails_.batchStatus));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBatchDetails_.facilityId));
            }
        }
        return specification;
    }
    
    
    protected Specification<ICTCBatchDetails> createSpecification(ICTCBatchDetailsCriteria criteria) {
        Specification<ICTCBatchDetails> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCBatchDetails_.id));
            }
            if (criteria.getLabId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLabId(), ICTCBatchDetails_.labId));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getConsignmentId(), ICTCBatchDetails_.consignmentId));
            }
            if (criteria.getEidLabName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEidLabName(), ICTCBatchDetails_.eidLabName));
            }
            if (criteria.getSampleCount() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSampleCount(), ICTCBatchDetails_.sampleCount));
            }
            if (criteria.getAcceptedSampleCount() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAcceptedSampleCount(), ICTCBatchDetails_.acceptedSampleCount));
            }
            if (criteria.getRejectedSampleCount() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRejectedSampleCount(), ICTCBatchDetails_.rejectedSampleCount));
            }
            if (criteria.getBatchStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBatchStatus(), ICTCBatchDetails_.batchStatus));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBatchDetails_.facilityId));
            }
        }
        return specification;
    }
}
