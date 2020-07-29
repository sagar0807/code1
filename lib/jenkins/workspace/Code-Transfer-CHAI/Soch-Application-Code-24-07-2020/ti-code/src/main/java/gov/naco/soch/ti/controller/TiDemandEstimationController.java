package gov.naco.soch.ti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.TiDemandEstimateDto;
import gov.naco.soch.ti.service.TiDemandEstimationService;

@RestController
@RequestMapping("/demandestimation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiDemandEstimationController {

	private static final Logger logger = LoggerFactory.getLogger(TiDemandEstimationController.class);

	@Autowired
	private TiDemandEstimationService tiDemandEstimationService;

	@GetMapping("/list")
	public TiDemandEstimateDto listDemandEstimation() {
		logger.debug("listDemandEstimationService method is invoked");
		return tiDemandEstimationService.listDemandEstimation();
	}

}
