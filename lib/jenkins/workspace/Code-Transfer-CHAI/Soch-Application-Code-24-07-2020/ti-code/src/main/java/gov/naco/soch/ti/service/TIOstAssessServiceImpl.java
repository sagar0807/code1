package gov.naco.soch.ti.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.MasterBeneficiaryOstStatus;
import gov.naco.soch.entity.MasterClientStatus;
import gov.naco.soch.entity.MasterOstClientStatus;
import gov.naco.soch.entity.MasterTiClientStatus;
import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.repository.TIOSTAssessmentRepository;
import gov.naco.soch.repository.TIOstFollowUpRepository;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.ti.dto.TIOstAssessDTO;
import gov.naco.soch.ti.mapper.TIOstAssessMapper;

/**
 * Service Implementation for managing {@link TIOstAssess}.
 */
@Service
@Transactional
public class TIOstAssessServiceImpl {

	private final Logger log = LoggerFactory.getLogger(TIOstAssessServiceImpl.class);

	private final TIOSTAssessmentRepository tIOstAssessRepository;

	private final TIOstAssessMapper tIOstAssessMapper;

	private final TIOstFollowUpRepository followUpRepository;

	private final TiOstBeneficiaryRepository ostBeneficiaryRepository;

	public TIOstAssessServiceImpl(TIOSTAssessmentRepository tIOstAssessRepository,
			TIOstFollowUpRepository followUpRepository, TIOstAssessMapper tIOstAssessMapper,
			TiOstBeneficiaryRepository ostBeneficiaryRepository) {
		this.tIOstAssessRepository = tIOstAssessRepository;
		this.followUpRepository = followUpRepository;
		this.tIOstAssessMapper = tIOstAssessMapper;
		this.ostBeneficiaryRepository = ostBeneficiaryRepository;
	}

	/**
	 * Save a tIOstAssess.
	 *
	 * @param tIOstAssessDTO
	 *            the entity to save.
	 * @return the persisted entity.
	 */

	public TIOstAssessDTO save(TIOstAssessDTO tIOstAssessDTO) {
		log.debug("Request to save TIOstAssess : {}", tIOstAssessDTO);
		Optional<TiOstBeneficiary> ostBeneficiary = ostBeneficiaryRepository
				.findById(tIOstAssessDTO.getTiOstBeneficiary().getId());
		if (ostBeneficiary.isPresent()) {
			boolean check = false;
			TiOstBeneficiary tiOstBeneficiary = ostBeneficiary.get();
			if (tiOstBeneficiary.getOstStatus() != null
					&& tIOstAssessDTO.getTiOstBeneficiary().getOstStatus() != null) {
				MasterBeneficiaryOstStatus ostStatus = tiOstBeneficiary.getOstStatus();
				if (ostStatus.getId() != tIOstAssessDTO.getTiOstBeneficiary().getOstStatus().getId()) {
					check = true;
					MasterBeneficiaryOstStatus newOstStatus = new MasterBeneficiaryOstStatus();
					newOstStatus.setId(tIOstAssessDTO.getTiOstBeneficiary().getOstStatus().getId());
					tiOstBeneficiary.setOstStatus(newOstStatus);
				}
			}
			if (tiOstBeneficiary.getBeneficiary().getMasterClientStatus() != null
					&& tIOstAssessDTO.getTiOstBeneficiary().getMasterBeneficiary().getMasterClientStatus() != null) {
				MasterClientStatus clientStatus = tiOstBeneficiary.getBeneficiary().getMasterClientStatus();
				if (clientStatus.getId() != tIOstAssessDTO.getTiOstBeneficiary().getMasterBeneficiary()
						.getMasterClientStatus().getId()) {
					check = true;
					MasterClientStatus newClientStatus = new MasterClientStatus();
					newClientStatus.setId(tIOstAssessDTO.getTiOstBeneficiary().getMasterBeneficiary()
							.getMasterClientStatus().getId());
					tiOstBeneficiary.getBeneficiary().setMasterClientStatus(newClientStatus);
				}
			}
			
			if (tiOstBeneficiary.getStatus()!= null
				&& tIOstAssessDTO.getTiOstBeneficiary().getStatus() != null) {
			MasterOstClientStatus status= tiOstBeneficiary.getStatus();
			if (status.getId() != tIOstAssessDTO.getTiOstBeneficiary().getStatus().getId()) {
				check = true;
				MasterOstClientStatus statusOst = new MasterOstClientStatus();
				statusOst.setId(tIOstAssessDTO.getTiOstBeneficiary().getStatus().getId());
				tiOstBeneficiary.setStatus(statusOst);
			}
		}

			if (tiOstBeneficiary.getConsentTakenDate() != tIOstAssessDTO.getTiOstBeneficiary().getConsentTakenDate()) {
				check = true;
				tiOstBeneficiary.setConsentTakenDate(tIOstAssessDTO.getTiOstBeneficiary().getConsentTakenDate());
			}
			if (tiOstBeneficiary.getOstNumber() != tIOstAssessDTO.getTiOstBeneficiary().getOstNumber()) {
				check = true;
				tiOstBeneficiary.setOstNumber(tIOstAssessDTO.getTiOstBeneficiary().getOstNumber());
			}
			if (check == true) {
				tiOstBeneficiary = ostBeneficiaryRepository.save(tiOstBeneficiary);
			}

		}
		TiOstAssessment tIOstAssess = tIOstAssessMapper.toEntity(tIOstAssessDTO);
		tIOstAssess = tIOstAssessRepository.save(tIOstAssess);
		return tIOstAssessMapper.toDto(tIOstAssess);
	}

	public TIOstAssessDTO update(TIOstAssessDTO tIOstAssessDTO) {
		log.debug("Request to update TIOstAssess : {}", tIOstAssessDTO);
		Optional<TiOstAssessment> tiOstAssessment = tIOstAssessRepository.findById(tIOstAssessDTO.getId());
		TiOstFollowUp ostFollowUp = followUpRepository
				.findByTiOstBeneficiary_IdAndNextFollowupDate(tIOstAssessDTO.getTiOstBeneficiary().getId(), null);
		if (tiOstAssessment.isPresent()) {
			TiOstAssessment tIOstAssess = tIOstAssessMapper.toUpdateEntity(tIOstAssessDTO, tiOstAssessment.get());
			tIOstAssess = tIOstAssessRepository.save(tIOstAssess);
			if (ostFollowUp != null) {
				ostFollowUp.setNextFollowupDate(tIOstAssessDTO.getNextFollowUpDate());
				followUpRepository.save(ostFollowUp);
			}
			TIOstAssessDTO response = tIOstAssessMapper.toDto(tIOstAssess);
			response.setNextFollowUpDate(tIOstAssessDTO.getNextFollowUpDate());
			return response;
		}

		return null;
	}

	/**
	 * Get all the tIOstAssesses.
	 *
	 * @param pageable
	 *            the pagination information.
	 * @return the list of entities.
	 */

	@Transactional(readOnly = true)
	public Page<TIOstAssessDTO> findAll(Pageable pageable) {
		log.debug("Request to get all TIOstAssesses");
		return tIOstAssessRepository.findAll(pageable).map(tIOstAssessMapper::toDto);
	}

	/**
	 * Get one tIOstAssess by id.
	 *
	 * @param id
	 *            the id of the entity.
	 * @return the entity.
	 */

	@Transactional(readOnly = true)
	public Optional<TIOstAssessDTO> findOne(Long id) {
		log.debug("Request to get TIOstAssess : {}", id);
		return tIOstAssessRepository.findById(id).map(tIOstAssessMapper::toDto);
	}

	/**
	 * Delete the tIOstAssess by id.
	 *
	 * @param id
	 *            the id of the entity.
	 */

	public void delete(Long id) {
		log.debug("Request to delete TIOstAssess : {}", id);
		Optional<TiOstAssessment> tiBen = tIOstAssessRepository.findById(id);
		if (tiBen.isPresent()) {
			TiOstAssessment tiOstAssessment = tiBen.get();
			tiOstAssessment.setIsDelete(true);
			tIOstAssessRepository.save(tiOstAssessment);

		}
	}

	public boolean validateOstNumberForExistingBeneficiary(String ostNumber, Long beneficiaryId, Long facilityId) {

		if (ostNumber != null) {
			Optional<TiOstBeneficiary> tiBen = ostBeneficiaryRepository
					.findByOstNumberAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
							ostNumber, facilityId, false, beneficiaryId);
			if (tiBen.isPresent()) {
				return false;
			}

		}
		return true;
	}
}
