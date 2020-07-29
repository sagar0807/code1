package gov.naco.soch.cst.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiaryQueueDto;
import gov.naco.soch.cst.dto.WorkLoadTilesDto;
import gov.naco.soch.cst.service.WorkLoadTilesService;
import gov.naco.soch.entity.ArtBeneficiaryQueue;

@RestController
@RequestMapping("/workloadtiles")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class WorkLoadTilesController {
	@Autowired 
	private WorkLoadTilesService workLoadTilesService;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueController.class);
	
	@GetMapping("/tilescount")
	public @ResponseBody List<WorkLoadTilesDto> getBeneficiaryDueCount() {
		logger.debug("getDueCount method is invoked");
		return workLoadTilesService.getWorkLoadTileCountList();
	}
	
}
