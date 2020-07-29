package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtFollowupListDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtFollowupList;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryArtStatusTracking;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterArtBeneficiaryStatus;
import gov.naco.soch.entity.MasterArtFollowupCriteria;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.projection.ArtFollowupListProjection;
import gov.naco.soch.projection.ArtFollowupListSchedulerProjection;
import gov.naco.soch.repository.ArtFollowupListRepository;
import gov.naco.soch.repository.BeneficiaryArtStatusTrackingRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.MasterArtFollowupCriteriaRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtFollowupListService {

	@Autowired
	private ArtFollowupListRepository artFollowupListRepository;

	@Autowired
	private MasterArtFollowupCriteriaRepository masterArtFollowupCriteriaRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private BeneficiaryArtStatusTrackingRepository beneficiaryArtStatusTrackingRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ArtFollowupListService.class);

	// Function for ART follow up list
	public List<ArtFollowupListDto> getFollowupList(Integer year, Integer month) {
		logger.debug("Entering into getFollowupList method");
		List<ArtFollowupListDto> artFollowupListDtos = new ArrayList<ArtFollowupListDto>();
		List<ArtFollowupList> artFollowupList = new ArrayList<ArtFollowupList>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		artFollowupList = artFollowupListRepository.findByYearAndDateAndFaciltyId(year, month,
				currentUser.getFacilityId());

		if (!CollectionUtils.isEmpty(artFollowupList)) {
			artFollowupList.forEach(row -> {

				ArtFollowupListDto artFollowupListDto = new ArtFollowupListDto();
				artFollowupListDto.setId(row.getId());
				artFollowupListDto.setYearGenerated(row.getYearGenerated());
				artFollowupListDto.setMonthGenerated(row.getMonthGenerated());
				if (row.getFacility() != null) {
					artFollowupListDto.setFacilityId(row.getFacility().getId());
				}
				if (row.getBeneficiary() != null) {
					artFollowupListDto.setBeneficiaryId(row.getBeneficiary().getId());
					/*
					 * if (row.getMasterArtBeneficiaryStatus() != null) { artFollowupListDto
					 * .setArtBeneficiaryStatusIdCaptured(row.getMasterArtBeneficiaryStatus().getId(
					 * )); artFollowupListDto
					 * .setArtBeneficiaryStatusNameCaptured(row.getMasterArtBeneficiaryStatus().
					 * getName()); }
					 */

					artFollowupListDto.setArtBeneficiaryStatusIdCaptured(row.getArtBeneficiaryStatusIdCaptured());
					artFollowupListDto.setArtNumber(row.getBeneficiary().getArtNumber());
					artFollowupListDto.setPreArtNumber(row.getBeneficiary().getPreArtNumber());
					artFollowupListDto.setBeneficiaryName(row.getBeneficiary().getFirstName() + " "
							+ row.getBeneficiary().getMiddleName() + " " + row.getBeneficiary().getLastName());
					artFollowupListDto.setMobileNumber(row.getBeneficiary().getMobileNumber());
					if (row.getBeneficiary().getGenderId() != null) {
						artFollowupListDto.setGenderName(row.getBeneficiary().getGenderId().getName());
						artFollowupListDto.setGenderId(row.getBeneficiary().getGenderId().getId());
					}
					artFollowupListDto.setUid(row.getBeneficiary().getUid());
					artFollowupListDto.setAge(row.getBeneficiary().getAge());
				}
				artFollowupListDtos.add(artFollowupListDto);

			});
		}

		return artFollowupListDtos;
	}

	// Function - Search
	public List<ArtFollowupListDto> getFollowupListBySearch(String searchText) {
		logger.debug("Entering into getFollowupListBySearch method");
		List<ArtFollowupListDto> artFollowupListDtos = new ArrayList<ArtFollowupListDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<MasterArtFollowupCriteria> masterArtFollowupCriterias = new ArrayList<MasterArtFollowupCriteria>();
		masterArtFollowupCriterias = masterArtFollowupCriteriaRepository.findAllFollowupCriteria();
		// masterArtFollowupCriterias =
		// masterArtFollowupCriteriaRepository.findAllFollowupCriteria();
		// masterArtFollowupCriterias = null;
		List<Long> artBeneficiaryStatusIds = new ArrayList<Long>();
		List<Integer> adherenceValue = new ArrayList<Integer>();
		List<Integer> cD4belowValue = new ArrayList<Integer>();
		List<Integer> vLaboveValue = new ArrayList<Integer>();
		if (!CollectionUtils.isEmpty(masterArtFollowupCriterias)) {
			masterArtFollowupCriterias.forEach(row -> {

				switch (row.getId()) {
				case 1: // On–ART MIS
					if (row.getIsActive() == true) {
						artBeneficiaryStatusIds.add(1l);
						artBeneficiaryStatusIds.add(2l);
					}
					break;
				case 2:// On-ART LFU
					if (row.getIsActive() == true) {
						artBeneficiaryStatusIds.add(3l);
						artBeneficiaryStatusIds.add(4l);
					}
					break;
				case 3: // Newly initiated on ART
					break;
				case 4:// Less than adherence
					if (row.getIsActive() == true) {
						adherenceValue.add(row.getCriteriaParameterValue());
					}
					break;
				case 5:// Beneficiary to be initiated on ART
					break;
				case 6:// CD4 below
					if (row.getIsActive() == true) {
						cD4belowValue.add(row.getCriteriaParameterValue());
					}
					break;
				case 7:// VL above
					if (row.getIsActive() == true) {
						vLaboveValue.add(row.getCriteriaParameterValue());
					}
					break;
				case 8:// Unstable

					break;
				case 9:// Migrant, Truckers
					break;
				case 10:// Opportunistic Infection Positive
					break;
				default:
					break;
				}
			});
			//List<Beneficiary> beneficiary = new ArrayList<Beneficiary>();

			// beneficiary =
			// beneficiaryRepository.findAllFollowUpList(artBeneficiaryStatusIds,adherenceValue.get(0),cD4belowValue.get(0),vLaboveValue.get(0));
			List<ArtFollowupListProjection> artFollowupListProjection = beneficiaryRepository.findAllFollowUpList(
					artBeneficiaryStatusIds, currentUser.getFacilityId(), searchText.toLowerCase());
			if (!CollectionUtils.isEmpty(artFollowupListProjection)) {
				artFollowupListProjection.forEach(row -> {
					ArtFollowupListDto artFollowupListDto = new ArtFollowupListDto();

					artFollowupListDto.setBeneficiaryId((long) row.getBeneficiaryId());
					artFollowupListDto.setBeneficiaryName(row.getBenficiaryName());
					artFollowupListDto.setAge(row.getAge());
					artFollowupListDto.setUid(row.getUid());
					artFollowupListDto.setArtNumber(row.getArtNumber());
					artFollowupListDto.setMobileNumber(row.getMobileNumber());
					artFollowupListDto.setYearGenerated(LocalDate.now().getYear());
					artFollowupListDto.setMonthGenerated(LocalDate.now().getMonthValue());
					artFollowupListDto.setFacilityId(currentUser.getFacilityId());
					// if (row.getArtBeneficiary() != null) {
					// row.getArtBeneficiary().forEach(temprow -> {
					artFollowupListDto.setArtBeneficiaryStatusIdCaptured((long) row.getArtBeneficiaryStatusId());
					artFollowupListDto.setArtBeneficiaryStatusNameCaptured(row.getArtBeneficiaryStatusName());
					// });
					// }
					artFollowupListDto.setPreArtNumber(row.getPreArtNumber());
					if (row.getGenderId() != null) {
						artFollowupListDto.setGenderId((long) row.getGenderId());
						artFollowupListDto.setGenderName(row.getGenderName());
					}
					artFollowupListDtos.add(artFollowupListDto);
				});
			}

		}

		return artFollowupListDtos;
	}

	// Save
	public List<ArtFollowupListDto> saveFollowupList(List<ArtFollowupListDto> artFollowupListDto) {
		logger.debug("Entering into saveFollowupList method");
		List<ArtFollowupListDto> artFollowupListDtos = new ArrayList<ArtFollowupListDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();

		if (artFollowupListDto != null) {

			artFollowupListDto.forEach(row -> {

				int count = 0;
				ArtFollowupList artFollowupList = new ArtFollowupList();
				ArtFollowupListDto tempartFollowupListDto = new ArtFollowupListDto();
				Beneficiary beneficiary = new Beneficiary();
				Facility facility = new Facility();
				facility.setId(currentUser.getFacilityId());
				beneficiary.setId(row.getBeneficiaryId());
				Long beneficiaryId = row.getBeneficiaryId();
				count = artFollowupListRepository.FindCountByBeneficiaryIdAndCurrentMonthAndCurrentYear(beneficiaryId,
						row.getMonthGenerated(), row.getYearGenerated());
				if (count != 0) {

					// logger.error(Constants.DUPLICATE_FOUND);
					String errorfield = "Beneficiary_Id";

					// logger.debug("call throwError if duplicate found");
					throwError(errorfield, row.getUid());
				} else {

					artFollowupList.setYearGenerated(row.getYearGenerated());
					artFollowupList.setMonthGenerated(row.getMonthGenerated());
					artFollowupList.setFacility(facility);
					artFollowupList.setBeneficiary(beneficiary);
					artFollowupList.setArtBeneficiaryStatusIdCaptured(row.getArtBeneficiaryStatusIdCaptured());
					artFollowupList.setIsActive(Boolean.TRUE);
					artFollowupList.setIsDelete(Boolean.FALSE);

					artFollowupList = artFollowupListRepository.save(artFollowupList);

					ArtFollowupListProjection artFollowupListProjection = beneficiaryRepository
							.findFollowUpLisByBeneficairyId(currentUser.getFacilityId(), beneficiaryId);
					tempartFollowupListDto.setId(artFollowupList.getId());
					tempartFollowupListDto.setBeneficiaryId((long) artFollowupListProjection.getBeneficiaryId());
					tempartFollowupListDto.setBeneficiaryName(artFollowupListProjection.getBenficiaryName());
					tempartFollowupListDto.setAge(artFollowupListProjection.getAge());
					tempartFollowupListDto.setUid(artFollowupListProjection.getUid());
					tempartFollowupListDto.setArtNumber(artFollowupListProjection.getArtNumber());
					tempartFollowupListDto.setMobileNumber(artFollowupListProjection.getMobileNumber());
					tempartFollowupListDto.setYearGenerated(row.getYearGenerated());
					tempartFollowupListDto.setMonthGenerated(row.getMonthGenerated());
					tempartFollowupListDto.setFacilityId(currentUser.getFacilityId());

					tempartFollowupListDto.setArtBeneficiaryStatusIdCaptured(
							(long) artFollowupListProjection.getArtBeneficiaryStatusId());
					tempartFollowupListDto.setArtBeneficiaryStatusNameCaptured(
							artFollowupListProjection.getArtBeneficiaryStatusName());

					tempartFollowupListDto.setPreArtNumber(artFollowupListProjection.getPreArtNumber());
					if (row.getGenderId() != null) {
						tempartFollowupListDto.setGenderId((long) artFollowupListProjection.getGenderId());
						tempartFollowupListDto.setGenderName(artFollowupListProjection.getGenderName());
					}
				}

				artFollowupListDtos.add(tempartFollowupListDto);
			});

		}

		return artFollowupListDtos;
	}

	public Boolean DeleteFollowupList(Long followupId) {

		artFollowupListRepository.deleteById(followupId);

		return true;
	}
	
	//Followup criteria - ON ART- MIS
	public void findOnArtMisBeneficiaryList() {
		List<ArtFollowupListSchedulerProjection> artFollowupListSchedulerProjections = new ArrayList<ArtFollowupListSchedulerProjection>();
		artFollowupListSchedulerProjections= beneficiaryArtStatusTrackingRepository.findOnArtMisBeneficiaryList();
		List<Long> trackingIdList=new ArrayList<Long>();
		List<ArtFollowupListDto> artFollowupListDtos = new ArrayList<ArtFollowupListDto>();
		//exisiting sts need to be updated and new sts need to be inserted
		if(!artFollowupListSchedulerProjections.isEmpty()) {
			
			MasterArtBeneficiaryStatus previousArtBeneficiaryStatus = new MasterArtBeneficiaryStatus();
			previousArtBeneficiaryStatus.setId(8l); // 8-  on-ART 
			MasterArtBeneficiaryStatus currentArtBeneficiaryStatus = new MasterArtBeneficiaryStatus();
			currentArtBeneficiaryStatus.setId(9l); // 9- on-ART MIS
			
			artFollowupListSchedulerProjections.forEach(row ->{
				BeneficiaryArtStatusTracking beneficiaryArtStatusTracking = new BeneficiaryArtStatusTracking();
				
				Beneficiary beneficiary = new Beneficiary();
				beneficiary.setId(row.getBeneficiaryId());
				beneficiaryArtStatusTracking.setBeneficiary(beneficiary);
				
				Facility facility = new Facility();
				facility.setId(row.getFacilityId());
				beneficiaryArtStatusTracking.setFacility(facility);
				
				beneficiaryArtStatusTracking.setPreviousArtBeneficiaryStatus(previousArtBeneficiaryStatus);
				beneficiaryArtStatusTracking.setCurrentArtBeneficiaryStatus(currentArtBeneficiaryStatus);
				beneficiaryArtStatusTracking.setStatusDate(LocalDate.now());
				beneficiaryArtStatusTracking.setStatusChangedBy(0l);
				beneficiaryArtStatusTracking.setIsActive(Boolean.TRUE);
				beneficiaryArtStatusTracking.setIsDelete(Boolean.FALSE);
				
				trackingIdList.add(row.getBeneficiaryArtStatusTrackingId());
				beneficiaryArtStatusTrackingRepository.save(beneficiaryArtStatusTracking);
				
				ArtFollowupListDto artFollowupListDto = new ArtFollowupListDto();
				artFollowupListDto.setArtNumber(row.getArtNumber());
				artFollowupListDto.setPreArtNumber(row.getPreArtNumber());
				artFollowupListDto.setBeneficiaryName(row.getBenficiaryName());
				artFollowupListDto.setAge(row.getAge());
				artFollowupListDto.setMobileNumber(row.getMobileNumber());
				artFollowupListDto.setGenderId(row.getGenderId());
				artFollowupListDto.setUid(row.getUid());
				artFollowupListDto.setFacilityId(row.getFacilityId());
				artFollowupListDto.setBeneficiaryId(row.getBeneficiaryId());
				artFollowupListDto.setYearGenerated(LocalDate.now().getYear());
				artFollowupListDto.setMonthGenerated(LocalDate.now().getMonthValue());
				artFollowupListDto.setArtBeneficiaryStatusIdCaptured(9l);
				artFollowupListDtos.add(artFollowupListDto);
				
			});
			if(!trackingIdList.isEmpty()) {
				beneficiaryArtStatusTrackingRepository.updateOnArtMisBeneficiaryListAsDelete(trackingIdList);
			}
			if(!artFollowupListDtos.isEmpty()) {
				List<ArtFollowupListDto> artFollowupListDtoList = saveFollowupList(artFollowupListDtos);
			}
		}
	}
	
	public void findOnArtLfuBeneficiaryList() {
		List<ArtFollowupListSchedulerProjection> artFollowupListSchedulerProjections = new ArrayList<ArtFollowupListSchedulerProjection>();
		artFollowupListSchedulerProjections= beneficiaryArtStatusTrackingRepository.findOnArtLfuBeneficiaryList();
		List<Long> trackingIdList=new ArrayList<Long>();
		List<ArtFollowupListDto> artFollowupListDtos = new ArrayList<ArtFollowupListDto>();
		if(!artFollowupListSchedulerProjections.isEmpty()) {
			
			MasterArtBeneficiaryStatus previousArtBeneficiaryStatus = new MasterArtBeneficiaryStatus();
			previousArtBeneficiaryStatus.setId(9l); // 9-  on-ART MIS
			MasterArtBeneficiaryStatus currentArtBeneficiaryStatus = new MasterArtBeneficiaryStatus();
			currentArtBeneficiaryStatus.setId(10l); // 9- on-ART LFU
			
			artFollowupListSchedulerProjections.forEach(row ->{
				
				//beneficiary art status tracking
				BeneficiaryArtStatusTracking beneficiaryArtStatusTracking = new BeneficiaryArtStatusTracking();
				Beneficiary beneficiary = new Beneficiary();
				beneficiary.setId(row.getBeneficiaryId());
				beneficiaryArtStatusTracking.setBeneficiary(beneficiary);
				
				Facility facility = new Facility();
				facility.setId(row.getFacilityId());
				beneficiaryArtStatusTracking.setFacility(facility);
				
				beneficiaryArtStatusTracking.setPreviousArtBeneficiaryStatus(previousArtBeneficiaryStatus);
				beneficiaryArtStatusTracking.setCurrentArtBeneficiaryStatus(currentArtBeneficiaryStatus);
				beneficiaryArtStatusTracking.setStatusDate(LocalDate.now());
				beneficiaryArtStatusTracking.setStatusChangedBy(0l);
				beneficiaryArtStatusTracking.setIsActive(Boolean.TRUE);
				beneficiaryArtStatusTracking.setIsDelete(Boolean.FALSE);
				
				trackingIdList.add(row.getBeneficiaryArtStatusTrackingId());
				beneficiaryArtStatusTrackingRepository.save(beneficiaryArtStatusTracking);
				
				//artfollowup 
				ArtFollowupListDto artFollowupListDto = new ArtFollowupListDto();
				artFollowupListDto.setArtNumber(row.getArtNumber());
				artFollowupListDto.setPreArtNumber(row.getPreArtNumber());
				artFollowupListDto.setBeneficiaryName(row.getBenficiaryName());
				artFollowupListDto.setAge(row.getAge());
				artFollowupListDto.setMobileNumber(row.getMobileNumber());
				artFollowupListDto.setGenderId(row.getGenderId());
				artFollowupListDto.setUid(row.getUid());
				artFollowupListDto.setFacilityId(row.getFacilityId());
				artFollowupListDto.setBeneficiaryId(row.getBeneficiaryId());
				artFollowupListDto.setYearGenerated(LocalDate.now().getYear());
				artFollowupListDto.setMonthGenerated(LocalDate.now().getMonthValue());
				artFollowupListDto.setArtBeneficiaryStatusIdCaptured(10l);
				artFollowupListDtos.add(artFollowupListDto);
			});
			if(!trackingIdList.isEmpty()) {
				beneficiaryArtStatusTrackingRepository.updateOnArtLfuBeneficiaryListAsDelete(trackingIdList);
			}
			if(!artFollowupListDtos.isEmpty()) {
				List<ArtFollowupListDto> artFollowupListDtoList = saveFollowupList(artFollowupListDtos);
			}
		}
		
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
}