package gov.naco.soch.cst.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import gov.naco.soch.cst.dto.ArtBeneficiaryStaffNurseProfileDto;
import gov.naco.soch.cst.service.ArtBeneficiaryStaffNurseProfileService;
import gov.naco.soch.dto.MasterDto;

/**
 * This is a controller class to handle the staff nurse beneficiary profile related
 * operation while clicking profile from the beneficiary queue list screen in Staff nurse role.
 *
 */

@RestController
@RequestMapping("/beneficiaryStaffNurseProfile")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryStaffNurseProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueProfileController.class);
	
	@Autowired
	private ArtBeneficiaryStaffNurseProfileService artBeneficiaryStaffNurseProfileService;
	
	@GetMapping("/{beneficiaryId}")
	public @ResponseBody ArtBeneficiaryStaffNurseProfileDto getBeneficiaryStaffNurseProfile(
			@PathVariable("beneficiaryId") Long beneficiaryId) {
		logger.info("getBeneficiaryQueueProfile() invoked");
		return artBeneficiaryStaffNurseProfileService.getBeneficiaryStaffNurseProfile(beneficiaryId);
	}
	
	@PostMapping("/staffNurse/save")
	public @ResponseBody ArtBeneficiaryStaffNurseProfileDto saveBeneficiaryQueueProfileForStaffNurse(
			@RequestBody ArtBeneficiaryStaffNurseProfileDto profileDetails) {

		logger.info("saveBeneficiaryQueueProfileForStaffNurse() invoked");
		return artBeneficiaryStaffNurseProfileService.saveBeneficiaryQueueProfileForStaffNurse(profileDetails);
	}
	
	/*
	 * @GetMapping("/opportunisticInfection/{beneficiaryId}") public @ResponseBody
	 * List<ArtOpportunisticInfectionSummaryDto> getOpportunisticInfectionSummary(
	 * 
	 * @PathVariable("beneficiaryId") Long beneficiaryId) {
	 * logger.debug("Entering into method getGender"); return
	 * artBeneficiaryStaffNurseProfileService.getOpportunisticInfectionSummary(
	 * beneficiaryId); }
	 */
}
