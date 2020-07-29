package gov.naco.soch.shared.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFamilyDetail;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterHivStatus;
import gov.naco.soch.entity.MasterRelationship;
import gov.naco.soch.shared.dto.BeneficiaryReferralDto;
import gov.naco.soch.shared.dto.PartnerLinkageDto;
import gov.naco.soch.shared.dto.UnregisteredPartnerDto;

public class UnregisteredPartnerMapper {

	public static BeneficiaryFamilyDetail mapUnregisteredPartnerDtoToBeneficiaryFamilyDetail(
			@Valid Beneficiary beneficiary, BeneficiaryFamilyDetail beneficiaryFamilyDetails,
			@Valid UnregisteredPartnerDto unregisteredPartnerDto) {
		BeneficiaryFamilyDetail beneficiaryFamilyDetail = new BeneficiaryFamilyDetail();
		beneficiaryFamilyDetail.setAgeMonths(unregisteredPartnerDto.getAgeMonths());
		beneficiaryFamilyDetail.setAgeYears(unregisteredPartnerDto.getAgeYears());
		beneficiaryFamilyDetail.setBeneficiary(beneficiary);
		if (beneficiaryFamilyDetails != null) {
			beneficiaryFamilyDetail.setFamilyUid(beneficiaryFamilyDetails.getFamilyUid());
		} else {
			beneficiaryFamilyDetail.setFamilyUid("F" + beneficiary.getUid());
		}
		beneficiaryFamilyDetail.setFirstName(unregisteredPartnerDto.getFirstName());
		beneficiaryFamilyDetail.setLastName(unregisteredPartnerDto.getLastName());
		beneficiaryFamilyDetail.setIsActive(Boolean.TRUE);
		beneficiaryFamilyDetail.setIsAlive(unregisteredPartnerDto.getIsAlive());
		beneficiaryFamilyDetail.setIsBeneficiary(Boolean.FALSE);
		beneficiaryFamilyDetail.setIsDelete(Boolean.FALSE);
		beneficiaryFamilyDetail.setMobileNumber(unregisteredPartnerDto.getMobileNumber());
		MasterGender masterGender = new MasterGender();
		masterGender.setId(unregisteredPartnerDto.getGenderId());
		beneficiaryFamilyDetail.setMasterGender(masterGender);
		MasterHivStatus masterHivStatus = new MasterHivStatus();
		masterHivStatus.setId(unregisteredPartnerDto.getHivStatusId());
		beneficiaryFamilyDetail.setMasterHivStatus(masterHivStatus);
		MasterRelationship masterRelationship = new MasterRelationship();
		masterRelationship.setId(unregisteredPartnerDto.getRelationShipStatusId());
		beneficiaryFamilyDetail.setMasterRelationship(masterRelationship);
		beneficiaryFamilyDetail.setOnArt(Boolean.FALSE);
		return beneficiaryFamilyDetail;
	}

	public static PartnerLinkageDto mapBeneficiaryFamilyDetailToPartnerLinkageDto(
			BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		PartnerLinkageDto partnerLinkageDto = new PartnerLinkageDto();
		if (beneficiaryFamilyDetail.getIsBeneficiary() == Boolean.TRUE) {
			partnerLinkageDto.setIsUnreg(Boolean.FALSE);
			if (beneficiaryFamilyDetail.getPartnerBeneficiary() != null) {
				partnerLinkageDto.setPartnerBeneficiaryId(beneficiaryFamilyDetail.getPartnerBeneficiary().getId());
				partnerLinkageDto.setUid(beneficiaryFamilyDetail.getPartnerBeneficiary().getUid());
				partnerLinkageDto.setFirstName(beneficiaryFamilyDetail.getPartnerBeneficiary().getFirstName());
				partnerLinkageDto.setLastName(beneficiaryFamilyDetail.getPartnerBeneficiary().getLastName());
			}

		} else if (beneficiaryFamilyDetail.getIsBeneficiary() == Boolean.FALSE) {
			partnerLinkageDto.setIsUnreg(Boolean.TRUE);
			partnerLinkageDto.setAgeMonths(beneficiaryFamilyDetail.getAgeMonths());
			partnerLinkageDto.setAgeYears(beneficiaryFamilyDetail.getAgeYears());
			partnerLinkageDto.setFirstName(beneficiaryFamilyDetail.getFirstName());
			partnerLinkageDto.setLastName(beneficiaryFamilyDetail.getLastName());
			partnerLinkageDto.setMobileNumber(beneficiaryFamilyDetail.getMobileNumber());
		}

		if (beneficiaryFamilyDetail.getMasterGender() != null) {
			partnerLinkageDto.setGender(beneficiaryFamilyDetail.getMasterGender().getName());
			partnerLinkageDto.setGenderId(beneficiaryFamilyDetail.getMasterGender().getId());
		}
		if (beneficiaryFamilyDetail.getMasterHivStatus() != null) {
			partnerLinkageDto.setHivStatus(beneficiaryFamilyDetail.getMasterHivStatus().getName());
			partnerLinkageDto.setHivStatusId(beneficiaryFamilyDetail.getMasterHivStatus().getId());
		}
		if (beneficiaryFamilyDetail.getMasterRelationship() != null) {
			partnerLinkageDto.setRelationShipStatus(beneficiaryFamilyDetail.getMasterRelationship().getName());
			partnerLinkageDto.setRelationShipStatusId(beneficiaryFamilyDetail.getMasterRelationship().getId());
		}
		partnerLinkageDto.setId(beneficiaryFamilyDetail.getId());
		if (beneficiaryFamilyDetail.getBeneficiary() != null) {
			partnerLinkageDto.setBeneficiaryId(beneficiaryFamilyDetail.getBeneficiary().getId());
		}

		partnerLinkageDto.setIsAlive(beneficiaryFamilyDetail.getIsAlive());

		return partnerLinkageDto;
	}

	public static List<BeneficiaryReferralDto> mapReferralDetails(List<BeneficiaryReferral> referrals) {
		List<BeneficiaryReferralDto> referralDtos = new ArrayList<BeneficiaryReferralDto>();
		referrals.forEach(referral -> {
			BeneficiaryReferralDto beneficiaryReferralDto = new BeneficiaryReferralDto();
			if (referral.getAcceptedDate() != null) {
				beneficiaryReferralDto.setAcceptedDate(referral.getAcceptedDate().toLocalDate());
			}
			beneficiaryReferralDto.setReferralDate(referral.getReferDate());
			beneficiaryReferralDto.setReferredFrom(referral.getFacility1().getName());
			beneficiaryReferralDto.setReferredFromId(referral.getFacility1().getId());
			beneficiaryReferralDto.setReferredTo(referral.getFacility2().getName());
			beneficiaryReferralDto.setReferredToId(referral.getFacility2().getId());
			referralDtos.add(beneficiaryReferralDto);
		});
		return referralDtos;
	}

}
