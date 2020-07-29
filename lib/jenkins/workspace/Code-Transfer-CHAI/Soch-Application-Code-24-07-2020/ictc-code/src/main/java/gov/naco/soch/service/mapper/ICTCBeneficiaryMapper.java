package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ICTCBeneficiary} and its DTO {@link ICTCBeneficiaryDTO}.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class, FacilityMapper.class, ArtBeneficiaryMapper.class})
public interface ICTCBeneficiaryMapper extends EntityMapper<ICTCBeneficiaryDTO, ICTCBeneficiary> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source = "facility.id", target = "facilityId")
//    @Mapping(source = "artBeneficiaryDetails.id", target = "infantMotherArtId")
    ICTCBeneficiaryDTO toDto(ICTCBeneficiary iCTCBeneficiary);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    @Mapping(source = "facilityId", target = "facility")
//    @Mapping(source = "infantMotherArtId", target = "artBeneficiaryDetails")
    ICTCBeneficiary toEntity(ICTCBeneficiaryDTO iCTCBeneficiaryDTO);

    default ICTCBeneficiary fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCBeneficiary iCTCBeneficiary = new ICTCBeneficiary();
        iCTCBeneficiary.setId(id);
        return iCTCBeneficiary;
    }
}
