package gov.naco.soch.web.rest;

import gov.naco.soch.service.ICTCFollowUpService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;
import gov.naco.soch.service.dto.ICTCFollowUpCriteria;
import gov.naco.soch.service.ICTCFollowUpQueryService;

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
 * REST controller for managing {@link gov.naco.soch.domain.ICTCFollowUp}.
 */
@RestController
@RequestMapping("/api")
public class ICTCFollowUpResource {

    private final Logger log = LoggerFactory.getLogger(ICTCFollowUpResource.class);

    private static final String ENTITY_NAME = "sochictcIctcFollowUp";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCFollowUpService iCTCFollowUpService;

    private final ICTCFollowUpQueryService iCTCFollowUpQueryService;

    public ICTCFollowUpResource(ICTCFollowUpService iCTCFollowUpService, ICTCFollowUpQueryService iCTCFollowUpQueryService) {
        this.iCTCFollowUpService = iCTCFollowUpService;
        this.iCTCFollowUpQueryService = iCTCFollowUpQueryService;
    }

    /**
     * {@code POST  /ictc-follow-ups} : Create a new iCTCFollowUp.
     *
     * @param iCTCFollowUpDTO the iCTCFollowUpDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCFollowUpDTO, or with status {@code 400 (Bad Request)} if the iCTCFollowUp has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ictc-follow-ups")
    public ResponseEntity<ICTCFollowUpDTO> createICTCFollowUp(@Valid @RequestBody ICTCFollowUpDTO iCTCFollowUpDTO) throws URISyntaxException {
        log.debug("REST request to save ICTCFollowUp : {}", iCTCFollowUpDTO);
        if (iCTCFollowUpDTO.getId() != null) {
            throw new BadRequestAlertException("A new iCTCFollowUp cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ICTCFollowUpDTO result = iCTCFollowUpService.saveFollowUpForInfant(iCTCFollowUpDTO);
        return ResponseEntity.created(new URI("/api/ictc-follow-ups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ictc-follow-ups} : Updates an existing iCTCFollowUp.
     *
     * @param iCTCFollowUpDTO the iCTCFollowUpDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iCTCFollowUpDTO,
     * or with status {@code 400 (Bad Request)} if the iCTCFollowUpDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iCTCFollowUpDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ictc-follow-ups")
    public ResponseEntity<ICTCFollowUpDTO> updateICTCFollowUp(@Valid @RequestBody ICTCFollowUpDTO iCTCFollowUpDTO) throws URISyntaxException {
        log.debug("REST request to update ICTCFollowUp : {}", iCTCFollowUpDTO);
        if (iCTCFollowUpDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ICTCFollowUpDTO result = iCTCFollowUpService.save(iCTCFollowUpDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iCTCFollowUpDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ictc-follow-ups} : get all the iCTCFollowUps.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCFollowUps in body.
     */
    @GetMapping("/ictc-follow-ups")
    public ResponseEntity<List<ICTCFollowUpDTO>> getAllICTCFollowUps(ICTCFollowUpCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCFollowUps by criteria: {}", criteria);
        Page<ICTCFollowUpDTO> page = iCTCFollowUpQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ictc-follow-ups/count} : count all the iCTCFollowUps.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/ictc-follow-ups/count")
    public ResponseEntity<Long> countICTCFollowUps(ICTCFollowUpCriteria criteria) {
        log.debug("REST request to count ICTCFollowUps by criteria: {}", criteria);
        return ResponseEntity.ok().body(iCTCFollowUpQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ictc-follow-ups/:id} : get the "id" iCTCFollowUp.
     *
     * @param id the id of the iCTCFollowUpDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCFollowUpDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-follow-ups/{id}")
    public ResponseEntity<ICTCFollowUpDTO> getICTCFollowUp(@PathVariable Long id) {
        log.debug("REST request to get ICTCFollowUp : {}", id);
        Optional<ICTCFollowUpDTO> iCTCFollowUpDTO = iCTCFollowUpService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCFollowUpDTO);
    }

//    /**
//     * {@code DELETE  /ictc-follow-ups/:id} : delete the "id" iCTCFollowUp.
//     *
//     * @param id the id of the iCTCFollowUpDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/ictc-follow-ups/{id}")
//    public ResponseEntity<Void> deleteICTCFollowUp(@PathVariable Long id) {
//        log.debug("REST request to delete ICTCFollowUp : {}", id);
//        iCTCFollowUpService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
