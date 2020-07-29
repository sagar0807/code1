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

import gov.naco.soch.ti.dto.TIBenFollowUpCriteria;
import gov.naco.soch.ti.dto.TIBenFollowUpDTO;
import gov.naco.soch.ti.dto.readonly.OstFollowUpDto;
import gov.naco.soch.ti.queryservice.OstFollowUpQueryService;
import gov.naco.soch.ti.service.TIBenFollowUpQueryService;
import gov.naco.soch.ti.service.TIBenFollowUpServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenFollowUp}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenFollowUpResource {

    private final Logger log = LoggerFactory.getLogger(TIBenFollowUpResource.class);

    private static final String ENTITY_NAME = "tIBenFollowUp";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenFollowUpServiceImpl tIBenFollowUpService;

    private final TIBenFollowUpQueryService tIBenFollowUpQueryService;
    
    private final OstFollowUpQueryService ostFollowUpQueryService;

    public TIBenFollowUpResource(TIBenFollowUpServiceImpl tIBenFollowUpService,
	    TIBenFollowUpQueryService tIBenFollowUpQueryService,OstFollowUpQueryService ostFollowUpQueryService) {
	this.tIBenFollowUpService = tIBenFollowUpService;
	this.tIBenFollowUpQueryService = tIBenFollowUpQueryService;
	this.ostFollowUpQueryService=ostFollowUpQueryService;
    }

    /**
     * {@code POST  /ti-ben-follow-ups} : Create a new tIBenFollowUp.
     *
     * @param tIBenFollowUpDTO the tIBenFollowUpDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIBenFollowUpDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenFollowUp has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-follow-ups")
    public ResponseEntity<TIBenFollowUpDTO> createTIBenFollowUp(@Valid @RequestBody TIBenFollowUpDTO tIBenFollowUpDTO)
	    throws URISyntaxException {
	log.debug("REST request to save TIBenFollowUp : {}", tIBenFollowUpDTO);
	if (tIBenFollowUpDTO.getId() != null) {
	    throw new BadRequestAlertException("A new tIBenFollowUp cannot already have an ID", ENTITY_NAME,
		    "idexists");
	}
	TIBenFollowUpDTO result = tIBenFollowUpService.save(tIBenFollowUpDTO);
	return ResponseEntity
		.created(new URI("/api/ti-ben-follow-ups/" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    /**
     * {@code PUT  /ti-ben-follow-ups} : Updates an existing tIBenFollowUp.
     *
     * @param tIBenFollowUpDTO the tIBenFollowUpDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIBenFollowUpDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenFollowUpDTO is not valid, or
     *         with status {@code 500 (Internal Server Error)} if the
     *         tIBenFollowUpDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-follow-ups")
    public ResponseEntity<TIBenFollowUpDTO> updateTIBenFollowUp(@Valid @RequestBody TIBenFollowUpDTO tIBenFollowUpDTO)
	    throws URISyntaxException {
	log.debug("REST request to update TIBenFollowUp : {}", tIBenFollowUpDTO);
	if (tIBenFollowUpDTO.getId() == null) {
	    throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
	}
	TIBenFollowUpDTO result = tIBenFollowUpService.update(tIBenFollowUpDTO);
	return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME,
		tIBenFollowUpDTO.getId().toString())).body(result);
    }

    /**
     * {@code GET  /ti-ben-follow-ups} : get all the tIBenFollowUps.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenFollowUps in body.
     */
    @GetMapping("/ti-ben-follow-ups")
    public ResponseEntity<List<TIBenFollowUpDTO>> getAllTIBenFollowUps(TIBenFollowUpCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenFollowUps by criteria: {}", criteria);
	Page<TIBenFollowUpDTO> page = tIBenFollowUpQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenFollowUpQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/v1/ti-ben-follow-ups")
    public ResponseEntity<List<OstFollowUpDto>> getTIBenFollowUps(TIBenFollowUpCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenFollowUps by criteria: {}", criteria);
	Page<OstFollowUpDto> page = ostFollowUpQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = ostFollowUpQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/ti-ben-follow-ups/search")
    public ResponseEntity<List<TIBenFollowUpDTO>> getAllTIBenFollowUpsSearch(TIBenFollowUpCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenFollowUps by criteria: {}", criteria);
	Page<TIBenFollowUpDTO> page = tIBenFollowUpQueryService.findByCriteriaSearch(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenFollowUpQueryService.countBySearchCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-follow-ups/count} : count all the tIBenFollowUps.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-ben-follow-ups/count")
    public ResponseEntity<Long> countTIBenFollowUps(TIBenFollowUpCriteria criteria) {
	log.debug("REST request to count TIBenFollowUps by criteria: {}", criteria);
	return ResponseEntity.ok().body(tIBenFollowUpQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-follow-ups/:id} : get the "id" tIBenFollowUp.
     *
     * @param id the id of the tIBenFollowUpDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIBenFollowUpDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-follow-ups/{id}")
    public ResponseEntity<TIBenFollowUpDTO> getTIBenFollowUp(@PathVariable Long id) {
	log.debug("REST request to get TIBenFollowUp : {}", id);
	Optional<TIBenFollowUpDTO> tIBenFollowUpDTO = tIBenFollowUpService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIBenFollowUpDTO);
    }

    /**
     * {@code DELETE  /ti-ben-follow-ups/:id} : delete the "id" tIBenFollowUp.
     *
     * @param id the id of the tIBenFollowUpDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-follow-ups/{id}")
    public ResponseEntity<Void> deleteTIBenFollowUp(@PathVariable Long id) {
	log.debug("REST request to delete TIBenFollowUp : {}", id);
	tIBenFollowUpService.delete(id);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }

}
