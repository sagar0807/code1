package gov.naco.soch.inventory.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.DispatchDetailedDto;
import gov.naco.soch.dto.DispatchDto;
import gov.naco.soch.dto.DispatchProductDto;
import gov.naco.soch.dto.DispatchRemarkDto;
import gov.naco.soch.dto.ErrorDto;
import gov.naco.soch.dto.ErrorResponse;
import gov.naco.soch.dto.LotContractDto;
import gov.naco.soch.dto.NoaDto;
import gov.naco.soch.dto.ProductContractDto;
import gov.naco.soch.dto.ProductDispatchHistoryDto;
import gov.naco.soch.entity.Contract;
import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.entity.ContractProductSchedule;
import gov.naco.soch.entity.ContractProductScheduleSacsLot;
import gov.naco.soch.entity.Dispatch;
import gov.naco.soch.entity.DispatchBatch;
import gov.naco.soch.entity.DispatchReceiptRemark;
import gov.naco.soch.entity.DispatchStatusMaster;
import gov.naco.soch.entity.DispatchStatusTracking;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.Receipt;
import gov.naco.soch.entity.SupplierStock;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.DispatchStatusEnum;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.mapper.DispatchMapperUtil;
import gov.naco.soch.mapper.Constants;
import gov.naco.soch.projection.FacilityDetailedProjection;
import gov.naco.soch.repository.ContractProductDetailRepository;
import gov.naco.soch.repository.ContractProductScheduleDetailRepository;
import gov.naco.soch.repository.ContractProductScheduleSacsLotRepository;
import gov.naco.soch.repository.ContractRepository;
import gov.naco.soch.repository.DispatchReceiptRemarkRepository;
import gov.naco.soch.repository.DispatchRepository;
import gov.naco.soch.repository.DispatchStatusTrackingRepository;
import gov.naco.soch.repository.FacilityDispatchRepository;
import gov.naco.soch.repository.FacilityReceiptRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.ProductRepository;
import gov.naco.soch.repository.ReceiptRepository;
import gov.naco.soch.repository.SupplierStockRepository;

@Service
@Transactional
public class DispatchService {

	@Autowired
	private DispatchRepository dispatchRepository;

	@Autowired
	private SupplierStockRepository supplierStockRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ContractProductDetailRepository contractProductRepository;

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private ContractProductScheduleSacsLotRepository contractProductSceduleSacsLotRepository;

	@Autowired
	private DispatchReceiptRemarkRepository dispatchRemarkRepository;

	@Autowired
	private DispatchStatusTrackingRepository dispatchStatusTrackingRepository;

	@Autowired
	private ReceiptRepository receiptRepository;

	@Autowired
	private ProductRepository ProductRepository;

	@Autowired
	private FacilityDispatchRepository facilityDispatchRepository;

	@Autowired
	private FacilityReceiptRepository facilityReceiptRepository;

	@Autowired
	private ContractProductScheduleDetailRepository contractProductScheduleRepository;

	// method to get all SACS
	public List<FacilityDetailedProjection> getSacs() {
		List<FacilityDetailedProjection> sacs = facilityRepository.findAllSacs();
		return sacs;
	}

	// method to get all facilities by state id
	public List<FacilityDetailedProjection> getAllFacilitiesByState(String facilityType, Long sacsId) {
		List<Long> facilityTypeIds = new ArrayList<>();
		List<Long> excludedFacilityTypeIds = new ArrayList<>();
		switch (facilityType) {
		case "rwh":
			facilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
			break;
		case "lab":
			List<Long> labFacilityTypeIds = new ArrayList<Long>(Arrays.asList(20L, 25L, 26L));
			facilityTypeIds.addAll(labFacilityTypeIds);
			break;
		case "facility":
			excludedFacilityTypeIds.add(FacilityTypeEnum.SACS.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
			excludedFacilityTypeIds.add(FacilityTypeEnum.SUPPLIER.getFacilityType());
			List<Long> newFacilityTypeIds = new ArrayList<Long>(
					Arrays.asList(20L, 21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 4L, 1L));
			excludedFacilityTypeIds.addAll(newFacilityTypeIds);
			break;
		default:
			break;

		}
		List<FacilityDetailedProjection> facilities = new ArrayList<>();
		if (!facilityType.equals("facility")) {
			facilities = facilityRepository.findFacilitiesBySacsIdAndFacilityType_IdIn(sacsId, facilityTypeIds);

		} else {
			facilities = facilityRepository.findFacilitiesBySacsIdAndFacilityType_IdNotIn(sacsId,
					excludedFacilityTypeIds);

		}
		return facilities;
	}

	public List<FacilityDetailedProjection> getAllLabs() {
		List<Long> facilityTypeIds = new ArrayList<Long>(Arrays.asList(20L, 21L, 22L, 23L, 24L, 25L, 26L, 27L));

		List<FacilityDetailedProjection> facilities = facilityRepository.findAllLabs(facilityTypeIds);
		return facilities;
	}

	// method to get product details by sacsId
	public List<ProductContractDto> getProductDetailsBySacsId(Long sacsId, Long facilityId) {

		List<Long> products = contractProductRepository.findBySacs(sacsId,facilityId);
		List<ProductContractDto> productContractDtoList = new ArrayList<>();
		products.forEach(product -> {
			Optional<Product> product1 = ProductRepository.findById(product);
			ProductContractDto productContractDto = DispatchMapperUtil
					.mapContractProductToProductContractDtoProduct(product1);
			productContractDtoList.add(productContractDto);

		});
		if (!productContractDtoList.isEmpty()) {
			productContractDtoList.forEach(product -> {
				List<Contract> contracts = contractRepository
						.findAllByContractProducts_Product_IdAndFacility_IdAndIsDeleteAndContractStatusMaster_Id(
								product.getProductId(), facilityId, false, 3);
				List<NoaDto> noas = new ArrayList<>();
				if (contracts != null) {
					contracts.forEach(contract -> {
						NoaDto noa = new NoaDto();
						Optional<ContractProduct> contractProductOptional = contractProductRepository
								.findByContract_ContractIdAndProduct_Id(contract.getContractId(),
										product.getProductId());
						if (contractProductOptional.isPresent()) {
							ContractProduct contractProduct = contractProductOptional.get();
							noa.setContractProductId(contractProduct.getId());
						}
						noa.setNoaNumber(contract.getNoaNumber());
						noa.setContractId(contract.getContractId());
						noas.add(noa);
					});
				}
				product.setNoa(noas);
				noas.forEach(noa -> {

					Set<ContractProductScheduleSacsLot> lots = contractProductSceduleSacsLotRepository
							.findAllByContractProductScheduleSac_ContractProductSchedule_ContractProduct_Contract_ContractIdAndContractProductScheduleSac_ContractProductSchedule_ContractProduct_Product_IdAndContractProductScheduleSac_Facility_IdOrderByStartDateAsc(
									noa.getContractId(), product.getProductId(), sacsId);
					List<LotContractDto> lotDtos = DispatchMapperUtil
							.mapContractProductSceduleSacsLotsToLotContractDto(lots);
					noa.setLots(lotDtos);
					Long dispatchedQuantity = 0L;
					ContractProductSchedule contractProductSchedule = contractProductScheduleRepository
							.findScheduleQuantity(product.getProductId(), noa.getContractId(), sacsId);
					if (contractProductSchedule != null) {
						product.setContractQuantity(contractProductSchedule.getQuantity());
						List<Dispatch> disapatches = dispatchRepository
								.findAllByContract_ContractIdAndContractProduct_Product_IdAndContractProductSchedule_Id(
										noa.getContractId(), product.getProductId(), contractProductSchedule.getId());
						if (disapatches != null) {
							for (Dispatch dispatch : disapatches) {
								for (DispatchBatch batch : dispatch.getDispatchBatches()) {
									dispatchedQuantity = dispatchedQuantity + batch.getQuantityNumber();
								}
							}
							product.setDispatchedQuantity(dispatchedQuantity);
						}
					}

				});

			});
		}

		/*
		 * Iterator<ProductContractDto> itr = productContractDtoList.iterator(); while
		 * (itr.hasNext()) { ProductContractDto product = (ProductContractDto)
		 * itr.next(); if (product.getContractQuantity() != null &&
		 * product.getDispatchedQuantity() != null) { if (product.getContractQuantity()
		 * - product.getDispatchedQuantity() < 0 || product.getContractQuantity() -
		 * product.getDispatchedQuantity() == 0) itr.remove(); } }
		 */

		return productContractDtoList;
	}

	// method to save dispatch details
	public DispatchDetailedDto saveDispatchDetails(DispatchDetailedDto dispatchDetailedDto) {
		Long count = dispatchRepository.existsByInvoiceNumber(dispatchDetailedDto.getInvoiceNumber());
		if (count>=1) {
			throwBatchError("Invoice Number");
		}
		if (dispatchDetailedDto.getDispatchId() == null) {
			Dispatch dispatch = DispatchMapperUtil.mapDispatchDtoToDispatch(dispatchDetailedDto);
			dispatchRepository.save(dispatch);
		}
		return dispatchDetailedDto;
	}

	// method to get all dispatch details
	public List<DispatchDto> getAllDispatchDetails(Long consignorId) {

		List<Dispatch> dispatchList = dispatchRepository.findAllByConsignor_IdOrderByDispatchIdDesc(consignorId);
		List<DispatchDto> dispatchDtoList = DispatchMapperUtil.mapDispatchDtoListToDispatch(dispatchList);
		dispatchDtoList.forEach(dispatchDto -> {

			Receipt receipt = receiptRepository.findByLatestByDispatchId(dispatchDto.getDispatchId());
			if (receipt != null) {
				if (receipt.getReceiptStatusMaster() != null) {
					dispatchDto.setReceiptStatus(receipt.getReceiptStatusMaster().getStatus());
				}
			} else {
				dispatchDto.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
			}

		});
		return dispatchDtoList;
	}

	// method to get dispatch details by id
	public DispatchDetailedDto getDispatchDetailsById(Long dispatchId) {

		Dispatch dispatch = dispatchRepository.findByDispatchId(dispatchId);
		Receipt receipt = receiptRepository.findByLatestByDispatchId(dispatchId);

		DispatchDetailedDto dispatchDetailedDto = DispatchMapperUtil.mapDispatchToDispatchDetailedDto(dispatch,
				receipt);

		if (receipt != null) {
			if (receipt.getReceiptStatusMaster() != null) {
				dispatchDetailedDto.setReceiptStatus(receipt.getReceiptStatusMaster().getStatus());
			}
		} else {
			dispatchDetailedDto.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
		}

		return dispatchDetailedDto;
	}

	// method to get batch details by product id
	public List<BatchDto> getBatchDetails(Long productId) {
		List<SupplierStock> supplierStocks = supplierStockRepository
				.findAllByProduct_IdOrderBySupplierStockIdDesc(productId);
		List<BatchDto> batches = DispatchMapperUtil.mapToBatchDto(supplierStocks);
		return batches;
	}

	// method to save batch details
	public void saveBtach(BatchDto batchDto) {

		long difference = ChronoUnit.DAYS.between(LocalDate.now(), batchDto.getExpiryDate());
		long diff = ChronoUnit.DAYS.between(batchDto.getManufactureDate(), batchDto.getExpiryDate());
		Double e = ((double) difference / diff) * 100;
		DecimalFormat df = new DecimalFormat("####.#");
		df.setRoundingMode(RoundingMode.CEILING);

		if (e < 1 || e.isNaN()) {
			throwError("batch");
		} else {
			Boolean isExist = supplierStockRepository.existsByBatchNumberAndProduct_Id(batchDto.getBatchNumber(),
					batchDto.getProductId());
			if (isExist) {
				throwBatchError("Batch number");
			} else {
				SupplierStock supplierStock = new SupplierStock();
				supplierStock.setBatchNumber(batchDto.getBatchNumber());
				supplierStock.setManufactureDate(batchDto.getManufactureDate());
				supplierStock.setExpiryDate(batchDto.getExpiryDate());
				if (batchDto.getSupplierId() != null) {
					Facility facility = new Facility();
					facility.setId(batchDto.getSupplierId());
					supplierStock.setFacility(facility);
				}
				Product product = new Product();
				product.setId(batchDto.getProductId());
				supplierStock.setProduct(product);
				supplierStock.setRemainingSelfLife(df.format(e) + "%");
				supplierStockRepository.save(supplierStock);
			}

		}

	}

	public List<DispatchProductDto> getDispatchedProducts(Long supplierId) {
		List<SupplierStock> stocks = supplierStockRepository.getStockBySupplierId(supplierId);
		List<DispatchProductDto> dispatchProducts = new ArrayList<DispatchProductDto>();
		dispatchProducts = DispatchMapperUtil.mapSupplierStockListToDispatchProductDtoList(stocks);
		return dispatchProducts;
	}

	// method to cancel a consignment
	public Boolean cancelConsignment(DispatchRemarkDto dispatchRemarkDto) {
		Dispatch dispatch = dispatchRepository.findByDispatchId(dispatchRemarkDto.getDispatchId());
		DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
		dispatchStatusMaster.setId(3);
		dispatch.setDispatchStatusMaster(dispatchStatusMaster);
		dispatchRepository.save(dispatch);

		DispatchStatusTracking dispatchStatusTracking = new DispatchStatusTracking();
		dispatchStatusTracking.setDispatch(dispatch);
		dispatchStatusMaster.setId(3);
		dispatchStatusTracking.setDispatchStatusMaster(dispatchStatusMaster);
		UserMaster user = new UserMaster();
		user.setId(dispatchRemarkDto.getUserId());
		dispatchStatusTracking.setUserMaster(user);
		dispatchStatusTrackingRepository.save(dispatchStatusTracking);

		DispatchReceiptRemark remark = new DispatchReceiptRemark();
		remark.setRemarks(dispatchRemarkDto.getRemarks());
		dispatchStatusMaster.setId(3);
		remark.setDispatch(dispatch);
		remark.setDispatchStatusMaster(dispatchStatusMaster);
		dispatchRemarkRepository.save(remark);
		return true;
	}

	public DispatchDetailedDto updateConsignment(@Valid DispatchDetailedDto dispatchDetailedDto) {

		if (dispatchDetailedDto.getDispatchId() != null) {
			Dispatch dispatch = dispatchRepository.findByDispatchId(dispatchDetailedDto.getDispatchId());

			Set<DispatchBatch> dispatchBatches = DispatchMapperUtil
					.maptoDispatchBatchDtoToDispatchBaches(dispatchDetailedDto.getBatchDetails(), dispatch);
			Set<DispatchBatch> alreadyExistingBatches = dispatch.getDispatchBatches();
			alreadyExistingBatches.forEach(batch -> {
				batch.setIsActive(false);
			});

			dispatchBatches = Sets.newHashSet(Iterables.concat(dispatchBatches, alreadyExistingBatches));

			dispatch.setDispatchBatches(dispatchBatches);
			Set<DispatchReceiptRemark> remarks = DispatchMapperUtil
					.mapDispatchRemarkDtoToDispatchRemark(dispatchDetailedDto, dispatch);
			dispatch.setDispatchReceiptRemarks(remarks);
			DispatchStatusMaster dispatchStatusMaster = new DispatchStatusMaster();
			dispatchStatusMaster.setId(1);
			Set<DispatchStatusTracking> dispatchStatusTrackings = DispatchMapperUtil
					.mapDispatchBatchDtoToDispatchStatusTracking(dispatchDetailedDto, dispatch);
			dispatch.setDispatchStatusTrackings(dispatchStatusTrackings);
			dispatch.setDispatchStatusMaster(dispatchStatusMaster);

			dispatchRepository.save(dispatch);
		}
		return dispatchDetailedDto;
	}

	public List<ProductDispatchHistoryDto> getProductDispatchHistoryList(Long consignorId) {

		List<FacilityDispatch> facilityDispatchList = facilityDispatchRepository.findAllByConsignorId(consignorId);
		// List<FacilityDispatch> facilityDispatchList = new ArrayList<>() ;
		List<ProductDispatchHistoryDto> productDispatchHistoryDtoList = DispatchMapperUtil
				.mapFacilityDispatchListToProductDispatchHistoryDtoList(facilityDispatchList);

		List<Long> facilityDispatchIds = facilityDispatchList.stream().map(FacilityDispatch::getFacilityDispatchId)
				.collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(facilityDispatchIds)) {

			List<FacilityReceipt> receiptList = facilityReceiptRepository
					.findByFacilityDispatchIds(facilityDispatchIds);

			productDispatchHistoryDtoList.stream().forEach(p -> {

				Optional<FacilityReceipt> receiptOpt = receiptList.stream()
						.filter(r -> r.getFacilityDispatch() != null
								&& r.getFacilityDispatch().getFacilityDispatchId() == p.getFacilityDispatchId())
						.findFirst();

				if (receiptOpt.isPresent()) {
					FacilityReceipt receipt = receiptOpt.get();
					if (receipt != null) {
						if (receipt.getFacilityReceiptStatusMaster() != null) {
							p.setReceiptStatus(receipt.getFacilityReceiptStatusMaster().getStatus());
						} else {
							p.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
						}
					}
				} else {
					p.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
				}
			});
		}

		return productDispatchHistoryDtoList;

	}

	private void throwError(String errorfield) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(Constants.INVALID_BATCH);
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(Constants.INVALID_BATCH, errorResponse, HttpStatus.BAD_REQUEST);
	}

	private void throwBatchError(String errorfield) {
		List<ErrorDto> errorDtoList = new ArrayList<>();
		List<String> detailsSimplified = new ArrayList<String>();
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(errorfield);
		errorDto.setDescription(errorfield + Constants.DUPLICATE);
		errorDtoList.add(errorDto);
		detailsSimplified.add(errorDto.getDescription());
		ErrorResponse errorResponse = new ErrorResponse(errorDtoList.toString(), errorDtoList, detailsSimplified);
		throw new ServiceException(errorfield + Constants.DUPLICATE, errorResponse, HttpStatus.BAD_REQUEST);
	}

}
