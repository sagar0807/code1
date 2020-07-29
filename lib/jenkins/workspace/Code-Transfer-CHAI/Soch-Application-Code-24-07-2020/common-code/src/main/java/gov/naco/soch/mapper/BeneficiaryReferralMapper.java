package gov.naco.soch.mapper;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Facility;

public class BeneficiaryReferralMapper {

	public static BeneficiaryReferral mapToBeneficiaryReferralEntity(BeneficiaryReferralDto beneficiaryReferralDto) {
		BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(beneficiaryReferralDto.getBeneficiaryId());
		beneficiaryReferral.setBeneficiary(beneficiary);
		beneficiaryReferral.setDateOfVisit(beneficiaryReferralDto.getDateOfVisit());
		Facility referredFromFacility = new Facility();
		referredFromFacility.setId(beneficiaryReferralDto.getReferredFromFacility());
		Facility referredToFacility = new Facility();
		referredToFacility.setId(beneficiaryReferralDto.getReferredToFacility());
		beneficiaryReferral.setFacility1(referredFromFacility);
		beneficiaryReferral.setFacility2(referredToFacility);
		beneficiaryReferral.setReferDate(beneficiaryReferralDto.getReferDate());
		return beneficiaryReferral;
	}

}
