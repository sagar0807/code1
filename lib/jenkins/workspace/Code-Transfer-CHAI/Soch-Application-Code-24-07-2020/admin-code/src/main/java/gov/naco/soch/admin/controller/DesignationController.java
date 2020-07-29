package gov.naco.soch.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.DesignationService;
import gov.naco.soch.dto.DesignationDto;

@RestController
@RequestMapping("/designation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	// Logger Method
	private static final Logger logger = LoggerFactory.getLogger(DesignationController.class);

	public DesignationController() {
	}

	// API to get all details from designation table
	@GetMapping("/list/{isActive}")
	public @ResponseBody List<DesignationDto> getAllDesignations(boolean onlyActive) {

		// Invoking getAllDesignations method
		logger.debug("getAllDesignations method called");
		List<DesignationDto> designationDtos = designationService.getAllDesignations(onlyActive);
		return designationDtos;
	}

	// API to save details to designation table
	@PostMapping("/save")
	public @ResponseBody DesignationDto saveDesignation(@Valid @RequestBody DesignationDto designationDto) {

		// Invoking saveDesignation method
		logger.debug("saveDesignation method called with parameters->{}", designationDto);
		designationDto = designationService.saveDesignation(designationDto);
		return designationDto;
	}

	// API to delete details from designation table
	@PostMapping("/delete/{id}")
	public Boolean deleteDesignation(@PathVariable("id") Long id) {

		// Invoking deleteDesignation method
		logger.debug("deleteDesignation method called with parameters->{}", id);
		return designationService.deleteDesignation(id);
	}

	// API to get details by facility type from designation table
	@GetMapping("/list/byfacilityType/{facilityType}")
	public @ResponseBody List<DesignationDto> getDesignationsByFacilityType(
			@PathVariable("facilityType") Long facilityType) {
		// Invoking getDesignationsByFacilityType method
		logger.debug("getDesignationsByFacilityType method called");
		List<DesignationDto> designationDtos = designationService.getDesignationsByFacilityType(facilityType);
		return designationDtos;
	}

}
