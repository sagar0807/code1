//package gov.naco.soch.ti.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import gov.naco.soch.dto.TiBeneficiaryrVassessmentDto;
//import gov.naco.soch.ti.service.TiBeneficiaryrVassessmentService;
//
//@RestController
//@RequestMapping("/rvAssessment")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class TiBeneficiaryrVassessmentController {
//
//	private static final Logger logger = LoggerFactory.getLogger(TiBeneficiaryrVassessmentController.class);
//
//	@Autowired
//	TiBeneficiaryrVassessmentService tiBeneficiaryrVassessmentService;
//
//	// API to add Ti Beneficiary R&V assessment details
//	@PostMapping("/add")
//	public @ResponseBody TiBeneficiaryrVassessmentDto addR_VAssesmentDetails(
//			@RequestBody TiBeneficiaryrVassessmentDto tiBeneficiaryrVassessmentDto) {
//		logger.debug("tiBeneficiaryrVassessmentDto method called with parameters->{}", tiBeneficiaryrVassessmentDto);
//		tiBeneficiaryrVassessmentService.addR_VAssesmentDetails(tiBeneficiaryrVassessmentDto);
//		logger.debug("tiBeneficiaryrVassessmentDto method returns with parameters->{}", tiBeneficiaryrVassessmentDto);
//		return tiBeneficiaryrVassessmentDto;
//
//	}
//
//}
