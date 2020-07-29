package gov.naco.soch.admin.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.dto.ProductDto;
import gov.naco.soch.entity.Division;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.LabTypesMaster;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.entity.ProductFacilityTypeMapping;
import gov.naco.soch.entity.ProductLabTypesMapping;
import gov.naco.soch.entity.ProductTypesMaster;
import gov.naco.soch.entity.ProductUomMaster;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.mapper.ProductMapper;
import gov.naco.soch.projection.ProductInventoryProjection;
import gov.naco.soch.repository.DivisionRepository;
import gov.naco.soch.repository.FacilityTypeRepository;
import gov.naco.soch.repository.LabTypesMasterRepository;
import gov.naco.soch.repository.ProductDosageRepository;
import gov.naco.soch.repository.ProductFacilityTypeMappingRepository;
import gov.naco.soch.repository.ProductRepository;
import gov.naco.soch.repository.ProductTypesMasterRepository;
import gov.naco.soch.repository.ProductUomRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductTypesMasterRepository productTypesMasterRepository;

	@Autowired
	DivisionRepository divisionRepository;

	@Autowired
	ProductUomRepository productUomRepository;

	@Autowired
	FacilityTypeRepository facilityTypeRepository;

	@Autowired
	LabTypesMasterRepository labTypesMasterRepository;

	@Autowired
	private ProductDosageRepository productDosageRepository;

	@Autowired
	private ProductFacilityTypeMappingRepository productFacilityTypeMappingRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	/*
	 * Save product
	 */
	public Long saveProduct(@RequestBody ProductDto productDto) {
		productDto.setProductName(productDto.getProductName() != null ? productDto.getProductName().trim() : null);
		productDto.setShortCode(productDto.getShortCode() != null ? productDto.getShortCode().trim() : null);
		logger.debug("Entering into method saveProduct with productDto->{}:", productDto);
		int count = 0;
		int codeCount = 0;
		if (productDto.getId() != null && productDto.getId() > 0) {
			count = productRepository.isExistByProductNameInEdit(productDto.getProductName(), productDto.getId());
			codeCount=productRepository.isExistByProductShortCodeInEdit(productDto.getShortCode(), productDto.getId());
		} else {
			count = productRepository.isExistByProductNameInSave(productDto.getProductName());
			codeCount=productRepository.isExistByProductShortCodeInSave(productDto.getShortCode());
		}
		if (count != 0) {
			logger.error(Constants.DUPLICATE_FOUND);
			String errorfield = "Product Name";
			throwError(errorfield, productDto.getProductName());
		}
		if (codeCount != 0) {
			logger.error(Constants.DUPLICATE_FOUND);
			String errorfield = "Product Short Code";
			throwError(errorfield, productDto.getShortCode());
		}
		Product product = null;
		if (productDto.getId() != null && productDto.getId() > 0) {
			product = productRepository.findById(productDto.getId()).get();
			if (product.getProductLabTypesMappings() != null && !product.getProductLabTypesMappings().isEmpty()) {
				product.getProductLabTypesMappings().clear();
			}
			if (product.getProductFacilityTypeMappings() != null
					&& !product.getProductFacilityTypeMappings().isEmpty()) {
				productFacilityTypeMappingRepository.deleteInBatch(product.getProductFacilityTypeMappings());
			}
		}
		product = ProductMapper.mapToProduct(productDto, product);

		if (productDto.getUom() != null && productDto.getUom().getId() != null && productDto.getUom().getId() > 0) {
			ProductUomMaster productUomMaster = productUomRepository.findById(productDto.getUom().getId()).get();
			product.setProductUomMaster(productUomMaster);
		}

		if (productDto.getProductType() != null && productDto.getProductType().getId() != null
				&& productDto.getProductType().getId() > 0) {
			ProductTypesMaster productTypesMaster = productTypesMasterRepository
					.findById(productDto.getProductType().getId()).get();
			product.setProductTypesMaster(productTypesMaster);
		}

		if (productDto.getDivision() != null && productDto.getDivision().getId() != null
				&& productDto.getDivision().getId() > 0) {
			Division division = divisionRepository.findById(productDto.getDivision().getId()).get();
			product.setDivision(division);
		}

		if (productDto.getLabTypes() != null && !productDto.getLabTypes().isEmpty()) {
			Set<ProductLabTypesMapping> productLabTypesMappingSet = new HashSet<ProductLabTypesMapping>();
			for (MasterDto masterDto : productDto.getFacilityTypes()) {
				if (masterDto.getId() != null && masterDto.getId() > 0) {
					ProductLabTypesMapping productLabTypesMapping = new ProductLabTypesMapping();
					LabTypesMaster labTypesMaster = labTypesMasterRepository.findById(masterDto.getId()).get();
					productLabTypesMapping.setLabTypesMaster(labTypesMaster);
					productLabTypesMapping.setIsDelete(false);
					productLabTypesMapping.setProduct(product);
					productLabTypesMappingSet.add(productLabTypesMapping);
				}
			}
			if (product.getProductLabTypesMappings() == null) {
				product.setProductLabTypesMappings(new HashSet<ProductLabTypesMapping>());
			}
			product.getProductLabTypesMappings().addAll(productLabTypesMappingSet);
		}

		if (productDto.getFacilityTypes() != null && !productDto.getFacilityTypes().isEmpty()) {
			Set<ProductFacilityTypeMapping> productFacilityTypeMappingSet = new HashSet<ProductFacilityTypeMapping>();
			for (MasterDto masterDto : productDto.getFacilityTypes()) {
				if (masterDto.getId() != null && masterDto.getId() > 0) {
					ProductFacilityTypeMapping productFacilityTypMapping = new ProductFacilityTypeMapping();
					FacilityType facilityType = facilityTypeRepository.findById(masterDto.getId()).get();
					productFacilityTypMapping.setFacilityType(facilityType);
					productFacilityTypMapping.setIsDelete(false);
					productFacilityTypMapping.setIsActive(product.getIsActive());
					productFacilityTypMapping.setProduct(product);
					productFacilityTypeMappingSet.add(productFacilityTypMapping);
				}
			}
			if (product.getProductFacilityTypeMappings() == null) {
				product.setProductFacilityTypeMappings(new HashSet<ProductFacilityTypeMapping>());
			}
			product.getProductFacilityTypeMappings().addAll(productFacilityTypeMappingSet);
		}

		productRepository.save(product);
		logger.debug("Leaving from method saveProduct with productDto->{}:", productDto);
		return product.getId();
	}

	public Boolean uploadProductImage(MultipartFile file, Long id, boolean isEdit) {
		Product product = productRepository.findById(id).get();
		try {
			product.setProductImage(file.getBytes());
			productRepository.save(product);
			return true;
		} catch (IOException e) {
			if (!isEdit) {
				productRepository.delete(product);
			}
			return false;
		}
	}

	/*
	 * Get all products
	 */
	public List<ProductDto> getProducts() {

		List<Product> products = productRepository.findAllByIsDeleteOrderByIdDesc(Boolean.FALSE);
		List<ProductDto> productDtoList = new ArrayList<>();
		ProductDto productDto = null;
		for (Product product : products) {
			productDto = ProductMapper.mapToProductDto(product);
			productDtoList.add(productDto);
		}
		return productDtoList;

	}
	
	public List<ProductDto> getActiveProductListForDropDown() {
		List<ProductInventoryProjection> products = productRepository.findAllProductByIsActiveAndIsDelete();
		List<ProductDto> productDtoList  =  ProductMapper.mapProjectionListToProductDtoList(products);
		return productDtoList;
	}

	/*
	 * Delete product.
	 */
	public boolean deleteProduct(Long productId) {

		Product product = productRepository.findById(productId).get();
		product.setIsDelete(true);
		if (product.getProductFacilityTypeMappings() != null && !product.getProductFacilityTypeMappings().isEmpty()) {
			product.getProductFacilityTypeMappings().forEach(action -> {
				action.setIsDelete(Boolean.TRUE);
			});
		}
		productRepository.save(product);
		if (!product.getProductDosages().isEmpty()) {
			Set<ProductDosage> dosages = product.getProductDosages();
			dosages.forEach(action -> {
				action.setIsDelete(Boolean.TRUE);
			});
			productDosageRepository.saveAll(dosages);
		}

		return true;

	}

	public List<ProductDto> productsNormalSearch(String searchValue) {
		searchValue = '%' + searchValue.trim() + '%';
		List<Product> products = productRepository.findProductsByNormalSearch(searchValue);
		List<ProductDto> productDtoList = new ArrayList<>();
		ProductDto productDto = null;
		for (Product product : products) {
			productDto = ProductMapper.mapToProductDto(product);
			productDtoList.add(productDto);
		}
		return productDtoList;
	}

	public List<ProductDto> productsAdvanceSearch(Map<String, String> searchValue) {
		String searchQuery = ProductMapper.advanceSearchQueryCreator(searchValue);
		List<Product> products = productRepository.findProductsByAdvanceSearch(searchQuery);
		List<ProductDto> productDtoList = new ArrayList<>();
		ProductDto productDto = null;
		for (Product product : products) {
			productDto = ProductMapper.mapToProductDto(product);
			productDtoList.add(productDto);
		}
		return productDtoList;
	}

	// Method to throw error
	private void throwError(String errorfield, String errorFieldValue) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.DUPLICATE_FOUND + "'" + errorFieldValue + "'");
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(Constants.DUPLICATE_FOUND + " '" + errorFieldValue + "' ", errorResponse,
				HttpStatus.BAD_REQUEST);
	}

}
