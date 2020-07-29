package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.FacilityReceiveStockListDto;
import gov.naco.soch.dto.FacilityReconciliationDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.entity.FacilityDispatchStatusMaster;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.FacilityReceiptProduct;
import gov.naco.soch.entity.FacilityReceiptProductBatch;
import gov.naco.soch.entity.FacilityReconciliation;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ReceiptBatchStatusMaster;
import gov.naco.soch.entity.ReconciliationStatusMaster;
import gov.naco.soch.inventory.mapper.FacilityReceiptMapperUtil;
import gov.naco.soch.inventory.mapper.FacilityReconciliationMapperUtil;
import gov.naco.soch.repository.FacilityDispatchReceiptRemarkRepository;
import gov.naco.soch.repository.FacilityDispatchRepository;
import gov.naco.soch.repository.FacilityReceiptProductBatchRepository;
import gov.naco.soch.repository.FacilityReceiptRepository;
import gov.naco.soch.repository.FacilityReconciliationRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;

@Service
@Transactional
public class FacilityReconcilationService {

	@Autowired
	private FacilityReceiptRepository facilityReceiptRepository;

	@Autowired
	private FacilityReceiptProductBatchRepository facilityReceiptProductBatchRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityReconciliationRepository facilityReconciliationRepository;

	@Autowired
	private FacilityDispatchReceiptRemarkRepository facilityDispatchReceiptRemarkRepository;

	@Autowired
	private FacilityDispatchRepository facilityDispatchRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	public List<FacilityReconciliationDto> getReconcilationList(Long facilityId) {

		List<Long> consignorIdList = new ArrayList<>();
		consignorIdList.add(facilityId);

		List<Facility> facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(facilityId, Boolean.FALSE,
				Boolean.TRUE);
		if (!CollectionUtils.isEmpty(facilityList)) {
			List<Long> facilityIds = facilityList.stream().map(f -> f.getId()).collect(Collectors.toList());
			consignorIdList.addAll(facilityIds);
		}

		List<FacilityReceipt> receiptList = facilityReceiptRepository.findReconcilationList(consignorIdList);
		List<FacilityReconciliationDto> reconcilationList = FacilityReconciliationMapperUtil
				.mapFacilityReceiptToFacilityReconciliationDto(receiptList);
		return reconcilationList;

	}

	public FacilityReceiveStockListDto getReconcilationById(Long facilityReceiptId) {
		FacilityReceipt facilityReceipt = facilityReceiptRepository.findByFacilityReceiptId(facilityReceiptId);
		FacilityReceiveStockListDto facilityReceiveStockListDto = FacilityReceiptMapperUtil
				.mapToFacilityReceiveStockListDto(facilityReceipt.getFacilityDispatch(), facilityReceipt);
		return facilityReceiveStockListDto;
	}

	public FacilityReconciliationDto acceptReconciliation(@Valid FacilityReconciliationDto facilityReconciliationDto) {

		ReceiptBatchStatusMaster receiptBatchStatusMaster = new ReceiptBatchStatusMaster();
		FacilityStock consignorFacilityStock = new FacilityStock();
		FacilityStock consigneeFacilityStock = new FacilityStock();
		ReconciliationStatusMaster reconciliationStatusMaster = new ReconciliationStatusMaster();
		FacilityReconciliation facilityReconciliation = new FacilityReconciliation();
		FacilityDispatchStatusMaster facilityDispatchStatusMaster = new FacilityDispatchStatusMaster();

		Long productId = null;
		String receiverType = null;

		Optional<FacilityReceiptProductBatch> facilityReceiptProductBatchOpt = facilityReceiptProductBatchRepository
				.findById(facilityReconciliationDto.getFacilityReceiptBatchId());
		FacilityReceiptProductBatch facilityReceiptProductBatch = facilityReceiptProductBatchOpt.get();
		if (facilityReceiptProductBatchOpt.get().getFacilityReceiptProduct() != null) {
			if (facilityReceiptProductBatch.getFacilityReceiptProduct().getProduct() != null) {
				productId = facilityReceiptProductBatch.getFacilityReceiptProduct().getProduct().getId();
				consignorFacilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
						facilityReceiptProductBatch.getBatchNumber(),
						facilityReceiptProductBatch.getFacilityReceiptProduct().getProduct().getId(),
						facilityReconciliationDto.getConsignorId());
				consigneeFacilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
						facilityReceiptProductBatch.getBatchNumber(),
						facilityReceiptProductBatch.getFacilityReceiptProduct().getProduct().getId(),
						facilityReconciliationDto.getConsigneeId());
			}
		}

		// mapping facility reconciliation details
		facilityReconciliation.setBatchNumber(facilityReceiptProductBatch.getBatchNumber());
		Facility facility = new Facility();
		facility.setId(facilityReconciliationDto.getFacilityId());
		facilityReconciliation.setFacility(facility);
		facilityReconciliation.setFacilityReceiptProductBatch(facilityReceiptProductBatch);
		facilityReconciliation.setGit(facilityReceiptProductBatch.getGit());
		if (productId != null) {
			Product product = new Product();
			product.setId(productId);
			facilityReconciliation.setProduct(product);
		}
		facilityReconciliationRepository.save(facilityReconciliation);

		// save remark in remark table
		FacilityDispatchReceiptRemark facilityDispatchReceiptRemark = FacilityReconciliationMapperUtil
				.mapToDispatchReceiptRemark(facilityReconciliationDto, facilityReceiptProductBatch);
		facilityDispatchReceiptRemarkRepository.save(facilityDispatchReceiptRemark);

		if ((facilityReconciliationDto.getFacilityId() == facilityReconciliationDto.getConsignorId())
				&& facilityReconciliationDto.isLostInTransit() == false) {
			receiverType = "consignor";
			receiptBatchStatusMaster.setId(1);

		} else if ((facilityReconciliationDto.getFacilityId() == facilityReconciliationDto.getConsigneeId())
				&& facilityReconciliationDto.isLostInTransit() == false) {
			receiverType = "consignee";
			receiptBatchStatusMaster.setId(2);

		} else if (facilityReconciliationDto.isLostInTransit()) {
			receiptBatchStatusMaster.setId(3);
			receiverType = "sacsLostInTransit";

		} else if ((facilityReconciliationDto.getFacilityId() != facilityReconciliationDto.getConsigneeId())
				&& (facilityReconciliationDto.getFacilityId() != facilityReconciliationDto.getConsignorId())
				&& facilityReconciliationDto.isLostInTransit() == false) {
			List<Long> facilityIdList = new ArrayList<>();
			List<Facility> facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(
					facilityReconciliationDto.getFacilityId(), Boolean.FALSE, Boolean.TRUE);
			if (!CollectionUtils.isEmpty(facilityList)) {
				List<Long> facilityIds = facilityList.stream().map(f -> f.getId()).collect(Collectors.toList());
				facilityIdList.addAll(facilityIds);
			}

			if (facilityIdList.contains(facilityReconciliationDto.getConsignorId())) {
				receiptBatchStatusMaster.setId(1);
			}

			if (facilityIdList.contains(facilityReconciliationDto.getConsigneeId())) {
				receiptBatchStatusMaster.setId(2);
			}
			receiverType = "sacs";
		}

		if (receiverType == "consignor") {
			FacilityStockTracking facilityStockTracking = FacilityReconciliationMapperUtil.mapToFacilityStockTracking(
					facilityReceiptProductBatch, facilityReconciliationDto.getFacilityId(), receiverType);
			facilityStockTrackingRepository.save(facilityStockTracking);
			if (consignorFacilityStock.getGit() != null && facilityReceiptProductBatch.getGit() != null) {
				consignorFacilityStock.setGit(consignorFacilityStock.getGit() - facilityReceiptProductBatch.getGit());
			} else if (consignorFacilityStock.getGit() == 0 || consignorFacilityStock.getGit() == null) {
				consignorFacilityStock.setGit(0.0);
			}
			facilityStockRepository.save(consignorFacilityStock);
		}
		if (receiverType == "consignee") {
			Double consigneeFacilityStockQuantity = 0.0;

			if (consignorFacilityStock.getGit() != null && facilityReceiptProductBatch.getGit() != null) {
				consignorFacilityStock.setGit(consignorFacilityStock.getGit() - facilityReceiptProductBatch.getGit());
			} else if (consignorFacilityStock.getGit() == 0 || consignorFacilityStock.getGit() == null) {
				consignorFacilityStock.setGit(0.0);
			}
			if (facilityReceiptProductBatch.getGit() != null) {
				consigneeFacilityStockQuantity = consigneeFacilityStock.getCurrentQuantity()
						+ facilityReceiptProductBatch.getGit();
			}
			FacilityStockTracking consigneeFacilityStockTracking = FacilityReconciliationMapperUtil
					.mapToFacilityStockTracking(facilityReceiptProductBatch, facilityReconciliationDto.getConsigneeId(),
							receiverType);
			facilityStockTrackingRepository.save(consigneeFacilityStockTracking);

			consigneeFacilityStock.setCurrentQuantity(consigneeFacilityStockQuantity);
			facilityStockRepository.save(consigneeFacilityStock);

			receiverType = "consignorstock";
			FacilityStockTracking consignorFacilityStockTracking = FacilityReconciliationMapperUtil
					.mapToFacilityStockTracking(facilityReceiptProductBatch, facilityReconciliationDto.getConsignorId(),
							receiverType);
			facilityStockTrackingRepository.save(consignorFacilityStockTracking);

			// consignorFacilityStock.setCurrentQuantity(consignorFacilityStockQuantity);
			// facilityStockRepository.save(consignorFacilityStock);

		}
		if (receiverType == "sacs") {
			Double consignorFacilityStockQuantity = 0.0;

			FacilityStockTracking facilityStockTracking = FacilityReconciliationMapperUtil.mapToFacilityStockTracking(
					facilityReceiptProductBatch, facilityReconciliationDto.getFacilityId(), receiverType);
			facilityStockTrackingRepository.save(facilityStockTracking);

			if (facilityReceiptProductBatch.getGit() != null) {
				consignorFacilityStockQuantity = consignorFacilityStock.getCurrentQuantity()
						- facilityReceiptProductBatch.getGit();
			}
			consignorFacilityStock.setCurrentQuantity(consignorFacilityStockQuantity);
			if (consignorFacilityStock.getGit() != null && facilityReceiptProductBatch.getGit() != null) {
				consignorFacilityStock.setGit(consignorFacilityStock.getGit() - facilityReceiptProductBatch.getGit());
			} else if (consignorFacilityStock.getGit() == 0 || consignorFacilityStock.getGit() == null) {
				consignorFacilityStock.setGit(0.0);
			}
			facilityStockRepository.save(consignorFacilityStock);
		}
		if (receiverType == "sacsLostInTransit") {
			FacilityStockTracking facilityStockTracking = FacilityReconciliationMapperUtil.mapToFacilityStockTracking(
					facilityReceiptProductBatch, facilityReconciliationDto.getConsignorId(), receiverType);
			facilityStockTrackingRepository.save(facilityStockTracking);

			if (consignorFacilityStock.getGit() != null && facilityReceiptProductBatch.getGit() != null) {
				consignorFacilityStock.setGit(consignorFacilityStock.getGit() - facilityReceiptProductBatch.getGit());
			} else if (consignorFacilityStock.getGit() == 0 || consignorFacilityStock.getGit() == null) {
				consignorFacilityStock.setGit(0.0);
			}
			facilityStockRepository.save(consignorFacilityStock);
		}

		facilityReceiptProductBatch.setReceiptBatchStatusMaster(receiptBatchStatusMaster);
		facilityReceiptProductBatch.setReconciliationDate(LocalDate.now());
		facilityReceiptProductBatch.setGit(0L);
		facilityReceiptProductBatchRepository.save(facilityReceiptProductBatch);

		if (facilityReceiptProductBatch.getFacilityReceiptProduct() != null) {
			if (facilityReceiptProductBatch.getFacilityReceiptProduct().getFacilityReceipt() != null) {
				boolean isReconciled = true;
				FacilityReceipt facilityReceipt = facilityReceiptProductBatch.getFacilityReceiptProduct()
						.getFacilityReceipt();
				FacilityDispatch facilityDispatch = facilityReceipt.getFacilityDispatch();

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
				if (isReconciled) {
					reconciliationStatusMaster.setId(2);
					facilityReceipt.setReconciliationStatusMaster(reconciliationStatusMaster);
					facilityDispatchStatusMaster.setId(3L);
					facilityDispatch.setFacilityDispatchStatusMaster(facilityDispatchStatusMaster);
				}
				facilityReceiptRepository.save(facilityReceipt);
				facilityDispatchRepository.save(facilityDispatch);

			}
		}

		return facilityReconciliationDto;
	}

	public List<FacilityReconciliationDto> getReconcilationListBySearch(Long facilityId, String stnNumber,
			String consignor, String consignee) {
		List<Long> consignorIdList = new ArrayList<>();
		consignorIdList.add(facilityId);

		List<Facility> facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(facilityId, Boolean.FALSE,
				Boolean.TRUE);
		if (!CollectionUtils.isEmpty(facilityList)) {
			List<Long> facilityIds = facilityList.stream().map(f -> f.getId()).collect(Collectors.toList());
			consignorIdList.addAll(facilityIds);
		}

		String searchQuery = FacilityReconciliationMapperUtil.createSearchQuery(facilityId, consignorIdList, stnNumber,
				consignor, consignee);
		List<FacilityReceipt> receiptList = facilityReceiptRepository.findFacilityReceiptBySearchValue(searchQuery);
		List<FacilityReconciliationDto> reconcilationList = FacilityReconciliationMapperUtil
				.mapFacilityReceiptToFacilityReconciliationDto(receiptList);
		return reconcilationList;
	}

}
