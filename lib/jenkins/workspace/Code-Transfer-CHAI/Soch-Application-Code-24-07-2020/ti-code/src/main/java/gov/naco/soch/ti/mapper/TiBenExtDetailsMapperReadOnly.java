package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiBenExtDetailsReadOnly;
import gov.naco.soch.ti.dto.TIBenfExtDetailsDTO;

@Mapper(componentModel = "spring",uses = {ExtDetailsAvailMapperReadOnly.class})
public interface TiBenExtDetailsMapperReadOnly extends EntityMapper<TIBenfExtDetailsDTO, TiBenExtDetailsReadOnly> {
    @Mapping(source="beneficiary.id",target="beneficiaryId")
    TIBenfExtDetailsDTO toDto(TiBenExtDetailsReadOnly tIBenExtDetails);

    default TiBenExtDetailsReadOnly fromId(Long id) {
        if (id == null) {
            return null;
        }
        TiBenExtDetailsReadOnly tiBenExtDetailsReadOnly = new TiBenExtDetailsReadOnly();
        tiBenExtDetailsReadOnly.setId(id);
        return tiBenExtDetailsReadOnly;
    }
}
