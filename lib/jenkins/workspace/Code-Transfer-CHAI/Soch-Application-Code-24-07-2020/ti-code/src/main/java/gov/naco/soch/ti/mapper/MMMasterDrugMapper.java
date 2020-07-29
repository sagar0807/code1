package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterDrug;

@Mapper(componentModel = "spring")
@Named("masterDrug")
public interface MMMasterDrugMapper { //extends EntityMapper<MiniMasterDto, MasterDrug> {

	MiniMasterDto toDrugDto(MasterDrug product);

	MasterDrug toDrugEntity(MiniMasterDto productDto);

}