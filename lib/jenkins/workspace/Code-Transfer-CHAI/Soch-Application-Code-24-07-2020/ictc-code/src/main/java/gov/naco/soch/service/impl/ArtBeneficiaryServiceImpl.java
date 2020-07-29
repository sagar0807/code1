package gov.naco.soch.service.impl;

import gov.naco.soch.service.ArtBeneficiaryService;
import gov.naco.soch.domain.ArtBeneficiary;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.service.dto.ArtBeneficiaryDTO;
import gov.naco.soch.service.mapper.ArtBeneficiaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing ArtBeneficiary.
 */
@Service
@Transactional
public class ArtBeneficiaryServiceImpl implements ArtBeneficiaryService {

    private final Logger log = LoggerFactory.getLogger(ArtBeneficiaryServiceImpl.class);

    private final ArtBeneficiaryRepository artBeneficiaryRepository;

    private final ArtBeneficiaryMapper artBeneficiaryMapper;

    public ArtBeneficiaryServiceImpl(ArtBeneficiaryRepository artBeneficiaryRepository, ArtBeneficiaryMapper artBeneficiaryMapper) {
        this.artBeneficiaryRepository = artBeneficiaryRepository;
        this.artBeneficiaryMapper = artBeneficiaryMapper;
    }

    /**
     * Save a artBeneficiary.
     *
     * @param artBeneficiaryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ArtBeneficiaryDTO save(ArtBeneficiaryDTO artBeneficiaryDTO) {
        log.debug("Request to save ArtBeneficiary : {}", artBeneficiaryDTO);
        ArtBeneficiary artBeneficiary = artBeneficiaryMapper.toEntity(artBeneficiaryDTO);
        artBeneficiary = artBeneficiaryRepository.save(artBeneficiary);
        return artBeneficiaryMapper.toDto(artBeneficiary);
    }

    /**
     * Get all the artBeneficiaries.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ArtBeneficiaryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ArtBeneficiaries");
        return artBeneficiaryRepository.findAll(pageable)
            .map(artBeneficiaryMapper::toDto);
    }


    /**
     * Get one artBeneficiary by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ArtBeneficiaryDTO> findOne(Long id) {
        log.debug("Request to get ArtBeneficiary : {}", id);
        return artBeneficiaryRepository.findById(id)
            .map(artBeneficiaryMapper::toDto);
    }

    /**
     * Delete the artBeneficiary by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ArtBeneficiary : {}", id);
        artBeneficiaryRepository.deleteById(id);
    }
}
