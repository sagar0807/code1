/**
 * 
 */
package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ArtBeneficiaryImmunizationReportDto;
import gov.naco.soch.cst.dto.DnaPcrResultsDto;
import gov.naco.soch.cst.dto.PediatricBeneficiariesInformationDto;
import gov.naco.soch.cst.dto.VitaminAResultDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryDnaPcrResult;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryImmunizationReport;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtBeneficiaryVitaminA;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterDnaPcrResult;
import gov.naco.soch.entity.MasterDnaPcrTest;
import gov.naco.soch.entity.MasterEducationLevel;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterGuardianCaregiver;
import gov.naco.soch.entity.MasterInfantFeeding;
import gov.naco.soch.entity.MasterStayingWith;
import gov.naco.soch.entity.MasterVaccineStage;
import gov.naco.soch.entity.MasterVaccineType;
import gov.naco.soch.entity.MasterVitaminAAge;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.repository.ArtBeneficiaryDnaPcrResultRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryImmunizationReportRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.ArtBeneficiaryVitaminARepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class PediatricBeneficiariesService {

	private static final Logger logger = LoggerFactory.getLogger(ArtPepService.class);

	@Autowired
	private ArtBeneficiaryImmunizationReportRepository artBeneficiaryImmunizationReportRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueReportRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private ArtBeneficiaryFollowupRepository artBeneficiaryFollowupRepository;

	@Autowired
	private ArtBeneficiaryVitaminARepository artBeneficiaryVitaminARepository;

	@Autowired
	private ArtBeneficiaryDnaPcrResultRepository artBeneficiaryDnaPcrResultRepository;

	public boolean savePediatricBeneficiaries(
			PediatricBeneficiariesInformationDto pediatricBeneficiariesInformationDto) {
		logger.debug("Entering into savePediatricBeneficiaries method");

		if (pediatricBeneficiariesInformationDto != null) {

			List<ArtBeneficiaryImmunizationReportDto> artBeneficiaryImmunizationReportDto = new ArrayList<ArtBeneficiaryImmunizationReportDto>();
			artBeneficiaryImmunizationReportDto = pediatricBeneficiariesInformationDto
					.getArtBeneficiaryImmunizationReportDtos();

			List<VitaminAResultDto> vitaminAResultDtos = new ArrayList<VitaminAResultDto>();
			vitaminAResultDtos = pediatricBeneficiariesInformationDto.getVitaminAResultDtos();
			List<DnaPcrResultsDto> dnaPcrResultsDtos = new ArrayList<DnaPcrResultsDto>();
			dnaPcrResultsDtos = pediatricBeneficiariesInformationDto.getDnaPcrResultsDtos();

			Beneficiary beneficiary = new Beneficiary();
			beneficiary.setId(pediatricBeneficiariesInformationDto.getBeneficiaryId());

			LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
			Facility facility = new Facility();
			facility.setId(currentUser.getFacilityId());

			UserMaster entryUser = new UserMaster();
			entryUser.setId(currentUser.getUserId());

			Long visterRegister = VisitRegisterService.getVisitRegisterIdForToday(currentUser.getFacilityId(),
					pediatricBeneficiariesInformationDto.getBeneficiaryId());
			
			BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
			beneficiaryVisitRegister.setId(visterRegister);

			if (pediatricBeneficiariesInformationDto.getAssignedTo() != null) {

				ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();

				UserMaster assignTo = new UserMaster();
				assignTo.setId(pediatricBeneficiariesInformationDto.getAssignedTo());
				beneficiary.setId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				artBeneficiaryQueue = artBeneficiaryQueueReportRepository
						.findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(
								pediatricBeneficiariesInformationDto.getBeneficiaryId(), currentUser.getFacilityId());
				if (artBeneficiaryQueue != null) {
					artBeneficiaryQueue.setAssignedToUser(assignTo);
					artBeneficiaryQueue.setVisitDate(pediatricBeneficiariesInformationDto.getNextVisitDate());
					artBeneficiaryQueueReportRepository.save(artBeneficiaryQueue);

				} else {
					ArtBeneficiaryQueue tempArtBeneficiaryQueue = new ArtBeneficiaryQueue();
					tempArtBeneficiaryQueue.setVisitDate(pediatricBeneficiariesInformationDto.getNextVisitDate());
					tempArtBeneficiaryQueue.setFacility(facility);
					tempArtBeneficiaryQueue.setAssignedToUser(assignTo);
					tempArtBeneficiaryQueue.setEntryUser(entryUser);

					tempArtBeneficiaryQueue.setBeneficiary(beneficiary);
					tempArtBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
					tempArtBeneficiaryQueue.setIsVisited(Boolean.FALSE);
					tempArtBeneficiaryQueue.setIsActive(Boolean.TRUE);
					tempArtBeneficiaryQueue.setIsDelete(Boolean.FALSE);
					artBeneficiaryQueueReportRepository.save(tempArtBeneficiaryQueue);
				}
		
			}
			  if(pediatricBeneficiariesInformationDto.getNextVisitDate()!=null) {
	                ArtBeneficiaryDueList tempArtBeneficiaryDueList = new ArtBeneficiaryDueList();
	                tempArtBeneficiaryDueList = artBeneficiaryDueListRepository
	                        .findByBeneficiaryIdAndExpectedVisitDateAndIsvisitedAndFacilityId(
	                                pediatricBeneficiariesInformationDto.getBeneficiaryId(),
	                                pediatricBeneficiariesInformationDto.getNextVisitDate(), currentUser.getFacilityId());
	                if (tempArtBeneficiaryDueList != null) {
	                    tempArtBeneficiaryDueList
	                            .setExpectedVisitDate(pediatricBeneficiariesInformationDto.getNextVisitDate());
	                    artBeneficiaryDueListRepository.save(tempArtBeneficiaryDueList);
	                } else {
	                    ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
	                    artBeneficiaryDueList.setExpectedVisitDate(pediatricBeneficiariesInformationDto.getNextVisitDate());
	                    artBeneficiaryDueList.setBeneficiary(beneficiary);
	                    artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
	                    artBeneficiaryDueList.setFacility(facility);
	                    artBeneficiaryDueList.setEntryUser(entryUser);
	           
	                    artBeneficiaryDueList.setIsVisited(Boolean.FALSE);
	                    artBeneficiaryDueList.setIsActive(Boolean.TRUE);
	                    artBeneficiaryDueList.setIsDelete(Boolean.FALSE);
	           
	                    artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
	                }
	            }
			
			// Updating beneficiary table
			if (pediatricBeneficiariesInformationDto.getBeneficiaryId() != null) {
				Beneficiary beneficiaryTemp = beneficiaryRepository
						.findById(pediatricBeneficiariesInformationDto.getBeneficiaryId()).get();
				MasterEducationLevel guardianCaregiverHighestEducationId = new MasterEducationLevel();
				if(pediatricBeneficiariesInformationDto.getGuardianHighestEducationId()!=null) {
					guardianCaregiverHighestEducationId
						.setId(pediatricBeneficiariesInformationDto.getGuardianHighestEducationId());
					beneficiaryTemp.setGuardianCaregiverHighestEducation_id(guardianCaregiverHighestEducationId);
				}
				beneficiaryTemp.setDateOfBirth(pediatricBeneficiariesInformationDto.getAge());
				
				MasterGender gender = new MasterGender();
				if(pediatricBeneficiariesInformationDto.getSexId() !=null) {
					gender.setId(pediatricBeneficiariesInformationDto.getSexId());
				}
				
				beneficiaryTemp.setGenderId(gender);
				
				MasterStayingWith stayingWithId = new MasterStayingWith();
				if(pediatricBeneficiariesInformationDto.getStayingWithId() !=null) {
					stayingWithId.setId(pediatricBeneficiariesInformationDto.getStayingWithId());
					beneficiaryTemp.setStayingWithId(stayingWithId);
				}
				beneficiaryTemp.setStayingWithOthers(pediatricBeneficiariesInformationDto.getStayingWithOthers());
				
				MasterGuardianCaregiver guardianCaregiverId = new MasterGuardianCaregiver();
				if(pediatricBeneficiariesInformationDto.getGuardianCaregiverId() !=null) {
					guardianCaregiverId.setId(pediatricBeneficiariesInformationDto.getGuardianCaregiverId());
					beneficiaryTemp.setGuardianCaregiverId(guardianCaregiverId);
				}
				beneficiaryTemp.setGuardianCaregiverOthers(pediatricBeneficiariesInformationDto.getGuardianCaregiverOthers());
				
				if(pediatricBeneficiariesInformationDto.getBirthHistoryId() != null) {
					beneficiaryTemp.setBirthHistoryId(pediatricBeneficiariesInformationDto.getBirthHistoryId());
				}
				beneficiaryTemp.setBirthWeight(pediatricBeneficiariesInformationDto.getBirthWeight());
				beneficiaryTemp
						.setNeoNatalComplications(pediatricBeneficiariesInformationDto.getNeonatalComplications());
				beneficiaryRepository.save(beneficiaryTemp);

			}

			// Art Beneficiary Followup
			ArtBeneficiaryFollowup artBeneficiaryFollowup = new ArtBeneficiaryFollowup();
			MasterInfantFeeding infantFeedingId = new MasterInfantFeeding();
			artBeneficiaryFollowup = artBeneficiaryFollowupRepository.findByBeneficiaryIdAndIsdeleteAndVisitDate(
					pediatricBeneficiariesInformationDto.getBeneficiaryId());

			if (artBeneficiaryFollowup != null) {
				artBeneficiaryFollowup.setPaediatricMilestoneAchievedAsPerAge(
						pediatricBeneficiariesInformationDto.getMilestoneAchieved());
				if(pediatricBeneficiariesInformationDto.getInfantFeedingId()!=null) {
					infantFeedingId.setId(pediatricBeneficiariesInformationDto.getInfantFeedingId());
					artBeneficiaryFollowup.setInfantFeedingId(infantFeedingId);
				}
				artBeneficiaryFollowup.setInfantFeedingBreastFeedStopMonths(pediatricBeneficiariesInformationDto.getInfantFeedingBreastFeedStopMonths());
				artBeneficiaryFollowupRepository.save(artBeneficiaryFollowup); 
																				
			} else {

//				BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
//				beneficiaryVisitRegister.setId(visterRegister);
				
				ArtBeneficiaryFollowup artBeneficiaryFollowupTemp = new ArtBeneficiaryFollowup();
				if(pediatricBeneficiariesInformationDto.getInfantFeedingId()!=null) {
					infantFeedingId.setId(pediatricBeneficiariesInformationDto.getInfantFeedingId());
					artBeneficiaryFollowupTemp.setInfantFeedingId(infantFeedingId);
				}
				artBeneficiaryFollowupTemp.setInfantFeedingBreastFeedStopMonths(pediatricBeneficiariesInformationDto.getInfantFeedingBreastFeedStopMonths());
				artBeneficiaryFollowupTemp.setIsActive(Boolean.TRUE);
				artBeneficiaryFollowupTemp.setIsDelete(Boolean.FALSE);
				artBeneficiaryFollowupTemp.setVisitDate(LocalDate.now());
				artBeneficiaryFollowupTemp.setBeneficiary(beneficiary);
				artBeneficiaryFollowupTemp.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
				artBeneficiaryFollowupTemp.setFacility(facility);
				artBeneficiaryFollowupTemp.setEntryUser(entryUser);
				artBeneficiaryFollowupTemp.setPaediatricMilestoneAchievedAsPerAge(
						pediatricBeneficiariesInformationDto.getMilestoneAchieved());
				artBeneficiaryFollowupRepository.save(artBeneficiaryFollowupTemp); // will un comment after getting
																					// confirmation from vimod
			}
			// System.out.println("out--");

			// art Beneficiary Immunization Report
			if (artBeneficiaryImmunizationReportDto != null) {
				int count = 0;
				count = artBeneficiaryImmunizationReportRepository
						.findCountByBeneficiaryId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				if (count > 0) {
					artBeneficiaryImmunizationReportRepository
							.deleteByBeneficiaryId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				}

				artBeneficiaryImmunizationReportDto.forEach(row -> {
					ArtBeneficiaryImmunizationReport artBeneficiaryImmunizationReport = new ArtBeneficiaryImmunizationReport();
					artBeneficiaryImmunizationReport.setDueDate(row.getDueDate());
					artBeneficiaryImmunizationReport.setGivenDate(row.getGiveDate());
					artBeneficiaryImmunizationReport.setIsActive(Boolean.TRUE);
					artBeneficiaryImmunizationReport.setIsDelete(Boolean.FALSE);
					if (beneficiary != null) {
						artBeneficiaryImmunizationReport.setBeneficiary(beneficiary);

					}
					MasterVaccineStage masterVaccineStage = new MasterVaccineStage();
					masterVaccineStage.setId(row.getVaccineStageId());

					artBeneficiaryImmunizationReport.setMasterVaccineStage(masterVaccineStage);

					MasterVaccineType masterVaccineType = new MasterVaccineType();
					masterVaccineType.setId(row.getVaccineTypeId());

					artBeneficiaryImmunizationReport.setMasterVaccineType(masterVaccineType);

					artBeneficiaryImmunizationReportRepository.save(artBeneficiaryImmunizationReport);
				});

			}

			// Vitamin A AGE
			if (vitaminAResultDtos != null) {
				int count = 0;
				count = artBeneficiaryVitaminARepository
						.findCountByBeneficiaryId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				if (count > 0) {
					artBeneficiaryVitaminARepository
							.deleteByBeneficiaryId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				}
				vitaminAResultDtos.forEach(row -> {
					ArtBeneficiaryVitaminA artBeneficiaryVitaminA = new ArtBeneficiaryVitaminA();
					if (beneficiary != null) {
						artBeneficiaryVitaminA.setBeneficiary(beneficiary);
					}
					MasterVitaminAAge masterVitaminAAge = new MasterVitaminAAge();
					masterVitaminAAge.setId(row.getVitaminAAgeId());
					artBeneficiaryVitaminA.setMasterVitaminAAge(masterVitaminAAge);
					artBeneficiaryVitaminA.setGivenDate(row.getGivenDate());
					artBeneficiaryVitaminA.setIsActive(Boolean.TRUE);
					artBeneficiaryVitaminA.setIsDelete(Boolean.FALSE);

					artBeneficiaryVitaminARepository.save(artBeneficiaryVitaminA);
				});
			}

			// DNA PCR results data
			if (dnaPcrResultsDtos != null) {
				int count = 0;
				count = artBeneficiaryDnaPcrResultRepository
						.findCountByBeneficiaryId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				if (count > 0) {
					artBeneficiaryDnaPcrResultRepository
							.deleteByBeneficiaryId(pediatricBeneficiariesInformationDto.getBeneficiaryId());
				}
				dnaPcrResultsDtos.forEach(row -> {
					ArtBeneficiaryDnaPcrResult artBeneficiaryDnaPcrResult = new ArtBeneficiaryDnaPcrResult();
					if (beneficiary != null) {
						artBeneficiaryDnaPcrResult.setBeneficiary(beneficiary);
					}
					MasterDnaPcrResult masterDnaPcrResult = new MasterDnaPcrResult();
					masterDnaPcrResult.setId(row.getDnaPcrResultId());
					artBeneficiaryDnaPcrResult.setMasterDnaPcrResult(masterDnaPcrResult);
					MasterDnaPcrTest masterDnaPcrTest = new MasterDnaPcrTest();
					masterDnaPcrTest.setId(row.getDnaPcrTestId());
					artBeneficiaryDnaPcrResult.setMasterDnaPcrTest(masterDnaPcrTest);
					artBeneficiaryDnaPcrResult.setIsActive(Boolean.TRUE);
					artBeneficiaryDnaPcrResult.setIsDelete(Boolean.FALSE);

					artBeneficiaryDnaPcrResultRepository.save(artBeneficiaryDnaPcrResult);
				});
			}
		}

		return true;
	}

	/**
	 * ;
	 * 
	 * @param beneficiaryid
	 * @return
	 */
	public PediatricBeneficiariesInformationDto getByBeneficiaryId(Long beneficiaryid) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();

		PediatricBeneficiariesInformationDto pediatricBeneficiariesInformationDto = new PediatricBeneficiariesInformationDto();
		List<ArtBeneficiaryImmunizationReportDto> artBeneficiaryImmunizationReportDto = new ArrayList<ArtBeneficiaryImmunizationReportDto>();
		List<VitaminAResultDto> vitaminAResultDtos = new ArrayList<VitaminAResultDto>();
		List<DnaPcrResultsDto> dnaPcrResultsDtos = new ArrayList<DnaPcrResultsDto>();

		Beneficiary beneficiary = beneficiaryRepository.findById(beneficiaryid).get();
		ArtBeneficiaryFollowup artBeneficiaryFollowup = artBeneficiaryFollowupRepository
				.findByBeneficiaryIdAndIsdeleteAndVisitDate(beneficiaryid);
		List<ArtBeneficiaryImmunizationReport> artBeneficiaryImmunizationReports = artBeneficiaryImmunizationReportRepository
				.findAllByBeneficiaryId(beneficiaryid);
		List<ArtBeneficiaryVitaminA> artBeneficiaryVitaminAs = artBeneficiaryVitaminARepository
				.findAllByBeneficiaryId(beneficiaryid);
		List<ArtBeneficiaryDnaPcrResult> artBeneficiaryDnaPcrResults = artBeneficiaryDnaPcrResultRepository
				.findAllByBeneficiaryId(beneficiaryid);
		ArtBeneficiaryQueue artBeneficiaryQueue = artBeneficiaryQueueReportRepository
				.findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(beneficiaryid, currentUser.getFacilityId());
		ArtBeneficiaryDueList artBeneficiaryDueList = artBeneficiaryDueListRepository.findByBeneficiaryIdAndFacilityIdAndIsVisited(beneficiaryid, currentUser.getFacilityId());

		if (artBeneficiaryImmunizationReports != null) {
			artBeneficiaryImmunizationReports.forEach(row -> {
				ArtBeneficiaryImmunizationReportDto tempArtBeneficiaryImmunizationReport = new ArtBeneficiaryImmunizationReportDto();
				tempArtBeneficiaryImmunizationReport.setId(row.getId());
				if (beneficiary != null) {
					tempArtBeneficiaryImmunizationReport.setBenefciaryId(beneficiary.getId());
				}
				if (row.getMasterVaccineStage() != null) {
					tempArtBeneficiaryImmunizationReport.setVaccineStageId(row.getMasterVaccineStage().getId());
					tempArtBeneficiaryImmunizationReport.setVaccineStageName(row.getMasterVaccineStage().getName());
				}
				if (row.getMasterVaccineType() != null) {
					tempArtBeneficiaryImmunizationReport.setVaccineTypeId(row.getMasterVaccineType().getId());
					tempArtBeneficiaryImmunizationReport.setVaccineTypeName(row.getMasterVaccineType().getName());
				}
				tempArtBeneficiaryImmunizationReport.setDueDate(row.getDueDate());
				tempArtBeneficiaryImmunizationReport.setGiveDate(row.getGivenDate());
				artBeneficiaryImmunizationReportDto.add(tempArtBeneficiaryImmunizationReport);
			});
		}

		if (artBeneficiaryVitaminAs != null) {
			artBeneficiaryVitaminAs.forEach(row -> {
				VitaminAResultDto tempVitaminAResultDto = new VitaminAResultDto();
				tempVitaminAResultDto.setId(row.getId());
				if (row.getMasterVitaminAAge() != null) {

					tempVitaminAResultDto.setVitaminAAgeId(row.getMasterVitaminAAge().getId());
					tempVitaminAResultDto.setVitaminAAgeName(row.getMasterVitaminAAge().getName());
					tempVitaminAResultDto.setGivenDate(row.getGivenDate());
				}

				vitaminAResultDtos.add(tempVitaminAResultDto);
			});
		}

		if (artBeneficiaryDnaPcrResults != null) {
			artBeneficiaryDnaPcrResults.forEach(row -> {

				DnaPcrResultsDto tempDnaPcrResultsDto = new DnaPcrResultsDto();
				tempDnaPcrResultsDto.setId(row.getId());
				if (row.getMasterDnaPcrTest() != null) {
					tempDnaPcrResultsDto.setDnaPcrTestId(row.getMasterDnaPcrTest().getId());
					tempDnaPcrResultsDto.setDnaPcrTestName(row.getMasterDnaPcrTest().getName());
				}
				if (row.getMasterDnaPcrResult() != null) {
					tempDnaPcrResultsDto.setDnaPcrResultId(row.getMasterDnaPcrResult().getId());
					tempDnaPcrResultsDto.setDnaPcrResultName(row.getMasterDnaPcrResult().getName());
				}
				dnaPcrResultsDtos.add(tempDnaPcrResultsDto);
			});
		}

		pediatricBeneficiariesInformationDto
				.setArtBeneficiaryImmunizationReportDtos(artBeneficiaryImmunizationReportDto);
		pediatricBeneficiariesInformationDto.setVitaminAResultDtos(vitaminAResultDtos);
		pediatricBeneficiariesInformationDto.setDnaPcrResultsDtos(dnaPcrResultsDtos);
		if (artBeneficiaryFollowup != null) {
			pediatricBeneficiariesInformationDto
					.setMilestoneAchieved(artBeneficiaryFollowup.getPaediatricMilestoneAchievedAsPerAge());
			if(artBeneficiaryFollowup.getInfantFeedingId()!=null) {
				pediatricBeneficiariesInformationDto.setInfantFeedingId(artBeneficiaryFollowup.getInfantFeedingId().getId());
			}
			pediatricBeneficiariesInformationDto.setInfantFeedingBreastFeedStopMonths(artBeneficiaryFollowup.getInfantFeedingBreastFeedStopMonths());
		}
		if (beneficiary != null) {
			pediatricBeneficiariesInformationDto.setBeneficiaryId(beneficiary.getId());
			if (beneficiary.getGenderId() != null) {
				pediatricBeneficiariesInformationDto.setSexId(beneficiary.getGenderId().getId());
			}
			pediatricBeneficiariesInformationDto.setAge(beneficiary.getDateOfBirth());

			if (beneficiary.getGuardianCaregiverHighestEducation_id() != null) {
				pediatricBeneficiariesInformationDto
						.setGuardianHighestEducationId(beneficiary.getGuardianCaregiverHighestEducation_id().getId());

			}
			if(beneficiary.getGuardianCaregiverId()!=null) {
				pediatricBeneficiariesInformationDto.setGuardianCaregiverId(beneficiary.getGuardianCaregiverId().getId());
			}
			
			if(beneficiary.getStayingWithId()!=null) {
				pediatricBeneficiariesInformationDto.setStayingWithId(beneficiary.getStayingWithId().getId());
			}
			pediatricBeneficiariesInformationDto.setGuardianCaregiverOthers(beneficiary.getGuardianCaregiverOthers());
			pediatricBeneficiariesInformationDto.setStayingWithOthers(beneficiary.getStayingWithOthers());
			
			if(beneficiary.getGenderId()!=null) {
				pediatricBeneficiariesInformationDto.setSexId(beneficiary.getGenderId().getId());
			}
			if(beneficiary.getBirthHistoryId()!=null) {
				pediatricBeneficiariesInformationDto.setBirthHistoryId(beneficiary.getBirthHistoryId());
			}
			pediatricBeneficiariesInformationDto.setBirthWeight(beneficiary.getBirthWeight());
			pediatricBeneficiariesInformationDto.setNeonatalComplications(beneficiary.getNeoNatalComplications());
			if (artBeneficiaryQueue != null) {
				if (artBeneficiaryQueue.getAssignedToUser() != null) {
					pediatricBeneficiariesInformationDto.setAssignedTo(artBeneficiaryQueue.getAssignedToUser().getId());
				}
			}
			if(artBeneficiaryDueList !=null) {
				pediatricBeneficiariesInformationDto.setNextVisitDate(artBeneficiaryDueList.getExpectedVisitDate());
			}
			// pediatricBeneficiariesInformationDto.setOtherVaccines(otherVaccines);// after
			// field confirmation from vimod
		}

		return pediatricBeneficiariesInformationDto;
	}

}
