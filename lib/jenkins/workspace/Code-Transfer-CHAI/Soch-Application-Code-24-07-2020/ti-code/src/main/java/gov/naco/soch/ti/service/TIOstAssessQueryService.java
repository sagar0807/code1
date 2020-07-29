package gov.naco.soch.ti.service;

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
import gov.naco.soch.entity.MasterOstClientStatus_;
import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.entity.TiOstAssessment_;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.repository.TIOSTAssessmentRepository;
import gov.naco.soch.ti.dto.TIOstAssessCriteria;
import gov.naco.soch.ti.dto.TIOstAssessDTO;
import gov.naco.soch.ti.mapper.TIOstAssessMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link TIOstAssess} entities in the
 * database. The main input is a {@link TIOstAssessCriteria} which gets
 * converted to {@link Specification}, in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIOstAssessDTO} or a {@link Page} of
 * {@link TIOstAssessDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIOstAssessQueryService extends QueryService<TiOstAssessment> {

	private final Logger log = LoggerFactory.getLogger(TIOstAssessQueryService.class);

	private final TIOSTAssessmentRepository tIOstAssessRepository;

	private final TIOstAssessMapper tIOstAssessMapper;

	public TIOstAssessQueryService(TIOSTAssessmentRepository tIOstAssessRepository,
			TIOstAssessMapper tIOstAssessMapper) {
		this.tIOstAssessRepository = tIOstAssessRepository;
		this.tIOstAssessMapper = tIOstAssessMapper;
	}

	/**
	 * Return a {@link List} of {@link TIOstAssessDTO} which matches the
	 * criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public List<TIOstAssessDTO> findByCriteria(TIOstAssessCriteria criteria) {
		log.debug("find by criteria : {}", criteria);
		final Specification<TiOstAssessment> specification = createSpecification(criteria);
		return tIOstAssessMapper.toDto(tIOstAssessRepository.findAll(specification));
	}

	/**
	 * Return a {@link Page} of {@link TIOstAssessDTO} which matches the
	 * criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @param page
	 *            The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<TIOstAssessDTO> findByCriteria(TIOstAssessCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TiOstAssessment> specification = createSpecification(criteria);
		List<TiOstAssessment> responseList = tIOstAssessRepository.findAll(specification, page).getContent();
		Map<Long, Optional<TiOstAssessment>> groupedByBeneficiaryId = responseList.stream()
				.collect(Collectors.groupingBy(x -> x.getTiOstBeneficiary().getId(), LinkedHashMap::new,
						Collectors.maxBy(Comparator.comparing(TiOstAssessment::getModifiedTime))));
		List<TiOstAssessment> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
				.collect(Collectors.toList());
		final Page<TiOstAssessment> responsePage = new PageImpl<>(list);
		Page<TIOstAssessDTO> response = responsePage.map(tIOstAssessMapper::toDto);
		return response;
	}

	/**
	 * Return a {@link Page} of {@link TIOstAssessDTO} which matches the
	 * criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @param page
	 *            The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<TIOstAssessDTO> searchByCriteria(TIOstAssessCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TiOstAssessment> specification = createSearchSpecification(criteria);
		return tIOstAssessRepository.findAll(specification, page).map(tIOstAssessMapper::toDto);
	}

	/**
	 * Return the number of matching entities in the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the number of matching entities.
	 */
	@Transactional(readOnly = true)
	public long countByCriteria(TIOstAssessCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TiOstAssessment> specification = createSpecification(criteria);
		return tIOstAssessRepository.count(specification);
	}
	
	@Transactional(readOnly = true)
	public long countBySearchCriteria(TIOstAssessCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TiOstAssessment> specification = createSearchSpecification(criteria);
		return tIOstAssessRepository.count(specification);
	}

	/**
	 * Function to convert {@link TIOstAssessCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching {@link Specification} of the entity.
	 */
	protected Specification<TiOstAssessment> createSearchSpecification(TIOstAssessCriteria criteria) {
		Specification<TiOstAssessment> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getParam() != null) {
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));

			}
			if (criteria.getOstNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getOstNumber(), root -> root
						.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT).get(TiOstBeneficiary_.ostNumber)));
			}
			if (criteria.getFacilityId() != null) {

				Specification<TiOstAssessment> facilitySpecification = findByFacilityId(
						criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);
			}
			if (criteria.getClientStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getClientStatus(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.masterClientStatus,JoinType.LEFT).
								get(MasterClientStatus_.name)));
			}
			
			 if (criteria.getStatus() != null) {
		 		specification = specification.and(buildSpecification(criteria.getStatus(),
		 			root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT).join(TiOstBeneficiary_.status, JoinType.LEFT).get(MasterOstClientStatus_.id)));
		 	    }
		}
		return specification;
	}

	/**
	 * Function to convert {@link TIOstAssessCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching {@link Specification} of the entity.
	 */
	protected Specification<TiOstAssessment> createSpecification(TIOstAssessCriteria criteria) {
		Specification<TiOstAssessment> specification = Specification.where(null);

		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), TiOstAssessment_.id));
			}
			if (criteria.getDateOfAssessment() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getDateOfAssessment(), TiOstAssessment_.dateOfAssessment));
			}
			if (criteria.getNextDateOfAssessment() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getNextDateOfAssessment(),
						TiOstAssessment_.nextDateOfAssessment));
			}

			if (criteria.getAgeAtOnset() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getAgeAtOnset(), TiOstAssessment_.ageAtOnset));
			}
			if (criteria.getNoYearsInUse() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getNoYearsInUse(), TiOstAssessment_.noYearsInUse));
			}
			if (criteria.getInjectingRoute() != null) {
				specification = specification
						.and(buildSpecification(criteria.getInjectingRoute(), TiOstAssessment_.injectingRoute));
			}
			if (criteria.getDependence() != null) {
				specification = specification
						.and(buildSpecification(criteria.getDependence(), TiOstAssessment_.dependence));
			}
			if (criteria.getUseInLastOneMonth() != null) {
				specification = specification
						.and(buildSpecification(criteria.getUseInLastOneMonth(), TiOstAssessment_.useInLastOneMonth));
			}

			if (criteria.getIsNeedlesAndSyringesShared() != null) {
				specification = specification.and(buildSpecification(criteria.getIsNeedlesAndSyringesShared(),
						TiOstAssessment_.isNeedlesAndSyringesShared));
			}
			if (criteria.getIsNeedlesAndSyringesSharedLastOccasion() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsNeedlesAndSyringesSharedLastOccasion(),
								TiOstAssessment_.isNeedlesAndSyringesSharedLastOccasion));
			}
			if (criteria.getIsOtherParaphernaliaSharedLastOccasion() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsOtherParaphernaliaSharedLastOccasion(),
								TiOstAssessment_.isOtherParaphernaliaSharedLastOccasion));
			}
			if (criteria.getIsOtherParaphernaliaSharedEver() != null) {
				specification = specification.and(buildSpecification(criteria.getIsOtherParaphernaliaSharedEver(),
						TiOstAssessment_.isOtherParaphernaliaSharedEver));
			}
			if (criteria.getNoOfSexualPartners() != null) {
				specification = specification
						.and(buildSpecification(criteria.getNoOfSexualPartners(), TiOstAssessment_.noOfSexualPartners));
			}
			if (criteria.getLastSexualEncounter() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getLastSexualEncounter(),
						TiOstAssessment_.lastSexualEncounter));
			}
			if (criteria.getIsAbstinenceAttemptedPreviously() != null) {
				specification = specification.and(buildSpecification(criteria.getIsAbstinenceAttemptedPreviously(),
						TiOstAssessment_.isAbstinenceAttemptedPreviously));
			}

			if (criteria.getDurationOfAbstinence() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getDurationOfAbstinence(),
						TiOstAssessment_.durationOfAbstinence));
			}
			if (criteria.getPulseRate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getPulseRate(), TiOstAssessment_.pulseRate));
			}
			if (criteria.getBloodPressureSystolic() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getBloodPressureSystolic(),
						TiOstAssessment_.bloodPressureSystolic));
			}
			if (criteria.getBloodPressureDiastolic() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getBloodPressureDiastolic(),
						TiOstAssessment_.bloodPressureDiastolic));
			}
			if (criteria.getRespiratoryRate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getRespiratoryRate(), TiOstAssessment_.respiratoryRate));
			}
			if (criteria.getWeight() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getWeight(), TiOstAssessment_.weight));
			}
			if (criteria.getTemperature() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getTemperature(), TiOstAssessment_.temperature));
			}
			if (criteria.getCyanosis() != null) {
				specification = specification
						.and(buildSpecification(criteria.getCyanosis(), TiOstAssessment_.cyanosis));
			}
			if (criteria.getJaundice() != null) {
				specification = specification
						.and(buildSpecification(criteria.getJaundice(), TiOstAssessment_.jaundice));
			}
			if (criteria.getOedema() != null) {
				specification = specification.and(buildSpecification(criteria.getOedema(), TiOstAssessment_.oedema));
			}
			if (criteria.getClubbing() != null) {
				specification = specification
						.and(buildSpecification(criteria.getClubbing(), TiOstAssessment_.clubbing));
			}
			if (criteria.getLymphadenopathy() != null) {
				specification = specification
						.and(buildSpecification(criteria.getLymphadenopathy(), TiOstAssessment_.lymphadenopathy));
			}

			if (criteria.getAbstinenceAttempts() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getAbstinenceAttempts(), TiOstAssessment_.abstinenceAttempts));
			}

			if (criteria.getFacilityId() != null) {

				Specification<TiOstAssessment> facilitySpecification = findByFacilityId(
						criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);
			}

			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT).get(TiOstBeneficiary_.id)));
			}

			if (criteria.getClientStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getClientStatus(),
						root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.masterClientStatus,JoinType.LEFT).
								get(MasterClientStatus_.name)));
			}
			
			 if (criteria.getStatus() != null) {
		 		specification = specification.and(buildSpecification(criteria.getStatus(),
		 			root -> root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT).join(TiOstBeneficiary_.status, JoinType.LEFT).get(MasterOstClientStatus_.id)));
		 	    }

			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), TiOstAssessment_.isDelete));
			}

		}
		return specification;
	}

	public static Specification<TiOstAssessment> findByFacilityId(final Long facilityId) {

		return new Specification<TiOstAssessment>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TiOstAssessment> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				Join<TiOstBeneficiary, Beneficiary> x = root.join(TiOstAssessment_.tiOstBeneficiary, JoinType.LEFT)
						.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT);
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
