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
import gov.naco.soch.domain.ICTCTestResultView;
import gov.naco.soch.domain.ICTCTestResultView_;
import gov.naco.soch.repository.ICTCTestResultViewRepository;
import gov.naco.soch.service.dto.ICTCTestResultViewCriteria;
import gov.naco.soch.service.dto.ICTCTestResultViewDTO;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for ICTCTestResultView entities in the database.
 * The main input is a {@link ICTCTestResultViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCTestResultViewDTO} or a {@link Page} of {@link ICTCTestResultViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCTestResultViewQueryService extends QueryService<ICTCTestResultView> {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultViewQueryService.class);

    private final ICTCTestResultViewRepository iCTCTestResultViewRepository;

    public ICTCTestResultViewQueryService(ICTCTestResultViewRepository iCTCTestResultViewRepository) {
        this.iCTCTestResultViewRepository = iCTCTestResultViewRepository;
    }

    /**
     * Return a {@link List} of {@link ICTCTestResultViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCTestResultView> findByCriteria(ICTCTestResultViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCTestResultView> specification = createSpecification(criteria);
        return iCTCTestResultViewRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link ICTCTestResultViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResultView> findByCriteria(ICTCTestResultViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResultView> specification = createSpecification(criteria);
        return iCTCTestResultViewRepository.findAll(specification, page);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCTestResultViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResultView> findByBasicCriteria(ICTCTestResultViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResultView> specification = createBasicSpecification(criteria);
        return iCTCTestResultViewRepository.findAll(specification, page);
    }

    /**
     * Function to convert ICTCTestResultViewCriteria to a {@link Specification}
     */
    private Specification<ICTCTestResultView> createSpecification(ICTCTestResultViewCriteria criteria) {
        Specification<ICTCTestResultView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), ICTCTestResultView_.id));
            }
            if (criteria.getUid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUid(), ICTCTestResultView_.uid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), ICTCTestResultView_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMiddleName(), ICTCTestResultView_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastName(), ICTCTestResultView_.lastName));
            }
            if (criteria.getAge() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAge(), ICTCTestResultView_.age));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGender(), ICTCTestResultView_.gender));
            }
            if (criteria.getInfantCode() != null) {
            	specification = specification.and(buildStringSpecification(criteria.getInfantCode(), ICTCTestResultView_.infantCode));
            }
//            if (criteria.getSampleCollectionDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getSampleCollectionDate(), ICTCTestResultView_.sampleCollectionDate));
//            }
            if (criteria.getResultStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getResultStatus(), ICTCTestResultView_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivStatus(), ICTCTestResultView_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivType(), ICTCTestResultView_.hivType));
            }
//            if (criteria.getTestedDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getTestedDate(), ICTCTestResultView_.testedDate));
//            }
            if (criteria.getSampleId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSampleId(), ICTCTestResultView_.sampleId));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getConsignmentId(), ICTCTestResultView_.consignmentId));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCTestResultView_.beneficiaryId));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIctcBeneficiaryId(), ICTCTestResultView_.ictcBeneficiaryId));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitId(), ICTCTestResultView_.visitId));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfBirth(), ICTCTestResultView_.dateOfBirth));
            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSampleCollectionStatus(), ICTCTestResultView_.sampleCollectionStatus));
            }
            if (criteria.getBatchStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBatchStatus(), ICTCTestResultView_.batchStatus));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBatchId(), ICTCTestResultView_.batchId));
            }
            if (criteria.getLabId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLabId(), ICTCTestResultView_.labId));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLabCode(), ICTCTestResultView_.labCode));
            }
            if (criteria.getLabName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLabName(), ICTCTestResultView_.labName));
            }
            if (criteria.getCategory() != null) {
            	specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCTestResultView_.category));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTestType(), ICTCTestResultView_.testType));
            }
            if (criteria.getFacilityId() != null) {
            	specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCTestResultView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCTestResultView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCTestResultView_.genderId));
            }
        }
        return specification;
    }
    
    /**
     * Function to convert ICTCTestResultViewCriteria to a {@link Specification}
     */
    private Specification<ICTCTestResultView> createBasicSpecification(ICTCTestResultViewCriteria criteria) {
        Specification<ICTCTestResultView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or(buildSpecification(criteria.getId(), ICTCTestResultView_.id));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCTestResultView_.uid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCTestResultView_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCTestResultView_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCTestResultView_.lastName));
            }
            if (criteria.getAge() != null) {
                specification = specification.or(buildStringSpecification(criteria.getAge(), ICTCTestResultView_.age));
            }
            if (criteria.getGender() != null) {
                specification = specification.or(buildStringSpecification(criteria.getGender(), ICTCTestResultView_.gender));
            }
            if (criteria.getInfantCode() != null) {
            	specification = specification.or(buildStringSpecification(criteria.getInfantCode(), ICTCTestResultView_.infantCode));
            }
//            if (criteria.getSampleCollectionDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getSampleCollectionDate(), ICTCTestResultView_.sampleCollectionDate));
//            }
            if (criteria.getResultStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getResultStatus(), ICTCTestResultView_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getHivStatus(), ICTCTestResultView_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getHivType(), ICTCTestResultView_.hivType));
            }
//            if (criteria.getTestedDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getTestedDate(), ICTCTestResultView_.testedDate));
//            }
            if (criteria.getSampleId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getSampleId(), ICTCTestResultView_.sampleId));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.or(buildStringSpecification(criteria.getConsignmentId(), ICTCTestResultView_.consignmentId));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCTestResultView_.beneficiaryId));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getIctcBeneficiaryId(), ICTCTestResultView_.ictcBeneficiaryId));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitId(), ICTCTestResultView_.visitId));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getDateOfBirth(), ICTCTestResultView_.dateOfBirth));
            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getSampleCollectionStatus(), ICTCTestResultView_.sampleCollectionStatus));
            }
            if (criteria.getBatchStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBatchStatus(), ICTCTestResultView_.batchStatus));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBatchId(), ICTCTestResultView_.batchId));
            }
            if (criteria.getLabId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getLabId(), ICTCTestResultView_.labId));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLabCode(), ICTCTestResultView_.labCode));
            }
            if (criteria.getLabName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLabName(), ICTCTestResultView_.labName));
            }
            if (criteria.getCategory() != null) {
            	specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCTestResultView_.category));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTestType(), ICTCTestResultView_.testType));
            }
            if (criteria.getFacilityId() != null) {
            	specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCTestResultView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCTestResultView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCTestResultView_.genderId));
            }
        }
        return specification;
    }

}
