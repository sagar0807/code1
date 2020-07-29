package gov.naco.soch.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.domain.LabTestSample;
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.repository.ICTCTestResultRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.dto.ICTCTestDetails;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;
import gov.naco.soch.service.mapper.ICTCTestResultMapper;
import gov.naco.soch.service.mapper.ICTCVisitMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
/**
 * Service Implementation for managing ICTCTestResult.
 */
@Service
@Transactional
public class ICTCTestResultServiceImpl implements ICTCTestResultService {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultServiceImpl.class);

    private final ICTCTestResultRepository iCTCTestResultRepository;

    private final ICTCTestResultMapper iCTCTestResultMapper;
    
    private final ICTCBeneficiaryMapper ictcBeneficiaryMapper;
    
    private final ICTCSampleCollectionMapper ictcSampleCollectionMapper;
        
    private final ICTCVisitMapper ictcVisitMapper;
    
    private final LabTestSampleRepository labTestSampleRepository;
    
    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;
    
    public ICTCTestResultServiceImpl(ICTCTestResultRepository iCTCTestResultRepository, ICTCTestResultMapper iCTCTestResultMapper,
    		ICTCBeneficiaryMapper ictcBeneficiaryMapper, ICTCSampleCollectionMapper ictcSampleCollectionMapper,
    		ICTCVisitMapper ictcVisitMapper, LabTestSampleRepository labTestSampleRepository, BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository) {
        this.iCTCTestResultRepository = iCTCTestResultRepository;
        this.iCTCTestResultMapper = iCTCTestResultMapper;
        this.ictcBeneficiaryMapper = ictcBeneficiaryMapper;
        this.ictcSampleCollectionMapper = ictcSampleCollectionMapper;
        this.ictcVisitMapper = ictcVisitMapper;
        this.labTestSampleRepository = labTestSampleRepository;
        this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
        
    }

    /**
     * Save a iCTCTestResult.
     *
     * @param iCTCTestResultDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ICTCTestResultDTO save(ICTCTestResultDTO iCTCTestResultDTO) {
        log.debug("Request to save ICTCTestResult : {}", iCTCTestResultDTO);
        ICTCTestResult iCTCTestResult = iCTCTestResultMapper.toEntity(iCTCTestResultDTO);
        iCTCTestResult = iCTCTestResultRepository.save(iCTCTestResult);
        return iCTCTestResultMapper.toDto(iCTCTestResult);
    }

    /**
     * Get all the iCTCTestResults.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCTestResultDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCTestResults");
        return iCTCTestResultRepository.findAll(pageable)
            .map(iCTCTestResultMapper::toDto);
    }


    /**
     * Get one iCTCTestResult by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCTestResultDTO> findOne(Long id) {
        log.debug("Request to get ICTCTestResult : {}", id);
        return iCTCTestResultRepository.findById(id)
            .map(iCTCTestResultMapper::toDto);
    }
    
    /**
     * Get one iCTCTestResult by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Optional<ICTCTestResult> find(Long id) {
        log.debug("Request to get ICTCTestResult : {}", id);
        return iCTCTestResultRepository.findById(id);
    }

    /**
     * Get one iCTCTestResult by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public ICTCTestResultDTO getOne(Long id) {
        log.debug("Request to get ICTCTestResult : {}", id);
        return iCTCTestResultMapper.toDto(iCTCTestResultRepository.getOne(id));
    }
    
    /**
     * Delete the iCTCTestResult by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCTestResult : {}", id);
        iCTCTestResultRepository.deleteById(id);
    }
    
    /**
     * Get Test result details
     *
     * @param id the id of the entity
     */
    public ICTCTestDetails getTestDetails(Long id) {
        log.debug("Request to get TestResult details : {}", id);
        Optional<ICTCTestResult> optional = iCTCTestResultRepository.findById(id);
        if(!optional.isPresent()) {
        	throw new BadRequestAlertException("Invalid result Id", "ICTC","Invalid result Id");
        }
        ICTCTestDetails details = new ICTCTestDetails();
        ICTCTestResult result = optional.get();
        details.setVisitDetails(ictcVisitMapper.toDto(result.getVisit()));
        details.setEidLabDetails(result.getSample().getBatch() == null ? null : result.getSample().getBatch().getLab());
        details.setIctcDetails(result.getSample().getFacility());
        details.setBeneficiaryDetails(result.getIctcBeneficiary().getBeneficiary());
        details.setIctcBeneficiaryDetails(ictcBeneficiaryMapper.toDto(result.getIctcBeneficiary()));
        details.setResultDto(iCTCTestResultMapper.toDto(result));
        details.setSampleDetails(ictcSampleCollectionMapper.toDto(result.getSample()));
        if(result.getSample().getBarcode() != null) {
        	List<LabTestSample> samples = labTestSampleRepository.findByBarcodeNumberOrderByIdDesc(result.getSample().getBarcode());
        	if(!samples.isEmpty()) {
        		details.setEidLabSampleDetails(samples.get(0));
        	}
        }
        List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(result.getIctcBeneficiary().getBeneficiary().getId(), 4);
    	if(!motherDetails.isEmpty()) {
    		details.setMotherDetails(motherDetails.get(0).getMemberBeneficiary());
    	}
        return details;
    }
}
