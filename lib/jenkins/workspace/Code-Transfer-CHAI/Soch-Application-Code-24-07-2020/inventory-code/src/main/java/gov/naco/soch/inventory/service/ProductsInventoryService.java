package gov.naco.soch.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gov.naco.soch.dto.BatchDetailsDto;
import gov.naco.soch.dto.ProductsInventoryDto;
import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.inventory.mapper.ProductsInventoryMapperUtil;
import gov.naco.soch.projection.FacilityAggregateStockProjection;
import gov.naco.soch.projection.ProductInventoryProjection;
import gov.naco.soch.repository.FacilityAggregateStockCustomRepository;
import gov.naco.soch.repository.FacilityAggregateStockRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.ProductDosageRepository;
import gov.naco.soch.repository.ProductRepository;

@Service
public class ProductsInventoryService {

	@Autowired
	private FacilityAggregateStockRepository facilityAggregateStockRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private FacilityStockRepository facilityStockRepository;
	@Autowired
	private ProductDosageRepository productDosageRepository;
	@Autowired
	private FacilityAggregateStockCustomRepository facilityAggregateStockCustomRepository;

	/**
	 * @param facilityId
	 * @return
	 */
	public List<ProductsInventoryDto> getSacsProductsList(Long facilityId) {
		List<ProductInventoryProjection> sacsProductInventoryProjectionList = facilityAggregateStockRepository
				.findAllByFacilityIdToProjection(facilityId);
		List<ProductsInventoryDto> sacsProductsInventoryDtoList = ProductsInventoryMapperUtil
				.mapFacsProductInventoryProjectionListToSacsProductsInventoryDtoList(
						sacsProductInventoryProjectionList);
		return sacsProductsInventoryDtoList;

	}

	/**
	 * @param facilityId
	 * @param productId
	 * @return
	 */
	public ProductsInventoryDto getProductInventoryDetails(Long facilityId, Long productId) {

		ProductsInventoryDto sacsProductsInventoryDto = null;
		ProductInventoryProjection sacsProductInventoryProjection = facilityAggregateStockRepository
				.findByFacilityIdAndProductIdToProjection(facilityId, productId);
		if (sacsProductInventoryProjection != null) {
			sacsProductsInventoryDto = ProductsInventoryMapperUtil
					.mapSacsProductInventoryProjectionToSacsProductsInventoryDto(sacsProductInventoryProjection);

			List<FacilityAggregateStock> facilityAggregateStockList = facilityAggregateStockRepository
					.findAllByFacilityIdAndProductId(facilityId, productId);

			if (!CollectionUtils.isEmpty(facilityAggregateStockList)) {
				sacsProductsInventoryDto = ProductsInventoryMapperUtil
						.mapFacilityAggregateStockListToSacsProductsInventoryDto(facilityAggregateStockList,
								sacsProductsInventoryDto);
			}
		}
		if (sacsProductsInventoryDto.getActiveBatchDetails() != null) {
			for (BatchDetailsDto activeBatch : sacsProductsInventoryDto.getActiveBatchDetails()) {
				FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
						activeBatch.getBatchNumber(), productId, facilityId);
				if (facilityStock != null) {
					activeBatch.setFacilityStockId(facilityStock.getId());
				}
			}
		}

		Optional<ProductDosage> productDosageOptional = productDosageRepository.findByProduct_Id(productId);
		if (productDosageOptional.isPresent()) {
			ProductDosage productDosage = productDosageOptional.get();
			sacsProductsInventoryDto.setProductDosage(productDosage.getDosageQtyPerMonth());
		}
		return sacsProductsInventoryDto;

	}

	/**
	 * @param facilityId
	 * @return
	 */
	public List<ProductsInventoryDto> getSacsProductListWithActiveBatches(Long facilityId, String productName) {

		List<ProductsInventoryDto> productsList = new ArrayList<>();

		List<ProductInventoryProjection> sacsProductInventoryProjectionList = facilityAggregateStockRepository
				.findAllByFacilityIdToProjection(facilityId);
		List<ProductsInventoryDto> sacsProductsInventoryDtoList = ProductsInventoryMapperUtil
				.mapFacsProductInventoryProjectionListToSacsProductsInventoryDtoList(
						sacsProductInventoryProjectionList);

		sacsProductsInventoryDtoList = sacsProductsInventoryDtoList.stream().map(p -> {

			List<FacilityAggregateStock> facilityAggregateStockList = facilityAggregateStockRepository
					.findAllByFacilityIdAndProductId(facilityId, p.getProductId());
			return ProductsInventoryMapperUtil
					.mapFacilityAggregateStockListToSacsProductsInventoryDto(facilityAggregateStockList, p);
		}).collect(Collectors.toList());

		sacsProductsInventoryDtoList = sacsProductsInventoryDtoList.stream()
				.filter(p -> !CollectionUtils.isEmpty(p.getActiveBatchDetails())).collect(Collectors.toList());

		for (ProductsInventoryDto p : sacsProductsInventoryDtoList) {
			List<BatchDetailsDto> activeList = new ArrayList<>();
			activeList = p.getActiveBatchDetails().stream()
					.filter(b -> (b.getQuantity() != null && b.getQuantity() != 0L)).collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(activeList)) {
				p.setActiveBatchDetails(activeList);
				productsList.add(p);
			}

			if (p.getActiveBatchDetails() != null) {
				for (BatchDetailsDto activeBatch : p.getActiveBatchDetails()) {
					FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
							activeBatch.getBatchNumber(), p.getProductId(), facilityId);
					if (facilityStock != null) {
						activeBatch.setFacilityStockId(facilityStock.getId());
					}
				}
			}

			Optional<ProductDosage> productDosageOptional = productDosageRepository.findByProduct_Id(p.getProductId());
			if (productDosageOptional.isPresent()) {
				ProductDosage productDosage = productDosageOptional.get();
				p.setProductDosage(productDosage.getDosageQtyPerMonth());
			}
		}

		if (!StringUtils.isEmpty(productName)) {
			List<Product> product = productRepository.findByProductNameLike(productName.toLowerCase());
			List<Long> productIds = product.stream().map(m -> m.getId()).collect(Collectors.toList());
			productsList = productsList.stream().filter(pl -> productIds.contains(pl.getProductId()))// .sorted(Comparator.comparing(ProductsInventoryDto::get))
					.collect(Collectors.toList());
		}

		return productsList;
	}

	public Product getProduct(Product product) {
		if (product != null) {
			return (productRepository.findById(product.getId())).get();
		}
		return null;
	}

	public List<ProductsInventoryDto> getDrugsForArtDispensation(Long facilityId, String drugType) {

		List<ProductsInventoryDto> productsList = new ArrayList<>();
		Long typeId = 1L;
		List<ProductInventoryProjection> sacsProductInventoryProjectionList = new ArrayList<>();
		if (drugType.equals("arvdrug")) {
			sacsProductInventoryProjectionList = facilityAggregateStockRepository.findAllARVDrugs(typeId, facilityId);
		} else if (drugType.equalsIgnoreCase("nonarvdrug")) {
			sacsProductInventoryProjectionList = facilityAggregateStockRepository.findAllNonARVDrugs(typeId,
					facilityId);
		}

		List<ProductsInventoryDto> sacsProductsInventoryDtoList = ProductsInventoryMapperUtil
				.mapFacsProductInventoryProjectionListToSacsProductsInventoryDtoList(
						sacsProductInventoryProjectionList);

		sacsProductsInventoryDtoList = sacsProductsInventoryDtoList.stream().map(p -> {

			List<FacilityAggregateStock> facilityAggregateStockList = facilityAggregateStockRepository
					.findAllByFacilityIdAndProductId(facilityId, p.getProductId());
			return ProductsInventoryMapperUtil
					.mapFacilityAggregateStockListToSacsProductsInventoryDto(facilityAggregateStockList, p);
		}).collect(Collectors.toList());

		sacsProductsInventoryDtoList = sacsProductsInventoryDtoList.stream()
				.filter(p -> !CollectionUtils.isEmpty(p.getActiveBatchDetails())).collect(Collectors.toList());

		for (ProductsInventoryDto p : sacsProductsInventoryDtoList) {
			List<BatchDetailsDto> activeList = new ArrayList<>();
			activeList = p.getActiveBatchDetails().stream()
					.filter(b -> (b.getQuantity() != null && b.getQuantity() != 0L)).collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(activeList)) {
				p.setActiveBatchDetails(activeList);
				productsList.add(p);
			}

			if (p.getActiveBatchDetails() != null) {
				for (BatchDetailsDto activeBatch : p.getActiveBatchDetails()) {
					FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
							activeBatch.getBatchNumber(), p.getProductId(), facilityId);
					if (facilityStock != null) {
						activeBatch.setFacilityStockId(facilityStock.getId());
					}
				}
			}

			Optional<ProductDosage> productDosageOptional = productDosageRepository.findByProduct_Id(p.getProductId());
			if (productDosageOptional.isPresent()) {
				ProductDosage productDosage = productDosageOptional.get();
				p.setProductDosage(productDosage.getDosageQtyPerMonth());
			}
		}

		return productsList;
	}

	public List<ProductsInventoryDto> getSacsProductListBySearchValue(Long facilityId, String productName, String productCode) {
		String serachQuery=ProductsInventoryMapperUtil.createSearchQuery(facilityId,productName,productCode);
		List<FacilityAggregateStockProjection> sacsProductInventoryProjectionList = facilityAggregateStockCustomRepository
				.findUsingSearchValue(serachQuery);
		List<ProductsInventoryDto> sacsProductsInventoryDtoList = ProductsInventoryMapperUtil
				.mapFacilityAggregateStockProjectionToSacsProductsInventoryDtoList(
						sacsProductInventoryProjectionList);
		return sacsProductsInventoryDtoList;
	}
}
