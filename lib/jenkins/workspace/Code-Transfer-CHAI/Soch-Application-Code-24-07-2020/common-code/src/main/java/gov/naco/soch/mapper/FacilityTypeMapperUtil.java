/**
 * 
 */
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DesignationDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.FacilityTypeListByDivisionDTO;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.entity.DesignationFacilityTypeMapping;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.enums.RoleEnum;

public class FacilityTypeMapperUtil {

	// method to map facilityTypeDto with facilityType
	public static FacilityType maptoFacilityType(FacilityTypeDto facilityTypeDto, FacilityType facilityType) {

		if (facilityType == null) {
			facilityType = new FacilityType();
		} else {
			if (facilityTypeDto != null) {
				facilityType.setId(facilityTypeDto.getId());
				facilityType.setFacilityTypeName(facilityTypeDto.getFacilityTypeName().toString());
				facilityType.setIsActive(facilityTypeDto.getIsActive());
				facilityType.setIsDelete(false);
			}
		}
		return facilityType;
	}

	// method to map facilityTypeList with facilityTypeDtoList
	public static List<FacilityTypeDto> mapToFacilityTypeDtoList(List<FacilityType> facilityTypeList) {
		List<FacilityTypeDto> facilityTypeDtos = new ArrayList<FacilityTypeDto>();
		if (!CollectionUtils.isEmpty(facilityTypeList)) {
			facilityTypeList.forEach(facilityType -> {
				FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
				facilityTypeDto.setId(facilityType.getId());
				facilityTypeDto.setFacilityTypeName(
						facilityType.getFacilityTypeName() != null ? facilityType.getFacilityTypeName().trim() : null);
				facilityTypeDto.setIsActive(facilityType.getIsActive());
				if (!facilityType.getDesignationFacilityTypeMappings().isEmpty()) {
					List<DesignationDto> designatioDtoList = DesignationMapperUtil
							.mapDesignationFacilityTypeMappingListToDesignationList(
									facilityType.getDesignationFacilityTypeMappings());
					designatioDtoList = designatioDtoList.stream().filter(d -> d.getId() != 1l)
							.collect(Collectors.toList());
					facilityTypeDto.setDesignationList(designatioDtoList);
				}
				facilityTypeDtos.add(facilityTypeDto);
				List<RoleDto> roleDto = RoleMapperUtil.mapToRoleDtoSet(facilityType.getRoles());
				roleDto = roleDto.stream().filter(r -> r.getId() != RoleEnum.SUPER_ADMIN.getRole())
						.collect(Collectors.toList());
				Collections.sort(roleDto);
				facilityTypeDto.setRoleDto(roleDto);

			});
		}
		return facilityTypeDtos;
	}

	// method to map facilityType with facilityTypeDto
	public static FacilityTypeDto maptoFacilityTypeDto(FacilityType facilityType) {
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		if (facilityType != null) {
			facilityTypeDto.setId(facilityType.getId());
			facilityTypeDto.setFacilityTypeName(facilityType.getFacilityTypeName());
			List<RoleDto> roleDto = null;
			roleDto = RoleMapperUtil.mapToRoleDtoSet(facilityType.getRoles());
			facilityTypeDto.setRoleDto(roleDto);
		}
		return facilityTypeDto;
	}

	public static FacilityTypeDto maptoFacilityTypeDtoWithoutRole(FacilityType facilityType) {
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		if (facilityType != null) {
			facilityTypeDto.setId(facilityType.getId());
			facilityTypeDto.setFacilityTypeName(facilityType.getFacilityTypeName());
		}
		return facilityTypeDto;
	}

	// Function to map facility type Id from facilityTypeDto to FacilityType
	public static FacilityType maptoFacilityTypeId(Long facilityTypeId) {
		FacilityType facilityType = new FacilityType();
		facilityType.setId(facilityTypeId);
		return facilityType;
	}

	// method to map facilityType with facilityTypeDto without roleDto
	public static FacilityTypeDto maptoFacilityTypeDtoWithoutObj(FacilityType facilityType) {
		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		if (facilityType != null) {
			facilityTypeDto.setId(facilityType.getId());
			facilityTypeDto.setFacilityTypeName(facilityType.getFacilityTypeName());
			facilityTypeDto.setIsActive(facilityType.getIsActive());
		}
		return facilityTypeDto;
	}

	/**
	 * To check given facility type id is lab or not
	 * 
	 * @param facilityTypeId
	 * @return
	 */
	public static Boolean facilityTypeLabChecker(Long facilityTypeId) {
		if (facilityTypeId == FacilityTypeEnum.LABORATORY_EID.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.LABORATORY_APEX.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.LABORATORY_NRL.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.LABORATORY_SRL.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.LABORATORY_CD4.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.VL_PUBLIC.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.VL_PRIVATE.getFacilityType()
				|| facilityTypeId == FacilityTypeEnum.LABORATORY_ICTC_PPTCT.getFacilityType()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	public static List<FacilityTypeListByDivisionDTO> mapToFacilityTypeListByDivisionDTOList(
			List<FacilityType> facilityTypes) {
		List<FacilityTypeListByDivisionDTO> listByDivisionDTOs = new ArrayList<>();
		for (FacilityType facilityType : facilityTypes) {
			FacilityTypeListByDivisionDTO facilityTypeDto = new FacilityTypeListByDivisionDTO();
			facilityTypeDto.setId(facilityType.getId());
			facilityTypeDto.setName(facilityType.getFacilityTypeName());
			listByDivisionDTOs.add(facilityTypeDto);
		}
		return listByDivisionDTOs;
	}

	public static List<FacilityTypeDto> mapDesignationFacilityTypeListToFacilityTypeDtoList(
			Set<DesignationFacilityTypeMapping> designationFacilityTypeMappings) {
		List<FacilityTypeDto> facilityTypeDtos = new ArrayList<>();
		for (DesignationFacilityTypeMapping designationFacilityTypeMapping : designationFacilityTypeMappings) {
			if (designationFacilityTypeMapping.getFacilityType() != null
					&& designationFacilityTypeMapping.getFacilityType().getIsActive() != null
					&& designationFacilityTypeMapping.getFacilityType().getIsActive() == true) {
				FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
				facilityTypeDto.setId(designationFacilityTypeMapping.getFacilityType().getId());
				facilityTypeDto
						.setFacilityTypeName(designationFacilityTypeMapping.getFacilityType().getFacilityTypeName());
				facilityTypeDto.setIsActive(designationFacilityTypeMapping.getFacilityType().getIsActive());
				facilityTypeDtos.add(facilityTypeDto);
			}

		}
		return facilityTypeDtos;
	}

	public static List<FacilityTypeDto> mapObjToFacilityTypeDtoList(List<Object[]> facilityTypeObj) {
		List<FacilityTypeDto> facilityTypeDtos = facilityTypeObj.stream().map(objects -> {
			FacilityTypeDto facilityType = new FacilityTypeDto();
			facilityType
					.setId(objects[0] != null && objects[0] != "" ? (long) ((Integer) objects[0]).intValue() : null);
			facilityType
					.setFacilityTypeName(objects[1] != null && objects[1] != "" ? objects[1].toString().trim() : null);
			return facilityType;
		}).collect(Collectors.toList());
		return facilityTypeDtos;
	}

}
