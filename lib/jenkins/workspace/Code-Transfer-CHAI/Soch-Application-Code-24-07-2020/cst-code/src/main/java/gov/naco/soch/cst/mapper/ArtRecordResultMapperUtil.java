package gov.naco.soch.cst.mapper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ArtCd4RecordResultDto;
import gov.naco.soch.entity.ArtBeneficiary;
//import gov.naco.soch.entity.ArtBeneficiaryDetail;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.MasterResultStatus;
import gov.naco.soch.entity.MasterSampleStatus;
import gov.naco.soch.projection.ArtSampleCollectionProjection;

public class ArtRecordResultMapperUtil {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * @param artCd4RecordResultDto
	 * @return artCd4RecordResult
	 */
	public static LabTestSample mapToArtCd4RecordResult(ArtCd4RecordResultDto artCd4RecordResultDto,
			LabTestSample labTestSample) {
		labTestSample.setResultValue(artCd4RecordResultDto.getCurrentTestCount());
		labTestSample.setNextAppointmentDate(artCd4RecordResultDto.getNextAppointmentDate());
		LocalDateTime currentTime = LocalDateTime.now();
		labTestSample.setResultReceivedDate(artCd4RecordResultDto.getTestDate().atTime(LocalTime.now()));
		labTestSample.setSampleReceivedDate(artCd4RecordResultDto.getTestDate().atTime(LocalTime.now()));
		MasterSampleStatus masterSampleStatus = new MasterSampleStatus();
		masterSampleStatus.setId(1l);
		labTestSample.setMasterSampleStatus(masterSampleStatus);
		MasterResultStatus masterResultStatus = new MasterResultStatus();
		masterResultStatus.setId(4l);
		labTestSample.setMasterResultStatus(masterResultStatus);
		labTestSample.setArtcSampleStatus("Result Recorded");
		labTestSample.setTypeOfSpecimen(artCd4RecordResultDto.getSampleType());
		labTestSample.setResultApprovedDate(LocalDateTime.now());
		labTestSample.setResultDispatchDate(LocalDateTime.now());
		return labTestSample;
	}

	/**
	 * @param facilityId
	 * @return facility
	 */
	private static Facility mapToFacilityId(long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	public static List<ArtCd4RecordResultDto> mapArtRecordResultListToArtCd4RecordResultDto(
			List<LabTestSample> labTestSample) {
		List<ArtCd4RecordResultDto> artRecordResultDtos = new ArrayList<>();
		if (!CollectionUtils.isEmpty(labTestSample)) {
			labTestSample.forEach(result -> {
				ArtCd4RecordResultDto artCd4RecordResultDto = new ArtCd4RecordResultDto();

				// artCd4RecordResultDto.setId(result.getId());
				artCd4RecordResultDto.setSampleId(result.getId());
				artCd4RecordResultDto.setAge(result.getBeneficiary().getAge());
				artCd4RecordResultDto.setBeneficiaryId(result.getBeneficiary().getId());
				artCd4RecordResultDto.setFirstName(result.getBeneficiary().getFirstName());
				artCd4RecordResultDto.setLastName(result.getBeneficiary().getLastName());
				artCd4RecordResultDto.setGender(result.getBeneficiary().getGenderId().getName());
				artCd4RecordResultDto.setUidNumber(result.getBeneficiary().getUid());
				artCd4RecordResultDto.setArtNumber(result.getBeneficiary().getArtNumber());
				artCd4RecordResultDto.setPreArtNumber(result.getBeneficiary().getPreArtNumber());
				if (result.getBeneficiary().getArtBeneficiary() != null) {
					for (ArtBeneficiary artBeneficiary : result.getBeneficiary().getArtBeneficiary()) {
						if (artBeneficiary.getMasterArtBeneficiaryStatus() != null) {
							artCd4RecordResultDto
									.setArtStatus(artBeneficiary.getMasterArtBeneficiaryStatus().getName());
						}
					}
				}
				artCd4RecordResultDto.setSampleType(result.getTypeOfSpecimen());
				artCd4RecordResultDto.setFacilityId(result.getLabTestSampleBatch().getLab().getId());
				artCd4RecordResultDto.setFacilityName(result.getLabTestSampleBatch().getLab().getName());
				if (result.getResultValue() != null) {
					artCd4RecordResultDto.setCurrentTestCount(result.getResultValue());
				}
				artCd4RecordResultDto.setTestDate(result.getResultDispatchDate().toLocalDate());
				artCd4RecordResultDto.setSamplecollectedDate(String.valueOf(result.getSampleCollectedDate()));

				artRecordResultDtos.add(artCd4RecordResultDto);
			});
		}
		return artRecordResultDtos;
	}

	public static List<ArtCd4RecordResultDto> mapProjectionListToArtCd4RecordResultDto(
			List<ArtSampleCollectionProjection> testResult) {
		
		List<ArtCd4RecordResultDto> dtoList = new ArrayList<ArtCd4RecordResultDto>();
		if (testResult != null) {
			for (ArtSampleCollectionProjection sample : testResult) {
				ArtCd4RecordResultDto result = new ArtCd4RecordResultDto();
				result.setSampleId(sample.getSampleId());
				result.setBeneficiaryId(sample.getBeneficiaryId());
				result.setAge(sample.getAge());
				result.setGender(sample.getGenderId());
				result.setFirstName(sample.getFirstName());
				result.setLastName(sample.getLastName());
				result.setUidNumber(sample.getUid());
				result.setArtNumber(sample.getArtNumber());
				result.setPreArtNumber(sample.getPreArtNumber());
				result.setArtStatus(sample.getBeneficiaryStatus());
				result.setSampleType(sample.getTypeOfSpecimen());
				result.setFacilityId(sample.getFacilityId());
				result.setFacilityName(sample.getFacilityName());
				result.setCurrentTestCount(sample.getResultValue());
				result.setTestDate(sample.getResultDispatchDate().toLocalDate());
				result.setSamplecollectedDate(String.valueOf(sample.getSampleCollectedDate()));
				dtoList.add(result);
			}
		}
		return dtoList;
	}

}
