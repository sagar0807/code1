package gov.naco.soch.service.impl;

import gov.naco.soch.service.BeneficiaryFamilyDetailsService;
import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;
import gov.naco.soch.service.mapper.BeneficiaryFamilyDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BeneficiaryFamilyDetails}.
 */
@Service
@Transactional
public class BeneficiaryFamilyDetailsServiceImpl implements BeneficiaryFamilyDetailsService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryFamilyDetailsServiceImpl.class);

    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;

    private final BeneficiaryFamilyDetailsMapper beneficiaryFamilyDetailsMapper;

    public BeneficiaryFamilyDetailsServiceImpl(BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository, BeneficiaryFamilyDetailsMapper beneficiaryFamilyDetailsMapper) {
        this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
        this.beneficiaryFamilyDetailsMapper = beneficiaryFamilyDetailsMapper;
    }

    /**
     * Save a beneficiaryFamilyDetails.
     *
     * @param beneficiaryFamilyDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BeneficiaryFamilyDetailsDTO save(BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO) {
        log.debug("Request to save BeneficiaryFamilyDetails : {}", beneficiaryFamilyDetailsDTO);
        BeneficiaryFamilyDetails beneficiaryFamilyDetails = beneficiaryFamilyDetailsMapper.toEntity(beneficiaryFamilyDetailsDTO);
        beneficiaryFamilyDetails = beneficiaryFamilyDetailsRepository.save(beneficiaryFamilyDetails);
        return beneficiaryFamilyDetailsMapper.toDto(beneficiaryFamilyDetails);
    }

    /**
     * Get all the beneficiaryFamilyDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BeneficiaryFamilyDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BeneficiaryFamilyDetails");
        return beneficiaryFamilyDetailsRepository.findAll(pageable)
            .map(beneficiaryFamilyDetailsMapper::toDto);
    }

    /**
     * Get one beneficiaryFamilyDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BeneficiaryFamilyDetailsDTO> findOne(Long id) {
        log.debug("Request to get BeneficiaryFamilyDetails : {}", id);
        return beneficiaryFamilyDetailsRepository.findById(id)
            .map(beneficiaryFamilyDetailsMapper::toDto);
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Optional<BeneficiaryFamilyDetails> findById(Long id) {
        log.debug("Request to get BeneficiaryFamilyDetails : {}", id);
        return beneficiaryFamilyDetailsRepository.findById(id);
    }

    /**
     * Delete the beneficiaryFamilyDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BeneficiaryFamilyDetails : {}", id);
        beneficiaryFamilyDetailsRepository.deleteById(id);
    }
}
