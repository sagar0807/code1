package gov.naco.soch.ti.service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.TIBenScrDetails;
import gov.naco.soch.repository.TIBenScrDetailsRepository;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO;
import gov.naco.soch.ti.mapper.TIBenScrDetailsMapper;

/**
 * Service Implementation for managing {@link TIBenScrDetails}.
 */
@Service
@Transactional
public class TIBenScrDetailsServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBenScrDetailsServiceImpl.class);

    private final TIBenScrDetailsRepository tIBenScrDetailsRepository;

    private final TIBenScrDetailsMapper tIBenScrDetailsMapper;

    public TIBenScrDetailsServiceImpl(TIBenScrDetailsRepository tIBenScrDetailsRepository,
	    TIBenScrDetailsMapper tIBenScrDetailsMapper) {
	this.tIBenScrDetailsRepository = tIBenScrDetailsRepository;
	this.tIBenScrDetailsMapper = tIBenScrDetailsMapper;
    }

    /**
     * Save a tIBenScrDetails.
     *
     * @param tIBenScrDetailsDTO the entity to save.
     * @return the persisted entity.
     */

    public TIBenScrDetailsDTO save(TIBenScrDetailsDTO tIBenScrDetailsDTO) {
	log.debug("Request to save TIBenScrDetails : {}", tIBenScrDetailsDTO);
	if (tIBenScrDetailsDTO.getBeneficiaryReferral() != null) {
	    tIBenScrDetailsDTO.getBeneficiaryReferral().setReferredToFacility(7l);
	    tIBenScrDetailsDTO.getBeneficiaryReferral().setIsDelete(false);
	}
	if (tIBenScrDetailsDTO.getBeneficiaryReferral() != null
		&& tIBenScrDetailsDTO.getBeneficiaryReferral().getReferralReason() != null) {
	    BeneficiaryReferralDto beneficiaryReferralDto = tIBenScrDetailsDTO.getBeneficiaryReferral();
	    if (tIBenScrDetailsDTO.getInfection().getId() == 1) {
		beneficiaryReferralDto.setFacilityType(11);
	    } else if (tIBenScrDetailsDTO.getInfection().getId() == 3) {
		beneficiaryReferralDto.setFacilityType(14);
	    } else if (tIBenScrDetailsDTO.getInfection().getId() == 2) {
		beneficiaryReferralDto.setFacilityType(12);
	    }
	    tIBenScrDetailsDTO.setBeneficiaryReferral(beneficiaryReferralDto);
	}
	TIBenScrDetails tIBenScrDetails = tIBenScrDetailsMapper.toEntity(tIBenScrDetailsDTO);
	tIBenScrDetails = tIBenScrDetailsRepository.save(tIBenScrDetails);
	if (tIBenScrDetails.getBeneficiaryReferral() != null) {
	    tIBenScrDetails.getBeneficiaryReferral().setFacility2(null);
	    tIBenScrDetailsRepository.save(tIBenScrDetails);
	}
	if (tIBenScrDetailsDTO.getPreviousId() != null) {
	    updatePreviousId(tIBenScrDetailsDTO.getPreviousId());
	}
	return tIBenScrDetailsMapper.toDto(tIBenScrDetails);
    }

    private void updatePreviousId(Long previousId) {
	Optional<TIBenScrDetails> tiScreeningOptional = tIBenScrDetailsRepository.findById(previousId);
	if (tiScreeningOptional.isPresent()) {
	    TIBenScrDetails tiScreening = tiScreeningOptional.get();
	    tiScreening.setIsEarly(true);
	    tIBenScrDetailsRepository.save(tiScreening);
	}
    }

    /**
     * Get all the tIBenScrDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIBenScrDetailsDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBenScrDetails");
	return tIBenScrDetailsRepository.findAll(pageable).map(tIBenScrDetailsMapper::toDto);
    }

    /**
     * Get one tIBenScrDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIBenScrDetailsDTO> findOne(Long id) {
	log.debug("Request to get TIBenScrDetails : {}", id);
	return tIBenScrDetailsRepository.findById(id).map(tIBenScrDetailsMapper::toDto);
    }

    /**
     * Delete the tIBenScrDetails by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
	log.debug("Request to delete TIBenScrDetails : {}", id);
	Optional<TIBenScrDetails> tiBen = tIBenScrDetailsRepository.findById(id);
	if (tiBen.isPresent()) {
	    TIBenScrDetails tIBenScrDetails = tiBen.get();
	    tIBenScrDetails.setIsDeleted(true);
	    tIBenScrDetailsRepository.save(tIBenScrDetails);

	}

    }

    @Transactional(readOnly = true)
    public List<TIBenScrDetailsDTO> findScreeningDetailsByBeneficiary(Long beneficiaryId) {
	Stream<TIBenScrDetails> responseList = tIBenScrDetailsRepository
		.findScreeningDetailsByBeneficiary(beneficiaryId);
	List<TIBenScrDetailsDTO> screeningList = tIBenScrDetailsMapper.toDtoList(responseList);
	return screeningList;
    }

    public Long findByInfectionAndBeneficiary(Long infectionId, Long beneficiaryId) {
	return tIBenScrDetailsRepository.findLatestRecord(infectionId, beneficiaryId);
    }

    public boolean validateMultipleScreening(Long beneficiaryId, Long infectionId, ZonedDateTime dateOfScreening) {
	ZonedDateTime latestScreeningDate = tIBenScrDetailsRepository.findLatestScreeningDate(beneficiaryId,
		infectionId);
	if (latestScreeningDate != null&&dateOfScreening!=null) {
	    long monthDiff = ChronoUnit.MONTHS.between(latestScreeningDate.toLocalDate(),
		    dateOfScreening.toLocalDate());
	    if (monthDiff < 3L) {
		return false;
	    }
	}
	return true;
    }
}
