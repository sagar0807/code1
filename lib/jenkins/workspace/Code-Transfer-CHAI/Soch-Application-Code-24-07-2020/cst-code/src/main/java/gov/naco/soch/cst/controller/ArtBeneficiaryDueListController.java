package gov.naco.soch.cst.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.ArtBeneficiaryDueListDto;
import gov.naco.soch.cst.service.ArtBeneficiaryDueListService;

@RestController
@RequestMapping("/beneficiarydue")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryDueListController {
	@Autowired
	private ArtBeneficiaryDueListService artBeneficiaryDueListService;

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueController.class);

	@GetMapping("/duelistlhs")
	public @ResponseBody List<ArtBeneficiaryDueListDto> getAllBeneficiaryDueListLhs() {
		logger.debug("*getAllBeneficiaryDueListLhs is invoked*");
		return artBeneficiaryDueListService.getAllArtBeneficiaryDueListLhs();
	}

	@GetMapping("/duelistrhs")
	public @ResponseBody List<ArtBeneficiaryDueListDto> getAllBeneficiaryDueListRhs() {
		logger.debug("*getAllBeneficiaryDueListRhs is invoked*");
		return artBeneficiaryDueListService.getAllArtBeneficiaryDueListRhs();
	}

	@GetMapping("/todayslist")
	public @ResponseBody List<ArtBeneficiaryDueListDto> getAllBeneficiaryTodaysList(
			@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate fromDate,
			@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate toDate) {
		logger.debug("*getAllBeneficiaryTodaysList is invoked*");
		return artBeneficiaryDueListService.getBeneficiaryTodaysList(fromDate, toDate);
	}

	@GetMapping("/visitedduelist")
	public @ResponseBody List<ArtBeneficiaryDueListDto> getAllBeneficiaryVisitedList(
			@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate fromDate,
			@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate toDate) {
		logger.debug("*getAllBeneficiaryVisitedList is invoked*");
		return artBeneficiaryDueListService.getBeneficiaryVisitedList(fromDate, toDate);
	}

	@GetMapping("/missedduelist")
	public @ResponseBody List<ArtBeneficiaryDueListDto> getAllBeneficiaryMissedDueList(
			@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate fromDate,
			@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate toDate) {
		logger.debug("*getAllBeneficiaryMissedDueList is invoked*");
		return artBeneficiaryDueListService.getBeneficiaryMissedList(fromDate, toDate);
	}
}
