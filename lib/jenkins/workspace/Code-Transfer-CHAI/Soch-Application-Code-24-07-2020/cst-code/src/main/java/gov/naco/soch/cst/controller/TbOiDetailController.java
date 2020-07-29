package gov.naco.soch.cst.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.dto.TbOiDetailsDto;
import gov.naco.soch.cst.service.TbOiDetailsService;

@RestController
@RequestMapping("/tbdetails")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TbOiDetailController {
	
private static final Logger logger = LoggerFactory.getLogger(TbOiDetailController.class);
	
	@Autowired
	private TbOiDetailsService tboiService;
	
	@PostMapping("/save")
	public @ResponseBody TbOiDetailsDto saveBeneficiaryTbOiDetails(@RequestBody TbOiDetailsDto tbOiDetailsDto) {
		logger.info("inside save");
		return tboiService.saveBeneficiaryTbOiDetails(tbOiDetailsDto);
	}
	
	@GetMapping("/get/{beneficiaryId}")
	public @ResponseBody List<TbOiDetailsDto> getBeneficiaryTbOiDetails(@PathVariable("beneficiaryId") Long beneficiaryId ) {
		return tboiService.getBeneficiaryTbOiDetails(beneficiaryId);
	}

}
