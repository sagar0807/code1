package gov.naco.soch.ti.service;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

import gov.naco.soch.constructordto.TiOstDispensationItemDTO;
import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.MasterClientStatus_;
import gov.naco.soch.entity.MasterOstClientStatus_;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.repository.TiOstDispensationItemRepository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIOstBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIOstBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenFollowUpDTO_Initial;
import gov.naco.soch.ti.mapper.OstBenMapper;
import gov.naco.soch.ti.mapper.TiOstBeneficiaryMapper;
import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class TIOstBeneficiaryQueryService extends QueryService<TiOstBeneficiary> {

	private final Logger log = LoggerFactory.getLogger(TIOstBeneficiaryQueryService.class);

	private final TiOstBeneficiaryRepository tIBeneficiaryRepository;

	private final TiOstBeneficiaryMapper tIBeneficiaryMapper;

	private final TiOstDispensationItemRepository dispensationItemRepository;

	private final TransferRepository transferRepository;
	
	private final OstBenMapper ostBenMapper;
	

	public TIOstBeneficiaryQueryService(TiOstBeneficiaryRepository tIBeneficiaryRepository,
			TiOstBeneficiaryMapper tIBeneficiaryMapper, OstBenMapper ostBenMapper,TiOstDispensationItemRepository dispensationItemRepository,
			TransferRepository transferRepository) {
		this.tIBeneficiaryRepository = tIBeneficiaryRepository;
		this.dispensationItemRepository = dispensationItemRepository;
		this.tIBeneficiaryMapper = tIBeneficiaryMapper;
		this.transferRepository = transferRepository;
		this.ostBenMapper=ostBenMapper;
	}

	/**
	 * Return a {@link List} of {@link TIOstBeneficiaryDTO} which matches the
	 * criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public List<TIOstBeneficiaryDTO> findByCriteria(TIOstBeneficiaryCriteria criteria) {
		log.debug("find by criteria : {}", criteria);
		final Specification<TiOstBeneficiary> specification = createSpecification(criteria);
		return tIBeneficiaryMapper.toDto(tIBeneficiaryRepository.findAll(specification));
	}

	/**
	 * Return a {@link Page} of {@link TIOstBeneficiaryDTO} which matches the
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
	public Page<TIOstBeneficiaryDTO> findByCriteria(TIOstBeneficiaryCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TiOstBeneficiary> specification = createSpecification(criteria);
		List<TIOstBeneficiaryDTO> list = tIBeneficiaryRepository.findAll(specification, page)
				.map(tIBeneficiaryMapper::toDto).getContent();
		//setIsTransferred(list);
		getDispensationDetails(list);
               setLatestTransferStatus(list);
		final Page<TIOstBeneficiaryDTO> response = new PageImpl<>(list);
		return response;

	}


	    private void setIsTransferred(List<TIOstBeneficiaryDTO> list, Long facilityId) {
		for (TIOstBeneficiaryDTO tiBen : list) {
		    Optional<BeneficiaryFacilityMappingDto> benFac = tiBen.getMasterBeneficiary()
			    .getBeneficiaryFacilityMappings().stream()
			    .filter(y -> y.getFacilityId().equals(facilityId)).filter(z->z.getIsTransferred()!=null)
			    .filter(x -> x.getIsTransferred().equals(Boolean.TRUE)).findFirst();
		    if (benFac.isPresent()) {
			tiBen.setIsTransferred(true);
		    }
		}
	    }

	private void setLatestTransferStatus(List<TIOstBeneficiaryDTO> list) {

		list.forEach(beneficiary -> {
			String status = transferRepository
					.getLatestTransferStatusOfBeneficiary(beneficiary.getMasterBeneficiary().getId());
			beneficiary.setCurrentTransferStatus(status);
		});
	    
	}

	private void getDispensationDetails(List<TIOstBeneficiaryDTO> list) {
	    list.forEach(beneficiary -> {
		TiOstDispensationItemDTO latestDispensationOfBeneficiary = dispensationItemRepository
				.getLatestDispensationDateOfBeneficiary(beneficiary.getId());
		String status = dispensationItemRepository.findDispensationStatusByBeneficiary(beneficiary.getId());
		if (latestDispensationOfBeneficiary == null) {
			TiOstDispensationItemDTO disp = new TiOstDispensationItemDTO();
			disp.setStatus(status);
			beneficiary.setDispensation(disp);
		} else {
			latestDispensationOfBeneficiary.setStatus(status);
			beneficiary.setDispensation(latestDispensationOfBeneficiary);
		}
	});
	    
	}


	   
	/**
	 * Return a {@link Page} of {@link TIOstBeneficiaryDTO} which matches the
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
	public Page<TIOstBeneficiaryDTO> searchByCriteria(TIOstBeneficiaryCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<TiOstBeneficiary> specification = createSearchSpecification(criteria);
		List<TIOstBeneficiaryDTO> list = tIBeneficiaryRepository.findAll(specification, page)
				.map(tIBeneficiaryMapper::toDto).getContent();
		if (criteria.getFacilityId() != null) {
		    setIsTransferred(list, criteria.getFacilityId().getEquals());
		}
		getDispensationDetails(list);
		setLatestTransferStatus(list);
		List<TIOstBeneficiaryDTO> sortedList = list.stream().map(x -> {
		    Set<TiBenFollowUpDTO_Initial> sortedSet = x.getOstFollowUp().stream()
			    .sorted(Comparator.comparing(TiBenFollowUpDTO_Initial::getId).reversed())
			    .collect(Collectors.toCollection(LinkedHashSet::new));
		    x.getOstFollowUp().clear();
		    x.setOstFollowUp(sortedSet);
		    return x;
		}).collect(Collectors.toList());
		final Page<TIOstBeneficiaryDTO> response = new PageImpl<>(sortedList);
		return response;
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
	public long countByCriteria(TIOstBeneficiaryCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TiOstBeneficiary> specification = createSpecification(criteria);
		return tIBeneficiaryRepository.count(specification);
	}
	
	@Transactional(readOnly = true)
	public long countBySearchCriteria(TIOstBeneficiaryCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<TiOstBeneficiary> specification = createSearchSpecification(criteria);
		return tIBeneficiaryRepository.count(specification);
	}

	/**
	 * Function to convert {@link TIOSTBeneficiaryCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching {@link Specification} of the entity.
	 */
	protected Specification<TiOstBeneficiary> createSearchSpecification(TIOstBeneficiaryCriteria criteria) {
		Specification<TiOstBeneficiary> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getParam() != null) {
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.uid)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
				specification = specification.or(buildSpecification(criteria.getParam(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
			}
			if (criteria.getFirstName() != null) {
				specification = specification.and(buildSpecification(criteria.getFirstName(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
				specification = specification.or(buildSpecification(criteria.getFirstName(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
				specification = specification.or(buildSpecification(criteria.getFirstName(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
			}

			if (criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getUid(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.uid)));
			}
			if (criteria.getOstNumber() != null) {
				specification = specification
						.and(buildSpecification(criteria.getOstNumber(), TiOstBeneficiary_.ostNumber));
			}
			if (criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(),
						root -> root.join(TiOstBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
			}

			if (criteria.getFacilityId() != null) {

				Specification<TiOstBeneficiary> facilitySpecification = findByFacilityId(
						criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);
			}

			if (criteria.getLinkedFacilityId() != null) {

				specification = specification.and(buildSpecification(criteria.getLinkedFacilityId(),
						root -> root.join(TiOstBeneficiary_.linkedFacility, JoinType.LEFT).get(Facility_.id)));
			}

			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), TiOstBeneficiary_.isActive));
			}
			if (criteria.getIsDeleted() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDeleted(), TiOstBeneficiary_.isDeleted));
			}
			if (criteria.getVisitStartDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getVisitStartDate(), TiOstBeneficiary_.registrationDate));
			}

			if (criteria.getVisitEndDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getVisitEndDate(), TiOstBeneficiary_.registrationDate));

			}
			if (criteria.getClientStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getClientStatus(),
						root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.masterClientStatus,JoinType.LEFT).
						get(MasterClientStatus_.name)));
			}
			  if (criteria.getStatus()!= null) {
				specification = specification.and(
					buildSpecification(criteria.getStatus(), 
						root->root.join(TiOstBeneficiary_.status,JoinType.LEFT).get(MasterOstClientStatus_.id)));
			    }

		}
		return specification;
	}

	/**
	 * Function to convert {@link TIBeneficiaryCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching {@link Specification} of the entity.
	 */
	protected Specification<TiOstBeneficiary> createSpecification(TIOstBeneficiaryCriteria criteria) {

		Specification<TiOstBeneficiary> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), TiOstBeneficiary_.id));
			}

			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), TiOstBeneficiary_.isActive));
			}
			if (criteria.getIsDeleted() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDeleted(), TiOstBeneficiary_.isDeleted));
			}
			if (criteria.getFacilityId() != null) {

				Specification<TiOstBeneficiary> facilitySpecification = findByFacilityId(
						criteria.getFacilityId().getEquals());
				specification = specification.and(facilitySpecification);

			}

			if (criteria.getLinkedFacilityId() != null) {

				specification = specification.and(buildSpecification(criteria.getLinkedFacilityId(),
						root -> root.join(TiOstBeneficiary_.linkedFacility, JoinType.LEFT).get(Facility_.id)));
			}
			if (criteria.getRegistrationDate() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getRegistrationDate(), TiOstBeneficiary_.registrationDate));
			}
			if (criteria.getTransitStartDate() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getTransitStartDate(), TiOstBeneficiary_.transitStartDate));
			}
			if (criteria.getTransitEndDate() != null) {
				specification = specification
						.and(buildRangeSpecification(criteria.getTransitEndDate(), TiOstBeneficiary_.transitEndDate));
			}
			if (criteria.getClientStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getClientStatus(),
						root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).join(Beneficiary_.masterClientStatus,JoinType.LEFT).
						get(MasterClientStatus_.name)));
			}
			  if (criteria.getStatus()!= null) {
				specification = specification.and(
					buildSpecification(criteria.getStatus(), 
						root->root.join(TiOstBeneficiary_.status,JoinType.LEFT).get(MasterOstClientStatus_.id)));
			    }

		}
		return specification;
	}

	public static Specification<TiOstBeneficiary> findByFacilityId(final Long facilityId) {

		return new Specification<TiOstBeneficiary>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TiOstBeneficiary> root, CriteriaQuery<?> criteriaQuery,
					CriteriaBuilder criteriaBuilder) {

				Join<TiOstBeneficiary, Beneficiary> x = root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT);
				SetJoin<Beneficiary, BeneficiaryFacilityMapping> y = x.join(Beneficiary_.beneficiaryFacilityMappings,
						JoinType.LEFT);
				Join<BeneficiaryFacilityMapping, Facility> j = y
						.join(gov.naco.soch.entity.BeneficiaryFacilityMapping_.facility, JoinType.LEFT);
				return criteriaBuilder.equal(j.get(Facility_.id), facilityId);

			}
		};
	}

	
}
