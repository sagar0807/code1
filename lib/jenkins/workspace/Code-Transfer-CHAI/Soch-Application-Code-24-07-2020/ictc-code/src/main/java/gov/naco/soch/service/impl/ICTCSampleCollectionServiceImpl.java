package gov.naco.soch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.domain.UserMaster;
import gov.naco.soch.repository.ICTCSampleCollectionRepository;
import gov.naco.soch.repository.ICTCTestResultRepository;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;
import gov.naco.soch.service.mapper.ICTCVisitMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link ICTCSampleCollection}.
 */
@Service
@Transactional
public class ICTCSampleCollectionServiceImpl implements ICTCSampleCollectionService {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionServiceImpl.class);

    private final ICTCSampleCollectionRepository iCTCSampleCollectionRepository;
    
    private final ICTCTestResultRepository ictcTestResultRepository;

    private final ICTCSampleCollectionMapper iCTCSampleCollectionMapper;
    
    private final ICTCVisitService visitService;
    
    private final ICTCTestResultService testResultService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCVisitMapper visitMapper;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;

    public ICTCSampleCollectionServiceImpl(ICTCSampleCollectionRepository iCTCSampleCollectionRepository, ICTCSampleCollectionMapper iCTCSampleCollectionMapper,
    		ICTCVisitService visitService, ICTCTestResultService testResultService, ICTCBeneficiaryService ictcBeneficiaryService,
    		ICTCTestResultRepository ictcTestResultRepository, ICTCVisitMapper visitMapper, BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService) {
        this.iCTCSampleCollectionRepository = iCTCSampleCollectionRepository;
        this.iCTCSampleCollectionMapper = iCTCSampleCollectionMapper;
        this.visitService = visitService;
        this.testResultService = testResultService;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
        this.ictcTestResultRepository = ictcTestResultRepository;
        this.visitMapper = visitMapper;
        this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
    }

    /**
     * Save a iCTCSampleCollection.
     *
     * @param iCTCSampleCollectionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCSampleCollectionDTO save(ICTCSampleCollectionDTO iCTCSampleCollectionDTO) {
        log.debug("Request to save ICTCSampleCollection : {}", iCTCSampleCollectionDTO);
        ICTCSampleCollection iCTCSampleCollection = iCTCSampleCollectionMapper.toEntity(iCTCSampleCollectionDTO);
        iCTCSampleCollection = iCTCSampleCollectionRepository.save(iCTCSampleCollection);
        return iCTCSampleCollectionMapper.toDto(iCTCSampleCollection);
    }
    
    /**
     * Save list of samples.
     *
     * @param samples the list of samples to save
     * @return the persisted entity.
     */
    @Transactional
    public List<ICTCSampleCollectionDTO> saveListOfSamples(List<CreateSampleDTO> samples) {
    	if (samples == null) {
            throw new BadRequestAlertException("Empty List", "ICTC","Empty List");
        }
    	List<ICTCSampleCollectionDTO> list = new ArrayList<>();
    	for(CreateSampleDTO sample : samples) {
    		Long countOfDuplicates = iCTCSampleCollectionRepository.countByBarcode(sample.getBarcode());
    		if(countOfDuplicates > 0 && sample.getBarcode() != null) {
    			throw new BadRequestAlertException("Barcode Already Exists: " + sample.getBarcode(), "ICTC","DUPLICATE_BARCODE");
    		}
    		Optional<ICTCVisit> visitOptional = visitService.find(sample.getVisitId());
    		if(!visitOptional.isPresent()) {
    			throw new BadRequestAlertException("Invalid visit id", "ICTC","Invalid visit Id");
    		}
    		ICTCVisitDTO prevVisit = visitMapper.toDto(visitOptional.get());
    		ICTCVisitDTO visit = prevVisit;
    		visit.setId(null);
    		visit.setIsMultiFacilityService(false);
    		
    		beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visitOptional.get().getIctcBeneficiary().getBeneficiary().getId(), 1, visit.getBeneficiaryStatus(), sample.getFacilityId(), null);
    		visit.setBeneficiaryStatus(1);
    		visit.setInfantBreastFed(sample.getInfantBreastFed());
    		visit.setVisitDate(sample.getVisitDate());
    		visit = visitService.save(visit);
    		
    		ICTCSampleCollectionDTO ictcSample = new ICTCSampleCollectionDTO();
    		
//    		ZonedDateTime currentTimeIndia = getCurrentTimeInIndia();
//        	LocalDateTime sampleCollectionTime = currentTimeIndia.toLocalDateTime();
//        	sampleCollectionTime = sampleCollectionTime.withYear(sample.getSampleCollectionDate().getYear());
//        	sampleCollectionTime = sampleCollectionTime.withMonth(sample.getSampleCollectionDate().getMonthValue());
//        	sampleCollectionTime = sampleCollectionTime.withDayOfMonth(sample.getSampleCollectionDate().getDayOfMonth());
    		
    		ictcSample.setSampleCollectionDate(sample.getSampleCollectionDate());
    		
    		ictcSample.setSampleCollectionStatus(1);
    		ictcSample.setIsActive(true);
    		ictcSample.setIsDeleted(false);
    		ictcSample.setBarcode(sample.getBarcode());
    		ictcSample.setIctcBeneficiaryId(sample.getIctcBeneficiaryId());
    		ictcSample.setVisitId(visit.getId());
    		ictcSample.setTestType(sample.getTestType());
    		ictcSample.setFacilityId(sample.getFacilityId());
    		ictcSample.setLabTechnician(sample.getLabTechnicianId() == null ? null : new UserMaster(sample.getLabTechnicianId()));
    		ictcSample = save(ictcSample);
    		list.add(ictcSample);
    		
    		ICTCTestResultDTO result = new ICTCTestResultDTO();
        	result.setResultStatus(1);
        	result.setIctcBeneficiaryId(sample.getIctcBeneficiaryId());
        	result.setVisitId(visit.getId());
        	result.setIsActive(true);
        	result.setIsDeleted(false);
    		result.setSampleId(ictcSample.getId());
    		result = testResultService.save(result);
    		
    		Optional<ICTCBeneficiaryDTO> ictcBeneficiaryOptional = ictcBeneficiaryService.findOne(sample.getIctcBeneficiaryId());
    		if(ictcBeneficiaryOptional.isPresent()) {
    			ICTCBeneficiaryDTO ictcBeneficiaryDTO = ictcBeneficiaryOptional.get();
    			ictcBeneficiaryDTO.setCurrentTestResultId(result.getId());
    			ictcBeneficiaryDTO.setRecentVisitId(visit.getId());
    			ictcBeneficiaryDTO.setBeneficiaryStatus(1);
    			ictcBeneficiaryService.save(ictcBeneficiaryDTO);
    		}
    	}
        log.debug("Request to save list of samples : {}", samples);
        return list;
    }

    /**
     * Get all the iCTCSampleCollections.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCSampleCollectionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCSampleCollections");
        return iCTCSampleCollectionRepository.findAll(pageable)
            .map(iCTCSampleCollectionMapper::toDto);
    }

    /**
     * Get one iCTCSampleCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCSampleCollectionDTO> findOne(Long id) {
        log.debug("Request to get ICTCSampleCollection : {}", id);
        return iCTCSampleCollectionRepository.findById(id)
            .map(iCTCSampleCollectionMapper::toDto);
    }
    
    /**
     * Get one iCTCSampleCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCSampleCollection> find(Long id) {
        log.debug("Request to get ICTCSampleCollection : {}", id);
        return iCTCSampleCollectionRepository.findById(id);
    }
    
    /**
     * Get one iCTCSampleCollection by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public ICTCSampleCollectionDTO getOne(Long id) {
        log.debug("Request to get ICTCSampleCollection : {}", id);
        return iCTCSampleCollectionMapper.toDto(iCTCSampleCollectionRepository.getOne(id));
    }

    /**
     * Delete the iCTCSampleCollection by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCSampleCollection : {}", id);
        iCTCSampleCollectionRepository.deleteById(id);
    }
    
    /**
     * Delete the iCTCSampleCollection by id.
     *
     * @param id the id of the entity.
     */
    @Transactional
    public void deactivate(Long id) {
        log.debug("Request to delete ICTCSampleCollection : {}", id);
        iCTCSampleCollectionRepository.markEntryAsDeletedAndInActive(id);
        ictcTestResultRepository.markEntryAsDeletedAndInActiveForASample(id);
    }
    
}
