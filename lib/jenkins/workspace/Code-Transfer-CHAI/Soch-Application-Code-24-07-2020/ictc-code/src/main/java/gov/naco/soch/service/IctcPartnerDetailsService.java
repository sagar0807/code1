package gov.naco.soch.service;

import gov.naco.soch.domain.IctcPartnerDetails;
import gov.naco.soch.repository.IctcPartnerDetailsRepository;
import gov.naco.soch.service.dto.IctcPartnerDetailsDTO;
import gov.naco.soch.service.mapper.IctcPartnerDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/**
 * Service Implementation for managing IctcPartnerDetails.
 */
@Service
@Transactional
public class IctcPartnerDetailsService {

    private final Logger log = LoggerFactory.getLogger(IctcPartnerDetailsService.class);

    private final IctcPartnerDetailsRepository ictcPartnerDetailsRepository;

    private final IctcPartnerDetailsMapper ictcPartnerDetailsMapper;

    public IctcPartnerDetailsService(IctcPartnerDetailsRepository ictcPartnerDetailsRepository, IctcPartnerDetailsMapper ictcPartnerDetailsMapper) {
        this.ictcPartnerDetailsRepository = ictcPartnerDetailsRepository;
        this.ictcPartnerDetailsMapper = ictcPartnerDetailsMapper;
    }

    /**
     * Save a ictcPartnerDetails.
     *
     * @param ictcPartnerDetailsDTO the entity to save
     * @return the persisted entity
     */
    public IctcPartnerDetailsDTO save(IctcPartnerDetailsDTO ictcPartnerDetailsDTO) {
        log.debug("Request to save IctcPartnerDetails : {}", ictcPartnerDetailsDTO);
        IctcPartnerDetails ictcPartnerDetails = ictcPartnerDetailsMapper.toEntity(ictcPartnerDetailsDTO);
        ictcPartnerDetails = ictcPartnerDetailsRepository.save(ictcPartnerDetails);
        return ictcPartnerDetailsMapper.toDto(ictcPartnerDetails);
    }

    /**
     * Get all the ictcPartnerDetails.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<IctcPartnerDetailsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all IctcPartnerDetails");
        return ictcPartnerDetailsRepository.findAll(pageable)
            .map(ictcPartnerDetailsMapper::toDto);
    }
    
    @Transactional(readOnly = true)
    public List<IctcPartnerDetailsDTO> findByBeneficiaryId(Long beneficiaryId) {
        log.debug("Request to get all IctcPartnerDetails");
        return ictcPartnerDetailsMapper.toDto(ictcPartnerDetailsRepository.findByBeneficaryId(beneficiaryId));
    }



    /**
     * Get one ictcPartnerDetails by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<IctcPartnerDetailsDTO> findOne(Long id) {
        log.debug("Request to get IctcPartnerDetails : {}", id);
        return ictcPartnerDetailsRepository.findById(id)
            .map(ictcPartnerDetailsMapper::toDto);
    }

    /**
     * Delete the ictcPartnerDetails by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete IctcPartnerDetails : {}", id);
        ictcPartnerDetailsRepository.deleteById(id);
    }
}
