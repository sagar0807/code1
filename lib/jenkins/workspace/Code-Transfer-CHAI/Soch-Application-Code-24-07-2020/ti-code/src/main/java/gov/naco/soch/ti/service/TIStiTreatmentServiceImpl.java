package gov.naco.soch.ti.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TIStiTreatment;
import gov.naco.soch.repository.TIBeneficiaryRepository;
import gov.naco.soch.repository.TIStiTreatmentRepository;
import gov.naco.soch.ti.dto.TIStiTreatmentDTO;
import gov.naco.soch.ti.mapper.TIStiTreatmentMapper;

/**
 * Service Implementation for managing {@link TIStiTreatment}.
 */
@Service
@Transactional
public class TIStiTreatmentServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIStiTreatmentServiceImpl.class);

    private final TIStiTreatmentRepository tIStiTreatmentRepository;

    private final TIBeneficiaryRepository tiBeneficiaryRepository;

    private final TIStiTreatmentMapper tIStiTreatmentMapper;

    public TIStiTreatmentServiceImpl(TIStiTreatmentRepository tIStiTreatmentRepository,
	    TIBeneficiaryRepository tiBeneficiaryRepository, TIStiTreatmentMapper tIStiTreatmentMapper) {
	this.tIStiTreatmentRepository = tIStiTreatmentRepository;
	this.tIStiTreatmentMapper = tIStiTreatmentMapper;
	this.tiBeneficiaryRepository = tiBeneficiaryRepository;
    }

    /**
     * Save a tIStiTreatment.
     *
     * @param tIStiTreatmentDTO the entity to save.
     * @return the persisted entity.
     */

    public TIStiTreatmentDTO save(TIStiTreatmentDTO tIStiTreatmentDTO) {
	log.debug("Request to save TIStiTreatment : {}", tIStiTreatmentDTO);
	TIStiTreatment tIStiTreatment = tIStiTreatmentMapper.toEntity(tIStiTreatmentDTO);
	tIStiTreatment = tIStiTreatmentRepository.save(tIStiTreatment);
	setLapAndIbTreatments(tIStiTreatmentDTO, tIStiTreatment);
	if (tIStiTreatmentDTO.getPreviousId() != null) {
	    updatePreviousId(tIStiTreatmentDTO.getPreviousId());
	}
	return tIStiTreatmentMapper.toDto(tIStiTreatment);
    }

    private void updatePreviousId(Long previousId) {
	Optional<TIStiTreatment> tiStOptional = tIStiTreatmentRepository.findById(previousId);
	if (tiStOptional.isPresent()) {
	    TIStiTreatment tiStiTreatment = tiStOptional.get();
	    tiStiTreatment.setIsEarly(true);
	    tIStiTreatmentRepository.save(tiStiTreatment);
	}
    }

    /**
     * Get all the tIStiTreatments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIStiTreatmentDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIStiTreatments");
	return tIStiTreatmentRepository.findAll(pageable).map(tIStiTreatmentMapper::toDto);
    }

    /**
     * Get one tIStiTreatment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIStiTreatmentDTO> findOne(Long id) {
	log.debug("Request to get TIStiTreatment : {}", id);
	return tIStiTreatmentRepository.findById(id).map(tIStiTreatmentMapper::toDto);
    }

    /**
     * Delete the tIStiTreatment by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
	log.debug("Request to delete TIStiTreatment : {}", id);
	Optional<TIStiTreatment> tiBen = tIStiTreatmentRepository.findById(id);
	if (tiBen.isPresent()) {
	    TIStiTreatment tIStiTreatment = tiBen.get();
	    tIStiTreatment.setIsDelete(true);
	    tIStiTreatmentRepository.save(tIStiTreatment);

	}
    }

    private void setLapAndIbTreatments(TIStiTreatmentDTO tIStiTreatmentDTO, TIStiTreatment tIStiTreatment) {
	Optional<TIBeneficiary> tiBeneficiary = tiBeneficiaryRepository
		.findById(tIStiTreatmentDTO.getBeneficiary().getId());
	if (tiBeneficiary.isPresent()) {
	    TIBeneficiary tiBen = tiBeneficiary.get();
	    tiBen.setLapTreatments(tIStiTreatmentDTO.getBeneficiary().getLapTreatments());
	    tiBen.setIbTreatments(tIStiTreatmentDTO.getBeneficiary().getIbTreatments());
	    tiBen = tiBeneficiaryRepository.save(tiBen);
	    tIStiTreatment.setBeneficiary(tiBen);
	}
    }

    public boolean validateDiagnosis(Long beneficiaryId, Long diagnosisId) {
	boolean check = tIStiTreatmentRepository.existsByBeneficiary_IdAndDiagnosisType_IdAndFollowUpDate(beneficiaryId,
		diagnosisId, LocalDate.now());
	return check;
    }
}
