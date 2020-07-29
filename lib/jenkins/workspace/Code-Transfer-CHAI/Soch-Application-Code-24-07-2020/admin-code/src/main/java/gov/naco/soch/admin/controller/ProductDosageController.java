package gov.naco.soch.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.ProductDosageService;
import gov.naco.soch.dto.ProductDosageDto;
import gov.naco.soch.dto.RoleDto;
import gov.naco.soch.util.AccessCode;

//Controller class for API call

@RestController
@RequestMapping("/dosage")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductDosageController {

	@Autowired
	private ProductDosageService productDosageService;

	// Logger method
	private static final Logger logger = LoggerFactory.getLogger(ProductDosageController.class);

	/**
	 * Api for both save and edit in dosage for particular product
	 * 
	 * @param productDosageDto
	 * @return
	 */
	@PostMapping("/save")
	public @ResponseBody ProductDosageDto saveProductDosage(@RequestBody ProductDosageDto productDosageDto) {
		logger.debug("saveProductDosage method called with parameters->{}", productDosageDto);
		productDosageDto = productDosageService.saveProductDosage(productDosageDto);
		logger.debug("saveProductDosage method returns with parameters->{}", productDosageDto);
		return productDosageDto;
	}

	/**
	 * Dosage listing api
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public @ResponseBody List<ProductDosageDto> getProductDosage() {
		logger.debug("getProductDosage method called");
		List<ProductDosageDto> productDosageDtolist = productDosageService.getProductDosage();
		logger.debug("getProductDosage method returns with->{}", productDosageDtolist);
		return productDosageDtolist;
	}

	/**
	 * Delete Api
	 * 
	 * @param dosageId
	 * @return
	 */
	@DeleteMapping("/delete/{dosageId}")
	public @ResponseBody Boolean deleteProductDosage(@PathVariable("dosageId") Long dosageId) {
		logger.debug("deleteProductDosage method called with path variable->", dosageId);
		Boolean isDelete = productDosageService.deleteProductDosage(dosageId);
		logger.debug("deleteProductDosage method returns with->{}", isDelete);
		return isDelete;
	}
	
	@GetMapping("/advancesearch")
	public @ResponseBody List<ProductDosageDto> productDosageAdvanceSearch(@RequestParam Map<String, String> searchValue) {
		logger.debug("productDosageAdvanceSearch() method called");
		List<ProductDosageDto> productDosageList = productDosageService.productDosageAdvanceSearch(searchValue);
		return productDosageList;

	}
}
