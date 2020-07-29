package gov.naco.soch.ti.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.dto.TiOstBeneficiaryDispensationDto;
import gov.naco.soch.dto.TiOstDispensationDto;
import gov.naco.soch.ti.dto.TiOstBeneficiaryDispensationCriteria;
import gov.naco.soch.ti.service.TiOstBeneficiaryDispensationQueryService;
import gov.naco.soch.ti.service.TiOstBeneficiaryDispensationService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.PaginationUtil;

/**
 * Controller class for managing ti_ost dispensation related APIs
 *
 */

@RestController
@RequestMapping("/dispensation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiOstBeneficiaryDispensationController {

	private static final Logger logger = LoggerFactory.getLogger(TiOstBeneficiaryDispensationController.class);

	@Autowired
	private TiOstBeneficiaryDispensationService tiOstBeneficiaryDispensationService;

	private TiOstBeneficiaryDispensationQueryService tiOstBeneficiaryDispensationQueryService;

	public TiOstBeneficiaryDispensationController(
			TiOstBeneficiaryDispensationQueryService tiOstBeneficiaryDispensationQueryService) {
		this.tiOstBeneficiaryDispensationQueryService = tiOstBeneficiaryDispensationQueryService;
	}

	/**
	 * method to get beneficiary details
	 * 
	 * @param facilityId,date
	 * @return ProductContractDto
	 */
	@GetMapping("/beneficiaries/{facilityId}")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getExpextedClientsForDispensation(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = true) LocalDate date, Pageable pageable) {
		logger.debug("getExpextedClientsForDispensation method is invoked");
		Boolean isTransit = Boolean.FALSE;
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationService
				.getExpectedClientsForDispensation(facilityId, drugType, name, date, isTransit, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@GetMapping("/beneficiaries/search/{facilityId}")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getExpextedClientsForDispensationSearch(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) LocalDate date,
			@RequestParam(value = "param", required = false) String param,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "ostNo", required = false) String ostNo,
			@RequestParam(value = "mobile", required = false) String mobile, Pageable pageable) {
		logger.debug("getExpextedClientsForDispensation method is invoked");
		Boolean isTransit = Boolean.FALSE;
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationService
				.getExpectedClientsForDispensationSearch(facilityId, drugType, name, date, isTransit, param, uid, ostNo,
						mobile, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());

	}

	/**
	 * method to get transit beneficiary details
	 * 
	 * @param facilityId,date
	 * @return ProductContractDto
	 */
	@GetMapping("/transitbeneficiaries/{facilityId}")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getTransitBeneficiariesForDispensation(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) LocalDate date, Pageable pageable) {
		logger.debug("getExpextedClientsForDispensation method is invoked");
		Boolean isTransit = Boolean.TRUE;
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationService
				.getExpectedClientsForDispensation(facilityId, drugType, name, date, isTransit, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);

		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * method to get transit beneficiary details based on search
	 * 
	 * @param facilityId,date
	 * @return ProductContractDto
	 */

	@GetMapping("/transitbeneficiaries/search/{facilityId}")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getTransitBeneficiariesForDispensationSearch(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) LocalDate date,
			@RequestParam(value = "param", required = false) String param,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "ostNo", required = false) String ostNo,
			@RequestParam(value = "mobile", required = false) String mobile, Pageable pageable) {
		logger.debug("getExpextedClientsForDispensation method is invoked");
		Boolean isTransit = Boolean.TRUE;
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationService
				.getExpectedClientsForDispensationSearch(facilityId, drugType, name, date, isTransit, param, uid, ostNo,
						mobile, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * saveDispatchDetails : Method to save dispatch details
	 * 
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 * 
	 */
	@PostMapping("/save")
	public TiOstDispensationDto saveDispensationDetails(@Valid @RequestBody TiOstDispensationDto tiOstDispensationDto) {
		logger.debug("saveDispensationDetails method is invoked");
		if (tiOstDispensationDto.isOk()) {
			return tiOstBeneficiaryDispensationService.saveDispensationDetails(tiOstDispensationDto);
		}
		int count = tiOstBeneficiaryDispensationService.validateClientStatus(tiOstDispensationDto.getBeneficiaries());
		if (count > 0) {
			String x = count == 1 ? "beneficiary" : "beneficiaries";
			StringBuilder warningMessage = new StringBuilder(
					"Client status for " + count + " " + x + " has been changed from active or relapse state");
			tiOstDispensationDto.setWarningMessage(warningMessage.toString());
			return tiOstDispensationDto;
		} else {
			return tiOstBeneficiaryDispensationService.saveDispensationDetails(tiOstDispensationDto);
		}
	}

	/**
	 * method to get beneficiary details
	 * 
	 * @param facilityId,date
	 * @return ProductContractDto
	 */
	@GetMapping("/list/{facilityId}")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getTodaysDispensedBeneficiaryList(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = true) LocalDate date, Pageable pageable) {
		logger.debug("getTodaysDispensedBeneficiaryList method is invoked");
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationService
				.getTodaysDispensedBeneficiaryList(facilityId, drugType, name, date, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);

		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@GetMapping("/list/search/{facilityId}")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getTodaysDispensedBeneficiaryListSearch(
			@PathVariable("facilityId") Long facilityId,
			@RequestParam(value = "drugType", required = true) String drugType,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "date", required = false) LocalDate date,
			@RequestParam(value = "param", required = false) String param,
			@RequestParam(value = "uid", required = false) String uid,
			@RequestParam(value = "ostNo", required = false) String ostNo,
			@RequestParam(value = "mobile", required = false) String mobile, Pageable pageable) {
		logger.debug("getTodaysDispensedBeneficiaryList method is invoked");
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationService
				.getTodaysDispensedBeneficiaryListSearch(facilityId, drugType, name, date, param, uid, ostNo, mobile,
						pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@GetMapping("/beneficiaries")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getBeneficiaryList(
			TiOstBeneficiaryDispensationCriteria criteria, Pageable pageable) {
		logger.debug("getExpextedClientsForDispensation method is invoked");
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationQueryService.findByCriteria(criteria,
				pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		long totalCount = tiOstBeneficiaryDispensationQueryService.countByCriteria(criteria);
		if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		}
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TiOstBeneficiaryDispensationDto>> getTodaysDispensedBenList(
			TiOstBeneficiaryDispensationCriteria criteria, Pageable pageable) {
		logger.debug("getTodaysDispensedBeneficiaryList method is invoked");
		Page<TiOstBeneficiaryDispensationDto> page = tiOstBeneficiaryDispensationQueryService
				.findByCriteriaForTodaysDispensation(criteria, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		long totalCount = tiOstBeneficiaryDispensationQueryService.countByCriteriaForTodaysDispensation(criteria);
		if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		}

		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}


}
