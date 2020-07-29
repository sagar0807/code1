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
import gov.naco.soch.domain.ICTCBeneficiaryVisit;
import gov.naco.soch.domain.ICTCBeneficiaryVisit_;
import gov.naco.soch.repository.ICTCBeneficiaryVisitRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryVisitMapper;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ICTCBeneficiaryVisit} entities in the database.
 * The main input is a {@link ICTCBeneficiaryVisitCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCBeneficiaryVisitDTO} or a {@link Page} of {@link ICTCBeneficiaryVisitDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCBeneficiaryVisitQueryService extends QueryService<ICTCBeneficiaryVisit> {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryVisitQueryService.class);

    private final ICTCBeneficiaryVisitRepository iCTCBeneficiaryVisitRepository;

    private final ICTCBeneficiaryVisitMapper iCTCBeneficiaryVisitMapper;

    public ICTCBeneficiaryVisitQueryService(ICTCBeneficiaryVisitRepository iCTCBeneficiaryVisitRepository, ICTCBeneficiaryVisitMapper iCTCBeneficiaryVisitMapper) {
        this.iCTCBeneficiaryVisitRepository = iCTCBeneficiaryVisitRepository;
        this.iCTCBeneficiaryVisitMapper = iCTCBeneficiaryVisitMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCBeneficiaryVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBeneficiaryVisitDTO> findByCriteria(ICTCBeneficiaryVisitCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiaryVisit> specification = createSpecification(criteria);
        return iCTCBeneficiaryVisitMapper.toDto(iCTCBeneficiaryVisitRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCBeneficiaryVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryVisitDTO> findByCriteria(ICTCBeneficiaryVisitCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryVisit> specification = createSpecification(criteria);
        return iCTCBeneficiaryVisitRepository.findAll(specification, page)
            .map(iCTCBeneficiaryVisitMapper::toDto);
    }
    
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryVisitDTO> findByCriteriaBasic(ICTCBeneficiaryVisitCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryVisit> specification = createBasicSearchSpecification(criteria);
        return iCTCBeneficiaryVisitRepository.findAll(specification, page)
            .map(iCTCBeneficiaryVisitMapper::toDto);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCBeneficiaryVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryVisitDTO> searchByCriteria(ICTCBeneficiaryVisitCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryVisit> specification = createSearchSpecification(criteria);
        return iCTCBeneficiaryVisitRepository.findAll(specification, page)
            .map(iCTCBeneficiaryVisitMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCBeneficiaryVisitCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCBeneficiaryVisit> specification = createSpecification(criteria);
        return iCTCBeneficiaryVisitRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCBeneficiaryVisitCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCBeneficiaryVisit> createSpecification(ICTCBeneficiaryVisitCriteria criteria) {
        Specification<ICTCBeneficiaryVisit> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCBeneficiaryVisit_.id));
            }
            if (criteria.getUid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryVisit_.uid));
            }
            if (criteria.getPid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryVisit_.pid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryVisit_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryVisit_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryVisit_.lastName));
            }
            if (criteria.getOccupation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOccupation(), ICTCBeneficiaryVisit_.occupation));
            }
            if (criteria.getMaritalStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMaritalStatus(), ICTCBeneficiaryVisit_.maritalStatus));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGender(), ICTCBeneficiaryVisit_.gender));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfBirth(), ICTCBeneficiaryVisit_.dateOfBirth));
            }
            if (criteria.getAge() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAge(), ICTCBeneficiaryVisit_.age));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryVisit_.mobileNumber));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInfantBreastFed(), ICTCBeneficiaryVisit_.infantBreastFed));
            }
            if (criteria.getInfantMotherArtNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantMotherArtNo(), ICTCBeneficiaryVisit_.infantMotherArtNo));
            }
            if (criteria.getInfantMotherArtId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInfantMotherArtId(), ICTCBeneficiaryVisit_.infantMotherArtId));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiaryVisit_.infantCode));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCBeneficiaryVisit_.category));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitDate(), ICTCBeneficiaryVisit_.visitDate));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.and(buildSpecification(criteria.getIsPregnant(), ICTCBeneficiaryVisit_.isPregnant));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitId(), ICTCBeneficiaryVisit_.visitId));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTestType(), ICTCBeneficiaryVisit_.testType));
            }
//            if (criteria.getTestedDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getTestedDate(), ICTCBeneficiaryVisit_.testedDate));
//            }
            if (criteria.getResultStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getResultStatus(), ICTCBeneficiaryVisit_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivStatus(), ICTCBeneficiaryVisit_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivType(), ICTCBeneficiaryVisit_.hivType));
            }
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportReceivedDate(), ICTCBeneficiaryVisit_.reportReceivedDate));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportDeliveryDate(), ICTCBeneficiaryVisit_.reportDeliveryDate));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBarcode(), ICTCBeneficiaryVisit_.barcode));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCBeneficiaryVisit_.beneficiaryId));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantMotherFirstName(), ICTCBeneficiaryVisit_.infantMotherFirstName));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantMotherLastName(), ICTCBeneficiaryVisit_.infantMotherLastName));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryVisit_.beneficiaryStatus));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiaryVisit_.isConsentDocumented));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryVisit_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryVisit_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryVisit_.genderId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiaryVisit_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiaryVisit_.isDeleted));
            }
        }
        return specification;
    }
    
    /**
     * Function to convert {@link ICTCBeneficiaryVisitCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCBeneficiaryVisit> createSearchSpecification(ICTCBeneficiaryVisitCriteria criteria) {
        Specification<ICTCBeneficiaryVisit> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getId(), ICTCBeneficiaryVisit_.id));
            }
            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryVisit_.pid));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryVisit_.uid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryVisit_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryVisit_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryVisit_.lastName));
            }
            if (criteria.getOccupation() != null) {
                specification = specification.or(buildStringSpecification(criteria.getOccupation(), ICTCBeneficiaryVisit_.occupation));
            }
            if (criteria.getMaritalStatus() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMaritalStatus(), ICTCBeneficiaryVisit_.maritalStatus));
            }
            if (criteria.getGender() != null) {
                specification = specification.or(buildStringSpecification(criteria.getGender(), ICTCBeneficiaryVisit_.gender));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getDateOfBirth(), ICTCBeneficiaryVisit_.dateOfBirth));
            }
            if (criteria.getAge() != null) {
                specification = specification.or(buildStringSpecification(criteria.getAge(), ICTCBeneficiaryVisit_.age));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryVisit_.mobileNumber));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getInfantBreastFed(), ICTCBeneficiaryVisit_.infantBreastFed));
            }
            if (criteria.getInfantMotherArtNo() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherArtNo(), ICTCBeneficiaryVisit_.infantMotherArtNo));
            }
            if (criteria.getInfantMotherArtId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getInfantMotherArtId(), ICTCBeneficiaryVisit_.infantMotherArtId));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiaryVisit_.infantCode));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitDate(), ICTCBeneficiaryVisit_.visitDate));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.or(buildSpecification(criteria.getIsPregnant(), ICTCBeneficiaryVisit_.isPregnant));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitId(), ICTCBeneficiaryVisit_.visitId));
            }
            if (criteria.getTestType() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getTestType(), ICTCBeneficiaryVisit_.testType));
            }
//            if (criteria.getTestedDate() != null) {
//                specification = specification.or(buildRangeSpecification(criteria.getTestedDate(), ICTCBeneficiaryVisit_.testedDate));
//            }
            if (criteria.getResultStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getResultStatus(), ICTCBeneficiaryVisit_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getHivStatus(), ICTCBeneficiaryVisit_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getHivType(), ICTCBeneficiaryVisit_.hivType));
            }
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getReportReceivedDate(), ICTCBeneficiaryVisit_.reportReceivedDate));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getReportDeliveryDate(), ICTCBeneficiaryVisit_.reportDeliveryDate));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getBarcode(), ICTCBeneficiaryVisit_.barcode));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCBeneficiaryVisit_.beneficiaryId));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherFirstName(), ICTCBeneficiaryVisit_.infantMotherFirstName));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherLastName(), ICTCBeneficiaryVisit_.infantMotherLastName));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryVisit_.beneficiaryStatus));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiaryVisit_.isConsentDocumented));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBatchId(), ICTCBeneficiaryVisit_.batchId));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.or(buildStringSpecification(criteria.getConsignmentId(), ICTCBeneficiaryVisit_.consignmentId));
            }
            if (criteria.getLabId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getLabId(), ICTCBeneficiaryVisit_.labId));
            }
            if (criteria.getLabName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLabName(), ICTCBeneficiaryVisit_.labName));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLabCode(), ICTCBeneficiaryVisit_.labCode));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCBeneficiaryVisit_.category));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryVisit_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryVisit_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryVisit_.genderId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiaryVisit_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiaryVisit_.isDeleted));
            }
        }
        return specification;
    }
    
    protected Specification<ICTCBeneficiaryVisit> createBasicSearchSpecification(ICTCBeneficiaryVisitCriteria criteria) {
        Specification<ICTCBeneficiaryVisit> specification = Specification.where(null);
        if (criteria != null) {
         
            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryVisit_.pid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryVisit_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryVisit_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryVisit_.lastName));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryVisit_.mobileNumber));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiaryVisit_.infantCode));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherFirstName(), ICTCBeneficiaryVisit_.infantMotherFirstName));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherLastName(), ICTCBeneficiaryVisit_.infantMotherLastName));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryVisit_.uid));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCategory(), ICTCBeneficiaryVisit_.category));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryVisit_.beneficiaryStatus));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiaryVisit_.isConsentDocumented));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryVisit_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryVisit_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryVisit_.genderId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiaryVisit_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiaryVisit_.isDeleted));
            }
            if (criteria.getDeletedReason() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDeletedReason(), ICTCBeneficiaryVisit_.deletedReason));
            }
            if (criteria.getDeletedReasonComment() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDeletedReasonComment(), ICTCBeneficiaryVisit_.deletedReasonComment));
            }
        }
        return specification;
    }
}
