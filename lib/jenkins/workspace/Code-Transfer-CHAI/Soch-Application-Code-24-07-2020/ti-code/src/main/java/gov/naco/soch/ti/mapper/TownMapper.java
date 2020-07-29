package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import gov.naco.soch.dto.TownDto;
import gov.naco.soch.entity.Town;

@Mapper(componentModel = "spring")
public interface TownMapper  extends EntityMapper<TownDto,Town> {
	
	Town toEntity(TownDto townDto);
	
	@InheritInverseConfiguration
	TownDto toDto(Town town);
	
	
	default Town fromId(Long id) {
		if (id == null) {
			return null;
		}
		Town town = new Town();
		town.setTownId(id);
		return town;
	}

}
