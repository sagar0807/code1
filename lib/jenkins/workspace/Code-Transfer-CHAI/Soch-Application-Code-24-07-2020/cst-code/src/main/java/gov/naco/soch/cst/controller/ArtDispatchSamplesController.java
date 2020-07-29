package gov.naco.soch.cst.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.service.ArtDispatchSamplesService;
import gov.naco.soch.dto.ArtDispatchSamplesDto;
import gov.naco.soch.dto.ViralLoadPreviousDispatchDto;

/**
 * Controller class for managing ART lab sample dispatch related APIs
 *
 */
@RestController
@RequestMapping("/lab")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtDispatchSamplesController {

	private static final Logger logger = LoggerFactory.getLogger(ArtDispatchSamplesController.class);

	@Autowired
	private ArtDispatchSamplesService artDispatchSamplesService;

	/**
	 * API to dispatch collected samples
	 * 
	 * @param artSampleCollectionDto
	 * @return ArtSampleCollectionDto
	 */
	@PostMapping("/dispatchCd4")
	public List<ArtDispatchSamplesDto> dispatchCd4Samples(
			@Valid @RequestBody List<ArtDispatchSamplesDto> artDispatchSamplesDtos) {
		logger.info("dispatchCd4Samples method called with parameters->{}", artDispatchSamplesDtos);
		artDispatchSamplesService.dispatchCd4Samples(artDispatchSamplesDtos);
		logger.info("dispatchCd4Samples method returns with parameters->{}", artDispatchSamplesDtos);
		return artDispatchSamplesDtos;
	}

	/**
	 * API to dispatch collected samples
	 * 
	 * @param artSampleCollectionDto
	 * @return ArtSampleCollectionDto
	 */
	@PostMapping("/dispatchViral")
	public List<ArtDispatchSamplesDto> dispatchViralSamples(
			@Valid @RequestBody List<ArtDispatchSamplesDto> artDispatchSamplesDtos) {
		logger.info("dispatchViralSamples method called with parameters->{}", artDispatchSamplesDtos);
		artDispatchSamplesService.dispatchViralSamples(artDispatchSamplesDtos);
		logger.info("dispatchViralSamples method returns with parameters->{}", artDispatchSamplesDtos);
		return artDispatchSamplesDtos;
	}

	/**
	 * To get all previous dispatched cd4,cd4 +viral load samples
	 * 
	 * @return ArtDispatchSamplesDto
	 */
	@GetMapping("/dispatch/cd4list")
	public List<ArtDispatchSamplesDto> getAllCD4PreviouDispatchedSamples() {
		logger.debug("getAllCD4PreviouDispatchedSamples method is invoked");
		return artDispatchSamplesService.getAllCD4PreviouDispatchedSamples();
	}

	/**
	 * To get all previous dispatched viral load,cd4 +viral load samples
	 * 
	 * @return ArtDispatchSamplesDto
	 */
	@GetMapping("/dispatch/virallist")
	public List<ViralLoadPreviousDispatchDto> getAllViralLoadPreviouDispatchedSamples() {
		logger.debug("getAllViralLoadPreviouDispatchedSamples method is invoked");
		return artDispatchSamplesService.getAllViralLoadPreviouDispatchedSamples();
	}

}
