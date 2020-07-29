package gov.naco.soch.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;

/**
 * Mapper for the entity {@link BeneficiaryReferral} and its DTO {@link BeneficiaryReferralDTO}.
 */
@Mapper(componentModel = "spring", uses = {FacilityMapper.class, BeneficiaryMapper.class})
public interface BeneficiaryReferralMapper extends EntityMapper<BeneficiaryReferralDTO, BeneficiaryReferral> {

	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "referedFrom.id", target = "referedFrom")
	@Mapping(source = "referedTo.id", target = "referedTo")
	BeneficiaryReferralDTO toDto(BeneficiaryReferral beneficiaryReferral);
	
	@Mapping(source = "beneficiaryId", target = "beneficiary")
	@Mapping(source = "referedFrom", target = "referedFrom")
	@Mapping(source = "referedTo", target = "referedTo")
	BeneficiaryReferral toEntity(BeneficiaryReferralDTO beneficiaryReferralDTO);
	
    default BeneficiaryReferral fromId(Long id) {
        if (id == null) {
            return null;
        }
        BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
        beneficiaryReferral.setId(id);
        return beneficiaryReferral;
    }
}
