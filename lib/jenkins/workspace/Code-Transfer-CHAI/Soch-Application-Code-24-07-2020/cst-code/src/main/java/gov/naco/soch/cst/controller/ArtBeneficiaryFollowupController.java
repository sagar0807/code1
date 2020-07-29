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
import org.springframework.web.bind.annotation.RestController;
import gov.naco.soch.cst.dto.ARTCounsellorFollowUpDto;
import gov.naco.soch.cst.service.ArtBeneficiaryFollowupService;

@RestController
@RequestMapping("/followup")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryFollowupController {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryFollowupController.class);

	@Autowired
	private ArtBeneficiaryFollowupService artBeneficiaryFollowupService;

	@PostMapping("/save")
	public ARTCounsellorFollowUpDto saveFollowUpBeneficiary(
			@RequestBody ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		logger.debug("saveFollowUpBeneficiary method is invoked");
		artBeneficiaryFollowupService.saveFollowUpBeneficiary(artCounsellorFollowUpDto);
		logger.debug("saveFollowUpBeneficiary method returns with parameters->{}", artCounsellorFollowUpDto);
		return artCounsellorFollowUpDto;
	}

	@GetMapping("{beneficiaryId}")
	public ARTCounsellorFollowUpDto getAllARTCounsellorFollowUpList(@PathVariable("beneficiaryId") Long beneficiaryId) {
		logger.debug("getAllARTCounsellorFollowUpList method is invoked");
		return artBeneficiaryFollowupService.getAllARTCounsellorFollowUpList(beneficiaryId);
	}

}
