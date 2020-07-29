package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.FacilityUserDto;
import gov.naco.soch.dto.LacUserDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.dto.TypologyDto;
import gov.naco.soch.dto.UserAuthDto;
import gov.naco.soch.dto.UserBasicDto;
import gov.naco.soch.dto.UserDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.MasterStatus;
import gov.naco.soch.entity.MasterTrainingType;
import gov.naco.soch.entity.MasterYesOrNo;
import gov.naco.soch.entity.Role;
import gov.naco.soch.entity.UserAuth;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.entity.UserRoleMapping;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.projection.UserBasicProjection;
import gov.naco.soch.projection.UserListProjection;

//Mapper class for role to map between bean class and entity class

public class UserMapperUtil {
	private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

	// function to map list of User class to list of UserDto class.

	public static Set<UserMasterDto> mapToUserMasterDtoSet(List<UserMaster> userList) {
		Set<UserMasterDto> userMasterDtos = new HashSet<UserMasterDto>();

		if (!CollectionUtils.isEmpty(userList)) {
			userList.forEach(user -> {
				UserMasterDto userMasterDto = new UserMasterDto();
				userMasterDto.setId(user.getId());
				userMasterDto.setFirstname(user.getFirstname());
				userMasterDto.setLastname(user.getLastname());
				userMasterDto.setEmail(user.getEmail());
				userMasterDto.setDesignationId(user.getDesignationId());
				userMasterDto.setLandlineNumber(user.getLandlineNumber());
				userMasterDto.setMobileNumber(user.getMobileNumber());
				userMasterDto.setStatus(user.getStatus() != null ? user.getStatus().getId() : null);
				userMasterDto.setIsActive(user.getIsActive());
				userMasterDto.setIsDelete(user.getIsDelete());
				userMasterDto.setIsBeneficiary(user.getIsBeneficiary());
				userMasterDto.setActiveRole(user.getActiveRole());
				userMasterDto.setPeCode(user.getPeCode());
				userMasterDto.setOrwCode(user.getOrwCode());
				userMasterDto.setIsTrained(user.getYesNo() != null ? user.getYesNo().getId() : null);
				userMasterDto
						.setTypeOfTraining(user.getTypeOfTraining() != null ? user.getTypeOfTraining().getId() : null);
				userMasterDto.setLastDateOfTraining(user.getLastDateOfTraining());
				UserAuthDto userAuthDto = new UserAuthDto();
				userAuthDto = UserAuthsMapperUtil.mapToUserAuthDtoWithoutPassword(user.getUserAuths());
				userMasterDto.setUserAuthsDto(userAuthDto);
				userMasterDto.setUserName(userAuthDto.getUsername());

				// userMasterDto.setBeneficiaryUserMappings(user.getBeneficiaryUserMappings());

				DivisionDto divisionDto = new DivisionDto();
				divisionDto = DivisionMapperUtil.mapToDivisionDto(user.getDivision());
				userMasterDto.setDivisionDto(divisionDto);
				userMasterDto.setDivisionId(divisionDto.getId());

				FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
				facilityTypeDto = FacilityTypeMapperUtil.maptoFacilityTypeDtoWithoutRole(user.getFacilityType());
				userMasterDto.setFacilityTypeDto(facilityTypeDto);
				userMasterDto.setFacilityTypeId(facilityTypeDto.getId());

				// FacilityDto facilityDto = new FacilityDto();
				// facilityDto = FacilityMapperUtil.mapToFacilityDto(user.getFacility());
				if (user.getFacility() != null) {
					userMasterDto.setFacilityId(user.getFacility().getId());
				}

				List<RoleDto> RoleDtoList = new ArrayList<RoleDto>();
				RoleDtoList = UserRoleMapperUtil.mapToRoleDtoListForUserList(user.getUserRoleMappings());
				userMasterDto.setRoleDto(RoleDtoList);

				// Set<UserRoleMappingDto> userRoleMappingDtoSet = new
				// HashSet<UserRoleMappingDto>();
				// userRoleMappingDtoSet =
				// UserRoleMapperUtil.mapToUserRoleMappingDtoSet(user.getUserRoleMappings());
				// userMasterDto.setUserRoleMappingsDto(userRoleMappingDtoSet);

				userMasterDtos.add(userMasterDto);

			});
		}
		return userMasterDtos;
	}

	// function to map UserDto class to User class.

	public static UserMaster mapToUserMaster(UserMasterDto userMasterDto) {

		UserMaster user = new UserMaster();
		if (userMasterDto != null) {
			user.setId(userMasterDto.getId());
			user.setFirstname(userMasterDto.getFirstname());
			user.setLastname(userMasterDto.getLastname());
			user.setEmail(userMasterDto.getEmail());
			user.setDesignationId(userMasterDto.getDesignationId());
			user.setLandlineNumber(userMasterDto.getLandlineNumber());
			user.setMobileNumber(userMasterDto.getMobileNumber());
			MasterStatus status = new MasterStatus();
			status.setId(userMasterDto.getStatus());
			user.setStatus(status);
			user.setIsActive(userMasterDto.getIsActive());
			user.setIsDelete(userMasterDto.getIsDelete());
			if (userMasterDto.getIsTrained() != null && userMasterDto.getIsTrained() != 0) {
				MasterYesOrNo trained = new MasterYesOrNo();
				trained.setId(userMasterDto.getIsTrained());
				user.setYesNo(trained);
				user.setLastDateOfTraining(userMasterDto.getLastDateOfTraining());
				MasterTrainingType typeOfTraining = null;
				if (userMasterDto.getTypeOfTraining() != null && userMasterDto.getTypeOfTraining() != 0) {
					typeOfTraining = new MasterTrainingType();
					typeOfTraining.setId(userMasterDto.getTypeOfTraining());
				}
				user.setTypeOfTraining(typeOfTraining);
			}
			user.setIsBeneficiary(userMasterDto.getIsBeneficiary());
			user.setActiveRole(userMasterDto.getActiveRole());

		}
		return user;
	}

	public static UserMasterDto mapToUserMasterDto(UserMaster user) {
		UserMasterDto userMasterDto = new UserMasterDto();

		userMasterDto.setId(user.getId());
		userMasterDto.setFirstname(user.getFirstname());
		userMasterDto.setLastname(user.getLastname());
		userMasterDto.setEmail(user.getEmail());
		userMasterDto.setDesignationId(user.getDesignationId());
		userMasterDto.setLandlineNumber(user.getLandlineNumber());
		userMasterDto.setMobileNumber(user.getMobileNumber());
		userMasterDto.setStatus(user.getStatus() != null ? user.getStatus().getId() : null);
		userMasterDto.setIsActive(user.getIsActive());
		userMasterDto.setIsTrained(user.getYesNo() != null ? user.getYesNo().getId() : null);
		userMasterDto.setTypeOfTraining(user.getTypeOfTraining() != null ? user.getTypeOfTraining().getId() : null);
		userMasterDto.setIsDelete(user.getIsDelete());
		userMasterDto.setIsBeneficiary(user.getIsBeneficiary());
		userMasterDto.setActiveRole(user.getActiveRole());
		userMasterDto.setFacilityId(user.getFacility().getId());
		userMasterDto.setWhatsappEnabled(user.getWhatsappEnabled());
		userMasterDto.setSmsEnabled(user.getSmsEnabled());
		userMasterDto.setPeCode(user.getPeCode());
		userMasterDto.setOrwCode(user.getOrwCode());
		userMasterDto.setLastDateOfTraining(user.getLastDateOfTraining());
		UserAuthDto userAuthDto = new UserAuthDto();
		userAuthDto = UserAuthsMapperUtil.mapToUserAuthDtoWithoutUserMaster(user.getUserAuths());
		userMasterDto.setUserAuthsDto(userAuthDto);
		userMasterDto.setUserName(userAuthDto.getUsername());
		userMasterDto.setFacilityId(user.getFacility() != null ? user.getFacility().getId() : null);
		userMasterDto.setTypologyId(user.getTypology() != null ? user.getTypology().getTypologyId() : null);

		// userMasterDto.setBeneficiaryUserMappings(user.getBeneficiaryUserMappings());

		DivisionDto divisionDto = new DivisionDto();
		divisionDto = DivisionMapperUtil.mapToDivisionDto(user.getDivision());
		userMasterDto.setDivisionDto(divisionDto);
		userMasterDto.setDivisionId(divisionDto.getId());

		FacilityTypeDto facilityTypeDto = new FacilityTypeDto();
		facilityTypeDto = FacilityTypeMapperUtil.maptoFacilityTypeDtoWithoutRole(user.getFacilityType());
		userMasterDto.setFacilityTypeDto(facilityTypeDto);
		userMasterDto.setFacilityTypeId(facilityTypeDto.getId());

		List<RoleDto> RoleDtoList = new ArrayList<RoleDto>();
		RoleDtoList = UserRoleMapperUtil.mapToRoleDtoListForUserList(user.getUserRoleMappings());
		userMasterDto.setRoleDto(RoleDtoList);

		TypologyDto typologyDto = new TypologyDto();
		typologyDto = TypologyMapperUtil.mapTypologyDto(user.getTypology());
		userMasterDto.setTypologyDto(typologyDto);

		// Set<UserRoleMappingDto> userRoleMappingDtos = new
		// HashSet<UserRoleMappingDto>();
		// userRoleMappingDtos =
		// UserRoleMapperUtil.mapToUserRoleMappingDtoSet(user.getUserRoleMappings());
		// userMasterDto.setUserRoleMappingsDto(userRoleMappingDtos);

		return userMasterDto;
	}

	public static UserMasterDto mapToUserMasterDtoWithoutObjects(UserMaster userMaster) {
		UserMasterDto userDto = new UserMasterDto();
		if (userMaster != null) {
			userDto.setId(userMaster.getId());
			userDto.setFirstname(userMaster.getFirstname());
			userDto.setLastname(userMaster.getLastname());
			userDto.setEmail(userMaster.getEmail());
			userDto.setDesignationId(userMaster.getDesignationId());
			userDto.setLandlineNumber(userMaster.getLandlineNumber());
			userDto.setMobileNumber(userMaster.getMobileNumber());
			userDto.setStatus(userMaster.getStatus().getId());
			userDto.setIsActive(userMaster.getIsActive());
			userDto.setIsDelete(userMaster.getIsDelete());
			userDto.setIsBeneficiary(userMaster.getIsBeneficiary());
			userDto.setActiveRole(userMaster.getActiveRole());
			userDto.setLastDateOfTraining(userMaster.getLastDateOfTraining());

		}
		return userDto;
	}

	public static Set<UserMasterDto> mapToUserMasterDtoSetWithoutObjects(Set<UserMaster> userMasters) {
		Set<UserMasterDto> userMasterDtos = new HashSet<>();
		if (!CollectionUtils.isEmpty(userMasters)) {
			userMasters.forEach(user -> {
				UserMasterDto userDto = new UserMasterDto();
				userDto.setId(user.getId());
				userDto.setFirstname(user.getFirstname());
				userDto.setLastname(user.getLastname());
				userDto.setEmail(user.getEmail());
				userDto.setDesignationId(user.getDesignationId());
				userDto.setLandlineNumber(user.getLandlineNumber());
				userDto.setMobileNumber(user.getMobileNumber());
				userDto.setStatus(user.getStatus() != null ? user.getStatus().getId() : null);
				userDto.setIsActive(user.getIsActive());
				userDto.setIsDelete(user.getIsDelete());
				userDto.setIsBeneficiary(user.getIsBeneficiary());
				userDto.setLastDateOfTraining(user.getLastDateOfTraining());
				userMasterDtos.add(userDto);
			});
		}

		return userMasterDtos;
	}

	public static List<UserMasterDto> mapObjToUserDto(List<Object[]> userObj) {
		List<UserMasterDto> userDtos = (List<UserMasterDto>) userObj.stream().map(objects -> {
			UserMasterDto userDto = new UserMasterDto();
			if (objects[0] != null) {
				userDto.setId((long) ((Integer) objects[0]).intValue());
			}
			if (objects[1] != null) {
				userDto.setFirstname(objects[1].toString());
				userDto.setLastname(objects[1].toString());
			}
			return userDto;
		}).collect(Collectors.toList());
		return userDtos;
	}

	public static UserAuth mapToUserAuth(UserMasterDto userMasterDto) {
		UserAuth userAuth = new UserAuth();
		if (userMasterDto != null) {
			userAuth.setEmail(userMasterDto.getEmail());
			userAuth.setUsername(userMasterDto.getUserName());
			String passwordNotEncoded = generateUserPassword(userMasterDto.getUserName());
			// String pass = bcryptEncoder.encode(passwordNotEncoded);
			String pass = encryptPassword(passwordNotEncoded);
			userAuth.setPassword(pass);
			userMasterDto.setPassword(passwordNotEncoded);

			userAuth.setIsActive(userMasterDto.getIsActive());
			userAuth.setIsDelete(userMasterDto.getIsDelete());
		}
		return userAuth;
	}

	public static String encryptPassword(String passwordNotEncoded) {
		return bcryptEncoder.encode(passwordNotEncoded);
	}

	public static String generateUserPassword(String userName) {
		if (!StringUtils.isBlank(userName)) {
			String password = "Soch@" + userName.substring(0, 4);
			return password;
		} else {
			return null;
		}

	}

	public static UserMaster mapToUserMasterId(UserMasterDto userMasterDto) {

		UserMaster user = new UserMaster();
		if (userMasterDto != null) {
			user.setId(userMasterDto.getId());

		}
		return user;
	}

	public static UserMaster mapToUserMaster(UserMasterDto userMasterDto, UserMaster userMaster) {
		if (userMaster == null) {
			userMaster = new UserMaster();
		} else {
			if (userMasterDto != null) {
				userMaster.setFirstname(userMasterDto.getFirstname());
				userMaster.setLastname(userMasterDto.getLastname());
				userMaster.setEmail(userMasterDto.getEmail());
				userMaster.setDesignationId(userMasterDto.getDesignationId());
				userMaster.setLandlineNumber(userMasterDto.getLandlineNumber());
				userMaster.setMobileNumber(userMasterDto.getMobileNumber());
				MasterStatus status = new MasterStatus();
				status.setId(userMasterDto.getStatus());
				if (userMasterDto.getIsTrained() != null && userMasterDto.getIsTrained() != 0) {
					MasterYesOrNo trained = new MasterYesOrNo();
					trained.setId(userMasterDto.getIsTrained());
					userMaster.setYesNo(trained);
					userMaster.setLastDateOfTraining(userMasterDto.getLastDateOfTraining());
					MasterTrainingType typeOfTraining = null;
					if (userMasterDto.getTypeOfTraining() != null && userMasterDto.getTypeOfTraining() != 0) {
						typeOfTraining = new MasterTrainingType();
						typeOfTraining.setId(userMasterDto.getTypeOfTraining());
					}
					userMaster.setTypeOfTraining(typeOfTraining);
				}
				userMaster.setStatus(status);
				userMaster.setIsActive(userMasterDto.getIsActive());
				userMaster.setIsDelete(userMasterDto.getIsDelete());
				userMaster.setIsBeneficiary(userMasterDto.getIsBeneficiary());
				userMaster.setLastDateOfTraining(userMasterDto.getLastDateOfTraining());
				userMaster.setActiveRole(userMasterDto.getActiveRole());
				userMaster.setPeCode(null);
				userMaster.setOrwCode(null);
			}
		}
		return userMaster;

	}

	public static UserMaster mapToUserMasterForUpdateProfile(UserMasterDto userMasterDto, UserMaster userMaster) {
		if (userMaster == null) {
			userMaster = new UserMaster();
		} else {
			if (userMasterDto != null) {
				userMaster.setFirstname(userMasterDto.getFirstname());
				userMaster.setLastname(userMasterDto.getLastname());
				userMaster.setEmail(userMasterDto.getEmail());
				userMaster.setWhatsappEnabled(userMasterDto.getWhatsappEnabled());
				userMaster.setSmsEnabled(userMasterDto.getSmsEnabled());
				userMaster.setLandlineNumber(userMasterDto.getLandlineNumber());
				userMaster.setMobileNumber(userMasterDto.getMobileNumber());

			}
		}
		return userMaster;

	}

	public static UserMaster mapToUserMasterForLacNurse(LacUserDto lacStaffNurseDto) {
		UserMaster user = new UserMaster();
		UserRoleMapping userRoleMapping = new UserRoleMapping();
		Role role = new Role();
		role.setId(lacStaffNurseDto.getRoleId());
		userRoleMapping.setRole(role);
		Set<UserRoleMapping> userRoleMappings = new HashSet<>();
		userRoleMappings.add(userRoleMapping);
		FacilityType facilityType = new FacilityType();
		facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(17l);
		user.setFacilityType(facilityType);
		user.setUserRoleMappings(userRoleMappings);
		user.setFirstname(lacStaffNurseDto.getFirstName());
		user.setLastname(lacStaffNurseDto.getLastName());
		user.setEmail(lacStaffNurseDto.getEmail());
		user.setMobileNumber(lacStaffNurseDto.getContactNumber());
		user.setDivision(DivisionMapperUtil.mapToDivisionId(lacStaffNurseDto.getDivisionId()));
		user.setDesignationId(lacStaffNurseDto.getDesignationId());
		user.setIsActive(true);
		user.setIsDelete(false);
		return user;
	}

	public static UserMaster mapToUserMasterForLacAlternatePerson(LacUserDto lacAlternatePersonDto) {
		UserMaster user = new UserMaster();
		UserRoleMapping userRoleMapping = new UserRoleMapping();
		Role role = new Role();
		role.setId(lacAlternatePersonDto.getRoleId());
		userRoleMapping.setRole(role);
		Set<UserRoleMapping> userRoleMappings = new HashSet<>();
		userRoleMappings.add(userRoleMapping);
		user.setUserRoleMappings(userRoleMappings);
		FacilityType facilityType = new FacilityType();
		facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(17l);
		user.setFacilityType(facilityType);
		user.setFirstname(lacAlternatePersonDto.getFirstName());
		user.setLastname(lacAlternatePersonDto.getLastName());
		user.setEmail(lacAlternatePersonDto.getEmail());
		user.setMobileNumber(lacAlternatePersonDto.getContactNumber());
		user.setDivision(DivisionMapperUtil.mapToDivisionId(lacAlternatePersonDto.getDivisionId()));
		user.setDesignationId(lacAlternatePersonDto.getDesignationId());
		user.setIsActive(true);
		user.setIsDelete(false);
		return user;
	}

	public static UserMaster mapToUserMasterForLacNurse(LacUserDto lacStaffNurseDto, UserMaster user) {
		UserRoleMapping userRoleMapping = user.getUserRoleMappings().iterator().next();
		Role role = new Role();
		role.setId(lacStaffNurseDto.getRoleId());
		userRoleMapping.setRole(role);
		Set<UserRoleMapping> userRoleMappings = new HashSet<>();
		userRoleMappings.add(userRoleMapping);
		FacilityType facilityType = new FacilityType();
		facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(17l);
		user.setFacilityType(facilityType);
		user.setUserRoleMappings(userRoleMappings);
		user.setFirstname(lacStaffNurseDto.getFirstName());
		user.setLastname(lacStaffNurseDto.getLastName());
		user.setEmail(lacStaffNurseDto.getEmail());
		user.setMobileNumber(lacStaffNurseDto.getContactNumber());
		user.setDivision(DivisionMapperUtil.mapToDivisionId(lacStaffNurseDto.getDivisionId()));
		user.setDesignationId(lacStaffNurseDto.getDesignationId());
		user.setIsActive(true);
		user.setIsDelete(false);
		return user;
	}

	public static UserMaster mapToUserMasterForLacAlternatePerson(LacUserDto lacAlternatePersonDto, UserMaster user) {
		UserRoleMapping userRoleMapping = user.getUserRoleMappings().iterator().next();
		Role role = new Role();
		role.setId(lacAlternatePersonDto.getRoleId());
		userRoleMapping.setRole(role);
		Set<UserRoleMapping> userRoleMappings = new HashSet<>();
		userRoleMappings.add(userRoleMapping);
		FacilityType facilityType = new FacilityType();
		facilityType = FacilityTypeMapperUtil.maptoFacilityTypeId(17l);
		user.setFacilityType(facilityType);
		user.setUserRoleMappings(userRoleMappings);
		user.setFirstname(lacAlternatePersonDto.getFirstName());
		user.setLastname(lacAlternatePersonDto.getLastName());
		user.setEmail(lacAlternatePersonDto.getEmail());
		user.setMobileNumber(lacAlternatePersonDto.getContactNumber());
		user.setDivision(DivisionMapperUtil.mapToDivisionId(lacAlternatePersonDto.getDivisionId()));
		user.setDesignationId(lacAlternatePersonDto.getDesignationId());
		user.setIsActive(true);
		user.setIsDelete(false);
		return user;
	}

	public static UserMasterDto mapToUserDto(UserMaster user) {
		UserMasterDto userDto = new UserMasterDto();
		if (user != null) {
			userDto.setId(user.getId());

		}
		return userDto;
	}

	public static List<UserDto> mapToUserDtoList(List<UserMaster> userList) {
		List<UserDto> userDtoList = new ArrayList<UserDto>();

		if (!CollectionUtils.isEmpty(userList)) {
			userList.forEach(user -> {
				UserDto userDto = new UserDto();
				userDto.setId(user.getId());
				userDto.setFirstName(user.getFirstname());
				userDto.setLastName(user.getLastname());
				userDto.setEmail(user.getEmail());
				userDto.setDesignation(user.getDesignationId());
				userDto.setLandline(user.getLandlineNumber());
				userDto.setMobileNumber(user.getMobileNumber());
				userDto.setStatus(String.valueOf(user.getStatus() != null ? user.getStatus().getId() : null));
				if (user.getCreatedTime() != null) {
					userDto.setCreatedTime(user.getCreatedTime());
				}
				userDto.setActive(user.getIsActive());
				userDto.setDelete(user.getIsDelete());
				userDto.setUsername(user.getUserAuths().getUsername());
				if (!CollectionUtils.isEmpty(user.getUserRoleMappings())) {
					List<RoleDto> RoleDtoSet = new ArrayList<RoleDto>();
					user.getUserRoleMappings().forEach(rm -> {
						if (rm.getIsActive() == Boolean.TRUE && rm.getIsDelete() == Boolean.FALSE) {
							RoleDto roleDto = new RoleDto();
							roleDto = RoleMapperUtil.mapToRoleDTO(rm.getRole());
							RoleDtoSet.add(roleDto);
						}
					});
					userDto.setRole(RoleDtoSet);
				}
				userDtoList.add(userDto);
			});
		}
		return userDtoList;
	}

	public static List<String> queryCreaterForUserAdvanceSearch(Map<String, String> searchValue,
			LoginResponseDto currentUser) {

		// Key is based on url name for each values
		String firstName = searchValue.get("firstname");
		String lastName = searchValue.get("lastname");
		String userName = searchValue.get("username");
		String mobileNumber = searchValue.get("mobilenumber");
		String email = searchValue.get("email");
		String role = searchValue.get("role");
		List<String> searchQueryAndCount = new ArrayList<>();

		if (currentUser != null && currentUser.getFacilityId() != null) {

			String searchQuery = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,"
					+ "u.mobile_number as mobile,ua.username as username,u.is_active as status,"
					+ "r.name as role from soch.user_master as u join soch.user_auth as ua on ua.user_id=u.id"
					+ " join soch.user_role_mapping as urm on urm.user_id=u.id"
					+ " join soch.role as r on r.id=urm.role_id where ";
			String actualCountQuery = "select count(DISTINCT u.id) from soch.user_master as u join soch.user_auth as ua on ua.user_id=u.id "
					+ "join soch.user_role_mapping as urm on urm.user_id=u.id "
					+ "join soch.role as r on r.id=urm.role_id where ";

			if (firstName != null && firstName != "") {
				searchQuery = searchQuery.concat("LOWER(u.firstname) LIKE LOWER('%" + firstName + "%') AND ");
				actualCountQuery = actualCountQuery.concat("LOWER(u.firstname) LIKE LOWER('%" + firstName + "%') AND ");
			}
			if (lastName != null && lastName != "") {
				searchQuery = searchQuery.concat("LOWER(u.lastname) LIKE LOWER('%" + lastName + "%') AND ");
				actualCountQuery = actualCountQuery.concat("LOWER(u.lastname) LIKE LOWER('%" + lastName + "%') AND ");
			}
			if (userName != null && userName != "") {
				searchQuery = searchQuery.concat("LOWER(ua.username) LIKE LOWER('%" + userName + "%') AND ");
				actualCountQuery = actualCountQuery.concat("LOWER(ua.username) LIKE LOWER('%" + userName + "%') AND ");
			}
			if (mobileNumber != null && mobileNumber != "") {
				searchQuery = searchQuery.concat("u.mobile_number LIKE '%" + mobileNumber + "%' AND ");
				actualCountQuery = actualCountQuery.concat("u.mobile_number LIKE '%" + mobileNumber + "%' AND ");
			}
			if (email != null && email != "") {
				searchQuery = searchQuery.concat("LOWER(u.email) LIKE LOWER('%" + email + "%') AND ");
				actualCountQuery = actualCountQuery.concat("LOWER(u.email) LIKE LOWER('%" + email + "%') AND ");
			}
			if (role != null && role != "") {
				searchQuery = searchQuery.concat("LOWER(r.name) LIKE LOWER('%" + role + "%') AND ");
				actualCountQuery = actualCountQuery.concat("LOWER(r.name) LIKE LOWER('%" + role + "%') AND ");
			}

			// For NACO level users they can search through all users
			if (currentUser.getFacilityTypeId() == FacilityTypeEnum.NACO.getFacilityType()) {
				searchQuery = searchQuery
						.concat("u.is_delete=false AND u.id!=" + currentUser.getUserId() + " order by u.id desc");
				actualCountQuery = actualCountQuery
						.concat("u.is_delete=false AND u.id!=" + currentUser.getUserId() + " ");
			} else {
				searchQuery = searchQuery.concat("u.is_delete=false AND u.facility_id=" + currentUser.getFacilityId()
						+ " AND u.id!=" + currentUser.getUserId() + " order by u.id desc");
				actualCountQuery = actualCountQuery.concat("u.is_delete=false AND u.facility_id="
						+ currentUser.getFacilityId() + " AND u.id!=" + currentUser.getUserId() + " ");
			}
			searchQueryAndCount.add(searchQuery);
			searchQueryAndCount.add(actualCountQuery);
		}

		return searchQueryAndCount;
	}

	/**
	 * @param userList
	 * @return
	 */
	public static List<FacilityUserDto> mapUserListToFacilityUserDtoList(List<UserMaster> userList) {
		List<FacilityUserDto> facilityUserDtos = new ArrayList<>();
		String name = "";
		if (!userList.isEmpty()) {
			for (UserMaster user : userList) {
				FacilityUserDto facilityUser = new FacilityUserDto();
				facilityUser.setId(user.getId());
				String lastname = "";
				if (user.getLastname() != null) {
					lastname = user.getLastname().trim();
				}
				name = user.getFirstname().trim() + " " + lastname;
				facilityUser.setName(name.trim());
				if (!user.getUserRoleMappings().isEmpty()) {
					UserRoleMapping roleMapping = user.getUserRoleMappings().stream().findFirst().get();
					if (roleMapping.getRole() != null) {
						facilityUser.setRole(roleMapping.getRole().getName());
						facilityUser.setRole_id(roleMapping.getRole().getId());
					}
				}
				facilityUserDtos.add(facilityUser);
			}
		}
		return facilityUserDtos;
	}

	public static List<UserMasterDto> mapUserListProjectionListToUserMasterDtoList(List<UserListProjection> userList) {
		List<UserMasterDto> list = new ArrayList<>();
		for (UserListProjection user : userList) {
			UserMasterDto userDto = new UserMasterDto();
			userDto.setId(user.getId());
			userDto.setFirstname(user.getFirstname());
			userDto.setLastname(user.getLastname());
			userDto.setUserName(user.getUsername());
			userDto.setEmail(user.getEmail());
			userDto.setRole(user.getRole());
			userDto.setMobileNumber(user.getMobile());
			userDto.setIsActive(user.getStatus());
			list.add(userDto);
		}
		return list;
	}

	public static List<UserMasterDto> mapUserListObjectToUserMasterDtoList(List<Object[]> userList) {
		List<UserMasterDto> list = userList.stream().map(object -> {
			UserMasterDto userDto = new UserMasterDto();
			userDto.setId(object[0] != null ? Long.valueOf(object[0].toString()) : null);
			userDto.setFirstname(object[1] != null ? object[1].toString() : null);
			userDto.setLastname(object[2] != null ? object[2].toString() : null);
			userDto.setEmail(object[3] != null ? object[3].toString() : null);
			userDto.setMobileNumber(object[4] != null ? object[4].toString() : null);
			userDto.setUserName(object[5] != null ? object[5].toString() : null);
			userDto.setIsActive(object[6] != null ? Boolean.valueOf(object[6].toString()) : null);
			userDto.setRole(object[7] != null ? object[7].toString() : null);
			return userDto;
		}).collect(Collectors.toList());
		return list;
	}

	public static List<UserBasicDto> mapBasicUserProjectionToUserBasicDto(
			List<UserBasicProjection> userProjectionList) {
		List<UserBasicDto> userList = new ArrayList<>();
		for (UserBasicProjection userProjection : userProjectionList) {
			UserBasicDto user = new UserBasicDto();
			user.setId(userProjection.getId() != null ? userProjection.getId() : null);
			user.setFirstname(userProjection.getFirstname() != null ? userProjection.getFirstname() : null);
			user.setLastname(userProjection.getLastname() != null ? userProjection.getLastname() : null);
			user.setUserName(userProjection.getUserName() != null ? userProjection.getUserName() : null);
			user.setDivisionId(userProjection.getDivisionId() != null ? userProjection.getDivisionId() : null);
			user.setRoleId(userProjection.getRoleId() != null ? userProjection.getRoleId() : null);
			user.setRoleName(userProjection.getRoleName() != null ? userProjection.getRoleName() : null);
			user.setPeCode(userProjection.getPeCode() != null ? userProjection.getPeCode() : null);
			user.setOrwCode(userProjection.getOrwCode() != null ? userProjection.getOrwCode() : null);
			user.setEmail(userProjection.getEmail() != null ? userProjection.getEmail() : null);
			user.setFacilityTypeId(
					userProjection.getFacilityTypeId() != null ? userProjection.getFacilityTypeId() : null);
			user.setTypologyId(userProjection.getTypologyId() != null ? userProjection.getTypologyId() : null);
			user.setIsTrained(userProjection.getIsTrained() != null ? userProjection.getIsTrained() : null);
			user.setMobileNumber(userProjection.getMobileNumber() != null ? userProjection.getMobileNumber() : null);
			user.setStatus(userProjection.getStatus() != null ? userProjection.getStatus() : null);
			user.setFacilityId(userProjection.getFacilityId() != null ? userProjection.getFacilityId() : null);
			user.setSmsEnabled(userProjection.getSmsEnabled() != null ? userProjection.getSmsEnabled() : null);
			user.setWhatsappEnabled(
					userProjection.getWhatsappEnabled() != null ? userProjection.getWhatsappEnabled() : null);
			user.setLastDateOfTraining(
					userProjection.getLastDateOfTraining() != null ? userProjection.getLastDateOfTraining() : null);
			user.setTypeOfTraining(
					userProjection.getTypeOfTraining() != null ? userProjection.getTypeOfTraining() : null);
			user.setIsActive(userProjection.getIsActive() != null ? userProjection.getIsActive() : null);
			userList.add(user);
		}
		return userList;
	}
}
