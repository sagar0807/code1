package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.TypologyMaster;

@Mapper(componentModel = "spring")
@Named("typology")
public interface MMTypologyMapper {

	@Mapping(source="id",target="typologyId")
	@Mapping(source="name",target="typologyName")
	TypologyMaster toTypologyEntity(MiniMasterDto miniMasterDto);
	@InheritInverseConfiguration
	MiniMasterDto toTypologyDto(TypologyMaster typologyMaster);
}
