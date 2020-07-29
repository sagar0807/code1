package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import gov.naco.soch.dto.AcceptConsignmentDto;
import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.ConsignmentBatchDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.ReceiptDto;
import gov.naco.soch.dto.ReceiptSupplierDto;
import gov.naco.soch.entity.ConsignmentStatusMaster;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.ContractProductSchedule;
import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.entity.DispatchReceiptRemark;
import gov.naco.soch.entity.DispatchStatusMaster;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.Grn1StatusMaster;
import gov.naco.soch.entity.Grn2StatusMaster;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.ReceiptBatch;
import gov.naco.soch.entity.ReceiptStatusMaster;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.inventory.service.ReceiptService;
import gov.naco.soch.util.UserUtils;

public class ReceiptMapperUtil {

	@Autowired
	ReceiptService receiptService;

	public static List<ReceiptSupplierDto> mappDispatchListToReceiptSupplierDto(List<Receipt> receiptList,
			String user) {
		List<ReceiptSupplierDto> receiptSupplierDtos = new ArrayList<ReceiptSupplierDto>();
		if (receiptList != null) {
			LoginResponseDto userDetails = UserUtils.getLoggedInUserDetails();
			for (Receipt receipt : receiptList) {
				ReceiptSupplierDto receiptSupplierDto = new ReceiptSupplierDto();
				receiptSupplierDto.setReceiptId(receipt.getId());
				Grn1StatusMaster grn1StatusMaster = receipt.getGrn1StatusMaster();
				receiptSupplierDto.setGrn1(grn1StatusMaster.getStatus());
				if (userDetails.getFacilityTypeId() == FacilityTypeEnum.SACS.getFacilityType()) {
					Grn2StatusMaster grn2StatusMaster = receipt.getGrn2StatusMaster();
					if (grn2StatusMaster != null) {
						receiptSupplierDto.setGrn2(grn2StatusMaster.getStatus());
					}
				}
				Dispatch dispatch = receipt.getDispatch();
				receiptSupplierDto.setDispatchId(dispatch.getDispatchId());
				receiptSupplierDto.setStnNo(dispatch.getStnNumber());
				receiptSupplierDto.setInvoiceNo(dispatch.getInvoiceNumber());
				ContractProductSchedule contractProductSchedule = dispatch.getContractProductSchedule();
				ContractProduct contractProduct = contractProductSchedule.getContractProduct();
				Set<ContractProduct> contractProducts = new HashSet<ContractProduct>();
				contractProducts.add(contractProduct);
				receiptSupplierDto.setProducts(mapContractProductsToreceiptSupplierDto(contractProducts));
				ReceiptStatusMaster receiptStatusMaster = receipt.getReceiptStatusMaster();
				receiptSupplierDto.setReceiptStatus(receiptStatusMaster.getStatus());
				receiptSupplierDto.setLastActionDate(receipt.getModifiedTime());
				receiptSupplierDtos.add(receiptSupplierDto);
			}
		}
		return receiptSupplierDtos;
	}

	private static List<String> mapContractProductsToreceiptSupplierDto(Set<ContractProduct> contractProducts) {
		List<String> products = new ArrayList<String>();
		for (ContractProduct contractProduct : contractProducts) {
			Product product = contractProduct.getProduct();
			String productName = product.getProductName();
			products.add(productName);
		}
		return products;
	}

	public static Set<DispatchReceiptRemark> mapReceiptDtoToDispatchReceiptRemark(@Valid ReceiptDto receiptDto,
			Dispatch dispatch, Receipt receipt, Integer receiptStatusId, Integer dispatchStatusId) {

		Set<DispatchReceiptRemark> remarks = new HashSet<>();
		DispatchReceiptRemark remark = new DispatchReceiptRemark();
		remark.setRemarks(receiptDto.getRemark());
		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		dispatchStatusMaster.setId(dispatchStatusId);
		ReceiptStatusMaster receiptStatusMaster = new ReceiptStatusMaster();
		receiptStatusMaster.setId(receiptStatusId);
		remark.setReceiptStatusMaster(receiptStatusMaster);
		remark.setDispatchStatusMaster(dispatchStatusMaster);
		remark.setDispatch(dispatch);
		remark.setReceipt(receipt);
		remarks.add(remark);
		return remarks;
	}

	public static Set<ReceiptBatch> mapBatchDtoToReceiptBatches(List<BatchDto> batches, Receipt receipt) {
		Set<ReceiptBatch> receiptBatches = new HashSet<>();
		if (batches != null) {
			batches.forEach(batch -> {
				ReceiptBatch receiptBatch = new ReceiptBatch();
				receiptBatch.setBatchNumber(batch.getBatchNumber());
				receiptBatch.setBatchExpiryDate(batch.getExpiryDate());
				receiptBatch.setBatchManufactureDate(batch.getManufactureDate());
				receiptBatch.setDispatchedQuantity(batch.getQuantity());
				receiptBatch.setDamagedQuantity(batch.getDamagedQuantity());
				receiptBatch.setGrn1Quantity(batch.getReceivedQuantity());
				receiptBatch.setIsActive(true);
				receiptBatch.setReceipt(receipt);
				receiptBatches.add(receiptBatch);
			});
		}
		return receiptBatches;
	}

	public static Dispatch mapAcceptConsignmentDtoToDispatch(Dispatch dispatch,
			AcceptConsignmentDto acceptConsignmentDto) {
		DispatchReceiptRemark dispatchReceiptRemark = new DispatchReceiptRemark();
		dispatchReceiptRemark.setRemarks(acceptConsignmentDto.getRemarks());
		dispatchReceiptRemark.setCreatedTime(LocalDateTime.now());
		Set<DispatchReceiptRemark> dispatchReceiptRemarks = dispatch.getDispatchReceiptRemarks();
		dispatchReceiptRemarks.add(dispatchReceiptRemark);
		dispatch.setDispatchReceiptRemarks(dispatchReceiptRemarks);
		// dispatch status,consignment status = GRN2
		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		dispatchStatusMaster.setId(2);
		dispatch.setDispatchStatusMaster(dispatchStatusMaster);
		ConsignmentStatusMaster consignmentStatusMaster = new ConsignmentStatusMaster();
		consignmentStatusMaster.setId(3);
		dispatch.setConsignmentStatusMaster(consignmentStatusMaster);
		// Update Grn2 status in receipt
		System.out.println("Before mapDispatchReceiptsToReceipts");
		Set<Receipt> receipts = mapDispatchReceiptsToReceipts(dispatch.getReceipts(),
				acceptConsignmentDto.getConsignmentBatches());
		dispatch.setReceipts(receipts);
		// Dispatch status tracking

		return dispatch;
	}

	public static Set<Receipt> mapDispatchReceiptsToReceipts(Set<Receipt> receipts,
			List<ConsignmentBatchDto> consignmentBatchDtoList) {
		if (receipts != null) {
			for (Receipt receipt : receipts) {
				Grn2StatusMaster grn2StatusMaster = new Grn2StatusMaster();
				grn2StatusMaster.setId(1);
				// Grn2_date
				receipt.setGrn2StatusMaster(grn2StatusMaster);
				// Update receipt batch update
				Set<ReceiptBatch> receiptBatchs = ReceiptMapperUtil.mapReceiptToReceiptBatchs(receipt,
						consignmentBatchDtoList);
				receipt.setReceiptBatches(receiptBatchs);

			}
		}
		return receipts;
	}

	public static Set<ReceiptBatch> mapReceiptToReceiptBatchs(Receipt receipt,
			List<ConsignmentBatchDto> consignmentBatchDtoList) {
		Set<ReceiptBatch> receiptBatchs = receipt.getReceiptBatches();
		if (receiptBatchs != null) {
			for (ConsignmentBatchDto consignmentBatchDto : consignmentBatchDtoList) {
				for (ReceiptBatch receiptBatch : receiptBatchs) {
					if (receiptBatch.getId() == consignmentBatchDto.getReceiptBatchId()) {
						receiptBatch.setGrn2Quantity(consignmentBatchDto.getReceivedQuantity());
						receiptBatch.setDamagedQuantity(consignmentBatchDto.getDamagedQty());
					}
				}
			}
		}
		return receiptBatchs;
	}

	public static Set<FacilityStockTracking> mapReceiptBatchToFacilityStockTracking(
			AcceptConsignmentDto acceptConsignmentDto) {
		// Add facility_stock_tracking
		Set<FacilityStockTracking> facilityStockTrackings = new HashSet<>();
		for (ConsignmentBatchDto consignmentBatchDto : acceptConsignmentDto.getConsignmentBatches()) {
			FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
			facilityStockTracking.setBatchNumber(consignmentBatchDto.getReceiptBatchId().toString());
			Facility facility = new Facility();
			facility.setId(acceptConsignmentDto.getFacilityId());
			facilityStockTracking.setFacility(facility);
			FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Receive_From_Supllier.getFacilityStockTrackingTypeId());
			facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
			Product product = new Product();
			product.setId(consignmentBatchDto.getProductId());
			if (consignmentBatchDto.getReceivedQuantity() != null) {
				facilityStockTracking.setQuantity(consignmentBatchDto.getReceivedQuantity().doubleValue());
			}
			facilityStockTracking.setProduct(product);
			facilityStockTracking.setTransactionDate(LocalDate.now());
			facilityStockTrackings.add(facilityStockTracking);
		}

		return facilityStockTrackings;
	}

	public static List<FacilityStockTracking> mapToFacilityStockTracking(@Valid ReceiptDto receiptDto, Long receiptId) {

		List<FacilityStockTracking> facilityStockTrackings = new ArrayList<>();
		for (BatchDto batch : receiptDto.getBatches()) {
			FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
			facilityStockTracking.setBatchNumber(batch.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(receiptDto.getFacilityId());
			facilityStockTracking.setFacility(facility);
			FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Receive_From_Supllier.getFacilityStockTrackingTypeId());
			facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
			Product product = new Product();
			product.setId(receiptDto.getProductId());
			facilityStockTracking.setProduct(product);
			facilityStockTracking.setBatchNumber(batch.getBatchNumber());
			facilityStockTracking.setTransactionDate(LocalDate.now());
			facilityStockTracking.setIsActive(true);
			facilityStockTracking.setIsDelete(false);
			facilityStockTracking.setReferenceNo(receiptId);
			if (batch.getReceivedQuantity() != null) {
				facilityStockTracking.setQuantity(batch.getReceivedQuantity().doubleValue());
			}
			facilityStockTrackings.add(facilityStockTracking);
		}

		return facilityStockTrackings;
	}

	public static FacilityStock mapToFacilityStock(@Valid FacilityStock facilityStock, ReceiptDto receiptDto,
			BatchDto batch, Long id) {

		if (facilityStock != null) {
			if (batch.getReceivedQuantity() != null) {
				if (facilityStock.getCurrentQuantity() != null) {
					facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() + batch.getReceivedQuantity());
				} else {
					facilityStock.setCurrentQuantity(batch.getReceivedQuantity().doubleValue());
				}
			}
			if (batch.getDamagedQuantity() != null) {
				if (facilityStock.getDamagedQuantity() != null) {
					facilityStock.setDamagedQuantity(facilityStock.getDamagedQuantity() + batch.getDamagedQuantity());
				} else {
					facilityStock.setDamagedQuantity(batch.getDamagedQuantity().doubleValue());
				}
			}
		} else {
			facilityStock = new FacilityStock();
			facilityStock.setBatchNumber(batch.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(receiptDto.getFacilityId());
			facilityStock.setFacility(facility);
			Product product = new Product();
			product.setId(receiptDto.getProductId());
			facilityStock.setProduct(product);
			if (batch.getDamagedQuantity() != null) {
				facilityStock.setDamagedQuantity(batch.getDamagedQuantity().doubleValue());
			}
			facilityStock.setManufacturingDate(batch.getManufactureDate());
			facilityStock.setNumberOfBoxes(batch.getNumberOfBoxes());
			facilityStock.setIsActive(true);
			facilityStock.setIsDelete(false);
			facilityStock.setExpiredDate(batch.getExpiryDate());
			if (batch.getReceivedQuantity() != null) {
				facilityStock.setCurrentQuantity(batch.getReceivedQuantity().doubleValue());
			}
		}
		return facilityStock;
	}

	public static String createSearchQuery(List<Long> consigneeIdList, String stnNumber, String invoiceNumber,
			String productName) {
		String formattedString = consigneeIdList.toString().replace("[", "").replace("]", "").trim();
		String searchQuery = "select * from soch.receipt r join soch.dispatch d on(r.dispatch_id=d.dispatch_id)join soch.contract_product cp"
				+ " on (d.contract_product_id=cp.id) join soch.product p on(p.id=cp.product_id)"
				+ " where d.ship_consignee_id IN (" + formattedString + ")";
		if (stnNumber != null) {
			stnNumber = stnNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(d.stn_number) like '%" + stnNumber + "%'";
		}
		if (invoiceNumber != null) {
			invoiceNumber = invoiceNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(d.invoice_number) like '%" + invoiceNumber + "%'";
		}
		if (productName != null) {
			productName = productName.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(p.product_name) like '%" + productName + "%'";
		}
		return searchQuery;
	}

}
