package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.mapper.ArtRecordResultMapperUtil;
import gov.naco.soch.dto.ArtCd4RecordResultDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.entity.MasterBatchStatus;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.projection.ArtSampleCollectionProjection;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.LabTestSampleBatchRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtRecordResultService {

	private static final Logger logger = LoggerFactory.getLogger(ArtRecordResultService.class);

	@Autowired
	private LabTestSampleBatchRepository labTestSampleBatchRepository;

	@Autowired
	LabTestSampleRepository labTestSampleRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	/**
	 * Method to record CD4 result details into table
	 * 
	 * @param artCd4RecordResultDtos
	 */
	public void addCd4RecordResult(@Valid List<ArtCd4RecordResultDto> artCd4RecordResultDtos) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		for (ArtCd4RecordResultDto artCd4RecordResultDto : artCd4RecordResultDtos) {
			LabTestSample labTestSample = new LabTestSample();
			labTestSample = labTestSampleRepository.findById(artCd4RecordResultDto.getSampleId()).get();
			labTestSample = ArtRecordResultMapperUtil.mapToArtCd4RecordResult(artCd4RecordResultDto, labTestSample);
			labTestSample = labTestSampleRepository.save(labTestSample);

			LabTestSampleBatch labTestSampleBatch = labTestSampleBatchRepository
					.findById(labTestSample.getLabTestSampleBatch().getId()).get();
			LocalDateTime currentTime = LocalDateTime.now();
			labTestSampleBatch.setReceivedDate(artCd4RecordResultDto.getTestDate().atTime(LocalTime.now()));
			MasterBatchStatus batchStatus = new MasterBatchStatus();
			batchStatus.setId(2l);
			labTestSampleBatch.setMasterBatchStatus(batchStatus);
			labTestSampleBatchRepository.save(labTestSampleBatch);

			if (artCd4RecordResultDto.getNextAppointmentDate() != null) {

				Optional<ArtBeneficiaryDueList> artBeneficiaryDueListOptional = artBeneficiaryDueListRepository
						.findByBeneficiaryNextVisitDateAndIsDelete(artCd4RecordResultDto.getBeneficiaryId(),
								loginResponseDto.getFacilityId(), artCd4RecordResultDto.getNextAppointmentDate(),
								false);
				if (!artBeneficiaryDueListOptional.isPresent()) {
					ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
					artBeneficiaryDueList.setIsDelete(false);
					artBeneficiaryDueList.setIsVisited(false);
					artBeneficiaryDueList.setIsActive(true);
					artBeneficiaryDueList.setExpectedVisitDate(artCd4RecordResultDto.getNextAppointmentDate());
					artBeneficiaryDueList.setVisitedDate(LocalDate.now());
					UserMaster entryUser = new UserMaster();
					entryUser.setId(loginResponseDto.getUserId());
					artBeneficiaryDueList.setEntryUser(entryUser);

					Beneficiary beneficiary = new Beneficiary();
					beneficiary.setId(artCd4RecordResultDto.getBeneficiaryId());
					artBeneficiaryDueList.setBeneficiary(beneficiary);

					Facility facility = new Facility();
					facility.setId(loginResponseDto.getFacilityId());
					artBeneficiaryDueList.setFacility(facility);

					Long visterRegister = VisitRegisterService.getVisitRegisterIdForToday(
							loginResponseDto.getFacilityId(), artCd4RecordResultDto.getBeneficiaryId());
					Optional<BeneficiaryVisitRegister> beneficiaryVisitRegister = beneficiaryVisitRegisterRepository
							.findById(visterRegister);
					if (beneficiaryVisitRegister.isPresent()) {
						BeneficiaryVisitRegister beneficiaryVisitRegisterDetails = beneficiaryVisitRegister.get();
						artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegisterDetails);
					}

					artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
					artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
				}
			}

		}
	}

	public List<ArtCd4RecordResultDto> getAllCD4TestResults(String searchValue) {
		List<ArtCd4RecordResultDto> artRecordResultDto = new ArrayList<ArtCd4RecordResultDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		if (searchValue.isEmpty()) {
			List<LabTestSample> labTestSample = labTestSampleRepository
					.findAllCD4TestResults(currentUser.getFacilityId());
			artRecordResultDto = ArtRecordResultMapperUtil.mapArtRecordResultListToArtCd4RecordResultDto(labTestSample);
		}else {
			
			List<ArtSampleCollectionProjection> testResult = labTestSampleRepository
					.searchInCD4TestResults(currentUser.getFacilityId(), searchValue.toLowerCase());
			artRecordResultDto = ArtRecordResultMapperUtil.mapProjectionListToArtCd4RecordResultDto(testResult);
			
		}
		return artRecordResultDto;
	}

}
