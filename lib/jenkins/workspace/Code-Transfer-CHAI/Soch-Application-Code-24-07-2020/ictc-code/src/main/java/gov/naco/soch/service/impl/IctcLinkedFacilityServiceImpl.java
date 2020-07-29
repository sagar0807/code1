package gov.naco.soch.service.impl;

import gov.naco.soch.service.IctcLinkedFacilityService;
import gov.naco.soch.domain.IctcLinkedFacility;
import gov.naco.soch.repository.IctcLinkedFacilityRepository;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;
import gov.naco.soch.service.mapper.IctcLinkedFacilityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link IctcLinkedFacility}.
 */
@Service
@Transactional
public class IctcLinkedFacilityServiceImpl implements IctcLinkedFacilityService {

    private final Logger log = LoggerFactory.getLogger(IctcLinkedFacilityServiceImpl.class);

    private final IctcLinkedFacilityRepository ictcLinkedFacilityRepository;

    private final IctcLinkedFacilityMapper ictcLinkedFacilityMapper;

    public IctcLinkedFacilityServiceImpl(IctcLinkedFacilityRepository ictcLinkedFacilityRepository, IctcLinkedFacilityMapper ictcLinkedFacilityMapper) {
        this.ictcLinkedFacilityRepository = ictcLinkedFacilityRepository;
        this.ictcLinkedFacilityMapper = ictcLinkedFacilityMapper;
    }

    /**
     * Save a ictcLinkedFacility.
     *
     * @param ictcLinkedFacilityDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public IctcLinkedFacilityDTO save(IctcLinkedFacilityDTO ictcLinkedFacilityDTO) {
        log.debug("Request to save IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
        IctcLinkedFacility ictcLinkedFacility = ictcLinkedFacilityMapper.toEntity(ictcLinkedFacilityDTO);
        ictcLinkedFacility = ictcLinkedFacilityRepository.save(ictcLinkedFacility);
        return ictcLinkedFacilityMapper.toDto(ictcLinkedFacility);
    }

    /**
     * Get all the ictcLinkedFacilities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<IctcLinkedFacilityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all IctcLinkedFacilities");
        return ictcLinkedFacilityRepository.findAll(pageable)
            .map(ictcLinkedFacilityMapper::toDto);
    }

    /**
     * Get one ictcLinkedFacility by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IctcLinkedFacilityDTO> findOne(Long id) {
        log.debug("Request to get IctcLinkedFacility : {}", id);
        return ictcLinkedFacilityRepository.findById(id)
            .map(ictcLinkedFacilityMapper::toDto);
    }

    /**
     * Delete the ictcLinkedFacility by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IctcLinkedFacility : {}", id);
        ictcLinkedFacilityRepository.deleteById(id);
    }
}
