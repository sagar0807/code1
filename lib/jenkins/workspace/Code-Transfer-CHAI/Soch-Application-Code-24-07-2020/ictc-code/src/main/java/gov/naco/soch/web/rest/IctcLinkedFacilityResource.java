package gov.naco.soch.web.rest;

import gov.naco.soch.service.IctcLinkedFacilityService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;
import gov.naco.soch.service.dto.IctcLinkedFacilityCriteria;
import gov.naco.soch.service.IctcLinkedFacilityQueryService;

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
 * REST controller for managing {@link gov.naco.soch.domain.IctcLinkedFacility}.
 */
@RestController
@RequestMapping("/api")
public class IctcLinkedFacilityResource {

    private final Logger log = LoggerFactory.getLogger(IctcLinkedFacilityResource.class);

    private static final String ENTITY_NAME = "sochictcIctcLinkedFacility";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IctcLinkedFacilityService ictcLinkedFacilityService;

    private final IctcLinkedFacilityQueryService ictcLinkedFacilityQueryService;

    public IctcLinkedFacilityResource(IctcLinkedFacilityService ictcLinkedFacilityService, IctcLinkedFacilityQueryService ictcLinkedFacilityQueryService) {
        this.ictcLinkedFacilityService = ictcLinkedFacilityService;
        this.ictcLinkedFacilityQueryService = ictcLinkedFacilityQueryService;
    }

    /**
     * {@code POST  /ictc-linked-facilities} : Create a new ictcLinkedFacility.
     *
     * @param ictcLinkedFacilityDTO the ictcLinkedFacilityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ictcLinkedFacilityDTO, or with status {@code 400 (Bad Request)} if the ictcLinkedFacility has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ictc-linked-facilities")
    public ResponseEntity<IctcLinkedFacilityDTO> createIctcLinkedFacility(@Valid @RequestBody IctcLinkedFacilityDTO ictcLinkedFacilityDTO) throws URISyntaxException {
        log.debug("REST request to save IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
        if (ictcLinkedFacilityDTO.getId() != null) {
            throw new BadRequestAlertException("A new ictcLinkedFacility cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IctcLinkedFacilityDTO result = ictcLinkedFacilityService.save(ictcLinkedFacilityDTO);
        return ResponseEntity.created(new URI("/api/ictc-linked-facilities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ictc-linked-facilities} : Updates an existing ictcLinkedFacility.
     *
     * @param ictcLinkedFacilityDTO the ictcLinkedFacilityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ictcLinkedFacilityDTO,
     * or with status {@code 400 (Bad Request)} if the ictcLinkedFacilityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ictcLinkedFacilityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ictc-linked-facilities")
    public ResponseEntity<IctcLinkedFacilityDTO> updateIctcLinkedFacility(@Valid @RequestBody IctcLinkedFacilityDTO ictcLinkedFacilityDTO) throws URISyntaxException {
        log.debug("REST request to update IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
        if (ictcLinkedFacilityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IctcLinkedFacilityDTO result = ictcLinkedFacilityService.save(ictcLinkedFacilityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ictcLinkedFacilityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ictc-linked-facilities} : get all the ictcLinkedFacilities.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ictcLinkedFacilities in body.
     */
    @GetMapping("/ictc-linked-facilities")
    public ResponseEntity<List<IctcLinkedFacilityDTO>> getAllIctcLinkedFacilities(IctcLinkedFacilityCriteria criteria, Pageable pageable) {
        log.debug("REST request to get IctcLinkedFacilities by criteria: {}", criteria);
        Page<IctcLinkedFacilityDTO> page = ictcLinkedFacilityQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ictc-linked-facilities/count} : count all the ictcLinkedFacilities.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/ictc-linked-facilities/count")
    public ResponseEntity<Long> countIctcLinkedFacilities(IctcLinkedFacilityCriteria criteria) {
        log.debug("REST request to count IctcLinkedFacilities by criteria: {}", criteria);
        return ResponseEntity.ok().body(ictcLinkedFacilityQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ictc-linked-facilities/:id} : get the "id" ictcLinkedFacility.
     *
     * @param id the id of the ictcLinkedFacilityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ictcLinkedFacilityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-linked-facilities/{id}")
    public ResponseEntity<IctcLinkedFacilityDTO> getIctcLinkedFacility(@PathVariable Long id) {
        log.debug("REST request to get IctcLinkedFacility : {}", id);
        Optional<IctcLinkedFacilityDTO> ictcLinkedFacilityDTO = ictcLinkedFacilityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ictcLinkedFacilityDTO);
    }

    /**
     * {@code DELETE  /ictc-linked-facilities/:id} : delete the "id" ictcLinkedFacility.
     *
     * @param id the id of the ictcLinkedFacilityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ictc-linked-facilities/{id}")
    public ResponseEntity<Void> deleteIctcLinkedFacility(@PathVariable Long id) {
        log.debug("REST request to delete IctcLinkedFacility : {}", id);
        ictcLinkedFacilityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
