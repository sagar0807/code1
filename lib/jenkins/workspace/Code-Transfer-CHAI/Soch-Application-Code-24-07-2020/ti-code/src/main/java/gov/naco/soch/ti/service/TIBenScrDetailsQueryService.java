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
import gov.naco.soch.entity.MasterHivScreeningStatus_;
import gov.naco.soch.entity.MasterInfectionType_;
import gov.naco.soch.entity.MasterSyphilisStatus_;
import gov.naco.soch.entity.MasterTbScreeningStatus_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TIBenScrDetails;
import gov.naco.soch.entity.TIBenScrDetails_;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TypologyMaster_;
// for static metamodels
import gov.naco.soch.repository.TIBenScrDetailsRepository;
import gov.naco.soch.ti.dto.TIBenScrDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO;
import gov.naco.soch.ti.mapper.TIBenScrDetailsMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Service for executing complex queries for {@link TIBenScrDetails} entities in
 * the database. The main input is a {@link TIBenScrDetailsCriteria} which gets
 * converted to {@link Specification}, in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenScrDetailsDTO} or a {@link Page} of
 * {@link TIBenScrDetailsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenScrDetailsQueryService extends QueryService<TIBenScrDetails> {

    private final Logger log = LoggerFactory.getLogger(TIBenScrDetailsQueryService.class);

    private final TIBenScrDetailsRepository tIBenScrDetailsRepository;

    private final TIBenScrDetailsMapper tIBenScrDetailsMapper;

    public TIBenScrDetailsQueryService(TIBenScrDetailsRepository tIBenScrDetailsRepository,
	    TIBenScrDetailsMapper tIBenScrDetailsMapper) {
	this.tIBenScrDetailsRepository = tIBenScrDetailsRepository;
	this.tIBenScrDetailsMapper = tIBenScrDetailsMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenScrDetailsDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenScrDetailsDTO> findByCriteria(TIBenScrDetailsCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TIBenScrDetails> specification = createSpecification(criteria);
	return tIBenScrDetailsMapper.toDto(tIBenScrDetailsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenScrDetailsDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenScrDetailsDTO> findByCriteria(TIBenScrDetailsCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBenScrDetails> specification = createSpecification(criteria);
	return tIBenScrDetailsRepository.findAll(specification, page).map(tIBenScrDetailsMapper::toDto);
    }

    /**
     * Return a {@link Page} of {@link TIBenScrDetailsDTO} which matches the
     * criteria from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenScrDetailsDTO> searchByCriteria(TIBenScrDetailsCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBenScrDetails> specification = createSearchSpecification(criteria);
	return tIBenScrDetailsRepository.findAll(specification, page).map(tIBenScrDetailsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenScrDetailsCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBenScrDetails> specification = createSpecification(criteria);
	return tIBenScrDetailsRepository.count(specification);
    }

    @Transactional(readOnly = true)
    public long countBySearchCriteria(TIBenScrDetailsCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBenScrDetails> specification = createSearchSpecification(criteria);
	return tIBenScrDetailsRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenScrDetailsCriteria} to a
     * {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenScrDetails> createSearchSpecification(TIBenScrDetailsCriteria criteria) {
	Specification<TIBenScrDetails> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getDateOfScreening() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfScreening(), TIBenScrDetails_.dateOfScreening));
	    }
	    if (criteria.getNextDateOfScreening() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNextDateOfScreening(),
			TIBenScrDetails_.nextDateOfScreening));
	    }
	    if (criteria.getScreeningStatusHiv() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(), root -> root
			.join(TIBenScrDetails_.screeningStatusHiv, JoinType.LEFT).get(MasterHivScreeningStatus_.name)));
	    }
	    if (criteria.getIsActive() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsActive(), TIBenScrDetails_.isActive));
	    }
	    if (criteria.getIsDeleted() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDeleted(), TIBenScrDetails_.isDeleted));
	    }
	    if (criteria.getFacilityId() != null) {

		Specification<TIBenScrDetails> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));
	    }
	    if (criteria.getGender() != null) {
		specification = specification.and(buildSpecification(criteria.getGender(),
			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.genderId, JoinType.LEFT).get(MasterGender_.name)));
	    }
	    if (criteria.getTypology() != null) {
		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyName)));
	    }
	    if (criteria.getInfection() != null) {
		specification = specification.and(buildSpecification(criteria.getInfection(),
			root -> root.join(TIBenScrDetails_.infection, JoinType.LEFT).get(MasterInfectionType_.name)));
	    }
	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), TIBenScrDetails_.isEarly));
	    }
	    
	    if (criteria.getStatus() != null) {
 		specification = specification.and(buildSpecification(criteria.getStatus(),
 			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
 	    }
	    if (criteria.getParam() != null) {

		specification = specification.and(andSearchParam(criteria.getParam(), specification));

	    }

	}
	return specification;
    }

    private Specification<TIBenScrDetails> andSearchParam(StringFilter basicSearchParam,
	    Specification<TIBenScrDetails> specification) {
	specification = specification
		.and(buildSpecification(basicSearchParam, root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
	specification = specification
		.or(buildSpecification(basicSearchParam, root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
			.get(TIBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
	specification = specification.or(buildSpecification(basicSearchParam,
		root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));
	return specification;
    }

    /**
     * Function to convert {@link TIBenScrDetailsCriteria} to a
     * {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBenScrDetails> createSpecification(TIBenScrDetailsCriteria criteria) {
	Specification<TIBenScrDetails> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIBenScrDetails_.id));
	    }
	    if (criteria.getInfection() != null) {
		specification = specification.and(buildSpecification(criteria.getInfection(),
			root -> root.join(TIBenScrDetails_.infection, JoinType.LEFT).get(MasterInfectionType_.name)));
	    }
	    if (criteria.getDateOfScreening() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfScreening(), TIBenScrDetails_.dateOfScreening));
	    }
	    if (criteria.getNextDateOfScreening() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getNextDateOfScreening(),
			TIBenScrDetails_.nextDateOfScreening));
	    }
	    if (criteria.getScreeningStatusHiv() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(), root -> root
			.join(TIBenScrDetails_.screeningStatusHiv, JoinType.LEFT).get(MasterHivScreeningStatus_.name)));
	    }
	    if (criteria.getScreeningStatusSyphilis() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(),
			root -> root.join(TIBenScrDetails_.screeningStatusSyphilis, JoinType.LEFT)
				.get(MasterSyphilisStatus_.name)));
	    }
	    if (criteria.getProlongedCoughGreaterThanThreeWeeks() != null) {
		specification = specification.and(buildSpecification(criteria.getProlongedCoughGreaterThanThreeWeeks(),
			TIBenScrDetails_.prolongedCoughGreaterThanThreeWeeks));
	    }
	    if (criteria.getPresenceOfSweatGreaterThanThreeWeeks() != null) {
		specification = specification.and(buildSpecification(criteria.getPresenceOfSweatGreaterThanThreeWeeks(),
			TIBenScrDetails_.presenceOfSweatGreaterThanThreeWeeks));
	    }
	    if (criteria.getWeightlossGreaterThan3kgInLastFourWeeks() != null) {
		specification = specification
			.and(buildSpecification(criteria.getWeightlossGreaterThan3kgInLastFourWeeks(),
				TIBenScrDetails_.weightlossGreaterThan3kgInLastFourWeeks));
	    }
	    if (criteria.getFeverGreaterThanThreeWeeks() != null) {
		specification = specification.and(buildSpecification(criteria.getFeverGreaterThanThreeWeeks(),
			TIBenScrDetails_.feverGreaterThanThreeWeeks));
	    }

	    if (criteria.getTbStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(), root -> root
			.join(TIBenScrDetails_.tbStatus, JoinType.LEFT).get(MasterTbScreeningStatus_.name)));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsActive(), TIBenScrDetails_.isActive));
	    }
	    if (criteria.getIsDeleted() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDeleted(), TIBenScrDetails_.isDeleted));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TIBenScrDetails> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
				.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));

	    }

	    if (criteria.getTypology() != null) {
		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.hrgPrimary)
				.get(TypologyMaster_.typologyName)));

	    }

	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), TIBenScrDetails_.isEarly));
	    }
	    
	    if (criteria.getStatus() != null) {
	 		specification = specification.and(buildSpecification(criteria.getStatus(),
	 			root -> root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	 	    }
	}
	return specification;
    }

    public static Specification<TIBenScrDetails> findByFacilityId(final Long facilityId) {

	return new Specification<TIBenScrDetails>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<TIBenScrDetails> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TIBeneficiary, Beneficiary> x = root.join(TIBenScrDetails_.beneficiary, JoinType.LEFT)
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
