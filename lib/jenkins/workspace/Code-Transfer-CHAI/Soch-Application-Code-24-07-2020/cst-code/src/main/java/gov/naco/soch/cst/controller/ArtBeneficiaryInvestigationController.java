package gov.naco.soch.cst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiaryInvestigationDto;
import gov.naco.soch.cst.service.ArtBeneficiaryInvestigationService;

@RestController
@RequestMapping("/artbeneficiary/investigation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryInvestigationController {
	@Autowired
	private ArtBeneficiaryInvestigationService artBeneficiaryInvestigationService;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryController.class);

	@GetMapping("/visitId")
	public @ResponseBody Long getisitRegisterId(@RequestParam Long beneficiaryId) {
		logger.debug("*getAllInvestigationListByBeneficiary is invoked*");
		return artBeneficiaryInvestigationService.getVisitRegisterIdForTodayExist(beneficiaryId);
	}

	@PostMapping("/save")
	public ArtBeneficiaryInvestigationDto saveBeneficiaryInvestigation(
			@RequestBody ArtBeneficiaryInvestigationDto artBeneficiaryInvestigationDto) {
		logger.debug("saveBeneficiary method is invoked");
		return artBeneficiaryInvestigationService.saveInvestigation(artBeneficiaryInvestigationDto);

	}

	@GetMapping("/list")
	public @ResponseBody ArtBeneficiaryInvestigationDto getAllInvestigationListByBeneficiary(
			@RequestParam Long beneficiaryId) {
		logger.debug("*getAllInvestigationListByBeneficiary is invoked*");
		return artBeneficiaryInvestigationService.getAllInvestigationListByBeneficiary(beneficiaryId);
	}
}
