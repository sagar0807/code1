package gov.naco.soch.cst.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiaryIctcReferralDto;
import gov.naco.soch.cst.dto.ArtSearchResultDto;
import gov.naco.soch.cst.dto.LinkedFacilityBeneficiaryDto;
import gov.naco.soch.cst.service.LacService;
import gov.naco.soch.dto.LacAddDto;

@RestController
@RequestMapping("/lac")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LacController {

	@Autowired
	private LacService lacService;

	private static final Logger logger = LoggerFactory.getLogger(LacController.class);

	@RequestMapping("/save")
	public LacAddDto saveLac(@RequestBody LacAddDto lacAddDto) {
		logger.debug("saveLac method is invoked");
		lacAddDto = lacService.saveLac(lacAddDto);
		logger.debug("saveLac method returns with parameters->{}", lacAddDto);
		return lacAddDto;

	}
	
	@DeleteMapping("/delete/{lacId}")
	public String deleteLac(@PathVariable Long lacId)
	{
		logger.debug("deleteLac method is invoked");
		return lacService.deleteLac(lacId);
	}
	
	@GetMapping("/list")
	public List<LinkedFacilityBeneficiaryDto> getAllLacs() {
		logger.debug("getAllLacs method is invoked");
		return lacService.getAllLacs();
	}
	
	@PutMapping("/update/{Id}/{lacId}")
	public Boolean UnLinkedFacilityBeneficiary(@PathVariable Long Id,@PathVariable Long lacId) {
		logger.debug("UnLinkedFacilityBeneficiary method is invoked");
		return lacService.unlinkLac(Id,lacId);
		
	}
	
	@PostMapping("/delink/{beneficiaryId}/{lacId}")
	public Boolean DeLinkLinkedFacilityBeneficiary(@PathVariable Long beneficiaryId,@PathVariable Long lacId) {
		logger.debug("UnLinkedFacilityBeneficiary method is invoked");
		return lacService.delinkLac(beneficiaryId,lacId);
		
	}
	
	@GetMapping("/ben-list")
	public List<LinkedFacilityBeneficiaryDto> getAllLacBeneficiary() {
		logger.debug("getAllLacBeneficiary method is invoked");
		return lacService.getAllLacBeneficiary();
	}
	
	
	@GetMapping("/lac-ben-listnsearch/{lacId}")
	public ArtSearchResultDto getLacBeneficiaryList(@RequestParam(required = true) String searchParameters,
													@RequestParam(required = true) Integer pageNumber, @RequestParam(required = true) Integer pageSize,@PathVariable("lacId") Long lacId) {

		logger.info("getArtBeneficiaryList method is invoked");
		ArtSearchResultDto artBeneficiarySearchResult = lacService.getLacBeneficiaryList(searchParameters, pageNumber, pageSize ,lacId);
		logger.info("getLacBeneficiaryList method returns with parameters->{}", artBeneficiarySearchResult.toString());

		return artBeneficiarySearchResult;
	}
	
	@GetMapping("/basic/searchby/{searchValue}")
	public @ResponseBody List<LinkedFacilityBeneficiaryDto> getLacListByNormalSearch(@PathVariable("searchValue") String searchValue)
	{
		logger.debug("getUserListByNormalSearch method is invoked");
		return lacService.getLacListByNormalSearch(searchValue);
	}
	
	@GetMapping("/advance/search")
	public List<LinkedFacilityBeneficiaryDto> getLacListBySearch(@RequestParam Map<String, String> searchValue) {
		logger.debug("inside referral advance search control");
		return lacService.lacListByAdvanceSearch(searchValue);
	}

	@GetMapping("/basic-searchby/{searchValue}")
	public @ResponseBody List<LinkedFacilityBeneficiaryDto> getLacBeneficiaryListByNormalSearch(@PathVariable("searchValue") String searchValue)
	{
		logger.debug("getUserListByNormalSearch method is invoked");
		return lacService.getLacBeneficiaryListByNormalSearch(searchValue);
	}
	
	@GetMapping("/advance-search")
	public List<LinkedFacilityBeneficiaryDto> getLacBenListByAdvSearch(@RequestParam Map<String, String> searchValue) {
		logger.debug("inside referral advance search control");
		return lacService.getLacBenListByAdvSearch(searchValue);
	}


}
