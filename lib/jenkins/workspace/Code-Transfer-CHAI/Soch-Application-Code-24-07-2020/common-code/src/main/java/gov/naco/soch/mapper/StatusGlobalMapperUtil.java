
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.StatusGlobalDto;

public class StatusGlobalMapperUtil {

	// function to map list of StatusGlobal class to list of StatusGlobalDto class.
	/*public static List<StatusGlobalDto> mapToStatusGlobalDto(List<StatusGlobalMaster> statusGlobalList) {
		List<StatusGlobalDto> statusGlobalDtos = new ArrayList<StatusGlobalDto>();
		if (!CollectionUtils.isEmpty(statusGlobalList)) {
			statusGlobalList.forEach(statusGlobal -> {
				StatusGlobalDto statusGlobalDto = new StatusGlobalDto();
				statusGlobalDto.setId(statusGlobal.getId());
				statusGlobalDto.setGlobalStatusName(statusGlobal.getGlobalStatusName());
				statusGlobalDtos.add(statusGlobalDto);
			});
		}
		return statusGlobalDtos;
	}*/

	// function to map StatusGlobalDto class to StatusGlobal class.
	/*public static StatusGlobalMaster mapToStatusGlobal(StatusGlobalDto statusGlobalDto,
			StatusGlobalMaster statusGlobal) {
		if (statusGlobal == null) {
			statusGlobal = new StatusGlobalMaster();
		}
		if (statusGlobalDto != null) {
			statusGlobal.setId(statusGlobalDto.getId());
			statusGlobal.setGlobalStatusName(statusGlobalDto.getGlobalStatusName());
		}
		return statusGlobal;
	}*/

}
