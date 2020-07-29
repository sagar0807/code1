package gov.naco.soch.ti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.TiCounsellingDto;
import gov.naco.soch.ti.service.TiCounsellingService;

@RestController
@RequestMapping("/counselling")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiCounsellingController {

	private static final Logger logger = LoggerFactory.getLogger(TiCounsellingController.class);

	@Autowired
	private TiCounsellingService tiCounsellingService;

	// API to add TI beneficiary counseling details
	@PostMapping("/add")
	public @ResponseBody TiCounsellingDto addCounselling(@RequestBody TiCounsellingDto tiCounsellingDto) {
		logger.debug("addCounsellingDetails method called with parameters->{}", tiCounsellingDto);
		tiCounsellingService.addCounsellingDetails(tiCounsellingDto);
		logger.debug("addCounsellingDetails method returns with parameters->{}", tiCounsellingDto);
		return tiCounsellingDto;
	}
}
