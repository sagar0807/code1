package gov.naco.soch.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.ICTCSampleBatch;
import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.repository.ICTCSampleBatchRepository;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCSampleBatchService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.LabTestSampleBatchService;
import gov.naco.soch.service.LabTestSampleService;
import gov.naco.soch.service.dto.CreateSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.LabTestSampleBatchDTO;
import gov.naco.soch.service.dto.LabTestSampleDTO;
import gov.naco.soch.service.mapper.ICTCSampleBatchMapper;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link ICTCSampleBatch}.
 */
@Service
@Transactional
public class ICTCSampleBatchServiceImpl implements ICTCSampleBatchService {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleBatchServiceImpl.class);

    private final ICTCSampleBatchRepository iCTCSampleBatchRepository;

    private final ICTCSampleBatchMapper iCTCSampleBatchMapper;
    
    private final ICTCSampleCollectionService sampleService;
    
    private final LabTestSampleBatchService labTestSampleBatchService;
    
    private final LabTestSampleService labTestSampleService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCSampleCollectionMapper ictcSampleCollectionMapper;
    
    private final ICTCVisitService ictcVisitService;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
    
    public ICTCSampleBatchServiceImpl(ICTCSampleBatchRepository iCTCSampleBatchRepository, ICTCSampleBatchMapper iCTCSampleBatchMapper,
    		ICTCSampleCollectionService sampleService, LabTestSampleBatchService labTestSampleBatchService, LabTestSampleService labTestSampleService,
    		ICTCBeneficiaryService ictcBeneficiaryService, ICTCSampleCollectionMapper ictcSampleCollectionMapper, ICTCVisitService ictcVisitService,
    		BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService) {
        this.iCTCSampleBatchRepository = iCTCSampleBatchRepository;
        this.iCTCSampleBatchMapper = iCTCSampleBatchMapper;
        this.sampleService = sampleService;
        this.labTestSampleBatchService = labTestSampleBatchService;
        this.labTestSampleService = labTestSampleService;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
        this.ictcSampleCollectionMapper = ictcSampleCollectionMapper;
        this.ictcVisitService = ictcVisitService;
        this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
    }

    /**
     * Save a iCTCSampleBatch.
     *
     * @param iCTCSampleBatchDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCSampleBatchDTO save(ICTCSampleBatchDTO iCTCSampleBatchDTO) {
        log.debug("Request to save ICTCSampleBatch : {}", iCTCSampleBatchDTO);
        ICTCSampleBatch iCTCSampleBatch = iCTCSampleBatchMapper.toEntity(iCTCSampleBatchDTO);
        iCTCSampleBatch = iCTCSampleBatchRepository.save(iCTCSampleBatch);
        return iCTCSampleBatchMapper.toDto(iCTCSampleBatch);
    }

    /**
     * Get all the iCTCSampleBatches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCSampleBatchDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCSampleBatches");
        return iCTCSampleBatchRepository.findAll(pageable)
            .map(iCTCSampleBatchMapper::toDto);
    }

    /**
     * Get one iCTCSampleBatch by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCSampleBatchDTO> findOne(Long id) {
        log.debug("Request to get ICTCSampleBatch : {}", id);
        return iCTCSampleBatchRepository.findById(id)
            .map(iCTCSampleBatchMapper::toDto);
    }

    /**
     * Delete the iCTCSampleBatch by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCSampleBatch : {}", id);
        iCTCSampleBatchRepository.deleteById(id);
    }
    
    /**
     * TO create a batch of samples
     * 
     */
    @Transactional
    public ICTCSampleBatchDTO createBatch(CreateSampleBatchDTO batchDetails) {
    	log.debug("Request to save ICTCSampleBatch : {}", batchDetails);
    	if(batchDetails.getSampleIds() == null) {
    		 throw new BadRequestAlertException("Empty List", "ICTC","Empty List");
    	}
    	Long countOfDuplicateConsignmentIds = iCTCSampleBatchRepository.countByConsignmentId(batchDetails.getConsignmentId());
    	if(countOfDuplicateConsignmentIds > 0) {
			throw new BadRequestAlertException("Consignment Id Already Exists: " + batchDetails.getConsignmentId(), "ICTC","DUPLICATE_CONSIGNMENT_ID");
		}
    	ICTCSampleBatchDTO batch = new ICTCSampleBatchDTO();
    	LabTestSampleBatchDTO labTestBatch = new LabTestSampleBatchDTO();
    	labTestBatch.setLabId(batchDetails.getLabId());
    	labTestBatch.setNumOfSamples(batchDetails.getSampleIds().size());
    	labTestBatch.setBdnSerialNumber(batchDetails.getConsignmentId());
    	
//    	ZonedDateTime currentTimeIndia = getCurrentTimeInIndia();
//    	LocalDateTime dispatchDateTime = currentTimeIndia.toLocalDateTime();
//    	dispatchDateTime = dispatchDateTime.withYear(batchDetails.getDispatchDate().getYear());
//    	dispatchDateTime = dispatchDateTime.withMonth(batchDetails.getDispatchDate().getMonthValue());
//    	dispatchDateTime = dispatchDateTime.withDayOfMonth(batchDetails.getDispatchDate().getDayOfMonth());
    	
    	labTestBatch.setDispatchDate(batchDetails.getDispatchDate());
    	labTestBatch.setBatchStatusId(1);
    	labTestBatch.setIsDelete(false);
    	labTestBatch.setArtcId(batchDetails.getFacilityId());
    	labTestBatch = labTestSampleBatchService.save(labTestBatch);
    	
    	batch.setConsignmentId(batchDetails.getConsignmentId());
    	batch.setLabId(batchDetails.getLabId());
    	batch.setBatchStatus(1);
    	batch.setCreatedTime(LocalDate.now());
    	batch.setIsDeleted(false);
    	batch.setIsActive(true);
    	batch.setDispatchDate(batchDetails.getDispatchDate());
    	batch.setFacilityId(batchDetails.getFacilityId());
    	batch = save(batch);
    	for(Long sampleId : batchDetails.getSampleIds()) {
    		Optional<ICTCSampleCollection> sampleOptional = sampleService.find(sampleId);
    		if(!sampleOptional.isPresent()) {
    			throw new BadRequestAlertException("Invalid Sample Id", "ICTC","Invalid Sample Id");
    		}
    		ICTCSampleCollection sample = sampleOptional.get();
    		ICTCVisit visit = sample.getVisit();
    		
    		beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), 10, visit.getBeneficiaryStatus(), batchDetails.getFacilityId(), null);
    		visit.setBeneficiaryStatus(10);
    		ictcVisitService.save(visit);
    		
    		ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
    		ictcBeneficiary.setBeneficiaryStatus(10);
    		ictcBeneficiaryService.save(ictcBeneficiary);
    		
    		ICTCSampleCollectionDTO sampleDTO = ictcSampleCollectionMapper.toDto(sample);
    		sampleDTO.setBatchId(batch.getId());
    		sampleDTO.setSampleCollectionStatus(2);
//    		sampleDTO.setDispatchDate(batchDetails.getDispatchDate());
    		sampleService.save(sampleDTO);
    		
    		LabTestSampleDTO labTestSampleDTO = new LabTestSampleDTO();
    		labTestSampleDTO.setBarcodeNumber(sample.getBarcode());
    		
//    		ZonedDateTime currentTimeInIndia = getCurrentTimeInIndia();
//    		LocalDateTime sampleCollectionTime = currentTimeInIndia.toLocalDateTime();
//    		if(sample.getSampleCollectionDate() == null) {
//    			sampleCollectionTime = sampleCollectionTime.withYear(visit.getVisitDate().getYear());
//    			sampleCollectionTime = sampleCollectionTime.withMonth(visit.getVisitDate().getMonthValue());
//    			sampleCollectionTime = sampleCollectionTime.withDayOfMonth(visit.getVisitDate().getDayOfMonth());
//    			labTestSampleDTO.setSampleCollectedDate(sampleCollectionTime);
//    		} else {
//    			labTestSampleDTO.setSampleCollectedDate(sample.getSampleCollectionDate());
//    		}
			
    			
    		labTestSampleDTO.setSampleCollectedDate(sample.getSampleCollectionDate());
			labTestSampleDTO.setSampleDispatchDate(batchDetails.getDispatchDate());
			labTestSampleDTO.setTestBatchId(labTestBatch.getId());
			labTestSampleDTO.setTestTypeId(sample.getTestType());
			labTestSampleDTO.setIsDelete(false);
			labTestSampleDTO.setSampleCollectedFacility(batchDetails.getFacilityId());
			labTestSampleDTO.setDispatchedToLab(batchDetails.getLabId());
			Optional<ICTCBeneficiaryDTO> ictcBeneficiaryOptional = ictcBeneficiaryService.findOne(sampleDTO.getIctcBeneficiaryId());
    		if(ictcBeneficiaryOptional.isPresent()) {
    			labTestSampleDTO.setBeneficiaryId(ictcBeneficiaryOptional.get().getBeneficiaryId());
    		}
			labTestSampleService.save(labTestSampleDTO);
    	}
    	return batch;
    }
    
//    private ZonedDateTime getCurrentTimeInIndia() {
//    	ZonedDateTime currentTime = ZonedDateTime.now();
//    	ZoneId india = ZoneId.of("Asia/Kolkata");
//    	currentTime = currentTime.withZoneSameInstant(india);
//    	return currentTime;
//    	
//    }
}
