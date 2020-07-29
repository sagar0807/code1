package gov.naco.soch.web.rest;

import gov.naco.soch.service.IctcRPQMappingService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.IctcRPQMappingDTO;
import gov.naco.soch.service.dto.IctcRPQMappingCriteria;
import gov.naco.soch.service.IctcRPQMappingQueryService;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link gov.naco.soch.domain.IctcRPQMapping}.
 */
@RestController
@RequestMapping("/api")
public class IctcRPQMappingResource {

    private final Logger log = LoggerFactory.getLogger(IctcRPQMappingResource.class);

    private static final String ENTITY_NAME = "sochictcIctcRpqMapping";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IctcRPQMappingService ictcRPQMappingService;

    private final IctcRPQMappingQueryService ictcRPQMappingQueryService;

    public IctcRPQMappingResource(IctcRPQMappingService ictcRPQMappingService, IctcRPQMappingQueryService ictcRPQMappingQueryService) {
        this.ictcRPQMappingService = ictcRPQMappingService;
        this.ictcRPQMappingQueryService = ictcRPQMappingQueryService;
    }

    /**
     * {@code POST  /ictc-rpq-mappings} : Create a new ictcRPQMapping.
     *
     * @param ictcRPQMappingDTO the ictcRPQMappingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ictcRPQMappingDTO, or with status {@code 400 (Bad Request)} if the ictcRPQMapping has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ictc-rpq-mappings")
    public ResponseEntity<IctcRPQMappingDTO> createIctcRPQMapping(@RequestBody IctcRPQMappingDTO ictcRPQMappingDTO) throws URISyntaxException {
        log.debug("REST request to save IctcRPQMapping : {}", ictcRPQMappingDTO);
        if (ictcRPQMappingDTO.getId() != null) {
            throw new BadRequestAlertException("A new ictcRPQMapping cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IctcRPQMappingDTO result = ictcRPQMappingService.save(ictcRPQMappingDTO);
        return ResponseEntity.created(new URI("/api/ictc-rpq-mappings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ictc-rpq-mappings} : Updates an existing ictcRPQMapping.
     *
     * @param ictcRPQMappingDTO the ictcRPQMappingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ictcRPQMappingDTO,
     * or with status {@code 400 (Bad Request)} if the ictcRPQMappingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ictcRPQMappingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ictc-rpq-mappings")
    public ResponseEntity<IctcRPQMappingDTO> updateIctcRPQMapping(@RequestBody IctcRPQMappingDTO ictcRPQMappingDTO) throws URISyntaxException {
        log.debug("REST request to update IctcRPQMapping : {}", ictcRPQMappingDTO);
        if (ictcRPQMappingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IctcRPQMappingDTO result = ictcRPQMappingService.save(ictcRPQMappingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ictcRPQMappingDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ictc-rpq-mappings} : get all the ictcRPQMappings.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ictcRPQMappings in body.
     */
    @GetMapping("/ictc-rpq-mappings")
    public ResponseEntity<List<IctcRPQMappingDTO>> getAllIctcRPQMappings(IctcRPQMappingCriteria criteria, Pageable pageable) {
        log.debug("REST request to get IctcRPQMappings by criteria: {}", criteria);
        Page<IctcRPQMappingDTO> page = ictcRPQMappingQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ictc-rpq-mappings/count} : count all the ictcRPQMappings.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/ictc-rpq-mappings/count")
    public ResponseEntity<Long> countIctcRPQMappings(IctcRPQMappingCriteria criteria) {
        log.debug("REST request to count IctcRPQMappings by criteria: {}", criteria);
        return ResponseEntity.ok().body(ictcRPQMappingQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ictc-rpq-mappings/:id} : get the "id" ictcRPQMapping.
     *
     * @param id the id of the ictcRPQMappingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ictcRPQMappingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-rpq-mappings/{id}")
    public ResponseEntity<IctcRPQMappingDTO> getIctcRPQMapping(@PathVariable Long id) {
        log.debug("REST request to get IctcRPQMapping : {}", id);
        Optional<IctcRPQMappingDTO> ictcRPQMappingDTO = ictcRPQMappingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ictcRPQMappingDTO);
    }

    /**
     * {@code DELETE  /ictc-rpq-mappings/:id} : delete the "id" ictcRPQMapping.
     *
     * @param id the id of the ictcRPQMappingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ictc-rpq-mappings/{id}")
    public ResponseEntity<Void> deleteIctcRPQMapping(@PathVariable Long id) {
        log.debug("REST request to delete IctcRPQMapping : {}", id);
        ictcRPQMappingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
