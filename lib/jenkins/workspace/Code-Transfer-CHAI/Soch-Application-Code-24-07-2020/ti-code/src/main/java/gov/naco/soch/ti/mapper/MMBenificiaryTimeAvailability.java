package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.ExtDetailsTimeAvailabilityMapping;
import gov.naco.soch.entity.MasterBenificiaryTimeAvailability;


@Mapper(componentModel = "spring")
@Named("timeAvailability")
public interface MMBenificiaryTimeAvailability {

	MasterBenificiaryTimeAvailability toEntitity(MiniMasterDto masterBenificiaryTimeAvailabilityDto);
	
	MiniMasterDto toDto(MasterBenificiaryTimeAvailability masterBenificiaryTimeAvailability);

}
