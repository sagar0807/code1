package gov.naco.soch.ti.queryservice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
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
import gov.naco.soch.entity.MasterDiagnosisType_;
import gov.naco.soch.entity.MasterKitType_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.ti.dto.TIStiTreatmentCriteria;
import gov.naco.soch.ti.dto.readonly.StiTreatmentDto;
import gov.naco.soch.ti.entity.MasterBenSubEntity;
import gov.naco.soch.ti.entity.MasterBenSubEntity_;
import gov.naco.soch.ti.entity.StiTreatment;
import gov.naco.soch.ti.entity.StiTreatment_;
import gov.naco.soch.ti.entity.TiBenSubEntity;
import gov.naco.soch.ti.entity.TiBenSubEntity_;
import gov.naco.soch.ti.mapper.readonly.StiTreatmentMapper;
import gov.naco.soch.ti.repository.StiTreatmentRepository;
import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class StiTreatmentQueryService extends QueryService<StiTreatment> {

    private final StiTreatmentMapper stiTreatmentMapper;
    private final StiTreatmentRepository stiTreatmentRepository;

    public StiTreatmentQueryService(StiTreatmentMapper stiTreatmentMapper,
	    StiTreatmentRepository stiTreatmentRepository) {
	this.stiTreatmentMapper = stiTreatmentMapper;
	this.stiTreatmentRepository = stiTreatmentRepository;
    }

    @Transactional(readOnly = true)
    public Page<StiTreatmentDto> findByCriteria(TIStiTreatmentCriteria criteria, Pageable page) {
	final Specification<StiTreatment> specification = createSpecification(criteria);
	List<StiTreatment> responseList = stiTreatmentRepository.findAll(specification, page).getContent();
	Function<StiTreatment, List<Object>> compositeKey = treatmentRecord -> Arrays.<Object>asList(
		treatmentRecord.getBeneficiary().getId(),
		Optional.ofNullable(treatmentRecord.getDiagnosisType()).isPresent()
			? treatmentRecord.getDiagnosisType().getId()
			: null);
	Map<List<Object>, Optional<StiTreatment>> groupedByBeneficiaryId = responseList.stream()
		.collect(Collectors.groupingBy(compositeKey, LinkedHashMap::new,
			Collectors.maxBy(Comparator.comparing(StiTreatment::getNextFollowUpDate))));
	List<StiTreatment> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
		.collect(Collectors.toList());
	final Page<StiTreatment> responsePage = new PageImpl<>(list);
	Page<StiTreatmentDto> response = responsePage.map(stiTreatmentMapper::toDto);
	return response;
    }
    
    @Transactional(readOnly = true)
    public long countByCriteria(TIStiTreatmentCriteria criteria) {
	final Specification<StiTreatment> specification = createSpecification(criteria);
	return stiTreatmentRepository.count(specification);
    }

    protected Specification<StiTreatment> createSpecification(TIStiTreatmentCriteria criteria) {
	Specification<StiTreatment> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), StiTreatment_.id));
	    }
	    if (criteria.getStiRtiDiagnosis() != null) {
		specification = specification.and(buildSpecification(criteria.getStiRtiDiagnosis(),
			root -> root.join(StiTreatment_.diagnosisType, JoinType.LEFT).get(MasterDiagnosisType_.id)));
	    }
	    if (criteria.getKitPrescribed() != null) {
		specification = specification.and(buildSpecification(criteria.getKitPrescribed(),
			root -> root.join(StiTreatment_.kitType, JoinType.LEFT).get(MasterKitType_.id)));
	    }
	    if (criteria.getPartnerNotified() != null) {
		specification = specification
			.and(buildSpecification(criteria.getPartnerNotified(), StiTreatment_.partnerNotified));
	    }
	    if (criteria.getFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getFollowUpDate(), StiTreatment_.followUpDate));
	    }
	    if (criteria.getNextFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNextFollowUpDate(), StiTreatment_.nextFollowUpDate));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), StiTreatment_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDelete(), StiTreatment_.isDelete));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(StiTreatment_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<StiTreatment> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(StiTreatment_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.hrgPrimary)
				.get(TypologyMaster_.typologyId)));

	    }

	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), StiTreatment_.isEarly));
	    }

	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(StiTreatment_.beneficiary, JoinType.LEFT)
				.join(TiBenSubEntity_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }
	}
	return specification;
    }
    
    public static Specification<StiTreatment> findByFacilityId(final Long facilityId) {

   	return new Specification<StiTreatment>() {

   	    private static final long serialVersionUID = 1L;

   	    @Override
   	    public Predicate toPredicate(Root<StiTreatment> root, CriteriaQuery<?> criteriaQuery,
   		    CriteriaBuilder criteriaBuilder) {

   		Join<TiBenSubEntity, MasterBenSubEntity> x = root.join(StiTreatment_.beneficiary, JoinType.LEFT)
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
