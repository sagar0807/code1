package gov.naco.soch.ti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.TiBeneficiaryCommodityDistributionDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.repository.BeneficiaryRepository;

//TiCommodityDistributionService class interact data with database
@Transactional
@Service
public class TiCommodityDistributionService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	// method to add commodity distribution details into ti_commodity_distribution
	// table
	public void addCommodityDistributionDetails(TiBeneficiaryCommodityDistributionDto tiCommodityDistributionDto) {

		tiCommodityDistributionDto.setIsActive(true);

		Beneficiary beneficiaryObj = null;
		beneficiaryObj = beneficiaryRepository.findById(tiCommodityDistributionDto.getBeneficiaryId()).get();
		beneficiaryObj.setBeneficiaryActivityStatus("Pending For Referral");
		beneficiaryObj = beneficiaryRepository.save(beneficiaryObj);

		//tiCommodityDistributionRepo.save(tiCommodityDistribution);

		//tiCommodityDistributionDto.setId(tiCommodityDistribution.getId());
	}
}
