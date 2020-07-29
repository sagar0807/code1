package gov.naco.soch.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.ProductDosageDto;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.mapper.ProductDosageMapper;
import gov.naco.soch.repository.ProductDosageRepository;
import gov.naco.soch.repository.ProductRepository;

@Transactional
@Service
public class ProductDosageService {

	// Logger method
	private static final Logger logger = LoggerFactory.getLogger(ProductDosageService.class);

	@Autowired
	private ProductDosageRepository productDosageRepository;

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Saving dosage for particular product
	 * 
	 * @param productDosageDto
	 * @return
	 */
	public ProductDosageDto saveProductDosage(ProductDosageDto productDosageDto) {

		logger.debug("Entered into function saveProductDosage with parameter->{}", productDosageDto);
		Product product = null;
		int count = 0;
		Optional<Product> productOpt = productRepository.findById(productDosageDto.getProductId());
		if (productOpt.isPresent()) {
			product = productOpt.get();
		}
		String countQuery = ProductDosageMapper.countQueryCreator(productDosageDto);
		String findQuery = ProductDosageMapper.findQueryCreator(productDosageDto);
		ProductDosage productDosage = null;
		if (productDosageDto.getDosageId() != null) {
			count = productDosageRepository.actualCount(countQuery);
			if (count != 0) {
				throwErrorManually("Dosage Already Existing For Product '" + product.getProductName() + "'",
						"Dosage Already Exist");
			}
			productDosage = productDosageRepository.findById(productDosageDto.getDosageId()).get();
//			List<ProductDosage> productDosageList = productDosageRepository.findProductDosage(findQuery);
//			if (productDosageList != null && !productDosageList.isEmpty() && productDosageList.get(0) != null) {
//				productDosage.setIsDelete(true);
//				productDosageRepository.save(productDosage);
//				productDosage = productDosageList.get(0);
//				productDosage.setIsDelete(false);
//			}
		} else {
			count = productDosageRepository.actualCount(countQuery);
			if (count != 0) {
				throwErrorManually("Dosage Already Existing For Product '" + product.getProductName() + "'",
						"Dosage Already Exist");
			} else {				
				List<ProductDosage> productDosageList = productDosageRepository.findProductDosage(findQuery);
				if (productDosageList != null && !productDosageList.isEmpty() && productDosageList.get(0) != null) {
					productDosage = productDosageList.get(0);
					productDosage.setIsDelete(false);
				}
			}

		}

		logger.debug("Calling function mapToProductDosageDto with parameter->{}", productDosageDto, product);
		productDosage = ProductDosageMapper.mapToProductDosageDto(productDosageDto, product, productDosage);
		productDosageRepository.save(productDosage);
		productDosageDto.setDosageId(productDosage.getId());

		logger.debug("saveProductDosage return with->{}", productDosageDto);
		return productDosageDto;
	}

	/**
	 * Function to list all dosage
	 * 
	 * @return
	 */
	public List<ProductDosageDto> getProductDosage() {

		logger.debug("Entered into function getProductDosage");
		List<ProductDosage> dosageList = productDosageRepository.findAllByIsDeleteOrderByProductIdAsc(Boolean.FALSE);
		List<ProductDosageDto> productDosageDtoList = ProductDosageMapper.mapToProductDosageDtoList(dosageList);
		logger.debug("getProductDosage return with->{}", productDosageDtoList);
		return productDosageDtoList;
	}

	/**
	 * Function to delete product dosage
	 * 
	 * @param dosageId
	 * @return
	 */
	public Boolean deleteProductDosage(Long dosageId) {

		logger.debug("Entered into function deleteProductDosage");
		Optional<ProductDosage> productDosageOpt = productDosageRepository.findByIdAndIsDelete(dosageId, Boolean.FALSE);
		if (productDosageOpt.isPresent()) {
			ProductDosage dosage = productDosageOpt.get();
			dosage.setIsDelete(Boolean.TRUE);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

	public List<ProductDosageDto> productDosageAdvanceSearch(Map<String, String> searchValue) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * To through By passing String
	 * 
	 * @param errorString
	 * @param errorType
	 */
	private void throwErrorManually(String errorString, String errorType) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorType);
		errorDto.setDescription(errorString);
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(errorString, errorResponse, HttpStatus.BAD_REQUEST);
	}

}
