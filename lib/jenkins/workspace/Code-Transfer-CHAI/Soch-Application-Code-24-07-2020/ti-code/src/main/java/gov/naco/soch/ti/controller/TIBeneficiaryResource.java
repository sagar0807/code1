package gov.naco.soch.ti.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import gov.naco.soch.ti.dto.TIBenChildDetailsDTO;
import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenDto;
import gov.naco.soch.ti.service.TIBeneficiaryQueryService;
import gov.naco.soch.ti.service.TIBeneficiaryServiceImpl;
import gov.naco.soch.ti.service.TiBenQueryService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBeneficiary}.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TIBeneficiaryResource {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiaryResource.class);

    private static final String ENTITY_NAME = "tIBeneficiary";

    private static final String APPLICATION_NAME = "TI";

    private final TIBeneficiaryServiceImpl tIBeneficiaryService;

    private final TIBeneficiaryQueryService tIBeneficiaryQueryService;
    
    private final TiBenQueryService tiBenQueryService;

    public TIBeneficiaryResource(TIBeneficiaryServiceImpl tIBeneficiaryService,
	    TIBeneficiaryQueryService tIBeneficiaryQueryService,TiBenQueryService tiBenQueryService) {
	this.tIBeneficiaryService = tIBeneficiaryService;
	this.tIBeneficiaryQueryService = tIBeneficiaryQueryService;
	this.tiBenQueryService=tiBenQueryService;
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
    @PostMapping("/ti-beneficiary/save")
    public ResponseEntity<TIBeneficiaryDTO> createTIBeneficiary(@Valid @RequestBody TIBeneficiaryDTO tIBeneficiaryDTO)
	    throws URISyntaxException {
	log.debug("REST request to save TIBeneficiary : {}", tIBeneficiaryDTO);
	boolean check = tIBeneficiaryService.validateTICode(tIBeneficiaryDTO.getTiCode(),
		tIBeneficiaryDTO.getFacility().getId());
	if (check == false) {
	    throw new BadRequestAlertException("TiCode  already exists", ENTITY_NAME, "1");

	}

	if (tIBeneficiaryDTO.getBeneficiaryReferralDto() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility() != null) {
	    String facilityType = tIBeneficiaryService.checkDuplicateReferral(
		    tIBeneficiaryDTO.getMasterBeneficiary().getId(),
		    tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
	    if (facilityType != null) {
		throw new BadRequestAlertException("Beneficiary is already registered in " + facilityType, ENTITY_NAME,
			"3");
	    }
	}

	validateBenChilds(tIBeneficiaryDTO.getTiBenChildren());
	
	boolean peCodeCheck=tIBeneficiaryService.validatePeCode(tIBeneficiaryDTO.getPeCode(),tIBeneficiaryDTO.getFacility().getId());
	if(!peCodeCheck)
	{
	    throw new BadRequestAlertException("PE code cannot have more than 120 beneficiaries" , ENTITY_NAME,
			"13");
	}

	TIBeneficiaryDTO result = tIBeneficiaryService.save(tIBeneficiaryDTO);
	return ResponseEntity.created(new URI("/ti-beneficiary/save"))
		.headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, "created"))
		.body(result);

    }

    private void validateBenChilds(Set<TIBenChildDetailsDTO> tiBenChildren) {
	if (tiBenChildren != null) {
	    tiBenChildren.forEach(x -> {
		if (x.getAge() == null && x.getGenderId() == null) {
		    throw new BadRequestAlertException("Enter children details(age or gender)", ENTITY_NAME, "8");
		}
	    });
	}

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
    @PutMapping("/ti-beneficiary/update")
    public ResponseEntity<TIBeneficiaryDTO> updateTIBeneficiary(@Valid @RequestBody TIBeneficiaryDTO tIBeneficiaryDTO)
	    throws URISyntaxException {
	log.debug("REST request to update TIBeneficiary : {}", tIBeneficiaryDTO);
	boolean check = tIBeneficiaryService.validateTICodeForExistingBeneficiary(tIBeneficiaryDTO.getTiCode(),
		tIBeneficiaryDTO.getId(), tIBeneficiaryDTO.getFacility().getId());
	if (check == false) {
	    throw new BadRequestAlertException("TiCode already exists", ENTITY_NAME, "1");

	}
	if (tIBeneficiaryDTO.getBeneficiaryReferralDto() != null
		&& tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility() != null) {
	    String facilityType = tIBeneficiaryService.checkDuplicateReferral(
		    tIBeneficiaryDTO.getMasterBeneficiary().getId(),
		    tIBeneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
	    if (facilityType != null) {
		throw new BadRequestAlertException("Beneficiary is already registered in " + facilityType, ENTITY_NAME,
			"3");
	    }
	}

	validateBenChilds(tIBeneficiaryDTO.getTiBenChildren());
	
	boolean peCodeCheck=tIBeneficiaryService.validatePeCode(tIBeneficiaryDTO.getPeCode(),tIBeneficiaryDTO.getFacility().getId());
	if(!peCodeCheck)
	{
	    throw new BadRequestAlertException("PE code cannot have more than 200 beneficiaries" , ENTITY_NAME,
			"13");
	}
	TIBeneficiaryDTO result = tIBeneficiaryService.update(tIBeneficiaryDTO);
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
    @GetMapping("/ti-beneficiaries")
	public ResponseEntity<List<TIBeneficiaryDTO>> getAllTIBeneficiaries(TIBeneficiaryCriteria criteria,
			Pageable pageable) {
		log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
		Page<TIBeneficiaryDTO> page = tIBeneficiaryQueryService.findByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		long totalCount = tIBeneficiaryQueryService.countByCriteria(criteria);
		if (!page.getContent().isEmpty()) {
		    page.getContent().get(0).setCount(totalCount);
		}

		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}
    
    @GetMapping("/v1/ti-beneficiaries")
 public ResponseEntity<List<TiBenDto>> findAllTIBeneficiaries(TIBeneficiaryCriteria criteria,
     Pageable pageable) {
	log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
	Page<TiBenDto> page = tiBenQueryService.findByCriteria(criteria, pageable);
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
    @GetMapping("/ti-beneficiaries/advsearch")
    public ResponseEntity<List<TIBeneficiaryDTO>> searchAllTIBeneficiaries(TIBeneficiaryCriteria criteria,
	    Pageable pageable) {
	log.debug("REST request to get TIBeneficiaries by criteria: {}" + criteria);
	Page<TIBeneficiaryDTO> page = tIBeneficiaryQueryService.searchByCriteria(criteria, pageable);
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
    @GetMapping("/ti-beneficiaries/count")
    public ResponseEntity<Long> countTIBeneficiaries(TIBeneficiaryCriteria criteria) {
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
    @GetMapping("/ti-beneficiaries/{id}")
    public ResponseEntity<TIBeneficiaryDTO> getTIBeneficiary(@PathVariable Long id) {
	log.debug("REST request to get TIBeneficiary : {}", id);
	Optional<TIBeneficiaryDTO> tIBeneficiaryDTO = tIBeneficiaryService.findOne(id);
	return ResponseUtil.wrapOrNotFound(tIBeneficiaryDTO);
    }

    /**
     * {@code DELETE  /ti-beneficiaries/:id} : delete the "id" tIBeneficiary.
     *
     * @param id the id of the tIBeneficiaryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @PostMapping("/ti-beneficiaries/{id}/{deleteReason}")
    public ResponseEntity<Void> deleteTIBeneficiary(@PathVariable("id") Long id,
	    @PathVariable("deleteReason") Long deleteReasonId) {
	log.debug("REST request to delete TIBeneficiary : {}", id);
	tIBeneficiaryService.delete(id, deleteReasonId);
	return ResponseEntity.noContent()
		.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
		.build();
    }
}
