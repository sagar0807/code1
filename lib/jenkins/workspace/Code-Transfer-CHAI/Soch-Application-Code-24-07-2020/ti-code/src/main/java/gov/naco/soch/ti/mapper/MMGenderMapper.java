package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterGender;

@Mapper(componentModel = "spring")
@Named("gender")
public interface MMGenderMapper {// extends EntityMapper<MiniMasterDto, MasterGender>  {

	
	MasterGender toGenderEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toGenderDto(MasterGender masterMaritalStatus);
	
}
