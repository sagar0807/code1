package gov.naco.soch.ti.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterBeneficiaryDeleteReason;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.Town;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.TIOstBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenTransferDto;
import gov.naco.soch.ti.mapper.BeneficiaryMapper;
import gov.naco.soch.ti.mapper.TiOstBeneficiaryMapper;

@Service
@Transactional
public class TiOstBeneficiaryServiceImpl {

    private final Logger log = LoggerFactory.getLogger(TiOstBeneficiaryServiceImpl.class);

    private final TiOstBeneficiaryRepository tIOstBeneficiaryRepository;

    private final TiOstBeneficiaryMapper tIOstBeneficiaryMapper;

    @Autowired
    private BeneficiaryReferralRepository beneficiaryReferralRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private BeneficiaryMapper beneficiaryMapper;

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    public TiOstBeneficiaryServiceImpl(TiOstBeneficiaryRepository TIOstBeneficiaryRepository,
	    TiOstBeneficiaryMapper TIOstBeneficiaryMapper) {
	this.tIOstBeneficiaryRepository = TIOstBeneficiaryRepository;
	this.tIOstBeneficiaryMapper = TIOstBeneficiaryMapper;
    }

    /**
     * Save a TIOstBeneficiary.
     *
     * @param tIOstBeneficiaryDTO the entity to save.
     * @return the persisted entity.
     */

    public TIOstBeneficiaryDTO save(TIOstBeneficiaryDTO tIOstBeneficiaryDTO) {
	log.info("Request to save TIOstBeneficiary : {}", tIOstBeneficiaryDTO);
	boolean subDistrictTownCheck = false;
	TiOstBeneficiary tIOstBeneficiary = tIOstBeneficiaryMapper.toEntity(tIOstBeneficiaryDTO);
	if (tIOstBeneficiaryDTO.getMasterBeneficiary().getId() != null) {
	    Beneficiary benef = beneficiaryRepository.findById(tIOstBeneficiaryDTO.getMasterBeneficiary().getId())
		    .get();
	    Beneficiary beneficiary = beneficiaryMapper.toUpdateEntity(tIOstBeneficiaryDTO.getMasterBeneficiary(),
		    benef);
	    beneficiary.setOstCode(tIOstBeneficiary.getOstCode());
	    beneficiary = beneficiaryRepository.save(beneficiary);
	    tIOstBeneficiary.setBeneficiary(beneficiary);
	    tIOstBeneficiary = tIOstBeneficiaryRepository.save(tIOstBeneficiary);
	    setSubDistrictAndTown(tIOstBeneficiaryDTO, tIOstBeneficiary, subDistrictTownCheck);
	    if (subDistrictTownCheck) {
		tIOstBeneficiary = tIOstBeneficiaryRepository.save(tIOstBeneficiary);
	    }

	    saveOutwardReferral(tIOstBeneficiaryDTO, tIOstBeneficiary);
	    saveTransfer(tIOstBeneficiaryDTO);
	} else {
	    tIOstBeneficiary = tIOstBeneficiaryRepository.save(tIOstBeneficiary);
	    setSubDistrictAndTown(tIOstBeneficiaryDTO, tIOstBeneficiary, subDistrictTownCheck);
	    if (subDistrictTownCheck) {
		tIOstBeneficiary = tIOstBeneficiaryRepository.save(tIOstBeneficiary);
	    }
	    if (tIOstBeneficiary != null && tIOstBeneficiary.getBeneficiary().getUid() == null) {
		tIOstBeneficiary.getBeneficiary().setUid("U" + Long.valueOf(tIOstBeneficiary.getBeneficiary().getId()));
		tIOstBeneficiary.getBeneficiary().setOstCode(tIOstBeneficiary.getOstCode());
		tIOstBeneficiary = tIOstBeneficiaryRepository.save(tIOstBeneficiary);
	    }

	}

	return tIOstBeneficiaryMapper.toDto(tIOstBeneficiary);

    }

    public TIOstBeneficiaryDTO update(TIOstBeneficiaryDTO tIOstBeneficiaryDTO) {
	log.info("Request to Update TIOstBeneficiary : {}", tIOstBeneficiaryDTO);

	Optional<TiOstBeneficiary> ostBeneficiary = tIOstBeneficiaryRepository.findById(tIOstBeneficiaryDTO.getId());
	if (ostBeneficiary.isPresent()) {
	    TiOstBeneficiary tiOstBeneficiary = ostBeneficiary.get();
	    // boolean isInwardTransfer = false;
	    boolean subDistrictTownCheck = false;
	    // Long facilityId = null;
	    // if (tIOstBeneficiaryDTO.getFacilityId() !=
	    // tiOstBeneficiary.getFacility().getId()) {
	    // facilityId = tIOstBeneficiaryDTO.getFacilityId();
	    // isInwardTransfer = true;
	    // tIOstBeneficiaryDTO.setFacilityId(tiOstBeneficiary.getFacility().getId());
	    // }
	    tiOstBeneficiary = tIOstBeneficiaryMapper.toUpdateEntity(tIOstBeneficiaryDTO, tiOstBeneficiary);
	    tiOstBeneficiary = tIOstBeneficiaryRepository.save(tiOstBeneficiary);
	    // if (isInwardTransfer) {
	    // Facility facility = new Facility();
	    // facility.setId(facilityId);
	    // tiOstBeneficiary.setFacility(facility);
	    // tiOstBeneficiary =
	    // tIOstBeneficiaryRepository.save(tiOstBeneficiary);
	    // }
	    setSubDistrictAndTown(tIOstBeneficiaryDTO, tiOstBeneficiary, subDistrictTownCheck);
	    if (subDistrictTownCheck) {
		tiOstBeneficiary = tIOstBeneficiaryRepository.save(tiOstBeneficiary);
	    }
	    saveOutwardReferral(tIOstBeneficiaryDTO, tiOstBeneficiary);
	    saveTransfer(tIOstBeneficiaryDTO);
	    return tIOstBeneficiaryMapper.toDto(tiOstBeneficiary);
	}
	return null;

    }

    /**
     * Get all the tIBeneficiaries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */

    @Transactional(readOnly = true)
    public Page<TIOstBeneficiaryDTO> findAll(Pageable pageable) {
	log.debug("Request to get all TIBeneficiaries");
	return tIOstBeneficiaryRepository.findAll(pageable).map(tIOstBeneficiaryMapper::toDto);
    }

    /**
     * Get one TIOstBeneficiary by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */

    @Transactional(readOnly = true)
    public Optional<TIOstBeneficiaryDTO> findOne(Long id) {
	log.debug("Request to get TIOstBeneficiary : {}", id);
	return tIOstBeneficiaryRepository.findById(id).map(tIOstBeneficiaryMapper::toDto);
    }

    /**
     * Delete the TIOstBeneficiary by id.
     *
     * @param id             the id of the entity.
     * @param deleteReasonId
     */

    public void delete(Long id, Long deleteReasonId) {
	log.debug("Request to delete TIOstBeneficiary : {}", id);
	Optional<TiOstBeneficiary> tiBen = tIOstBeneficiaryRepository.findById(id);
	if (tiBen.isPresent()) {
	    TiOstBeneficiary tIOstBeneficiary = tiBen.get();
	    tIOstBeneficiary.setIsDeleted(true);
	    MasterBeneficiaryDeleteReason masterBeneficiaryDeleteReason = new MasterBeneficiaryDeleteReason();
	    masterBeneficiaryDeleteReason.setId(deleteReasonId);
	    tIOstBeneficiary.setDeletedReason(masterBeneficiaryDeleteReason);
	    if (tIOstBeneficiary.getOstAssess() != null) {
		tIOstBeneficiary.getOstAssess().forEach(x -> {
		    x.setIsDelete(true);
		});
	    }
	    if (tIOstBeneficiary.getOstFollowUp() != null) {
		tIOstBeneficiary.getOstFollowUp().forEach(x -> {
		    x.setIsDelete(true);
		});
	    }
	    deleteReferral(tIOstBeneficiary);
	    tIOstBeneficiaryRepository.save(tIOstBeneficiary);

	}
    }

    public boolean validateOstCode(String ostCode, Long facilityId) {
	if (ostCode != null && tIOstBeneficiaryRepository
		.existsByOstCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeleted(ostCode, facilityId,
			false)) {
	    return false;
	}
	return true;
    }

    public boolean validateOstCodeForExistingBeneficiary(String ostCode, Long facilityId, Long beneficiaryId) {

	if (ostCode != null) {
	    Optional<TiOstBeneficiary> tiBen = tIOstBeneficiaryRepository
		    .findByOstCodeAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(ostCode,
			    facilityId, false, beneficiaryId);
	    if (tiBen.isPresent()) {
		return false;
	    }

	}
	return true;
    }

    private void deleteReferral(TiOstBeneficiary tiBeneficiary) {
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

    private void saveTransfer(TIOstBeneficiaryDTO tIOstBeneficiaryDTO) {
	if (tIOstBeneficiaryDTO.getMasterBeneficiary().getId() != null
		&& tIOstBeneficiaryDTO.getBenTransferDto() != null
		&& tIOstBeneficiaryDTO.getBenTransferDto().getTransferFromId() != null) {
	    try {
		Beneficiary beneficiary = beneficiaryRepository
			.findById(tIOstBeneficiaryDTO.getMasterBeneficiary().getId()).get();
		Transfer transfer = new Transfer();
		TiBenTransferDto benTransferDto = tIOstBeneficiaryDTO.getBenTransferDto();
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
		    transfer.setAcceptedTime(LocalDateTime.now());
		    transfer = transferRepository.save(transfer);
		    transfer.setFacilityTo(null);
		    transferRepository.save(transfer);
		}

	    } catch (Exception e) {
	    }
	} else if (tIOstBeneficiaryDTO.getBenTransferDto() != null
		&& tIOstBeneficiaryDTO.getBenTransferDto().getId() != null
		&& tIOstBeneficiaryDTO.getBenTransferDto().getTransferStatus().equalsIgnoreCase("Accepted")) {
	    Transfer transfer = transferRepository.findById(tIOstBeneficiaryDTO.getBenTransferDto().getId()).get();
	    transfer.setTransferStatus(tIOstBeneficiaryDTO.getBenTransferDto().getTransferStatus());
	    transferRepository.save(transfer);
	    setIsTransferred(tIOstBeneficiaryDTO);
	}
    }

    private void setIsTransferred(TIOstBeneficiaryDTO tIOstBeneficiaryDTO) {
	Stream<Long> ids = tIOstBeneficiaryDTO.getMasterBeneficiary().getBeneficiaryFacilityMappings().stream()
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

    private void saveOutwardReferral(TIOstBeneficiaryDTO tIOstBeneficiaryDTO, TiOstBeneficiary tIOstBeneficiary) {
	if (tIOstBeneficiaryDTO.getMasterBeneficiary().getId() != null
		&& tIOstBeneficiaryDTO.getBeneficiaryReferral() != null
		&& tIOstBeneficiaryDTO.getBeneficiaryReferral().getReferredFromFacility() != null) {
	    Beneficiary beneficiary = beneficiaryRepository.findById(tIOstBeneficiary.getBeneficiary().getId()).get();

	    BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
	    try {

		if (tIOstBeneficiaryDTO.getBeneficiaryReferral().getId() != null) {
		    beneficiaryReferral = beneficiaryReferralRepository
			    .findById(tIOstBeneficiaryDTO.getBeneficiaryReferral().getId()).get();
		    Facility facilityReferred = beneficiaryReferral.getFacility1();
		    facilityReferred.setId(facilityReferred.getId());
		    beneficiaryReferral.setFacility1(facilityReferred);
		    Facility facilityReferredTo = beneficiaryReferral.getFacility2();
		    facilityReferredTo.setId(facilityReferredTo.getId());
		    beneficiaryReferral.setFacility2(facilityReferredTo);
		    if (tIOstBeneficiaryDTO.getBeneficiaryReferral().getReferDate() != null)
			beneficiaryReferral.setReferDate(tIOstBeneficiaryDTO.getBeneficiaryReferral().getReferDate());
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
		    beneficiaryReferralRepository.save(beneficiaryReferral);
		} else {
		    validateIduReferral(tIOstBeneficiaryDTO.getBeneficiaryReferral());
		    beneficiaryReferral = new BeneficiaryReferral();
		    Facility facilityReferred = new Facility();
		    facilityReferred.setId(tIOstBeneficiaryDTO.getBeneficiaryReferral().getReferredFromFacility());
		    beneficiaryReferral.setFacility1(facilityReferred);
		    Facility facilityReferredTo = new Facility();
		    // facilityReferredTo.setId(7l);
		    facilityReferredTo.setId(tIOstBeneficiaryDTO.getBeneficiaryReferral().getReferredToFacility());
		    beneficiaryReferral.setFacility2(facilityReferredTo);
		    beneficiaryReferral.setReferDate(tIOstBeneficiaryDTO.getBeneficiaryReferral().getReferDate());
		    MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
		    beneficiaryReferralStatusMaster.setId(1l);
		    beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
		    beneficiaryReferral.setAcceptedDate(LocalDateTime.now());
		    beneficiaryReferral.setBeneficiary(beneficiary);
		    beneficiaryReferral.setIsDelete(false);
		    beneficiaryReferral = beneficiaryReferralRepository.save(beneficiaryReferral);

		}

	    } catch (Exception e) {

	    }

	}
    }

    public boolean validateIduReferral(BeneficiaryReferralDto beneficiaryReferral) {
        Long facilityType=facilityRepository.getFacilityType(beneficiaryReferral.getReferredToFacility());
       if( FacilityTypeEnum.TI_CENTER.getFacilityType().equals(facilityType))
       {
	   Long count=beneficiaryReferralRepository.checkIduTypology(beneficiaryReferral.getReferredToFacility());
		if(count==0)
		{
		   return false;
		}	
       }
       return true;
    }

    private void setSubDistrictAndTown(TIOstBeneficiaryDTO tIOstBeneficiaryDTO, TiOstBeneficiary tIOstBeneficiary,
	    boolean check) {
	if (tIOstBeneficiaryDTO.getMasterBeneficiary().getAddress().getSubDistrictId() != null) {
	    check = true;
	    Subdistrict subdistrict = new Subdistrict();
	    subdistrict.setSubdistrictId(tIOstBeneficiaryDTO.getMasterBeneficiary().getAddress().getSubDistrictId());
	    tIOstBeneficiary.getBeneficiary().getAddress().setSubdistrict(subdistrict);
	}
	if (tIOstBeneficiaryDTO.getMasterBeneficiary().getAddress().getTownId() != null) {
	    check = true;
	    Town town = new Town();
	    town.setTownId(tIOstBeneficiaryDTO.getMasterBeneficiary().getAddress().getTownId());
	    log.debug("Address :", tIOstBeneficiary.getBeneficiary().getAddress());
	    tIOstBeneficiary.getBeneficiary().getAddress().setTown(town);
	}
    }

    public boolean validateOstNumberForExistingBeneficiary(String ostNumber, Long beneficiaryId, Long facilityId) {

	if (ostNumber != null) {
	    Optional<TiOstBeneficiary> tiBen = tIOstBeneficiaryRepository
		    .findByOstNumberAndBeneficiary_BeneficiaryFacilityMappings_Facility_IdAndIsDeletedAndIdNot(
			    ostNumber, facilityId, false, beneficiaryId);
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
}
