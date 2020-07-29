package gov.naco.soch.cst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiaryQueueProfileDto;
import gov.naco.soch.cst.dto.CareCoordinationProfileDto;
import gov.naco.soch.cst.service.CareCoordinatorBeneficiaryProfileService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/careCoordinator")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CareCoordinatorBeneficiaryProfileController {
	private static final Logger logger = LoggerFactory.getLogger(CareCoordinatorBeneficiaryProfileController.class);

	@Autowired
	private CareCoordinatorBeneficiaryProfileService beneficiaryProfileService;

	@GetMapping("/{beneficiaryId}")
	public @ResponseBody CareCoordinationProfileDto getAllCareCoordinatorBeneficiaryProfile(
			@PathVariable("beneficiaryId") Long beneficiaryId) {
		logger.info("getAllCareCoordinatorBeneficiaryProfile() invoked");
		return beneficiaryProfileService.getAllCareCoordinatorBeneficiaryProfile(beneficiaryId);
	}

	@PostMapping("/save")
	public @ResponseBody CareCoordinationProfileDto saveBeneficiaryProfile(
			@RequestBody CareCoordinationProfileDto beneficiaryProfile) {
		logger.debug("saveBeneficiaryProfile method is invoked");
		return beneficiaryProfileService.saveBeneficiaryProfile(beneficiaryProfile);
	}

}
