package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import gov.naco.soch.dto.StateDto;
import gov.naco.soch.entity.State;

/**
 * Mapper for the entity {@link State} and its DTO {@link StateDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StateMapper extends EntityMapper<StateDto, State> {

	State toEntity(StateDto stateDTO);

	// @Mapping(target = "districts",ignore=true)
	@InheritInverseConfiguration
	StateDto toDto(State state);

	default State fromId(Long id) {
		if (id == null) {
			return null;
		}
		State state = new State();
		state.setId(id);
		return state;
	}
}
