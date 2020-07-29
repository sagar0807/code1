package gov.naco.soch.cst.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ARTDashBoardResponseDTO;
import gov.naco.soch.cst.dto.ARTDashboardRequestDTO;
import gov.naco.soch.cst.service.ARTDashBoardService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ARTDashboardController {
	
	@Autowired
	private ARTDashBoardService dashboardService;

	private static final Logger logger = LoggerFactory.getLogger(ARTDashboardController.class);

	@PostMapping("/dashboard/data")
	public ResponseEntity<ARTDashBoardResponseDTO> getData(
			@Valid @RequestBody ARTDashboardRequestDTO dashboardRequestDto) throws Exception {
		logger.debug("getData method invoked ");
		ARTDashBoardResponseDTO artDashBoardResponseDTO = new ARTDashBoardResponseDTO();
		try {
			artDashBoardResponseDTO = dashboardService.getData(dashboardRequestDto);
		} catch (Exception e) {
			logger.error("Exception handler stack : ", e);
			return new ResponseEntity<ARTDashBoardResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ARTDashBoardResponseDTO>(artDashBoardResponseDTO, HttpStatus.OK);

	}
	
	@PostMapping("/dashboard/data/filter")
	public ResponseEntity<ARTDashBoardResponseDTO> getFilteredData(
			@Valid @RequestBody ARTDashboardRequestDTO dashboardRequestDto) throws Exception {
		logger.debug("getData method invoked ");
		ARTDashBoardResponseDTO artDashBoardResponseDTO = new ARTDashBoardResponseDTO();
		try {
			artDashBoardResponseDTO = dashboardService.getFilteredData(dashboardRequestDto);
		} catch (Exception e) {
			logger.error("Exception handler stack : ", e);
			return new ResponseEntity<ARTDashBoardResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ARTDashBoardResponseDTO>(artDashBoardResponseDTO, HttpStatus.OK);

	}
	
	
	


}
