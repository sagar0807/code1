package gov.naco.soch.ti.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.OstBenDto;
import gov.naco.soch.ti.dto.TIOstBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIOstBeneficiaryDTO;
import gov.naco.soch.ti.service.TIOstBeneficiaryQueryService;
import gov.naco.soch.ti.service.TiOstBenQueryService;
import gov.naco.soch.ti.service.TiOstBeneficiaryServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIOstBeneficiaryResource {

    private final Logger log = LoggerFactory.getLogger(TIOstBeneficiaryResource.class);

    private static final String ENTITY_NAME = "tiOstBeneficiary";

    private static final String APPLICATION_NAME = "TI";

    private final TiOstBeneficiaryServiceImpl tIBeneficiaryService;

    private final TIOstBeneficiaryQueryService tIBeneficiaryQueryService;

    private final TiOstBenQueryService ostBenQueryService;

    public TIOstBeneficiaryResource(TiOstBeneficiaryServiceImpl tIBeneficiaryService,
	    TIOstBeneficiaryQueryService tIBeneficiaryQueryService, TiOstBenQueryService ostBenQueryService) {
	this.tIBeneficiaryService = tIBeneficiaryService;
	this.tIBeneficiaryQueryService = tIBeneficiaryQueryService;
	this.ostBenQueryService = ostBenQueryService;
    }

    /**
     * {@code POST  /ti-beneficiaries} : Create a new tIBeneficiary.
     *
     * @param tIBeneficiaryDTO the tIBeneficiaryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with
     *         body the new tIBeneficiaryDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBeneficiary has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ti-ost-beneficiary/save")
    public ResponseEntity<TIOstBeneficiaryDTO> createTIBeneficiary(
	    @Valid @RequestBody TIOstBeneficiaryDTO tIBeneficiaryDTO) throws URISyntaxException {
	log.debug("REST request to save TIBeneficiary : {}", tIBeneficiaryDTO);

	boolean check = tIBeneficiaryService.validateOstCode(tIBeneficiaryDTO.getOstCode(),
		tIBeneficiaryDTO.getFacility().getId());

	if (check == false) {
	    throw new BadRequestAlertException("OstCode already exists", ENTITY_NAME, "1");

	}

	if (tIBeneficiaryDTO.getBeneficiaryReferral() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferral().getReferredToFacility() != null) {
	    String facilityType = tIBeneficiaryService.checkDuplicateReferral(
		    tIBeneficiaryDTO.getMasterBeneficiary().getId(),
		    tIBeneficiaryDTO.getBeneficiaryReferral().getReferredToFacility());
	    if (facilityType != null) {
		throw new BadRequestAlertException("Beneficiary is already registered in " + facilityType, ENTITY_NAME,
			"3");
	    }
	}

	if (tIBeneficiaryDTO.getBeneficiaryReferral() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferral().getId() == null) {
	    boolean iduCheck = tIBeneficiaryService.validateIduReferral(tIBeneficiaryDTO.getBeneficiaryReferral());
	    if (!iduCheck) {
		throw new BadRequestAlertException("Referral not allowed to a non IDU TI facility", ENTITY_NAME, "10");
	    }
	}

	TIOstBeneficiaryDTO result = tIBeneficiaryService.save(tIBeneficiaryDTO);
	return ResponseEntity.created(new URI("/ti-beneficiary/save"))
		.headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, "created"))
		.body(result);
    }

    /**
     * {@code PUT  /ti-beneficiaries} : Updates an existing tIBeneficiary.
     *
     * @param tIBeneficiaryDTO the tIBeneficiaryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the updated tIBeneficiaryDTO, or with status
     *         {@code 400 (Bad Request)} if the tIBeneficiaryDTO is not valid, or
     *         with status {@code 500 (Internal Server Error)} if the
     *         tIBeneficiaryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ti-ost-beneficiary/update")
    public ResponseEntity<TIOstBeneficiaryDTO> updateTIBeneficiary(
	    @Valid @RequestBody TIOstBeneficiaryDTO tIBeneficiaryDTO) throws URISyntaxException {
	log.debug("REST request to update TIBeneficiary : {}", tIBeneficiaryDTO);

	boolean check = tIBeneficiaryService.validateOstCodeForExistingBeneficiary(tIBeneficiaryDTO.getOstCode(),
		tIBeneficiaryDTO.getFacility().getId(), tIBeneficiaryDTO.getId());

	if (check == false) {
	    throw new BadRequestAlertException("OstCode already exists", ENTITY_NAME, "1");

	}

	boolean ostCheck = tIBeneficiaryService.validateOstNumberForExistingBeneficiary(tIBeneficiaryDTO.getOstNumber(),
		tIBeneficiaryDTO.getId(), tIBeneficiaryDTO.getFacility().getId());

	if (ostCheck == false) {
	    throw new BadRequestAlertException("Ost Number already exists", ENTITY_NAME, "2");

	}
	if (tIBeneficiaryDTO.getBeneficiaryReferral() != null) {
	    String facilityType = tIBeneficiaryService.checkDuplicateReferral(
		    tIBeneficiaryDTO.getMasterBeneficiary().getId(),
		    tIBeneficiaryDTO.getBeneficiaryReferral().getReferredToFacility());
	    if (facilityType != null) {
		throw new BadRequestAlertException("Beneficiary is already registered in " + facilityType, ENTITY_NAME,
			"3");
	    }
	}

	if (tIBeneficiaryDTO.getBeneficiaryReferral() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferral().getId() == null) {
	    boolean iduCheck = tIBeneficiaryService.validateIduReferral(tIBeneficiaryDTO.getBeneficiaryReferral());
	    if (!iduCheck) {
		throw new BadRequestAlertException("Referral not allowed to a non IDU TI facility", ENTITY_NAME, "10");
	    }
	}

	TIOstBeneficiaryDTO result = tIBeneficiaryService.update(tIBeneficiaryDTO);
	return ResponseEntity.ok()
		.headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, "updated"))
		.body(result);
    }

    /**
     * {@code GET  /ti-beneficiaries} : get all the tIBeneficiaries.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBeneficiaries in body.
     */
    @GetMapping("/ti-ost-beneficiaries")
    public ResponseEntity<List<TIOstBeneficiaryDTO>> getAllTIBeneficiaries(TIOstBeneficiaryCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
	Page<TIOstBeneficiaryDTO> page = tIBeneficiaryQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBeneficiaryQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/v1/ti-ost-beneficiaries")
    public ResponseEntity<List<OstBenDto>> getAllTIOstBeneficiaries(TIOstBeneficiaryCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
	Page<OstBenDto> page = ostBenQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBeneficiaryQueryService.countByCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-beneficiaries} : get all the tIBeneficiaries.
     *
     * 
     * @param pageable the pagination information.
     * 
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of tIBeneficiaries in body.
     */
    @GetMapping("/ti-ost-beneficiaries/search")
    public ResponseEntity<List<TIOstBeneficiaryDTO>> searchAllTIBeneficiaries(TIOstBeneficiaryCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
	Page<TIOstBeneficiaryDTO> page = tIBeneficiaryQueryService.searchByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	long totalCount = tIBeneficiaryQueryService.countBySearchCriteria(criteria);
	if (!page.getContent().isEmpty()) {
	    page.getContent().get(0).setCount(totalCount);
	}
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ti-beneficiaries/count} : count all the tIBeneficiaries.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ti-ost-beneficiaries/count")
    public ResponseEntity<Long> countTIBeneficiaries(TIOstBeneficiaryCriteria criteria) {
	log.debug("REST request to count TIBeneficiaries by criteria: {}", criteria);
	return ResponseEntity.ok().body(tIBeneficiaryQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ti-beneficiaries/:id} : get the "id" tIBeneficiary.
     *
     * @param id the id of the tIBeneficiaryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the tIBeneficiaryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ti-ost-beneficiaries/{id}")
    public ResponseEntity<TIOstBeneficiaryDTO> getTIBeneficiary(@PathVariable Long id) {
	log.debug("REST request to get TIBeneficiary : {}", id);
	Optional<TIOstBeneficiaryDTO> tIBeneficiaryDTO = tIBeneficiaryService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIBeneficiaryDTO);
    }

    /**
     * {@code DELETE  /ti-beneficiaries/:id} : delete the "id" tIBeneficiary.
     *
     * @param id the id of the tIBeneficiaryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @PostMapping("/ti-ost-beneficiaries/{id}/{deleteReason}")
    public ResponseEntity<Void> deleteTIBeneficiary(@PathVariable("id") Long id,
	    @PathVariable("deleteReason") Long deleteReasonId) {
	log.debug("REST request to delete TIBeneficiary : {}", id);
	tIBeneficiaryService.delete(id, deleteReasonId);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }
}