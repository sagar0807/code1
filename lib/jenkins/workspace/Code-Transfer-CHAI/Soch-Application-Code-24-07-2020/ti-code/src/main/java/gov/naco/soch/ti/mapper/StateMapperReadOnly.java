package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.dto.StateDto;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.StateReadOnly;

/**
 * Mapper for the entity {@link State} and its DTO {@link StateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StateMapperReadOnly extends EntityMapper<StateDto, StateReadOnly> {

	StateDto toDto(StateReadOnly state);
}
