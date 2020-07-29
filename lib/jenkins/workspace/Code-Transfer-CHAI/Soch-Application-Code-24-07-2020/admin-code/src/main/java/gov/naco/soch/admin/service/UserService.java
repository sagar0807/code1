package gov.naco.soch.admin.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gov.naco.soch.admin.controller.UserController;
import gov.naco.soch.admin.dto.UserSearchResponseDto;
import gov.naco.soch.criteria.SearchCriteria;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.FacilityUserDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.dto.UserAuthDto;
import gov.naco.soch.dto.UserDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.Role;
import gov.naco.soch.entity.TypologyMaster;
import gov.naco.soch.entity.UserAuth;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.entity.UserRoleMapping;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.enums.RoleEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.AccessSettingsMapper;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.mapper.UserMapperUtil;
import gov.naco.soch.projection.UserListProjection;
import gov.naco.soch.repository.DivisionRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityTypeRepository;
import gov.naco.soch.repository.RoleRepository;
import gov.naco.soch.repository.TypologyRepository;
import gov.naco.soch.repository.UserAuthRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.repository.UserRoleMappingRepository;
import gov.naco.soch.specifications.UserSpecification;
import gov.naco.soch.util.CommonConstants;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserMasterRepository userRepository;

	@Autowired
	private UserRoleMappingRepository userRoleMappingRepository;

	@Autowired
	private UserAuthRepository userAuthRepository;

	@Autowired
	private DivisionRepository divisionRepository;

	@Autowired
	private FacilityTypeRepository facilityTypeRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TypologyRepository typologyRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

	// function to select all user details from database
	public UserSearchResponseDto getAllUsers(Integer pageNumber, Integer pageSize) {

		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		UserSearchResponseDto userResponse = new UserSearchResponseDto();
		List<UserListProjection> userList = new ArrayList<>();
		Page<UserListProjection> userPage = null;
		Optional<List> userListOptional = null;
		int userCount = 0;

		if (currentUser != null && currentUser.getFacilityId() != null) {
			if (currentUser.getFacilityTypeId() == FacilityTypeEnum.NACO.getFacilityType()) {
				userCount = userRepository.findCountOfTotalRecord(currentUser.getUserId());
				userPage = userRepository.findAllUserList(currentUser.getUserId(), pageable);
				userListOptional = Optional.ofNullable(userPage.getContent());
			} else {
				userCount = userRepository.findCountOfTotalRecord(currentUser.getUserId(), currentUser.getFacilityId());
				userPage = userRepository.findAllUserList(currentUser.getUserId(), currentUser.getFacilityId(),
						pageable);
				userListOptional = Optional.ofNullable(userPage.getContent());
			}
		}
		if (userListOptional.isPresent()) {
			userList = userListOptional.get();
		}
		List<UserMasterDto> userMasterDtos = UserMapperUtil.mapUserListProjectionListToUserMasterDtoList(userList);
		Collections.sort(userMasterDtos, Collections.reverseOrder());
		userResponse.setActualRecordCount(userCount);
		userResponse.setGivenRecordCount(userMasterDtos.size());
		userResponse.setUserMasterList(userMasterDtos);
		return userResponse;
	}

	public List<UserDto> getAllFacilityUsers(Long facilityId) {

		List<UserMaster> users = (List<UserMaster>) userRepository.findAllByFacilityIdAndIsDelete(facilityId,
				Boolean.FALSE);
		List<UserDto> userDtoList = UserMapperUtil.mapToUserDtoList(users);
		Collections.sort(userDtoList);
		return userDtoList;
	}

	// function to add user details to database

	public UserMasterDto saveUser(UserMasterDto userMasterDto) {
		userMasterDto.setEmail(userMasterDto.getEmail() != null ? userMasterDto.getEmail().toLowerCase() : null);
		userMasterDto.setUserName(userMasterDto.getUserName() != null ? userMasterDto.getUserName().trim() : null);
		UserMaster user = new UserMaster();
		UserAuth userAuth = new UserAuth();
		String password = null;
		userMasterDto.setIsDelete(false);

		user = UserMapperUtil.mapToUserMaster(userMasterDto);

		boolean isEdit = false;

		int count = userAuthRepository.existsByUsernameIgnoreCase(userMasterDto.getUserName());

		if (userMasterDto.getId() != null && userMasterDto.getId() != 0) {
			isEdit = true;
			if (count == 0) {
				userRepository.save(user);
			} else {
				Optional<UserMaster> userMaster = userRepository.findById(user.getId());
				user = UserMapperUtil.mapToUserMaster(userMasterDto, userMaster.get());

			}
		} else {
			isEdit = false;
			if (count != 0) {
				String errorfield = "username";
				throwError(errorfield, userMasterDto.getUserName());
			}

		}
		if (user.getId() == null) {
			userAuth = UserMapperUtil.mapToUserAuth(userMasterDto);
			password = userMasterDto.getPassword();
			userAuth.setUserMaster(user);
			user.setUserAuths(userAuth);
		}
		try {
			Optional<Facility> facility = facilityRepository.findById(userMasterDto.getFacilityId());
			user.setFacility(facility.get());
		} catch (NoSuchElementException e) {
			List<ErrorDto> errorDtoList = new ArrayList<>();
			List<String> detailsSimplified = new ArrayList<String>();

			ErrorDto errorDto = new ErrorDto();
			errorDto.setDescription("Facility does not exist");
			errorDtoList.add(errorDto);
			detailsSimplified.add(errorDto.getDescription());
			ErrorResponse errorResponse = new ErrorResponse("Validation Failed", errorDtoList, detailsSimplified);
			throw new ServiceException("Facility does not exist", errorResponse, HttpStatus.BAD_REQUEST);
		}

		Optional<Division> division = divisionRepository.findById(userMasterDto.getDivisionId());
		user.setDivision(division.get());

		Optional<FacilityType> facilityType = facilityTypeRepository.findById(userMasterDto.getFacilityTypeId());
		user.setFacilityType(facilityType.get());

		Set<UserRoleMapping> userRoleMappingSet = new HashSet<UserRoleMapping>();
		List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
		roleDtoList = userMasterDto.getRoleDto();

		UserMaster userEntity = userRepository.save(user);

		if (isEdit) {
			userRoleMappingRepository.deleteByUserMasterId(userMasterDto.getId());
		}
		boolean isPe = false;
		boolean isOrw = false;
		for (RoleDto roleDto : roleDtoList) {
			Optional<Role> role = roleRepository.findById(roleDto.getId());
			UserRoleMapping userRoleMapping = new UserRoleMapping();
			userRoleMapping.setCreatedBy(userEntity.getCreatedBy());
			userRoleMapping.setCreatedTime(userEntity.getCreatedTime());
			userRoleMapping.setModifiedBy(userEntity.getModifiedBy());
			userRoleMapping.setModifiedTime(userEntity.getModifiedTime());
			userRoleMapping.setIsActive(userEntity.getIsActive());
			userRoleMapping.setIsDelete(userEntity.getIsDelete());
			userRoleMapping.setRole(role.get());
			userRoleMapping.setUserMaster(userEntity);
			userRoleMappingSet.add(userRoleMapping);
			isPe = AccessSettingsMapper.findIsPeFromAccessSettings(role.get(), isPe);
			isOrw = AccessSettingsMapper.findIsOrwFromAccessSettings(role.get(), isOrw);
		}
		userRoleMappingRepository.saveAll(userRoleMappingSet);
		Optional<TypologyMaster> typology = null;
		if (userMasterDto.getTypologyId()!=null) {
			typology = typologyRepository.findById(userMasterDto.getTypologyId());
		}

		if (isPe) {
			DecimalFormat df = new DecimalFormat("0000");
			String peCode = "PE" + df.format(userEntity.getId());
			userEntity.setPeCode(peCode);
			if (typology!=null) {
				userEntity.setTypology(typology.get());
			}
			userRepository.save(userEntity);
		}
		if (isOrw) {
			DecimalFormat df = new DecimalFormat("0000");
			String orwCode = "ORW" + df.format(userEntity.getId());
			userEntity.setOrwCode(orwCode);
			if (typology!=null) {
				userEntity.setTypology(typology.get());
			}
			userRepository.save(userEntity);
		}
		userEntity.setUserRoleMappings(userRoleMappingSet);
		userMasterDto = UserMapperUtil.mapToUserMasterDto(userEntity);
		userMasterDto.setPassword(password);
		return userMasterDto;
	}

	/*
	 * public UserMasterDto prepareRegistrationDetailsForSavedUser(UserMasterDto
	 * userMasterDto) { String password =
	 * UserMapperUtil.generateUserPassword(userMasterDto.getUserName());
	 * userMasterDto.setPassword(password); return userMasterDto;
	 * 
	 * }
	 */

	// function to delete user details from database
	public String deleteUser(Long userId) {
		Optional<UserMaster> userMaster = userRepository.findById(userId);
		Optional<UserAuth> userAuthMaster = userAuthRepository.findById(userId);
		UserAuth userAuth = userAuthMaster.get();
		UserMaster user = userMaster.get();
		user.setIsDelete(true);
		userAuth.setIsDelete(true);
		userRepository.save(user);
		userAuthRepository.save(userAuth);
		if (!user.getUserRoleMappings().isEmpty()) {
			Set<UserRoleMapping> mappings = user.getUserRoleMappings();
			mappings.forEach(action -> {
				action.setIsDelete(Boolean.TRUE);
			});
			userRoleMappingRepository.saveAll(mappings);
		}
		return userMaster.get().getFirstname();
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

	public Set<UserMasterDto> searchAllUsers(List<SearchCriteria> searchCriteria) {
		UserSpecification userSpecification = new UserSpecification(new SearchCriteria("is_delete", "=", "false"));
		// int counter=0;
		// Specification.where(userSpecification);
		// for (SearchCriteria tempCriteria : searchCriteria) {
		// UserSpecification temp= new UserSpecification(new
		// SearchCriteria(tempCriteria.getKey(), ":", tempCriteria.getValue()));
		// if(counter==0) {
		// Specification.and(temp);
		// }else {
		//
		// }
		// counter++;
		// }

		// UserSpecification spec= new UserSpecification(new
		// SearchCriteria(searchCriteria.getKey(), ":", searchCriteria.getValue()));
		// System.out.println(spec.toString());
		List<UserMaster> users = (List<UserMaster>) userRepository.findAll();
		return UserMapperUtil.mapToUserMasterDtoSet(users);
	}

	public UserMasterDto getUserIdByName(String name) {
		UserMaster user = new UserMaster();
		UserMasterDto userDto = new UserMasterDto();
		user = userRepository.findByName(name);
		userDto = UserMapperUtil.mapToUserDto(user);
		return userDto;

	}

	public UserMasterDto getUserProfileInfoById(Long id) {
		UserMaster userMaster = userRepository.findByUserId(id);
		UserMasterDto userDto = new UserMasterDto();
		userDto = UserMapperUtil.mapToUserMasterDto(userMaster);
		return userDto;
	}

	public UserMasterDto updateUserProfile(@Valid UserMasterDto userDto) {
		UserMaster userMaster = new UserMaster();
		userMaster = userRepository.findById(userDto.getId()).get();
		userMaster = UserMapperUtil.mapToUserMasterForUpdateProfile(userDto, userMaster);
		userMaster = userRepository.save(userMaster);
		return userDto;
	}

	public UserAuthDto updateUserPassword(@Valid UserAuthDto userDto) {

		UserAuth user = userAuthRepository.findUserAuthByUserId(userDto.getId());
		String existingPswd = user.getPassword();
		String newPswd = userDto.getPassword();

		// Checking entered current password and password in db is equal or not
		if (userDto.getCurrentPassword() == null
				|| !bcryptEncoder.matches(userDto.getCurrentPassword(), existingPswd)) {
			throw new ServiceException("Incorrect current password", null, HttpStatus.CONFLICT);
		}

		// Checking entered New password and password in db is equal or not
		if (!bcryptEncoder.matches(newPswd, existingPswd)) {
			user.setPassword(bcryptEncoder.encode(newPswd));
			userAuthRepository.save(user);
		} else {
			throw new ServiceException("New password same as old password. Please enter a new one.", null,
					HttpStatus.CONFLICT);
		}
		return userDto;
	}

	/**
	 * Noral Search in User List
	 * 
	 * @param searchValue
	 * @return
	 */
	public UserSearchResponseDto getUserListByNormalSearch(String searchValue, Integer pageNumber, Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		// Getting current login user details
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		UserSearchResponseDto searchResponse = new UserSearchResponseDto();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
		List<UserListProjection> userList = new ArrayList<>();
		Page<UserListProjection> userPage = null;
		Optional<List> userListOptional = null;
		searchValue = '%' + searchValue.trim() + '%';
		int actualRecordCount = 0;

		if (currentUser != null && currentUser.getFacilityId() != null) {
			if (currentUser.getFacilityTypeId() == FacilityTypeEnum.NACO.getFacilityType()) {
				actualRecordCount = userRepository.userNormalSearchActualRecordCount(searchValue,
						currentUser.getUserId());
				userPage = userRepository.userNormalSearch(searchValue, currentUser.getUserId(), pageable);
				userListOptional = Optional.ofNullable(userPage.getContent());
			} else {
				actualRecordCount = userRepository.userNormalSearchBasedOnFacilityActualRecordCount(searchValue,
						currentUser.getFacilityId(), currentUser.getUserId());
				userPage = userRepository.userNormalSearchBasedOnFacility(searchValue, currentUser.getFacilityId(),
						currentUser.getUserId(), pageable);
				userListOptional = Optional.ofNullable(userPage.getContent());

			}
		}
		if (userListOptional.isPresent()) {
			userList = userListOptional.get();
		}
		List<UserMasterDto> userMasterDtos = UserMapperUtil.mapUserListProjectionListToUserMasterDtoList(userList);
		Collections.sort(userMasterDtos, Collections.reverseOrder());
		searchResponse.setActualRecordCount(actualRecordCount);
		searchResponse.setGivenRecordCount(userList.size());
		searchResponse.setUserMasterList(userMasterDtos);
		return searchResponse;
	}

	public UserSearchResponseDto getUserListByAdvancedSearch(Map<String, String> searchValue, Integer pageNumber,
			Integer pageSize) {
		if (pageNumber == null || pageSize == null) {
			pageNumber = 0;
			pageSize = 1000;
		}
		// Getting current login user details
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		UserSearchResponseDto searchResponse = new UserSearchResponseDto();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<Object[]> userList = new ArrayList<>();
		int actualRecordCount = 0;
		List<String> searchAndActualCountQueries = UserMapperUtil.queryCreaterForUserAdvanceSearch(searchValue,
				currentUser);
		if (!searchAndActualCountQueries.isEmpty()) {
			userList = userRepository.userAdvanceSearch(searchAndActualCountQueries.get(0), pageable);
			actualRecordCount = userRepository.actualCount(searchAndActualCountQueries.get(1));
		}
		List<UserMasterDto> userMasterDtos = UserMapperUtil.mapUserListObjectToUserMasterDtoList(userList);
		Collections.sort(userMasterDtos, Collections.reverseOrder());
		searchResponse.setActualRecordCount(actualRecordCount);
		searchResponse.setGivenRecordCount(userList.size());
		searchResponse.setUserMasterList(userMasterDtos);
		return searchResponse;
	}

	/**
	 * Fetch all Users list for current log in facility
	 * 
	 * @return
	 */
	public List<FacilityUserDto> getUserListForCurrentFacility() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<UserMaster> userList = userRepository.findAllByFacilityIdAndIsDelete(currentUser.getFacilityId(),
				Boolean.FALSE);
		List<FacilityUserDto> facilityUserList = UserMapperUtil.mapUserListToFacilityUserDtoList(userList);
		facilityUserList = facilityUserList.stream()
				.filter(user -> user.getRole_id() != RoleEnum.ART_DATA_MANAGER.getRole()
						&& user.getRole_id() != RoleEnum.SACEP_COORDINATOR.getRole())
				.collect(Collectors.toList());
		return facilityUserList;
	}

	public UserMasterDto getUserByUserId(Long userId) {
		Optional<UserMaster> userOpt = userRepository.findById(userId);
		UserMasterDto userDto = new UserMasterDto();
		if (userOpt.isPresent()) {
			userDto = UserMapperUtil.mapToUserMasterDto(userOpt.get());
		}
		return userDto;
	}

	public boolean resetPassword(String userName) {
		UserAuth user = userAuthRepository.findByUserName(userName);
		String newPassword = "";
		boolean result = false;	
    	newPassword = UserMapperUtil.generateUserPassword(userName);
    	newPassword = UserMapperUtil.encryptPassword(newPassword);
		user.setPassword(newPassword);
		try {
		userAuthRepository.save(user);
		result = true;
		}
		catch (Exception e) {
			result = false;
		}
		return result;
	}
}
