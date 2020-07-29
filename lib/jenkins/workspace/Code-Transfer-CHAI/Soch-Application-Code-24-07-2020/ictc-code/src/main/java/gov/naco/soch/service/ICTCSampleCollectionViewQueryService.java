package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ICTCSampleCollectionViewRepository;
import gov.naco.soch.service.dto.ICTCSampleCollectionViewCriteria;

import gov.naco.soch.service.dto.ICTCSampleCollectionViewDTO;
import gov.naco.soch.service.mapper.ICTCSampleCollectionViewMapper;

/**
 * Service for executing complex queries for ICTCSampleCollectionView entities in the database.
 * The main input is a {@link ICTCSampleCollectionViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCSampleCollectionViewDTO} or a {@link Page} of {@link ICTCSampleCollectionViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCSampleCollectionViewQueryService extends QueryService<ICTCSampleCollectionView> {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionViewQueryService.class);

    private final ICTCSampleCollectionViewRepository iCTCSampleCollectionViewRepository;

    private final ICTCSampleCollectionViewMapper iCTCSampleCollectionViewMapper;

    public ICTCSampleCollectionViewQueryService(ICTCSampleCollectionViewRepository iCTCSampleCollectionViewRepository, ICTCSampleCollectionViewMapper iCTCSampleCollectionViewMapper) {
        this.iCTCSampleCollectionViewRepository = iCTCSampleCollectionViewRepository;
        this.iCTCSampleCollectionViewMapper = iCTCSampleCollectionViewMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCSampleCollectionViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCSampleCollectionViewDTO> findByCriteria(ICTCSampleCollectionViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCSampleCollectionView> specification = createSpecification(criteria);
        return iCTCSampleCollectionViewMapper.toDto(iCTCSampleCollectionViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCSampleCollectionViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCSampleCollectionViewDTO> findByCriteria(ICTCSampleCollectionViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCSampleCollectionView> specification = createSpecification(criteria);
        return iCTCSampleCollectionViewRepository.findAll(specification, page)
            .map(iCTCSampleCollectionViewMapper::toDto);
    }

    /**
     * Function to convert ICTCSampleCollectionViewCriteria to a {@link Specification}
     */
    private Specification<ICTCSampleCollectionView> createSpecification(ICTCSampleCollectionViewCriteria criteria) {
        Specification<ICTCSampleCollectionView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or(buildSpecification(criteria.getId(), ICTCSampleCollectionView_.id));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantCode(), ICTCSampleCollectionView_.infantCode));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCSampleCollectionView_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCSampleCollectionView_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCSampleCollectionView_.lastName));
            }
            if (criteria.getAge() != null) {
                specification = specification.or(buildStringSpecification(criteria.getAge(), ICTCSampleCollectionView_.age));
            }
            if (criteria.getGender() != null) {
                specification = specification.or(buildStringSpecification(criteria.getGender(), ICTCSampleCollectionView_.gender));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitDate(), ICTCSampleCollectionView_.visitDate));
            }
            if (criteria.getTestType() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getTestType(), ICTCSampleCollectionView_.testType));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getIctcBeneficiaryId(), ICTCSampleCollectionView_.ictcBeneficiaryId));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitId(), ICTCSampleCollectionView_.visitId));
            }
            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCSampleCollectionView_.pid));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCSampleCollectionView_.uid));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getBarcode(), ICTCSampleCollectionView_.barcode));
            }
//            if (criteria.getSampleCollectionDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getSampleCollectionDate(), ICTCSampleCollectionView_.sampleCollectionDate));
//            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSampleCollectionStatus(), ICTCSampleCollectionView_.sampleCollectionStatus));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCSampleCollectionView_.category));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBatchId(), ICTCSampleCollectionView_.batchId));
            }
            if (criteria.getFacilityId() != null) {
            	specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCSampleCollectionView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCSampleCollectionView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCSampleCollectionView_.genderId));
            }
        }
        return specification;
    }

}
