package gov.naco.soch.cst.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import gov.naco.soch.cst.dto.ArtPepDto;
import gov.naco.soch.cst.service.ArtPepService;
import gov.naco.soch.dto.SacsFacilityDto;
import gov.naco.soch.entity.ArtPep;

@RestController
@RequestMapping("/pep")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PepController {

	@Autowired
	private ArtPepService artPepService;

	private static final Logger logger = LoggerFactory.getLogger(PepController.class);

	// API to register/save PEP details
	@PostMapping("/register")
	public @ResponseBody boolean savePepDetails(@RequestBody ArtPepDto artPepDto) {
		logger.debug("Entering into savePepDetails  method ");
		ArtPep artPep = new ArtPep();
		//artPep = artPepService.savePepDetails(artPepDto);
		logger.debug("savePepDetails method returns with parameters->{}", artPepDto);
		return artPepService.savePepDetails(artPepDto);
	}

	// API to List PEP details with Normal Search
	@GetMapping("/list/search")
	public @ResponseBody List<ArtPepDto> getPepList(@RequestParam String searchText) {
		logger.debug("Entering into getPepList  method ");
		return artPepService.getPepList(searchText);
	}

	// API to list PEP Queue Details with Normal Search
	@GetMapping("/queuelist/search")
	public @ResponseBody List<ArtPepDto> getPepQueueList(@RequestParam String searchText) {
		logger.debug("Entering into getPepQueueList  method ");
		return artPepService.getPepQueueList(searchText);
	}

	// API to List PEP Due List with Normal Search
	@GetMapping("/duelist/search")
	public @ResponseBody List<ArtPepDto> getPepDueList(@RequestParam String searchText) {
		logger.debug("Entering into getPepDueList  method ");
		return artPepService.getPepDueList(searchText);
	}

	@GetMapping("/peplist/advancesearch")
	public @ResponseBody List<ArtPepDto> advanceSearchForFacilities(@RequestParam Map<String, String> searchValues) {

		List<ArtPepDto> artPepDtoList = new ArrayList<ArtPepDto>();
		artPepDtoList = artPepService.getPepListByAdvanceSearch(searchValues);
		return artPepDtoList;

	}

}
