package gov.naco.soch.admin.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.SnomedCtService;
import in.cdac.medinfo.csnotk.csnolib.commons.ConceptDetails;
import in.cdac.medinfo.csnotk.csnolib.model.CompositeDescription;

/*Controller class for API to get the snomed CT details. */

@RestController
@RequestMapping("/snomedct")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PropertySource("classpath:application.yml")
public class SnomedCtController {

	@Autowired
	SnomedCtService snomedCtService;

	public SnomedCtController() {
	}

	@GetMapping("/search")
	public @ResponseBody Set<CompositeDescription> search(@RequestParam(required = true) String matchTerm,
			@RequestParam(required = false) String semanticTags,
			@RequestParam(required = false, defaultValue = "10") Integer searchReturnlimit,
			@RequestParam(required = false, defaultValue = "10") Integer suggestReturnlimit,
			@RequestParam(required = false, defaultValue = "10") Integer topSuggestReturnlimit) throws Exception {
		return snomedCtService.search(matchTerm, semanticTags, searchReturnlimit, suggestReturnlimit,
				topSuggestReturnlimit);
	}

	@GetMapping("/getSuggestions")
	public @ResponseBody Set<String> getSuggestions(@RequestParam(required = true) String matchTerm,
			@RequestParam(required = false, defaultValue = "10000") Integer searchReturnlimit,
			@RequestParam(required = false, defaultValue = "500") Integer suggestReturnlimit,
			@RequestParam(required = false, defaultValue = "50") Integer topSuggestReturnlimit) throws Exception {
		return snomedCtService.getSuggestions(matchTerm, searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit);
	}

	@GetMapping("/getConceptDetails/{conceptId}")
	public ConceptDetails getConceptDetails(@PathVariable("conceptId") String conceptId) throws Exception {
		return snomedCtService.getConceptDetails(conceptId);
	}

}
