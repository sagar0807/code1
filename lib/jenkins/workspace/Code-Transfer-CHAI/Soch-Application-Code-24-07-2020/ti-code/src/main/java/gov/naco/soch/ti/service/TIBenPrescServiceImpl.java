package gov.naco.soch.ti.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TIBenPresc;
import gov.naco.soch.repository.TIBenPrescRepository;
import gov.naco.soch.ti.dto.TIBenPrescDTO;
import gov.naco.soch.ti.mapper.TIBenPrescMapper;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TIBenPresc}.
 */
@Service
@Transactional
public class TIBenPrescServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBenPrescServiceImpl.class);

    private final TIBenPrescRepository tIBenPrescRepository;

    private final TIBenPrescMapper tIBenPrescMapper;

    public TIBenPrescServiceImpl(TIBenPrescRepository tIBenPrescRepository, TIBenPrescMapper tIBenPrescMapper) {
        this.tIBenPrescRepository = tIBenPrescRepository;
        this.tIBenPrescMapper = tIBenPrescMapper;
    }

    /**
     * Save a tIBenPresc.
     *
     * @param tIBenPrescDTO the entity to save.
     * @return the persisted entity.
     */
    public TIBenPrescDTO save(TIBenPrescDTO tIBenPrescDTO) {
        log.debug("Request to save TIBenPresc : {}", tIBenPrescDTO);
        TIBenPresc tIBenPresc = tIBenPrescMapper.toEntity(tIBenPrescDTO);
        tIBenPresc = tIBenPrescRepository.save(tIBenPresc);
        return tIBenPrescMapper.toDto(tIBenPresc);
    }

    /**
     * Get all the tIBenPrescs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TIBenPrescDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TIBenPrescs");
        return tIBenPrescRepository.findAll(pageable)
            .map(tIBenPrescMapper::toDto);
    }


    /**
     * Get one tIBenPresc by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TIBenPrescDTO> findOne(Long id) {
        log.debug("Request to get TIBenPresc : {}", id);
        return tIBenPrescRepository.findById(id)
            .map(tIBenPrescMapper::toDto);
    }

    /**
     * Delete the tIBenPresc by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete TIBenPresc : {}", id);
        tIBenPrescRepository.deleteById(id);
    }
}
