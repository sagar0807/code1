package gov.naco.soch.service;

import gov.naco.soch.domain.BeneficiaryFacilityMapping;
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;
import gov.naco.soch.service.mapper.BeneficiaryFacilityMappingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing BeneficiaryFacilityMapping.
 */
@Service
@Transactional
public class BeneficiaryFacilityMappingService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryFacilityMappingService.class);

    private final BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;

    private final BeneficiaryFacilityMappingMapper beneficiaryFacilityMappingMapper;

    public BeneficiaryFacilityMappingService(BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository, BeneficiaryFacilityMappingMapper beneficiaryFacilityMappingMapper) {
        this.beneficiaryFacilityMappingRepository = beneficiaryFacilityMappingRepository;
        this.beneficiaryFacilityMappingMapper = beneficiaryFacilityMappingMapper;
    }

    /**
     * Save a beneficiaryFacilityMapping.
     *
     * @param beneficiaryFacilityMappingDTO the entity to save
     * @return the persisted entity
     */
    public BeneficiaryFacilityMappingDTO save(BeneficiaryFacilityMappingDTO beneficiaryFacilityMappingDTO) {
        log.debug("Request to save BeneficiaryFacilityMapping : {}", beneficiaryFacilityMappingDTO);
        BeneficiaryFacilityMapping beneficiaryFacilityMapping = beneficiaryFacilityMappingMapper.toEntity(beneficiaryFacilityMappingDTO);
        beneficiaryFacilityMapping = beneficiaryFacilityMappingRepository.save(beneficiaryFacilityMapping);
        return beneficiaryFacilityMappingMapper.toDto(beneficiaryFacilityMapping);
    }

    /**
     * Get all the beneficiaryFacilityMappings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<BeneficiaryFacilityMappingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BeneficiaryFacilityMappings");
        return beneficiaryFacilityMappingRepository.findAll(pageable)
            .map(beneficiaryFacilityMappingMapper::toDto);
    }


    /**
     * Get one beneficiaryFacilityMapping by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<BeneficiaryFacilityMappingDTO> findOne(Long id) {
        log.debug("Request to get BeneficiaryFacilityMapping : {}", id);
        return beneficiaryFacilityMappingRepository.findById(id)
            .map(beneficiaryFacilityMappingMapper::toDto);
    }

    /**
     * Delete the beneficiaryFacilityMapping by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete BeneficiaryFacilityMapping : {}", id);
        beneficiaryFacilityMappingRepository.deleteById(id);
    }
}
