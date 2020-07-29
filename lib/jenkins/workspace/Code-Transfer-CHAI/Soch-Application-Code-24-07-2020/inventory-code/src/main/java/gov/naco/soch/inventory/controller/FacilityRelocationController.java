package gov.naco.soch.inventory.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.ProductDispatchHistoryDto;
import gov.naco.soch.dto.RemarkDto;
import gov.naco.soch.inventory.service.FacilityRelocationService;

@RestController
@RequestMapping("/facilityrelocation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityRelocationController {

	private static final Logger logger = LoggerFactory.getLogger(FacilityRelocationController.class);

	@Autowired
	private FacilityRelocationService facilityRelocationService;

	@GetMapping("/list/tofacility/{facilityId}")
	public List<ProductDispatchHistoryDto> fetchFacilityRelocationListToFacility(
			@PathVariable("facilityId") Long facilityId) {
		logger.debug("fetchFacilityRelocationListToFacility method is invoked");
		return facilityRelocationService.fetchFacilityRelocationListToFacility(facilityId);
	}

	/**
	 * approveRelocation : Method to approve relocation request
	 * 
	 * @param facilityDispatchId,status
	 * @return true
	 * 
	 */
	@PostMapping("/request/{facilityDispatchId}/approve")
	public Boolean approveRelocation(@PathVariable(value = "facilityDispatchId") Long facilityDispatchId,
			@RequestParam(value = "status") String status, @Valid @RequestBody RemarkDto remarkDto) {
		logger.debug("approveRelocation method is invoked");
		return facilityRelocationService.approveRelocation(facilityDispatchId, status, remarkDto);
	}
	
	@GetMapping("/list/tofacility/search/{facilityId}")
	public List<ProductDispatchHistoryDto> fetchFacilityRelocationListToFacility(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value="stnNumber",required=false)String stnNumber,
			@RequestParam(value="consignee",required=false)String consignee,
			@RequestParam(value="dispatchDate",required=false)@DateTimeFormat(pattern="MM/dd/yyyy")LocalDate dispatchDate,
			@RequestParam(value="productName",required=false)String productName) {
		logger.debug("fetchFacilityRelocationListToFacility method is invoked");
		return facilityRelocationService.fetchFacilityRelocationHistoryBysearchValue(facilityId,stnNumber,consignee,dispatchDate,productName);
	}
}
