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
import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.repository.ICTCFollowUpRepository;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCFollowUpService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;
import gov.naco.soch.service.mapper.ICTCFollowUpMapper;

/**
 * Service Implementation for managing {@link ICTCFollowUp}.
 */
@Service
@Transactional
public class ICTCFollowUpServiceImpl implements ICTCFollowUpService {

    private final Logger log = LoggerFactory.getLogger(ICTCFollowUpServiceImpl.class);

    private final ICTCFollowUpRepository iCTCFollowUpRepository;

    private final ICTCFollowUpMapper iCTCFollowUpMapper;
    
    private final ICTCVisitService visitService;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;

    public ICTCFollowUpServiceImpl(ICTCFollowUpRepository iCTCFollowUpRepository, ICTCFollowUpMapper iCTCFollowUpMapper, 
    		ICTCVisitService visitService, BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService,
    		ICTCBeneficiaryService ictcBeneficiaryService) {
        this.iCTCFollowUpRepository = iCTCFollowUpRepository;
        this.iCTCFollowUpMapper = iCTCFollowUpMapper;
        this.visitService = visitService;
        this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
    }

    /**
     * Save a iCTCFollowUp.
     *
     * @param iCTCFollowUpDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCFollowUpDTO save(ICTCFollowUpDTO iCTCFollowUpDTO) {
        log.debug("Request to save ICTCFollowUp : {}", iCTCFollowUpDTO);
        ICTCFollowUp iCTCFollowUp = iCTCFollowUpMapper.toEntity(iCTCFollowUpDTO);
        iCTCFollowUp.setIsActive(true);
        iCTCFollowUp.setIsDeleted(false);
        iCTCFollowUp.setCreatedTime(LocalDate.now());
        iCTCFollowUp = iCTCFollowUpRepository.save(iCTCFollowUp);
        return iCTCFollowUpMapper.toDto(iCTCFollowUp);
    }
    
    /**
     * Save a iCTCFollowUp for infant.
     *
     * @param iCTCFollowUpDTO the entity to save.
     * @return the persisted entity.
     */
    @Transactional
    public ICTCFollowUpDTO saveFollowUpForInfant(ICTCFollowUpDTO iCTCFollowUpDTO) {
        log.debug("Request to save ICTCFollowUp : {}", iCTCFollowUpDTO);
        Optional<ICTCFollowUp> followUpOptional = iCTCFollowUpRepository.findByFollowUpTypeAndVisitId(iCTCFollowUpDTO.getFollowUpType(), iCTCFollowUpDTO.getVisitId());
        if(followUpOptional.isPresent()) {
        	iCTCFollowUpDTO.setId(followUpOptional.get().getId());
        }
        Optional<ICTCVisit> visitOptional = visitService.find(iCTCFollowUpDTO.getVisitId());
        if(visitOptional.isPresent()) {
        	ICTCVisit visit = visitOptional.get();
        	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), 3, visit.getBeneficiaryStatus(), iCTCFollowUpDTO.getFacilityId(), null);
        	visit.setBeneficiaryStatus(3);
        	visitService.save(visit);
        	ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
        	ictcBeneficiary.setBeneficiaryStatus(3);
        	ictcBeneficiaryService.save(ictcBeneficiary);
        }
        ICTCFollowUp iCTCFollowUp = iCTCFollowUpMapper.toEntity(iCTCFollowUpDTO);
        iCTCFollowUp.setIsActive(true);
        iCTCFollowUp.setIsDeleted(false);
        iCTCFollowUp.setCreatedTime(LocalDate.now());
        iCTCFollowUp = iCTCFollowUpRepository.save(iCTCFollowUp);
        return iCTCFollowUpMapper.toDto(iCTCFollowUp);
    }

    /**
     * Get all the iCTCFollowUps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCFollowUpDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCFollowUps");
        return iCTCFollowUpRepository.findAll(pageable)
            .map(iCTCFollowUpMapper::toDto);
    }

    /**
     * Get one iCTCFollowUp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCFollowUpDTO> findOne(Long id) {
        log.debug("Request to get ICTCFollowUp : {}", id);
        return iCTCFollowUpRepository.findById(id)
            .map(iCTCFollowUpMapper::toDto);
    }
    
    /**
     * Get one iCTCFollowUp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<ICTCFollowUp> find(Long id) {
        log.debug("Request to get ICTCFollowUp : {}", id);
        return iCTCFollowUpRepository.findById(id);
    }

    /**
     * Delete the iCTCFollowUp by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCFollowUp : {}", id);
        iCTCFollowUpRepository.deleteById(id);
    }
}
