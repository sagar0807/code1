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
@RequestMapping("/labs")
public class LabsController {
	private static final Logger logger = LoggerFactory.getLogger(LabsController.class);

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private CommonAdminService commonService;

	public LabsController() {

	}

	@GetMapping("/list")
	public @ResponseBody List<SacsFacilityDto> getAllLabs(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		List<Long> facilityTypeIds = new ArrayList<Long>();
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_EID.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_APEX.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_NRL.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_SRL.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_CD4.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_ICTC_PPTCT.getFacilityType());
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.getFacilityByFacilityType(facilityTypeIds, pageNumber, pageSize);
		return sacsFacilityDtoList;
	}

	// API to add details to facility table
	@PostMapping("/create")
	public @ResponseBody SacsFacilityDto addLabs(@RequestBody SacsFacilityDto sacsFacilityDto) {
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

	@DeleteMapping("/delete/{facilityId}")
	public SacsFacilityDto deleteLabs(@PathVariable("facilityId") Long facilityId) {
		logger.info("deleteFacility method called with facilityId" + facilityId);
		commonService.clearCache("FacilitiesBasicListCache", null);
		return facilityService.deleteFacility(facilityId);
	}

	/**
	 * Advance search for the Laboratory. Search criteria:
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
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_EID.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_APEX.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_NRL.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_SRL.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_CD4.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.VL_PUBLIC.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.VL_PRIVATE.getFacilityType());
		facilityTypeIds.add(FacilityTypeEnum.LABORATORY_ICTC_PPTCT.getFacilityType());
		sacsFacilityDtoList = facilityService.advanceSearchForFacilities(searchValues, facilityTypeIds, pageNumber,
				pageSize);
		return sacsFacilityDtoList;
	}

	/**
	 * Get ictc facility list mapped with current login facility as EID lab
	 * 
	 * @return
	 */
	@GetMapping("/mappedictc")
	public @ResponseBody List<SacsFacilityDto> getMappedIctcForEidLab() {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.getMappedIctcForEidLab();
		return sacsFacilityDtoList;
	}

	/**
	 * Fetching vl labs mapped with current facility id
	 * 
	 * @return
	 */
	@GetMapping("/mapped/undercurrentFacility")
	public @ResponseBody List<SacsFacilityDto> getMappedVlLabsUnderCurrentFacility() {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.getMappedVlLabsUnderCurrentFacility();
		return sacsFacilityDtoList;
	}

}
