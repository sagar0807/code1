package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.TestDto;
import gov.naco.soch.dto.TestTypeDto;
import gov.naco.soch.entity.MasterTestType;
import gov.naco.soch.entity.Test;

public class TestMapper {

	public static List<TestTypeDto> mapToTestTypeDtoList(List<MasterTestType> testTypeList) {
		List<TestTypeDto> testTypeDtos = new ArrayList<TestTypeDto>();
		if (!CollectionUtils.isEmpty(testTypeList)) {
			testTypeList.forEach(element -> {

				TestTypeDto testTypeDto = new TestTypeDto();
				testTypeDto.setValue(element.getId());
				testTypeDto.setViewValue(element.getTestType());
				testTypeDtos.add(testTypeDto);
			});
		}
		return testTypeDtos;
	}

	public static List<TestDto> mapToTestDtoList(List<Test> testList) {
		List<TestDto> testDtos = new ArrayList<TestDto>();
		if (!CollectionUtils.isEmpty(testList)) {
			testList.forEach(element -> {
				TestDto testDto = new TestDto();
				testDto.setId(element.getId());
				testDto.setValue(element.getTypeOfTest());
				testDto.setBarcodeRequired(element.getIsBarcodeRequired());
				testDtos.add(testDto);
			});
		}
		return testDtos;
	}
}
