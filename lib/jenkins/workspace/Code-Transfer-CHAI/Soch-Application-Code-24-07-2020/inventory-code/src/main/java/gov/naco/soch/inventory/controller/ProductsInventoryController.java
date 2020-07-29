package gov.naco.soch.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.ProductsInventoryDto;
import gov.naco.soch.inventory.service.ProductsInventoryService;

@RestController
@RequestMapping("/productsinventory")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductsInventoryController {

	@Autowired
	private ProductsInventoryService productsInventoryService;

	private static final Logger logger = LoggerFactory.getLogger(DispatchController.class);

	/**
	 * @param facilityId
	 * @return
	 */
	@GetMapping("/list/{facilityId}")
	public List<ProductsInventoryDto> getSacsProductList(@PathVariable("facilityId") Long facilityId) {
		logger.debug("Entered getSacsProductsList method");
		List<ProductsInventoryDto> SacsProductsInventoryDtoList = productsInventoryService
				.getSacsProductsList(facilityId);
		return SacsProductsInventoryDtoList;
	}
	
	/**
	 * @param facilityId
	 * @return
	 */
	@GetMapping("/list/search/{facilityId}")
	public List<ProductsInventoryDto> getSacsProductListBySearchValue(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value="productName",required=false)String productName,
			@RequestParam(value="productCode",required=false)String productCode) {
		logger.debug("Entered getSacsProductListBySearchValue method");
		List<ProductsInventoryDto> SacsProductsInventoryDtoList = productsInventoryService
				.getSacsProductListBySearchValue(facilityId,productName,productCode);
		return SacsProductsInventoryDtoList;
	}

	/**
	 * @param facilityId
	 * @param productId
	 * @return
	 */
	@GetMapping("/details/{facilityId}/{productId}")
	public ProductsInventoryDto getProductInventoryDetail(@PathVariable("facilityId") Long facilityId,
			@PathVariable("productId") Long productId) {
		logger.debug("Entered getProductInventoryDetails method");
		ProductsInventoryDto SacsProductsInventoryDto = productsInventoryService
				.getProductInventoryDetails(facilityId, productId);
		return SacsProductsInventoryDto;
	}
	
	/**
	 * @param facilityId
	 * @return
	 */
	@GetMapping("/active/list/{facilityId}")
	public List<ProductsInventoryDto> getSacsProductListWithActiveBatches(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "productName", required = false) String productName) {
		logger.debug("Entered getSacsProductListWithActiveBatches method");
		List<ProductsInventoryDto> SacsProductsInventoryDtoList = productsInventoryService
				.getSacsProductListWithActiveBatches(facilityId, productName);
		return SacsProductsInventoryDtoList;
	}
	
	/**
	 * @param facilityId
	 * @return
	 */
	@GetMapping("/artdrugs/{facilityId}")
	public List<ProductsInventoryDto> getDrugsForArtDispensation(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType) {
		logger.debug("Entered getDrugsForArtDispensation method");
		List<ProductsInventoryDto> SacsProductsInventoryDtoList = productsInventoryService
				.getDrugsForArtDispensation(facilityId, drugType);
		return SacsProductsInventoryDtoList;
	}

}
