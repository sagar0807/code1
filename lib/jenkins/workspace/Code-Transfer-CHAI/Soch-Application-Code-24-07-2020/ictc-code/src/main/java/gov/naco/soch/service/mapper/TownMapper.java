package gov.naco.soch.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.domain.District;
import gov.naco.soch.domain.Town;
import gov.naco.soch.service.dto.TownDTO;

@Mapper(componentModel = "spring", uses = {SubdistrictMapper.class})
public interface TownMapper extends EntityMapper<TownDTO, Town>{

	@Mapping(source = "subdistrict.subdistrictId", target = "subdistrictId")
	TownDTO toDto(Town town);
	
	@Mapping(source = "subdistrictId", target = "subdistrict")
    Town toEntity(TownDTO townDTO);
	
	default Town fromId(Long townId) {
        if (townId == null) {
            return null;
        }
        Town town = new Town();
        town.setTownId(townId);
        return town;
    }
}
