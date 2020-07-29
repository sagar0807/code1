package gov.naco.soch.ti.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TIBenReferral;
import gov.naco.soch.repository.TIBenReferralRepository;
import gov.naco.soch.ti.dto.TIBenReferralDTO;
import gov.naco.soch.ti.mapper.TIBenReferralMapper;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TIBenReferral}.
 */
@Service
@Transactional
public class TIBenReferralServiceImpl  {

    private final Logger log = LoggerFactory.getLogger(TIBenReferralServiceImpl.class);

    private final TIBenReferralRepository tIBenReferralRepository;

    private final TIBenReferralMapper tIBenReferralMapper;

    public TIBenReferralServiceImpl(TIBenReferralRepository tIBenReferralRepository, TIBenReferralMapper tIBenReferralMapper) {
        this.tIBenReferralRepository = tIBenReferralRepository;
        this.tIBenReferralMapper = tIBenReferralMapper;
    }

    /**
     * Save a tIBenReferral.
     *
     * @param tIBenReferralDTO the entity to save.
     * @return the persisted entity.
     */
   
    public TIBenReferralDTO save(TIBenReferralDTO tIBenReferralDTO) {
        log.debug("Request to save TIBenReferral : {}", tIBenReferralDTO);
        TIBenReferral tIBenReferral = tIBenReferralMapper.toEntity(tIBenReferralDTO);
        tIBenReferral = tIBenReferralRepository.save(tIBenReferral);
        return tIBenReferralMapper.toDto(tIBenReferral);
    }

    /**
     * Get all the tIBenReferrals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    
    @Transactional(readOnly = true)
    public Page<TIBenReferralDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TIBenReferrals");
        return tIBenReferralRepository.findAll(pageable)
            .map(tIBenReferralMapper::toDto);
    }


    /**
     * Get one tIBenReferral by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    
    @Transactional(readOnly = true)
    public Optional<TIBenReferralDTO> findOne(Long id) {
        log.debug("Request to get TIBenReferral : {}", id);
        return tIBenReferralRepository.findById(id)
            .map(tIBenReferralMapper::toDto);
    }

    /**
     * Delete the tIBenReferral by id.
     *
     * @param id the id of the entity.
     */
  
    public void delete(Long id) {
        log.debug("Request to delete TIBenReferral : {}", id);
        tIBenReferralRepository.deleteById(id);
    }
}
