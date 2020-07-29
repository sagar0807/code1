package gov.naco.soch.web.rest;

import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryCriteria;
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.service.ICTCBeneficiaryQueryService;

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
 * REST controller for managing {@link gov.naco.soch.domain.ICTCBeneficiary}.
 */
@RestController
@RequestMapping("/api")
public class ICTCBeneficiaryResource {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryResource.class);

    private static final String ENTITY_NAME = "sochictcIctcBeneficiary";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ICTCBeneficiaryService iCTCBeneficiaryService;

    private final ICTCBeneficiaryQueryService iCTCBeneficiaryQueryService;

    public ICTCBeneficiaryResource(ICTCBeneficiaryService iCTCBeneficiaryService, ICTCBeneficiaryQueryService iCTCBeneficiaryQueryService) {
        this.iCTCBeneficiaryService = iCTCBeneficiaryService;
        this.iCTCBeneficiaryQueryService = iCTCBeneficiaryQueryService;
    }

    /**
     * {@code POST  /ictc-beneficiaries} : Create a new iCTCBeneficiary.
     *
     * @param iCTCBeneficiaryDTO the iCTCBeneficiaryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCBeneficiaryDTO, or with status {@code 400 (Bad Request)} if the iCTCBeneficiary has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ictc-beneficiaries")
    public ResponseEntity<ICTCBeneficiaryDTO> createICTCBeneficiary(@Valid @RequestBody ICTCBeneficiaryDTO iCTCBeneficiaryDTO) throws URISyntaxException {
        log.debug("REST request to save ICTCBeneficiary : {}", iCTCBeneficiaryDTO);
        if (iCTCBeneficiaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new iCTCBeneficiary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ICTCBeneficiaryDTO result = iCTCBeneficiaryService.save(iCTCBeneficiaryDTO);
        return ResponseEntity.created(new URI("/api/ictc-beneficiaries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ictc-beneficiaries} : Updates an existing iCTCBeneficiary.
     *
     * @param iCTCBeneficiaryDTO the iCTCBeneficiaryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iCTCBeneficiaryDTO,
     * or with status {@code 400 (Bad Request)} if the iCTCBeneficiaryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the iCTCBeneficiaryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ictc-beneficiaries")
    public ResponseEntity<ICTCBeneficiaryDTO> updateICTCBeneficiary(@Valid @RequestBody ICTCBeneficiaryDTO iCTCBeneficiaryDTO) throws URISyntaxException {
        log.debug("REST request to update ICTCBeneficiary : {}", iCTCBeneficiaryDTO);
        if (iCTCBeneficiaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ICTCBeneficiaryDTO result = iCTCBeneficiaryService.save(iCTCBeneficiaryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iCTCBeneficiaryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ictc-beneficiaries} : get all the iCTCBeneficiaries.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaries in body.
     */
    @GetMapping("/ictc-beneficiaries")
    public ResponseEntity<List<ICTCBeneficiaryDTO>> getAllICTCBeneficiaries(ICTCBeneficiaryCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaries by criteria: {}", criteria);
        Page<ICTCBeneficiaryDTO> page = iCTCBeneficiaryQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * {@code GET  /ictc-beneficiaries-page} : get all the iCTCBeneficiaries.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaries in body.
     */
    @GetMapping("/ictc-beneficiaries-page")
    public ResponseEntity<List<ICTCBeneficiary>> getAllICTCBeneficiariesAsPage(ICTCBeneficiaryCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaries by criteria: {}", criteria);
        Page<ICTCBeneficiary> page = iCTCBeneficiaryQueryService.getPageByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ictc-beneficiaries/count} : count all the iCTCBeneficiaries.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/ictc-beneficiaries/count")
    public ResponseEntity<Long> countICTCBeneficiaries(ICTCBeneficiaryCriteria criteria) {
        log.debug("REST request to count ICTCBeneficiaries by criteria: {}", criteria);
        return ResponseEntity.ok().body(iCTCBeneficiaryQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ictc-beneficiaries/:id} : get the "id" iCTCBeneficiary.
     *
     * @param id the id of the iCTCBeneficiaryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCBeneficiaryDTO, or with status {@code 404 (Not Found)}.
     */
//    @GetMapping("/ictc-beneficiaries/{id}")
//    public ResponseEntity<ICTCBeneficiaryDTO> getICTCBeneficiary(@PathVariable Long id) {
//        log.debug("REST request to get ICTCBeneficiary : {}", id);
//        Optional<ICTCBeneficiaryDTO> iCTCBeneficiaryDTO = iCTCBeneficiaryService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCBeneficiaryDTO);
//    }
    
    @GetMapping("/ictc-beneficiaries/{id}")
    public ResponseEntity<ICTCBeneficiary> getICTCBeneficiary(@PathVariable Long id) {
        log.debug("REST request to get ICTCBeneficiary : {}", id);
        Optional<ICTCBeneficiary> iCTCBeneficiaryDTO = iCTCBeneficiaryService.find(id);
        return ResponseUtil.wrapOrNotFound(iCTCBeneficiaryDTO);
    }

    /**
     * {@code DELETE  /ictc-beneficiaries/:id} : delete the "id" iCTCBeneficiary.
     *
     * @param id the id of the iCTCBeneficiaryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ictc-beneficiaries/{id}")
    public ResponseEntity<Void> deleteICTCBeneficiary(@PathVariable Long id) {
        log.debug("REST request to delete ICTCBeneficiary : {}", id);
        iCTCBeneficiaryService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
