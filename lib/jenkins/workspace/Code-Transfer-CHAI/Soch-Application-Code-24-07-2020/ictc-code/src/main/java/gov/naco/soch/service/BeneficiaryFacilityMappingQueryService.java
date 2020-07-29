package gov.naco.soch.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingCriteria;

import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;
import gov.naco.soch.service.mapper.BeneficiaryFacilityMappingMapper;

/**
 * Service for executing complex queries for BeneficiaryFacilityMapping entities
 * in the database. The main input is a
 * {@link BeneficiaryFacilityMappingCriteria} which gets converted to
 * {@link Specification}, in a way that all the filters must apply. It returns a
 * {@link List} of {@link BeneficiaryFacilityMappingDTO} or a {@link Page} of
 * {@link BeneficiaryFacilityMappingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BeneficiaryFacilityMappingQueryService extends QueryService<BeneficiaryFacilityMapping> {

	private final Logger log = LoggerFactory.getLogger(BeneficiaryFacilityMappingQueryService.class);

	private final BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;

	private final BeneficiaryFacilityMappingMapper beneficiaryFacilityMappingMapper;

	public BeneficiaryFacilityMappingQueryService(
			BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository,
			BeneficiaryFacilityMappingMapper beneficiaryFacilityMappingMapper) {
		this.beneficiaryFacilityMappingRepository = beneficiaryFacilityMappingRepository;
		this.beneficiaryFacilityMappingMapper = beneficiaryFacilityMappingMapper;
	}

	/**
	 * Return a {@link List} of {@link BeneficiaryFacilityMappingDTO} which matches
	 * the criteria from the database
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public List<BeneficiaryFacilityMappingDTO> findByCriteria(BeneficiaryFacilityMappingCriteria criteria) {
		log.debug("find by criteria : {}", criteria);
		final Specification<BeneficiaryFacilityMapping> specification = createSpecification(criteria);
		return beneficiaryFacilityMappingMapper.toDto(beneficiaryFacilityMappingRepository.findAll(specification));
	}

	/**
	 * Return a {@link Page} of {@link BeneficiaryFacilityMappingDTO} which matches
	 * the criteria from the database
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @param page     The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<BeneficiaryFacilityMappingDTO> findByCriteria(BeneficiaryFacilityMappingCriteria criteria,
			Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<BeneficiaryFacilityMapping> specification = createSpecification(criteria);
		return beneficiaryFacilityMappingRepository.findAll(specification, page)
				.map(beneficiaryFacilityMappingMapper::toDto);
	}

	@Transactional(readOnly = true)
	public Page<BeneficiaryFacilityMapping> findByCriteriaAdvanced(BeneficiaryFacilityMappingCriteria criteria,
			Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<BeneficiaryFacilityMapping> specification = createSpecificationAdvanced(criteria);
		return beneficiaryFacilityMappingRepository.findAll(specification, page);
	}

	/**
	 * Return a {@link Page} of {@link BeneficiaryFacilityMappingDTO} which matches
	 * the criteria from the database
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @param page     The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<BeneficiaryFacilityMapping> findByCriteriaForArtBeneficiarySearch(BeneficiaryFacilityMappingCriteria criteria,
			Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<BeneficiaryFacilityMapping> specification = createSpecificationForArtBeneficiarySearch(criteria);
		return beneficiaryFacilityMappingRepository.findAll(specification, page);
	}

	
	/**
	 * Function to convert BeneficiaryFacilityMappingCriteria to a
	 * {@link Specification}
	 */
	private Specification<BeneficiaryFacilityMapping> createSpecification(BeneficiaryFacilityMappingCriteria criteria) {
		Specification<BeneficiaryFacilityMapping> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), BeneficiaryFacilityMapping_.id));
			}
			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), BeneficiaryFacilityMapping_.isActive));
			}
			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), BeneficiaryFacilityMapping_.isDelete));
			}
			if (criteria.getPid() != null) {
				specification = specification
						.and(buildStringSpecification(criteria.getPid(), BeneficiaryFacilityMapping_.pid));
			}
			if (criteria.getMappingDate() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getMappingDate(), BeneficiaryFacilityMapping_.mappingDate));
			}
			if (criteria.getRegistrationDate() != null) {
				specification = specification.and(buildRangeSpecification(criteria.getRegistrationDate(),
						BeneficiaryFacilityMapping_.registrationDate));
			}
			if (criteria.getCreatedTime() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getCreatedTime(), BeneficiaryFacilityMapping_.createdTime));
			}
			if (criteria.getModifiedTime() != null) {
				specification = specification.and(
						buildRangeSpecification(criteria.getModifiedTime(), BeneficiaryFacilityMapping_.modifiedTime));
			}
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getBeneficiaryId(),
						BeneficiaryFacilityMapping_.beneficiary, Beneficiary_.id));
			}
			if (criteria.getFacilityId() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getFacilityId(),
						BeneficiaryFacilityMapping_.facility, Facility_.id));
			}
		}
		return specification;
	}

	private Specification<BeneficiaryFacilityMapping> createSpecificationAdvanced(
			BeneficiaryFacilityMappingCriteria criteria) {
		Specification<BeneficiaryFacilityMapping> specification = Specification.where(null);
		if (criteria != null) {

			if (criteria.getFirstName() != null) {
				specification = specification.or(buildSpecification(criteria.getFirstName(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if (criteria.getMiddleName() != null) {
				specification = specification.or(buildSpecification(criteria.getMiddleName(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
			}
			if (criteria.getLastName() != null) {
				specification = specification.or(buildSpecification(criteria.getLastName(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
			}
			if (criteria.getUid() != null) {
				specification = specification.or(buildSpecification(criteria.getUid(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			
			if (criteria.getMobileNumber() != null) {
				specification = specification.or(buildSpecification(criteria.getMobileNumber(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			
			if (criteria.getPreArtNumber() != null) {
				specification = specification.or(buildSpecification(criteria.getPreArtNumber(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.preArtNumber)));
			}
			if (criteria.getArtNumber() != null) {
				specification = specification.or(buildSpecification(criteria.getArtNumber(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.artNumber)));
			}
			
			if (criteria.getPid() != null) {
				specification = specification.or(buildSpecification(criteria.getPid(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.pid)));
			}
			
			if (criteria.getTiCode() != null) {
				specification = specification.or(buildSpecification(criteria.getTiCode(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.tiCode)));
			}
			
			if (criteria.getOstCode() != null) {
				specification = specification.or(buildSpecification(criteria.getOstCode(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostCode)));
			}

			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), BeneficiaryFacilityMapping_.id));
			}
			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), BeneficiaryFacilityMapping_.isActive));
			}
			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), BeneficiaryFacilityMapping_.isDelete));
			}
			if (criteria.getFacilityId() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getFacilityId(),
						BeneficiaryFacilityMapping_.facility, Facility_.id));
			}
			if (criteria.getFacilityTypeId() != null) {
				specification = specification.and(buildSpecification(criteria.getFacilityTypeId(), root -> root
						.join(BeneficiaryFacilityMapping_.facility, JoinType.LEFT).get(Facility_.facilityTypeId)));
			}

		}
		return specification;
	}

	/**
	 * Function to convert BeneficiaryFacilityMappingCriteria to a
	 * {@link Specification}
	 */
	private Specification<BeneficiaryFacilityMapping> createSpecificationForArtBeneficiarySearch(BeneficiaryFacilityMappingCriteria criteria) {
		Specification<BeneficiaryFacilityMapping> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getFirstName() != null) {
				specification = specification.or(buildSpecification(criteria.getFirstName(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if (criteria.getMiddleName() != null) {
				specification = specification.or(buildSpecification(criteria.getMiddleName(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
			}
			if (criteria.getLastName() != null) {
				specification = specification.or(buildSpecification(criteria.getLastName(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
			}
			if (criteria.getUid() != null) {
				specification = specification.or(buildSpecification(criteria.getUid(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			if (criteria.getMobileNumber() != null) {
				specification = specification.or(buildSpecification(criteria.getMobileNumber(), root -> root
						.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			if (criteria.getPid() != null) {
				specification = specification
						.or(buildStringSpecification(criteria.getPid(), BeneficiaryFacilityMapping_.pid));
			}
			if (criteria.getId() != null) {
				specification = specification.or(buildSpecification(criteria.getId(), BeneficiaryFacilityMapping_.id));
			}
			if (criteria.getIsDelete() != null) {
				specification = specification.or(buildSpecification(criteria.getIsDelete(), BeneficiaryFacilityMapping_.isDelete));
			}
			if (criteria.getMappingDate() != null) {
				specification = specification.or(
						buildRangeSpecification(criteria.getMappingDate(), BeneficiaryFacilityMapping_.mappingDate));
			}
			if (criteria.getRegistrationDate() != null) {
				specification = specification.or(buildRangeSpecification(criteria.getRegistrationDate(), BeneficiaryFacilityMapping_.registrationDate));
			}
			if (criteria.getCreatedTime() != null) {
				specification = specification.or(
						buildRangeSpecification(criteria.getCreatedTime(), BeneficiaryFacilityMapping_.createdTime));
			}
			if (criteria.getModifiedTime() != null) {
				specification = specification.or(
						buildRangeSpecification(criteria.getModifiedTime(), BeneficiaryFacilityMapping_.modifiedTime));
			}
			if (criteria.getArtNumber() != null) {
				specification = specification.or(
						buildStringSpecification(criteria.getArtNumber(), BeneficiaryFacilityMapping_.artNumber));
			}
			if (criteria.getPreArtNumber() != null) {
				specification = specification.or(
						buildStringSpecification(criteria.getPreArtNumber(), BeneficiaryFacilityMapping_.preArtNumber));
			}
			//mandatory
			if (criteria.getFacilityId() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getFacilityId(),
						BeneficiaryFacilityMapping_.facility, Facility_.id));
			}
			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), BeneficiaryFacilityMapping_.isActive));
			}
			if (criteria.getArtCode() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getArtCode(),
						BeneficiaryFacilityMapping_.facility, Facility_.code));
			}
			if (criteria.getGenderId() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getGenderId(),
						BeneficiaryFacilityMapping_.beneficiary, Beneficiary_.genderId));
			}
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildReferringEntitySpecification(criteria.getBeneficiaryId(),
						BeneficiaryFacilityMapping_.beneficiary, Beneficiary_.id));
			}
			
		}
		return specification;
	}

}
