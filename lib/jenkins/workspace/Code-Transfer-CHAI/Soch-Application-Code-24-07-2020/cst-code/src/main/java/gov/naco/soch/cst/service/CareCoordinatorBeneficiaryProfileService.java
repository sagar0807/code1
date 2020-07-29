package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import gov.naco.soch.cst.dto.BeneficiaryFourSSymptomsPerVisitDto;
import gov.naco.soch.cst.dto.BeneficiaryLabTestDetailsDto;
import gov.naco.soch.cst.dto.CareCoordinationProfileDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.BeneficiaryFourSSymptomsPerVisit;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterFourSsymptom;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.repository.ArtBeneficiaryClinicalDetailRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.BeneficiaryFourSSymptomsPerVisitRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class CareCoordinatorBeneficiaryProfileService {

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private BeneficiaryFourSSymptomsPerVisitRepository beneficiaryFourSSymptomsPerVisitRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	@Autowired
	private BeneficiaryLabTestDetailsService beneficiaryLabTestDetailsService;

	@Autowired
	private ArtBeneficiaryClinicalDetailRepository artBeneficiaryClinicalDetailRepository;

	@Autowired
	private ArtBeneficiaryFollowupRepository artBeneficiaryFollowupRepository;

	public CareCoordinationProfileDto getAllCareCoordinatorBeneficiaryProfile(Long beneficiaryId) {
		CareCoordinationProfileDto coordinationProfileDto = new CareCoordinationProfileDto();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForTodayExist(loginResponseDto.getFacilityId(),
				beneficiaryId);
		if (visitRegisterId != null) {
			Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
					.findById(visitRegisterId);
			if (optVisitDetails.isPresent()) {
				BeneficiaryVisitRegister visitDetails = optVisitDetails.get();
				coordinationProfileDto.setBeneficiaryId(visitDetails.getBeneficiary().getId());
				coordinationProfileDto.setVisitBy(visitDetails.getVisitBy());
				coordinationProfileDto.setLastVisitDate(visitDetails.getVisitDate());
				coordinationProfileDto.setPreviousWeight(visitDetails.getWeight());
				coordinationProfileDto.setPreviousHeight(visitDetails.getHeight());
				coordinationProfileDto.setWeight(visitDetails.getWeight());
				coordinationProfileDto.setHeight(visitDetails.getHeight());
				coordinationProfileDto.setIsFourSSymptoms(visitDetails.getFoursSymptoms());
				if (visitDetails.getFoursSymptoms() != null && visitDetails.getFoursSymptoms() == true) {
					List<BeneficiaryFourSSymptomsPerVisit> fourSSymptoms = beneficiaryFourSSymptomsPerVisitRepository
							.findByVisitRegisterId(visitRegisterId);
					if (fourSSymptoms != null && !fourSSymptoms.isEmpty()) {
						List<BeneficiaryFourSSymptomsPerVisitDto> fourSSymptomsPerVisitDtoList = fourSSymptoms.stream()
								.map(f -> {
									BeneficiaryFourSSymptomsPerVisitDto fourSSymptomsPerVisitDto = new BeneficiaryFourSSymptomsPerVisitDto();
									if (f.getMasterFourSSymptom() != null) {
										fourSSymptomsPerVisitDto.setFourSSymptomId(f.getMasterFourSSymptom().getId());
										fourSSymptomsPerVisitDto.setFourSSymptom(f.getMasterFourSSymptom().getName());
									}
									return fourSSymptomsPerVisitDto;
								}).collect(Collectors.toList());
						coordinationProfileDto.setFourSSysmptomsValue(fourSSymptomsPerVisitDtoList);
					}
				}
				BeneficiaryLabTestDetailsDto labTestDetails = beneficiaryLabTestDetailsService
						.getBeneficiaryLabTestDetils(beneficiaryId);
				if (labTestDetails != null) {
					coordinationProfileDto.setLabTestDetailsDto(labTestDetails);
				}

				Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
						.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);
				if (optClinicalDetails.isPresent()) {
					if (optClinicalDetails.get().getRegimen() != null) {
						coordinationProfileDto.setRegimenId(optClinicalDetails.get().getRegimen().getId());
						coordinationProfileDto.setRegimenName(optClinicalDetails.get().getRegimen().getRegimenName());
					}

				}
				Optional<ArtBeneficiaryFollowup> followupOption = artBeneficiaryFollowupRepository
						.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);

				if (followupOption.isPresent()) {
					if (followupOption.get().getAdherenceToArt() != null) {
						coordinationProfileDto.setLastAdherenceValue(followupOption.get().getAdherenceToArt());
					}
				}

				ArtBeneficiaryQueue artBeneficiaryQueueOpt = artBeneficiaryQueueRepository
						.findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(coordinationProfileDto.getBeneficiaryId(), loginResponseDto.getFacilityId());
				if (artBeneficiaryQueueOpt!=null) {
					UserMaster assignedToUser = artBeneficiaryQueueOpt.getAssignedToUser();
					if (assignedToUser != null) {
						coordinationProfileDto.setAssignToNextUser(assignedToUser.getId());
					}
				}

			}
		}
		return coordinationProfileDto;
	}

	public CareCoordinationProfileDto saveBeneficiaryProfile(CareCoordinationProfileDto beneficiaryProfile) {

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				beneficiaryProfile.getBeneficiaryId());

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);
		if (optVisitDetails.isPresent()) {
			BeneficiaryVisitRegister visitDetails = optVisitDetails.get();

			UserMaster entryUser = new UserMaster();
			entryUser.setId(loginResponseDto.getUserId());
			visitDetails.setWeight(beneficiaryProfile.getWeight());
			visitDetails.setHeight(beneficiaryProfile.getHeight());
			visitDetails.setFoursSymptoms(beneficiaryProfile.getIsFourSSymptoms());
			visitDetails.setVisitBy(beneficiaryProfile.getVisitBy());
			List<BeneficiaryFourSSymptomsPerVisit> oldFourSSymptoms = beneficiaryFourSSymptomsPerVisitRepository
					.findByVisitRegisterId(visitRegisterId);
			beneficiaryFourSSymptomsPerVisitRepository.deleteAll(oldFourSSymptoms);

			if (!CollectionUtils.isEmpty(beneficiaryProfile.getFourSSysmptomsValue())) {
				visitDetails.setFoursSymptoms(Boolean.TRUE);
				List<BeneficiaryFourSSymptomsPerVisit> fourSSymptomsPerVisitList = beneficiaryProfile
						.getFourSSysmptomsValue().stream().map(f -> {
							BeneficiaryFourSSymptomsPerVisit fourSSymptomsPerVisit = new BeneficiaryFourSSymptomsPerVisit();
							fourSSymptomsPerVisit.setBeneficiaryVisitRegister(visitDetails);
							MasterFourSsymptom fourSSymptom = new MasterFourSsymptom();
							fourSSymptom.setId(f.getFourSSymptomId());
							fourSSymptomsPerVisit.setMasterFourSSymptom(fourSSymptom);
							fourSSymptom.setIsActive(Boolean.TRUE);
							fourSSymptom.setIsDelete(Boolean.FALSE);
							return fourSSymptomsPerVisit;
						}).collect(Collectors.toList());

				beneficiaryFourSSymptomsPerVisitRepository.saveAll(fourSSymptomsPerVisitList);
			}

			Facility facility = new Facility();
			facility.setId(loginResponseDto.getFacilityId());

			Optional<ArtBeneficiaryQueue> currentQueueOpt = artBeneficiaryQueueRepository.findBeneficiaryAssignedTo(
					beneficiaryProfile.getBeneficiaryId(), loginResponseDto.getUserId(),
					loginResponseDto.getFacilityId(), LocalDate.now());
			if (currentQueueOpt.isPresent()) {
				ArtBeneficiaryQueue currentQueue = currentQueueOpt.get();
				currentQueue.setIsVisited(Boolean.TRUE);
				artBeneficiaryQueueRepository.save(currentQueue);
			}
			if (beneficiaryProfile.getAssignToNextUser() != null) {
				UserMaster nextUser = new UserMaster();
				nextUser.setId(beneficiaryProfile.getAssignToNextUser());
				ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
				artBeneficiaryQueue.setAssignedToUser(nextUser);
				artBeneficiaryQueue.setEntryUser(entryUser);
				artBeneficiaryQueue.setFacility(facility);
				artBeneficiaryQueue.setVisitDate(LocalDate.now());
				artBeneficiaryQueue.setIsVisited(false);
				artBeneficiaryQueue.setIsActive(true);
				artBeneficiaryQueue.setIsDelete(false);
				artBeneficiaryQueue.setBeneficiary(optVisitDetails.get().getBeneficiary());
				artBeneficiaryQueue.setBeneficiaryVisitRegister(optVisitDetails.get());
				artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
			}
			ArtBeneficiaryDueList artBeneficiaryDueLists = artBeneficiaryDueListRepository
					.findByBeneficiaryVisitRegister_Id(visitDetails.getId(),LocalDate.now());
			if (artBeneficiaryDueLists != null) {
				artBeneficiaryDueLists.setIsVisited(Boolean.TRUE);
				artBeneficiaryDueListRepository.save(artBeneficiaryDueLists);
			}
			beneficiaryVisitRegisterRepository.save(visitDetails);
		}
		return beneficiaryProfile;

	}

}
