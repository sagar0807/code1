package gov.naco.soch.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.DivisionFacilityTypeDto;
import gov.naco.soch.dto.FacilityTypeDivisionMappingDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.FacilityTypeDivisionMapping;
import gov.naco.soch.util.DateUtil;

public class DivisionFacilityTypeUtil {

	// map DivisionFacilityType list to DivisionFacilityTypeDto list
	public static Set<FacilityTypeDivisionMappingDto> mapToDivisionFacilityTypeDtoList(
			Set<FacilityTypeDivisionMapping> divisionFacilityTypeList) {
		Set<FacilityTypeDivisionMappingDto> divisionFacilityTypeDtoList = new HashSet<>();
		if (!CollectionUtils.isEmpty(divisionFacilityTypeList)) {
			divisionFacilityTypeList.forEach(divisionFacilityTypeRow -> {
				FacilityTypeDivisionMappingDto divisionFacilityTypeDtoRow = new FacilityTypeDivisionMappingDto();

				FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
				facilityTypeDto = FacilityTypeMapperUtil
						.maptoFacilityTypeDto(divisionFacilityTypeRow.getFacilityType());
				divisionFacilityTypeDtoRow.setFacilityType(facilityTypeDto);
				divisionFacilityTypeDtoRow.setId(divisionFacilityTypeRow.getId());
				divisionFacilityTypeDtoRow.setIsDelete(divisionFacilityTypeRow.getIsDelete());
				divisionFacilityTypeDtoRow.setIsActive(divisionFacilityTypeRow.getIsActive());

				FacilityType facilityType = divisionFacilityTypeRow.getFacilityType();
				divisionFacilityTypeDtoRow.setFacilityType(facilityTypeDto);
				divisionFacilityTypeDtoRow
						.setFacilityTypeName(divisionFacilityTypeRow.getFacilityType().getFacilityTypeName());

				divisionFacilityTypeDtoList.add(divisionFacilityTypeDtoRow);

			});
		}

		return divisionFacilityTypeDtoList;
	}

	public static Set<FacilityTypeDivisionMapping> mapToDivisionFacilityTypeList(
			List<FacilityTypeDivisionMappingDto> facilityTypeDivisionMappingDtoList) {
		Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappingList = new HashSet<FacilityTypeDivisionMapping>();
		if (!CollectionUtils.isEmpty(facilityTypeDivisionMappingDtoList)) {
			facilityTypeDivisionMappingDtoList.forEach(facilityTypeDivisionMappingDtorow -> {
				FacilityTypeDivisionMapping facilityTypeDivisionMapping = new FacilityTypeDivisionMapping();

				FacilityType facilityType = new FacilityType();
				facilityType = FacilityTypeMapperUtil
						.maptoFacilityType(facilityTypeDivisionMappingDtorow.getFacilityType(), facilityType);
				facilityTypeDivisionMapping.setFacilityType(facilityType);

				facilityTypeDivisionMapping.setId(facilityTypeDivisionMappingDtorow.getId());
				facilityTypeDivisionMapping.setIsDelete(facilityTypeDivisionMappingDtorow.getIsDelete());
				facilityTypeDivisionMapping.setIsActive(facilityTypeDivisionMappingDtorow.getIsActive());
				facilityTypeDivisionMappingList.add(facilityTypeDivisionMapping);
			});
		}

		return facilityTypeDivisionMappingList;
	}

	// map DivisionFacilityTypeDto to DivisionFacilityType
	public static FacilityTypeDivisionMapping mapToDivisionFacilityType(
			DivisionFacilityTypeDto divisionFacilityTypeDto) {
		FacilityTypeDivisionMapping divisionFacilityType = new FacilityTypeDivisionMapping();
		if (divisionFacilityTypeDto != null) {
			divisionFacilityType.setId(divisionFacilityTypeDto.getId());

			// divisionFacilityType.setDivisionId(divisionFacilityTypeDto.getDivision_id());
			// divisionFacilityType.setFacilityTypeId(divisionFacilityTypeDto.getId());
			divisionFacilityType.setIsDelete(divisionFacilityTypeDto.getIsDelete());
			divisionFacilityType.setIsActive(divisionFacilityTypeDto.getIsActive());
		}
		return divisionFacilityType;
	}

	// map DivisionFacilityType to DivisionFacilityTypeDto
	public static DivisionFacilityTypeDto mapToDivisionFacilityTypeDto(
			FacilityTypeDivisionMapping divisionFacilityType) {
		DivisionFacilityTypeDto divisionFacilityTypeDto = new DivisionFacilityTypeDto();
		if (divisionFacilityType != null) {

			// divisionFacilityTypeDto.setDivision_id(divisionFacilityType.getDivision_id());
			// divisionFacilityTypeDto.setId(divisionFacilityType.getFacilityType_id());
			divisionFacilityType.setIsActive(divisionFacilityTypeDto.getIsActive());
			divisionFacilityType.setIsDelete(divisionFacilityTypeDto.getIsDelete());
		}
		return divisionFacilityTypeDto;
	}

	// map DivisionFacility list of Object type to DivisionFacilityTypeDto list
	public static List<DivisionFacilityTypeDto> mapObjToDivisionFacilityDto(List<Object[]> mapObject) {
		List<DivisionFacilityTypeDto> divisionFacilityTypeDtos = mapObject.stream().map(objects -> {
			DivisionFacilityTypeDto divisionFacilityTypeDto = new DivisionFacilityTypeDto();
			// divisionFacilityTypeDto.setId(((Integer) objects[1]).intValue());
			// divisionFacilityTypeDto.setFacilityTypeName(objects[2].toString());
			// divisionFacilityTypeDto.setDivision_id(((Integer) objects[4]).intValue());
			// divisionFacilityTypeDto.setDivision_name(objects[5].toString());
			return divisionFacilityTypeDto;
		}).collect(Collectors.toList());

		return divisionFacilityTypeDtos;

	}

	public static FacilityTypeDivisionMapping mapToDivisionFacilityType(DivisionDto divisionDto) {
		FacilityTypeDivisionMapping facilityTypeDivisionMapping = new FacilityTypeDivisionMapping();
		if (divisionDto != null) {

			facilityTypeDivisionMapping.setIsDelete(divisionDto.getIsDelete());
			facilityTypeDivisionMapping.setIsActive(divisionDto.getIsActive());
		}
		return facilityTypeDivisionMapping;
	}

}
