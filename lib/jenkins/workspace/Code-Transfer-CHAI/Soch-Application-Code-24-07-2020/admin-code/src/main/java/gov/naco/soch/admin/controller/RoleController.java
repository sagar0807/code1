package gov.naco.soch.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.RoleService;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.util.AccessCode;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleController {

	@Autowired
	private RoleService roleService;

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	// default constructor
	public RoleController() {
	}

	/**
	 * @param roleDto
	 * @return roleDto
	 */
	@PostMapping("/add")
	@PreAuthorize("hasAuthority('" + AccessCode.NACO_ROLE_CREATE + "')")
	public @ResponseBody RoleDto addRole(@Valid @RequestBody RoleDto roleDto) {
		logger.debug("addRole method called with parameters->{}", roleDto);
		roleService.addRole(roleDto);
		logger.debug("addRole method returns with parameters->{}", roleDto);
		return roleDto;
	}

	/**
	 * @return roleList
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('" + AccessCode.NACO_ROLE_VIEW + "')")
	public @ResponseBody List<RoleDto> getAllRoles() {
		logger.debug("getAllRoles method called");
		List<RoleDto> roleList = roleService.getAllRoles();
		return roleList;

	}

	/**
	 * @param id
	 * @return roleDto
	 */
	@PostMapping("/delete/{id}")
	public boolean deleteRole(@PathVariable("id") Long id) {
		logger.debug("deleteRole method called with parameters->{}", id);
		return roleService.deleteRole(id);
	}

	/**
	 * @param facilityTypeId
	 * @return roleDto
	 */
	@GetMapping("/facilitytype/{facilityTypeId}")
	public @ResponseBody List<RoleDto> getFacilityTypeRoles(@PathVariable("facilityTypeId") Long facilityTypeId) {
		logger.debug("getFacilityTypeRoles method called with parameters->{}", facilityTypeId);
		List<RoleDto> roleDtoList = roleService.getFacilityTypeRoles(facilityTypeId);
		logger.debug("getFacilityTypeRoles method returns with parameters->{}", roleDtoList);
		return roleDtoList;
	}

	@GetMapping("/primary/facilitytype/{facilityTypeId}")
	public @ResponseBody List<RoleDto> getFacilityTypePrimaryRoles(
			@PathVariable("facilityTypeId") Long facilityTypeId) {
		List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
		roleDtoList = roleService.getFacilityTypePrimaryRoles(facilityTypeId);

		return roleDtoList;

	}

	@GetMapping("/nonprimary/facilitytype/{facilityTypeId}")
	public @ResponseBody List<RoleDto> getFacilityTypeNonPrimaryRoles(
			@PathVariable("facilityTypeId") Long facilityTypeId) {
		List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
		roleDtoList = roleService.getFacilityTypeNonPrimaryRoles(facilityTypeId);
		return roleDtoList;

	}

	/**
	 * role advance search with criteria: facilityType, name, primary
	 * 
	 * @param searchValue
	 * @return
	 */
	@GetMapping("/advancesearch")
	@PreAuthorize("hasAuthority('" + AccessCode.NACO_ROLE_VIEW + "')")
	public @ResponseBody List<RoleDto> roleAdvanceSearch(@RequestParam Map<String, String> searchValue) {
		logger.debug("roleAdvanceSearch() method called");
		List<RoleDto> roleList = roleService.roleAdvanceSearch(searchValue);
		return roleList;

	}

}
