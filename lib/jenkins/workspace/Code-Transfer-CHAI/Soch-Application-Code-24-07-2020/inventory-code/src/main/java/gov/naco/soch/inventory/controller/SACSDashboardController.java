package gov.naco.soch.inventory.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.DashboardRequestDto;
import gov.naco.soch.inventory.dto.SACSDashboardReponseDto;
import gov.naco.soch.inventory.service.SACSDashboardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SACSDashboardController {

	private static final Logger logger = LoggerFactory.getLogger(SACSDashboardController.class);
	@Autowired
	private SACSDashboardService sACSDashboardService;

	@PostMapping("/data")
	public SACSDashboardReponseDto getData(@Valid @RequestBody DashboardRequestDto dashboardRequestDto) {
		logger.debug("getData method invoked ");
		return sACSDashboardService.getData(dashboardRequestDto);

	}

}
