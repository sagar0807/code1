package gov.naco.soch.service.impl;

import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.repository.ICTCBeneficiaryRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ICTCBeneficiary}.
 */
@Service
public class ICTCBeneficiaryServiceImpl implements ICTCBeneficiaryService {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryServiceImpl.class);

    private final ICTCBeneficiaryRepository iCTCBeneficiaryRepository;

    private final ICTCBeneficiaryMapper iCTCBeneficiaryMapper;

    public ICTCBeneficiaryServiceImpl(ICTCBeneficiaryRepository iCTCBeneficiaryRepository, ICTCBeneficiaryMapper iCTCBeneficiaryMapper) {
        this.iCTCBeneficiaryRepository = iCTCBeneficiaryRepository;
        this.iCTCBeneficiaryMapper = iCTCBeneficiaryMapper;
    }

    /**
     * Save a iCTCBeneficiary.
     *
     * @param iCTCBeneficiaryDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCBeneficiaryDTO save(ICTCBeneficiaryDTO iCTCBeneficiaryDTO) {
        log.debug("Request to save ICTCBeneficiary : {}", iCTCBeneficiaryDTO);
        ICTCBeneficiary iCTCBeneficiary = iCTCBeneficiaryMapper.toEntity(iCTCBeneficiaryDTO);
        iCTCBeneficiary = iCTCBeneficiaryRepository.save(iCTCBeneficiary);
        return iCTCBeneficiaryMapper.toDto(iCTCBeneficiary);
    }
    
    /**
     * Save a iCTCBeneficiary.
     *
     * @param ictcBeneficiary the entity to save.
     * @return the persisted entity.
     */
    public ICTCBeneficiary save(ICTCBeneficiary ictcBeneficiary) {
        log.debug("Request to save ICTCBeneficiary : {}", ictcBeneficiary);
        return iCTCBeneficiaryRepository.save(ictcBeneficiary);
    }

    /**
     * Get all the iCTCBeneficiaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCBeneficiaries");
        return iCTCBeneficiaryRepository.findAll(pageable)
            .map(iCTCBeneficiaryMapper::toDto);
    }

    /**
     * Get one iCTCBeneficiary by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCBeneficiaryDTO> findOne(Long id) {
        log.debug("Request to get ICTCBeneficiary : {}", id);
        return iCTCBeneficiaryRepository.findById(id).map(iCTCBeneficiaryMapper::toDto);
    }
    
    /**
     * Get one iCTCBeneficiary by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCBeneficiary> find(Long id) {
        log.debug("Request to get ICTCBeneficiary : {}", id);
        return iCTCBeneficiaryRepository.findById(id);
    }


    /**
     * Delete the iCTCBeneficiary by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCBeneficiary : {}", id);
        iCTCBeneficiaryRepository.deleteById(id);
    }
}
