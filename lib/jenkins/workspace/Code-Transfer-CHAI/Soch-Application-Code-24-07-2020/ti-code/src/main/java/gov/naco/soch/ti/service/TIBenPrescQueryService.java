package gov.naco.soch.ti.service;

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
import gov.naco.soch.entity.TIBenPresc;
import gov.naco.soch.entity.TIBenPresc_;
import gov.naco.soch.entity.TIBeneficiary_;
// for static metamodels
import gov.naco.soch.repository.TIBenPrescRepository;
import gov.naco.soch.ti.dto.TIBenPrescCriteria;
import gov.naco.soch.ti.dto.TIBenPrescDTO;
import gov.naco.soch.ti.mapper.TIBenPrescMapper;


/**
 * Service for executing complex queries for {@link TIBenPresc} entities in the database.
 * The main input is a {@link TIBenPrescCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenPrescDTO} or a {@link Page} of {@link TIBenPrescDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenPrescQueryService extends QueryService<TIBenPresc> {

    private final Logger log = LoggerFactory.getLogger(TIBenPrescQueryService.class);

    private final TIBenPrescRepository tIBenPrescRepository;

    private final TIBenPrescMapper tIBenPrescMapper;

    public TIBenPrescQueryService(TIBenPrescRepository tIBenPrescRepository, TIBenPrescMapper tIBenPrescMapper) {
        this.tIBenPrescRepository = tIBenPrescRepository;
        this.tIBenPrescMapper = tIBenPrescMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenPrescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenPrescDTO> findByCriteria(TIBenPrescCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBenPresc> specification = createSpecification(criteria);
        return tIBenPrescMapper.toDto(tIBenPrescRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenPrescDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenPrescDTO> findByCriteria(TIBenPrescCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TIBenPresc> specification = createSpecification(criteria);
        return tIBenPrescRepository.findAll(specification, page)
            .map(tIBenPrescMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenPrescCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TIBenPresc> specification = createSpecification(criteria);
        return tIBenPrescRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenPrescCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenPresc> createSpecification(TIBenPrescCriteria criteria) {
        Specification<TIBenPresc> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), TIBenPresc_.id));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), TIBenPresc_.facilityId));
            }
            if (criteria.getInitiationDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInitiationDate(), TIBenPresc_.initiationDate));
            }
            if (criteria.getSubstitutionDrug() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSubstitutionDrug(), TIBenPresc_.substitutionDrug));
            }
            if (criteria.getConsentTaken() != null) {
                specification = specification.and(buildSpecification(criteria.getConsentTaken(), TIBenPresc_.consentTaken));
            }
            if (criteria.getDosage() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDosage(), TIBenPresc_.dosage));
            }
            if (criteria.getMeasureOfUnit() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMeasureOfUnit(), TIBenPresc_.measureOfUnit));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), TIBenPresc_.isActive));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), TIBenPresc_.isDelete));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), TIBenPresc_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), TIBenPresc_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), TIBenPresc_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), TIBenPresc_.modifiedTime));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(TIBenPresc_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
            }
        }
        return specification;
    }
}
