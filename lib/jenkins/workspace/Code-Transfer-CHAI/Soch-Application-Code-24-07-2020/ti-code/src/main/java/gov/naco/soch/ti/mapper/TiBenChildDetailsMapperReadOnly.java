package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBenChildDetails;
import gov.naco.soch.entity.TiBenChildDetailsReadOnly;
import gov.naco.soch.ti.dto.TIBenChildDetailsDTO;

/**
 * Mapper for the entity {@link TIBenChildDetails} and its DTO
 * {@link TIBenChildDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = MMGenderMapper.class)
public interface TiBenChildDetailsMapperReadOnly extends EntityMapper<TIBenChildDetailsDTO, TiBenChildDetailsReadOnly> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(target = "genderId", qualifiedByName = "gender")
    TIBenChildDetailsDTO toDto(TiBenChildDetailsReadOnly tIBenChildDetails);


    default TiBenChildDetailsReadOnly fromId(Long id) {
	if (id == null) {
	    return null;
	}
	TiBenChildDetailsReadOnly tiBenChildDetailsReadOnly = new TiBenChildDetailsReadOnly();
	tiBenChildDetailsReadOnly.setId(id);
	return tiBenChildDetailsReadOnly;
    }
}
