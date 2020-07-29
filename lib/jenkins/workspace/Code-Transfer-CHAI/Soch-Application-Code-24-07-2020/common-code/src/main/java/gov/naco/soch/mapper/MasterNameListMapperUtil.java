
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.MasterNameListDto;
import gov.naco.soch.entity.MasterNameList;

/**
 * @date 2020-Jan-03 1:05:41 PM
 */

public class MasterNameListMapperUtil {

	// function to map list of MasterNameList class to list of MasterNameListDto
	// class.
	public static List<MasterNameListDto> mapToMasterNameList(List<MasterNameList> masterNameList) {
		List<MasterNameListDto> masterNameListDtos = new ArrayList<MasterNameListDto>();
		if (!CollectionUtils.isEmpty(masterNameList)) {
			masterNameList.forEach(masterName -> {
				MasterNameListDto masterNameListDto = new MasterNameListDto();
				masterNameListDto.setId(masterName.getId());
				masterNameListDto.setMasterName(masterName.getMasterName());
				masterNameListDto.setMasterDescription(masterName.getMasterDescription());
				masterNameListDto.setIsActive(masterName.getIsActive());
				masterNameListDto.setIsDelete(masterName.getIsDelete());
				masterNameListDto.setMasterType(masterName.getMasterType());
				masterNameListDto.setFetchEndpoint(masterName.getFetchEndpoint());
				masterNameListDto.setSaveEndpoint(masterName.getSaveEndpoint());
				masterNameListDtos.add(masterNameListDto);
			});
		}
		return masterNameListDtos;
	}

}
