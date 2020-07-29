package gov.naco.soch.inventory.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.UnregisteredSourceReceiveStockDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityConsignmentStatusMaster;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchProduct;
import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.entity.FacilityDispatchStatusMaster;
import gov.naco.soch.entity.FacilityDispatchStatusTracking;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.FacilityReceiptProduct;
import gov.naco.soch.entity.FacilityRelocationRequestStatusMaster;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.MasterInventoryUnregisteredSource;
import gov.naco.soch.entity.Product;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.mapper.FacilityReceiptMapperUtil;
import gov.naco.soch.inventory.mapper.UnregisteredSourceReceiveStockMapperUtil;
import gov.naco.soch.repository.FacilityConsignmentStatusMasterRepository;
import gov.naco.soch.repository.FacilityDispatchRepository;
import gov.naco.soch.repository.FacilityDispatchStatusMasterRepository;
import gov.naco.soch.repository.FacilityReceiptRepository;
import gov.naco.soch.repository.FacilityRelocationRequestStatusMasterRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;
import gov.naco.soch.repository.MasterInventoryUnregisteredSourceRepository;
import gov.naco.soch.repository.ProductRepository;

@Service
public class UnregisteredSourceReceiveStockService {

	private static final Logger logger = LoggerFactory.getLogger(UnregisteredSourceReceiveStockService.class);

	private static String DISPATCHED = "Dispatched";

	private static String DISPATCH = "Dispatch";

	private static String PENDING = "Pending";

	@Autowired
	private MasterInventoryUnregisteredSourceRepository unregisteredSourceRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private FacilityReceiptRepository facilityReceiptRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityDispatchRepository facilityDispatchRepository;

	@Autowired
	private FacilityDispatchStatusMasterRepository facilityDispatchStatusMasterRepository;

	@Autowired
	private FacilityConsignmentStatusMasterRepository facilityConsignmentStatusMasterRepository;

	@Autowired
	private FacilityRelocationRequestStatusMasterRepository facilityRelocationRequestStatusMasterRepository;

	public List<UnregisteredSourceReceiveStockDto> getAllUnregisteredSources() {
		logger.info("In getAllUnregisteredSources() of UnregisteredSourceReceiveStockService");
		List<UnregisteredSourceReceiveStockDto> sourceList = new ArrayList<>();
		List<MasterInventoryUnregisteredSource> sourceListFetched = unregisteredSourceRepository
				.findByIsDeleteAndIsFacility(Boolean.FALSE, Boolean.FALSE);
		sourceList = sourceListFetched.stream()
				.map(s -> UnregisteredSourceReceiveStockMapperUtil.mapToUnregisteredSourceReceiveStockDto(s))
				.collect(Collectors.toList());
		return sourceList;
	}

	public UnregisteredSourceReceiveStockDto receiveStock(UnregisteredSourceReceiveStockDto dto) {

		MasterInventoryUnregisteredSource source = null;
		if (dto.getSourceId() == null) {
			source = UnregisteredSourceReceiveStockMapperUtil.mapToMasterInventoryUnregisteredSource(dto,
					Boolean.FALSE);
			source = unregisteredSourceRepository.save(source);
		} else {
			Optional<MasterInventoryUnregisteredSource> sourceOpt = unregisteredSourceRepository
					.findById(dto.getSourceId());
			if (sourceOpt.isPresent()) {
				source = sourceOpt.get();
			} else {
				throw new ServiceException("Invalid Source Id", null, HttpStatus.BAD_REQUEST);
			}
		}

		FacilityReceipt facilityReceipt = UnregisteredSourceReceiveStockMapperUtil.mapToFacilityReceipt(source, dto);

		// Update Facility Stock information
		String receiverType = "receiveFromUnregisteredSource";
		List<FacilityStockTracking> facilityStockTrackings = new ArrayList<>();
		List<FacilityStock> facilityStocks = new ArrayList<>();

		for (BatchDto batch : dto.getBatchDetails()) {

			FacilityStockTracking consigneeFacilityStockTracking = FacilityReceiptMapperUtil.mapToFacilityStockTracking(
					batch, dto.getFacilityId(), batch.getProductId(), receiverType,
					facilityReceipt.getFacilityReceiptId());
			facilityStockTrackings.add(consigneeFacilityStockTracking);

			FacilityStock consigneeFacilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					batch.getBatchNumber(), batch.getProductId(), dto.getFacilityId());

			if (consigneeFacilityStock != null && consigneeFacilityStock.getManufacturingDate() != null
					&& consigneeFacilityStock.getExpiredDate() != null && batch.getExpiryDate() != null
					&& batch.getManufactureDate() != null) {

				if (!batch.getExpiryDate().equals(consigneeFacilityStock.getExpiredDate())
						|| !batch.getManufactureDate().equals(consigneeFacilityStock.getManufacturingDate())) {

					if (!batch.getExpiryDate().equals(consigneeFacilityStock.getExpiredDate())
							&& batch.getManufactureDate().equals(consigneeFacilityStock.getManufacturingDate())) {
						throw new ServiceException(
								"Expiry Date does not match the previous receipt entry made for batch "
										+ batch.getBatchNumber() + "of "
										+ consigneeFacilityStock.getProduct().getProductName()
										+ " i.e. (enter date entered last time:"
										+ consigneeFacilityStock.getExpiredDate() + ")",
								null, HttpStatus.BAD_REQUEST);
					}

					if (!batch.getManufactureDate().equals(consigneeFacilityStock.getManufacturingDate())
							&& batch.getExpiryDate().equals(consigneeFacilityStock.getExpiredDate())) {
						throw new ServiceException(
								"Manufacture Date does not match the previous receipt entry made for batch "
										+ batch.getBatchNumber() + "of "
										+ consigneeFacilityStock.getProduct().getProductName()
										+ " i.e. (enter date entered last time:"
										+ consigneeFacilityStock.getManufacturingDate() + ")",
								null, HttpStatus.BAD_REQUEST);
					}

					if (!batch.getManufactureDate().equals(consigneeFacilityStock.getManufacturingDate())
							&& !batch.getExpiryDate().equals(consigneeFacilityStock.getExpiredDate())) {
						throw new ServiceException(
								"Expiry & Manufacture Dates does not match the previous receipt entry made for batch "
										+ batch.getBatchNumber() + "of "
										+ consigneeFacilityStock.getProduct().getProductName()
										+ " i.e. (enter dates entered last time: Expiry date="
										+ consigneeFacilityStock.getExpiredDate() + " , Manufacture Date="
										+ consigneeFacilityStock.getManufacturingDate() + ")",
								null, HttpStatus.BAD_REQUEST);
					}
				}

				
			}
			consigneeFacilityStock = FacilityReceiptMapperUtil.mapToFacilityStock(batch, consigneeFacilityStock,
					dto.getFacilityId(), batch.getProductId(), receiverType,
					facilityReceipt.getFacilityReceiptStatusMaster());
			facilityStocks.add(consigneeFacilityStock);

		}

		List<Long> productIds = dto.getBatchDetails().stream().map(b -> b.getProductId()).distinct()
				.collect(Collectors.toList());
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productsMap = products.stream().collect(Collectors.toMap(Product::getId, p -> p));

		Map<Long, List<BatchDto>> productBatchMapping = dto.getBatchDetails().stream()
				.collect(Collectors.groupingBy(BatchDto::getProductId));

		Set<FacilityReceiptProduct> facilityReceiptProductSet = UnregisteredSourceReceiveStockMapperUtil
				.mapDispatchDtoToFacilityReceiptProductSet(facilityReceipt, productsMap, productBatchMapping);
		facilityReceipt.setFacilityReceiptProducts(facilityReceiptProductSet);

		FacilityDispatchReceiptRemark remark = new FacilityDispatchReceiptRemark();
		remark.setRemarks(dto.getRemarks());
		remark.setFacilityReceipt(facilityReceipt);
		remark.setFacilityReceiptStatusMaster(facilityReceipt.getFacilityReceiptStatusMaster());
		remark.setIsActive(Boolean.TRUE);
		remark.setIsDelete(Boolean.FALSE);

		Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarkSet = new HashSet<>();
		facilityDispatchReceiptRemarkSet.add(remark);
		facilityReceipt.setFacilityDispatchReceiptRemarks(facilityDispatchReceiptRemarkSet);

		facilityReceiptRepository.save(facilityReceipt);

		if ((!CollectionUtils.isEmpty(facilityStockTrackings)) && (!CollectionUtils.isEmpty(facilityStocks))) {
			facilityStockTrackingRepository.saveAll(facilityStockTrackings);
			facilityStockRepository.saveAll(facilityStocks);
		}

		return dto;
	}

	public List<UnregisteredSourceReceiveStockDto> receivedStockList(Long facilityId, String productName,
			String sourceName) {

		List<Long> facilityIdList = new ArrayList<>();
		facilityIdList.add(facilityId);

		/*
		 * List<Facility> facilityList =
		 * facilityRepository.findBySacsIdAndIsDeleteAndIsActive(facilityId,
		 * Boolean.FALSE, Boolean.TRUE); if (!CollectionUtils.isEmpty(facilityList)) {
		 * List<Long> facilityIds = facilityList.stream().map(f ->
		 * f.getId()).collect(Collectors.toList()); facilityIdList.addAll(facilityIds);
		 * }
		 */
		List<FacilityReceipt> receiptsList = new ArrayList<>();
		if (productName == null&&sourceName==null) {
			receiptsList = facilityReceiptRepository.findByReceivedFacilityIds(facilityIdList);
		} else {
			String searchQuery = UnregisteredSourceReceiveStockMapperUtil.createSearchQuery(facilityIdList, productName,
					sourceName);
			receiptsList = facilityReceiptRepository.findUnregisteredSourceHistoryBySearchQuery(searchQuery);
		}
		List<UnregisteredSourceReceiveStockDto> dtoList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(receiptsList)) {
			receiptsList.forEach(r -> {
				UnregisteredSourceReceiveStockDto dto = UnregisteredSourceReceiveStockMapperUtil
						.mapToUnregisteredSourceReceiveStockDto(r);
				dtoList.add(dto);
			});
		}
		return dtoList;
	}

	public List<UnregisteredSourceReceiveStockDto> getAllUnregisteredFacilities() {
		logger.info("In getAllUnregisteredFacilities() of UnregisteredSourceReceiveStockService");
		List<UnregisteredSourceReceiveStockDto> sourceList = new ArrayList<>();
		List<MasterInventoryUnregisteredSource> sourceListFetched = unregisteredSourceRepository
				.findByIsDeleteAndIsFacility(Boolean.FALSE, Boolean.TRUE);
		sourceList = sourceListFetched.stream()
				.map(s -> UnregisteredSourceReceiveStockMapperUtil.mapToUnregisteredSourceReceiveStockDto(s))
				.collect(Collectors.toList());
		return sourceList;
	}

	public UnregisteredSourceReceiveStockDto dispatchStock(UnregisteredSourceReceiveStockDto dto) {

		MasterInventoryUnregisteredSource source = null;
		if (dto.getSourceId() == null) {
			source = UnregisteredSourceReceiveStockMapperUtil.mapToMasterInventoryUnregisteredSource(dto, Boolean.TRUE);
			source = unregisteredSourceRepository.save(source);
		} else {
			Optional<MasterInventoryUnregisteredSource> sourceOpt = unregisteredSourceRepository
					.findById(dto.getSourceId());
			if (sourceOpt.isPresent()) {
				source = sourceOpt.get();
			} else {
				throw new ServiceException("Invalid Source Id", null, HttpStatus.BAD_REQUEST);
			}
		}

		Facility consignorFacility = new Facility();
		consignorFacility.setId(dto.getFacilityId());

		FacilityDispatchStatusMaster facilityDispatchStatus = facilityDispatchStatusMasterRepository
				.findByStatusAndIsDelete(DISPATCHED, Boolean.FALSE);

		FacilityConsignmentStatusMaster facilityConsignmentStatus = facilityConsignmentStatusMasterRepository
				.findByStatusAndIsDelete(PENDING, Boolean.FALSE);

		FacilityRelocationRequestStatusMaster relocationRequestStatus = facilityRelocationRequestStatusMasterRepository
				.findByStatusAndIsDelete(PENDING, Boolean.FALSE);

		FacilityDispatch facilityDispatch = new FacilityDispatch();
		facilityDispatch.setConsignor(consignorFacility);

		facilityDispatch.setFacilityDispatchStatusMaster(facilityDispatchStatus);
		facilityDispatch.setFacilityConsignmentStatusMaster(facilityConsignmentStatus);
		facilityDispatch.setFacilityRelocationRequestStatusMaster(relocationRequestStatus);
		facilityDispatch.setMasterInventoryUnregisteredSource(source);

		facilityDispatch = UnregisteredSourceReceiveStockMapperUtil.mapDispatchDtoToFacilityDispatch(facilityDispatch,
				dto);

		List<Long> productIds = dto.getBatchDetails().stream().map(b -> b.getProductId()).collect(Collectors.toList());

		productIds = productIds.stream().distinct().collect(Collectors.toList());
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productsMap = products.stream().collect(Collectors.toMap(Product::getId, p -> p));

		List<FacilityDispatchProduct> facilityDispatchProductList = UnregisteredSourceReceiveStockMapperUtil
				.mapDispatchDtoToFacilityDispatchProductLis(facilityDispatch, dto, productsMap);

		Set<FacilityDispatchProduct> facilityDispatchProductSet = facilityDispatchProductList.stream()
				.collect(Collectors.toSet());

		facilityDispatch.setFacilityDispatchProducts(facilityDispatchProductSet);

		FacilityDispatchReceiptRemark remark = new FacilityDispatchReceiptRemark();
		remark.setRemarks(dto.getRemarks());
		remark.setFacilityDispatch(facilityDispatch);
		remark.setFacilityDispatchStatusMaster(facilityDispatchStatus);
		remark.setIsActive(Boolean.TRUE);
		remark.setIsDelete(Boolean.FALSE);

		Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarkSet = new HashSet<>();
		facilityDispatchReceiptRemarkSet.add(remark);
		facilityDispatch.setFacilityDispatchReceiptRemarks(facilityDispatchReceiptRemarkSet);

		FacilityDispatchStatusTracking facilityDispatchStatusTracking = new FacilityDispatchStatusTracking();
		facilityDispatchStatusTracking.setFacilityDispatchStatusMaster(facilityDispatchStatus);
		facilityDispatchStatusTracking.setFacilityDispatch(facilityDispatch);
		facilityDispatchStatusTracking.setIsActive(Boolean.TRUE);
		facilityDispatchStatusTracking.setIsDelete(Boolean.FALSE);

		Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackingSet = new HashSet<>();
		facilityDispatchStatusTrackingSet.add(facilityDispatchStatusTracking);
		facilityDispatch.setFacilityDispatchStatusTrackings(facilityDispatchStatusTrackingSet);
		facilityDispatch.setDispatchType(DISPATCH);

		facilityDispatch = facilityDispatchRepository.save(facilityDispatch);

		String stnNumber = "STN" + StringUtils.leftPad(facilityDispatch.getFacilityDispatchId().toString(), 13, "0");

		facilityDispatch.setStnNumber(stnNumber);
		facilityDispatch = facilityDispatchRepository.save(facilityDispatch);

		// Update Facility Stock information
		String receiverType = "dispatchToUnregSource";
		List<FacilityStockTracking> facilityStockTrackings = new ArrayList<>();
		List<FacilityStock> facilityStocks = new ArrayList<>();

		for (BatchDto batch : dto.getBatchDetails()) {
			FacilityStockTracking consigneeFacilityStockTracking = FacilityReceiptMapperUtil.mapToFacilityStockTracking(
					batch, dto.getFacilityId(), batch.getProductId(), receiverType,
					facilityDispatch.getFacilityDispatchId());
			facilityStockTrackings.add(consigneeFacilityStockTracking);
			FacilityStock consigneeFacilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					batch.getBatchNumber(), batch.getProductId(), dto.getFacilityId());
			consigneeFacilityStock = FacilityReceiptMapperUtil.mapToFacilityStock(batch, consigneeFacilityStock,
					dto.getFacilityId(), batch.getProductId(), receiverType, null);
			facilityStocks.add(consigneeFacilityStock);
		}

		if ((!CollectionUtils.isEmpty(facilityStockTrackings)) && (!CollectionUtils.isEmpty(facilityStocks))) {
			facilityStockTrackingRepository.saveAll(facilityStockTrackings);
			facilityStockRepository.saveAll(facilityStocks);
		}

		return dto;
	}

}
