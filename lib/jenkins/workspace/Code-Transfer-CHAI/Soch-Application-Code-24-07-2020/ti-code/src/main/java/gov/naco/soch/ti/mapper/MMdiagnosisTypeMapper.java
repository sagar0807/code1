package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterDiagnosisType;

@Mapper(componentModel = "spring")
@Named("diagnosisType")
public interface MMdiagnosisTypeMapper {

	MasterDiagnosisType toEntity(MiniMasterDto diagnosisType);
	
	MiniMasterDto toDto(MasterDiagnosisType diagnosisType);
}
