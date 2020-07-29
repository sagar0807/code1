package gov.naco.soch.service.impl;

import gov.naco.soch.service.LabTestSampleService;
import gov.naco.soch.domain.LabTestSample;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.service.dto.LabTestSampleDTO;
import gov.naco.soch.service.mapper.LabTestSampleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link LabTestSample}.
 */
@Service
@Transactional
public class LabTestSampleServiceImpl implements LabTestSampleService {

    private final Logger log = LoggerFactory.getLogger(LabTestSampleServiceImpl.class);

    private final LabTestSampleRepository labTestSampleRepository;

    private final LabTestSampleMapper labTestSampleMapper;

    public LabTestSampleServiceImpl(LabTestSampleRepository labTestSampleRepository, LabTestSampleMapper labTestSampleMapper) {
        this.labTestSampleRepository = labTestSampleRepository;
        this.labTestSampleMapper = labTestSampleMapper;
    }

    /**
     * Save a labTestSample.
     *
     * @param labTestSampleDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public LabTestSampleDTO save(LabTestSampleDTO labTestSampleDTO) {
        log.debug("Request to save LabTestSample : {}", labTestSampleDTO);
        LabTestSample labTestSample = labTestSampleMapper.toEntity(labTestSampleDTO);
        labTestSample = labTestSampleRepository.save(labTestSample);
        return labTestSampleMapper.toDto(labTestSample);
    }

    /**
     * Get all the labTestSamples.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LabTestSampleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all LabTestSamples");
        return labTestSampleRepository.findAll(pageable)
            .map(labTestSampleMapper::toDto);
    }

    /**
     * Get one labTestSample by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LabTestSampleDTO> findOne(Long id) {
        log.debug("Request to get LabTestSample : {}", id);
        return labTestSampleRepository.findById(id)
            .map(labTestSampleMapper::toDto);
    }

    /**
     * Delete the labTestSample by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete LabTestSample : {}", id);
        labTestSampleRepository.deleteById(id);
    }
}
