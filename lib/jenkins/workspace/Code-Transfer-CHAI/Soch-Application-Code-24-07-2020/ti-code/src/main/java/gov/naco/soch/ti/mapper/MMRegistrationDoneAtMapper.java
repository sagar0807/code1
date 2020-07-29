package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterRegistrationDoneAt;

@Mapper(componentModel = "spring")
@Named("registrationDoneAt")
public interface MMRegistrationDoneAtMapper {//extends EntityMapper<MiniMasterDto, MasterRegistrationDoneAt> {

	MasterRegistrationDoneAt toRegDoneAtEntity(MiniMasterDto masterRegistrationDoneAt);
	
	MiniMasterDto toRegDoneAtDto(MasterRegistrationDoneAt masterRegistrationDoneAt);
}
