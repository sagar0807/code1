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

import gov.naco.soch.ti.dto.TIOstAssessCriteria;
import gov.naco.soch.ti.dto.TIOstAssessDTO;
import gov.naco.soch.ti.dto.readonly.OstAssessmentDto;
import gov.naco.soch.ti.queryservice.OstAssessmentQueryService;
import gov.naco.soch.ti.service.TIOstAssessQueryService;
import gov.naco.soch.ti.service.TIOstAssessServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIOstAssess}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIOstAssessResource {

    private final Logger log = LoggerFactory.getLogger(TIOstAssessResource.class);

    private static final String ENTITY_NAME = "tIOstAssess";

    private static final String APPLICATION_NAME = "TI";

    private final TIOstAssessServiceImpl tIOstAssessService;

    private final TIOstAssessQueryService tIOstAssessQueryService;
    
    private final OstAssessmentQueryService ostAssessQueryService;

    public TIOstAssessResource(TIOstAssessServiceImpl tIOstAssessService,
	    TIOstAssessQueryService tIOstAssessQueryService,OstAssessmentQueryService ostAssessQueryService) {
	this.tIOstAssessService = tIOstAssessService;
	this.tIOstAssessQueryService = tIOstAssessQueryService;
	this.ostAssessQueryService=ostAssessQueryService;
    }

    /**
     * {@code POST  /ti-ost-assesses} : Create a new tIOstAssess.
     *
     * @param tIOstAssessDTO the tIOstAssessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIOstAssessDTO, or with status {@code 400 (Bad Request)}
     *         if the tIOstAssess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ost-assesses")
    public ResponseEntity<TIOstAssessDTO> createTIOstAssess(@Valid @RequestBody TIOstAssessDTO tIOstAssessDTO)
	    throws URISyntaxException {
	log.debug("REST request to save TIOstAssess : {}", tIOstAssessDTO);
	if (tIOstAssessDTO.getId() != null) {
	    throw new BadRequestAlertException("A new tIOstAssess cannot already have an ID", ENTITY_NAME, "idexists");
	}
	boolean check = tIOstAssessService.validateOstNumberForExistingBeneficiary(
		tIOstAssessDTO.getTiOstBeneficiary().getOstNumber(), tIOstAssessDTO.getTiOstBeneficiary().getId(),
		tIOstAssessDTO.getTiOstBeneficiary().getFacility().getId());
	if (check == false) {
	    throw new BadRequestAlertException("Ost Number already exists", ENTITY_NAME, "2");

	}
	TIOstAssessDTO result = tIOstAssessService.save(tIOstAssessDTO);
	return ResponseEntity
		.created(new URI("/api/ti-ost-assesses/" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    /**
     * {@code PUT  /ti-ost-assesses} : Updates an existing tIOstAssess.
     *
     * @param tIOstAssessDTO the tIOstAssessDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIOstAssessDTO, or with status {@code 400 (Bad Request)}
     *         if the tIOstAssessDTO is not valid, or with status
     *         {@code 500 (Internal Server Error)} if the tIOstAssessDTO couldn't be
     *         updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ost-assesses")
    public ResponseEntity<TIOstAssessDTO> updateTIOstAssess(@Valid @RequestBody TIOstAssessDTO tIOstAssessDTO)
	    throws URISyntaxException {
	log.debug("REST request to update TIOstAssess : {}", tIOstAssessDTO);
	if (tIOstAssessDTO.getId() == null) {
	    throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
	}
	boolean check = tIOstAssessService.validateOstNumberForExistingBeneficiary(
		tIOstAssessDTO.getTiOstBeneficiary().getOstNumber(), tIOstAssessDTO.getTiOstBeneficiary().getId(),
		tIOstAssessDTO.getTiOstBeneficiary().getFacility().getId());
	if (check == false) {
	    throw new BadRequestAlertException("Ost Number already exists", ENTITY_NAME, "2");

	}
	TIOstAssessDTO result = tIOstAssessService.update(tIOstAssessDTO);
	return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME,
		tIOstAssessDTO.getId().toString())).body(result);
    }

    /**
     * {@code GET  /ti-ost-assesses} : get all the tIOstAssesses.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIOstAssesses in body.
     */
    @GetMapping("/ti-ost-assesses")
    public ResponseEntity<List<TIOstAssessDTO>> getAllTIOstAssesses(TIOstAssessCriteria criteria, Pageable pageable) {
	log.debug("REST request to get TIOstAssesses by criteria: {}", criteria);
	Page<TIOstAssessDTO> page = tIOstAssessQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIOstAssessQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/v1/ti-ost-assesses")
    public ResponseEntity<List<OstAssessmentDto>> getTIOstAssesses(TIOstAssessCriteria criteria, Pageable pageable) {
	log.debug("REST request to get TIOstAssesses by criteria: {}", criteria);
	Page<OstAssessmentDto> page = ostAssessQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = ostAssessQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ost-assesses} : get all the tIOstAssesses.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIOstAssesses in body.
     */
    @GetMapping("/ti-ost-assesses/search")
    public ResponseEntity<List<TIOstAssessDTO>> searchAllTIOstAssesses(TIOstAssessCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIOstAssesses by criteria: {}", criteria);
	Page<TIOstAssessDTO> page = tIOstAssessQueryService.searchByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIOstAssessQueryService.countBySearchCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ost-assesses/count} : count all the tIOstAssesses.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-ost-assesses/count")
    public ResponseEntity<Long> countTIOstAssesses(TIOstAssessCriteria criteria) {
	log.debug("REST request to count TIOstAssesses by criteria: {}", criteria);
	return ResponseEntity.ok().body(tIOstAssessQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ost-assesses/:id} : get the "id" tIOstAssess.
     *
     * @param id the id of the tIOstAssessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIOstAssessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ost-assesses/{id}")
    public ResponseEntity<TIOstAssessDTO> getTIOstAssess(@PathVariable Long id) {
	log.debug("REST request to get TIOstAssess : {}", id);
	Optional<TIOstAssessDTO> tIOstAssessDTO = tIOstAssessService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIOstAssessDTO);
    }

    /**
     * {@code DELETE  /ti-ost-assesses/:id} : delete the "id" tIOstAssess.
     *
     * @param id the id of the tIOstAssessDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ost-assesses/{id}")
    public ResponseEntity<Void> deleteTIOstAssess(@PathVariable Long id) {
	log.debug("REST request to delete TIOstAssess : {}", id);
	tIOstAssessService.delete(id);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }
}
