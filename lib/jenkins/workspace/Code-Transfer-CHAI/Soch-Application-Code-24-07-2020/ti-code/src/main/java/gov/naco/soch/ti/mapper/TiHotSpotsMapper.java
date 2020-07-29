package gov.naco.soch.ti.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import gov.naco.soch.ti.dto.TIHotspotDto;
import gov.naco.soch.entity.TIHotspot;

@Mapper(componentModel = "spring",uses= {TiFacilityMapper.class,MMTypologyMapper.class,HotSpotAddressMapper.class})
public interface TiHotSpotsMapper extends EntityMapper<TIHotspotDto,TIHotspot> {
	@Mapping(target="typology",qualifiedByName="typology")
	TIHotspotDto toDto(TIHotspot tiHotspot);
	
	@InheritInverseConfiguration
	@Mapping(target="typology",qualifiedByName="typology")
	TIHotspot toEntity(TIHotspotDto tiHotspotDto);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	TIHotspot toUpdateEntity(TIHotspotDto tiHotSpotDTO, @MappingTarget TIHotspot tiHotSpot);

}
