package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.dto.SubdistrictDto;
import gov.naco.soch.entity.SubDistrictReadOnly;

@Mapper(componentModel = "spring", uses = {})
public interface SubDistrictMapperReadOnly extends EntityMapper<SubdistrictDto, SubDistrictReadOnly> {

    SubdistrictDto toDto(SubDistrictReadOnly subdistrict);
}
