package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ArtBeneficiaryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ArtBeneficiary and its DTO ArtBeneficiaryDTO.
 */
@Mapper(componentModel = "spring", uses = {FacilityMapper.class})
public interface ArtBeneficiaryMapper extends EntityMapper<ArtBeneficiaryDTO, ArtBeneficiary> {

    @Mapping(source = "facility.id", target = "facilityId")
    ArtBeneficiaryDTO toDto(ArtBeneficiary artBeneficiary);

    @Mapping(source = "facilityId", target = "facility")
    ArtBeneficiary toEntity(ArtBeneficiaryDTO artBeneficiaryDTO);

    default ArtBeneficiary fromId(Long id) {
        if (id == null) {
            return null;
        }
        ArtBeneficiary artBeneficiary = new ArtBeneficiary();
        artBeneficiary.setId(id);
        return artBeneficiary;
    }
}
