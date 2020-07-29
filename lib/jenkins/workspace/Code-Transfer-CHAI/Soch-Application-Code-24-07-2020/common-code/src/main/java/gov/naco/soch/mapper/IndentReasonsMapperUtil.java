/**
 * 
 */
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.IndentReasonsDto;
import gov.naco.soch.entity.IndentReasonsMaster;

/**
 * @date 2020-Jan-01 12:07:16 PM
 */

// Mapper class for IndentReasons to map between IndentReasonsDto (bean class)
// and IndentReasonsEntity (entity class)
public class IndentReasonsMapperUtil {

	// Function to map list of IndentReasonsEntity class to list of IndentReasonsDto
	// class
	public static List<IndentReasonsDto> mapToIndentReasonsDtoList(List<IndentReasonsMaster> IndentReasonsList) {
		List<IndentReasonsDto> indentReasonsDtos = new ArrayList<IndentReasonsDto>();
		if (!CollectionUtils.isEmpty(IndentReasonsList)) {
			IndentReasonsList.forEach(indentReasons -> {
				IndentReasonsDto indentReasonsDto = new IndentReasonsDto();
				indentReasonsDto.setId(indentReasons.getId());
				indentReasonsDto.setIndentReasonsName(indentReasons.getIndentReasonsName().trim());
				indentReasonsDto.setIs_active(indentReasons.getIsActive());
				indentReasonsDto.setIs_delete(indentReasons.getIsDelete());
				indentReasonsDtos.add(indentReasonsDto);
			});
		}
		return indentReasonsDtos;
	}

	// Function to map IndentReasonsDto class to IndentReasonsEntity class
	public static IndentReasonsMaster mapToIndentReasonsEntity(IndentReasonsDto indentReasonsDto,
			IndentReasonsMaster indentReasons) {

		if (indentReasons == null) {
			indentReasons = new IndentReasonsMaster();
		}
		if (indentReasonsDto != null) {
			indentReasons.setIndentReasonsName(indentReasonsDto.getIndentReasonsName().trim());
			indentReasons.setIsActive(indentReasonsDto.getIs_active());
			indentReasons.setIsDelete(indentReasonsDto.getIs_delete());
		}
		return indentReasons;
	}

	// Function to map IndentReasonsEntity class to IndentReasonsDto class
	public static IndentReasonsDto mapToIndentReasonsDto(IndentReasonsMaster indentReasons) {
		IndentReasonsDto indentReasonsDto = new IndentReasonsDto();
		if (indentReasons != null) {
			indentReasonsDto.setId(indentReasons.getId());
			indentReasonsDto.setIndentReasonsName(indentReasons.getIndentReasonsName().trim());
			indentReasonsDto.setIs_active(indentReasons.getIsActive());
			indentReasonsDto.setIs_delete(indentReasons.getIsDelete());
		}
		return indentReasonsDto;
	}
}
