package gov.naco.soch.web.rest;

import gov.naco.soch.service.ICTCBeneficiaryVisitService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitCriteria;
import gov.naco.soch.service.ICTCBeneficiaryVisitQueryService;

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
import java.util.stream.StreamSupport;


/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCBeneficiaryVisit}.
 */
@RestController
@RequestMapping("/api")
public class ICTCBeneficiaryVisitController {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryVisitController.class);

    private static final String ENTITY_NAME = "sochictcIctcBeneficiaryVisit";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCBeneficiaryVisitService iCTCBeneficiaryVisitService;

    private final ICTCBeneficiaryVisitQueryService iCTCBeneficiaryVisitQueryService;

    public ICTCBeneficiaryVisitController(ICTCBeneficiaryVisitService iCTCBeneficiaryVisitService, ICTCBeneficiaryVisitQueryService iCTCBeneficiaryVisitQueryService) {
        this.iCTCBeneficiaryVisitService = iCTCBeneficiaryVisitService;
        this.iCTCBeneficiaryVisitQueryService = iCTCBeneficiaryVisitQueryService;
    }

    /**
     * {@code GET  /ictc-visit-list} : get all the iCTCBeneficiaryVisits.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaryVisits in body.
     */
    @GetMapping("/ictc-visit-list")
    public ResponseEntity<List<ICTCBeneficiaryVisitDTO>> getAllICTCBeneficiaryVisits(ICTCBeneficiaryVisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
        Page<ICTCBeneficiaryVisitDTO> page = iCTCBeneficiaryVisitQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/ictc-visit-list/basic")
    public ResponseEntity<List<ICTCBeneficiaryVisitDTO>> getAllICTCBeneficiaryVisitsBasic(ICTCBeneficiaryVisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
        Page<ICTCBeneficiaryVisitDTO> page = iCTCBeneficiaryVisitQueryService.findByCriteriaBasic(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/ictc-visit-list/advanced")
    public ResponseEntity<List<ICTCBeneficiaryVisitDTO>> getAllICTCBeneficiaryVisitsAdvanced(ICTCBeneficiaryVisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
        Page<ICTCBeneficiaryVisitDTO> page = iCTCBeneficiaryVisitQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * {@code GET  /ictc-visit-list-search} : get all the iCTCBeneficiaryVisits.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaryVisits in body.
     */
    @GetMapping("/ictc-visit-list-search")
    public ResponseEntity<List<ICTCBeneficiaryVisitDTO>> searchAllICTCBeneficiaryVisits(ICTCBeneficiaryVisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
        Page<ICTCBeneficiaryVisitDTO> page = iCTCBeneficiaryVisitQueryService.searchByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ictc-visit-lists/:id} : get the "id" iCTCBeneficiaryVisit.
     *
     * @param id the id of the iCTCBeneficiaryVisitDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCBeneficiaryVisitDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-visit-list/{id}")
    public ResponseEntity<ICTCBeneficiaryVisitDTO> getICTCBeneficiaryVisit(@PathVariable Long id) {
        log.debug("REST request to get ICTCBeneficiaryVisit : {}", id);
        Optional<ICTCBeneficiaryVisitDTO> iCTCBeneficiaryVisitDTO = iCTCBeneficiaryVisitService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCBeneficiaryVisitDTO);
    }

}
