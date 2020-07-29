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
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.TIBenReferral;
import gov.naco.soch.entity.TIBenReferral_;
import gov.naco.soch.entity.TIBeneficiary_;
// for static metamodels
import gov.naco.soch.repository.TIBenReferralRepository;
import gov.naco.soch.ti.dto.TIBenReferralCriteria;
import gov.naco.soch.ti.dto.TIBenReferralDTO;
import gov.naco.soch.ti.dto.TiBenReferralCriteriaNew;
import gov.naco.soch.ti.dto.TiBenReferralDtoNew;
import gov.naco.soch.ti.mapper.TIBenReferralMapper;


/**
 * Service for executing complex queries for {@link TIBenReferral} entities in the database.
 * The main input is a {@link TIBenReferralCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenReferralDTO} or a {@link Page} of {@link TIBenReferralDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenReferralQueryService extends QueryService<TIBenReferral> {

    private final Logger log = LoggerFactory.getLogger(TIBenReferralQueryService.class);

    private final TIBenReferralRepository tIBenReferralRepository;

    private final TIBenReferralMapper tIBenReferralMapper;

    public TIBenReferralQueryService(TIBenReferralRepository tIBenReferralRepository, TIBenReferralMapper tIBenReferralMapper) {
        this.tIBenReferralRepository = tIBenReferralRepository;
        this.tIBenReferralMapper = tIBenReferralMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenReferralDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenReferralDTO> findByCriteria(TIBenReferralCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBenReferral> specification = createSpecification(criteria);
        return tIBenReferralMapper.toDto(tIBenReferralRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenReferralDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenReferralDTO> findByCriteria(TIBenReferralCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TIBenReferral> specification = createSpecification(criteria);
        return tIBenReferralRepository.findAll(specification, page)
            .map(tIBenReferralMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenReferralCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TIBenReferral> specification = createSpecification(criteria);
        return tIBenReferralRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenReferralCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenReferral> createSpecification(TIBenReferralCriteria criteria) {
        Specification<TIBenReferral> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), TIBenReferral_.id));
            }
            if (criteria.getRefferalRequestorId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRefferalRequestorId(), TIBenReferral_.refferalRequestorId));
            }
            if (criteria.getTimeOfAppointment() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTimeOfAppointment(), TIBenReferral_.timeOfAppointment));
            }
            if (criteria.getReferralFacility() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralFacility(), TIBenReferral_.referralFacility));
            }
            if (criteria.getReferredFacility() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferredFacility(), TIBenReferral_.referredFacility));
            }
            if (criteria.getTransferTo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTransferTo(), TIBenReferral_.transferTo));
            }
            if (criteria.getTransferFrom() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTransferFrom(), TIBenReferral_.transferFrom));
            }
            if (criteria.getTransferDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTransferDate(), TIBenReferral_.transferDate));
            }
            if (criteria.getTransferStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTransferStatus(), TIBenReferral_.transferStatus));
            }
            if (criteria.getReferralStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralStatus(), TIBenReferral_.referralStatus));
            }
            if (criteria.getDateOfReferral() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfReferral(), TIBenReferral_.dateOfReferral));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHivStatus(), TIBenReferral_.hivStatus));
            }
            if (criteria.getIsCompleted() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getIsCompleted(), TIBenReferral_.isCompleted));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), TIBenReferral_.isActive));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), TIBenReferral_.isDelete));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), TIBenReferral_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), TIBenReferral_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), TIBenReferral_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), TIBenReferral_.modifiedTime));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(TIBenReferral_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildSpecification(criteria.getName(),
                    root -> root.join(TIBenReferral_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
            }
            if (criteria.getuId() != null) {
                specification = specification.and(buildSpecification(criteria.getuId(),
                    root -> root.join(TIBenReferral_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(TIBenReferral_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
            }
        }
        return specification;
    }


}
