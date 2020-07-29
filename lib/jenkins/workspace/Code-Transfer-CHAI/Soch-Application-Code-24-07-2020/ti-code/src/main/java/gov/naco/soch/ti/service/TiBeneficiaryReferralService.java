package gov.naco.soch.ti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.BeneficiaryRegistrationDto;
import gov.naco.soch.dto.TiBeneficiaryReferralDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.mapper.BeneficiaryMapperUtil;
import gov.naco.soch.projection.BeneficiaryBasicProjection;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.IctcBeneficiaryRepository;
import gov.naco.soch.repository.TIBeneficiaryRepository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.ti.dto.FacilityDTO;
import gov.naco.soch.ti.dto.ReferralTimeLineDto;
import gov.naco.soch.ti.dto.ReferralTimeLineObjectDto;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenTransferDto;
import gov.naco.soch.ti.mapper.BeneficiaryMapper;
import gov.naco.soch.ti.mapper.FacilityMapper;
import gov.naco.soch.ti.mapper.TiBeneficiaryReferralMapper;
import gov.naco.soch.ti.mapper.TiBenficiarySaveReferralMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

@Service
@Transactional
public class TiBeneficiaryReferralService {

	@Autowired
	private TIBeneficiaryRepository tiBeneficiaryRepository;

	@Autowired
	private BeneficiaryReferralRepository beneficiaryReferralRepository;

	@Autowired
	private FacilityRepository facilityRepository;
	@Autowired
	private ArtBeneficiaryRepository artBeneficiaryRepository;

	@Autowired
	private TransferRepository transferRepository;

	@Autowired
	private TiBenficiarySaveReferralMapper tiBenficiarySaveReferralMapper;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private BeneficiaryMapper beneficiaryMapper;

	@Autowired
	IctcBeneficiaryRepository ictcBeneficiaryRepository;

	@Autowired
	private BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;
	private static final Logger logger = LoggerFactory.getLogger(TiBeneficiaryReferralService.class);

	private final TiBeneficiaryReferralMapper tiBeneficiaryReferralMapper = new TiBeneficiaryReferralMapper();

	// 2. method to accept an transfer-in request
	// public void acceptTransfer(BeneficiaryRegistrationDto
	// beneficiaryRegistrationDto) {
	//
	// //TiBeneficiaryReferral tiBeneficiaryReferral = new
	// TiBeneficiaryReferral();
	//
	// Beneficiary beneficiaryObj = null;
	// beneficiaryObj =
	// beneficiaryRepository.findById(beneficiaryRegistrationDto.getBeneficiaryId()).get();
	//
	// BeneficiaryRegistration beneficiaryRegistration = null;
	// beneficiaryRegistration =
	// BeneficiaryRegistrationMapper.mapToBeneficiaryReg(beneficiaryRegistrationDto);
	//
	// BeneficiaryFacilityMapping beneficiaryFacilityMappings = null;
	// beneficiaryFacilityMappings = BeneficiaryRegistrationMapper
	// .mapToBeneficiaryFacilityMapping(beneficiaryRegistrationDto);
	//
	// beneficiaryRegistration.setBeneficiary(beneficiaryObj);
	// beneficiaryFacilityMappings.setBeneficiary(beneficiaryObj);
	//
	// beneficiaryObj.setBeneficiaryRegistration(beneficiaryRegistration);
	//
	// Set<BeneficiaryFacilityMapping> beneficiaryFacilityList = new
	// HashSet<BeneficiaryFacilityMapping>();
	// beneficiaryObj.setBeneficiaryFacilityMappings(beneficiaryFacilityList);
	// beneficiaryObj.getBeneficiaryFacilityMappings().add(beneficiaryFacilityMappings);
	//
	// beneficiaryObj.setBeneficiaryActivityStatus("Pending For STI Treatment");
	// //tiBeneficiaryReferral.setTransferStatus("Transferred");
	// //tiBeneficiaryReferralRepository.save(tiBeneficiaryReferral);
	//
	// beneficiaryObj = beneficiaryRepository.save(beneficiaryObj);
	// }

	// public List<TiReferralDto> listAllSReferrals(String typeRefferal, Long
	// facilityId) {
	// List<TIBenReferral> benReferrals = new ArrayList<TIBenReferral>();
	// List<TiReferralDto> tiReferralDtos = new ArrayList<TiReferralDto>();
	// if(typeRefferal.equalsIgnoreCase("inward")) {
	// benReferrals = referralRepository.findByRefferedTo(facilityId);
	// }
	// else if(typeRefferal.equalsIgnoreCase("outward")) {
	// benReferrals = referralRepository.findByReferredFrom(facilityId);
	// }
	//
	// tiReferralDtos =
	// TiBeneficiaryReferralMapper.mapTiRefferalToTiRefferalDto(tiReferralDtos,benReferrals);
	// return tiReferralDtos;
	// // TODO Auto-generated method stub
	//
	//
	//
	// }

	// public boolean deleteReferral(Long id) {
	// Optional<TIBenReferral> benReferral = referralRepository.findById(id);
	// TIBenReferral benReferralUpdate = benReferral.get();
	// benReferralUpdate.setIsDelete(true);
	// referralRepository.save(benReferralUpdate);
	// benReferral = referralRepository.findById(id);
	// if(benReferral.get().isIsDelete() == true) {
	// return true;
	// }
	// return false;
	// }

	public void acceptReferral(BeneficiaryRegistrationDto beneficiaryRegistrationDto) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public boolean acceptReferral(Long beneficiaryId, Long facilityId) {
		TIBeneficiary tiBeneficiary = tiBeneficiaryRepository.findbyBenficiaryId(beneficiaryId);
		if (tiBeneficiary != null) {
			BeneficiaryReferral benReferral = beneficiaryReferralRepository
					.findByBeneficiary_Id(tiBeneficiary.getBeneficiary().getId()).get();
			if (benReferral != null) {
				Facility facility = new Facility();
				facility.setId(facilityId);
				benReferral.setFacility2(facility);
				beneficiaryReferralRepository.save(benReferral);
				return true;
			} else
				return false;
		}
		return false;
	}

	public List<FacilityDTO> listFacilities() {
		List<FacilityDTO> facilityDTOs = new ArrayList<FacilityDTO>();
		List<Facility> facilities = facilityRepository.findAll();
		facilityDTOs = FacilityMapper.mapFacilityListToFacilityDtoList(facilities, facilityDTOs);
		return facilityDTOs;
	}

	public boolean transferTo(Long transferId, Long failityToId, String action) {
		Transfer transfer = new Transfer();
		try {
			transfer = transferRepository.findById(transferId).get();
		} catch (Exception e) {
		}
		if (action.equalsIgnoreCase("accept")) {
			transfer.setTransferStatus("Accepted");
		} else if (action.equalsIgnoreCase("transfer")) {
			transfer.setTransferStatus("Transferred");
			transfer.setInitiationDate(LocalDate.now());
			Facility facilityTo = new Facility();
			facilityTo.setId(failityToId);
			transfer.setFacilityTo(facilityTo);
		} else if (action.equalsIgnoreCase("cancel")) {
			transfer.setTransferStatus("Cancelled");
		} else if (action.equalsIgnoreCase("reject")) {
			transfer.setTransferStatus("Rejected");
		}
		transferRepository.save(transfer);
		return true;
	}

	public boolean saveTiBeneficiary(TIBeneficiaryDTO beneficiaryDTO) {
		try {
			TIBeneficiary tiBeneficiary = tiBenficiarySaveReferralMapper.toEntity(beneficiaryDTO);
			tiBeneficiary = tiBeneficiaryRepository.save(tiBeneficiary);
			System.out.println("Before beneficiaryRepository.findById");
			Beneficiary beneficiary = beneficiaryRepository.findById(beneficiaryDTO.getMasterBeneficiary().getId())
					.get();
			Facility facility = new Facility();
			if (beneficiaryDTO.getFacility() != null)
				facility.setId(beneficiaryDTO.getFacility().getId());
			beneficiary = BeneficiaryMapperUtil.mapToDto(beneficiaryDTO.getMasterBeneficiary(), beneficiary, facility);
			tiBeneficiary.setBeneficiary(beneficiary);
			tiBeneficiaryRepository.save(tiBeneficiary);
			BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
			if (beneficiaryDTO.getBeneficiaryReferralDto() != null) {
				if (beneficiaryDTO.getBeneficiaryReferralDto().getId() != null) {
					System.out.println("Before beneficiaryReferralRepositor.findById");
					beneficiaryReferral = beneficiaryReferralRepository
							.findById(beneficiaryDTO.getBeneficiaryReferralDto().getId()).get();
					Facility facilityReferred = new Facility();
					facilityReferred.setId(beneficiaryDTO.getBeneficiaryReferralDto().getReferredFromFacility());
					beneficiaryReferral.setFacility1(facilityReferred);
					Facility facilityReferredTo = new Facility();
					facilityReferredTo.setId(beneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
					beneficiaryReferral.setFacility2(facilityReferredTo);

					// beneficiaryReferral.setReferDate(beneficiaryDTO.getBeneficiaryReferralDto().getReferDate());
					MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
					if (beneficiaryReferral.getBeneficiaryReferralStatusMaster().getId() == 1
							|| beneficiaryReferral.getBeneficiaryReferralStatusMaster().getId() == 2) {
						beneficiaryReferralStatusMaster.setId(3l);
					} else {
						System.out.println("");
						beneficiaryReferralStatusMaster.setId(1l);
					}
					beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
					beneficiaryReferral.setAcceptedDate(LocalDateTime.now());
					beneficiaryReferral.setBeneficiary(beneficiary);
				} else {
					beneficiaryReferral = new BeneficiaryReferral();
					Facility facilityReferred = new Facility();
					facilityReferred.setId(beneficiaryDTO.getBeneficiaryReferralDto().getReferredFromFacility());
					beneficiaryReferral.setFacility1(facilityReferred);
					Facility facilityReferredTo = new Facility();
					facilityReferredTo.setId(beneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
					beneficiaryReferral.setFacility2(facilityReferredTo);
					MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
					beneficiaryReferralStatusMaster.setId(1l);
					beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
					beneficiaryReferral.setReferDate(beneficiaryDTO.getBeneficiaryReferralDto().getReferDate());
					beneficiaryReferral.setBeneficiary(beneficiary);
				}
			}
			beneficiaryReferralRepository.save(beneficiaryReferral);
			if (beneficiaryDTO.getBenTransferDto() != null) {
				Transfer transfer = new Transfer();
				TiBenTransferDto benTransferDto = beneficiaryDTO.getBenTransferDto();
				if (benTransferDto.getId() != null) {
					transfer = transferRepository.findById(benTransferDto.getId()).get();
					Facility facilityTransferFrom = new Facility();
					facilityTransferFrom.setId(benTransferDto.getTransferFromId());
					Facility facilityTransferTo = new Facility();
					facilityTransferTo.setId(benTransferDto.getTransferToId());
					transfer.setFacilityFrom(facilityTransferFrom);
					transfer.setSourceFacilityType(benTransferDto.getSourceType());
					transfer.setFacilityTo(facilityTransferTo);
					transfer.setDestinationFacilityType(benTransferDto.getDestinationType());
					transfer.setTransferStatus(benTransferDto.getTransferStatus());
					transfer.setBeneficiary(beneficiary);
					transfer.setTiBeneficiary(tiBeneficiary);

				} else {
					Facility facilityTransferFrom = new Facility();
					facilityTransferFrom.setId(benTransferDto.getTransferFromId());
					Facility facilityTransferTo = new Facility();
					facilityTransferTo.setId(benTransferDto.getTransferToId());
					transfer.setFacilityFrom(facilityTransferFrom);
					transfer.setFacilityTo(facilityTransferTo);
					transfer.setSourceFacilityType(benTransferDto.getSourceType());
					transfer.setDestinationFacilityType(benTransferDto.getDestinationType());
					transfer.setTransferStatus(benTransferDto.getTransferStatus());
					transfer.setBeneficiary(beneficiary);
					transfer.setTiBeneficiary(tiBeneficiary);
				}
				transferRepository.save(transfer);
			}
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			return false;
		}

	}

	public boolean referBeneficiary(Long id, Long facilityTo, String action, Long beneficiaryId, LocalDate referDate) {
		BeneficiaryReferral beneficiaryReferral = beneficiaryReferralRepository.findById(id).get();
		if (action.equalsIgnoreCase("decline") || action.equalsIgnoreCase("cancel")) {
			if (action.equalsIgnoreCase("decline")) {
				MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
				beneficiaryReferralStatusMaster.setId(4l);
				beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
				beneficiaryReferral.setDeclinedDate(LocalDateTime.now());
			}

			if (action.equalsIgnoreCase("cancel")) {
				MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
				beneficiaryReferralStatusMaster.setId(5l);
				beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
			}
		} else {

			String facilityType = checkDuplicateReferral(beneficiaryId, facilityTo);

			if (facilityType != null) {
				throw new BadRequestAlertException("Beneficiary is already registered in " + facilityType, "Referral",
						"3");
			}

			MasterReferralStatus beneficiaryReferralStatusMaster = new MasterReferralStatus();
			beneficiaryReferralStatusMaster.setId(1l);
			beneficiaryReferral.setBeneficiaryReferralStatusMaster(beneficiaryReferralStatusMaster);
			Facility facility = new Facility();
			facility.setId(facilityTo);
			beneficiaryReferral.setFacility2(facility);
			beneficiaryReferral.setAcceptedDate(LocalDateTime.now());
			beneficiaryReferral.setReferDate(referDate);
		}

		beneficiaryReferralRepository.save(beneficiaryReferral);
		return true;
	}

	public ReferralTimeLineDto getReferralTimeLine(Long beneficiaryId, Long facilityId) {
		ReferralTimeLineDto referralTimeLineDto = new ReferralTimeLineDto();
		try {
			BeneficiaryBasicProjection beneficiaryBasicProjection = beneficiaryRepository
					.getBasicBeneficiaryDetails(beneficiaryId);
			referralTimeLineDto.setBeneficiaryId(beneficiaryBasicProjection.getId());
			referralTimeLineDto.setFirstName(beneficiaryBasicProjection.getFirstName());
			referralTimeLineDto.setLastName(beneficiaryBasicProjection.getLastName());
			referralTimeLineDto.setuId(beneficiaryBasicProjection.getUid());
			referralTimeLineDto.setAge(beneficiaryBasicProjection.getAge());
			referralTimeLineDto.setGender(beneficiaryBasicProjection.getGender());
			referralTimeLineDto.setReferralId(0L);
			List<ReferralTimeLineObjectDto> lineObjectDtos = new ArrayList<ReferralTimeLineObjectDto>();
			List<BeneficiaryReferral> beneficiaryReferrals = beneficiaryReferralRepository
					.findByBeneficiaryIdForTimeLine(beneficiaryId);
			if (beneficiaryReferrals != null && beneficiaryReferrals.size() > 0) {

				for (BeneficiaryReferral referral : beneficiaryReferrals) {
					if (referral.getBeneficiaryReferralStatusMaster().getId() == 3) {
						ReferralTimeLineObjectDto timeLineObjectDto = new ReferralTimeLineObjectDto();
						timeLineObjectDto.setReferralId(referral.getId());
						timeLineObjectDto.setAcceptedDate(referral.getAcceptedDate());
						timeLineObjectDto.setFacilityFrom(referral.getFacility1().getId());
						timeLineObjectDto.setFacilityFromName(referral.getFacility1().getName());
						timeLineObjectDto.setFacilityTo(referral.getFacility2().getId());
						timeLineObjectDto.setFacilityToName(referral.getFacility2().getName());
						switch (Integer.parseInt(referral.getFacility2().getFacilityType().getId().toString())) {
						case 7:
							if (referral.getBeneficiary().getTiBeneficiary() != null) {
								timeLineObjectDto.setCodeType("TI Code");
								timeLineObjectDto.setBenCode(referral.getBeneficiary().getTiBeneficiary().getTiCode());
								timeLineObjectDto.setClientStatus(
										referral.getBeneficiary().getTiBeneficiary().getStatus().getName());
							}
							break;
						case 10:
							if (referral.getBeneficiary().getOstBeneficiary() != null) {
								timeLineObjectDto.setCodeType("OST Num");
								timeLineObjectDto
										.setBenCode(referral.getBeneficiary().getOstBeneficiary().getOstCode());
								timeLineObjectDto.setClientStatus(
										referral.getBeneficiary().getOstBeneficiary().getStatus().getName());
							}
							break;
						case 11:
							if (referral.getBeneficiary().getIctcBeneficiary() != null) {
								timeLineObjectDto.setCodeType("PID");
								timeLineObjectDto.setBenCode(referral.getBeneficiary().getIctcBeneficiary().getPid());
								timeLineObjectDto.setClientStatus(getICTCBenStatus(beneficiaryId,
										referral.getBeneficiary().getIctcBeneficiary().getFacility().getId()));
							}
							break;
						case 15:
							if (referral.getBeneficiary().getArtBeneficiary() != null) {
								timeLineObjectDto.setCodeType("ART Num");
								timeLineObjectDto.setBenCode(referral.getBeneficiary().getArtNumber());
								logger.info("referral.getFacility2().getId() : " + referral.getFacility2().getId());
								timeLineObjectDto.setClientStatus(
										getARTBenStatus(beneficiaryId, referral.getFacility2().getId()));
							}
							break;
						default:
							break;
						}

						timeLineObjectDto.setStatus(referral.getBeneficiaryReferralStatusMaster().getName());
						lineObjectDtos.add(timeLineObjectDto);
					}
				}
				Beneficiary beneficiary = new Beneficiary();
				Facility facility = new Facility();
				BeneficiaryFacilityMapping beneficiaryFacilityMapping = beneficiaryFacilityMappingRepository
						.findByBeneficiary_IdAndFacility_IdAndIsActive(beneficiaryId, facilityId, true);
				referralTimeLineDto.setBasicDtlFacilityName(beneficiaryFacilityMapping.getFacility().getName());
				if (lineObjectDtos.size() == 0) {

					beneficiary = beneficiaryFacilityMapping.getBeneficiary();
					facility = beneficiaryFacilityMapping.getFacility();

				} else {
					BeneficiaryReferral initialReferredFrom = getSortedReferralData(beneficiaryReferrals, "ASC");
					beneficiary = initialReferredFrom.getBeneficiary();
					facility = initialReferredFrom.getFacility1();
				}

				switch (Integer.parseInt(facility.getFacilityType().getId().toString())) {
				case 7:
					if (beneficiary.getTiBeneficiary() != null) {
						referralTimeLineDto.setCodeType("TI Code");
						referralTimeLineDto.setBenCode(beneficiary.getTiBeneficiary().getTiCode());
						referralTimeLineDto.setDateOfReg(beneficiary.getRegDate());
						referralTimeLineDto.setRegisteredFacility(facility.getName());
						referralTimeLineDto.setClientStatus(beneficiary.getTiBeneficiary().getStatus().getName());
					}
					break;
				case 10:
					if (beneficiary.getOstBeneficiary() != null) {
						referralTimeLineDto.setCodeType("OST Num");
						referralTimeLineDto.setBenCode(beneficiary.getOstBeneficiary().getOstCode());
						referralTimeLineDto.setDateOfReg(beneficiary.getRegDate());
						referralTimeLineDto.setRegisteredFacility(facility.getName());
						referralTimeLineDto.setClientStatus(beneficiary.getOstBeneficiary().getStatus().getName());
					}
					break;
				case 11:
					if (beneficiary.getIctcBeneficiary() != null) {
						referralTimeLineDto.setCodeType("PID");
						referralTimeLineDto.setBenCode(beneficiary.getIctcBeneficiary().getPid());
						referralTimeLineDto.setDateOfReg(beneficiary.getRegDate());
						referralTimeLineDto.setRegisteredFacility(facility.getName());
						referralTimeLineDto.setClientStatus(getICTCBenStatus(beneficiaryId,
								beneficiary.getIctcBeneficiary().getFacility().getId()));
					}
					break;
				case 15:
					if (beneficiary.getArtBeneficiary() != null) {
						referralTimeLineDto.setCodeType("ART Num");
						referralTimeLineDto.setBenCode(beneficiary.getArtNumber());
						referralTimeLineDto.setDateOfReg(beneficiary.getRegDate());
						referralTimeLineDto.setRegisteredFacility(facility.getName());
						referralTimeLineDto.setClientStatus(getARTBenStatus(beneficiaryId, facility.getId()));
					}
					break;
				default:
					break;
				}
			}
			referralTimeLineDto.setReferrals(lineObjectDtos);
		} catch (Exception e) {
			return referralTimeLineDto;
		}
		return referralTimeLineDto;
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

	public boolean addBeneficiaryReferral(TiBeneficiaryReferralDto tiBeneficiaryReferralDto) {
		BeneficiaryReferral beneficiaryReferral = tiBeneficiaryReferralMapper
				.mapTiBeneficiaryReferralDtoToTiBeneficiaryReferral(tiBeneficiaryReferralDto);
		beneficiaryReferralRepository.save(beneficiaryReferral);
		return true;
	}

	static BeneficiaryReferral getSortedReferralData(List<BeneficiaryReferral> beneficiaryReferrals, String sortType) {
		BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
		if (sortType.equals("ASC")) {
			Collections.sort(beneficiaryReferrals, (o1, o2) -> o1.getId().intValue() - o2.getId().intValue());
		} else if (sortType.equals("DESC")) {
			Collections.sort(beneficiaryReferrals, (o1, o2) -> o2.getId().intValue() - o1.getId().intValue());
		}
		if (beneficiaryReferrals.size() > 0) {
			beneficiaryReferral = beneficiaryReferrals.get(0);
		}
		return beneficiaryReferral;

	}

	public String getICTCBenStatus(Long beneficiaryId, Long facilityId) {
		String ictcBenStatus = "";
		try {
			ictcBenStatus = ictcBeneficiaryRepository.getICTCBenStatus(beneficiaryId, facilityId);
		} catch (Exception e) {
			return ictcBenStatus;
		}
		return ictcBenStatus;
	}

	public String getARTBenStatus(Long beneficiaryId, Long facilityId) {
		String artBenStatus = "";
		try {
			artBenStatus = artBeneficiaryRepository.getBenficiaryStatus(beneficiaryId, facilityId);
		} catch (Exception e) {
			return artBenStatus;
		}

		return artBenStatus;
	}
}
