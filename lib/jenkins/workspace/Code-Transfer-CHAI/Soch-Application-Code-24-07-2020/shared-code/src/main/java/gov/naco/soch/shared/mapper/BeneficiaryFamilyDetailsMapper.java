package gov.naco.soch.shared.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import gov.naco.soch.dto.BeneficiaryFamilyDetailsDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFamilyDetail;

@Mapper(componentModel = "spring")
public interface BeneficiaryFamilyDetailsMapper
		extends EntityMapper<BeneficiaryFamilyDetailsDto, BeneficiaryFamilyDetail> {

	@Mapping(source = "partnerBeneficiary.id", target = "partnerBeneficiaryId")
	@Mapping(source = "partnerBeneficiary.uid", target = "partnerUid")
	BeneficiaryFamilyDetailsDto toDto(BeneficiaryFamilyDetail beneficiaryFamilyDetail);

	@AfterMapping
	default void setPartnerName(@MappingTarget BeneficiaryFamilyDetailsDto familyDetails,
			BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		Beneficiary partner = beneficiaryFamilyDetail.getPartnerBeneficiary();
		if (partner.getLastName() != null) {
			familyDetails.setPartnerName(partner.getFirstName() + " " + partner.getLastName());
		} else {
			 familyDetails.setPartnerName(partner.getFirstName());
		}
	}

	default BeneficiaryFamilyDetail fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryFamilyDetail beneficiaryFamilyDetail = new BeneficiaryFamilyDetail();
		beneficiaryFamilyDetail.setId(id);
		return beneficiaryFamilyDetail;
	}

}