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

import gov.naco.soch.domain.ArtBeneficiary;
import gov.naco.soch.service.ArtBeneficiaryQueryService;
import gov.naco.soch.service.ArtBeneficiaryService;
import gov.naco.soch.service.dto.ArtBeneficiaryCriteria;
import gov.naco.soch.service.dto.ArtBeneficiaryDTO;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing ArtBeneficiary.
 */
@RestController
@RequestMapping("/api")
public class ArtBeneficiaryResource {

    private final Logger log = LoggerFactory.getLogger(ArtBeneficiaryResource.class);

    private static final String ENTITY_NAME = "artBeneficiary";

    private final ArtBeneficiaryService artBeneficiaryService;

    private final ArtBeneficiaryQueryService artBeneficiaryQueryService;

    public ArtBeneficiaryResource(ArtBeneficiaryService artBeneficiaryService, ArtBeneficiaryQueryService artBeneficiaryQueryService) {
        this.artBeneficiaryService = artBeneficiaryService;
        this.artBeneficiaryQueryService = artBeneficiaryQueryService;
    }

    /**
     * GET  /art-beneficiaries : get all the artBeneficiaries.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of artBeneficiaries in body
     */
    @GetMapping("/art-beneficiaries")
    public ResponseEntity<List<ArtBeneficiary>> getAllArtBeneficiaries(ArtBeneficiaryCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ArtBeneficiaries by criteria: {}", criteria);
        Page<ArtBeneficiary> page = artBeneficiaryQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /art-beneficiaries/:id : get the "id" artBeneficiary.
     *
     * @param id the id of the artBeneficiaryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the artBeneficiaryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/art-beneficiaries/{id}")
    public ResponseEntity<ArtBeneficiaryDTO> getArtBeneficiary(@PathVariable Long id) {
        log.debug("REST request to get ArtBeneficiary : {}", id);
        Optional<ArtBeneficiaryDTO> artBeneficiaryDTO = artBeneficiaryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(artBeneficiaryDTO);
    }

}
