package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.AcceptConsignmentDto;
import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.ConsignmentBatchDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.dto.ReceiptDto;
import gov.naco.soch.dto.ReceiptSupplierDto;
import gov.naco.soch.entity.ConsignmentStatusMaster;
import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.entity.DispatchReceiptRemark;
import gov.naco.soch.entity.DispatchStatusMaster;
import gov.naco.soch.entity.DispatchStatusTracking;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.Grn1StatusMaster;
import gov.naco.soch.entity.Grn2StatusMaster;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.ReceiptBatch;
import gov.naco.soch.entity.ReceiptStatusMaster;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.DispatchStatusEnum;
import gov.naco.soch.enums.DivisionEnum;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.inventory.mapper.DispatchMapperUtil;
import gov.naco.soch.inventory.mapper.ReceiptMapperUtil;
import gov.naco.soch.repository.DispatchRepository;
import gov.naco.soch.repository.DispatchStatusTrackingRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;
import gov.naco.soch.repository.ReceiptRepository;

@Service
@Transactional
public class ReceiptService {

	@Autowired
	private DispatchRepository dispatchRepository;

	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private DispatchStatusTrackingRepository dispatchStatusTrackingRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	public List<DispatchDetailedDto> getAllDispatchedStocks(Long facilityId, String facilityType, String stnNumber,
			String consignorName, String invoiceNumber, LocalDate invoiceDate) {
		List<Long> facilityTypeIds = new ArrayList<>();

		switch (facilityType) {
		case "sacs":
			facilityTypeIds.add(FacilityTypeEnum.SACS.getFacilityType());
			break;
		case "supplier":
			facilityTypeIds.add(FacilityTypeEnum.SUPPLIER.getFacilityType());
			break;
		default:
			break;
		}
		List<Dispatch> dispatchedStocks = new ArrayList<Dispatch>();
		if (stnNumber == null && consignorName == null && invoiceNumber == null && invoiceDate == null) {
			dispatchedStocks = dispatchRepository
					.findAllByShipToConsignee_IdAndDispatchStatusMaster_IdAndConsignor_FacilityType_IdIn(facilityId, 1,
							facilityTypeIds);
		} else {
			String searchQuery = DispatchMapperUtil.createDispatchSearchQuery(facilityId, facilityTypeIds, stnNumber,
					consignorName, invoiceNumber, invoiceDate);
			dispatchedStocks = dispatchRepository.findDispatchBySearchValue(searchQuery);
		}

		List<DispatchDetailedDto> dispatchDetailedDtos = new ArrayList<>();
		dispatchedStocks.forEach(dispatchedStock -> {
			DispatchDetailedDto dispatchDetailedDto = DispatchMapperUtil
					.mapDispatchToDispatchDetailedDto(dispatchedStock, null);
			dispatchDetailedDtos.add(dispatchDetailedDto);
		});

		return dispatchDetailedDtos;

	}

	public ReceiptDto saveReceiptDetails(@Valid ReceiptDto receiptDto) {

		Dispatch dispatch = new Dispatch();
		Receipt receipt = new Receipt();
		Long divisionId = 0L;
		ConsignmentStatusMaster consignmentStatusMaster = new ConsignmentStatusMaster();
		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		Grn1StatusMaster grn1StatusMaster = new Grn1StatusMaster();
		Grn2StatusMaster grn2StatusMaster = new Grn2StatusMaster();
		ReceiptStatusMaster receiptStatusMaster = new ReceiptStatusMaster();

		Optional<Facility> facilityOptioanl = facilityRepository.findById(receiptDto.getFacilityId());
		if (facilityOptioanl.isPresent()) {
			Facility facility = facilityOptioanl.get();
			if (facility.getDivision() != null) {
				divisionId = facility.getDivision().getId();
			}
		}

		if (!receiptDto.getIsProductMatch()) {
			grn1StatusMaster.setId(2);
			receiptStatusMaster.setId(3);
			consignmentStatusMaster.setId(4);
			dispatchStatusMaster.setId(4);
		}

		if (receiptDto.getIsProductMatch() && !receiptDto.getIsBatchMatch()) {
			grn1StatusMaster.setId(2);
			receiptStatusMaster.setId(4);
			consignmentStatusMaster.setId(4);
			dispatchStatusMaster.setId(4);
		}
		Integer totalReceived = 0;
		for (BatchDto batch : receiptDto.getBatches()) {
			if (batch.getReceivedQuantity() != null) {
				totalReceived = totalReceived + batch.getReceivedQuantity().intValue();
			}

		}

		if (receiptDto.getIsProductMatch() && receiptDto.getIsBatchMatch()) {
			if (receiptDto.getBatches() != null) {
				for (BatchDto batch : receiptDto.getBatches()) {
					Integer quantityMismatch = 0;
					if (batch.getDamagedQuantity() != null) {
						quantityMismatch = batch.getQuantity().intValue()
								- (batch.getReceivedQuantity().intValue() + batch.getDamagedQuantity().intValue());
					}

					if (receiptDto.getProductQuantity().intValue() == totalReceived
							&& (batch.getDamagedQuantity() == null || batch.getDamagedQuantity() == 0)) {
						grn1StatusMaster.setId(1);
						receiptStatusMaster.setId(2);
						consignmentStatusMaster.setId(2);
						dispatchStatusMaster.setId(2);
						grn2StatusMaster.setId(1);
					}
					if ((batch.getDamagedQuantity() != null && batch.getDamagedQuantity() != 0)
							&& quantityMismatch.intValue() == 0) {
						grn1StatusMaster.setId(1);
						receiptStatusMaster.setId(7);
						consignmentStatusMaster.setId(2);
						dispatchStatusMaster.setId(2);
						grn2StatusMaster.setId(1);
					}
					if ((batch.getDamagedQuantity() != null && batch.getDamagedQuantity() != 0)
							&& quantityMismatch.intValue() != 0) {
						grn1StatusMaster.setId(1);
						receiptStatusMaster.setId(8);
						consignmentStatusMaster.setId(2);
						dispatchStatusMaster.setId(2);
						grn2StatusMaster.setId(1);
					}
					if ((batch.getDamagedQuantity() == null || batch.getDamagedQuantity() == 0)
							&& ((batch.getQuantity().intValue() - batch.getReceivedQuantity().intValue()) != 0)) {
						grn1StatusMaster.setId(1);
						receiptStatusMaster.setId(5);
						consignmentStatusMaster.setId(2);
						dispatchStatusMaster.setId(2);
						grn2StatusMaster.setId(1);

					}
					if (divisionId != DivisionEnum.LABORATORY.getDivision()) {
						receipt.setGrn2StatusMaster(grn2StatusMaster);
						receipt.setGrn2Date(LocalDateTime.now());
					}

				}
			}
		}

		receipt.setIsBatchMatch(receiptDto.getIsBatchMatch());
		receipt.setIsProductMatch(receiptDto.getIsProductMatch());
		receipt.setGrn1StatusMaster(grn1StatusMaster);
		receipt.setReceiptStatusMaster(receiptStatusMaster);
		receipt.setGrn1Date(LocalDateTime.now());
		dispatch.setDispatchId(receiptDto.getDispatchId());
		receipt.setDispatch(dispatch);

		Set<ReceiptBatch> receiptBatches = ReceiptMapperUtil.mapBatchDtoToReceiptBatches(receiptDto.getBatches(),
				receipt);
		receipt.setReceiptBatches(receiptBatches);
		Set<DispatchReceiptRemark> dispatchReceiptRemarks = ReceiptMapperUtil.mapReceiptDtoToDispatchReceiptRemark(
				receiptDto, dispatch, receipt, receiptStatusMaster.getId(), dispatchStatusMaster.getId());
		receipt.setDispatchReceiptRemarks(dispatchReceiptRemarks);

		receipt = receiptRepository.save(receipt);

		if (divisionId == DivisionEnum.LABORATORY.getDivision()) {

			List<FacilityStockTracking> consigneeFacilityStockTrackings = ReceiptMapperUtil
					.mapToFacilityStockTracking(receiptDto, receipt.getId());
			facilityStockTrackingRepository.saveAll(consigneeFacilityStockTrackings);

			for (BatchDto batch : receiptDto.getBatches()) {
				FacilityStock consigneeFacilityStock = facilityStockRepository
						.findByBatchNumberAndProduct_IdAndFacility_Id(batch.getBatchNumber(), receiptDto.getProductId(),
								receiptDto.getFacilityId());
				consigneeFacilityStock = ReceiptMapperUtil.mapToFacilityStock(consigneeFacilityStock, receiptDto, batch,
						receipt.getId());
				facilityStockRepository.save(consigneeFacilityStock);
			}

		}

		DispatchStatusTracking dispatchStatusTracking = new DispatchStatusTracking();
		dispatchStatusTracking.setDispatch(dispatch);
		dispatchStatusTracking.setReceipt(receipt);
		dispatchStatusTracking.setReceiptStatusMaster(receiptStatusMaster);
		UserMaster user = new UserMaster();
		user.setId(receiptDto.getUserId());
		dispatchStatusTracking.setUserMaster(user);
		dispatchStatusTrackingRepository.save(dispatchStatusTracking);

		if (receiptDto.getDispatchId() != null) {
			dispatch = dispatchRepository.findByDispatchId(receiptDto.getDispatchId());
			dispatch.setDispatchStatusMaster(dispatchStatusMaster);
			dispatch.setConsignmentStatusMaster(consignmentStatusMaster);
			dispatchRepository.save(dispatch);
		}

		return receiptDto;
	}

	public DispatchDetailedDto viewReceiptByReceiptIdFromSupplier(Long receiptId) {
		Optional<Receipt> receipt = receiptRepository.findById(receiptId);
		Dispatch dispatch = receipt.get().getDispatch();
		DispatchDetailedDto detailedDto = DispatchMapperUtil.mapDispatchToDispatchDetailedDto(dispatch, receipt.get());
		if (receipt != null) {
			if (receipt.get().getReceiptStatusMaster() != null) {
				detailedDto.setReceiptStatus(receipt.get().getReceiptStatusMaster().getStatus());
			} else {
				detailedDto.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
			}
			List<BatchDto> batchDtos = new ArrayList<BatchDto>();
			for (ReceiptBatch receiptBatch : receipt.get().getReceiptBatches()) {
				BatchDto batchDto = new BatchDto();
				batchDto.setReceiptBatchId(receiptBatch.getId());
				batchDto.setBatchNumber(receiptBatch.getBatchNumber());
				batchDto.setManufactureDate(receiptBatch.getBatchManufactureDate());
				batchDto.setExpiryDate(receiptBatch.getBatchExpiryDate());
				batchDto.setReceivedQuantity(receiptBatch.getGrn1Quantity());
				batchDto.setGrn2Quantity(receiptBatch.getGrn2Quantity());
				batchDto.setDamagedQuantity(receiptBatch.getDamagedQuantity());
				batchDto.setQuantity(receiptBatch.getDispatchedQuantity());
				batchDtos.add(batchDto);
			}
			detailedDto.setActiveBatchDetails(batchDtos);
		}
		return detailedDto;
	}

	public AcceptConsignmentDto acceptConsignement(AcceptConsignmentDto acceptConsignmentDto) {

		Optional<Dispatch> dispatch = dispatchRepository.findById(acceptConsignmentDto.getDispatchId());
		Dispatch dispatchUpdate = dispatch.get();
		dispatchUpdate = ReceiptMapperUtil.mapAcceptConsignmentDtoToDispatch(dispatch.get(), acceptConsignmentDto);
		// Facility stock tracking records
		Set<FacilityStockTracking> facilityStockTracking = new HashSet<>();
		facilityStockTracking = ReceiptMapperUtil.mapReceiptBatchToFacilityStockTracking(acceptConsignmentDto);
		facilityStockTrackingRepository.saveAll(facilityStockTracking);

		for (Receipt receipt : dispatch.get().getReceipts()) {
			Grn2StatusMaster grn2StatusMaster = new Grn2StatusMaster();
			grn2StatusMaster.setId(2);
			receipt.setGrn2StatusMaster(grn2StatusMaster);
		}

		for (ConsignmentBatchDto consignmentBatchDto : acceptConsignmentDto.getConsignmentBatches()) {
			FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					consignmentBatchDto.getBatchNumber(), consignmentBatchDto.getProductId(),
					dispatchUpdate.getShipToConsignee().getId());

			if (facilityStock != null) {
				if (consignmentBatchDto.getReceivedQuantity() != null) {
					if (facilityStock.getCurrentQuantity() != null) {
						facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() + consignmentBatchDto.getReceivedQuantity());
					} else {
						facilityStock.setCurrentQuantity(consignmentBatchDto.getReceivedQuantity().doubleValue());
					}
				}
				if (consignmentBatchDto.getDamagedQty() != null) {
					if (facilityStock.getDamagedQuantity() != null) {
						facilityStock.setDamagedQuantity(facilityStock.getDamagedQuantity() + consignmentBatchDto.getDamagedQty());
					} else {
						facilityStock.setDamagedQuantity(consignmentBatchDto.getDamagedQty().doubleValue());
					}
				}
			} else {
				facilityStock = new FacilityStock();
				facilityStock.setBatchNumber(consignmentBatchDto.getBatchNumber());
				Facility facility = new Facility();
				facility.setId(dispatchUpdate.getShipToConsignee().getId());
				facilityStock.setFacility(facility);
				Product product = new Product();
				product.setId(consignmentBatchDto.getProductId());
				facilityStock.setProduct(product);
				facilityStock.setIsActive(true);
				facilityStock.setIsDelete(false);
				facilityStock.setManufacturingDate(consignmentBatchDto.getManufactureDate());
				facilityStock.setExpiredDate(consignmentBatchDto.getExpiryDate());
				facilityStock.setDamagedQuantity(consignmentBatchDto.getDamagedQty().doubleValue());
				if (consignmentBatchDto.getReceivedQuantity() != null) {
					facilityStock.setCurrentQuantity(consignmentBatchDto.getReceivedQuantity().doubleValue());
				}
			}
			facilityStockRepository.save(facilityStock);
		}
		dispatchUpdate.setReceipts(dispatch.get().getReceipts());
		dispatchRepository.save(dispatchUpdate);
		return acceptConsignmentDto;
	}

	public List<ReceiptSupplierDto> getReceiptHistory(Long facilityId, String user, String stnNumber, String invoiceNumber, String productName) {

		List<Long> consigneeIdList = new ArrayList<>();
		consigneeIdList.add(facilityId);

		List<Facility> facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(facilityId, Boolean.FALSE,
				Boolean.TRUE);
		if (!CollectionUtils.isEmpty(facilityList)) {
			List<Long> facilityIds = facilityList.stream().map(f -> f.getId()).collect(Collectors.toList());
			consigneeIdList.addAll(facilityIds);
		}
		List<Receipt> receiptList =new ArrayList<>();
		if(stnNumber==null&&invoiceNumber==null&&productName==null) {
			receiptList = receiptRepository.findAllByDispatch_ShipToConsignee_IdIn(consigneeIdList);	
		}else {
			String searchQuery=ReceiptMapperUtil.createSearchQuery(consigneeIdList,stnNumber,invoiceNumber,productName);
			receiptList = receiptRepository.findReceiptHistoryBySearchQuery(searchQuery);
		}

		return ReceiptMapperUtil.mappDispatchListToReceiptSupplierDto(receiptList, user);
	}

}
