package gov.naco.soch.cst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.CounsellingDto;
import gov.naco.soch.cst.service.ArtBeneficiaryCounsellingNoteService;

@RestController
@RequestMapping("/counselling-note")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryCounsellingNoteController {

	@Autowired
	private ArtBeneficiaryCounsellingNoteService counsellingNoteService;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryCounsellingNoteController.class);

	@GetMapping("/list/{beneficiaryId}")
	public CounsellingDto getCounsellingNoteList(@PathVariable("beneficiaryId") Long beneficiaryId) {
		logger.info("getCounsellingNoteList method is invoked");
		return counsellingNoteService.getAllCounsellingNotes(beneficiaryId);

	}

	@RequestMapping("/save")
	public CounsellingDto saveCounsellingNote(@RequestBody CounsellingDto counsellingDto) {
		logger.debug("saveCounsellingNote method is invoked");
		counsellingNoteService.saveCounsellingNote(counsellingDto);
		logger.debug("saveBeneficiary method returns with parameters->{}", counsellingDto);
		return counsellingDto;

	}

}
