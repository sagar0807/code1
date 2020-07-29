package gov.naco.soch.ti.controller;

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
import gov.naco.soch.ti.dto.DashBoardResponseDto;
import gov.naco.soch.ti.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	@Autowired
	private DashboardService dashboardService;

	@PostMapping("/data")
	public DashBoardResponseDto getData(@Valid @RequestBody DashboardRequestDto dashboardRequestDto) {
		logger.debug("getData method invoked ");
		return dashboardService.getData(dashboardRequestDto);

	}

	@PostMapping("/data/summary")
	public DashBoardResponseDto getDataForSummary(@Valid @RequestBody DashboardRequestDto dashboardRequestDto) {
		logger.debug("getData method invoked ");
		return dashboardService.getDataForSummary(dashboardRequestDto);

	}

	@PostMapping("/ost/data")
	public DashBoardResponseDto getOstData(@Valid @RequestBody DashboardRequestDto dashboardRequestDto) {
		logger.debug("getData method invoked ");
		return dashboardService.getOstData(dashboardRequestDto);

	}

}
