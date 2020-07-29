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

import gov.naco.soch.ti.dto.StiTreatmentDiagnosisDTO;
import gov.naco.soch.ti.dto.TIStiTreatmentCriteria;
import gov.naco.soch.ti.dto.TIStiTreatmentDTO;
import gov.naco.soch.ti.dto.readonly.StiTreatmentDto;
import gov.naco.soch.ti.queryservice.StiTreatmentQueryService;
import gov.naco.soch.ti.service.TIStiTreatmentQueryService;
import gov.naco.soch.ti.service.TIStiTreatmentServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIStiTreatment}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIStiTreatmentResource {

    private final Logger log = LoggerFactory.getLogger(TIStiTreatmentResource.class);

    private static final String ENTITY_NAME = "tIStiTreatment";

    private static final String APPLICATION_NAME = "TI";

    private final TIStiTreatmentServiceImpl tIStiTreatmentService;

    private final TIStiTreatmentQueryService tIStiTreatmentQueryService;
    
    private final StiTreatmentQueryService stiTreatmentQueryService;

 

    public TIStiTreatmentResource(TIStiTreatmentServiceImpl tIStiTreatmentService,
	    TIStiTreatmentQueryService tIStiTreatmentQueryService, StiTreatmentQueryService stiTreatmentQueryService) {
	this.tIStiTreatmentService = tIStiTreatmentService;
	this.tIStiTreatmentQueryService = tIStiTreatmentQueryService;
	this.stiTreatmentQueryService = stiTreatmentQueryService;
    }

    /**
     * {@code POST  /ti-sti-treatments} : Create a new tIStiTreatment.
     *
     * @param tIStiTreatmentDTO the tIStiTreatmentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIStiTreatmentDTO, or with status
     *         {@code 400 (Bad Request)} if the tIStiTreatment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-sti-treatments")
    public ResponseEntity<TIStiTreatmentDTO> createTIStiTreatment(
	    @Valid @RequestBody TIStiTreatmentDTO tIStiTreatmentDTO) throws URISyntaxException {
	log.debug("REST request to save TIStiTreatment : {}", tIStiTreatmentDTO);
	if (tIStiTreatmentDTO.getId() != null) {
	    throw new BadRequestAlertException("A new tIStiTreatment cannot already have an ID", ENTITY_NAME,
		    "idexists");
	}
	boolean check = false;
	check = tIStiTreatmentService.validateDiagnosis(tIStiTreatmentDTO.getBeneficiary().getId(),
		tIStiTreatmentDTO.getDiagnosisType().getId());
	if (check == true) {
	    throw new BadRequestAlertException("Infection already diagonised today", ENTITY_NAME, "4");
	}
	TIStiTreatmentDTO result = tIStiTreatmentService.save(tIStiTreatmentDTO);
	return ResponseEntity
		.created(new URI("/api/ti-sti-treatments/" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    /**
     * {@code PUT  /ti-sti-treatments} : Updates an existing tIStiTreatment.
     *
     * @param tIStiTreatmentDTO the tIStiTreatmentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIStiTreatmentDTO, or with status
     *         {@code 400 (Bad Request)} if the tIStiTreatmentDTO is not valid, or
     *         with status {@code 500 (Internal Server Error)} if the
     *         tIStiTreatmentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-sti-treatments")
    public ResponseEntity<TIStiTreatmentDTO> updateTIStiTreatment(
	    @Valid @RequestBody TIStiTreatmentDTO tIStiTreatmentDTO) throws URISyntaxException {
	log.debug("REST request to update TIStiTreatment : {}", tIStiTreatmentDTO);
	if (tIStiTreatmentDTO.getId() == null) {
	    throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
	}
	boolean check = false;
	check = tIStiTreatmentService.validateDiagnosis(tIStiTreatmentDTO.getBeneficiary().getId(),
		tIStiTreatmentDTO.getDiagnosisType().getId());
	if (check == true) {
	    throw new BadRequestAlertException("Infection already diagonised today", ENTITY_NAME, "4");
	}
	TIStiTreatmentDTO result = tIStiTreatmentService.save(tIStiTreatmentDTO);
	return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME,
		tIStiTreatmentDTO.getId().toString())).body(result);
    }

    /**
     * {@code GET  /ti-sti-treatments} : get all the tIStiTreatments.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIStiTreatments in body.
     */
    @GetMapping("/ti-sti-treatments")
    public ResponseEntity<List<TIStiTreatmentDTO>> getAllTIStiTreatments(TIStiTreatmentCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIStiTreatments by criteria: {}", criteria);
	Page<TIStiTreatmentDTO> page = tIStiTreatmentQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIStiTreatmentQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/v1/ti-sti-treatments")
    public ResponseEntity<List<StiTreatmentDto>> getTIStiTreatments(TIStiTreatmentCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIStiTreatments by criteria: {}", criteria);
	Page<StiTreatmentDto> page = stiTreatmentQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = stiTreatmentQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-sti-treatments/count} : count all the tIStiTreatments.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-sti-treatments/count")
    public ResponseEntity<Long> countTIStiTreatments(TIStiTreatmentCriteria criteria) {
	log.debug("REST request to count TIStiTreatments by criteria: {}", criteria);
	return ResponseEntity.ok().body(stiTreatmentQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-sti-treatments/:id} : get the "id" tIStiTreatment.
     *
     * @param id the id of the tIStiTreatmentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIStiTreatmentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-sti-treatments/{id}")
    public ResponseEntity<TIStiTreatmentDTO> getTIStiTreatment(@PathVariable Long id) {
	log.debug("REST request to get TIStiTreatment : {}", id);
	Optional<TIStiTreatmentDTO> tIStiTreatmentDTO = tIStiTreatmentService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIStiTreatmentDTO);
    }

    /**
     * {@code DELETE  /ti-sti-treatments/:id} : delete the "id" tIStiTreatment.
     *
     * @param id the id of the tIStiTreatmentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-sti-treatments/{id}")
    public ResponseEntity<Void> deleteTIStiTreatment(@PathVariable Long id) {
	log.debug("REST request to delete TIStiTreatment : {}", id);
	tIStiTreatmentService.delete(id);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }

    @GetMapping("/ti-sti-treatments/search")
    public ResponseEntity<List<TIStiTreatmentDTO>> getAllTIStiTreatmentsSearch(TIStiTreatmentCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIStiTreatments by criteria: {}", criteria);
	Page<TIStiTreatmentDTO> page = tIStiTreatmentQueryService.findByCriteriaSearch(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIStiTreatmentQueryService.countBySearchCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/ti-sti-treatments/{beneficiaryId}/{diagnosisId}")
    public StiTreatmentDiagnosisDTO getByDiagnosisAndBeneficiary(@PathVariable("beneficiaryId") Long beneficiaryId,
	    @PathVariable("diagnosisId") Long diagnosisId) {
	log.debug("REST request to get details by diagnosis id and beneficiary: {}", diagnosisId, beneficiaryId);
	return  tIStiTreatmentQueryService.findByDiagnosisAndBeneficiary(diagnosisId,
		beneficiaryId);
    }
}
