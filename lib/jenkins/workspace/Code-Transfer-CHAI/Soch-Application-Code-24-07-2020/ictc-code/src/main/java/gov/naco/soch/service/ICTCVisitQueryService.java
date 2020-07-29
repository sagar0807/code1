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

import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ICTCVisitRepository;
import gov.naco.soch.service.dto.ICTCVisitCriteria;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.mapper.ICTCVisitMapper;

/**
 * Service for executing complex queries for {@link ICTCVisit} entities in the database.
 * The main input is a {@link ICTCVisitCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCVisitDTO} or a {@link Page} of {@link ICTCVisitDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCVisitQueryService extends QueryService<ICTCVisit> {

    private final Logger log = LoggerFactory.getLogger(ICTCVisitQueryService.class);

    private final ICTCVisitRepository iCTCVisitRepository;

    private final ICTCVisitMapper iCTCVisitMapper;

    public ICTCVisitQueryService(ICTCVisitRepository iCTCVisitRepository, ICTCVisitMapper iCTCVisitMapper) {
        this.iCTCVisitRepository = iCTCVisitRepository;
        this.iCTCVisitMapper = iCTCVisitMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCVisitDTO> findByCriteria(ICTCVisitCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCVisit> specification = createSpecification(criteria);
        return iCTCVisitMapper.toDto(iCTCVisitRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCVisitDTO> findByCriteria(ICTCVisitCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCVisit> specification = createSpecification(criteria);
        return iCTCVisitRepository.findAll(specification, page)
            .map(iCTCVisitMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCVisitCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCVisit> specification = createSpecification(criteria);
        return iCTCVisitRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCVisitCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCVisit> createSpecification(ICTCVisitCriteria criteria) {
        Specification<ICTCVisit> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCVisit_.id));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitDate(), ICTCVisit_.visitDate));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCVisit_.beneficiaryStatus));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.and(buildSpecification(criteria.getIsPregnant(), ICTCVisit_.isPregnant));
            }
            if (criteria.getPregnancyType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPregnancyType(), ICTCVisit_.pregnancyType));
            }
            if (criteria.getHasTbSymptoms() != null) {
                specification = specification.and(buildSpecification(criteria.getHasTbSymptoms(), ICTCVisit_.hasTbSymptoms));
            }
            if (criteria.getHasStiRtiSymptoms() != null) {
                specification = specification.and(buildSpecification(criteria.getHasStiRtiSymptoms(), ICTCVisit_.hasStiRtiSymptoms));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInfantBreastFed(), ICTCVisit_.infantBreastFed));
            }
            if (criteria.getArvProphylaxis() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getArvProphylaxis(), ICTCVisit_.arvProphylaxis));
            }
            if (criteria.getCptInitiationDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCptInitiationDate(), ICTCVisit_.cptInitiationDate));
            }
//            if (criteria.getPartnerStatusKnown() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getPartnerStatusKnown(), ICTCVisit_.partnerStatusKnown));
//            }
//            if (criteria.getPartnerHivStatus() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getPartnerHivStatus(), ICTCVisit_.partnerHivStatus));
//            }
//            if (criteria.getPartnerNotTestedReason() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getPartnerNotTestedReason(), ICTCVisit_.partnerNotTestedReason));
//            }
//            if (criteria.getPartnerTestFollowUpDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getPartnerTestFollowUpDate(), ICTCVisit_.partnerTestFollowUpDate));
//            }
//            if (criteria.getIsPartnerPrivTreatForHiv() != null) {
//                specification = specification.and(buildSpecification(criteria.getIsPartnerPrivTreatForHiv(), ICTCVisit_.isPartnerPrivTreatForHiv));
//            }
            if (criteria.getTransmissionRoute() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTransmissionRoute(), ICTCVisit_.transmissionRoute));
            }
            if (criteria.getPregnancyLmpDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPregnancyLmpDate(), ICTCVisit_.pregnancyLmpDate));
            }
            if (criteria.getMonthOfPregnancy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMonthOfPregnancy(), ICTCVisit_.monthOfPregnancy));
            }
            if (criteria.getExpectedDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getExpectedDeliveryDate(), ICTCVisit_.expectedDeliveryDate));
            }
            if (criteria.getDeliveryOutcome()!= null) {
                specification = specification.and(buildRangeSpecification(criteria.getDeliveryOutcome(), ICTCVisit_.deliveryOutcome));
            }
            if (criteria.getDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDeliveryDate(), ICTCVisit_.deliveryDate));
            }
            if (criteria.getGravida() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGravida(), ICTCVisit_.gravida));
            }
            if (criteria.getIsRPQCaptured() != null) {
                specification = specification.and(buildSpecification(criteria.getIsRPQCaptured(), ICTCVisit_.isRPQCaptured));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ICTCVisit_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), ICTCVisit_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), ICTCVisit_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), ICTCVisit_.modifiedTime));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCVisit_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCVisit_.isDeleted));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getIctcBeneficiaryId(),
                    root -> root.join(ICTCVisit_.ictcBeneficiary, JoinType.LEFT).get(ICTCBeneficiary_.id)));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityId(),
                    root -> root.join(ICTCVisit_.facility, JoinType.LEFT).get(Facility_.id)));
            }
//            if (criteria.getPartnerArtCenterId() != null) {
//                specification = specification.and(buildSpecification(criteria.getPartnerArtCenterId(),
//                    root -> root.join(ICTCVisit_.partnerArtCenter, JoinType.LEFT).get(ArtBeneficiaryDetails_.id)));
//            }
        }
        return specification;
    }
}
