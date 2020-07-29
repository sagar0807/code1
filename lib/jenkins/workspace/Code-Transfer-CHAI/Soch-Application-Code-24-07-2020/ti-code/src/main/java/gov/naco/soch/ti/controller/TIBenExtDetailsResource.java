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

import gov.naco.soch.ti.dto.TIBenfExtDetailsDTO;
import gov.naco.soch.ti.dto.TIBenExtDetailsCriteria;
import gov.naco.soch.ti.service.TIBenExtDetailsQueryService;
import gov.naco.soch.ti.service.TIBenExtDetailsServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenExtDetails}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenExtDetailsResource {

    private final Logger log = LoggerFactory.getLogger(TIBenExtDetailsResource.class);

    private static final String ENTITY_NAME = "tIBenExtDetails";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenExtDetailsServiceImpl tIBenExtDetailsService;

    private final TIBenExtDetailsQueryService tIBenExtDetailsQueryService;

    public TIBenExtDetailsResource(TIBenExtDetailsServiceImpl tIBenExtDetailsService, TIBenExtDetailsQueryService tIBenExtDetailsQueryService) {
        this.tIBenExtDetailsService = tIBenExtDetailsService;
        this.tIBenExtDetailsQueryService = tIBenExtDetailsQueryService;
    }

    /**
     * {@code POST  /ti-ben-ext-details} : Create a new tIBenExtDetails.
     *
     * @param tIBenExtDetailsDTO the tIBenExtDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tIBenExtDetailsDTO, or with status {@code 400 (Bad Request)} if the tIBenExtDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-ext-details")
    public ResponseEntity<TIBenfExtDetailsDTO> createTIBenExtDetails(@Valid @RequestBody TIBenfExtDetailsDTO tIBenExtDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save TIBenExtDetails : {}", tIBenExtDetailsDTO);
        if (tIBenExtDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new tIBenExtDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TIBenfExtDetailsDTO result = tIBenExtDetailsService.save(tIBenExtDetailsDTO);
        return ResponseEntity.created(new URI("/api/ti-ben-ext-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ti-ben-ext-details} : Updates an existing tIBenExtDetails.
     *
     * @param tIBenExtDetailsDTO the tIBenExtDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tIBenExtDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the tIBenExtDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tIBenExtDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-ext-details")
    public ResponseEntity<TIBenfExtDetailsDTO> updateTIBenExtDetails(@Valid @RequestBody TIBenfExtDetailsDTO tIBenExtDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update TIBenExtDetails : {}", tIBenExtDetailsDTO);
        if (tIBenExtDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TIBenfExtDetailsDTO result = tIBenExtDetailsService.save(tIBenExtDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, tIBenExtDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ti-ben-ext-details} : get all the tIBenExtDetails.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBenExtDetails in body.
     */
    @GetMapping("/ti-ben-ext-details")
    public ResponseEntity<List<TIBenfExtDetailsDTO>> getAllTIBenExtDetails(TIBenExtDetailsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TIBenExtDetails by criteria: {}", criteria);
        Page<TIBenfExtDetailsDTO> page = tIBenExtDetailsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /ti-ben-ext-details/count} : count all the tIBenExtDetails.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/ti-ben-ext-details/count")
    public ResponseEntity<Long> countTIBenExtDetails(TIBenExtDetailsCriteria criteria) {
        log.debug("REST request to count TIBenExtDetails by criteria: {}", criteria);
        return ResponseEntity.ok().body(tIBenExtDetailsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-ext-details/:id} : get the "id" tIBenExtDetails.
     *
     * @param id the id of the tIBenExtDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tIBenExtDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-ext-details/{id}")
    public ResponseEntity<TIBenfExtDetailsDTO> getTIBenExtDetails(@PathVariable Long id) {
        log.debug("REST request to get TIBenExtDetails : {}", id);
        Optional<TIBenfExtDetailsDTO> tIBenExtDetailsDTO = tIBenExtDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tIBenExtDetailsDTO);
    }

    /**
     * {@code DELETE  /ti-ben-ext-details/:id} : delete the "id" tIBenExtDetails.
     *
     * @param id the id of the tIBenExtDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-ext-details/{id}")
    public ResponseEntity<Void> deleteTIBenExtDetails(@PathVariable Long id) {
        log.debug("REST request to delete TIBenExtDetails : {}", id);
        tIBenExtDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
