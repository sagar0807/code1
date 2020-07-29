package gov.naco.soch.ti.controller;

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

import gov.naco.soch.dto.BeneficiaryRegistrationDto;
import gov.naco.soch.ti.dto.GlobalBeneficiaryViewCardDTO;

//Controller class for Ti beneficiary

@RestController
@RequestMapping("/beneficiary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BeneficiaryController {

	@Autowired
	private gov.naco.soch.ti.service.BeneficiaryService beneficiaryService;

	public BeneficiaryController() {
	}

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

	// 1. API to add ti beneficiary
	@PostMapping("/add")
	public @ResponseBody BeneficiaryRegistrationDto addBeneficiary(
			@RequestBody BeneficiaryRegistrationDto beneficiaryRegistrationDto) {

		logger.debug("addBeneficiary method is invoked");
		// beneficiaryService.addBeneficiary(beneficiaryRegistrationDto);
		logger.debug("addBeneficiary method returns with parameters->{}", beneficiaryRegistrationDto);
		return beneficiaryRegistrationDto;
	}

	// 2. API to update ti beneficiary
	@PostMapping("/update")
	public @ResponseBody BeneficiaryRegistrationDto updateBeneficiary(
			@RequestBody BeneficiaryRegistrationDto beneficiaryRegistrationDto) {
		logger.debug("updateBeneficiary method is invoked");
		// beneficiaryService.updateBeneficiary(beneficiaryRegistrationDto);
		logger.debug("updateBeneficiary method returns with parameters->{}", beneficiaryRegistrationDto);
		return beneficiaryRegistrationDto;
	}

	// 3. API to delete ti beneficiary
	@PostMapping("/delete/{id}")
	public @ResponseBody BeneficiaryRegistrationDto deleteBeneficiary(@PathVariable("id") Long id) {

		BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();
		logger.debug("deleteBeneficiary method is invoked");
		beneficiaryService.deleteBeneficiary(id);
		logger.debug("deleteBeneficiary method returns with parameters->{}", beneficiaryRegistrationDto);
		return beneficiaryRegistrationDto;
	}

	// 4. API to search beneficiary details by UID or mobile number
	@GetMapping(value = "/search/{searchValue}")
	public @ResponseBody BeneficiaryRegistrationDto getBeneficiaryBySearchValue(
			@PathVariable("searchValue") String searchValue) {
		logger.debug("getBeneficiaryBySearchValue method is invoked");
		return beneficiaryService.getBeneficiaryBySearchValue(searchValue);
	}

	// 5. API to search beneficiary details by UID, mobile number,
	// firstName, LastName, HIVStatus, referralStatus, referralFacility
	@GetMapping(value = "/referral/search/{referralSearchValue}")
	public @ResponseBody BeneficiaryRegistrationDto getBeneficiaryByReferralSearchValue(
			@PathVariable("referralSearchValue") String referralSearchValue) {
		logger.debug("getBeneficiaryByReferralSearchValue method is invoked");
		return beneficiaryService.getBeneficiaryByReferralSearchValue(referralSearchValue);
	}

	// 6. API to list all outward referrals
	@GetMapping("referral/outward/list")
	public @ResponseBody List<BeneficiaryRegistrationDto> getAllOutwardReferrals() {
		logger.debug("getBeneficiaries getBeneficiariesForReferralOrTranfer is invoked");
		List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = beneficiaryService
				.getBeneficiariesForReferralOrTranfer();
		return beneficiaryRegistrationDtoList;
	}

	// 7. API to list all inward referrals
	@GetMapping("referral/inward/list")
	public @ResponseBody List<BeneficiaryRegistrationDto> getAllInwardReferrals() {
		logger.debug("getBeneficiaries getBeneficiariesForReferralOrTranfer is invoked");
		List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = beneficiaryService
				.getBeneficiariesForReferralOrTranfer();
		return beneficiaryRegistrationDtoList;
	}

	// 8. API to list all transfer-in requests
	@GetMapping("transfer/in/list")
	public @ResponseBody List<BeneficiaryRegistrationDto> getAllTransferIns() {
		logger.debug("getBeneficiaries getBeneficiariesForReferralOrTranfer is invoked");
		List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = beneficiaryService
				.getBeneficiariesForReferralOrTranfer();
		return beneficiaryRegistrationDtoList;
	}

	// 9. API to list all transfer-due beneficiaries
	@GetMapping("transfer/due/list")
	public @ResponseBody List<BeneficiaryRegistrationDto> getAllTranferDueList() {
		logger.debug("getBeneficiaries getBeneficiariesForReferralOrTranfer is invoked");
		List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = beneficiaryService
				.getBeneficiariesForReferralOrTranfer();
		return beneficiaryRegistrationDtoList;
	}

	// 10. API to list all transferred beneficiaries
	@GetMapping("transfer/out/list")
	public @ResponseBody List<BeneficiaryRegistrationDto> getAllTranferOut() {
		logger.debug("getBeneficiaries getBeneficiariesForReferralOrTranfer is invoked");
		List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList = beneficiaryService
				.getBeneficiariesForReferralOrTranfer();
		return beneficiaryRegistrationDtoList;
	}

	// 11. API to list all beneficiaries
	/*
	 * @GetMapping("/list/{facilityId}") public @ResponseBody
	 * List<BeneficiaryRegistrationDto>
	 * getAllBeneficiaries(@PathVariable("facilityId") Long facilityId) {
	 * logger.debug("getBeneficiaries getBeneficiaries is invoked"); //
	 * List<BeneficiaryRegistrationDto> beneficiaryRegistrationDtoList =
	 * beneficiaryService.getBeneficiaries(facilityId); return
	 * beneficiaryRegistrationDtoList; }
	 */

	@GetMapping("/viewcard/{beneficiaryId}")
	public GlobalBeneficiaryViewCardDTO getTIBeneficiary(@PathVariable Long beneficiaryId) {
		logger.debug("REST request to view details of global beneficiary : {}", beneficiaryId);
		GlobalBeneficiaryViewCardDTO tIBeneficiaryDTO = beneficiaryService.findOne(beneficiaryId);
		return tIBeneficiaryDTO;
	}
}
