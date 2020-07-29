package gov.naco.soch.ti.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly_;
import gov.naco.soch.entity.BeneficiaryReadOnly;
import gov.naco.soch.entity.BeneficiaryReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;
import gov.naco.soch.entity.MasterBeneficiaryDeleteReason_;
import gov.naco.soch.entity.MasterDestinationDuration_;
import gov.naco.soch.entity.MasterHrgSecondary_;
import gov.naco.soch.entity.MasterMobilityType_;
import gov.naco.soch.entity.MasterRegistrationDoneAt_;
import gov.naco.soch.entity.MasterStayingWith_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TiBeneficiaryReadOnly;
import gov.naco.soch.entity.TiBeneficiaryReadOnly_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.repository.TiBenRepositoryReadOnly;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenDto;
import gov.naco.soch.ti.mapper.TiBenMapper;
import io.github.jhipster.service.QueryService;

@Service
@Transactional
public class TiBenQueryService extends QueryService<TiBeneficiaryReadOnly>{
    
    private final Logger log = LoggerFactory.getLogger(TiBenQueryService.class);

    private final TransferRepository transferRepository;

    private final TiBenMapper tiBenMapper;
    
    private final TiBenRepositoryReadOnly tiBenRepo;
    
    public TiBenQueryService( TiBenMapper tiBenMapper,
	    TiBenRepositoryReadOnly tiBenRepo,TransferRepository transferRepository) {
	this.tiBenMapper = tiBenMapper;
	this.transferRepository = transferRepository;
	this.tiBenRepo=tiBenRepo;
    }
    
    @Transactional(readOnly = true)
    public Page<TiBenDto> findByCriteria(TIBeneficiaryCriteria criteria,Pageable page) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TiBeneficiaryReadOnly> specification = createSpecification(criteria);
	List<TiBenDto> benList= tiBenRepo.findAll(specification,page).map(tiBenMapper::toDto).getContent();
	if(criteria.getFacilityId()!=null)
	{
	setIsTransferred(benList,criteria.getFacilityId().getEquals());
	}
	setTransferStatus(benList);
	final Page<TiBenDto> response = new PageImpl<>(benList);
	return response;
    }
    

    private void setTransferStatus(List<TiBenDto> list) {
	list.forEach(beneficiary -> {
	    String status = transferRepository
		    .getLatestTransferStatusOfBeneficiary(beneficiary.getMasterBeneficiary().getId());
	    beneficiary.setCurrentTransferStatus(status);
	});

    }
    
    private void setIsTransferred(List<TiBenDto> list, Long facilityId) {
   	for (TiBenDto tiBen : list) {
   	    Optional<BeneficiaryFacilityMappingDto> benFac = tiBen.getMasterBeneficiary()
   		    .getBeneficiaryFacilityMappings().stream()
   		    .filter(y -> y.getFacilityId().equals(facilityId)).filter(z->z.getIsTransferred()!=null)
   		    .filter(x -> x.getIsTransferred().equals(Boolean.TRUE)).findAny();
   	    if (benFac.isPresent()) {
   		tiBen.setIsTransferred(true);
   	    }
   	}
       }
    
    protected Specification<TiBeneficiaryReadOnly> createSpecification(TIBeneficiaryCriteria criteria) {
    Specification<TiBeneficiaryReadOnly> specification = Specification.where(null);
	if (criteria != null) {
	    if (criteria.getId() != null) {
		specification = specification.and(buildSpecification(criteria.getId(), TiBeneficiaryReadOnly_.id));
	    }

	    if (criteria.getIsActive() != null) {
		specification = specification.and(buildSpecification(criteria.getIsActive(), TiBeneficiaryReadOnly_.isActive));
	    }
	    if (criteria.getIsDeleted() != null) {
		specification = specification
			.and(buildSpecification(criteria.getIsDeleted(), TiBeneficiaryReadOnly_.isDeleted));
	    }

	    if (criteria.getFacilityId() != null) {

		Specification<TiBeneficiaryReadOnly> facilitySpecification = findByFacilityId(
			criteria.getFacilityId().getEquals());
		specification = specification.and(facilitySpecification);
	    }

	    if (criteria.getDateOfReg() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getDateOfReg(), TiBeneficiaryReadOnly_.dateOfReg));
	    }
	    if (criteria.getTypology() != null) {
		specification = specification.and(buildSpecification(criteria.getTypology(),
			root -> root.join(TiBeneficiaryReadOnly_.hrgPrimary).get(TypologyMaster_.typologyName)));
	    }
	    if (criteria.getTiCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getTiCode(), TiBeneficiaryReadOnly_.tiCode));
	    }
	    if (criteria.getPeCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getPeCode(), TiBeneficiaryReadOnly_.peCode));
	    }
	    if (criteria.getOrwCode() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getOrwCode(), TiBeneficiaryReadOnly_.orwCode));
	    }
	    if (criteria.getNumberOfPartners() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getNumberOfPartners(), TiBeneficiaryReadOnly_.numberOfPartners));
	    }
	    if (criteria.getRegularPartners() != null) {
		specification = specification
			.and(buildStringSpecification(criteria.getRegularPartners(), TiBeneficiaryReadOnly_.regularPartners));
	    }
	    if (criteria.getOtherEmploymentStatus() != null) {
		specification = specification.and(buildStringSpecification(criteria.getOtherEmploymentStatus(),
			TiBeneficiaryReadOnly_.otherEmploymentStatus));
	    }
	    if (criteria.getHrgPrimaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
			root -> root.join(TiBeneficiaryReadOnly_.hrgPrimary).get(TypologyMaster_.typologyId)));
	    }
	    if (criteria.getHrgSecondaryCategory() != null) {
		specification = specification.and(buildSpecification(criteria.getHrgSecondaryCategory(),
			root -> root.join(TiBeneficiaryReadOnly_.hrgSecondary).get(MasterHrgSecondary_.id)));
	    }

	    if (criteria.getAvgNoSexualActsUponReg() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getAvgNoSexualActsUponReg(),
			TiBeneficiaryReadOnly_.avgNoSexualActsUponReg));
	    }
	    if (criteria.getNoYearsInSexWork() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getNoYearsInSexWork(), TiBeneficiaryReadOnly_.noYearsInSexWork));
	    }
	    if (criteria.getConsumeAlcohol() != null) {
		specification = specification
			.and(buildSpecification(criteria.getConsumeAlcohol(), TiBeneficiaryReadOnly_.consumeAlcohol));
	    }
	    if (criteria.getAlcoholConsDaysInWeek() != null) {
		specification = specification.and(buildRangeSpecification(criteria.getAlcoholConsDaysInWeek(),
			TiBeneficiaryReadOnly_.alcoholConsDaysInWeek));
	    }

	    if (criteria.getHotspot() != null) {
		specification = specification
			.and(buildRangeSpecification(criteria.getHotspot(), TiBeneficiaryReadOnly_.hotspot));
	    }
	    if (criteria.getDeletedReason() != null) {
		specification = specification.and(buildSpecification(criteria.getDeletedReason(),
			root -> root.join(TiBeneficiaryReadOnly_.deletedReason).get(MasterBeneficiaryDeleteReason_.name)));
	    }
	    if (criteria.getSexOtherThanSpouse() != null) {
		specification = specification
			.and(buildSpecification(criteria.getSexOtherThanSpouse(), TiBeneficiaryReadOnly_.sexOtherThanSpouse));
	    }

	    if (criteria.getTypeOfMobility() != null) {
		specification = specification.and(buildSpecification(criteria.getTypeOfMobility(),
			root -> root.join(TiBeneficiaryReadOnly_.masterMobilityType).get(MasterMobilityType_.id)));
	    }
	    if (criteria.getStayingWith() != null) {
		specification = specification.and(buildSpecification(criteria.getStayingWith(),
			root -> root.join(TiBeneficiaryReadOnly_.masterStayingWith).get(MasterStayingWith_.id)));
	    }
	    if (criteria.getDurationOfTheStays() != null) {
		specification = specification.and(buildSpecification(criteria.getDurationOfTheStays(), root -> root
			.join(TiBeneficiaryReadOnly_.masterDestinationDuration).get(MasterDestinationDuration_.id)));
	    }
	    if (criteria.getRegistrationPlace() != null) {
		specification = specification.and(buildSpecification(criteria.getRegistrationPlace(),
			root -> root.join(TiBeneficiaryReadOnly_.masterRegistrationDoneAt).get(MasterRegistrationDoneAt_.id)));
	    }
	    
	    if (criteria.getNoOfSexualActivity() != null) {
		specification = specification.and(
			buildRangeSpecification(criteria.getNoOfSexualActivity(), TiBeneficiaryReadOnly_.noOfSexualActivity));
	    }
	    if (criteria.getStatus() != null) {
		specification = specification.and(buildSpecification(criteria.getStatus(),
			root -> root.join(TiBeneficiaryReadOnly_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
	    }

	}
	return specification;
}
    public static Specification<TiBeneficiaryReadOnly> findByFacilityId(final Long facilityId) {

 	return new Specification<TiBeneficiaryReadOnly>() {

 	    private static final long serialVersionUID = 1L;

 	    @Override
 	    public Predicate toPredicate(Root<TiBeneficiaryReadOnly> root, CriteriaQuery<?> criteriaQuery,
 		    CriteriaBuilder criteriaBuilder) {

 		Join<TiBeneficiaryReadOnly, BeneficiaryReadOnly> x = root.join(TiBeneficiaryReadOnly_.beneficiary, JoinType.LEFT);
 		SetJoin<BeneficiaryReadOnly, BeneficiaryFacilityMappingReadOnly> y = x.join(BeneficiaryReadOnly_.beneficiaryFacilityMappings,
 			JoinType.LEFT);
 		//y.on(criteriaBuilder.equal(y.get(BeneficiaryFacilityMappingReadOnly_.isActive), true));
 		Join<BeneficiaryFacilityMappingReadOnly, FacilityReadOnly> j = y
 			.join(BeneficiaryFacilityMappingReadOnly_.facility, JoinType.LEFT);
 		return criteriaBuilder.equal(j.get(FacilityReadOnly_.id), facilityId);

 	    }
 	};
     }

    

}
