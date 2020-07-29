package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterHrgPrimary;

@Mapper(componentModel = "spring")
@Named("hrgPrimary")
public interface MMHrgPrimaryMapper { //extends EntityMapper<MiniMasterDto,MasterHrgPrimary> {

	
	MasterHrgPrimary toHrgPrimaryEntity(MiniMasterDto hrgPrimary);

	MiniMasterDto toHrgPrimaryDto(MasterHrgPrimary hrgPrimary); 
	
	
}
