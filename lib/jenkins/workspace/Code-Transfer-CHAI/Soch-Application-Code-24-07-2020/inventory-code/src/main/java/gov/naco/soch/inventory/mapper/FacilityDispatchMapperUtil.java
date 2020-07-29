package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchProduct;
import gov.naco.soch.entity.FacilityDispatchProductBatch;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.Product;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;

public class FacilityDispatchMapperUtil {

	public static FacilityDispatch mapDispatchDtoToFacilityDispatch(FacilityDispatch facilityDispatch,
			@Valid DispatchDetailedDto dispatchDetailedDto) {

		facilityDispatch.setIndentDate(dispatchDetailedDto.getIndentDate());
		if (dispatchDetailedDto.getIndentNumber() != null) {
			facilityDispatch.setIndentNum(dispatchDetailedDto.getIndentNumber());
		}
		facilityDispatch.setExpectedDispatchDate(dispatchDetailedDto.getExpectedDispatchDate());
		facilityDispatch.setExpectedArrivalDate(dispatchDetailedDto.getExpectedArrivalDate());
		facilityDispatch.setTransporterName(dispatchDetailedDto.getTransporterName());
		facilityDispatch.setAwbNum(dispatchDetailedDto.getTransporterAwbNumber());
		// To change to driver name in future if needed
		facilityDispatch.setDriverName(dispatchDetailedDto.getTransporterAwbNumber());
		facilityDispatch.setContactNum(dispatchDetailedDto.getTransporterPhone());
		return facilityDispatch;
	}

	public static List<FacilityDispatchProduct> mapDispatchDtoToFacilityDispatchProductLis(
			FacilityDispatch facilityDispatch, @Valid DispatchDetailedDto dispatchDetailedDto,
			Map<Long, Product> productsMap) {

		Map<Long, List<BatchDto>> productBatchMapping = dispatchDetailedDto.getBatchDetails().stream()
				.collect(Collectors.groupingBy(BatchDto::getProductId));

		List<FacilityDispatchProduct> facilityDispatchProductList = productBatchMapping.entrySet().stream().map(m -> {

			FacilityDispatchProduct facilityDispatchProduct = new FacilityDispatchProduct();
			facilityDispatchProduct.setFacilityDispatch(facilityDispatch);
			facilityDispatchProduct.setProduct(productsMap.get(m.getKey()));
			facilityDispatchProduct.setIsDelete(Boolean.FALSE);
			facilityDispatchProduct.setIsActive(Boolean.TRUE);

			Set<FacilityDispatchProductBatch> facilityDispatchProductBatchSet = m.getValue().stream().map(b -> {

				FacilityDispatchProductBatch facilityDispatchProductBatch = new FacilityDispatchProductBatch();
				facilityDispatchProductBatch.setBatchNumber(b.getBatchNumber());
				facilityDispatchProductBatch.setBatchExpiryDate(b.getExpiryDate());
				facilityDispatchProductBatch.setBatchManufactureDate(b.getManufactureDate());
				facilityDispatchProductBatch.setQuantityDispatched(b.getDispatchQuantity());
				facilityDispatchProductBatch.setBoxesNo(b.getNumberOfBoxes());
				facilityDispatchProductBatch.setFacilityDispatchProduct(facilityDispatchProduct);
				facilityDispatchProductBatch.setIsDelete(Boolean.FALSE);
				facilityDispatchProductBatch.setIsActive(Boolean.TRUE);
				return facilityDispatchProductBatch;

			}).collect(Collectors.toSet());

			facilityDispatchProduct.setFacilityDispatchProductBatches(facilityDispatchProductBatchSet);

			return facilityDispatchProduct;
		}).collect(Collectors.toList());

		return facilityDispatchProductList;
	}

	public static FacilityStock mapToFacilityStock(String receiverType, FacilityStock facilityStock, BatchDto batch,
			Long facilityId) {
		if (facilityStock != null) {

			if (facilityStock.getCurrentQuantity() != null && batch.getDispatchQuantity() != null) {
				if (receiverType.equalsIgnoreCase("consignee")) {
					facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() + batch.getDispatchQuantity());
				} else if (receiverType.equalsIgnoreCase("consignor")) {
					facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() - batch.getDispatchQuantity());
				}

				if (receiverType.equalsIgnoreCase("dispatch")) {
					facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() - batch.getDispatchQuantity());
					if (facilityStock.getGit() != null) {
						facilityStock.setGit(facilityStock.getGit() + batch.getDispatchQuantity());
					} else {
						facilityStock.setGit(batch.getDispatchQuantity().doubleValue());
					}
				}
			} else if (facilityStock.getCurrentQuantity() != null && batch.getReturnQuantity() != null) {
				if (receiverType.equalsIgnoreCase("returnconsignee")) {
					facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() - batch.getReturnQuantity());
				} else if (receiverType.equalsIgnoreCase("returnconsignor")) {
					facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() + batch.getReturnQuantity());
				}
			}
		} else {
			facilityStock = new FacilityStock();
			facilityStock.setBatchNumber(batch.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(facilityId);
			facilityStock.setFacility(facility);
			Product product = new Product();
			product.setId(batch.getProductId());
			facilityStock.setProduct(product);
			facilityStock.setManufacturingDate(batch.getManufactureDate());
			facilityStock.setNumberOfBoxes(batch.getNumberOfBoxes());
			facilityStock.setExpiredDate(batch.getExpiryDate());
			facilityStock.setIsActive(true);
			facilityStock.setIsDelete(false);
			if (batch.getDispatchQuantity() != null) {
				facilityStock.setCurrentQuantity(batch.getDispatchQuantity().doubleValue());
			}
		}
		return facilityStock;
	}

	public static FacilityStockTracking mapToFacilityStockTracking(BatchDto batch, @Valid Long facilityId,
			Long productId, String receiverType, Long reference) {
		FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
		facilityStockTracking.setBatchNumber(batch.getBatchNumber());
		Facility facility = new Facility();
		facility.setId(facilityId);
		facilityStockTracking.setFacility(facility);
		FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
		Product product = new Product();
		product.setId(productId);
		facilityStockTracking.setProduct(product);
		facilityStockTracking.setBatchNumber(batch.getBatchNumber());
		facilityStockTracking.setTransactionDate(LocalDate.now());
		facilityStockTracking.setIsActive(true);
		facilityStockTracking.setIsDelete(false);
		if (reference != null) {
			facilityStockTracking.setReferenceNo(reference);
		}
		if (receiverType.equalsIgnoreCase("consignee")) {
			if (batch.getDispatchQuantity() != null) {
				facilityStockTracking.setQuantity(batch.getDispatchQuantity().doubleValue());
			}
			facilityStockTrackingType.setId(FacilityStockTrackingTypeEnum.Facility_Assign_Stock_to_Sub_Facility
					.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("consignor")) {
			if (batch.getDispatchQuantity() != null) {
				facilityStockTracking.setQuantity(-batch.getDispatchQuantity().doubleValue());
			}
			facilityStockTrackingType.setId(FacilityStockTrackingTypeEnum.Facility_Assign_Stock_to_Sub_Facility
					.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("returnconsignee")) {
			if (batch.getReturnQuantity() != null) {
				facilityStockTracking.setQuantity(-batch.getReturnQuantity().doubleValue());
			}
			facilityStockTrackingType.setId(FacilityStockTrackingTypeEnum.Sub_Facility_Return_Stock_To_Facility
					.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("returnconsignor")) {
			if (batch.getReturnQuantity() != null) {
				facilityStockTracking.setQuantity(batch.getReturnQuantity().doubleValue());
			}
			facilityStockTrackingType.setId(FacilityStockTrackingTypeEnum.Sub_Facility_Return_Stock_To_Facility
					.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("dispatch")) {
			if (batch.getDispatchQuantity() != null) {
				facilityStockTracking.setQuantity(-batch.getDispatchQuantity().doubleValue());
			}
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Facility_Dispatch_Stock.getFacilityStockTrackingTypeId());
		}
		facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
		return facilityStockTracking;
	}
}
