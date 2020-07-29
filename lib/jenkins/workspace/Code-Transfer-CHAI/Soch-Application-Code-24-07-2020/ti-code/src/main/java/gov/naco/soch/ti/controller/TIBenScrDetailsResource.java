package gov.naco.soch.ti.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.TIBenScrDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO;
import gov.naco.soch.ti.dto.readonly.ScreeningDto;
import gov.naco.soch.ti.queryservice.ScreeningQueryService;
import gov.naco.soch.ti.service.TIBenScrDetailsQueryService;
import gov.naco.soch.ti.service.TIBenScrDetailsServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenScrDetails}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenScrDetailsResource {

    private final Logger log = LoggerFactory.getLogger(TIBenScrDetailsResource.class);

    private static final String ENTITY_NAME = "tIBenScrDetails";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenScrDetailsServiceImpl tIBenScrDetailsService;

    private final TIBenScrDetailsQueryService tIBenScrDetailsQueryService;

    private final ScreeningQueryService screeningQueryService;

    public TIBenScrDetailsResource(TIBenScrDetailsServiceImpl tIBenScrDetailsService,
	    TIBenScrDetailsQueryService tIBenScrDetailsQueryService, ScreeningQueryService screeningQueryService) {
	this.tIBenScrDetailsService = tIBenScrDetailsService;
	this.tIBenScrDetailsQueryService = tIBenScrDetailsQueryService;
	this.screeningQueryService = screeningQueryService;
    }

    /**
     * {@code POST  /ti-ben-scr-details} : Create a new tIBenScrDetails.
     *
     * @param tIBenScrDetailsDTO the tIBenScrDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIBenScrDetailsDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenScrDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-scr-details")
    public ResponseEntity<TIBenScrDetailsDTO> createTIBenScrDetails(
	    @Valid @RequestBody TIBenScrDetailsDTO tIBenScrDetailsDTO) throws URISyntaxException {
	log.debug("REST request to save TIBenScrDetails : {}", tIBenScrDetailsDTO);
	if (tIBenScrDetailsDTO.getId() != null) {
	    throw new BadRequestAlertException("A new tIBenScrDetails cannot already have an ID", ENTITY_NAME,
		    "idexists");
	}
	boolean check = tIBenScrDetailsService.validateMultipleScreening(tIBenScrDetailsDTO.getBeneficiary().getId(),
		tIBenScrDetailsDTO.getInfection().getId(),tIBenScrDetailsDTO.getDateOfScreening());
	if (!check) {
	    throw new BadRequestAlertException("Screening for this client already recorded for this quarter",
		    ENTITY_NAME, "12");
	}
	TIBenScrDetailsDTO result = tIBenScrDetailsService.save(tIBenScrDetailsDTO);
	return ResponseEntity
		.created(new URI("/api/ti-ben-scr-details/" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    /**
     * {@code PUT  /ti-ben-scr-details} : Updates an existing tIBenScrDetails.
     *
     * @param tIBenScrDetailsDTO the tIBenScrDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIBenScrDetailsDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenScrDetailsDTO is not valid, or
     *         with status {@code 500 (Internal Server Error)} if the
     *         tIBenScrDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-scr-details")
    public ResponseEntity<TIBenScrDetailsDTO> updateTIBenScrDetails(
	    @Valid @RequestBody TIBenScrDetailsDTO tIBenScrDetailsDTO) throws URISyntaxException {
	log.debug("REST request to update TIBenScrDetails : {}", tIBenScrDetailsDTO);
	if (tIBenScrDetailsDTO.getId() == null) {
	    throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
	}
	boolean check = tIBenScrDetailsService.validateMultipleScreening(tIBenScrDetailsDTO.getBeneficiary().getId(),
		tIBenScrDetailsDTO.getInfection().getId(),tIBenScrDetailsDTO.getDateOfScreening());
	if (!check) {
	    throw new BadRequestAlertException("Screening for this client already recorded for this quarter",
		    ENTITY_NAME, "12");
	}
	TIBenScrDetailsDTO result = tIBenScrDetailsService.save(tIBenScrDetailsDTO);
	return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME,
		tIBenScrDetailsDTO.getId().toString())).body(result);
    }

    /**
     * {@code GET  /ti-ben-scr-details} : get all the tIBenScrDetails.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenScrDetails in body.
     */
    @GetMapping("/ti-ben-scr-details")
    public ResponseEntity<List<TIBenScrDetailsDTO>> getAllTIBenScrDetails(TIBenScrDetailsCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenScrDetails by criteria: {}", criteria);
	Page<TIBenScrDetailsDTO> page = tIBenScrDetailsQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenScrDetailsQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/v1/ti-ben-scr-details")
    public ResponseEntity<List<ScreeningDto>> getTIBenScrDetails(TIBenScrDetailsCriteria criteria, Pageable pageable) {
	log.debug("REST request to get TIBenScrDetails by criteria: {}", criteria);
	Page<ScreeningDto> page = screeningQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenScrDetailsQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-scr-details} : get all the tIBenScrDetails.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenScrDetails in body.
     */
    @GetMapping("/ti-ben-scr-details/search")
    public ResponseEntity<List<TIBenScrDetailsDTO>> searchAllTIBenScrDetails(TIBenScrDetailsCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenScrDetails by criteria: {}", criteria);
	Page<TIBenScrDetailsDTO> page = tIBenScrDetailsQueryService.searchByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenScrDetailsQueryService.countBySearchCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-scr-details/count} : count all the tIBenScrDetails.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-ben-scr-details/count")
    public ResponseEntity<Long> countTIBenScrDetails(TIBenScrDetailsCriteria criteria) {
	log.debug("REST request to count TIBenScrDetails by criteria: {}", criteria);
	return ResponseEntity.ok().body(screeningQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-scr-details/:id} : get the "id" tIBenScrDetails.
     *
     * @param id the id of the tIBenScrDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIBenScrDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-scr-details/{id}")
    public ResponseEntity<TIBenScrDetailsDTO> getTIBenScrDetails(@PathVariable Long id) {
	log.debug("REST request to get TIBenScrDetails : {}", id);
	Optional<TIBenScrDetailsDTO> tIBenScrDetailsDTO = tIBenScrDetailsService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIBenScrDetailsDTO);
    }

    /**
     * {@code DELETE  /ti-ben-scr-details/:id} : delete the "id" tIBenScrDetails.
     *
     * @param id the id of the tIBenScrDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-scr-details/{id}")
    public ResponseEntity<Void> deleteTIBenScrDetails(@PathVariable Long id) {
	log.debug("REST request to delete TIBenScrDetails : {}", id);
	tIBenScrDetailsService.delete(id);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }

    @GetMapping("/ti-ben-scr-details/beneficiary/{beneficiaryId}")
    public ResponseEntity<List<TIBenScrDetailsDTO>> getTIBenScrDetailsByBeneficiary(@PathVariable Long beneficiaryId) {
	log.debug("REST request to get TIBenScrDetailsByBeneficiary : {}", beneficiaryId);
	List<TIBenScrDetailsDTO> screeningList = tIBenScrDetailsService
		.findScreeningDetailsByBeneficiary(beneficiaryId);
	return ResponseEntity.ok().body(screeningList);
    }

    @GetMapping("/ti-ben-scr-details/{beneficiaryId}/{infectionId}")
    public Long getByDiagnosisAndBeneficiary(@PathVariable("beneficiaryId") Long beneficiaryId,
	    @PathVariable("infectionId") Long infectionId) {
	log.debug("REST request to get details by infection and beneficiary: {}", infectionId, beneficiaryId);
	return tIBenScrDetailsService.findByInfectionAndBeneficiary(infectionId, beneficiaryId);
    }

}
