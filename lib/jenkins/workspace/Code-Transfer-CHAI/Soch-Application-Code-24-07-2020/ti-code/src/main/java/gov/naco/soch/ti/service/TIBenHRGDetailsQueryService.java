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
import gov.naco.soch.entity.TIBenHRGDetails;
import gov.naco.soch.entity.TIBenHRGDetails_;
import gov.naco.soch.entity.TIBeneficiary_;
// for static metamodels
import gov.naco.soch.repository.TIBenHRGDetailsRepository;
import gov.naco.soch.ti.dto.TIBenHRGDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenHRGDetailsDTO;
import gov.naco.soch.ti.mapper.TIBenHRGDetailsMapper;


/**
 * Service for executing complex queries for {@link TIBenHRGDetails} entities in the database.
 * The main input is a {@link TIBenHRGDetailsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenHRGDetailsDTO} or a {@link Page} of {@link TIBenHRGDetailsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenHRGDetailsQueryService extends QueryService<TIBenHRGDetails> {

    private final Logger log = LoggerFactory.getLogger(TIBenHRGDetailsQueryService.class);

    private final TIBenHRGDetailsRepository tIBenHRGDetailsRepository;

    private final TIBenHRGDetailsMapper tIBenHRGDetailsMapper;

    public TIBenHRGDetailsQueryService(TIBenHRGDetailsRepository tIBenHRGDetailsRepository, TIBenHRGDetailsMapper tIBenHRGDetailsMapper) {
        this.tIBenHRGDetailsRepository = tIBenHRGDetailsRepository;
        this.tIBenHRGDetailsMapper = tIBenHRGDetailsMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenHRGDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenHRGDetailsDTO> findByCriteria(TIBenHRGDetailsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBenHRGDetails> specification = createSpecification(criteria);
        return tIBenHRGDetailsMapper.toDto(tIBenHRGDetailsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenHRGDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenHRGDetailsDTO> findByCriteria(TIBenHRGDetailsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TIBenHRGDetails> specification = createSpecification(criteria);
        return tIBenHRGDetailsRepository.findAll(specification, page)
            .map(tIBenHRGDetailsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenHRGDetailsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TIBenHRGDetails> specification = createSpecification(criteria);
        return tIBenHRGDetailsRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenHRGDetailsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenHRGDetails> createSpecification(TIBenHRGDetailsCriteria criteria) {
        Specification<TIBenHRGDetails> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), TIBenHRGDetails_.id));
            }
            if (criteria.getHrgPrimaryCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHrgPrimaryCategory(), TIBenHRGDetails_.hrgPrimaryCategory));
            }
            if (criteria.getHrgSecondaryCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHrgSecondaryCategory(), TIBenHRGDetails_.hrgSecondaryCategory));
            }
            if (criteria.getSubCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSubCategory(), TIBenHRGDetails_.subCategory));
            }
            if (criteria.getAvgNoSexualActsUponReg() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAvgNoSexualActsUponReg(), TIBenHRGDetails_.avgNoSexualActsUponReg));
            }
            if (criteria.getNoYearsInSexWork() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNoYearsInSexWork(), TIBenHRGDetails_.noYearsInSexWork));
            }
            if (criteria.getConsumeAlcohol() != null) {
                specification = specification.and(buildSpecification(criteria.getConsumeAlcohol(), TIBenHRGDetails_.consumeAlcohol));
            }
            if (criteria.getAlcoholConsDaysInWeek() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAlcoholConsDaysInWeek(), TIBenHRGDetails_.alcoholConsDaysInWeek));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), TIBenHRGDetails_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), TIBenHRGDetails_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), TIBenHRGDetails_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), TIBenHRGDetails_.modifiedTime));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(TIBenHRGDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
            }
        }
        return specification;
    }
}
