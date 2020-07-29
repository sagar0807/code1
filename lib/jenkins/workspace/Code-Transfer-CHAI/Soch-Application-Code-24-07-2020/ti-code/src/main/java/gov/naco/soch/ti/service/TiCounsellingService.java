package gov.naco.soch.ti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.TiCounsellingDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.repository.BeneficiaryRepository;

//TiCounsellingService class interact data with database
@Transactional
@Service
public class TiCounsellingService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	// method to add counseling details into ti_beneficiary_counselling table
	public void addCounsellingDetails(TiCounsellingDto tiCounsellingDto) {

		tiCounsellingDto.setIsActive(true);


		Beneficiary beneficiaryObj = null;
		beneficiaryObj = beneficiaryRepository.findById(tiCounsellingDto.getBeneficiaryId()).get();
		beneficiaryObj.setBeneficiaryActivityStatus("Pending For STI Treatment");
		beneficiaryObj = beneficiaryRepository.save(beneficiaryObj);

	}
}
