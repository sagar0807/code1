/**
 * 
 */
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.IndentRequestStatusDto;
import gov.naco.soch.entity.IndentRequestStatusMaster;

/**
 * @date 2019-Dec-31 9:57:22 AM
 */
// Class to map between bean class(IndentRequestStatusDto) and entity
// class(IndentRequestEntity)
public class IndentRequestStatusMapperUtil {

	// Function to map list of IndentRequestStatusEntity class to list of
	// IndentRequestStatusDto class
	public static List<IndentRequestStatusDto> mapToIndentRequestStatusDtoList(
			List<IndentRequestStatusMaster> IndentRequestStatusList) {
		List<IndentRequestStatusDto> indentRequestStatusDtos = new ArrayList<IndentRequestStatusDto>();
		if (!CollectionUtils.isEmpty(IndentRequestStatusList)) {
			IndentRequestStatusList.forEach(indentRequestStatus -> {
				IndentRequestStatusDto indentRequestStatusDto = new IndentRequestStatusDto();
				indentRequestStatusDto.setId(indentRequestStatus.getId());
				indentRequestStatusDto
						.setIndentRequestStatusName(indentRequestStatus.getIndentRequestStatusName().trim());
				indentRequestStatusDto.setIs_active(indentRequestStatus.getIsActive());
				indentRequestStatusDto.setIs_delete(indentRequestStatus.getIsDelete());
				indentRequestStatusDtos.add(indentRequestStatusDto);
			});
		}
		return indentRequestStatusDtos;
	}

	// Function to map IndentRequestStatusDto class to IndentRequestStatusEntity
	// class
	public static IndentRequestStatusMaster mapToIndentRequestStatusEntity(
			IndentRequestStatusDto indentRequestStatusDto ,IndentRequestStatusMaster indentRequestStatus) {
		if(indentRequestStatus == null) {
			indentRequestStatus = new IndentRequestStatusMaster();
		}
		if (indentRequestStatusDto != null) {
			indentRequestStatus.setIndentRequestStatusName(indentRequestStatusDto.getIndentRequestStatusName().trim());
			indentRequestStatus.setIsActive(indentRequestStatusDto.getIs_active());
			indentRequestStatus.setIsDelete(indentRequestStatusDto.getIs_delete());
		}
		return indentRequestStatus;
	}

	// Function to map IndentRequestStatusEntity class to IndentRequestStatusDto
	// class
	public static IndentRequestStatusDto mapToIndentRequestStatusDto(IndentRequestStatusMaster indentRequestStatus) {
		IndentRequestStatusDto indentRequestStatusDto = new IndentRequestStatusDto();
		if (indentRequestStatus != null) {
			indentRequestStatusDto.setId(indentRequestStatus.getId());
			indentRequestStatusDto.setIndentRequestStatusName(indentRequestStatus.getIndentRequestStatusName().trim());
			indentRequestStatusDto.setIs_active(indentRequestStatus.getIsActive());
			indentRequestStatusDto.setIs_delete(indentRequestStatus.getIsDelete());
		}
		return indentRequestStatusDto;
	}
}
