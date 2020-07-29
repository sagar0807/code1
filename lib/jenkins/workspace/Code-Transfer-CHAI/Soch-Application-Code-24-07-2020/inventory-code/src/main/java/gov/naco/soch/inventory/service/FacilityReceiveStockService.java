package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.FacilityProductBatchDto;
import gov.naco.soch.dto.FacilityReceiveStockListDto;
import gov.naco.soch.entity.FacilityConsignmentStatusMaster;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.entity.FacilityDispatchStatusMaster;
import gov.naco.soch.entity.FacilityDispatchStatusTracking;
import gov.naco.soch.entity.FacilityGrnStatusMaster;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.FacilityReceiptProduct;
import gov.naco.soch.entity.FacilityReceiptProductBatch;
import gov.naco.soch.entity.FacilityReceiptStatusMaster;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.ReconciliationStatusMaster;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.inventory.mapper.FacilityReceiptMapperUtil;
import gov.naco.soch.repository.FacilityDispatchReceiptRemarkRepository;
import gov.naco.soch.repository.FacilityDispatchRepository;
import gov.naco.soch.repository.FacilityDispatchStatusTrackingRepository;
import gov.naco.soch.repository.FacilityReceiptRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;

@Service
@Transactional
public class FacilityReceiveStockService {

	@Autowired
	private FacilityDispatchRepository facilityDispatchRepository;

	@Autowired
	private FacilityReceiptRepository facilityReceiptRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityDispatchStatusTrackingRepository facilityDispatchStatusTrackingRepository;

	@Autowired
	private FacilityDispatchReceiptRemarkRepository facilityDispatchReceiptRemarkRepository;

	public List<FacilityReceiveStockListDto> getAllDispatchedStocks(Long facilityId, String facilityType,
			String stnNumber, String consignorName, String indentNumber, LocalDate dispatchDate) {

		List<Long> facilityTypeIds = new ArrayList<>();
		List<Long> excludedFacilityTypeIds = new ArrayList<>();
		switch (facilityType) {
		case "sacs":
			facilityTypeIds.add(FacilityTypeEnum.SACS.getFacilityType());
			break;
		case "warehouse":
			facilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
			break;
		case "lab":
			facilityTypeIds.add(FacilityTypeEnum.LABORATORY_EID.getFacilityType());
			facilityTypeIds.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
			facilityTypeIds.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());
			break;
		case "supplier":
			facilityTypeIds.add(FacilityTypeEnum.SUPPLIER.getFacilityType());
			break;
		case "facility":
			excludedFacilityTypeIds.add(FacilityTypeEnum.SACS.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.SUPPLIER.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.LABORATORY_EID.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());
			break;
		default:
			break;

		}
		List<FacilityDispatch> dispatchedStocks = new ArrayList<>();
		List<Long> statusIds = Arrays.asList(1L, 2L);
		if (stnNumber == null && indentNumber == null && consignorName == null && dispatchDate == null) {
			if (!facilityType.equals("facility")) {
				dispatchedStocks = facilityDispatchRepository
						.findAllByConsignee_IdAndFacilityDispatchStatusMaster_IdInAndConsignor_FacilityType_IdInOrderByFacilityDispatchIdDesc(
								facilityId, statusIds, facilityTypeIds);
			} else {
				dispatchedStocks = facilityDispatchRepository
						.findAllByConsignee_IdAndFacilityDispatchStatusMaster_IdInAndConsignor_FacilityType_IdNotInOrderByFacilityDispatchIdDesc(
								facilityId, statusIds, excludedFacilityTypeIds);
			}
		} else {
			String searchQuery = FacilityReceiptMapperUtil.createSearchQuery(facilityType, facilityId, statusIds,
					facilityTypeIds, excludedFacilityTypeIds, stnNumber, consignorName, indentNumber, dispatchDate);
			dispatchedStocks = facilityDispatchRepository.findFacilityDispatchBySearchValue(searchQuery);
		}

		List<FacilityReceiveStockListDto> facilityReceiveStockDtos = FacilityReceiptMapperUtil
				.mapFacilityDispatchToFacilityReceiveStockDto(dispatchedStocks);
		facilityReceiveStockDtos.forEach(facilityReceiveStockDto -> {
			FacilityReceipt facilityReceipt = facilityReceiptRepository
					.findByFacilityDispatch_FacilityDispatchId(facilityReceiveStockDto.getFacilityDispatchId());

			if (facilityReceipt != null) {
				facilityReceiveStockDto.setReceiptStatus(facilityReceipt.getFacilityReceiptStatusMaster().getStatus());
			} else {
				facilityReceiveStockDto.setReceiptStatus("Pending");
			}
		});
		return facilityReceiveStockDtos;
	}

	public FacilityReceiveStockListDto saveFacilityReceiptDetails(@Valid FacilityReceiveStockListDto receiptDto) {

		FacilityConsignmentStatusMaster facilityConsignmentStatusMaster = new FacilityConsignmentStatusMaster();
		FacilityDispatchStatusMaster facilityDispatchStatusMaster = new FacilityDispatchStatusMaster();
		FacilityGrnStatusMaster facilityGrnStatusMaster = new FacilityGrnStatusMaster();
		FacilityReceiptStatusMaster facilityReceiptStatusMaster = new FacilityReceiptStatusMaster();
		boolean quantityMismatch = false;
		boolean damagedQuantity = false;
		boolean quantityMismatchAndDamaged = false;

		Long consignmentStatusId;
		Long dispatchStatusId;
		Long grnStatusId;
		Long receiptStatusId;

		for (FacilityProductBatchDto receiptProduct : receiptDto.getProducts()) {
			for (BatchDto batch : receiptProduct.getBatches()) {
				Long quantity = batch.getReceivedQuantity() + batch.getDamagedQuantity();

				if (batch.getDamagedQuantity() != null && batch.getDamagedQuantity() != 0
						&& batch.getQuantity().intValue() != quantity.intValue()) {
					quantityMismatchAndDamaged = true;

				} else if ((batch.getDamagedQuantity() == null || batch.getDamagedQuantity().intValue() == 0)
						&& batch.getQuantity().intValue() != quantity.intValue()) {
					quantityMismatch = true;

				} else if (batch.getDamagedQuantity() != null && batch.getDamagedQuantity() != 0
						&& batch.getQuantity().intValue() == quantity.intValue()) {
					damagedQuantity = true;

				}

				if (quantityMismatch && quantityMismatchAndDamaged && damagedQuantity) {
					break;
				}

			}
			if (quantityMismatch && quantityMismatchAndDamaged && damagedQuantity) {
				break;
			}
		}

		if (quantityMismatch && !quantityMismatchAndDamaged && !damagedQuantity) {
			consignmentStatusId = 2L;
			dispatchStatusId = 4L;
			receiptStatusId = 5L;
			grnStatusId = 4L;
		} else if (damagedQuantity && !quantityMismatch && !quantityMismatchAndDamaged) {
			consignmentStatusId = 2L;
			dispatchStatusId = 3L;
			receiptStatusId = 7L;
			grnStatusId = 4L;
		} else if (quantityMismatchAndDamaged && !damagedQuantity && !quantityMismatch) {
			consignmentStatusId = 2L;
			dispatchStatusId = 4L;
			receiptStatusId = 8L;
			grnStatusId = 4L;
		} else if (!quantityMismatchAndDamaged && !damagedQuantity && !quantityMismatch) {
			consignmentStatusId = 2L;
			dispatchStatusId = 3L;
			receiptStatusId = 2L;
			grnStatusId = 4L;
		} else if (quantityMismatchAndDamaged && damagedQuantity && quantityMismatch) {
			consignmentStatusId = 2L;
			dispatchStatusId = 3L;
			receiptStatusId = 8L;
			grnStatusId = 4L;
		} else {
			consignmentStatusId = 2L;
			dispatchStatusId = 3L;
			receiptStatusId = 8L;
			grnStatusId = 4L;
		}
		facilityConsignmentStatusMaster.setId(consignmentStatusId);
		facilityDispatchStatusMaster.setId(dispatchStatusId);
		facilityReceiptStatusMaster.setId(receiptStatusId);
		facilityGrnStatusMaster.setId(grnStatusId);

		boolean isReconciled = true;
		FacilityReceipt facilityReceipt = FacilityReceiptMapperUtil.mapToFacilityReceiveStockListDtoToFacilityReceipt(
				receiptDto, facilityGrnStatusMaster, facilityReceiptStatusMaster);
		for (FacilityReceiptProduct product : facilityReceipt.getFacilityReceiptProducts()) {
			for (FacilityReceiptProductBatch batch : product.getFacilityReceiptProductBatches()) {
				if (batch.getGit() != null && batch.getGit() != 0) {
					isReconciled = false;
					if (!isReconciled) {
						break;
					}
				}
			}
		}
		if (!isReconciled) {
			ReconciliationStatusMaster reconciliationStatusMaster = new ReconciliationStatusMaster();
			reconciliationStatusMaster.setId(1);
			facilityReceipt.setReconciliationStatusMaster(reconciliationStatusMaster);
		}
		facilityReceipt = facilityReceiptRepository.save(facilityReceipt);

		FacilityDispatch facilityDispatch = facilityDispatchRepository
				.findByFacilityDispatchId(receiptDto.getFacilityDispatchId());
		facilityDispatch.setFacilityDispatchStatusMaster(facilityDispatchStatusMaster);
		facilityDispatch.setFacilityConsignmentStatusMaster(facilityConsignmentStatusMaster);
		facilityDispatchRepository.save(facilityDispatch);

		FacilityDispatchStatusTracking facilityDispatchStatusTracking = FacilityReceiptMapperUtil
				.mapToFacilityDispatchStatusTracking(facilityReceipt, receiptDto, facilityReceiptStatusMaster,
						facilityDispatch);
		facilityDispatchStatusTrackingRepository.save(facilityDispatchStatusTracking);

		FacilityDispatchReceiptRemark facilityDispatchReceiptRemark = FacilityReceiptMapperUtil
				.mapToFacilityDispatchReceiptRemark(facilityReceipt, receiptDto, facilityReceiptStatusMaster,
						facilityDispatch);
		facilityDispatchReceiptRemarkRepository.save(facilityDispatchReceiptRemark);

		// Update Facility Stock information
		String receiverType;
		Long consigneeFacilityId = null;
		// Consignee Facility Stock
		if (facilityDispatch.getConsignee() != null) {
			consigneeFacilityId = facilityDispatch.getConsignee().getId();
		}

		receiverType = "consignee";
		for (FacilityProductBatchDto receiptProduct : receiptDto.getProducts()) {
			for (BatchDto batch : receiptProduct.getBatches()) {
				FacilityStockTracking consigneeFacilityStockTracking = FacilityReceiptMapperUtil
						.mapToFacilityStockTracking(batch, consigneeFacilityId, receiptProduct.getProductId(),
								receiverType, facilityReceipt.getFacilityReceiptId());
				facilityStockTrackingRepository.save(consigneeFacilityStockTracking);
				FacilityStock consigneeFacilityStock = facilityStockRepository
						.findByBatchNumberAndProduct_IdAndFacility_Id(batch.getBatchNumber(),
								receiptProduct.getProductId(), consigneeFacilityId);
				consigneeFacilityStock = FacilityReceiptMapperUtil.mapToFacilityStock(batch, consigneeFacilityStock,
						consigneeFacilityId, receiptProduct.getProductId(), receiverType, facilityReceiptStatusMaster);
				facilityStockRepository.save(consigneeFacilityStock);
			}
		}

		// Consignor facility Stock
		Long consignorFacilityId = null;
		if (facilityDispatch.getConsignor() != null) {
			consignorFacilityId = facilityDispatch.getConsignor().getId();
		}
		receiverType = "consignor";
		for (FacilityProductBatchDto receiptProduct : receiptDto.getProducts()) {
			for (BatchDto batch : receiptProduct.getBatches()) {
				FacilityStockTracking consignorFacilityStockTracking = FacilityReceiptMapperUtil
						.mapToFacilityStockTracking(batch, consignorFacilityId, receiptProduct.getProductId(),
								receiverType, facilityReceipt.getFacilityReceiptId());
				facilityStockTrackingRepository.save(consignorFacilityStockTracking);
				FacilityStock consignorFacilityStock = facilityStockRepository
						.findByBatchNumberAndProduct_IdAndFacility_Id(batch.getBatchNumber(),
								receiptProduct.getProductId(), consignorFacilityId);
				consignorFacilityStock = FacilityReceiptMapperUtil.mapToFacilityStock(batch, consignorFacilityStock,
						consignorFacilityId, receiptProduct.getProductId(), receiverType, facilityReceiptStatusMaster);
				facilityStockRepository.save(consignorFacilityStock);
			}
		}

		return receiptDto;
	}

	public List<FacilityReceiveStockListDto> getReceiptHistory(Long facilityId, String facilityType, String stnNumber,
			String indentNumber, String productName) {

		List<Long> facilityTypeIds = new ArrayList<>();
		List<Long> excludedFacilityTypeIds = new ArrayList<>();
		switch (facilityType) {
		case "sacs":
			facilityTypeIds.add(FacilityTypeEnum.SACS.getFacilityType());
			break;
		case "warehouse":
			facilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
			break;
		case "supplier":
			facilityTypeIds.add(FacilityTypeEnum.SUPPLIER.getFacilityType());
			break;
		case "lab":
			facilityTypeIds.add(FacilityTypeEnum.LABORATORY_EID.getFacilityType());
			facilityTypeIds.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
			facilityTypeIds.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());
			break;
		case "facility":
			excludedFacilityTypeIds.add(FacilityTypeEnum.SACS.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.SUPPLIER.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.LABORATORY_EID.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());

			break;
		default:
			break;

		}
		List<FacilityReceipt> receiptList = new ArrayList<>();
		if (stnNumber == null && indentNumber == null && productName == null) {
			if (!facilityType.equals("facility")) {
				receiptList = facilityReceiptRepository
						.findAllByFacilityDispatch_Consignee_IdAndFacilityDispatch_Consignor_FacilityType_IdInOrderByFacilityReceiptIdDesc(
								facilityId, facilityTypeIds);

			} else {
				receiptList = facilityReceiptRepository
						.findAllByFacilityDispatch_Consignee_IdAndFacilityDispatch_Consignor_FacilityType_IdNotInOrderByFacilityReceiptIdDesc(
								facilityId, excludedFacilityTypeIds);
			}
		} else {

			String searchQuery = FacilityReceiptMapperUtil.createSearchQueryForReceiptHistory(facilityType,facilityId,
					facilityTypeIds, excludedFacilityTypeIds, stnNumber, indentNumber, productName);
			receiptList = facilityReceiptRepository.findReceiptHistoryBySearchValue(searchQuery);

		}
		List<FacilityReceiveStockListDto> facilityReceiveStockListDtos = FacilityReceiptMapperUtil
				.mapFacilityReceiptToFacilityReceiveStockListDto(receiptList);
		return facilityReceiveStockListDtos;
	}

}
