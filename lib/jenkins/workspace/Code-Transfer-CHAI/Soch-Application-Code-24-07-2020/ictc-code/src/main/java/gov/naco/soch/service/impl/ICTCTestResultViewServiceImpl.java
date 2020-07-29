package gov.naco.soch.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCTestResultView;
import gov.naco.soch.repository.ICTCTestResultViewRepository;
import gov.naco.soch.service.ICTCTestResultViewService;
import gov.naco.soch.service.dto.ICTCTestResultViewDTO;
import gov.naco.soch.service.mapper.ICTCTestResultViewMapper;
/**
 * Service Implementation for managing ICTCTestResultView.
 */
@Service
@Transactional
public class ICTCTestResultViewServiceImpl implements ICTCTestResultViewService {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultViewServiceImpl.class);

    private final ICTCTestResultViewRepository iCTCTestResultViewRepository;

    private final ICTCTestResultViewMapper iCTCTestResultViewMapper;

    public ICTCTestResultViewServiceImpl(ICTCTestResultViewRepository iCTCTestResultViewRepository, ICTCTestResultViewMapper iCTCTestResultViewMapper) {
        this.iCTCTestResultViewRepository = iCTCTestResultViewRepository;
        this.iCTCTestResultViewMapper = iCTCTestResultViewMapper;
    }

    /**
     * Save a iCTCTestResultView.
     *
     * @param iCTCTestResultViewDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ICTCTestResultViewDTO save(ICTCTestResultViewDTO iCTCTestResultViewDTO) {
        log.debug("Request to save ICTCTestResultView : {}", iCTCTestResultViewDTO);
        ICTCTestResultView iCTCTestResultView = iCTCTestResultViewMapper.toEntity(iCTCTestResultViewDTO);
        iCTCTestResultView = iCTCTestResultViewRepository.save(iCTCTestResultView);
        return iCTCTestResultViewMapper.toDto(iCTCTestResultView);
    }

    /**
     * Get all the iCTCTestResultViews.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCTestResultViewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCTestResultViews");
        return iCTCTestResultViewRepository.findAll(pageable)
            .map(iCTCTestResultViewMapper::toDto);
    }


    /**
     * Get one iCTCTestResultView by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<ICTCTestResultView> findOne(Long id) {
        log.debug("Request to get ICTCTestResultView : {}", id);
        return iCTCTestResultViewRepository.findById(id);
    }

    /**
     * Delete the iCTCTestResultView by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCTestResultView : {}", id);
        iCTCTestResultViewRepository.deleteById(id);
    }
}
