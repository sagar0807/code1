package gov.naco.soch.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import gov.naco.soch.dto.FacilityBasicListDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.enums.FacilityTypeEnum;

@RestController
@RequestMapping("/lac")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LacController {
	private static final Logger logger = LoggerFactory.getLogger(LacController.class);

	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private CommonAdminService commonService;

	@PostMapping("/create")
	public @ResponseBody SacsFacilityDto addLacFacility(@RequestBody SacsFacilityDto sacsFacilityDto) {
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
		commonService.clearCache("FacilitiesBasicListCache", null);
		return sacsFacilityDto;
	}

	@GetMapping("/list")
	public @ResponseBody List<SacsFacilityDto> getAllLacFacility(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		List<SacsFacilityDto> sacsFacilityDtoList = facilityService.getFacilityListByParentAsCurrentFacility(
				FacilityTypeEnum.LAC_FACILITY.getFacilityType(), pageNumber, pageSize);
		return sacsFacilityDtoList;
	}

	/**
	 * Optimized List for LAC facility
	 * @return
	 */
	@GetMapping("/optimized/list")
	public @ResponseBody List<FacilityBasicListDto> getAllOptimizedFacilityByCurrentFacilityAsParent() {
		List<FacilityBasicListDto> facilityBasicListDtoList = facilityService
				.getAllOptimizedFacilityByCurrentFacilityAsParent(FacilityTypeEnum.LAC_FACILITY.getFacilityType());
		return facilityBasicListDtoList;
	}

	@DeleteMapping("/delete/{facilityId}")
	public SacsFacilityDto deleteLacFacility(@PathVariable("facilityId") Long facilityId) {
		logger.info("deleteFacility method called with facilityId" + facilityId);
		commonService.clearCache("FacilitiesBasicListCache", null);
		return facilityService.deleteFacility(facilityId);
	}

	/**
	 * Advance search for the LAC. Search criteria:
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
		facilityTypeIds.add(FacilityTypeEnum.LAC_FACILITY.getFacilityType());
		sacsFacilityDtoList = facilityService.advanceSearchForFacilities(searchValues, facilityTypeIds, pageNumber,
				pageSize);
		return sacsFacilityDtoList;
	}
	
}
