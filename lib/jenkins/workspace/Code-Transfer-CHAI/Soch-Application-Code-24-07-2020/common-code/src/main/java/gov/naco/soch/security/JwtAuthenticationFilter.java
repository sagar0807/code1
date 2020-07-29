package gov.naco.soch.security;

import static gov.naco.soch.util.CommonConstants.HEADER_STRING;
import static gov.naco.soch.util.CommonConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.exception.ServiceAuthException;
import gov.naco.soch.repository.UserAuthRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserAuthRepository userAuthRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		try {
			String header = req.getHeader(HEADER_STRING);
			List<String> detailsSimplified = new ArrayList<String>();
			ErrorResponse errorResponse = new ErrorResponse();
			String username = null;
			String authToken = null;

			if (req.getRequestURI().contains("auth/login") || req.getRequestURI().contains("auth/delete/sid")
					|| req.getRequestURI().contains("system/details")
					|| req.getRequestURI().contains("system/clearCache") || req.getRequestURI().contains("mhl")) {
				logger.info("No need to validate token as URL is in safe list");
				chain.doFilter(req, res);
			} else {
				if (header != null && header.startsWith(TOKEN_PREFIX)) {
					authToken = jwtTokenUtil.getTokenFromHeader(header);
					try {
						username = jwtTokenUtil.getUsernameFromToken(authToken);
					} catch (IllegalArgumentException e) {
						logger.error("An error occured during getting username from token", e);
						detailsSimplified.add(e.getMessage());
						errorResponse.setMessage("An error occured during getting username from token");
						errorResponse.setDetailsSimplified(detailsSimplified);
						res.setStatus(HttpStatus.UNAUTHORIZED.value());
						res.setContentType(MediaType.APPLICATION_JSON_VALUE);
						res.getWriter().write(convertObjectToJson(errorResponse));
						return;
					} catch (ExpiredJwtException e) {
						logger.warn("The token is expired and not valid anymore", e);
						detailsSimplified.add(e.getMessage());
						errorResponse.setMessage("The token is expired and not valid anymore");
						errorResponse.setDetailsSimplified(detailsSimplified);
						res.setStatus(HttpStatus.UNAUTHORIZED.value());
						res.setContentType(MediaType.APPLICATION_JSON_VALUE);
						res.getWriter().write(convertObjectToJson(errorResponse));
						return;
					} catch (SignatureException e) {
						logger.error("Authentication Failed. Invalid token!!");
						detailsSimplified.add(e.getMessage());
						errorResponse.setMessage("Authentication Failed. Invalid token!!");
						errorResponse.setDetailsSimplified(detailsSimplified);
						res.setStatus(HttpStatus.UNAUTHORIZED.value());
						res.setContentType(MediaType.APPLICATION_JSON_VALUE);
						res.getWriter().write(convertObjectToJson(errorResponse));
						return;
					}
				} else {
					logger.warn("couldn't find bearer string, will ignore the header");
//				detailsSimplified.add("No auth token found in request header");
//				errorResponse.setMessage("Couldn't find bearer string. Please provide the auth token");
//				errorResponse.setDetailsSimplified(detailsSimplified);
//				res.setStatus(HttpStatus.UNAUTHORIZED.value());
//				res.setContentType(MediaType.APPLICATION_JSON_VALUE);
//				res.getWriter().write(convertObjectToJson(errorResponse));
//				return;

					logger.error("Authentication Failed. No token!!");
					detailsSimplified.add("Authentication Failed. No token!!");
					errorResponse.setMessage("Authentication Failed. Invalid token!!");
					errorResponse.setDetailsSimplified(detailsSimplified);
					res.setStatus(HttpStatus.UNAUTHORIZED.value());
					res.setContentType(MediaType.APPLICATION_JSON_VALUE);
					res.getWriter().write(convertObjectToJson(errorResponse));
					return;

				}
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					if (jwtTokenUtil.validateToken(authToken)) {
						List<String> accessCodes = (List<String>) jwtTokenUtil.getClaimsFromToken(authToken)
								.get("accessCodes");
						Long userId = ((Integer) jwtTokenUtil.getClaimsFromToken(authToken).get("userId")).longValue();

						String activeKey = (String) jwtTokenUtil.getClaimsFromToken(authToken).get("activeKey");

						String activeToken = userAuthRepository.findActiveTokenByUserId(userId);
						
						  if (activeKey != null && !StringUtils.isBlank(activeToken) &&
						  activeKey.contentEquals(activeToken)) {
						 
							List<SimpleGrantedAuthority> authorityList = accessCodes.stream()
									.map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());

							UsernamePasswordAuthenticationToken authentication = new UserAuthenticationToken(username,
									null, userId, authToken, authorityList);
							authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
							logger.info("authenticated user " + username + ", setting security context");
							SecurityContextHolder.setStrategyName("MODE_INHERITABLETHREADLOCAL");
							SecurityContextHolder.getContext().setAuthentication(authentication);
						} else {
							throw new ServiceAuthException("Unauthorised access or Session Ended");
						}
					}
				}

				chain.doFilter(req, res);
			}

		} catch (RuntimeException e) {
			res.setStatus(HttpStatus.UNAUTHORIZED.value());
			res.getWriter().write(e.getMessage());
		}
	}

	private String convertObjectToJson(Object object) throws JsonProcessingException {
		if (object == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

}