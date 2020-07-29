package gov.naco.soch.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import gov.naco.soch.service.IctcPartnerDetailsService;
import gov.naco.soch.service.dto.IctcPartnerDetailsDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing IctcPartnerDetails.
 */
@RestController
@RequestMapping("/api")
public class IctcPartnerDetailsResource {

    private final Logger log = LoggerFactory.getLogger(IctcPartnerDetailsResource.class);

    private static final String ENTITY_NAME = "ictcPartnerDetails";

    private final IctcPartnerDetailsService ictcPartnerDetailsService;

    public IctcPartnerDetailsResource(IctcPartnerDetailsService ictcPartnerDetailsService) {
        this.ictcPartnerDetailsService = ictcPartnerDetailsService;
    }

    /**
     * POST  /ictc-partner-details : Create a new ictcPartnerDetails.
     *
     * @param ictcPartnerDetailsDTO the ictcPartnerDetailsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ictcPartnerDetailsDTO, or with status 400 (Bad Request) if the ictcPartnerDetails has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/ictc-partner-details")
    public ResponseEntity<IctcPartnerDetailsDTO> createIctcPartnerDetails(@Valid @RequestBody IctcPartnerDetailsDTO ictcPartnerDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save IctcPartnerDetails : {}", ictcPartnerDetailsDTO);
        if (ictcPartnerDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new ictcPartnerDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IctcPartnerDetailsDTO result = ictcPartnerDetailsService.save(ictcPartnerDetailsDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityCreationAlert("ICTC", false, ENTITY_NAME, ictcPartnerDetailsDTO.getId().toString()))
                .body(result);
    }

    /**
     * PUT  /ictc-partner-details : Updates an existing ictcPartnerDetails.
     *
     * @param ictcPartnerDetailsDTO the ictcPartnerDetailsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ictcPartnerDetailsDTO,
     * or with status 400 (Bad Request) if the ictcPartnerDetailsDTO is not valid,
     * or with status 500 (Internal Server Error) if the ictcPartnerDetailsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/ictc-partner-details")
    public ResponseEntity<IctcPartnerDetailsDTO> updateIctcPartnerDetails(@Valid @RequestBody IctcPartnerDetailsDTO ictcPartnerDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update IctcPartnerDetails : {}", ictcPartnerDetailsDTO);
        if (ictcPartnerDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IctcPartnerDetailsDTO result = ictcPartnerDetailsService.save(ictcPartnerDetailsDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("ICTC", false, ENTITY_NAME, ictcPartnerDetailsDTO.getId().toString()))
                .body(result);
    }

    /**
     * GET  /ictc-partner-details : get all the ictcPartnerDetails.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ictcPartnerDetails in body
     */
    @GetMapping("/ictc-partner-details")
    public ResponseEntity<List<IctcPartnerDetailsDTO>> getAllIctcPartnerDetails(Pageable pageable) {
        log.debug("REST request to get a page of IctcPartnerDetails");
        Page<IctcPartnerDetailsDTO> page = ictcPartnerDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    @GetMapping("/ictc-partner-details/beneficiary/{id}")
    public ResponseEntity<List<IctcPartnerDetailsDTO>> getAllIctcPartnerDetailsByBeneficiaryId(@PathVariable Long id) {
        log.debug("REST request to get a page of IctcPartnerDetails");
        List<IctcPartnerDetailsDTO> list = ictcPartnerDetailsService.findByBeneficiaryId(id);
        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().body(list);
    }

    /**
     * GET  /ictc-partner-details/:id : get the "id" ictcPartnerDetails.
     *
     * @param id the id of the ictcPartnerDetailsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ictcPartnerDetailsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/ictc-partner-details/{id}")
    public ResponseEntity<IctcPartnerDetailsDTO> getIctcPartnerDetails(@PathVariable Long id) {
        log.debug("REST request to get IctcPartnerDetails : {}", id);
        Optional<IctcPartnerDetailsDTO> ictcPartnerDetailsDTO = ictcPartnerDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ictcPartnerDetailsDTO);
    }

    /**
     * DELETE  /ictc-partner-details/:id : delete the "id" ictcPartnerDetails.
     *
     * @param id the id of the ictcPartnerDetailsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/ictc-partner-details/{id}")
    public ResponseEntity<Void> deleteIctcPartnerDetails(@PathVariable Long id) {
        log.debug("REST request to delete IctcPartnerDetails : {}", id);
        ictcPartnerDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert("ICTC", false, ENTITY_NAME, id.toString())).build();
    }
}
