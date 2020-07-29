package gov.naco.soch.ti.service;

import java.time.LocalDate;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
import gov.naco.soch.entity.MasterDiagnosisType_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.MasterKitType_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TIStiTreatment;
import gov.naco.soch.entity.TIStiTreatment_;
import gov.naco.soch.entity.TypologyMaster_;
// for static metamodels
import gov.naco.soch.repository.TIStiTreatmentRepository;
import gov.naco.soch.ti.dto.StiTreatmentDiagnosisDTO;
import gov.naco.soch.ti.dto.TIStiTreatmentCriteria;
import gov.naco.soch.ti.dto.TIStiTreatmentDTO;
import gov.naco.soch.ti.mapper.TIStiTreatmentMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Service for executing complex queries for {@link TIStiTreatment} entities in
 * the database. The main input is a {@link TIStiTreatmentCriteria} which gets
 * converted to {@link Specification}, in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIStiTreatmentDTO} or a {@link Page} of
 * {@link TIStiTreatmentDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIStiTreatmentQueryService extends QueryService<TIStiTreatment> {

    private final Logger log = LoggerFactory.getLogger(TIStiTreatmentQueryService.class);

    private final TIStiTreatmentRepository tIStiTreatmentRepository;

    private final TIStiTreatmentMapper tIStiTreatmentMapper;

    public TIStiTreatmentQueryService(TIStiTreatmentRepository tIStiTreatmentRepository,
	    TIStiTreatmentMapper tIStiTreatmentMapper) {
	this.tIStiTreatmentRepository = tIStiTreatmentRepository;
	this.tIStiTreatmentMapper = tIStiTreatmentMapper;
    }

    /**
     * Return a {@link List} of {@link TIStiTreatmentDTO} which matches the criteria
     * from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIStiTreatmentDTO> findByCriteria(TIStiTreatmentCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TIStiTreatment> specification = createSpecification(criteria);
	return tIStiTreatmentMapper.toDto(tIStiTreatmentRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIStiTreatmentDTO} which matches the criteria
     * from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIStiTreatmentDTO> findByCriteria(TIStiTreatmentCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIStiTreatment> specification = createSpecification(criteria);
	List<TIStiTreatment> responseList = tIStiTreatmentRepository.findAll(specification, page).getContent();
	Function<TIStiTreatment, List<Object>> compositeKey = treatmentRecord -> Arrays.<Object>asList(
		treatmentRecord.getBeneficiary().getId(),
		Optional.ofNullable(treatmentRecord.getDiagnosisType()).isPresent()
			? treatmentRecord.getDiagnosisType().getId()
			: null);
	Map<List<Object>, Optional<TIStiTreatment>> groupedByBeneficiaryId = responseList.stream()
		.collect(Collectors.groupingBy(compositeKey, LinkedHashMap::new,
			Collectors.maxBy(Comparator.comparing(TIStiTreatment::getNextFollowUpDate))));
	List<TIStiTreatment> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
		.collect(Collectors.toList());
	final Page<TIStiTreatment> responsePage = new PageImpl<>(list);
	Page<TIStiTreatmentDTO> response = responsePage.map(tIStiTreatmentMapper::toDto);
	return response;
    }

    // public static <T> T nullcheck(Supplier<T> statement) {
    // try {
    // return statement.get();
    // } catch (NullPointerException exc) {
    // return null;
    // }
    // }
    //

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIStiTreatmentCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIStiTreatment> specification = createSpecification(criteria);
	return tIStiTreatmentRepository.count(specification);
    }

    @Transactional(readOnly = true)
    public long countBySearchCriteria(TIStiTreatmentCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIStiTreatment> specification = createSpecificationSearch(criteria);
	return tIStiTreatmentRepository.count(specification);
    }

    @Transactional(readOnly = true)
    public Page<TIStiTreatmentDTO> findByCriteriaSearch(TIStiTreatmentCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIStiTreatment> specification = createSpecificationSearch(criteria);
	return tIStiTreatmentRepository.findAll(specification, page).map(tIStiTreatmentMapper::toDto);
    }

    /**
     * Function to convert {@link TIStiTreatmentCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIStiTreatment> createSpecification(TIStiTreatmentCriteria criteria) {
	Specification<TIStiTreatment> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIStiTreatment_.id));
	    }
	    if (criteria.getStiRtiDiagnosis() != null) {
		specification = specification.and(buildSpecification(criteria.getStiRtiDiagnosis(),
			root -> root.join(TIStiTreatment_.diagnosisType, JoinType.LEFT).get(MasterDiagnosisType_.id)));
	    }
	    if (criteria.getKitPrescribed() != null) {
		specification = specification.and(buildSpecification(criteria.getKitPrescribed(),
			root -> root.join(TIStiTreatment_.kitType, JoinType.LEFT).get(MasterKitType_.id)));
	    }
	    if (criteria.getPartnerNotified() != null) {
		specification = specification
			.and(buildSpecification(criteria.getPartnerNotified(), TIStiTreatment_.partnerNotified));
	    }
	    if (criteria.getFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getFollowUpDate(), TIStiTreatment_.followUpDate));
	    }
	    if (criteria.getNextFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNextFollowUpDate(), TIStiTreatment_.nextFollowUpDate));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), TIStiTreatment_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDelete(), TIStiTreatment_.isDelete));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TIStiTreatment> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));
	    }

	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyId)));

	    }

	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), TIStiTreatment_.isEarly));
	    }
	    
	    if (criteria.getStatus() != null) {
 		specification = specification.and(buildSpecification(criteria.getStatus(),
 			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
 	    }
	}
	return specification;
    }

    protected Specification<TIStiTreatment> createSpecificationSearch(TIStiTreatmentCriteria criteria) {
	Specification<TIStiTreatment> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIStiTreatment_.id));
	    }
	    if (criteria.getStiRtiDiagnosis() != null) {
		specification = specification.and(buildSpecification(criteria.getStiRtiDiagnosis(),
			root -> root.join(TIStiTreatment_.diagnosisType, JoinType.LEFT).get(MasterDiagnosisType_.id)));
	    }
	    if (criteria.getKitPrescribed() != null) {
		specification = specification.and(buildSpecification(criteria.getKitPrescribed(),
			root -> root.join(TIStiTreatment_.kitType, JoinType.LEFT).get(MasterKitType_.id)));
	    }
	    if (criteria.getPartnerNotified() != null) {
		specification = specification
			.and(buildSpecification(criteria.getPartnerNotified(), TIStiTreatment_.partnerNotified));
	    }
	    if (criteria.getFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getFollowUpDate(), TIStiTreatment_.followUpDate));
	    }
	    if (criteria.getNextFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNextFollowUpDate(), TIStiTreatment_.nextFollowUpDate));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), TIStiTreatment_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDelete(), TIStiTreatment_.isDelete));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TIStiTreatment> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }
	    
	    if (criteria.getStatus() != null) {
	 		specification = specification.and(buildSpecification(criteria.getStatus(),
	 			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	 	    }

	    if (criteria.getGender() != null) {
		specification = specification.and(buildSpecification(criteria.getGender(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.genderId, JoinType.LEFT).get(MasterGender_.name)));

	    }
	    if (criteria.getTypology() != null) {

		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyName)));

	    }

	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), TIStiTreatment_.isEarly));
	    }

	    if (criteria.getParam() != null) {

		specification = specification.and(andSearchParam(criteria.getParam(), specification));

	    }
	}

	return specification;
    }

    private Specification<TIStiTreatment> andSearchParam(StringFilter param,
	    Specification<TIStiTreatment> specification) {
	specification = specification
		.and(buildSpecification(param, root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
	specification = specification
		.or(buildSpecification(param, root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
	specification = specification
		.or(buildSpecification(param, root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
	specification = specification
		.or(buildSpecification(param, root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
	specification = specification
		.or(buildSpecification(param, root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
	specification = specification.or(buildSpecification(param,
		root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));

	return specification;
    }

    @Transactional(readOnly = true)
    public Page<TIStiTreatmentDTO> findByCriteriaUpcoming(TIStiTreatmentCriteria criteria, Pageable page) {
	log.debug("find by criteria findByCriteriaUpcoming : {}, page: {}", criteria, page);
	final Specification<TIStiTreatment> specification = createSpecificationUpMiss(criteria, "upcoming");
	return tIStiTreatmentRepository.findAll(specification, page).map(tIStiTreatmentMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<TIStiTreatmentDTO> findByCriteriaMissed(TIStiTreatmentCriteria criteria, Pageable page) {
	log.debug("find by criteria findByCriteriaMissed : {}, page: {}", criteria, page);
	final Specification<TIStiTreatment> specification = createSpecificationUpMiss(criteria, "missed");
	return tIStiTreatmentRepository.findAll(specification, page).map(tIStiTreatmentMapper::toDto);
    }

    public static Specification<TIStiTreatment> isUpcomingDate(TIStiTreatmentCriteria criteria) {
	LocalDate todaydate = LocalDate.now();
	// LocalDate date = LocalDate.of(2020, 04, 25);
	return (root, query, cb) -> {

	    Predicate pd1 = cb.greaterThan(root.get(TIStiTreatment_.nextFollowUpDate), todaydate.minusDays(10));
	    Predicate pd2 = cb.lessThanOrEqualTo(root.get(TIStiTreatment_.nextFollowUpDate), todaydate);
	    Predicate pd3 = cb.and(pd1, pd2);

	    return pd3;
	};
    }

    public static Specification<TIStiTreatment> isMissedDate(TIStiTreatmentCriteria criteria) {
	LocalDate todaydate = LocalDate.now();
	// LocalDate date = LocalDate.of(2020, 05, 13);
	return (root, query, cb) -> {
	    return cb.lessThanOrEqualTo(root.get(TIStiTreatment_.nextFollowUpDate), todaydate.minusDays(10));
	};

    }

    protected Specification<TIStiTreatment> createSpecificationUpMiss(TIStiTreatmentCriteria criteria, String val) {
	Specification<TIStiTreatment> specification = null;
	if (val.equalsIgnoreCase("upcoming")) {
	    specification = Specification.where(isUpcomingDate(criteria));
	}
	if (val.equalsIgnoreCase("missed")) {
	    specification = Specification.where(isMissedDate(criteria));
	}
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIStiTreatment_.id));
	    }
	    if (criteria.getStiRtiDiagnosis() != null) {
		specification = specification.and(buildSpecification(criteria.getStiRtiDiagnosis(),
			root -> root.join(TIStiTreatment_.diagnosisType, JoinType.LEFT).get(MasterDiagnosisType_.id)));
	    }
	    if (criteria.getKitPrescribed() != null) {
		specification = specification.and(buildSpecification(criteria.getKitPrescribed(),
			root -> root.join(TIStiTreatment_.kitType, JoinType.LEFT).get(MasterKitType_.id)));
	    }
	    if (criteria.getPartnerNotified() != null) {
		specification = specification
			.and(buildSpecification(criteria.getPartnerNotified(), TIStiTreatment_.partnerNotified));
	    }
	    if (criteria.getFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getFollowUpDate(), TIStiTreatment_.followUpDate));
	    }
	    if (criteria.getNextFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNextFollowUpDate(), TIStiTreatment_.nextFollowUpDate));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), TIStiTreatment_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDelete(), TIStiTreatment_.isDelete));
	    }

	    /*
	     * if (criteria.getFacilityId() != null) { specification =
	     * specification.and(buildRangeSpecification(criteria.getFacilityId( ),
	     * TIStiTreatment_.facilityId)); }
	     */
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIStiTreatment_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }
	}
	return specification;
    }

    public static Specification<TIStiTreatment> findByFacilityId(final Long facilityId) {

	return new Specification<TIStiTreatment>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<TIStiTreatment> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TIBeneficiary, Beneficiary> x = root.join(TIStiTreatment_.beneficiary, JoinType.LEFT)
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

    public StiTreatmentDiagnosisDTO findByDiagnosisAndBeneficiary(Long diagnosisId, Long beneficiaryId) {
	LocalDate firstFollowUpDate = tIStiTreatmentRepository.findByDiagnosisAndBeneficiaryId(diagnosisId,
		beneficiaryId);
	Long id = tIStiTreatmentRepository.findLatestRecord(diagnosisId, beneficiaryId);
	StiTreatmentDiagnosisDTO response = new StiTreatmentDiagnosisDTO();
	response.setFirstFollowupDate(firstFollowUpDate);
	response.setId(id);
	return response;

    }

}
