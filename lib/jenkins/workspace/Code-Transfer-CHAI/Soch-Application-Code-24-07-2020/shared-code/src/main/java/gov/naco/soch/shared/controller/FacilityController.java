package gov.naco.soch.shared.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.shared.dto.FacilityListResponseDTO;
import gov.naco.soch.shared.service.FacilityService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FacilityController {

	private final Logger log = LoggerFactory.getLogger(FacilityController.class);

	private final FacilityService facilityService;

	public FacilityController(FacilityService facilityService) {
		this.facilityService = facilityService;
	}

	@GetMapping("/facilities/{facilityType}")
	public List<FacilityListResponseDTO> getFacilitiesByFacilityType(@PathVariable Long facilityType) {
		return facilityService.getFacilitiesByFacilityType(facilityType);
	}

}
