package gov.naco.soch.shared.controller;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.dto.PartnerLinkageDTO;
import gov.naco.soch.shared.dto.PartnerLinkageCriteria;
import gov.naco.soch.shared.dto.PartnerLinkageDto;
import gov.naco.soch.shared.dto.UnregisteredPartnerDto;
import gov.naco.soch.shared.service.PartnerLinkageQueryService;
import gov.naco.soch.shared.service.PartnerLinkageServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartnerLinkageResource {

	private final Logger log = LoggerFactory.getLogger(PartnerLinkageResource.class);

	private static final String ENTITY_NAME = "partner linkage";

	private static final String APPLICATION_NAME = "TI";

	private final PartnerLinkageServiceImpl partnerLinkageServiceImpl;

	private final PartnerLinkageQueryService partnerLinkageQueryService;

	public PartnerLinkageResource(PartnerLinkageServiceImpl partnerLinkageServiceImpl,
			PartnerLinkageQueryService partnerLinkageQueryService) {
		this.partnerLinkageServiceImpl = partnerLinkageServiceImpl;
		this.partnerLinkageQueryService = partnerLinkageQueryService;
	}

	@PostMapping("/partnerlink")
	public ResponseEntity<PartnerLinkageDTO> createTIBeneficiary(
			@Valid @RequestBody PartnerLinkageDTO partnerLinkageDTO) throws URISyntaxException {
		log.debug("REST request to link partner : {}", partnerLinkageDTO);
		boolean check = false;
		check = partnerLinkageServiceImpl.validateDuplicatePartner(partnerLinkageDTO.getBeneficiary().getId(),
				partnerLinkageDTO.getPartnerBeneficiary().getId());
		if (check == true) {
			throw new BadRequestAlertException(
					"Beneficiary " + partnerLinkageDTO.getPartnerBeneficiary().getUid() + " is already a partner ",
					ENTITY_NAME, "5");
		}
		PartnerLinkageDTO result = partnerLinkageServiceImpl.save(partnerLinkageDTO);
		return ResponseEntity.created(new URI("/partnerlink"))
				.headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, "created"))
				.body(result);

	}

	@PutMapping("/partnerlink")
	public ResponseEntity<PartnerLinkageDTO> updateTIBeneficiary(
			@Valid @RequestBody PartnerLinkageDTO partnerLinkageDTO) throws URISyntaxException {
		log.debug("REST request to update link partner : {}", partnerLinkageDTO);
		boolean check = false;
		check = partnerLinkageServiceImpl.validateDuplicatePartner(partnerLinkageDTO.getBeneficiary().getId(),
				partnerLinkageDTO.getPartnerBeneficiary().getId());
		if (check == true) {
			throw new BadRequestAlertException(
					"Beneficiary " + "U" + partnerLinkageDTO.getPartnerBeneficiary().getId() + " is already a partner ",
					ENTITY_NAME, "5");
		}
		PartnerLinkageDTO result = partnerLinkageServiceImpl.update(partnerLinkageDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, "updated"))
				.body(result);
	}

	@GetMapping("/partnerlink")
	public ResponseEntity<List<PartnerLinkageDTO>> getAllFamilyDetails(PartnerLinkageCriteria criteria,
			Pageable pageable) {
		log.debug("REST request to get family details by criteria: {}", criteria);
		Page<PartnerLinkageDTO> page = partnerLinkageQueryService.findByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@DeleteMapping("/partnerlink/{id}")
	public ResponseEntity<Void> deleteLinkage(@PathVariable("id") Long id) {
		log.debug("REST request to delete TIBeneficiary : {}", id);
		partnerLinkageServiceImpl.delete(id);
		return ResponseEntity.noContent()
				.headers(HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, id.toString()))
				.build();
	}

	@PostMapping("/unregpartnerlink")
	public UnregisteredPartnerDto unregisteredPartnerLink(@Valid @RequestBody UnregisteredPartnerDto unregisteredPartnerDto) {
		log.debug("saveUnregisteredPartner() method is invoked with params: {}", unregisteredPartnerDto);
		UnregisteredPartnerDto result = partnerLinkageServiceImpl.saveUnregisteredPartner(unregisteredPartnerDto);
		return result;
	}
	
	@GetMapping("/partnerlink/list/{beneficiaryId}")
	public List<PartnerLinkageDto> getPartnerLinkDetails(@PathVariable("beneficiaryId")Long beneficiaryId) {
		log.debug("getPartnerLinkDetails() method is invoked with params: {}", beneficiaryId);
		List<PartnerLinkageDto> partnerLinkageDetails=partnerLinkageServiceImpl.getPartnerLinkDetails(beneficiaryId);
		return partnerLinkageDetails;
	}

}
