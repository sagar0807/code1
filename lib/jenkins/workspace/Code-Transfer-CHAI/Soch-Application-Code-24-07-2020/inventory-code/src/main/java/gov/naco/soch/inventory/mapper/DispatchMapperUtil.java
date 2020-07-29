package gov.naco.soch.inventory.mapper;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import gov.naco.soch.dto.BatchDetailsDto;
import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.ConsigneeAddressDto;
import gov.naco.soch.dto.DescriptionOfProductsDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.dto.DispatchDto;
import gov.naco.soch.dto.DispatchProductDto;
import gov.naco.soch.dto.DispatchRemarkDto;
import gov.naco.soch.dto.LotContractDto;
import gov.naco.soch.dto.NoaDto;
import gov.naco.soch.dto.ProductContractDto;
import gov.naco.soch.dto.ProductDispatchHistoryDto;
import gov.naco.soch.dto.RemarkDto;
import gov.naco.soch.dto.ScheduleProductDto;
import gov.naco.soch.entity.ConsignmentStatusMaster;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.ContractProductSchedule;
import gov.naco.soch.entity.ContractProductScheduleSac;
import gov.naco.soch.entity.ContractProductScheduleSacsLot;
import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.entity.DispatchBatch;
import gov.naco.soch.entity.DispatchReceiptRemark;
import gov.naco.soch.entity.DispatchStatusMaster;
import gov.naco.soch.entity.DispatchStatusTracking;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductUomMaster;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.SupplierStock;
import gov.naco.soch.entity.UserMaster;

public class DispatchMapperUtil {

	// method to map DispatchDto list to Dispatch list
	public static List<DispatchDto> mapDispatchDtoListToDispatch(List<Dispatch> dispatchList) {

		List<DispatchDto> dispatchDtos = new ArrayList<DispatchDto>();
		if (dispatchList != null) {
			dispatchList.forEach(dispatch -> {
				DispatchDto dispatchDto = new DispatchDto();
				dispatchDto.setDispatchId(dispatch.getDispatchId());
				dispatchDto.setInvoiceDate(dispatch.getInvoiceDate());
				dispatchDto.setInvoiceNumber(dispatch.getInvoiceNumber());
				dispatchDto.setStnNumber(dispatch.getStnNumber());

				if (dispatch.getDispatchStatusMaster() != null) {
					dispatchDto.setDispatchStatus(dispatch.getDispatchStatusMaster().getStatus());
				}
				if (dispatch.getConsignmentStatusMaster().getStatus() != null) {
					dispatchDto.setConsignmentStatus(dispatch.getConsignmentStatusMaster().getStatus());
				}

				if (dispatch.getContract() != null) {
					dispatchDto.setNoaNumber(dispatch.getContract().getNoaNumber());
				}
				if (dispatch.getBillToConsignee() != null) {
					dispatchDto.setConsignee(dispatch.getShipToConsignee().getName());
				}
				Long quantity = FindTotalProductQuantity(dispatch.getDispatchBatches());
				dispatchDto.setQuantity(quantity);

				if (dispatch.getContractProductSchedule() != null) {
					if (dispatch.getContractProductSchedule().getContractProduct() != null) {
						if (dispatch.getContractProductSchedule().getContractProduct().getProduct() != null) {
							dispatchDto.setProduct(dispatch.getContractProductSchedule().getContractProduct()
									.getProduct().getProductName());
						}
					}
				}
				if (dispatch.getContractProductSceduleSacsLot() != null) {
					String lotNumber = dispatch.getContractProductSceduleSacsLot().getLotNumber();
					dispatchDto.setLotNumber(lotNumber);
				}
				dispatchDtos.add(dispatchDto);
			});
		}
		return dispatchDtos;
	}

	// method to map Dispatch to DispatchDetailedDto
	public static DispatchDetailedDto mapDispatchToDispatchDetailedDto(Dispatch dispatch, Receipt receipt) {
		DispatchDetailedDto dispatchDetailedDto = new DispatchDetailedDto();
		List<BatchDto> activeBatches = new ArrayList<BatchDto>();
		List<BatchDto> inActiveBatches = new ArrayList<BatchDto>();
		List<DispatchRemarkDto> remarks = new ArrayList<DispatchRemarkDto>();
		if (dispatch != null) {

			dispatchDetailedDto.setDispatchId(dispatch.getDispatchId());
			dispatchDetailedDto.setDriverName(dispatch.getDriverName());
			dispatchDetailedDto.setExpectedArrivalDate(dispatch.getExpectedArrivalDate());
			dispatchDetailedDto.setExpectedDispatchDate(dispatch.getExpectedDispatchDate());
			dispatchDetailedDto.setInvoiceDate(dispatch.getInvoiceDate());
			dispatchDetailedDto.setReceiptDate(dispatch.getCreatedTime());
			dispatchDetailedDto.setInvoiceNumber(dispatch.getInvoiceNumber());
			if (dispatch.getConsignor() != null) {
				dispatchDetailedDto.setConsignerId(dispatch.getConsignor().getId());
				dispatchDetailedDto.setConsignorName(dispatch.getConsignor().getName());
				String consigneeAddress = null;
				if (dispatch.getConsignor().getAddress().getAddress() != null) {
					consigneeAddress = dispatch.getConsignor().getAddress().getAddress();
				}
				if (dispatch.getConsignor().getAddress().getCity() != null) {
					if (consigneeAddress != null) {
						consigneeAddress = consigneeAddress + " " + dispatch.getConsignor().getAddress().getCity();
					} else {
						consigneeAddress = dispatch.getConsignor().getAddress().getCity();
					}
				}
				if (dispatch.getConsignor().getAddress().getDistrict().getName() != null) {
					if (consigneeAddress != null) {
						consigneeAddress = consigneeAddress + " "
								+ dispatch.getConsignor().getAddress().getDistrict().getName();
					} else {
						consigneeAddress = dispatch.getConsignor().getAddress().getDistrict().getName();
					}
				}
				if (dispatch.getConsignor().getAddress().getState().getName() != null) {
					if (consigneeAddress != null) {
						consigneeAddress = consigneeAddress + " "
								+ dispatch.getConsignor().getAddress().getState().getName();
					} else {
						consigneeAddress = dispatch.getConsignor().getAddress().getState().getName();
					}
				}
				if (dispatch.getConsignor().getAddress().getPincode() != null) {
					if (consigneeAddress != null) {
						consigneeAddress = consigneeAddress + " " + dispatch.getConsignor().getAddress().getPincode();
					} else {
						consigneeAddress = dispatch.getConsignor().getAddress().getPincode();
					}
				}
				dispatchDetailedDto.setConsignorAddress(consigneeAddress);
			}

			dispatchDetailedDto.setConsigneeName(dispatch.getShipToConsignee().getName());
			if (dispatch.getBillToConsignee() != null) {
				ConsigneeAddressDto consigneeAddress = new ConsigneeAddressDto();
				consigneeAddress.setConsigneeId(dispatch.getShipToConsignee().getId());
				consigneeAddress.setAddress(dispatch.getShipToConsignee().getAddress().getAddress());
				consigneeAddress.setBlock(dispatch.getShipToConsignee().getAddress().getBlock());
				consigneeAddress.setHouseNo(dispatch.getShipToConsignee().getAddress().getHouseNo());
				consigneeAddress.setCity(dispatch.getShipToConsignee().getAddress().getCity());
				consigneeAddress.setDistrict(dispatch.getShipToConsignee().getAddress().getDistrict().getName());
				consigneeAddress.setState(dispatch.getShipToConsignee().getAddress().getState().getName());
				consigneeAddress.setPin(dispatch.getShipToConsignee().getAddress().getPincode());
				dispatchDetailedDto.setConsigneeAddress(consigneeAddress);
			}

			dispatchDetailedDto.setAllotmentDate(dispatch.getContract().getAllotmentDate());
			if (dispatch.getDispatchStatusMaster() != null) {
				dispatchDetailedDto.setDispatchStatus(dispatch.getDispatchStatusMaster().getStatus());
			}
			if (dispatch.getConsignmentStatusMaster().getStatus() != null) {
				dispatchDetailedDto.setConsignmentStatus(dispatch.getConsignmentStatusMaster().getStatus());
			}

			dispatchDetailedDto.setStnNumber(dispatch.getStnNumber());
			dispatchDetailedDto.setTransporterName(dispatch.getTransporterName());
			dispatchDetailedDto.setTransporterPhone(dispatch.getTransporterPhone());

			// mapping remarks details
			if (dispatch.getDispatchReceiptRemarks() != null) {
				dispatch.getDispatchReceiptRemarks().forEach(remark -> {
					DispatchRemarkDto dispatchRemarkDto = new DispatchRemarkDto();
					dispatchRemarkDto.setRemarks(remark.getRemarks());
					dispatchRemarkDto.setDate(remark.getCreatedTime());
					dispatchRemarkDto.setUserId(remark.getUserMaster1().getId());
					dispatchRemarkDto.setUserName(remark.getUserMaster1().getFirstname());
					remarks.add(dispatchRemarkDto);
				});
			}
			dispatchDetailedDto.setRemarks(remarks);

			// mapping batch details
			if (receipt == null || (receipt != null && receipt.getReceiptStatusMaster().getId() == 4)) {
				if (dispatch.getDispatchBatches() != null) {

					dispatch.getDispatchBatches().forEach(batch -> {
						BatchDto batchDto = new BatchDto();

						if (batch.getIsActive()) {
							batchDto.setBatchNumber(batch.getBatchNumber());
							batchDto.setExpiryDate(batch.getBatchExpiryDate());
							batchDto.setManufactureDate(batch.getBatchManufactureDate());
							batchDto.setDispatchBatchId(batch.getId());
							batchDto.setQuantity(batch.getQuantityNumber());
							activeBatches.add(batchDto);
						}

						if (!batch.getIsActive()) {
							batchDto.setBatchNumber(batch.getBatchNumber());
							batchDto.setExpiryDate(batch.getBatchExpiryDate());
							batchDto.setManufactureDate(batch.getBatchManufactureDate());
							batchDto.setDispatchBatchId(batch.getId());
							batchDto.setQuantity(batch.getQuantityNumber());
							inActiveBatches.add(batchDto);
						}
					});
					dispatchDetailedDto.setActiveBatchDetails(activeBatches);
					dispatchDetailedDto.setInActiveBatchDetails(inActiveBatches);
				}
			} else if (receipt != null) {

				if (receipt.getReceiptBatches() != null) {

					receipt.getReceiptBatches().forEach(batch -> {
						BatchDto batchDto = new BatchDto();

						if (batch.getIsActive()) {
							batchDto.setBatchNumber(batch.getBatchNumber());
							batchDto.setExpiryDate(batch.getBatchExpiryDate());
							batchDto.setManufactureDate(batch.getBatchManufactureDate());
							batchDto.setDispatchBatchId(batch.getId());
							batchDto.setQuantity(batch.getDispatchedQuantity());
							batchDto.setReceivedQuantity(batch.getGrn1Quantity());
							batchDto.setGrn2Quantity(batch.getGrn2Quantity());
							batchDto.setDamagedQuantity(batch.getDamagedQuantity());
							activeBatches.add(batchDto);
						}

						if (!batch.getIsActive()) {
							batchDto.setBatchNumber(batch.getBatchNumber());
							batchDto.setExpiryDate(batch.getBatchExpiryDate());
							batchDto.setManufactureDate(batch.getBatchManufactureDate());
							batchDto.setDispatchBatchId(batch.getId());
							batchDto.setQuantity(batch.getDispatchedQuantity());
							batchDto.setReceivedQuantity(batch.getGrn1Quantity());
							batchDto.setGrn2Quantity(batch.getGrn2Quantity());
							batchDto.setDamagedQuantity(batch.getDamagedQuantity());
							inActiveBatches.add(batchDto);
						}
					});
					dispatchDetailedDto.setActiveBatchDetails(activeBatches);
					dispatchDetailedDto.setInActiveBatchDetails(inActiveBatches);
				}
			}

			if (dispatch.getBillToConsignee() != null) {
				dispatchDetailedDto.setBilledToFacilityId(dispatch.getBillToConsignee().getId());
				dispatchDetailedDto.setBilledToFacilityName(dispatch.getBillToConsignee().getName());
				if (dispatch.getBillToConsignee().getAddress() != null) {
					String address = null;
					if (dispatch.getBillToConsignee().getAddress().getAddress() != null) {
						address = dispatch.getBillToConsignee().getAddress().getAddress();
					}
					if (dispatch.getBillToConsignee().getAddress().getCity() != null) {
						if (address != null) {
							address = address + " " + dispatch.getBillToConsignee().getAddress().getCity();
						} else {
							address = dispatch.getBillToConsignee().getAddress().getCity();
						}
					}
					if (dispatch.getBillToConsignee().getAddress().getDistrict().getName() != null) {
						if (address != null) {
							address = address + " "
									+ dispatch.getBillToConsignee().getAddress().getDistrict().getName();
						} else {
							address = dispatch.getBillToConsignee().getAddress().getDistrict().getName();
						}
					}
					if (dispatch.getBillToConsignee().getAddress().getState().getName() != null) {
						if (address != null) {
							address = address + " " + dispatch.getBillToConsignee().getAddress().getState().getName();
						} else {
							address = dispatch.getBillToConsignee().getAddress().getState().getName();
						}
					}
					if (dispatch.getBillToConsignee().getAddress().getPincode() != null) {
						if (address != null) {
							address = address + " " + dispatch.getBillToConsignee().getAddress().getPincode();
						} else {
							address = dispatch.getBillToConsignee().getAddress().getPincode();
						}
					}
					dispatchDetailedDto.setBilledToFacilityAddress(address);
				}
			}

			if (dispatch.getContractProductSceduleSacsLot() != null) {
				dispatchDetailedDto.setLotNumber(dispatch.getContractProductSceduleSacsLot().getLotNumber());
			}

			Long quantity = FindTotalProductQuantity(dispatch.getDispatchBatches());
			dispatchDetailedDto.setProductQuantity(quantity);

			if (dispatch.getContract() != null) {
				dispatchDetailedDto.setNoa(dispatch.getContract().getNoaNumber());
			}

			if (dispatch.getContractProductSchedule() != null) {
				dispatchDetailedDto.setScheduleNumber(dispatch.getContractProductSchedule().getScheduleNumber());

				if (dispatch.getContractProductSchedule().getContractProduct() != null) {
					dispatchDetailedDto.setProductName(
							dispatch.getContractProductSchedule().getContractProduct().getProduct().getProductName());
					dispatchDetailedDto.setProductId(
							dispatch.getContractProductSchedule().getContractProduct().getProduct().getId());
				}
			}
			if (dispatch.getShipToConsignee() != null) {
				dispatchDetailedDto.setShippedToFacilityId(dispatch.getShipToConsignee().getId());
				dispatchDetailedDto.setShippedToFacilityName(dispatch.getShipToConsignee().getName());
				if (dispatch.getShipToConsignee().getAddress() != null) {
					String address = null;
					if (dispatch.getShipToConsignee().getAddress().getAddress() != null) {
						address = dispatch.getShipToConsignee().getAddress().getAddress() + " ";
					}
					if (dispatch.getShipToConsignee().getAddress().getCity() != null) {
						if (address != null) {
							address = address + dispatch.getBillToConsignee().getAddress().getCity() + " ";
						} else {
							address = dispatch.getShipToConsignee().getAddress().getCity();
						}
					}
					if (dispatch.getShipToConsignee().getAddress().getDistrict().getName() != null) {
						if (address != null) {
							address = address + dispatch.getShipToConsignee().getAddress().getDistrict().getName()
									+ " ";
						} else {
							address = dispatch.getShipToConsignee().getAddress().getDistrict().getName();
						}
					}
					if (dispatch.getShipToConsignee().getAddress().getState().getName() != null) {
						if (address != null) {
							address = address + " " + dispatch.getShipToConsignee().getAddress().getState().getName()
									+ " ";
						} else {
							address = dispatch.getShipToConsignee().getAddress().getState().getName() + " ";
						}
					}
					if (dispatch.getShipToConsignee().getAddress().getPincode() != null) {
						if (address != null) {
							address = address + dispatch.getBillToConsignee().getAddress().getPincode();
						} else {
							address = dispatch.getShipToConsignee().getAddress().getPincode();
						}
					}

					dispatchDetailedDto.setShippedToFacilityAddress(address);
				}
			}
		}
		return dispatchDetailedDto;
	}

	private static Long FindTotalProductQuantity(Set<DispatchBatch> dispatchBatches) {
		Long quantity = 0L;
		for (DispatchBatch a : dispatchBatches) {
			if (a.getIsActive() == Boolean.TRUE&&a.getQuantityNumber()!=null) {
				quantity = quantity + a.getQuantityNumber();
			}
		}
		return quantity;
	}

	// method to map supplierStock list to batch list
	public static List<BatchDto> mapToBatchDto(List<SupplierStock> supplierStocks) {
		List<BatchDto> batchDtos = new ArrayList<>();

		if (supplierStocks != null) {
			supplierStocks.forEach(supplierStock -> {
				BatchDto batchDto = new BatchDto();
				batchDto.setSupplierStockId(supplierStock.getSupplierStockId());
				batchDto.setBatchNumber(supplierStock.getBatchNumber());
				batchDto.setExpiryDate(supplierStock.getExpiryDate());
				batchDto.setManufactureDate(supplierStock.getManufactureDate());
				long difference = ChronoUnit.DAYS.between(LocalDate.now(), batchDto.getExpiryDate());
				long diff = ChronoUnit.DAYS.between(batchDto.getManufactureDate(), batchDto.getExpiryDate());
				Double e = ((double) difference / diff) * 100;
				if (e < 1 || e.isNaN()) {
					batchDto.setIsExpired(Boolean.TRUE);
					batchDto.setRemainingSelfLife("0%");
				} else if (e > 1 && e < 50) {
					batchDto.setIsExpired(Boolean.TRUE);
					DecimalFormat df = new DecimalFormat("####.#");
					df.setRoundingMode(RoundingMode.CEILING);
					batchDto.setRemainingSelfLife(df.format(e) + "%");
				} else if (e >= 50 && e <= 100) {
					batchDto.setIsExpired(Boolean.FALSE);
					DecimalFormat df = new DecimalFormat("####.#");
					df.setRoundingMode(RoundingMode.CEILING);
					batchDto.setRemainingSelfLife(df.format(e) + "%");
				}
				batchDtos.add(batchDto);
			});
		}
		return batchDtos;
	}

	// method to map DispatchDetailedDto to Dispatch
	public static Dispatch mapDispatchDtoToDispatch(DispatchDetailedDto dispatchDetailedDto) {

		Dispatch dispatch = new Dispatch();

		Contract contract = new Contract();
		contract.setContractId(dispatchDetailedDto.getContractId());
		dispatch.setContract(contract);

		ContractProduct contractProduct = new ContractProduct();
		contractProduct.setId(dispatchDetailedDto.getContractProductId());
		dispatch.setContractProduct(contractProduct);

		ContractProductSchedule contractProductSchedule = new ContractProductSchedule();
		contractProductSchedule.setId(dispatchDetailedDto.getScheduleId());
		dispatch.setContractProductSchedule(contractProductSchedule);

		ContractProductScheduleSacsLot contractProductSceduleSacsLot = new ContractProductScheduleSacsLot();
		contractProductSceduleSacsLot.setId(dispatchDetailedDto.getLotId());
		dispatch.setContractProductSceduleSacsLot(contractProductSceduleSacsLot);

		dispatch.setInvoiceNumber(dispatchDetailedDto.getInvoiceNumber());
		dispatch.setInvoiceDate(dispatchDetailedDto.getInvoiceDate());
		dispatch.setTransporterName(dispatchDetailedDto.getTransporterName());
		dispatch.setTransporterPhone(dispatchDetailedDto.getTransporterPhone());
		dispatch.setStnNumber("STN26" + dispatchDetailedDto.getInvoiceNumber());
		dispatch.setDriverName(dispatchDetailedDto.getDriverName());
		dispatch.setExpectedArrivalDate(dispatchDetailedDto.getExpectedArrivalDate());
		dispatch.setExpectedDispatchDate(dispatchDetailedDto.getExpectedDispatchDate());

		Facility facilityBilled = new Facility();
		facilityBilled.setId(dispatchDetailedDto.getBilledToFacilityId());
		dispatch.setBillToConsignee(facilityBilled);

		Facility facilityShipped = new Facility();
		facilityShipped.setId(dispatchDetailedDto.getShippedToFacilityId());
		dispatch.setShipToConsignee(facilityShipped);

		Facility consignor = new Facility();
		consignor.setId(dispatchDetailedDto.getConsignerId());
		dispatch.setConsignor(consignor);

		Set<DispatchReceiptRemark> remarks = mapDispatchRemarkDtoToDispatchRemark(dispatchDetailedDto, dispatch);
		dispatch.setDispatchReceiptRemarks(remarks);

		ConsignmentStatusMaster consignmentStatusMaster = new ConsignmentStatusMaster();
		consignmentStatusMaster.setId(1);
		dispatch.setConsignmentStatusMaster(consignmentStatusMaster);

		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		dispatchStatusMaster.setId(1);
		dispatch.setDispatchStatusMaster(dispatchStatusMaster);

		Set<DispatchStatusTracking> dispatchStatusTrackings = mapDispatchBatchDtoToDispatchStatusTracking(
				dispatchDetailedDto, dispatch);
		dispatch.setDispatchStatusTrackings(dispatchStatusTrackings);

		Set<DispatchBatch> dispatchBatches = maptoDispatchBatchDtoToDispatchBaches(
				dispatchDetailedDto.getBatchDetails(), dispatch);
		dispatch.setDispatchBatches(dispatchBatches);
		return dispatch;
	}

	public static Set<DispatchStatusTracking> mapDispatchBatchDtoToDispatchStatusTracking(
			DispatchDetailedDto dispatchDetailedDto, Dispatch dispatch) {
		Set<DispatchStatusTracking> dispatchStatusTrackings = new HashSet<>();

		DispatchStatusTracking dispatchStatusTracking = new DispatchStatusTracking();
		dispatchStatusTracking.setDispatch(dispatch);
		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		dispatchStatusMaster.setId(1);
		dispatchStatusTracking.setDispatchStatusMaster(dispatchStatusMaster);
		UserMaster user = new UserMaster();
		user.setId(dispatchDetailedDto.getUserId());
		dispatchStatusTracking.setUserMaster(user);
		dispatchStatusTrackings.add(dispatchStatusTracking);
		return dispatchStatusTrackings;
	}

	// method to map DispatchDetailedDto to DispatchRemark
	public static Set<DispatchReceiptRemark> mapDispatchRemarkDtoToDispatchRemark(
			DispatchDetailedDto dispatchDetailedDto, Dispatch dispatch) {

		Set<DispatchReceiptRemark> remarks = new HashSet<>();
		DispatchReceiptRemark remark = new DispatchReceiptRemark();
		remark.setRemarks(dispatchDetailedDto.getRemark());
		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		dispatchStatusMaster.setId(1);
		remark.setDispatchStatusMaster(dispatchStatusMaster);
		remark.setDispatch(dispatch);
		remarks.add(remark);
		return remarks;
	}

	// method to map BatchDto to DispatchBatch
	public static Set<DispatchBatch> maptoDispatchBatchDtoToDispatchBaches(List<BatchDto> batchDetails,
			Dispatch dispatch) {

		Set<DispatchBatch> batches = new HashSet<DispatchBatch>();
		for (BatchDto batchDto : batchDetails) {
			DispatchBatch batch = new DispatchBatch();
			batch.setBatchExpiryDate(batchDto.getExpiryDate());
			batch.setBatchManufactureDate(batchDto.getManufactureDate());
			batch.setBatchNumber(batchDto.getBatchNumber());
			batch.setQuantityNumber(batchDto.getQuantity());
			batch.setIsActive(true);
			batch.setDispatch(dispatch);
			batches.add(batch);
		}
		return batches;
	}

	public static List<DispatchProductDto> mapSupplierStockListToDispatchProductDtoList(List<SupplierStock> stocks) {
		List<DispatchProductDto> dispatchProductDtos = new ArrayList<DispatchProductDto>();
		if (stocks != null) {
			Long productId = 0l;
			for (SupplierStock stock : stocks) {
				if (productId != stock.getProduct().getId()) {
					DispatchProductDto dispatchProductDto = new DispatchProductDto();
					Product product = stock.getProduct();
					productId = product.getId();
					dispatchProductDto.setProductId(product.getId());
					dispatchProductDto.setProductCode(product.getProductCode());
					dispatchProductDto.setProductName(product.getProductName());
					ProductUomMaster productUomMaster = product.getProductUomMaster();
					dispatchProductDto.setUom(productUomMaster.getUomName());
					dispatchProductDto.setBatchDtos(mapstockToBatchDtos(dispatchProductDto, stocks));
					dispatchProductDtos.add(dispatchProductDto);
				}

			}

		}
		return dispatchProductDtos;
	}

	private static List<BatchDto> mapstockToBatchDtos(DispatchProductDto dispatchProductDto,
			List<SupplierStock> stocks) {
		List<BatchDto> batchDtos = new ArrayList<BatchDto>();
		for (SupplierStock stock : stocks) {
			if (dispatchProductDto.getProductId() == stock.getProduct().getId()) {
				BatchDto batchDto = new BatchDto();
				batchDto.setBatchNumber(stock.getBatchNumber());
				batchDto.setManufactureDate(stock.getManufactureDate());
				batchDto.setSupplierStockId(stock.getSupplierStockId());
				batchDto.setExpiryDate(stock.getExpiryDate());
				batchDtos.add(batchDto);
			}
		}
		return batchDtos;
	}

	public static List<ProductContractDto> mapContractProductToProductContractDto(List<ContractProduct> products) {
		List<ProductContractDto> productContractDtos = new ArrayList<>();
		if (products != null) {
			products.forEach(product -> {
				ProductContractDto productContractDto = new ProductContractDto();
				Long productId = product.getProduct().getId();
				productContractDto.setProductId(productId);
				if (product.getProduct() != null) {
					productContractDto.setProductName(product.getProduct().getProductName());
					productContractDto.setContarctId(product.getContract().getContractId());
					if (product.getProduct().getProductUomMaster() != null) {
						productContractDto.setUom(product.getProduct().getProductUomMaster().getUomName());
					}
				}
				productContractDtos.add(productContractDto);
			});
		}
		return productContractDtos;
	}

	public static List<ScheduleProductDto> mapContractProductScheduleToScheduleProductDto(
			Set<ContractProductSchedule> contractProductSchedules) {
		List<ScheduleProductDto> scheduleProductDtos = new ArrayList<>();
		if (contractProductSchedules != null) {
			contractProductSchedules.forEach(contractProductSchedule -> {
				ScheduleProductDto scheduleProductDto = new ScheduleProductDto();
				scheduleProductDto.setScheduleId(contractProductSchedule.getId());
				scheduleProductDto.setScheduleNumber(contractProductSchedule.getScheduleNumber());
				scheduleProductDto.setQuantity(contractProductSchedule.getQuantity());
				List<LotContractDto> lotContractDtos = mapContractProductSceduleSacsToLotContractDto(
						contractProductSchedule.getContractProductScheduleSacs());
				scheduleProductDto.setLots(lotContractDtos);
				scheduleProductDtos.add(scheduleProductDto);
			});
		}
		return scheduleProductDtos;
	}

	private static List<LotContractDto> mapContractProductSceduleSacsToLotContractDto(
			Set<ContractProductScheduleSac> contractProductScheduleSacs) {
		List<LotContractDto> lotContractDtos = new ArrayList<>();
		for (ContractProductScheduleSac contractProductScheduleSac : contractProductScheduleSacs) {
			lotContractDtos = mapContractProductSceduleSacsLotsToLotContractDto(
					contractProductScheduleSac.getContractProductSceduleSacsLots());
		}
		return lotContractDtos;
	}

	public static List<LotContractDto> mapContractProductSceduleSacsLotsToLotContractDto(
			Set<ContractProductScheduleSacsLot> contractProductSceduleSacsLotDetails) {
		List<LotContractDto> lotDetails = new ArrayList<>();
		if (contractProductSceduleSacsLotDetails != null) {
			for (ContractProductScheduleSacsLot contractProductSceduleLotDetail : contractProductSceduleSacsLotDetails) {
				LotContractDto lotContractDto = new LotContractDto();
				lotContractDto.setLotId(contractProductSceduleLotDetail.getId());
				if (contractProductSceduleLotDetail.getStartDate() != null) {
					lotContractDto.setStartDate(contractProductSceduleLotDetail.getStartDate());
				}
				if (contractProductSceduleLotDetail.getEndDate() != null) {
					lotContractDto.setEndDate(contractProductSceduleLotDetail.getEndDate());
				}

				if (contractProductSceduleLotDetail.getQuantity() != null) {
					lotContractDto.setQuantity(contractProductSceduleLotDetail.getQuantity());
				}
				if (contractProductSceduleLotDetail.getLotNumber() != null) {
					lotContractDto.setLotNumber(contractProductSceduleLotDetail.getLotNumber());
				}
				if (contractProductSceduleLotDetail.getContractProductScheduleSac() != null
						&& contractProductSceduleLotDetail.getContractProductScheduleSac()
								.getContractProductSchedule() != null) {
					lotContractDto.setScheduleId(contractProductSceduleLotDetail.getContractProductScheduleSac()
							.getContractProductSchedule().getId());
					lotContractDto.setScheduleNumber(contractProductSceduleLotDetail.getContractProductScheduleSac()
							.getContractProductSchedule().getScheduleNumber());
				}
				lotDetails.add(lotContractDto);
			}
		}
		return lotDetails;
	}

	public static List<NoaDto> mapToNoaDto(List<Contract> contracts, Long productId) {
		List<NoaDto> noas = new ArrayList<>();
		if (contracts != null) {
			contracts.forEach(contract -> {
				NoaDto noa = new NoaDto();
				noa.setNoaNumber(contract.getNoaNumber());
				noa.setContractId(contract.getContractId());
				contract.getContractProducts().forEach(product -> {
					noa.setContractProductId(product.getId());
				});
				noas.add(noa);
			});
		}
		return noas;
	}

	public static List<ProductDispatchHistoryDto> mapFacilityDispatchListToProductDispatchHistoryDtoList(
			List<FacilityDispatch> facilityDispatchList) {

		List<ProductDispatchHistoryDto> ProductDispatchHistoryDtoList = new ArrayList<>();

		for (FacilityDispatch facilityDispatch : facilityDispatchList) {
			ProductDispatchHistoryDto productDispatchHistoryDto = new ProductDispatchHistoryDto();
			List<DescriptionOfProductsDto> descriptionOfProductsDtoList = new ArrayList<>();
			List<RemarkDto> remarkList = new ArrayList<>();
			List<String> products = new ArrayList<>();
			String consigneeAddress = null;

			if (facilityDispatch.getConsignee() != null) {
				productDispatchHistoryDto.setConsignee(facilityDispatch.getConsignee().getName());
				productDispatchHistoryDto.setConsigneeId(facilityDispatch.getConsignee().getId());
				productDispatchHistoryDto.setConsigneeName(facilityDispatch.getConsignee().getName());
				productDispatchHistoryDto
						.setConsigneeType(facilityDispatch.getConsignee().getFacilityType().getFacilityTypeName());
				if (facilityDispatch.getConsignee().getAddress() != null) {
					if (facilityDispatch.getConsignee().getAddress().getAddress() != null) {
						consigneeAddress = facilityDispatch.getConsignee().getAddress().getAddress();
					}
					if (facilityDispatch.getConsignee().getAddress().getCity() != null) {
						if (consigneeAddress != null) {
							consigneeAddress = consigneeAddress + " "
									+ facilityDispatch.getConsignee().getAddress().getCity();
						} else {
							consigneeAddress = facilityDispatch.getConsignee().getAddress().getCity();
						}
					}
					if (facilityDispatch.getConsignee().getAddress().getDistrict().getName() != null) {
						if (consigneeAddress != null) {
							consigneeAddress = consigneeAddress + " "
									+ facilityDispatch.getConsignee().getAddress().getDistrict().getName();
						} else {
							consigneeAddress = facilityDispatch.getConsignee().getAddress().getDistrict().getName();
						}
					}
					if (facilityDispatch.getConsignee().getAddress().getState().getName() != null) {
						if (consigneeAddress != null) {
							consigneeAddress = consigneeAddress + " "
									+ facilityDispatch.getConsignee().getAddress().getState().getName();
						} else {
							consigneeAddress = facilityDispatch.getConsignee().getAddress().getState().getName();
						}
					}
					if (facilityDispatch.getConsignee().getAddress().getPincode() != null) {
						if (consigneeAddress != null) {
							consigneeAddress = consigneeAddress + " "
									+ facilityDispatch.getConsignee().getAddress().getPincode();
						} else {
							consigneeAddress = facilityDispatch.getConsignee().getAddress().getPincode();
						}
					}
					productDispatchHistoryDto.setConsigneeAddress(consigneeAddress);
				}
			}

			if (facilityDispatch.getMasterInventoryUnregisteredSource() != null) {
				productDispatchHistoryDto
						.setConsignee(facilityDispatch.getMasterInventoryUnregisteredSource().getSourceName());
				productDispatchHistoryDto
						.setConsigneeId(facilityDispatch.getMasterInventoryUnregisteredSource().getId());
				productDispatchHistoryDto
						.setConsigneeName(facilityDispatch.getMasterInventoryUnregisteredSource().getSourceName());
				productDispatchHistoryDto.setConsigneeType("Unregistered Facility");
				if (facilityDispatch.getMasterInventoryUnregisteredSource().getAddress() != null) {
					String address = facilityDispatch.getMasterInventoryUnregisteredSource().getAddress()
							.getAddressLineOne();
					String district = facilityDispatch.getMasterInventoryUnregisteredSource().getAddress().getDistrict()
							.getName();
					String state = facilityDispatch.getMasterInventoryUnregisteredSource().getAddress().getState()
							.getName();
					String pincode = facilityDispatch.getMasterInventoryUnregisteredSource().getAddress().getPincode();
					consigneeAddress = address + " " + district + " " + state + " " + pincode;
					productDispatchHistoryDto.setConsigneeAddress(consigneeAddress);
				}
			}
			productDispatchHistoryDto.setFacilityDispatchId(facilityDispatch.getFacilityDispatchId());
			productDispatchHistoryDto.setStnNumber(facilityDispatch.getStnNumber());
			if (facilityDispatch.getConsignor() != null) {
				productDispatchHistoryDto.setConsignorId(facilityDispatch.getConsignor().getId());
				productDispatchHistoryDto.setConsignorName(facilityDispatch.getConsignor().getName());
				if (facilityDispatch.getConsignor().getFacilityType() != null) {
					productDispatchHistoryDto
							.setConsignorType(facilityDispatch.getConsignor().getFacilityType().getFacilityTypeName());
				}
			}
			productDispatchHistoryDto.setDispatchDate(String.valueOf(facilityDispatch.getExpectedDispatchDate()));
			productDispatchHistoryDto.setTotalQuantity(0L);
			productDispatchHistoryDto.setTotalBox(0L);

			facilityDispatch.getFacilityDispatchProducts().forEach(element -> {

				products.add(element.getProduct().getProductName());

				DescriptionOfProductsDto descriptionOfProductsDto = new DescriptionOfProductsDto();
				List<BatchDetailsDto> batchDetailsDtoList = new ArrayList<>();

				descriptionOfProductsDto.setProductName(element.getProduct().getProductName());
				descriptionOfProductsDto.setProductId(element.getProduct().getId());
				descriptionOfProductsDto.setTotalQuantity(0L);
				descriptionOfProductsDto.setTotalBox(0L);

				element.getFacilityDispatchProductBatches().forEach(action -> {

					BatchDetailsDto batchDetailsDto = new BatchDetailsDto();
					if (action.getQuantityDispatched() != null) {
						Long quantity = productDispatchHistoryDto.getTotalQuantity() + action.getQuantityDispatched();
						productDispatchHistoryDto.setTotalQuantity(quantity);

						quantity = descriptionOfProductsDto.getTotalQuantity() + action.getQuantityDispatched();
						descriptionOfProductsDto.setTotalQuantity(quantity);
					}
					if (action.getBoxesNo() != null) {
						Long box = productDispatchHistoryDto.getTotalBox() + action.getBoxesNo();
						productDispatchHistoryDto.setTotalBox(box);

						box = descriptionOfProductsDto.getTotalBox() + action.getBoxesNo();
						descriptionOfProductsDto.setTotalBox(box);
					}

					batchDetailsDto.setBatchDetailId(action.getId());
					batchDetailsDto.setBatchNumber(String.valueOf(action.getBatchNumber()));
					batchDetailsDto.setExpiryDate(String.valueOf(action.getBatchExpiryDate()));
					batchDetailsDto.setManufactureDate(String.valueOf(action.getBatchManufactureDate()));
					batchDetailsDto.setNumberOfBox(action.getBoxesNo());
					if (action.getQuantityDispatched() != null) {
						batchDetailsDto.setQuantity(action.getQuantityDispatched().doubleValue());
					}

					batchDetailsDtoList.add(batchDetailsDto);
				});
				descriptionOfProductsDto.setBatchDetails(batchDetailsDtoList);
				descriptionOfProductsDtoList.add(descriptionOfProductsDto);
			});

			productDispatchHistoryDto.setProductNames(products);
			productDispatchHistoryDto.setStatus(facilityDispatch.getFacilityDispatchStatusMaster().getStatus());
			productDispatchHistoryDto.setIndentNumber(facilityDispatch.getIndentNum());
			productDispatchHistoryDto.setIndentDate(String.valueOf(facilityDispatch.getIndentDate()));
			productDispatchHistoryDto.setTransporterOrCourier(facilityDispatch.getTransporterName());
			productDispatchHistoryDto.setAwbNumber(facilityDispatch.getAwbNum());
			productDispatchHistoryDto.setContactNumber(facilityDispatch.getContactNum());

			String consignorAddress = null;
			if (facilityDispatch.getConsignor() != null && facilityDispatch.getConsignor().getAddress() != null) {
				if (facilityDispatch.getConsignor().getAddress().getAddress() != null) {
					consignorAddress = facilityDispatch.getConsignor().getAddress().getAddress();
				}
				if (facilityDispatch.getConsignor().getAddress().getState().getName() != null) {
					if (consignorAddress != null) {
						consignorAddress = consignorAddress + " "
								+ facilityDispatch.getConsignor().getAddress().getState().getName();
					} else {
						consignorAddress = facilityDispatch.getConsignor().getAddress().getState().getName();
					}
				}
				if (facilityDispatch.getConsignor().getAddress().getDistrict().getName() != null) {
					if (consignorAddress != null) {
						consignorAddress = consignorAddress + " "
								+ facilityDispatch.getConsignor().getAddress().getDistrict().getName();
					} else {
						consignorAddress = facilityDispatch.getConsignor().getAddress().getDistrict().getName();
					}
				}
				if (facilityDispatch.getConsignor().getAddress().getPincode() != null) {
					if (consignorAddress != null) {
						consignorAddress = consignorAddress + " "
								+ facilityDispatch.getConsignor().getAddress().getPincode();
					} else {
						consignorAddress = facilityDispatch.getConsignor().getAddress().getPincode();
					}
				}
			}
			productDispatchHistoryDto.setConsignorAddress(consignorAddress);

			if (facilityDispatch.getFacilityConsignmentStatusMaster() != null) {
				productDispatchHistoryDto
						.setConsignmentStatusId(facilityDispatch.getFacilityConsignmentStatusMaster().getId());
				productDispatchHistoryDto
						.setConsignmentStatus(facilityDispatch.getFacilityConsignmentStatusMaster().getStatus());
			}

			if (facilityDispatch.getFacilityDispatchStatusMaster() != null) {
				productDispatchHistoryDto
						.setDispatchStatusId(facilityDispatch.getFacilityDispatchStatusMaster().getId());
				productDispatchHistoryDto
						.setDispatchStatus(facilityDispatch.getFacilityDispatchStatusMaster().getStatus());
				productDispatchHistoryDto.setStatusId(facilityDispatch.getFacilityDispatchStatusMaster().getId());
			}

			if (facilityDispatch.getFacilityRelocationRequestStatusMaster() != null) {
				productDispatchHistoryDto
						.setRequestStatusId(facilityDispatch.getFacilityRelocationRequestStatusMaster().getId());
				productDispatchHistoryDto
						.setRequestStatus(facilityDispatch.getFacilityRelocationRequestStatusMaster().getStatus());
			}

			productDispatchHistoryDto
					.setConsigneeStatus(facilityDispatch.getFacilityConsignmentStatusMaster().getStatus());
			productDispatchHistoryDto.setDescriptionOfGoodsOrDrugs(descriptionOfProductsDtoList);

			facilityDispatch.getFacilityDispatchReceiptRemarks().forEach(receipt -> {
				if (receipt.getFacilityReceiptStatusMaster() != null) {
					productDispatchHistoryDto.setReceiptStatus(receipt.getFacilityReceiptStatusMaster().getStatus());
				}
				RemarkDto remark = new RemarkDto();
				remark.setDate(String.valueOf(receipt.getCreatedTime()));
				remark.setRemarks(receipt.getRemarks());
				if (receipt.getUserMaster1() != null) {
					String userName = receipt.getUserMaster1().getFirstname();
					if (receipt.getUserMaster1().getLastname() != null) {
						userName += " " + receipt.getUserMaster1().getLastname();
					}
					remark.setUserName(userName);
				}
				remarkList.add(remark);
			});

			productDispatchHistoryDto.setRemarks(remarkList);
			ProductDispatchHistoryDtoList.add(productDispatchHistoryDto);
		}
		return ProductDispatchHistoryDtoList;
	}

	public static List<ProductContractDto> mapContractProductToProductContractDtoProduct(List<Product> products) {
		List<ProductContractDto> productContractDtos = new ArrayList<>();
		if (products != null) {
			products.forEach(product -> {
				ProductContractDto productContractDto = new ProductContractDto();
				Long productId = product.getId();
				productContractDto.setProductId(productId);
				productContractDto.setProductName(product.getProductName());
				if (product.getProductUomMaster() != null) {
					productContractDto.setUom(product.getProductUomMaster().getUomName());
				}

				productContractDtos.add(productContractDto);
			});
		}
		return productContractDtos;
	}

	public static ProductContractDto mapContractProductToProductContractDtoProduct(Optional<Product> product1) {
		ProductContractDto productContractDto = new ProductContractDto();
		Product product = product1.get();
		Long productId = product.getId();
		productContractDto.setProductId(productId);
		productContractDto.setProductName(product.getProductName());
		if (product.getProductUomMaster() != null) {
			productContractDto.setUom(product.getProductUomMaster().getUomName());
		}
		return productContractDto;
	}

	public static String createSearchQuery(List<Long> consignorIdList, String stnNumber, String consignee,
			LocalDate dispatchDate, String productName) {
		String formattedString = consignorIdList.toString().replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();
		String searchQuery = "select * from soch.facility_dispatch fd join soch.facility f on(f.id=fd.consignee_facility_id)\r\n"
				+ "join soch.facility_dispatch_product fdp on(fd.facility_dispatch_id=fdp.facility_dispatch_id)"
				+ "join soch.product p on(p.id=fdp.product_id) where lower(fd.dispatch_type) = 'relocate'\r\n"
				+ "and fd.consignor_facility_id IN (" + formattedString + ")\r\n";
		if (stnNumber != null) {
			stnNumber=stnNumber.toLowerCase().trim();
			searchQuery = searchQuery + "and LOWER(fd.stn_number) like '%" + stnNumber + "%'\r\n";
		}
		if (consignee != null) {
			consignee=consignee.toLowerCase().trim();
			searchQuery = searchQuery + "and LOWER(f.name) like '%" + consignee + "%'\r\n";
		}
		if (dispatchDate != null) {
			searchQuery = searchQuery + "and fd.expected_dispatch_date='" + dispatchDate + "'\r\n";
		}
		if (productName != null) {
			productName=productName.toLowerCase().trim();
			searchQuery = searchQuery + "and LOWER(p.product_name) like '%" + productName + "%'\r\n";
		}

		return searchQuery;
	}

	public static String createDispatchSearchQuery(Long facilityId, List<Long> facilityTypeIds, String stnNumber,
			String consignorName, String invoiceNumber, LocalDate invoiceDate) {
		String facilityTypeIdString = facilityTypeIds.toString().replace("[", "") // remove the right bracket
				.replace("]", "") // remove the left bracket
				.trim();
		String searchQuery = "select * from soch.dispatch d join soch.facility f1 on (f1.id=d.ship_consignee_id)"
				+ " join soch.facility f2 on(f2.id=d.consignor_id) join soch.facility_type ft on(ft.id=f2.facility_type_id)"
				+ " where f1.id=" + facilityId + " and d.dispatch_status_id=1 and f2.facility_type_id IN("
				+ facilityTypeIdString + ")";

		if (stnNumber != null) {
			stnNumber=stnNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(d.stn_number) like '%" + stnNumber + "%'";
		}
		if (consignorName != null) {
			consignorName=consignorName.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(f2.name) like '%" + consignorName + "%'";
		}
		if (invoiceNumber != null) {
			invoiceNumber=invoiceNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(d.invoice_number) like '%" + invoiceNumber + "%'";
		}
		if (invoiceDate != null) {
			searchQuery = searchQuery + " and d.invoice_date='" + invoiceDate + "'";
		}

		return searchQuery;
	}

}
