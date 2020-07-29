package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BeneficiaryFamilyDetails} and its DTO {@link BeneficiaryFamilyDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BeneficiaryFamilyDetailsMapper extends EntityMapper<BeneficiaryFamilyDetailsDTO, BeneficiaryFamilyDetails> {


    @Mapping(source = "memberBeneficiary.id", target = "memberBeneficiaryId")
    BeneficiaryFamilyDetailsDTO toDto(BeneficiaryFamilyDetails beneficiaryFamilyDetails);
//
//    @Mapping(source = "memberBeneficiaryId", target = "memberBeneficiary")
//    @Mapping(source = "beneficiaryId", target = "beneficiary")
//    BeneficiaryFamilyDetails toEntity(BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO);

    default BeneficiaryFamilyDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        BeneficiaryFamilyDetails beneficiaryFamilyDetails = new BeneficiaryFamilyDetails();
        beneficiaryFamilyDetails.setId(id);
        return beneficiaryFamilyDetails;
    }
}
