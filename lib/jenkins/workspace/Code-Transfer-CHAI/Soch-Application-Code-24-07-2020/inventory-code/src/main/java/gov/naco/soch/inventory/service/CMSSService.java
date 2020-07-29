package gov.naco.soch.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.CMSSProductMapping;
import gov.naco.soch.entity.CmssIndent;
import gov.naco.soch.entity.CmssIndentDispatch;
import gov.naco.soch.entity.CmssStoreSacsMapping;
import gov.naco.soch.entity.CmssWarehouse;
import gov.naco.soch.entity.CmssWarehouseStock;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ReceiptStatusMaster;
import gov.naco.soch.entity.SacsCmssWarehouseMapping;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.dto.CMSSExternalIndentIssuesDto;
import gov.naco.soch.inventory.dto.CMSSIndentDto;
import gov.naco.soch.inventory.dto.CMSSIssueDto;
import gov.naco.soch.inventory.dto.CMSSPOWiseStockDto;
import gov.naco.soch.inventory.dto.CMSSSacsWarehouseMappingDto;
import gov.naco.soch.inventory.dto.CMSSStockDto;
import gov.naco.soch.inventory.dto.CMSSStockExternalResponseDto;
import gov.naco.soch.inventory.dto.CMSSStoreWiseStockDto;
import gov.naco.soch.inventory.dto.CMSSWarehouseDto;
import gov.naco.soch.inventory.mapper.CMSSMapperUtil;
import gov.naco.soch.inventory.util.CMSSUtils;
import gov.naco.soch.projection.FacilityDetailedProjection;
import gov.naco.soch.repository.CMSSProductMappingRepository;
import gov.naco.soch.repository.CmssIndentDispatchRepository;
import gov.naco.soch.repository.CmssIndentRepository;
import gov.naco.soch.repository.CmssStoreSacsMappingRepository;
import gov.naco.soch.repository.CmssWarehouseRepository;
import gov.naco.soch.repository.CmssWarehouseStockRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;
import gov.naco.soch.repository.ProductRepository;
import gov.naco.soch.repository.SacsCmssWarehouseMappingRepository;
import gov.naco.soch.util.UserUtils;

@Service
public class CMSSService {

	private static final Logger logger = LoggerFactory.getLogger(CMSSService.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private CmssWarehouseRepository cmssWarehouseRepository;

	@Autowired
	private CmssWarehouseStockRepository cmssWarehouseStockRepository;

	@Autowired
	private CMSSProductMappingRepository cmssProductMappingRepository;

	@Autowired
	private CmssStoreSacsMappingRepository cmssStoreSacsMappingRepository;

	@Autowired
	private CmssIndentRepository cmssIndentRepository;

	@Autowired
	private CmssIndentDispatchRepository cmssIndentDispatchRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SacsCmssWarehouseMappingRepository sacsCmssWarehouseMappingRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Value("${cmss.external.stock.url}")
	private String cmssExternalStockUrl;

	@Value("${cmss.external.stock.username}")
	private String cmssExternalStockUsername;

	@Value("${cmss.external.stock.password}")
	private String cmssExternalStockPassword;

	@Value("${cmss.external.indent.url}")
	private String cmssExternalIndentUrl;

	@Value("${cmss.external.indent.username}")
	private String cmssExternalIndentUsername;

	@Value("${cmss.external.indent.password}")
	private String cmssExternalIndentPassword;

	@Value("${cmss.external.issues.url}")
	private String cmssExternalIssuestUrl;

	@Value("${cmss.external.issues.username}")
	private String cmssExternalIssuesUsername;

	@Value("${cmss.external.issues.password}")
	private String cmssExternalIssuesPassword;

	public Boolean fetchAndUpdateStockFromExternalService() {
		logger.debug("fetchStockFromExternal() of CMSSService");
		List<CMSSStockExternalResponseDto> externalStockData = fetchStockFromExternalService();

		List<CMSSProductMapping> cmssProducts = cmssProductMappingRepository.findByIsDelete(Boolean.FALSE);
		List<Product> sochProduct = productRepository.findAllByIsDelete(Boolean.FALSE);

		Map<String, String> cmssProductsmap = new HashMap<String, String>();
		for (CMSSProductMapping cp : cmssProducts) {
			cmssProductsmap.put(cp.getCmssProductName(), cp.getProductCode());
		}

		Map<String, String> sochProductsmap = new HashMap<String, String>();
		for (Product p : sochProduct) {
			sochProductsmap.put(p.getProductShortCode(), p.getProductName());
		}

		List<CmssWarehouseStock> stockList = new ArrayList<CmssWarehouseStock>();

		List<String> cmssProductNotFoundList = new ArrayList<String>();
		List<String> sochProductNotFoundList = new ArrayList<String>();

		for (CMSSStockExternalResponseDto extenalStock : externalStockData) {

			String cmssProductName = CMSSUtils.getCMSSProductName(extenalStock.getDrug_NAME());

			String cmssProductCode = cmssProductsmap.get(cmssProductName);

			if (cmssProductCode == null) {
				cmssProductNotFoundList.add(cmssProductName);
			} else {
				String sochProductName = sochProductsmap.get(cmssProductCode);
				if (sochProductName == null) {
					sochProductNotFoundList.add(cmssProductName);
				} else {
					CmssWarehouseStock stockItem = new CmssWarehouseStock();
					stockItem.setStoreId(extenalStock.getStore_ID());
					stockItem.setStoreName(CMSSUtils.getStoreName(extenalStock.getStore_NAME()));
					stockItem.setCmssProductName(cmssProductName);
					stockItem.setProductCode(cmssProductCode);
					stockItem.setProductName(sochProductName);
					stockItem.setBrandId(extenalStock.getBrand_ID());
					stockItem.setBatchNo(extenalStock.getBatch_NO());
					stockItem.setPoNo(extenalStock.getPo_NO());
					stockItem.setQtyActive(Long.parseLong(extenalStock.getQty_ACTIVE()));
					stockItem.setQtyQuarantine(Long.parseLong(extenalStock.getQty_QUAR()));
					stockItem.setQtyRejected(Long.parseLong(extenalStock.getQty_REJ()));
					stockItem.setManufactureDate(CMSSUtils.getDate(extenalStock.getManuf_DATE()));
					stockItem.setExpiryDate(CMSSUtils.getDate(extenalStock.getExpiry_DATE()));
					stockItem.setIsActive(Boolean.TRUE);
					stockItem.setIsDelete(Boolean.FALSE);
					stockList.add(stockItem);
				}
			}

		}

		if (!CollectionUtils.isEmpty(stockList)) {
			cmssWarehouseStockRepository.deleteAll();
			cmssWarehouseStockRepository.saveAll(stockList);
		}

		cmssProductNotFoundList = cmssProductNotFoundList.stream().distinct().collect(Collectors.toList());

		sochProductNotFoundList = sochProductNotFoundList.stream().distinct().collect(Collectors.toList());

		logger.info("CMSS Product mapping not found for following products >>>> " + cmssProductNotFoundList);

		logger.info("Product not found in SOCH for following CMSS products >>>> " + sochProductNotFoundList);

		return Boolean.TRUE;
	}

	public List<CMSSStockDto> fetchStockList() {
		logger.debug("fetchStockList() of CMSSService");
		List<CmssWarehouseStock> cmssWarehouseStockList = cmssWarehouseStockRepository.findAll();

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {

			List<SacsCmssWarehouseMapping> warehouses = sacsCmssWarehouseMappingRepository
					.findAllByFacility_Id(user.getFacilityId());

			List<String> stores = warehouses.stream().map(w -> w.getCmssWarehouse().getStoreName()).distinct()
					.collect(Collectors.toList());

			cmssWarehouseStockList = cmssWarehouseStockList.stream().filter(s -> stores.contains(s.getStoreName()))
					.collect(Collectors.toList());
		}

		List<CMSSStockDto> cmssWarehouseStockDtoList = CMSSMapperUtil
				.mapCmssWarehouseStockToCMSSStockDto(cmssWarehouseStockList);
		return cmssWarehouseStockDtoList;
	}

	public List<CMSSStoreWiseStockDto> fetchStockStorewiseList() {
		logger.debug("fetchStockStorewiseList() of CMSSService");

		List<CMSSStoreWiseStockDto> cmssStoreWiseStockDtoList = new ArrayList<>();
		List<CmssWarehouseStock> cmssWarehouseStockList = cmssWarehouseStockRepository.findAll();

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {

			List<SacsCmssWarehouseMapping> warehouses = sacsCmssWarehouseMappingRepository
					.findAllByFacility_Id(user.getFacilityId());

			List<String> stores = warehouses.stream().map(w -> w.getCmssWarehouse().getStoreName()).distinct()
					.collect(Collectors.toList());

			cmssWarehouseStockList = cmssWarehouseStockList.stream().filter(s -> stores.contains(s.getStoreName()))
					.collect(Collectors.toList());
		}

		List<CMSSStockDto> cmssWarehouseStockDtoList = CMSSMapperUtil
				.mapCmssWarehouseStockToCMSSStockDto(cmssWarehouseStockList);

		cmssStoreWiseStockDtoList = CMSSMapperUtil
				.mapCMSSWarehouseStockDtoListToCMSSStoreWiseStockDtoList(cmssWarehouseStockDtoList);

		return cmssStoreWiseStockDtoList;
	}

	public List<CMSSPOWiseStockDto> fetchStockPOwiseList() {
		logger.debug("fetchStockPOwiseList() of CMSSService");
		List<CMSSPOWiseStockDto> cmsspoWiseStockDtos = new ArrayList<>();
		List<CmssWarehouseStock> cmssWarehouseStockList = cmssWarehouseStockRepository.findAll();

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {

			List<SacsCmssWarehouseMapping> warehouses = sacsCmssWarehouseMappingRepository
					.findAllByFacility_Id(user.getFacilityId());

			List<String> stores = warehouses.stream().map(w -> w.getCmssWarehouse().getStoreName()).distinct()
					.collect(Collectors.toList());

			cmssWarehouseStockList = cmssWarehouseStockList.stream().filter(s -> stores.contains(s.getStoreName()))
					.collect(Collectors.toList());
		}

		List<CMSSStockDto> cmssWarehouseStockDtoList = CMSSMapperUtil
				.mapCmssWarehouseStockToCMSSStockDto(cmssWarehouseStockList);
		Map<String, List<CMSSStockDto>> mapByPoNo = cmssWarehouseStockDtoList.stream()
				.collect(Collectors.groupingBy(CMSSStockDto::getPoNo));
		mapByPoNo.forEach((k, v) -> {
			Long activeQty = 0L;
			Long quarQty = 0L;
			Long rejQty = 0L;
			CMSSPOWiseStockDto cmsspoWiseStockDto = new CMSSPOWiseStockDto();
			cmsspoWiseStockDto.setPoNo(k);
			cmsspoWiseStockDto.setPoList(v);

			for (CMSSStockDto s : v) {
				activeQty = activeQty + s.getQtyActive();
				quarQty = quarQty + s.getQtyQuar();
				rejQty = rejQty + s.getQtyRej();
			}

			cmsspoWiseStockDto.setQtyActive(activeQty);
			cmsspoWiseStockDto.setQtyQuar(quarQty);
			cmsspoWiseStockDto.setQtyRej(rejQty);
			cmsspoWiseStockDtos.add(cmsspoWiseStockDto);

		});

		return cmsspoWiseStockDtos;
	}

	public List<String> fetchProductsList() {
		List<String> products = new ArrayList<>();
		List<CmssWarehouseStock> cmssWarehouseStockList = cmssWarehouseStockRepository.findAll();
		Map<String, List<CmssWarehouseStock>> mapByProductName = cmssWarehouseStockList.stream()
				.collect(Collectors.groupingBy(CmssWarehouseStock::getCmssProductName));
		mapByProductName.forEach((k, v) -> {
			products.add(k);
		});
		return products;
	}

	public List<CMSSWarehouseDto> fetchWarehousesList() {
		logger.debug("fetchWarehousesList() of CMSSService");
		List<CmssWarehouse> cmssWareHouseList = cmssWarehouseRepository.findAllByOrderByIdAsc();
		List<CMSSWarehouseDto> cmssWareHouseDtoList = CMSSMapperUtil
				.mapCMSSWarehouseDtoToCMSSWarehouse(cmssWareHouseList);
		return cmssWareHouseDtoList;
	}

	public Boolean saveWarehouses(List<CMSSWarehouseDto> warehouseList) {
		logger.debug("saveWarehouses() of CMSSService");
		List<CmssWarehouse> cmssWarehouseList = new ArrayList<>();
		warehouseList.forEach(warehouse -> {
			CmssWarehouse cmssWarehouse = new CmssWarehouse();
			if (warehouse.getId() != null) {
				Optional<CmssWarehouse> cmsswarehouseOptional = cmssWarehouseRepository.findById(warehouse.getId());
				if (cmsswarehouseOptional.isPresent()) {
					int count = cmssWarehouseRepository.existsByIdAndStoreId(warehouse.getId(), warehouse.getStoreId());
					if (count > 0) {
						throw new ServiceException("store ID already exists", null, HttpStatus.BAD_REQUEST);
					} else {
						cmssWarehouse = cmsswarehouseOptional.get();
						cmssWarehouse.setStoreId(warehouse.getStoreId());
						cmssWarehouse.setStoreName(warehouse.getStoreName());
					}
				}
			} else {
				Boolean isExistByStoreId = cmssWarehouseRepository.existsByStoreId(warehouse.getStoreId());
				if (isExistByStoreId) {
					throw new ServiceException("store ID already exists", null, HttpStatus.BAD_REQUEST);
				} else {
					cmssWarehouse.setStoreId(warehouse.getStoreId());
					cmssWarehouse.setStoreName(warehouse.getStoreName());
					cmssWarehouse.setIsActive(true);
					cmssWarehouse.setIsDelete(false);
				}
			}
			cmssWarehouseList.add(cmssWarehouse);
		});
		cmssWarehouseRepository.saveAll(cmssWarehouseList);
		return true;
	}

	public Boolean deleteWarehouse(@Valid Long warehouseId) {
		CmssWarehouse cmssWarehouse = new CmssWarehouse();
		Optional<CmssWarehouse> cmsswarehouseOptional = cmssWarehouseRepository.findById(warehouseId);
		if (cmsswarehouseOptional.isPresent()) {
			cmssWarehouse = cmsswarehouseOptional.get();
			cmssWarehouseRepository.delete(cmssWarehouse);
			return true;
		} else {
			throw new ServiceException("Invalid warehouseId", null, HttpStatus.BAD_REQUEST);
		}
	}

	public List<CMSSSacsWarehouseMappingDto> fetchWarehousesSacsMappingList() {
		logger.debug("fetchWarehousesSacsMappingList() of CMSSService");
		List<CMSSSacsWarehouseMappingDto> sacsAndMappedWarehouses = new ArrayList<>();
		List<FacilityDetailedProjection> sacsList = facilityRepository.findAllSacs();
		for (FacilityDetailedProjection sacs : sacsList) {
			CMSSSacsWarehouseMappingDto cmssSacsWarehouseMappingDto = new CMSSSacsWarehouseMappingDto();
			cmssSacsWarehouseMappingDto.setSacsId(sacs.getId());
			cmssSacsWarehouseMappingDto.setSacsCode(sacs.getCode());
			cmssSacsWarehouseMappingDto.setSacsName(sacs.getName());
			List<SacsCmssWarehouseMapping> warehouses = sacsCmssWarehouseMappingRepository
					.findAllByFacility_Id(sacs.getId());
			List<CMSSWarehouseDto> mappedWarehouses = CMSSMapperUtil
					.mapSacsCmssWarehouseMappingToCMSSWarehouseDto(warehouses);
			cmssSacsWarehouseMappingDto.setMappedWarehouses(mappedWarehouses);
			cmssSacsWarehouseMappingDto.setNumberOfWarehouses(mappedWarehouses.size());
			sacsAndMappedWarehouses.add(cmssSacsWarehouseMappingDto);
		}
		return sacsAndMappedWarehouses;
	}

	public CMSSSacsWarehouseMappingDto saveWarehousesSacsMapping(@Valid CMSSSacsWarehouseMappingDto warehouse) {
		logger.debug("saveWarehousesSacsMapping() of CMSSService");
		List<SacsCmssWarehouseMapping> warehouses = sacsCmssWarehouseMappingRepository
				.findAllByFacility_Id(warehouse.getSacsId());
		sacsCmssWarehouseMappingRepository.deleteInBatch(warehouses);
		warehouses = CMSSMapperUtil.mapCMSSSacsWarehouseMappingDto(warehouse);
		try {
			warehouses = sacsCmssWarehouseMappingRepository.saveAll(warehouses);

		} catch (Exception e) {
			throw new ServiceException("Invalid warehouse id", null, HttpStatus.BAD_REQUEST);
		}
		warehouse.setNumberOfWarehouses(warehouse.getMappedWarehouses().size());
		return warehouse;
	}

	public List<CMSSWarehouseDto> fetchStoreList() {

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {
			Long sacsId = user.getFacilityId();
			List<SacsCmssWarehouseMapping> warehouses = sacsCmssWarehouseMappingRepository.findAllByFacility_Id(sacsId);
			return warehouses.stream().map(w -> w.getCmssWarehouse().getStoreName()).distinct().map(i -> {
				CMSSWarehouseDto dto = new CMSSWarehouseDto();
				dto.setStoreName(i);
				return dto;
			}).collect(Collectors.toList());
		} else {
			List<CmssWarehouseStock> cmssWarehouseStockList = cmssWarehouseStockRepository.findAll();
			return cmssWarehouseStockList.stream().map(CmssWarehouseStock::getStoreName).distinct().map(i -> {
				CMSSWarehouseDto dto = new CMSSWarehouseDto();
				dto.setStoreName(i);
				return dto;
			}).collect(Collectors.toList());
		}
	}

	public List<CMSSIndentDto> fetchIndentList() {

		List<CmssIndent> indentList = cmssIndentRepository.findAll();
		List<CMSSIndentDto> indentDtoList = new ArrayList<>();

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {

			indentList = indentList.stream()
					.filter(s -> s.getFacility() != null && s.getFacility().getId() == user.getFacilityId())
					.collect(Collectors.toList());
		}

		indentDtoList = indentList.stream().map(i -> {
			CMSSIndentDto dto = new CMSSIndentDto();
			dto.setIndentNbr(i.getIndentNo());
			if (i.getFacility() != null) {
				dto.setIndentStoreId(i.getFacility().getId());
				dto.setIndentStore(i.getFacility().getName());
			}
			dto.setIndentDate(i.getIndentDate());
			dto.setIssuingStore(i.getIssuingStore());
			dto.setProductName(i.getProductName());
			dto.setIndentQty(i.getIndentQty());
			return dto;
		}).collect(Collectors.toList());

		return indentDtoList;
	}

	public List<CMSSIssueDto> fetchIssueList() {

		List<CmssIndentDispatch> indentDipatchList = cmssIndentDispatchRepository.findAll();

		indentDipatchList = indentDipatchList.stream().filter(i -> i.getReceiptStatusMaster().getId() == 1L)
				.collect(Collectors.toList());

		List<CMSSIssueDto> issueDtoList = new ArrayList<>();

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {

			indentDipatchList = indentDipatchList.stream()
					.filter(s -> s.getFacility() != null && s.getFacility().getId() == user.getFacilityId())
					.collect(Collectors.toList());
		}

		issueDtoList = indentDipatchList.stream().map(i -> {
			CMSSIssueDto dto = new CMSSIssueDto();

			dto.setRoId(i.getId());
			dto.setIssuingStore(i.getIssuingStore());
			if (i.getFacility() != null) {
				dto.setIndentStoreId(i.getFacility().getId());
				dto.setIndentStore(i.getFacility().getName());
			}
			dto.setIndentNbr(i.getIndentNo());
			dto.setIssueNbr(i.getIssueNo());
			dto.setProductName(i.getProductName());
			dto.setBatchNo(i.getBatchNo());
			dto.setIssueDate(i.getIssueDate());
			dto.setIssueQty(i.getIssueQty());
			dto.setManufDate(i.getManufactureDate());
			dto.setExpiryDate(i.getExpiryDate());
			dto.setReceivedQty(i.getReceivedQty());
			dto.setDamagedQty(i.getDamagedQty());
			dto.setReceiptStatusId(i.getReceiptStatusMaster().getId().longValue());
			dto.setReceiptStatus(i.getReceiptStatusMaster().getStatus());
			dto.setRemarks(i.getReceiptRemarks());
			return dto;
		}).collect(Collectors.toList());

		return issueDtoList;
	}

	public List<CMSSIssueDto> fetchIssuesHistoryList() {
		List<CmssIndentDispatch> indentDipatchList = cmssIndentDispatchRepository.findAll();

		indentDipatchList = indentDipatchList.stream().filter(i -> i.getReceiptStatusMaster().getId() != 1L)
				.collect(Collectors.toList());

		List<CMSSIssueDto> issueDtoList = new ArrayList<>();

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		if (user.getFacilityTypeId() != FacilityTypeEnum.NACO.getFacilityType()) {

			indentDipatchList = indentDipatchList.stream()
					.filter(s -> s.getFacility() != null && s.getFacility().getId() == user.getFacilityId())
					.collect(Collectors.toList());
		}

		issueDtoList = indentDipatchList.stream().map(i -> {
			CMSSIssueDto dto = new CMSSIssueDto();
			dto.setRoId(i.getId());
			dto.setIssuingStore(i.getIssuingStore());
			if (i.getFacility() != null) {
				dto.setIndentStoreId(i.getFacility().getId());
				dto.setIndentStore(i.getFacility().getName());
			}
			dto.setIndentNbr(i.getIndentNo());
			dto.setIssueNbr(i.getIssueNo());
			dto.setProductName(i.getProductName());
			dto.setBatchNo(i.getBatchNo());
			dto.setIssueDate(i.getIssueDate());
			dto.setIssueQty(i.getIssueQty());
			dto.setManufDate(i.getManufactureDate());
			dto.setExpiryDate(i.getExpiryDate());
			dto.setReceivedQty(i.getReceivedQty());
			dto.setDamagedQty(i.getDamagedQty());
			dto.setReceiptStatusId(i.getReceiptStatusMaster().getId().longValue());
			dto.setReceiptStatus(i.getReceiptStatusMaster().getStatus());
			dto.setRemarks(i.getReceiptRemarks());
			return dto;
		}).collect(Collectors.toList());

		return issueDtoList;
	}

	public CMSSIssueDto receiveIssuedIndents(Long roId, CMSSIssueDto dto) {
		// TODO Auto-generated method stub

		ReceiptStatusMaster receiptStatusMaster = new ReceiptStatusMaster();
		boolean quantityMismatch = false;
		boolean damagedQuantity = false;
		boolean quantityMismatchAndDamaged = false;
		Long totalQunatity = 0L;
		Integer receiptStatusId = 0;
		Long productId = 0L;

		Optional<CmssIndentDispatch> issueOpt = cmssIndentDispatchRepository.findById(roId);
		if (issueOpt.isPresent()) {

			CmssIndentDispatch issue = issueOpt.get();
			productId = productRepository.findProductIdByProductName(issue.getProductName());

			issue.setReceivedQty(dto.getReceivedQty());
			issue.setDamagedQty(dto.getDamagedQty());
			issue.setReceiptRemarks(dto.getRemarks());

			if (issue.getManufactureDate() == null) {
				issue.setManufactureDate(dto.getManufDate());
			}

			if (issue.getExpiryDate() == null) {
				issue.setExpiryDate(dto.getExpiryDate());
			}

			// handle receipt status
			if (issue.getDamagedQty() != null) {
				totalQunatity = issue.getReceivedQty() + issue.getDamagedQty();
			} else {
				if (issue.getReceivedQty() != null) {
					totalQunatity = issue.getReceivedQty();
				}
			}

			if (issue.getDamagedQty() != null && issue.getDamagedQty() != 0L && issue.getIssueQty().longValue() != totalQunatity) {
				quantityMismatchAndDamaged = true;
			} else if ((issue.getDamagedQty() == null || issue.getDamagedQty() == 0L)
					&& issue.getIssueQty().longValue() != totalQunatity.longValue()) {
				quantityMismatch = true;
			} else if (issue.getDamagedQty() != null && issue.getDamagedQty() != 0L
					&& issue.getIssueQty().longValue() == totalQunatity.longValue()) {
				damagedQuantity = true;
			}
			if (quantityMismatch && !quantityMismatchAndDamaged && !damagedQuantity) {
				receiptStatusId = 5;
			} else if (damagedQuantity && !quantityMismatch && !quantityMismatchAndDamaged) {
				receiptStatusId = 7;
			} else if (quantityMismatchAndDamaged && !damagedQuantity && !quantityMismatch) {
				receiptStatusId = 8;
			} else if (!quantityMismatchAndDamaged && !damagedQuantity && !quantityMismatch) {
				receiptStatusId = 2;
			} else if (quantityMismatchAndDamaged && damagedQuantity && quantityMismatch) {
				receiptStatusId = 8;
			} else {
				receiptStatusId = 8;
			}
			receiptStatusMaster.setId(receiptStatusId);
			issue.setReceiptStatusMaster(receiptStatusMaster);
			issue.setReceiptRemarks(dto.getRemarks());
			issue = cmssIndentDispatchRepository.save(issue);

			// update stock
			if (productId != 0L && issue.getFacility() != null) {
				FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
						issue.getBatchNo(), productId, issue.getFacility().getId());
				facilityStock = CMSSMapperUtil.mapToFacilityStock(productId, issue);
				facilityStockRepository.save(facilityStock);
			}

			FacilityStockTracking facilityStockTracking = CMSSMapperUtil.mapToFacilityStockTracking(productId, issue);
			facilityStockTrackingRepository.save(facilityStockTracking);
		} else {
			throw new ServiceException("Invalid Id", null, HttpStatus.BAD_REQUEST);
		}

		return dto;
	}

	private List<CMSSStockExternalResponseDto> fetchStockFromExternalService() {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(cmssExternalStockUsername, cmssExternalStockPassword);

		// create request
		HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

		// make a request
		ResponseEntity<List<CMSSStockExternalResponseDto>> response = restTemplate.exchange(cmssExternalStockUrl,
				HttpMethod.GET, request, new ParameterizedTypeReference<List<CMSSStockExternalResponseDto>>() {
				});

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ServiceException("Invalid Source Id", null, HttpStatus.BAD_REQUEST);
		}
		return response.getBody();
	}

	public Boolean fetchExternalIndents() {

		CMSSExternalIndentIssuesDto exteranlIndents = fetchIndents();

		List<CMSSProductMapping> cmssProducts = cmssProductMappingRepository.findByIsDelete(Boolean.FALSE);
		List<Product> sochProduct = productRepository.findAllByIsDelete(Boolean.FALSE);

		Map<String, String> cmssProductsmap = new HashMap<String, String>();
		for (CMSSProductMapping cp : cmssProducts) {
			cmssProductsmap.put(cp.getCmssProductName(), cp.getProductCode());
		}

		Map<String, String> sochProductsmap = new HashMap<String, String>();
		for (Product p : sochProduct) {
			sochProductsmap.put(p.getProductShortCode(), p.getProductName());
		}

		List<CmssStoreSacsMapping> cmssStoreMappingList = cmssStoreSacsMappingRepository.findByIsDelete(Boolean.FALSE);

		Map<String, Facility> cmssStoreMappingMap = new HashMap<String, Facility>();
		for (CmssStoreSacsMapping s : cmssStoreMappingList) {
			cmssStoreMappingMap.put(s.getCmssStoreName(), s.getFacility());
		}

		List<String> cmssProductNotFoundList = new ArrayList<String>();
		List<String> sochProductNotFoundList = new ArrayList<String>();

		List<CmssIndent> indents = new ArrayList<CmssIndent>();

		for (List<String> indentDetails : exteranlIndents.getDataValue()) {

			String cmssProductName = CMSSUtils.getCMSSProductName(indentDetails.get(4));

			String cmssProductCode = cmssProductsmap.get(cmssProductName);

			if (cmssProductCode == null) {
				cmssProductNotFoundList.add(cmssProductName);
			} else {
				String sochProductName = sochProductsmap.get(cmssProductCode);
				if (sochProductName == null) {
					sochProductNotFoundList.add(cmssProductName);
				} else {
					CmssIndent indent = new CmssIndent();
					indent.setIndentNo(indentDetails.get(0));
					indent.setIndentStore(indentDetails.get(1));
					if (cmssStoreMappingMap.get(indentDetails.get(1)) != null) {
						indent.setFacility(cmssStoreMappingMap.get(indentDetails.get(1)));
					}
					indent.setIssuingStore(CMSSUtils.getStoreName(indentDetails.get(2)));
					indent.setIndentDate(CMSSUtils.getDate(indentDetails.get(3)));
					indent.setCmssProductName(cmssProductName);
					indent.setProductCode(cmssProductCode);
					indent.setProductName(sochProductName);
					indent.setIndentQty(Long.parseLong(indentDetails.get(5)));
					indents.add(indent);
				}
			}
		}

		if (!CollectionUtils.isEmpty(indents)) {
			cmssIndentRepository.deleteAll();
			cmssIndentRepository.saveAll(indents);
		}

		cmssProductNotFoundList = cmssProductNotFoundList.stream().distinct().collect(Collectors.toList());

		sochProductNotFoundList = sochProductNotFoundList.stream().distinct().collect(Collectors.toList());

		logger.info("CMSS Product mapping not found for following products >>>> " + cmssProductNotFoundList);

		logger.info("Product not found in SOCH for following CMSS products >>>> " + sochProductNotFoundList);

		return Boolean.TRUE;
	}

	public Boolean fetchExternalIssues() {
		CMSSExternalIndentIssuesDto exteranlIssues = fetchIssues();

		List<CmssWarehouseStock> cmssWarehouseStockList = cmssWarehouseStockRepository.findAll();
		Map<String, CmssWarehouseStock> cmssWarehouseStockByBatchMap = new HashMap<String, CmssWarehouseStock>();
		for (CmssWarehouseStock cp : cmssWarehouseStockList) {
			cmssWarehouseStockByBatchMap.put(cp.getBatchNo(), cp);
		}

		List<CMSSProductMapping> cmssProducts = cmssProductMappingRepository.findByIsDelete(Boolean.FALSE);
		List<Product> sochProduct = productRepository.findAllByIsDelete(Boolean.FALSE);

		Map<String, String> cmssProductsmap = new HashMap<String, String>();
		for (CMSSProductMapping cp : cmssProducts) {
			cmssProductsmap.put(cp.getCmssProductName(), cp.getProductCode());
		}

		Map<String, String> sochProductsmap = new HashMap<String, String>();
		for (Product p : sochProduct) {
			sochProductsmap.put(p.getProductShortCode(), p.getProductName());
		}

		List<CmssStoreSacsMapping> cmssStoreMappingList = cmssStoreSacsMappingRepository.findByIsDelete(Boolean.FALSE);

		Map<String, Facility> cmssStoreMappingMap = new HashMap<String, Facility>();
		for (CmssStoreSacsMapping s : cmssStoreMappingList) {
			cmssStoreMappingMap.put(s.getCmssStoreName(), s.getFacility());
		}

		List<String> cmssProductNotFoundList = new ArrayList<>();
		List<String> sochProductNotFoundList = new ArrayList<>();

		List<CmssIndentDispatch> indentDispatches = new ArrayList<>();

		for (List<String> indentDetails : exteranlIssues.getDataValue()) {

			String cmssProductName = CMSSUtils.getCMSSProductName(indentDetails.get(4));

			String cmssProductCode = cmssProductsmap.get(cmssProductName);

			if (cmssProductCode == null) {
				cmssProductNotFoundList.add(cmssProductName);
			} else {
				String sochProductName = sochProductsmap.get(cmssProductCode);
				if (sochProductName == null) {
					sochProductNotFoundList.add(cmssProductName);
				} else {
					CmssIndentDispatch indentDispatch = new CmssIndentDispatch();

					indentDispatch.setIssuingStore(CMSSUtils.getStoreName(indentDetails.get(0)));
					String storeName = CMSSUtils.getStoreName(indentDetails.get(1));
					indentDispatch.setIndentStore(storeName);
					if (cmssStoreMappingMap.get(storeName) != null) {
						indentDispatch.setFacility(cmssStoreMappingMap.get(storeName));
					}

					indentDispatch.setIndentNo(indentDetails.get(2));
					indentDispatch.setIssueNo(indentDetails.get(3));
					indentDispatch.setCmssProductName(cmssProductName);
					indentDispatch.setProductCode(cmssProductCode);
					indentDispatch.setProductName(sochProductName);
					indentDispatch.setBatchNo(indentDetails.get(5));
					indentDispatch.setIssueDate(CMSSUtils.getDate(indentDetails.get(6)));
					indentDispatch.setIssueQty(Long.parseLong(indentDetails.get(7)));

					CmssWarehouseStock batchDetails = cmssWarehouseStockByBatchMap.get(indentDetails.get(5));
					if (batchDetails != null) {
						indentDispatch.setManufactureDate(batchDetails.getManufactureDate());
						indentDispatch.setExpiryDate(batchDetails.getExpiryDate());
					}
					ReceiptStatusMaster receiptStatus = new ReceiptStatusMaster();
					receiptStatus.setId(1);
					indentDispatch.setReceiptStatusMaster(receiptStatus);

					indentDispatches.add(indentDispatch);
				}
			}
		}

		if (!CollectionUtils.isEmpty(indentDispatches)) {

			List<CmssIndentDispatch> savedIssues = cmssIndentDispatchRepository.findAll();

			List<CmssIndentDispatch> issuesToRemove = savedIssues.stream()
					.filter(i -> i.getReceiptStatusMaster() != null && i.getReceiptStatusMaster().getId() == 1)
					.collect(Collectors.toList());

			savedIssues = savedIssues.stream()
					.filter(i -> i.getReceiptStatusMaster() != null && i.getReceiptStatusMaster().getId() != 1)
					.collect(Collectors.toList());

			List<CmssIndentDispatch> toRemoveList = new ArrayList<CmssIndentDispatch>();

			for (CmssIndentDispatch issueToSave : indentDispatches) {

				Optional<CmssIndentDispatch> searchedIssue = savedIssues.stream()
						.filter(i -> i.getIssueNo().equalsIgnoreCase(issueToSave.getIssueNo())
								&& i.getIndentNo().equalsIgnoreCase(issueToSave.getIndentNo())
								&& i.getBatchNo().equalsIgnoreCase(issueToSave.getBatchNo()))
						.findFirst();
				if (searchedIssue.isPresent()) {
					toRemoveList.add(issueToSave);
				}

			}

			if (!CollectionUtils.isEmpty(toRemoveList)) {
				indentDispatches.removeAll(toRemoveList);
			}

			cmssIndentDispatchRepository.deleteAll(issuesToRemove);
			cmssIndentDispatchRepository.saveAll(indentDispatches);
		}

		cmssProductNotFoundList = cmssProductNotFoundList.stream().distinct().collect(Collectors.toList());

		sochProductNotFoundList = sochProductNotFoundList.stream().distinct().collect(Collectors.toList());

		logger.info("CMSS Product mapping not found for following products >>>> " + cmssProductNotFoundList);

		logger.info("Product not found in SOCH for following CMSS products >>>> " + sochProductNotFoundList);

		return Boolean.TRUE;
	}

	public CMSSExternalIndentIssuesDto fetchIndents() {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(cmssExternalIndentUsername, cmssExternalIndentPassword);
		headers.setContentType(MediaType.TEXT_PLAIN);

		// create request
		HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

		// make a request

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(0, converter);

		ResponseEntity<CMSSExternalIndentIssuesDto> response = restTemplate.exchange(cmssExternalIndentUrl,
				HttpMethod.POST, request, CMSSExternalIndentIssuesDto.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ServiceException("Invalid Source Id", null, HttpStatus.BAD_REQUEST);
		}
		return response.getBody();
	}

	private CMSSExternalIndentIssuesDto fetchIssues() {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(cmssExternalIssuesUsername, cmssExternalIssuesPassword);
		headers.setContentType(MediaType.TEXT_PLAIN);

		// create request
		HttpEntity<HttpHeaders> request = new HttpEntity<>(headers);

		// make a request

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(0, converter);

		ResponseEntity<CMSSExternalIndentIssuesDto> response = restTemplate.exchange(cmssExternalIssuestUrl,
				HttpMethod.POST, request, CMSSExternalIndentIssuesDto.class);

		if (response.getStatusCode() != HttpStatus.OK) {
			throw new ServiceException("Invalid Source Id", null, HttpStatus.BAD_REQUEST);
		}

		return response.getBody();
	}

}
