package gov.naco.soch.shared.mapper;

import org.mapstruct.*;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.BeneficiaryReferral;

@Mapper(componentModel = "spring", uses = {})
public interface BeneficiaryReferMapper extends EntityMapper<BeneficiaryReferralDto, BeneficiaryReferral> {

	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "facility1.id", target = "referredFromFacility")
	@Mapping(source = "facility2.id", target = "referredToFacility")
	@Mapping(source = "facility1.name", target = "referredFromFacilityName")
	@Mapping(source = "facility2.name", target = "referredToFacilityName")
	@Mapping(source = "referralReason", target = "referralReason")
	@Mapping(source = "facilityType", target = "facilityType")
	@Mapping(source = "beneficiaryReferralStatusMaster.name", target = "status")
	@Mapping(source = "isDelete", target = "isDelete")
	BeneficiaryReferralDto toDto(BeneficiaryReferral beneficiaryReferral);

	default BeneficiaryReferral fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
		beneficiaryReferral.setId(id);
		return beneficiaryReferral;
	}
}
