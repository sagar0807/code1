package gov.naco.soch.ti.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.LinkedBeneficiaryDTO;
import gov.naco.soch.ti.dto.LinkedFacilityBeneficiaryCriteria;
import gov.naco.soch.ti.service.LinkedFacilityBeneficiaryQueryService;
import gov.naco.soch.ti.service.TiSatelliteOstServiceImpl;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiSatelliteOstResource {

	private final Logger log = LoggerFactory.getLogger(TiSatelliteOstResource.class);

	private static final String ENTITY_NAME = "tiSatelliteOst";

	private static final String APPLICATION_NAME = "TI-OST";

	private final TiSatelliteOstServiceImpl tiSatelliteOstService;
	
	private final LinkedFacilityBeneficiaryQueryService linkedFacilityBeneficiaryQueryService;

	public TiSatelliteOstResource(TiSatelliteOstServiceImpl tiSatelliteOstService,LinkedFacilityBeneficiaryQueryService linkedFacilityBeneficiaryQueryService) {
		this.tiSatelliteOstService = tiSatelliteOstService;
		this.linkedFacilityBeneficiaryQueryService=linkedFacilityBeneficiaryQueryService;

	}

	@PostMapping("/ti-ost-satellite/link")
	public ResponseEntity<LinkedBeneficiaryDTO> createSatelliteOst(
			@Valid @RequestBody LinkedBeneficiaryDTO linkedBeneficiaryDTO) throws URISyntaxException {
		log.debug("REST request to link TIOstBeneficiary : {}", linkedBeneficiaryDTO);
		LinkedBeneficiaryDTO result = tiSatelliteOstService.save(linkedBeneficiaryDTO);
		return ResponseEntity.created(new URI("/ti-ost-satellite/link"))
				.headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, "created"))
				.body(result);
	}
	
	@PostMapping("/ti-ost-satellite/{id}/{unlinkReason}")
	public ResponseEntity<Void> deleteTIBeneficiary(@PathVariable("id") Long id,
			@PathVariable("unlinkReason") Long unlinkReasonId) {
		log.debug("REST request to unlink TiOstBeneficary : {}", id);
		tiSatelliteOstService.delete(id, unlinkReasonId);
		return ResponseEntity.noContent()
				.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
				.build();
	}
	
	@GetMapping("/linked-facilities")
	public ResponseEntity<List<LinkedBeneficiaryDTO>> getLinkedBeneficaryFacilities(LinkedFacilityBeneficiaryCriteria criteria,
			Pageable pageable) {
		log.debug("REST request to get satellite ost beneficiaries by criteria: {}", criteria);
		Page<LinkedBeneficiaryDTO> page = linkedFacilityBeneficiaryQueryService.findByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

}
