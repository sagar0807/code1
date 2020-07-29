package gov.naco.soch.service.impl;

import gov.naco.soch.service.IctcRPQMappingService;
import gov.naco.soch.domain.IctcRPQMapping;
import gov.naco.soch.repository.IctcRPQMappingRepository;
import gov.naco.soch.service.dto.IctcRPQMappingDTO;
import gov.naco.soch.service.mapper.IctcRPQMappingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link IctcRPQMapping}.
 */
@Service
@Transactional
public class IctcRPQMappingServiceImpl implements IctcRPQMappingService {

    private final Logger log = LoggerFactory.getLogger(IctcRPQMappingServiceImpl.class);

    private final IctcRPQMappingRepository ictcRPQMappingRepository;

    private final IctcRPQMappingMapper ictcRPQMappingMapper;

    public IctcRPQMappingServiceImpl(IctcRPQMappingRepository ictcRPQMappingRepository, IctcRPQMappingMapper ictcRPQMappingMapper) {
        this.ictcRPQMappingRepository = ictcRPQMappingRepository;
        this.ictcRPQMappingMapper = ictcRPQMappingMapper;
    }

    /**
     * Save a ictcRPQMapping.
     *
     * @param ictcRPQMappingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public IctcRPQMappingDTO save(IctcRPQMappingDTO ictcRPQMappingDTO) {
        log.debug("Request to save IctcRPQMapping : {}", ictcRPQMappingDTO);
        IctcRPQMapping ictcRPQMapping = ictcRPQMappingMapper.toEntity(ictcRPQMappingDTO);
        ictcRPQMapping = ictcRPQMappingRepository.save(ictcRPQMapping);
        return ictcRPQMappingMapper.toDto(ictcRPQMapping);
    }

    /**
     * Get all the ictcRPQMappings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<IctcRPQMappingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all IctcRPQMappings");
        return ictcRPQMappingRepository.findAll(pageable)
            .map(ictcRPQMappingMapper::toDto);
    }

    /**
     * Get one ictcRPQMapping by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IctcRPQMappingDTO> findOne(Long id) {
        log.debug("Request to get IctcRPQMapping : {}", id);
        return ictcRPQMappingRepository.findById(id)
            .map(ictcRPQMappingMapper::toDto);
    }

    /**
     * Delete the ictcRPQMapping by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IctcRPQMapping : {}", id);
        ictcRPQMappingRepository.deleteById(id);
    }
}
