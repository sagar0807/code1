package gov.naco.soch.ti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.BeneficiaryServiceCalendarDto;
import gov.naco.soch.ti.service.BeneficiaryCalendarService;

@RestController
@RequestMapping("/api")
public class TIBenCalendarViewController {

	@Autowired
	BeneficiaryCalendarService beneficiaryCalendarService;

	@GetMapping("/getCalendarData/{beneficairyId}")
	public ResponseEntity<BeneficiaryServiceCalendarDto> getBeneficiaryCalendarData(
			@PathVariable("beneficairyId") Long beneficairyId, @RequestParam("serviceTypeId") int serviceTypeId,
			@RequestParam("facilityId") Long facilityId) {
		BeneficiaryServiceCalendarDto beneficiaryServiceCalendarDto = new BeneficiaryServiceCalendarDto();

		try {
			beneficiaryServiceCalendarDto = beneficiaryCalendarService.getBeneficiaryCalendarData(beneficairyId,
					serviceTypeId, facilityId);
		} catch (Exception e) {
			System.out.println(e);
			new ResponseEntity<BeneficiaryServiceCalendarDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<BeneficiaryServiceCalendarDto>(beneficiaryServiceCalendarDto, HttpStatus.OK);

	}
}
