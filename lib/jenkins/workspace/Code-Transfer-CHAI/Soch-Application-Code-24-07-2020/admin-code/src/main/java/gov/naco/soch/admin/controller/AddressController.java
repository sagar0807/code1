package gov.naco.soch.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.AddressService;
import gov.naco.soch.dto.LocationDto;

//Address controller for State , District , Thaluk

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

	@Autowired
	AddressService addressService;
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	public AddressController() {
	}
	
	//API to list all states
	@GetMapping("/state")
	public @ResponseBody List<LocationDto> getStateList() {
		logger.debug("Entering into method getStateList()");
		List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
		locationDtoList = addressService.getStateList();
		return locationDtoList;
	}
	
	//API to list all districts by state_id
	@GetMapping("/districtbystateid")
	public @ResponseBody List<LocationDto> getDistrictList(@RequestParam Long stateId) {
		logger.debug("Entering into method getDistrictList()");
		List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
		locationDtoList = addressService.getDistrictList(stateId);
		return locationDtoList;
	}
	
	
	//API to list all sub districts by district_id
	@GetMapping("/subdistrictbydistrictid")
	public @ResponseBody List<LocationDto> getSubDistrictList(@RequestParam Long districtId) {
		logger.debug("Entering into method getSubDistrictList()");
		List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
		locationDtoList = addressService.getSubDistrictList(districtId);
		return locationDtoList;
	}
	
	//API to list all town by sub district id
	@GetMapping("/townbysubdistrictid")
	public @ResponseBody List<LocationDto> getTownList(@RequestParam Long subdistrictId) {
		logger.debug("Entering into method getTownList()");
		List<LocationDto> locationDtoList = new ArrayList<LocationDto>();
		locationDtoList = addressService.getTownList(subdistrictId);
		return locationDtoList;
	}
	
}
