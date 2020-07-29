package gov.naco.soch.inventory.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.UnregisteredSourceReceiveStockDto;
import gov.naco.soch.inventory.service.UnregisteredSourceReceiveStockService;

@RestController
@RequestMapping("/unregisteredsource")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UnregisteredSourceReceiveStockController {

	private static final Logger logger = LoggerFactory.getLogger(UnregisteredSourceReceiveStockController.class);

	@Autowired
	private UnregisteredSourceReceiveStockService unregisteredSourceReceiveStockService;

	@GetMapping("/list")
	public List<UnregisteredSourceReceiveStockDto> getAllUnregisteredSources() {
		logger.info("getAllUnregisteredSources method is invoked");
		return unregisteredSourceReceiveStockService.getAllUnregisteredSources();
	}

	@PostMapping("/receivestock")
	public UnregisteredSourceReceiveStockDto receiveStock(
			@RequestBody UnregisteredSourceReceiveStockDto unregisteredSourceReceiveStockDto) {
		logger.info("getAllUnregisteredSources method is invoked");
		return unregisteredSourceReceiveStockService.receiveStock(unregisteredSourceReceiveStockDto);
	}

	@GetMapping("/receivedstock/list/{facilityId}")
	public List<UnregisteredSourceReceiveStockDto> receivedStockList(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value="productName",required=false)String productName,
			@RequestParam(value="sourceName",required=false)String sourceName) {
		logger.info("getAllUnregisteredSources method is invoked");
		return unregisteredSourceReceiveStockService.receivedStockList(facilityId,productName,sourceName);
	}

	@GetMapping("/list/facilities")
	public List<UnregisteredSourceReceiveStockDto> getAllUnregisteredFacilities() {
		logger.info("getAllUnregisteredSources method is invoked");
		return unregisteredSourceReceiveStockService.getAllUnregisteredFacilities();
	}

	@PostMapping("/dispatchstock")
	public UnregisteredSourceReceiveStockDto dispatchStock(
			@RequestBody UnregisteredSourceReceiveStockDto unregisteredSourceReceiveStockDto) {
		logger.info("getAllUnregisteredSources method is invoked");
		return unregisteredSourceReceiveStockService.dispatchStock(unregisteredSourceReceiveStockDto);
	}
}
