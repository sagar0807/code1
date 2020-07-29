package gov.naco.soch.service.impl;

import gov.naco.soch.service.LabTestSampleBatchService;
import gov.naco.soch.domain.LabTestSampleBatch;
import gov.naco.soch.repository.LabTestSampleBatchRepository;
import gov.naco.soch.service.dto.LabTestSampleBatchDTO;
import gov.naco.soch.service.mapper.LabTestSampleBatchMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link LabTestSampleBatch}.
 */
@Service
@Transactional
public class LabTestSampleBatchServiceImpl implements LabTestSampleBatchService {

    private final Logger log = LoggerFactory.getLogger(LabTestSampleBatchServiceImpl.class);

    private final LabTestSampleBatchRepository labTestSampleBatchRepository;

    private final LabTestSampleBatchMapper labTestSampleBatchMapper;

    public LabTestSampleBatchServiceImpl(LabTestSampleBatchRepository labTestSampleBatchRepository, LabTestSampleBatchMapper labTestSampleBatchMapper) {
        this.labTestSampleBatchRepository = labTestSampleBatchRepository;
        this.labTestSampleBatchMapper = labTestSampleBatchMapper;
    }

    /**
     * Save a labTestSampleBatch.
     *
     * @param labTestSampleBatchDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public LabTestSampleBatchDTO save(LabTestSampleBatchDTO labTestSampleBatchDTO) {
        log.debug("Request to save LabTestSampleBatch : {}", labTestSampleBatchDTO);
        LabTestSampleBatch labTestSampleBatch = labTestSampleBatchMapper.toEntity(labTestSampleBatchDTO);
        labTestSampleBatch = labTestSampleBatchRepository.save(labTestSampleBatch);
        return labTestSampleBatchMapper.toDto(labTestSampleBatch);
    }

    /**
     * Get all the labTestSampleBatches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LabTestSampleBatchDTO> findAll(Pageable pageable) {
        log.debug("Request to get all LabTestSampleBatches");
        return labTestSampleBatchRepository.findAll(pageable)
            .map(labTestSampleBatchMapper::toDto);
    }

    /**
     * Get one labTestSampleBatch by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LabTestSampleBatchDTO> findOne(Long id) {
        log.debug("Request to get LabTestSampleBatch : {}", id);
        return labTestSampleBatchRepository.findById(id)
            .map(labTestSampleBatchMapper::toDto);
    }

    /**
     * Delete the labTestSampleBatch by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete LabTestSampleBatch : {}", id);
        labTestSampleBatchRepository.deleteById(id);
    }
}
