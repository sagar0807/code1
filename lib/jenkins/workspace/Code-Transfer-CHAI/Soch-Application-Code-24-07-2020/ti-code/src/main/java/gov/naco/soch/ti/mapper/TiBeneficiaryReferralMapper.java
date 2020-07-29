package gov.naco.soch.ti.mapper;

import java.time.LocalDate;
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;

import gov.naco.soch.dto.TiBeneficiaryReferralDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.TIBenCounselling;
import gov.naco.soch.entity.TIBenReferral;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO;
import gov.naco.soch.ti.dto.TiReferralDto;

public class TiBeneficiaryReferralMapper {

	private static Beneficiary mapToBeneficiary(Long beneficiaryId) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(beneficiaryId);
		return beneficiary;
	}

	public static List<TiReferralDto> mapTiRefferalToTiRefferalDto(List<TiReferralDto> tiReferralDtos,
			List<TIBenReferral> benReferrals) {
		for(TIBenReferral benReferral : benReferrals) {
			TiReferralDto referralDto = new TiReferralDto(); 
			TIBeneficiary tiBeneficiary = benReferral.getBeneficiary();
			referralDto.setId(benReferral.getId());
			referralDto.setDateOfReferral(benReferral.getDateOfReferral());
			referralDto.setReferredFrom(benReferral.getTransferFrom());
			referralDto.setReferredTo(benReferral.getTransferTo());
 			Beneficiary beneficiary = tiBeneficiary.getBeneficiary();
			referralDto.setAge(Integer.parseInt(beneficiary.getAge()));
			referralDto.setName(beneficiary.getFirstName()+" "+beneficiary.getLastName());
			referralDto.setGender(beneficiary.getGender());
			referralDto.setMobileNumber(beneficiary.getMobileNumber());
			referralDto.setUid(beneficiary.getUid());
			tiReferralDtos.add(referralDto);
		}
		return tiReferralDtos;
	}

	public static TIBenReferral mapReferralDtoToTiBenReferral(TIBenReferral tiBenReferral,
			TiReferralDto referralDto) {
		tiBenReferral.setIsDelete(false);
		tiBenReferral.transferTo(referralDto.getReferredTo());
		tiBenReferral.setTransferFrom(referralDto.getReferredFrom());
		return tiBenReferral;
	}
	
   
    public static BeneficiaryReferral mapTiBeneficiaryReferralDtoToTiBeneficiaryReferral(TiBeneficiaryReferralDto tiBeneficiaryReferralDto) {
    	BeneficiaryReferral beneficiaryReferral =new BeneficiaryReferral();
    	Beneficiary beneficiary = new Beneficiary();
    	beneficiary.setId(tiBeneficiaryReferralDto.getBeneficiaryId());
    	beneficiaryReferral.setBeneficiary(beneficiary);
    	Facility referralFacility = new Facility();
    	Long facilityFrom=Long.valueOf(tiBeneficiaryReferralDto.getReferralFacility());
    	referralFacility.setId(facilityFrom);
    	beneficiaryReferral.setFacility1(referralFacility);
    	Facility referredFacility = new Facility();
    	Long facilityTo=Long.valueOf(tiBeneficiaryReferralDto.getReferredFacility());
    	referredFacility.setId(facilityTo);
    	beneficiaryReferral.setFacility2(referredFacility);
    	MasterReferralStatus masterReferralStatus= new MasterReferralStatus();
    	masterReferralStatus.setId(1l);
    	beneficiaryReferral.setBeneficiaryReferralStatusMaster(masterReferralStatus);
    	beneficiaryReferral.setReferralType(tiBeneficiaryReferralDto.getReferralType());
    	beneficiaryReferral.setReferDate(LocalDate.now());
    	return beneficiaryReferral;
    }
 
}
