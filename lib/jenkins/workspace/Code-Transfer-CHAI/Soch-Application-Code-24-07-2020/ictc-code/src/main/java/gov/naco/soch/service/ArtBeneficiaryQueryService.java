package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// for static metamodels
import gov.naco.soch.domain.ArtBeneficiary;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.service.dto.ArtBeneficiaryCriteria;
import gov.naco.soch.service.dto.ArtBeneficiaryDTO;
import gov.naco.soch.service.mapper.ArtBeneficiaryMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for ArtBeneficiary entities in the database.
 * The main input is a {@link ArtBeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ArtBeneficiaryDTO} or a {@link Page} of {@link ArtBeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ArtBeneficiaryQueryService extends QueryService<ArtBeneficiary> {

    private final Logger log = LoggerFactory.getLogger(ArtBeneficiaryQueryService.class);

    private final ArtBeneficiaryRepository artBeneficiaryRepository;

    private final ArtBeneficiaryMapper artBeneficiaryMapper;

    public ArtBeneficiaryQueryService(ArtBeneficiaryRepository artBeneficiaryRepository, ArtBeneficiaryMapper artBeneficiaryMapper) {
        this.artBeneficiaryRepository = artBeneficiaryRepository;
        this.artBeneficiaryMapper = artBeneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link ArtBeneficiaryDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ArtBeneficiaryDTO> findByCriteria(ArtBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ArtBeneficiary> specification = createSpecification(criteria);
        return artBeneficiaryMapper.toDto(artBeneficiaryRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ArtBeneficiaryDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ArtBeneficiary> findByCriteria(ArtBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ArtBeneficiary> specification = createSpecification(criteria);
        return artBeneficiaryRepository.findAll(specification, page);
    }

    /**
     * Function to convert ArtBeneficiaryCriteria to a {@link Specification}
     */
    private Specification<ArtBeneficiary> createSpecification(ArtBeneficiaryCriteria criteria) {
        Specification<ArtBeneficiary> specification = Specification.where(null);
//        if (criteria != null) {
//            if (criteria.getId() != null) {
//                specification = specification.or(buildSpecification(criteria.getId(), ArtBeneficiary_.id));
//            }
//            if (criteria.getArtEligibilityDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getArtEligibilityDate(), ArtBeneficiary_.artEligibilityDate));
//            }
//            if (criteria.getArtRegistrationDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getArtRegistrationDate(), ArtBeneficiary_.artRegistrationDate));
//            }
//            if (criteria.getArtStartDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getArtStartDate(), ArtBeneficiary_.artStartDate));
//            }
//            if (criteria.getIsActive() != null) {
//                specification = specification.or(buildSpecification(criteria.getIsActive(), ArtBeneficiary_.isActive));
//            }
//            if (criteria.getIsDelete() != null) {
//                specification = specification.or(buildSpecification(criteria.getIsDelete(), ArtBeneficiary_.isDelete));
//            }
//            if (criteria.getLacLinked() != null) {
//                specification = specification.or(buildSpecification(criteria.getLacLinked(), ArtBeneficiary_.lacLinked));
//            }
//            if (criteria.getLinkageInstituteName() != null) {
//                specification = specification.or(buildStringSpecification(criteria.getLinkageInstituteName(), ArtBeneficiary_.linkageInstituteName));
//            }
//            //if (criteria.getPreviousClinic() != null) {
//            //   specification = specification.or(buildStringSpecification(criteria.getPreviousClinic(), ArtBeneficiary_.previousClinic));
//            //}
//            if (criteria.getRegistrationDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getRegistrationDate(), ArtBeneficiary_.registrationDate));
//            }
//            if (criteria.getVisitRegisterId() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getVisitRegisterId(), ArtBeneficiary_.visitRegisterId));
//            }
//            if (criteria.getArtBeneficiaryStatusId() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getArtBeneficiaryStatusId(), ArtBeneficiary_.artBeneficiaryStatusId));
//            }
//            if (criteria.getHivRiskFactorId() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getHivRiskFactorId(), ArtBeneficiary_.hivRiskFactorId));
//            }
//            if (criteria.getFacilityId() != null) {
//                specification = specification.or(buildReferringEntitySpecification(criteria.getFacilityId(), ArtBeneficiary_.facility, Facility_.id));
//            }
//            if (criteria.getBeneficiaryId() != null) {
//                specification = specification.or(buildReferringEntitySpecification(criteria.getBeneficiaryId(), ArtBeneficiary_.beneficiary, Beneficiary_.id));
//            }
//            if (criteria.getFirstName() != null) {
//                specification = specification.or(buildSpecification(criteria.getFirstName(),
//                    root -> root.join(ArtBeneficiary_.beneficiary, JoinType.INNER).get(Beneficiary_.firstName)));
//            }
//            if (criteria.getMiddleName() != null) {
//                specification = specification.or(buildSpecification(criteria.getMiddleName(),
//                    root -> root.join(ArtBeneficiary_.beneficiary, JoinType.INNER).get(Beneficiary_.middleName)));
//            }
//            if (criteria.getLastName() != null) {
//                specification = specification.or(buildSpecification(criteria.getLastName(),
//                    root -> root.join(ArtBeneficiary_.beneficiary, JoinType.INNER).get(Beneficiary_.lastName)));
//            }
//            if (criteria.getMobileNumber() != null) {
//                specification = specification.or(buildSpecification(criteria.getMobileNumber(),
//                    root -> root.join(ArtBeneficiary_.beneficiary, JoinType.INNER).get(Beneficiary_.mobileNumber)));
//            }
//            if (criteria.getArtNumber() != null) {
//                specification = specification.or(buildSpecification(criteria.getArtNumber(),
//                    root -> root.join(ArtBeneficiary_.beneficiary, JoinType.INNER).get(Beneficiary_.artNumber)));
//            }
//            if (criteria.getPreArtNumber() != null) {
//                specification = specification.or(buildSpecification(criteria.getPreArtNumber(),
//                    root -> root.join(ArtBeneficiary_.beneficiary, JoinType.INNER).get(Beneficiary_.preArtNumber)));
//            }
//            if (criteria.getArtCentreCode() != null) {
//                specification = specification.and(buildSpecification(criteria.getArtCentreCode(),
//                    root -> root.join(ArtBeneficiary_.facility, JoinType.INNER).get(Facility_.code)));
//            }
//        }
        return specification;
    }

}
