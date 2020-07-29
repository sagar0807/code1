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

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.MasterBeneficiaryDeleteReason_;
import gov.naco.soch.entity.MasterClientStatus_;
import gov.naco.soch.entity.MasterDestinationDuration_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.MasterHrgSecondary_;
import gov.naco.soch.entity.MasterMobilityType_;
import gov.naco.soch.entity.MasterRegistrationDoneAt_;
import gov.naco.soch.entity.MasterStayingWith_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.repository.TIBeneficiaryRepository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO_Initial;
import gov.naco.soch.ti.dto.TIBenRVAssessmentDTO_Initial;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO_Initial;
import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenDto;
import gov.naco.soch.ti.mapper.TIBeneficiaryMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link TIBeneficiary} entities in
 * the database. The main input is a {@link TIBeneficiaryCriteria} which gets
 * converted to {@link Specification}, in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBeneficiaryDTO} or a {@link Page} of
 * {@link TIBeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBeneficiaryQueryService extends QueryService<TIBeneficiary> {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiaryQueryService.class);

    private final TIBeneficiaryRepository tIBeneficiaryRepository;

    private final TIBeneficiaryMapper tIBeneficiaryMapper;

    private final TransferRepository transferRepository;

    public TIBeneficiaryQueryService(TIBeneficiaryRepository tIBeneficiaryRepository,
	    TIBeneficiaryMapper tIBeneficiaryMapper, TransferRepository transferRepository) {
	this.tIBeneficiaryRepository = tIBeneficiaryRepository;
	this.tIBeneficiaryMapper = tIBeneficiaryMapper;
	this.transferRepository = transferRepository;
    }

    /**
     * Return a {@link List} of {@link TIBeneficiaryDTO} which matches the criteria
     * from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBeneficiaryDTO> findByCriteria(TIBeneficiaryCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TIBeneficiary> specification = createSpecification(criteria);
	return tIBeneficiaryMapper.toDto(tIBeneficiaryRepository.findAll(specification));
    }

    @Transactional(readOnly = true)
    public Page<TIBeneficiaryDTO> findByCriteria(TIBeneficiaryCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBeneficiary> specification = createSpecification(criteria);
	List<TIBeneficiaryDTO> list = tIBeneficiaryRepository.findAll(specification, page)
		.map(tIBeneficiaryMapper::toDto).getContent();
	setLatestTransferStatus(list);
	final Page<TIBeneficiaryDTO> response = new PageImpl<>(list);
	return response;

    }

    private void setTransferStatus(List<TiBenDto> list) {
	list.forEach(beneficiary -> {
	    String status = transferRepository
		    .getLatestTransferStatusOfBeneficiary(beneficiary.getMasterBeneficiary().getId());
	    beneficiary.setCurrentTransferStatus(status);
	});

    }

    /**
     * Return a {@link Page} of {@link TIBeneficiaryDTO} which matches the criteria
     * from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBeneficiaryDTO> searchByCriteria(TIBeneficiaryCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}, page: {}", criteria, page);
	final Specification<TIBeneficiary> specification = createSearchSpecification(criteria);
	List<TIBeneficiaryDTO> list = tIBeneficiaryRepository.findAll(specification, page)
		.map(tIBeneficiaryMapper::toDto).getContent();
	if (criteria.getFacilityId() != null) {
	    setIsTransferred(list, criteria.getFacilityId().getEquals());
	}
	setLatestTransferStatus(list);
	List<TIBeneficiaryDTO> sortedList = list.stream().map(x -> {
	    Set<TIBenRVAssessmentDTO_Initial> sortedSet = x.getTiAssessment().stream()
		    .sorted(Comparator.comparing(TIBenRVAssessmentDTO_Initial::getId).reversed())
		    .collect(Collectors.toCollection(LinkedHashSet::new));
	    x.getTiAssessment().clear();
	    x.setTiAssessment(sortedSet);

	    Set<TIBenCounsellingDTO_Initial> sortedCounsSet = x.getTiCounselling().stream()
		    .sorted(Comparator.comparing(TIBenCounsellingDTO_Initial::getId).reversed())
		    .collect(Collectors.toCollection(LinkedHashSet::new));
	    x.getTiCounselling().clear();
	    x.setTiCounselling(sortedCounsSet);

	    Set<TIBenScrDetailsDTO_Initial> sortedScrSet = x.getTiScreening().stream()
		    .sorted(Comparator.comparing(TIBenScrDetailsDTO_Initial::getId).reversed())
		    .collect(Collectors.toCollection(LinkedHashSet::new));
	    x.getTiScreening().clear();
	    x.setTiScreening(sortedScrSet);

	    return x;
	}).collect(Collectors.toList());
	final Page<TIBeneficiaryDTO> response = new PageImpl<>(sortedList);
	return response;

    }

    private void setIsTransferred(List<TIBeneficiaryDTO> list, Long facilityId) {
	for (TIBeneficiaryDTO tiBen : list) {
	    Optional<BeneficiaryFacilityMappingDto> benFac = tiBen.getMasterBeneficiary()
		    .getBeneficiaryFacilityMappings().stream().filter(y -> y.getFacilityId().equals(facilityId))
		    .filter(z -> z.getIsTransferred() != null).filter(x -> x.getIsTransferred().equals(Boolean.TRUE))
		    .findAny();
	    if (benFac.isPresent()) {
		tiBen.setIsTransferred(true);
	    }
	}
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBeneficiaryCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBeneficiary> specification = createSpecification(criteria);
	return tIBeneficiaryRepository.count(specification);
    }

    @Transactional(readOnly = true)
    public long countBySearchCriteria(TIBeneficiaryCriteria criteria) {
	log.debug("count by criteria : {}", criteria);
	final Specification<TIBeneficiary> specification = createSearchSpecification(criteria);
	return tIBeneficiaryRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBeneficiaryCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */

    protected Specification<TIBeneficiary> createSearchSpecification(TIBeneficiaryCriteria criteria) {
	Specification<TIBeneficiary> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getParam() != null) {
		specification = specification.or(buildSpecification(criteria.getParam(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
		specification = specification.or(buildSpecification(criteria.getParam(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
		specification = specification.or(buildSpecification(criteria.getParam(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
		specification = specification.or(buildSpecification(criteria.getParam(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
		specification = specification.or(buildSpecification(criteria.getParam(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
		specification = specification.or(buildSpecification(criteria.getParam(), TIBeneficiary_.tiCode));
	    }
	    if (criteria.getFirstName() != null) {
		specification = specification.and(buildSpecification(criteria.getFirstName(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
		specification = specification.or(buildSpecification(criteria.getFirstName(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.middleName)));
		specification = specification.or(buildSpecification(criteria.getFirstName(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.lastName)));
	    }

	    if (criteria.getUid() != null) {
		specification = specification.and(buildSpecification(criteria.getUid(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
	    }
	    if (criteria.getMobileNumber() != null) {
		specification = specification.and(buildSpecification(criteria.getMobileNumber(),
			root -> root.join(TIBeneficiary_.beneficiary).get(Beneficiary_.mobileNumber)));
	    }

	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIBeneficiary_.id));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), TIBeneficiary_.isActive));
	    }
	    if (criteria.getIsDeleted() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDeleted(), TIBeneficiary_.isDeleted));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TIBeneficiary> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getDateOfReg() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfReg(), TIBeneficiary_.dateOfReg));
	    }

	    if (criteria.getTypology() != null) {
		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyName)));
	    }

	    if (criteria.getTiCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getTiCode(), TIBeneficiary_.tiCode));
	    }
	    if (criteria.getPeCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getPeCode(), TIBeneficiary_.peCode));
	    }
	    if (criteria.getOrwCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getOrwCode(), TIBeneficiary_.orwCode));
	    }
	    if (criteria.getNumberOfPartners() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getNumberOfPartners(), TIBeneficiary_.numberOfPartners));
	    }
	    if (criteria.getRegularPartners() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getRegularPartners(), TIBeneficiary_.regularPartners));
	    }
	    if (criteria.getOtherEmploymentStatus() != null) {
		specification = specification.and(buildStringSpecification(criteria.getOtherEmploymentStatus(),
			TIBeneficiary_.otherEmploymentStatus));
	    }
	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyId)));
	    }
	    if (criteria.getHrgSecondaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgSecondaryCategory(),
			root -> root.join(TIBeneficiary_.hrgSecondary).get(MasterHrgSecondary_.id)));
	    }

	    if (criteria.getAvgNoSexualActsUponReg() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getAvgNoSexualActsUponReg(),
			TIBeneficiary_.avgNoSexualActsUponReg));
	    }
	    if (criteria.getNoYearsInSexWork() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNoYearsInSexWork(), TIBeneficiary_.noYearsInSexWork));
	    }
	    if (criteria.getConsumeAlcohol() != null) {
		specification = specification
			.and(buildSpecification(criteria.getConsumeAlcohol(), TIBeneficiary_.consumeAlcohol));
	    }
	    if (criteria.getAlcoholConsDaysInWeek() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getAlcoholConsDaysInWeek(),
			TIBeneficiary_.alcoholConsDaysInWeek));
	    }

	    if (criteria.getHotspot() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getHotspot(), TIBeneficiary_.hotspot));
	    }
	    if (criteria.getDeletedReason() != null) {
		specification = specification.and(buildSpecification(criteria.getDeletedReason(),
			root -> root.join(TIBeneficiary_.deletedReason).get(MasterBeneficiaryDeleteReason_.name)));
	    }
	    if (criteria.getSexOtherThanSpouse() != null) {
		specification = specification
			.and(buildSpecification(criteria.getSexOtherThanSpouse(), TIBeneficiary_.sexOtherThanSpouse));
	    }

	    if (criteria.getTypeOfMobility() != null) {
		specification = specification.and(buildSpecification(criteria.getTypeOfMobility(),
			root -> root.join(TIBeneficiary_.masterMobilityType).get(MasterMobilityType_.id)));
	    }
	    if (criteria.getStayingWith() != null) {
		specification = specification.and(buildSpecification(criteria.getStayingWith(),
			root -> root.join(TIBeneficiary_.masterStayingWith).get(MasterStayingWith_.id)));
	    }
	    if (criteria.getDurationOfTheStays() != null) {
		specification = specification.and(buildSpecification(criteria.getDurationOfTheStays(), root -> root
			.join(TIBeneficiary_.masterDestinationDuration).get(MasterDestinationDuration_.id)));
	    }
	    if (criteria.getRegistrationPlace() != null) {
		specification = specification.and(buildSpecification(criteria.getRegistrationPlace(),
			root -> root.join(TIBeneficiary_.masterRegistrationDoneAt).get(MasterRegistrationDoneAt_.id)));
	    }
	    if (criteria.getNoOfSexualActivity() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getNoOfSexualActivity(), TIBeneficiary_.noOfSexualActivity));
	    }

	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }

	    if (criteria.getGender() != null) {
		specification = specification.and(buildSpecification(criteria.getGender(),
			root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.genderId, JoinType.LEFT).get(MasterGender_.name)));
	    }
	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));
	    }
	    if (criteria.getVisitStartDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getVisitStartDate(), TIBeneficiary_.dateOfReg));
	    }

	    if (criteria.getVisitEndDate() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getVisitEndDate(), TIBeneficiary_.dateOfReg));

	    }
	}
	return specification;
    }

    /**
     * Function to convert {@link TIBeneficiaryCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBeneficiary> createSpecification(TIBeneficiaryCriteria criteria) {
	Specification<TIBeneficiary> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TIBeneficiary_.id));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), TIBeneficiary_.isActive));
	    }
	    if (criteria.getIsDeleted() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDeleted(), TIBeneficiary_.isDeleted));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TIBeneficiary> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getDateOfReg() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfReg(), TIBeneficiary_.dateOfReg));
	    }
	    if (criteria.getTypology() != null) {
		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyName)));
	    }
	    if (criteria.getTiCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getTiCode(), TIBeneficiary_.tiCode));
	    }
	    if (criteria.getPeCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getPeCode(), TIBeneficiary_.peCode));
	    }
	    if (criteria.getOrwCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getOrwCode(), TIBeneficiary_.orwCode));
	    }
	    if (criteria.getNumberOfPartners() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getNumberOfPartners(), TIBeneficiary_.numberOfPartners));
	    }
	    if (criteria.getRegularPartners() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getRegularPartners(), TIBeneficiary_.regularPartners));
	    }
	    if (criteria.getOtherEmploymentStatus() != null) {
		specification = specification.and(buildStringSpecification(criteria.getOtherEmploymentStatus(),
			TIBeneficiary_.otherEmploymentStatus));
	    }
	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyId)));
	    }
	    if (criteria.getHrgSecondaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgSecondaryCategory(),
			root -> root.join(TIBeneficiary_.hrgSecondary).get(MasterHrgSecondary_.id)));
	    }

	    if (criteria.getAvgNoSexualActsUponReg() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getAvgNoSexualActsUponReg(),
			TIBeneficiary_.avgNoSexualActsUponReg));
	    }
	    if (criteria.getNoYearsInSexWork() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNoYearsInSexWork(), TIBeneficiary_.noYearsInSexWork));
	    }
	    if (criteria.getConsumeAlcohol() != null) {
		specification = specification
			.and(buildSpecification(criteria.getConsumeAlcohol(), TIBeneficiary_.consumeAlcohol));
	    }
	    if (criteria.getAlcoholConsDaysInWeek() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getAlcoholConsDaysInWeek(),
			TIBeneficiary_.alcoholConsDaysInWeek));
	    }

	    if (criteria.getHotspot() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getHotspot(), TIBeneficiary_.hotspot));
	    }
	    if (criteria.getDeletedReason() != null) {
		specification = specification.and(buildSpecification(criteria.getDeletedReason(),
			root -> root.join(TIBeneficiary_.deletedReason).get(MasterBeneficiaryDeleteReason_.name)));
	    }
	    if (criteria.getSexOtherThanSpouse() != null) {
		specification = specification
			.and(buildSpecification(criteria.getSexOtherThanSpouse(), TIBeneficiary_.sexOtherThanSpouse));
	    }

	    if (criteria.getTypeOfMobility() != null) {
		specification = specification.and(buildSpecification(criteria.getTypeOfMobility(),
			root -> root.join(TIBeneficiary_.masterMobilityType).get(MasterMobilityType_.id)));
	    }
	    if (criteria.getStayingWith() != null) {
		specification = specification.and(buildSpecification(criteria.getStayingWith(),
			root -> root.join(TIBeneficiary_.masterStayingWith).get(MasterStayingWith_.id)));
	    }
	    if (criteria.getDurationOfTheStays() != null) {
		specification = specification.and(buildSpecification(criteria.getDurationOfTheStays(), root -> root
			.join(TIBeneficiary_.masterDestinationDuration).get(MasterDestinationDuration_.id)));
	    }
	    if (criteria.getRegistrationPlace() != null) {
		specification = specification.and(buildSpecification(criteria.getRegistrationPlace(),
			root -> root.join(TIBeneficiary_.masterRegistrationDoneAt).get(MasterRegistrationDoneAt_.id)));
	    }

	    if (criteria.getClientStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getClientStatus(),
			root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT)
				.join(Beneficiary_.masterClientStatus, JoinType.LEFT).get(MasterClientStatus_.name)));
	    }
	    if (criteria.getNoOfSexualActivity() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getNoOfSexualActivity(), TIBeneficiary_.noOfSexualActivity));
	    }
	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(TIBeneficiary_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }

	}
	return specification;
    }

    private void setLatestTransferStatus(List<TIBeneficiaryDTO> list) {

	list.forEach(beneficiary -> {
	    String status = transferRepository
		    .getLatestTransferStatusOfBeneficiary(beneficiary.getMasterBeneficiary().getId());
	    beneficiary.setCurrentTransferStatus(status);
	});
    }

    public static Specification<TIBeneficiary> findByFacilityId(final Long facilityId) {

	return new Specification<TIBeneficiary>() {

	    private static final long serialVersionUID = 1L;

	    @Override
	    public Predicate toPredicate(Root<TIBeneficiary> root, CriteriaQuery<?> criteriaQuery,
		    CriteriaBuilder criteriaBuilder) {

		Join<TIBeneficiary, Beneficiary> x = root.join(TIBeneficiary_.beneficiary, JoinType.LEFT);
		SetJoin<Beneficiary, BeneficiaryFacilityMapping> y = x.join(Beneficiary_.beneficiaryFacilityMappings,
			JoinType.LEFT);
		Join<BeneficiaryFacilityMapping, Facility> j = y
			.join(gov.naco.soch.entity.BeneficiaryFacilityMapping_.facility, JoinType.LEFT);
		return criteriaBuilder.equal(j.get(Facility_.id), facilityId);

	    }
	};
    }
}
