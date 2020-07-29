package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.DateUtil;

@Component
public class VisitRegisterService {

	private static BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@PostConstruct
	public void init() {
		VisitRegisterService.beneficiaryVisitRegisterRepository = beneficiaryVisitRegisterRepository1;
	}

	@Autowired
	BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository1;

	private static Beneficiary mapToBeneficiaryDtoId(long beneficiaryId) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(beneficiaryId);
		return beneficiary;
	}

	public static Facility mapToFacilityId(long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	public static Long getVisitRegisterIdForToday(Long facilityId, Long beneficiaryId) {

		Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOptional = beneficiaryVisitRegisterRepository
				.findByfacilityIdAndBeneficiaryId(facilityId, beneficiaryId,LocalDate.now());

		if (beneficiaryVisitRegisterOptional.isPresent()) {
			BeneficiaryVisitRegister visitRegister = beneficiaryVisitRegisterOptional.get();
			return visitRegister.getId();

		} else {
			BeneficiaryVisitRegister visitRegister = new BeneficiaryVisitRegister();
			Beneficiary beneficiary = mapToBeneficiaryDtoId(beneficiaryId);
			visitRegister.setBeneficiary(beneficiary);
			Facility facility = mapToFacilityId(facilityId);
			visitRegister.setFacility(facility);
			visitRegister.setVisitDate(DateUtil.getTodayDateInIST());
			visitRegister.setIsActive(true);
			visitRegister.setIsDelete(false);
			beneficiaryVisitRegisterRepository.save(visitRegister);
			return visitRegister.getId();

		}
	}
	
	public static Long getVisitRegisterIdForTodayExist(Long facilityId, Long beneficiaryId) {

		Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOptional = beneficiaryVisitRegisterRepository
				.findByfacilityIdAndBeneficiaryId(facilityId, beneficiaryId,LocalDate.now());

		if (beneficiaryVisitRegisterOptional.isPresent()) {
			BeneficiaryVisitRegister visitRegister = beneficiaryVisitRegisterOptional.get();
			return visitRegister.getId();
		} else {
			return null;
		}
	}

}
