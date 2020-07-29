package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.entity.BeneficiaryReferral;

@Mapper(componentModel = "spring", uses = {})
public interface BeneficiaryScreeningReferralMapper extends EntityMapper<BeneficiaryReferralDto, BeneficiaryReferral> {
	
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "facility1.id", target = "referredFromFacility")
	@Mapping(source = "facility2.id", target = "referredToFacility")
	@Mapping(source = "referralReason", target = "referralReason")
	@Mapping(source = "facilityType", target = "facilityType")
	@Mapping(source = "isDelete", target = "isDelete")
	BeneficiaryReferralDto toDto(BeneficiaryReferral beneficiaryReferral);
	
	@InheritInverseConfiguration
	BeneficiaryReferral toEntity(BeneficiaryReferralDto beneficiaryReferralDto);
	
	default BeneficiaryReferral fromId(Long id) {
        if (id == null) {
            return null;
        }
        BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
        beneficiaryReferral.setId(id);
        return beneficiaryReferral;
    }
}