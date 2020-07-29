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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.TIBenRVAssessmentCriteria;
import gov.naco.soch.ti.dto.TIBenRVAssessmentDTO;
import gov.naco.soch.ti.dto.readonly.RvAssessmentDto;
import gov.naco.soch.ti.queryservice.RVAssessmentQueryService;
import gov.naco.soch.ti.service.TIBenRVAssessmentQueryService;
import gov.naco.soch.ti.service.TIBenRVAssessmentServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenRVAssessment}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenRVAssessmentResource {

    private final Logger log = LoggerFactory.getLogger(TIBenRVAssessmentResource.class);

    private static final String ENTITY_NAME = "tIBenRVAssessment";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenRVAssessmentServiceImpl tIBenRVAssessmentService;

    private final TIBenRVAssessmentQueryService tIBenRVAssessmentQueryService;
    
    private final RVAssessmentQueryService rvAssessmentQueryService ;

    public TIBenRVAssessmentResource(TIBenRVAssessmentServiceImpl tIBenRVAssessmentService,
	    TIBenRVAssessmentQueryService tIBenRVAssessmentQueryService,RVAssessmentQueryService rvAssessmentQueryService) {
	this.tIBenRVAssessmentService = tIBenRVAssessmentService;
	this.tIBenRVAssessmentQueryService = tIBenRVAssessmentQueryService;
	this.rvAssessmentQueryService=rvAssessmentQueryService;
    }

    /**
     * {@code POST  /ti-ben-rv-assessments} : Create a new tIBenRVAssessment.
     *
     * @param tIBenRVAssessmentDTO the tIBenRVAssessmentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIBenRVAssessmentDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenRVAssessment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-rv-assessments")
    public ResponseEntity<TIBenRVAssessmentDTO> createTIBenRVAssessment(
	    @Valid @RequestBody TIBenRVAssessmentDTO tIBenRVAssessmentDTO) throws URISyntaxException {
	log.debug("REST request to save TIBenRVAssessment : {}", tIBenRVAssessmentDTO);
	if (tIBenRVAssessmentDTO.getId() != null) {
	    throw new BadRequestAlertException("A new tIBenRVAssessment cannot already have an ID", ENTITY_NAME,
		    "idexists");
	}
	boolean check = tIBenRVAssessmentService.validateMultipleAssessment(tIBenRVAssessmentDTO.getBeneficiary().getId(),
		tIBenRVAssessmentDTO.getAssessmentDate());
	if (!check) {
	    throw new BadRequestAlertException("Assessment for this client already recorded for this quarter",
		    ENTITY_NAME, "13");
	}
	TIBenRVAssessmentDTO result = tIBenRVAssessmentService.save(tIBenRVAssessmentDTO);
	return ResponseEntity
		.created(new URI("/api/ti-ben-rv-assessments/" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    /**
     * {@code PUT  /ti-ben-rv-assessments} : Updates an existing tIBenRVAssessment.
     *
     * @param tIBenRVAssessmentDTO the tIBenRVAssessmentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIBenRVAssessmentDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenRVAssessmentDTO is not valid,
     *         or with status {@code 500 (Internal Server Error)} if the
     *         tIBenRVAssessmentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-rv-assessments")
    public ResponseEntity<TIBenRVAssessmentDTO> updateTIBenRVAssessment(
	    @Valid @RequestBody TIBenRVAssessmentDTO tIBenRVAssessmentDTO) throws URISyntaxException {
	log.debug("REST request to update TIBenRVAssessment : {}", tIBenRVAssessmentDTO);
	if (tIBenRVAssessmentDTO.getId() == null) {
	    throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
	}
	boolean check = tIBenRVAssessmentService.validateMultipleAssessment(tIBenRVAssessmentDTO.getBeneficiary().getId(),
		tIBenRVAssessmentDTO.getAssessmentDate());
	if (!check) {
	    throw new BadRequestAlertException("Assessment for this client already recorded for this quarter",
		    ENTITY_NAME, "13");
	}
	TIBenRVAssessmentDTO result = tIBenRVAssessmentService.save(tIBenRVAssessmentDTO);
	return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME,
		tIBenRVAssessmentDTO.getId().toString())).body(result);
    }

    /**
     * {@code GET  /ti-ben-rv-assessments} : get all the tIBenRVAssessments.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenRVAssessments in body.
     */
    @GetMapping("/ti-ben-rv-assessments")
    public ResponseEntity<List<TIBenRVAssessmentDTO>> getAllTIBenRVAssessments(TIBenRVAssessmentCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenRVAssessments by criteria: {}", criteria);
	Page<TIBenRVAssessmentDTO> page = tIBenRVAssessmentQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenRVAssessmentQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/v1/ti-ben-rv-assessments")
    public ResponseEntity<List<RvAssessmentDto>> getTIBenRVAssessments(TIBenRVAssessmentCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenRVAssessments by criteria: {}", criteria);
	Page<RvAssessmentDto> page = rvAssessmentQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenRVAssessmentQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-rv-assessments} : get all the tIBenRVAssessments.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenRVAssessments in body.
     */
    @GetMapping("/ti-ben-rv-assessments/search")
    public ResponseEntity<List<TIBenRVAssessmentDTO>> searchTIBenRVAssessments(TIBenRVAssessmentCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenRVAssessments by criteria: {}", criteria);
	Page<TIBenRVAssessmentDTO> page = tIBenRVAssessmentQueryService.searchByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenRVAssessmentQueryService.countBySearchCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-rv-assessments/count} : count all the tIBenRVAssessments.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-ben-rv-assessments/count")
    public ResponseEntity<Long> countTIBenRVAssessments(TIBenRVAssessmentCriteria criteria) {
	log.debug("REST request to count TIBenRVAssessments by criteria: {}", criteria);
	return ResponseEntity.ok().body(tIBenRVAssessmentQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-rv-assessments/:id} : get the "id" tIBenRVAssessment.
     *
     * @param id the id of the tIBenRVAssessmentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIBenRVAssessmentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-rv-assessments/{id}")
    public ResponseEntity<TIBenRVAssessmentDTO> getTIBenRVAssessment(@PathVariable Long id) {
	log.debug("REST request to get TIBenRVAssessment : {}", id);
	Optional<TIBenRVAssessmentDTO> tIBenRVAssessmentDTO = tIBenRVAssessmentService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIBenRVAssessmentDTO);
    }

    /**
     * {@code DELETE  /ti-ben-rv-assessments/:id} : delete the "id"
     * tIBenRVAssessment.
     *
     * @param id the id of the tIBenRVAssessmentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @PostMapping("/ti-ben-rv-assessments/{id}")
    public ResponseEntity<Void> deleteTIBenRVAssessment(@PathVariable Long id) {
	log.debug("REST request to delete TIBenRVAssessment : {}", id);
	tIBenRVAssessmentService.delete(id);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }
}
