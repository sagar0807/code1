package gov.naco.soch.ti.queryservice;

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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;
import gov.naco.soch.entity.MasterBeneficiaryOstStatus_;
import gov.naco.soch.entity.MasterOstClientStatus_;
import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.ti.dto.TIBenFollowUpCriteria;
import gov.naco.soch.ti.dto.readonly.OstFollowUpDto;
import gov.naco.soch.ti.entity.MasterBenSubEntity;
import gov.naco.soch.ti.entity.MasterBenSubEntity_;
import gov.naco.soch.ti.entity.OstBenSubEntity;
import gov.naco.soch.ti.entity.OstBenSubEntity_;
import gov.naco.soch.ti.entity.OstFollowUp;
import gov.naco.soch.ti.entity.OstFollowUp_;
import gov.naco.soch.ti.mapper.readonly.OstFollowUpMapper;
import gov.naco.soch.ti.repository.OstFollowUpRepository;
import io.github.jhipster.service.QueryService;

@Service
@Transactional
public class OstFollowUpQueryService extends QueryService<OstFollowUp> {

    private final OstFollowUpRepository ostFollowUpRepository;
    private final OstFollowUpMapper followUpMapper;

    public OstFollowUpQueryService(OstFollowUpRepository ostFollowUpRepository, OstFollowUpMapper followUpMapper) {
	this.ostFollowUpRepository = ostFollowUpRepository;
	this.followUpMapper = followUpMapper;
    }

    @Transactional(readOnly = true)
    public Page<OstFollowUpDto> findByCriteria(TIBenFollowUpCriteria criteria, Pageable page) {
	final Specification<OstFollowUp> specification = createSpecification(criteria);
	List<OstFollowUp> responseList = ostFollowUpRepository.findAll(specification, page).getContent();
	Map<Long, Optional<OstFollowUp>> groupedByBeneficiaryId = responseList.stream()
		.collect(Collectors.groupingBy(x -> x.getTiOstBeneficiary().getId(), LinkedHashMap::new,
			Collectors.maxBy(Comparator.comparing(OstFollowUp::getId))));
	List<OstFollowUp> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
		.collect(Collectors.toList());
	final Page<OstFollowUp> responsePage = new PageImpl<>(list);
	Page<OstFollowUpDto> response = responsePage.map(followUpMapper::toDto);
	return response;
    }

    @Transactional(readOnly = true)
    public long countByCriteria(TIBenFollowUpCriteria criteria) {
	final Specification<OstFollowUp> specification = createSpecification(criteria);
	return ostFollowUpRepository.count(specification);
    }

    protected Specification<OstFollowUp> createSpecification(TIBenFollowUpCriteria criteria) {
	Specification<OstFollowUp> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), OstFollowUp_.id));
	    }
	    if (criteria.getFollowUpDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getFollowUpDate(), OstFollowUp_.followUpDate));
	    }
	    if (criteria.getNextFollowupDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNextFollowupDate(), OstFollowUp_.nextFollowupDate));
	    }

	    if (criteria.getNoSideEffects() != null) {
		specification = specification
			.and(buildSpecification(criteria.getNoSideEffects(), OstFollowUp_.noSideEffects));
	    }

	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(OstFollowUp_.tiOstBeneficiary, JoinType.LEFT).get(OstBenSubEntity_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<OstFollowUp> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(OstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
				.join(OstBenSubEntity_.status, JoinType.LEFT).get(MasterOstClientStatus_.id)));
	    }

	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), OstFollowUp_.isEarly));
	    }

	    if (criteria.getOstStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getOstStatus(),
			root -> root.join(OstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
				.join(OstBenSubEntity_.ostStatus, JoinType.LEFT).get(MasterBeneficiaryOstStatus_.id)));
	    }

	    if (criteria.getIsDelete() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDelete(), OstFollowUp_.isDelete));
	    }
	}
	return specification;
    }

    public static Specification<OstFollowUp> findByFacilityId(final Long facilityId) {

	return new Specification<OstFollowUp>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<OstFollowUp> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<OstBenSubEntity, MasterBenSubEntity> x = root.join(OstFollowUp_.tiOstBeneficiary, JoinType.LEFT)
			.join(OstBenSubEntity_.beneficiary, JoinType.LEFT);
		SetJoin<MasterBenSubEntity, BeneficiaryFacilityMappingReadOnly> y = x
			.join(MasterBenSubEntity_.beneficiaryFacilityMappings, JoinType.LEFT);
		y.on(criteriaBuilder.equal(y.get(BeneficiaryFacilityMappingReadOnly_.isActive), true));
		Join<BeneficiaryFacilityMappingReadOnly, FacilityReadOnly> j = y
			.join(BeneficiaryFacilityMappingReadOnly_.facility, JoinType.LEFT);
		return criteriaBuilder.equal(j.get(FacilityReadOnly_.id), facilityId);

	    }
	};
    }

}
