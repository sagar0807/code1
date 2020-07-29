package gov.naco.soch.ti.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.ti.dto.ProfileUpdateCriteria;
import gov.naco.soch.ti.dto.ProfileUpdateDto;
import gov.naco.soch.ti.dto.TIBenCounsellingCriteria;
import gov.naco.soch.ti.service.ProfileUpdateQueryService;
import gov.naco.soch.ti.service.ProfileUpdateService;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfileUpdateResource {

    private static final String ENTITY_NAME = "ProfileUpdateResource";

    private static final String APPLICATION_NAME = "TI";

    private final ProfileUpdateService profileUpdateService;
    private final ProfileUpdateQueryService puQueryService;

    public ProfileUpdateResource(ProfileUpdateService profileUpdateService,ProfileUpdateQueryService puQueryService) {
	this.puQueryService=puQueryService;
	this.profileUpdateService = profileUpdateService;
    }

    @PostMapping("/profile")
    public ResponseEntity<ProfileUpdateDto> saveProfile(@Valid @RequestBody ProfileUpdateDto profileUpdate)
	    throws URISyntaxException {

	ProfileUpdateDto result = profileUpdateService.save(profileUpdate);
	return ResponseEntity
		.created(new URI("/profile" + result.getId())).headers(HeaderUtil
			.createEntityCreationAlert(APPLICATION_NAME, false, ENTITY_NAME, result.getId().toString()))
		.body(result);
    }

    @GetMapping("/profile")
    public ResponseEntity<List<ProfileUpdateDto>> getProfile(ProfileUpdateCriteria criteria,
	    Pageable pageable) {
	Page<ProfileUpdateDto> page = puQueryService.findByCriteria(criteria, pageable);
	HttpHeaders headers = PaginationUtil
		.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
	return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}
