package gov.naco.soch.web.rest;

import gov.naco.soch.service.ICTCSampleBatchService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;
import gov.naco.soch.service.dto.CreateSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCSampleBatchCriteria;
import gov.naco.soch.service.ICTCSampleBatchQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCSampleBatch}.
 */
@RestController
@RequestMapping("/api")
public class ICTCSampleBatchResource {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleBatchResource.class);

    private static final String ENTITY_NAME = "sochictcIctcSampleBatch";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCSampleBatchService iCTCSampleBatchService;

    private final ICTCSampleBatchQueryService iCTCSampleBatchQueryService;

    public ICTCSampleBatchResource(ICTCSampleBatchService iCTCSampleBatchService, ICTCSampleBatchQueryService iCTCSampleBatchQueryService) {
        this.iCTCSampleBatchService = iCTCSampleBatchService;
        this.iCTCSampleBatchQueryService = iCTCSampleBatchQueryService;
    }

    /**
     * {@code POST  /ictc-sample-batches} : Create a new iCTCSampleBatch.
     *
     * @param iCTCSampleBatchDTO the iCTCSampleBatchDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCSampleBatchDTO, or with status {@code 400 (Bad Request)} if the iCTCSampleBatch has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ictc-sample-batches")
    public ResponseEntity<ICTCSampleBatchDTO> createICTCSampleBatch(@RequestBody CreateSampleBatchDTO batchDetails) throws URISyntaxException {
        log.debug("REST request to save ICTCSampleBatch : {}", batchDetails);
        return ResponseEntity.ok()
            .body(iCTCSampleBatchService.createBatch(batchDetails));
    }

    /**
     * {@code PUT  /ictc-sample-batches} : Updates an existing iCTCSampleBatch.
     *
     * @param iCTCSampleBatchDTO the iCTCSampleBatchDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iCTCSampleBatchDTO,
     * or with status {@code 400 (Bad Request)} if the iCTCSampleBatchDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iCTCSampleBatchDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ictc-sample-batches")
    public ResponseEntity<ICTCSampleBatchDTO> updateICTCSampleBatch(@Valid @RequestBody ICTCSampleBatchDTO iCTCSampleBatchDTO) throws URISyntaxException {
        log.debug("REST request to update ICTCSampleBatch : {}", iCTCSampleBatchDTO);
        if (iCTCSampleBatchDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ICTCSampleBatchDTO result = iCTCSampleBatchService.save(iCTCSampleBatchDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iCTCSampleBatchDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ictc-sample-batches} : get all the iCTCSampleBatches.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCSampleBatches in body.
     */
    @GetMapping("/ictc-sample-batches")
    public ResponseEntity<List<ICTCSampleBatchDTO>> getAllICTCSampleBatches(ICTCSampleBatchCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCSampleBatches by criteria: {}", criteria);
        Page<ICTCSampleBatchDTO> page = iCTCSampleBatchQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    /**
     * {@code GET  /ictc-sample-batches/:id} : get the "id" iCTCSampleBatch.
     *
     * @param id the id of the iCTCSampleBatchDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCSampleBatchDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-sample-batches/{id}")
    public ResponseEntity<ICTCSampleBatchDTO> getICTCSampleBatch(@PathVariable Long id) {
        log.debug("REST request to get ICTCSampleBatch : {}", id);
        Optional<ICTCSampleBatchDTO> iCTCSampleBatchDTO = iCTCSampleBatchService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCSampleBatchDTO);
    }

}
