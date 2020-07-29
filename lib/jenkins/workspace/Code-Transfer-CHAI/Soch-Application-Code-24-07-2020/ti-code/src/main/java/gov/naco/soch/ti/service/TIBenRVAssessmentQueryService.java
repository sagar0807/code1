package gov.naco.soch.ti.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryFacilityMapping_;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.MasterClientStatus_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TIBenRVAssessment;
import gov.naco.soch.entity.TIBenRVAssessment_;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TypologyMaster_;
// for static metamodels
import gov.naco.soch.repository.TIBenRVAssessmentRepository;
import gov.naco.soch.ti.dto.TIBenRVAssessmentCriteria;
import gov.naco.soch.ti.dto.TIBenRVAssessmentDTO;
import gov.naco.soch.ti.mapper.TIBenRVAssessmentMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link TIBenRVAssessment} entities
 * in the database. The main input is a {@link TIBenRVAssessmentCriteria} which
 * gets converted to {@link Specification}, in a way that all the filters must
 * apply. It returns a {@link List} of {@link TIBenRVAssessmentDTO} or a
 * {@link Page} of {@link TIBenRVAssessmentDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenRVAssessmentQueryService extends QueryService<TIBenRVAssessment> {

    private final Logger log = LoggerFactory.getLogger(TIBenRVAssessmentQueryService.class);

    private final TIBenRVAssessmentRepository tIBenRVAssessmentRepository;

    private final TIBenRVAssessmentMapper tIBenRVAssessmentMapper;

    public TIBenRVAssessmentQueryService(TIBenRVAssessmentRepository tIBenRVAssessmentRepository,
	    TIBenRVAssessmentMapper tIBenRVAssessmentMapper) {
	this.tIBenRVAssessmentRepository = tIBenRVAssessmentRepository;
	this.tIBenRVAssessmentMapper = tIBenRVAssessmentMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenRVAssessmentDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenRVAssessmentDTO> findByCriteria(TIBenRVAssessmentCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TIBenRVAssessment> specification = createSpecification(criteria);
	return tIBenRVAssessmentMapper.toDto(tIBenRVAssessmentRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenRVAssessmentDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenRVAssessmentDTO> findByCriteria(TIBenRVAssessmentCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBenRVAssessment> specification = createSpecification(criteria);
	return tIBenRVAssessmentRepository.findAll(specification, page).map(tIBenRVAssessmentMapper::toDto);
    }

    /**
     * Return a {@link Page} of {@link TIBenRVAssessmentDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenRVAssessmentDTO> searchByCriteria(TIBenRVAssessmentCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBenRVAssessment> specification = createSearchSpecification(criteria);
	return tIBenRVAssessmentRepository.findAll(specification, page).map(tIBenRVAssessmentMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenRVAssessmentCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBenRVAssessment> specification = createSpecification(criteria);
	return tIBenRVAssessmentRepository.count(specification);
    }

    @Transactional(readOnly = true)
    public long countBySearchCriteria(TIBenRVAssessmentCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBenRVAssessment> specification = createSearchSpecification(criteria);
	return tIBenRVAssessmentRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenRVAssessmentCriteria} to a
     * {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenRVAssessment> createSpecification(TIBenRVAssessmentCriteria criteria) {
	Specification<TIBenRVAssessment> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIBenRVAssessment_.id));
	    }

	    if (criteria.getDueDateOfAssessment() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getDueDateOfAssessment(),
			TIBenRVAssessment_.dueDateOfAssessment));
	    }
	    if (criteria.getAssessmentPending() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getAssessmentPending(), TIBenRVAssessment_.assessmentPending));
	    }
	    if (criteria.getAssessmentDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getAssessmentDate(), TIBenRVAssessment_.assessmentDate));
	    }
	    if (criteria.getHighNumberOfSexualEncounters() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getHighNumberOfSexualEncounters(),
			TIBenRVAssessment_.highNumberOfSexualEncounters));
	    }
	    if (criteria.getLowCondomUse() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getLowCondomUse(), TIBenRVAssessment_.lowCondomUse));
	    }
	    if (criteria.getFirstYearInSexWorkAndBelowAgeOf25Years() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getFirstYearInSexWorkAndBelowAgeOf25Years(),
				TIBenRVAssessment_.firstYearInSexWorkAndBelowAgeOf25Years));
	    }
	    if (criteria.getStiReportedInLastThreeMonthsTi() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getStiReportedInLastThreeMonthsTi(),
			TIBenRVAssessment_.stiReportedInLastThreeMonthsTi));
	    }
	    if (criteria.getAlcohol() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getAlcohol(), TIBenRVAssessment_.alcohol));
	    }
	    if (criteria.getUnsafeSex() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getUnsafeSex(), TIBenRVAssessment_.unsafeSex));
	    }
	    if (criteria.getViolence() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getViolence(), TIBenRVAssessment_.violence));
	    }
	    if (criteria.getCondomRequirementPerWeek() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getCondomRequirementPerWeek(),
			TIBenRVAssessment_.condomRequirementPerWeek));
	    }
	    if (criteria.getHighNumberOfDrugUsingPartners() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getHighNumberOfDrugUsingPartners(),
			TIBenRVAssessment_.highNumberOfDrugUsingPartners));
	    }
	    if (criteria.getSharingOfNeedlesSyringes() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getSharingOfNeedlesSyringes(),
			TIBenRVAssessment_.sharingOfNeedlesSyringes));
	    }
	    if (criteria.getInjectingGreaterThanThreeTimes() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getInjectingGreaterThanThreeTimes(),
			TIBenRVAssessment_.injectingGreaterThanThreeTimes));
	    }
	    if (criteria.getStiReportedInLastThreeMonthsIdu() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getStiReportedInLastThreeMonthsIdu(),
			TIBenRVAssessment_.stiReportedInLastThreeMonthsIdu));
	    }
	    if (criteria.getUseOfAlcoholAndOtherDrugsApartFromInjections() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getUseOfAlcoholAndOtherDrugsApartFromInjections(),
				TIBenRVAssessment_.useOfAlcoholAndOtherDrugsApartFromInjections));
	    }
	    if (criteria.getUnsafeSexSexWithNonRegularPartner() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getUnsafeSexSexWithNonRegularPartner(),
				TIBenRVAssessment_.unsafeSexSexWithNonRegularPartner));
	    }
	    if (criteria.getMobilityFromOneHotspotToAnother() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getMobilityFromOneHotspotToAnother(),
			TIBenRVAssessment_.mobilityFromOneHotspotToAnother));
	    }
	    if (criteria.getNeedlesSyringesRequirementPerWeek() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNeedlesSyringesRequirementPerWeek(),
				TIBenRVAssessment_.needlesSyringesRequirementPerWeek));
	    }
	    if (criteria.getIsActive() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsActive(), TIBenRVAssessment_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDelete(), TIBenRVAssessment_.isDelete));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TIBenRVAssessment> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));
	    }

	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyId)));

	    }
	    if (criteria.getIsEarly() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsEarly(), TIBenRVAssessment_.isEarly));
	    }
	    if (criteria.getStatus() != null) {
 		specification = specification.and(buildSpecification(criteria.getStatus(),
 			root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
 	    }
	}
	return specification;
    }

    protected Specification<TIBenRVAssessment> createSearchSpecification(TIBenRVAssessmentCriteria criteria) {
	Specification<TIBenRVAssessment> specification = Specification.where(null);
	if (criteria.getParam() != null) {
	    specification = specification.or(buildSpecification(criteria.getParam(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary)
			    .get(Beneficiary_.uid)));
	    specification = specification.or(buildSpecification(criteria.getParam(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary)
			    .get(Beneficiary_.firstName)));
	    specification = specification.or(buildSpecification(criteria.getParam(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary)
			    .get(Beneficiary_.middleName)));
	    specification = specification.or(buildSpecification(criteria.getParam(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary)
			    .get(Beneficiary_.lastName)));
	    specification = specification.or(buildSpecification(criteria.getParam(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary)
			    .get(Beneficiary_.mobileNumber)));
	    specification = specification.or(buildSpecification(criteria.getParam(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));
	}
	if (criteria.getDueDateOfAssessment() != null) {
	    specification = specification.and(
		    buildRangeSpecification(criteria.getDueDateOfAssessment(), TIBenRVAssessment_.dueDateOfAssessment));
	}
	if (criteria.getAssessmentPending() != null) {
	    specification = specification.and(
		    buildRangeSpecification(criteria.getAssessmentPending(), TIBenRVAssessment_.assessmentPending));
	}
	if (criteria.getFacilityId() != null) {

	    Specification<TIBenRVAssessment> facilitySpecification = findByFacilityId(
		    criteria.getFacilityId().getEquals());
	    specification = specification.and(facilitySpecification);

	}

	if (criteria.getTypology() != null) {
	    specification = specification.and(buildSpecification(criteria.getTypology(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
			    .get(TypologyMaster_.typologyName)));
	}
	if (criteria.getGender() != null) {
	    specification = specification.and(buildSpecification(criteria.getGender(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT)
			    .join(TIBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.genderId, JoinType.LEFT)
			    .get(MasterGender_.name)));
	}
	if (criteria.getIsEarly() != null) {
	    specification = specification.and(buildSpecification(criteria.getIsEarly(), TIBenRVAssessment_.isEarly));
	}
	
	  if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }

	if (criteria.getIsActive() != null) {
	    specification = specification.and(buildSpecification(criteria.getIsActive(), TIBenRVAssessment_.isActive));
	}
	if (criteria.getIsDelete() != null) {
	    specification = specification.and(buildSpecification(criteria.getIsDelete(), TIBenRVAssessment_.isDelete));
	}
	return specification;
    }

    protected Specification<TIBenRVAssessment> createAdvancedSearchSpecification(TIBenRVAssessmentCriteria criteria,
	    Specification<TIBenRVAssessment> specification) {
	if (criteria.getTypology() != null) {
	    specification = specification.or(buildSpecification(criteria.getTypology(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
			    .get(TypologyMaster_.typologyName)));
	}
	if (criteria.getGender() != null) {
	    specification = specification.and(buildSpecification(criteria.getGender(),
		    root -> root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT)
			    .join(TIBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.genderId, JoinType.LEFT)
			    .get(MasterGender_.name)));
	}
	  if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), TIBenRVAssessment_.isEarly));
	    }

	return specification;
    }

    public static Specification<TIBenRVAssessment> findByFacilityId(final Long facilityId) {

	return new Specification<TIBenRVAssessment>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<TIBenRVAssessment> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TIBeneficiary, Beneficiary> x = root.join(TIBenRVAssessment_.beneficiary, JoinType.LEFT)
			.join(TIBeneficiary_.beneficiary, JoinType.LEFT);
		SetJoin<Beneficiary, BeneficiaryFacilityMapping> y = x.join(Beneficiary_.beneficiaryFacilityMappings,
			JoinType.LEFT);
		y.on(criteriaBuilder.equal(y.get(BeneficiaryFacilityMapping_.isActive), true));
		Join<BeneficiaryFacilityMapping, Facility> j = y
			.join(gov.naco.soch.entity.BeneficiaryFacilityMapping_.facility, JoinType.LEFT);
		return criteriaBuilder.equal(j.get(Facility_.id), facilityId);

	    }
	};
    }
}
