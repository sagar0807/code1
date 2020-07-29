package gov.naco.soch.ti.queryservice;

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

import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.ti.dto.TIBenRVAssessmentCriteria;
import gov.naco.soch.ti.dto.readonly.RvAssessmentDto;
import gov.naco.soch.ti.entity.MasterBenSubEntity;
import gov.naco.soch.ti.entity.MasterBenSubEntity_;
import gov.naco.soch.ti.entity.RVAssessment;
import gov.naco.soch.ti.entity.RVAssessment_;
import gov.naco.soch.ti.entity.TiBenSubEntity;
import gov.naco.soch.ti.entity.TiBenSubEntity_;
import gov.naco.soch.ti.mapper.readonly.RVAssessmentMapper;
import gov.naco.soch.ti.repository.RVAssessmentRepository;
import io.github.jhipster.service.QueryService;

@Service
@Transactional
public class RVAssessmentQueryService extends QueryService<RVAssessment> {

    private final Logger log = LoggerFactory.getLogger(RVAssessmentQueryService.class);
    private final RVAssessmentMapper rvAssessmentMapper;
    private final RVAssessmentRepository rvAssessmentRepository;

    public RVAssessmentQueryService(RVAssessmentMapper rvAssessmentMapper,
	    RVAssessmentRepository rvAssessmentRepository) {
	this.rvAssessmentMapper = rvAssessmentMapper;
	this.rvAssessmentRepository = rvAssessmentRepository;
    }
    
    @Transactional(readOnly = true)
    public Page<RvAssessmentDto> findByCriteria(TIBenRVAssessmentCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<RVAssessment> specification = createSpecification(criteria);
	return rvAssessmentRepository.findAll(specification, page).map(rvAssessmentMapper::toDto);
    }
    
    protected Specification<RVAssessment> createSpecification(TIBenRVAssessmentCriteria criteria) {
  	Specification<RVAssessment> specification = Specification.where(null);
  	if (criteria != null) {
  	    if (criteria.getId() != null) {
  		specification = specification.and(buildSpecification(criteria.getId(), RVAssessment_.id));
  	    }

  	    if (criteria.getDueDateOfAssessment() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getDueDateOfAssessment(),
  			RVAssessment_.dueDateOfAssessment));
  	    }
  	    if (criteria.getAssessmentPending() != null) {
  		specification = specification.and(
  			buildRangeSpecification(criteria.getAssessmentPending(), RVAssessment_.assessmentPending));
  	    }
  	    if (criteria.getAssessmentDate() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getAssessmentDate(), RVAssessment_.assessmentDate));
  	    }
  	    if (criteria.getHighNumberOfSexualEncounters() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getHighNumberOfSexualEncounters(),
  			RVAssessment_.highNumberOfSexualEncounters));
  	    }
  	    if (criteria.getLowCondomUse() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getLowCondomUse(), RVAssessment_.lowCondomUse));
  	    }
  	    if (criteria.getFirstYearInSexWorkAndBelowAgeOf25Years() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getFirstYearInSexWorkAndBelowAgeOf25Years(),
  				RVAssessment_.firstYearInSexWorkAndBelowAgeOf25Years));
  	    }
  	    if (criteria.getStiReportedInLastThreeMonthsTi() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getStiReportedInLastThreeMonthsTi(),
  			RVAssessment_.stiReportedInLastThreeMonthsTi));
  	    }
  	    if (criteria.getAlcohol() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getAlcohol(), RVAssessment_.alcohol));
  	    }
  	    if (criteria.getUnsafeSex() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getUnsafeSex(), RVAssessment_.unsafeSex));
  	    }
  	    if (criteria.getViolence() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getViolence(), RVAssessment_.violence));
  	    }
  	    if (criteria.getCondomRequirementPerWeek() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getCondomRequirementPerWeek(),
  			RVAssessment_.condomRequirementPerWeek));
  	    }
  	    if (criteria.getHighNumberOfDrugUsingPartners() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getHighNumberOfDrugUsingPartners(),
  			RVAssessment_.highNumberOfDrugUsingPartners));
  	    }
  	    if (criteria.getSharingOfNeedlesSyringes() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getSharingOfNeedlesSyringes(),
  			RVAssessment_.sharingOfNeedlesSyringes));
  	    }
  	    if (criteria.getInjectingGreaterThanThreeTimes() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getInjectingGreaterThanThreeTimes(),
  			RVAssessment_.injectingGreaterThanThreeTimes));
  	    }
  	    if (criteria.getStiReportedInLastThreeMonthsIdu() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getStiReportedInLastThreeMonthsIdu(),
  			RVAssessment_.stiReportedInLastThreeMonthsIdu));
  	    }
  	    if (criteria.getUseOfAlcoholAndOtherDrugsApartFromInjections() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getUseOfAlcoholAndOtherDrugsApartFromInjections(),
  				RVAssessment_.useOfAlcoholAndOtherDrugsApartFromInjections));
  	    }
  	    if (criteria.getUnsafeSexSexWithNonRegularPartner() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getUnsafeSexSexWithNonRegularPartner(),
  				RVAssessment_.unsafeSexSexWithNonRegularPartner));
  	    }
  	    if (criteria.getMobilityFromOneHotspotToAnother() != null) {
  		specification = specification.and(buildRangeSpecification(criteria.getMobilityFromOneHotspotToAnother(),
  			RVAssessment_.mobilityFromOneHotspotToAnother));
  	    }
  	    if (criteria.getNeedlesSyringesRequirementPerWeek() != null) {
  		specification = specification
  			.and(buildRangeSpecification(criteria.getNeedlesSyringesRequirementPerWeek(),
  				RVAssessment_.needlesSyringesRequirementPerWeek));
  	    }
  	    if (criteria.getIsActive() != null) {
  		specification = specification
  			.and(buildSpecification(criteria.getIsActive(), RVAssessment_.isActive));
  	    }
  	    if (criteria.getIsDelete() != null) {
  		specification = specification
  			.and(buildSpecification(criteria.getIsDelete(), RVAssessment_.isDelete));
  	    }
  	    if (criteria.getBeneficiaryId() != null) {
  		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
  			root -> root.join(RVAssessment_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.id)));
  	    }

  	    if (criteria.getFacilityId() != null) {

  		Specification<RVAssessment> facilitySpecification = findByFacilityId(
  			criteria.getFacilityId().getEquals());
  		specification = specification.and(facilitySpecification);
  	    }


  	    if (criteria.getHrgPrimaryCategory() != null) {
  		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
  			root -> root.join(RVAssessment_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.hrgPrimary)
  				.get(TypologyMaster_.typologyId)));

  	    }
  	    if (criteria.getIsEarly() != null) {
  		specification = specification
  			.and(buildSpecification(criteria.getIsEarly(), RVAssessment_.isEarly));
  	    }
  	    if (criteria.getStatus() != null) {
   		specification = specification.and(buildSpecification(criteria.getStatus(),
   			root -> root.join(RVAssessment_.beneficiary, JoinType.LEFT).join(TiBenSubEntity_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
   	    }
  	}
  	return specification;
      }
    public static Specification<RVAssessment> findByFacilityId(final Long facilityId) {

	return new Specification<RVAssessment>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<RVAssessment> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TiBenSubEntity, MasterBenSubEntity> x = root.join(RVAssessment_.beneficiary, JoinType.LEFT)
    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT);
    		SetJoin<MasterBenSubEntity, BeneficiaryFacilityMappingReadOnly> y = x.join(MasterBenSubEntity_.beneficiaryFacilityMappings,
    			JoinType.LEFT);
    		y.on(criteriaBuilder.equal(y.get(BeneficiaryFacilityMappingReadOnly_.isActive), true));
    		Join<BeneficiaryFacilityMappingReadOnly, FacilityReadOnly> j = y
    			.join(BeneficiaryFacilityMappingReadOnly_.facility, JoinType.LEFT);
    		return criteriaBuilder.equal(j.get(FacilityReadOnly_.id), facilityId);

	    }
	};
    }

}
