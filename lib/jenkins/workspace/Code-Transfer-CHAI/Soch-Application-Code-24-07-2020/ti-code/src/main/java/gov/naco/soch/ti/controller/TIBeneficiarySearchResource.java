package gov.naco.soch.ti.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.service.TIBeneficiaryAddlQueryService;
import gov.naco.soch.ti.service.TIBeneficiaryServiceImpl;
import io.github.jhipster.web.util.PaginationUtil;

/**
 * REST controller for managing {@link gov.naco.soch.domain.TIBeneficiary}.
 */
@RestController
@RequestMapping("/api")
public class TIBeneficiarySearchResource {

    private final Logger log = LoggerFactory.getLogger(TIBeneficiarySearchResource.class);

    private static final String ENTITY_NAME = "tIBeneficiarySearch";

    private static final String APPLICATION_NAME = "TI";

    private final TIBeneficiaryServiceImpl tIBeneficiaryService;

  
    
    private final TIBeneficiaryAddlQueryService tIBeneficiaryQueryService;

    public TIBeneficiarySearchResource(TIBeneficiaryServiceImpl tIBeneficiaryService, TIBeneficiaryAddlQueryService tIBeneficiaryQueryService) {
        this.tIBeneficiaryService = tIBeneficiaryService;
        this.tIBeneficiaryQueryService = tIBeneficiaryQueryService;
    }


    /**
     * {@code GET  /ti-beneficiaries/search} : get all the tIBeneficiaries based on search 
     * parameters.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBeneficiaries in body.
     */
    @GetMapping("/ti-beneficiaries/search")
    public ResponseEntity<List<TIBeneficiaryDTO>> getAllTIBeneficiaries(TIBeneficiaryCriteria criteria, Pageable pageable) {
    	log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
        Page<TIBeneficiaryDTO> page = tIBeneficiaryQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    /**
     * {@code GET  /ti-beneficiaries/basicSearch} : get all the tIBeneficiaries based on search 
     * parameters.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBeneficiaries in body.
     */
    @GetMapping("/ti-beneficiaries/basicSearch")
    public List<TIBeneficiaryDTO> getTIBeneficiariesBasicSearch(
    		String param) {
    	log.debug("REST request to get TIBeneficiaries by search param: {}", param);
        List<TIBeneficiaryDTO> list = tIBeneficiaryQueryService.findBySearchParam(param);
        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        //return ResponseEntity.ok().headers(headers).body(page.getContent());
        return list;
    }
    
    /**
     * {@code GET  /ti-beneficiaries/advanceSearch} : get all the tIBeneficiaries based on search 
     * parameters.
     *

     * @param pageable the pagination information.

     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tIBeneficiaries in body.
     */
    @GetMapping("/ti-beneficiaries/advanceSearch")
    public List<TIBeneficiaryDTO> getTIBeneficiariesAdvanceSearch(
    		TIBeneficiaryCriteria criteria) {
    	log.debug("REST request to get TIBeneficiaries by search criteria: {}", criteria);
        List<TIBeneficiaryDTO> list = tIBeneficiaryQueryService.advanceSearch(criteria);
        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        //return ResponseEntity.ok().headers(headers).body(page.getContent());
        return list;
    }

}
