package gov.naco.soch.ti.service;


import gov.naco.soch.entity.TIBenHRGDetails;
import gov.naco.soch.repository.TIBenHRGDetailsRepository;
import gov.naco.soch.ti.dto.TIBenHRGDetailsDTO;
import gov.naco.soch.ti.mapper.TIBenHRGDetailsMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TIBenHRGDetails}.
 */
@Service
@Transactional
public class TIBenHRGDetailsServiceImpl  {

    private final Logger log = LoggerFactory.getLogger(TIBenHRGDetailsServiceImpl.class);

    private final TIBenHRGDetailsRepository tIBenHRGDetailsRepository;

    private final TIBenHRGDetailsMapper tIBenHRGDetailsMapper;

    public TIBenHRGDetailsServiceImpl(TIBenHRGDetailsRepository tIBenHRGDetailsRepository, TIBenHRGDetailsMapper tIBenHRGDetailsMapper) {
        this.tIBenHRGDetailsRepository = tIBenHRGDetailsRepository;
        this.tIBenHRGDetailsMapper = tIBenHRGDetailsMapper;
    }

    /**
     * Save a tIBenHRGDetails.
     *
     * @param tIBenHRGDetailsDTO the entity to save.
     * @return the persisted entity.
     */
   
    public TIBenHRGDetailsDTO save(TIBenHRGDetailsDTO tIBenHRGDetailsDTO) {
        log.debug("Request to save TIBenHRGDetails : {}", tIBenHRGDetailsDTO);
        TIBenHRGDetails tIBenHRGDetails = tIBenHRGDetailsMapper.toEntity(tIBenHRGDetailsDTO);
        tIBenHRGDetails = tIBenHRGDetailsRepository.save(tIBenHRGDetails);
        return tIBenHRGDetailsMapper.toDto(tIBenHRGDetails);
    }

    /**
     * Get all the tIBenHRGDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
  
    @Transactional(readOnly = true)
    public Page<TIBenHRGDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TIBenHRGDetails");
        return tIBenHRGDetailsRepository.findAll(pageable)
            .map(tIBenHRGDetailsMapper::toDto);
    }


    /**
     * Get one tIBenHRGDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
   
    @Transactional(readOnly = true)
    public Optional<TIBenHRGDetailsDTO> findOne(Long id) {
        log.debug("Request to get TIBenHRGDetails : {}", id);
        return tIBenHRGDetailsRepository.findById(id)
            .map(tIBenHRGDetailsMapper::toDto);
    }

    /**
     * Delete the tIBenHRGDetails by id.
     *
     * @param id the id of the entity.
     */
   
    public void delete(Long id) {
        log.debug("Request to delete TIBenHRGDetails : {}", id);
        tIBenHRGDetailsRepository.deleteById(id);
    }
}
