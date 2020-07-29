package gov.naco.soch.web.rest;

import gov.naco.soch.service.ReferralsService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.ReferralsDTO;
import gov.naco.soch.service.dto.ReferralsCriteria;
import gov.naco.soch.domain.Referrals;
import gov.naco.soch.service.ReferralsQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link gov.naco.soch.domain.Referrals}.
 */
@RestController
@RequestMapping("/api")
public class ReferralsResource {

    private final Logger log = LoggerFactory.getLogger(ReferralsResource.class);

    private static final String ENTITY_NAME = "sochictcReferrals";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReferralsService referralsService;

    private final ReferralsQueryService referralsQueryService;

    public ReferralsResource(ReferralsService referralsService, ReferralsQueryService referralsQueryService) {
        this.referralsService = referralsService;
        this.referralsQueryService = referralsQueryService;
    }

    /**
     * {@code POST  /referrals} : Create a new referrals.
     *
     * @param referralsDTO the referralsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new referralsDTO, or with status {@code 400 (Bad Request)} if the referrals has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/referrals")
    public ResponseEntity<ReferralsDTO> createReferrals(@Valid @RequestBody ReferralsDTO referralsDTO) throws URISyntaxException {
        log.debug("REST request to save Referrals : {}", referralsDTO);
        if (referralsDTO.getId() != null) {
            throw new BadRequestAlertException("A new referrals cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReferralsDTO result = referralsService.save(referralsDTO);
        return ResponseEntity.created(new URI("/api/referrals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /referrals} : Updates an existing referrals.
     *
     * @param referralsDTO the referralsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated referralsDTO,
     * or with status {@code 400 (Bad Request)} if the referralsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the referralsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/referrals")
    public ResponseEntity<ReferralsDTO> updateReferrals(@Valid @RequestBody ReferralsDTO referralsDTO) throws URISyntaxException {
        log.debug("REST request to update Referrals : {}", referralsDTO);
        if (referralsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReferralsDTO result = referralsService.save(referralsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, referralsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /referrals} : get all the referrals.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of referrals in body.
     */
    @GetMapping("/referrals")
    public ResponseEntity<List<Referrals>> getAllReferrals(ReferralsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Referrals by criteria: {}", criteria);
        Page<Referrals> page = referralsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /referrals/count} : count all the referrals.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/referrals/count")
    public ResponseEntity<Long> countReferrals(ReferralsCriteria criteria) {
        log.debug("REST request to count Referrals by criteria: {}", criteria);
        return ResponseEntity.ok().body(referralsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /referrals/:id} : get the "id" referrals.
     *
     * @param id the id of the referralsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the referralsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/referrals/{id}")
    public ResponseEntity<ReferralsDTO> getReferrals(@PathVariable Long id) {
        log.debug("REST request to get Referrals : {}", id);
        Optional<ReferralsDTO> referralsDTO = referralsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(referralsDTO);
    }

    /**
     * {@code DELETE  /referrals/:id} : delete the "id" referrals.
     *
     * @param id the id of the referralsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/referrals/{id}")
    public ResponseEntity<Void> deleteReferrals(@PathVariable Long id) {
        log.debug("REST request to delete Referrals : {}", id);
        referralsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
