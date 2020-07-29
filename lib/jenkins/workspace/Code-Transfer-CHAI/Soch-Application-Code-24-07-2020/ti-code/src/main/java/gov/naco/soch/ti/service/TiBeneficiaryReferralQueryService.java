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

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping_;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiaryReferral_;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityType_;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.MasterInfectionType_;
import gov.naco.soch.entity.MasterReferralStatus_;
import gov.naco.soch.entity.TIBenScrDetails_;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.ti.dto.TiBenReferralCriteriaNew;
import gov.naco.soch.ti.dto.TiBenReferralDtoNew;
import gov.naco.soch.ti.mapper.TiBenficiaryReferralMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;

@Service
@Transactional(readOnly = true)
public class TiBeneficiaryReferralQueryService extends QueryService<BeneficiaryReferral> {
	private final Logger log = LoggerFactory.getLogger(TiBeneficiaryReferralQueryService.class);

	@Autowired
	private BeneficiaryReferralRepository beneficiaryReferralRepository;

	@Autowired
	private TiBenficiaryReferralMapper tiBenficiaryReferralMapper;

	@Transactional(readOnly = true)
	public Page<TiBenReferralDtoNew> findByCriteria(TiBenReferralCriteriaNew criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<BeneficiaryReferral> specification = createSpecification(criteria);
		return beneficiaryReferralRepository.findAll(specification, pageable).map(tiBenficiaryReferralMapper::toDto);
	}
	
	@Transactional(readOnly = true)
	public Page<TiBenReferralDtoNew> findByCriteriaSearch(TiBenReferralCriteriaNew criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<BeneficiaryReferral> specification = createSpecificationSearch(criteria);
		return beneficiaryReferralRepository.findAll(specification, pageable).map(tiBenficiaryReferralMapper::toDto);
	}

	@Transactional(readOnly = true)
	public Page<TiBenReferralDtoNew> findByCriteriaOutRefSearch(TiBenReferralCriteriaNew criteria, Pageable pageable) {
		log.debug("find by criteria : {}, page: {}", criteria, pageable);
		final Specification<BeneficiaryReferral> specification = createSpecificationOutRefSearch(criteria);
		return beneficiaryReferralRepository.findAll(specification, pageable).map(tiBenficiaryReferralMapper::toDto);
	}
	
	     @Transactional(readOnly = true)
	    public long countByCriteria(TiBenReferralCriteriaNew criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<BeneficiaryReferral> specification = createSpecification(criteria);
		return beneficiaryReferralRepository.count(specification);
	    }
	     
	     @Transactional(readOnly = true)
		    public long countByCriteriaSearch(TiBenReferralCriteriaNew criteria) {
			log.debug("count by criteria : {}", criteria);
			final Specification<BeneficiaryReferral> specification = createSpecificationSearch(criteria);
			return beneficiaryReferralRepository.count(specification);
		    }
	    
	    @Transactional(readOnly = true)
	    public long countBySearchCriteria(TiBenReferralCriteriaNew criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<BeneficiaryReferral> specification = createSpecificationOutRefSearch(criteria);
		return beneficiaryReferralRepository.count(specification);
	    }

	private Specification<BeneficiaryReferral> createSpecification(TiBenReferralCriteriaNew criteria) {
		Specification<BeneficiaryReferral> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), BeneficiaryReferral_.id));
			}
			if (criteria.getStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getStatus(),
						root -> root.join(BeneficiaryReferral_.beneficiaryReferralStatusMaster, JoinType.LEFT)
								.get(MasterReferralStatus_.name)));
			}

			if (criteria.getReferredFacility() != null) {
				specification = specification.and(buildSpecification(criteria.getReferredFacility(),
						root -> root.join(BeneficiaryReferral_.facility1, JoinType.LEFT).get(Facility_.id)));
			}
			if (criteria.getReferralType() != null) {
				specification = specification
						.and(buildSpecification(criteria.getReferralType(), BeneficiaryReferral_.referralType));
			}
			if (criteria.getReferralFacility() != null) {
				specification = specification.and(buildSpecification(criteria.getReferralFacility(),
						root -> root.join(BeneficiaryReferral_.facility2, JoinType.LEFT).get(Facility_.id)));
			}
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}
			if (criteria.getName() != null) {
				specification = specification.and(buildSpecification(criteria.getName(), root -> root
						.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if (criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getuId(),
						root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			if (criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(), root -> root
						.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}

			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
			}
			if (criteria.getParam() != null) {

				specification = specification.and(andSearchParam(criteria.getParam(), specification));

			}
		}
		return specification;
	}

	
	private Specification<BeneficiaryReferral> createSpecificationSearch(TiBenReferralCriteriaNew criteria) {
		Specification<BeneficiaryReferral> specification = Specification.where(statusCheck(criteria));
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), BeneficiaryReferral_.id));
			}
		/*	if (criteria.getStatus() != null) {
				specification = specification.and(buildSpecification(criteria.getStatus(),
						root -> root.join(BeneficiaryReferral_.beneficiaryReferralStatusMaster, JoinType.LEFT)
								.get(MasterReferralStatus_.name)));
			} */

			if (criteria.getFacilityTypeId() != null) {
				specification = specification.and(buildSpecification(criteria.getFacilityTypeId(),
						root -> root.join(BeneficiaryReferral_.facility2, JoinType.LEFT).get(Facility_.facilityType).get(FacilityType_.id)));
			}
			if (criteria.getReferralType() != null) {
				specification = specification
						.and(buildSpecification(criteria.getReferralType(), BeneficiaryReferral_.referralType));
			}
			if (criteria.getReferralFacility() != null) {
				Specification<BeneficiaryReferral> facilitySpecification = getRefFacilityList(criteria.getReferralFacility().getEquals());
				specification = specification.and(facilitySpecification);
			    	
			}
			if (criteria.getReferredfromfacilitytype() != null) {
				Specification<BeneficiaryReferral> facilitySpecification = getRefFromFacilityList(criteria.getReferredfromfacilitytype().getEquals());
				specification = specification.and(facilitySpecification);
			    	
			}
			if (criteria.getBeneficiaryId() != null) {
				specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
						root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
			}
			if (criteria.getUid() != null) {
				specification = specification.and(buildSpecification(criteria.getUid(),
						root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}		
			if (criteria.getName() != null) {
	        	specification = specification.and(andSearchName(criteria.getName(), specification));
	         }
			if (criteria.getVisitStdate() != null) {
				
				specification = specification.and(buildSpecification(criteria.getVisitStdate(), BeneficiaryReferral_.dateOfVisit));
			}
			if (criteria.getVisitENdate() != null) {
				
				specification = specification.and(buildSpecification(criteria.getVisitStdate(), BeneficiaryReferral_.dateOfVisit));
			}
			if (criteria.getDateofReferral() != null) {
				
				specification = specification.and(buildSpecification(criteria.getDateofReferral(), BeneficiaryReferral_.referDate));
			}
			if (criteria.getGender() != null) {
				
				specification = specification.and(buildSpecification(criteria.getGender(), root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).
						join(Beneficiary_.genderId,JoinType.LEFT).get(MasterGender_.name)));
			}
			if(criteria.getGenderId() != null) {
				specification = specification.and(buildSpecification(criteria.getGenderId(),
		                   root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).join(Beneficiary_.genderId,JoinType.LEFT).get(MasterGender_.id)));
			}
			if (criteria.getOstNo() != null) {
				specification = specification.and(buildSpecification(criteria.getOstNo(),
		                   root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.ostBeneficiary).get(TiOstBeneficiary_.ostNumber)));
			}
			if(criteria.getTiNo() != null) {
				specification = specification.and(buildSpecification(criteria.getTiNo(),
		                   root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.tiBeneficiary).get(TIBeneficiary_.tiCode)));
			}
			
			if (criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(), root -> root
						.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}

			if (criteria.getIsDelete() != null) {
				specification = specification
						.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
			}
			if (criteria.getParam() != null) {

				specification = specification.and(andSearchParam(criteria.getParam(), specification));

			}
		}
		return specification;
	}

	
	
	private Specification<BeneficiaryReferral> createSpecificationOutRefSearch(TiBenReferralCriteriaNew criteria) {
		Specification<BeneficiaryReferral> specification = Specification.where(null);
		if (criteria != null) {
			if (criteria.getId() != null) {
				specification = specification.and(buildSpecification(criteria.getId(), BeneficiaryReferral_.id));
			}
			if (criteria.getReferredFacility() != null) {
				specification = specification.and(buildSpecification(criteria.getReferredFacility(),
						root -> root.join(BeneficiaryReferral_.facility1, JoinType.LEFT).get(Facility_.id)));
			}
			if (criteria.getReferralType() != null) {
				specification = specification
						.and(buildSpecification(criteria.getReferralType(), BeneficiaryReferral_.referralType));
			}
			if (criteria.getReferralFacility() != null) {
				specification = specification.and(buildSpecification(criteria.getReferralFacility(),
						root -> root.join(BeneficiaryReferral_.facility2, JoinType.LEFT).get(Facility_.id)));
			}
			if (criteria.getName() != null) {
				specification = specification.and(buildSpecification(criteria.getName(), root -> root
						.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
			}
			if (criteria.getuId() != null) {
				specification = specification.and(buildSpecification(criteria.getuId(),
						root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
			}
			if (criteria.getMobileNumber() != null) {
				specification = specification.and(buildSpecification(criteria.getMobileNumber(), root -> root
						.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			}
			if (criteria.getGender() != null) {
				specification = specification.and(buildSpecification(criteria.getGender(),
					root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT)
						.join(Beneficiary_.genderId, JoinType.LEFT).get(MasterGender_.name)));
			    
			}
			
			if (criteria.getReferralFacility() != null) {

				specification = specification.and(buildSpecification(criteria.getReferralFacility(),
						root -> root.join(BeneficiaryReferral_.facility2, JoinType.LEFT).get(Facility_.id)));

			}
			if (criteria.getInfectionType() != null) {
				specification = specification.and(buildSpecification(criteria.getInfectionType(),
						root-> root.join(BeneficiaryReferral_.tiBenScrDetails, JoinType.LEFT).
						join(TIBenScrDetails_.infection,JoinType.LEFT).get(MasterInfectionType_.name)));
			}
			if (criteria.getParam() != null) {

				specification = specification.and(andSearchParam(criteria.getParam(), specification));

			}
		}
		return specification;
	}

	private Specification<BeneficiaryReferral> andSearchParam(StringFilter param,
			Specification<BeneficiaryReferral> specification) {
		specification = specification.and(buildSpecification(param,
				root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
		specification = specification.or(buildSpecification(param,
				root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
		specification = specification.or(buildSpecification(param,
				root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
		specification = specification.or(buildSpecification(param,
				root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
		specification = specification.or(buildSpecification(param,
				root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
		specification = specification
				.or(buildSpecification(param, root -> root.join(BeneficiaryReferral_.tiBenScrDetails, JoinType.LEFT)
						.join(TIBenScrDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.tiCode)));
		return specification;
	}

	 public static Specification<BeneficiaryReferral> statusCheck(TiBenReferralCriteriaNew criteria) {
			return (root, query, cb) -> {

			    Predicate pd1 = cb.equal(root.get(BeneficiaryReferral_.beneficiaryReferralStatusMaster), 1);
			    Predicate pd2 = cb.equal(root.get(BeneficiaryReferral_.beneficiaryReferralStatusMaster), 2);
			    Predicate pd3 = cb.or(pd1, pd2);

			    return pd3;
			};
		    }
	 
	 public static Specification<BeneficiaryReferral> getRefFacilityList(Long facilityType) {
			return (root, query, cb) ->{ 
				Subquery<Long> maxSubQuery = query.subquery(Long.class);
				   
			   Root<BeneficiaryReferral> benReferral = maxSubQuery.from(BeneficiaryReferral.class);
			   Join<BeneficiaryReferral,Facility> b= benReferral.join(BeneficiaryReferral_.facility2,JoinType.LEFT);
			   Subquery<Long> facilitySubQuery = query.subquery(Long.class);
			   Root<Facility> facility = facilitySubQuery.from(Facility.class);
			   facilitySubQuery.select(facility.get(Facility_.id));
			   Join<Facility,FacilityType> m= facility.join(Facility_.facilityType,JoinType.LEFT);
			   Predicate y =cb.equal(m.get(FacilityType_.id),facilityType);
				
			   facilitySubQuery.where(y);
			   
			   Predicate j=root.get(BeneficiaryReferral_.facility2).in(facilitySubQuery);
			   return cb.and(j);
			};
	   }
	 
	 public static Specification<BeneficiaryReferral> getRefFromFacilityList(Long refFrmfacility) {
		 if(refFrmfacility != 28) {
			return (root, query, cb) ->{ 
				Subquery<Long> maxSubQuery = query.subquery(Long.class);
				   
			   Root<BeneficiaryReferral> benReferral = maxSubQuery.from(BeneficiaryReferral.class);
			   Join<BeneficiaryReferral,Facility> b= benReferral.join(BeneficiaryReferral_.facility1,JoinType.LEFT);
			   Subquery<Long> facilitySubQuery = query.subquery(Long.class);
			   Root<Facility> facility = facilitySubQuery.from(Facility.class);
			   facilitySubQuery.select(facility.get(Facility_.id));
			   Join<Facility,FacilityType> m= facility.join(Facility_.facilityType,JoinType.LEFT);
			   Predicate y =cb.equal(m.get(FacilityType_.id),refFrmfacility);
			   facilitySubQuery.where(y);
			   Predicate j=root.get(BeneficiaryReferral_.facility1).in(facilitySubQuery);
			   return cb.and(j);
			};
		 }else{
			 return (root, query, cb) ->{ 
				
					Subquery<Long> maxSubQuery = query.subquery(Long.class);
					   
				   Root<BeneficiaryReferral> benReferral = maxSubQuery.from(BeneficiaryReferral.class);
				   Join<BeneficiaryReferral,Facility> b= benReferral.join(BeneficiaryReferral_.facility1,JoinType.LEFT);
				   Subquery<Long> facilitySubQuery = query.subquery(Long.class);
				   Root<Facility> facility = facilitySubQuery.from(Facility.class);
				   facilitySubQuery.select(facility.get(Facility_.id));
				   Join<Facility,FacilityType> m= facility.join(Facility_.facilityType,JoinType.LEFT);
				   Predicate a1 =cb.notEqual(m.get(FacilityType_.id),7);
				   Predicate a2 =cb.notEqual(m.get(FacilityType_.id),10);
				   Predicate a3 =cb.notEqual(m.get(FacilityType_.id),11);
				   Predicate a4 =cb.notEqual(m.get(FacilityType_.id),12);
				   Predicate a5 =cb.notEqual(m.get(FacilityType_.id),15);
				   Predicate a = cb.and(a1,a2,a3,a4,a5);
				   facilitySubQuery.where(a);
				   
				   Predicate j=root.get(BeneficiaryReferral_.facility1).in(facilitySubQuery);
				   return cb.and(j);
				};
			 
		 }
	   }
	 
	 
		
	 private Specification<BeneficiaryReferral> andSearchName(StringFilter param, Specification<BeneficiaryReferral> specification) {
		    specification = specification.and(buildSpecification(param,
	                root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
	         specification = specification.or(buildSpecification(param,
		                   root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
	         specification = specification.or(buildSpecification(param,
	                 root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
	         
			return specification;
		}
}
