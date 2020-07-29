package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBenChildDetails;
import gov.naco.soch.ti.dto.TIBenChildDetailsDTO;

/**
 * Mapper for the entity {@link TIBenChildDetails} and its DTO
 * {@link TIBenChildDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = MMGenderMapper.class)
public interface TIBenChildDetailsMapper extends EntityMapper<TIBenChildDetailsDTO, TIBenChildDetails> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source = "facility.id", target = "facilityId")
    @Mapping(target = "genderId", qualifiedByName = "gender")
    TIBenChildDetailsDTO toDto(TIBenChildDetails tIBenChildDetails);

    @InheritInverseConfiguration
    TIBenChildDetails toEntity(TIBenChildDetailsDTO tIBenChildDetailsDTO);

    default TIBenChildDetails fromId(Long id) {
	if (id == null) {
	    return null;
	}
	TIBenChildDetails tIBenChildDetails = new TIBenChildDetails();
	tIBenChildDetails.setId(id);
	return tIBenChildDetails;
    }
}
