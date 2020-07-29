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
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiaryCommDis;
import gov.naco.soch.entity.TIBeneficiaryCommDis_;
import gov.naco.soch.entity.TIBeneficiary_;
// for static metamodels
import gov.naco.soch.repository.TIBeneficiaryCommDisRepository;
import gov.naco.soch.ti.dto.TIBeneficiaryCommDisCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryCommDisDTO;
import gov.naco.soch.ti.mapper.TIBeneficiaryCommDisMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link TIBeneficiaryCommDis}
 * entities in the database. The main input is a
 * {@link TIBeneficiaryCommDisCriteria} which gets converted to
 * {@link Specification}, in a way that all the filters must apply. It returns a
 * {@link List} of {@link TIBeneficiaryCommDisDTO} or a {@link Page} of
 * {@link TIBeneficiaryCommDisDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBeneficiaryCommDisQueryService extends QueryService<TIBeneficiaryCommDis> {

	private final Logger log = LoggerFactory.getLogger(TIBeneficiaryCommDisQueryService.class);

	private final TIBeneficiaryCommDisRepository tIBeneficiaryCommDisRepository;

	private final TIBeneficiaryCommDisMapper tIBeneficiaryCommDisMapper;

	public TIBeneficiaryCommDisQueryService(TIBeneficiaryCommDisRepository tIBeneficiaryCommDisRepository,
			TIBeneficiaryCommDisMapper tIBeneficiaryCommDisMapper) {
		this.tIBeneficiaryCommDisRepository = tIBeneficiaryCommDisRepository;
		this.tIBeneficiaryCommDisMapper = tIBeneficiaryCommDisMapper;
	}

	/**
	 * Return a {@link List} of {@link TIBeneficiaryCommDisDTO} which matches
	 * the criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public List<TIBeneficiaryCommDisDTO> findByCriteria(TIBeneficiaryCommDisCriteria criteria) {
		log.debug("find by criteria : {}", criteria);
		final Specification<TIBeneficiaryCommDis> specification = createSpecification(criteria);
		return tIBeneficiaryCommDisMapper.toDto(tIBeneficiaryCommDisRepository.findAll(specification));
	}

	/**
	 * Return a {@link Page} of {@link TIBeneficiaryCommDisDTO} which matches
	 * the criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @param page
	 *            The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<TIBeneficiaryCommDisDTO> findByCriteria(TIBeneficiaryCommDisCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TIBeneficiaryCommDis> specification = createSpecification(criteria);
		return tIBeneficiaryCommDisRepository.findAll(specification, page).map(tIBeneficiaryCommDisMapper::toDto);
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
	public long countByCriteria(TIBeneficiaryCommDisCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TIBeneficiaryCommDis> specification = createSpecification(criteria);
		return tIBeneficiaryCommDisRepository.count(specification);
	}

	/**
	 * Function to convert {@link TIBeneficiaryCommDisCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching {@link Specification} of the entity.
	 */
	protected Specification<TIBeneficiaryCommDis> createSpecification(TIBeneficiaryCommDisCriteria criteria) {
		Specification<TIBeneficiaryCommDis> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), TIBeneficiaryCommDis_.id));
			}
			if (criteria.getCondomsDistributed() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getCondomsDistributed(),
						TIBeneficiaryCommDis_.condomsDistributed));
			}
			
			if (criteria.getCondomUseDuringLastSex() != null) {
				specification = specification.and(buildSpecification(criteria.getCondomUseDuringLastSex(),
						TIBeneficiaryCommDis_.condomUseDuringLastSex));
			}
			if (criteria.getNotSharingNeedleSyringe() != null) {
				specification = specification.and(buildSpecification(criteria.getNotSharingNeedleSyringe(),
						TIBeneficiaryCommDis_.notSharingNeedleSyringe));
			}
			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), TIBeneficiaryCommDis_.isActive));
			}
			if (criteria.getIsDeleted() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDeleted(), TIBeneficiaryCommDis_.isDeleted));
			}
			if (criteria.getDistributionDate() != null) {
				specification = specification
						.and(buildSpecification(criteria.getDistributionDate(), TIBeneficiaryCommDis_.distributionDate));
			}
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(TIBeneficiaryCommDis_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
			}
			if (criteria.getFacilityId() != null) {

				Specification<TIBeneficiaryCommDis>  facilitySpecification = findByFacilityId(criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);
			}
			
			
			
		}
		return specification;
	}
	
	public static Specification<TIBeneficiaryCommDis> findByFacilityId(final Long facilityId) {

		return new Specification<TIBeneficiaryCommDis>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TIBeneficiaryCommDis> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				Join<TIBeneficiary, Beneficiary> x = root.join(TIBeneficiaryCommDis_.beneficiary,JoinType.LEFT).join(TIBeneficiary_.beneficiary, JoinType.LEFT);
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
