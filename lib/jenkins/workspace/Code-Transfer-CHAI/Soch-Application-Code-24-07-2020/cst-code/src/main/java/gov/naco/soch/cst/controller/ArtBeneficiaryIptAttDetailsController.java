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

import gov.naco.soch.cst.dto.ArtBeneficiaryIptAttDetailsDto;
import gov.naco.soch.cst.service.ArtBeneficiaryIptAttDetailService;

@RestController
@RequestMapping("/iptattdetails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryIptAttDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryIptAttDetailsController.class);
	
	@Autowired
	private ArtBeneficiaryIptAttDetailService artBeneficiaryIptAttDetailService;
	
	@PostMapping("/save")
	public @ResponseBody ArtBeneficiaryIptAttDetailsDto saveBeneficiaryIPTATTDetails(@RequestBody ArtBeneficiaryIptAttDetailsDto artBeneficiaryIPTATTDetailsDto) {
		logger.info("saveBeneficiaryIPTATTDetails() invoked");
		return artBeneficiaryIptAttDetailService.saveBeneficiaryIPTATTDetails(artBeneficiaryIPTATTDetailsDto);
	}
	
	@GetMapping("/get")
	public @ResponseBody ArtBeneficiaryIptAttDetailsDto getBeneficiaryIptAttDetailsForToday(
			@RequestParam("beneficiaryId") Long beneficiaryId) {
		return artBeneficiaryIptAttDetailService.getBeneficiaryIptAttDetailsForToday(beneficiaryId);
	}

}
