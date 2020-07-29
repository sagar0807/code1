package gov.naco.soch.ti.queryservice;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;
import gov.naco.soch.entity.MasterOstClientStatus_;
import gov.naco.soch.ti.dto.TIOstAssessCriteria;
import gov.naco.soch.ti.dto.readonly.OstAssessmentDto;
import gov.naco.soch.ti.entity.MasterBenSubEntity;
import gov.naco.soch.ti.entity.MasterBenSubEntity_;
import gov.naco.soch.ti.entity.OstAssessment;
import gov.naco.soch.ti.entity.OstAssessment_;
import gov.naco.soch.ti.entity.OstBenSubEntity;
import gov.naco.soch.ti.entity.OstBenSubEntity_;
import gov.naco.soch.ti.mapper.readonly.OstAssessmentMapper;
import gov.naco.soch.ti.repository.OstAssessmentRepository;
import io.github.jhipster.service.QueryService;

@Service
public class OstAssessmentQueryService extends QueryService<OstAssessment> {

    private final OstAssessmentRepository ostAssessmentRepository;
    private final OstAssessmentMapper ostAssessmentMapper;

    public OstAssessmentQueryService(OstAssessmentRepository ostAssessmentRepository,
	    OstAssessmentMapper ostAssessmentMapper) {
	this.ostAssessmentRepository = ostAssessmentRepository;
	this.ostAssessmentMapper = ostAssessmentMapper;
    }

    @Transactional(readOnly = true)
    public Page<OstAssessmentDto> findByCriteria(TIOstAssessCriteria criteria, Pageable page) {
	final Specification<OstAssessment> specification = createSpecification(criteria);
	List<OstAssessment> responseList = ostAssessmentRepository.findAll(specification, page).getContent();
	Map<Long, Optional<OstAssessment>> groupedByBeneficiaryId = responseList.stream()
		.collect(Collectors.groupingBy(x -> x.getTiOstBeneficiary().getId(), LinkedHashMap::new,
			Collectors.maxBy(Comparator.comparing(OstAssessment::getId))));
	List<OstAssessment> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
		.collect(Collectors.toList());
	final Page<OstAssessment> responsePage = new PageImpl<>(list);
	Page<OstAssessmentDto> response = responsePage.map(ostAssessmentMapper::toDto);
	return response;
    }

    @Transactional(readOnly = true)
    public long countByCriteria(TIOstAssessCriteria criteria) {
	final Specification<OstAssessment> specification = createSpecification(criteria);
	return ostAssessmentRepository.count(specification);
    }

    protected Specification<OstAssessment> createSpecification(TIOstAssessCriteria criteria) {
	Specification<OstAssessment> specification = Specification.where(null);

	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), OstAssessment_.id));
	    }
	    if (criteria.getDateOfAssessment() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfAssessment(), OstAssessment_.dateOfAssessment));
	    }
	    if (criteria.getNextDateOfAssessment() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNextDateOfAssessment(),
			OstAssessment_.nextDateOfAssessment));
	    }

	    if (criteria.getAgeAtOnset() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getAgeAtOnset(), OstAssessment_.ageAtOnset));
	    }
	    if (criteria.getNoYearsInUse() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNoYearsInUse(), OstAssessment_.noYearsInUse));
	    }
	    if (criteria.getInjectingRoute() != null) {
		specification = specification
			.and(buildSpecification(criteria.getInjectingRoute(), OstAssessment_.injectingRoute));
	    }
	    if (criteria.getDependence() != null) {
		specification = specification
			.and(buildSpecification(criteria.getDependence(), OstAssessment_.dependence));
	    }
	    if (criteria.getUseInLastOneMonth() != null) {
		specification = specification
			.and(buildSpecification(criteria.getUseInLastOneMonth(), OstAssessment_.useInLastOneMonth));
	    }

	    if (criteria.getIsNeedlesAndSyringesShared() != null) {
		specification = specification.and(buildSpecification(criteria.getIsNeedlesAndSyringesShared(),
			OstAssessment_.isNeedlesAndSyringesShared));
	    }
	    if (criteria.getIsNeedlesAndSyringesSharedLastOccasion() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsNeedlesAndSyringesSharedLastOccasion(),
				OstAssessment_.isNeedlesAndSyringesSharedLastOccasion));
	    }
	    if (criteria.getIsOtherParaphernaliaSharedLastOccasion() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsOtherParaphernaliaSharedLastOccasion(),
				OstAssessment_.isOtherParaphernaliaSharedLastOccasion));
	    }
	    if (criteria.getIsOtherParaphernaliaSharedEver() != null) {
		specification = specification.and(buildSpecification(criteria.getIsOtherParaphernaliaSharedEver(),
			OstAssessment_.isOtherParaphernaliaSharedEver));
	    }
	    if (criteria.getNoOfSexualPartners() != null) {
		specification = specification
			.and(buildSpecification(criteria.getNoOfSexualPartners(), OstAssessment_.noOfSexualPartners));
	    }
	    if (criteria.getLastSexualEncounter() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getLastSexualEncounter(), OstAssessment_.lastSexualEncounter));
	    }
	    if (criteria.getIsAbstinenceAttemptedPreviously() != null) {
		specification = specification.and(buildSpecification(criteria.getIsAbstinenceAttemptedPreviously(),
			OstAssessment_.isAbstinenceAttemptedPreviously));
	    }

	    if (criteria.getDurationOfAbstinence() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getDurationOfAbstinence(),
			OstAssessment_.durationOfAbstinence));
	    }
	    if (criteria.getPulseRate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getPulseRate(), OstAssessment_.pulseRate));
	    }
	    if (criteria.getBloodPressureSystolic() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getBloodPressureSystolic(),
			OstAssessment_.bloodPressureSystolic));
	    }
	    if (criteria.getBloodPressureDiastolic() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getBloodPressureDiastolic(),
			OstAssessment_.bloodPressureDiastolic));
	    }
	    if (criteria.getRespiratoryRate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getRespiratoryRate(), OstAssessment_.respiratoryRate));
	    }
	    if (criteria.getWeight() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getWeight(), OstAssessment_.weight));
	    }
	    if (criteria.getTemperature() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getTemperature(), OstAssessment_.temperature));
	    }
	    if (criteria.getCyanosis() != null) {
		specification = specification.and(buildSpecification(criteria.getCyanosis(), OstAssessment_.cyanosis));
	    }
	    if (criteria.getJaundice() != null) {
		specification = specification.and(buildSpecification(criteria.getJaundice(), OstAssessment_.jaundice));
	    }
	    if (criteria.getOedema() != null) {
		specification = specification.and(buildSpecification(criteria.getOedema(), OstAssessment_.oedema));
	    }
	    if (criteria.getClubbing() != null) {
		specification = specification.and(buildSpecification(criteria.getClubbing(), OstAssessment_.clubbing));
	    }
	    if (criteria.getLymphadenopathy() != null) {
		specification = specification
			.and(buildSpecification(criteria.getLymphadenopathy(), OstAssessment_.lymphadenopathy));
	    }

	    if (criteria.getAbstinenceAttempts() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getAbstinenceAttempts(), OstAssessment_.abstinenceAttempts));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<OstAssessment> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(OstAssessment_.tiOstBeneficiary, JoinType.LEFT).get(OstBenSubEntity_.id)));
	    }

	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(OstAssessment_.tiOstBeneficiary, JoinType.LEFT)
				.join(OstBenSubEntity_.status, JoinType.LEFT).get(MasterOstClientStatus_.id)));
	    }

	    if (criteria.getIsDelete() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDelete(), OstAssessment_.isDelete));
	    }

	}
	return specification;
    }

    public static Specification<OstAssessment> findByFacilityId(final Long facilityId) {

	return new Specification<OstAssessment>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<OstAssessment> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<OstBenSubEntity, MasterBenSubEntity> x = root.join(OstAssessment_.tiOstBeneficiary, JoinType.LEFT)
			.join(OstBenSubEntity_.beneficiary, JoinType.LEFT);
		SetJoin<MasterBenSubEntity, BeneficiaryFacilityMappingReadOnly> y = x
			.join(MasterBenSubEntity_.beneficiaryFacilityMappings, JoinType.LEFT);
		y.on(criteriaBuilder.equal(y.get(BeneficiaryFacilityMappingReadOnly_.isActive), true));
		Join<BeneficiaryFacilityMappingReadOnly, FacilityReadOnly> j = y
			.join(BeneficiaryFacilityMappingReadOnly_.facility, JoinType.LEFT);
		return criteriaBuilder.equal(j.get(FacilityReadOnly_.id), facilityId);

	    }
	};
    }

}
