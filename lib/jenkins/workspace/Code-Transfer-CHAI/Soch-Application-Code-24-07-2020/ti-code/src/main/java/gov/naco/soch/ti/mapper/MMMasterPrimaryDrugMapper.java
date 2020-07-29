package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterPrimaryDrug;

@Mapper(componentModel = "spring")
@Named("drug")
public interface MMMasterPrimaryDrugMapper {//extends EntityMapper<MiniMasterDto, MasterPrimaryDrug> {

	@Named("primaryDrug")
	MiniMasterDto toPrimaryDrugDto(MasterPrimaryDrug product);

	@Named("primaryDrug")
	MasterPrimaryDrug toPrimaryDrugEntity(MiniMasterDto productDto);
	
	@Named("otherDrug")
	MiniMasterDto toOtherDrugDto(MasterPrimaryDrug product);

	@Named("otherDrug")
	MasterPrimaryDrug toOtherDrugEntity(MiniMasterDto productDto);

}