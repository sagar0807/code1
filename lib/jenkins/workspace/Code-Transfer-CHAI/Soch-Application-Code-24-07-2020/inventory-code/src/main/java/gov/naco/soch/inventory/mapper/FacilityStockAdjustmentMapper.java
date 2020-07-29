package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import gov.naco.soch.dto.FacilityStockAdjustDto;
import gov.naco.soch.dto.FacilityStockAdjustHistoryDto;
import gov.naco.soch.dto.FacilityStockAdjustmentTypeMasterDto;
import gov.naco.soch.dto.FacilityStockAdjustmentTypeReasonsDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockAdjustment;
import gov.naco.soch.entity.FacilityStockAdjustmentTypeMaster;
import gov.naco.soch.entity.FacilityStockAdjustmentTypeReason;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.Product;
import gov.naco.soch.enums.FacilityStockAdjustmentEnum;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.util.UserUtils;

public class FacilityStockAdjustmentMapper {

	public static FacilityStockAdjustment mapFacilityStockAdjustDtoToFacilityStockAdjustment(
			@Valid FacilityStockAdjustDto facilityStockAdjustDto) {
		FacilityStockAdjustment facilityStockAdjustment = new FacilityStockAdjustment();
		facilityStockAdjustment.setAdjustStockQuantity(facilityStockAdjustDto.getAdjustedQuantity());
		facilityStockAdjustment.setRemark(facilityStockAdjustDto.getRemarks());
		facilityStockAdjustment.setBatchNumber(facilityStockAdjustDto.getBatchNumber());
		Facility facility = new Facility();
		facility.setId(facilityStockAdjustDto.getFacilityId());
		facilityStockAdjustment.setFacility(facility);
		Product product = new Product();
		product.setId(facilityStockAdjustDto.getProductId());
		facilityStockAdjustment.setProduct(product);
		if (facilityStockAdjustDto.getReasonCode() != null) {
			FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason = new FacilityStockAdjustmentTypeReason();
			facilityStockAdjustmentTypeReason.setId(facilityStockAdjustDto.getReasonCode());
			facilityStockAdjustment.setFacilityStockAdjustmentTypeReason(facilityStockAdjustmentTypeReason);
		}
		FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster = new FacilityStockAdjustmentTypeMaster();
		facilityStockAdjustmentTypeMaster.setId(facilityStockAdjustDto.getType());
		facilityStockAdjustment.setFacilityStockAdjustmentTypeMaster(facilityStockAdjustmentTypeMaster);
		facilityStockAdjustment.setCurrentQuantity(facilityStockAdjustDto.getCurrentQuantity());

		facilityStockAdjustment.setDateOfAdditionOrConsumption(facilityStockAdjustDto.getDateOfAdditionOrConsumption());
		facilityStockAdjustment.setBulkDispenseQuantity(facilityStockAdjustDto.getBulkDispenseQuantity());
		facilityStockAdjustment.setWastageQuantity(facilityStockAdjustDto.getWastageQuantity());
		facilityStockAdjustment.setTestingQuantity(facilityStockAdjustDto.getTestingQuantity());
		facilityStockAdjustment.setQaQuantity(facilityStockAdjustDto.getQaQuantity());
		facilityStockAdjustment.setControlQuantity(facilityStockAdjustDto.getControlQuantity());
		facilityStockAdjustment.setBeneficiaryQuantity(facilityStockAdjustDto.getBeneficiaryQuantity());
		facilityStockAdjustment.setOtherQuantity(facilityStockAdjustDto.getOtherQuantity());
		facilityStockAdjustment.setTotalQuantity(facilityStockAdjustDto.getTotalQuantity());

		return facilityStockAdjustment;
	}

	public static FacilityStockTracking mapToFacilityStockTracking(@Valid FacilityStockAdjustDto facilityStockAdjustDto,
			Long referenceNumber) {

		FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
		facilityStockTracking.setBatchNumber(facilityStockAdjustDto.getBatchNumber());
		Facility facility = new Facility();
		facility.setId(facilityStockAdjustDto.getFacilityId());
		facilityStockTracking.setFacility(facility);
		facilityStockTracking.setIsActive(true);
		facilityStockTracking.setIsDelete(false);
		FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
		if (facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.ADD_STOCK
				.getFacilityStockAdjustmentType()) {
			facilityStockTrackingType.setId(
					FacilityStockTrackingTypeEnum.Facility_Stock_Adjustment_Add_Stock.getFacilityStockTrackingTypeId());
		} else if (facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.WRITE_OFF
				.getFacilityStockAdjustmentType()) {
			facilityStockTrackingType.setId(
					FacilityStockTrackingTypeEnum.Facility_Stock_Adjustment_Write_Off.getFacilityStockTrackingTypeId());
		} else if (facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.WRITE_OFF_EXPIRED
				.getFacilityStockAdjustmentType()) {
			facilityStockTrackingType.setId(FacilityStockTrackingTypeEnum.Facility_Stock_Adjustment_Write_Off_Expired
					.getFacilityStockTrackingTypeId());
		} else if (facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.CONSUMPTION
				.getFacilityStockAdjustmentType()) {
			facilityStockTrackingType.setId(FacilityStockTrackingTypeEnum.Consumption.getFacilityStockTrackingTypeId());
		}
		facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
		Product product = new Product();
		product.setId(facilityStockAdjustDto.getProductId());
		facilityStockTracking.setProduct(product);
		facilityStockTracking.setReferenceNo(referenceNumber);
		facilityStockTracking.setTransactionDate(LocalDate.now());
		if (facilityStockAdjustDto.getAdjustedQuantity() != null) {
			if (facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.ADD_STOCK
					.getFacilityStockAdjustmentType()) {
				facilityStockTracking.setQuantity(facilityStockAdjustDto.getAdjustedQuantity().doubleValue());
			} else if (facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.WRITE_OFF
					.getFacilityStockAdjustmentType()
					|| facilityStockAdjustDto.getType() == FacilityStockAdjustmentEnum.WRITE_OFF_EXPIRED
							.getFacilityStockAdjustmentType()) {
				facilityStockTracking.setQuantity(-facilityStockAdjustDto.getAdjustedQuantity().doubleValue());
			}
		}
		return facilityStockTracking;
	}

	public static FacilityStock mapToFacilityStock(@Valid FacilityStockAdjustDto facilityStockAdjustDto,
			FacilityStock facilityStock) {
		if (facilityStock != null) {
			if (facilityStockAdjustDto.getAdjustedQuantity() != null) {
				if (facilityStockAdjustDto.getType() == 1L) {
					Double quantity = facilityStock.getCurrentQuantity() + facilityStockAdjustDto.getAdjustedQuantity();
					facilityStock.setCurrentQuantity(quantity);
				} else if (facilityStockAdjustDto.getType() == 2L || facilityStockAdjustDto.getType() == 3L) {
					Double quantity = facilityStock.getCurrentQuantity() - facilityStockAdjustDto.getAdjustedQuantity();
					facilityStock.setCurrentQuantity(quantity);
				} else if (facilityStockAdjustDto.getType() == 5L) {
					Double quantity = facilityStock.getCurrentQuantity() - facilityStockAdjustDto.getAdjustedQuantity();
					facilityStock.setCurrentQuantity(quantity);
				}
			}

		} else {
			facilityStock = new FacilityStock();
			facilityStock.setBatchNumber(facilityStockAdjustDto.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(facilityStockAdjustDto.getFacilityId());
			facilityStock.setFacility(facility);
			Product product = new Product();
			facilityStock.setIsActive(true);
			facilityStock.setIsDelete(false);
			product.setId(facilityStockAdjustDto.getProductId());
			facilityStock.setProduct(product);
			facilityStock.setManufacturingDate(facilityStockAdjustDto.getManufactureDate());
			facilityStock.setExpiredDate(facilityStockAdjustDto.getExpiryDate());
			if (facilityStockAdjustDto.getAdjustedQuantity() != null) {
				facilityStock.setCurrentQuantity(facilityStockAdjustDto.getAdjustedQuantity().doubleValue());
			}
		}
		return facilityStock;
	}

	public static List<FacilityStockAdjustmentTypeMasterDto> mapFacilityStockAdjustmentTypes(
			List<FacilityStockAdjustmentTypeMaster> stockAdjustmentTypes) {
		List<FacilityStockAdjustmentTypeMasterDto> facilityStockAdjustmentTypeMasterDtos = new ArrayList<FacilityStockAdjustmentTypeMasterDto>();
		if (stockAdjustmentTypes != null) {
			stockAdjustmentTypes.forEach(stockAdjustmentType -> {
				FacilityStockAdjustmentTypeMasterDto facilityStockAdjustmentTypeMasterDto = new FacilityStockAdjustmentTypeMasterDto();
				facilityStockAdjustmentTypeMasterDto.setTypeId(stockAdjustmentType.getId());
				facilityStockAdjustmentTypeMasterDto.setType(stockAdjustmentType.getType());
				List<FacilityStockAdjustmentTypeReasonsDto> reasons = mapFacilityStockAdjustmentTypeReason(
						stockAdjustmentType.getFacilityStockAdjustmentTypeReasons());
				facilityStockAdjustmentTypeMasterDto.setReasons(reasons);
				facilityStockAdjustmentTypeMasterDtos.add(facilityStockAdjustmentTypeMasterDto);
			});
		}
		return facilityStockAdjustmentTypeMasterDtos;
	}

	private static List<FacilityStockAdjustmentTypeReasonsDto> mapFacilityStockAdjustmentTypeReason(
			Set<FacilityStockAdjustmentTypeReason> facilityStockAdjustmentTypeReasons) {
		List<FacilityStockAdjustmentTypeReasonsDto> facilityStockAdjustmentTypeReasonsDtos = new ArrayList<>();
		if (facilityStockAdjustmentTypeReasons != null) {
			facilityStockAdjustmentTypeReasons.forEach(reason -> {
				FacilityStockAdjustmentTypeReasonsDto reasonDto = new FacilityStockAdjustmentTypeReasonsDto();
				reasonDto.setReasonId(reason.getId());
				reasonDto.setReasonCode(reason.getStockAdjustmentReason());
				facilityStockAdjustmentTypeReasonsDtos.add(reasonDto);
			});
		}
		return facilityStockAdjustmentTypeReasonsDtos;
	}

	public static List<FacilityStockAdjustHistoryDto> mapToFacilityStockAdjustHistoryDto(
			List<FacilityStockAdjustment> facilityStockAdjustments) {
		List<FacilityStockAdjustHistoryDto> facilityStockAdjustHistoryDtos = new ArrayList<>();
		if (facilityStockAdjustments != null) {
			facilityStockAdjustments.forEach(facilityStockAdjustment -> {
				FacilityStockAdjustHistoryDto facilityStockAdjustHistoryDto = new FacilityStockAdjustHistoryDto();
				facilityStockAdjustHistoryDto.setBatchNumber(facilityStockAdjustment.getBatchNumber());
				facilityStockAdjustHistoryDto.setAdjustedQuantity(facilityStockAdjustment.getAdjustStockQuantity());
				facilityStockAdjustHistoryDto.setPreviousStock(facilityStockAdjustment.getCurrentQuantity());
				if (facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster().getId() == 1) {
					facilityStockAdjustHistoryDto.setNewStock(facilityStockAdjustment.getCurrentQuantity()
							+ facilityStockAdjustment.getAdjustStockQuantity());
				}
				if (facilityStockAdjustment.getFacilityStockAdjustmentTypeReason() != null) {
					facilityStockAdjustHistoryDto.setReason(
							facilityStockAdjustment.getFacilityStockAdjustmentTypeReason().getStockAdjustmentReason());
				}
				if (facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster() != null) {
					facilityStockAdjustHistoryDto
							.setType(facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster().getType());
				}
				facilityStockAdjustHistoryDto.setRemark(facilityStockAdjustment.getRemark());
				LoginResponseDto userDetails = UserUtils.getLoggedInUserDetails();

				if (userDetails.getFacilityTypeId() == FacilityTypeEnum.SACS.getFacilityType()) {
					if (facilityStockAdjustment.getCreatedTime() != null) {
						facilityStockAdjustHistoryDto
								.setAdjustedDate(facilityStockAdjustment.getCreatedTime().toLocalDate());
					}
				} else {
					facilityStockAdjustHistoryDto
							.setAdjustedDate(facilityStockAdjustment.getDateOfAdditionOrConsumption());
				}
				if (facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster().getId() == 1L) {
					Long quantity = facilityStockAdjustment.getCurrentQuantity()
							+ facilityStockAdjustment.getAdjustStockQuantity();
					facilityStockAdjustHistoryDto.setNewStock(quantity);
				} else if (facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster().getId() == 2L
						|| facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster().getId() == 3L
						|| facilityStockAdjustment.getFacilityStockAdjustmentTypeMaster().getId() == 5L) {
					Long quantity = 0L;
					if (facilityStockAdjustment.getCurrentQuantity() > facilityStockAdjustment
							.getAdjustStockQuantity()) {
						quantity = facilityStockAdjustment.getCurrentQuantity()
								- facilityStockAdjustment.getAdjustStockQuantity();
						facilityStockAdjustHistoryDto.setNewStock(quantity);
					}
				}
				facilityStockAdjustHistoryDto.setTesting(facilityStockAdjustment.getTestingQuantity());
				facilityStockAdjustHistoryDto.setQa(facilityStockAdjustment.getQaQuantity());
				facilityStockAdjustHistoryDto.setControl(facilityStockAdjustment.getControlQuantity());
				facilityStockAdjustHistoryDto.setWastage(facilityStockAdjustment.getWastageQuantity());
				facilityStockAdjustHistoryDto.setForBeneficiary(facilityStockAdjustment.getBeneficiaryQuantity());
				facilityStockAdjustHistoryDto.setOtherQuantity(facilityStockAdjustment.getOtherQuantity());
				facilityStockAdjustHistoryDto.setBulkDispensed(facilityStockAdjustment.getBulkDispenseQuantity());
				facilityStockAdjustHistoryDtos.add(facilityStockAdjustHistoryDto);
			});
		}
		return facilityStockAdjustHistoryDtos;
	}

}
