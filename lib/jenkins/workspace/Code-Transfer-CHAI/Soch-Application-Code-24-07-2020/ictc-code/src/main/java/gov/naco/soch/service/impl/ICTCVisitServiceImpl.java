package gov.naco.soch.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.repository.ICTCVisitRepository;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.mapper.ICTCVisitMapper;

/**
 * Service Implementation for managing {@link ICTCVisit}.
 */
@Service
@Transactional
public class ICTCVisitServiceImpl implements ICTCVisitService {

    private final Logger log = LoggerFactory.getLogger(ICTCVisitServiceImpl.class);

    private final ICTCVisitRepository iCTCVisitRepository;

    private final ICTCVisitMapper iCTCVisitMapper;

    public ICTCVisitServiceImpl(ICTCVisitRepository iCTCVisitRepository, ICTCVisitMapper iCTCVisitMapper) {
        this.iCTCVisitRepository = iCTCVisitRepository;
        this.iCTCVisitMapper = iCTCVisitMapper;
    }

    /**
     * Save a iCTCVisit.
     *
     * @param iCTCVisitDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCVisitDTO save(ICTCVisitDTO iCTCVisitDTO) {
        log.debug("Request to save ICTCVisit : {}", iCTCVisitDTO);
        ICTCVisit iCTCVisit = iCTCVisitMapper.toEntity(iCTCVisitDTO);
        iCTCVisit = iCTCVisitRepository.save(iCTCVisit);
        return iCTCVisitMapper.toDto(iCTCVisit);
    }

    /**
     * Save a iCTCVisit.
     *
     * @param iCTCVisitDTO the entity to save.
     * @return the persisted entity.
     */
    public ICTCVisit save(ICTCVisit ictcVisit) {
        log.debug("Request to save ICTCVisit : {}", ictcVisit);
        return iCTCVisitRepository.save(ictcVisit);
    }

    
    /**
     * Get all the iCTCVisits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCVisitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCVisits");
        return iCTCVisitRepository.findAll(pageable)
            .map(iCTCVisitMapper::toDto);
    }

    /**
     * Get one iCTCVisit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ICTCVisit> find(Long id) {
        log.debug("Request to get ICTCVisit : {}", id);
        return iCTCVisitRepository.findById(id);
    }
    
    /**
     * Get one iCTCVisit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCVisitDTO> findOne(Long id) {
        log.debug("Request to get ICTCVisit : {}", id);
        return iCTCVisitRepository.findById(id)
            .map(iCTCVisitMapper::toDto);
    }
    
  
    /**
     * Get one visit
     * 
     * @param id id the id of the entity.
     * @return
     */
    public ICTCVisitDTO getOne(Long id) {
        log.debug("Request to get ICTCVisit : {}", id);
        return iCTCVisitMapper.toDto(iCTCVisitRepository.getOne(id));
    }

    /**
     * Delete the iCTCVisit by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCVisit : {}", id);
        iCTCVisitRepository.deleteById(id);
    }
}
