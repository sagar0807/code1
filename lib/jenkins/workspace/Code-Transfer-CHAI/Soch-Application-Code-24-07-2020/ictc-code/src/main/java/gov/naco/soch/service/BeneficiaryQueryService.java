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

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.service.dto.BeneficiaryCriteria;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.mapper.BeneficiaryMapper;

/**
 * Service for executing complex queries for {@link Beneficiary} entities in the database.
 * The main input is a {@link BeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BeneficiaryDTO} or a {@link Page} of {@link BeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BeneficiaryQueryService extends QueryService<Beneficiary> {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryQueryService.class);

    private final BeneficiaryRepository beneficiaryRepository;

    private final BeneficiaryMapper beneficiaryMapper;

    public BeneficiaryQueryService(BeneficiaryRepository beneficiaryRepository, BeneficiaryMapper beneficiaryMapper) {
        this.beneficiaryRepository = beneficiaryRepository;
        this.beneficiaryMapper = beneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link BeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BeneficiaryDTO> findByCriteria(BeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryMapper.toDto(beneficiaryRepository.findAll(specification));
    }
    
    @Transactional(readOnly = true)
    public List<BeneficiaryDTO> findByCriteriaBasic(BeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecificationBasic(criteria);
        return beneficiaryMapper.toDto(beneficiaryRepository.findAll(specification));
    }
    
    
    /**
     * Return a {@link List} of {@link BeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Beneficiary> findList(BeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link BeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BeneficiaryDTO> findByCriteria(BeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryRepository.findAll(specification, page)
            .map(beneficiaryMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BeneficiaryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryRepository.count(specification);
    }

    /**
     * Function to convert {@link BeneficiaryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Beneficiary> createSpecification(BeneficiaryCriteria criteria) {
        Specification<Beneficiary> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Beneficiary_.id));
            }
            if (criteria.getUid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUid(), Beneficiary_.uid));
            }
            if (criteria.getAadharNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAadharNumber(), Beneficiary_.aadharNumber));
            }
            if (criteria.getAge() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAge(), Beneficiary_.age));
            }

            if (criteria.getBeneficiaryType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBeneficiaryType(), Beneficiary_.beneficiaryType));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), Beneficiary_.category));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfBirth(), Beneficiary_.dateOfBirth));
            }
            if (criteria.getEducationLevel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEducationLevel(), Beneficiary_.educationLevel));
            }
            if (criteria.getEmploymentStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmploymentStatus(), Beneficiary_.employmentStatus));
            }

            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), Beneficiary_.firstName));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGender(), Beneficiary_.gender));
            }
   
            if (criteria.getLastName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastName(), Beneficiary_.lastName));
            }
            if (criteria.getMaritalStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaritalStatus(), Beneficiary_.maritalStatus));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMiddleName(), Beneficiary_.middleName));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobileNumber(), Beneficiary_.mobileNumber));
            }
            if (criteria.getOccupation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOccupation(), Beneficiary_.occupation));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), Beneficiary_.status));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), Beneficiary_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), Beneficiary_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), Beneficiary_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), Beneficiary_.modifiedTime));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), Beneficiary_.isActive));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), Beneficiary_.isDelete));
            }
            if (criteria.getAddressId() != null) {
                specification = specification.and(buildSpecification(criteria.getAddressId(),
                    root -> root.join(Beneficiary_.address, JoinType.LEFT).get(Address_.id)));
            }
        }
        return specification;
    }
    
    protected Specification<Beneficiary> createSpecificationBasic(BeneficiaryCriteria criteria) {
        Specification<Beneficiary> specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), Beneficiary_.uid));
            }
      
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), Beneficiary_.firstName));
            }  
   
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), Beneficiary_.lastName));
            }
         
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), Beneficiary_.middleName));
            }
         
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), Beneficiary_.isActive));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), Beneficiary_.isDelete));
            }
        }
        return specification;
    }
}
