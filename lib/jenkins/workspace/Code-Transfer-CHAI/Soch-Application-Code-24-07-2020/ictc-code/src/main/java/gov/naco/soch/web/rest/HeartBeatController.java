package gov.naco.soch.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.service.TemporaryMigrationService;

@RestController
@RequestMapping("/api")
public class HeartBeatController {
	
	@Autowired
	private TemporaryMigrationService migrationService;
	
	@GetMapping("/migrate/{id}")
	public String migrate(@PathVariable(name = "id") Integer id) {
		if(id == 136610) {
			migrationService.migrate();
			return "completed";
		} else {
			return "invalid";
		}
	}

}
