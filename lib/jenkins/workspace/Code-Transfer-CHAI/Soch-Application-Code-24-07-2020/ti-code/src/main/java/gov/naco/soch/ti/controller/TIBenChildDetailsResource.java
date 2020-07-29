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

import gov.naco.soch.ti.dto.TIBenChildDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenChildDetailsDTO;
import gov.naco.soch.ti.service.TIBenChildDetailsQueryService;
import gov.naco.soch.ti.service.TIBenChildDetailsService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenChildDetails}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenChildDetailsResource {

    private final Logger log = LoggerFactory.getLogger(TIBenChildDetailsResource.class);

    private static final String ENTITY_NAME = "tIBenChildDetails";
    
    private static final String APPLICATION_NAME = "TI";

    private final TIBenChildDetailsService tIBenChildDetailsService;

    private final TIBenChildDetailsQueryService tIBenChildDetailsQueryService;

    public TIBenChildDetailsResource(TIBenChildDetailsService tIBenChildDetailsService, TIBenChildDetailsQueryService tIBenChildDetailsQueryService) {
        this.tIBenChildDetailsService = tIBenChildDetailsService;
        this.tIBenChildDetailsQueryService = tIBenChildDetailsQueryService;
    }

    /**
     * {@code POST  /ti-ben-child-details} : Create a new tIBenChildDetails.
     *
     * @param tIBenChildDetailsDTO the tIBenChildDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tIBenChildDetailsDTO, or with status {@code 400 (Bad Request)} if the tIBenChildDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-child-details")
    public ResponseEntity<TIBenChildDetailsDTO> createTIBenChildDetails(@Valid @RequestBody TIBenChildDetailsDTO tIBenChildDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save TIBenChildDetails : {}", tIBenChildDetailsDTO);
        if (tIBenChildDetailsDTO.getId() != null) {

            throw new BadRequestAlertException("A new tIBenChildDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TIBenChildDetailsDTO result = tIBenChildDetailsService.save(tIBenChildDetailsDTO);
        return ResponseEntity.created(new URI("/api/ti-ben-child-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ti-ben-child-details} : Updates an existing tIBenChildDetails.
     *
     * @param tIBenChildDetailsDTO the tIBenChildDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tIBenChildDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the tIBenChildDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tIBenChildDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-child-details")
    public ResponseEntity<TIBenChildDetailsDTO> updateTIBenChildDetails(@Valid @RequestBody TIBenChildDetailsDTO tIBenChildDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update TIBenChildDetails : {}", tIBenChildDetailsDTO);
        if (tIBenChildDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TIBenChildDetailsDTO result = tIBenChildDetailsService.save(tIBenChildDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, tIBenChildDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ti-ben-child-details} : get all the tIBenChildDetails.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBenChildDetails in body.
     */
    @GetMapping("/ti-ben-child-details")
    public ResponseEntity<List<TIBenChildDetailsDTO>> getAllTIBenChildDetails(TIBenChildDetailsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TIBenChildDetails by criteria: {}", criteria);
        Page<TIBenChildDetailsDTO> page = tIBenChildDetailsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /ti-ben-child-details/count} : count all the tIBenChildDetails.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/ti-ben-child-details/count")
    public ResponseEntity<Long> countTIBenChildDetails(TIBenChildDetailsCriteria criteria) {
        log.debug("REST request to count TIBenChildDetails by criteria: {}", criteria);
        return ResponseEntity.ok().body(tIBenChildDetailsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-child-details/:id} : get the "id" tIBenChildDetails.
     *
     * @param id the id of the tIBenChildDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tIBenChildDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-child-details/{id}")
    public ResponseEntity<TIBenChildDetailsDTO> getTIBenChildDetails(@PathVariable Long id) {
        log.debug("REST request to get TIBenChildDetails : {}", id);
        Optional<TIBenChildDetailsDTO> tIBenChildDetailsDTO = tIBenChildDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tIBenChildDetailsDTO);
    }

    /**
     * {@code DELETE  /ti-ben-child-details/:id} : delete the "id" tIBenChildDetails.
     *
     * @param id the id of the tIBenChildDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-child-details/{id}")
    public ResponseEntity<Void> deleteTIBenChildDetails(@PathVariable Long id) {
        log.debug("REST request to delete TIBenChildDetails : {}", id);
        tIBenChildDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
