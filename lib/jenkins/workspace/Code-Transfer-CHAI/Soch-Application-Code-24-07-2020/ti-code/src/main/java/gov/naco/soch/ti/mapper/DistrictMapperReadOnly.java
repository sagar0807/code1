package gov.naco.soch.ti.mapper;

import org.mapstruct.*;

import gov.naco.soch.dto.DistrictDto;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.DistrictReadOnly;

/**
 * Mapper for the entity {@link District} and its DTO {@link DistrictDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DistrictMapperReadOnly extends EntityMapper<DistrictDto, DistrictReadOnly> {
    DistrictDto toDto(DistrictReadOnly district);
}