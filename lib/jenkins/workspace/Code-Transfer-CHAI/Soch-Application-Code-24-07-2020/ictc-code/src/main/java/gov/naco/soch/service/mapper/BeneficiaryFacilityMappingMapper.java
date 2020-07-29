package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BeneficiaryFacilityMapping and its DTO BeneficiaryFacilityMappingDTO.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class, FacilityMapper.class})
public interface BeneficiaryFacilityMappingMapper extends EntityMapper<BeneficiaryFacilityMappingDTO, BeneficiaryFacilityMapping> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source = "facility.id", target = "facilityId")
    BeneficiaryFacilityMappingDTO toDto(BeneficiaryFacilityMapping beneficiaryFacilityMapping);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    @Mapping(source = "facilityId", target = "facility")
    BeneficiaryFacilityMapping toEntity(BeneficiaryFacilityMappingDTO beneficiaryFacilityMappingDTO);

    default BeneficiaryFacilityMapping fromId(Long id) {
        if (id == null) {
            return null;
        }
        BeneficiaryFacilityMapping beneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
        beneficiaryFacilityMapping.setId(id);
        return beneficiaryFacilityMapping;
    }
}
