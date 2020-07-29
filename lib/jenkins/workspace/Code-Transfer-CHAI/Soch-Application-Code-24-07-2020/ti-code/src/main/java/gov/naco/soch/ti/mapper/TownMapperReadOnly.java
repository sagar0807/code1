package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.dto.TownDto;
import gov.naco.soch.entity.TownReadOnly;

@Mapper(componentModel = "spring")
public interface TownMapperReadOnly extends EntityMapper<TownDto, TownReadOnly> {

    TownDto toDto(TownReadOnly town);
}