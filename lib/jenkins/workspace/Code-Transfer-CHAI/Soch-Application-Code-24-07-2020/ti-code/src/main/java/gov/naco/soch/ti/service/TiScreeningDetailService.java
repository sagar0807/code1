package gov.naco.soch.ti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.TiScreeningDetailDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.repository.BeneficiaryRepository;

//TiScreeningDetailService class interact data with database
@Transactional
@Service
public class TiScreeningDetailService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	// method to add screening details into screening details table
	public void addScreeningDetails(TiScreeningDetailDto tiScreeningDetailDto) {

		tiScreeningDetailDto.setIsActive(true);
		tiScreeningDetailDto.setIsDelete(false);

		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBeneficiaryActivityStatus(tiScreeningDetailDto.getBeneficiaryActivityStatus());
		Beneficiary beneficiaryObj = null;
		beneficiaryObj = beneficiaryRepository.findById(tiScreeningDetailDto.getBeneficiaryId()).get();
		beneficiaryObj.setBeneficiaryActivityStatus("Pending For Commodity Distribution");
		beneficiaryObj = beneficiaryRepository.save(beneficiaryObj);


	}

}
