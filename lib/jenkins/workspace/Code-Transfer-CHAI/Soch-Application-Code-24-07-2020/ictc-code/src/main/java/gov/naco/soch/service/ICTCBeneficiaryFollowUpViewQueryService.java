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
import gov.naco.soch.repository.ICTCBeneficiaryFollowUpViewRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewCriteria;

import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryFollowUpViewMapper;

/**
 * Service for executing complex queries for ICTCBeneficiaryFollowUpView entities in the database.
 * The main input is a {@link ICTCBeneficiaryFollowUpViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCBeneficiaryFollowUpViewDTO} or a {@link Page} of {@link ICTCBeneficiaryFollowUpViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCBeneficiaryFollowUpViewQueryService extends QueryService<ICTCBeneficiaryFollowUpView> {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryFollowUpViewQueryService.class);

    private final ICTCBeneficiaryFollowUpViewRepository iCTCBeneficiaryFollowUpViewRepository;

    private final ICTCBeneficiaryFollowUpViewMapper iCTCBeneficiaryFollowUpViewMapper;

    public ICTCBeneficiaryFollowUpViewQueryService(ICTCBeneficiaryFollowUpViewRepository iCTCBeneficiaryFollowUpViewRepository, ICTCBeneficiaryFollowUpViewMapper iCTCBeneficiaryFollowUpViewMapper) {
        this.iCTCBeneficiaryFollowUpViewRepository = iCTCBeneficiaryFollowUpViewRepository;
        this.iCTCBeneficiaryFollowUpViewMapper = iCTCBeneficiaryFollowUpViewMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCBeneficiaryFollowUpViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBeneficiaryFollowUpViewDTO> findByCriteria(ICTCBeneficiaryFollowUpViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiaryFollowUpView> specification = createSpecification(criteria);
        return iCTCBeneficiaryFollowUpViewMapper.toDto(iCTCBeneficiaryFollowUpViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCBeneficiaryFollowUpViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryFollowUpViewDTO> findByCriteria(ICTCBeneficiaryFollowUpViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryFollowUpView> specification = createSpecification(criteria);
        return iCTCBeneficiaryFollowUpViewRepository.findAll(specification, page)
            .map(iCTCBeneficiaryFollowUpViewMapper::toDto);
    }
    
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryFollowUpViewDTO> findByCriteriaBasic(ICTCBeneficiaryFollowUpViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryFollowUpView> specification = createSpecificationBasic(criteria);
        return iCTCBeneficiaryFollowUpViewRepository.findAll(specification, page)
            .map(iCTCBeneficiaryFollowUpViewMapper::toDto);
    }

    /**
     * Function to convert ICTCBeneficiaryFollowUpViewCriteria to a {@link Specification}
     */
    private Specification<ICTCBeneficiaryFollowUpView> createSpecification(ICTCBeneficiaryFollowUpViewCriteria criteria) {
        Specification<ICTCBeneficiaryFollowUpView> specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryFollowUpView_.pid));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryFollowUpView_.uid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryFollowUpView_.firstName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryFollowUpView_.lastName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryFollowUpView_.middleName));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryFollowUpView_.mobileNumber));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), ICTCBeneficiaryFollowUpView_.id));
            }
            if (criteria.getAge() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAge(), ICTCBeneficiaryFollowUpView_.age));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGender(), ICTCBeneficiaryFollowUpView_.gender));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCBeneficiaryFollowUpView_.category));
            }
            if (criteria.getFollowUpDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFollowUpDate(), ICTCBeneficiaryFollowUpView_.followUpDate));
            }
            if (criteria.getFollowUpType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFollowUpType(), ICTCBeneficiaryFollowUpView_.followUpType));
            }
            if (criteria.getExpectedDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExpectedDeliveryDate(), ICTCBeneficiaryFollowUpView_.expectedDeliveryDate));
            }
            if (criteria.getPregnancyLmpDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPregnancyLmpDate(), ICTCBeneficiaryFollowUpView_.pregnancyLmpDate));
            }
            if (criteria.getDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDeliveryDate(), ICTCBeneficiaryFollowUpView_.deliveryDate));
            }
//            if (criteria.getRemarks() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getRemarks(), ICTCBeneficiaryFollowUpView_.remarks));
//            }
            if (criteria.getIsCompleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsCompleted(), ICTCBeneficiaryFollowUpView_.isCompleted));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryFollowUpView_.beneficiaryStatus));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCBeneficiaryFollowUpView_.beneficiaryId));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitId(), ICTCBeneficiaryFollowUpView_.visitId));
            }
            if (criteria.getTestResultId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTestResultId(), ICTCBeneficiaryFollowUpView_.testResultId));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIctcBeneficiaryId(), ICTCBeneficiaryFollowUpView_.ictcBeneficiaryId));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryFollowUpView_.facilityId));
            }
            if (criteria.getVisitDate() != null) {
            	specification = specification.and(buildRangeSpecification(criteria.getVisitDate(), ICTCBeneficiaryFollowUpView_.visitDate));
            }
            if (criteria.getDateOfBirth() != null) {
            	specification = specification.and(buildRangeSpecification(criteria.getDateOfBirth(), ICTCBeneficiaryFollowUpView_.dateOfBirth));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryFollowUpView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryFollowUpView_.genderId));
            }
        }
        return specification;
    }
    
    private Specification<ICTCBeneficiaryFollowUpView> createSpecificationBasic(ICTCBeneficiaryFollowUpViewCriteria criteria) {
        Specification<ICTCBeneficiaryFollowUpView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryFollowUpView_.pid));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryFollowUpView_.uid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryFollowUpView_.firstName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryFollowUpView_.lastName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryFollowUpView_.middleName));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryFollowUpView_.mobileNumber));
            }
        
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCBeneficiaryFollowUpView_.category));
            }

            if (criteria.getFollowUpType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFollowUpType(), ICTCBeneficiaryFollowUpView_.followUpType));
            }
            
            if (criteria.getIsCompleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsCompleted(), ICTCBeneficiaryFollowUpView_.isCompleted));
            }
           
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryFollowUpView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryFollowUpView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryFollowUpView_.genderId));
            }
            if (criteria.getExpectedDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExpectedDeliveryDate(), ICTCBeneficiaryFollowUpView_.expectedDeliveryDate));
            }
        }
        return specification;
    }


}
