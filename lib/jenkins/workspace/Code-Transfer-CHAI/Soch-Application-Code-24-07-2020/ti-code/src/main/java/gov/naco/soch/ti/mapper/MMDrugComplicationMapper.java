package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterDrugComplications;

@Mapper(componentModel = "spring")
@Named("drugComplication")
public interface MMDrugComplicationMapper {// extends EntityMapper<MiniMasterDto, MasterDrugComplications>  {

	
	MasterDrugComplications toDrugComplicationsEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toDrugComplicationsDto(MasterDrugComplications masterDrugComplications);
	
}
