package gov.naco.soch.ti.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.ti.dto.TIBenfExtDetailsDTO;
import gov.naco.soch.entity.TIBeneficiaryExtDetails;
import gov.naco.soch.repository.TIBeneficiaryExtDetailsRepository;
import gov.naco.soch.ti.mapper.TIBenExtDetailsMapper;

/**
 * Service Implementation for managing {@link TIBenExtDetails}.
 */
@Service
@Transactional
public class TIBenExtDetailsServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBenExtDetailsServiceImpl.class);

    private final TIBeneficiaryExtDetailsRepository tIBenExtDetailsRepository;

    private final TIBenExtDetailsMapper tIBenExtDetailsMapper;

    public TIBenExtDetailsServiceImpl(TIBeneficiaryExtDetailsRepository tIBenExtDetailsRepository, TIBenExtDetailsMapper tIBenExtDetailsMapper) {
        this.tIBenExtDetailsRepository = tIBenExtDetailsRepository;
        this.tIBenExtDetailsMapper = tIBenExtDetailsMapper;
    }

    /**
     * Save a tIBenExtDetails.
     *
     * @param tIBenExtDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    
    public TIBenfExtDetailsDTO save(TIBenfExtDetailsDTO tIBenExtDetailsDTO) {
        log.debug("Request to save TIBenExtDetails : {}", tIBenExtDetailsDTO);
        TIBeneficiaryExtDetails tIBenExtDetails = tIBenExtDetailsMapper.toEntity(tIBenExtDetailsDTO);
        tIBenExtDetails = tIBenExtDetailsRepository.save(tIBenExtDetails);
        return tIBenExtDetailsMapper.toDto(tIBenExtDetails);
    }

    /**
     * Get all the tIBenExtDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    
    @Transactional(readOnly = true)
    public Page<TIBenfExtDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TIBenExtDetails");
        return tIBenExtDetailsRepository.findAll(pageable)
            .map(tIBenExtDetailsMapper::toDto);
    }


    /**
     * Get one tIBenExtDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    
    @Transactional(readOnly = true)
    public Optional<TIBenfExtDetailsDTO> findOne(Long id) {
        log.debug("Request to get TIBenExtDetails : {}", id);
        return tIBenExtDetailsRepository.findById(id)
            .map(tIBenExtDetailsMapper::toDto);
    }

    /**
     * Delete the tIBenExtDetails by id.
     *
     * @param id the id of the entity.
     */
  
    public void delete(Long id) {
        log.debug("Request to delete TIBenExtDetails : {}", id);
        tIBenExtDetailsRepository.deleteById(id);
    }
}
