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

import gov.naco.soch.dto.TiBeneficiaryCommodityDistributionDto;
import gov.naco.soch.ti.service.TiCommodityDistributionService;

@RestController
@RequestMapping("/distribution")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiCommodityDistributionController {

	private static final Logger logger = LoggerFactory.getLogger(TiCommodityDistributionController.class);

	@Autowired
	private TiCommodityDistributionService tiCommodityDistributionService;

	// API to add TI commodity distribution details
	@PostMapping("/add")
	public @ResponseBody TiBeneficiaryCommodityDistributionDto addCounselling(
			@RequestBody TiBeneficiaryCommodityDistributionDto tiCommodityDistributionDto) {
		logger.debug("addCommodityDistributionDetails method called with parameters->{}", tiCommodityDistributionDto);
		tiCommodityDistributionService.addCommodityDistributionDetails(tiCommodityDistributionDto);
		logger.debug("addCommodityDistributionDetails method returns with parameters->{}", tiCommodityDistributionDto);
		return tiCommodityDistributionDto;
	}
}
