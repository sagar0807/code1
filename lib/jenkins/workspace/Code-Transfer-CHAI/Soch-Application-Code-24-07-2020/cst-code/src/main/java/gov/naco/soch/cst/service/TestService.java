package gov.naco.soch.cst.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.TestDto;
import gov.naco.soch.dto.TestTypeDto;
import gov.naco.soch.entity.MasterTestType;
import gov.naco.soch.entity.Test;
import gov.naco.soch.mapper.TestMapper;
import gov.naco.soch.repository.MasterTestTypeRepository;
import gov.naco.soch.repository.TestRepository;

@Transactional
@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private MasterTestTypeRepository masterTestTypeRepository;

	public List<TestTypeDto> getTestTypeList(String labType) {
		List<MasterTestType> testTypeList = masterTestTypeRepository.findAllByLabTypeAndIsDelete(labType.toUpperCase(),
				Boolean.FALSE);
		List<TestTypeDto> testTypeDtoList = TestMapper.mapToTestTypeDtoList(testTypeList);
		return testTypeDtoList;
	}

	public List<TestDto> getTestList(String collectionCenter) {
		List<Test> testList = testRepository.findAllByIsDeleteAndIsActiveAndCollectionCenter(Boolean.FALSE,
				Boolean.TRUE, collectionCenter.toUpperCase());
		List<TestDto> testDtoList = TestMapper.mapToTestDtoList(testList);
		return testDtoList;
	}

}
