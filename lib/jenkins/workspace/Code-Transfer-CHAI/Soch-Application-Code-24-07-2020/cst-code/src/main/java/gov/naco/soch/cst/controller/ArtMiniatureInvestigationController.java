package gov.naco.soch.cst.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ARTDashboardRequestDTO;
import gov.naco.soch.cst.dto.InvestigationDetailsDto;
import gov.naco.soch.cst.dto.MasterInvestigationDto;
import gov.naco.soch.cst.dto.ProfileTableDataDto;
import gov.naco.soch.cst.service.ArtMiniatureInvestigationService;

@RestController
@RequestMapping("/art/miniature")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtMiniatureInvestigationController {
	
	@Autowired
	private ArtMiniatureInvestigationService artMiniatureInvestigationService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArtMiniatureInvestigationController.class);
	
	@GetMapping("/count-of-investigations")
	public ResponseEntity<InvestigationDetailsDto> getInvestigationDetails(@RequestParam(required = true) Long beneficiaryId,
                                                                                 @RequestParam(required = true) Long facilityId, 
                                                                                 @RequestParam(required = true) Long investigationId) {
		InvestigationDetailsDto investigationDetailsDto = new InvestigationDetailsDto();
		try {
			investigationDetailsDto = artMiniatureInvestigationService.getInvestigationDetails(beneficiaryId,facilityId,investigationId);
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<InvestigationDetailsDto>(investigationDetailsDto, HttpStatus.OK);
	}
	
	@GetMapping("/masterinvestigation")
	public ResponseEntity<List<MasterInvestigationDto>> getmasterInvestigation(){
		
		List<MasterInvestigationDto> masterInvestigationDto = new ArrayList<>();
		try {
			masterInvestigationDto = artMiniatureInvestigationService.getmasterInvestigation();
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<MasterInvestigationDto>>(masterInvestigationDto, HttpStatus.OK);
		
	}

}
