package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.domain.BeneficiaryFacilityMapping;
import gov.naco.soch.service.BeneficiaryFacilityMappingQueryService;
import gov.naco.soch.service.BeneficiaryFacilityMappingService;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingCriteria;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing BeneficiaryFacilityMapping.
 */
@RestController
@RequestMapping("/api")
public class BeneficiaryFacilityMappingResource {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryFacilityMappingResource.class);

    private static final String ENTITY_NAME = "beneficiaryFacilityMapping";

    private final BeneficiaryFacilityMappingService beneficiaryFacilityMappingService;

    private final BeneficiaryFacilityMappingQueryService beneficiaryFacilityMappingQueryService;

    public BeneficiaryFacilityMappingResource(BeneficiaryFacilityMappingService beneficiaryFacilityMappingService, BeneficiaryFacilityMappingQueryService beneficiaryFacilityMappingQueryService) {
        this.beneficiaryFacilityMappingService = beneficiaryFacilityMappingService;
        this.beneficiaryFacilityMappingQueryService = beneficiaryFacilityMappingQueryService;
    }

    /**
     * POST  /beneficiary-facility-mappings : Create a new beneficiaryFacilityMapping.
     *
     * @param beneficiaryFacilityMappingDTO the beneficiaryFacilityMappingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new beneficiaryFacilityMappingDTO, or with status 400 (Bad Request) if the beneficiaryFacilityMapping has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/beneficiary-facility-mappings")
    public ResponseEntity<BeneficiaryFacilityMappingDTO> createBeneficiaryFacilityMapping(@RequestBody BeneficiaryFacilityMappingDTO beneficiaryFacilityMappingDTO) throws URISyntaxException {
        log.debug("REST request to save BeneficiaryFacilityMapping : {}", beneficiaryFacilityMappingDTO);
        if (beneficiaryFacilityMappingDTO.getId() != null) {
            throw new BadRequestAlertException("A new beneficiaryFacilityMapping cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BeneficiaryFacilityMappingDTO result = beneficiaryFacilityMappingService.save(beneficiaryFacilityMappingDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityCreationAlert("ICTC", false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * PUT  /beneficiary-facility-mappings : Updates an existing beneficiaryFacilityMapping.
     *
     * @param beneficiaryFacilityMappingDTO the beneficiaryFacilityMappingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated beneficiaryFacilityMappingDTO,
     * or with status 400 (Bad Request) if the beneficiaryFacilityMappingDTO is not valid,
     * or with status 500 (Internal Server Error) if the beneficiaryFacilityMappingDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/beneficiary-facility-mappings")
    public ResponseEntity<BeneficiaryFacilityMappingDTO> updateBeneficiaryFacilityMapping(@RequestBody BeneficiaryFacilityMappingDTO beneficiaryFacilityMappingDTO) throws URISyntaxException {
        log.debug("REST request to update BeneficiaryFacilityMapping : {}", beneficiaryFacilityMappingDTO);
        if (beneficiaryFacilityMappingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BeneficiaryFacilityMappingDTO result = beneficiaryFacilityMappingService.save(beneficiaryFacilityMappingDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("ICTC", false, ENTITY_NAME, beneficiaryFacilityMappingDTO.getId().toString()))
                .body(result);
    }

    /**
     * GET  /beneficiary-facility-mappings : get all the beneficiaryFacilityMappings.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of beneficiaryFacilityMappings in body
     */
    @GetMapping("/beneficiary-facility-mappings")
    public ResponseEntity<List<BeneficiaryFacilityMappingDTO>> getAllBeneficiaryFacilityMappings(BeneficiaryFacilityMappingCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BeneficiaryFacilityMappings by criteria: {}", criteria);
        Page<BeneficiaryFacilityMappingDTO> page = beneficiaryFacilityMappingQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    
    @GetMapping("/beneficiary-facility-mappings/advanced")
    public ResponseEntity<List<BeneficiaryFacilityMapping>> getAllBeneficiaryFacilityMappingsAdvanced(BeneficiaryFacilityMappingCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BeneficiaryFacilityMappings by criteria: {}", criteria);
        Page<BeneficiaryFacilityMapping> page = beneficiaryFacilityMappingQueryService.findByCriteriaAdvanced(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    @GetMapping("/beneficiary-facility-mappings/art-beneficiary-search")
    public ResponseEntity<List<BeneficiaryFacilityMapping>> getAllBeneficiaryFacilityMappingsForArtBeneficiarySearch(BeneficiaryFacilityMappingCriteria criteria, Pageable pageable) {
        log.debug("REST request to get BeneficiaryFacilityMappings by criteria: {}", criteria);
        Page<BeneficiaryFacilityMapping> page = beneficiaryFacilityMappingQueryService.findByCriteriaForArtBeneficiarySearch(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /beneficiary-facility-mappings/:id : get the "id" beneficiaryFacilityMapping.
     *
     * @param id the id of the beneficiaryFacilityMappingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the beneficiaryFacilityMappingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/beneficiary-facility-mappings/{id}")
    public ResponseEntity<BeneficiaryFacilityMappingDTO> getBeneficiaryFacilityMapping(@PathVariable Long id) {
        log.debug("REST request to get BeneficiaryFacilityMapping : {}", id);
        Optional<BeneficiaryFacilityMappingDTO> beneficiaryFacilityMappingDTO = beneficiaryFacilityMappingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(beneficiaryFacilityMappingDTO);
    }

    /**
     * DELETE  /beneficiary-facility-mappings/:id : delete the "id" beneficiaryFacilityMapping.
     *
     * @param id the id of the beneficiaryFacilityMappingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/beneficiary-facility-mappings/{id}")
    public ResponseEntity<Void> deleteBeneficiaryFacilityMapping(@PathVariable Long id) {
        log.debug("REST request to delete BeneficiaryFacilityMapping : {}", id);
        beneficiaryFacilityMappingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert("ICTC", false, ENTITY_NAME, id.toString())).build();
    }
}
