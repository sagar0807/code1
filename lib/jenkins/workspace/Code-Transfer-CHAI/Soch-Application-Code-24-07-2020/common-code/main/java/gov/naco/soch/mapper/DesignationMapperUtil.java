package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DesignationDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.entity.Designation;
import gov.naco.soch.entity.DesignationFacilityTypeMapping;
import gov.naco.soch.entity.FacilityType;

//Mapper class for role to map between bean class and entity class

public class DesignationMapperUtil {

	// function to map list of Designation class to list of DesignationDto class.
	public static List<DesignationDto> mapToDesignationDtoList(List<Designation> designationList) {
		List<DesignationDto> designationDtos = new ArrayList<DesignationDto>();
		if (!CollectionUtils.isEmpty(designationList)) {
			designationList.forEach(designation -> {
				DesignationDto designationDto = new DesignationDto();
				designationDto.setId(designation.getId());
				designationDto.setTitle(designation.getTitle());
				designationDto.setActive(designation.getIsActive());
				designationDto.setDescription(designation.getDescription());
				designationDto.setDelete(designation.getIsDelete());
				if (designation.getDesignationFacilityTypeMappings() != null
						&& !designation.getDesignationFacilityTypeMappings().isEmpty()) {
					List<FacilityTypeDto> facilityTypeDtoList = FacilityTypeMapperUtil
							.mapDesignationFacilityTypeListToFacilityTypeDtoList(
									designation.getDesignationFacilityTypeMappings());
					designationDto.setFacilityTypeList(facilityTypeDtoList);
				}
				designationDtos.add(designationDto);
			});
		}
		return designationDtos;
	}

	// function to map DesignationDto class to Designation class.
	public static Designation mapToDesignation(DesignationDto designationDto, Designation designation) {
		if (designation == null) {
			designation = new Designation();
		}
		if (designationDto != null) {
			designation.setDescription(designationDto.getDescription());
			designation.setTitle(designationDto.getTitle().trim());
			designation.setIsActive(designationDto.isActive());
			designation.setIsDelete(false);

		}
		return designation;
	}

	// function to map Designation class to DesignationDto class.
	public static DesignationDto mapToDesignationDto(Designation designation) {
		DesignationDto designationDto = new DesignationDto();
		if (designation != null) {
			designationDto.setId(designation.getId());
			designationDto.setDescription(designation.getDescription());
			designationDto.setDelete(designation.getIsDelete());
			designationDto.setActive(designation.getIsActive());
			if (designation.getDesignationFacilityTypeMappings() != null
					&& !designation.getDesignationFacilityTypeMappings().isEmpty()) {
				List<FacilityTypeDto> facilityTypeDtoList = FacilityTypeMapperUtil
						.mapDesignationFacilityTypeListToFacilityTypeDtoList(
								designation.getDesignationFacilityTypeMappings());
				designationDto.setFacilityTypeList(facilityTypeDtoList);
			}
		}
		return designationDto;
	}

	public static Set<DesignationFacilityTypeMapping> mapToDesignationFacilityTypeList(DesignationDto designationDto,
			Designation designation) {

		Set<DesignationFacilityTypeMapping> list = new HashSet<>();
		for (FacilityTypeDto facilityTypeDto : designationDto.getFacilityTypeList()) {
			DesignationFacilityTypeMapping designationFacilityTypeMapping = new DesignationFacilityTypeMapping();
			FacilityType facilityType = new FacilityType();
			facilityType.setId(facilityTypeDto.getId());
			designationFacilityTypeMapping.setFacilityType(facilityType);
			designationFacilityTypeMapping.setDesignation(designation);
			designationFacilityTypeMapping.setIsActive(designationDto.isActive());
			designationFacilityTypeMapping.setIsDelete(false);
			list.add(designationFacilityTypeMapping);
		}
		return list;
	}

	public static List<DesignationDto> mapDesignationFacilityTypeMappingListToDesignationList(
			Set<DesignationFacilityTypeMapping> designationFacilityTypeMappings) {
		List<DesignationDto> list = new ArrayList<>();
		for (DesignationFacilityTypeMapping designationFacilityTypeMapping : designationFacilityTypeMappings) {
			if (designationFacilityTypeMapping.getDesignation() != null
					&& designationFacilityTypeMapping.getDesignation().getIsDelete() != null
					&& designationFacilityTypeMapping.getDesignation().getIsDelete() == false
					&& designationFacilityTypeMapping.getDesignation().getIsActive() != null
					&& designationFacilityTypeMapping.getDesignation().getIsActive() == true) {
				DesignationDto designationDto = new DesignationDto();
				designationDto.setId(designationFacilityTypeMapping.getDesignation().getId());
				designationDto.setTitle(designationFacilityTypeMapping.getDesignation().getTitle());
				designationDto.setDescription(designationFacilityTypeMapping.getDesignation().getDescription());
				designationDto.setActive(designationFacilityTypeMapping.getDesignation().getIsActive());
				list.add(designationDto);
			}
		}
		return list;
	}

	public static List<DesignationDto> mapObjToDesignationDtoList(List<Object[]> designationFacilityTypeMapListObj) {
		List<DesignationDto> designationDtos = designationFacilityTypeMapListObj.stream().map(objects -> {
			DesignationDto designationDto = new DesignationDto();
			designationDto
					.setId(objects[0] != null && objects[0] != "" ? (long) ((Integer) objects[0]).intValue() : null);
			designationDto.setTitle(objects[1] != null && objects[1] != "" ? objects[1].toString() : null);
			return designationDto;
		}).collect(Collectors.toList());
		return designationDtos;
	}

}
