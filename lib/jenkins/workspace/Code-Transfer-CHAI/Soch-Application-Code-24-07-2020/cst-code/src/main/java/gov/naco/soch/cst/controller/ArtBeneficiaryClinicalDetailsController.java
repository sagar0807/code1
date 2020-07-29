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

import gov.naco.soch.cst.dto.ArtBeneficiaryClinicalDetailsDto;
import gov.naco.soch.cst.service.ArtBeneficiaryClinicalDetailsService;

@RestController
@RequestMapping("/clinicaldetails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryClinicalDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryClinicalDetailsController.class);

	@Autowired
	private ArtBeneficiaryClinicalDetailsService clinicalService;

	@GetMapping("{beneficiaryId}")
	public @ResponseBody ArtBeneficiaryClinicalDetailsDto getBeneficiaryClinicalDetailsForToday(
			@PathVariable("beneficiaryId") Long beneficiaryId) {
		logger.info("getBeneficiaryClinicalDetailsForToday() invoked");
		return clinicalService.getBeneficiaryClinicalDetailsForToday(beneficiaryId);
	}

	@PostMapping("/save")
	public @ResponseBody ArtBeneficiaryClinicalDetailsDto saveBeneficiaryClinicalDetails(
			@RequestBody ArtBeneficiaryClinicalDetailsDto clinicalDetails) {
		logger.info("saveBeneficiaryClinicalDetails() invoked");
		return clinicalService.saveBeneficiaryClinicalDetails(clinicalDetails);
	}
}
