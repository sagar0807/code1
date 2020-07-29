package gov.naco.soch.service.impl;

import gov.naco.soch.service.TransfersService;
import gov.naco.soch.domain.Transfers;
import gov.naco.soch.repository.TransfersRepository;
import gov.naco.soch.service.dto.TransfersDTO;
import gov.naco.soch.service.mapper.TransfersMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Transfers}.
 */
@Service
@Transactional
public class TransfersServiceImpl implements TransfersService {

    private final Logger log = LoggerFactory.getLogger(TransfersServiceImpl.class);

    private final TransfersRepository transfersRepository;

    private final TransfersMapper transfersMapper;

    public TransfersServiceImpl(TransfersRepository transfersRepository, TransfersMapper transfersMapper) {
        this.transfersRepository = transfersRepository;
        this.transfersMapper = transfersMapper;
    }

    /**
     * Save a transfers.
     *
     * @param transfersDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public TransfersDTO save(TransfersDTO transfersDTO) {
        log.debug("Request to save Transfers : {}", transfersDTO);
        Transfers transfers = transfersMapper.toEntity(transfersDTO);
        transfers = transfersRepository.save(transfers);
        return transfersMapper.toDto(transfers);
    }

    /**
     * Get all the transfers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TransfersDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Transfers");
        return transfersRepository.findAll(pageable)
            .map(transfersMapper::toDto);
    }

    /**
     * Get one transfers by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TransfersDTO> findOne(Long id) {
        log.debug("Request to get Transfers : {}", id);
        return transfersRepository.findById(id)
            .map(transfersMapper::toDto);
    }

    /**
     * Delete the transfers by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Transfers : {}", id);
        transfersRepository.deleteById(id);
    }
}
