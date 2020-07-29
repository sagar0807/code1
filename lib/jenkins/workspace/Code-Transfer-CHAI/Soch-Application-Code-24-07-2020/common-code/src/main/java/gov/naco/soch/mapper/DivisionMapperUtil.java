package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.FacilityType;

/**
 * Mapper class for Division to map between bean class with entity class
 *
 */
public class DivisionMapperUtil {

	/**
	 * Method to map list of Division class to list of DivisionDto class.
	 */
	public static List<DivisionDto> mapToDivisionDtoList(List<Division> divisionList) {
		List<DivisionDto> divisionDtoList = new ArrayList<DivisionDto>();
		if (!CollectionUtils.isEmpty(divisionList)) {
			divisionList.stream().forEach(divisionRow -> {
				DivisionDto divisionDtoRow = new DivisionDto();
				divisionDtoRow.setId(divisionRow.getId());
				divisionDtoRow.setName(divisionRow.getName());
				divisionDtoRow.setCode(divisionRow.getCode());
				divisionDtoRow.setIsActive(divisionRow.getIsActive());
				divisionDtoRow.setSccEmail(divisionRow.getSccEmailId());
				divisionDtoRow.setSccMobileNo(divisionRow.getSccMobileNumber());
				divisionDtoRow.setSccName(divisionRow.getSccName());
				divisionDtoRow.setHeadDdgEmail(divisionRow.getHeadEmailId());
				divisionDtoRow.setHeadDdgMobileNo(divisionRow.getHeadPhoneNumber());
				divisionDtoRow.setHeadDdgName(divisionRow.getHeadDdgName());
				divisionDtoRow.setNpoEmail(divisionRow.getNpoEmailId());
				divisionDtoRow.setNpoMobileNo(divisionRow.getNpoMobileNumber());
				divisionDtoRow.setNpoName(divisionRow.getNpoName());

				List<FacilityType> facilityTypeList = divisionRow.getFacilityTypeDivisionMappings().stream()
						.map(m -> m.getFacilityType()).collect(Collectors.toList());

				List<FacilityTypeDto> facilityTypeDtoList = FacilityTypeMapperUtil
						.mapToFacilityTypeDtoList(facilityTypeList);
				Collections.sort(facilityTypeDtoList);

				List<String> facilityTypeNames = new ArrayList<>();
				for (FacilityTypeDto facilityTypeDto : facilityTypeDtoList) {
					facilityTypeNames.add(facilityTypeDto.getFacilityTypeName());
				}
				if (!facilityTypeNames.isEmpty()) {
					divisionDtoRow.setFacilityTypeNames(String.join(", ", facilityTypeNames));
				}

				divisionDtoRow.setFacilityTypes(facilityTypeDtoList);
				divisionDtoList.add(divisionDtoRow);
			});
		}
		return divisionDtoList;
	}

	/**
	 * Method to map DivisionDto class to Division class.
	 */
	public static Division mapToDivision(DivisionDto divisionDto, Division division) {
		if (division == null) {
			division = new Division();
		}
		if (divisionDto != null) {
			division.setName(divisionDto.getName());
			division.setCode(divisionDto.getCode());
			division.setHeadDdgName(divisionDto.getHeadDdgName());
			division.setSccName(divisionDto.getSccName());
			division.setSccEmailId(divisionDto.getSccEmail());
			division.setNpoName(divisionDto.getNpoName());
			division.setIsActive(divisionDto.getIsActive());
			division.setIsDelete(divisionDto.getIsDelete());
			division.setSccMobileNumber(divisionDto.getSccMobileNo());
			division.setHeadEmailId(divisionDto.getHeadDdgEmail());
			division.setHeadPhoneNumber(divisionDto.getHeadDdgMobileNo());
			division.setNpoEmailId(divisionDto.getNpoEmail());
			division.setNpoMobileNumber(divisionDto.getNpoMobileNo());
		}
		return division;
	}

	/**
	 * Method to map Division class to DivisionDto class.
	 */
	public static DivisionDto mapToDivisionDto(Division division) {
		DivisionDto divisionDto = new DivisionDto();
		if (division != null) {

			divisionDto.setId(division.getId());
			divisionDto.setId(division.getId());
			divisionDto.setName(division.getName());
			divisionDto.setCode(division.getCode());
			divisionDto.setIsActive(division.getIsActive());
			divisionDto.setIsDelete(division.getIsDelete());
		}
		return divisionDto;
	}

	/**
	 * method to map divisionFacilityTypeMapListObj to divisionDto
	 */
	public static List<DivisionDto> mapObjToDivisionDto(List<Object[]> divisionFacilityTypeMapListObj) {
		List<DivisionDto> divisionDtos = (List<DivisionDto>) divisionFacilityTypeMapListObj.stream().map(objects -> {
			DivisionDto divisionDto = new DivisionDto();
			divisionDto.setId((long) ((Integer) objects[0]).intValue());
			divisionDto.setName(objects[1].toString());
			return divisionDto;
		}).collect(Collectors.toList());

		return divisionDtos;
	}

	public static Division mapToDivisionId(DivisionDto divisionDto) {
		Division division = new Division();
		if (divisionDto != null) {
			division.setId(divisionDto.getId());
		}
		return division;
	}

	public static Division mapToDivisionId(Long divisionId) {
		Division division = new Division();
		division.setId(divisionId);
		return division;
	}

	public static String divisionAdvanceSearchQueryCreator(Map<String, String> searchValue) {
		String divisionName = searchValue.get("name");
		String code = searchValue.get("code");
		String facilityType = searchValue.get("facilityType");
		String searchQuery = "select d.* from soch.division d \r\n"
				+ "join soch.facility_type_division_mapping ftdm on ftdm.division_id=d.id \r\n"
				+ "where d.is_delete=false and ftdm.is_delete=false ";
		if (divisionName != null && divisionName != "") {
			searchQuery = searchQuery.concat("and lower(d.name) Like lower('%" + divisionName + "%') ");
		}
		if (code != null && code != "") {
			searchQuery = searchQuery.concat("and lower(d.code) Like lower('%" + code + "%') ");
		}
		if (facilityType != null && facilityType != "") {
			searchQuery = searchQuery.concat("and ftdm.facility_type_id=" + facilityType + " ");
		}
		searchQuery = searchQuery.concat("group by d.id order by d.name");
		return searchQuery;
	}

}
