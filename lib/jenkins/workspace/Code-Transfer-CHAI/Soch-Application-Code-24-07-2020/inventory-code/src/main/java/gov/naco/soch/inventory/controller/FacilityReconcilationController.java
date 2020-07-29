package gov.naco.soch.inventory.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.FacilityReceiveStockListDto;
import gov.naco.soch.dto.FacilityReconciliationDto;
import gov.naco.soch.inventory.service.FacilityReconcilationService;

/**
 * Controller class for managing facility receive stock related APIs
 *
 */
@RestController
@RequestMapping("/reconciliation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityReconcilationController {

	private static final Logger logger = LoggerFactory.getLogger(FacilityReconcilationController.class);

	@Autowired
	private FacilityReconcilationService facilityReconcilationService;
	
	/**
	 * saveFacilityReceiptDetails : Method to save receipt details
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 * 
	 */
	@PostMapping("/save")
	public FacilityReconciliationDto acceptReconciliation(
			@Valid @RequestBody FacilityReconciliationDto facilityReconciliationDto) {
		logger.debug("acceptReconciliation method is invoked");
		return facilityReconcilationService.acceptReconciliation(facilityReconciliationDto);
	}

	/**
	 * 
	 * method to get reconciliation List
	 * 
	 * @return List<FacilityReceiveStockListDto>
	 * @param facilityId
	 * 
	 */
	@GetMapping("/list/{facilityId}")
	public List<FacilityReconciliationDto> getReconcilationList(@PathVariable("facilityId") Long facilityId) {
		logger.debug("getReconcilationList method is invoked");
		return facilityReconcilationService.getReconcilationList(facilityId);
	}
	
	/**
	 * 
	 * method to get reconciliation List by search params
	 * 
	 * @return List<FacilityReceiveStockListDto>
	 * @param facilityId
	 * 
	 */
	@GetMapping("/list/search/{facilityId}")
	public List<FacilityReconciliationDto> getReconcilationListBySearch(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value="stnNumber",required=false)String stnNumber,
			@RequestParam(value="consignor",required=false)String consignor,
			@RequestParam(value="consignee",required=false)String consignee) {
		logger.debug("getRecongetReconcilationListBySearch method is invoked");
		return facilityReconcilationService.getReconcilationListBySearch(facilityId,stnNumber,consignor,consignee);
	}
	
	/**
	 * 
	 * method to get reconciliation details by id
	 * 
	 * @return FacilityReceiveStockListDto
	 * @param facilityReceiptId
	 * 
	 */
	@GetMapping("/{facilityReceiptId}")
	public FacilityReceiveStockListDto getReconcilationById(@PathVariable("facilityReceiptId") Long facilityReceiptId) {
		logger.debug("getReconcilationById method is invoked");
		return facilityReconcilationService.getReconcilationById(facilityReceiptId);
	}

}
