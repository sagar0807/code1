package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.mapper.ArtSampleCollectionMapperUtil;
import gov.naco.soch.dto.ArtSampleCollectionDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.TestDetails;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
//import gov.naco.soch.entity.BeneficiaryQueue;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.projection.ArtSampleCollectionProjection;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.util.UserUtils;

/**
 * Service class that handle sample collection related methods
 *
 */
@Service
@Transactional
public class ArtSampleCollectionService {

	private static final Logger logger = LoggerFactory.getLogger(ArtSampleCollectionService.class);
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Autowired
	LabTestSampleRepository labTestSampleRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;
	
	

	/**
	 * to add all collected samples into soch.art_sample_collection
	 * 
	 * @param artSampleCollectionDtos
	 */
	public void addSamples(@Valid List<ArtSampleCollectionDto> artSampleCollectionDtos) {
		logger.debug("In addSamples() of ArtSampleCollectionService");

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		for (ArtSampleCollectionDto artSampleCollectionDto : artSampleCollectionDtos) {

			LabTestSample labTestSample = new LabTestSample();
			List<TestDetails> details = new ArrayList<TestDetails>();
			details = artSampleCollectionDto.getTestDetails();
			for (TestDetails detail : details) {
				boolean b = false;
				if (detail.getBarcode() != null) {
					b = labTestSampleRepository.existsByBarcodeNumber(detail.getBarcode());
				}
				if (b) {
					logger.error(Constants.DUPLICATE_FOUND);
					String errorfield = "name";
					throwError(errorfield, detail.getBarcode());
				}
				labTestSample = ArtSampleCollectionMapperUtil.mapToArtSampleCollection(artSampleCollectionDto, detail);
				labTestSample = labTestSampleRepository.save(labTestSample);
			}

			Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
					artSampleCollectionDto.getBeneficiaryId());

			Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
					.findById(visitRegisterId);
			if (optVisitDetails.isPresent()) {
				BeneficiaryVisitRegister visitDetails = optVisitDetails.get();
				Optional<ArtBeneficiaryQueue> currentQueueOpt = artBeneficiaryQueueRepository.findBeneficiaryAssignedTo(
						visitDetails.getBeneficiary().getId(), loginResponseDto.getUserId(),
						loginResponseDto.getFacilityId(), LocalDate.now());
				if (currentQueueOpt.isPresent()) {
					ArtBeneficiaryQueue currentQueue = currentQueueOpt.get();
					currentQueue.setIsVisited(Boolean.TRUE);
					artBeneficiaryQueueRepository.save(currentQueue);
				}
			}
		}
	}

	public List<ArtSampleCollectionDto> getTodaysSampleList() {
		// LocalDateTime currentDate = LocalDateTime.now();
		List<LabTestSample> sampleList = labTestSampleRepository.findTodaysSamples();
		List<ArtSampleCollectionDto> sampleDtoList = ArtSampleCollectionMapperUtil
				.mapToArtSampleCollectionDtoList(sampleList);
		return sampleDtoList;
	}

	public List<ArtSampleCollectionDto> getSampleList(String searchValue) {
		List<ArtSampleCollectionDto> sampleDtoList = new ArrayList<ArtSampleCollectionDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		if (searchValue.isEmpty()) {
			List<LabTestSample> sampleList = labTestSampleRepository
					.findAllByIsDeleteAndSampleCollectedFacilityId(Boolean.FALSE, currentUser.getFacilityId());
			sampleDtoList = ArtSampleCollectionMapperUtil.mapToArtSampleCollectionDtoList(sampleList);

		} else {
			List<ArtSampleCollectionProjection> sampleProjection = labTestSampleRepository
					.searchInSampleList(currentUser.getFacilityId(), searchValue.toLowerCase());
			sampleDtoList = ArtSampleCollectionMapperUtil.mapProjectionToArtSampleCollectionDtoList(sampleProjection);
		}

		return sampleDtoList;
	}

	/**
	 * method to list all cd4/viral load+cd4 type samples
	 * 
	 * @return sampleDtoList
	 */
	public List<ArtSampleCollectionDto> getCD4SampleCollectedBeneficiaryList() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<LabTestSample> sampleList = labTestSampleRepository.findAllCD4List(currentUser.getFacilityId());
		List<ArtSampleCollectionDto> sampleDtoList = ArtSampleCollectionMapperUtil
				.mapToArtSampleCollectionDtoList(sampleList);
		return sampleDtoList;
	}

	/**
	 * method to list all viral load/viral load+cd4 type samples
	 * 
	 * @return sampleDtoList
	 */
	public List<ArtSampleCollectionDto> getViralLoadSampleCollectedBeneficiaryList() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<LabTestSample> sampleList = labTestSampleRepository.findAllViralList(currentUser.getFacilityId());
		List<ArtSampleCollectionDto> sampleDtoList = ArtSampleCollectionMapperUtil
				.mapToArtSampleCollectionDtoList(sampleList);
		return sampleDtoList;
	}

	public List<ArtSampleCollectionDto> getCD4DispatchedBeneficiaryList(String searchValue) {
		List<ArtSampleCollectionDto> sampleDtoList = new ArrayList<ArtSampleCollectionDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		if(searchValue.isEmpty()) {
			List<LabTestSample> sampleList = labTestSampleRepository.findAllCD4Dispatchedlist(currentUser.getFacilityId());
			sampleDtoList = ArtSampleCollectionMapperUtil
					.mapToArtSampleCollectionDtoList(sampleList);
		}else {
			List<ArtSampleCollectionProjection> sampleList = labTestSampleRepository.
					findAllCD4DispatchedlistByProjection(currentUser.getFacilityId(),searchValue.toLowerCase());
			sampleDtoList = ArtSampleCollectionMapperUtil
					.mapProjectionToArtSampleCollectionDtoList(sampleList);
		}
		if (!CollectionUtils.isEmpty(sampleDtoList)) {

			for (ArtSampleCollectionDto s : sampleDtoList) {

				Optional<LabTestSample> previousTestDetails = labTestSampleRepository
						.findPreviousCD4TestResults(s.getSampleId(), s.getBeneficiaryId(), currentUser.getFacilityId());

				if (previousTestDetails.isPresent()) {
					s.setLastTestCount(previousTestDetails.get().getResultValue());
					if(previousTestDetails.get().getResultApprovedDate()!=null)
					s.setLastTestDate(previousTestDetails.get().getResultApprovedDate().format(formatter));
				}
			}
		}

		return sampleDtoList;
	}

	public List<ArtSampleCollectionDto> getViralLoadDispatchedBeneficiaryList() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<LabTestSample> sampleList = labTestSampleRepository
				.findAllViralDispatchedList(currentUser.getFacilityId());
		List<ArtSampleCollectionDto> sampleDtoList = ArtSampleCollectionMapperUtil
				.mapToArtSampleCollectionDtoList(sampleList);
		return sampleDtoList;
	}

	/**
	 * Method to throw error in case of validation errors
	 * 
	 * @param errorfield
	 * @param errorFieldValue
	 */
	private void throwError(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.DUPLICATE_FOUND + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(Constants.DUPLICATE_FOUND + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

	public List<String> getAllBarcodes() {
		List<String> barcodesList = labTestSampleRepository.findAllBarcodes();
		return barcodesList;
	}

}
