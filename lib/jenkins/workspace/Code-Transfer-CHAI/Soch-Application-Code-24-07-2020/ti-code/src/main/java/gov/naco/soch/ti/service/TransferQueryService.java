package gov.naco.soch.ti.service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryReferral_;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityType_;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.entity.Transfer_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.TiBenTransferCriteria;
import gov.naco.soch.ti.dto.TiBenTransferDto;
import gov.naco.soch.ti.mapper.TiTransferMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;
@Service
@Transactional(readOnly = true)
public class TransferQueryService extends QueryService<Transfer> {
	private final Logger log = LoggerFactory.getLogger(TransferQueryService.class);
	@Autowired
	private TransferRepository transferRepository;
	@Autowired
	private TiTransferMapper tiTransferMapper;
	public Page<TiBenTransferDto> findByCriteria(TiBenTransferCriteria criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<Transfer> specification = createSpecification(criteria);
		return transferRepository.findAll(specification,pageable).map(tiTransferMapper::toDto);
	}
	public Page<TiBenTransferDto> findByCriteriainRefSearch(TiBenTransferCriteria criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<Transfer> specification = createSpecificationSearch(criteria);
		return transferRepository.findAll(specification,pageable).map(tiTransferMapper::toDto);
	}
	public Page<TiBenTransferDto> findByStatusCriteria(TiBenTransferCriteria criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<Transfer> specification = createStatusSpecification(criteria);
		return transferRepository.findAll(specification,pageable).map(tiTransferMapper::toDto);
	}
	   @Transactional(readOnly = true)
	    public long countByCriteria(TiBenTransferCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<Transfer> specification = createSpecification(criteria);
		return transferRepository.count(specification);
	    }
	    
	   
	    @Transactional(readOnly = true)
	    public long countBySearchCriteria(TiBenTransferCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<Transfer> specification = createSpecificationSearch(criteria);
		return transferRepository.count(specification);
	    }
	
	    @Transactional(readOnly = true)
	    public long countByStatusCriteria(TiBenTransferCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<Transfer> specification = createStatusSpecification(criteria);
		return transferRepository.count(specification);
	    }
	    
	
	private Specification<Transfer> createSpecificationSearch(TiBenTransferCriteria criteria) {
		Specification<Transfer> specification = Specification.where(statusCheck(criteria));
		if(criteria != null) {
			if(criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(),Transfer_.id));
			}
			
			/*if(criteria.getStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getStatus(),Transfer_.transferStatus));
			}*/
			if (criteria.getTransferredFromFacility() != null) {
	            specification = specification.and(buildSpecification(criteria.getTransferredFromFacility(),
		                   root -> root.join(Transfer_.facilityFrom, JoinType.LEFT).get(Facility_.id)));
		     }
			if (criteria.getFacilityTypeId() != null) {
				specification = specification.and(buildSpecification(criteria.getFacilityTypeId(),
						root -> root.join(Transfer_.facilityTo, JoinType.LEFT).join(Facility_.facilityType).get(FacilityType_.id)));
			}
			if (criteria.getTransferredToFacility() != null) {
				Specification<Transfer> facilitySpecification = getTransFacilityList(criteria.getTransferredToFacility().getEquals());
				specification = specification.and(facilitySpecification);
	         }
			
			if (criteria.getBeneficiaryId() != null) {
	            specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
	                   root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
	         }
			if (criteria.getGender() != null) {
				
				specification = specification.and(buildSpecification(criteria.getGender(),
						root -> root.join(Transfer_.beneficiary, JoinType.LEFT).
						join(Beneficiary_.genderId,JoinType.LEFT).get(MasterGender_.name)));
			}
			if (criteria.getTypology() != null) {
			
				specification = specification.and(buildSpecification(criteria.getTypology(),
						root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyId)));
			}
			if (criteria.getuId() != null) {
	            specification = specification.and(buildSpecification(criteria.getuId(),
	                   root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
	         }
			if (criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getUid(),
						root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}	
			if (criteria.getName() != null) {
	        	specification = specification.and(andSearchName(criteria.getName(), specification));
	         }
			if (criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(), root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			if(criteria.getTiNo() != null) {
				specification = specification.and(buildSpecification(criteria.getTiNo(),
		                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));
			}
			if (criteria.getOstNo() != null) {
				specification = specification.and(buildSpecification(criteria.getOstNo(),
		                   root -> root.join(Transfer_.beneficiary, JoinType.LEFT).join(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.ostNumber)));
			}
			if (criteria.getVisitStdate() != null) {
				
				specification = specification.and(buildSpecification(criteria.getVisitStdate(), Transfer_.initiationDate));
			}
			if (criteria.getVisitENdate() != null) {
				
				specification = specification.and(buildSpecification(criteria.getVisitStdate(), Transfer_.reportingDate));
			}
			if(criteria.getGenderId() != null) {
				specification = specification.and(buildSpecification(criteria.getGenderId(),
		                   root -> root.join(Transfer_.beneficiary, JoinType.LEFT).join(Beneficiary_.genderId,JoinType.LEFT).get(MasterGender_.id)));
			}
		
			
		}
		return specification;
	}
	

    public static Specification<Transfer> statusCheck(TiBenTransferCriteria criteria) {
	return (root, query, cb) -> {

	    Predicate pd1 = cb.equal(root.get(Transfer_.transferStatus), "Transferred");
	    Predicate pd2 = cb.equal(root.get(Transfer_.transferStatus), "Pending");
	    Predicate pd3 = cb.or(pd1, pd2);

	    return pd3;
	};
    }
	

	
	private Specification<Transfer> andSearchParam(StringFilter param, Specification<Transfer> specification) {
		 specification = specification.and(buildSpecification(param,root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
	     specification = specification.or(buildSpecification(param,root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
	     specification = specification.or(buildSpecification(param,root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
	     specification = specification.or(buildSpecification(param,root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
	     specification = specification.or(buildSpecification(param,root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));	   
	     specification = specification.or(buildSpecification(param,root -> root.get(Transfer_.tiCode)));
		
		return specification;
	}
	private Specification<Transfer> createSpecification(TiBenTransferCriteria criteria) {
		Specification<Transfer> specification = Specification.where(null);
		if(criteria != null) {
			if(criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(),Transfer_.id));
			}
			
			if(criteria.getStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getStatus(),Transfer_.transferStatus));
			}
			if (criteria.getTransferredFromFacility() != null) {
	            specification = specification.and(buildSpecification(criteria.getTransferredFromFacility(),
	                   root -> root.join(Transfer_.facilityFrom, JoinType.LEFT).get(Facility_.id)));
	         }
			if (criteria.getTransferredToFacility() != null) {
	            specification = specification.and(buildSpecification(criteria.getTransferredToFacility(),
	                   root -> root.join(Transfer_.facilityTo, JoinType.LEFT).get(Facility_.id)));
	         }
			if (criteria.getName() != null) {
	            specification = specification.and(buildSpecification(criteria.getName(),
	                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
	         }
			if (criteria.getBeneficiaryId() != null) {
	            specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
	                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.id)));
	         }
			if (criteria.getuId() != null) {
	            specification = specification.and(buildSpecification(criteria.getuId(),
	                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
	         }
			if (criteria.getParam() != null) {

				specification = specification.and(andSearchParam(criteria.getParam(), specification));

			}
			
		}
		return specification;
	}
	private Specification<Transfer> createStatusSpecification(TiBenTransferCriteria criteria) {
		Specification<Transfer> specification = Specification.where(null);
		if(criteria != null) {
			if(criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(),Transfer_.id));
			}
			
			if(criteria.getStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getStatus(),Transfer_.transferStatus));
			}
			if (criteria.getTransferredFromFacility() != null) {
	            specification = specification.and(buildSpecification(criteria.getTransferredFromFacility(),
	                   root -> root.join(Transfer_.facilityFrom, JoinType.LEFT).get(Facility_.id)));
	         }
			if (criteria.getTransferredToFacility() != null) {
	            specification = specification.and(buildSpecification(criteria.getTransferredToFacility(),
	                   root -> root.join(Transfer_.facilityTo, JoinType.LEFT).get(Facility_.id)));
	         }
			if (criteria.getName() != null) {
	            specification = specification.and(buildSpecification(criteria.getName(),
	                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.firstName)));
	         }
			if (criteria.getBeneficiaryId() != null) {
	            specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
	                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.id)));
	         }
			if (criteria.getuId() != null) {
	            specification = specification.and(buildSpecification(criteria.getuId(),
	                   root -> root.join(Transfer_.tiBeneficiary, JoinType.LEFT).get(TIBeneficiary_.beneficiary).get(Beneficiary_.uid)));
	         }
			
		}
		return specification;
	}
	
	 public static Specification<Transfer> getTransFacilityList(Long facilityType) {
			return (root, query, cb) ->{ 
				Subquery<Long> maxSubQuery = query.subquery(Long.class);
				   
			   Root<Transfer> transf = maxSubQuery.from(Transfer.class);
			   Join<Transfer,Facility> b= transf.join(Transfer_.facilityTo,JoinType.LEFT);
			   Subquery<Long> facilitySubQuery = query.subquery(Long.class);
			   Root<Facility> facility = facilitySubQuery.from(Facility.class);
			   facilitySubQuery.select(facility.get(Facility_.id));
			   Join<Facility,FacilityType> m= facility.join(Facility_.facilityType,JoinType.LEFT);
			   Predicate y =cb.equal(m.get(FacilityType_.id),facilityType);
				
			   facilitySubQuery.where(y);
			   
			   Predicate j=root.get(Transfer_.facilityTo).in(facilitySubQuery);
			   return cb.and(j);
			};
	   }
	 

	 private Specification<Transfer> andSearchName(StringFilter param, Specification<Transfer> specification) {
		    specification = specification.and(buildSpecification(param,
	                root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
	         specification = specification.or(buildSpecification(param,
		                   root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
	         specification = specification.or(buildSpecification(param,
	                 root -> root.join(Transfer_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
	         
			return specification;
		}
}
