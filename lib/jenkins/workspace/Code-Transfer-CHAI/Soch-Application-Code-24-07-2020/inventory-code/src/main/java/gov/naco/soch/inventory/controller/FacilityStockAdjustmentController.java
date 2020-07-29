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
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.FacilityStockAdjustDto;
import gov.naco.soch.dto.FacilityStockAdjustHistoryDto;
import gov.naco.soch.dto.FacilityStockAdjustmentTypeMasterDto;
import gov.naco.soch.inventory.service.FacilityStockAdjustmentService;

/**
 * Controller class for managing stock adjustment related APIs
 *
 */
@RestController
@RequestMapping("/stockadjustment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityStockAdjustmentController {

	private static final Logger logger = LoggerFactory.getLogger(FacilityStockAdjustmentController.class);

	@Autowired
	private FacilityStockAdjustmentService facilityStockAdjustmentService;

	/**
	 * method to get all StockAdjustment Type With Reasons
	 * 
	 * @return List<FacilityStockAdjustmentTypeMasterDto>
	 */
	@GetMapping("/type/list")
	public List<FacilityStockAdjustmentTypeMasterDto> getStockAdjustmentTypeWithReasons() {
		logger.debug("Entered getStockAdjustmentTypeWithReasons method");
		return facilityStockAdjustmentService.getStockAdjustmentTypeWithReasons();
	}

	/**
	 * adjustStock : Method to save stock adjustment details
	 * 
	 * @param facilityStockAdjustDto
	 * @return FacilityStockAdjustDto
	 */
	@PostMapping("/save")
	public FacilityStockAdjustDto adjustStock(@Valid @RequestBody FacilityStockAdjustDto facilityStockAdjustDto) {
		logger.debug("adjustStock method is invoked");
		return facilityStockAdjustmentService.adjustStock(facilityStockAdjustDto);
	}
	
	/**
	 * method to get StockAdjustment history
	 * 
	 * @return List<FacilityStockAdjustmentTypeMasterDto>
	 */
	@GetMapping("/list/{facilityId}/{productId}")
	public List<FacilityStockAdjustHistoryDto> getStockAdjustmentHistory(@PathVariable("facilityId") Long facilityId,
			@PathVariable("productId") Long productId) {
		logger.debug("Entered getStockAdjustmentHistory method");
		return facilityStockAdjustmentService.getStockAdjustmentHistory(facilityId,productId);
	}
	
	

}
