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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.TIHotspotDto;
import gov.naco.soch.ti.dto.TiHotspotCriteria;
import gov.naco.soch.ti.service.TiHotSpotQueryService;
import gov.naco.soch.ti.service.TiHotSpotServiceImpl;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/api/hotspot")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiHotSpotResource {

	private final Logger log = LoggerFactory.getLogger(TiHotSpotResource.class);

	private static final String ENTITY_NAME = "tiHotspot";

	private static final String APPLICATION_NAME = "TI";

	private final TiHotSpotServiceImpl tiHotSpotServiceImpl;

	private final TiHotSpotQueryService tiHotSpotQueryService;

	public TiHotSpotResource(TiHotSpotServiceImpl tiHotSpotServiceImpl, TiHotSpotQueryService tiHotSpotQueryService) {
		this.tiHotSpotServiceImpl = tiHotSpotServiceImpl;
		this.tiHotSpotQueryService = tiHotSpotQueryService;
	}

	@PostMapping("/save")
	public ResponseEntity<TIHotspotDto> saveTIHotspot(@Valid @RequestBody TIHotspotDto tiHotspotDto)
			throws URISyntaxException {
		log.debug("REST request to save a  hotspot : {}", tiHotspotDto);
		boolean check = false;
		check = tiHotSpotServiceImpl.validateHotSpotName(tiHotspotDto.getHotspotName(), tiHotspotDto.getFacility().getId());
		if (check == true) {
			throw new BadRequestAlertException("Hotspot name already exists ", ENTITY_NAME, "6");
		}
		check = tiHotSpotServiceImpl.validateHotSpotCode(tiHotspotDto.getHotspotCode(),tiHotspotDto.getFacility().getId());
		if (check == true) {
			throw new BadRequestAlertException("Hotspot code already exists ", ENTITY_NAME, "7");
		}
		TIHotspotDto response = tiHotSpotServiceImpl.save(tiHotspotDto);
		return ResponseEntity.created(new URI("/hotspot/save"))
				.headers(HeaderUtil.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, "created"))
				.body(response);
	}

	@PutMapping("/update")
	public ResponseEntity<TIHotspotDto> updateTIHotspot(@Valid @RequestBody TIHotspotDto tiHotspotDto) {
		log.debug("REST request to update a  hotspot : {}", tiHotspotDto);
		boolean check = false;
		check = tiHotSpotServiceImpl.validateHotSpotNameForExisting(tiHotspotDto.getHotspotName(), tiHotspotDto.getId(),
				tiHotspotDto.getFacility().getId());
		if (check == true) {
			throw new BadRequestAlertException("Hotspot name already exists ", ENTITY_NAME, "6");
		}
		check = tiHotSpotServiceImpl.validateHotSpotCodeForExisting(tiHotspotDto.getHotspotCode(), tiHotspotDto.getId(),
				tiHotspotDto.getFacility().getId());
		if (check == true) {
			throw new BadRequestAlertException("Hotspot code already exists ", ENTITY_NAME, "7");
		}
		TIHotspotDto response = tiHotSpotServiceImpl.update(tiHotspotDto);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(APPLICATION_NAME, false, ENTITY_NAME, "updated"))
				.body(response);
	}

	@GetMapping("/list")
	public ResponseEntity<List<TIHotspotDto>> getAllTiHotSpots(TiHotspotCriteria criteria, Pageable pageable) {
		log.debug("REST request to get hotspots by criteria: {}", criteria);
		Page<TIHotspotDto> page = tiHotSpotQueryService.findByCriteria(criteria, pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@PostMapping("/delete/{hotspotId}")
	public ResponseEntity<Void> deleteTIHotspot(@PathVariable Long hotspotId) {
		log.debug("REST request to delete a  hotspot : {}", hotspotId);
		tiHotSpotServiceImpl.delete(hotspotId);
		return ResponseEntity.noContent().headers(
				HeaderUtil.createEntityDeletionAlert(APPLICATION_NAME, false, ENTITY_NAME, hotspotId.toString()))
				.build();
	}

}
