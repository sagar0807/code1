package gov.naco.soch.ti.controller;


import gov.naco.soch.ti.dto.TIBeneficiaryCommDisCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryCommDisDTO;
import gov.naco.soch.ti.service.TIBeneficiaryCommDisQueryService;
import gov.naco.soch.ti.service.TIBeneficiaryCommDisServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;


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
 * REST controller for managing {@link gov.naco.soch.domain.TIBeneficiaryCommDis}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBeneficiaryCommDisResource {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiaryCommDisResource.class);

    private static final String ENTITY_NAME = "tIBeneficiaryCommDis";

    private static final String APPLICATION_NAME = "TI";

    private final TIBeneficiaryCommDisServiceImpl tIBeneficiaryCommDisService;

    private final TIBeneficiaryCommDisQueryService tIBeneficiaryCommDisQueryService;

    public TIBeneficiaryCommDisResource(TIBeneficiaryCommDisServiceImpl tIBeneficiaryCommDisService, TIBeneficiaryCommDisQueryService tIBeneficiaryCommDisQueryService) {
        this.tIBeneficiaryCommDisService = tIBeneficiaryCommDisService;
        this.tIBeneficiaryCommDisQueryService = tIBeneficiaryCommDisQueryService;
    }

    /**
     * {@code POST  /ti-beneficiary-comm-dis} : Create a new tIBeneficiaryCommDis.
     *
     * @param tIBeneficiaryCommDisDTO the tIBeneficiaryCommDisDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tIBeneficiaryCommDisDTO, or with status {@code 400 (Bad Request)} if the tIBeneficiaryCommDis has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-beneficiary-comm-dis")
    public ResponseEntity<TIBeneficiaryCommDisDTO> createTIBeneficiaryCommDis(@Valid @RequestBody TIBeneficiaryCommDisDTO tIBeneficiaryCommDisDTO) throws URISyntaxException {
        log.debug("REST request to save TIBeneficiaryCommDis : {}", tIBeneficiaryCommDisDTO);
        if (tIBeneficiaryCommDisDTO.getId() != null) {
            throw new BadRequestAlertException("A new tIBeneficiaryCommDis cannot already have an ID", ENTITY_NAME, "idexists");
        }
        boolean check=tIBeneficiaryCommDisService.validateMultipleDistribution(tIBeneficiaryCommDisDTO.getBeneficiary().getId(),
        	tIBeneficiaryCommDisDTO.getDistributionDate());
        if(!check)
        {
            throw new BadRequestAlertException("Distribution for this client has already been recorded for this date" , ENTITY_NAME, "9");
        }
        TIBeneficiaryCommDisDTO result = tIBeneficiaryCommDisService.save(tIBeneficiaryCommDisDTO);
        return ResponseEntity.created(new URI("/api/ti-beneficiary-comm-dis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ti-beneficiary-comm-dis} : Updates an existing tIBeneficiaryCommDis.
     *
     * @param tIBeneficiaryCommDisDTO the tIBeneficiaryCommDisDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tIBeneficiaryCommDisDTO,
     * or with status {@code 400 (Bad Request)} if the tIBeneficiaryCommDisDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tIBeneficiaryCommDisDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-beneficiary-comm-dis")
    public ResponseEntity<TIBeneficiaryCommDisDTO> updateTIBeneficiaryCommDis(@Valid @RequestBody TIBeneficiaryCommDisDTO tIBeneficiaryCommDisDTO) throws URISyntaxException {
        log.debug("REST request to update TIBeneficiaryCommDis : {}", tIBeneficiaryCommDisDTO);
        if (tIBeneficiaryCommDisDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        boolean check=tIBeneficiaryCommDisService.validateMultipleDistribution(tIBeneficiaryCommDisDTO.getBeneficiary().getId(),tIBeneficiaryCommDisDTO.getDistributionDate());
        if(!check)
        {
            throw new BadRequestAlertException("Distribution for this client has already been recorded for this date" , ENTITY_NAME, "9");
        }
        TIBeneficiaryCommDisDTO result = tIBeneficiaryCommDisService.save(tIBeneficiaryCommDisDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, tIBeneficiaryCommDisDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ti-beneficiary-comm-dis} : get all the tIBeneficiaryCommDis.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBeneficiaryCommDis in body.
     */
    @GetMapping("/ti-beneficiary-comm-dis")
    public ResponseEntity<List<TIBeneficiaryCommDisDTO>> getAllTIBeneficiaryCommDis(TIBeneficiaryCommDisCriteria criteria, Pageable pageable) {
        log.debug("REST request to get TIBeneficiaryCommDis by criteria: {}", criteria);
        Page<TIBeneficiaryCommDisDTO> page = tIBeneficiaryCommDisQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        long totalCount=tIBeneficiaryCommDisQueryService.countByCriteria(criteria);
     	headers.add("totalCount", String.valueOf(totalCount));
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /ti-beneficiary-comm-dis/count} : count all the tIBeneficiaryCommDis.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/ti-beneficiary-comm-dis/count")
    public ResponseEntity<Long> countTIBeneficiaryCommDis(TIBeneficiaryCommDisCriteria criteria) {
        log.debug("REST request to count TIBeneficiaryCommDis by criteria: {}", criteria);
        return ResponseEntity.ok().body(tIBeneficiaryCommDisQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-beneficiary-comm-dis/:id} : get the "id" tIBeneficiaryCommDis.
     *
     * @param id the id of the tIBeneficiaryCommDisDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tIBeneficiaryCommDisDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-beneficiary-comm-dis/{id}")
    public ResponseEntity<TIBeneficiaryCommDisDTO> getTIBeneficiaryCommDis(@PathVariable Long id) {
        log.debug("REST request to get TIBeneficiaryCommDis : {}", id);
        Optional<TIBeneficiaryCommDisDTO> tIBeneficiaryCommDisDTO = tIBeneficiaryCommDisService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tIBeneficiaryCommDisDTO);
    }

    /**
     * {@code DELETE  /ti-beneficiary-comm-dis/:id} : delete the "id" tIBeneficiaryCommDis.
     *
     * @param id the id of the tIBeneficiaryCommDisDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ti-beneficiary-comm-dis/{id}")
    public ResponseEntity<Void> deleteTIBeneficiaryCommDis(@PathVariable Long id) {
        log.debug("REST request to delete TIBeneficiaryCommDis : {}", id);
        tIBeneficiaryCommDisService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString())).build();
    }
}
