package gov.naco.soch.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCBatchDetails;
import gov.naco.soch.domain.LabTestSampleBatch;
import gov.naco.soch.repository.ICTCBatchDetailsRepository;
import gov.naco.soch.repository.LabTestSampleBatchRepository;
import gov.naco.soch.service.ICTCBatchDetailsService;
import gov.naco.soch.service.dto.ICTCBatchDetailsDTO;
import gov.naco.soch.service.mapper.ICTCBatchDetailsMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link ICTCBatchDetails}.
 */
@Service
@Transactional
public class ICTCBatchDetailsServiceImpl implements ICTCBatchDetailsService {

    private final Logger log = LoggerFactory.getLogger(ICTCBatchDetailsServiceImpl.class);

    private final ICTCBatchDetailsRepository iCTCBatchDetailsRepository;

    private final ICTCBatchDetailsMapper iCTCBatchDetailsMapper;
    
    private final LabTestSampleBatchRepository labTestSampleBatchRepository;

    public ICTCBatchDetailsServiceImpl(ICTCBatchDetailsRepository iCTCBatchDetailsRepository, ICTCBatchDetailsMapper iCTCBatchDetailsMapper,
    		LabTestSampleBatchRepository labTestSampleBatchRepository) {
        this.iCTCBatchDetailsRepository = iCTCBatchDetailsRepository;
        this.iCTCBatchDetailsMapper = iCTCBatchDetailsMapper;
        this.labTestSampleBatchRepository = labTestSampleBatchRepository;
    }

    /**
     * Save a iCTCBatchDetails.
     *
     * @param iCTCBatchDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCBatchDetailsDTO save(ICTCBatchDetailsDTO iCTCBatchDetailsDTO) {
        log.debug("Request to save ICTCBatchDetails : {}", iCTCBatchDetailsDTO);
        ICTCBatchDetails iCTCBatchDetails = iCTCBatchDetailsMapper.toEntity(iCTCBatchDetailsDTO);
        iCTCBatchDetails = iCTCBatchDetailsRepository.save(iCTCBatchDetails);
        return iCTCBatchDetailsMapper.toDto(iCTCBatchDetails);
    }

    /**
     * Get all the iCTCBatchDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCBatchDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCBatchDetails");
        return iCTCBatchDetailsRepository.findAll(pageable)
            .map(iCTCBatchDetailsMapper::toDto);
    }

    /**
     * Get one iCTCBatchDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCBatchDetailsDTO> findOne(Long id) {
        log.debug("Request to get ICTCBatchDetails : {}", id);
        return iCTCBatchDetailsRepository.findById(id)
            .map(iCTCBatchDetailsMapper::toDto);
    }
    
    /**
     * Get one iCTCBatchDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public ICTCBatchDetailsDTO getBatchDetails(Long id) {
        log.debug("Request to get ICTCBatchDetails : {}", id);
        Optional<ICTCBatchDetailsDTO> batchDetailsOptional = findOne(id);
        if(batchDetailsOptional.isPresent()) {
        	ICTCBatchDetailsDTO batch = batchDetailsOptional.get();
        	List<LabTestSampleBatch> batches = labTestSampleBatchRepository.findByBdnSerialNumberOrderByIdDesc(batchDetailsOptional.get().getConsignmentId());
        	if(!batches.isEmpty()) {
        		batch.setEidLabBatchDetails(batches.get(0));
        	}
        	return batch;
        } else {
        	throw new BadRequestAlertException("INVALID_ID", "ICTC", "INVALID_ID");
        }
    }

    /**
     * Delete the iCTCBatchDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCBatchDetails : {}", id);
        iCTCBatchDetailsRepository.deleteById(id);
    }
}
