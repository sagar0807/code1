package gov.naco.soch.cst.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.cst.service.TestService;
import gov.naco.soch.dto.TestDto;
import gov.naco.soch.dto.TestTypeDto;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

	@Autowired
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/testTypelist/{labType}")
	public @ResponseBody List<TestTypeDto> getTestTypeList(@PathVariable("labType") String labType) {
		logger.debug("Entering into method getTestTypeList");
		return testService.getTestTypeList(labType.trim());
	}

	@GetMapping("/testlist/{collectionCenter}")
	public @ResponseBody List<TestDto> getTestList(@PathVariable("collectionCenter") String collectionCenter) {
		logger.debug("Entering into method getTestList");
		return testService.getTestList(collectionCenter.trim());
	}

}
