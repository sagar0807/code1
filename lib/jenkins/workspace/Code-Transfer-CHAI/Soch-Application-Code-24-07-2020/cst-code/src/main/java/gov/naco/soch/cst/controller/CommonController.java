package gov.naco.soch.cst.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.service.CommonService;
import gov.naco.soch.dto.FacilityDto;

@RestController
@RequestMapping("/common")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private CommonService commonService;

	@GetMapping("/getFacilityListByDistrict/{districtId}")
	public @ResponseBody List<FacilityDto> getFacilityList(@PathVariable Long districtId) {
		logger.debug("Entering into method getFacilityListByDistrictId with districtId->{}:", districtId);
		return commonService.getFacilityListByDistrictId(districtId);
	}

}
