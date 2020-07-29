package gov.naco.soch.ti.queryservice;

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
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly_;
import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.FacilityReadOnly_;
import gov.naco.soch.entity.MasterGender_;
import gov.naco.soch.entity.MasterTiClientStatus_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.ti.dto.TIBenCounsellingCriteria;
import gov.naco.soch.ti.dto.readonly.CounsellingDto;
import gov.naco.soch.ti.entity.MasterBenSubEntity;
import gov.naco.soch.ti.entity.MasterBenSubEntity_;
import gov.naco.soch.ti.entity.TiBenSubEntity;
import gov.naco.soch.ti.entity.TiBenSubEntity_;
import gov.naco.soch.ti.entity.TiCounsellingSubEntity;
import gov.naco.soch.ti.entity.TiCounsellingSubEntity_;
import gov.naco.soch.ti.mapper.readonly.CounsellingMapper;
import gov.naco.soch.ti.repository.TiCounsellingReadOnlyRepository;
import io.github.jhipster.service.QueryService;

    @Service
    @Transactional(readOnly = true)
    public class CounsellingQueryService  extends QueryService<TiCounsellingSubEntity>{

        private final Logger log = LoggerFactory.getLogger(CounsellingQueryService.class);

        private final TiCounsellingReadOnlyRepository counsellingRepository;

        private final CounsellingMapper tIBenCounsellingMapper;

        public CounsellingQueryService(TiCounsellingReadOnlyRepository tIBenCounsellingRepository,
        	CounsellingMapper tIBenCounsellingMapper) {
    	this.counsellingRepository = tIBenCounsellingRepository;
    	this.tIBenCounsellingMapper = tIBenCounsellingMapper;
        }

      /*
         * @param criteria The object which holds all the filters, which the entities
         *                 should match.
         * @param page     The page, which should be returned.
         * @return the matching entities.
         */
        @Transactional(readOnly = true)
        public Page<CounsellingDto> findByCriteria(TIBenCounsellingCriteria criteria, Pageable page) {
    	log.debug("find by criteria : {}, page: {}", criteria, page);
    	final Specification<TiCounsellingSubEntity> specification = createSpecification(criteria);
    	return counsellingRepository.findAll(specification, page).map(tIBenCounsellingMapper::toDto);
        }

        
        /**
         * Return the number of matching entities in the database.
         * 
         * @param criteria The object which holds all the filters, which the entities
         *                 should match.
         * @return the number of matching entities.
         */
        @Transactional(readOnly = true)
        public long countByCriteria(TIBenCounsellingCriteria criteria) {
    	log.debug("count by criteria : {}", criteria);
    	final Specification<TiCounsellingSubEntity> specification = createSpecification(criteria);
    	return counsellingRepository.count(specification);
        }

        /**
         * Function to convert {@link TIBenCounsellingCriteria} to a
         * {@link Specification}
         * 
         * @param criteria The object which holds all the filters, which the entities
         *                 should match.
         * @return the matching {@link Specification} of the entity.
         */
        protected Specification<TiCounsellingSubEntity> createSpecification(TIBenCounsellingCriteria criteria) {
    	Specification<TiCounsellingSubEntity> specification = Specification.where(null);
    	if (criteria != null) {
    	    if (criteria.getId() != null) {
    		specification = specification.and(buildSpecification(criteria.getId(), TiCounsellingSubEntity_.id));
    	    }

    	    if (criteria.getDurationOfCounselling() != null) {
    		specification = specification.and(buildRangeSpecification(criteria.getDurationOfCounselling(),
    			TiCounsellingSubEntity_.durationOfCounselling));
    	    }

    	    if (criteria.getNoOfCondomsDistributed() != null) {
    		specification = specification.and(buildRangeSpecification(criteria.getNoOfCondomsDistributed(),
    			TiCounsellingSubEntity_.noOfCondomsDistributed));
    	    }
    	    if (criteria.getLastCounsellingDate() != null) {
    		specification = specification.and(buildRangeSpecification(criteria.getLastCounsellingDate(),
    			TiCounsellingSubEntity_.lastCounsellingDate));
    	    }
    	    if (criteria.getCounsellingDate() != null) {
    		specification = specification
    			.and(buildRangeSpecification(criteria.getCounsellingDate(), TiCounsellingSubEntity_.counsellingDate));
    	    }
    	    if (criteria.getNextCounsellingDate() != null) {
    		specification = specification.and(buildRangeSpecification(criteria.getNextCounsellingDate(),
    			TiCounsellingSubEntity_.nextCounsellingDate));
    	    }
    	    if (criteria.getIsActive() != null) {
    		specification = specification
    			.and(buildSpecification(criteria.getIsActive(), TiCounsellingSubEntity_.isActive));
    	    }
    	    if (criteria.getIsDelete() != null) {
    		specification = specification
    			.and(buildSpecification(criteria.getIsDelete(), TiCounsellingSubEntity_.isDelete));
    	    }
    	    if (criteria.getBeneficiaryId() != null) {
    		specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
    			root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.id)));
    	    }
    	    if (criteria.getFacilityId() != null) {

    		Specification<TiCounsellingSubEntity> facilitySpecification = findByFacilityId(
    			criteria.getFacilityId().getEquals());
    		specification = specification.and(facilitySpecification);
    	    }

    
    	    if (criteria.getGender() != null) {

    		specification = specification.and(buildSpecification(criteria.getGender(),
    			root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
    				.join(TiBenSubEntity_.beneficiary, JoinType.LEFT)
    				.join(MasterBenSubEntity_.genderId, JoinType.LEFT).get(MasterGender_.name)));
    	    }
    	    if (criteria.getTypology() != null) {

    		specification = specification.and(buildSpecification(criteria.getTypology(),
    			root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.hrgPrimary)
    				.get(TypologyMaster_.typologyName)));
    	    }
//    	    if (criteria.getBasicSearchParam() != null) {
//
//    		specification = specification.and(andSearchParam(criteria.getBasicSearchParam(), specification));
//
//    	    }

    	    if (criteria.getHrgPrimaryCategory() != null) {
    		specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
    			root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.hrgPrimary)
    				.get(TypologyMaster_.typologyId)));

    	    }

    	    if (criteria.getStatus() != null) {
    		specification = specification.and(buildSpecification(criteria.getStatus(),
    			root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
    				.join(TiBenSubEntity_.status, JoinType.LEFT).get(MasterTiClientStatus_.id)));
    	    }
    	    if (criteria.getIsEarly() != null) {
    		specification = specification.and(buildSpecification(criteria.getIsEarly(), TiCounsellingSubEntity_.isEarly));
    	    }

    	}
    	// for basic search the parameter passed could be of any type
    	/*
    	 * if (criteria.getBasicSearchParam() != null) { specification =
    	 * specification.and(searchVal(criteria.getBasicSearchParam())); }
    	 */
    	return specification;
        }

//        private Specification<TiCounsellingSubEntity> andSearchParam(StringFilter basicSearchParam,
//    	    Specification<TiCounsellingSubEntity> specification) {
//    	specification = specification.and(
//    		buildSpecification(basicSearchParam, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.get(TiBenSubEntity_.beneficiary).get(MasterBenSubEntity_.uid)));
//    	specification = specification
//    		.or(buildSpecification(basicSearchParam, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.get(TiBenSubEntity_.beneficiary).get(MasterBenSubEntity_.firstName)));
//    	specification = specification
//    		.or(buildSpecification(basicSearchParam, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.get(TiBenSubEntity_.beneficiary).get(MasterBenSubEntity_.middleName)));
//    	specification = specification
//    		.or(buildSpecification(basicSearchParam, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.get(TiBenSubEntity_.beneficiary).get(MasterBenSubEntity_.lastName)));
//    	specification = specification
//    		.or(buildSpecification(basicSearchParam, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.get(TiBenSubEntity_.beneficiary).get(MasterBenSubEntity_.mobileNumber)));
//    	specification = specification.or(buildSpecification(basicSearchParam,
//    		root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.tiCode)));
//
//    	// TODO Auto-generated method stub
//    	return specification;
//        }

//        public Specification<TIBenCounselling> searchVal(StringFilter param) {
//    	Specification<TIBenCounselling> specification = Specification.where(null);
//    	specification = specification
//    		.or(buildSpecification(param, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT).get(MasterBenSubEntity_.mobileNumber)));
//
//    	specification = specification
//    		.or(buildSpecification(param, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT).get(MasterBenSubEntity_.firstName)));
//
//    	specification = specification
//    		.or(buildSpecification(param, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT).get(MasterBenSubEntity_.middleName)));
//
//    	specification = specification
//    		.or(buildSpecification(param, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT).get(MasterBenSubEntity_.lastName)));
//
//    	specification = specification
//    		.or(buildSpecification(param, root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
//    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT).get(MasterBenSubEntity_.uid)));
//
//    	specification = specification.or(buildSpecification(param,
//    		root -> root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT).get(TiBenSubEntity_.tiCode)));
//
//    	return specification;
//        }

  
        public static Specification<TiCounsellingSubEntity> findByFacilityId(final Long facilityId) {

    	return new Specification<TiCounsellingSubEntity>() {

    	    private static final long serialVersionUID = 1L;

    	    @Override
    	    public Predicate toPredicate(Root<TiCounsellingSubEntity> root, CriteriaQuery<?> criteriaQuery,
    		    CriteriaBuilder criteriaBuilder) {

    		Join<TiBenSubEntity, MasterBenSubEntity> x = root.join(TiCounsellingSubEntity_.beneficiary, JoinType.LEFT)
    			.join(TiBenSubEntity_.beneficiary, JoinType.LEFT);
    		SetJoin<MasterBenSubEntity, BeneficiaryFacilityMappingReadOnly> y = x.join(MasterBenSubEntity_.beneficiaryFacilityMappings,
    			JoinType.LEFT);
    		y.on(criteriaBuilder.equal(y.get(BeneficiaryFacilityMappingReadOnly_.isActive), true));
    		Join<BeneficiaryFacilityMappingReadOnly, FacilityReadOnly> j = y
    			.join(BeneficiaryFacilityMappingReadOnly_.facility, JoinType.LEFT);
    		return criteriaBuilder.equal(j.get(FacilityReadOnly_.id), facilityId);

    	    }
    	};
        }
    
    

}
