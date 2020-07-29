package gov.naco.soch.cst.controller;

import java.util.List;

import javax.validation.Valid;

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

import gov.naco.soch.cst.dto.ArtBeneficiaryDispensationDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryDispensationListDto;
import gov.naco.soch.cst.dto.TodaysDispensedDto;
import gov.naco.soch.cst.service.ArtBeneficiaryDispensationService;

/**
 * Controller class for managing ART-Beneficiary dispensation related APIs
 *
 */
@RestController
@RequestMapping("/dispense")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtBeneficiaryDispensationController {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryDispensationController.class);

	@Autowired
	private ArtBeneficiaryDispensationService artBeneficiaryDispensationService;

	/**
	 * API to get beneficiary details for dispensation
	 * 
	 * @param beneficiaryId
	 * @return ArtBeneficiaryDispensationDto
	 */
	@GetMapping("/beneficiarydetails/{beneficiaryId}")
	public ArtBeneficiaryDispensationListDto getBeneficiaryDetailsForDispensation(
			@Valid @PathVariable("beneficiaryId") Long beneficiaryId) {
		logger.debug("getBeneficiaryDetailsForDispensation() method is invoked");
		ArtBeneficiaryDispensationListDto beneficiaryDetails = artBeneficiaryDispensationService
				.getBeneficiaryDetailsForDispensation(beneficiaryId);
		logger.debug("getBeneficiaryDetailsForDispensation() method returns with parameters->{}" + beneficiaryDetails);
		return beneficiaryDetails;
	}

	/**
	 * API to save dispensation details
	 * 
	 * @param artBeneficiaryDispensationDto
	 * @return ArtBeneficiaryDispensationDto
	 */
	@PostMapping("/save")
	public ArtBeneficiaryDispensationDto saveDispensationDetails(
			@Valid @RequestBody ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {

		logger.info("saveDispensationDetails method called with parameters->{}", artBeneficiaryDispensationDto);
		artBeneficiaryDispensationDto = artBeneficiaryDispensationService
				.saveDispensationDetails(artBeneficiaryDispensationDto);
		logger.info("saveDispensationDetails method returns with parameters->{}", artBeneficiaryDispensationDto);
		return artBeneficiaryDispensationDto;
	}

	/**
	 * API to save PEP dispensation details
	 * 
	 * @param artBeneficiaryDispensationDto
	 * @return ArtBeneficiaryDispensationDto
	 */
	@PostMapping("/pep/save")
	public ArtBeneficiaryDispensationDto savePepDispensation(
			@Valid @RequestBody ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {

		logger.info("savePepDispensation method called with parameters->{}", artBeneficiaryDispensationDto);
		artBeneficiaryDispensationDto = artBeneficiaryDispensationService
				.savePepDispensation(artBeneficiaryDispensationDto);
		logger.info("savePepDispensation method returns with parameters->{}", artBeneficiaryDispensationDto);
		return artBeneficiaryDispensationDto;
	}

	/**
	 * API to get todays dispensed details
	 * 
	 * @param facilityId
	 * @return List<TodaysDispensedDto>
	 */
	@GetMapping("/todaysdispensedlist/{facilityId}")
	public List<TodaysDispensedDto> getTodaysDispensedList(@Valid @PathVariable("facilityId") Long facilityId) {
		logger.debug("getTodaysDispensedList() method is invoked");
		List<TodaysDispensedDto> todaysDispensedDtos = artBeneficiaryDispensationService
				.getTodaysDispensedList(facilityId);
		logger.debug("getTodaysDispensedList() method returns with parameters->{}" + todaysDispensedDtos);
		return todaysDispensedDtos;
	}

	/**
	 * API to get todays dispensed details
	 * 
	 * @param facilityId
	 * @return List<TodaysDispensedDto>
	 */
	@GetMapping("/todaysdispensedlist/search/{facilityId}")
	public List<TodaysDispensedDto> getTodaysDispensedListBySearch(@Valid @PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "artNumber", required = false) String artNumber,
			@RequestParam(value = "preArtNumber", required = false) String preArtNumber,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "pepName", required = false) String pepName,
			@RequestParam(value = "pepNumber", required = false) String pepNumber) {
		logger.debug("getTodaysDispensedListBySearch() method is invoked");
		List<TodaysDispensedDto> todaysDispensedDtos = artBeneficiaryDispensationService
				.getTodaysDispensedListBySearch(facilityId, name, artNumber, preArtNumber, uid,pepName,pepNumber);
		logger.debug("getTodaysDispensedListBySearch() method returns with parameters->{}" + todaysDispensedDtos);
		return todaysDispensedDtos;
	}

	/**
	 * API to save product returned from beneficiary
	 * 
	 * @param artBeneficiaryDispensationDto
	 * @return ArtBeneficiaryDispensationDto
	 */
	@PostMapping("/return/save")
	public ArtBeneficiaryDispensationDto returnFromPatient(
			@Valid @RequestBody ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {

		logger.info("returnFromPatient method called with parameters->{}", artBeneficiaryDispensationDto);
		artBeneficiaryDispensationDto = artBeneficiaryDispensationService
				.returnFromPatient(artBeneficiaryDispensationDto);
		logger.info("returnFromPatient method returns with parameters->{}", artBeneficiaryDispensationDto);
		return artBeneficiaryDispensationDto;
	}

}
