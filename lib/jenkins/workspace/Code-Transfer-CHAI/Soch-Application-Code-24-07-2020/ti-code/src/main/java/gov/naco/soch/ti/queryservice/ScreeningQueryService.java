package gov.naco.soch.ti.queryservice;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;
import gov.naco.soch.entity.MasterHivScreeningStatus_;
import gov.naco.soch.entity.MasterInfectionType_;
import gov.naco.soch.entity.MasterSyphilisStatus_;
import gov.naco.soch.entity.MasterTbScreeningStatus_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.ti.dto.TIBenScrDetailsCriteria;
import gov.naco.soch.ti.dto.readonly.ScreeningDto;
import gov.naco.soch.ti.entity.MasterBenSubEntity;
import gov.naco.soch.ti.entity.MasterBenSubEntity_;
import gov.naco.soch.ti.entity.Screening;
import gov.naco.soch.ti.entity.Screening_;
import gov.naco.soch.ti.entity.TiBenSubEntity;
import gov.naco.soch.ti.entity.TiBenSubEntity_;
import gov.naco.soch.ti.mapper.readonly.ScreeningMapper;
import gov.naco.soch.ti.repository.ScreeningRepository;
import io.github.jhipster.service.QueryService;

@Service
public class ScreeningQueryService extends QueryService<Screening> {

    private final ScreeningRepository screeningRepo;
    private final ScreeningMapper screeningMapper;

    public ScreeningQueryService(ScreeningRepository screeningRepo, ScreeningMapper screeningMapper) {
	this.screeningRepo = screeningRepo;
	this.screeningMapper = screeningMapper;
    }

    @Transactional(readOnly = true)
    public Page<ScreeningDto> findByCriteria(TIBenScrDetailsCriteria criteria, Pageable page) {
	final Specification<Screening> specification = createSpecification(criteria);
	return screeningRepo.findAll(specification, page).map(screeningMapper::toDto);
    }

    @Transactional(readOnly = true)
    public long countByCriteria(TIBenScrDetailsCriteria criteria) {
	final Specification<Screening> specification = createSpecification(criteria);
	return screeningRepo.count(specification);
    }

    protected Specification<Screening> createSpecification(TIBenScrDetailsCriteria criteria) {
	Specification<Screening> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), Screening_.id));
	    }
	    if (criteria.getInfection() != null) {
		specification = specification.and(buildSpecification(criteria.getInfection(),
			root -> root.join(Screening_.infection, JoinType.LEFT).get(MasterInfectionType_.name)));
	    }
	    if (criteria.getDateOfScreening() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfScreening(), Screening_.dateOfScreening));
	    }
	    if (criteria.getNextDateOfScreening() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getNextDateOfScreening(), Screening_.nextDateOfScreening));
	    }
	    if (criteria.getScreeningStatusHiv() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(), root -> root
			.join(Screening_.screeningStatusHiv, JoinType.LEFT).get(MasterHivScreeningStatus_.name)));
	    }
	    if (criteria.getScreeningStatusSyphilis() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(), root -> root
			.join(Screening_.screeningStatusSyphilis, JoinType.LEFT).get(MasterSyphilisStatus_.name)));
	    }
	    if (criteria.getProlongedCoughGreaterThanThreeWeeks() != null) {
		specification = specification.and(buildSpecification(criteria.getProlongedCoughGreaterThanThreeWeeks(),
			Screening_.prolongedCoughGreaterThanThreeWeeks));
	    }
	    if (criteria.getPresenceOfSweatGreaterThanThreeWeeks() != null) {
		specification = specification.and(buildSpecification(criteria.getPresenceOfSweatGreaterThanThreeWeeks(),
			Screening_.presenceOfSweatGreaterThanThreeWeeks));
	    }
	    if (criteria.getWeightlossGreaterThan3kgInLastFourWeeks() != null) {
		specification = specification
			.and(buildSpecification(criteria.getWeightlossGreaterThan3kgInLastFourWeeks(),
				Screening_.weightlossGreaterThan3kgInLastFourWeeks));
	    }
	    if (criteria.getFeverGreaterThanThreeWeeks() != null) {
		specification = specification.and(buildSpecification(criteria.getFeverGreaterThanThreeWeeks(),
			Screening_.feverGreaterThanThreeWeeks));
	    }

	    if (criteria.getTbStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getScreeningStatusHiv(),
			root -> root.join(Screening_.tbStatus, JoinType.LEFT).get(MasterTbScreeningStatus_.name)));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), Screening_.isActive));
	    }
	    if (criteria.getIsDeleted() != null) {
		specification = specification.and(buildSpecification(criteria.getIsDeleted(), Screening_.isDeleted));
	    }
	    if (criteria.getBeneficiaryId() != null) {
		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
			root -> root.join(Screening_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.id)));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<Screening> facilitySpecification = findByFacilityId(criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getTypology() != null) {
		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(Screening_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.hrgPrimary)
				.get(TypologyMaster_.typologyName)));

	    }

	    if (criteria.getIsEarly() != null) {
		specification = specification.and(buildSpecification(criteria.getIsEarly(), Screening_.isEarly));
	    }

	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(Screening_.beneficiary, JoinType.LEFT)
				.join(TiBenSubEntity_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }
	}
	return specification;
    }

    public static Specification<Screening> findByFacilityId(final Long facilityId) {

	return new Specification<Screening>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<Screening> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TiBenSubEntity, MasterBenSubEntity> x = root.join(Screening_.beneficiary, JoinType.LEFT)
			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT);
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
