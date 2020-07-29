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

import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.MasterHrgSecondary_;
import gov.naco.soch.entity.MasterSubcategory_;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.entity.TypologyMaster_;
import gov.naco.soch.repository.TIBeneficiaryRepository;
import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.mapper.TIBeneficiaryMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;



/**
 * Service for executing complex queries for {@link TIBeneficiary} entities in the database.
 * The main input is a {@link TIBeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBeneficiaryDTO} or a {@link Page} of {@link TIBeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBeneficiaryAddlQueryService extends QueryService<TIBeneficiary> {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiaryAddlQueryService.class);

    private final TIBeneficiaryRepository tIBeneficiaryRepository;

    private final TIBeneficiaryMapper tIBeneficiaryMapper;

    public TIBeneficiaryAddlQueryService(TIBeneficiaryRepository tIBeneficiaryRepository, TIBeneficiaryMapper tIBeneficiaryMapper) {
        this.tIBeneficiaryRepository = tIBeneficiaryRepository;
        this.tIBeneficiaryMapper = tIBeneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link TIBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBeneficiaryDTO> findByCriteria(TIBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBeneficiary> specification = createOrSpecification(criteria);
        return tIBeneficiaryMapper.toDto(tIBeneficiaryRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBeneficiaryDTO> findByCriteria(TIBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TIBeneficiary> specification = createOrSpecification(criteria);
        return tIBeneficiaryRepository.findAll(specification, page)
            .map(tIBeneficiaryMapper::toDto);
    }
    
    /**
     * Return a {@link Page} of {@link TIBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBeneficiaryDTO> findBySearchParam(String searchParam) {
        log.debug("find by searchParam : {}", searchParam);
        final Specification<TIBeneficiary> specification = createOrSpecification(searchParam);
        List<TIBeneficiary> list = tIBeneficiaryRepository.findAll(specification);
        return tIBeneficiaryMapper.toDto(list);
    }
    
    /**
     * Return a {@link Page} of {@link TIBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBeneficiaryDTO> advanceSearch(TIBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBeneficiary> specification = createOrSpecification(criteria);
        List<TIBeneficiary> list = tIBeneficiaryRepository.findAll(specification);
        return tIBeneficiaryMapper.toDto(list);
    }


    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBeneficiaryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TIBeneficiary> specification = createSpecification(criteria);
        return tIBeneficiaryRepository.count(specification);
    }
    
    
    /**
     * Function to convert {@link TIBeneficiaryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
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
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), TIBeneficiary_.isDeleted));
            }
           
            if (criteria.getFacilityId() != null) {
           //     specification = specification.and(buildStringSpecification(criteria.getFacilityId(), TIBeneficiary_.facilityId));
            }
            if (criteria.getDateOfReg() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfReg(), TIBeneficiary_.dateOfReg));
            }
            if (criteria.getTypology() != null) {
            	specification = specification.and(buildSpecification(criteria.getTypology(),
						root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyName)));
            }
            if (criteria.getTiCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTiCode(), TIBeneficiary_.tiCode));
            }
            if (criteria.getPeCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPeCode(), TIBeneficiary_.peCode));
            }
            if (criteria.getOrwCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOrwCode(), TIBeneficiary_.orwCode));
            }
            if (criteria.getNumberOfPartners() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNumberOfPartners(), TIBeneficiary_.numberOfPartners));
            }
            if (criteria.getRegularPartners() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRegularPartners(), TIBeneficiary_.regularPartners));
            }
            if (criteria.getOtherEmploymentStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOtherEmploymentStatus(), TIBeneficiary_.otherEmploymentStatus));
            }
            if (criteria.getHrgPrimaryCategory() != null) {
            	specification = specification.and(buildSpecification(criteria.getHrgPrimaryCategory(),
						root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyId)));
            }
//            if (criteria.getHrgSecondaryCategory() != null) {
//            	specification = specification.and(buildSpecification(criteria.getTypology(),
//						root -> root.join(TIBeneficiary_.hrgSecondary).get(MasterHrgSecondary_.id)));
//            }
//         
            if (criteria.getAvgNoSexualActsUponReg() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAvgNoSexualActsUponReg(), TIBeneficiary_.avgNoSexualActsUponReg));
            }
            if (criteria.getNoYearsInSexWork() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getNoYearsInSexWork(), TIBeneficiary_.noYearsInSexWork));
            }
            if (criteria.getConsumeAlcohol() != null) {
                specification = specification.and(buildSpecification(criteria.getConsumeAlcohol(), TIBeneficiary_.consumeAlcohol));
            }
            if (criteria.getAlcoholConsDaysInWeek() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAlcoholConsDaysInWeek(), TIBeneficiary_.alcoholConsDaysInWeek));
            }
            
        }
        return specification;
    }
        
	protected Specification<TIBeneficiary> createOrSpecification(TIBeneficiaryCriteria criteria) {
		Specification<TIBeneficiary> specification = Specification.where(null);
		if (criteria != null) {
			if(criteria.getMobileNumber()!=null) {
				specification = specification.or(buildSpecification(criteria.getMobileNumber(),
					root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
			} 
			else if(criteria.getFirstName() != null) {
				specification = specification.or(buildSpecification(criteria.getFirstName(), 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
				
				specification = specification.or(buildSpecification(criteria.getFirstName(), 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
				
				specification = specification.or(buildSpecification(criteria.getFirstName(), 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
			}
			 else if(criteria.getTiCode() != null){
				specification = specification.or(buildSpecification(criteria.getTiCode(), 
						TIBeneficiary_.tiCode));
			} else if(criteria.getGender() != null){
				specification = specification.or(buildSpecification(criteria.getGender(), 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.gender)));
			} else if(criteria.getTypology() != null){
				specification = specification.and(buildSpecification(criteria.getTypology(),
						root -> root.join(TIBeneficiary_.hrgPrimary).get(TypologyMaster_.typologyName)));
			} else {
				specification = specification.or(buildSpecification(criteria.getClientStatus(), 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.clientStatus)));
			}
			
		}
		
		return specification;
	}
	
	protected Specification<TIBeneficiary> createOrSpecification(String searchParam) {
		
		Specification<TIBeneficiary> specification = Specification.where(null);
		StringFilter filter = new StringFilter();
		filter.setEquals(searchParam);
		if (searchParam != null) {
			
			specification = specification.or(buildSpecification(filter,
					root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
		
			specification = specification.or(buildSpecification(filter, 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
				
			specification = specification.or(buildSpecification(filter, 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
				
			specification = specification.or(buildSpecification(filter, 
						root -> root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
		
			specification = specification.or(buildStringSpecification(filter, 
						TIBeneficiary_.tiCode));
		
		}
		return specification;
		
		/*return (root, query, cb) -> {

			Predicate pd1 = cb.like(root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber), searchParam);
			Predicate pd2 = cb.like(root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName), searchParam);
			Predicate pd3 = cb.like(root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName), searchParam);
			Predicate pd4 = cb.like(root.join(TIBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName), searchParam);
			Predicate pd5 = cb.like(root.get(TIBeneficiary_.uid), searchParam);
			Predicate pd6 = cb.like(root.get(TIBeneficiary_.tiCode), searchParam);
			Predicate pd7 = cb.or(pd1,pd2,pd3,pd4,pd5,pd6);

			return pd7;
		};*/
		
	}
}
