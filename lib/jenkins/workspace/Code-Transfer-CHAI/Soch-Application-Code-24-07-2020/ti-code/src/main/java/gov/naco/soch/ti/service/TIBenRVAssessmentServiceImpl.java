package gov.naco.soch.ti.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TIBenRVAssessment;
import gov.naco.soch.repository.TIBenRVAssessmentRepository;
import gov.naco.soch.ti.dto.TIBenRVAssessmentDTO;
import gov.naco.soch.ti.mapper.TIBenRVAssessmentMapper;

/**
 * Service Implementation for managing {@link TIBenRVAssessment}.
 */
@Service
@Transactional
public class TIBenRVAssessmentServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBenRVAssessmentServiceImpl.class);

    private final TIBenRVAssessmentRepository tIBenRVAssessmentRepository;

    private final TIBenRVAssessmentMapper tIBenRVAssessmentMapper;

    public TIBenRVAssessmentServiceImpl(TIBenRVAssessmentRepository tIBenRVAssessmentRepository,
	    TIBenRVAssessmentMapper tIBenRVAssessmentMapper) {
	this.tIBenRVAssessmentRepository = tIBenRVAssessmentRepository;
	this.tIBenRVAssessmentMapper = tIBenRVAssessmentMapper;
    }

    /**
     * Save a tIBenRVAssessment.
     *
     * @param tIBenRVAssessmentDTO the entity to save.
     * @return the persisted entity.
     */

    public TIBenRVAssessmentDTO save(TIBenRVAssessmentDTO tIBenRVAssessmentDTO) {
	log.debug("Request to save TIBenRVAssessment : {}", tIBenRVAssessmentDTO);
	TIBenRVAssessment tIBenRVAssessment = tIBenRVAssessmentMapper.toEntity(tIBenRVAssessmentDTO);
	tIBenRVAssessment = tIBenRVAssessmentRepository.save(tIBenRVAssessment);
	if (tIBenRVAssessmentDTO.getPreviousId() != null) {
	    updatePreviousId(tIBenRVAssessmentDTO.getPreviousId());
	}

	return tIBenRVAssessmentMapper.toDto(tIBenRVAssessment);
    }

    private void updatePreviousId(Long previousId) {
	Optional<TIBenRVAssessment> tiAssessOptional = tIBenRVAssessmentRepository.findById(previousId);
	if (tiAssessOptional.isPresent()) {
	    TIBenRVAssessment tiAssess = tiAssessOptional.get();
	    tiAssess.setIsEarly(true);
	    tIBenRVAssessmentRepository.save(tiAssess);
	}
    }

    /**
     * Get all the tIBenRVAssessments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIBenRVAssessmentDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBenRVAssessments");
	return tIBenRVAssessmentRepository.findAll(pageable).map(tIBenRVAssessmentMapper::toDto);
    }

    /**
     * Get one tIBenRVAssessment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIBenRVAssessmentDTO> findOne(Long id) {
	log.debug("Request to get TIBenRVAssessment : {}", id);
	return tIBenRVAssessmentRepository.findById(id).map(tIBenRVAssessmentMapper::toDto);
    }

    /**
     * Delete the tIBenRVAssessment by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
	log.debug("Request to delete TIBenRVAssessment : {}", id);
	Optional<TIBenRVAssessment> tiBen = tIBenRVAssessmentRepository.findById(id);
	if (tiBen.isPresent()) {
	    TIBenRVAssessment tiBenAssessment = tiBen.get();
	    tiBenAssessment.setIsDelete(true);
	    tIBenRVAssessmentRepository.save(tiBenAssessment);

	}
    }

    public boolean validateMultipleAssessment(Long beneficiaryId, LocalDate assessmentDate) {
	LocalDate latestAssessDate = tIBenRVAssessmentRepository.findLatestAssessment(beneficiaryId);
	if (latestAssessDate != null) {
	    long monthDiff = ChronoUnit.MONTHS.between(latestAssessDate, assessmentDate);
	    if (monthDiff < 3L) {
		return false;
	    }
	}
	return true;
    }

}
