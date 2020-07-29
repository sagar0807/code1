package gov.naco.soch.inventory.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityConsignmentStatusMaster;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchProduct;
import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.entity.FacilityDispatchStatusMaster;
import gov.naco.soch.entity.FacilityDispatchStatusTracking;
import gov.naco.soch.entity.FacilityRelocationRequestStatusMaster;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.GoodsRequest;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.DivisionEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.mapper.FacilityDispatchMapperUtil;
import gov.naco.soch.repository.FacilityConsignmentStatusMasterRepository;
import gov.naco.soch.repository.FacilityDispatchRepository;
import gov.naco.soch.repository.FacilityDispatchStatusMasterRepository;
import gov.naco.soch.repository.FacilityRelocationRequestStatusMasterRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;
import gov.naco.soch.repository.GoodsRequestRepository;
import gov.naco.soch.repository.ProductRepository;

@Service
public class FacilityDispatchService {

	private static String PENDING = "Pending";

	private static String APPROVED = "Approved";

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private FacilityDispatchRepository facilityDispatchRepository;

	@Autowired
	private FacilityDispatchStatusMasterRepository facilityDispatchStatusMasterRepository;

	@Autowired
	private FacilityConsignmentStatusMasterRepository facilityConsignmentStatusMasterRepository;

	@Autowired
	private FacilityRelocationRequestStatusMasterRepository facilityRelocationRequestStatusMasterRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private GoodsRequestRepository goodsRequestRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	public DispatchDetailedDto savefacilityDispatchDetails(DispatchDetailedDto dispatchDetailedDto) {

		validateDispatch(dispatchDetailedDto);
		FacilityRelocationRequestStatusMaster relocationRequestStatus = new FacilityRelocationRequestStatusMaster();

		Optional<Facility> consigneeFacility = facilityRepository
				.findById(dispatchDetailedDto.getShippedToFacilityId());

		Optional<Facility> consignorFacility = facilityRepository.findById(dispatchDetailedDto.getConsignerId());

		if (consigneeFacility.isPresent() && consignorFacility.isPresent()) {

			FacilityDispatchStatusMaster facilityDispatchStatus = null;
			if (dispatchDetailedDto.getDispatchType().equalsIgnoreCase("dispatch")) {
				facilityDispatchStatus = facilityDispatchStatusMasterRepository.findByStatusAndIsDelete("Dispatched",
						Boolean.FALSE);
			} else {

				if ((consigneeFacility.get().getDivision().getId() == DivisionEnum.LABORATORY.getDivision())
						|| (consignorFacility.get().getDivision().getId() == DivisionEnum.LABORATORY.getDivision())) {
					facilityDispatchStatus = facilityDispatchStatusMasterRepository.findByStatusAndIsDelete("Relocate",
							Boolean.FALSE);

				} else {
					facilityDispatchStatus = facilityDispatchStatusMasterRepository
							.findByStatusAndIsDelete("Relocate Request", Boolean.FALSE);
				}
			}

			if ((consigneeFacility.get().getDivision().getId() == DivisionEnum.LABORATORY.getDivision())
					|| (consignorFacility.get().getDivision().getId() == DivisionEnum.LABORATORY.getDivision())) {
				relocationRequestStatus = facilityRelocationRequestStatusMasterRepository
						.findByStatusAndIsDelete(APPROVED, Boolean.FALSE);
			} else {
				relocationRequestStatus = facilityRelocationRequestStatusMasterRepository
						.findByStatusAndIsDelete(PENDING, Boolean.FALSE);
			}

			FacilityConsignmentStatusMaster facilityConsignmentStatus = facilityConsignmentStatusMasterRepository
					.findByStatusAndIsDelete(PENDING, Boolean.FALSE);

			FacilityDispatch facilityDispatch = new FacilityDispatch();
			facilityDispatch.setConsignee(consigneeFacility.get());
			facilityDispatch.setConsignor(consignorFacility.get());

			facilityDispatch.setFacilityDispatchStatusMaster(facilityDispatchStatus);
			facilityDispatch.setFacilityConsignmentStatusMaster(facilityConsignmentStatus);
			facilityDispatch.setFacilityRelocationRequestStatusMaster(relocationRequestStatus);

			facilityDispatch = FacilityDispatchMapperUtil.mapDispatchDtoToFacilityDispatch(facilityDispatch,
					dispatchDetailedDto);

			List<Long> productIds = dispatchDetailedDto.getBatchDetails().stream().map(b -> b.getProductId())
					.collect(Collectors.toList());

			productIds = productIds.stream().distinct().collect(Collectors.toList());
			List<Product> products = productRepository.findAllById(productIds);
			Map<Long, Product> productsMap = products.stream().collect(Collectors.toMap(Product::getId, p -> p));

			List<FacilityDispatchProduct> facilityDispatchProductList = FacilityDispatchMapperUtil
					.mapDispatchDtoToFacilityDispatchProductLis(facilityDispatch, dispatchDetailedDto, productsMap);

			Set<FacilityDispatchProduct> facilityDispatchProductSet = facilityDispatchProductList.stream()
					.collect(Collectors.toSet());

			facilityDispatch.setFacilityDispatchProducts(facilityDispatchProductSet);

			FacilityDispatchReceiptRemark remark = new FacilityDispatchReceiptRemark();
			remark.setRemarks(dispatchDetailedDto.getRemark());
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

			UserMaster user = new UserMaster();
			user.setId(dispatchDetailedDto.getUserId());
			facilityDispatchStatusTracking.setUserMaster(user);

			Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackingSet = new HashSet<>();
			facilityDispatchStatusTrackingSet.add(facilityDispatchStatusTracking);
			facilityDispatch.setFacilityDispatchStatusTrackings(facilityDispatchStatusTrackingSet);

			facilityDispatch.setDispatchType(dispatchDetailedDto.getDispatchType());

			facilityDispatch = facilityDispatchRepository.save(facilityDispatch);

			String stnNumber = "STN"
					+ StringUtils.leftPad(facilityDispatch.getFacilityDispatchId().toString(), 13, "0");

			facilityDispatch.setStnNumber(stnNumber);
			facilityDispatch = facilityDispatchRepository.save(facilityDispatch);

			for (BatchDto batch : dispatchDetailedDto.getBatchDetails()) {

				FacilityStock consignorFacilityStock = facilityStockRepository
						.findByBatchNumberAndProduct_IdAndFacility_Id(batch.getBatchNumber(), batch.getProductId(),
								consignorFacility.get().getId());

				consignorFacilityStock = FacilityDispatchMapperUtil.mapToFacilityStock("dispatch",
						consignorFacilityStock, batch, consignorFacility.get().getId());
				facilityStockRepository.save(consignorFacilityStock);
				FacilityStockTracking consignorFacilityStockTracking = FacilityDispatchMapperUtil
						.mapToFacilityStockTracking(batch, consignorFacility.get().getId(), batch.getProductId(),
								"dispatch", facilityDispatch.getFacilityDispatchId());
				facilityStockTrackingRepository.save(consignorFacilityStockTracking);
			}

			dispatchDetailedDto.setDispatchId(facilityDispatch.getFacilityDispatchId());
			dispatchDetailedDto.setStnNumber(stnNumber);

			if (dispatchDetailedDto.getGoodsRequestId() != null) {
				Optional<GoodsRequest> goodRequestOpt = goodsRequestRepository
						.findById(dispatchDetailedDto.getGoodsRequestId());
				if (goodRequestOpt.isPresent()) {
					GoodsRequest goodsRequest = goodRequestOpt.get();
					goodsRequest.setIsDispatched(Boolean.TRUE);
					goodsRequestRepository.save(goodsRequest);
				}
			}

			return dispatchDetailedDto;
		} else {
			throw new ServiceException("Invalid Consignee or Consignor Id", null, HttpStatus.BAD_REQUEST);
		}
	}

	private void validateDispatch(DispatchDetailedDto dispatchDetailedDto) {

		if (!CollectionUtils.isEmpty(dispatchDetailedDto.getBatchDetails())) {
			Boolean invalid = false;
			for (BatchDto b : dispatchDetailedDto.getBatchDetails()) {
				if ((b.getDispatchQuantity() <= 0) || (b.getNumberOfBoxes() <= 0)) {
					invalid = true;
				}
			}
			if (invalid) {
				throw new ServiceException("Invalid quantity or number of boxes", null, HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ServiceException("No Products Dispatched", null, HttpStatus.BAD_REQUEST);
		}
	}

	public DispatchDetailedDto assignStock(DispatchDetailedDto dispatchDetailedDto) {

		Optional<Facility> consigneeFacility = facilityRepository
				.findById(dispatchDetailedDto.getShippedToFacilityId());

		Optional<Facility> consignorFacility = facilityRepository.findById(dispatchDetailedDto.getConsignerId());

		if (consigneeFacility.get() != null && consignorFacility.get() != null) {
			FacilityDispatch facilityDispatch = new FacilityDispatch();
			facilityDispatch.setConsignee(consigneeFacility.get());
			facilityDispatch.setConsignor(consignorFacility.get());

			List<Long> productIds = dispatchDetailedDto.getBatchDetails().stream().map(b -> b.getProductId())
					.collect(Collectors.toList());

			productIds = productIds.stream().distinct().collect(Collectors.toList());
			List<Product> products = productRepository.findAllById(productIds);
			Map<Long, Product> productsMap = products.stream().collect(Collectors.toMap(Product::getId, p -> p));

			List<FacilityDispatchProduct> facilityDispatchProductList = FacilityDispatchMapperUtil
					.mapDispatchDtoToFacilityDispatchProductLis(facilityDispatch, dispatchDetailedDto, productsMap);

			Set<FacilityDispatchProduct> facilityDispatchProductSet = facilityDispatchProductList.stream()
					.collect(Collectors.toSet());

			facilityDispatch.setFacilityDispatchProducts(facilityDispatchProductSet);
			facilityDispatch = facilityDispatchRepository.save(facilityDispatch);
			String stnNumber = "STN"
					+ StringUtils.leftPad(facilityDispatch.getFacilityDispatchId().toString(), 13, "0");

			facilityDispatch.setStnNumber(stnNumber);
			facilityDispatch = facilityDispatchRepository.save(facilityDispatch);

			for (BatchDto batch : dispatchDetailedDto.getBatchDetails()) {
				FacilityStock consigneeFacilityStock = facilityStockRepository
						.findByBatchNumberAndProduct_IdAndFacility_Id(batch.getBatchNumber(), batch.getProductId(),
								consigneeFacility.get().getId());
				consigneeFacilityStock = FacilityDispatchMapperUtil.mapToFacilityStock("consignee",
						consigneeFacilityStock, batch, consigneeFacility.get().getId());
				facilityStockRepository.save(consigneeFacilityStock);
				FacilityStockTracking consigneeFacilityStockTracking = FacilityDispatchMapperUtil
						.mapToFacilityStockTracking(batch, consigneeFacility.get().getId(), batch.getProductId(),
								"consignee", facilityDispatch.getFacilityDispatchId());
				facilityStockTrackingRepository.save(consigneeFacilityStockTracking);

				FacilityStock consignorFacilityStock = facilityStockRepository
						.findByBatchNumberAndProduct_IdAndFacility_Id(batch.getBatchNumber(), batch.getProductId(),
								consignorFacility.get().getId());

				consignorFacilityStock = FacilityDispatchMapperUtil.mapToFacilityStock("consignor",
						consignorFacilityStock, batch, consignorFacility.get().getId());
				facilityStockRepository.save(consignorFacilityStock);
				FacilityStockTracking consignorFacilityStockTracking = FacilityDispatchMapperUtil
						.mapToFacilityStockTracking(batch, consignorFacility.get().getId(), batch.getProductId(),
								"consignor", facilityDispatch.getFacilityDispatchId());
				facilityStockTrackingRepository.save(consignorFacilityStockTracking);
			}

		} else {
			throw new ServiceException("Invalid Consignee or Consignor Id", null, HttpStatus.BAD_REQUEST);
		}

		return dispatchDetailedDto;
	}

	public DispatchDetailedDto returnStockFromSubFacility(DispatchDetailedDto dispatchDetailedDto) {

		Optional<Facility> consigneeFacility = facilityRepository
				.findById(dispatchDetailedDto.getShippedToFacilityId());

		Optional<Facility> consignorFacility = facilityRepository.findById(dispatchDetailedDto.getConsignerId());

		for (BatchDto batch : dispatchDetailedDto.getBatchDetails()) {

			FacilityStock consigneeFacilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					batch.getBatchNumber(), batch.getProductId(), consigneeFacility.get().getId());
			consigneeFacilityStock = FacilityDispatchMapperUtil.mapToFacilityStock("returnconsignee",
					consigneeFacilityStock, batch, consigneeFacility.get().getId());
			facilityStockRepository.save(consigneeFacilityStock);
			FacilityStockTracking consigneeFacilityStockTracking = FacilityDispatchMapperUtil
					.mapToFacilityStockTracking(batch, consigneeFacility.get().getId(), batch.getProductId(),
							"returnconsignee", null);
			facilityStockTrackingRepository.save(consigneeFacilityStockTracking);

			FacilityStock consignorFacilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					batch.getBatchNumber(), batch.getProductId(), consignorFacility.get().getId());

			consignorFacilityStock = FacilityDispatchMapperUtil.mapToFacilityStock("returnconsignor",
					consignorFacilityStock, batch, consignorFacility.get().getId());
			facilityStockRepository.save(consignorFacilityStock);
			FacilityStockTracking consignorFacilityStockTracking = FacilityDispatchMapperUtil
					.mapToFacilityStockTracking(batch, consignorFacility.get().getId(), batch.getProductId(),
							"returnconsignor", null);
			facilityStockTrackingRepository.save(consignorFacilityStockTracking);
		}
		return dispatchDetailedDto;
	}

}
