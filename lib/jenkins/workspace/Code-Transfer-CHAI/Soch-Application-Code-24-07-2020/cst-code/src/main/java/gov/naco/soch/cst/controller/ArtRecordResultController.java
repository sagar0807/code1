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
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.service.ArtRecordResultService;
import gov.naco.soch.dto.ArtCd4RecordResultDto;

@RestController
@RequestMapping("/lab")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtRecordResultController {

	private static final Logger logger = LoggerFactory.getLogger(ArtRecordResultController.class);

	@Autowired
	private ArtRecordResultService artRecordResultService;

	/**
	 * Method to record CD4 results into db
	 * 
	 * @param artCd4RecordResultDtos
	 * @return List<ArtCd4RecordResultDto>
	 */
	@PostMapping("result/cd4record")
	public List<ArtCd4RecordResultDto> addCd4RecordResult(
			@Valid @RequestBody List<ArtCd4RecordResultDto> artCd4RecordResultDtos) {
		logger.info("addCd4RecordResult method called with parameters->{}", artCd4RecordResultDtos);
		artRecordResultService.addCd4RecordResult(artCd4RecordResultDtos);
		logger.info("addCd4RecordResult method returns with parameters->{}", artCd4RecordResultDtos);
		return artCd4RecordResultDtos;
	}

	/**
	 * To get all test results
	 * 
	 * @return ArtDispatchSamplesDto
	 */
	@GetMapping("result/cd4list")
	public List<ArtCd4RecordResultDto> getAllCD4TestResults(@RequestParam(defaultValue = "") String searchValue) {
		logger.debug("getAllCD4TestResults method is invoked");
		return artRecordResultService.getAllCD4TestResults(searchValue);
	}

}
