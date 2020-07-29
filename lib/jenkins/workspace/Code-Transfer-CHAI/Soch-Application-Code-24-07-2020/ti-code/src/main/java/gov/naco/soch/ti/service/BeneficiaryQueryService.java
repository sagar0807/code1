package gov.naco.soch.ti.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryFacilityMapping_;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.mapper.BeneficiaryMapperUtil;
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.ti.dto.TiBenReferralCriteriaNew;
import gov.naco.soch.ti.dto.TiBenReferralDtoNew;
import gov.naco.soch.ti.mapper.BeneficiaryReflMapper;
import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class BeneficiaryQueryService extends QueryService<BeneficiaryFacilityMapping>{
	private final Logger log = LoggerFactory.getLogger(BeneficiaryQueryService.class);
	@Autowired 
	private BeneficiaryRepository beneficiaryRepository;
	@Autowired
	private BeneficiaryReflMapper beneficiaryMapper;
	
	@Autowired
	private BeneficiaryReferralRepository beneficiaryReferralRepository;
	
	@Autowired
	private BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository; 
	
	
	@Transactional(readOnly = true)
    public Page<TiBenReferralDtoNew> findByCriteria(TiBenReferralCriteriaNew criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		System.out.println("Before Specification");
		if(criteria.getuId()!=null&&criteria.getName()!=null&&criteria.getMobileNumber()!=null) {
		 if(criteria.getuId().equals(criteria.getMobileNumber())&&criteria.getName().equals(criteria.getMobileNumber())) {
			 System.out.println("Inside of if(criteria.getuId().equals(criteria.getMobileNumber())&&criteria.getName().equals(criteria.getMobileNumber()))");
			 final Specification<BeneficiaryFacilityMapping> specification = createSpecification2(criteria);
			 return beneficiaryFacilityMappingRepository.findAll(specification, pageable).map(beneficiaryMapper::toDto);
		 }
		 else {
			 System.out.println("Inside of else : if(criteria.getuId().equals(criteria.getMobileNumber())&&criteria.getName().equals(criteria.getMobileNumber()))");
			 final Specification<BeneficiaryFacilityMapping> specification = createSpecification(criteria);
			 return beneficiaryFacilityMappingRepository.findAll(specification, pageable).map(beneficiaryMapper::toDto);
		 }
		}
		System.out.println("ELSE..........................");
		 final Specification<BeneficiaryFacilityMapping> specification = createSpecification(criteria);
		 return beneficiaryFacilityMappingRepository.findAll(specification, pageable).map(beneficiaryMapper::toDto);  
	}
	
	@Transactional(readOnly = true)
    public Page<TiBenReferralDtoNew> findByStatusCriteria(TiBenReferralCriteriaNew criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		System.out.println("Before Specification");
		if(criteria.getuId()!=null&&criteria.getName()!=null&&criteria.getMobileNumber()!=null) {
		 if(criteria.getuId().equals(criteria.getMobileNumber())&&criteria.getName().equals(criteria.getMobileNumber())) {
			 System.out.println("Inside of if(criteria.getuId().equals(criteria.getMobileNumber())&&criteria.getName().equals(criteria.getMobileNumber()))");
			 final Specification<BeneficiaryFacilityMapping> specification = createSpecification(criteria);
			 return beneficiaryFacilityMappingRepository.findAll(specification, pageable).map(beneficiaryMapper::toDto);
		 }
		 else {
			 System.out.println("Inside of else : if(criteria.getuId().equals(criteria.getMobileNumber())&&criteria.getName().equals(criteria.getMobileNumber()))");
			 final Specification<BeneficiaryFacilityMapping> specification = createSpecification3(criteria);
			 return beneficiaryFacilityMappingRepository.findAll(specification, pageable).map(beneficiaryMapper::toDto);
		 }
		}
		System.out.println("ELSE..........................");
		 final Specification<BeneficiaryFacilityMapping> specification = createSpecification3(criteria);
		 return beneficiaryFacilityMappingRepository.findAll(specification, pageable).map(beneficiaryMapper::toDto);  
	}
	
	 @Transactional(readOnly = true)
	    public long countByCriteria(TiBenReferralCriteriaNew criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<BeneficiaryFacilityMapping> specification = createSpecification(criteria);
		return beneficiaryFacilityMappingRepository.count(specification);
	    }
	    
	 @Transactional(readOnly = true)
	    public long countByStatusCriteria(TiBenReferralCriteriaNew criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<BeneficiaryFacilityMapping> specification = createSpecification3(criteria);
		return beneficiaryFacilityMappingRepository.count(specification);
	    }
	    
	private Specification<BeneficiaryFacilityMapping> createSpecification2(TiBenReferralCriteriaNew criteria) {
		Specification<BeneficiaryFacilityMapping> specification = Specification.where(null);
		if(criteria != null) {
           if(criteria.getRegisteredFacility() != null) {
        	   specification = specification.or(buildSpecification(criteria.getRegisteredFacility(),
	                   root -> root.join(BeneficiaryFacilityMapping_.facility, JoinType.LEFT).get(Facility_.id)));
			}
			if(criteria.getBeneficiaryId() != null) {
				 specification = specification.or(buildSpecification(criteria.getBeneficiaryId(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}
			if(criteria.getName() != null) {
				specification = specification.or(buildSpecification(criteria.getName(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if(criteria.getuId() != null) {
				specification = specification.or(buildSpecification(criteria.getuId(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			if(criteria.getMobileNumber() != null) {
				specification = specification.or(buildSpecification(criteria.getMobileNumber(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			
		}
		return specification;
	}
	
	

private Specification<BeneficiaryFacilityMapping> createSpecification(TiBenReferralCriteriaNew criteria) {
		
		Specification<BeneficiaryFacilityMapping> specification = Specification.where(null);
		if(criteria != null) {
           if(criteria.getRegisteredFacility() != null) {
        	   specification = specification.and(buildSpecification(criteria.getRegisteredFacility(),
	                   root -> root.join(BeneficiaryFacilityMapping_.facility, JoinType.LEFT).get(Facility_.id)));
			}
			if(criteria.getBeneficiaryId() != null) {
				 specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}
			if(criteria.getName() != null) {
				specification = specification.and(buildSpecification(criteria.getName(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if(criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			if(criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getUid(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			/*if(criteria.getPid() != null) {
				specification = specification.and(buildSpecification(criteria.getPid(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.pid)));
			}*/
			if(criteria.getTiNo() != null) {
				specification = specification.and(buildSpecification(criteria.getTiNo(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.tiBeneficiary).get(TIBeneficiary_.tiCode)));
			}
			if(criteria.getOstNo() != null) {
				specification = specification.and(buildSpecification(criteria.getOstNo(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.ostNumber)));
			}
			/*if(criteria.getArtNo() != null) {
				specification = specification.and(buildSpecification(criteria.getArtNo(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.artBeneficiaryDetails).get(ArtBeneficiaryDetail_.artNumber)));
			}*/
			if(criteria.getVisitStDt() != null) {
				specification = specification.and(buildSpecification(criteria.getVisitStDt(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.registrationDate)));
			}
			if(criteria.getVisitEnDt() != null) {
				specification = specification.and(buildSpecification(criteria.getVisitEnDt(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.registrationDate)));
			}
			if(criteria.getGenderId() != null) {
				specification = specification.and(buildSpecification(criteria.getGenderId(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).join(Beneficiary_.genderId,JoinType.LEFT).get(MasterGender_.id)));
			}
			
		}
		return specification;
	}
	
	
	
private Specification<BeneficiaryFacilityMapping> createSpecification3(TiBenReferralCriteriaNew criteria) {
		
		Specification<BeneficiaryFacilityMapping> specification = Specification.where(null);
		if(criteria != null) {
           if(criteria.getRegisteredFacility() != null) {
        	   specification = specification.and(buildSpecification(criteria.getRegisteredFacility(),
	                   root -> root.join(BeneficiaryFacilityMapping_.facility, JoinType.LEFT).get(Facility_.id)));
			}
			if(criteria.getBeneficiaryId() != null) {
				 specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}
			if(criteria.getName() != null) {
				specification = specification.and(buildSpecification(criteria.getName(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if(criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			if(criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getUid(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			/*if(criteria.getPid() != null) {
				specification = specification.and(buildSpecification(criteria.getPid(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.pid)));
			}*/
			if(criteria.getTiNo() != null) {
				specification = specification.and(buildSpecification(criteria.getTiNo(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.tiBeneficiary).get(TIBeneficiary_.tiCode)));
			}
			if(criteria.getOstNo() != null) {
				specification = specification.and(buildSpecification(criteria.getOstNo(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.ostNumber)));
			}
			/*if(criteria.getArtNo() != null) {
				specification = specification.and(buildSpecification(criteria.getArtNo(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.artBeneficiaryDetails).get(ArtBeneficiaryDetail_.artNumber)));
			}*/
			if(criteria.getVisitStDt() != null) {
				specification = specification.and(buildSpecification(criteria.getVisitStDt(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.registrationDate)));
			}
			if(criteria.getVisitEnDt() != null) {
				specification = specification.and(buildSpecification(criteria.getVisitEnDt(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.registrationDate)));
			}
			if(criteria.getGenderId() != null) {
				specification = specification.and(buildSpecification(criteria.getGenderId(),
		                   root -> root.join(BeneficiaryFacilityMapping_.beneficiary, JoinType.LEFT).join(Beneficiary_.genderId,JoinType.LEFT).get(MasterGender_.id)));
			}
			
		}
		return specification;
	}
	public BeneficiaryDto findByGlobalBeneficiaryId(Long beneficiaryId, Long facilityId) {
		System.out.println("BenficiaryId :"+beneficiaryId);
		BeneficiaryDto beneficiaryDto = BeneficiaryMapperUtil.mapToBeneficiary(beneficiaryRepository.findById(beneficiaryId).get());
		try {
	    BeneficiaryReferral beneficiaryReferral = beneficiaryReferralRepository.findByInwardReferral(beneficiaryId,facilityId);
	    if(beneficiaryReferral!=null) {
		BeneficiaryReferralDto beneficiaryReferralDto = new BeneficiaryReferralDto();
		beneficiaryReferralDto.setId(beneficiaryReferral.getId());
		beneficiaryReferralDto.setBeneficiaryId(beneficiaryId);
		beneficiaryReferralDto.setDateOfVisit(beneficiaryReferral.getDateOfVisit());
		beneficiaryReferralDto.setReferredFromFacility(beneficiaryReferral.getFacility1().getId());
		beneficiaryReferralDto.setReferredToFacility(beneficiaryReferral.getFacility2().getId());
		beneficiaryReferralDto.setReferralReason(beneficiaryReferral.getReferralReason());
		if(beneficiaryReferral.getFacility1().getFacilityType() != null)
		beneficiaryReferralDto.setFacilityFromType(beneficiaryReferral.getFacility1().getFacilityType().getId());
		beneficiaryReferralDto.setStatus(beneficiaryReferral.getBeneficiaryReferralStatusMaster().getName());
		beneficiaryReferralDto.setReferDate(beneficiaryReferral.getReferDate());
		Set<BeneficiaryReferralDto> referrals = new HashSet<>();
		referrals.add(beneficiaryReferralDto);
		beneficiaryDto.setBeneficiaryReferral(referrals);
	     }
		}
		catch (Exception e) {
			System.out.println("Exception :"+e.getMessage());
		}
	    return beneficiaryDto;
	}
}
