package gov.naco.soch.mapper;

import java.time.LocalDateTime;

import gov.naco.soch.dto.RoleAccessMappingDto;
import gov.naco.soch.entity.AccessMaster;
import gov.naco.soch.entity.Role;
import gov.naco.soch.entity.RoleAccessMapping;
import gov.naco.soch.enums.AccessCodeEnum;

public class AccessSettingsMapper {

	/*
	 * function to map list of RoleAccessMapping class to list of
	 * RoleAccessMappingDto class
	 */
	public static RoleAccessMappingDto mapToRoleAccessMappingDto(RoleAccessMapping roleAccessMapping) {
		RoleAccessMappingDto roleAccessMappingDto = new RoleAccessMappingDto();
		roleAccessMappingDto.setId(roleAccessMapping.getId());
		roleAccessMappingDto.setAccessCode(roleAccessMapping.getAccessMaster().getCode());
		roleAccessMappingDto.setAccessName(roleAccessMapping.getAccessMaster().getName());
		roleAccessMappingDto.setModule(roleAccessMapping.getAccessMaster().getModule());
		roleAccessMappingDto.setRoleId(roleAccessMapping.getRole().getId());
		return roleAccessMappingDto;
	}

	public static RoleAccessMappingDto mapToRoleAccessMappingDto(AccessMaster accessMaster) {
		RoleAccessMappingDto roleAccessMappingDto = new RoleAccessMappingDto();
		roleAccessMappingDto.setAccessCode(accessMaster.getCode());
		roleAccessMappingDto.setAccessName(accessMaster.getName());
		roleAccessMappingDto.setAccessDescription(accessMaster.getDescription());
		roleAccessMappingDto.setModule(accessMaster.getModule());
		return roleAccessMappingDto;
	}

	/*
	 * function to map list of RoleAccessMapping class to list of
	 * RoleAccessMappingDto class
	 */
	public static RoleAccessMapping mapToRoleAccessMapping(RoleAccessMappingDto roleAccessMappingDto) {
		/* This is a new entry in the role_access_mapping table. So set created_time. */
		RoleAccessMapping roleAccessMapping = new RoleAccessMapping();
		// roleAccessMapping.setCreatedTime(currentUtcTime);
		// roleAccessMapping.setCreatedBy(createdBy);//TODO
		AccessMaster accessMaster = new AccessMaster();
		accessMaster.setCode(roleAccessMappingDto.getAccessCode());
		roleAccessMapping.setAccessMaster(accessMaster);
		// roleAccessMapping.setModifiedBy(modifiedBy); //TODO
		// roleAccessMapping.setModifiedTime(currentUtcTime);

		return roleAccessMapping;
	}

	public static RoleAccessMapping mapToRoleAccessMapping(AccessMaster accessMaster,
			LocalDateTime currentUtcDateTime) {
		RoleAccessMapping roleAccessMapping = null;
		if (accessMaster != null) {
			/* This is a new entry in the role_access_mapping table. So set created_time. */
			roleAccessMapping = new RoleAccessMapping();
			// roleAccessMapping.setCreatedTime(currentUtcDateTime);
			// roleAccessMapping.setCreatedBy(createdBy);//TODO
			// roleAccessMapping.setModifiedTime(currentUtcDateTime);
			// roleAccessMapping.setModifiedBy(modifiedBy);//TODO
			roleAccessMapping.setAccessMaster(accessMaster);

		}
		return roleAccessMapping;
	}

	public static boolean findIsPeFromAccessSettings(Role role, boolean isPe) {
		if (!role.getRoleAccessMappings().isEmpty() && !isPe) {
			for (RoleAccessMapping accessMapping : role.getRoleAccessMappings()) {
				if (accessMapping.getAccessMaster() != null && accessMapping.getAccessMaster().getCode().equals(AccessCodeEnum.PE.getAccessCode())) {
					isPe = true;
				}
			}
		}
		return isPe;
	}

	public static boolean findIsOrwFromAccessSettings(Role role, boolean isOrw) {
		if (!role.getRoleAccessMappings().isEmpty() && !isOrw) {
			for (RoleAccessMapping accessMapping : role.getRoleAccessMappings()) {
				if (accessMapping.getAccessMaster() != null && accessMapping.getAccessMaster().getCode().equals(AccessCodeEnum.ORW.getAccessCode())) {
					isOrw = true;
				}
			}
		}
		return isOrw;
	}

}
