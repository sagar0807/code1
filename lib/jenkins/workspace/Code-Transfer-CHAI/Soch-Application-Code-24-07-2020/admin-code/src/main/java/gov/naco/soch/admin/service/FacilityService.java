package gov.naco.soch.admin.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DistrictDto;
import gov.naco.soch.dto.DistrictFacilityDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.FacilityBasicListDto;
import gov.naco.soch.dto.FacilityDto;
import gov.naco.soch.dto.FacilityListByDistrictAndFacilityTypeDTO;
import gov.naco.soch.dto.FacilityRequestDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.dto.TypologyDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityTypeDivisionMapping;
import gov.naco.soch.entity.Machine;
import gov.naco.soch.entity.MappingLabFacility;
import gov.naco.soch.entity.Pincode;
import gov.naco.soch.entity.Role;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.Town;
import gov.naco.soch.entity.TypologyFacilityMapping;
import gov.naco.soch.entity.TypologyMaster;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.entity.UserRoleMapping;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.AddressMapperUtil;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.mapper.FacilityMapperUtil;
import gov.naco.soch.mapper.FacilityTypeMapperUtil;
import gov.naco.soch.mapper.RoleMapperUtil;
import gov.naco.soch.mapper.TypologyMapperUtil;
import gov.naco.soch.repository.AddressRepository;
import gov.naco.soch.repository.ContractProductDetailRepository;
import gov.naco.soch.repository.ContractRepository;
import gov.naco.soch.repository.DistrictRepository;
import gov.naco.soch.repository.DivisionFacilitytypeMappingRepository;
import gov.naco.soch.repository.DivisionRepository;
import gov.naco.soch.repository.FacilityLinkedFacilityBeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityTypeRepository;
import gov.naco.soch.repository.MachineRepository;
import gov.naco.soch.repository.MappingLabFacilityRepository;
import gov.naco.soch.repository.PincodeRepository;
import gov.naco.soch.repository.RoleRepository;
import gov.naco.soch.repository.StateRepository;
import gov.naco.soch.repository.SubdistrictRepository;
import gov.naco.soch.repository.TownRespository;
import gov.naco.soch.repository.TypologyFacilityMappingRepository;
import gov.naco.soch.repository.TypologyRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.repository.UserRoleMappingRepository;
import gov.naco.soch.util.UserUtils;

//service class interact data with database

@Transactional
@Service
public class FacilityService {

	private static final Logger logger = LoggerFactory.getLogger(FacilityService.class);

	@Autowired
	FacilityRepository facilityRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	private MappingLabFacilityRepository mappingLabFacilityRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private DivisionFacilitytypeMappingRepository divisionFacilityTypeRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private DivisionRepository divisionRepository;

	@Autowired
	private TypologyRepository typologyRepository;

	@Autowired
	private TypologyFacilityMappingRepository typologyFacilityMappingRepository;

	@Autowired
	private TownRespository townRespository;

	@Autowired
	private SubdistrictRepository subdistrictRepository;

	@Autowired
	private PincodeRepository pincodeRepository;

	@Autowired
	private MachineRepository machineRepository;

	@Autowired
	private UserMasterRepository userRepository;

	@Autowired
	private UserRoleMappingRepository userRoleMappingRepository;

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private ContractProductDetailRepository contractProductDetailRepository;

	@Autowired
	private FacilityTypeRepository facilityTypeRepository;

	@Autowired
	private FacilityLinkedFacilityBeneficiaryRepository facilityLinkedFacilityBeneficiaryRepository;

	private static final String REQUIRED_ERROR = "SACS is required to create laboratory";

	private static final String PERMISSION_ERROR = "You are not permitted to create a laboratory";

	// method to insert facility details into facility table,address details into
	// address table and user-facility mapping details into user-facility mapping
	// table
	public void addFacility(FacilityDto facilityDto) {

		facilityDto.setIsActive(facilityDto.getIsActive());
		facilityDto.setIsDelete(false);
		int count = 0;

		// To check whether the facility name is already exist in table
		boolean isExistsName = facilityRepository.existsByNameIgnoreCase(facilityDto.getName());
		count = facilityRepository.existsByOtherNameInAdd(facilityDto.getName());

		if (count != 0) {
			String errorfield = "name";
			facilityDto.setName(facilityDto.getName());
			throwError(errorfield, facilityDto.getName());
		}
		Pincode pincode = null;
		if (facilityDto.getPincode() != null && facilityDto.getPincode() != "") {
			Optional<Pincode> pincodeOpt = pincodeRepository.findByPincode(facilityDto.getPincode());
			if (!pincodeOpt.isPresent()) {
				pincode = new Pincode();
				pincode.setPincode(facilityDto.getPincode());
				pincode.setIsActive(true);
				pincode.setIsDelete(false);
				pincode = pincodeRepository.save(pincode);
			} else {
				pincode = pincodeOpt.get();
			}
		}
		Optional<State> state = stateRepository.findById(facilityDto.getStateId());
		Optional<District> district = districtRepository.findById(facilityDto.getDistrictId());
		Facility facility = FacilityMapperUtil.mapToFacility(facilityDto);
		Address address = AddressMapperUtil.mapToAddressFacility(facilityDto, state.get(), district.get(), pincode);
		facility.setAddress(address);

		// Set<Facility> facilities = new HashSet<Facility>();
		// address.setFacilities(facilities);
		// address.getFacilities().add(facility);
		//
		// address = addressRepository.save(address);

		// auto generate facility code after saving a facility based on its primary key
		// https://www.java67.com/2014/10/how-to-pad-numbers-with-leading-zeroes-in-Java-example.html
		facilityRepository.save(facility);

		DecimalFormat df = new DecimalFormat("0000");
		String facilityCode = "FAC" + df.format(facility.getId());
		facility.setCode(facilityCode);
		facilityRepository.save(facility);
		facilityDto.setCode(facility.getCode());

		facilityDto.setId(facility.getId());

	}

	// Method to list all facilities
	public List<FacilityDto> getAllFacilities(List<Long> divisionIds, Long stateId) {

		List<Facility> facilityList = facilityRepository.findByIsDelete(Boolean.FALSE);

		if (!CollectionUtils.isEmpty(divisionIds)) {
			facilityList = facilityList.stream().filter(f -> divisionIds.contains(f.getDivision().getId()))
					.collect(Collectors.toList());
		}

		if (stateId != null) {
			Predicate<Facility> addressFilter = f -> f.getAddress() != null;
			Predicate<Facility> stateFilter = f -> f.getAddress().getState() != null;
			Predicate<Facility> stateIdFilter = f -> f.getAddress().getState().getId() == stateId;
			facilityList = facilityList.stream().filter(addressFilter.and(stateFilter).and(stateIdFilter))
					.collect(Collectors.toList());
		}

		List<FacilityDto> facilityDtoList = FacilityMapperUtil.mapToFacilityDtoList(facilityList);

		return facilityDtoList;
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

	public List<FacilityRequestDto> getFacilities(Long divisionId, Long facilityTypeId) {
		List<Object[]> facilities = facilityRepository.findByDivisionAndFacilityTypeToObject(divisionId,
				facilityTypeId);
		List<FacilityRequestDto> facilityRequests = FacilityMapperUtil.mapObjectToFacilityRequestDto(facilities);
		return facilityRequests;
	}

	// Added for bugfix 14-02-2020
	// Method to delete facility
	public String deleteFacilityById(Long facilityId) {
		int count = facilityRepository.findDeleteUser(facilityId);
		if (count == 0) {
			Boolean isDeleted = false;
			Facility facility = null;
			try {
				facility = facilityRepository.findById(facilityId).get();
				facility.setIsDelete(true);
				facilityRepository.save(facility);
				logger.debug("Facility Deleted for facilityId " + facilityId);
				isDeleted = true;
				return facility.getName();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else {
			return null;
		}
		return null;
	}

	public List<FacilityDto> getFacilitiesMappedToLab(Long labId) {

		List<FacilityDto> facilityList = new ArrayList<>();
		List<MappingLabFacility> mapping = mappingLabFacilityRepository.findByLabId(labId);
		if (!CollectionUtils.isEmpty(mapping)) {
			facilityList = mapping.stream().map(m -> FacilityMapperUtil.mapToFacilityDto(m.getFacility()))
					.collect(Collectors.toList());
		}
		return facilityList;
	}

	// Method to list all facilities (labs)
	public List<FacilityDto> getLabs() {
		List<Facility> facilityList = facilityRepository.findByIsDelete(false);
		facilityList = facilityList.stream().filter(f -> f.getDivision().getId() == 9L).collect(Collectors.toList());
		List<FacilityDto> facilityDtoList = FacilityMapperUtil.mapToFacilityDtoList(facilityList);
		return facilityDtoList;
	}

	public List<FacilityDto> mapLabToFacility(Long labId, List<FacilityDto> facilities) {

		Optional<Facility> facilityOpt = facilityRepository.findById(labId);
		if (facilityOpt.isPresent()) {
			Facility lab = facilityOpt.get();

			List<MappingLabFacility> oldMappingList = mappingLabFacilityRepository.findByLabId(labId);

			mappingLabFacilityRepository.deleteAll(oldMappingList);

			List<Long> facilityIds = facilities.stream().map(f -> f.getId()).collect(Collectors.toList());

			List<Facility> facilitiesList = facilityRepository.findAllById(facilityIds);

			List<MappingLabFacility> newMappings = new ArrayList<>();

			List<FacilityDto> newFacilityMapping = new ArrayList<>();

			if (!CollectionUtils.isEmpty(facilitiesList)) {

				newMappings = facilitiesList.stream().map(fac -> {
					MappingLabFacility mapping = new MappingLabFacility();
					mapping.setLab(lab);
					mapping.setFacility(fac);
					mapping.setIsDelete(Boolean.FALSE);
					return mapping;
				}).collect(Collectors.toList());

				mappingLabFacilityRepository.saveAll(newMappings);

				newFacilityMapping = FacilityMapperUtil.mapToFacilityDtoList(facilitiesList);
				return newFacilityMapping;
			} else {
				return newFacilityMapping;
			}
		} else {
			throw new ServiceException("Invalid Lab Id", null, HttpStatus.BAD_REQUEST);
		}
	}

	public DistrictFacilityDto getLocalFacilites(Long facilityId, List<Long> divisionIds) {

		if (!CollectionUtils.isEmpty(divisionIds)) {
			DistrictFacilityDto districtFacilityDto = new DistrictFacilityDto();
			Optional<Facility> facilityOpt = facilityRepository.findById(facilityId);

			if (facilityOpt.isPresent()) {

				Facility facility = facilityOpt.get();
				if (facility.getAddress() != null && facility.getAddress().getState() != null) {
					Long stateId = facility.getAddress().getState().getId();

					List<District> districtList = districtRepository.findByStateId(stateId);

					List<Long> districtIds = districtList.stream().map(d -> d.getId()).collect(Collectors.toList());

					List<DistrictDto> districtDtoList = districtList.stream().map(d -> {

						DistrictDto district = new DistrictDto();
						district.setId(d.getId());
						district.setName(d.getName());
						district.setStateid(d.getState().getId());
						return district;
					}).sorted(Comparator.comparing(DistrictDto::getName)).collect(Collectors.toList());

					districtFacilityDto.setDistricts(districtDtoList);

					List<FacilityTypeDivisionMapping> facilityTypeDivisionMapping = divisionFacilityTypeRepository
							.findFacilityTypeMappingByDivisionIdList(divisionIds);
					List<FacilityType> facilityTypeList = facilityTypeDivisionMapping.stream()
							.map(m -> m.getFacilityType()).collect(Collectors.toList());
					List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
					logger.debug("mapToFacilityTypeDtoList method called with parameters->{}", facilityTypeDtoList);
					facilityTypeDtoList = FacilityTypeMapperUtil.mapToFacilityTypeDtoList(facilityTypeList);
					districtFacilityDto.setFacilityTypes(facilityTypeDtoList);

					if (facility.getFacilityType().getId() != FacilityTypeEnum.SACS.getFacilityType()) {
						facilityId = facility.getSacsId();
					}

					List<Facility> facilityList = facilityRepository.findByDivisionIds(divisionIds, facilityId);
					List<FacilityDto> facilityDtoList = FacilityMapperUtil.mapToFacilityDtoList(facilityList);
					facilityDtoList = facilityDtoList.stream().filter(f -> districtIds.contains(f.getDistrictId()))
							.collect(Collectors.toList());

					districtFacilityDto.setFacilities(facilityDtoList);

					return districtFacilityDto;

				} else {
					throw new ServiceException("Invalid Facility Address", null, HttpStatus.BAD_REQUEST);
				}

			} else {
				throw new ServiceException("Invalid Facility Id", null, HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ServiceException("Required division ids as query parameters", null, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @param sacsFacilityDto
	 * @return
	 */
	public SacsFacilityDto addAnyFacilities(SacsFacilityDto sacsFacilityDto) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		errorChecker(sacsFacilityDto);
		int count = 0;
		// To check whether the facility name is already exist in table
		count = facilityRepository.existsByOtherNameInAdd(sacsFacilityDto.getName());

		if (count != 0) {
			String errorfield = "Facility name";
			throwError(errorfield, sacsFacilityDto.getName());
		} else {
			if (sacsFacilityDto.getFacilityNo() != null && sacsFacilityDto.getFacilityNo() != "") {
				count = 0;
				count = facilityRepository.existsByFacilityNumberInAdd(sacsFacilityDto.getFacilityNo());
				if (count != 0) {
					String errorfield = "Facility Number";
					throwError(errorfield, sacsFacilityDto.getFacilityNo());
				}
			}
			if (sacsFacilityDto.getTypology() != null && sacsFacilityDto.getTypology().size() != 0) {
				sacsFacilityDto = FacilityMapperUtil.mapSacsFacilityDtoBasedOnTypology(sacsFacilityDto);
			}

			Machine machine = null;
			Optional<State> state = stateRepository.findById(sacsFacilityDto.getStateId());
			Optional<District> district = districtRepository.findById(sacsFacilityDto.getDistrictId());
			Town town = null;
			Subdistrict subdistrict = null;
			Pincode pincode = null;
			if (sacsFacilityDto.getTownId() != null) {
				Optional<Town> townOpt = townRespository.findById(sacsFacilityDto.getTownId());
				if (townOpt.isPresent()) {
					town = townOpt.get();
				}

			}
			if (sacsFacilityDto.getSubDistrictId() != null) {
				Optional<Subdistrict> subdistrictOpt = subdistrictRepository
						.findById(sacsFacilityDto.getSubDistrictId());
				if (subdistrictOpt.isPresent()) {
					subdistrict = subdistrictOpt.get();
				}

			}
			if (sacsFacilityDto.getPincode() != null && sacsFacilityDto.getPincode() != "") {
				Optional<Pincode> pincodeOpt = pincodeRepository.findByPincode(sacsFacilityDto.getPincode());
				if (!pincodeOpt.isPresent()) {
					pincode = new Pincode();
					pincode.setPincode(sacsFacilityDto.getPincode());
					pincode.setIsActive(true);
					pincode.setIsDelete(false);
					pincode = pincodeRepository.save(pincode);
				} else {
					pincode = pincodeOpt.get();
				}
			}
			if (sacsFacilityDto.getMachineId() != null) {
				Optional<Machine> machineOpt = machineRepository.findById(sacsFacilityDto.getMachineId());
				if (machineOpt.isPresent()) {
					machine = machineOpt.get();
				}
			}

			Optional<Division> division = divisionRepository.findById(sacsFacilityDto.getDivisionId());
			Facility facility = FacilityMapperUtil.mapSacsFacilityDtoToFacility(sacsFacilityDto);
			Address address = AddressMapperUtil.mapSacsFacilityDtoToAddressFacility(sacsFacilityDto, state.get(),
					district.get(), town, subdistrict, pincode);
			facility.setAddress(address);
			facility.setDivision(division.get());
			facility.setMachine(machine);

			if (sacsFacilityDto.getParentFacilityId() != null) {
				Facility parentFacility = facilityRepository.findById(sacsFacilityDto.getParentFacilityId()).get();
				facility.setFacility(parentFacility);
				if (sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.LAC_FACILITY.getFacilityType()
						&& parentFacility != null) {
					facility.setSacsId(parentFacility.getSacsId());
				}
			}

			facility = facilityRepository.save(facility);

			if (sacsFacilityDto.getTypology() != null && sacsFacilityDto.getTypology().size() != 0
					&& sacsFacilityDto.getFacilityTypeId() == 7l) {
				Set<TypologyFacilityMapping> typologyFacilityMappingList = FacilityMapperUtil
						.maptToTypologyFacilityMapping(sacsFacilityDto.getTypology(), facility);
				typologyFacilityMappingRepository.saveAll(typologyFacilityMappingList);
			}

			/*
			 * Finding Facility Code
			 */
			if ((sacsFacilityDto.getCode() == null || sacsFacilityDto.getCode() == "")
					&& sacsFacilityDto.getFacilityTypeId() == 3l) {
				DecimalFormat df = new DecimalFormat("0000");
				String facilityCode = "SUP" + df.format(facility.getId());
				facility.setCode(facilityCode);
				facilityRepository.save(facility);
				sacsFacilityDto.setCode(facility.getCode());
			} else if ((sacsFacilityDto.getCode() == null || sacsFacilityDto.getCode() == "")
					&& FacilityTypeMapperUtil.facilityTypeLabChecker(sacsFacilityDto.getFacilityTypeId())) {
				DecimalFormat df = new DecimalFormat("0000");
				String facilityCode = "LAB" + df.format(facility.getId());
				facility.setCode(facilityCode);
				facility.setIsLab(Boolean.TRUE);
				facilityRepository.save(facility);
				sacsFacilityDto.setCode(facility.getCode());
			} else if ((sacsFacilityDto.getCode() == null || sacsFacilityDto.getCode() == "")
					&& sacsFacilityDto.getFacilityTypeId() == 6l) {
				DecimalFormat df = new DecimalFormat("0000");
				String facilityCode = "RWH" + df.format(facility.getId());
				facility.setCode(facilityCode);
				facilityRepository.save(facility);
				sacsFacilityDto.setCode(facility.getCode());
			} else if ((sacsFacilityDto.getCode() == null || sacsFacilityDto.getCode() == "")
					&& sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.LAC_FACILITY.getFacilityType()) {
				DecimalFormat df = new DecimalFormat("0000");
				String facilityCode = "LAC" + df.format(facility.getId());
				facility.setCode(facilityCode);
				facilityRepository.save(facility);
				sacsFacilityDto.setCode(facility.getCode());
			} else if (sacsFacilityDto.getCode() == null || sacsFacilityDto.getCode() == "") {
				DecimalFormat df = new DecimalFormat("0000");
				String facilityCode = "FAC" + df.format(facility.getId());
				facility.setCode(facilityCode);
				facilityRepository.save(facility);
				sacsFacilityDto.setCode(facility.getCode());
			}

			sacsFacilityDto.setId(facility.getId());

			sacsFacilityDto = saveUserForFacilityCreation(sacsFacilityDto, facility);

		}

		return sacsFacilityDto;
	}

	/**
	 * @param sacsFacilityDto
	 * @return
	 */
	public SacsFacilityDto editAnyFacilities(SacsFacilityDto sacsFacilityDto) {

		errorChecker(sacsFacilityDto);
		int count = 0;
		// To check whether the facility name is already exist in table
		count = facilityRepository.existsByOtherNameInEdit(sacsFacilityDto.getName(), sacsFacilityDto.getId());

		if (count != 0) {
			String errorfield = "Facility name";
			throwError(errorfield, sacsFacilityDto.getName());
		} else {
			if (sacsFacilityDto.getFacilityNo() != null && sacsFacilityDto.getFacilityNo() != "") {
				count = 0;
				count = facilityRepository.existsByFacilityNumberInEdit(sacsFacilityDto.getFacilityNo(),
						sacsFacilityDto.getId());
				if (count != 0) {
					String errorfield = "Facility Number";
					throwError(errorfield, sacsFacilityDto.getFacilityNo());
				}
			}
			Optional<Facility> facilityOpt = facilityRepository.findById(sacsFacilityDto.getId());
			if (facilityOpt.get().getFacilityType().getId() != sacsFacilityDto.getFacilityTypeId()) {
				String errorfield = "Facility Type";
				Optional<FacilityType> facilityType = facilityTypeRepository
						.findById(sacsFacilityDto.getFacilityTypeId());
				String facilityTypeName = facilityType.get().getFacilityTypeName();
				throwErrorCannotChange(errorfield, facilityTypeName);
			}
			if (sacsFacilityDto.getTypology() != null && sacsFacilityDto.getTypology().size() != 0) {
				sacsFacilityDto = FacilityMapperUtil.mapSacsFacilityDtoBasedOnTypology(sacsFacilityDto);
			}

			Optional<State> state = stateRepository.findById(sacsFacilityDto.getStateId());
			Optional<District> district = districtRepository.findById(sacsFacilityDto.getDistrictId());
			Machine machine = null;
			Town town = null;
			Subdistrict subdistrict = null;
			Pincode pincode = null;
			if (sacsFacilityDto.getTownId() != null) {
				Optional<Town> townOpt = townRespository.findById(sacsFacilityDto.getTownId());
				if (townOpt.isPresent()) {
					town = townOpt.get();
				}
			}
			if (sacsFacilityDto.getSubDistrictId() != null) {
				Optional<Subdistrict> subdistrictOpt = subdistrictRepository
						.findById(sacsFacilityDto.getSubDistrictId());
				if (subdistrictOpt.isPresent()) {
					subdistrict = subdistrictOpt.get();
				}
			}
			if (sacsFacilityDto.getPincode() != null && sacsFacilityDto.getPincode() != "") {
				Optional<Pincode> pincodeOpt = pincodeRepository.findByPincode(sacsFacilityDto.getPincode());
				if (!pincodeOpt.isPresent()) {
					pincode = new Pincode();
					pincode.setPincode(sacsFacilityDto.getPincode());
					pincode.setIsActive(true);
					pincode.setIsDelete(false);
					pincode = pincodeRepository.save(pincode);
				} else {
					pincode = pincodeOpt.get();
				}
			}
			if (sacsFacilityDto.getMachineId() != null) {
				Optional<Machine> machineOpt = machineRepository.findById(sacsFacilityDto.getMachineId());
				if (machineOpt.isPresent()) {
					machine = machineOpt.get();
				}
			}
			Optional<Division> division = divisionRepository.findById(sacsFacilityDto.getDivisionId());
			Facility facility = FacilityMapperUtil.mapSacsFacilityDtoToFacilityInEdit(sacsFacilityDto,
					facilityOpt.get());
			Address address = new Address();
			if (facility.getAddress() != null) {
				address = facility.getAddress();
			}
			address = AddressMapperUtil.mapSacsFacilityDtoToAddressFacilityInEdit(sacsFacilityDto, state.get(),
					district.get(), town, subdistrict, pincode, address);
			facility.setAddress(address);
			facility.setDivision(division.get());
			facility.setMachine(machine);

			facility = facilityRepository.save(facility);

			int typologyCount = 0;
			typologyCount = typologyFacilityMappingRepository.isExistByFacilityId(facility.getId());
			if (typologyCount != 0) {
				typologyFacilityMappingRepository.deleteByFacilityId(facility.getId());
			}
			if (sacsFacilityDto.getTypology() != null && sacsFacilityDto.getTypology().size() != 0
					&& sacsFacilityDto.getFacilityTypeId() == 7l) {
				Set<TypologyFacilityMapping> typologyFacilityMappingList = FacilityMapperUtil
						.maptToTypologyFacilityMapping(sacsFacilityDto.getTypology(), facility);
				typologyFacilityMappingRepository.saveAll(typologyFacilityMappingList);
			}

			sacsFacilityDto = saveUserForFacilityCreation(sacsFacilityDto, facility);

		}

		return sacsFacilityDto;
	}

	public List<FacilityDto> getFacilitySacs(Long sacsId) {
		List<Facility> facilityList = new ArrayList<Facility>();
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(sacsId, Boolean.FALSE, Boolean.TRUE);
		facilityDtoList = FacilityMapperUtil.mapToFacilityDtoList(facilityList);
		return facilityDtoList;

	}

	public List<TypologyDto> getAllTypology() {
		List<TypologyMaster> typologyMasterList = typologyRepository.findAll();
		List<TypologyDto> typologyDtoList = FacilityMapperUtil
				.mapTypologyMasterLitToTypologyDtoList(typologyMasterList);
		return typologyDtoList;
	}

	public List<FacilityDto> getSacsList() {
		Long facilityTypeId = (long) 2;
		List<Facility> facilityList = new ArrayList<Facility>();
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		facilityList = facilityRepository.findByFacilityTypeIdAndIsDelete(facilityTypeId, Boolean.FALSE);
		facilityDtoList = FacilityMapperUtil.mapToFacilityDtoList(facilityList);
		return facilityDtoList;
	}

	public List<SacsFacilityDto> getAllFacilityBySacs(Long sacsId, Integer pageNumber, Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		List<Long> facilityTypeIds = new ArrayList<>();
		facilityTypeIds.add(FacilityTypeEnum.LAC_FACILITY.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		List<Facility> facilityList = new ArrayList<Facility>();
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		Page<Facility> facilityPage = facilityRepository.findBySacsIdAndIsDeleteAndNotInFacilityTypes(sacsId,
				Boolean.FALSE, facilityTypeIds, pageable);
		int actualCount = facilityRepository.findCountIdBySacsIdAndIsDeleteNotInFacilityTypes(sacsId, Boolean.FALSE,
				facilityTypeIds);
		Optional<List> facilityListOptional = Optional.ofNullable(facilityPage.getContent());
		if (facilityListOptional.isPresent()) {
			facilityList = facilityListOptional.get();
		}
		sacsFacilityDtoList = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		if (!sacsFacilityDtoList.isEmpty()) {
			sacsFacilityDtoList.get(0).setActualRecordCount(actualCount);
		}
		return sacsFacilityDtoList;
	}

	public List<SacsFacilityDto> getAllFacilityByParentId(Long parentFacilityId) {
		List<Facility> facilityList = new ArrayList<Facility>();
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		facilityList = facilityRepository.findLacByArt(parentFacilityId);
		sacsFacilityDtoList = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		return sacsFacilityDtoList;
	}

	public SacsFacilityDto deleteFacility(Long facilityId) {
		Optional<Facility> facilityOpt = facilityRepository.findById(facilityId);
		Facility facility = facilityOpt.get();
		facility.setIsDelete(Boolean.TRUE);
		facility.getAddress().setIsDelete(Boolean.TRUE);
		facilityRepository.save(facility);
		SacsFacilityDto sacsFacilityDto = FacilityMapperUtil.mapFacilityToSacsfacilityDto(facility);

		Set<TypologyFacilityMapping> typologyFacilityMappings = facility.getTypologyFacilityMappings();
		typologyFacilityMappings.forEach(element -> {
			element.setIsDelete(Boolean.TRUE);
		});
		typologyFacilityMappingRepository.saveAll(typologyFacilityMappings);

		Set<UserMaster> userMasterList = userRepository.findAllByFacilityId(facilityId);
		userMasterList.forEach(element -> {
			element.setIsDelete(Boolean.TRUE);
			element.getUserAuths().setIsDelete(Boolean.TRUE);
			Set<UserRoleMapping> roleMappings = element.getUserRoleMappings();
			if (!roleMappings.isEmpty()) {
				roleMappings.forEach(roleMap -> {
					roleMap.setIsDelete(Boolean.TRUE);
				});
				userRoleMappingRepository.saveAll(roleMappings);
			}
		});
		userRepository.saveAll(userMasterList);

		if (facility.getFacilityType().getId() == FacilityTypeEnum.SUPPLIER.getFacilityType()) {
			if (!facility.getContracts().isEmpty()) {
				Set<Contract> contracts = facility.getContracts();
				contracts.forEach(c -> {
					c.setIsDelete(Boolean.TRUE);
					Set<ContractProduct> contractProducts = c.getContractProducts();
					if (!contractProducts.isEmpty()) {
						contractProducts.forEach(cp -> {
							cp.setIsDelete(Boolean.TRUE);
						});
						contractProductDetailRepository.saveAll(contractProducts);
					}
				});
				contractRepository.saveAll(contracts);
			}
		}

		return sacsFacilityDto;
	}

	public List<SacsFacilityDto> getFacilityByFacilityType(List<Long> facilityTypeId, Integer pageNumber,
			Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		LoginResponseDto currentLogin = UserUtils.getLoggedInUserDetails();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		Page<Facility> facilityPage = null;
		Optional<List> facilityListOptional = null;
		List<Facility> facilityList = new ArrayList<Facility>();
		int actualRecordCount;
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		if (!facilityTypeId.isEmpty() && facilityTypeId.get(0) == FacilityTypeEnum.WAREHOUSE.getFacilityType()) {
			actualRecordCount = facilityRepository.CountBySacsIdAndFacilityTypeIdIn(facilityTypeId,
					currentLogin.getFacilityId());
			facilityPage = facilityRepository.findBySacsIdAndFacilityTypeIdIn(facilityTypeId,
					currentLogin.getFacilityId(), pageable);
			facilityListOptional = Optional.ofNullable(facilityPage.getContent());
		} else {
			actualRecordCount = facilityRepository.CountByFacilityTypeIdIn(facilityTypeId);
			facilityPage = facilityRepository.findByFacilityTypeIdIn(facilityTypeId, pageable);
			facilityListOptional = Optional.ofNullable(facilityPage.getContent());
		}
		if (facilityListOptional.isPresent()) {
			facilityList = facilityListOptional.get();
		}
		sacsFacilityDtoList = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		if (!sacsFacilityDtoList.isEmpty()) {
			sacsFacilityDtoList.get(0).setActualRecordCount(actualRecordCount);
		}
		return sacsFacilityDtoList;
	}

	public List<TypologyDto> getTypologyListByFacilityId(Long facilityId) {
		List<Object[]> typologyList = typologyRepository.findAllByFacilityIdAndIsDelete(facilityId);
		List<TypologyDto> typologyDtoList = TypologyMapperUtil.mapTypologyObjectListToTypologyDtoList(typologyList);
		return typologyDtoList;
	}

	public SacsFacilityDto getFacilityByFacilityId(Long facilityId) {
		Optional<Facility> facility = facilityRepository.findById(facilityId);
		SacsFacilityDto sacsFacilityDto = FacilityMapperUtil.mapFacilityToSacsfacilityDto(facility.get());
		return sacsFacilityDto;
	}

	public List<SacsFacilityDto> getFacilityByFacilityTypeIdAndSacs(Long facilityTypeId) {
		List<Facility> facilityList = new ArrayList<Facility>();
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		facilityList = facilityRepository.findByFacilityTypeIdAndSacsIdAndIsDelete(facilityTypeId,
				loginResponseDto.getFacilityId(), Boolean.FALSE);
		sacsFacilityDtoList = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		return sacsFacilityDtoList;
	}

	public List<SacsFacilityDto> getTiCenterByIduAndSacs() {
		List<Facility> facilityList = new ArrayList<Facility>();
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		facilityList = facilityRepository.findTiCenterUnderIDU(FacilityTypeEnum.TI_CENTER.getFacilityType(),
				loginResponseDto.getFacilityId());
		sacsFacilityDtoList = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		return sacsFacilityDtoList;
	}

	public List<SacsFacilityDto> getParentOstCenterList() {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<Facility> facilityList = new ArrayList<>();
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		Facility facility = facilityRepository.findByIdAndIsDelete(loginResponseDto.getFacilityId(), Boolean.FALSE);
		if (facility.getFacilityType().getId() == FacilityTypeEnum.SACS.getFacilityType()) {
			facilityList = facilityRepository.findByFacilityTypeIdAndSacsIdAndIsDelete(
					FacilityTypeEnum.OST_FACILITY.getFacilityType(), facility.getId(), Boolean.FALSE);
		} else {
			facilityList = facilityRepository
					.findByFacilityTypeIdAndIsDelete(FacilityTypeEnum.OST_FACILITY.getFacilityType(), Boolean.FALSE);
		}
		sacsFacilityDtoList = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		return sacsFacilityDtoList;
	}

	public List<SacsFacilityDto> getFacilityListByParentAsCurrentFacility(Long facilityTypeId, Integer pageNumber,
			Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Page<Facility> facilityPage = null;
		Optional<List> facilityListOptional = null;
		List<SacsFacilityDto> sacsFacilityDtos = new ArrayList<>();
		List<Facility> facilityList = new ArrayList<>();
		int actualRecordCount = 0;
		actualRecordCount = facilityRepository.countByFacilityIdAndFacilityTypeIdAndIsDelete(
				loginResponseDto.getFacilityId(), facilityTypeId, Boolean.FALSE);
		facilityPage = facilityRepository.findAllByFacilityIdAndFacilityTypeIdAndIsDelete(
				loginResponseDto.getFacilityId(), facilityTypeId, Boolean.FALSE, pageable);
		facilityListOptional = Optional.ofNullable(facilityPage.getContent());
		if (facilityListOptional.isPresent()) {
			facilityList = facilityListOptional.get();
		}
		sacsFacilityDtos = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		if (!sacsFacilityDtos.isEmpty()) {
			sacsFacilityDtos.get(0).setActualRecordCount(actualRecordCount);
		}
		return sacsFacilityDtos;
	}

	/**
	 * Fetch facility list based on district id (Mandatory) and facility type id
	 * (Not Mandatory) api as query parameter
	 * 
	 * @param district
	 * @param facilityType
	 * @return
	 */
	public List<FacilityListByDistrictAndFacilityTypeDTO> getFacilityByDistrictAndFacilityType(Long district,
			Long facilityType) {
		if (district == null || district == 0) {
			throwErrorManually("District Id is Required", "Required_error");
		}
		List<Facility> facilityList = new ArrayList<>();
		List<FacilityListByDistrictAndFacilityTypeDTO> FacilityDtos = new ArrayList<>();
		if (facilityType != null && facilityType != 0) {
			facilityList = facilityRepository.findAllByDistrictIdAndFacilityTypeId(district, facilityType);
		} else {
			facilityList = facilityRepository.findAllByDistrictId(district);
		}
		FacilityDtos = FacilityMapperUtil.mapToFacilityListByDistrictAndFacilityTypeDTOList(facilityList);
		return FacilityDtos;
	}

	public List<SacsFacilityDto> advanceSearchForFacilities(Map<String, String> searchValues,
			List<Long> facilityTypeIds, Integer pageNumber, Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		Long sacsId = 0l;
		int actualRecordCount = 0;
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		if (currentUser.getFacilityTypeId() == FacilityTypeEnum.SACS.getFacilityType()) {
			sacsId = currentUser.getFacilityId();
		}
		String searchQuery = FacilityMapperUtil.advanceSearchQueryCreator(searchValues, facilityTypeIds, sacsId);
		String countQuery = searchQuery.replace("f.*", "count(f.id)");
		countQuery = countQuery.replace("group by f.id order by f.id desc", " ");
		actualRecordCount = facilityRepository.actualCount(countQuery);
		List<Facility> facilityList = facilityRepository.facilitySearch(searchQuery, pageable);
		List<SacsFacilityDto> sacsFacilityDtos = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		if (!sacsFacilityDtos.isEmpty()) {
			sacsFacilityDtos.get(0).setActualRecordCount(actualRecordCount);
		}
		return sacsFacilityDtos;
	}

	public List<SacsFacilityDto> normalSearchForFacilities(Map<String, String> searchDetails, Integer pageNumber,
			Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		Long sacsId = 0l;
		int actualRecordCount = 0;
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		if (currentUser.getFacilityTypeId() == FacilityTypeEnum.SACS.getFacilityType()) {
			sacsId = currentUser.getFacilityId();
		}
		String searchQuery = FacilityMapperUtil.normalSearchQueryCreator(searchDetails, sacsId);
		String countQuery = searchQuery.replace("f.*", "count(f.id)");
		countQuery = countQuery.replace("group by f.id order by f.id desc", " ");
		actualRecordCount = facilityRepository.actualCount(countQuery);
		List<Facility> facilityList = facilityRepository.facilitySearch(searchQuery, pageable);
		List<SacsFacilityDto> sacsFacilityDtos = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		if (!sacsFacilityDtos.isEmpty()) {
			sacsFacilityDtos.get(0).setActualRecordCount(actualRecordCount);
		}
		return sacsFacilityDtos;
	}

	/**
	 * Optimized facility list for All facilities
	 * is_delete=false and is_active=true and is_external=false or null
	 * @param divisionIds
	 * @param stateId
	 * @param facilityTypeId
	 * @return FacilityBasicListDto
	 */
	@Cacheable(value = "FacilitiesBasicListCache")
	public List<FacilityBasicListDto> getFacilities(List<Long> divisionIds, Long stateId, Long facilityTypeId) {
		String listQuery = FacilityMapperUtil.FacilityListQueryCreater(divisionIds, stateId, facilityTypeId);
		List<Object[]> facilityListObj = facilityRepository.findFacilityList(listQuery);
		List<FacilityBasicListDto> facilityList = FacilityMapperUtil.mapObjToBasicFAcilityList(facilityListObj);
		return facilityList;
	}

	/**
	 * Optimized Facility list for Link Art and Ost Satellite (Pass facilityTypeId)
	 * Based on current login facility as parent facility
	 * is_delete=false and is_active=true and is_external=false or null
	 * @param facilityType
	 * @return
	 */
	public List<FacilityBasicListDto> getAllOptimizedFacilityByCurrentFacilityAsParent(Long facilityType) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<Object[]> facilityListObj = facilityRepository.findFacilityByParentId(currentUser.getFacilityId(),
				facilityType);
		List<FacilityBasicListDto> facilityList = FacilityMapperUtil.mapObjToBasicFAcilityList(facilityListObj);
		return facilityList;
	}

	/**
	 * Fetching mapped ICTC facility with current login EID lab
	 * 
	 * @return
	 */
	public List<SacsFacilityDto> getMappedIctcForEidLab() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<SacsFacilityDto> sacsFacilityDtos = new ArrayList<>();
		if (currentUser.getFacilityTypeId() == FacilityTypeEnum.LABORATORY_EID.getFacilityType()) {
			List<Facility> facilityList = facilityRepository.findMappedFacilityByFacilityIdAndFacilityType(
					currentUser.getFacilityId(), FacilityTypeEnum.ICTC_FACILITY.getFacilityType());
			sacsFacilityDtos = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		}
		return sacsFacilityDtos;
	}

	/**
	 * Fetching vl labs mapped with current facility id
	 * 
	 * @return
	 */
	public List<SacsFacilityDto> getMappedVlLabsUnderCurrentFacility() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<Long> facilityType = new ArrayList<>();
		facilityType.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
		facilityType.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());
		List<Facility> facilityList = facilityRepository.findMappedVlLabsByFacilityId(currentUser.getFacilityId(),
				facilityType);

		if (currentUser.getFacilityTypeId() == FacilityTypeEnum.ART_FACILITY.getFacilityType()) {
			List<Facility> mhlFacilityList = findMHLFacilities();
			facilityList.addAll(mhlFacilityList);
		}

		List<SacsFacilityDto> sacsFacilityDtos = FacilityMapperUtil.mapToSacsfacilityDto(facilityList);
		return sacsFacilityDtos;
	}

	private List<Facility> findMHLFacilities() {
		List<Facility> mhlFacilityList = facilityRepository
				.findMHLFacilities(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
		return mhlFacilityList;
	}

	private SacsFacilityDto saveUserForFacilityCreation(SacsFacilityDto sacsFacilityDto, Facility facility) {
		if (facility.getId() != null) {

			List<RoleDto> roleList = new ArrayList<>();
			RoleDto roleDto = new RoleDto();
			UserMasterDto userMasterDto = new UserMasterDto();
			Optional<Role> roleOpt;

			// Saving Primary User
			if (sacsFacilityDto.getPrimaryUser() != null) {
				sacsFacilityDto.getPrimaryUser().setFacilityId(facility.getId());
				roleOpt = roleRepository.findById(sacsFacilityDto.getPrimaryUser().getRoleId());
				if (roleOpt.isPresent()) {
					roleDto = RoleMapperUtil.mapToRoleDTO(roleOpt.get());
					roleList.add(roleDto);
				}
				sacsFacilityDto.getPrimaryUser().setRoleDto(roleList);
				if (sacsFacilityDto.getIsActive()) {
					sacsFacilityDto.getPrimaryUser().setIsActive(true);
					sacsFacilityDto.getPrimaryUser().setStatus(1l);
				} else {
					sacsFacilityDto.getPrimaryUser().setIsActive(false);
					sacsFacilityDto.getPrimaryUser().setStatus(2l);
				}
				sacsFacilityDto.getPrimaryUser().setIsTrained(2l);
				try {
					userMasterDto = userService.saveUser(sacsFacilityDto.getPrimaryUser());
					sacsFacilityDto.setPrimaryUser(userMasterDto);
				} catch (Exception e) {
					String errorfield = "Primary Username";
					throwError(errorfield, sacsFacilityDto.getPrimaryUser().getUserName());
				}
			}

			// Saving Alternate User
			if (sacsFacilityDto.getAlternateUser() != null && sacsFacilityDto.getAlternateUser().getUserName() != null
					&& sacsFacilityDto.getAlternateUser().getUserName() != ""
					&& sacsFacilityDto.getAlternateUser().getRoleId() != null
					&& sacsFacilityDto.getAlternateUser().getFirstname() != null
					&& sacsFacilityDto.getAlternateUser().getFirstname() != "") {
				sacsFacilityDto.getAlternateUser().setFacilityId(facility.getId());
				roleList = new ArrayList<>();
				roleOpt = roleRepository.findById(sacsFacilityDto.getAlternateUser().getRoleId());
				if (roleOpt.isPresent()) {
					roleDto = RoleMapperUtil.mapToRoleDTO(roleOpt.get());
					roleList.add(roleDto);
				}
				sacsFacilityDto.getAlternateUser().setRoleDto(roleList);
				if (sacsFacilityDto.getIsActive()) {
					sacsFacilityDto.getAlternateUser().setIsActive(true);
					sacsFacilityDto.getAlternateUser().setStatus(1l);
				} else {
					sacsFacilityDto.getAlternateUser().setIsActive(false);
					sacsFacilityDto.getAlternateUser().setStatus(2l);
				}
				sacsFacilityDto.getAlternateUser().setIsTrained(2l);
				try {
					userMasterDto = userService.saveUser(sacsFacilityDto.getAlternateUser());
					sacsFacilityDto.setAlternateUser(userMasterDto);
				} catch (Exception e) {
					String errorfield = "Alternate Username";
					throwError(errorfield, sacsFacilityDto.getAlternateUser().getUserName());
				}
			}

		}
		return sacsFacilityDto;
	}

	/**
	 * Method to throw error in case of validation errors
	 * 
	 * @param errorfield
	 * @param errorFieldValue
	 */
	private void throwErrorCannotChange(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.CANNOT_CHANGE + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(Constants.CANNOT_CHANGE + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * To through By passing String
	 * 
	 * @param errorString
	 * @param errorType
	 */
	private void throwErrorManually(String errorString, String errorType) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorType);
		errorDto.setDescription(errorString);
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(errorString, errorResponse, HttpStatus.BAD_REQUEST);
	}

	private void errorChecker(SacsFacilityDto sacsFacilityDto) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		if (FacilityTypeMapperUtil.facilityTypeLabChecker(sacsFacilityDto.getFacilityTypeId())
				&& loginResponseDto.getFacilityTypeId() == FacilityTypeEnum.NACO.getFacilityType()
				&& (sacsFacilityDto.getSacsId() == null || sacsFacilityDto.getSacsId() == 0)) {
			throwErrorManually(REQUIRED_ERROR, "Required_error");
		}
		if (FacilityTypeMapperUtil.facilityTypeLabChecker(sacsFacilityDto.getFacilityTypeId())
				&& loginResponseDto.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()
				&& loginResponseDto.getFacilityTypeId() != FacilityTypeEnum.SACS.getFacilityType()) {
			throwErrorManually(PERMISSION_ERROR, "Permission_error");
		}
		if (sacsFacilityDto.getIsActive() == false
				&& sacsFacilityDto.getFacilityTypeId() == FacilityTypeEnum.LAC_FACILITY.getFacilityType()) {
			int count = 0;
			count = facilityLinkedFacilityBeneficiaryRepository
					.findFacilityCountLinkedBeneficiary(sacsFacilityDto.getId());
			if (count != 0) {
				throwErrorManually("Facility already linked with beneficiary", "Status cannot change");
			}
		}
	}

}
