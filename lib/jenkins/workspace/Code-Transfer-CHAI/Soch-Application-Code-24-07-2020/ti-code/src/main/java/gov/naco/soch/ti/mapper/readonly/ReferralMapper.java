package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.ti.entity.BenReferral;
import gov.naco.soch.ti.mapper.EntityMapper;

@Mapper(componentModel = "spring", uses = {})
public interface ReferralMapper extends EntityMapper<BeneficiaryReferralDto, BenReferral> {
	
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "facility1.id", target = "referredFromFacility")
	@Mapping(source = "facility2.id", target = "referredToFacility")
	@Mapping(source = "referralReason", target = "referralReason")
	@Mapping(source = "facilityType", target = "facilityType")
	@Mapping(source = "isDelete", target = "isDelete")
	BeneficiaryReferralDto toDto(BenReferral beneficiaryReferral);
}
