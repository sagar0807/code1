package gov.naco.soch.shared.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.shared.dto.GlobalBeneficiaryViewCardDTO;
import gov.naco.soch.shared.service.BeneficiaryViewCardService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficiaryViewCardController {
	
	private final Logger log = LoggerFactory.getLogger(BeneficiaryViewCardController.class);
	
	private final BeneficiaryViewCardService beneficiaryViewCardService;
	
		public BeneficiaryViewCardController(BeneficiaryViewCardService beneficiaryViewCardService) {
		this.beneficiaryViewCardService = beneficiaryViewCardService;
	}

	@GetMapping("/viewcard/{beneficiaryId}")
	public GlobalBeneficiaryViewCardDTO getTIBeneficiary(@PathVariable Long beneficiaryId) {
		log.debug("REST request to view details of global beneficiary : {}", beneficiaryId);
		GlobalBeneficiaryViewCardDTO tIBeneficiaryDTO = beneficiaryViewCardService.findOne(beneficiaryId);
		return tIBeneficiaryDTO;
	}

}
