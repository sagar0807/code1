package gov.naco.soch.web.rest;

import gov.naco.soch.service.RiskProfilingQuestionsService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.RiskProfilingQuestionsDTO;
import gov.naco.soch.service.dto.RiskProfilingQuestionsCriteria;
import gov.naco.soch.service.RiskProfilingQuestionsQueryService;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link gov.naco.soch.domain.RiskProfilingQuestions}.
 */
@RestController
@RequestMapping("/api")
public class RiskProfilingQuestionsResource {

    private final Logger log = LoggerFactory.getLogger(RiskProfilingQuestionsResource.class);

    private static final String ENTITY_NAME = "sochictcRiskProfilingQuestions";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RiskProfilingQuestionsService riskProfilingQuestionsService;

    private final RiskProfilingQuestionsQueryService riskProfilingQuestionsQueryService;

    public RiskProfilingQuestionsResource(RiskProfilingQuestionsService riskProfilingQuestionsService, RiskProfilingQuestionsQueryService riskProfilingQuestionsQueryService) {
        this.riskProfilingQuestionsService = riskProfilingQuestionsService;
        this.riskProfilingQuestionsQueryService = riskProfilingQuestionsQueryService;
    }

    /**
     * {@code POST  /risk-profiling-questions} : Create a new riskProfilingQuestions.
     *
     * @param riskProfilingQuestionsDTO the riskProfilingQuestionsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new riskProfilingQuestionsDTO, or with status {@code 400 (Bad Request)} if the riskProfilingQuestions has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/risk-profiling-questions")
    public ResponseEntity<RiskProfilingQuestionsDTO> createRiskProfilingQuestions(@RequestBody RiskProfilingQuestionsDTO riskProfilingQuestionsDTO) throws URISyntaxException {
        log.debug("REST request to save RiskProfilingQuestions : {}", riskProfilingQuestionsDTO);
        if (riskProfilingQuestionsDTO.getId() != null) {
            throw new BadRequestAlertException("A new riskProfilingQuestions cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RiskProfilingQuestionsDTO result = riskProfilingQuestionsService.save(riskProfilingQuestionsDTO);
        return ResponseEntity.created(new URI("/api/risk-profiling-questions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /risk-profiling-questions} : Updates an existing riskProfilingQuestions.
     *
     * @param riskProfilingQuestionsDTO the riskProfilingQuestionsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated riskProfilingQuestionsDTO,
     * or with status {@code 400 (Bad Request)} if the riskProfilingQuestionsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the riskProfilingQuestionsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/risk-profiling-questions")
    public ResponseEntity<RiskProfilingQuestionsDTO> updateRiskProfilingQuestions(@RequestBody RiskProfilingQuestionsDTO riskProfilingQuestionsDTO) throws URISyntaxException {
        log.debug("REST request to update RiskProfilingQuestions : {}", riskProfilingQuestionsDTO);
        if (riskProfilingQuestionsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RiskProfilingQuestionsDTO result = riskProfilingQuestionsService.save(riskProfilingQuestionsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, riskProfilingQuestionsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /risk-profiling-questions} : get all the riskProfilingQuestions.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of riskProfilingQuestions in body.
     */
    @GetMapping("/risk-profiling-questions")
    public ResponseEntity<List<RiskProfilingQuestionsDTO>> getAllRiskProfilingQuestions(RiskProfilingQuestionsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get RiskProfilingQuestions by criteria: {}", criteria);
        Page<RiskProfilingQuestionsDTO> page = riskProfilingQuestionsQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /risk-profiling-questions/count} : count all the riskProfilingQuestions.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/risk-profiling-questions/count")
    public ResponseEntity<Long> countRiskProfilingQuestions(RiskProfilingQuestionsCriteria criteria) {
        log.debug("REST request to count RiskProfilingQuestions by criteria: {}", criteria);
        return ResponseEntity.ok().body(riskProfilingQuestionsQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /risk-profiling-questions/:id} : get the "id" riskProfilingQuestions.
     *
     * @param id the id of the riskProfilingQuestionsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the riskProfilingQuestionsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/risk-profiling-questions/{id}")
    public ResponseEntity<RiskProfilingQuestionsDTO> getRiskProfilingQuestions(@PathVariable Long id) {
        log.debug("REST request to get RiskProfilingQuestions : {}", id);
        Optional<RiskProfilingQuestionsDTO> riskProfilingQuestionsDTO = riskProfilingQuestionsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(riskProfilingQuestionsDTO);
    }

    /**
     * {@code DELETE  /risk-profiling-questions/:id} : delete the "id" riskProfilingQuestions.
     *
     * @param id the id of the riskProfilingQuestionsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/risk-profiling-questions/{id}")
    public ResponseEntity<Void> deleteRiskProfilingQuestions(@PathVariable Long id) {
        log.debug("REST request to delete RiskProfilingQuestions : {}", id);
        riskProfilingQuestionsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
