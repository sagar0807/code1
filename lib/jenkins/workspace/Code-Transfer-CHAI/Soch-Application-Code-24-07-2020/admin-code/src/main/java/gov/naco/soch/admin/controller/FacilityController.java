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
import gov.naco.soch.dto.DistrictFacilityDto;
import gov.naco.soch.dto.FacilityBasicListDto;
import gov.naco.soch.dto.FacilityDto;
import gov.naco.soch.dto.FacilityListByDistrictAndFacilityTypeDTO;
import gov.naco.soch.dto.FacilityRequestDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.dto.TypologyDto;

@RestController
@RequestMapping("/facility")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityController {

	private static final Logger logger = LoggerFactory.getLogger(FacilityController.class);

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private CommonAdminService commonService;

	public FacilityController() {
	}

	// API to add details to facility table
	@PostMapping("/add")
	public @ResponseBody FacilityDto addFacility(@RequestBody FacilityDto facilityDto) {
		logger.debug("addFacility method called with parameters->{}", facilityDto);
		facilityService.addFacility(facilityDto);
		commonService.clearCache("FacilitiesBasicListCache", null);
		logger.debug("addFacility method returns with parameters->{}", facilityDto);
		return facilityDto;
	}

	// API to get all details from facility table
	@GetMapping("/list")
	public @ResponseBody List<FacilityDto> getAllFacilities(@RequestParam(required = false) List<Long> divisionIds,
			@RequestParam(required = false) Long stateId) {
		logger.debug("getAllFacilities method is invoked");
		return facilityService.getAllFacilities(divisionIds, stateId);
	}

	/**
	 * Facility list based on
	 * 
	 * @param divisionIds
	 * @param stateId
	 * @param facilityTypeId
	 * @return FacilityBasicListDto
	 */
	@GetMapping("/listby")
	public @ResponseBody List<FacilityBasicListDto> getFacilities(
			@RequestParam(required = false) List<Long> divisionIds, @RequestParam(required = false) Long stateId,
			@RequestParam(required = false) Long facilityTypeId) {
		logger.debug("getAllFacilities method is invoked");
		return facilityService.getFacilities(divisionIds, stateId, facilityTypeId);
	}

	// API to retrieve facilities based on division and facility type

	@GetMapping("/get/{divisionId}/{facilityTypeId}")
	public @ResponseBody List<FacilityRequestDto> getFacility(@PathVariable("divisionId") Long divisionId,
			@PathVariable("facilityTypeId") Long facilityTypeId) {
		logger.debug("getFacility method called with division and facility type id as ", divisionId, facilityTypeId);
		List<FacilityRequestDto> facilities = facilityService.getFacilities(divisionId, facilityTypeId);
		logger.debug("getFacility method returns with parameters->{}", facilities);
		return facilities;
	}

	// Bugfix 14-02-2020

	// API to get facilities mapped to a lab
	@GetMapping("/mappedtolab/{labId}")
	public @ResponseBody List<FacilityDto> getFacilitiesMappedToLab(@PathVariable("labId") Long labId) {
		logger.info("getAllFacilities method is invoked");
		return facilityService.getFacilitiesMappedToLab(labId);
	}

	// API to get all details from facility table
	@GetMapping("/labs")
	public @ResponseBody List<FacilityDto> getLabs() {
		logger.debug("getAllFacilities method is invoked");
		return facilityService.getLabs();
	}

	// API to map facilities to a lab
	@PostMapping("/labs/{labId}/mapToFacility")
	public @ResponseBody List<FacilityDto> mapLabToFacility(@PathVariable("labId") Long labId,
			@RequestBody List<FacilityDto> facilities) {
		logger.debug("getAllFacilities method is invoked");
		return facilityService.mapLabToFacility(labId, facilities);
	}

	// API to get all details from facility table
	@GetMapping("/localfacilities/{facilityId}")
	public @ResponseBody DistrictFacilityDto getLocalFacilites(@PathVariable("facilityId") Long facilityId,
			@RequestParam(required = true) List<Long> divisionIds) {
		logger.debug("getLocalFacilites method is invoked");
		return facilityService.getLocalFacilites(facilityId, divisionIds);
	}

	// API to list all active facilities created by particular SACS
	// @parameter sacsId
	// only IsActive = TRUE and Is_Delete = FALSE

	@GetMapping("/{sacsId}/list")
	public @ResponseBody List<FacilityDto> getFacilitySacs(@PathVariable("sacsId") Long sacsId) {
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		facilityDtoList = facilityService.getFacilitySacs(sacsId);
		return facilityDtoList;
	}

	// API to list all facilities(SACS)
	@GetMapping("list/sacs")
	public @ResponseBody List<FacilityDto> getSacsList() {
		List<FacilityDto> facilityDtoList = new ArrayList<FacilityDto>();
		facilityDtoList = facilityService.getSacsList();
		return facilityDtoList;

	}

	/**
	 * From here to down latest API for all facility functionalities
	 */

	/**
	 * Create and Edit Facility
	 * 
	 * @param sacsFacilityDto
	 * @return
	 */
	@PostMapping("/create/facilities")
	public @ResponseBody SacsFacilityDto addAnyFacility(@RequestBody SacsFacilityDto sacsFacilityDto) {
		sacsFacilityDto
				.setFacilityNo(sacsFacilityDto.getFacilityNo() != null ? sacsFacilityDto.getFacilityNo().trim() : null);
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

	/**
	 * API to list all active facilities created by particular SACS only IsActive =
	 * TRUE and Is_Delete = FALSE
	 * 
	 * @param sacsId
	 * @return
	 */
	@GetMapping("list/{sacsId}")
	public @ResponseBody List<SacsFacilityDto> getAllFacilityBySacs(@PathVariable("sacsId") Long sacsId,
			@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.getAllFacilityBySacs(sacsId, pageNumber, pageSize);
		return sacsFacilityDtoList;

	}

	/**
	 * API to list all active facilities created by particular parent facility only
	 * Is_Delete = FALSE
	 * 
	 * @param parentFacilityId
	 * @return
	 */
	@GetMapping("list/parent/{parentFacilityId}")
	public @ResponseBody List<SacsFacilityDto> getAllFacilityByParent(
			@PathVariable("parentFacilityId") Long parentFacilityId) {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.getAllFacilityByParentId(parentFacilityId);
		return sacsFacilityDtoList;

	}

	/**
	 * Delete Facility
	 * 
	 * @param facilityId
	 * @return
	 */
	@DeleteMapping("/delete/{facilityId}")
	public SacsFacilityDto deleteFacility(@PathVariable("facilityId") Long facilityId) {
		logger.info("deleteFacility method called with facilityId" + facilityId);
		commonService.clearCache("FacilitiesBasicListCache", null);
		return facilityService.deleteFacility(facilityId);
	}

	/**
	 * Find facility by facility ID
	 * 
	 * @param facilityId
	 * @return
	 */
	@GetMapping("/findby/{facilityId}")
	public @ResponseBody SacsFacilityDto getFacilityByFacilityId(@PathVariable("facilityId") Long facilityId) {
		SacsFacilityDto sacsFacilityDto = new SacsFacilityDto();
		sacsFacilityDto = facilityService.getFacilityByFacilityId(facilityId);
		return sacsFacilityDto;
	}

	/**
	 * Find facility list based on facilityType
	 * 
	 * @param facilityTypeId
	 * @return
	 */
	@GetMapping("/findby/facilityTypeId/{facilityTypeId}/andsacs")
	public @ResponseBody List<SacsFacilityDto> getFacilityByFacilityTypeIdAndSacs(
			@PathVariable("facilityTypeId") Long facilityTypeId) {
		List<SacsFacilityDto> sacsFacilityDtos = facilityService.getFacilityByFacilityTypeIdAndSacs(facilityTypeId);
		return sacsFacilityDtos;
	}

	@GetMapping("/ticenter/list/underIdu")
	public @ResponseBody List<SacsFacilityDto> getTiCenterByIduAndSacs() {
		List<SacsFacilityDto> sacsFacilityDtos = facilityService.getTiCenterByIduAndSacs();
		return sacsFacilityDtos;
	}

	/**
	 * Find typology list by facility id
	 * 
	 * @param facilityId
	 * @return
	 */
	@GetMapping("/typology/list/byfacility/{facilityId}")
	public @ResponseBody List<TypologyDto> getTypologyListByFacility(@PathVariable("facilityId") Long facilityId) {
		List<TypologyDto> typologyDtoList = new ArrayList<TypologyDto>();
		typologyDtoList = facilityService.getTypologyListByFacilityId(facilityId);
		return typologyDtoList;
	}

	/**
	 * Find all typology list
	 * 
	 * @return
	 */
	@GetMapping("/typology/list")
	public @ResponseBody List<TypologyDto> getTypologyList() {
		List<TypologyDto> typologyDtoList = new ArrayList<TypologyDto>();
		typologyDtoList = facilityService.getAllTypology();
		return typologyDtoList;
	}

	/**
	 * Find list of Parent ost center
	 * 
	 * @return
	 */
	@GetMapping("/parentostcenter/list")
	public @ResponseBody List<SacsFacilityDto> getParentOstCenterList() {
		List<SacsFacilityDto> sacsFacilityDtos = facilityService.getParentOstCenterList();
		return sacsFacilityDtos;
	}

	// API to list all India ART based on facility type id

	@GetMapping("/listbyfacilitytype/{facilityTypeId}")
	public @ResponseBody List<SacsFacilityDto> getAllArt(@PathVariable Long facilityTypeId) {
		List<Long> facilityType = new ArrayList<Long>();
		facilityType.add((facilityTypeId));
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		Integer pageNumber = null;
		Integer pageSize = null;
		sacsFacilityDtoList = facilityService.getFacilityByFacilityType(facilityType, pageNumber, pageSize);
		return sacsFacilityDtoList;
	}

	/**
	 * Fetch facility list based on district id (Mandatory) and facility type id
	 * (Not Mandatory) api as query parameter
	 * 
	 * @param district
	 * @param facilityType
	 * @return
	 */
	@GetMapping("/getFacilityListByDistrict")
	public @ResponseBody List<FacilityListByDistrictAndFacilityTypeDTO> getFacilityByDistrictAndFacilityType(
			@RequestParam Long district, @RequestParam(required = false) Long facilityType) {
		List<FacilityListByDistrictAndFacilityTypeDTO> FacilityList = facilityService
				.getFacilityByDistrictAndFacilityType(district, facilityType);
		return FacilityList;
	}

	/**
	 * Advance search for the facilities created by sacs login Search criteria:
	 * facilityname,code,username,mobilenumber,email
	 * 
	 * @param searchValues
	 * @return
	 */
	@GetMapping("/createdbysacs/advancesearch")
	public @ResponseBody List<SacsFacilityDto> advanceSearchForFacilities(
			@RequestParam Map<String, String> searchValues, @RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		List<Long> facilityTypeIds = null;
		sacsFacilityDtoList = facilityService.advanceSearchForFacilities(searchValues, facilityTypeIds, pageNumber,
				pageSize);
		return sacsFacilityDtoList;
	}

	/**
	 * Normal search Query parameters searchvalue: contain value to search.
	 * facilitytype: for determine which facility screen. division: for determine
	 * api call from laboratory screen or not
	 * 
	 * @param searchDetails
	 * @return
	 */
	@GetMapping("/normalsearch")
	public @ResponseBody List<SacsFacilityDto> normalSearchForFacilities(
			@RequestParam Map<String, String> searchDetails, @RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize) {
		List<SacsFacilityDto> sacsFacilityDtoList = new ArrayList<SacsFacilityDto>();
		sacsFacilityDtoList = facilityService.normalSearchForFacilities(searchDetails, pageNumber, pageSize);
		return sacsFacilityDtoList;
	}

}
