package gov.naco.soch.ti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.naco.soch.constructordto.TiOstDispensationItemDTO;
import gov.naco.soch.dto.BeneficiaryRegistrationDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.BeneficiaryRegistrationMapper;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.projection.ReferralProjection;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.TiOstDispensationItemRepository;
import gov.naco.soch.ti.dto.GlobalBeneficiaryViewCardDTO;
import gov.naco.soch.ti.mapper.GlobalBenVCMapper;

//Beneficiary service class interact data with database
@Transactional
@Service
public class BeneficiaryService {

	private final BeneficiaryRepository beneficiaryRepository;

	private final BeneficiaryReferralRepository beneficiaryReferralRepository;

	private final GlobalBenVCMapper globalBeneficiaryViewCardMapper;

	private final TiOstDispensationItemRepository dispensationItemRepository;

	/*
	 * @Autowired private AvailableDaysMappingRepository
	 * availableDaysMappingRepository;
	 */

	// 1. method to list all beneficiaries details from database public
	/*
	 * public List<BeneficiaryRegistrationDto> getBeneficiaries() {
	 * List<BeneficiaryRegistration> beneficiaries =
	 * beneficiaryRegistrationRepository.findAll(); //
	 * List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = //
	 * BeneficiaryRegistrationMapper.mapToBeneficiaryRegDto(beneficiaries); //
	 * return beneficiaryRegistrationDtoList; return null; }
	 */

	public BeneficiaryService(BeneficiaryRepository beneficiaryRepository,
			BeneficiaryReferralRepository beneficiaryReferralRepository,
			GlobalBenVCMapper globalBeneficiaryViewCardMapper,
			TiOstDispensationItemRepository dispensationItemRepository) {
		this.beneficiaryRepository = beneficiaryRepository;
		this.beneficiaryReferralRepository = beneficiaryReferralRepository;
		this.globalBeneficiaryViewCardMapper = globalBeneficiaryViewCardMapper;
		this.dispensationItemRepository = dispensationItemRepository;
	}

	// 2. method to search beneficiary by mobile number or UID
	public BeneficiaryRegistrationDto getBeneficiaryBySearchValue(String searchValue) {
		BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();
		List<Object[]> beneficiaryObj = new ArrayList<>();
		beneficiaryObj = beneficiaryRepository.findBySearchValue(searchValue);
		beneficiaryObj.stream().map(objects -> {
			if (objects[0] != null) {
				beneficiaryRegistrationDto.setId((long) ((Integer) objects[0]).intValue());
			}
			if (objects[1] != null) {
				beneficiaryRegistrationDto.setUidNumber(objects[1].toString());
			}
			String beneficiaryName = "";
			if (objects[2] != null) {
				beneficiaryName += objects[2].toString();
			}
			if (objects[3] != null) {
				beneficiaryName += objects[3].toString();
			}
			if (objects[4] != null) {
				beneficiaryName += objects[4].toString();
			}
			beneficiaryRegistrationDto.setFirstName(beneficiaryName);

			if (objects[5] != null) {
				beneficiaryRegistrationDto.setMobileNumber(objects[5].toString());
			}
			if (objects[6] != null) {
				beneficiaryRegistrationDto.setBeneficiaryActivityStatus(objects[6].toString());
			}
			if (objects[7] != null) {
				beneficiaryRegistrationDto.setHrgPrimaryCategory(objects[7].toString());
			}
			if (objects[8] != null) {
				if (beneficiaryRegistrationDto.getHrgSecondaryCategory() != null) {
					beneficiaryRegistrationDto.setHrgSecondaryCategory(objects[8].toString());
				}
			}

			return beneficiaryRegistrationDto;
		}).collect(Collectors.toList());
		if (beneficiaryRegistrationDto.getUidNumber() == null || beneficiaryRegistrationDto.getMobileNumber() == null) {
			String errorFeild = "uidNumber/mobileNumber";
			throwError(errorFeild, searchValue);
		}
		return beneficiaryRegistrationDto;
	}

	// 3. method to search beneficiary details by UID, mobile number,
	// firstName, LastName, HIVStatus, referralStatus, referralFacility
	public BeneficiaryRegistrationDto getBeneficiaryByReferralSearchValue(String searchValue) {
		BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();
		List<Object[]> beneficiaryObj = new ArrayList<>();
		beneficiaryObj = beneficiaryRepository.findBySearchValueReferral(searchValue);
		beneficiaryObj.stream().map(objects -> {
			beneficiaryRegistrationDto.setId((long) ((Integer) objects[0]).longValue());
			beneficiaryRegistrationDto.setUidNumber(objects[1].toString());
			beneficiaryRegistrationDto.setFirstName(objects[2].toString());
			beneficiaryRegistrationDto.setMobileNumber(objects[5].toString());
			beneficiaryRegistrationDto.setBeneficiaryActivityStatus(objects[6].toString());
			beneficiaryRegistrationDto.setReferralFacility(((Integer) objects[7]).intValue());
			beneficiaryRegistrationDto.setReferralStatus(objects[8].toString());
			beneficiaryRegistrationDto.setHivStatus(objects[9].toString());

			System.out.println(beneficiaryRegistrationDto.toString());
			return beneficiaryRegistrationDto;

		}).collect(Collectors.toList());
		if (beneficiaryRegistrationDto.getUidNumber() == null || beneficiaryRegistrationDto.getMobileNumber() == null
				|| beneficiaryRegistrationDto.getFirstName() == null
				|| beneficiaryRegistrationDto.getReferralFacility() == null
				|| beneficiaryRegistrationDto.getReferralStatus() == null
				|| beneficiaryRegistrationDto.getHivStatus() == null) {
			String errorFeild = "uidNumber/mobileNumber/firstName/referralFacility/referralStatus/hivStatus";
			throwError(errorFeild, searchValue);
		}
		return beneficiaryRegistrationDto;
	}

	// 4. general method to throw error
	private void throwError(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.NO_RECORDS_FOUND + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(Constants.NO_RECORDS_FOUND, errorDtoList, detailsSimplified);
		throw new ServiceException(Constants.NO_RECORDS_FOUND + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

	// 5. method to add beneficiary details to database public
	/*
	 * public BeneficiaryRegistrationDto
	 * addBeneficiary(BeneficiaryRegistrationDto beneficiaryRegistrationDto) {
	 * 
	 * Facility facility = new Facility();
	 * beneficiaryRegistrationDto.setIsActive(true);
	 * beneficiaryRegistrationDto.setIsDelete(false);
	 * beneficiaryRegistrationDto.
	 * setBeneficiaryActivityStatus("Pending R&V Assessment");
	 * 
	 * facility.setId(beneficiaryRegistrationDto.getFacilityId()); Long facId =
	 * beneficiaryRegistrationDto.getFacilityId();
	 * 
	 * logger.debug("findFacilityCode method called"); String code =
	 * beneficiaryRegistrationRepository.findFacilityCode(facId);
	 * logger.debug("findFacilityCode method returns with facilityCode");
	 * beneficiaryRegistrationDto.setFacilityCode(code);
	 * 
	 * Address address = null; logger.debug("maptoAddress method called");
	 * address =
	 * BeneficiaryRegistrationMapper.maptoAddress(beneficiaryRegistrationDto);
	 * logger.
	 * debug("maptoAddress method returns with beneficiaryRegistrationDto",
	 * beneficiaryRegistrationDto);
	 * 
	 * Beneficiary beneficiary = null;
	 * logger.debug("maptoBeneficiary method called"); beneficiary =
	 * BeneficiaryRegistrationMapper.maptoBeneficiary(beneficiaryRegistrationDto
	 * ); logger.
	 * debug("maptoBeneficiary method returns with beneficiaryRegistrationDto",
	 * beneficiaryRegistrationDto);
	 * 
	 * 
	 * BeneficiaryUserMapping beneficiaryUserMappings = null;
	 * logger.debug("mapToBeneficiaryUserMapping method called");
	 * beneficiaryUserMappings =
	 * BeneficiaryRegistrationMapper.mapToBeneficiaryUserMapping(
	 * beneficiaryRegistrationDto); logger.
	 * debug("mapToBeneficiaryUserMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * 
	 * AvailableDaysMapping availableDaysMapping = null;
	 * logger.debug("mapToAvailableDaysMapping method called");
	 * availableDaysMapping =
	 * BeneficiaryRegistrationMapper.mapToAvailableDaysMapping(
	 * beneficiaryRegistrationDto); logger.
	 * debug("mapToAvailableDaysMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * Set<ChildrenAgeGenderMapping> childrenAgeGenderMappings = null; if
	 * (beneficiaryRegistrationDto.getChildrenAgeGenderMapping() != null) {
	 * 
	 * logger.debug("mapToChildrenAgeGenderMapping method called");
	 * childrenAgeGenderMappings = BeneficiaryRegistrationMapper
	 * .mapToChildrenAgeGenderMapping(beneficiaryRegistrationDto.
	 * getChildrenAgeGenderMapping()); logger.
	 * debug("mapToChildrenAgeGenderMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * }
	 */

	/*
	 * BeneficiaryRegistration beneficiaryRegistration =
	 * null;logger.debug("mapToBeneficiaryReg method called");
	 * beneficiaryRegistration=BeneficiaryRegistrationMapper.
	 * mapToBeneficiaryReg( beneficiaryRegistrationDto);logger.
	 * debug("mapToBeneficiaryReg method returns with beneficiaryRegistrationDto"
	 * ,beneficiaryRegistrationDto);
	 * 
	 * BeneficiaryFacilityMapping beneficiaryFacilityMappings =
	 * null;logger.debug("mapToBeneficiaryFacilityMapping method called");
	 * beneficiaryFacilityMappings=BeneficiaryRegistrationMapper.
	 * mapToBeneficiaryFacilityMapping(beneficiaryRegistrationDto);logger.
	 * debug("mapToBeneficiaryFacilityMapping method returns with beneficiaryRegistrationDto"
	 * ,beneficiaryRegistrationDto);
	 * 
	 * // setting child entities in parent (BeneficiaryRegistration) entity
	 * beneficiaryRegistration.setAvailableDaysMapping(availableDaysMapping);
	 * 
	 * // setting parent entity in child entities Set<BeneficiaryRegistration>
	 * beneficiaryRegList = new
	 * HashSet<BeneficiaryRegistration>();availableDaysMapping.
	 * setBeneficiaryRegistrations(beneficiaryRegList);availableDaysMapping.
	 * getBeneficiaryRegistrations().add(beneficiaryRegistration);
	 * 
	 * // saving child entities
	 * availableDaysMappingRepository.save(availableDaysMapping);
	 * beneficiaryRegistration.setBeneficiary(beneficiary);
	 * beneficiaryFacilityMappings.setBeneficiary(beneficiary);
	 * beneficiaryUserMappings.setBeneficiary(beneficiary);
	 * 
	 * Set<BeneficiaryFacilityMapping> beneficiaryfacilityList = new
	 * HashSet<BeneficiaryFacilityMapping>();beneficiary.
	 * setBeneficiaryFacilityMappings(beneficiaryfacilityList);beneficiary.
	 * getBeneficiaryFacilityMappings().add(beneficiaryFacilityMappings);
	 * 
	 * Set<BeneficiaryUserMapping> beneficiaryuserList = new
	 * HashSet<BeneficiaryUserMapping>();beneficiary.setBeneficiaryUserMappings(
	 * beneficiaryuserList);beneficiary.getBeneficiaryUserMappings().add(
	 * beneficiaryUserMappings);
	 * 
	 * beneficiary.setBeneficiaryRegistration(beneficiaryRegistration);
	 * beneficiary. setAddress(address);
	 * 
	 * Set<Beneficiary> beneficiaryList = new
	 * HashSet<Beneficiary>();address.setBeneficiaries(beneficiaryList);address.
	 * getBeneficiaries().add(beneficiary);
	 */
	/*
	 * if (childrenAgeGenderMappings != null) { for (ChildrenAgeGenderMapping
	 * childrenAgeGenderMappingObj : childrenAgeGenderMappings) {
	 * Set<ChildrenAgeGenderMapping> childrenList = new
	 * HashSet<ChildrenAgeGenderMapping>();
	 * beneficiary.setChildrenAgeGenderMappings(childrenList);
	 * beneficiary.getChildrenAgeGenderMappings().add(
	 * childrenAgeGenderMappingObj);
	 * childrenAgeGenderMappingObj.setBeneficiary(beneficiary);
	 * 
	 * // saving parent entity address = addressRepository.save(address);
	 * 
	 * } } else { address = addressRepository.save(address); }
	 */

	/*
	 * // code to generate UID DecimalFormat df = new
	 * DecimalFormat("00000000");//
	 * https://www.java67.com/2014/10/how-to-pad-numbers-with-leading-zeroes-in-
	 * Java -example.html String uid = "U" + df.format(beneficiary.getId());
	 */
	/*
	 * beneficiary.setUid(uid); beneficiaryRepository.save(beneficiary);
	 * beneficiaryRegistrationDto.setUidNumber(beneficiary.getUid());
	 * 
	 * beneficiaryRegistrationDto.setId(beneficiaryRegistration.getId());
	 * beneficiaryRegistrationDto.setUidNumber(beneficiary.getUid());
	 * beneficiaryRegistrationDto.setAddressId(address.getId());
	 * beneficiaryRegistrationDto.setBeneficiaryId(beneficiary.getId());
	 * beneficiaryRegistrationDto.setAvailableDaysMapId(availableDaysMapping.
	 * getId() ); beneficiaryRegistrationDto.setBeneficiaryFacilityMapId(
	 * beneficiaryFacilityMappings.getId());
	 */

	// return beneficiaryRegistrationDto;

	// }

	// 6. method to update beneficiary details to database public
	/*
	 * public BeneficiaryRegistrationDto
	 * updateBeneficiary(BeneficiaryRegistrationDto beneficiaryRegistrationDto)
	 * {
	 * 
	 * beneficiaryRegistrationDto.setIsDelete(false);
	 * 
	 * Address address = null; logger.debug("maptoAddress method called");
	 * address =
	 * BeneficiaryRegistrationMapper.maptoAddress(beneficiaryRegistrationDto);
	 * logger.
	 * debug("maptoAddress method returns with beneficiaryRegistrationDto",
	 * beneficiaryRegistrationDto);
	 * 
	 * Beneficiary beneficiary = null;
	 * logger.debug("maptoBeneficiary method called"); beneficiary =
	 * BeneficiaryRegistrationMapper.maptoBeneficiary(beneficiaryRegistrationDto
	 * ); logger.
	 * debug("maptoBeneficiary method returns with beneficiaryRegistrationDto",
	 * beneficiaryRegistrationDto);
	 * 
	 * AvailableDaysMapping availableDaysMapping = null;
	 * logger.debug("mapToAvailableDaysMapping method called");
	 * //availableDaysMapping =
	 * BeneficiaryRegistrationMapper.mapToAvailableDaysMapping(
	 * beneficiaryRegistrationDto); logger.
	 * debug("mapToAvailableDaysMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * Set<ChildrenAgeGenderMapping> childrenAgeGenderMappings = null; if
	 * (beneficiaryRegistrationDto.getChildrenAgeGenderMapping() != null) {
	 * 
	 * logger.debug("mapToChildrenAgeGenderMapping method called");
	 * childrenAgeGenderMappings = BeneficiaryRegistrationMapper
	 * .mapToChildrenAgeGenderMapping(beneficiaryRegistrationDto.
	 * getChildrenAgeGenderMapping()); logger.
	 * debug("mapToChildrenAgeGenderMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto); }
	 * 
	 * BeneficiaryRegistration beneficiaryRegistration = null;
	 * logger.debug("mapToBeneficiaryReg method called");
	 * beneficiaryRegistration =
	 * BeneficiaryRegistrationMapper.mapToBeneficiaryReg(
	 * beneficiaryRegistrationDto) ; logger.
	 * debug("mapToBeneficiaryReg method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * BeneficiaryFacilityMapping beneficiaryFacilityMappings = null;
	 * logger.debug("mapToBeneficiaryFacilityMapping method called");
	 * beneficiaryFacilityMappings = BeneficiaryRegistrationMapper
	 * .mapToBeneficiaryFacilityMapping(beneficiaryRegistrationDto); logger.
	 * debug("mapToBeneficiaryFacilityMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * BeneficiaryUserMapping beneficiaryUserMappings = null;
	 * logger.debug("mapToBeneficiaryUserMapping method called");
	 * beneficiaryUserMappings =
	 * BeneficiaryRegistrationMapper.mapToBeneficiaryUserMapping(
	 * beneficiaryRegistrationDto); logger.
	 * debug("mapToBeneficiaryUserMapping method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * TiScreeningDetail tiScreeningDetail = null;
	 * logger.debug("mapToTiScreeningDetail method called"); tiScreeningDetail =
	 * BeneficiaryRegistrationMapper.mapToTiScreeningDetail(
	 * beneficiaryRegistrationDto); logger.
	 * debug("mapToTiScreeningDetail method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * TiOstDetail tiOstDetail = null;
	 * logger.debug("mapToTiOstDetail method called"); tiOstDetail =
	 * BeneficiaryRegistrationMapper.mapToTiOstDetail(beneficiaryRegistrationDto
	 * ); logger.
	 * debug("mapToTiOstDetail method returns with beneficiaryRegistrationDto",
	 * beneficiaryRegistrationDto);
	 * 
	 * TiBeneficiaryReferral tiBeneficiaryReferral = null;
	 * logger.debug("mapToTiBeneficiaryReferral method called");
	 * tiBeneficiaryReferral =
	 * BeneficiaryRegistrationMapper.mapToTiBeneficiaryReferral(
	 * beneficiaryRegistrationDto); logger.
	 * debug("mapToTiBeneficiaryReferral method returns with beneficiaryRegistrationDto"
	 * , beneficiaryRegistrationDto);
	 * 
	 * // setting child entities in parent (BeneficiaryRegistration) entity
	 * beneficiaryRegistration.setAvailableDaysMapping(availableDaysMapping);
	 * 
	 * // setting child entities in parent entity and vice-versa
	 * Set<BeneficiaryRegistration> beneficiaryRegList = new
	 * HashSet<BeneficiaryRegistration>();
	 * availableDaysMapping.setBeneficiaryRegistrations(beneficiaryRegList);
	 * availableDaysMapping.getBeneficiaryRegistrations().add(
	 * beneficiaryRegistration);
	 * 
	 * availableDaysMappingRepository.save(availableDaysMapping);
	 * beneficiaryRegistration.setBeneficiary(beneficiary);
	 * tiScreeningDetail.setBeneficiary(beneficiary);
	 * tiOstDetail.setBeneficiary(beneficiary);
	 * beneficiaryFacilityMappings.setBeneficiary(beneficiary);
	 * beneficiaryUserMappings.setBeneficiary(beneficiary);
	 * tiBeneficiaryReferral.setBeneficiary(beneficiary);
	 * 
	 * Set<TiScreeningDetail> beneficiaryTiScrList = new
	 * HashSet<TiScreeningDetail>();
	 * beneficiary.setTiScreeningDetails(beneficiaryTiScrList);
	 * beneficiary.getTiScreeningDetails().add(tiScreeningDetail);
	 * 
	 * Set<TiOstDetail> beneficiaryTiOstList = new HashSet<TiOstDetail>();
	 * beneficiary.setTiOstDetails(beneficiaryTiOstList);
	 * beneficiary.getTiOstDetails().add(tiOstDetail);
	 * 
	 * Set<BeneficiaryFacilityMapping> beneficiaryFacilityList = new
	 * HashSet<BeneficiaryFacilityMapping>();
	 * beneficiary.setBeneficiaryFacilityMappings(beneficiaryFacilityList);
	 * beneficiary.getBeneficiaryFacilityMappings().add(
	 * beneficiaryFacilityMappings) ;
	 * 
	 * Set<BeneficiaryUserMapping> beneficiaryUserList = new
	 * HashSet<BeneficiaryUserMapping>();
	 * beneficiary.setBeneficiaryUserMappings(beneficiaryUserList);
	 * beneficiary.getBeneficiaryUserMappings().add(beneficiaryUserMappings);
	 * 
	 * Set<TiBeneficiaryReferral> beneficiaryReferralList = new
	 * HashSet<TiBeneficiaryReferral>();
	 * beneficiary.setTiBeneficiaryReferrals(beneficiaryReferralList);
	 * beneficiary.getTiBeneficiaryReferrals().add(tiBeneficiaryReferral);
	 * 
	 * beneficiary.setBeneficiaryRegistration(beneficiaryRegistration);
	 * beneficiary.setAddress(address);
	 * 
	 * Set<Beneficiary> beneficiaryList = new HashSet<Beneficiary>();
	 * address.setBeneficiaries(beneficiaryList);
	 * address.getBeneficiaries().add(beneficiary);
	 * 
	 * if (childrenAgeGenderMappings != null) { for (ChildrenAgeGenderMapping
	 * childrenAgeGenderMappingObj : childrenAgeGenderMappings) {
	 * Set<ChildrenAgeGenderMapping> childrenList = new
	 * HashSet<ChildrenAgeGenderMapping>();
	 * beneficiary.setChildrenAgeGenderMappings(childrenList);
	 * beneficiary.getChildrenAgeGenderMappings().add(
	 * childrenAgeGenderMappingObj);
	 * childrenAgeGenderMappingObj.setBeneficiary(beneficiary);
	 * 
	 * // saving parent entity address = addressRepository.save(address); } }
	 * 
	 * address = addressRepository.save(address);
	 * 
	 * beneficiaryRegistrationDto.setId(beneficiaryRegistration.getId());
	 * beneficiaryRegistrationDto.setAddressId(address.getId());
	 * beneficiaryRegistrationDto.setBeneficiaryId(beneficiary.getId());
	 * beneficiaryRegistrationDto.setAvailableDaysMapId(availableDaysMapping.
	 * getId() ); beneficiaryRegistrationDto.setBeneficiaryFacilityMapId(
	 * beneficiaryFacilityMappings.getId());
	 * beneficiaryRegistrationDto.setRefferalId(tiBeneficiaryReferral.getId());
	 * 
	 * return beneficiaryRegistrationDto;
	 * 
	 * }
	 */

	// 7. function to delete beneficiary details to database public
	public BeneficiaryRegistrationDto deleteBeneficiary(Long id) {

		BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();

		/*
		 * BeneficiaryRegistration beneficiaryRegistration = null;
		 * logger.debug("mapToBeneficiaryReg method called");
		 * beneficiaryRegistration =
		 * BeneficiaryRegistrationMapper.mapToBeneficiaryReg(
		 * beneficiaryRegistrationDto); logger.
		 * debug("mapToBeneficiaryReg method returns with beneficiaryRegistrationDto"
		 * , beneficiaryRegistrationDto);
		 * 
		 * logger.
		 * debug("findById method called for find values of particular id");
		 * beneficiaryRegistration =
		 * beneficiaryRegistrationRepository.findById(id).get();
		 * logger.debug("findById method returns with entity values ",
		 * beneficiaryRegistration);
		 * 
		 * // Setting tables as deleted
		 * beneficiaryRegistration.setIsDelete(true); //
		 * beneficiaryRegistration.setBeneficiary(beneficiary);
		 * 
		 * beneficiaryRegistrationRepository.save(beneficiaryRegistration);
		 */

		return beneficiaryRegistrationDto;
	}

	// 8. method to list beneficiaries based on referral and transfer
	public List<BeneficiaryRegistrationDto> getBeneficiariesForReferralOrTranfer() {

		List<ReferralProjection> beneficiaries = new ArrayList<>();
		BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();
		if (beneficiaryRegistrationDto.isOutwardReferal() == true
				&& beneficiaryRegistrationDto.isInwardReferal() == false
				&& beneficiaryRegistrationDto.isTransferInReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutDueForTransferReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutTransferredReferal() == false) {
			beneficiaries = beneficiaryReferralRepository.findAllOutRefferals();

		} else if (beneficiaryRegistrationDto.isInwardReferal() == true
				&& beneficiaryRegistrationDto.isOutwardReferal() == false
				&& beneficiaryRegistrationDto.isTransferInReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutDueForTransferReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutTransferredReferal() == false) {
			beneficiaries = beneficiaryReferralRepository
					.findAllInwardRefferals(beneficiaryRegistrationDto.getUserFacilityId());

		} else if (beneficiaryRegistrationDto.isTransferInReferal() == true
				&& beneficiaryRegistrationDto.isOutwardReferal() == true
				&& beneficiaryRegistrationDto.isInwardReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutDueForTransferReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutTransferredReferal() == false) {
			// beneficiaryRegistrationDto.setTransferStatus("Transfer In");
			beneficiaries = beneficiaryReferralRepository
					.findAllTransferIns(beneficiaryRegistrationDto.getUserFacilityId());

		} else if (beneficiaryRegistrationDto.isTransferOutDueForTransferReferal() == true
				&& beneficiaryRegistrationDto.isOutwardReferal() == true
				&& beneficiaryRegistrationDto.isInwardReferal() == false
				&& beneficiaryRegistrationDto.isTransferInReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutTransferredReferal() == false) {
			// beneficiaryRegistrationDto.setTransferStatus("Due to transfer");
			beneficiaries = beneficiaryReferralRepository.findAllTranferDues();

		} else if (beneficiaryRegistrationDto.isTransferOutTransferredReferal() == true
				&& beneficiaryRegistrationDto.isOutwardReferal() == true
				&& beneficiaryRegistrationDto.isInwardReferal() == false
				&& beneficiaryRegistrationDto.isTransferInReferal() == false
				&& beneficiaryRegistrationDto.isTransferOutDueForTransferReferal() == false) {
			// beneficiaryRegistrationDto.setTransferStatus("Transferred");
			beneficiaries = beneficiaryReferralRepository.findAllTranferred();

		}
		List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = BeneficiaryRegistrationMapper
				.mapToBeneficiaryReferralDto(beneficiaries);
		return beneficiaryRegistrationDtoList;
	}

	public GlobalBeneficiaryViewCardDTO findOne(Long beneficiaryId) {
		Optional<Beneficiary> benef = beneficiaryRepository.findById(beneficiaryId);
		if (benef.isPresent()) {
			Beneficiary beneficiary = benef.get();
			GlobalBeneficiaryViewCardDTO response = globalBeneficiaryViewCardMapper.toDto(beneficiary);
			if (response.getOstBeneficiary() != null) {
				TiOstDispensationItemDTO latestDispensationOfBeneficiary = dispensationItemRepository
						.getLatestDispensationDateOfBeneficiary(response.getOstBeneficiary().getId());
				String status = dispensationItemRepository
						.findDispensationStatusByBeneficiary(response.getOstBeneficiary().getId());
				if (latestDispensationOfBeneficiary == null) {
					TiOstDispensationItemDTO disp = new TiOstDispensationItemDTO();
					disp.setStatus(status);
					response.getOstBeneficiary().setDispensation(disp);
				} else {
					latestDispensationOfBeneficiary.setStatus(status);
					response.getOstBeneficiary().setDispensation(latestDispensationOfBeneficiary);
				}

			}
			return response;
		}
		return null;

	}

}