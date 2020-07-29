package gov.naco.soch.ti.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.entity.LinkedFacilityBeneficiary_;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.repository.LinkedFacilityBeneficiaryRepository;
import gov.naco.soch.ti.dto.LinkedBeneficiaryDTO;
import gov.naco.soch.ti.dto.LinkedFacilityBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO;
import gov.naco.soch.ti.mapper.LinkBeneficiaryMapper;
import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class LinkedFacilityBeneficiaryQueryService extends QueryService<LinkedFacilityBeneficiary> {

	private final Logger log = LoggerFactory.getLogger(LinkedFacilityBeneficiaryQueryService.class);

	private final LinkedFacilityBeneficiaryRepository linkedBeneficiaryRepository;

	private final LinkBeneficiaryMapper linkBeneficiaryMapper;

	public LinkedFacilityBeneficiaryQueryService(LinkedFacilityBeneficiaryRepository linkedBeneficiaryRepository,
			LinkBeneficiaryMapper linkBeneficiaryMapper) {
		this.linkedBeneficiaryRepository = linkedBeneficiaryRepository;
		this.linkBeneficiaryMapper = linkBeneficiaryMapper;
	}

	/**
	 * Return a {@link List} of {@link TIBenScrDetailsDTO} which matches the
	 * criteria from the database.
	 * 
	 * @param criteria
	 *            The object which holds all the filters, which the entities
	 *            should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<LinkedBeneficiaryDTO> findByCriteria(LinkedFacilityBeneficiaryCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}", criteria);
		final Specification<LinkedFacilityBeneficiary> specification = createSpecification(criteria);
		return linkedBeneficiaryRepository.findAll(specification, page).map(linkBeneficiaryMapper::toDto);
	}

	protected Specification<LinkedFacilityBeneficiary> createSpecification(LinkedFacilityBeneficiaryCriteria criteria) {
		Specification<LinkedFacilityBeneficiary> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), LinkedFacilityBeneficiary_.id));
			}

			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), LinkedFacilityBeneficiary_.isActive));
			}
			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), LinkedFacilityBeneficiary_.isDelete));
			}
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(), root -> root
						.join(LinkedFacilityBeneficiary_.tiOstBeneficiary, JoinType.LEFT).get(TiOstBeneficiary_.id)));
			}

		}
		return specification;
	}

}
