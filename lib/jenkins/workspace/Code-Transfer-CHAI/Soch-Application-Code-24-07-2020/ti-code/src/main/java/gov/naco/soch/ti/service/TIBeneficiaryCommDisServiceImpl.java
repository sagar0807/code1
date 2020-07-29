package gov.naco.soch.ti.service;

import gov.naco.soch.entity.TIBeneficiaryCommDis;
import gov.naco.soch.repository.TIBeneficiaryCommDisRepository;
import gov.naco.soch.ti.dto.TIBeneficiaryCommDisDTO;
import gov.naco.soch.ti.mapper.TIBeneficiaryCommDisMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * Service Implementation for managing {@link TIBeneficiaryCommDis}.
 */
@Service
@Transactional
public class TIBeneficiaryCommDisServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiaryCommDisServiceImpl.class);

    private final TIBeneficiaryCommDisRepository tIBeneficiaryCommDisRepository;

    private final TIBeneficiaryCommDisMapper tIBeneficiaryCommDisMapper;

    public TIBeneficiaryCommDisServiceImpl(TIBeneficiaryCommDisRepository tIBeneficiaryCommDisRepository,
	    TIBeneficiaryCommDisMapper tIBeneficiaryCommDisMapper) {
	this.tIBeneficiaryCommDisRepository = tIBeneficiaryCommDisRepository;
	this.tIBeneficiaryCommDisMapper = tIBeneficiaryCommDisMapper;
    }

    /**
     * Save a tIBeneficiaryCommDis.
     *
     * @param tIBeneficiaryCommDisDTO the entity to save.
     * @return the persisted entity.
     */

    public TIBeneficiaryCommDisDTO save(TIBeneficiaryCommDisDTO tIBeneficiaryCommDisDTO) {
	log.debug("Request to save TIBeneficiaryCommDis : {}", tIBeneficiaryCommDisDTO);
	TIBeneficiaryCommDis tIBeneficiaryCommDis = tIBeneficiaryCommDisMapper.toEntity(tIBeneficiaryCommDisDTO);
	tIBeneficiaryCommDis = tIBeneficiaryCommDisRepository.save(tIBeneficiaryCommDis);
	return tIBeneficiaryCommDisMapper.toDto(tIBeneficiaryCommDis);
    }

    /**
     * Get all the tIBeneficiaryCommDis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIBeneficiaryCommDisDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBeneficiaryCommDis");
	return tIBeneficiaryCommDisRepository.findAll(pageable).map(tIBeneficiaryCommDisMapper::toDto);
    }

    /**
     * Get one tIBeneficiaryCommDis by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIBeneficiaryCommDisDTO> findOne(Long id) {
	log.debug("Request to get TIBeneficiaryCommDis : {}", id);
	return tIBeneficiaryCommDisRepository.findById(id).map(tIBeneficiaryCommDisMapper::toDto);
    }

    /**
     * Delete the tIBeneficiaryCommDis by id.
     *
     * @param id the id of the entity.
     */

    public void delete(Long id) {
	log.debug("Request to delete TIBeneficiaryCommDis : {}", id);
	tIBeneficiaryCommDisRepository.deleteById(id);
    }

    public boolean validateMultipleDistribution(Long beneficiaryId,LocalDate distributionDate) {
	if (beneficiaryId != null) {
	    Boolean check = tIBeneficiaryCommDisRepository.existsByBeneficiary_IdAndDistributionDate(beneficiaryId,distributionDate);
	    if (check.equals(Boolean.TRUE)) {
		return false;
	    }
	}
	return true;
    }
}
