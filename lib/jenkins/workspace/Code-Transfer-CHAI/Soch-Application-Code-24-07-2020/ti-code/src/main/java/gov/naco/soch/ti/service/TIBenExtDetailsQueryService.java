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

import gov.naco.soch.ti.dto.TIBenfExtDetailsDTO;
import gov.naco.soch.entity.TIBeneficiaryExtDetails;
import gov.naco.soch.entity.TIBeneficiaryExtDetails_;
import gov.naco.soch.entity.TIBeneficiary_;
import gov.naco.soch.repository.TIBeneficiaryExtDetailsRepository;
import gov.naco.soch.ti.dto.TIBenExtDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenExtDetailsDTO;
import gov.naco.soch.ti.dto.TIBenTransitListDto;
import gov.naco.soch.ti.mapper.TIBenExtDetailsMapper;
import gov.naco.soch.ti.mapper.TIBenTransitListMapper;
import io.github.jhipster.service.QueryService;


/**
 * Service for executing complex queries for {@link TIBenExtDetails} entities in the database.
 * The main input is a {@link TIBenExtDetailsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TIBenExtDetailsDTO} or a {@link Page} of {@link TIBenExtDetailsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TIBenExtDetailsQueryService extends QueryService<TIBeneficiaryExtDetails> {

    private final Logger log = LoggerFactory.getLogger(TIBenExtDetailsQueryService.class);

    private final TIBeneficiaryExtDetailsRepository tIBenExtDetailsRepository;

    private final TIBenExtDetailsMapper tIBenExtDetailsMapper;
    
    private final TIBenTransitListMapper tiBenTransitListMapper;

    public TIBenExtDetailsQueryService(TIBeneficiaryExtDetailsRepository tIBenExtDetailsRepository, TIBenExtDetailsMapper tIBenExtDetailsMapper,
    		 TIBenTransitListMapper tiBenTransitListMapper) {
        this.tIBenExtDetailsRepository = tIBenExtDetailsRepository;
        this.tIBenExtDetailsMapper = tIBenExtDetailsMapper;
        this.tiBenTransitListMapper = tiBenTransitListMapper;
    }

    /**
     * Return a {@link List} of {@link TIBenExtDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TIBenfExtDetailsDTO> findByCriteria(TIBenExtDetailsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<TIBeneficiaryExtDetails> specification = createSpecification(criteria);
        return tIBenExtDetailsMapper.toDto(tIBenExtDetailsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link TIBenExtDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenfExtDetailsDTO> findByCriteria(TIBenExtDetailsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<TIBeneficiaryExtDetails> specification = createSpecification(criteria);
        return tIBenExtDetailsRepository.findAll(specification, page)
            .map(tIBenExtDetailsMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TIBenExtDetailsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<TIBeneficiaryExtDetails> specification = createSpecification(criteria);
        return tIBenExtDetailsRepository.count(specification);
    }

    /**
     * Function to convert {@link TIBenExtDetailsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TIBeneficiaryExtDetails> createSpecification(TIBenExtDetailsCriteria criteria) {
        Specification<TIBeneficiaryExtDetails> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), TIBeneficiaryExtDetails_.id));
            }
            if (criteria.getWithinTheDistrictNoOfTimes() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWithinTheDistrictNoOfTimes(), TIBeneficiaryExtDetails_.withinTheDistrictNoOfTimes));
            }
            if (criteria.getWithinTheDistrictNoOfDays() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWithinTheDistrictNoOfDays(), TIBeneficiaryExtDetails_.withinTheDistrictNoOfDays));
            }
            if (criteria.getWithinTheStateNoOfTimes() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWithinTheStateNoOfTimes(), TIBeneficiaryExtDetails_.withinTheStateNoOfTimes));
            }
            if (criteria.getWithinTheStateNoOfDays() != null) {
                specification = specification.and(buildStringSpecification(criteria.getWithinTheStateNoOfDays(), TIBeneficiaryExtDetails_.withinTheStateNoOfDays));
            }
            if (criteria.getOutsideTheStateNoOfTimes() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOutsideTheStateNoOfTimes(), TIBeneficiaryExtDetails_.outsideTheStateNoOfTimes));
            }
            if (criteria.getOutsideTheStateNoOfDays() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOutsideTheStateNoOfDays(), TIBeneficiaryExtDetails_.outsideTheStateNoOfDays));
            }
            if (criteria.getMondayAvbl() != null) {
                specification = specification.and(buildSpecification(criteria.getMondayAvbl(), TIBeneficiaryExtDetails_.mondayAvbl));
            }
            if (criteria.getTuesdayAvbl() != null) {
                specification = specification.and(buildSpecification(criteria.getTuesdayAvbl(), TIBeneficiaryExtDetails_.tuesdayAvbl));
            }
            if (criteria.getWednesdayAvbl() != null) {
                specification = specification.and(buildSpecification(criteria.getWednesdayAvbl(), TIBeneficiaryExtDetails_.wednesdayAvbl));
            }
            if (criteria.getThursdayAvbl() != null) {
                specification = specification.and(buildSpecification(criteria.getThursdayAvbl(), TIBeneficiaryExtDetails_.thursdayAvbl));
            }
            if (criteria.getFridayAvbl() != null) {
                specification = specification.and(buildSpecification(criteria.getFridayAvbl(), TIBeneficiaryExtDetails_.fridayAvbl));
            }
            if (criteria.getSaturdayAvbl() != null) {
                specification = specification.and(buildSpecification(criteria.getSaturdayAvbl(), TIBeneficiaryExtDetails_.saturdayAvbl));
            }
            if (criteria.getReferredFacility() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferredFacility(), TIBeneficiaryExtDetails_.referredFacility));
            }
            if (criteria.getReferredTo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferredTo(), TIBeneficiaryExtDetails_.referredTo));
            }
            if (criteria.getReferralStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralStatus(), TIBeneficiaryExtDetails_.referralStatus));
            }
            if (criteria.getIsOutwardReferal() != null) {
                specification = specification.and(buildSpecification(criteria.getIsOutwardReferal(), TIBeneficiaryExtDetails_.isOutwardReferal));
            }
    
            if (criteria.getGuardianName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGuardianName(), TIBeneficiaryExtDetails_.guardianName));
            }
            if (criteria.getRelation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRelation(), TIBeneficiaryExtDetails_.relation));
            }
            if (criteria.getGuardianContactNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGuardianContactNumber(), TIBeneficiaryExtDetails_.guardianContactNumber));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(TIBeneficiaryExtDetails_.beneficiary, JoinType.LEFT).get(TIBeneficiary_.id)));
            }
        }
        return specification;
    }

	public Page<TIBenTransitListDto> transitListFindByCriteria(TIBenExtDetailsCriteria criteria, Pageable pageable) {
		
		final Specification<TIBeneficiaryExtDetails> specification = createSpecification(criteria);
        return tIBenExtDetailsRepository.findAll(specification, pageable)
            .map(tiBenTransitListMapper::toDto);
	}
}
