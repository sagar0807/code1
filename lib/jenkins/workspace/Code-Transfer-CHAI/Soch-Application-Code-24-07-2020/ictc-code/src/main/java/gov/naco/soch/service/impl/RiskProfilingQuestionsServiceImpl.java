package gov.naco.soch.service.impl;

import gov.naco.soch.service.RiskProfilingQuestionsService;
import gov.naco.soch.domain.RiskProfilingQuestions;
import gov.naco.soch.repository.RiskProfilingQuestionsRepository;
import gov.naco.soch.service.dto.RiskProfilingQuestionsDTO;
import gov.naco.soch.service.mapper.RiskProfilingQuestionsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RiskProfilingQuestions}.
 */
@Service
@Transactional
public class RiskProfilingQuestionsServiceImpl implements RiskProfilingQuestionsService {

    private final Logger log = LoggerFactory.getLogger(RiskProfilingQuestionsServiceImpl.class);

    private final RiskProfilingQuestionsRepository riskProfilingQuestionsRepository;

    private final RiskProfilingQuestionsMapper riskProfilingQuestionsMapper;

    public RiskProfilingQuestionsServiceImpl(RiskProfilingQuestionsRepository riskProfilingQuestionsRepository, RiskProfilingQuestionsMapper riskProfilingQuestionsMapper) {
        this.riskProfilingQuestionsRepository = riskProfilingQuestionsRepository;
        this.riskProfilingQuestionsMapper = riskProfilingQuestionsMapper;
    }

    /**
     * Save a riskProfilingQuestions.
     *
     * @param riskProfilingQuestionsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public RiskProfilingQuestionsDTO save(RiskProfilingQuestionsDTO riskProfilingQuestionsDTO) {
        log.debug("Request to save RiskProfilingQuestions : {}", riskProfilingQuestionsDTO);
        RiskProfilingQuestions riskProfilingQuestions = riskProfilingQuestionsMapper.toEntity(riskProfilingQuestionsDTO);
        riskProfilingQuestions = riskProfilingQuestionsRepository.save(riskProfilingQuestions);
        return riskProfilingQuestionsMapper.toDto(riskProfilingQuestions);
    }

    /**
     * Get all the riskProfilingQuestions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RiskProfilingQuestionsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RiskProfilingQuestions");
        return riskProfilingQuestionsRepository.findAll(pageable)
            .map(riskProfilingQuestionsMapper::toDto);
    }

    /**
     * Get one riskProfilingQuestions by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RiskProfilingQuestionsDTO> findOne(Long id) {
        log.debug("Request to get RiskProfilingQuestions : {}", id);
        return riskProfilingQuestionsRepository.findById(id)
            .map(riskProfilingQuestionsMapper::toDto);
    }

    /**
     * Delete the riskProfilingQuestions by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RiskProfilingQuestions : {}", id);
        riskProfilingQuestionsRepository.deleteById(id);
    }
}
