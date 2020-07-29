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

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ICTCBeneficiaryRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;

/**
 * Service for executing complex queries for {@link ICTCBeneficiary} entities in the database.
 * The main input is a {@link ICTCBeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCBeneficiaryDTO} or a {@link Page} of {@link ICTCBeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCBeneficiaryQueryService extends QueryService<ICTCBeneficiary> {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryQueryService.class);

    private final ICTCBeneficiaryRepository iCTCBeneficiaryRepository;

    private final ICTCBeneficiaryMapper iCTCBeneficiaryMapper;

    public ICTCBeneficiaryQueryService(ICTCBeneficiaryRepository iCTCBeneficiaryRepository, ICTCBeneficiaryMapper iCTCBeneficiaryMapper) {
        this.iCTCBeneficiaryRepository = iCTCBeneficiaryRepository;
        this.iCTCBeneficiaryMapper = iCTCBeneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBeneficiaryDTO> findByCriteria(ICTCBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryMapper.toDto(iCTCBeneficiaryRepository.findAll(specification));
    }
    
    
    /**
     * Return a {@link List} of {@link ICTCBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBeneficiary> findList(ICTCBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.findAll(specification);
    }
    

    /**
     * Return a {@link Page} of {@link ICTCBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryDTO> findByCriteria(ICTCBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.findAll(specification, page)
            .map(iCTCBeneficiaryMapper::toDto);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCBeneficiary} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiary> getPageByCriteria(ICTCBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCBeneficiaryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCBeneficiaryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCBeneficiary> createSpecification(ICTCBeneficiaryCriteria criteria) {
        Specification<ICTCBeneficiary> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCBeneficiary_.id));
            }
            if (criteria.getPid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPid(), ICTCBeneficiary_.pid));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiary_.isConsentDocumented));
            }
            if (criteria.getReferredBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferredBy(), ICTCBeneficiary_.referredBy));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiary_.infantCode));
            }
            if (criteria.getRegistrationDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRegistrationDate(), ICTCBeneficiary_.registrationDate));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ICTCBeneficiary_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), ICTCBeneficiary_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), ICTCBeneficiary_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), ICTCBeneficiary_.modifiedTime));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiary_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiary_.isDeleted));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(ICTCBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
            }
            if (criteria.getBeneficiaryCategory() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryCategory(),
                    root -> root.join(ICTCBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.category)));
            }
            if (criteria.getFacilityId() != null) {
            	 specification = specification.and(buildSpecification(criteria.getFacilityId(),
                    root -> root.join(ICTCBeneficiary_.facility, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiary_.beneficiaryStatus));
            }
//            if (criteria.getInfantMotherArtId() != null) {
//            	specification = specification.and(buildSpecification(criteria.getFacilityId(),
//                    root -> root.join(ICTCBeneficiary_.artBeneficiaryDetails, JoinType.LEFT).get(ArtBeneficiaryDetails_.id)));
//            }
        }
        return specification;
    }
}
