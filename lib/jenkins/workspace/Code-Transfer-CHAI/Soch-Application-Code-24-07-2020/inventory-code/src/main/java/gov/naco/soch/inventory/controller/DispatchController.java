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

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.dto.DispatchDto;
import gov.naco.soch.dto.DispatchProductDto;
import gov.naco.soch.dto.DispatchRemarkDto;
import gov.naco.soch.dto.ProductContractDto;
import gov.naco.soch.dto.ProductDispatchHistoryDto;
import gov.naco.soch.inventory.service.DispatchService;
import gov.naco.soch.projection.FacilityDetailedProjection;

/**
 * Controller class for managing dispatch related APIs
 *
 */

@RestController
@RequestMapping("/dispatch")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DispatchController {

	private static final Logger logger = LoggerFactory.getLogger(DispatchController.class);

	@Autowired
	private DispatchService dispatchService;

	/**
	 * method to get all sacs
	 * 
	 * @return List<FacilityDetailedProjection>
	 * 
	 */
	@GetMapping("/sacs/list")
	public List<FacilityDetailedProjection> getSacs() {
		logger.debug("Entered getSacs method");
		return dispatchService.getSacs();
	}

	/**
	 * method to get all facilities corresponding to a state
	 * 
	 * @param stateId
	 * @return List<FacilityDetailedProjection>
	 * 
	 */
	@GetMapping("/{facilityType}/list/{sacsId}")
	public List<FacilityDetailedProjection> getAllFacilitiesByState(@PathVariable("facilityType") String facilityType,
			@PathVariable("sacsId") Long sacsId) {
		logger.debug("getAllFacilitiesByState method is invoked");
		return dispatchService.getAllFacilitiesByState(facilityType, sacsId);
	}
	
	/**
	 * method to get all facilities corresponding to a state
	 * 
	 * @param stateId
	 * @return List<FacilityDetailedProjection>
	 * 
	 */
	@GetMapping("/lab/list")
	public List<FacilityDetailedProjection> getAllLabs() {
		logger.debug("getAllLabs method is invoked");
		return dispatchService.getAllLabs();
	}

	/**
	 * method to get product details by sacsId
	 * 
	 * @param sacsId
	 * @return ProductContractDto
	 */
	@GetMapping("/product/list/{sacsId}/{facilityId}")
	public List<ProductContractDto> getProductDetailsBySacsId(@PathVariable("sacsId") Long sacsId,
			@PathVariable("facilityId") Long facilityId) {
		logger.debug("getProductDetailsBySacsId method is invoked");
		return dispatchService.getProductDetailsBySacsId(sacsId, facilityId);
	}

	/**
	 * saveDispatchDetails : Method to save dispatch details
	 * 
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 * 
	 */
	@PostMapping("/save")
	public DispatchDetailedDto saveDispatchDetails(@Valid @RequestBody DispatchDetailedDto dispatchDetailedDto) {
		logger.debug("saveDispatchDetails method is invoked");
		return dispatchService.saveDispatchDetails(dispatchDetailedDto);
	}

	/**
	 * updateConsignment : Method to update batch details
	 * 
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 * 
	 */
	@PostMapping("/update")
	public DispatchDetailedDto updateConsignment(@Valid @RequestBody DispatchDetailedDto dispatchDetailedDto) {
		logger.debug("updateConsignment method is invoked");
		return dispatchService.updateConsignment(dispatchDetailedDto);
	}

	/**
	 * cancelConsignment : Method to cancel consignment
	 * 
	 * @param dispatchId
	 * @return true
	 * 
	 */
	@PostMapping("/cancel")
	public Boolean cancelConsignment(@Valid @RequestBody DispatchRemarkDto dispatchRemarkDto) {
		logger.debug("cancelConsignment method is invoked");
		return dispatchService.cancelConsignment(dispatchRemarkDto);
	}

	/**
	 * method to get all dispatch details
	 * 
	 * @return List<DispatchDto>
	 * 
	 */
	@GetMapping("/list/{consignorId}")
	public List<DispatchDto> getAllDispatchDetails(@PathVariable("consignorId") Long consignorId) {
		logger.debug("getAllDispatchDetails method is invoked");
		return dispatchService.getAllDispatchDetails(consignorId);
	}

	/**
	 * method to get all dispatch details by dispatchId
	 * 
	 * @param dispatchId
	 * @return DispatchDetailedDto
	 */
	@GetMapping("/{dispatchId}")
	public DispatchDetailedDto getDispatchDetailsById(@PathVariable("dispatchId") Long dispatchId) {
		logger.debug("getDispatchDetailsById method is invoked");
		return dispatchService.getDispatchDetailsById(dispatchId);
	}

	/**
	 * Get batch details by productId
	 * 
	 * @return List<BatchDto>
	 * @param productId
	 * 
	 */
	@GetMapping("/batch/list/{productId}")
	public List<BatchDto> getBatchDetails(@PathVariable("productId") Long productId) {
		logger.debug("getBatchDetails method is invoked");
		return dispatchService.getBatchDetails(productId);
	}

	/**
	 * method to save batch details
	 * 
	 * @param BatchDto
	 * 
	 */
	@PostMapping("/batch/save")
	public void saveBtach(@Valid @RequestBody BatchDto batchDto) {
		logger.debug("saveBtach method is invoked");
		dispatchService.saveBtach(batchDto);
	}

	/**
	 * listProducts : Method to list product details
	 * 
	 * @return DispatchProductDto
	 * @param supplierId
	 * 
	 */
	@GetMapping("/{supplierId}/products")
	public List<DispatchProductDto> listProducts(@PathVariable("supplierId") Long supplierId) {
		logger.debug("listProducts method is invoked!");
		return dispatchService.getDispatchedProducts(supplierId);
	}

	@GetMapping("/history/{consignorId}")
	public List<ProductDispatchHistoryDto> getProductDispatchHistoryDetails(
			@PathVariable("consignorId") Long consignorId) {
		logger.debug("listProducts method is invoked!");
		return dispatchService.getProductDispatchHistoryList(consignorId);
	}

}
