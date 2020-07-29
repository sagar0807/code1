package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import gov.naco.soch.dto.FacilityReconciliationDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.FacilityReceiptProduct;
import gov.naco.soch.entity.FacilityReceiptProductBatch;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.Product;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;

public class FacilityReconciliationMapperUtil {

	public static List<FacilityReconciliationDto> mapFacilityReceiptToFacilityReconciliationDto(
			List<FacilityReceipt> receiptList) {
		List<FacilityReconciliationDto> receiptDtoList = new ArrayList<FacilityReconciliationDto>();
		if (receiptList != null) {
			receiptList.forEach(receipt -> {
				FacilityReconciliationDto facilityReconciliationDto = new FacilityReconciliationDto();
				Long git = 0L;
				if (receipt.getFacilityDispatch() != null) {
					facilityReconciliationDto.setStnNumber(receipt.getFacilityDispatch().getStnNumber());
					facilityReconciliationDto
							.setFacilityDispatchId(receipt.getFacilityDispatch().getFacilityDispatchId());
					if (receipt.getFacilityDispatch().getConsignee() != null) {
						facilityReconciliationDto.setConsigneeId(receipt.getFacilityDispatch().getConsignee().getId());
						facilityReconciliationDto
								.setConsigneeName(receipt.getFacilityDispatch().getConsignee().getName());
					}
					if (receipt.getFacilityDispatch().getConsignor() != null) {
						facilityReconciliationDto.setConsignorId(receipt.getFacilityDispatch().getConsignor().getId());
						facilityReconciliationDto
								.setConsignorName(receipt.getFacilityDispatch().getConsignor().getName());
					}
				}
				if (receipt.getReconciliationStatusMaster() != null) {
					facilityReconciliationDto
							.setReconciliationStatus(receipt.getReconciliationStatusMaster().getStatus());
				}
				facilityReconciliationDto.setFacilityReceiptId(receipt.getFacilityReceiptId());
				for (FacilityReceiptProduct product : receipt.getFacilityReceiptProducts()) {
					for (FacilityReceiptProductBatch batch : product.getFacilityReceiptProductBatches()) {
						if (batch.getGit() != null) {
							git = git + batch.getGit();
						}
						/*
						 * if (batch.getDamagedQuantity() != null) { git = git +
						 * batch.getDamagedQuantity(); }
						 */
					}
				}

				facilityReconciliationDto.setGit(git);
				receiptDtoList.add(facilityReconciliationDto);
			});
		}
		return receiptDtoList;
	}

	public static FacilityStockTracking mapToFacilityStockTracking(FacilityReceiptProductBatch batch, Long facilityId,
			String receiverType) {
		FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
		FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
		facilityStockTracking.setBatchNumber(batch.getBatchNumber());
		Facility facility = new Facility();
		facility.setId(facilityId);
		facilityStockTracking.setFacility(facility);

		Product product = new Product();
		if (batch.getFacilityReceiptProduct() != null) {
			if (batch.getFacilityReceiptProduct().getProduct() != null) {
				product.setId(batch.getFacilityReceiptProduct().getProduct().getId());
			}
		}
		facilityStockTracking.setProduct(product);
		facilityStockTracking.setBatchNumber(batch.getBatchNumber());
		facilityStockTracking.setIsActive(true);
		facilityStockTracking.setIsDelete(false);
		if (batch.getGit() != null) {
			facilityStockTracking.setQuantity(batch.getGit().doubleValue());
			// facilityStockTracking.setReferenceNo(facilityReceipt.getFacilityReceiptId());
			if (receiverType == "consignee") {
				facilityStockTracking.setQuantity(batch.getGit().doubleValue());
				facilityStockTrackingType
						.setId(FacilityStockTrackingTypeEnum.Reconciliation.getFacilityStockTrackingTypeId());
			} else if (receiverType == "consignor") {
				facilityStockTracking.setQuantity(-batch.getGit().doubleValue());
				facilityStockTrackingType.setId(
						FacilityStockTrackingTypeEnum.Git_Reconciliation_By_Consignor.getFacilityStockTrackingTypeId());
			} else if (receiverType == "consignorstock") {
				facilityStockTracking.setQuantity(-batch.getGit().doubleValue());
				facilityStockTrackingType
						.setId(FacilityStockTrackingTypeEnum.Reconciliation.getFacilityStockTrackingTypeId());
			} else if (receiverType == "sacsLostInTransit") {
				facilityStockTracking.setQuantity(-batch.getGit().doubleValue());
				facilityStockTrackingType.setId(
						FacilityStockTrackingTypeEnum.Reconciliation.getFacilityStockTrackingTypeId());
			} else if (receiverType == "sacs") {
				facilityStockTracking.setQuantity(-batch.getGit().doubleValue());
				facilityStockTrackingType.setId(
						FacilityStockTrackingTypeEnum.Reconciliation.getFacilityStockTrackingTypeId());
			}
			
		}

		if (batch.getFacilityReceiptProduct() != null) {
			if (batch.getFacilityReceiptProduct().getFacilityReceipt() != null) {
				facilityStockTracking
						.setReferenceNo(batch.getFacilityReceiptProduct().getFacilityReceipt().getFacilityReceiptId());
			}
		}
		facilityStockTracking.setTransactionDate(LocalDate.now());
		facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
		return facilityStockTracking;
	}

	public static FacilityDispatchReceiptRemark mapToDispatchReceiptRemark(
			@Valid FacilityReconciliationDto facilityReconciliationDto,
			FacilityReceiptProductBatch facilityReceiptProductBatch) {
		FacilityDispatchReceiptRemark facilityDispatchReceiptRemark = new FacilityDispatchReceiptRemark();
		FacilityDispatch facilityDispatch = new FacilityDispatch();
		facilityDispatch.setFacilityDispatchId(facilityReconciliationDto.getFacilityDispatchId());
		facilityDispatchReceiptRemark.setFacilityDispatch(facilityDispatch);
		facilityDispatchReceiptRemark.setRemarks(facilityReconciliationDto.getRemarks());
		FacilityReceipt facilityReceipt = new FacilityReceipt();
		facilityReceipt.setFacilityReceiptId(facilityReconciliationDto.getFacilityReceiptId());
		facilityDispatchReceiptRemark.setFacilityReceipt(facilityReceipt);
		return facilityDispatchReceiptRemark;
	}

	public static String createSearchQuery(Long facilityId, List<Long> consignorIdList, String stnNumber,
			String consignor, String consignee) {
		String formattedString = consignorIdList.toString().replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();
		String serachQuery = "select * from soch.facility_receipt fr join soch.facility_dispatch fd on"
				+ "(fr.facility_dispatch_id=fd.facility_dispatch_id) join soch.facility f on(f.id=fd.consignor_facility_id) "
				+ "join soch.facility f2 on(f2.id=fd.consignee_facility_id) where (fd.consignor_facility_id IN ("
				+ formattedString + ") or fd.consignee_facility_id IN (" + formattedString
				+ ") )and fr.facility_receipt_status_id in (5,8)";
		if (stnNumber != null) {
			stnNumber=stnNumber.toLowerCase().trim();
			serachQuery = serachQuery + " and LOWER(fd.stn_number) like'%" + stnNumber + "%'";
		}
		if (consignor != null ) {
			consignor=consignor.toLowerCase().trim();
			serachQuery = serachQuery + " and LOWER(f.name) like'%" + consignor + "%'";
		}
		if(consignee != null) {
			consignee=consignee.toLowerCase().trim();
			serachQuery = serachQuery + " and LOWER(f2.name) like'%" + consignee + "%'";
		}

		return serachQuery;
	}

}
