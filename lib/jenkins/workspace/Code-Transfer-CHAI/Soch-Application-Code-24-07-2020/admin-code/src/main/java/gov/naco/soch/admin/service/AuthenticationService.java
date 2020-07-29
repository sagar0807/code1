package gov.naco.soch.admin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.MenuItemDto;
import gov.naco.soch.entity.MenuMaster;
import gov.naco.soch.entity.UserAuth;
import gov.naco.soch.projection.UserDetailsProjection;
import gov.naco.soch.projection.UserRoleAccessProjection;
import gov.naco.soch.repository.MenuMasterRepository;
import gov.naco.soch.repository.UserAuthRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.security.JwtTokenUtil;
import gov.naco.soch.security.UserAuthenticationToken;
import io.jsonwebtoken.Claims;

@Service
@Transactional
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserMasterRepository userRepository;

	@Autowired
	private UserAuthRepository userAuthRepository;

	@Autowired
	private MenuMasterRepository menuMasterRepository;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

	private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

	public LoginResponseDto findLoginUserDetails(String username) {
		logger.debug("findLoginUserDetails:Going to fetch the user details for username->{}:", username);
		LoginResponseDto loginUserDetails = new LoginResponseDto();
		loginUserDetails.setUserName(username);
		List<UserDetailsProjection> userDetailList = userRepository.findUserDetails(username);
		logger.debug("User details fetched for username->{}:", username);
		if (!userDetailList.isEmpty()) {
			UserDetailsProjection userDetails = userDetailList.get(0);
			logger.debug("User details fetched for username->{}:userDetailList.get(0)->{}:", username, userDetails);
			Long userId = userDetails.getUserId();
			loginUserDetails.setUserId(userDetails.getUserId());
			loginUserDetails.setFirstname(userDetails.getFirstname());
			loginUserDetails.setLastname(userDetails.getLastname());
			loginUserDetails.setDivisionId(userDetails.getDivisionId());
			loginUserDetails.setFacilityTypeId(userDetails.getFacilityTypeId());
			loginUserDetails.setFacilityId(userDetails.getFacilityId());
			loginUserDetails.setFacilityName(userDetails.getFacilityName());
			loginUserDetails.setFacilityCode(userDetails.getFacilityCode());
			loginUserDetails.setDesignationId(userDetails.getDesignationId());
			loginUserDetails.setDesignation(userDetails.getDesignation());
			loginUserDetails.setUserName(userDetails.getUsername());
			loginUserDetails.setRoleId(userDetails.getRoleId());
			loginUserDetails.setRoleName(userDetails.getRoleName());
			loginUserDetails.setLastLogin(userDetails.getLastLoginTime());
			loginUserDetails.setFacilityCbStatus(userDetails.getFacilityCbStatus());

			LocalDateTime loginTime = LocalDateTime.now();
			String activeKey = loginTime.toString() + new Random().nextInt(99999);
			System.out.println("Active Key : " + activeKey);

			loginUserDetails.setCurrentLoginTime(loginTime);
			loginUserDetails.setActiveToken(bcryptEncoder.encode(activeKey));

			logger.debug("loginUserDetails constructed->{}:", loginUserDetails);

			List<UserRoleAccessProjection> userRoleAccessList = getUserRoleAccessByUserId(userId);
			List<String> accessCodes = getUserRolesAccess(userRoleAccessList);
			logger.debug("accessCodes fetched for username->{}:accessCodes->{}:", username, accessCodes);
			loginUserDetails.setAccessCodes(accessCodes);
			List<MenuMaster> menuItems = getMenuItems(userRoleAccessList);
			List<MenuItemDto> menuItemsDto = menuItems.stream().map(m -> {
				MenuItemDto menuItemDto = new MenuItemDto();
				menuItemDto.setId(m.getId());
				menuItemDto.setMenu(m.getMenuName());
				menuItemDto.setRouterLink(m.getRouteLink());
				return menuItemDto;
			}).collect(Collectors.toList());
			loginUserDetails.setMenuItems(menuItemsDto);
		}
		logger.debug("findLoginUserDetails:Returning for username->{}:", username);
		return loginUserDetails;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDetailsProjection> userDetailList = userRepository.findUserDetails(username);
		if (userDetailList.isEmpty()) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		UserDetailsProjection userDetails = userDetailList.get(0);
		Long userId = userDetails.getUserId();
		List<UserRoleAccessProjection> userRoleAccessList = getUserRoleAccessByUserId(userId);
		List<String> accessCodes = getUserRolesAccess(userRoleAccessList);
		List<SimpleGrantedAuthority> authorityList = accessCodes.stream().map(r -> new SimpleGrantedAuthority(r))
				.collect(Collectors.toList());

		// password field to be set
		return new User(userDetails.getUsername(), userDetails.getPassword(), authorityList);
	}

	public LoginResponseDto getLoggedInUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((UserAuthenticationToken) authentication).getName();
		return findLoginUserDetails(username);
	}

	public LoginResponseDto getLoginUserDetailsFromToken(String token) {

		LoginResponseDto loginUserDetails = new LoginResponseDto();
		String username = jwtTokenUtil.getUsernameFromToken(token);

		Claims tokenClaims = jwtTokenUtil.getClaimsFromToken(token);
		List<String> accessCodes = (List<String>) tokenClaims.get("accessCodes");
		Long userId = ((Integer) tokenClaims.get("userId")).longValue();
		String firstname = (String) tokenClaims.get("firstname");
		String lastname = (String) tokenClaims.get("lastname");
		Long roleId = ((Integer) tokenClaims.get("roleId")).longValue();
		String roleName = (String) tokenClaims.get("roleName");
		Long divisionId = ((Integer) tokenClaims.get("divisionId")).longValue();
		Long facilityTypeId = ((Integer) tokenClaims.get("facilityTypeId")).longValue();
		Optional<Integer> facilityIdOpt = Optional.ofNullable((Integer) tokenClaims.get("facilityId"));
		Long facilityId = facilityIdOpt.isPresent() ? facilityIdOpt.get().longValue() : null;
		Long designationId = ((Integer) tokenClaims.get("designationId")).longValue();
		String designation = ((String) tokenClaims.get("designation"));

		loginUserDetails.setUserId(userId);
		loginUserDetails.setFirstname(firstname);
		loginUserDetails.setLastname(lastname);
		loginUserDetails.setDivisionId(divisionId);
		loginUserDetails.setFacilityTypeId(facilityTypeId);
		loginUserDetails.setFacilityId(facilityId);
		loginUserDetails.setDesignationId(designationId);
		loginUserDetails.setDesignation(designation);
		loginUserDetails.setUserName(username);
		loginUserDetails.setRoleId(roleId);
		loginUserDetails.setRoleName(roleName);
		loginUserDetails.setAccessCodes(accessCodes);
		return loginUserDetails;
	}

	private List<MenuMaster> getMenuItems(List<UserRoleAccessProjection> userRoleAccessList) {
		List<String> accessCode = userRoleAccessList.stream().map(r -> r.getAccessCode()).collect(Collectors.toList());
		return menuMasterRepository.findMenuByAccessList(accessCode);
	}

	private List<UserRoleAccessProjection> getUserRoleAccessByUserId(Long userId) {
		return userRepository.getUserRoleAccessByUserId(userId);
	}

	private List<String> getUserRolesAccess(List<UserRoleAccessProjection> userRoleAccessList) {

		List<String> accessCodes = new ArrayList<>();

		if (!userRoleAccessList.isEmpty()) {
			accessCodes = userRoleAccessList.stream().map(UserRoleAccessProjection::getAccessCode)
					.collect(Collectors.toList());

		}

		return accessCodes;
	}

	public void setLoginTimeAndToken(LoginResponseDto user) {
		UserAuth userAuthDetails = userAuthRepository.findByUserMaster(user.getUserId());
		userAuthDetails.setLastLoginTime(user.getCurrentLoginTime());
		userAuthDetails.setActiveToken(user.getActiveToken());
		userAuthRepository.save(userAuthDetails);
	}
}
