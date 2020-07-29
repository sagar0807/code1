package gov.naco.soch.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.domain.ICTCTestResultView;
import gov.naco.soch.service.ICTCTestResultViewQueryService;
import gov.naco.soch.service.ICTCTestResultViewService;
import gov.naco.soch.service.dto.ICTCTestResultViewCriteria;
import gov.naco.soch.service.dto.ICTCTestResultViewDTO;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing ICTCTestResultView.
 */
@RestController
@RequestMapping("/api")
public class ICTCTestResultViewResource {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultViewResource.class);

    private static final String ENTITY_NAME = "iCTCTestResultView";

    private final ICTCTestResultViewService iCTCTestResultViewService;

    private final ICTCTestResultViewQueryService iCTCTestResultViewQueryService;

    public ICTCTestResultViewResource(ICTCTestResultViewService iCTCTestResultViewService, ICTCTestResultViewQueryService iCTCTestResultViewQueryService) {
        this.iCTCTestResultViewService = iCTCTestResultViewService;
        this.iCTCTestResultViewQueryService = iCTCTestResultViewQueryService;
    }
  
    /**
     * GET  /ictc-test-result-views/advanced : get all the iCTCTestResultViews.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResultViews in body
     */
    @GetMapping("/ictc-test-result-views/advanced")
    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsAdvanced(ICTCTestResultViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    /**
     * GET  /ictc-test-result-views/basic : get all the iCTCTestResultViews.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResultViews in body
     */
    @GetMapping("/ictc-test-result-views/basic")
    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsBasic(ICTCTestResultViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByBasicCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /ictc-test-result-views/:id : get the "id" iCTCTestResultView.
     *
     * @param id the id of the iCTCTestResultViewDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the iCTCTestResultViewDTO, or with status 404 (Not Found)
     */
    @GetMapping("/ictc-test-result-views/{id}")
    public ResponseEntity<ICTCTestResultView> getICTCTestResultView(@PathVariable Long id) {
        log.debug("REST request to get ICTCTestResultView : {}", id);
        Optional<ICTCTestResultView> iCTCTestResultView = iCTCTestResultViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCTestResultView);
    }

}
