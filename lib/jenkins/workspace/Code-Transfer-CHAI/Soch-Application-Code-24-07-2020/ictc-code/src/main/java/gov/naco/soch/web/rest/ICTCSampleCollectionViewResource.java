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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.service.ICTCSampleCollectionViewQueryService;
import gov.naco.soch.service.ICTCSampleCollectionViewService;
import gov.naco.soch.service.dto.ICTCSampleCollectionViewCriteria;
import gov.naco.soch.service.dto.ICTCSampleCollectionViewDTO;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.micrometer.core.annotation.Timed;

/**
 * REST controller for managing ICTCSampleCollectionView.
 */
@RestController
@RequestMapping("/api")
public class ICTCSampleCollectionViewResource {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionViewResource.class);

    private static final String ENTITY_NAME = "iCTCSampleCollectionView";

    private final ICTCSampleCollectionViewService iCTCSampleCollectionViewService;

    private final ICTCSampleCollectionViewQueryService iCTCSampleCollectionViewQueryService;

    public ICTCSampleCollectionViewResource(ICTCSampleCollectionViewService iCTCSampleCollectionViewService, ICTCSampleCollectionViewQueryService iCTCSampleCollectionViewQueryService) {
        this.iCTCSampleCollectionViewService = iCTCSampleCollectionViewService;
        this.iCTCSampleCollectionViewQueryService = iCTCSampleCollectionViewQueryService;
    }


    /**
     * GET  /ictc-sample-collection-views : get all the iCTCSampleCollectionViews.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of iCTCSampleCollectionViews in body
     */
    @GetMapping("/ictc-sample-collection-views")
    public ResponseEntity<List<ICTCSampleCollectionViewDTO>> getAllICTCSampleCollectionViews(ICTCSampleCollectionViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCSampleCollectionViews by criteria: {}", criteria);
        Page<ICTCSampleCollectionViewDTO> page = iCTCSampleCollectionViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /ictc-sample-collection-views/:id : get the "id" iCTCSampleCollectionView.
     *
     * @param id the id of the iCTCSampleCollectionViewDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the iCTCSampleCollectionViewDTO, or with status 404 (Not Found)
     */
    @GetMapping("/ictc-sample-collection-views/{id}")
    @Timed
    public ResponseEntity<ICTCSampleCollectionViewDTO> getICTCSampleCollectionView(@PathVariable Long id) {
        log.debug("REST request to get ICTCSampleCollectionView : {}", id);
        Optional<ICTCSampleCollectionViewDTO> iCTCSampleCollectionViewDTO = iCTCSampleCollectionViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCSampleCollectionViewDTO);
    }

}
