package gov.naco.soch.ti.mapper;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.TIBenfExtDetailsDTO;
import gov.naco.soch.entity.TIBeneficiaryExtDetails;
import gov.naco.soch.ti.dto.TIBenExtDetailsDTO;

/**
 * Mapper for the entity {@link TIBenExtDetails} and its DTO {@link TIBenExtDetailsDTO}.
 */
@Mapper(componentModel = "spring",uses = {ExtDetailsTimeAvailabilityMapper.class})
public interface TIBenExtDetailsMapper extends EntityMapper<TIBenfExtDetailsDTO, TIBeneficiaryExtDetails> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source="facility.id",target="facilityId")
    TIBenfExtDetailsDTO toDto(TIBeneficiaryExtDetails tIBenExtDetails);

    @InheritInverseConfiguration
    TIBeneficiaryExtDetails toEntity(TIBenfExtDetailsDTO tIBenExtDetailsDTO);

    default TIBeneficiaryExtDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBeneficiaryExtDetails tIBenExtDetails = new TIBeneficiaryExtDetails();
        tIBenExtDetails.setId(id);
        return tIBenExtDetails;
    }
}
