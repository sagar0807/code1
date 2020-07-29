package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterBeneficiaryOstStatus;

@Mapper(componentModel = "spring")
@Named("ostStatus")
public interface MMOstStatusMapper {

	MasterBeneficiaryOstStatus toOstStatusEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toOstStatusDto(MasterBeneficiaryOstStatus masterBeneficiaryOstStatus);
}