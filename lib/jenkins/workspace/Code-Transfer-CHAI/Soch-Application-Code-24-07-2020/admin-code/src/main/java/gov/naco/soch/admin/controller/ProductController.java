package gov.naco.soch.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import gov.naco.soch.admin.service.ProductService;
import gov.naco.soch.dto.ProductDto;

//Controller class for API call

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	public ProductController() {
	}

	/*
	 * Save product.
	 * 
	 */
	@PostMapping("/save")
	public @ResponseBody Long saveProduct(@RequestBody ProductDto productDto) {
		logger.debug("Entering into method saveProduct with productDto->{}:", productDto);
		return productService.saveProduct(productDto);
	}

	@PostMapping("/fileupload")
	public @ResponseBody Boolean productImageUpload(@RequestParam("fileKey") MultipartFile file,
			@RequestParam("productId") Long Id, @RequestParam("isEdit") boolean isEdit) {
		return productService.uploadProductImage(file, Id, isEdit);
	}

	@GetMapping("/list")
	public @ResponseBody List<ProductDto> getProducts() {
		logger.debug("Entering into method getProducts");
		return productService.getProducts();
	}
	
	/**
	 * Optimized product list for Dropdowns 
	 * is_active=true and is_delete=false
	 * @return
	 */
	@GetMapping("/active/list")
	public @ResponseBody List<ProductDto> getActiveProductListForDropDown() {
		logger.debug("Entering into method getProducts");
		return productService.getActiveProductListForDropDown();
	}

	/*
	 * Save product.
	 * 
	 */
	@DeleteMapping("/{productId}/delete")
	public @ResponseBody boolean deleteProduct(@PathVariable("productId") Long productId) {
		logger.debug("Entering into method deleteProduct with productId->{}:", productId);
		return productService.deleteProduct(productId);
	}

	/**
	 * product normal search. search criteria: productname/short code
	 * 
	 * @param searchValue
	 * @return
	 */
	@GetMapping("/normalsearch/{searchValue}")
	public @ResponseBody List<ProductDto> productsNormalSearch(@PathVariable("searchValue") String searchValue) {
		logger.debug("Entering into method productsNormalSearch");
		return productService.productsNormalSearch(searchValue);
	}

	/**
	 * product advance search. search criteria:
	 * productname,shortcode,uom,producttype
	 * 
	 * @param searchValue
	 * @return
	 */
	@GetMapping("/advancesearch")
	public @ResponseBody List<ProductDto> productsAdvanceSearch(@RequestParam Map<String, String> searchValue) {
		logger.debug("Entering into method productsAdvanceSearch");
		return productService.productsAdvanceSearch(searchValue);
	}

}
