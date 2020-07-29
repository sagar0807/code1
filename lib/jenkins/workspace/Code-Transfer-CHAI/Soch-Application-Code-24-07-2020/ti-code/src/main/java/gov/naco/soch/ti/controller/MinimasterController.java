package gov.naco.soch.ti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.projection.MinimasterProjection;
import gov.naco.soch.ti.dto.MinimasterResponseDto;
import gov.naco.soch.ti.service.MinimasterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MinimasterController {
	
	private final MinimasterService minimasterService;

	public MinimasterController(MinimasterService minimasterService) {
		this.minimasterService = minimasterService;
	}
	
	@GetMapping("/minimaster/{tableName}")
	public List<MinimasterProjection> get(@PathVariable String tableName)
	{
		return minimasterService.get(tableName);
			
	}
	

	@GetMapping("/minimasters")
	public MinimasterResponseDto get()
	{
		return minimasterService.get();
			
	}
	

}
