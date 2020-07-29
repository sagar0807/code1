package gov.naco.soch.service.impl;

import gov.naco.soch.service.ICTCBeneficiaryFollowUpViewService;
import gov.naco.soch.domain.ICTCBeneficiaryFollowUpView;
import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.repository.ICTCBeneficiaryFollowUpViewRepository;
import gov.naco.soch.repository.ICTCFollowUpRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryFollowUpViewMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing ICTCBeneficiaryFollowUpView.
 */
@Service
@Transactional
public class ICTCBeneficiaryFollowUpViewServiceImpl implements ICTCBeneficiaryFollowUpViewService {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryFollowUpViewServiceImpl.class);

    private final ICTCBeneficiaryFollowUpViewRepository iCTCBeneficiaryFollowUpViewRepository;

    private final ICTCBeneficiaryFollowUpViewMapper iCTCBeneficiaryFollowUpViewMapper;
    
    private final ICTCFollowUpRepository ictcFollowUpRepository;

    public ICTCBeneficiaryFollowUpViewServiceImpl(ICTCBeneficiaryFollowUpViewRepository iCTCBeneficiaryFollowUpViewRepository, 
    		ICTCBeneficiaryFollowUpViewMapper iCTCBeneficiaryFollowUpViewMapper,
    		ICTCFollowUpRepository ictcFollowUpRepository) {
        this.iCTCBeneficiaryFollowUpViewRepository = iCTCBeneficiaryFollowUpViewRepository;
        this.iCTCBeneficiaryFollowUpViewMapper = iCTCBeneficiaryFollowUpViewMapper;
        this.ictcFollowUpRepository = ictcFollowUpRepository;
    }

    /**
     * Save a iCTCBeneficiaryFollowUpView.
     *
     * @param iCTCBeneficiaryFollowUpViewDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ICTCBeneficiaryFollowUpViewDTO save(ICTCBeneficiaryFollowUpViewDTO iCTCBeneficiaryFollowUpViewDTO) {
        log.debug("Request to save ICTCBeneficiaryFollowUpView : {}", iCTCBeneficiaryFollowUpViewDTO);
        ICTCBeneficiaryFollowUpView iCTCBeneficiaryFollowUpView = iCTCBeneficiaryFollowUpViewMapper.toEntity(iCTCBeneficiaryFollowUpViewDTO);
        iCTCBeneficiaryFollowUpView = iCTCBeneficiaryFollowUpViewRepository.save(iCTCBeneficiaryFollowUpView);
        return iCTCBeneficiaryFollowUpViewMapper.toDto(iCTCBeneficiaryFollowUpView);
    }

    /**
     * Get all the iCTCBeneficiaryFollowUpViews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryFollowUpViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCBeneficiaryFollowUpViews");
        return iCTCBeneficiaryFollowUpViewRepository.findAll(pageable)
            .map(iCTCBeneficiaryFollowUpViewMapper::toDto);
    }


    /**
     * Get one iCTCBeneficiaryFollowUpView by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCBeneficiaryFollowUpViewDTO> findOne(Long id) {
        log.debug("Request to get ICTCBeneficiaryFollowUpView : {}", id);
        return iCTCBeneficiaryFollowUpViewRepository.findById(id)
            .map(iCTCBeneficiaryFollowUpViewMapper::toDto);
    }

    /**
     * Delete the iCTCBeneficiaryFollowUpView by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCBeneficiaryFollowUpView : {}", id);
        iCTCBeneficiaryFollowUpViewRepository.deleteById(id);
    }
    
    /**
     * Disable the iCTCBeneficiaryFollowUpView by id.
     *
     * @param id the id of the entity
     */
    @Transactional
    public void disable(Long id) {
        log.debug("Request to disable ICTCBeneficiaryFollowUpView : {}", id);
        Optional<ICTCFollowUp> followUpOptional = ictcFollowUpRepository.findById(id);
        if(!followUpOptional.isPresent()) {
        	throw new BadRequestAlertException("Invalid followup Id", "ICTC","INVALID_ID");
        }
        ICTCFollowUp followUp = followUpOptional.get();
        followUp.setIsActive(false);
        ictcFollowUpRepository.save(followUp);
    }
}
