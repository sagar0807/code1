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

import gov.naco.soch.ti.dto.TIBenHRGDetailsCriteria;
import gov.naco.soch.ti.dto.TIBenHRGDetailsDTO;
import gov.naco.soch.ti.service.TIBenHRGDetailsQueryService;
import gov.naco.soch.ti.service.TIBenHRGDetailsServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenHRGDetails}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenHRGDetailsResource {

    private final Logger log = LoggerFactory.getLogger(TIBenHRGDetailsResource.class);

    private static final String ENTITY_NAME = "tIBenHRGDetails";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenHRGDetailsServiceImpl tIBenHRGDetailsService;

    private final TIBenHRGDetailsQueryService tIBenHRGDetailsQueryService;

    public TIBenHRGDetailsResource(TIBenHRGDetailsServiceImpl tIBenHRGDetailsService, TIBenHRGDetailsQueryService tIBenHRGDetailsQueryService) {
        this.tIBenHRGDetailsService = tIBenHRGDetailsService;
        this.tIBenHRGDetailsQueryService = tIBenHRGDetailsQueryService;
    }

    /**
     * {@code POST  /ti-ben-hrg-details} : Create a new tIBenHRGDetails.
     *
     * @param tIBenHRGDetailsDTO the tIBenHRGDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tIBenHRGDetailsDTO, or with status {@code 400 (Bad Request)} if the tIBenHRGDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-hrg-details")
    public ResponseEntity<TIBenHRGDetailsDTO> createTIBenHRGDetails(@Valid @RequestBody TIBenHRGDetailsDTO tIBenHRGDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save TIBenHRGDetails : {}", tIBenHRGDetailsDTO);
        if (tIBenHRGDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new tIBenHRGDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TIBenHRGDetailsDTO result = tIBenHRGDetailsService.save(tIBenHRGDetailsDTO);
        return ResponseEntity.created(new URI("/api/ti-ben-hrg-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ti-ben-hrg-details} : Updates an existing tIBenHRGDetails.
     *
     * @param tIBenHRGDetailsDTO the tIBenHRGDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tIBenHRGDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the tIBenHRGDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tIBenHRGDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-hrg-details")
    public ResponseEntity<TIBenHRGDetailsDTO> updateTIBenHRGDetails(@Valid @RequestBody TIBenHRGDetailsDTO tIBenHRGDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update TIBenHRGDetails : {}", tIBenHRGDetailsDTO);
        if (tIBenHRGDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TIBenHRGDetailsDTO result = tIBenHRGDetailsService.save(tIBenHRGDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, tIBenHRGDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ti-ben-hrg-details} : get all the tIBenHRGDetails.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBenHRGDetails in body.
     */
    @GetMapping("/ti-ben-hrg-details")
    public ResponseEntity<List<TIBenHRGDetailsDTO>> getAllTIBenHRGDetails(TIBenHRGDetailsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TIBenHRGDetails by criteria: {}", criteria);
        Page<TIBenHRGDetailsDTO> page = tIBenHRGDetailsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /ti-ben-hrg-details/count} : count all the tIBenHRGDetails.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/ti-ben-hrg-details/count")
    public ResponseEntity<Long> countTIBenHRGDetails(TIBenHRGDetailsCriteria criteria) {
        log.debug("REST request to count TIBenHRGDetails by criteria: {}", criteria);
        return ResponseEntity.ok().body(tIBenHRGDetailsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-hrg-details/:id} : get the "id" tIBenHRGDetails.
     *
     * @param id the id of the tIBenHRGDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tIBenHRGDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-hrg-details/{id}")
    public ResponseEntity<TIBenHRGDetailsDTO> getTIBenHRGDetails(@PathVariable Long id) {
        log.debug("REST request to get TIBenHRGDetails : {}", id);
        Optional<TIBenHRGDetailsDTO> tIBenHRGDetailsDTO = tIBenHRGDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tIBenHRGDetailsDTO);
    }

    /**
     * {@code DELETE  /ti-ben-hrg-details/:id} : delete the "id" tIBenHRGDetails.
     *
     * @param id the id of the tIBenHRGDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-hrg-details/{id}")
    public ResponseEntity<Void> deleteTIBenHRGDetails(@PathVariable Long id) {
        log.debug("REST request to delete TIBenHRGDetails : {}", id);
        tIBenHRGDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
