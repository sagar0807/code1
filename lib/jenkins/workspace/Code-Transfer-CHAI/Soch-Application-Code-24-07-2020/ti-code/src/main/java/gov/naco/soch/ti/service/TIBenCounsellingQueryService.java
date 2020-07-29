package gov.naco.soch.ti.service;

import java.time.LocalDate;
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
import gov.naco.soch.entity.TIBenCounselling;
import gov.naco.soch.entity.TIBenCounselling_;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.repository.TIBenCounsellingRepository;
import gov.naco.soch.ti.dto.TIBenCounsellingCriteria;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO;
import gov.naco.soch.ti.mapper.TIBenCounsellingMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Service for executing complex queries for {@link TIBenCounselling} entities
 * in the database. The main input is a {@link TIBenCounsellingCriteria} which
 * gets converted to {@link Specification}, in a way that all the filters must
 * apply. It returns a {@link List} of {@link TIBenCounsellingDTO} or a
 * {@link Page} of {@link TIBenCounsellingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenCounsellingQueryService extends QueryService<TIBenCounselling> {

    private final Logger log = LoggerFactory.getLogger(TIBenCounsellingQueryService.class);

    private final TIBenCounsellingRepository tIBenCounsellingRepository;

    private final TIBenCounsellingMapper tIBenCounsellingMapper;

    public TIBenCounsellingQueryService(TIBenCounsellingRepository tIBenCounsellingRepository,
	    TIBenCounsellingMapper tIBenCounsellingMapper) {
	this.tIBenCounsellingRepository = tIBenCounsellingRepository;
	this.tIBenCounsellingMapper = tIBenCounsellingMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenCounsellingDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenCounsellingDTO> findByCriteria(TIBenCounsellingCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TIBenCounselling> specification = createSpecification(criteria);
	return tIBenCounsellingMapper.toDto(tIBenCounsellingRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenCounsellingDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenCounsellingDTO> findByCriteria(TIBenCounsellingCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBenCounselling> specification = createSpecification(criteria);
	return tIBenCounsellingRepository.findAll(specification, page).map(tIBenCounsellingMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<TIBenCounsellingDTO> findByCriteriaUpcoming(TIBenCounsellingCriteria criteria, Pageable page) {
	log.debug("find by criteria findByCriteriaUpcoming : {}, page: {}", criteria, page);
	final Specification<TIBenCounselling> specification = createSpecificationUpMiss(criteria, "upcoming");
	return tIBenCounsellingRepository.findAll(specification, page).map(tIBenCounsellingMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<TIBenCounsellingDTO> findByCriteriaMissed(TIBenCounsellingCriteria criteria, Pageable page) {
	log.debug("find by criteria findByCriteriaMissed : {}, page: {}", criteria, page);
	final Specification<TIBenCounselling> specification = createSpecificationUpMiss(criteria, "missed");
	return tIBenCounsellingRepository.findAll(specification, page).map(tIBenCounsellingMapper::toDto);
    }

    public static Specification<TIBenCounselling> isUpcomingDate(TIBenCounsellingCriteria criteria) {
	LocalDate todaydate = LocalDate.now();
	// LocalDate date = LocalDate.of(2020, 04, 25);
	return (root, query, cb) -> {

	    Predicate pd1 = cb.greaterThan(root.get(TIBenCounselling_.nextCounsellingDate), todaydate.minusDays(10));
	    Predicate pd2 = cb.lessThanOrEqualTo(root.get(TIBenCounselling_.nextCounsellingDate), todaydate);
	    Predicate pd3 = cb.and(pd1, pd2);

	    return pd3;
	};
    }

    public static Specification<TIBenCounselling> isMissedDate(TIBenCounsellingCriteria criteria) {
	LocalDate todaydate = LocalDate.now();
	// LocalDate date = LocalDate.of(2020, 05, 25);
	return (root, query, cb) -> {
	    return cb.lessThanOrEqualTo(root.get(TIBenCounselling_.nextCounsellingDate), todaydate.minusDays(10));
	};

    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenCounsellingCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBenCounselling> specification = createSpecification(criteria);
	return tIBenCounsellingRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenCounsellingCriteria} to a
     * {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenCounselling> createSpecification(TIBenCounsellingCriteria criteria) {
	Specification<TIBenCounselling> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIBenCounselling_.id));
	    }

	    if (criteria.getDurationOfCounselling() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getDurationOfCounselling(),
			TIBenCounselling_.durationOfCounselling));
	    }

	    if (criteria.getNoOfCondomsDistributed() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNoOfCondomsDistributed(),
			TIBenCounselling_.noOfCondomsDistributed));
	    }
	    if (criteria.getLastCounsellingDate() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getLastCounsellingDate(),
			TIBenCounselling_.lastCounsellingDate));
	    }
	    if (criteria.getCounsellingDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getCounsellingDate(), TIBenCounselling_.counsellingDate));
	    }
	    if (criteria.getNextCounsellingDate() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNextCounsellingDate(),
			TIBenCounselling_.nextCounsellingDate));
	    }
	    if (criteria.getIsActive() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsActive(), TIBenCounselling_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDelete(), TIBenCounselling_.isDelete));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }
	    if (criteria.getFacilityId() != null) {

		Specification<TIBenCounselling> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));

	    }
	    if (criteria.getGender() != null) {

		specification = specification.and(buildSpecification(criteria.getGender(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.genderId, JoinType.LEFT).get(MasterGender_.name)));
	    }
	    if (criteria.getTypology() != null) {

		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyName)));
	    }
	    if (criteria.getBasicSearchParam() != null) {

		specification = specification.and(andSearchParam(criteria.getBasicSearchParam(), specification));

	    }

	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyId)));

	    }

	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }
	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), TIBenCounselling_.isEarly));
	    }

	}
	// for basic search the parameter passed could be of any type
	/*
	 * if (criteria.getBasicSearchParam() != null) { specification =
	 * specification.and(searchVal(criteria.getBasicSearchParam())); }
	 */
	return specification;
    }

    private Specification<TIBenCounselling> andSearchParam(StringFilter basicSearchParam,
	    Specification<TIBenCounselling> specification) {
	specification = specification.and(
		buildSpecification(basicSearchParam, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
	specification = specification.or(buildSpecification(basicSearchParam,
		root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));

	// TODO Auto-generated method stub
	return specification;
    }

    public Specification<TIBenCounselling> searchVal(StringFilter param) {
	Specification<TIBenCounselling> specification = Specification.where(null);
	specification = specification
		.or(buildSpecification(param, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));

	specification = specification
		.or(buildSpecification(param, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));

	specification = specification
		.or(buildSpecification(param, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));

	specification = specification
		.or(buildSpecification(param, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));

	specification = specification
		.or(buildSpecification(param, root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
			.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));

	specification = specification.or(buildSpecification(param,
		root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));

	return specification;
    }

    protected Specification<TIBenCounselling> createSpecificationUpMiss(TIBenCounsellingCriteria criteria, String val) {
	Specification<TIBenCounselling> specification = null;
	if (val.equalsIgnoreCase("upcoming")) {
	    specification = Specification.where(isUpcomingDate(criteria));
	}
	if (val.equalsIgnoreCase("missed")) {
	    specification = Specification.where(isMissedDate(criteria));
	}
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIBenCounselling_.id));
	    }

	    if (criteria.getDurationOfCounselling() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getDurationOfCounselling(),
			TIBenCounselling_.durationOfCounselling));
	    }
	    if (criteria.getNoOfCondomsDistributed() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNoOfCondomsDistributed(),
			TIBenCounselling_.noOfCondomsDistributed));
	    }
	    if (criteria.getLastCounsellingDate() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getLastCounsellingDate(),
			TIBenCounselling_.lastCounsellingDate));
	    }
	    if (criteria.getCounsellingDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getCounsellingDate(), TIBenCounselling_.counsellingDate));
	    }
	    if (criteria.getNextCounsellingDate() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNextCounsellingDate(),
			TIBenCounselling_.nextCounsellingDate));
	    }
	    if (criteria.getIsActive() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsActive(), TIBenCounselling_.isActive));
	    }
	    if (criteria.getIsDelete() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDelete(), TIBenCounselling_.isDelete));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIBenCounselling_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }
	}
	return specification;
    }

    public static Specification<TIBenCounselling> findByFacilityId(final Long facilityId) {

	return new Specification<TIBenCounselling>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<TIBenCounselling> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TIBeneficiary, Beneficiary> x = root.join(TIBenCounselling_.beneficiary, JoinType.LEFT)
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
