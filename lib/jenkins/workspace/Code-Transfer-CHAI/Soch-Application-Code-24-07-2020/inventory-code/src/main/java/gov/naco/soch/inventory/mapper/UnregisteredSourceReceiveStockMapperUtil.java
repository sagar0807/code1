package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import gov.naco.soch.dto.BatchDto;
import gov.naco.soch.dto.RemarkDto;
import gov.naco.soch.dto.UnregisteredSourceReceiveStockDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchProduct;
import gov.naco.soch.entity.FacilityDispatchProductBatch;
import gov.naco.soch.entity.FacilityGrnStatusMaster;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.FacilityReceiptProduct;
import gov.naco.soch.entity.FacilityReceiptProductBatch;
import gov.naco.soch.entity.FacilityReceiptStatusMaster;
import gov.naco.soch.entity.MasterInventoryUnregisteredSource;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.Town;

public class UnregisteredSourceReceiveStockMapperUtil {

	public static UnregisteredSourceReceiveStockDto mapToUnregisteredSourceReceiveStockDto(
			MasterInventoryUnregisteredSource source) {
		UnregisteredSourceReceiveStockDto dto = new UnregisteredSourceReceiveStockDto();
		dto.setSourceId(source.getId());
		dto.setSourceName(source.getSourceName());
		dto.setAddressId(source.getAddress().getId());
		dto.setAddress(source.getAddress().getAddressLineOne());
		dto.setStateId(source.getAddress().getState().getId());
		dto.setState(source.getAddress().getState().getName());
		dto.setDistrictId(source.getAddress().getDistrict().getId());
		dto.setDistrict(source.getAddress().getDistrict().getName());

		if (source.getAddress().getSubdistrict() != null) {
			dto.setSubDistrictId(source.getAddress().getSubdistrict().getSubdistrictId());
			dto.setSubDistrict(source.getAddress().getSubdistrict().getSubdistrictName());

		}

		if (source.getAddress().getTown() != null) {
			dto.setTownId(source.getAddress().getTown().getTownId());
			dto.setTown(source.getAddress().getTown().getTownName());
		}

		if (source.getAddress().getPincode() != null) {
			dto.setPincode(source.getAddress().getPincode());
		}

		return dto;
	}

	public static MasterInventoryUnregisteredSource mapToMasterInventoryUnregisteredSource(
			UnregisteredSourceReceiveStockDto dto, Boolean isfacility) {

		MasterInventoryUnregisteredSource source = new MasterInventoryUnregisteredSource();
		source.setSourceName(dto.getSourceName());

		Address address = new Address();
		address.setAddressLineOne(dto.getAddress());

		State state = new State();
		state.setId(dto.getStateId());

		District district = new District();
		district.setId(dto.getDistrictId());

		address.setState(state);
		address.setDistrict(district);

		if (dto.getSubDistrictId() != null) {
			Subdistrict subdistrict = new Subdistrict();
			subdistrict.setSubdistrictId(dto.getSubDistrictId());
			address.setSubdistrict(subdistrict);
		}

		if (dto.getTownId() != null) {
			Town town = new Town();
			town.setTownId(dto.getTownId());
			address.setTown(town);
		}
		if (dto.getPincode() != null) {
			address.setPincode(dto.getPincode());
		}

		source.setAddress(address);
		source.setIsDelete(Boolean.FALSE);
		source.setIsFacility(isfacility);

		return source;
	}

	public static Set<FacilityReceiptProduct> mapDispatchDtoToFacilityReceiptProductSet(FacilityReceipt facilityReceipt,
			Map<Long, Product> productsMap, Map<Long, List<BatchDto>> productBatchMapping) {
		return productBatchMapping.entrySet().stream().map(m -> {

			FacilityReceiptProduct facilityReceiptProduct = new FacilityReceiptProduct();
			facilityReceiptProduct.setFacilityReceipt(facilityReceipt);
			facilityReceiptProduct.setProduct(productsMap.get(m.getKey()));
			facilityReceiptProduct.setIsDelete(Boolean.FALSE);
			facilityReceiptProduct.setIsActive(Boolean.TRUE);

			Set<FacilityReceiptProductBatch> facilityReceiptProductBatchSet = m.getValue().stream().map(b -> {

				FacilityReceiptProductBatch facilityReceiptProductBatch = new FacilityReceiptProductBatch();
				facilityReceiptProductBatch.setBatchNumber(b.getBatchNumber());
				facilityReceiptProductBatch.setBatchManufactureDate(b.getManufactureDate());
				facilityReceiptProductBatch.setBatchExpiryDate(b.getExpiryDate());
				facilityReceiptProductBatch.setQuantityReceived(b.getReceivedQuantity());
				facilityReceiptProductBatch.setDamagedQuantity(b.getDamagedQuantity());
				facilityReceiptProductBatch.setFacilityReceiptProduct(facilityReceiptProduct);
				facilityReceiptProductBatch.setIsDelete(Boolean.FALSE);
				facilityReceiptProductBatch.setIsActive(Boolean.TRUE);
				return facilityReceiptProductBatch;

			}).collect(Collectors.toSet());

			facilityReceiptProduct.setFacilityReceiptProductBatches(facilityReceiptProductBatchSet);

			return facilityReceiptProduct;
		}).collect(Collectors.toSet());
	}

	public static FacilityReceipt mapToFacilityReceipt(MasterInventoryUnregisteredSource source,
			UnregisteredSourceReceiveStockDto dto) {
		FacilityReceipt facilityReceipt = new FacilityReceipt();

		Facility receivedfacility = new Facility();
		receivedfacility.setId(dto.getFacilityId());

		FacilityGrnStatusMaster facilityGrnStatusMaster = new FacilityGrnStatusMaster();
		FacilityReceiptStatusMaster facilityReceiptStatusMaster = new FacilityReceiptStatusMaster();
		facilityReceiptStatusMaster.setId(2L);
		facilityGrnStatusMaster.setId(4L);

		boolean isDamaged = false;
		for (BatchDto b : dto.getBatchDetails()) {
			if (b.getDamagedQuantity() != null && b.getDamagedQuantity() != 0) {
				isDamaged = true;
			}
		}

		if (isDamaged) {
			facilityReceiptStatusMaster.setId(7L);
		}

		facilityReceipt.setMasterInventoryUnregisteredSource(source);
		facilityReceipt.setFacilityReceiptStatusMaster(facilityReceiptStatusMaster);
		facilityReceipt.setFacilityGrnStatusMaster(facilityGrnStatusMaster);
		facilityReceipt.setGrnDate(LocalDate.now());
		facilityReceipt.setReceivedFacility(receivedfacility);

		return facilityReceipt;
	}

	public static UnregisteredSourceReceiveStockDto mapToUnregisteredSourceReceiveStockDto(FacilityReceipt r) {
		UnregisteredSourceReceiveStockDto dto = UnregisteredSourceReceiveStockMapperUtil
				.mapToUnregisteredSourceReceiveStockDto(r.getMasterInventoryUnregisteredSource());

		List<String> products = new ArrayList<>();
		List<BatchDto> batchDetails = new ArrayList<>();

		r.getFacilityReceiptProducts().forEach(p -> {

			products.add(p.getProduct().getProductName());
			p.getFacilityReceiptProductBatches().forEach(action -> {

				BatchDto batchDto = new BatchDto();
				batchDto.setProductId(p.getProduct().getId());
				batchDto.setProductName(p.getProduct().getProductName());
				batchDto.setReceivedQuantity(action.getQuantityReceived());
				batchDto.setDamagedQuantity(action.getDamagedQuantity());
				batchDto.setReceiptBatchId(action.getId());
				batchDto.setBatchNumber(action.getBatchNumber());
				batchDto.setExpiryDate(action.getBatchExpiryDate());
				batchDto.setManufactureDate(action.getBatchManufactureDate());
				batchDetails.add(batchDto);
			});
		});

		dto.setProducts(products);
		dto.setBatchDetails(batchDetails);

		List<RemarkDto> remarksList = new ArrayList<>();
		r.getFacilityDispatchReceiptRemarks().forEach(receipt -> {
			RemarkDto remark = new RemarkDto();
			remark.setDate(String.valueOf(receipt.getCreatedTime()));
			remark.setRemarks(receipt.getRemarks());
			if (receipt.getUserMaster1() != null) {
				remark.setUserName(
						receipt.getUserMaster1().getFirstname() + " " + receipt.getUserMaster1().getLastname());
			}
			remarksList.add(remark);
		});

		dto.setReceiptId(r.getFacilityReceiptId());

		dto.setFacilityId(r.getReceivedFacility().getId());
		dto.setFacilityName(r.getReceivedFacility().getName());

		dto.setGrnStatusId(r.getFacilityGrnStatusMaster().getId());
		dto.setGrnStatus(r.getFacilityGrnStatusMaster().getStatus());
		dto.setReceiptStatusId(r.getFacilityReceiptStatusMaster().getId());
		dto.setReceiptStatus(r.getFacilityReceiptStatusMaster().getStatus());
		dto.setRemarksList(remarksList);
		dto.setReceiptDate(r.getCreatedTime().toLocalDate());
		return dto;
	}

	public static FacilityDispatch mapDispatchDtoToFacilityDispatch(FacilityDispatch facilityDispatch,
			@Valid UnregisteredSourceReceiveStockDto dto) {

		facilityDispatch.setIndentDate(dto.getIndentDate());
		facilityDispatch.setExpectedDispatchDate(dto.getExpectedDispatchDate());
		facilityDispatch.setExpectedArrivalDate(dto.getExpectedArrivalDate());
		facilityDispatch.setTransporterName(dto.getTransporterName());
		facilityDispatch.setAwbNum(dto.getTransporterAwbNumber());
		// To change to driver name in future if needed
		facilityDispatch.setDriverName(dto.getTransporterAwbNumber());
		facilityDispatch.setContactNum(dto.getTransporterPhone());
		return facilityDispatch;
	}

	public static List<FacilityDispatchProduct> mapDispatchDtoToFacilityDispatchProductLis(
			FacilityDispatch facilityDispatch, @Valid UnregisteredSourceReceiveStockDto dto,
			Map<Long, Product> productsMap) {

		Map<Long, List<BatchDto>> productBatchMapping = dto.getBatchDetails().stream()
				.collect(Collectors.groupingBy(BatchDto::getProductId));

		List<FacilityDispatchProduct> facilityDispatchProductList = productBatchMapping.entrySet().stream().map(m -> {

			FacilityDispatchProduct facilityDispatchProduct = new FacilityDispatchProduct();
			facilityDispatchProduct.setFacilityDispatch(facilityDispatch);
			facilityDispatchProduct.setProduct(productsMap.get(m.getKey()));
			facilityDispatchProduct.setIsDelete(Boolean.FALSE);
			facilityDispatchProduct.setIsActive(Boolean.TRUE);

			Set<FacilityDispatchProductBatch> facilityDispatchProductBatchSet = m.getValue().stream().map(b -> {

				FacilityDispatchProductBatch facilityDispatchProductBatch = new FacilityDispatchProductBatch();
				facilityDispatchProductBatch.setBatchNumber(b.getBatchNumber());
				facilityDispatchProductBatch.setBatchExpiryDate(b.getExpiryDate());
				facilityDispatchProductBatch.setBatchManufactureDate(b.getManufactureDate());
				facilityDispatchProductBatch.setQuantityDispatched(b.getReceivedQuantity());
				facilityDispatchProductBatch.setBoxesNo(b.getNumberOfBoxes());
				facilityDispatchProductBatch.setFacilityDispatchProduct(facilityDispatchProduct);
				facilityDispatchProductBatch.setIsDelete(Boolean.FALSE);
				facilityDispatchProductBatch.setIsActive(Boolean.TRUE);
				return facilityDispatchProductBatch;

			}).collect(Collectors.toSet());

			facilityDispatchProduct.setFacilityDispatchProductBatches(facilityDispatchProductBatchSet);

			return facilityDispatchProduct;
		}).collect(Collectors.toList());

		return facilityDispatchProductList;
	}

	public static String createSearchQuery(List<Long> facilityIdList, String productName, String sourceName) {
		String formattedString = facilityIdList.toString().replace("[", "").replace("]", "").trim();
		String searchQuery = "select * from soch.facility_receipt fr join soch.facility_receipt_product frp"
				+ " on (fr.facility_receipt_id=frp.facility_receipt_id) join soch.product p on(p.id=frp.product_id)"
				+ " join soch.master_inventory_unregistered_source u on(u.id=fr.unregistered_source_id) where fr.received_facility_id IN " + "(" + formattedString + ")";
		if(productName!=null) {
			productName=productName.toLowerCase().trim();
			searchQuery=searchQuery+" and LOWER(p.product_name) like '%"+ productName+ "%'";
		}
		if(sourceName!=null) {
			sourceName=sourceName.toLowerCase().trim();
			searchQuery=searchQuery+" and LOWER(u.source_name) like '%"+ sourceName+ "%'";
		}
		return searchQuery;
	}

}
