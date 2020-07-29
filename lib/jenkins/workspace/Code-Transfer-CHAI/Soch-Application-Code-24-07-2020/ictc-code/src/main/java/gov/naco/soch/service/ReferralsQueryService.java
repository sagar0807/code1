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

import gov.naco.soch.domain.Referrals;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ReferralsRepository;
import gov.naco.soch.service.dto.ReferralsCriteria;
import gov.naco.soch.service.dto.ReferralsDTO;
import gov.naco.soch.service.mapper.ReferralsMapper;

/**
 * Service for executing complex queries for {@link Referrals} entities in the database.
 * The main input is a {@link ReferralsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ReferralsDTO} or a {@link Page} of {@link ReferralsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ReferralsQueryService extends QueryService<Referrals> {

    private final Logger log = LoggerFactory.getLogger(ReferralsQueryService.class);

    private final ReferralsRepository referralsRepository;

    private final ReferralsMapper referralsMapper;

    public ReferralsQueryService(ReferralsRepository referralsRepository, ReferralsMapper referralsMapper) {
        this.referralsRepository = referralsRepository;
        this.referralsMapper = referralsMapper;
    }

    /**
     * Return a {@link List} of {@link ReferralsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ReferralsDTO> findByCriteria(ReferralsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Referrals> specification = createSpecification(criteria);
        return referralsMapper.toDto(referralsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ReferralsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Referrals> findByCriteria(ReferralsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Referrals> specification = createSpecification(criteria);
        return referralsRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ReferralsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Referrals> specification = createSpecification(criteria);
        return referralsRepository.count(specification);
    }

    /**
     * Function to convert {@link ReferralsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Referrals> createSpecification(ReferralsCriteria criteria) {
        Specification<Referrals> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Referrals_.id));
            }
            if (criteria.getSourceFacilityType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSourceFacilityType(), Referrals_.sourceFacilityType));
            }
            if (criteria.getReferralStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralStatus(), Referrals_.referralStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getHivStatus(), Referrals_.hivStatus));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), Referrals_.category));
            }
            if (criteria.getRemarks() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRemarks(), Referrals_.remarks));
            }
            if (criteria.getInitiationDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInitiationDate(), Referrals_.initiationDate));
            }
            if (criteria.getDestinationFacilityType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDestinationFacilityType(), Referrals_.destinationFacilityType));
            }
            if (criteria.getDsrcCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDsrcCode(), Referrals_.dsrcCode));
            }
            if (criteria.getTiCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTiCode(), Referrals_.tiCode));
            }
            if (criteria.getArtCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getArtCode(), Referrals_.artCode));
            }
            if (criteria.getOstCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOstCode(), Referrals_.ostCode));
            }
            if (criteria.getPidCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPidCode(), Referrals_.pidCode));
            }
            if (criteria.getReportingDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportingDate(), Referrals_.reportingDate));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), Referrals_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), Referrals_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), Referrals_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), Referrals_.modifiedTime));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), Referrals_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), Referrals_.isDeleted));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(Referrals_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
            }
            if (criteria.getSourceFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getSourceFacilityId(),
                    root -> root.join(Referrals_.sourceFacility, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getDestinationFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getDestinationFacilityId(),
                    root -> root.join(Referrals_.destinationFacility, JoinType.LEFT).get(Facility_.id)));
            }
        }
        return specification;
    }
}
