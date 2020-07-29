package gov.naco.soch.cst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.service.MasterCstDataService;
import gov.naco.soch.dto.MasterDto;

@RestController
@RequestMapping("/master")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MasterCstDataController {
	
	@Autowired
	private MasterCstDataService masterCstDataService;
	
	@GetMapping("/artregimenaction")
	public @ResponseBody List<MasterDto> getAllMasterArtRegimenAction() {
		return masterCstDataService.getAllMasterArtRegimenAction();
	}
	
	@GetMapping("/artregimenactionreason/{actionId}")
	public @ResponseBody List<MasterDto> getAllMasterArtRegimenActionReasonsByActionId(
			@PathVariable("actionId") Long actionId) {
		return masterCstDataService.getAllMasterArtRegimenActionReasonsByActionId(actionId);
	}

}
