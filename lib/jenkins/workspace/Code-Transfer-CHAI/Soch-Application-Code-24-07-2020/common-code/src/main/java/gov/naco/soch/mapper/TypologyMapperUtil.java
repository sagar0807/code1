package gov.naco.soch.mapper;

import java.util.List;
import java.util.stream.Collectors;

import gov.naco.soch.dto.TypologyDto;
import gov.naco.soch.entity.TypologyMaster;

public class TypologyMapperUtil {

	public static TypologyDto mapTypologyDto(TypologyMaster typology) {
		TypologyDto typologyDto = new TypologyDto();
		if (typology != null) {
			typologyDto.setId(typology.getTypologyId());
			typologyDto.setTypologyName(typology.getTypologyName());
		}
		return typologyDto;
	}

	public static List<TypologyDto> mapTypologyObjectListToTypologyDtoList(List<Object[]> typologyList) {
		List<TypologyDto> typologyDtoList = typologyList.stream().map(object -> {
			TypologyDto typologyDto = new TypologyDto();
			typologyDto.setId(object[0] != null ? Long.valueOf(object[0].toString()) : null);
			typologyDto.setTypologyName(object[1] != null ? object[1].toString() : null);
			typologyDto.setTypologyTarget(object[2] != null ? Long.valueOf(object[2].toString()) : null);
			return typologyDto;
		}).collect(Collectors.toList());
		return typologyDtoList;
	}

}
