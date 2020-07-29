package gov.naco.soch.cst.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ArtSampleCollectionDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.TestDetails;
//import gov.naco.soch.entity.ArtBeneficiaryDetail;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.MasterResultStatus;
import gov.naco.soch.entity.MasterTestType;
import gov.naco.soch.entity.Test;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.mapper.BeneficiaryMapperUtil;
import gov.naco.soch.projection.ArtSampleCollectionProjection;
import gov.naco.soch.util.UserUtils;

public class ArtSampleCollectionMapperUtil {

	/**
	 * @param artSampleCollectionDto
	 * @param detail
	 * @return artSampleCollection
	 */
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public static LabTestSample mapToArtSampleCollection(@Valid ArtSampleCollectionDto artSampleCollectionDto,
			TestDetails detail) {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();

		LabTestSample labTestSample = new LabTestSample();
		labTestSample.setBarcodeNumber(detail.getBarcode());
		labTestSample.setId(artSampleCollectionDto.getId());
		
		if(detail.getTest() != null) {
			Test test = mapToTestId(detail.getTest());
			labTestSample.setTest(test);

			if (detail.getTest() != 1L && artSampleCollectionDto.getTestTypeId() != null) {
				MasterTestType masterTestType = new MasterTestType();
				masterTestType.setId(artSampleCollectionDto.getTestTypeId());
				labTestSample.setTestType(masterTestType);
			}
		}


		if (artSampleCollectionDto.getSampleCollectedDate() != null) {
			labTestSample.setSampleCollectedDate(
					LocalDateTime.parse(artSampleCollectionDto.getSampleCollectedDate(), formatter));
		}
		UserMaster userMaster = new UserMaster();
		userMaster.setId(artSampleCollectionDto.getLabTechId());
		labTestSample.setLabTecnician(userMaster);
		MasterResultStatus masterResultStatus = new MasterResultStatus();
		masterResultStatus.setId(1l);
		labTestSample.setMasterResultStatus(masterResultStatus);
		labTestSample.setIsDelete(false);
		Beneficiary beneficiary = BeneficiaryMapperUtil.mapToBeneficiaryId(artSampleCollectionDto.getBeneficiaryId());
		labTestSample.setBeneficiary(beneficiary);
		Facility sampleCollectedFacility = new Facility();
		sampleCollectedFacility.setId(currentUser.getFacilityId());
		labTestSample.setSampleCollectedFacility(sampleCollectedFacility);
		labTestSample.setArtcSampleStatus("Sample Collected");
		return labTestSample;
	}

	/**
	 * mapToTestId : Method to map to test
	 * 
	 * @param testId
	 * @return
	 */
	private static Test mapToTestId(long testId) {
		Test test = new Test();
		test.setId(testId);
		return test;
	}

	/**
	 * @param sampleList
	 * @return ArtSampleCollectionDto
	 */
	public static List<ArtSampleCollectionDto> mapToArtSampleCollectionDtoList(List<LabTestSample> sampleList) {
		Map<Long, ArtSampleCollectionDto> artSampleCollectionDtoMap = new HashMap<>();

		List<ArtSampleCollectionDto> dtoList = new ArrayList<>();

		if (!CollectionUtils.isEmpty(sampleList)) {

//			Map<Long, List<TestDetails>> samplesMap = new HashMap<>();
//			sampleList.forEach(sample -> {
//				TestDetails testDetails = new TestDetails();
//				testDetails.setTest(sample.getTest().getId());
//				testDetails.setTestName(sample.getTest().getTypeOfTest());
//				testDetails.setBarcode(sample.getBarcodeNumber());
//
//				if (samplesMap.containsKey(sample.getBeneficiary().getId())) {
//					samplesMap.get(sample.getBeneficiary().getId()).add(testDetails);
//				} else {
//					List<TestDetails> testDetailsList = new ArrayList<>();
//					testDetailsList.add(testDetails);
//					samplesMap.put(sample.getBeneficiary().getId(), testDetailsList);
//				}
//			});

			sampleList.forEach(sample -> {
//				if (!artSampleCollectionDtoMap.containsKey(sample.getBeneficiary().getId())) {
				ArtSampleCollectionDto artSampleCollectionDto = new ArtSampleCollectionDto();
				artSampleCollectionDto.setSampleId(sample.getId());
				artSampleCollectionDto.setSampleCollectedDate(sample.getSampleCollectedDate().format(formatter));
				if (sample.getTestType() != null) {
					artSampleCollectionDto.setTestType(sample.getTestType().getTestType());
					artSampleCollectionDto.setTestTypeId(sample.getTestType().getId());
				}
				if (sample.getTest() != null) {
					artSampleCollectionDto.setTestId(sample.getTest().getId());
					artSampleCollectionDto.setTest(sample.getTest().getTypeOfTest());
				}

				artSampleCollectionDto.setAge(sample.getBeneficiary().getAge());
				artSampleCollectionDto.setBeneficiaryId(sample.getBeneficiary().getId());
				artSampleCollectionDto.setUidNumber(sample.getBeneficiary().getUid());
				artSampleCollectionDto.setFirstName(sample.getBeneficiary().getFirstName());
				artSampleCollectionDto.setLastName(sample.getBeneficiary().getLastName());
				artSampleCollectionDto.setMiddleName(sample.getBeneficiary().getMiddleName());
				artSampleCollectionDto.setLabTechId(sample.getLabTecnician().getId());
				artSampleCollectionDto.setGender(sample.getBeneficiary().getGenderId().getName());
				artSampleCollectionDto.setSampleStatus(sample.getArtcSampleStatus());
				artSampleCollectionDto.setArtNumber(sample.getBeneficiary().getArtNumber());
				artSampleCollectionDto.setPreArtNumber(sample.getBeneficiary().getPreArtNumber());

				dtoList.add(artSampleCollectionDto);

//					if (samplesMap.containsKey(sample.getBeneficiary().getId())) {
//						artSampleCollectionDto.setTestDetails(samplesMap.get(sample.getBeneficiary().getId()));
//					}
//
//					artSampleCollectionDtoMap.put(sample.getBeneficiary().getId(), artSampleCollectionDto);
//				}
			});

		}
		return dtoList;

//		return artSampleCollectionDtoMap.values().stream().collect(Collectors.toList());
	}

	/**
	 * @param beneficiaryObj
	 * @return artSampleCollectionDtos
	 */
	public static List<ArtSampleCollectionDto> mapObjToArtSampleCollectionDto(List<Object[]> beneficiaryObj) {
		List<ArtSampleCollectionDto> artSampleCollectionDtos = beneficiaryObj.stream().map(objects -> {
			ArtSampleCollectionDto artSampleCollectionDto = new ArtSampleCollectionDto();
			artSampleCollectionDto.setBeneficiaryId(((Integer) objects[0]).intValue());
			artSampleCollectionDto.setFirstName(objects[1].toString());
			artSampleCollectionDto.setGender(objects[2].toString());
			artSampleCollectionDto.setAge(objects[3].toString());
			if (objects[4] != null) {
				artSampleCollectionDto.setArtNumber(objects[4].toString());
			}
			if (objects[5] != null) {
				artSampleCollectionDto.setPreArtNumber(objects[5].toString());
			}
			if (objects[6] != null) {
				artSampleCollectionDto.setPatientArtStatus(objects[6].toString());
			}
			return artSampleCollectionDto;
		}).collect(Collectors.toList());

		return artSampleCollectionDtos;
	}

	public static List<ArtSampleCollectionDto> mapProjectionToArtSampleCollectionDtoList(
			List<ArtSampleCollectionProjection> sampleList) {
		
		List<ArtSampleCollectionDto> sampleDtoList = new ArrayList<>();
		if(sampleList != null) {
			
			for(ArtSampleCollectionProjection test:sampleList) {
				ArtSampleCollectionDto sample = new ArtSampleCollectionDto();
				sample.setSampleId(test.getSampleId());
				if(test.getSampleCollectedDate() !=null) {
					sample.setSampleCollectedDate(test.getSampleCollectedDate().format(formatter));
				}
				sample.setTestTypeId(test.getTestTypeId());
				sample.setTestId(test.getTestId());
				sample.setAge(test.getAge());
				sample.setBeneficiaryId(test.getBeneficiaryId());
				sample.setUidNumber(test.getUid());
				sample.setFirstName(test.getFirstName());
				sample.setLastName(test.getLastName());
				sample.setMiddleName(test.getMiddleName());
				sample.setLabTechId(test.getLabTechnicianId());
				sample.setSampleStatus(test.getArtcSampleStatus());
				sample.setArtNumber(test.getArtNumber());
				sample.setPreArtNumber(test.getPreArtNumber());
				sample.setGender(test.getGenderId());
				sample.setTest(test.getTest());
				sample.setTestType(test.getTestType());
				sampleDtoList.add(sample);
			}
		}
		return sampleDtoList;
	}

}
