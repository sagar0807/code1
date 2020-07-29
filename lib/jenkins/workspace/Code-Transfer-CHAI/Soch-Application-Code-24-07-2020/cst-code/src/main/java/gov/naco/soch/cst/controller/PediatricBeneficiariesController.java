/**
 * 
 */
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.PediatricBeneficiariesInformationDto;
import gov.naco.soch.cst.service.PediatricBeneficiariesService;

@RestController
@RequestMapping("/pediatric")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PediatricBeneficiariesController {

	private static final Logger logger = LoggerFactory.getLogger(PediatricBeneficiariesController.class);

	@Autowired
	private PediatricBeneficiariesService pediatricBeneficiariesService;

	// API to save Pediatric Beneficiaries Details
	@PostMapping("/add")
	public boolean savePediatricBeneficiaries(
			@RequestBody PediatricBeneficiariesInformationDto pediatricBeneficiariesInformationDto) {
		logger.debug("Entering into savePediatricBeneficiaries  method ");
		System.out.println("DTO--" + pediatricBeneficiariesInformationDto.toString());
		logger.debug("saveBeneficiary method returns with parameters->{}",
				pediatricBeneficiariesInformationDto.toString());
		return pediatricBeneficiariesService.savePediatricBeneficiaries(pediatricBeneficiariesInformationDto);
	}

	// APi to Get Beneficiary Details by Beneficiary ID
	@GetMapping("/getbybeneficiaryid")
	public @ResponseBody PediatricBeneficiariesInformationDto getByBeneficiaryId(@RequestParam Long beneficiaryid) {
		logger.debug("Entering into getByBeneficiaryId  method ");
		PediatricBeneficiariesInformationDto pediatricBeneficiariesInformationDto = new PediatricBeneficiariesInformationDto();
		pediatricBeneficiariesInformationDto = pediatricBeneficiariesService.getByBeneficiaryId(beneficiaryid);
		return pediatricBeneficiariesInformationDto;

	}

}
