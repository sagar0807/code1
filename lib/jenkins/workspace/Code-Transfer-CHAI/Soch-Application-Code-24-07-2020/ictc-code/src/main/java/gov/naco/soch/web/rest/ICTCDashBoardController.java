package gov.naco.soch.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.service.ICTCDashBoardService;
import gov.naco.soch.service.dto.ICTCDashBoardResponseDTO;
import gov.naco.soch.service.dto.ICTCDashboardRequestDTO;

@RestController
@RequestMapping("/api")
public class ICTCDashBoardController {

	@Autowired
	private ICTCDashBoardService dashboardService;

	private static final Logger logger = LoggerFactory.getLogger(ICTCDashBoardController.class);

	@PostMapping("/dashboard/data")
	public ResponseEntity<ICTCDashBoardResponseDTO> getData(
			@Valid @RequestBody ICTCDashboardRequestDTO dashboardRequestDto) throws Exception {
		logger.debug("getData method invoked ");
		ICTCDashBoardResponseDTO ictcDashBoardResponseDTO = new ICTCDashBoardResponseDTO();
		try {
			ictcDashBoardResponseDTO = dashboardService.getData(dashboardRequestDto);
		} catch (Exception e) {
			return new ResponseEntity<ICTCDashBoardResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ICTCDashBoardResponseDTO>(ictcDashBoardResponseDTO, HttpStatus.OK);

	}
}
