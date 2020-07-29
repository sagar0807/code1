package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterTruckerOccupation;

@Mapper(componentModel = "spring")
@Named("truckerOccupation")
public interface MMTruckerOccupation {

        MasterTruckerOccupation toTruckerEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toTruckerDto(MasterTruckerOccupation entity); 
}