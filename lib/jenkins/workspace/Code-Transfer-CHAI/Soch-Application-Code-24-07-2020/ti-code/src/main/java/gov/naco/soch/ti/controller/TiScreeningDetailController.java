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

import gov.naco.soch.dto.TiScreeningDetailDto;
import gov.naco.soch.ti.service.TiScreeningDetailService;

@RestController
@RequestMapping("/screening")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiScreeningDetailController {

	private static final Logger logger = LoggerFactory.getLogger(TiScreeningDetailController.class);

	@Autowired
	TiScreeningDetailService screeningService;

	// API to add TI beneficiary screening details
	@PostMapping("/add")
	public @ResponseBody TiScreeningDetailDto addScreeningDetails(
			@RequestBody TiScreeningDetailDto tiScreeningDetailDto) {
		logger.debug("addScreeningDetails method called with parameters->{}", tiScreeningDetailDto);
		screeningService.addScreeningDetails(tiScreeningDetailDto);
		logger.debug("addScreeningDetails method returns with parameters->{}", tiScreeningDetailDto);
		return tiScreeningDetailDto;
	}

}
