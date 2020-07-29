package gov.naco.soch.web.rest;

import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionCriteria;
import gov.naco.soch.service.ICTCSampleCollectionQueryService;

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
 * REST controller for managing {@link gov.naco.soch.domain.ICTCSampleCollection}.
 */
@RestController
@RequestMapping("/api")
public class ICTCSampleCollectionResource {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionResource.class);

    private static final String ENTITY_NAME = "sochictcIctcSampleCollection";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCSampleCollectionService iCTCSampleCollectionService;

    private final ICTCSampleCollectionQueryService iCTCSampleCollectionQueryService;

    public ICTCSampleCollectionResource(ICTCSampleCollectionService iCTCSampleCollectionService, ICTCSampleCollectionQueryService iCTCSampleCollectionQueryService) {
        this.iCTCSampleCollectionService = iCTCSampleCollectionService;
        this.iCTCSampleCollectionQueryService = iCTCSampleCollectionQueryService;
    }

    /**
     * {@code POST  /ictc-sample-collections} : Create a new iCTCSampleCollection.
     *
     * @param iCTCSampleCollectionDTO the iCTCSampleCollectionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCSampleCollectionDTO, or with status {@code 400 (Bad Request)} if the iCTCSampleCollection has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ictc-sample-collections")
    public ResponseEntity<List<ICTCSampleCollectionDTO>> createICTCSampleCollection(@RequestBody List<CreateSampleDTO> samples) throws URISyntaxException {
        log.debug("REST request to save samples : {}", samples);
        return ResponseEntity.ok().body(iCTCSampleCollectionService.saveListOfSamples(samples));
    }

    /**
     * {@code GET  /ictc-sample-collections} : get all the iCTCSampleCollections.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCSampleCollections in body.
     */
    @GetMapping("/ictc-sample-collections")
    public ResponseEntity<List<ICTCSampleCollectionDTO>> getAllICTCSampleCollections(ICTCSampleCollectionCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCSampleCollections by criteria: {}", criteria);
        Page<ICTCSampleCollectionDTO> page = iCTCSampleCollectionQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ictc-sample-collections/:id} : get the "id" iCTCSampleCollection.
     *
     * @param id the id of the iCTCSampleCollectionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCSampleCollectionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-sample-collections/{id}")
    public ResponseEntity<ICTCSampleCollectionDTO> getICTCSampleCollection(@PathVariable Long id) {
        log.debug("REST request to get ICTCSampleCollection : {}", id);
        Optional<ICTCSampleCollectionDTO> iCTCSampleCollectionDTO = iCTCSampleCollectionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCSampleCollectionDTO);
    }

    /**
     * {@code DELETE  /ictc-sample-collections/:id} : delete the "id" iCTCSampleCollection.
     *
     * @param id the id of the iCTCSampleCollectionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ictc-sample-collections/{id}")
    public ResponseEntity<Void> deleteICTCSampleCollection(@PathVariable Long id) {
        log.debug("REST request to delete ICTCSampleCollection : {}", id);
        iCTCSampleCollectionService.deactivate(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
