package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.service.BeneficiaryReferralQueryService;
import gov.naco.soch.service.BeneficiaryReferralService;
import gov.naco.soch.service.dto.BeneficiaryReferralCriteria;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.BeneficiaryReferral}.
 */
@RestController
@RequestMapping("/api")
public class BeneficiaryReferralResource {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryReferralResource.class);

    private static final String ENTITY_NAME = "sochictcBeneficiaryReferral";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BeneficiaryReferralService beneficiaryReferralService;

    private final BeneficiaryReferralQueryService beneficiaryReferralQueryService;

    public BeneficiaryReferralResource(BeneficiaryReferralService beneficiaryReferralService, BeneficiaryReferralQueryService beneficiaryReferralQueryService) {
        this.beneficiaryReferralService = beneficiaryReferralService;
        this.beneficiaryReferralQueryService = beneficiaryReferralQueryService;
    }

    /**
     * {@code POST  /beneficiary-referrals} : Create a new beneficiaryReferral.
     *
     * @param beneficiaryReferralDTO the beneficiaryReferralDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new beneficiaryReferralDTO, or with status {@code 400 (Bad Request)} if the beneficiaryReferral has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/beneficiary-referrals")
    public ResponseEntity<BeneficiaryReferralDTO> createBeneficiaryReferral(@RequestBody BeneficiaryReferralDTO beneficiaryReferralDTO) throws URISyntaxException {
        log.debug("REST request to save BeneficiaryReferral : {}", beneficiaryReferralDTO);
        if (beneficiaryReferralDTO.getId() != null) {
            throw new BadRequestAlertException("A new beneficiaryReferral cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BeneficiaryReferralDTO result = beneficiaryReferralService.saveReferral(beneficiaryReferralDTO);
        return ResponseEntity.created(new URI("/api/beneficiary-referrals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /beneficiary-referrals} : Updates an existing beneficiaryReferral.
     *
     * @param beneficiaryReferralDTO the beneficiaryReferralDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated beneficiaryReferralDTO,
     * or with status {@code 400 (Bad Request)} if the beneficiaryReferralDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the beneficiaryReferralDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/beneficiary-referrals")
    public ResponseEntity<BeneficiaryReferralDTO> updateBeneficiaryReferral(@RequestBody BeneficiaryReferralDTO beneficiaryReferralDTO) throws URISyntaxException {
        log.debug("REST request to update BeneficiaryReferral : {}", beneficiaryReferralDTO);
        if (beneficiaryReferralDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BeneficiaryReferralDTO result = beneficiaryReferralService.save(beneficiaryReferralDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, beneficiaryReferralDTO.getId().toString()))
            .body(result);
    }
    
    /**
     * {@code GET  /beneficiary-referrals/other-pending/basic} : get all the beneficiaryReferrals.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaryReferrals in body.
     */
    @GetMapping("/beneficiary-referrals/other-pending/basic")
    public ResponseEntity<List<BeneficiaryReferral>> getAllOtherPendingBeneficiaryReferralsBasic(BeneficiaryReferralCriteria criteria, Pageable pageable) {
        log.debug("REST request to get all other pending BeneficiaryReferrals by criteria: {}", criteria);
        Page<BeneficiaryReferral> page = beneficiaryReferralQueryService.findOtherPendingResultsBasic(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * {@code GET  /beneficiary-referrals/other-pending/advanced} : get all the beneficiaryReferrals.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaryReferrals in body.
     */
    @GetMapping("/beneficiary-referrals/other-pending/advanced")
    public ResponseEntity<List<BeneficiaryReferral>> getAllOtherPendingBeneficiaryReferralsAdvanced(BeneficiaryReferralCriteria criteria, Pageable pageable) {
        log.debug("REST request to get all other pending BeneficiaryReferrals by criteria: {}", criteria);
        Page<BeneficiaryReferral> page = beneficiaryReferralQueryService.findOtherPendingResultsAdvanced(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /beneficiary-referrals} : get all the beneficiaryReferrals.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaryReferrals in body.
     */
    @GetMapping("/beneficiary-referrals")
    public ResponseEntity<List<BeneficiaryReferral>> getAllBeneficiaryReferrals(BeneficiaryReferralCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BeneficiaryReferrals by criteria: {}", criteria);
        Page<BeneficiaryReferral> page = beneficiaryReferralQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/beneficiary-referrals/basic")
    public ResponseEntity<List<BeneficiaryReferral>> getAllBeneficiaryReferralsBasic(BeneficiaryReferralCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BeneficiaryReferrals by criteria: {}", criteria);
        Page<BeneficiaryReferral> page = beneficiaryReferralQueryService.find(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    @GetMapping("/beneficiary-referrals/advanced")
    public ResponseEntity<List<BeneficiaryReferral>> getAllBeneficiaryReferralsAdvanced(BeneficiaryReferralCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BeneficiaryReferrals by criteria: {}", criteria);
        Page<BeneficiaryReferral> page = beneficiaryReferralQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /beneficiary-referrals/count} : count all the beneficiaryReferrals.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/beneficiary-referrals/count")
    public ResponseEntity<Long> countBeneficiaryReferrals(BeneficiaryReferralCriteria criteria) {
        log.debug("REST request to count BeneficiaryReferrals by criteria: {}", criteria);
        return ResponseEntity.ok().body(beneficiaryReferralQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /beneficiary-referrals/:id} : get the "id" beneficiaryReferral.
     *
     * @param id the id of the beneficiaryReferralDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the beneficiaryReferralDTO, or with status {@code 404 (Not Found)}.
     */
//    @GetMapping("/beneficiary-referrals/{id}")
//    public ResponseEntity<BeneficiaryReferralDTO> getBeneficiaryReferral(@PathVariable Long id) {
//        log.debug("REST request to get BeneficiaryReferral : {}", id);
//        Optional<BeneficiaryReferralDTO> beneficiaryReferralDTO = beneficiaryReferralService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(beneficiaryReferralDTO);
//    }
    
    @GetMapping("/beneficiary-referrals/{id}")
    public ResponseEntity<BeneficiaryReferral> getBeneficiaryReferral(@PathVariable Long id) {
        log.debug("REST request to get BeneficiaryReferral : {}", id);
        Optional<BeneficiaryReferral> beneficiaryReferralDTO = beneficiaryReferralService.find(id);
        return ResponseUtil.wrapOrNotFound(beneficiaryReferralDTO);
    }

    /**
     * {@code DELETE  /beneficiary-referrals/:id} : delete the "id" beneficiaryReferral.
     *
     * @param id the id of the beneficiaryReferralDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/beneficiary-referrals/{id}")
    public ResponseEntity<Void> deleteBeneficiaryReferral(@PathVariable Long id) {
        log.debug("REST request to delete BeneficiaryReferral : {}", id);
        beneficiaryReferralService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
    
    /**
     * {@code GET  /beneficiary-referrals/decline/:id} : decline the beneficiaryReferral with id 
     *
     * @param id the id of the beneficiaryReferral to decline.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the beneficiaryReferralDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/beneficiary-referrals/decline/{id}")
    public ResponseEntity<Void> declineBeneficiaryReferral(@PathVariable Long id) {
        log.debug("REST request to get BeneficiaryReferral : {}", id);
        beneficiaryReferralService.declineBeneficiaryReferral(id);
        return ResponseEntity.ok().build();
    }

}
