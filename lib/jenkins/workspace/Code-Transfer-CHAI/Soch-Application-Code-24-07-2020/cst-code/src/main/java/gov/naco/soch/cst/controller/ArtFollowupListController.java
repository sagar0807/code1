package gov.naco.soch.cst.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtFollowupListDto;
import gov.naco.soch.cst.service.ArtFollowupListService;

@RestController
@RequestMapping("/artfollowup")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtFollowupListController {

	private static final Logger logger = LoggerFactory.getLogger(ArtFollowupListController.class);

	@Autowired
	private ArtFollowupListService artFollowupListService;

	@GetMapping("/list/generate")
	private @ResponseBody List<ArtFollowupListDto> getFollowupList(@RequestParam Integer year,
			@RequestParam Integer month) {
		logger.debug("Entering into getFollowupList  method ");
		List<ArtFollowupListDto> artFollowupListDto = new ArrayList<ArtFollowupListDto>();
		artFollowupListDto = artFollowupListService.getFollowupList(year, month);
		return artFollowupListDto;

	}

	@GetMapping("/list/search")
	private @ResponseBody List<ArtFollowupListDto> getFollowupListBySearch(@RequestParam String searchText) {
		logger.debug("Entering into getFollowupListBySearch  method ");
		List<ArtFollowupListDto> artFollowupListDto = new ArrayList<ArtFollowupListDto>();
		artFollowupListDto = artFollowupListService.getFollowupListBySearch(searchText);
		return artFollowupListDto;

	}

	@PostMapping("/save")
	private List<ArtFollowupListDto> saveFollowupList(@RequestBody List<ArtFollowupListDto> artFollowupListDto) {
		logger.debug("Entering into saveFollowupList  method ");
		return artFollowupListService.saveFollowupList(artFollowupListDto);

	}
	
	@DeleteMapping("/delete/{followupId}")
	public Boolean DeleteFollowupList(@PathVariable("followupId") Long followupId){
		logger.debug("DeleteFollowupList method called with parameters->{}", followupId);
		return artFollowupListService.DeleteFollowupList(followupId);
	}
	
	@GetMapping("/statuschange")
	public void getStatusList() {
		logger.debug("Entering into findOnArtMisBeneficiaryList  method ");
		artFollowupListService.findOnArtMisBeneficiaryList();
		artFollowupListService.findOnArtLfuBeneficiaryList();
	}
	

}
