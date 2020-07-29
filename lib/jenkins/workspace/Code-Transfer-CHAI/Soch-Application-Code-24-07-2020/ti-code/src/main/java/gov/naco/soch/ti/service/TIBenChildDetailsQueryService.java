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
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.TIBenChildDetails;
import gov.naco.soch.entity.TIBenChildDetails_;
import gov.naco.soch.entity.TIBeneficiary_;
// for static metamodels
import gov.naco.soch.repository.TIBenChildDetailsRepository;
import gov.naco.soch.ti.dto.TIBenChildDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenChildDetailsDTO;
import gov.naco.soch.ti.mapper.TIBenChildDetailsMapper;


/**
 * Service for executing complex queries for {@link TIBenChildDetails} entities in the database.
 * The main input is a {@link TIBenChildDetailsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenChildDetailsDTO} or a {@link Page} of {@link TIBenChildDetailsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenChildDetailsQueryService extends QueryService<TIBenChildDetails> {

    private final Logger log = LoggerFactory.getLogger(TIBenChildDetailsQueryService.class);

    private final TIBenChildDetailsRepository tIBenChildDetailsRepository;

    private final TIBenChildDetailsMapper tIBenChildDetailsMapper;

    public TIBenChildDetailsQueryService(TIBenChildDetailsRepository tIBenChildDetailsRepository, TIBenChildDetailsMapper tIBenChildDetailsMapper) {
        this.tIBenChildDetailsRepository = tIBenChildDetailsRepository;
        this.tIBenChildDetailsMapper = tIBenChildDetailsMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenChildDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenChildDetailsDTO> findByCriteria(TIBenChildDetailsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBenChildDetails> specification = createSpecification(criteria);
        return tIBenChildDetailsMapper.toDto(tIBenChildDetailsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenChildDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenChildDetailsDTO> findByCriteria(TIBenChildDetailsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TIBenChildDetails> specification = createSpecification(criteria);
        return tIBenChildDetailsRepository.findAll(specification, page)
            .map(tIBenChildDetailsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenChildDetailsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TIBenChildDetails> specification = createSpecification(criteria);
        return tIBenChildDetailsRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenChildDetailsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenChildDetails> createSpecification(TIBenChildDetailsCriteria criteria) {
        Specification<TIBenChildDetails> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), TIBenChildDetails_.id));
            }
            if (criteria.getAge() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAge(), TIBenChildDetails_.age));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildSpecification(criteria.getGender(), 
                		root->root.join(TIBenChildDetails_.genderId,JoinType.LEFT).get(MasterGender_.name)));
            }
            
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(TIBenChildDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
            }
        }
        return specification;
    }
}
