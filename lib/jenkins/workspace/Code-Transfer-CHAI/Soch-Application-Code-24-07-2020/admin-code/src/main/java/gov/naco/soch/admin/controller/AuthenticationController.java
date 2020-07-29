package gov.naco.soch.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.AuthenticationService;
import gov.naco.soch.admin.service.SSOAuthService;
import gov.naco.soch.admin.service.CommonAdminService;
import gov.naco.soch.constant.SSOAuthConstants;
import gov.naco.soch.dto.LoginRequest;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.SSOResponseDto;
import gov.naco.soch.security.JwtTokenUtil;
import gov.naco.soch.security.UserAuthenticationToken;
import gov.naco.soch.util.CommonConstants;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationService authService;

	@Autowired
	SSOAuthService ssoAuthService;
	@Autowired
	Environment environment;

	@Autowired
	private CommonAdminService systemService;

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponseDto login(@RequestBody LoginRequest loginUser) {
		if (loginUser.getUsername() != null) {
			loginUser.setUsername(loginUser.getUsername().trim());
		}
		logger.info("Autentication started for the loginUser.getUserName->{}:", loginUser.getUsername());
		LoginResponseDto user = authService.findLoginUserDetails(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);

		authenticate(user.getUserId(), user.getUserName(), loginUser.getPassword(), token, user.getAccessCodes());

		user.setToken(token);
		authService.setLoginTimeAndToken(user);

		// To set SSO session ID -[START]
		try {
			if (Arrays.stream(environment.getActiveProfiles())
					.anyMatch(env -> (!env.equalsIgnoreCase("performance")))) {
				SSOResponseDto ssoResponseDto = new SSOResponseDto();
				try {
					ssoResponseDto = ssoAuthService
							.registeruserForSSO(SSOAuthConstants.SSO_APP_NAME, user.getUserName()).getBody();
					if (ssoResponseDto.getId() != null && !ssoResponseDto.getId().isEmpty()) {
						user.setSsoSessionId(ssoResponseDto.getId());
					}
					// END
				} catch (Exception e) {
					return user;
				}
			}
		} catch (Exception e) {
			return user;
		}

		return user;
	}

	@RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
	public LoginResponseDto refreshToken(HttpServletRequest request, HttpServletResponse response) {

		String token = jwtTokenUtil.getTokenFromHeader(request.getHeader(CommonConstants.HEADER_STRING));
		LoginResponseDto user = authService.getLoginUserDetailsFromToken(token);
		final String newToken = jwtTokenUtil.generateToken(user);
		user.setToken(newToken);
		return user;
	}

	private void authenticate(Long userId, String username, String password, String token, List<String> accessCodes) {

		List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();
		if (accessCodes != null && !accessCodes.isEmpty()) {
			authorityList = accessCodes.stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
		}
		UsernamePasswordAuthenticationToken authentication = new UserAuthenticationToken(username, password, userId,
				token, authorityList);
		authenticationManager.authenticate(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	// To Test rempoved once tested.
	@DeleteMapping("/delete/sid/{sessionId}")
	public ResponseEntity<Boolean> deleteRegisteredSession(@PathVariable("sessionId") String sessionId) {
		Boolean isDeleted = true;
		try {
			isDeleted = ssoAuthService.deleteRegisteredSession(sessionId);
		} catch (Exception e) {
			isDeleted = false;
		}
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}

}
