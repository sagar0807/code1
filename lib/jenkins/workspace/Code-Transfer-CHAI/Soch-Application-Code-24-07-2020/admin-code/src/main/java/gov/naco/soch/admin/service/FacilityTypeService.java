
package gov.naco.soch.admin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.DesignationDto;
import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.FacilityTypeListByDivisionDTO;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityTypeDivisionMapping;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.mapper.DesignationMapperUtil;
import gov.naco.soch.mapper.DivisionMapperUtil;
import gov.naco.soch.mapper.FacilityTypeMapperUtil;
import gov.naco.soch.mapper.RoleMapperUtil;
import gov.naco.soch.mapper.UserMapperUtil;
import gov.naco.soch.repository.DesignationFacilityTypeMappingRepository;
import gov.naco.soch.repository.DivisionFacilitytypeMappingRepository;
import gov.naco.soch.repository.FacilityTypeRepository;
import gov.naco.soch.repository.RoleRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.util.CommonConstants;

@Service
@Transactional
public class FacilityTypeService {

	@Autowired
	private FacilityTypeRepository facilityTypeRepository;

	@Autowired
	private DivisionFacilitytypeMappingRepository divisionFacilityTypeRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserMasterRepository userRepository;

	@Autowired
	private DesignationFacilityTypeMappingRepository designationFacilityTypeMappingRepository;

	private static final Logger logger = LoggerFactory.getLogger(FacilityTypeService.class);

	// method to add/update facility type
	public FacilityTypeDto addFacilityType(FacilityTypeDto facilityTypeDto) {
		FacilityType facilityType = new FacilityType();
		int count = 0;
		boolean isEdit = false;

		if (facilityTypeDto.getId() != null && facilityTypeDto.getId() != 0) {
			// To check whether the facilityTypeName is already exist in table in edit
			String facilityTypeName = facilityTypeDto.getFacilityTypeName().trim().toString();
			count = facilityTypeRepository.existsByFacilityTypeNameInEdit(facilityTypeName, facilityTypeDto.getId());
			isEdit = true;
		} else {
			// To check whether the facilityTypeName is already exist in table in add
			String facilityTypeName = facilityTypeDto.getFacilityTypeName().trim().toString();
			count = facilityTypeRepository.existsByFacilityTypeNameIgnoreCase(facilityTypeName);
		}

		// invoking throwError method if duplicate found in facility type name
		if (count != 0) {
			logger.error(Constants.DUPLICATE_FOUND);
			String errorfield = "facilityTypeName";
			throwError(errorfield, facilityTypeDto.getFacilityTypeName());
		}

		// get all details by facility_type_id in edit
		if (isEdit) {
			facilityType = facilityTypeRepository.findById(facilityTypeDto.getId()).get();
		}

		facilityType = FacilityTypeMapperUtil.maptoFacilityType(facilityTypeDto, facilityType);
		logger.debug("maptoFacilityType method called with parameters->{}", facilityTypeDto);

		// save facility_type details into table
		facilityTypeRepository.save(facilityType);
		logger.debug("maptoFacilityTypeDto method called with parameters->{}", facilityType);
		facilityTypeDto = FacilityTypeMapperUtil.maptoFacilityTypeDtoWithoutObj(facilityType);

		return facilityTypeDto;
	}

	// method to find all facility types
	public List<FacilityTypeDto> getAllFacilityType() {
		// listing all values from division table
		List<FacilityType> facilityTypeList = facilityTypeRepository.findAll();
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		logger.debug("mapToFacilityTypeDtoList method called with parameters->{}", facilityTypeDtoList);
		facilityTypeDtoList = FacilityTypeMapperUtil.mapToFacilityTypeDtoList(facilityTypeList);
		return facilityTypeDtoList;

	}

	// method to find all facility types with division
	public List<FacilityTypeDto> getFacilityTypesWithDivision() {

		// to get all facility type where isActive=true
		List<FacilityType> facilityTypeList = facilityTypeRepository.findByIsActive(true);

		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();

		// taking each row of division list
		for (FacilityTypeDto facilityTypeDto : FacilityTypeMapperUtil.mapToFacilityTypeDtoList(facilityTypeList)) {

			List<Object[]> divisionFacilityTypeMapListObj = new ArrayList<>();

			// to get division by facility_type_id
			divisionFacilityTypeMapListObj = divisionFacilityTypeRepository
					.findAllByFacilityTypeId(facilityTypeDto.getId());

			List<DivisionDto> divisionDto = new ArrayList<>();
			logger.debug("mapObjToDivisionDto method called with parameters->{}", divisionDto);
			divisionDto = DivisionMapperUtil.mapObjToDivisionDto(divisionFacilityTypeMapListObj);
			facilityTypeDto.setDivision(divisionDto);

			// to get all primary users by facility_type_id
			List<Object[]> userListObj = new ArrayList<>();
			userListObj = userRepository.findUserByFacilityTypeId(facilityTypeDto.getId());

			List<UserMasterDto> userDtos = new ArrayList<>();
			logger.debug("mapObjToUserDto method called with parameters->{}", userListObj);
			userDtos = UserMapperUtil.mapObjToUserDto(userListObj);
			for (UserMasterDto userDto : userDtos) {
				List<Object[]> roleObj = new ArrayList<>();

				// to get role details by primary_user_id
				roleObj = roleRepository.findRoleByUserId(userDto.getId());
				List<RoleDto> roleDto = new ArrayList<>();
				logger.debug("mapObjToRoleDto method called with parameters->{}", roleObj);
				roleDto = RoleMapperUtil.mapObjToRoleDto(roleObj);
				userDto.setRoleDto(roleDto);
			}
			facilityTypeDto.setUser(userDtos);

			// adding each row to list
			facilityTypeDtoList.add(facilityTypeDto);
		}
		return facilityTypeDtoList;
	}

	// method to find all facility types which are not mapped with any division.
	public List<FacilityTypeDto> getDivisionNotMappedFacilityTypes() {
		// // listing all values from division table
		// List<FacilityType> facilityTypeList =
		// facilityTypeRepository.findAllNotDivisionMappedFacTypes();
		// List<FacilityTypeDto> facilityTypeDtoList = null;
		// logger.debug("mapToFacilityTypeDtoList method called with parameters->{}",
		// facilityTypeDtoList);
		// facilityTypeDtoList =
		// FacilityTypeMapperUtil.mapToFacilityTypeDtoList(facilityTypeList);
		// return facilityTypeDtoList;

		List<Integer> facilityTypeList = facilityTypeRepository.findByIsDelete();
		List<FacilityType> facilityTypeListDropDown = new ArrayList<>();
		if (!facilityTypeList.isEmpty()) {
			facilityTypeList.stream().map(String::valueOf).collect(Collectors.joining(","));
			facilityTypeListDropDown = facilityTypeRepository.getList(facilityTypeList);
		} else {
			facilityTypeListDropDown = facilityTypeRepository.findAllByIsDeleteAndIsActive(false, true);
		}

		List<FacilityTypeDto> facilityTypeDtoList = null;
		facilityTypeDtoList = FacilityTypeMapperUtil.mapToFacilityTypeDtoList(facilityTypeListDropDown);
		return facilityTypeDtoList;
	}

	// Method to throw error
	private void throwError(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.DUPLICATE_FOUND + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(CommonConstants.VALIDATION_FAILED, errorDtoList,
				detailsSimplified);
		throw new ServiceException(Constants.DUPLICATE_FOUND + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

	public List<FacilityTypeDto> getFacilityTypesForLabs() {

		List<FacilityTypeDivisionMapping> facilityTypeDivisionMapping = divisionFacilityTypeRepository
				.findFacilityTypeMappingByDivisionId(9L);
		List<FacilityType> facilityTypeList = facilityTypeDivisionMapping.stream().map(m -> m.getFacilityType())
				.collect(Collectors.toList());
		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();
		logger.debug("mapToFacilityTypeDtoList method called with parameters->{}", facilityTypeDtoList);
		facilityTypeDtoList = FacilityTypeMapperUtil.mapToFacilityTypeDtoList(facilityTypeList);
		return facilityTypeDtoList;
	}

	public List<FacilityTypeDto> getFacilityTypesForFacilityCreation() {
		// to get all facility type where isActive=true
		List<Object[]> facilityTypeObj = facilityTypeRepository.findLitByIsActive();
		List<FacilityTypeDto> facilityTypeDtos = new ArrayList<FacilityTypeDto>();
		facilityTypeDtos = FacilityTypeMapperUtil.mapObjToFacilityTypeDtoList(facilityTypeObj);
		Collections.sort(facilityTypeDtos);
		// LAC facility type removed from facility dropdown list
		facilityTypeDtos = facilityTypeDtos.stream()
				.filter(f -> f.getId() != FacilityTypeEnum.LAC_FACILITY.getFacilityType()
						&& f.getId() != FacilityTypeEnum.SACS.getFacilityType()
						&& f.getId() != FacilityTypeEnum.SUPPLIER.getFacilityType()
						&& f.getId() != FacilityTypeEnum.LABORATORY_EID.getFacilityType()
						&& f.getId() != FacilityTypeEnum.LABORATORY_APEX.getFacilityType()
						&& f.getId() != FacilityTypeEnum.LABORATORY_NRL.getFacilityType()
						&& f.getId() != FacilityTypeEnum.LABORATORY_SRL.getFacilityType()
						&& f.getId() != FacilityTypeEnum.LABORATORY_CD4.getFacilityType()
						&& f.getId() != FacilityTypeEnum.VL_PUBLIC.getFacilityType()
						&& f.getId() != FacilityTypeEnum.VL_PRIVATE.getFacilityType()
						&& f.getId() != FacilityTypeEnum.LABORATORY_ICTC_PPTCT.getFacilityType()
						&& f.getId() != FacilityTypeEnum.WAREHOUSE.getFacilityType())
				.collect(Collectors.toList());

		List<FacilityTypeDto> facilityTypeDtoList = new ArrayList<FacilityTypeDto>();

		// taking each row of division list
		for (FacilityTypeDto facilityTypeDto : facilityTypeDtos) {

			//Mapping Designation
			List<Object[]> designationFacilityTypeMapListObj = new ArrayList<>();
			designationFacilityTypeMapListObj = designationFacilityTypeMappingRepository
					.findDesignationByFacilityType(facilityTypeDto.getId());
			List<DesignationDto> designationList = new ArrayList<>();
			designationList = DesignationMapperUtil.mapObjToDesignationDtoList(designationFacilityTypeMapListObj);
			designationList = designationList.stream().filter(d -> d.getId() != 1l).collect(Collectors.toList());
			facilityTypeDto.setDesignationList(designationList);

			List<Object[]> divisionFacilityTypeMapListObj = new ArrayList<>();
			// to get division by facility_type_id
			divisionFacilityTypeMapListObj = divisionFacilityTypeRepository
					.findAllByFacilityTypeId(facilityTypeDto.getId());
			List<DivisionDto> divisionDto = new ArrayList<>();
			logger.debug("mapObjToDivisionDto method called with parameters->{}", divisionDto);
			divisionDto = DivisionMapperUtil.mapObjToDivisionDto(divisionFacilityTypeMapListObj);
			facilityTypeDto.setDivision(divisionDto);

			// to get all primary users by facility_type_id
			List<Object[]> userListObj = new ArrayList<>();
			userListObj = userRepository.findUserByFacilityTypeId(facilityTypeDto.getId());
			List<UserMasterDto> userDtos = new ArrayList<>();
			logger.debug("mapObjToUserDto method called with parameters->{}", userListObj);
			userDtos = UserMapperUtil.mapObjToUserDto(userListObj);
			for (UserMasterDto userDto : userDtos) {
				List<Object[]> roleObj = new ArrayList<>();

				// to get role details by primary_user_id
				roleObj = roleRepository.findRoleByUserId(userDto.getId());
				List<RoleDto> roleDto = new ArrayList<>();
				logger.debug("mapObjToRoleDto method called with parameters->{}", roleObj);
				roleDto = RoleMapperUtil.mapObjToRoleDto(roleObj);
				userDto.setRoleDto(roleDto);
			}
			facilityTypeDto.setUser(userDtos);

			// adding each row to list
			facilityTypeDtoList.add(facilityTypeDto);
		}
		return facilityTypeDtoList;
	}

	public List<FacilityTypeListByDivisionDTO> getFacilityTypesListByDivision(Long divisionid) {
		List<FacilityType> facilityTypes = facilityTypeRepository.findByDivisionId(divisionid);
		List<FacilityTypeListByDivisionDTO> list = FacilityTypeMapperUtil
				.mapToFacilityTypeListByDivisionDTOList(facilityTypes);
		return list;
	}

}
