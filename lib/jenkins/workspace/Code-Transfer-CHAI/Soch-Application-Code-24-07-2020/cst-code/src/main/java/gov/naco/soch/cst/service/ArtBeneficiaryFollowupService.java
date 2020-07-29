package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gov.naco.soch.cst.dto.ARTCounsellorFollowUpDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryFollowupMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryConcurrentCondition;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryLinkagePurposes;
import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtBeneficiarySideEffect;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiaryTransitFacility;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityLinkedFacilityBeneficiary;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.repository.ArtBeneficiaryConcurrentConditionRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryLinkagePurposesRepository;
import gov.naco.soch.repository.ArtBeneficiaryOpportunisticInfectionRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.ArtBeneficiarySideEffectRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryTransitFacilityRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.FacilityLinkedFacilityBeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class ArtBeneficiaryFollowupService {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryFollowupService.class);

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private ArtBeneficiaryFollowupRepository artBeneficiaryFollowupRepository;

	@Autowired
	private ArtBeneficiaryOpportunisticInfectionRepository artBeneficiaryOpportunisticInfectionRepository;

	@Autowired
	private ArtBeneficiarySideEffectRepository artBeneficiarySideEffectRepository;

	@Autowired
	private ArtBeneficiaryConcurrentConditionRepository artBeneficiaryConcurrentConditionRepository;

	@Autowired
	private FacilityLinkedFacilityBeneficiaryRepository linkedFacilityBeneficiaryRepository;

	@Autowired
	private TransferRepository transferRepository;

	@Autowired
	private BeneficiaryTransitFacilityRepository beneficiaryTransitFacilityRepository;

	@Autowired
	private BeneficiaryReferralRepository beneficiaryReferralRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	@Autowired
	private ArtBeneficiaryRepository artBeneficiaryRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	@Autowired
	private ArtBeneficiaryLinkagePurposesRepository artBeneficiaryLinkagePurposesRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	public ARTCounsellorFollowUpDto saveFollowUpBeneficiary(ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		if (artCounsellorFollowUpDto.getBeneficiaryId() != null && artCounsellorFollowUpDto.getBeneficiaryId() != 0) {
			Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository
					.findById(artCounsellorFollowUpDto.getBeneficiaryId());
			if (beneficiaryOptional.isPresent()) {
				Beneficiary beneficiary = beneficiaryOptional.get();
				LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
				Optional<Facility> facility = facilityRepository.findById(loginResponseDto.getFacilityId());
				Long visterRegister = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
						artCounsellorFollowUpDto.getBeneficiaryId());
				Optional<BeneficiaryVisitRegister> beneficiaryVisitRegister = beneficiaryVisitRegisterRepository
						.findById(visterRegister);
				if (beneficiaryVisitRegister.isPresent()) {
					BeneficiaryVisitRegister beneficiaryVisitRegisterDetails = beneficiaryVisitRegister.get();
					beneficiaryVisitRegisterDetails = ArtBeneficiaryFollowupMapper
							.maptoBeneficiaryVisitRegister(artCounsellorFollowUpDto, beneficiaryVisitRegisterDetails);
					beneficiaryVisitRegisterRepository.save(beneficiaryVisitRegisterDetails);
				}
				ArtBeneficiary artBeneficary = artBeneficiaryRepository
						.findByBeneficiaryIdAndAndIsDelete(artCounsellorFollowUpDto.getBeneficiaryId(), false);
				artBeneficary = ArtBeneficiaryFollowupMapper.mapToArtBeneficiary(artCounsellorFollowUpDto,
						artBeneficary);
				artBeneficary.setBeneficiary(beneficiary);
				artBeneficiaryRepository.save(artBeneficary);

				/*
				 * if (artCounsellorFollowUpDto.getUserMaster1() != null) {
				 * Optional<ArtBeneficiaryQueue> currentQueueOpt =
				 * artBeneficiaryQueueRepository.findBeneficiaryAssignedTo(
				 * artCounsellorFollowUpDto.getBeneficiaryId(),artCounsellorFollowUpDto.
				 * getUserMaster1() , loginResponseDto.getFacilityId(), LocalDate.now()); if
				 * (currentQueueOpt.isPresent()) { ArtBeneficiaryQueue currentQueue =
				 * currentQueueOpt.get(); currentQueue.setIsVisited(Boolean.TRUE);
				 * currentQueue.setIsActive(false); currentQueue.setIsDelete(true);
				 * artBeneficiaryQueueRepository.save(currentQueue); } UserMaster nextUser = new
				 * UserMaster(); nextUser.setId(artCounsellorFollowUpDto.getUserMaster1());
				 * UserMaster entryUser = new UserMaster();
				 * entryUser.setId(loginResponseDto.getUserId()); ArtBeneficiaryQueue
				 * artBeneficiaryQueue = new ArtBeneficiaryQueue();
				 * artBeneficiaryQueue.setAssignedToUser(nextUser);
				 * artBeneficiaryQueue.setEntryUser(entryUser);
				 * artBeneficiaryQueue.setFacility(facility.get());
				 * artBeneficiaryQueue.setVisitDate(LocalDate.now());
				 * artBeneficiaryQueue.setIsVisited(false);
				 * artBeneficiaryQueue.setIsActive(true);
				 * artBeneficiaryQueue.setIsDelete(false);
				 * artBeneficiaryQueue.setBeneficiary(beneficiary);
				 * artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get(
				 * )); artBeneficiaryQueueRepository.save(artBeneficiaryQueue); }
				 */
				
				logger.debug("Save ArtBeneficiaryQueue method ");
				if (artCounsellorFollowUpDto.getUserMaster1() != null) {
					ArtBeneficiaryQueue artBeneficiaryQueue = artBeneficiaryQueueRepository
							.findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(
									artCounsellorFollowUpDto.getBeneficiaryId(), loginResponseDto.getFacilityId());
					UserMaster nextUser = new UserMaster();
					nextUser.setId(artCounsellorFollowUpDto.getUserMaster1());
					 UserMaster entryUser = new UserMaster();
					 entryUser.setId(loginResponseDto.getUserId());
					if (artBeneficiaryQueue != null) {
						artBeneficiaryQueue.setAssignedToUser(nextUser);
						artBeneficiaryQueue.setEntryUser(entryUser);
						artBeneficiaryQueue.setFacility(facility.get());
						artBeneficiaryQueue.setVisitDate(LocalDate.now());
						artBeneficiaryQueue.setIsVisited(false);
						artBeneficiaryQueue.setIsActive(true);
						artBeneficiaryQueue.setIsDelete(false);
						artBeneficiaryQueue.setBeneficiary(beneficiary);
						artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
						artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
					}
					else {
						  ArtBeneficiaryQueue artBeneficiaryQueue1 = new ArtBeneficiaryQueue();
						  artBeneficiaryQueue1.setAssignedToUser(nextUser);
						  artBeneficiaryQueue1.setEntryUser(entryUser);
						  artBeneficiaryQueue1.setFacility(facility.get());
						  artBeneficiaryQueue1.setVisitDate(LocalDate.now());
						  artBeneficiaryQueue1.setIsVisited(false);
						  artBeneficiaryQueue1.setIsActive(true);
						  artBeneficiaryQueue1.setIsDelete(false);
						  artBeneficiaryQueue1.setBeneficiary(beneficiary);
						  artBeneficiaryQueue1.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get()); 
						 artBeneficiaryQueueRepository.save(artBeneficiaryQueue1); 
					}
				}

				saveArtBeneficiaryDueList(beneficiary, beneficiaryVisitRegister, artCounsellorFollowUpDto, facility);
				linkOut(artCounsellorFollowUpDto, beneficiary);
				transfer(artCounsellorFollowUpDto, beneficiary);
				refferal(artCounsellorFollowUpDto, beneficiary);
				transit(artCounsellorFollowUpDto, beneficiary);

				if (artCounsellorFollowUpDto.getArtBeneficiaryFollowupId() != null
						&& artCounsellorFollowUpDto.getArtBeneficiaryFollowupId() != 0) {
					Optional<ArtBeneficiaryFollowup> artBeneficiaryFollowupOptional = artBeneficiaryFollowupRepository
							.findById(artCounsellorFollowUpDto.getArtBeneficiaryFollowupId());
					if (artBeneficiaryFollowupOptional.isPresent()) {
						logger.debug("mapToArtBeneficiaryFollowup method called");
						ArtBeneficiaryFollowup artBeneficiaryFollowup = artBeneficiaryFollowupRepository
								.findByBeneficiaryVisitRegisterIdAndAndIsDelete(
										artBeneficiaryFollowupOptional.get().getBeneficiaryVisitRegister().getId(),
										false);
						artBeneficiaryFollowup = ArtBeneficiaryFollowupMapper
								.mapToArtBeneficiaryFollowup(artCounsellorFollowUpDto, artBeneficiaryFollowup);
						artBeneficiaryFollowup.setBeneficiary(beneficiary);
						artBeneficiaryFollowup.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
						artBeneficiaryFollowupRepository.save(artBeneficiaryFollowup);

						saveArtBeneficiaryLinkagePurpose(artCounsellorFollowUpDto, artBeneficiaryFollowup);
						saveOpportunisticInfections(artCounsellorFollowUpDto, artBeneficiaryFollowup);
						saveSideEffects(artCounsellorFollowUpDto, artBeneficiaryFollowup);
						saveConcurrentConditions(artCounsellorFollowUpDto, artBeneficiaryFollowup);
					}
				}

				else {
					logger.debug("mapToArtBeneficiaryFollowup method called");
					ArtBeneficiaryFollowup artBeneficiaryFollowup = ArtBeneficiaryFollowupMapper
							.mapToArtBeneficiaryFollowup(artCounsellorFollowUpDto);
					artBeneficiaryFollowup.setBeneficiary(beneficiary);
					artBeneficiaryFollowup.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
					artBeneficiaryFollowupRepository.save(artBeneficiaryFollowup);

					saveArtBeneficiaryLinkagePurpose(artCounsellorFollowUpDto, artBeneficiaryFollowup);
					saveOpportunisticInfections(artCounsellorFollowUpDto, artBeneficiaryFollowup);
					saveSideEffects(artCounsellorFollowUpDto, artBeneficiaryFollowup);
					saveConcurrentConditions(artCounsellorFollowUpDto, artBeneficiaryFollowup);
				}
			}
		}
		return artCounsellorFollowUpDto;
	}

	private void saveArtBeneficiaryLinkagePurpose(ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			ArtBeneficiaryFollowup artBeneficiaryFollowup) {

		List<Long> linkagePurposeIdList = artCounsellorFollowUpDto.getLinkagePurposesId();
		if (linkagePurposeIdList != null && !linkagePurposeIdList.isEmpty()) {
			List<ArtBeneficiaryLinkagePurposes> linkagePurposList = artBeneficiaryLinkagePurposesRepository
					.findByBeneficaryId(artBeneficiaryFollowup.getBeneficiary().getId());
			if (linkagePurposList != null && !linkagePurposList.isEmpty()) {
				artBeneficiaryLinkagePurposesRepository.deleteAll(linkagePurposList);
			}
			List<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposesList = ArtBeneficiaryFollowupMapper
					.mapToArtBeneficiaryLinkagePurposes(artCounsellorFollowUpDto);
			for (ArtBeneficiaryLinkagePurposes linkagePurposes : artBeneficiaryLinkagePurposesList) {
				linkagePurposes.setBeneficiary(artBeneficiaryFollowup.getBeneficiary());
			}
			artBeneficiaryLinkagePurposesRepository.saveAll(artBeneficiaryLinkagePurposesList);
		}

	}

	private void saveArtBeneficiaryDueList(Beneficiary beneficiary,
			Optional<BeneficiaryVisitRegister> beneficiaryVisitRegister,
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto, Optional<Facility> facility) {
		if (artCounsellorFollowUpDto.getNextVisitDate() != null) {
			LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
			Optional<ArtBeneficiaryDueList> artBeneficiaryDueListOption = artBeneficiaryDueListRepository
					.findByBeneficiaryNextVisitDateAndIsDelete(artCounsellorFollowUpDto.getBeneficiaryId(),currentUser.getFacilityId(), artCounsellorFollowUpDto.getNextVisitDate(), false);
			if (!artBeneficiaryDueListOption.isPresent()) {
				logger.debug("mapToBeneficiaryArtBeneficiaryDueList method called");
				ArtBeneficiaryDueList artBeneficiaryDueList = ArtBeneficiaryFollowupMapper
						.mapToBeneficiaryArtBeneficiaryDueList(artCounsellorFollowUpDto);
				artBeneficiaryDueList.setBeneficiary(beneficiary);
				artBeneficiaryDueList.setFacility(facility.get());
				artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
				artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
			}
		}
	}

	private void saveOpportunisticInfections(ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		List<Long> opportunisticInfectionId = artCounsellorFollowUpDto.getOpportunisticInfections();

		List<ArtBeneficiaryOpportunisticInfection> followupOpportunisticInfectionsList = artBeneficiaryOpportunisticInfectionRepository
				.findByVisitRegisterId(artBeneficiaryFollowup.getBeneficiaryVisitRegister().getId());
		if (followupOpportunisticInfectionsList != null && !followupOpportunisticInfectionsList.isEmpty()) {
			artBeneficiaryOpportunisticInfectionRepository.deleteAll(followupOpportunisticInfectionsList);
		}
		if (opportunisticInfectionId != null && !opportunisticInfectionId.isEmpty()) {
			List<ArtBeneficiaryOpportunisticInfection> followupOpportunisticInfectionsListToSave = ArtBeneficiaryFollowupMapper
					.mapToArtBeneficiaryOpportunisticInfection(artCounsellorFollowUpDto);
			for (ArtBeneficiaryOpportunisticInfection artBeneficiaryOpportunisticInfection : followupOpportunisticInfectionsListToSave) {
				artBeneficiaryOpportunisticInfection
						.setBeneficiaryVisitRegister(artBeneficiaryFollowup.getBeneficiaryVisitRegister());
				artBeneficiaryOpportunisticInfectionRepository.save(artBeneficiaryOpportunisticInfection);
			}

		}

	}

	private void saveSideEffects(ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		List<Long> aRTSideEffectsId = artCounsellorFollowUpDto.getaRTSideEffects();

		List<ArtBeneficiarySideEffect> artBeneficiarySideEffectsList = artBeneficiarySideEffectRepository
				.findByVisitRegisterId(artBeneficiaryFollowup.getBeneficiaryVisitRegister().getId());
		if (artBeneficiarySideEffectsList != null && !artBeneficiarySideEffectsList.isEmpty()) {
			artBeneficiarySideEffectRepository.deleteAll(artBeneficiarySideEffectsList);
		}
		if (aRTSideEffectsId != null && !aRTSideEffectsId.isEmpty()) {
			List<ArtBeneficiarySideEffect> followupSideEffectsList = ArtBeneficiaryFollowupMapper
					.mapToArtBeneficiaryFollowupSideEffect(artCounsellorFollowUpDto);
			for (ArtBeneficiarySideEffect sideEffect : followupSideEffectsList) {
				sideEffect.setBeneficiaryVisitRegister(artBeneficiaryFollowup.getBeneficiaryVisitRegister());
				artBeneficiarySideEffectRepository.save(sideEffect);
			}
		}

	}

	private void saveConcurrentConditions(ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		List<Long> concurrentConditionIds = artCounsellorFollowUpDto.getConcurrentCondition();
		List<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditionsList = artBeneficiaryConcurrentConditionRepository
				.findByVisitRegisterId(artBeneficiaryFollowup.getBeneficiaryVisitRegister().getId());
		if (artBeneficiaryConcurrentConditionsList != null && !artBeneficiaryConcurrentConditionsList.isEmpty()) {
			artBeneficiaryConcurrentConditionRepository.deleteAll(artBeneficiaryConcurrentConditionsList);
		}
		if (concurrentConditionIds != null && !concurrentConditionIds.isEmpty()) {
			List<ArtBeneficiaryConcurrentCondition> concurrentConditionsList = ArtBeneficiaryFollowupMapper
					.mapToArtBeneficiaryFollowupConcurrentCondition(artCounsellorFollowUpDto);
			for (ArtBeneficiaryConcurrentCondition condition : concurrentConditionsList) {
				condition.setBeneficiaryVisitRegister(artBeneficiaryFollowup.getBeneficiaryVisitRegister());
				artBeneficiaryConcurrentConditionRepository.save(condition);
			}
		}

	}

	private void transit(ARTCounsellorFollowUpDto artCounsellorFollowUpDto, Beneficiary beneficiary) {
		List<Long> transistFacilityId = artCounsellorFollowUpDto.getTransistFacilityId();
		List<BeneficiaryTransitFacility> beneficiaryTransitFacilities = beneficiaryTransitFacilityRepository
				.findByBeneficiaryIdAndIsDelete(artCounsellorFollowUpDto.getBeneficiaryId(), false);
		if (beneficiaryTransitFacilities != null && !beneficiaryTransitFacilities.isEmpty()) {
			beneficiaryTransitFacilityRepository.deleteAll(beneficiaryTransitFacilities);
		}
		if (transistFacilityId != null && !transistFacilityId.isEmpty()) {
			List<BeneficiaryTransitFacility> transitFacility = ArtBeneficiaryFollowupMapper
					.mapToBeneficiaryTransitFacility(artCounsellorFollowUpDto);
			for (BeneficiaryTransitFacility beneficiaryTransitFacility1 : transitFacility) {
				beneficiaryTransitFacility1.setBeneficiary(beneficiary);
				beneficiaryTransitFacilityRepository.save(beneficiaryTransitFacility1);
			}
		}
	}

	private void refferal(ARTCounsellorFollowUpDto artCounsellorFollowUpDto, Beneficiary beneficiary) {
		BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		Optional<BeneficiaryReferral> beneficiaryReferraloptional = beneficiaryReferralRepository
				.findByBeneficiaryAndIsDelete(beneficiary.getId(), currentUser.getFacilityId(), false);
		if (beneficiaryReferraloptional.isPresent()) {
			beneficiaryReferralRepository.delete(beneficiaryReferraloptional.get());
		}
		if (artCounsellorFollowUpDto.getReferTo() != null) {
			beneficiaryReferral = ArtBeneficiaryFollowupMapper.mapToBeneficiaryReferral(artCounsellorFollowUpDto);
			beneficiaryReferral.setBeneficiary(beneficiary);
			beneficiaryReferralRepository.save(beneficiaryReferral);
		}
	}

	private void transfer(ARTCounsellorFollowUpDto artCounsellorFollowUpDto, Beneficiary beneficiary) {
		Transfer artPatientTransfer = new Transfer();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		Optional<Transfer> artPatientTransferOpt = transferRepository.findByBeneficiaryAndIsDeleted(beneficiary.getId(),currentUser.getFacilityId(), false);
		if (artPatientTransferOpt.isPresent()) {
			artPatientTransfer = artPatientTransferOpt.get();
			transferRepository.delete(artPatientTransfer);
		}
		if (artCounsellorFollowUpDto.getDestinationFacilityId() != null) {
			artPatientTransfer = ArtBeneficiaryFollowupMapper.mapToTransfer(artCounsellorFollowUpDto);
			artPatientTransfer.setBeneficiary(beneficiary);
			artPatientTransfer.setTransferStatus("PENDING");
			artPatientTransfer.setInitiationDate(LocalDate.now());
			transferRepository.save(artPatientTransfer);
		}
	}

	private void linkOut(ARTCounsellorFollowUpDto artCounsellorFollowUpDto, Beneficiary beneficiary) {
		FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary = new FacilityLinkedFacilityBeneficiary();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		Optional<FacilityLinkedFacilityBeneficiary> linkedFacilityBeneficiaryOpt = linkedFacilityBeneficiaryRepository
				.findByBeneficiaryAndIsDelete(beneficiary.getId(),currentUser.getFacilityId(), false);
		if (linkedFacilityBeneficiaryOpt.isPresent()) {
			facilityLinkedFacilityBeneficiary = linkedFacilityBeneficiaryOpt.get();
			linkedFacilityBeneficiaryRepository.delete(facilityLinkedFacilityBeneficiary);
		}
		if (artCounsellorFollowUpDto.getLinkedFacilityId() != null) {
			facilityLinkedFacilityBeneficiary = ArtBeneficiaryFollowupMapper
					.mapToFacilityLinkedFacilityBeneficiary(artCounsellorFollowUpDto);
			facilityLinkedFacilityBeneficiary.setBeneficiary(beneficiary);
			linkedFacilityBeneficiaryRepository.save(facilityLinkedFacilityBeneficiary);
		}
	}

	public ARTCounsellorFollowUpDto getAllARTCounsellorFollowUpList(Long beneficiaryId) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				beneficiaryId);
		Optional<ArtBeneficiaryFollowup> followupOption = artBeneficiaryFollowupRepository
				.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);
		List<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditionList = artBeneficiaryConcurrentConditionRepository
				.findByVisitRegisterId(visitRegisterId);
		List<ArtBeneficiarySideEffect> artBeneficiarySideEffectList = artBeneficiarySideEffectRepository
				.findByVisitRegisterId(visitRegisterId);
		List<ArtBeneficiaryOpportunisticInfection> beneficiaryOpportunisticInfectionList = artBeneficiaryOpportunisticInfectionRepository
				.findByVisitRegisterId(visitRegisterId);
		List<ArtBeneficiaryLinkagePurposes> linkagePurposesList = artBeneficiaryLinkagePurposesRepository
				.findByBeneficaryId(beneficiaryId);
		ArtBeneficiary artBeneficiaries = artBeneficiaryRepository.findByBeneficiaryIdAndAndIsDelete(beneficiaryId,
				false);
		ARTCounsellorFollowUpDto counsellorFollowUpDto = new ARTCounsellorFollowUpDto();
		if (followupOption.isPresent()) {
			return ArtBeneficiaryFollowupMapper.mapToArtBeneficiaryFollowupDetails(followupOption.get(),
					artBeneficiaryConcurrentConditionList, artBeneficiarySideEffectList,
					beneficiaryOpportunisticInfectionList, linkagePurposesList, artBeneficiaries);
		}
		return counsellorFollowUpDto;
	}
}
