package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gov.naco.soch.entity.CmssIndentDispatch;
import gov.naco.soch.entity.CmssWarehouse;
import gov.naco.soch.entity.CmssWarehouseStock;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.SacsCmssWarehouseMapping;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;
import gov.naco.soch.inventory.dto.CMSSSacsWarehouseMappingDto;
import gov.naco.soch.inventory.dto.CMSSStockDto;
import gov.naco.soch.inventory.dto.CMSSStockExternalResponseDto;
import gov.naco.soch.inventory.dto.CMSSStoreWiseStockDto;
import gov.naco.soch.inventory.dto.CMSSWarehouseDto;

public class CMSSMapperUtil {

	private static DateTimeFormatter DATE_FORMATTOR = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

	public static List<CMSSWarehouseDto> mapCMSSWarehouseDtoToCMSSWarehouse(List<CmssWarehouse> cmssWareHouseList) {
		List<CMSSWarehouseDto> cmssWarehouseDtos = new ArrayList<CMSSWarehouseDto>();
		cmssWareHouseList.forEach(cmssWarehouse -> {
			CMSSWarehouseDto cmssWarehouseDto = new CMSSWarehouseDto();
			cmssWarehouseDto.setId(cmssWarehouse.getId());
			cmssWarehouseDto.setStoreId(cmssWarehouse.getStoreId());
			cmssWarehouseDto.setStoreName(cmssWarehouse.getStoreName());
			cmssWarehouseDtos.add(cmssWarehouseDto);
		});
		return cmssWarehouseDtos;
	}

	public static CmssWarehouseStock mapCMSSStockExternalResponseDtoToCmssWarehouseStock(
			CMSSStockExternalResponseDto extenalStock) {
		CmssWarehouseStock stockItem = new CmssWarehouseStock();
		stockItem.setStoreId(extenalStock.getStore_ID());
		stockItem.setStoreName(extenalStock.getStore_NAME());
		stockItem.setCmssProductName(extenalStock.getDrug_NAME());
		stockItem.setBrandId(extenalStock.getBrand_ID());
		stockItem.setBatchNo(extenalStock.getBatch_NO());
		stockItem.setPoNo(extenalStock.getPo_NO());
		stockItem.setQtyActive(Long.parseLong(extenalStock.getQty_ACTIVE()));
		stockItem.setQtyQuarantine(Long.parseLong(extenalStock.getQty_QUAR()));
		stockItem.setQtyRejected(Long.parseLong(extenalStock.getQty_REJ()));
		stockItem.setManufactureDate(getDate(extenalStock.getManuf_DATE()));
		stockItem.setExpiryDate(getDate(extenalStock.getExpiry_DATE()));
		stockItem.setIsActive(Boolean.TRUE);
		stockItem.setIsDelete(Boolean.FALSE);
		return stockItem;
	}

	private static LocalDate getDate(String date) {
		if (!StringUtils.isEmpty(date)) {
			String newDate = date.substring(0, 4).toUpperCase() + date.substring(4).toLowerCase();
			return LocalDate.parse(newDate, DATE_FORMATTOR);
		} else {
			return null;
		}
	}

	public static List<CMSSWarehouseDto> mapSacsCmssWarehouseMappingToCMSSWarehouseDto(
			List<SacsCmssWarehouseMapping> mappedWarehouses) {
		List<CMSSWarehouseDto> warehouses = new ArrayList<>();
		mappedWarehouses.forEach(warehouse -> {
			CMSSWarehouseDto mappedWarehouse = new CMSSWarehouseDto();
			mappedWarehouse.setId(warehouse.getCmssWarehouse().getId());
			mappedWarehouse.setStoreId(warehouse.getCmssWarehouse().getStoreId());
			mappedWarehouse.setStoreName(warehouse.getCmssWarehouse().getStoreName());
			warehouses.add(mappedWarehouse);
		});
		return warehouses;
	}

	public static List<SacsCmssWarehouseMapping> mapCMSSSacsWarehouseMappingDto(
			@Valid CMSSSacsWarehouseMappingDto warehouseDto) {
		List<SacsCmssWarehouseMapping> sacsMappedWarehouses = new ArrayList<>();
		warehouseDto.getMappedWarehouses().forEach(warehouse -> {
			SacsCmssWarehouseMapping sacsCmssWarehouseMapping = new SacsCmssWarehouseMapping();
			CmssWarehouse cmssWarehouse = new CmssWarehouse();
			cmssWarehouse.setId(warehouse.getId());
			sacsCmssWarehouseMapping.setCmssWarehouse(cmssWarehouse);
			Facility facility = new Facility();
			facility.setId(warehouseDto.getSacsId());
			sacsCmssWarehouseMapping.setFacility(facility);
			sacsMappedWarehouses.add(sacsCmssWarehouseMapping);
		});
		return sacsMappedWarehouses;
	}

	public static List<CMSSStockDto> mapCmssWarehouseStockToCMSSStockDto(
			List<CmssWarehouseStock> cmssWarehouseStockList) {
		List<CMSSStockDto> cmssWarehouseStockDtoList = new ArrayList<>();
		cmssWarehouseStockList.forEach(cmssWarehouseStock -> {
			CMSSStockDto cmssStockDto = new CMSSStockDto();
			cmssStockDto.setBatchNo(cmssWarehouseStock.getBatchNo());
			cmssStockDto.setBrandId(cmssWarehouseStock.getBrandId());
			cmssStockDto.setDrugName(cmssWarehouseStock.getCmssProductName());
			cmssStockDto.setExpiryDate(cmssWarehouseStock.getExpiryDate());
			cmssStockDto.setManufDate(cmssWarehouseStock.getManufactureDate());
			cmssStockDto.setPoNo(cmssWarehouseStock.getPoNo());
			cmssStockDto.setQtyActive(cmssWarehouseStock.getQtyActive());
			cmssStockDto.setQtyQuar(cmssWarehouseStock.getQtyQuarantine());
			cmssStockDto.setQtyRej(cmssWarehouseStock.getQtyRejected());
			cmssStockDto.setStoreId(cmssWarehouseStock.getStoreId());
			cmssStockDto.setStoreName(cmssWarehouseStock.getStoreName());
			cmssWarehouseStockDtoList.add(cmssStockDto);

		});
		return cmssWarehouseStockDtoList;
	}

	public static List<CMSSStoreWiseStockDto> mapCMSSWarehouseStockDtoListToCMSSStoreWiseStockDtoList(
			List<CMSSStockDto> cmssWarehouseStockDtoList) {

		List<CMSSStoreWiseStockDto> cmssStoreWiseStockDtoList = new ArrayList<>();

		cmssWarehouseStockDtoList = cmssWarehouseStockDtoList.stream().map(s -> {
			if (s.getManufDate() == null) {
				s.setManufDate(LocalDate.MIN);
			}
			if (s.getExpiryDate() == null) {
				s.setManufDate(LocalDate.MIN);
			}
			return s;
		}).collect(Collectors.toList());

		Map<String, List<CMSSStockDto>> storeWiseMap = cmssWarehouseStockDtoList.stream()
				.collect(Collectors.groupingBy(CMSSStockDto::getStoreName));

		storeWiseMap.forEach((k, v) -> {

			Map<String, List<CMSSStockDto>> productWiseMap = v.stream()
					.collect(Collectors.groupingBy(CMSSStockDto::getDrugName));

			productWiseMap.forEach((x, y) -> {

				CMSSStoreWiseStockDto cmssStoreWiseStockDto = new CMSSStoreWiseStockDto();

				cmssStoreWiseStockDto.setStoreName(k);

				cmssStoreWiseStockDto.setDrugName(x);

				Map<String, List<CMSSStockDto>> batchWiseMap = y.stream()
						.collect(Collectors.groupingBy(CMSSStockDto::getBatchNo));

				cmssStoreWiseStockDto.setNoOfBatch(Long.valueOf(batchWiseMap.entrySet().size()));

				List<CMSSStockDto> batchesList = new ArrayList<>();
				batchWiseMap.forEach((b, c) -> {

					Long activeQty = 0L;
					Long quarQty = 0L;
					Long rejQty = 0L;

					CMSSStockDto cmssStockDto = new CMSSStockDto();
					cmssStockDto.setBatchNo(b);
					cmssStockDto.setStoreName(k);
					cmssStockDto.setDrugName(x);

					for (CMSSStockDto s : c) {
						activeQty = activeQty + s.getQtyActive();
						quarQty = quarQty + s.getQtyQuar();
						rejQty = rejQty + s.getQtyRej();
					}

					LocalDate manufDate = c.stream().map(CMSSStockDto::getManufDate).distinct().sorted().findFirst()
							.get();
					LocalDate expiryDate = c.stream().map(CMSSStockDto::getExpiryDate).distinct().sorted().findFirst()
							.get();

					cmssStockDto.setManufDate(manufDate);
					cmssStockDto.setExpiryDate(expiryDate);

					cmssStockDto.setQtyActive(activeQty);
					cmssStockDto.setQtyQuar(quarQty);
					cmssStockDto.setQtyRej(rejQty);
					batchesList.add(cmssStockDto);
				});

				Map<String, List<CMSSStockDto>> poWiseMap = y.stream()
						.collect(Collectors.groupingBy(CMSSStockDto::getPoNo));

				cmssStoreWiseStockDto.setNoOfPO(Long.valueOf(poWiseMap.entrySet().size()));

				List<CMSSStockDto> poList = new ArrayList<>();
				poWiseMap.forEach((p, q) -> {

					Long activeQty = 0L;
					Long quarQty = 0L;
					Long rejQty = 0L;

					CMSSStockDto cmssStockDto = new CMSSStockDto();
					cmssStockDto.setPoNo(p);
					cmssStockDto.setStoreName(k);
					cmssStockDto.setDrugName(x);

					for (CMSSStockDto s : q) {
						activeQty = activeQty + s.getQtyActive();
						quarQty = quarQty + s.getQtyQuar();
						rejQty = rejQty + s.getQtyRej();
					}

					cmssStockDto.setQtyActive(activeQty);
					cmssStockDto.setQtyQuar(quarQty);
					cmssStockDto.setQtyRej(rejQty);
					poList.add(cmssStockDto);
				});

				cmssStoreWiseStockDto.setPoList(poList);

				LocalDate manufDate = y.stream().map(CMSSStockDto::getManufDate).distinct().sorted().findFirst().get();

				cmssStoreWiseStockDto.setManufDate(manufDate);

				LocalDate expiryDate = null;
				Optional<LocalDate> expiryDateOpt = y.stream()
						.filter(s -> s.getQtyActive() != null && s.getQtyActive().longValue() != 0L)
						.map(CMSSStockDto::getExpiryDate).distinct().sorted().findFirst();

				if (expiryDateOpt.isPresent()) {
					expiryDate = expiryDateOpt.get();
				} else {
					expiryDate = y.stream().map(CMSSStockDto::getExpiryDate).distinct().sorted().findFirst().get();
				}
				cmssStoreWiseStockDto.setExpiryDate(expiryDate);

				Map<LocalDate, List<CMSSStockDto>> manufDateWiseMap = v.stream()
						.filter(p -> p.getManufDate().compareTo(manufDate) == 0)
						.collect(Collectors.groupingBy(CMSSStockDto::getManufDate));

				List<CMSSStockDto> manufDateWiseList = new ArrayList<>();
				manufDateWiseMap.forEach((m, n) -> {

					Map<String, List<CMSSStockDto>> productManufMap = n.stream()
							.collect(Collectors.groupingBy(CMSSStockDto::getDrugName));

					productManufMap.forEach((g, h) -> {

						Long activeQty = 0L;
						Long quarQty = 0L;
						Long rejQty = 0L;
						CMSSStockDto cmssStockDto = new CMSSStockDto();

						cmssStockDto.setStoreName(k);
						cmssStockDto.setDrugName(g);
						cmssStockDto.setManufDate(m);

						for (CMSSStockDto s : h) {
							activeQty = activeQty + s.getQtyActive();
							quarQty = quarQty + s.getQtyQuar();
							rejQty = rejQty + s.getQtyRej();
						}

						cmssStockDto.setQtyActive(activeQty);
						cmssStockDto.setQtyQuar(quarQty);
						cmssStockDto.setQtyRej(rejQty);
						manufDateWiseList.add(cmssStockDto);
					});

				});

				cmssStoreWiseStockDto.setManufList(manufDateWiseList);

				LocalDate toCompareExpiryDate = cmssStoreWiseStockDto.getExpiryDate();
				Map<LocalDate, List<CMSSStockDto>> expiryDateWiseMap = v.stream()
						.filter(p -> p.getExpiryDate().compareTo(toCompareExpiryDate) == 0)
						.collect(Collectors.groupingBy(CMSSStockDto::getExpiryDate));

				List<CMSSStockDto> expiryDateWiseList = new ArrayList<>();
				expiryDateWiseMap.forEach((e, f) -> {

					Map<String, List<CMSSStockDto>> productExpiryMap = f.stream()
							.collect(Collectors.groupingBy(CMSSStockDto::getDrugName));

					productExpiryMap.forEach((g, h) -> {

						Long activeQty = 0L;
						Long quarQty = 0L;
						Long rejQty = 0L;

						CMSSStockDto cmssStockDto = new CMSSStockDto();

						cmssStockDto.setStoreName(k);
						cmssStockDto.setDrugName(g);
						cmssStockDto.setExpiryDate(e);

						for (CMSSStockDto s : h) {
							activeQty = activeQty + s.getQtyActive();
							quarQty = quarQty + s.getQtyQuar();
							rejQty = rejQty + s.getQtyRej();
						}

						cmssStockDto.setQtyActive(activeQty);
						cmssStockDto.setQtyQuar(quarQty);
						cmssStockDto.setQtyRej(rejQty);
						expiryDateWiseList.add(cmssStockDto);
					});

				});

				cmssStoreWiseStockDto.setExpiryList(expiryDateWiseList);

				Long activeQty = 0L;
				Long quarQty = 0L;
				Long rejQty = 0L;

				for (CMSSStockDto s : batchesList) {
					activeQty = activeQty + s.getQtyActive();
					quarQty = quarQty + s.getQtyQuar();
					rejQty = rejQty + s.getQtyRej();
				}

				cmssStoreWiseStockDto.setBatchList(batchesList);

				cmssStoreWiseStockDto.setQtyActive(activeQty);
				cmssStoreWiseStockDto.setQtyQuar(quarQty);
				cmssStoreWiseStockDto.setQtyRej(rejQty);

				List<CMSSStockDto> expiryQtyList = v.stream()
						.filter(p -> p.getExpiryDate().compareTo(toCompareExpiryDate) == 0 && p.getDrugName().contentEquals(x))
						.collect(Collectors.toList());

				if (!CollectionUtils.isEmpty(expiryQtyList)) {
					Long expiryQty = 0L;

					for (CMSSStockDto s : batchesList) {
						expiryQty = expiryQty + s.getQtyActive();
					}
					cmssStoreWiseStockDto.setExpiryQty(expiryQty);
				}

				cmssStoreWiseStockDtoList.add(cmssStoreWiseStockDto);
			});

		});

		return cmssStoreWiseStockDtoList;

	}

	public static FacilityStock mapToFacilityStock(Long productId, CmssIndentDispatch issue) {
		FacilityStock facilityStock = new FacilityStock();
		facilityStock.setBatchNumber(issue.getBatchNo());
		Facility facility = new Facility();
		if (issue.getFacility() != null) {
			facility.setId(issue.getFacility().getId());
		}
		facilityStock.setFacility(facility);
		Product product = new Product();
		product.setId(productId);
		facilityStock.setProduct(product);
		facilityStock.setIsActive(true);
		facilityStock.setIsActive(false);
		facilityStock.setManufacturingDate(issue.getManufactureDate());
		facilityStock.setExpiredDate(issue.getExpiryDate());
		if(issue.getReceivedQty()!=null) {
		facilityStock.setCurrentQuantity(issue.getReceivedQty().doubleValue());
		}
		return facilityStock;
	}

	public static FacilityStockTracking mapToFacilityStockTracking(Long productId, CmssIndentDispatch issue) {
		FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
		facilityStockTracking.setBatchNumber(issue.getBatchNo());
		Facility facility = new Facility();
		if (issue.getFacility() != null) {
			facility.setId(issue.getFacility().getId());
		}
		facilityStockTracking.setFacility(facility);
		FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
		facilityStockTrackingType
				.setId(FacilityStockTrackingTypeEnum.Receive_From_CMSS.getFacilityStockTrackingTypeId());
		facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
		Product product = new Product();
		product.setId(productId);
		facilityStockTracking.setIsActive(true);
		facilityStockTracking.setIsActive(false);
		facilityStockTracking.setProduct(product);
		facilityStockTracking.setBatchNumber(issue.getBatchNo());
		facilityStockTracking.setTransactionDate(LocalDate.now());
		facilityStockTracking.setReferenceNo(issue.getId());
		if(issue.getReceivedQty()!=null) {
			facilityStockTracking.setQuantity(issue.getReceivedQty().doubleValue());
		}
		return facilityStockTracking;
	}
}
