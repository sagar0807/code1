package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.Role;

public class RoleMapperUtil {

	// function to map RoleDto class to Role class.
	public static Role mapToRole(RoleDto roleDto, Role role) {
		if (role == null) {
			role = new Role();
		}
		if (roleDto != null) {
			role.setId(roleDto.getId());
			role.setName(roleDto.getName());
			FacilityType facilityType = new FacilityType();
			facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(roleDto.getFacilityTypeId());
			role.setFacilityType(facilityType);
			role.setIsDelete(roleDto.getIsDelete());
			role.setIsActive(roleDto.getIsActive());
			role.setIsPrimary(roleDto.getIsPrimary());
		}
		return role;
	}

	// function to map Role list to RoleDto list.
	public static List<RoleDto> mapToRoleDTOList(List<Role> roleList) {
		List<RoleDto> roleDtos = new ArrayList<RoleDto>();
		if (!CollectionUtils.isEmpty(roleList)) {
			roleList.forEach(role -> {
				RoleDto roleDto = new RoleDto();
				roleDto.setId(role.getId());
				roleDto.setName(role.getName());
				roleDto.setIsDelete(role.getIsDelete());
				roleDto.setIsPrimary(role.getIsPrimary());
				roleDto.setIsActive(role.getIsActive());
				roleDto.setFacilityTypeId(role.getFacilityType().getId());
				FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
				facilityTypeDto = FacilityTypeMapperUtil.maptoFacilityTypeDtoWithoutObj(role.getFacilityType());
				roleDto.setFacilityType(facilityTypeDto);
				roleDtos.add(roleDto);
			});
		}
		return roleDtos;
	}

	// function to map Role class to RoleDto class.
	public static RoleDto mapToRoleDTO(Role role) {

		RoleDto roleDto = new RoleDto();
		if (role != null) {
			roleDto.setId(role.getId());
			roleDto.setName(role.getName());
			roleDto.setIsDelete(role.getIsDelete());
			FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
			facilityTypeDto = FacilityTypeMapperUtil.maptoFacilityTypeDto(role.getFacilityType());
			roleDto.setFacilityType(facilityTypeDto);
		}
		return roleDto;
	}
	
	public static RoleDto mapToRoleDTOWithoutFacilityType(Role role) {

		RoleDto roleDto = new RoleDto();
		if (role != null) {
			roleDto.setId(role.getId());
			roleDto.setName(role.getName());
			roleDto.setIsDelete(role.getIsDelete());
		}
		return roleDto;
	}

	// method to map roleObj to roleDto
	public static List<RoleDto> mapObjToRoleDto(List<Object[]> roleObj) {
		List<RoleDto> roleDtos = roleObj.stream().map(objects -> {
			RoleDto roleDto = new RoleDto();
			roleDto.setId((long) ((Integer) objects[0]).intValue());
			roleDto.setName(objects[1].toString());

			return roleDto;
		}).collect(Collectors.toList());

		return roleDtos;
	}

	// method to map roleDto_id to role_id
	public static Role mapToRoleId(RoleDto roleDto) {
		Role role = new Role();
		if (roleDto != null) {
			role.setId(roleDto.getId());
		}
		return role;
	}

	// method to map Set<Role> into roleDto list
	public static List<RoleDto> mapToRoleDtoSet(Set<Role> roles) {
		List<RoleDto> roleDtos = new ArrayList<RoleDto>();
		if (!CollectionUtils.isEmpty(roles)) {
			roles.forEach(role -> {
				RoleDto roleDto = new RoleDto();
				roleDto.setId(role.getId());
				roleDto.setName(role.getName());
				roleDto.setIsDelete(role.getIsDelete());
				roleDto.setIsActive(role.getIsActive());
				roleDto.setIsPrimary(role.getIsPrimary());
				roleDto.setFacilityTypeId(role.getFacilityType().getId());
				roleDtos.add(roleDto);
			});
		}
		return roleDtos;
	}

	public static String advanceSearchQueryCreator(Map<String, String> searchValue) {
		String facilityType = searchValue.get("facilityType");
		String name = searchValue.get("name");
		String primary = searchValue.get("primary");
		String searchQuery = "select r.* from soch.role r where r.is_delete=false ";
		if (facilityType != null && facilityType != "") {
			searchQuery = searchQuery.concat("and r.facility_type_id=" + facilityType + " ");
		}
		if (name != null && name != "") {
			searchQuery = searchQuery.concat("and lower(r.name) Like lower('%" + name + "%') ");
		}
		if (primary != null && primary != "") {
			searchQuery = searchQuery.concat("and r.is_primary=" + primary + " ");
		}
		searchQuery = searchQuery.concat("order by r.name");
		return searchQuery;
	}
}
