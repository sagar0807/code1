package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.repository.ICTCTestResultRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.service.dto.ICTCTestResultCriteria;

import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.IctcTestResultHistoryDTO;
import gov.naco.soch.service.mapper.ICTCTestResultMapper;

/**
 * Service for executing complex queries for ICTCTestResult entities in the database.
 * The main input is a {@link ICTCTestResultCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCTestResultDTO} or a {@link Page} of {@link ICTCTestResultDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCTestResultQueryService extends QueryService<ICTCTestResult> {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultQueryService.class);

    private final ICTCTestResultRepository iCTCTestResultRepository;

    private final ICTCTestResultMapper iCTCTestResultMapper;
    
    private final LabTestSampleRepository labTestSampleRepository;
    
    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;

    public ICTCTestResultQueryService(ICTCTestResultRepository iCTCTestResultRepository, ICTCTestResultMapper iCTCTestResultMapper, 
    		LabTestSampleRepository labTestSampleRepository, BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository) {
        this.iCTCTestResultRepository = iCTCTestResultRepository;
        this.iCTCTestResultMapper = iCTCTestResultMapper;
        this.labTestSampleRepository = labTestSampleRepository;
        this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
    }

    /**
     * Return a {@link List} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCTestResultDTO> findByCriteria(ICTCTestResultCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        return iCTCTestResultMapper.toDto(iCTCTestResultRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResultDTO> findByCriteria(ICTCTestResultCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        return iCTCTestResultRepository.findAll(specification, page)
            .map(iCTCTestResultMapper::toDto);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResult> findEntitiesByCriteria(ICTCTestResultCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        return iCTCTestResultRepository.findAll(specification, page);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public IctcTestResultHistoryDTO findEntitiesByCriteriaForTRF(ICTCTestResultCriteria criteria, Pageable page, Long resultId) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        IctcTestResultHistoryDTO history = new IctcTestResultHistoryDTO();
        Page<ICTCTestResult> pageOfHistory = iCTCTestResultRepository.findAll(specification, page);
        history.setTestResults(pageOfHistory.getContent());
        if(!history.getTestResults().isEmpty()) {
        	for(ICTCTestResult result : history.getTestResults()) {
        		if(result.getId().equals(resultId)) {
        			List<LabTestSample> samples = labTestSampleRepository.findByBarcodeNumberOrderByIdDesc(result.getSample().getBarcode());
                	if(!samples.isEmpty()) {
                		history.setLabTestSample(samples.get(0));
                	}
                	break;
        		}
        	}
        	List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(history.getTestResults().get(0).getIctcBeneficiary().getBeneficiary().getId(), 4);
        	if(!motherDetails.isEmpty()) {
        		history.setMotherDetails(motherDetails.get(0).getMemberBeneficiary());
        	}
        }
        return history;
    }


    /**
     * Function to convert ICTCTestResultCriteria to a {@link Specification}
     */
    private Specification<ICTCTestResult> createSpecification(ICTCTestResultCriteria criteria) {
        Specification<ICTCTestResult> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), ICTCTestResult_.id));
            }
//            if (criteria.getTestedDate() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getTestedDate(), ICTCTestResult_.testedDate));
//            }
            if (criteria.getResultStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getResultStatus(), ICTCTestResult_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivStatus(), ICTCTestResult_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivType(), ICTCTestResult_.hivType));
            }
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportReceivedDate(), ICTCTestResult_.reportReceivedDate));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportDeliveryDate(), ICTCTestResult_.reportDeliveryDate));
            }
            if (criteria.getIsTestedForTb() != null) {
                specification = specification.and(buildSpecification(criteria.getIsTestedForTb(), ICTCTestResult_.isTestedForTb));
            }
            if (criteria.getTbTestResult() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTbTestResult(), ICTCTestResult_.tbTestResult));
            }
            if (criteria.getIsTestedForSyphilis() != null) {
                specification = specification.and(buildSpecification(criteria.getIsTestedForSyphilis(), ICTCTestResult_.isTestedForSyphilis));
            }
            if (criteria.getSyphilisTestResult() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getSyphilisTestResult(), ICTCTestResult_.syphilisTestResult));
            }
//            if (criteria.getFollowupRequired() != null) {
//                specification = specification.and(buildSpecification(criteria.getFollowupRequired(), ICTCTestResult_.followupRequired));
//            }
//            if (criteria.getIsReferedToART() != null) {
//                specification = specification.and(buildSpecification(criteria.getIsReferedToART(), ICTCTestResult_.isReferedToART));
//            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCTestResult_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCTestResult_.isDeleted));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), ICTCTestResult_.createdBy));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), ICTCTestResult_.createdTime));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), ICTCTestResult_.modifiedBy));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), ICTCTestResult_.modifiedTime));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getIctcBeneficiaryId(), ICTCTestResult_.ictcBeneficiary, ICTCBeneficiary_.id));
            }
            if (criteria.getSampleId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getSampleId(), ICTCTestResult_.sample, ICTCSampleCollection_.id));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildReferringEntitySpecification(criteria.getVisitId(), ICTCTestResult_.visit, ICTCVisit_.id));
            }
        }
        return specification;
    }

}
