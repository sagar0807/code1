package gov.naco.soch.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.service.ICTCBeneficiaryFollowUpViewQueryService;
import gov.naco.soch.service.ICTCBeneficiaryFollowUpViewService;
import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewDTO;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCBeneficiaryFollowUpView}.
 */
@RestController
@RequestMapping("/api")
public class ICTCBeneficiaryFollowUpViewController {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryFollowUpViewController.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCBeneficiaryFollowUpViewService ictcBeneficiaryFollowUpViewService;

    private final ICTCBeneficiaryFollowUpViewQueryService ictcBeneficiaryFollowUpViewQueryService;

    public ICTCBeneficiaryFollowUpViewController(ICTCBeneficiaryFollowUpViewService ictcBeneficiaryFollowUpViewService, ICTCBeneficiaryFollowUpViewQueryService ictcBeneficiaryFollowUpViewQueryService) {
        this.ictcBeneficiaryFollowUpViewService = ictcBeneficiaryFollowUpViewService;
        this.ictcBeneficiaryFollowUpViewQueryService = ictcBeneficiaryFollowUpViewQueryService;
    }

    
    /**
     * {@code GET  /ictc-beneficiary-followups} : get all the iCTCBeneficiaryFollowups.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaryFollowups in body.
     */
    @GetMapping("/ictc-follow-up-view-list")
    public ResponseEntity<List<ICTCBeneficiaryFollowUpViewDTO>> getAllICTCBeneficiaryFollowups(ICTCBeneficiaryFollowUpViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryFollowups by criteria: {}", criteria);
        Page<ICTCBeneficiaryFollowUpViewDTO> page = ictcBeneficiaryFollowUpViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    
    @GetMapping("/ictc-follow-up-view-list/basic")
    public ResponseEntity<List<ICTCBeneficiaryFollowUpViewDTO>> getAllICTCBeneficiaryFollowupsBasic(ICTCBeneficiaryFollowUpViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryFollowups by criteria: {}", criteria);
        Page<ICTCBeneficiaryFollowUpViewDTO> page = ictcBeneficiaryFollowUpViewQueryService.findByCriteriaBasic(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/ictc-follow-up-view-list/advanced")
    public ResponseEntity<List<ICTCBeneficiaryFollowUpViewDTO>> getAllICTCBeneficiaryFollowupsAdvanced(ICTCBeneficiaryFollowUpViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryFollowups by criteria: {}", criteria);
        Page<ICTCBeneficiaryFollowUpViewDTO> page = ictcBeneficiaryFollowUpViewQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    /**
     * {@code GET  /ictc-beneficiary-followups/:id} : get the "id" iCTCBeneficiaryFollowup.
     *
     * @param id the id of the iCTCBeneficiaryFollowupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ICTCBeneficiaryFollowUpViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-follow-up-view-list/{id}")
    public ResponseEntity<ICTCBeneficiaryFollowUpViewDTO> getICTCBeneficiaryFollowup(@PathVariable Long id) {
        log.debug("REST request to get ICTCBeneficiaryFollowup : {}", id);
        Optional<ICTCBeneficiaryFollowUpViewDTO> iCTCBeneficiaryFollowupDTO = ictcBeneficiaryFollowUpViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCBeneficiaryFollowupDTO);
    }
    
    /**
     * {@code GET  /ictc-follow-up-view-list//:id} : get the "id" iCTCBeneficiaryFollowup.
     *
     * @param id the id of the iCTCBeneficiaryFollowupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ICTCBeneficiaryFollowUpViewDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ictc-follow-up-view-list/disable/{id}")
    public ResponseEntity<Void> disableICTCBeneficiaryFollowup(@PathVariable Long id) {
        log.debug("REST request to disable ICTCBeneficiaryFollowup : {}", id);
        ictcBeneficiaryFollowUpViewService.disable(id);
        return ResponseEntity.ok().build();
    }

}