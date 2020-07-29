package gov.naco.soch.mapper;

import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.entity.LabTypesMaster;
import gov.naco.soch.entity.MasterData;

public class MasterDataMapper {

	/*
	 * function to map masterData class to MasterDto
	 */
	public static MasterDto mapToMasterDto(MasterData masterData) {
		MasterDto masterDto = new MasterDto();
		masterDto.setId(masterData.getId());
		masterDto.setName(masterData.getName());
		masterDto.setCode(masterData.getCode());

		return masterDto;
	}
	
	/*
	 * function to map LabTypesMaster class to MasterDto
	 */
	public static MasterDto mapLabTypesMasterToMasterDto(LabTypesMaster labTypesMaster) {
		MasterDto masterDto = new MasterDto();
		masterDto.setId(labTypesMaster.getId());
		masterDto.setName(labTypesMaster.getLabTypeName());

		return masterDto;
	}

}
