package gov.naco.soch.service.impl;

import gov.naco.soch.service.ICTCBeneficiaryVisitService;
import gov.naco.soch.domain.ICTCBeneficiaryVisit;
import gov.naco.soch.repository.ICTCBeneficiaryVisitRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryVisitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ICTCBeneficiaryVisit}.
 */
@Service
@Transactional
public class ICTCBeneficiaryVisitServiceImpl implements ICTCBeneficiaryVisitService {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryVisitServiceImpl.class);

    private final ICTCBeneficiaryVisitRepository iCTCBeneficiaryVisitRepository;

    private final ICTCBeneficiaryVisitMapper iCTCBeneficiaryVisitMapper;

    public ICTCBeneficiaryVisitServiceImpl(ICTCBeneficiaryVisitRepository iCTCBeneficiaryVisitRepository, ICTCBeneficiaryVisitMapper iCTCBeneficiaryVisitMapper) {
        this.iCTCBeneficiaryVisitRepository = iCTCBeneficiaryVisitRepository;
        this.iCTCBeneficiaryVisitMapper = iCTCBeneficiaryVisitMapper;
    }

    /**
     * Save a iCTCBeneficiaryVisit.
     *
     * @param iCTCBeneficiaryVisitDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCBeneficiaryVisitDTO save(ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO) {
        log.debug("Request to save ICTCBeneficiaryVisit : {}", iCTCBeneficiaryVisitDTO);
        ICTCBeneficiaryVisit iCTCBeneficiaryVisit = iCTCBeneficiaryVisitMapper.toEntity(iCTCBeneficiaryVisitDTO);
        iCTCBeneficiaryVisit = iCTCBeneficiaryVisitRepository.save(iCTCBeneficiaryVisit);
        return iCTCBeneficiaryVisitMapper.toDto(iCTCBeneficiaryVisit);
    }

    /**
     * Get all the iCTCBeneficiaryVisits.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryVisitDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCBeneficiaryVisits");
        return iCTCBeneficiaryVisitRepository.findAll(pageable)
            .map(iCTCBeneficiaryVisitMapper::toDto);
    }

    /**
     * Get one iCTCBeneficiaryVisit by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCBeneficiaryVisitDTO> findOne(Long id) {
        log.debug("Request to get ICTCBeneficiaryVisit : {}", id);
        return iCTCBeneficiaryVisitRepository.findById(id)
            .map(iCTCBeneficiaryVisitMapper::toDto);
    }

    /**
     * Delete the iCTCBeneficiaryVisit by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCBeneficiaryVisit : {}", id);
        iCTCBeneficiaryVisitRepository.deleteById(id);
    }
}
