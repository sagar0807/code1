package gov.naco.soch.cst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ProfileTableDataDto;
import gov.naco.soch.cst.dto.ProfileWidgetDashBoardDto;
import gov.naco.soch.cst.dto.StaffNurseProfileDataDto;
import gov.naco.soch.cst.service.MiniDashBoardProfileServie;

@RestController
@RequestMapping("/profiles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MiniDashBoardProfileController {
	@Autowired
	MiniDashBoardProfileServie dashBoardProfileServie;

	@GetMapping("/get/nonwidget/dashboard/{beneficairyId}/{facilityId}")
	public ResponseEntity<ProfileTableDataDto> getProfileNonWidgetDetails(
			@PathVariable("beneficairyId") Long beneficairyId, @PathVariable("facilityId") Long facilityId) {
		ProfileTableDataDto profileTableDataDto = new ProfileTableDataDto();
		try {
			profileTableDataDto = dashBoardProfileServie.getProfileNonWidgetDetails(beneficairyId,facilityId);
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ProfileTableDataDto>(profileTableDataDto, HttpStatus.OK);
	}

	@GetMapping("/get/dashboard/{beneficairyId}/{facilityId}")
	public ResponseEntity<ProfileWidgetDashBoardDto> getProfileWithWidgetDetails(
			@PathVariable("beneficairyId") Long beneficairyId, @PathVariable("facilityId") Long facilityId) {
		ProfileWidgetDashBoardDto profileWidgetDashBoardDto = new ProfileWidgetDashBoardDto();
		try {
			profileWidgetDashBoardDto = dashBoardProfileServie.getWidgetDashboardData(beneficairyId, facilityId);
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ProfileWidgetDashBoardDto>(profileWidgetDashBoardDto, HttpStatus.OK);
	}

	@GetMapping("/get/dashboard/staffnurse/{beneficairyId}/{facilityId}")
	public ResponseEntity<StaffNurseProfileDataDto> getProfileDataForStaffNurse(
			@PathVariable("beneficairyId") Long beneficairyId, @PathVariable("facilityId") Long facilityId) {
		StaffNurseProfileDataDto staffNurseProfileDataDto = new StaffNurseProfileDataDto();
		try {
			staffNurseProfileDataDto = dashBoardProfileServie.getProfileDataForStaffNurse(beneficairyId, facilityId);
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<StaffNurseProfileDataDto>(staffNurseProfileDataDto, HttpStatus.OK);
	}

}
