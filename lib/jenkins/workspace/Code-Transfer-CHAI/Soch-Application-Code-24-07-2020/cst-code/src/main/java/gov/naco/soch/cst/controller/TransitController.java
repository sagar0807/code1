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

import gov.naco.soch.cst.dto.TransitBeneficiaryDto;
import gov.naco.soch.cst.service.TransitBeneficiaryService;

@RestController
@RequestMapping("/transit")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransitController {

	private static final Logger logger = LoggerFactory.getLogger(TransitController.class);
	
	@Autowired
	private TransitBeneficiaryService transitBeneficiaryService;
	
	@GetMapping("/list/{facilityId}/{searchText}")
	public List<TransitBeneficiaryDto> getBeneficiaryByFacility(@PathVariable Long facilityId , @PathVariable String searchText ){
		logger.debug("Entering into getBeneficiaryByFacility method ");
		 List<TransitBeneficiaryDto>beneficiaryDtos = new ArrayList<TransitBeneficiaryDto>();
		 beneficiaryDtos = transitBeneficiaryService.getBeneficiaryByFacility(facilityId , searchText);
		 return beneficiaryDtos;
	
	}
	
	@PostMapping("/assign")
	public @ResponseBody Boolean assignTransitBeneficiaryQueue(@RequestBody List<TransitBeneficiaryDto> transitBeneficiaryDto ) {
		logger.debug("Entering into assignTransitBeneficiaryQueue method ");
		Boolean isAssign =false;
		isAssign = transitBeneficiaryService.assignTransitBeneficiaryQueue(transitBeneficiaryDto);
		return isAssign;
		
	}
}
