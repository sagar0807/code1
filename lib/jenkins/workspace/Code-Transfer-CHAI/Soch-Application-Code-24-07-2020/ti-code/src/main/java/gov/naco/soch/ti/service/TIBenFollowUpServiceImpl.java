package gov.naco.soch.ti.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.repository.TIOstFollowUpRepository;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.ti.dto.TIBenFollowUpDTO;
import gov.naco.soch.ti.mapper.TIBenFollowUpMapper;

/**
 * Service Implementation for managing {@link TIBenFollowUp}.
 */
@Service
@Transactional
public class TIBenFollowUpServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBenFollowUpServiceImpl.class);

    private final TIOstFollowUpRepository tIOstFollowUpRepository;

    private final TIBenFollowUpMapper tIBenFollowUpMapper;

    private final TiOstBeneficiaryRepository tiOstBeneficiaryRepository;

    public TIBenFollowUpServiceImpl(TIOstFollowUpRepository tIBenFollowUpRepository,
	    TiOstBeneficiaryRepository tiOstBeneficiaryRepository, TIBenFollowUpMapper tIBenFollowUpMapper) {
	this.tIOstFollowUpRepository = tIBenFollowUpRepository;
	this.tIBenFollowUpMapper = tIBenFollowUpMapper;
	this.tiOstBeneficiaryRepository = tiOstBeneficiaryRepository;
    }

    /**
     * Save a tIBenFollowUp.
     *
     * @param tIBenFollowUpDTO the entity to save.
     * @return the persisted entity.
     */

    public TIBenFollowUpDTO save(TIBenFollowUpDTO tIBenFollowUpDTO) {
	log.debug("Request to save TIBenFollowUp : {}", tIBenFollowUpDTO);
	TiOstFollowUp tIBenFollowUp = tIBenFollowUpMapper.toEntity(tIBenFollowUpDTO);
	tIBenFollowUp = tIOstFollowUpRepository.save(tIBenFollowUp);
	Optional<TiOstBeneficiary> ostBeneficiary = tiOstBeneficiaryRepository
		.findById(tIBenFollowUpDTO.getTiOstBeneficiary().getId());
	if (ostBeneficiary.isPresent()) {
	    TiOstBeneficiary tiOstBeneficiary = ostBeneficiary.get();
	    tiOstBeneficiary.setFollowups(tIBenFollowUpDTO.getTiOstBeneficiary().getFollowups());
	    tiOstBeneficiary = tiOstBeneficiaryRepository.save(tiOstBeneficiary);
	    tIBenFollowUp.setTiOstBeneficiary(tiOstBeneficiary);
	}
	if (tIBenFollowUpDTO.getPreviousId() != null) {
	    updatePreviousId(tIBenFollowUpDTO.getPreviousId());
	}
	return tIBenFollowUpMapper.toDto(tIBenFollowUp);
    }

    private void updatePreviousId(Long previousId) {
	Optional<TiOstFollowUp> tiFollowupOptional = tIOstFollowUpRepository.findById(previousId);
	if (tiFollowupOptional.isPresent()) {
	    TiOstFollowUp tiFollowup = tiFollowupOptional.get();
	    tiFollowup.setIsEarly(true);
	    tIOstFollowUpRepository.save(tiFollowup);
	}

    }

    public TIBenFollowUpDTO update(TIBenFollowUpDTO tIBenFollowUpDTO) {
	log.debug("Request to update TIBenFollowUp : {}", tIBenFollowUpDTO);
	Optional<TiOstFollowUp> tiOstFollowUp = tIOstFollowUpRepository.findById(tIBenFollowUpDTO.getId());
	if (tiOstFollowUp.isPresent()) {
	    TiOstFollowUp followUp = tIBenFollowUpMapper.toUpdateEntity(tIBenFollowUpDTO, tiOstFollowUp.get());
	    followUp = tIOstFollowUpRepository.save(followUp);
	    Optional<TiOstBeneficiary> ostBeneficiary = tiOstBeneficiaryRepository
		    .findById(tIBenFollowUpDTO.getTiOstBeneficiary().getId());
	    if (ostBeneficiary.isPresent()) {
		TiOstBeneficiary tiOstBeneficiary = ostBeneficiary.get();
		tiOstBeneficiary.setFollowups(tIBenFollowUpDTO.getTiOstBeneficiary().getFollowups());
		tiOstBeneficiary = tiOstBeneficiaryRepository.save(tiOstBeneficiary);
		followUp.setTiOstBeneficiary(tiOstBeneficiary);
	    }
	    return tIBenFollowUpMapper.toDto(followUp);
	}

	return null;
    }

    /**
     * Get all the tIBenFollowUps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIBenFollowUpDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBenFollowUps");
	return tIOstFollowUpRepository.findAll(pageable).map(tIBenFollowUpMapper::toDto);
    }

    /**
     * Get one tIBenFollowUp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIBenFollowUpDTO> findOne(Long id) {
	log.debug("Request to get TIBenFollowUp : {}", id);
	return tIOstFollowUpRepository.findById(id).map(tIBenFollowUpMapper::toDto);
    }

    /**
     * Delete the tIBenFollowUp by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
	log.debug("Request to delete TIBenFollowUp : {}", id);
	Optional<TiOstFollowUp> tiBen = tIOstFollowUpRepository.findById(id);
	if (tiBen.isPresent()) {
	    TiOstFollowUp tiOstFollowUp = tiBen.get();
	    tiOstFollowUp.setIsDelete(true);
	    tIOstFollowUpRepository.save(tiOstFollowUp);

	}
    }

}
