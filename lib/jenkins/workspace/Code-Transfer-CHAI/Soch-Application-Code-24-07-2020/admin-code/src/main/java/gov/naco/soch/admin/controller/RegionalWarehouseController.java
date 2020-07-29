package gov.naco.soch.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.FacilityService;
import gov.naco.soch.admin.service.CommonAdminService;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.enums.FacilityTypeEnum;

@RestController
@RequestMapping("/regionalwarehouse")
public class RegionalWarehouseController {
	private static final Logger logger = LoggerFactory.getLogger(RegionalWarehouseController.class);

	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private CommonAdminService systemService;

	public RegionalWarehouseController() {

	}

	@GetMapping("/list")
	public @ResponseBody List<SacsFacilityDto> getAllRegionalWarehouseList(
			@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
		List<Long> facilityTypeId = new ArrayList<Long>();
		facilityTypeId.add((long) 6); // Regional Warehouse facility Type Id
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.getFacilityByFacilityType(facilityTypeId, pageNumber, pageSize);
		return sacsFacilityDtoList;
	}

	@PostMapping("/create")
	public @ResponseBody SacsFacilityDto addRegionalWarehouse(@RequestBody SacsFacilityDto sacsFacilityDto) {
		sacsFacilityDto.setName(sacsFacilityDto.getName() != null ? sacsFacilityDto.getName().trim() : null);
		if (sacsFacilityDto.getId() == null) {
			logger.debug("addFacilityFromSacs method called with parameters->{}", sacsFacilityDto);
			sacsFacilityDto = facilityService.addAnyFacilities(sacsFacilityDto);
			logger.debug("addFacilityFromSacs method returns with parameters->{}", sacsFacilityDto);
		} else {
			logger.debug("editAnyFacilities method called with parameters->{}", sacsFacilityDto);
			sacsFacilityDto = facilityService.editAnyFacilities(sacsFacilityDto);
			logger.debug("editAnyFacilities method returns with parameters->{}", sacsFacilityDto);
		}
		systemService.clearCache("FacilitiesBasicListCache", null);
		return sacsFacilityDto;
	}

	@DeleteMapping("/delete/{facilityId}")
	public SacsFacilityDto deleteRegionalWarehouse(@PathVariable("facilityId") Long facilityId) {
		logger.info("deleteFacility method called with facilityId" + facilityId);
		systemService.clearCache("FacilitiesBasicListCache", null);
		return facilityService.deleteFacility(facilityId);
	}

	/**
	 * Advance search for the Regional Warehouse. Search criteria:
	 * facilityname,code,username,mobilenumber,email
	 * 
	 * @param searchValues
	 * @return
	 */
	@GetMapping("/advancesearch")
	public @ResponseBody List<SacsFacilityDto> advanceSearchForFacilities(
			@RequestParam Map<String, String> searchValues, @RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		List<Long> facilityTypeIds = new ArrayList<>();
		facilityTypeIds.add(FacilityTypeEnum.WAREHOUSE.getFacilityType());
		sacsFacilityDtoList = facilityService.advanceSearchForFacilities(searchValues, facilityTypeIds, pageNumber,
				pageSize);
		return sacsFacilityDtoList;
	}
	
}
