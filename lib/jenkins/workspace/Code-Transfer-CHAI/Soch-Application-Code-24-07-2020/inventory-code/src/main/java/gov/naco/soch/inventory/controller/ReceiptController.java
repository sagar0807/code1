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

import gov.naco.soch.dto.AcceptConsignmentDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.dto.ReceiptDto;
import gov.naco.soch.dto.ReceiptSupplierDto;
import gov.naco.soch.inventory.service.ReceiptService;

/**
 * Controller class for managing receipt related APIs
 *
 */

@RestController
@RequestMapping("/receipt")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceiptController {

	private static final Logger logger = LoggerFactory.getLogger(ReceiptController.class);

	@Autowired
	private ReceiptService receiptService;

	/**
	 * 
	 * method to get list of dispatched stocks
	 * 
	 * @return List<DispatchDetailedDto>
	 * @param facilityId,facilityType
	 * 
	 */
	@GetMapping("/stocklist/{facilityId}/{facilityType}")
	public List<DispatchDetailedDto> getAllDispatchDetails(@PathVariable("facilityId") Long facilityId,
			@PathVariable("facilityType") String facilityType,
			@RequestParam(value = "stnNumber", required = false) String stnNumber,
			@RequestParam(value = "consignorName", required = false) String consignorName,
			@RequestParam(value = "invoiceNumber", required = false) String invoiceNumber,
			@RequestParam(value = "invoiceDate", required = false)@DateTimeFormat(pattern="MM/dd/yyyy")LocalDate invoiceDate) {
		logger.debug("getAllDispatchedStocks method is invoked");
		return receiptService.getAllDispatchedStocks(facilityId, facilityType,stnNumber,consignorName,invoiceNumber,invoiceDate);
	}

	/**
	 * saveReceiptDetails : Method to save receipt details
	 * 
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 * 
	 */
	@PostMapping("/save")
	public ReceiptDto saveReceiptDetails(@Valid @RequestBody ReceiptDto receiptDto) {
		logger.debug("saveReceiptDetails method is invoked");
		return receiptService.saveReceiptDetails(receiptDto);
	}

	/**
	 * listSupplierReceipts : Method to list all receipt from supplier
	 * 
	 * @return List of ReceiptSupplierDto
	 * 
	 */
	@GetMapping("/list/{facilityId}/supplier")
	public List<ReceiptSupplierDto> listReceiptsFromSupplier(
			@RequestParam(value = "user", required = false) String user, @PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "stnNumber", required = false) String stnNumber,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "invoiceNumber", required = false) String invoiceNumber) {
		return receiptService.getReceiptHistory(facilityId,user,stnNumber,invoiceNumber,productName);
	}

	/**
	 * viewReceiptByReceiptIdFromSupplier : Method to fetch receipt details from
	 * supplier by using receiptId
	 * 
	 * @param receiptId
	 * @return ReceiptSupplierDto
	 */
	@GetMapping("{receiptId}/supplier")
	public DispatchDetailedDto viewReceiptByReceiptIdFromSupplier(@PathVariable("receiptId") Long receiptId) {
		return receiptService.viewReceiptByReceiptIdFromSupplier(receiptId);
	}

	/**
	 * acceptConsignement : Method to accept consignment
	 * 
	 * @param receiptId
	 * @param acceptConsignmentDto
	 * @return AcceptConsignmentDto
	 */
	@PostMapping("/consignment/accept")
	public AcceptConsignmentDto acceptConsignement(@RequestBody AcceptConsignmentDto acceptConsignmentDto) {
		return receiptService.acceptConsignement(acceptConsignmentDto);
	}

}
