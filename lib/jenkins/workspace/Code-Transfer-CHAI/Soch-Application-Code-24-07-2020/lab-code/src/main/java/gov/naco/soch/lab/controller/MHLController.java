package gov.naco.soch.lab.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.lab.dto.MHLBarcodeValidationDto;
import gov.naco.soch.lab.dto.PatientLoadDto;
import gov.naco.soch.lab.dto.RecordResultDto;
import gov.naco.soch.lab.service.MHLService;

/**
 * Controller class for managing MHL related APIs
 *
 */
@RestController
@RequestMapping("/mhl")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MHLController {

	private static final Logger logger = LoggerFactory.getLogger(MHLController.class);

	@Autowired
	private MHLService mhlService;

	// API 1.https://ims.naco.gov.in/api/vload_sample_detail
	@PostMapping(value = "/vload_sample_detail", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<Object> getViralLoadSampleDetail(MHLBarcodeValidationDto mhlBarcodeValidationDto) {
		logger.debug("getViralLoadSampleDetail() method is invoked");
		ResponseEntity<Object> mhlSampleDetailDto = mhlService.getViralLoadSampleDetail(mhlBarcodeValidationDto);
		return mhlSampleDetailDto;

	}

	// API 2.https://ims.naco.gov.in/api/vload_record_result
	@PostMapping(value = "/vload_record_result", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<Object> recordResult(@Valid RecordResultDto recordResultDto) {
		logger.debug("recordResult() method is invoked");
		ResponseEntity<Object> mhlSampleDetailDto = mhlService.recordResult(recordResultDto);
		return mhlSampleDetailDto;
	}

	// API 3.https://ims.naco.gov.in/api/vl_patient_load
	@PostMapping(value = "/vl_patient_load", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<Object> getVLPatientLoad(@Valid PatientLoadDto patientLoadDto) {
		logger.debug("getVLPatientLoad() method is invoked");
		ResponseEntity<Object> loadDetails = mhlService.getVLPatientLoad(patientLoadDto);
		logger.debug("getVLPatientLoad() method returns with parameter {}", loadDetails);
		return loadDetails;
	}

}
