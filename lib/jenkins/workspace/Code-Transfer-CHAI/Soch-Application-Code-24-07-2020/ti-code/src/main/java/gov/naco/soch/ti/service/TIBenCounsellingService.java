package gov.naco.soch.ti.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.TIBenCounselling;
import gov.naco.soch.entity.TIStiTreatment;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.repository.TIBenCounsellingRepository;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO;
import gov.naco.soch.ti.mapper.TIBenCounsellingMapper;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Service Implementation for managing {@link TIBenCounselling}.
 */
@Service
@Transactional
public class TIBenCounsellingService {

    private final Logger log = LoggerFactory.getLogger(TIBenCounsellingService.class);

    private final TIBenCounsellingRepository tIBenCounsellingRepository;

    private final TIBenCounsellingMapper tIBenCounsellingMapper;

    public TIBenCounsellingService(TIBenCounsellingRepository tIBenCounsellingRepository,
	    TIBenCounsellingMapper tIBenCounsellingMapper) {
	this.tIBenCounsellingRepository = tIBenCounsellingRepository;
	this.tIBenCounsellingMapper = tIBenCounsellingMapper;
    }

    /**
     * Save a tIBenCounselling.
     *
     * @param tIBenCounsellingDTO the entity to save.
     * @return the persisted entity.
     */

    public TIBenCounsellingDTO save(TIBenCounsellingDTO tIBenCounsellingDTO) {
	log.debug("Request to save TIBenCounselling : {}", tIBenCounsellingDTO);
	TIBenCounselling tIBenCounselling = tIBenCounsellingMapper.toEntity(tIBenCounsellingDTO);
	tIBenCounselling = tIBenCounsellingRepository.save(tIBenCounselling);
	if (tIBenCounsellingDTO.getPreviousId() != null) {
	    updatePreviousId(tIBenCounsellingDTO.getPreviousId());
	}
	return tIBenCounsellingMapper.toDto(tIBenCounselling);
    }

    private void updatePreviousId(Long previousId) {
	Optional<TIBenCounselling> tiCounsellingOptional = tIBenCounsellingRepository.findById(previousId);
	if (tiCounsellingOptional.isPresent()) {
	    TIBenCounselling tiCounselling = tiCounsellingOptional.get();
	    tiCounselling.setIsEarly(true);
	    tIBenCounsellingRepository.save(tiCounselling);
	}
    }

    /**
     * Get all the tIBenCounsellings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIBenCounsellingDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBenCounsellings");
	return tIBenCounsellingRepository.findAll(pageable).map(tIBenCounsellingMapper::toDto);
    }

    /**
     * Get one tIBenCounselling by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIBenCounsellingDTO> findOne(Long id) {
	log.debug("Request to get TIBenCounselling : {}", id);
	return tIBenCounsellingRepository.findById(id).map(tIBenCounsellingMapper::toDto);
    }

    /**
     * Delete the tIBenCounselling by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
	log.debug("Request to delete TIBenCounselling : {}", id);
	Optional<TIBenCounselling> tiBen = tIBenCounsellingRepository.findById(id);
	if (tiBen.isPresent()) {
	    TIBenCounselling tiBenCounselling = tiBen.get();
	    tiBenCounselling.setIsDelete(true);
	    tIBenCounsellingRepository.save(tiBenCounselling);

	}

    }

    public boolean validateMultipleCounselling(Long beneficiaryId, LocalDate counsellingDate) {
	if (beneficiaryId != null) {
	    Boolean check = tIBenCounsellingRepository.existsByBeneficiary_IdAndCounsellingDate(beneficiaryId,
		    counsellingDate);
	    if (check.equals(Boolean.TRUE)) {
		return false;
	    }
	}
	return true;
    }

}
