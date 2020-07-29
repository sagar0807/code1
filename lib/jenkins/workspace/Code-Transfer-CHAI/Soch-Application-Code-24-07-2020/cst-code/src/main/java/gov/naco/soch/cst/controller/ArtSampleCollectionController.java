
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.service.ArtSampleCollectionService;
import gov.naco.soch.dto.ArtSampleCollectionDto;

/**
 * Controller class for managing ART lab sample collection related APIs
 *
 */
@RestController
@RequestMapping("/lab")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtSampleCollectionController {

	private static final Logger logger = LoggerFactory.getLogger(ArtSampleCollectionController.class);

	@Autowired
	private ArtSampleCollectionService artSampleCollectionService;

	/**
	 * API to add sample collection details
	 * 
	 * @param artSampleCollectionDto
	 * @return ArtSampleCollectionDto
	 */
	@PostMapping("/sample/add")
	public List<ArtSampleCollectionDto> addSamples(
			@Valid @RequestBody List<ArtSampleCollectionDto> artSampleCollectionDtos) {

		logger.info("addSamples method called with parameters->{}", artSampleCollectionDtos);
		artSampleCollectionService.addSamples(artSampleCollectionDtos);
		logger.info("addSamples method returns with parameters->{}", artSampleCollectionDtos);
		return artSampleCollectionDtos;
	}

	/**
	 * To get all samples collected in current data
	 * 
	 * @return ArtSampleCollectionDto
	 */
	@GetMapping("/sample/todayslist")
	public List<ArtSampleCollectionDto> getTodaysSampleList() {
		logger.debug("getCD4SampleCollectedBeneficiaryList method is invoked");
		List<ArtSampleCollectionDto> list = artSampleCollectionService.getTodaysSampleList();
		return list;
	}

	/**
	 * To get all samples
	 * 
	 * @return ArtSampleCollectionDto
	 */
	@GetMapping("/sample/list")
	public  @ResponseBody List<ArtSampleCollectionDto> getSampleList(@RequestParam(defaultValue = "") String searchValue ) {
		logger.debug("getCD4SampleCollectedBeneficiaryList method is invoked");
		List<ArtSampleCollectionDto> list = artSampleCollectionService.getSampleList(searchValue);
		return list;
	}

	/**
	 * To get all samples which are cd4/cd4+viral load
	 * 
	 * @return ArtSampleCollectionDto
	 */
	@GetMapping("/sample/cd4list")
	public List<ArtSampleCollectionDto> getCD4SampleCollectedBeneficiaryList() {
		logger.debug("getCD4SampleCollectedBeneficiaryList method is invoked");
		return artSampleCollectionService.getCD4SampleCollectedBeneficiaryList();
	}

	/**
	 * To get all samples which are viral load/cd4+viral load
	 * 
	 * @return ArtSampleCollectionDto
	 */
	@GetMapping("/sample/virallist")
	public List<ArtSampleCollectionDto> getViralLoadSampleCollectedBeneficiaryList() {
		logger.debug("getAllSampleCollectedBeneficiaryList method is invoked");
		return artSampleCollectionService.getViralLoadSampleCollectedBeneficiaryList();
	}

	/**
	 * To get all beneficiaries with dispatch_status=true & test=CD4/CD4+viral load
	 * to record result
	 * 
	 * @return ArtSampleCollectionDto
	 */
	@GetMapping("/record/cd4list")
	public List<ArtSampleCollectionDto> getCD4DispatchedBeneficiaryList(@RequestParam(defaultValue = "") String searchValue) {
		logger.debug("getCD4DispatchedBeneficiaryList method is invoked");
		return artSampleCollectionService.getCD4DispatchedBeneficiaryList(searchValue);
	}

	/**
	 * To get all beneficiaries with dispatch_status=true& test=viral load/CD4+viral
	 * load to record result
	 * 
	 * @return ArtSampleCollectionDto
	 */
	@GetMapping("/record/virallist")
	public List<ArtSampleCollectionDto> getViralLoadDispatchedBeneficiaryList() {
		logger.debug("getViralLoadDispatchedBeneficiaryList method is invoked");
		return artSampleCollectionService.getViralLoadDispatchedBeneficiaryList();
	}
	

	@GetMapping("/barcodes/list")
	public List<String> getAllBarcodes() {
		logger.debug("getAllBarcodes method is invoked");
		return artSampleCollectionService.getAllBarcodes();
	}
	
}
