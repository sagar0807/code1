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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.TIBenPrescCriteria;
import gov.naco.soch.ti.dto.TIBenPrescDTO;
import gov.naco.soch.ti.service.TIBenPrescQueryService;
import gov.naco.soch.ti.service.TIBenPrescServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenPresc}.
 */
@RestController
@RequestMapping("/api")
public class TIBenPrescResource {

    private final Logger log = LoggerFactory.getLogger(TIBenPrescResource.class);

    private static final String ENTITY_NAME = "tIBenPresc";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenPrescServiceImpl tIBenPrescService;

    private final TIBenPrescQueryService tIBenPrescQueryService;

    public TIBenPrescResource(TIBenPrescServiceImpl tIBenPrescService, TIBenPrescQueryService tIBenPrescQueryService) {
        this.tIBenPrescService = tIBenPrescService;
        this.tIBenPrescQueryService = tIBenPrescQueryService;
    }

    /**
     * {@code POST  /ti-ben-prescs} : Create a new tIBenPresc.
     *
     * @param tIBenPrescDTO the tIBenPrescDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tIBenPrescDTO, or with status {@code 400 (Bad Request)} if the tIBenPresc has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-prescs")
    public ResponseEntity<TIBenPrescDTO> createTIBenPresc(@Valid @RequestBody TIBenPrescDTO tIBenPrescDTO) throws URISyntaxException {
        log.debug("REST request to save TIBenPresc : {}", tIBenPrescDTO);
        if (tIBenPrescDTO.getId() != null) {
            throw new BadRequestAlertException("A new tIBenPresc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TIBenPrescDTO result = tIBenPrescService.save(tIBenPrescDTO);
        return ResponseEntity.created(new URI("/api/ti-ben-prescs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ti-ben-prescs} : Updates an existing tIBenPresc.
     *
     * @param tIBenPrescDTO the tIBenPrescDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tIBenPrescDTO,
     * or with status {@code 400 (Bad Request)} if the tIBenPrescDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tIBenPrescDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-prescs")
    public ResponseEntity<TIBenPrescDTO> updateTIBenPresc(@Valid @RequestBody TIBenPrescDTO tIBenPrescDTO) throws URISyntaxException {
        log.debug("REST request to update TIBenPresc : {}", tIBenPrescDTO);
        if (tIBenPrescDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TIBenPrescDTO result = tIBenPrescService.save(tIBenPrescDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, tIBenPrescDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ti-ben-prescs} : get all the tIBenPrescs.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBenPrescs in body.
     */
    @GetMapping("/ti-ben-prescs")
    public ResponseEntity<List<TIBenPrescDTO>> getAllTIBenPrescs(TIBenPrescCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TIBenPrescs by criteria: {}", criteria);
        Page<TIBenPrescDTO> page = tIBenPrescQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /ti-ben-prescs/count} : count all the tIBenPrescs.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/ti-ben-prescs/count")
    public ResponseEntity<Long> countTIBenPrescs(TIBenPrescCriteria criteria) {
        log.debug("REST request to count TIBenPrescs by criteria: {}", criteria);
        return ResponseEntity.ok().body(tIBenPrescQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-prescs/:id} : get the "id" tIBenPresc.
     *
     * @param id the id of the tIBenPrescDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tIBenPrescDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-prescs/{id}")
    public ResponseEntity<TIBenPrescDTO> getTIBenPresc(@PathVariable Long id) {
        log.debug("REST request to get TIBenPresc : {}", id);
        Optional<TIBenPrescDTO> tIBenPrescDTO = tIBenPrescService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tIBenPrescDTO);
    }

    /**
     * {@code DELETE  /ti-ben-prescs/:id} : delete the "id" tIBenPresc.
     *
     * @param id the id of the tIBenPrescDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-prescs/{id}")
    public ResponseEntity<Void> deleteTIBenPresc(@PathVariable Long id) {
        log.debug("REST request to delete TIBenPresc : {}", id);
        tIBenPrescService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
