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
import gov.naco.soch.entity.MasterBeneficiaryOstStatus_;
import gov.naco.soch.entity.MasterClientStatus_;
import gov.naco.soch.entity.MasterDrug_;
import gov.naco.soch.entity.MasterOstClientStatus_;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.entity.TiOstFollowUp_;
import gov.naco.soch.entity.TiOstPrescription_;
// for static metamodels
import gov.naco.soch.repository.TIOstFollowUpRepository;
import gov.naco.soch.ti.dto.TIBenFollowUpCriteria;
import gov.naco.soch.ti.dto.TIBenFollowUpDTO;
import gov.naco.soch.ti.mapper.TIBenFollowUpMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Service for executing complex queries for {@link TIBenFollowUp} entities in
 * the database. The main input is a {@link TIBenFollowUpCriteria} which gets
 * converted to {@link Specification}, in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenFollowUpDTO} or a {@link Page} of
 * {@link TIBenFollowUpDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenFollowUpQueryService extends QueryService<TiOstFollowUp> {

	private final Logger log = LoggerFactory.getLogger(TIBenFollowUpQueryService.class);

	private final TIOstFollowUpRepository tIBenFollowUpRepository;

	private final TIBenFollowUpMapper tIBenFollowUpMapper;

	public TIBenFollowUpQueryService(TIOstFollowUpRepository tIBenFollowUpRepository,
			TIBenFollowUpMapper tIBenFollowUpMapper) {
		this.tIBenFollowUpRepository = tIBenFollowUpRepository;
		this.tIBenFollowUpMapper = tIBenFollowUpMapper;
	}

	/**
	 * Return a {@link List} of {@link TIBenFollowUpDTO} which matches the
	 * criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public List<TIBenFollowUpDTO> findByCriteria(TIBenFollowUpCriteria criteria) {
		log.debug("find by criteria : {}", criteria);
		final Specification<TiOstFollowUp> specification = createSpecification(criteria);
		return tIBenFollowUpMapper.toDto(tIBenFollowUpRepository.findAll(specification));
	}

	/**
	 * Return a {@link Page} of {@link TIBenFollowUpDTO} which matches the
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
	public Page<TIBenFollowUpDTO> findByCriteria(TIBenFollowUpCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TiOstFollowUp> specification = createSpecification(criteria);
		List<TiOstFollowUp> responseList = tIBenFollowUpRepository.findAll(specification, page).getContent();
		Map<Long, Optional<TiOstFollowUp>> groupedByBeneficiaryId = responseList.stream()
				.collect(Collectors.groupingBy(x -> x.getTiOstBeneficiary().getId(),LinkedHashMap::new,
						Collectors.maxBy(Comparator.comparing(TiOstFollowUp::getModifiedTime))));
		List<TiOstFollowUp> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
				.collect(Collectors.toList());
		final Page<TiOstFollowUp> responsePage = new PageImpl<>(list);
		Page<TIBenFollowUpDTO> response = responsePage.map(tIBenFollowUpMapper::toDto);
		return response;
	}

	@Transactional(readOnly = true)
	public Page<TIBenFollowUpDTO> findByCriteriaSearch(TIBenFollowUpCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TiOstFollowUp> specification = createSpecificationSearch(criteria);
		return tIBenFollowUpRepository.findAll(specification, page).map(tIBenFollowUpMapper::toDto);
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
	public long countByCriteria(TIBenFollowUpCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TiOstFollowUp> specification = createSpecification(criteria);
		return tIBenFollowUpRepository.count(specification);
	}

	@Transactional(readOnly = true)
	public long countBySearchCriteria(TIBenFollowUpCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TiOstFollowUp> specification = createSpecificationSearch(criteria);
		return tIBenFollowUpRepository.count(specification);
	}
	/**
	 * Function to convert {@link TIBenFollowUpCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching {@link Specification} of the entity.
	 */
	protected Specification<TiOstFollowUp> createSpecification(TIBenFollowUpCriteria criteria) {
		Specification<TiOstFollowUp> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), TiOstFollowUp_.id));
			}
			if (criteria.getFollowUpDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getFollowUpDate(), TiOstFollowUp_.followUpDate));
			}
			if (criteria.getNextFollowupDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getNextFollowupDate(), TiOstFollowUp_.nextFollowupDate));
			}

			if (criteria.getNoSideEffects() != null) {
				specification = specification
						.and(buildSpecification(criteria.getNoSideEffects(), TiOstFollowUp_.noSideEffects));
			}
			
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).get(TiOstBeneficiary_.id)));
			}

			if (criteria.getFacilityId() != null) {

				Specification<TiOstFollowUp>  facilitySpecification = findByFacilityId(criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);
			}
			
			 if (criteria.getStatus() != null) {
		 		specification = specification.and(buildSpecification(criteria.getStatus(),
		 			root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).join(TiOstBeneficiary_.status, JoinType.LEFT).get(MasterOstClientStatus_.id)));
		 	    }
			 
			   if (criteria.getIsEarly() != null) {
				specification = specification.and(buildSpecification(criteria.getIsEarly(), TiOstFollowUp_.isEarly));
			    }
			
			if (criteria.getClientStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getClientStatus(),
						root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.masterClientStatus,JoinType.LEFT).
								get(MasterClientStatus_.name)));
			}

			if (criteria.getOstStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getOstStatus(), root -> root
						.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).join(TiOstBeneficiary_.ostStatus,JoinType.LEFT).
						get(MasterBeneficiaryOstStatus_.id)));
			}

			if (criteria.getIsDelete() != null) {
				specification = specification.and(buildSpecification(criteria.getIsDelete(), TiOstFollowUp_.isDelete));
			}
		}
		return specification;
	}

	protected Specification<TiOstFollowUp> createSpecificationSearch(TIBenFollowUpCriteria criteria) {
		Specification<TiOstFollowUp> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), TiOstFollowUp_.id));
			}
			if (criteria.getFollowUpDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getFollowUpDate(), TiOstFollowUp_.followUpDate));
			}
			if (criteria.getNextFollowupDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getNextFollowupDate(), TiOstFollowUp_.nextFollowupDate));
			}
		
			if (criteria.getNoSideEffects() != null) {
				specification = specification
						.and(buildSpecification(criteria.getNoSideEffects(), TiOstFollowUp_.noSideEffects));
			}
			
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).get(TiOstBeneficiary_.id)));
			}

			if (criteria.getFacilityId() != null) {

				Specification<TiOstFollowUp>  facilitySpecification = findByFacilityId(criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);
			}

			if (criteria.getClientStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getClientStatus(),
						root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
								.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.masterClientStatus,JoinType.LEFT).
								get(MasterClientStatus_.name)));
			}
			
			   if (criteria.getIsEarly() != null) {
				specification = specification.and(buildSpecification(criteria.getIsEarly(), TiOstFollowUp_.isEarly));
			    }
			   
			if (criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getUid(),
						root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
								.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.uid)));
			}
			if (criteria.getOstNo() != null) {

				specification = specification.and(buildSpecification(criteria.getOstNo(), root -> root
						.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).get(TiOstBeneficiary_.ostNumber)));

			}
			if (criteria.getMobile() != null) {

				specification = specification.and(buildSpecification(criteria.getMobile(),
						root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
								.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));

			}
			if (criteria.getName() != null) {

				specification = specification.and(andSearchName(criteria.getParam(), specification));

			}

			if (criteria.getDrug() != null) {

				specification = specification.and(buildSpecification(criteria.getDrug(),
						root -> root.join(TiOstFollowUp_.tiOstPrescriptions, JoinType.LEFT)
								.get(TiOstPrescription_.product).get(MasterDrug_.name)));

			}

			if (criteria.getDate() != null) {

				specification = specification.and(buildSpecification(criteria.getDate(), TiOstFollowUp_.followUpDate));
				specification = specification
						.or(buildSpecification(criteria.getDate(), TiOstFollowUp_.nextFollowupDate));

			}
			
			 if (criteria.getStatus() != null) {
		 		specification = specification.and(buildSpecification(criteria.getStatus(),
		 			root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).join(TiOstBeneficiary_.status, JoinType.LEFT).get(MasterOstClientStatus_.id)));
		 	    }

			if (criteria.getOstStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getOstStatus(), root -> root
						.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT).join(TiOstBeneficiary_.ostStatus,JoinType.LEFT).
						get(MasterBeneficiaryOstStatus_.id)));
			}
			
			if (criteria.getParam() != null) {

				specification = specification.and(andSearchParam(criteria.getParam(), specification));

			}
			
		}
		return specification;
	}

	private Specification<TiOstFollowUp> andSearchName(StringFilter param, Specification<TiOstFollowUp> specification) {
		specification = specification
				.and(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
		return specification;
	}

	private Specification<TiOstFollowUp> andSearchParam(StringFilter param,
			Specification<TiOstFollowUp> specification) {
		specification = specification
				.and(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.uid)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(TiOstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
						.get(TiOstBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
		return specification;
	}
	
	public static Specification<TiOstFollowUp> findByFacilityId(final Long facilityId) {

		return new Specification<TiOstFollowUp>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TiOstFollowUp> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				Join<TiOstBeneficiary, Beneficiary> x = root.join(TiOstFollowUp_.tiOstBeneficiary,JoinType.LEFT).join(TiOstBeneficiary_.beneficiary, JoinType.LEFT);
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
