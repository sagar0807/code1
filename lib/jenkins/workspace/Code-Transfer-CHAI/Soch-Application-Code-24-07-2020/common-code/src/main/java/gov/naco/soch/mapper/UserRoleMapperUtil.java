package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.dto.UserRoleMappingDto;
import gov.naco.soch.entity.Role;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.entity.UserRoleMapping;

public class UserRoleMapperUtil {

	public static Set<UserRoleMappingDto> mapToUserRoleMappingDtoSet(Set<UserRoleMapping> userRoleMappingList) {
		Set<UserRoleMappingDto> userRoleMappingDtos = new HashSet<UserRoleMappingDto>();
		if (!CollectionUtils.isEmpty(userRoleMappingList)) {
			userRoleMappingList.forEach(userRoleMapping -> {
				UserRoleMappingDto userRoleMappingDto = new UserRoleMappingDto();
				userRoleMappingDto.setId(userRoleMapping.getId());
				userRoleMappingDto.setIsActive(userRoleMapping.getIsActive());

				RoleDto roleDto = new RoleDto();
				roleDto = RoleMapperUtil.mapToRoleDTO(userRoleMapping.getRole());
				userRoleMappingDto.setRoleDto(roleDto);

				UserMasterDto userMasterDto = new UserMasterDto();
				userMasterDto = UserMapperUtil.mapToUserMasterDtoWithoutObjects(userRoleMapping.getUserMaster());
				userRoleMappingDto.setUserMasterDto(userMasterDto);

				userRoleMappingDtos.add(userRoleMappingDto);
			});
		}
		return userRoleMappingDtos;
	}

	public static List<RoleDto> mapToRoleDtoList(Set<UserRoleMapping> userRoleMappingList) {
		List<RoleDto> RoleDtoSet = new ArrayList<RoleDto>();
		if (!CollectionUtils.isEmpty(userRoleMappingList)) {
			userRoleMappingList.forEach(userRoleMapping -> {

				RoleDto roleDto = new RoleDto();
				roleDto = RoleMapperUtil.mapToRoleDTO(userRoleMapping.getRole());

				RoleDtoSet.add(roleDto);
			});
		}
		return RoleDtoSet;
	}
	
	public static List<RoleDto> mapToRoleDtoListForUserList(Set<UserRoleMapping> userRoleMappingList) {
		List<RoleDto> RoleDtoSet = new ArrayList<RoleDto>();
		if (!CollectionUtils.isEmpty(userRoleMappingList)) {
			userRoleMappingList.forEach(userRoleMapping -> {

				RoleDto roleDto = new RoleDto();
				roleDto = RoleMapperUtil.mapToRoleDTOWithoutFacilityType(userRoleMapping.getRole());

				RoleDtoSet.add(roleDto);
			});
		}
		return RoleDtoSet;
	}

	public static Set<UserRoleMapping> mapToUserRoleMappingSet(Set<UserRoleMappingDto> userRoleMappingDtoList) {
		Set<UserRoleMapping> UserRoleMappings = new HashSet<UserRoleMapping>();
		if (!CollectionUtils.isEmpty(userRoleMappingDtoList)) {
			userRoleMappingDtoList.forEach(userRoleMappingDto -> {
				UserRoleMapping UserRoleMapping = new UserRoleMapping();
				UserRoleMapping.setId(userRoleMappingDto.getId());
				UserRoleMapping.setIsActive(userRoleMappingDto.getIsActive());
				UserRoleMapping.setIsDelete(userRoleMappingDto.getIsDelete());

				Role role = new Role();
				role = RoleMapperUtil.mapToRole(userRoleMappingDto.getRoleDto(), role);
				UserRoleMapping.setRole(role);

				UserMaster userMaster = new UserMaster();
				userMaster = UserMapperUtil.mapToUserMaster(userRoleMappingDto.getUserMasterDto());
				UserRoleMapping.setUserMaster(userMaster);

				UserRoleMappings.add(UserRoleMapping);
			});
		}
		return UserRoleMappings;
	}

	public static UserRoleMapping mapToUserRoleMapping(UserRoleMappingDto userRoleMappingDto) {
		UserRoleMapping userRoleMapping = new UserRoleMapping();
		if (userRoleMappingDto != null) {
			userRoleMapping.setId(userRoleMappingDto.getId());
			userRoleMapping.setIsActive(userRoleMappingDto.getIsActive());
			userRoleMapping.setIsDelete(userRoleMappingDto.getIsDelete());

			Role role = new Role();
			role = RoleMapperUtil.mapToRole(userRoleMappingDto.getRoleDto(), role);
			userRoleMapping.setRole(role);

			UserMaster userMaster = new UserMaster();
			userMaster = UserMapperUtil.mapToUserMaster(userRoleMappingDto.getUserMasterDto());
			userRoleMapping.setUserMaster(userMaster);
		}
		return userRoleMapping;
	}

	public static UserRoleMappingDto mapToUserRoleMappingDto(UserRoleMapping userRoleMapping) {
		UserRoleMappingDto userRoleMappingDto = new UserRoleMappingDto();
		if (userRoleMapping != null) {
			userRoleMappingDto.setId(userRoleMapping.getId());
			userRoleMappingDto.setIsActive(userRoleMapping.getIsActive());
			userRoleMappingDto.setIsDelete(userRoleMapping.getIsDelete());

			RoleDto roleDto = new RoleDto();
			roleDto = RoleMapperUtil.mapToRoleDTO(userRoleMapping.getRole());
			userRoleMappingDto.setRoleDto(roleDto);

			UserMasterDto userMasterDto = new UserMasterDto();
			userMasterDto = UserMapperUtil.mapToUserMasterDto(userRoleMapping.getUserMaster());
			userRoleMappingDto.setUserMasterDto(userMasterDto);
		}
		return userRoleMappingDto;
	}

	public static Set<UserRoleMapping> mapToUserRoleMappingSetWithoutUserMaster(
			Set<UserRoleMappingDto> userRoleMappingDtoList, UserMaster userMaster) {
		Set<UserRoleMapping> userRoleMappings = new HashSet<UserRoleMapping>();
		if (!CollectionUtils.isEmpty(userRoleMappingDtoList)) {
			userRoleMappingDtoList.forEach(userRoleMappingDto -> {
				UserRoleMapping userRoleMapping = new UserRoleMapping();
				userRoleMapping.setId(userRoleMappingDto.getId());
				userRoleMapping.setIsActive(userRoleMappingDto.getIsActive());
				userRoleMapping.setIsDelete(userRoleMappingDto.getIsDelete());

				Role role = new Role();
				role = RoleMapperUtil.mapToRoleId(userRoleMappingDto.getRoleDto());
				userRoleMapping.setRole(role);
				userRoleMapping.setUserMaster(userMaster);

				userRoleMappings.add(userRoleMapping);
			});
		}
		return userRoleMappings;
	}

}
