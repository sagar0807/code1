package gov.naco.soch.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.service.SnomedCtService;

/*Controller class for API to configure snomed CT database.*/

@RestController
@RequestMapping("/snomedct-config")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PropertySource("classpath:application.yml")
public class SnomedCtConfigController {

	private static final Logger logger = LoggerFactory.getLogger(SnomedCtConfigController.class);

	@Autowired
	SnomedCtService snomedCtService;

	public SnomedCtConfigController() {
	}

	@GetMapping("/create-db")
	public @ResponseBody boolean createSnomedCtDb(@RequestParam(required = false) String installFilePath,
			@RequestParam(required = false) String dataDir, @RequestParam(required = false) String errorLogDir,
			@RequestParam(required = false, defaultValue = "10000") Integer searchReturnlimit,
			@RequestParam(required = false, defaultValue = "500") Integer suggestReturnlimit,
			@RequestParam(required = false, defaultValue = "50") Integer topSuggestReturnlimit,
			@RequestParam(required = false, defaultValue = "true") Boolean overridedb) throws Exception {
		snomedCtService.createSnomedCtDb(installFilePath, searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit,
				overridedb);
		return true;
	}

	@GetMapping("/create-extensiondb")
	public @ResponseBody boolean createSnomedCtExtensiondb(@RequestParam(required = false) String installFilePath,
			@RequestParam(required = false) String dataDir, @RequestParam(required = false) String errorLogDir,
			@RequestParam(required = false, defaultValue = "10000") Integer searchReturnlimit,
			@RequestParam(required = false, defaultValue = "500") Integer suggestReturnlimit,
			@RequestParam(required = false, defaultValue = "50") Integer topSuggestReturnlimit,
			@RequestParam(required = false, defaultValue = "true") Boolean overridedb) throws Exception {
		snomedCtService.createSnomedCtExtensiondb(installFilePath, searchReturnlimit, suggestReturnlimit,
				topSuggestReturnlimit, overridedb);
		return true;
	}

}
