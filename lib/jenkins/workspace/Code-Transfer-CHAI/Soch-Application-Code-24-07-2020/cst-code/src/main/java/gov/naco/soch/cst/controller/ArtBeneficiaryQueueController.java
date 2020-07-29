package gov.naco.soch.cst.controller;

import gov.naco.soch.cst.dto.ArtBeneficiaryInvestigationDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryQueueDto;
import gov.naco.soch.cst.service.ArtBeneficiaryQueueService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller class for API call

@RestController
@RequestMapping("/beneficiaryQueue")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryQueueController {

	@Autowired
	private ArtBeneficiaryQueueService artBeneficiaryQueueService;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueController.class);

	@GetMapping("/queueList")
	public @ResponseBody List<ArtBeneficiaryQueueDto> getAllBeneficiaryQueues() {
		logger.debug("getAllBeneficiaryQueues method is invoked");
		return artBeneficiaryQueueService.getBeneficiaryQueues();
	}

	@GetMapping("/visitedList")
	public @ResponseBody List<ArtBeneficiaryQueueDto> getAllBeneficiaryVisitedList() {
		logger.debug("getBeneficiaryVistedList method is invoked");
		return artBeneficiaryQueueService.getBeneficiaryVisitedQueues();
	}

	@PostMapping("/saveAssignedBeneficiaries")
	public ArtBeneficiaryQueueDto saveAllBeneficiaryAssigned(@RequestBody List<ArtBeneficiaryQueueDto> dtolist){
		logger.debug("saveAllBeneficiaryAssigned() method is invoked");
		return artBeneficiaryQueueService.saveNewlyAssignedBneficiaries(dtolist);
	}
	

}
