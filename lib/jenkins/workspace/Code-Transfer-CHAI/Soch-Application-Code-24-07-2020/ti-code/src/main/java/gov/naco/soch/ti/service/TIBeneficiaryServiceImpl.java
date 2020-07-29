package gov.naco.soch.ti.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterBeneficiaryDeleteReason;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.Town;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.TIBeneficiaryRepository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenTransferDto;
import gov.naco.soch.ti.mapper.BeneficiaryMapper;
import gov.naco.soch.ti.mapper.TIBeneficiaryMapper;

/**
 * Service Implementation for managing {@link TIBeneficiary}.
 */
@Service
@Transactional
public class TIBeneficiaryServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiaryServiceImpl.class);

    private final TIBeneficiaryRepository tIBeneficiaryRepository;

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private BeneficiaryReferralRepository beneficiaryReferralRepository;

    @Autowired
    private BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private BeneficiaryMapper beneficiaryMapper;

    private final TIBeneficiaryMapper tIBeneficiaryMapper;

    public TIBeneficiaryServiceImpl(TIBeneficiaryRepository tIBeneficiaryRepository,
	    TIBeneficiaryMapper tIBeneficiaryMapper) {
	this.tIBeneficiaryRepository = tIBeneficiaryRepository;
	this.tIBeneficiaryMapper = tIBeneficiaryMapper;
    }

    /**
     * Save a tIBeneficiary.
     *
     * @param tIBeneficiaryDTO the entity to save.
     * @return the persisted entity.
     */

    public TIBeneficiaryDTO save(TIBeneficiaryDTO tIBeneficiaryDTO) {
	log.info("Request to save TIBeneficiary : {}", tIBeneficiaryDTO);
	boolean subDistrictTownCheck = false;
	TIBeneficiary tIBeneficiary = tIBeneficiaryMapper.toEntity(tIBeneficiaryDTO);
	if (tIBeneficiaryDTO.getMasterBeneficiary().getId() != null) {
	    Beneficiary benef = beneficiaryRepository.findById(tIBeneficiaryDTO.getMasterBeneficiary().getId()).get();
	    Beneficiary beneficiary = beneficiaryMapper.toUpdateEntity(tIBeneficiaryDTO.getMasterBeneficiary(), benef);
	    beneficiary.setTiCode(tIBeneficiary.getTiCode());
	    beneficiary = beneficiaryRepository.save(beneficiary);
	    tIBeneficiary.setBeneficiary(beneficiary);
	    tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    setSubDistrictAndTown(tIBeneficiaryDTO, tIBeneficiary, subDistrictTownCheck);
	    if (subDistrictTownCheck) {
		tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    }

	    saveOutwardReferral(tIBeneficiaryDTO, tIBeneficiary);
	    saveTransfer(tIBeneficiaryDTO, tIBeneficiary);
	} else {
	    tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    setSubDistrictAndTown(tIBeneficiaryDTO, tIBeneficiary, subDistrictTownCheck);
	    if (subDistrictTownCheck) {
		tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    }
	    if (tIBeneficiary != null && tIBeneficiary.getBeneficiary().getUid() == null) {
		tIBeneficiary.getBeneficiary().setUid("U" + Long.valueOf(tIBeneficiary.getBeneficiary().getId()));
		tIBeneficiary.getBeneficiary().setTiCode(tIBeneficiary.getTiCode());
		tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    }

	}
	return tIBeneficiaryMapper.toDto(tIBeneficiary);

    }

    public TIBeneficiaryDTO update(TIBeneficiaryDTO tIBeneficiaryDTO) {

	log.info("Request to update TIBeneficiary : {}", tIBeneficiaryDTO);
	Optional<TIBeneficiary> tiBen = tIBeneficiaryRepository.findById(tIBeneficiaryDTO.getId());
	if (tiBen.isPresent()) {
	    TIBeneficiary tiBeneficiary = tiBen.get();
	    boolean subDistrictTownCheck = false;
	    TIBeneficiary tIBeneficiary = tIBeneficiaryMapper.toUpdateEntity(tIBeneficiaryDTO, tiBeneficiary);
	    tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    setSubDistrictAndTown(tIBeneficiaryDTO, tIBeneficiary, subDistrictTownCheck);
	    if (subDistrictTownCheck) {
		tIBeneficiary = tIBeneficiaryRepository.save(tIBeneficiary);
	    }
	    saveOutwardReferral(tIBeneficiaryDTO, tIBeneficiary);
	    saveTransfer(tIBeneficiaryDTO, tIBeneficiary);
	    return tIBeneficiaryMapper.toDto(tIBeneficiary);
	}
	return null;

    }

    private void saveTransfer(TIBeneficiaryDTO tIBeneficiaryDTO, TIBeneficiary tIBeneficiary) {
	// Code for adding transfers
	if (tIBeneficiaryDTO.getMasterBeneficiary().getId() != null && tIBeneficiaryDTO.getBenTransferDto() != null
		&& tIBeneficiaryDTO.getBenTransferDto().getTransferFromId() != null) {
	    try {
		Beneficiary beneficiary = beneficiaryRepository.findById(tIBeneficiary.getBeneficiary().getId()).get();
		Transfer transfer = new Transfer();
		TiBenTransferDto benTransferDto = tIBeneficiaryDTO.getBenTransferDto();
		if (benTransferDto.getId() != null) {
		    transfer = transferRepository.findById(benTransferDto.getId()).get();
		    Facility facilityTransferFrom = transfer.getFacilityFrom();
		    Facility facilityTransferTo = transfer.getFacilityTo();
		    facilityTransferTo.setId(benTransferDto.getTransferToId());
		    transfer.setFacilityFrom(facilityTransferFrom);
		    transfer.setSourceFacilityType(benTransferDto.getSourceType());
		    transfer.setFacilityTo(facilityTransferTo);
		    transfer.setDestinationFacilityType(benTransferDto.getDestinationType());
		    transfer.setTransferStatus(benTransferDto.getTransferStatus());
		    transfer.setBeneficiary(beneficiary);
		    transfer.setTiBeneficiary(tIBeneficiary);
		    transfer.setAcceptedTime(LocalDateTime.now());
		    transfer = transferRepository.save(transfer);

		} else {
		    Facility facilityTransferFrom = new Facility();
		    facilityTransferFrom.setId(benTransferDto.getTransferFromId());
		    Facility facilityTransferTo = new Facility();
		    facilityTransferTo.setId(7l);
		    transfer.setFacilityFrom(facilityTransferFrom);
		    transfer.setFacilityTo(facilityTransferTo);
		    transfer.setSourceFacilityType(benTransferDto.getSourceType());
		    transfer.setDestinationFacilityType(benTransferDto.getDestinationType());
		    transfer.setTransferStatus(benTransferDto.getTransferStatus());
		    transfer.setBeneficiary(beneficiary);
		    transfer.setTiBeneficiary(tIBeneficiary);
		    transfer.setAcceptedTime(LocalDateTime.now());
		    transfer = transferRepository.save(transfer);
		    transfer.setFacilityTo(null);
		    transferRepository.save(transfer);
		}

	    } catch (Exception e) {
	    }
	} else if (tIBeneficiaryDTO.getBenTransferDto() != null && tIBeneficiaryDTO.getBenTransferDto().getId() != null
		&& tIBeneficiaryDTO.getBenTransferDto().getTransferStatus().equalsIgnoreCase("Accepted")) {
	    Transfer transfer = transferRepository.findById(tIBeneficiaryDTO.getBenTransferDto().getId()).get();
	    transfer.setTransferStatus(tIBeneficiaryDTO.getBenTransferDto().getTransferStatus());
	    transferRepository.save(transfer);
	    setIsTransferred(tIBeneficiaryDTO);

	}
    }

    private void setIsTransferred(TIBeneficiaryDTO tIBeneficiaryDTO) {
	Stream<Long> ids = tIBeneficiaryDTO.getMasterBeneficiary().getBeneficiaryFacilityMappings().stream()
		.filter(x -> x.getIsActive().equals(false)).map(BeneficiaryFacilityMappingDto::getId);
	ids.forEach(id -> {
	    Optional<BeneficiaryFacilityMapping> benFac = beneficiaryFacilityMappingRepository.findById(id);
	    if (benFac.isPresent()) {
		BeneficiaryFacilityMapping benefFacMap = benFac.get();
		benefFacMap.setIsTransferred(true);
		beneficiaryFacilityMappingRepository.save(benefFacMap);
	    }

	});

    }

    private void saveOutwardReferral(TIBeneficiaryDTO tIBeneficiaryDTO, TIBeneficiary tIBeneficiary) {
	if (tIBeneficiaryDTO.getMasterBeneficiary().getId() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferralDto() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredFromFacility() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility() != null) {
	    Beneficiary beneficiary = beneficiaryRepository.findById(tIBeneficiary.getBeneficiary().getId()).get();

	    BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
	    try {

		if (tIBeneficiaryDTO.getBeneficiaryReferralDto().getId() != null) {
		    beneficiaryReferral = beneficiaryReferralRepository
			    .findById(tIBeneficiaryDTO.getBeneficiaryReferralDto().getId()).get();
		    Facility facilityReferred = new Facility();
		    facilityReferred.setId(tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredFromFacility());
		    beneficiaryReferral.setFacility1(facilityReferred);
		    Facility facilityReferredTo = new Facility();
		    facilityReferredTo.setId(tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
		    beneficiaryReferral.setFacility2(facilityReferredTo);
		    if (tIBeneficiaryDTO.getBeneficiaryReferralDto() != null)
			beneficiaryReferral.setReferDate(tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferDate());
		    MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
		    if (beneficiaryReferral.getBeneficiaryReferralStatusMaster().getId() == 1
			    || beneficiaryReferral.getBeneficiaryReferralStatusMaster().getId() == 2)
			beneficiaryReferralStatusMaster.setId(3l);
		    else
			beneficiaryReferralStatusMaster.setId(1l);
		    beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
		    beneficiaryReferral.setAcceptedDate(LocalDateTime.now());
		    beneficiaryReferral.setBeneficiary(beneficiary);
		    beneficiaryReferral.setIsDelete(false);
		} else {
		    beneficiaryReferral = new BeneficiaryReferral();
		    Facility facilityReferred = new Facility();
		    facilityReferred.setId(tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredFromFacility());
		    beneficiaryReferral.setFacility1(facilityReferred);
		    Facility facilityReferredTo = new Facility();
		    facilityReferredTo.setId(tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
		    beneficiaryReferral.setFacility2(facilityReferredTo);
		    MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
		    beneficiaryReferralStatusMaster.setId(1l);
		    beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
		    beneficiaryReferral.setReferDate(tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferDate());
		    beneficiaryReferral.getBeneficiaryReferralStatusMaster().setId(1l);
		    beneficiaryReferral.setAcceptedDate(LocalDateTime.now());
		    beneficiaryReferral.setBeneficiary(beneficiary);
		    beneficiaryReferral.setIsDelete(false);
		}
		beneficiaryReferralRepository.save(beneficiaryReferral);
		Set<BeneficiaryReferral> referrals = new HashSet<>();
		referrals.add(beneficiaryReferral);
		beneficiary.setBeneficiaryReferral(referrals);
		tIBeneficiary.setBeneficiary(beneficiary);
	    } catch (Exception e) {
		// TODO: handle exception
	    }

	}
    }

    private void setSubDistrictAndTown(TIBeneficiaryDTO tIBeneficiaryDTO, TIBeneficiary tIBeneficiary,
	    boolean subDistrictTownCheck) {
	if (tIBeneficiaryDTO.getMasterBeneficiary().getAddress().getSubDistrictId() != null) {
	    subDistrictTownCheck = true;
	    Subdistrict subdistrict = new Subdistrict();
	    subdistrict.setSubdistrictId(tIBeneficiaryDTO.getMasterBeneficiary().getAddress().getSubDistrictId());
	    tIBeneficiary.getBeneficiary().getAddress().setSubdistrict(subdistrict);
	}
	if (tIBeneficiaryDTO.getMasterBeneficiary().getAddress().getTownId() != null) {
	    subDistrictTownCheck = true;
	    Town town = new Town();
	    town.setTownId(tIBeneficiaryDTO.getMasterBeneficiary().getAddress().getTownId());
	    log.debug("Address :", tIBeneficiary.getBeneficiary().getAddress());
	    tIBeneficiary.getBeneficiary().getAddress().setTown(town);
	}
    }

    /**
     * Get all the tIBeneficiaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIBeneficiaryDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBeneficiaries");
	return tIBeneficiaryRepository.findAll(pageable).map(tIBeneficiaryMapper::toDto);
    }

    /**
     * Get one tIBeneficiary by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIBeneficiaryDTO> findOne(Long id) {
	log.debug("Request to get TIBeneficiary : {}", id);
	return tIBeneficiaryRepository.findById(id).map(tIBeneficiaryMapper::toDto);
    }

    /**
     * Delete the tIBeneficiary by id.
     *
     * @param id             the id of the entity.
     * @param deleteReasonId
     */

    public void delete(Long id, Long deleteReasonId) {
	log.debug("Request to delete TIBeneficiary : {}", id);
	Optional<TIBeneficiary> tiBen = tIBeneficiaryRepository.findById(id);
	if (tiBen.isPresent()) {
	    TIBeneficiary tiBeneficiary = tiBen.get();
	    tiBeneficiary.setIsDeleted(true);
	    MasterBeneficiaryDeleteReason masterBeneficiaryDeleteReason = new MasterBeneficiaryDeleteReason();
	    masterBeneficiaryDeleteReason.setId(deleteReasonId);
	    tiBeneficiary.setDeletedReason(masterBeneficiaryDeleteReason);
	    if (tiBeneficiary.getTiCounselling() != null) {
		tiBeneficiary.getTiCounselling().forEach(x -> {
		    x.setIsDelete(true);
		});
	    }

	    if (tiBeneficiary.getTiScreening() != null) {
		tiBeneficiary.getTiScreening().forEach(x -> {
		    x.setIsDeleted(true);
		});
	    }
	    if (tiBeneficiary.getTiStiTreatment() != null) {
		tiBeneficiary.getTiStiTreatment().forEach(x -> {
		    x.setIsDelete(true);
		});
	    }
	    if (tiBeneficiary.getTiAssessment() != null) {
		tiBeneficiary.getTiAssessment().forEach(x -> {
		    x.setIsDelete(true);
		});
	    }
	    deleteReferral(tiBeneficiary);
	    tIBeneficiaryRepository.save(tiBeneficiary);

	}

    }

    private void deleteReferral(TIBeneficiary tiBeneficiary) {
	if (tiBeneficiary.getBeneficiary() != null) {
	    Optional<BeneficiaryReferral> beneficiaryReferral = beneficiaryReferralRepository
		    .findByBeneficiary_IdAndFacility1_Id(tiBeneficiary.getBeneficiary().getId(),
			    tiBeneficiary.getFacility().getId());
	    if (beneficiaryReferral.isPresent()) {
		log.debug("Inside delete referral");
		BeneficiaryReferral referral = beneficiaryReferral.get();
		referral.setIsDelete(true);
		beneficiaryReferralRepository.save(referral);
	    }

	}
    }

    public boolean validateTICode(String tiCode, Long facilityId) {
	if (tiCode != null && tIBeneficiaryRepository
		.existsByTiCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeleted(tiCode, facilityId,
			false)) {
	    return false;
	}
	return true;
    }

    public boolean validateTICodeForExistingBeneficiary(String tiCode, Long beneficiaryId, Long facilityId) {
	if (tiCode != null) {
	    Optional<TIBeneficiary> tiBen = tIBeneficiaryRepository
		    .findByTiCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(tiCode,
			    facilityId, false, beneficiaryId);
	    if (tiBen.isPresent()) {
		return false;
	    }

	}
	return true;
    }

    public String checkDuplicateReferral(Long beneficiaryId, Long referredToFacilityId) {
	Optional<Facility> facility = facilityRepository.findById(referredToFacilityId);
	if (facility.isPresent()) {
	    Set<Long> facilityId = new HashSet<Long>();
	    facilityId.add(11l);
	    facilityId.add(13l);
	    Long facilityTypeId = facility.get().getFacilityType().getId();
	    long count = beneficiaryFacilityMappingRepository
		    .countByBeneficiary_IdAndFacility_FacilityType_IdAndIsActiveAndFacility_FacilityType_IdNotIn(
			    beneficiaryId, facilityTypeId, true, facilityId);
	    if (count > 0l) {
		return facility.get().getFacilityType().getFacilityTypeName();
	    } else
		return null;
	}
	return null;
    }

    public boolean validatePeCode(String peCode, Long facilityId) {
	if (!StringUtils.isEmpty(peCode)) {
	    Long count = tIBeneficiaryRepository.countByPeCodeAndFacility_Id(peCode, facilityId);
	    if (count >= 120) {
		return false;
	    }
	}
	return true;
    }

}
