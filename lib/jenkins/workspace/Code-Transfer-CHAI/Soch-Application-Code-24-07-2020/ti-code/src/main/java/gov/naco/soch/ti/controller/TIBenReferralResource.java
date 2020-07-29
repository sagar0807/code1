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

import gov.naco.soch.ti.dto.TIBenReferralCriteria;
import gov.naco.soch.ti.dto.TIBenReferralDTO;
import gov.naco.soch.ti.service.TIBenReferralQueryService;
import gov.naco.soch.ti.service.TIBenReferralServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBenReferral}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBenReferralResource {

    private final Logger log = LoggerFactory.getLogger(TIBenReferralResource.class);

    private static final String ENTITY_NAME = "tIBenReferral";

    private static final String APPLICATION_NAME = "TI";

    private final TIBenReferralServiceImpl tIBenReferralService;

    private final TIBenReferralQueryService tIBenReferralQueryService;

    public TIBenReferralResource(TIBenReferralServiceImpl tIBenReferralService, TIBenReferralQueryService tIBenReferralQueryService) {
        this.tIBenReferralService = tIBenReferralService;
        this.tIBenReferralQueryService = tIBenReferralQueryService;
    }

    /**
     * {@code POST  /ti-ben-referrals} : Create a new tIBenReferral.
     *
     * @param tIBenReferralDTO the tIBenReferralDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tIBenReferralDTO, or with status {@code 400 (Bad Request)} if the tIBenReferral has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ben-referrals")
    public ResponseEntity<TIBenReferralDTO> createTIBenReferral(@Valid @RequestBody TIBenReferralDTO tIBenReferralDTO) throws URISyntaxException {
        log.debug("REST request to save TIBenReferral : {}", tIBenReferralDTO);
        if (tIBenReferralDTO.getId() != null) {
            throw new BadRequestAlertException("A new tIBenReferral cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TIBenReferralDTO result = tIBenReferralService.save(tIBenReferralDTO);
        return ResponseEntity.created(new URI("/api/ti-ben-referrals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ti-ben-referrals} : Updates an existing tIBenReferral.
     *
     * @param tIBenReferralDTO the tIBenReferralDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tIBenReferralDTO,
     * or with status {@code 400 (Bad Request)} if the tIBenReferralDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tIBenReferralDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ben-referrals")
    public ResponseEntity<TIBenReferralDTO> updateTIBenReferral(@Valid @RequestBody TIBenReferralDTO tIBenReferralDTO) throws URISyntaxException {
        log.debug("REST request to update TIBenReferral : {}", tIBenReferralDTO);
        if (tIBenReferralDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TIBenReferralDTO result = tIBenReferralService.save(tIBenReferralDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, tIBenReferralDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ti-ben-referrals} : get all the tIBenReferrals.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBenReferrals in body.
     */
    @GetMapping("/ti-ben-referrals")
    public ResponseEntity<List<TIBenReferralDTO>> getAllTIBenReferrals(TIBenReferralCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TIBenReferrals by criteria: {}", criteria);
        Page<TIBenReferralDTO> page = tIBenReferralQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /ti-ben-referrals/count} : count all the tIBenReferrals.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/ti-ben-referrals/count")
    public ResponseEntity<Long> countTIBenReferrals(TIBenReferralCriteria criteria) {
        log.debug("REST request to count TIBenReferrals by criteria: {}", criteria);
        return ResponseEntity.ok().body(tIBenReferralQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-ben-referrals/:id} : get the "id" tIBenReferral.
     *
     * @param id the id of the tIBenReferralDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tIBenReferralDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ben-referrals/{id}")
    public ResponseEntity<TIBenReferralDTO> getTIBenReferral(@PathVariable Long id) {
        log.debug("REST request to get TIBenReferral : {}", id);
        Optional<TIBenReferralDTO> tIBenReferralDTO = tIBenReferralService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tIBenReferralDTO);
    }

    /**
     * {@code DELETE  /ti-ben-referrals/:id} : delete the "id" tIBenReferral.
     *
     * @param id the id of the tIBenReferralDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-ben-referrals/{id}")
    public ResponseEntity<Void> deleteTIBenReferral(@PathVariable Long id) {
        log.debug("REST request to delete TIBenReferral : {}", id);
        tIBenReferralService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
