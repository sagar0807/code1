package gov.naco.soch.ti.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.dto.TiBeneficiaryPrescriptionDto;
import gov.naco.soch.ti.service.TiBeneficiaryPrescriptionService;

@RestController
@RequestMapping("/prescription")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiBeneficiaryPrescriptionController {

	private static final Logger logger = LoggerFactory.getLogger(TiBeneficiaryPrescriptionController.class);

	@Autowired
	private TiBeneficiaryPrescriptionService tiBeneficiaryPrescriptionService;

	/**
	 * @param prescriptionDto
	 * @return TiBeneficiaryPrescriptionDto
	 */
	@RequestMapping("/save")
	public TiBeneficiaryPrescriptionDto addPrescription(@RequestBody TiBeneficiaryPrescriptionDto prescriptionDto) {
		logger.debug("addPrescription method is invoked");
		//prescriptionDto = tiBeneficiaryPrescriptionService.addPrescription(prescriptionDto);
		logger.debug("addPrescription method returns with parameters->{}", prescriptionDto);
		return prescriptionDto;
	}

	@GetMapping("/medicinelist")
	public List<MasterDto> getMedicineList() {
		logger.debug("getAllLacs method is invoked");
		return tiBeneficiaryPrescriptionService.getMedicineList();
	}

}
