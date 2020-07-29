
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

import gov.naco.soch.ti.dto.TIBenCounsellingCriteria;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO;
import gov.naco.soch.ti.dto.readonly.CounsellingDto;
import gov.naco.soch.ti.queryservice.CounsellingQueryService;
import gov.naco.soch.ti.service.TIBenCounsellingQueryService;
import gov.naco.soch.ti.service.TIBenCounsellingService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenCounselling}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenCounsellingResource {

    private final Logger log = LoggerFactory.getLogger(TIBenCounsellingResource.class);

    private static final String ENTITY_NAME = "tIBenCounselling";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenCounsellingService tIBenCounsellingService;

    private final TIBenCounsellingQueryService tIBenCounsellingQueryService;
    
    private final CounsellingQueryService counsellingQueryService;

    public TIBenCounsellingResource(TIBenCounsellingService tIBenCounsellingService,
	    TIBenCounsellingQueryService tIBenCounsellingQueryService,CounsellingQueryService counsellingQueryService) {
	this.tIBenCounsellingService = tIBenCounsellingService;
	this.tIBenCounsellingQueryService = tIBenCounsellingQueryService;
	this.counsellingQueryService=counsellingQueryService;
    }

    /**
     * {@code POST  /ti-ben-counsellings} : Create a new tIBenCounselling.
     *
     * @param tIBenCounsellingDTO the tIBenCounsellingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIBenCounsellingDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenCounselling has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-counsellings")
    public ResponseEntity<TIBenCounsellingDTO> createTIBenCounselling(
	    @Valid @RequestBody TIBenCounsellingDTO tIBenCounsellingDTO) throws URISyntaxException {
	log.debug("REST request to save TIBenCounselling : {}", tIBenCounsellingDTO);
	if (tIBenCounsellingDTO.getId() != null) {
	    throw new BadRequestAlertException("A new tIBenCounselling cannot already have an ID", ENTITY_NAME,
		    "idexists");
	}
	  boolean check=tIBenCounsellingService.validateMultipleCounselling(tIBenCounsellingDTO.getBeneficiary().getId(),
		  tIBenCounsellingDTO.getCounsellingDate());
	        if(!check)
	        {
	            throw new BadRequestAlertException("Counselling for this client has already been recorded for this date" , ENTITY_NAME, "11");
	        }
	TIBenCounsellingDTO result = tIBenCounsellingService.save(tIBenCounsellingDTO);
	return ResponseEntity
		.created(new URI("/api/ti-ben-counsellings/" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    /**
     * {@code PUT  /ti-ben-counsellings} : Updates an existing tIBenCounselling.
     *
     * @param tIBenCounsellingDTO the tIBenCounsellingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIBenCounsellingDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBenCounsellingDTO is not valid, or
     *         with status {@code 500 (Internal Server Error)} if the
     *         tIBenCounsellingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-counsellings")
    public ResponseEntity<TIBenCounsellingDTO> updateTIBenCounselling(
	    @Valid @RequestBody TIBenCounsellingDTO tIBenCounsellingDTO) throws URISyntaxException {
	log.debug("REST request to update TIBenCounselling : {}", tIBenCounsellingDTO);
	if (tIBenCounsellingDTO.getId() == null) {
	    throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
	}
	TIBenCounsellingDTO result = tIBenCounsellingService.save(tIBenCounsellingDTO);
	return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME,
		tIBenCounsellingDTO.getId().toString())).body(result);
    }

    /**
     * {@code GET  /ti-ben-counsellings} : get all the tIBenCounsellings.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenCounsellings in body.
     */
    @GetMapping("/ti-ben-counsellings")
    public ResponseEntity<List<TIBenCounsellingDTO>> getAllTIBenCounsellings(TIBenCounsellingCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenCounsellings by criteria: {}", criteria);
	Page<TIBenCounsellingDTO> page = tIBenCounsellingQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenCounsellingQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/v1/ti-ben-counsellings")
    public ResponseEntity<List<CounsellingDto>> getTIBenCounsellings(TIBenCounsellingCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenCounsellings by criteria: {}", criteria);
	Page<CounsellingDto> page = counsellingQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = counsellingQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-counsellings/upcoming} : get all the upcoming
     * tIBenCounsellings.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenCounsellings in body.
     */

    @GetMapping("/ti-ben-counsellings/upcoming")
    public ResponseEntity<List<TIBenCounsellingDTO>> getAllUpcomTIBenCounsellings(TIBenCounsellingCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenCounsellings by criteria: {}", criteria);
	Page<TIBenCounsellingDTO> page = tIBenCounsellingQueryService.findByCriteriaUpcoming(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-counsellings/missed} : get all the missed
     * tIBenCounsellings.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenCounsellings in body.
     */

    @GetMapping("/ti-ben-counsellings/missed")
    public ResponseEntity<List<TIBenCounsellingDTO>> getAllMissedTIBenCounsellings(TIBenCounsellingCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenCounsellings by criteria: {}", criteria);
	Page<TIBenCounsellingDTO> page = tIBenCounsellingQueryService.findByCriteriaMissed(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-ben-counsellings/count} : count all the tIBenCounsellings.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-ben-counsellings/count")
    public ResponseEntity<Long> countTIBenCounsellings(TIBenCounsellingCriteria criteria) {
	log.debug("REST request to count TIBenCounsellings by criteria: {}", criteria);
	return ResponseEntity.ok().body(tIBenCounsellingQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-counsellings/:id} : get the "id" tIBenCounselling.
     *
     * @param id the id of the tIBenCounsellingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIBenCounsellingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-counsellings/{id}")
    public ResponseEntity<TIBenCounsellingDTO> getTIBenCounselling(@PathVariable Long id) {
	log.debug("REST request to get TIBenCounselling : {}", id);
	Optional<TIBenCounsellingDTO> tIBenCounsellingDTO = tIBenCounsellingService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIBenCounsellingDTO);
    }

    /**
     * {@code DELETE  /ti-ben-counsellings/:id} : delete the "id" tIBenCounselling.
     *
     * @param id the id of the tIBenCounsellingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @PostMapping("/ti-ben-counsellings/{id}")
    public ResponseEntity<Void> deleteTIBenCounselling(@PathVariable("id") Long id) {
	log.debug("REST request to delete TIBenCounselling : {}", id);
	tIBenCounsellingService.delete(id);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }

    /**
     * {@code GET  /ti-ben-counsellings/search} : search ti-ben-counselling records
     * based on given criteria
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBenCounsellings in body.
     */
    @GetMapping("/ti-ben-counsellings/search")
    public ResponseEntity<List<TIBenCounsellingDTO>> searchTIBenCounsellings(TIBenCounsellingCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBenCounsellings by criteria: {}", criteria);
	Page<TIBenCounsellingDTO> page = tIBenCounsellingQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBenCounsellingQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
