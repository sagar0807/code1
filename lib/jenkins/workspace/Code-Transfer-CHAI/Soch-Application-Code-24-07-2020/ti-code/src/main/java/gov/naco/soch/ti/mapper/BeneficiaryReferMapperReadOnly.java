package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.BeneficiaryReferralReadOnly;

@Mapper(componentModel = "spring", uses = {})
public interface BeneficiaryReferMapperReadOnly extends EntityMapper<BeneficiaryReferralDto, BeneficiaryReferralReadOnly> {

	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "facility1.id", target = "referredFromFacility")
	@Mapping(source = "facility2.id", target = "referredToFacility")
	@Mapping(source = "facility1.name", target = "referredFromFacilityName")
	@Mapping(source = "facility2.name", target = "referredToFacilityName")
	@Mapping(source = "referralReason", target = "referralReason")
	@Mapping(source = "facilityType", target = "facilityType")
	@Mapping(source="beneficiaryReferralStatusMaster.name",target="status")
	@Mapping(source = "isDelete", target = "isDelete")
	BeneficiaryReferralDto toDto(BeneficiaryReferralReadOnly beneficiaryReferral);

	default BeneficiaryReferralReadOnly fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryReferralReadOnly beneficiaryReferralReadOnly = new BeneficiaryReferralReadOnly();
		beneficiaryReferralReadOnly.setId(id);
		return beneficiaryReferralReadOnly;
	}
}
