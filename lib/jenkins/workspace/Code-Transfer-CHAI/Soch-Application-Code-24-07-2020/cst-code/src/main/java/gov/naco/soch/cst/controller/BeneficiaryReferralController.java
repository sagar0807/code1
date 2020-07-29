package gov.naco.soch.cst.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiaryIctcReferralDto;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.cst.service.BeneficiaryReferralService;

@RestController
@RequestMapping("/referral")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficiaryReferralController {
	
	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryReferralController.class);
	
	@Autowired
	private BeneficiaryReferralService beneficiaryReferralService;
	
	
	@GetMapping("/list")
	public List<ArtBeneficiaryIctcReferralDto> getReferralList() {
		logger.debug("inside referral list control");
		return beneficiaryReferralService.getReferralList();
		
	}
	
	@PostMapping("/save")
	public ArtRegistrationDto saveBeneficiaryFromIctcReferral(@RequestBody ArtRegistrationDto artRegistrationDto) {
		return beneficiaryReferralService.saveBeneficiaryFromIctcReferral(artRegistrationDto);
	}
	
	@GetMapping("normal/search/{searchText}")
	public List<ArtBeneficiaryIctcReferralDto> getReferralListByBasicSearch(@PathVariable String searchText) {
		logger.debug("inside referral search list control");
		return beneficiaryReferralService.getReferralListBySearch(searchText);
	}
	
	@GetMapping("advance/search")
	public List<ArtBeneficiaryIctcReferralDto> getReferralListBySearch(@RequestParam Map<String, String> searchValue) {
		logger.debug("inside referral advance search control");
		return beneficiaryReferralService.getReferralListByAdvanceSearch(searchValue);
	}

}
