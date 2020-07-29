package gov.naco.soch.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.inventory.service.FacilityDispatchService;

@RestController
@RequestMapping("/facilitydispatch")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityDispatchController {

	private static final Logger logger = LoggerFactory.getLogger(FacilityDispatchController.class);

	@Autowired
	private FacilityDispatchService facilityDispatchService;

	@PostMapping("/save")
	public DispatchDetailedDto savefacilityDispatchDetails(@RequestBody DispatchDetailedDto dispatchDetailedDto) {
		logger.debug("savefacilityDispatchDetails method is invoked");
		return facilityDispatchService.savefacilityDispatchDetails(dispatchDetailedDto);
	}
	
	@PostMapping("/assignstock")
	public DispatchDetailedDto assignStock(@RequestBody DispatchDetailedDto dispatchDetailedDto) {
		logger.debug("assignStock method is invoked");
		return facilityDispatchService.assignStock(dispatchDetailedDto);
	}
	
	@PostMapping("/returnfromsubfacility")
	public DispatchDetailedDto returnStockFromSubFacility(@RequestBody DispatchDetailedDto dispatchDetailedDto) {
		logger.debug("returnStockFromSubFacility method is invoked");
		return facilityDispatchService.returnStockFromSubFacility(dispatchDetailedDto);
	}
	
	
	
}
