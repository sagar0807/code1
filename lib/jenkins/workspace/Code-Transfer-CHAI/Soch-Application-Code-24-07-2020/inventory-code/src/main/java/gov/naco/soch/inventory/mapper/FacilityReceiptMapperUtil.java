package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.DispatchRemarkDto;
import gov.naco.soch.dto.FacilityProductBatchDto;
import gov.naco.soch.dto.FacilityReceiveStockListDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchProduct;
import gov.naco.soch.entity.FacilityDispatchProductBatch;
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
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;

public class FacilityReceiptMapperUtil {

	public static List<FacilityReceiveStockListDto> mapFacilityDispatchToFacilityReceiveStockDto(
			List<FacilityDispatch> dispatchedStocks) {
		List<FacilityReceiveStockListDto> facilityReceiveStockDtos = new ArrayList<FacilityReceiveStockListDto>();
		if (dispatchedStocks != null) {
			dispatchedStocks.forEach(dispatchedStock -> {
				FacilityReceiveStockListDto facilityReceiveStockDto = mapToFacilityReceiveStockListDto(dispatchedStock,
						null);
				facilityReceiveStockDtos.add(facilityReceiveStockDto);
			});
		}
		return facilityReceiveStockDtos;
	}

	public static FacilityReceiveStockListDto mapToFacilityReceiveStockListDto(FacilityDispatch dispatchedStock,
			FacilityReceipt receipt) {
		FacilityReceiveStockListDto facilityReceiveStockDto = new FacilityReceiveStockListDto();
		facilityReceiveStockDto.setIndentNumber(dispatchedStock.getIndentNum());
		facilityReceiveStockDto.setStnNumber(dispatchedStock.getStnNumber());

		if (dispatchedStock.getConsignor() != null) {
			facilityReceiveStockDto.setConsignorId(dispatchedStock.getConsignor().getId());
			facilityReceiveStockDto.setConsignorName(dispatchedStock.getConsignor().getName());
			String consignorAddress = null;
			if (dispatchedStock.getConsignor().getAddress().getAddress() != null) {
				consignorAddress = dispatchedStock.getConsignor().getAddress().getAddress();
			}
			if (dispatchedStock.getConsignor().getAddress().getCity() != null) {
				if (consignorAddress != null) {
					consignorAddress += " " + dispatchedStock.getConsignor().getAddress().getCity();
				} else {
					consignorAddress = dispatchedStock.getConsignor().getAddress().getCity();
				}
			}
			if (dispatchedStock.getConsignor().getAddress().getDistrict().getName() != null) {
				if (consignorAddress != null) {
					consignorAddress += " " + dispatchedStock.getConsignor().getAddress().getDistrict().getName();
				} else {
					consignorAddress = dispatchedStock.getConsignor().getAddress().getDistrict().getName();
				}
			}
			if (dispatchedStock.getConsignor().getAddress().getState().getName() != null) {
				if (consignorAddress != null) {
					consignorAddress += " " + dispatchedStock.getConsignor().getAddress().getState().getName();
				} else {
					consignorAddress = dispatchedStock.getConsignor().getAddress().getState().getName();
				}
			}
			if (dispatchedStock.getConsignor().getAddress().getPincode() != null) {
				if (consignorAddress != null) {
					consignorAddress += " " + dispatchedStock.getConsignor().getAddress().getPincode();
				} else {
					consignorAddress = dispatchedStock.getConsignor().getAddress().getPincode();
				}
			}
			facilityReceiveStockDto.setConsignorAddress(consignorAddress);
		}
		if (dispatchedStock.getConsignee() != null) {
			facilityReceiveStockDto.setConsigneeId(dispatchedStock.getConsignee().getId());
			facilityReceiveStockDto.setConsigneeName(dispatchedStock.getConsignee().getName());
			String consigneeAddress = null;
			if (dispatchedStock.getConsignee().getAddress().getAddress() != null) {
				consigneeAddress = dispatchedStock.getConsignee().getAddress().getAddress();
			}
			if (dispatchedStock.getConsignee().getAddress().getCity() != null) {
				if (consigneeAddress != null) {
					consigneeAddress += " " + dispatchedStock.getConsignee().getAddress().getCity();
				} else {
					consigneeAddress = dispatchedStock.getConsignee().getAddress().getCity();
				}
			}
			if (dispatchedStock.getConsignee().getAddress().getDistrict().getName() != null) {
				if (consigneeAddress != null) {
					consigneeAddress += " " + dispatchedStock.getConsignee().getAddress().getDistrict().getName();
				} else {
					consigneeAddress = dispatchedStock.getConsignee().getAddress().getDistrict().getName();
				}
			}
			if (dispatchedStock.getConsignee().getAddress().getState().getName() != null) {
				if (consigneeAddress != null) {
					consigneeAddress += " " + dispatchedStock.getConsignee().getAddress().getState().getName();
				} else {
					consigneeAddress = dispatchedStock.getConsignee().getAddress().getState().getName();
				}
			}
			if (dispatchedStock.getConsignee().getAddress().getPincode() != null) {
				if (consigneeAddress != null) {
					consigneeAddress += " " + dispatchedStock.getConsignee().getAddress().getPincode();
				} else {
					consigneeAddress = dispatchedStock.getConsignee().getAddress().getPincode();
				}
			}
			facilityReceiveStockDto.setConsigneeAddress(consigneeAddress);
		}
		facilityReceiveStockDto.setTransporterName(dispatchedStock.getTransporterName());
		facilityReceiveStockDto.setTransporterPhone(dispatchedStock.getContactNum());
		if (dispatchedStock.getFacilityDispatchStatusMaster() != null) {
			facilityReceiveStockDto.setDispatchStatus(dispatchedStock.getFacilityDispatchStatusMaster().getStatus());
		}
		if (dispatchedStock.getFacilityConsignmentStatusMaster() != null) {
			facilityReceiveStockDto
					.setConsignmentStatus(dispatchedStock.getFacilityConsignmentStatusMaster().getStatus());

		}
		facilityReceiveStockDto.setAWBNumber(dispatchedStock.getAwbNum());
		if (dispatchedStock.getCreatedTime() != null) {
			facilityReceiveStockDto.setDispatchDate(dispatchedStock.getCreatedTime().toLocalDate());
		}
		facilityReceiveStockDto.setFacilityDispatchId(dispatchedStock.getFacilityDispatchId());

		facilityReceiveStockDto.setIndentDate(dispatchedStock.getIndentDate());
		if (receipt == null) {
			List<FacilityProductBatchDto> products = mapToFacilityProductBatchDto(
					dispatchedStock.getFacilityDispatchProducts());
			facilityReceiveStockDto.setProducts(products);
		}
		if (receipt != null) {
			facilityReceiveStockDto.setFacilityReciptId(receipt.getFacilityReceiptId());
			List<FacilityProductBatchDto> products = mapToFacilityProductBatchDto(receipt);
			facilityReceiveStockDto.setProducts(products);
			if (receipt.getCreatedTime() != null) {
				facilityReceiveStockDto.setReceiptDate(receipt.getCreatedTime().toLocalDate());

			}
			if (receipt.getFacilityReceiptStatusMaster() != null) {
				facilityReceiveStockDto.setReceiptStatus(receipt.getFacilityReceiptStatusMaster().getStatus());
			}
			if (receipt.getFacilityGrnStatusMaster() != null) {
				facilityReceiveStockDto.setGrnStatus(receipt.getFacilityGrnStatusMaster().getStatus());
			}
		}

		List<DispatchRemarkDto> remarks = new ArrayList<>();
		if (dispatchedStock.getFacilityDispatchReceiptRemarks() != null) {
			dispatchedStock.getFacilityDispatchReceiptRemarks().forEach(remark -> {
				DispatchRemarkDto dispatchRemarkDto = new DispatchRemarkDto();
				dispatchRemarkDto.setRemarks(remark.getRemarks());
				if (remark.getCreatedTime() != null) {
					dispatchRemarkDto.setDate(remark.getCreatedTime());
				}
				if (remark.getUserMaster1() != null) {
					dispatchRemarkDto.setUserId(remark.getUserMaster1().getId());
					dispatchRemarkDto.setUserName(remark.getUserMaster1().getFirstname());
				}

				remarks.add(dispatchRemarkDto);
			});
		}

		facilityReceiveStockDto.setRemarks(remarks);
		return facilityReceiveStockDto;
	}

	private static List<FacilityProductBatchDto> mapToFacilityProductBatchDto(FacilityReceipt receipt) {
		List<FacilityProductBatchDto> facilityProductBatchDtos = new ArrayList<>();
		if (receipt.getFacilityReceiptProducts() != null) {
			receipt.getFacilityReceiptProducts().forEach(receiptProduct -> {
				FacilityProductBatchDto facilityProductBatchDto = new FacilityProductBatchDto();
				Long receivedQuantity = 0L;
				Long dispatchedQuantity = 0L;
				if (receiptProduct.getProduct() != null) {
					facilityProductBatchDto.setProductId(receiptProduct.getProduct().getId());
					facilityProductBatchDto.setProductName(receiptProduct.getProduct().getProductName());
				}

				for (FacilityReceiptProductBatch batch : receiptProduct.getFacilityReceiptProductBatches()) {
					if (batch.getQuantityReceived() != null) {
						receivedQuantity = receivedQuantity + batch.getQuantityReceived();
					}
					if (batch.getDispatchedQuantity() != null) {
						dispatchedQuantity = dispatchedQuantity + batch.getDispatchedQuantity();
					}
				}
				facilityProductBatchDto.setReceivedQuantity(receivedQuantity);
				facilityProductBatchDto.setDispatchedQuantity(dispatchedQuantity);
				List<BatchDto> batches = mapToReceiptBatchDto(receiptProduct.getFacilityReceiptProductBatches());
				facilityProductBatchDto.setBatches(batches);
				facilityProductBatchDtos.add(facilityProductBatchDto);
			});
		}

		return facilityProductBatchDtos;
	}

	private static List<BatchDto> mapToReceiptBatchDto(Set<FacilityReceiptProductBatch> facilityReceiptProductBatches) {
		List<BatchDto> batches = new ArrayList<>();
		if (facilityReceiptProductBatches != null) {
			facilityReceiptProductBatches.forEach(facilityReceiptProductBatch -> {
				BatchDto batch = new BatchDto();
				batch.setBatchNumber(facilityReceiptProductBatch.getBatchNumber());
				batch.setExpiryDate(facilityReceiptProductBatch.getBatchExpiryDate());
				batch.setManufactureDate(facilityReceiptProductBatch.getBatchManufactureDate());
				batch.setQuantity(facilityReceiptProductBatch.getDispatchedQuantity());
				batch.setDamagedQuantity(facilityReceiptProductBatch.getDamagedQuantity());
				batch.setReceivedQuantity(facilityReceiptProductBatch.getQuantityReceived());
				batch.setGit(facilityReceiptProductBatch.getGit());
				batch.setFacilityReceiptBatchId(facilityReceiptProductBatch.getId());
				batch.setReconciliationDate(facilityReceiptProductBatch.getReconciliationDate());
				if (facilityReceiptProductBatch.getReceiptBatchStatusMaster() != null) {
					batch.setReceiptBatchStatus(facilityReceiptProductBatch.getReceiptBatchStatusMaster().getStatus());
				}
				batches.add(batch);
			});

		}
		return batches;

	}

	private static List<FacilityProductBatchDto> mapToFacilityProductBatchDto(
			Set<FacilityDispatchProduct> facilityDispatchProducts) {
		List<FacilityProductBatchDto> facilityProductBatchDtos = new ArrayList<>();
		if (facilityDispatchProducts != null) {
			facilityDispatchProducts.forEach(facilityDispatchProduct -> {
				FacilityProductBatchDto facilityProductBatchDto = new FacilityProductBatchDto();
				if (facilityDispatchProduct.getProduct() != null) {
					facilityProductBatchDto.setProductId(facilityDispatchProduct.getProduct().getId());
					facilityProductBatchDto.setProductName(facilityDispatchProduct.getProduct().getProductName());
				}

				List<BatchDto> batches = mapToBatchDto(facilityDispatchProduct.getFacilityDispatchProductBatches());
				facilityProductBatchDto.setBatches(batches);
				facilityProductBatchDtos.add(facilityProductBatchDto);
			});
		}
		return facilityProductBatchDtos;
	}

	private static List<BatchDto> mapToBatchDto(Set<FacilityDispatchProductBatch> facilityDispatchProductBatches) {
		List<BatchDto> batches = new ArrayList<>();
		if (facilityDispatchProductBatches != null) {
			facilityDispatchProductBatches.forEach(facilityDispatchProductBatch -> {
				BatchDto batch = new BatchDto();
				batch.setBatchNumber(facilityDispatchProductBatch.getBatchNumber());
				batch.setExpiryDate(facilityDispatchProductBatch.getBatchExpiryDate());
				batch.setManufactureDate(facilityDispatchProductBatch.getBatchManufactureDate());
				batch.setQuantity(facilityDispatchProductBatch.getQuantityDispatched());
				batch.setNumberOfBoxes(facilityDispatchProductBatch.getBoxesNo());
				batches.add(batch);
			});

		}
		return batches;

	}

	public static FacilityReceipt mapToFacilityReceiveStockListDtoToFacilityReceipt(
			@Valid FacilityReceiveStockListDto receiptDto, FacilityGrnStatusMaster facilityGrnStatusMaster,
			FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		FacilityReceipt facilityReceipt = new FacilityReceipt();

		FacilityDispatch facilityDispatch = new FacilityDispatch();
		facilityDispatch.setFacilityDispatchId(receiptDto.getFacilityDispatchId());
		facilityReceipt.setFacilityDispatch(facilityDispatch);
		facilityReceipt.setFacilityGrnStatusMaster(facilityGrnStatusMaster);
		facilityReceipt.setFacilityReceiptStatusMaster(facilityReceiptStatusMaster);

		facilityReceipt.setGrnDate(LocalDate.now());
		Set<FacilityReceiptProduct> facilityReceiptProducts = mapToFacilityReceiptProduct(receiptDto.getProducts(),
				facilityReceipt, facilityReceiptStatusMaster);
		facilityReceipt.setFacilityReceiptProducts(facilityReceiptProducts);
		return facilityReceipt;
	}

	private static Set<FacilityReceiptProduct> mapToFacilityReceiptProduct(
			@Valid List<FacilityProductBatchDto> productList, FacilityReceipt facilityReceipt,
			FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		Set<FacilityReceiptProduct> facilityReceiptProducts = new HashSet<>();
		if (productList != null) {
			productList.forEach(receivedProduct -> {
				FacilityReceiptProduct facilityReceiptProduct = new FacilityReceiptProduct();
				Product product = new Product();
				product.setId(receivedProduct.getProductId());
				facilityReceiptProduct.setProduct(product);
				Set<FacilityReceiptProductBatch> facilityReceiptProductBatches = mapToFacilityReceiptProductBatch(
						receivedProduct.getBatches(), facilityReceiptProduct, facilityReceiptStatusMaster);
				facilityReceiptProduct.setFacilityReceiptProductBatches(facilityReceiptProductBatches);
				facilityReceiptProduct.setFacilityReceipt(facilityReceipt);
				facilityReceiptProducts.add(facilityReceiptProduct);
			});
		}
		return facilityReceiptProducts;
	}

	private static Set<FacilityReceiptProductBatch> mapToFacilityReceiptProductBatch(List<BatchDto> batches,
			FacilityReceiptProduct facilityReceiptProduct, FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		Set<FacilityReceiptProductBatch> facilityReceiptProductBatches = new HashSet<>();
		if (batches != null) {
			batches.forEach(batch -> {
				FacilityReceiptProductBatch facilityReceiptProductBatch = new FacilityReceiptProductBatch();
				Long git = 0L;
				// Long quantity = batch.getReceivedQuantity() + batch.getDamagedQuantity();
				facilityReceiptProductBatch.setBatchNumber(batch.getBatchNumber());
				facilityReceiptProductBatch.setBatchExpiryDate(batch.getExpiryDate());
				facilityReceiptProductBatch.setBatchManufactureDate(batch.getManufactureDate());
				facilityReceiptProductBatch.setDispatchedQuantity(batch.getQuantity());
				facilityReceiptProductBatch.setDamagedQuantity(batch.getDamagedQuantity());
				facilityReceiptProductBatch.setQuantityReceived(batch.getReceivedQuantity());
				if (facilityReceiptStatusMaster.getId() == 5 || facilityReceiptStatusMaster.getId() == 8) {
					if (batch.getQuantity() >= batch.getReceivedQuantity()) {
						git = batch.getQuantity() - batch.getReceivedQuantity();
						facilityReceiptProductBatch.setGit(git);
					}
				}
				facilityReceiptProductBatch.setFacilityReceiptProduct(facilityReceiptProduct);
				facilityReceiptProductBatches.add(facilityReceiptProductBatch);

			});
		}
		return facilityReceiptProductBatches;
	}

	public static Set<FacilityDispatchReceiptRemark> mapToFacilityDispatchReceiptRemark(
			@Valid FacilityReceiveStockListDto receiptDto, FacilityDispatch facilityDispatch,
			FacilityReceipt facilityReceipt) {
		Set<FacilityDispatchReceiptRemark> remarks = new HashSet<>();
		for (FacilityDispatchReceiptRemark facilityDispatchReceiptRemark : remarks) {
			facilityDispatchReceiptRemark.setFacilityDispatch(facilityDispatch);
			FacilityDispatchStatusMaster facilityDispatchStatusMaster = new FacilityDispatchStatusMaster();
			facilityDispatchStatusMaster.setId(1L);
			facilityDispatchReceiptRemark.setFacilityDispatchStatusMaster(facilityDispatchStatusMaster);
			facilityDispatchReceiptRemark.setIsActive(true);
			facilityDispatchReceiptRemark.setRemarks(receiptDto.getRemark());
			facilityDispatchReceiptRemark.setFacilityReceipt(facilityReceipt);
			remarks.add(facilityDispatchReceiptRemark);
		}
		return remarks;
	}

	public static FacilityDispatchStatusTracking mapToFacilityDispatchStatusTracking(
			@Valid FacilityReceipt facilityReceipt, FacilityReceiveStockListDto receiptDto,
			FacilityReceiptStatusMaster facilityReceiptStatusMaster, FacilityDispatch facilityDispatch) {
		FacilityDispatchStatusTracking facilityDispatchStatusTracking = new FacilityDispatchStatusTracking();
		facilityDispatchStatusTracking.setFacilityDispatch(facilityDispatch);
		facilityDispatchStatusTracking.setFacilityReceiptStatusMaster(facilityReceiptStatusMaster);
		UserMaster userMaster = new UserMaster();
		userMaster.setId(receiptDto.getUserId());
		facilityDispatchStatusTracking.setUserMaster(userMaster);
		facilityDispatchStatusTracking.setFacilityReceipt(facilityReceipt);
		return facilityDispatchStatusTracking;
	}

	public static FacilityDispatchReceiptRemark mapToFacilityDispatchReceiptRemark(FacilityReceipt facilityReceipt,
			@Valid FacilityReceiveStockListDto receiptDto, FacilityReceiptStatusMaster facilityReceiptStatusMaster,
			FacilityDispatch facilityDispatch) {
		FacilityDispatchReceiptRemark facilityDispatchReceiptRemark = new FacilityDispatchReceiptRemark();
		facilityDispatchReceiptRemark.setFacilityDispatch(facilityDispatch);
		facilityDispatchReceiptRemark.setRemarks(receiptDto.getRemark());
		facilityDispatchReceiptRemark.setFacilityReceipt(facilityReceipt);
		facilityDispatchReceiptRemark.setFacilityReceiptStatusMaster(facilityReceiptStatusMaster);
		return facilityDispatchReceiptRemark;
	}

	public static List<FacilityReceiveStockListDto> mapFacilityReceiptToFacilityReceiveStockListDto(
			List<FacilityReceipt> receiptList) {
		List<FacilityReceiveStockListDto> facilityReceiveStockListDtos = new ArrayList<>();
		if (receiptList != null) {
			receiptList.forEach(receipt -> {
				FacilityReceiveStockListDto facilityReceiveStockDto = new FacilityReceiveStockListDto();
				if (receipt.getFacilityDispatch() != null) {
					facilityReceiveStockDto = mapToFacilityReceiveStockListDto(receipt.getFacilityDispatch(), receipt);
				}
				if (receipt.getFacilityReceiptStatusMaster() != null) {
					facilityReceiveStockDto.setReceiptStatus(receipt.getFacilityReceiptStatusMaster().getStatus());
				}
				if (receipt.getFacilityGrnStatusMaster() != null) {
					facilityReceiveStockDto.setGrnStatus(receipt.getFacilityGrnStatusMaster().getStatus());
				}
				facilityReceiveStockListDtos.add(facilityReceiveStockDto);
			});
		}
		return facilityReceiveStockListDtos;
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
		facilityStockTracking.setIsActive(true);
		facilityStockTracking.setIsDelete(false);
		facilityStockTracking.setProduct(product);
		facilityStockTracking.setBatchNumber(batch.getBatchNumber());
		facilityStockTracking.setTransactionDate(LocalDate.now());
		facilityStockTracking.setReferenceNo(reference);
		if (receiverType.equalsIgnoreCase("consignee")) {
			if (batch.getReceivedQuantity() != null) {
				facilityStockTracking.setQuantity(batch.getReceivedQuantity().doubleValue());
			}
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Facility_Receive_Stock.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("consignor")) {
			if (batch.getReceivedQuantity() != null) {
				facilityStockTracking.setQuantity(-batch.getReceivedQuantity().doubleValue());
			}
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Facility_Dispatch_Stock.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("receiveFromUnregisteredSource")) {
			if (batch.getReceivedQuantity() != null) {
				facilityStockTracking.setQuantity(batch.getReceivedQuantity().doubleValue());
			}
			facilityStockTrackingType.setId(
					FacilityStockTrackingTypeEnum.Receive_from_unregistered_source.getFacilityStockTrackingTypeId());
		} else if (receiverType.equalsIgnoreCase("dispatchToUnregSource")) {
			if (batch.getReceivedQuantity() != null) {
				facilityStockTracking.setQuantity(-batch.getReceivedQuantity().doubleValue());
			}
			facilityStockTrackingType.setId(
					FacilityStockTrackingTypeEnum.Dispatch_to_unregistered_source.getFacilityStockTrackingTypeId());
		}
		facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
		return facilityStockTracking;
	}

	public static FacilityStock mapToFacilityStock(BatchDto batch, FacilityStock facilityStock, Long facilityId,
			Long productId, String receiverType, FacilityReceiptStatusMaster facilityReceiptStatusMaster) {

		Long git = 0L;
		Long quantity = batch.getReceivedQuantity();

		if (facilityReceiptStatusMaster != null) {
			if (facilityReceiptStatusMaster.getId() == 5 || facilityReceiptStatusMaster.getId() == 8) {
				if (batch.getQuantity() > batch.getReceivedQuantity()) {
					git = batch.getQuantity() - batch.getReceivedQuantity();
				}
			}
		}

		if (facilityStock != null) {
			if (batch.getReceivedQuantity() != null) {
				Double gitQuantity = 0.0;
				Double currentQuantity = 0.0;
				Long numberOfBoxes = 0L;
				if (receiverType == "consignee") {
					currentQuantity = facilityStock.getCurrentQuantity() + quantity;
					if (facilityStock.getNumberOfBoxes() != null && batch.getNumberOfBoxes() != null) {
						numberOfBoxes = facilityStock.getNumberOfBoxes() + batch.getNumberOfBoxes();
						facilityStock.setNumberOfBoxes(numberOfBoxes);
					}
					if (batch.getDamagedQuantity() != null) {
						if (facilityStock.getDamagedQuantity() != null) {
							facilityStock.setDamagedQuantity(
									facilityStock.getDamagedQuantity() + batch.getDamagedQuantity());
						} else {
							facilityStock.setDamagedQuantity(batch.getDamagedQuantity().doubleValue());
						}
					}

					facilityStock.setCurrentQuantity(currentQuantity);
				} else if (receiverType == "consignor") {
					if (facilityStock.getGit() != null && facilityStock.getGit() != 0) {
						if (facilityStock.getGit() > quantity) {
							gitQuantity = facilityStock.getGit() - quantity;
							facilityStock.setGit(gitQuantity);
						}
					} else {
						if (git != null) {
							facilityStock.setGit(git.doubleValue());
						}
					}
					if (facilityStock.getNumberOfBoxes() != null && batch.getNumberOfBoxes() != null) {
						numberOfBoxes = facilityStock.getNumberOfBoxes() - batch.getNumberOfBoxes();
						facilityStock.setNumberOfBoxes(numberOfBoxes);
					}
				} else if (receiverType == "receiveFromUnregisteredSource") {
					currentQuantity = facilityStock.getCurrentQuantity() + batch.getReceivedQuantity();
					facilityStock.setCurrentQuantity(currentQuantity);
					if(batch.getDamagedQuantity()!=null) {
						facilityStock.setDamagedQuantity(batch.getDamagedQuantity().doubleValue());	
					}
				} else if (receiverType == "dispatchToUnregSource") {
					currentQuantity = facilityStock.getCurrentQuantity() - batch.getReceivedQuantity();
					facilityStock.setCurrentQuantity(currentQuantity);

				}

			}
		} else {
			facilityStock = new FacilityStock();
			facilityStock.setBatchNumber(batch.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(facilityId);
			facilityStock.setFacility(facility);
			Product product = new Product();
			product.setId(productId);
			facilityStock.setIsActive(true);
			facilityStock.setIsDelete(false);
			facilityStock.setProduct(product);
			if(batch.getDamagedQuantity()!=null) {
				facilityStock.setDamagedQuantity(batch.getDamagedQuantity().doubleValue());
			}
			facilityStock.setManufacturingDate(batch.getManufactureDate());
			facilityStock.setNumberOfBoxes(batch.getNumberOfBoxes());
			facilityStock.setExpiredDate(batch.getExpiryDate());
			if (batch.getReceivedQuantity() != null) {
				facilityStock.setCurrentQuantity(batch.getReceivedQuantity().doubleValue());
			}
		}
		return facilityStock;
	}

	public static String createSearchQuery(String facilityType, Long facilityId, List<Long> statusIds,
			List<Long> facilityTypeIds, List<Long> excludedFacilityTypeIds, String stnNumber, String consignorName,
			String indentNumber, LocalDate dispatchDate) {
		String statusIdString = statusIds.toString().replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();
		String excludedFacilityTypeIdString = excludedFacilityTypeIds.toString().replace("[", "").replace("]", "")
				.trim();
		String facilityTypeIdString = facilityTypeIds.toString().replace("[", "").replace("]", "").trim();
		String searchQuery = "select * from soch.facility_dispatch fd join soch.facility f1 "
				+ "on (f1.id=fd.consignor_facility_id) join soch.facility f2 on "
				+ "(f2.id=fd.consignee_facility_id) where fd.consignee_facility_id =" + facilityId
				+ " and fd.facility_dispatch_status_id IN (" + statusIdString + ")";

		if (stnNumber != null) {
			stnNumber = stnNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(fd.stn_number) like '%" + stnNumber + "%'";
		}
		if (indentNumber != null) {
			indentNumber = indentNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(fd.indent_num) like '%" + indentNumber + "%'";
		}
		if (consignorName != null) {
			consignorName = consignorName.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(f1.name) like '%" + consignorName + "%'";
		}
		if (dispatchDate != null) {
			searchQuery = searchQuery + " and DATE(fd.created_time)='" + dispatchDate + "'";
		}

		if (!facilityType.equals("facility")) {
			searchQuery = searchQuery + " and f1.facility_type_id IN(" + facilityTypeIdString
					+ ") order by fd.facility_dispatch_id desc";
		} else {
			searchQuery = searchQuery + " and f1.facility_type_id NOT IN(" + excludedFacilityTypeIdString
					+ ") order by fd.facility_dispatch_id desc";
		}
		return searchQuery;
	}

	public static String createSearchQueryForReceiptHistory(String facilityType, Long facilityId,
			List<Long> facilityTypeIds, List<Long> excludedFacilityTypeIds, String stnNumber, String indentNumber,
			String productName) {

		String facilityTypeIdString = facilityTypeIds.toString().replace("[", "").replace("]", "").trim();
		String excludedFacilityTypeIdString = excludedFacilityTypeIds.toString().replace("[", "").replace("]", "")
				.trim();
		String searchQuery = "select * from soch.facility_receipt fr join soch.facility_dispatch fd"
				+ " on (fr.facility_dispatch_id=fd.facility_dispatch_id)  join soch.facility f on"
				+ " (f.id=fd.consignor_facility_id) join soch.facility_type ft on (ft.id=f.facility_type_id)"
				+ " join soch.facility_dispatch_product fdp on (fd.facility_dispatch_id=fdp.facility_dispatch_id)"
				+ " join soch.product p on (fdp.product_id=p.id) where fd.consignee_facility_id=" + facilityId;
		if (stnNumber != null) {
			stnNumber = stnNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(fd.stn_number) like '%" + stnNumber + "%'";
		}
		if (indentNumber != null) {
			indentNumber = indentNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(fd.indent_num) like '%" + indentNumber + "%'";
		}
		if (productName != null) {
			productName = productName.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(p.product_name) like '%" + productName + "%'";
		}
		if (!facilityType.equals("facility")) {
			searchQuery = searchQuery + " and f.facility_type_id IN (" + facilityTypeIdString
					+ ") order by fr.facility_receipt_id desc";
		} else {
			searchQuery = searchQuery + " and f.facility_type_id NOT IN (" + excludedFacilityTypeIdString
					+ ") order by fr.facility_receipt_id desc";
		}
		return searchQuery;
	}

}
