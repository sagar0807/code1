package gov.naco.soch.shared.service;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryFamilyDetail;
import gov.naco.soch.entity.BeneficiaryFamilyDetail_;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.repository.BeneficiaryFamilyDetailRepository;
import gov.naco.soch.shared.dto.PartnerLinkageCriteria;
import gov.naco.soch.dto.PartnerLinkageDTO;
import gov.naco.soch.shared.mapper.PartnerLinkageMapper;
import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class PartnerLinkageQueryService extends QueryService<BeneficiaryFamilyDetail> {

	private final Logger log = LoggerFactory.getLogger(PartnerLinkageQueryService.class);

	private final BeneficiaryFamilyDetailRepository beneficiaryFamilyDetailRepository;

	private final PartnerLinkageMapper partnerLinkageMapper;

	public PartnerLinkageQueryService(BeneficiaryFamilyDetailRepository beneficiaryFamilyDetailRepository,
			PartnerLinkageMapper partnerLinkageMapper) {
		this.beneficiaryFamilyDetailRepository = beneficiaryFamilyDetailRepository;
		this.partnerLinkageMapper = partnerLinkageMapper;
	}

	public Page<PartnerLinkageDTO> findByCriteria(PartnerLinkageCriteria criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<BeneficiaryFamilyDetail> specification = createSpecification(criteria);
		return beneficiaryFamilyDetailRepository.findAll(specification, pageable).map(partnerLinkageMapper::toDto);

	}

	private Specification<BeneficiaryFamilyDetail> createSpecification(PartnerLinkageCriteria criteria) {

		Specification<BeneficiaryFamilyDetail> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), BeneficiaryFamilyDetail_.id));
			}

			if (criteria.getIsActive() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsActive(), BeneficiaryFamilyDetail_.isActive));
			}
			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), BeneficiaryFamilyDetail_.isDelete));
			}
			if (criteria.getFamilyUid() != null) {
				specification = specification
						.and(buildStringSpecification(criteria.getFamilyUid(), BeneficiaryFamilyDetail_.familyUid));
			}

			if (criteria.getPartnerBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getPartnerBeneficiaryId(), root -> root
						.join(BeneficiaryFamilyDetail_.partnerBeneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}

			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(BeneficiaryFamilyDetail_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}

		}
		return specification;

	}
}
