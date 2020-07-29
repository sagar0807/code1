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

import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.service.ICTCTestResultQueryService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.dto.ICTCTestDetails;
import gov.naco.soch.service.dto.ICTCTestResultCriteria;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.IctcTestResultHistoryDTO;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing ICTCTestResult.
 */
@RestController
@RequestMapping("/api")
public class ICTCTestResultResource {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultResource.class);

    private static final String ENTITY_NAME = "iCTCTestResult";

    private final ICTCTestResultService iCTCTestResultService;

    private final ICTCTestResultQueryService iCTCTestResultQueryService;

    public ICTCTestResultResource(ICTCTestResultService iCTCTestResultService, ICTCTestResultQueryService iCTCTestResultQueryService) {
        this.iCTCTestResultService = iCTCTestResultService;
        this.iCTCTestResultQueryService = iCTCTestResultQueryService;
    }

//    /**
//     * POST  /ictc-test-results : Create a new iCTCTestResult.
//     *
//     * @param iCTCTestResultDTO the iCTCTestResultDTO to create
//     * @return the ResponseEntity with status 201 (Created) and with body the new iCTCTestResultDTO, or with status 400 (Bad Request) if the iCTCTestResult has already an ID
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PostMapping("/ictc-test-results")
//    @Timed
//    public ResponseEntity<ICTCTestResultDTO> createICTCTestResult(@Valid @RequestBody ICTCTestResultDTO iCTCTestResultDTO) throws URISyntaxException {
//        log.debug("REST request to save ICTCTestResult : {}", iCTCTestResultDTO);
//        if (iCTCTestResultDTO.getId() != null) {
//            throw new BadRequestAlertException("A new iCTCTestResult cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        ICTCTestResultDTO result = iCTCTestResultService.save(iCTCTestResultDTO);
//        return ResponseEntity.created(new URI("/api/ictc-test-results/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * PUT  /ictc-test-results : Updates an existing iCTCTestResult.
//     *
//     * @param iCTCTestResultDTO the iCTCTestResultDTO to update
//     * @return the ResponseEntity with status 200 (OK) and with body the updated iCTCTestResultDTO,
//     * or with status 400 (Bad Request) if the iCTCTestResultDTO is not valid,
//     * or with status 500 (Internal Server Error) if the iCTCTestResultDTO couldn't be updated
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PutMapping("/ictc-test-results")
//    @Timed
//    public ResponseEntity<ICTCTestResultDTO> updateICTCTestResult(@Valid @RequestBody ICTCTestResultDTO iCTCTestResultDTO) throws URISyntaxException {
//        log.debug("REST request to update ICTCTestResult : {}", iCTCTestResultDTO);
//        if (iCTCTestResultDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        ICTCTestResultDTO result = iCTCTestResultService.save(iCTCTestResultDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, iCTCTestResultDTO.getId().toString()))
//            .body(result);
//    }
//
    /**
     * GET  /ictc-test-results : get all the iCTCTestResults.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
     */
    @GetMapping("/ictc-test-results")
    public ResponseEntity<List<ICTCTestResultDTO>> getAllICTCTestResults(ICTCTestResultCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
        Page<ICTCTestResultDTO> page = iCTCTestResultQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    /**
     * GET  /ictc-test-results-details : get all the iCTCTestResults.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
     */
    @GetMapping("/ictc-test-results-details")
    public ResponseEntity<List<ICTCTestResult>> getAllICTCTestResultsDetails(ICTCTestResultCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
        Page<ICTCTestResult> page = iCTCTestResultQueryService.findEntitiesByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    
    /**
     * GET  /ictc-test-results-details/trf : get all the iCTCTestResults.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
     */
    @GetMapping("/ictc-test-results-details/trf/{resultId}")
    public ResponseEntity<IctcTestResultHistoryDTO> getAllICTCTestResultsDetailsForTRF(ICTCTestResultCriteria criteria, @PathVariable("resultId") Long resultId, Pageable pageable) {
        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
        IctcTestResultHistoryDTO history = iCTCTestResultQueryService.findEntitiesByCriteriaForTRF(criteria, pageable, resultId);
        return ResponseEntity.ok().body(history);
    }
    
   
    /**
     * GET  /ictc-test-results/:id : get the "id" iCTCTestResult.
     *
     * @param id the id of the iCTCTestResultDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the iCTCTestResultDTO, or with status 404 (Not Found)
     */
    @GetMapping("/ictc-test-results/{id}")
    public ResponseEntity<ICTCTestResultDTO> getICTCTestResult(@PathVariable Long id) {
        log.debug("REST request to get ICTCTestResult : {}", id);
        Optional<ICTCTestResultDTO> iCTCTestResultDTO = iCTCTestResultService.findOne(id);
        return ResponseUtil.wrapOrNotFound(iCTCTestResultDTO);
    }
    
    /**
     * GET  /ictc-test-result/test-details/:id : get the "id" iCTCTestResult.
     *
     * @param id the id of the ICTCTestDetails to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ICTCTestDetails
     */
    @GetMapping("/ictc-test-result/test-details/{id}")
    public ResponseEntity<ICTCTestDetails> getTestDetails(@PathVariable Long id) {
        log.debug("REST request to get ICTCTestResult : {}", id);
        return ResponseEntity.ok().body(iCTCTestResultService.getTestDetails(id));
    }
    
//
//    /**
//     * DELETE  /ictc-test-results/:id : delete the "id" iCTCTestResult.
//     *
//     * @param id the id of the iCTCTestResultDTO to delete
//     * @return the ResponseEntity with status 200 (OK)
//     */
//    @DeleteMapping("/ictc-test-results/{id}")
//    @Timed
//    public ResponseEntity<Void> deleteICTCTestResult(@PathVariable Long id) {
//        log.debug("REST request to delete ICTCTestResult : {}", id);
//        iCTCTestResultService.delete(id);
//        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
//    }
}
