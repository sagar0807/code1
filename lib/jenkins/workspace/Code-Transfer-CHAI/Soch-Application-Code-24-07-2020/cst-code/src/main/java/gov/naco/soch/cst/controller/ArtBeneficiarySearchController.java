package gov.naco.soch.cst.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiarySearchDto;
import gov.naco.soch.cst.service.ArtBeneficiarySearchService;

@RestController
@RequestMapping("/beneficiary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiarySearchController {

	@Autowired
	private ArtBeneficiarySearchService artBeneficiarySearchService;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiarySearchController.class);

	/**
	 * API to get todays duelist details
	 * 
	 * @param facilityId
	 * @return List<ArtBeneficiarySearchDto>
	 */
	@GetMapping("/duelist/search/{facilityId}")
	public List<ArtBeneficiarySearchDto> getDueListBySearch(@Valid @PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "artNumber", required = false) String artNumber,
			@RequestParam(value = "preArtNumber", required = false) String preArtNumber,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "age", required = false) String gender) {
		logger.debug("getDueListBySearch() method is invoked"+name+""+artNumber+""+preArtNumber+""+uid);
		List<ArtBeneficiarySearchDto> beneficiaryDueListDtos = artBeneficiarySearchService
				.getDueListBySearch(facilityId, name, artNumber, preArtNumber, uid, gender);
		return beneficiaryDueListDtos;

	}

	@GetMapping("/duelistvisited/search/{facilityId}")
	public List<ArtBeneficiarySearchDto> getDueListBySearchVisited(@Valid @PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "artNumber", required = false) String artNumber,
			@RequestParam(value = "preArtNumber", required = false) String preArtNumber,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "age", required = false) String gender) {
		logger.debug("getDueListBySearch() method is invoked");
		List<ArtBeneficiarySearchDto> beneficiaryDueListDtos = artBeneficiarySearchService
				.getDueListBySearchVisited(facilityId, name, artNumber, preArtNumber, uid, gender);
		return beneficiaryDueListDtos;

	}
	
	@GetMapping("/queue/search/{facilityId}")
	public List<ArtBeneficiarySearchDto> getQueueBySearch(@Valid @PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "artNumber", required = false) String artNumber,
			@RequestParam(value = "preArtNumber", required = false) String preArtNumber,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "age", required = false) String gender) {
		logger.debug("getqueueBySearch() method is invoked");
		List<ArtBeneficiarySearchDto> beneficiaryQueueDtos = artBeneficiarySearchService
				.getQueueSearch(facilityId, name, artNumber, preArtNumber, uid, gender);
		return beneficiaryQueueDtos;

	}
	
	@GetMapping("/queuevisited/search/{facilityId}")
	public List<ArtBeneficiarySearchDto> getQueueBySearchVisited(@Valid @PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "artNumber", required = false) String artNumber,
			@RequestParam(value = "preArtNumber", required = false) String preArtNumber,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "age", required = false) String gender) {
		logger.debug("getDueListBySearch() method is invoked");
		List<ArtBeneficiarySearchDto> beneficiaryDueListDtos = artBeneficiarySearchService
				.getQueueSearchVisited(facilityId, name, artNumber, preArtNumber, uid, gender);
		return beneficiaryDueListDtos;

	}
}
