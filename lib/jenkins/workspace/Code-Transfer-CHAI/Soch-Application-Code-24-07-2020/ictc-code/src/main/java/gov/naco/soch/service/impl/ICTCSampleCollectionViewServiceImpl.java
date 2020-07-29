package gov.naco.soch.service.impl;

import gov.naco.soch.service.ICTCSampleCollectionViewService;
import gov.naco.soch.domain.ICTCSampleCollectionView;
import gov.naco.soch.repository.ICTCSampleCollectionViewRepository;
import gov.naco.soch.service.dto.ICTCSampleCollectionViewDTO;
import gov.naco.soch.service.mapper.ICTCSampleCollectionViewMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing ICTCSampleCollectionView.
 */
@Service
@Transactional
public class ICTCSampleCollectionViewServiceImpl implements ICTCSampleCollectionViewService {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionViewServiceImpl.class);

    private final ICTCSampleCollectionViewRepository iCTCSampleCollectionViewRepository;

    private final ICTCSampleCollectionViewMapper iCTCSampleCollectionViewMapper;

    public ICTCSampleCollectionViewServiceImpl(ICTCSampleCollectionViewRepository iCTCSampleCollectionViewRepository, ICTCSampleCollectionViewMapper iCTCSampleCollectionViewMapper) {
        this.iCTCSampleCollectionViewRepository = iCTCSampleCollectionViewRepository;
        this.iCTCSampleCollectionViewMapper = iCTCSampleCollectionViewMapper;
    }

    /**
     * Save a iCTCSampleCollectionView.
     *
     * @param iCTCSampleCollectionViewDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ICTCSampleCollectionViewDTO save(ICTCSampleCollectionViewDTO iCTCSampleCollectionViewDTO) {
        log.debug("Request to save ICTCSampleCollectionView : {}", iCTCSampleCollectionViewDTO);
        ICTCSampleCollectionView iCTCSampleCollectionView = iCTCSampleCollectionViewMapper.toEntity(iCTCSampleCollectionViewDTO);
        iCTCSampleCollectionView = iCTCSampleCollectionViewRepository.save(iCTCSampleCollectionView);
        return iCTCSampleCollectionViewMapper.toDto(iCTCSampleCollectionView);
    }

    /**
     * Get all the iCTCSampleCollectionViews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCSampleCollectionViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCSampleCollectionViews");
        return iCTCSampleCollectionViewRepository.findAll(pageable)
            .map(iCTCSampleCollectionViewMapper::toDto);
    }


    /**
     * Get one iCTCSampleCollectionView by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCSampleCollectionViewDTO> findOne(Long id) {
        log.debug("Request to get ICTCSampleCollectionView : {}", id);
        return iCTCSampleCollectionViewRepository.findById(id)
            .map(iCTCSampleCollectionViewMapper::toDto);
    }

    /**
     * Delete the iCTCSampleCollectionView by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCSampleCollectionView : {}", id);
        iCTCSampleCollectionViewRepository.deleteById(id);
    }
}
