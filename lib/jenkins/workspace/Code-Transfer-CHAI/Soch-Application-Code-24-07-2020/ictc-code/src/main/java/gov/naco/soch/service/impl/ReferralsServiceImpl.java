package gov.naco.soch.service.impl;

import gov.naco.soch.service.ReferralsService;
import gov.naco.soch.domain.Referrals;
import gov.naco.soch.repository.ReferralsRepository;
import gov.naco.soch.service.dto.ReferralsDTO;
import gov.naco.soch.service.mapper.ReferralsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Referrals}.
 */
@Service
@Transactional
public class ReferralsServiceImpl implements ReferralsService {

    private final Logger log = LoggerFactory.getLogger(ReferralsServiceImpl.class);

    private final ReferralsRepository referralsRepository;

    private final ReferralsMapper referralsMapper;

    public ReferralsServiceImpl(ReferralsRepository referralsRepository, ReferralsMapper referralsMapper) {
        this.referralsRepository = referralsRepository;
        this.referralsMapper = referralsMapper;
    }

    /**
     * Save a referrals.
     *
     * @param referralsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReferralsDTO save(ReferralsDTO referralsDTO) {
        log.debug("Request to save Referrals : {}", referralsDTO);
        Referrals referrals = referralsMapper.toEntity(referralsDTO);
        referrals = referralsRepository.save(referrals);
        return referralsMapper.toDto(referrals);
    }

    /**
     * Get all the referrals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReferralsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Referrals");
        return referralsRepository.findAll(pageable)
            .map(referralsMapper::toDto);
    }

    /**
     * Get one referrals by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReferralsDTO> findOne(Long id) {
        log.debug("Request to get Referrals : {}", id);
        return referralsRepository.findById(id)
            .map(referralsMapper::toDto);
    }

    /**
     * Delete the referrals by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Referrals : {}", id);
        referralsRepository.deleteById(id);
    }
}
