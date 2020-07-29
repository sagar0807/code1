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

import gov.naco.soch.dto.FacilityReceiveStockListDto;
import gov.naco.soch.inventory.service.FacilityReceiveStockService;

/**
 * Controller class for managing facility receive stock related APIs
 *
 */
@RestController
@RequestMapping("/facilityreceive")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityReceiveStockController {

	private static final Logger logger = LoggerFactory.getLogger(FacilityReceiveStockController.class);

	@Autowired
	private FacilityReceiveStockService facilityReceiveStockService;

	/**
	 * method to get list of dispatched stocks in a facility
	 * 
	 * @return List<DispatchDetailedDto>
	 * @param facilityId,facilityType
	 * 
	 */
	@GetMapping("/stocklist/{facilityId}/{facilityType}")
	public List<FacilityReceiveStockListDto> getAllDispatchedStocks(@PathVariable("facilityId") Long facilityId,
			@PathVariable("facilityType") String facilityType,
			@RequestParam(value = "stnNumber", required = false) String stnNumber,
			@RequestParam(value = "consignorName", required = false) String consignorName,
			@RequestParam(value = "indentNumber", required = false) String indentNumber,
			@RequestParam(value = "dispatchDate", required = false)@DateTimeFormat(pattern="MM/dd/yyyy")LocalDate dispatchDate) {
		logger.debug("getAllDispatchedStocks method is invoked");
		return facilityReceiveStockService.getAllDispatchedStocks(facilityId, facilityType, stnNumber, consignorName,
				indentNumber, dispatchDate);
	}

	/**
	 * saveFacilityReceiptDetails : Method to save receipt details
	 * 
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 * 
	 */
	@PostMapping("/save")
	public FacilityReceiveStockListDto saveFacilityReceiptDetails(
			@Valid @RequestBody FacilityReceiveStockListDto receiptDto) {
		logger.debug("saveFacilityReceiptDetails method is invoked");
		return facilityReceiveStockService.saveFacilityReceiptDetails(receiptDto);
	}

	/**
	 * 
	 * method to get facility receipt history
	 * 
	 * @return List<FacilityReceiveStockListDto>
	 * @param facilityId,facilityType
	 * 
	 */
	@GetMapping("/list/{facilityId}/{facilityType}")
	public List<FacilityReceiveStockListDto> getReceiptHistory(@PathVariable("facilityId") Long facilityId,
			@PathVariable("facilityType") String facilityType,
			@RequestParam(value="stnNumber",required=false)String stnNumber,
			@RequestParam(value="indentNumber",required=false)String indentNumber,
			@RequestParam(value="productName",required=false)String productName) {
		logger.debug("getReceiptHistory method is invoked");
		return facilityReceiveStockService.getReceiptHistory(facilityId, facilityType,stnNumber,indentNumber,productName);
	}

}
