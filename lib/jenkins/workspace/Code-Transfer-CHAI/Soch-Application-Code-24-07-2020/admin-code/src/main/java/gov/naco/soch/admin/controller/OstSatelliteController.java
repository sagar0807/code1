package gov.naco.soch.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.FacilityService;
import gov.naco.soch.dto.FacilityBasicListDto;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.enums.FacilityTypeEnum;

@RestController
@RequestMapping("/ostsatellite")
public class OstSatelliteController {
	private static final Logger logger = LoggerFactory.getLogger(OstSatelliteController.class);

	@Autowired
	private FacilityService facilityService;

	public OstSatelliteController() {
	}

	/**
	 * Fetching list of ost Satellite based on parent ost center (Current login
	 * facility)
	 * 
	 * @return
	 */
	@GetMapping("/list/byostcenter")
	public @ResponseBody List<SacsFacilityDto> getOstSatelliteListByParentOst() {
		Integer pageNumber = null;
		Integer pageSize = null;
		List<SacsFacilityDto> sacsFacilityDtoList = facilityService.getFacilityListByParentAsCurrentFacility(
				FacilityTypeEnum.TI_SATELLITE_OST.getFacilityType(), pageNumber, pageSize);
		return sacsFacilityDtoList;
	}
	
	/**
	 * Optimized List for Ost satellite facility
	 * @return
	 */
	@GetMapping("/optimized/list")
	public @ResponseBody List<FacilityBasicListDto> getAllOptimizedFacilityByCurrentFacilityAsParent() {
		List<FacilityBasicListDto> facilityBasicListDtoList = facilityService
				.getAllOptimizedFacilityByCurrentFacilityAsParent(FacilityTypeEnum.TI_SATELLITE_OST.getFacilityType());
		return facilityBasicListDtoList;
	}
}