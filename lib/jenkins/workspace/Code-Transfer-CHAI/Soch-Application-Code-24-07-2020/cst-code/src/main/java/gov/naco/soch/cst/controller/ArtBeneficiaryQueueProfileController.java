package gov.naco.soch.cst.controller;

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

import gov.naco.soch.cst.dto.ArtBeneficiaryQueueProfileDto;
import gov.naco.soch.cst.service.ArtBeneficiaryQueueProfileService;

/**
 * This is a controller class to handle the beneficiary profile related
 * operation while clicking profile from the beneficiary queue list screen.
 *
 */
@RestController
@RequestMapping("/beneficiaryqueueprofile")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryQueueProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueProfileController.class);

	@Autowired
	private ArtBeneficiaryQueueProfileService artBeneficiaryQueueProfileService;

	@GetMapping("/{beneficiaryId}")
	public @ResponseBody ArtBeneficiaryQueueProfileDto getBeneficiaryQueueProfile(
			@PathVariable("beneficiaryId") Long beneficiaryId) {

		logger.info("getBeneficiaryQueueProfile() invoked");
		return artBeneficiaryQueueProfileService.getBeneficiaryQueueProfile(beneficiaryId);
	}

	@PostMapping("/counsellor/save")
	public @ResponseBody ArtBeneficiaryQueueProfileDto saveBeneficiaryQueueProfileCounsellor(
			@RequestBody ArtBeneficiaryQueueProfileDto profileDetails) {

		logger.info("saveBeneficiaryQueueProfileCounsellor() invoked");
		return artBeneficiaryQueueProfileService.saveBeneficiaryQueueProfileCounsellor(profileDetails);
	}
	
	@PostMapping("/mo/save")
	public @ResponseBody ArtBeneficiaryQueueProfileDto saveBeneficiaryQueueProfileForMO(
			@RequestBody ArtBeneficiaryQueueProfileDto profileDetails) {

		logger.info("saveBeneficiaryQueueProfileForMO() invoked");
		return artBeneficiaryQueueProfileService.saveBeneficiaryQueueProfileForMO(profileDetails);
	}
}
