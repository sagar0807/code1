package gov.naco.soch.ti.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TIBenChildDetails;
import gov.naco.soch.repository.TIBenChildDetailsRepository;
import gov.naco.soch.ti.dto.TIBenChildDetailsDTO;
import gov.naco.soch.ti.mapper.TIBenChildDetailsMapper;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TIBenChildDetails}.
 */
@Service
@Transactional
public class TIBenChildDetailsService  {

    private final Logger log = LoggerFactory.getLogger(TIBenChildDetailsService.class);

    private final TIBenChildDetailsRepository tIBenChildDetailsRepository;

    private final TIBenChildDetailsMapper tIBenChildDetailsMapper;

    public TIBenChildDetailsService(TIBenChildDetailsRepository tIBenChildDetailsRepository, TIBenChildDetailsMapper tIBenChildDetailsMapper) {
        this.tIBenChildDetailsRepository = tIBenChildDetailsRepository;
        this.tIBenChildDetailsMapper = tIBenChildDetailsMapper;
    }

    /**
     * Save a tIBenChildDetails.
     *
     * @param tIBenChildDetailsDTO the entity to save.
     * @return the persisted entity.
     */
 
    public TIBenChildDetailsDTO save(TIBenChildDetailsDTO tIBenChildDetailsDTO) {
        log.debug("Request to save TIBenChildDetails : {}", tIBenChildDetailsDTO);
        TIBenChildDetails tIBenChildDetails = tIBenChildDetailsMapper.toEntity(tIBenChildDetailsDTO);
        tIBenChildDetails = tIBenChildDetailsRepository.save(tIBenChildDetails);
        return tIBenChildDetailsMapper.toDto(tIBenChildDetails);
    }

    /**
     * Get all the tIBenChildDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
 
    @Transactional(readOnly = true)
    public Page<TIBenChildDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TIBenChildDetails");
        return tIBenChildDetailsRepository.findAll(pageable)
            .map(tIBenChildDetailsMapper::toDto);
    }


    /**
     * Get one tIBenChildDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    
    @Transactional(readOnly = true)
    public Optional<TIBenChildDetailsDTO> findOne(Long id) {
        log.debug("Request to get TIBenChildDetails : {}", id);
        return tIBenChildDetailsRepository.findById(id)
            .map(tIBenChildDetailsMapper::toDto);
    }

    /**
     * Delete the tIBenChildDetails by id.
     *
     * @param id the id of the entity.
     */
    
    public void delete(Long id) {
        log.debug("Request to delete TIBenChildDetails : {}", id);
        tIBenChildDetailsRepository.deleteById(id);
    }
}
