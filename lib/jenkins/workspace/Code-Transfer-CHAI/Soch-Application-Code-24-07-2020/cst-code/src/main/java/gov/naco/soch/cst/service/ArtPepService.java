package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.controller.PepController;
import gov.naco.soch.cst.dto.ArtPepDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.ArtPep;
import gov.naco.soch.entity.ArtPepDueList;
import gov.naco.soch.entity.ArtPepQueue;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterExposureSeverity;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterHbvStatus;
import gov.naco.soch.entity.MasterHcvStatus;
import gov.naco.soch.entity.MasterHivExposureCode;
import gov.naco.soch.entity.MasterHivSourceStatus;
import gov.naco.soch.entity.MasterHivStatus;
import gov.naco.soch.entity.MasterPepPrescription;
import gov.naco.soch.entity.Pincode;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.Town;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.projection.ArtPepProjection;
import gov.naco.soch.repository.ArtPepDueListRepository;
import gov.naco.soch.repository.ArtPepQueueRepository;
import gov.naco.soch.repository.ArtPepRepository;
import gov.naco.soch.repository.DistrictRepository;
import gov.naco.soch.repository.PincodeRepository;
import gov.naco.soch.repository.StateRepository;
import gov.naco.soch.repository.SubdistrictRepository;
import gov.naco.soch.repository.TownRespository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtPepService {

	@Autowired
	private ArtPepRepository artPepRepository;

	@Autowired
	private ArtPepQueueRepository artPepQueueRepository;

	@Autowired
	private ArtPepDueListRepository artPepDueListRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private SubdistrictRepository subdistrictRepository;
	
	@Autowired
	private TownRespository townRespository;
	
	@Autowired
	private PincodeRepository pincodeRepository;

	private static final Logger logger = LoggerFactory.getLogger(ArtPepService.class);

	// Function to save/ edit PEP details
	public Boolean savePepDetails(ArtPepDto artPepDto) {

		logger.debug("Entering into savePepDetails method");
		ArtPep artpep = null;
		ArtPepQueue artPepQueue = null;
		String artPepnumber = artPepDto.getPep_no();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();

		if (artPepDto != null) {
			int count = 0;
			Boolean isEdit = false;
			if (artPepDto.getId() != null && artPepDto.getId() != 0) {
				logger.debug("Entering into Edit Function");
				count = artPepRepository.existsByPepNumberAndIdInEdit(artPepnumber.toLowerCase(), artPepDto.getId(),
						currentUser.getFacilityId());
				logger.debug("Edit returns with count", count);
				artpep = artPepRepository.findById(artPepDto.getId()).get();
				isEdit = true;
			} else {
				logger.debug("Entering into Save Function");
				artpep = new ArtPep();
				count = artPepRepository.findPepCount(artPepnumber.toLowerCase(), currentUser.getFacilityId());
				logger.debug("Save returns with count", count);
			}

			if (count != 0) {
				// logger.error(Constants.DUPLICATE_FOUND);
				String errorfield = "Pep_number";

				// logger.debug("call throwError if duplicate found");
				throwError(errorfield, artPepnumber, null);
			}

			Facility facility = new Facility();
			facility.setId(currentUser.getFacilityId());

			MasterGender masterGender = new MasterGender();
			masterGender.setId(artPepDto.getGender());

			UserMaster entryUser = new UserMaster();
			entryUser.setId(currentUser.getUserId());

			UserMaster assignTo = new UserMaster();
			
			
			artpep.setFacility(facility);
			artpep.setMasterGender(masterGender);
			artpep.setEntryUser(entryUser);

			artpep.setExposedStaffName(artPepDto.getName());
			artpep.setDateOfBirth(artPepDto.getDob());
			artpep.setMobileNumber(artPepDto.getContact_no());
			artpep.setPepNumber(artPepDto.getPep_no());
			artpep.setIsActive(Boolean.TRUE);
			artpep.setIsDelete(Boolean.FALSE);
			artpep.setCreatedBy(currentUser.getUserId());
			artpep.setExposedStaffDesignation(artPepDto.getExposedStaffDesignation());
			
			//new fields
			artpep.setExposedStaffFacilityId(artPepDto.getExposedStaffFacilityId());
			artpep.setRegistrationDate(LocalDate.now());
			if(artPepDto.getHivSourceStatusId()!=null) {
				MasterHivSourceStatus hivSourceStatus = new MasterHivSourceStatus();
				hivSourceStatus.setId(artPepDto.getHivSourceStatusId());
				artpep.setHivSourceStatus(hivSourceStatus);
			}
		
			if(artPepDto.getHivExposureCodeId()!= null){
				MasterHivExposureCode hivExposureCode = new MasterHivExposureCode();
				hivExposureCode.setId(artPepDto.getHivExposureCodeId());
				artpep.setHivExposureCode(hivExposureCode);
				
			}
			if(artPepDto.getSeverityOfExposureId()!=null) {
				MasterExposureSeverity severityOfExposure = new MasterExposureSeverity();
				severityOfExposure.setId(artPepDto.getSeverityOfExposureId());
				artpep.setSeverityOfExposure(severityOfExposure);
			}
			if(artPepDto.getPepPrescriptionId()!= null) {
				MasterPepPrescription pepPrescription = new MasterPepPrescription();
				pepPrescription.setId(artPepDto.getPepPrescriptionId());
				artpep.setPepPrescription(pepPrescription);
			}
		
			artpep.setDateOfAccidentalExposure(artPepDto.getDateOfAccidentalExposure());
			artpep.setModeOfInjuryOrExposure(artPepDto.getModeOfInjuryOrExposure());
			
			if(artPepDto.getConsentTaken()!=null) {
				artpep.setConsentTaken(artPepDto.getConsentTaken());
			}else {
				artpep.setConsentTaken(Boolean.FALSE);
			}
		
			artpep.setPepStartDate(artPepDto.getPepStartDate());
			artpep.setPepCourseDays(artPepDto.getPepCourseDays());
			artpep.setPepCourseCompleted(artPepDto.getPepCourseCompleted());
			//Baseline Test -  HIV
			if(artPepDto.getBaselineTestConductedHiv()!=null) {
				artpep.setBaselineTestConductedHiv(artPepDto.getBaselineTestConductedHiv());
			}else {
				artpep.setBaselineTestConductedHiv(Boolean.FALSE);
			}
			
			if(artPepDto.getBaselineTestConductedHivResultId()!= null) {
				MasterHivStatus baselineTestConductedHivResult = new MasterHivStatus();
				baselineTestConductedHivResult.setId(artPepDto.getBaselineTestConductedHivResultId());
				artpep.setBaselineTestConductedHivResult(baselineTestConductedHivResult);
			}
			
			//Baseline Test HCV
			if(artPepDto.getBaselineTestConductedHcv() !=null) {
				artpep.setBaselineTestConductedHcv(artPepDto.getBaselineTestConductedHcv());
			}else {
				artpep.setBaselineTestConductedHcv(Boolean.FALSE);
			}
			
			if(artPepDto.getBaselineTestConductedHcvResultId()!= null) {
				MasterHcvStatus baselineTestConductedHcvResult = new MasterHcvStatus();
				baselineTestConductedHcvResult.setId(artPepDto.getBaselineTestConductedHivResultId());
				artpep.setBaselineTestConductedHcvResult(baselineTestConductedHcvResult);
			}
			//Baseline Test HBV
			if(artPepDto.getBaselineTestConductedHbv()!=null) {
				artpep.setBaselineTestConductedHbv(artPepDto.getBaselineTestConductedHbv());
			}else {
				artpep.setBaselineTestConductedHbv(Boolean.FALSE);
			}

			if(artPepDto.getBaselineTestConductedHbvResultId()!= null) {
				MasterHbvStatus baselineTestConductedHbvResult = new MasterHbvStatus();
				baselineTestConductedHbvResult.setId(artPepDto.getBaselineTestConductedHbvResultId());
				artpep.setBaselineTestConductedHbvResult(baselineTestConductedHbvResult);
			}
			
			if(artPepDto.getExposedPersonSeroStatusSixMonthsId()!=null){
				MasterHivStatus exposedPersonSeroStatusSixMonths = new MasterHivStatus();
				exposedPersonSeroStatusSixMonths.setId(artPepDto.getExposedPersonSeroStatusSixMonthsId());
				artpep.setExposedPersonSeroStatusSixMonths(exposedPersonSeroStatusSixMonths);
			}
			
			if(artPepDto.getExposedPersonSeroStatusThreeMonthsId()!=null){
				MasterHivStatus exposedPersonSeroStatusThreeMonths = new MasterHivStatus();
				exposedPersonSeroStatusThreeMonths.setId(artPepDto.getExposedPersonSeroStatusThreeMonthsId());
				artpep.setExposedPersonSeroStatusThreeMonths(exposedPersonSeroStatusThreeMonths);
			}
			//Address
			if(artPepDto.getStateId()!=null && artPepDto.getDistrictId() !=null) {
				Optional<State> state = stateRepository.findById(artPepDto.getStateId());
				Optional<District> district = districtRepository.findById(artPepDto.getDistrictId());
				Town town= null;
				Subdistrict subdistrict = null;
				Pincode pincode =null;
				if(artPepDto.getSubDistrictId()!=null) {
					Optional<Subdistrict> subdistrictTemp = subdistrictRepository.findById(artPepDto.getSubDistrictId());
					if(subdistrictTemp.isPresent()) {
						subdistrict=subdistrictTemp.get();
					}
				}
				if(artPepDto.getTownId()!=null) {
					Optional<Town> townTemp = townRespository.findByTownId(artPepDto.getTownId());
					if(townTemp.isPresent()) {
						town=townTemp.get();
					}
				}
			
				if (artPepDto.getPinCode() != null && artPepDto.getPinCode() != "") {
					Optional<Pincode> pincodeOpt = pincodeRepository.findByPincode(artPepDto.getPinCode());
					if (!pincodeOpt.isPresent()) {
						pincode = new Pincode();
						pincode.setPincode(artPepDto.getPinCode());
						pincode.setIsActive(true);
						pincode.setIsDelete(false);
						pincode = pincodeRepository.save(pincode);
					} else {
						pincode = pincodeOpt.get();
					}
				}
				Address address = new Address();
				if(pincode !=null) {
					address.setPincodeEntity(pincode);
				}
				address.setAddressLineOne(artPepDto.getAddressLineOne());
				address.setAddressLineTwo(artPepDto.getAddressLineTwo());
				address.setState(state.get());
				address.setDistrict(district.get());
				address.setSubdistrict(subdistrict);
				address.setTown(town);
				address.setPincode(pincode.getPincode());
				address.setCountry("India");
				address.setIsActive(true);
				address.setIsDelete(false);
				artpep.setAddress(address);
			}
			
			artpep = artPepRepository.save(artpep);
			
			if (isEdit == true) {
				artPepQueue = artPepQueueRepository.findPepQueuebyPepIdAndIsVisited(artpep.getId());
			} else {
				artPepQueue = new ArtPepQueue();
			}

			if (artPepDto.getAssign_to() != null) {
				assignTo.setId(artPepDto.getAssign_to());
				artPepQueue.setAssignedTo(assignTo);

			} else {
				throwError("AssignTo", artPepnumber, "Assign_to value cannot be NULL");
			}
			artPepQueue.setArtPep(artpep);
			artPepQueue.setFacility(facility);
			artPepQueue.setIsVisited(Boolean.FALSE);
			artPepQueue.setVisitDate(LocalDate.now());
			artPepQueue.setEntryUser(entryUser);
			artPepQueue.setIsActive(Boolean.TRUE);
			artPepQueue.setIsDelete(Boolean.FALSE);

			artPepQueue = artPepQueueRepository.save(artPepQueue);

		}
		System.out.println("artpep--" + artpep.toString());
		logger.debug("savePepDetails method returns with artpep", artpep);
		return true;
	}

	// Function to List PEP details with normal search
	public List<ArtPepDto> getPepList(String searchText) {
		logger.debug("Entering into getPepList method");

		List<ArtPep> artpep = new ArrayList<ArtPep>();
		List<ArtPepProjection> artPepProjections = new ArrayList <ArtPepProjection>();
		List<ArtPepDto> artPepDtos = new ArrayList<ArtPepDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();

		if (searchText != null && searchText !="") {

			artPepProjections = artPepRepository.findbyFacilityIdAndSearchText(currentUser.getFacilityId(),
					searchText.toLowerCase());
		} else {

			artPepProjections = artPepRepository.findbyFacilityId(currentUser.getFacilityId());

		}
		if (!CollectionUtils.isEmpty(artPepProjections)) {
			artPepProjections.forEach(row -> {
				ArtPepDto artPepDto = new ArtPepDto();
				artPepDto.setId(row.getId());
				artPepDto.setName(row.getPepName());
				artPepDto.setGender(row.getGender());
				artPepDto.setContact_no(row.getContactNumber());
				artPepDto.setPep_no(row.getPepNumber());
				artPepDto.setDob(row.getDob());
				artPepDto.setAssign_to(row.getAssignTo());
				artPepDto.setExposedStaffDesignation(row.getExposedStaffDesignation());
				artPepDto.setDateOfAccidentalExposure(row.getDateOfAccidentalExposure());
				artPepDto.setModeOfInjuryOrExposure(row.getModeOfInjuryOrExposure());
				artPepDto.setHivExposureCodeId(row.getHivExposureCodeId());
				artPepDto.setConsentTaken(row.getConsentTaken());
				artPepDto.setSeverityOfExposureId(row.getSeverityOfExposureId());
				artPepDto.setHivSourceStatusId(row.getHivSourceStatusId());
				artPepDto.setRegistrationDate(row.getRegistrationDate());
				artPepDto.setPepPrescriptionId(row.getPepPrescriptionId());
				artPepDto.setPepStartDate(row.getPepStartDate());
				artPepDto.setPepCourseDays(row.getPepCourseDays());
				artPepDto.setBaselineTestConductedHiv(row.getBaselineTestConductedHiv());
				artPepDto.setBaselineTestConductedHivResultId(row.getBaselineTestConductedHivResultId());
				artPepDto.setBaselineTestConductedHbv(row.getBaselineTestConductedHbv());
				artPepDto.setBaselineTestConductedHbvResultId(row.getBaselineTestConductedHbvResultId());
				artPepDto.setBaselineTestConductedHcv(row.getBaselineTestConductedHcv());
				artPepDto.setBaselineTestConductedHcvResultId(row.getBaselineTestConductedHcvResultId());
				artPepDto.setExposedPersonSeroStatusSixMonthsId(row.getExposedPersonSeroStatusSixMonthsId());
				artPepDto.setExposedPersonSeroStatusThreeMonthsId(row.getExposedPersonSeroStatusThreeMonthsId());
				artPepDto.setExposedStaffFacilityId(row.getExposedStaffFacilityId());
				artPepDto.setPepCourseCompleted(row.getPepCourseCompleted());
				artPepDto.setAddressId(row.getAddressId());
				artPepDto.setAddressLineOne(row.getAddressLineOne());
				artPepDto.setAddressLineTwo(row.getAddressLineTwo());
				artPepDto.setStateId(row.getStateId());
				artPepDto.setDistrictId(row.getDistrictId());
				artPepDto.setSubDistrictId(row.getSubDistrictId());
				artPepDto.setTownId(row.getTownId());
				artPepDto.setPinCode(row.getPinCode());
				
				artPepDtos.add(artPepDto);
			});
		}
		logger.debug("getPepList method returns with artPepDto", artPepDtos);
		return artPepDtos;
	}

	public List<ArtPepDto> getPepListByAdvanceSearch(Map<String, String> searchValues) {

		List<ArtPepDto> artPepDtoList = new ArrayList<ArtPepDto>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<ArtPep> artPep = new ArrayList<ArtPep>();

		return artPepDtoList;
	}

	public String pepListAdvanceSearchQueryCreator(Map<String, String> searchValues) {

		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		String pepName = searchValues.get("name");
		String pepNumber = searchValues.get("pep_no");
		String mobileNumber = searchValues.get("contact_no");
		String searchQuery = "";
		if ((pepName == null || pepName == "") && (pepNumber == null || pepNumber == "")
				&& (mobileNumber == null || mobileNumber == "")) {

		}

		return null;

	}

	// Function to List PEP Queue details with normal search
	public List<ArtPepDto> getPepQueueList(String searchText) {

		logger.debug("Entering into getPepList method");
		List<ArtPepQueue> artPepQueue = new ArrayList<ArtPepQueue>();
		List<ArtPepDto> artPepDtos = new ArrayList<ArtPepDto>();
		List<ArtPepProjection> artPepProjections = new ArrayList <ArtPepProjection>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		if (searchText != null && searchText !="" ) {

			artPepProjections = artPepQueueRepository.findbyFacilityIdAndSearchText(currentUser.getFacilityId(),
					currentUser.getUserId(), searchText.toLowerCase());

		} else {
			artPepProjections = artPepQueueRepository.findbyFacilityIdAndAssignedTo(currentUser.getFacilityId(),
					currentUser.getUserId());
		}
		
		if (!CollectionUtils.isEmpty(artPepProjections)) {
			artPepProjections.forEach(row -> {
				ArtPepDto artPepDto = new ArtPepDto();
				artPepDto.setPepqueueid(row.getPepqueueid());
				artPepDto.setId(row.getId());
				artPepDto.setName(row.getPepName());
				artPepDto.setGender(row.getGender());
				artPepDto.setContact_no(row.getContactNumber());
				artPepDto.setPep_no(row.getPepNumber());
				artPepDto.setDob(row.getDob());
				artPepDto.setAssign_to(row.getAssignTo());
				artPepDto.setExposedStaffDesignation(row.getExposedStaffDesignation());
				artPepDto.setDateOfAccidentalExposure(row.getDateOfAccidentalExposure());
				artPepDto.setModeOfInjuryOrExposure(row.getModeOfInjuryOrExposure());
				artPepDto.setHivExposureCodeId(row.getHivExposureCodeId());
				artPepDto.setConsentTaken(row.getConsentTaken());
				artPepDto.setSeverityOfExposureId(row.getSeverityOfExposureId());
				artPepDto.setHivSourceStatusId(row.getHivSourceStatusId());
				artPepDto.setRegistrationDate(row.getRegistrationDate());
				artPepDto.setPepPrescriptionId(row.getPepPrescriptionId());
				artPepDto.setPepStartDate(row.getPepStartDate());
				artPepDto.setPepCourseDays(row.getPepCourseDays());
				artPepDto.setBaselineTestConductedHiv(row.getBaselineTestConductedHiv());
				artPepDto.setBaselineTestConductedHivResultId(row.getBaselineTestConductedHivResultId());
				artPepDto.setBaselineTestConductedHbv(row.getBaselineTestConductedHbv());
				artPepDto.setBaselineTestConductedHbvResultId(row.getBaselineTestConductedHbvResultId());
				artPepDto.setBaselineTestConductedHcv(row.getBaselineTestConductedHcv());
				artPepDto.setBaselineTestConductedHcvResultId(row.getBaselineTestConductedHcvResultId());
				artPepDto.setExposedPersonSeroStatusSixMonthsId(row.getExposedPersonSeroStatusSixMonthsId());
				artPepDto.setExposedPersonSeroStatusThreeMonthsId(row.getExposedPersonSeroStatusThreeMonthsId());
				artPepDto.setExposedStaffFacilityId(row.getExposedStaffFacilityId());
				artPepDto.setPepCourseCompleted(row.getPepCourseCompleted());
				artPepDto.setAddressId(row.getAddressId());
				artPepDto.setAddressLineOne(row.getAddressLineOne());
				artPepDto.setAddressLineTwo(row.getAddressLineTwo());
				artPepDto.setStateId(row.getStateId());
				artPepDto.setDistrictId(row.getDistrictId());
				artPepDto.setSubDistrictId(row.getSubDistrictId());
				artPepDto.setTownId(row.getTownId());
				artPepDto.setPinCode(row.getPinCode());
				
				artPepDtos.add(artPepDto);
			});
		}

		logger.debug("getPepQueueList method returns with artPepDtos", artPepDtos);
		return artPepDtos;
	}

	// Function to List PEP Due details with normal search
	public List<ArtPepDto> getPepDueList(String searchText) {

		logger.debug("Entering into getPepDueList method");
		List<ArtPepDueList> artPepDueList = new ArrayList<ArtPepDueList>();
		List<ArtPepDto> artPepDtos = new ArrayList<ArtPepDto>();
		List<ArtPepProjection> artPepProjections = new ArrayList <ArtPepProjection>();
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		if (searchText != null && searchText !="" ) {
			artPepProjections = artPepDueListRepository.findbyFacilityIdAndSearchText(currentUser.getFacilityId(),
					searchText.toLowerCase());
		} else {
			artPepProjections = artPepDueListRepository.findbyFacilityIdAndCurrentDate(currentUser.getFacilityId());
		}
		if (!CollectionUtils.isEmpty(artPepProjections)) {
			artPepProjections.forEach(row -> {
				ArtPepDto artPepDto = new ArtPepDto();
				artPepDto.setPepqueueid(row.getPepqueueid());
				artPepDto.setPepdueid(row.getPepdueid());
				artPepDto.setId(row.getId());
				artPepDto.setName(row.getPepName());
				artPepDto.setGender(row.getGender());
				artPepDto.setContact_no(row.getContactNumber());
				artPepDto.setPep_no(row.getPepNumber());
				artPepDto.setDob(row.getDob());
				artPepDto.setAssign_to(row.getAssignTo());
				artPepDto.setExposedStaffDesignation(row.getExposedStaffDesignation());
				artPepDto.setDateOfAccidentalExposure(row.getDateOfAccidentalExposure());
				artPepDto.setModeOfInjuryOrExposure(row.getModeOfInjuryOrExposure());
				artPepDto.setHivExposureCodeId(row.getHivExposureCodeId());
				artPepDto.setConsentTaken(row.getConsentTaken());
				artPepDto.setSeverityOfExposureId(row.getSeverityOfExposureId());
				artPepDto.setHivSourceStatusId(row.getHivSourceStatusId());
				artPepDto.setRegistrationDate(row.getRegistrationDate());
				artPepDto.setPepPrescriptionId(row.getPepPrescriptionId());
				artPepDto.setPepStartDate(row.getPepStartDate());
				artPepDto.setPepCourseDays(row.getPepCourseDays());
				artPepDto.setBaselineTestConductedHiv(row.getBaselineTestConductedHiv());
				artPepDto.setBaselineTestConductedHivResultId(row.getBaselineTestConductedHivResultId());
				artPepDto.setBaselineTestConductedHbv(row.getBaselineTestConductedHbv());
				artPepDto.setBaselineTestConductedHbvResultId(row.getBaselineTestConductedHbvResultId());
				artPepDto.setBaselineTestConductedHcv(row.getBaselineTestConductedHcv());
				artPepDto.setBaselineTestConductedHcvResultId(row.getBaselineTestConductedHcvResultId());
				artPepDto.setExposedPersonSeroStatusSixMonthsId(row.getExposedPersonSeroStatusSixMonthsId());
				artPepDto.setExposedPersonSeroStatusThreeMonthsId(row.getExposedPersonSeroStatusThreeMonthsId());
				artPepDto.setExposedStaffFacilityId(row.getExposedStaffFacilityId());
				artPepDto.setPepCourseCompleted(row.getPepCourseCompleted());
				artPepDto.setAddressId(row.getAddressId());
				artPepDto.setAddressLineOne(row.getAddressLineOne());
				artPepDto.setAddressLineTwo(row.getAddressLineTwo());
				artPepDto.setStateId(row.getStateId());
				artPepDto.setDistrictId(row.getDistrictId());
				artPepDto.setSubDistrictId(row.getSubDistrictId());
				artPepDto.setTownId(row.getTownId());
				artPepDto.setPinCode(row.getPinCode());
				
				artPepDtos.add(artPepDto);
			});
		}


		logger.debug("getPepQueueList method returns with artPepDtos", artPepDtos);
		return artPepDtos;
	}

	/**
	 * Method to throw error in case of validation errors
	 * 
	 * @param errorfield
	 * @param errorFieldValue
	 */
	private void throwError(String errorfield, String errorFieldValue, String errorMessage) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		if (errorMessage != null) {
			errorDto.setDescription(errorMessage + "'" + errorFieldValue + "'");
			errorDtoList.add(errorDto);
			detailsSimplified.add(errorDto.getDescription());
			ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
			throw new ServiceException(errorMessage + " '" + errorFieldValue + "' ", errorResponse,
					HttpStatus.BAD_REQUEST);
		} else {
			errorDto.setDescription(Constants.DUPLICATE_FOUND + "'" + errorFieldValue + "'");
			errorDtoList.add(errorDto);
			detailsSimplified.add(errorDto.getDescription());
			ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
			throw new ServiceException(Constants.DUPLICATE_FOUND + " '" + errorFieldValue + "' ", errorResponse,
					HttpStatus.BAD_REQUEST);
		}

	}

}
