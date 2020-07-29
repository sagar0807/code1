package gov.naco.soch.cst.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ArtDispatchSamplesDto;
import gov.naco.soch.dto.ArtSampleCollectionDto;
import gov.naco.soch.dto.ViralLoadPreviousDispatchDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.ArtBeneficiary;
//import gov.naco.soch.entity.ArtBeneficiaryDetail;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.entity.MasterBatchStatus;
import gov.naco.soch.entity.UserMaster;

public class ArtDispatchSamplesMapper {

	/**
	 * @param artDispatchSamplesDto
	 * @return
	 */
	public static LabTestSampleBatch mapToArtDispatchSamples(ArtDispatchSamplesDto artDispatchSamplesDto) {
		LabTestSampleBatch labTestSampleBatch = new LabTestSampleBatch();

		labTestSampleBatch.setBdnSerialNumber(artDispatchSamplesDto.getBDN());
		labTestSampleBatch.setDispatchDate(LocalDateTime.parse(artDispatchSamplesDto.getDispatchDate()));
		labTestSampleBatch.setIsDelete(false);
		Facility facility = mapToFacilityId(artDispatchSamplesDto.getFacilityId());
		labTestSampleBatch.setFacility(facility);
		Facility dispatchTo = mapToFacilityId(artDispatchSamplesDto.getDisapatchTo());
		labTestSampleBatch.setLab(dispatchTo);
		UserMaster artcLabTechUser = mapToUserId(artDispatchSamplesDto.getLabTechId());
		labTestSampleBatch.setArtcLabTechUser(artcLabTechUser);
		MasterBatchStatus masterBatchStatus = new MasterBatchStatus();
		masterBatchStatus.setId(1l);
		labTestSampleBatch.setMasterBatchStatus(masterBatchStatus);
		return labTestSampleBatch;
	}

	/**
	 * @param beneficiaryId
	 * @return Facility
	 */
	public static Facility mapToFacilityId(long beneficiaryId) {
		Facility facility = new Facility();
		facility.setId(beneficiaryId);
		return facility;
	}

	public static UserMaster mapToUserId(long UserId) {
		UserMaster userMaster = new UserMaster();
		userMaster.setId(UserId);
		return userMaster;
	}

	/**
	 * @param artDispatchSamples
	 * @return sampleDtos
	 */
	public static List<ArtDispatchSamplesDto> mapToArtDispatchSamplesDtoList(
			List<LabTestSampleBatch> artDispatchSamples) {
		List<ArtDispatchSamplesDto> sampleDtos = new ArrayList<>();
		if (!CollectionUtils.isEmpty(artDispatchSamples)) {
			artDispatchSamples.forEach(sample -> {
				ArtDispatchSamplesDto artDispatchSamplesDto = new ArtDispatchSamplesDto();

				artDispatchSamplesDto.setId(sample.getId());
				sample.getLabTestSamples().forEach(lab -> {
					artDispatchSamplesDto.setSampleCollectedDate(String.valueOf(lab.getSampleCollectedDate()));
					artDispatchSamplesDto.setSampleId(lab.getId());
					artDispatchSamplesDto.setUidNumber(lab.getBeneficiary().getUid());
					artDispatchSamplesDto.setAge(lab.getBeneficiary().getAge());
					artDispatchSamplesDto.setBeneficiaryId(lab.getBeneficiary().getId());
					artDispatchSamplesDto.setGender(lab.getBeneficiary().getGenderId().getName());
					artDispatchSamplesDto.setFirstName(lab.getBeneficiary().getFirstName());
					artDispatchSamplesDto.setMiddleName(lab.getBeneficiary().getMiddleName());
					artDispatchSamplesDto.setLastName(lab.getBeneficiary().getLastName());
					artDispatchSamplesDto.setLabTechId(lab.getLabTecnician().getId());
					artDispatchSamplesDto.setStatus(lab.getArtcSampleStatus());
					artDispatchSamplesDto.setArtNumber(lab.getBeneficiary().getArtNumber());
					artDispatchSamplesDto.setPreArtNumber(lab.getBeneficiary().getPreArtNumber());
				});
				artDispatchSamplesDto.setDispatchDate(String.valueOf(sample.getDispatchDate()));
				artDispatchSamplesDto.setFacilityId(sample.getFacility().getId());
				artDispatchSamplesDto.setFacilityName(sample.getFacility().getName());
				artDispatchSamplesDto.setDisapatchTo(sample.getLab().getId());
				artDispatchSamplesDto.setDispatchedFacilityName(sample.getLab().getName());
				artDispatchSamplesDto.setBDN(sample.getBdnSerialNumber());
				sampleDtos.add(artDispatchSamplesDto);
			});
		}
		return sampleDtos;
	}

	public static List<ViralLoadPreviousDispatchDto> mapToViralLoadPreviousDispatchDto(
			List<LabTestSampleBatch> labTestSampleBatch) {

		List<ViralLoadPreviousDispatchDto> sampleDtos = new ArrayList<>();

		if (!CollectionUtils.isEmpty(labTestSampleBatch)) {
			labTestSampleBatch.forEach(sample -> {

				ViralLoadPreviousDispatchDto artDispatchSamplesDto = new ViralLoadPreviousDispatchDto();
				List<ArtSampleCollectionDto> ArtSampleCollectionDtoList = new ArrayList<>();

				artDispatchSamplesDto.setId(sample.getId());
				sample.getLabTestSamples().forEach(lab -> {
					ArtSampleCollectionDto artSampleCollectionDto = new ArtSampleCollectionDto();
					artSampleCollectionDto.setSampleCollectedDate(String.valueOf(lab.getSampleCollectedDate()));
					artSampleCollectionDto.setSampleId(lab.getId());
					artSampleCollectionDto.setUidNumber(lab.getBeneficiary().getUid());
					artSampleCollectionDto.setAge(lab.getBeneficiary().getAge());
					artSampleCollectionDto.setBeneficiaryId(lab.getBeneficiary().getId());
					artSampleCollectionDto.setGender(lab.getBeneficiary().getGenderId().getName());
					artSampleCollectionDto.setFirstName(lab.getBeneficiary().getFirstName());
					artSampleCollectionDto.setLastName(lab.getBeneficiary().getLastName());
					artSampleCollectionDto.setLabTechId(lab.getLabTecnician().getId());
					artSampleCollectionDto.setLabTechnicianName(lab.getLabTecnician().getFirstname() + " "
							+ (lab.getLabTecnician().getLastname() != null ? lab.getLabTecnician().getLastname() : ""));
					artSampleCollectionDto.setPatientStatus(lab.getArtcSampleStatus());
					artSampleCollectionDto.setBarcode(lab.getBarcodeNumber());
					artSampleCollectionDto.setTestType(lab.getTestType().getTestType());
					artSampleCollectionDto.setTestTypeId(lab.getTestType().getId());
					artSampleCollectionDto.setResultStatus(lab.getMasterResultStatus().getStatus());
					artSampleCollectionDto.setResultStatusId(lab.getMasterResultStatus().getId());
					artSampleCollectionDto.setDateOfBirth(String.valueOf(lab.getBeneficiary().getDateOfBirth()));
					artSampleCollectionDto.setResultValue(lab.getResultValue());
					artSampleCollectionDto.setSampleDispatchDate(String.valueOf(lab.getSampleDispatchDate()));
					artSampleCollectionDto.setResultDispatchDate(String.valueOf(lab.getResultDispatchDate()));
					artSampleCollectionDto.setSampleReceivedDate(String.valueOf(lab.getSampleReceivedDate()));
					artSampleCollectionDto.setResultReceivedDate(String.valueOf(lab.getResultReceivedDate()));
					artSampleCollectionDto.setResultApprovedDate(String.valueOf(lab.getResultApprovedDate()));

					if (!CollectionUtils.isEmpty(lab.getBeneficiary().getArtBeneficiary())) {
						if (lab.getBeneficiary().getArtBeneficiary().iterator().hasNext()) {

							ArtBeneficiary artDetails = lab.getBeneficiary().getArtBeneficiary().iterator().next();
							artSampleCollectionDto.setHivStatus(artDetails.getMasterArtBeneficiaryStatus().getName());
							if (artDetails.getMasterRiskFactor() != null) {
								artSampleCollectionDto.setPopulationType(artDetails.getMasterRiskFactor().getName());
							}
						}
					}

					artSampleCollectionDto.setTypeOfSpecimen(lab.getTypeOfSpecimen());
					artSampleCollectionDto.setArtNumber(lab.getBeneficiary().getArtNumber());
					artSampleCollectionDto.setPreArtNumber(lab.getBeneficiary().getPreArtNumber());
					artSampleCollectionDto.setLabFacilityTypeId(lab.getDispatchedToLab().getFacilityType().getId());
					if (lab.getLabInCharge() != null) {
						artSampleCollectionDto.setLabInchargeId(lab.getLabInCharge().getId());
						artSampleCollectionDto.setLabInchargeName(lab.getLabInCharge().getFirstname() + " "
								+ (lab.getLabInCharge().getLastname() != null ? lab.getLabInCharge().getLastname()
										: ""));
					}
					if (lab.getMasterSampleStatus() != null) {
						artSampleCollectionDto.setSampleStatus(lab.getMasterSampleStatus().getStatus());
					}

					if (lab.getResultType() != null) {
						artSampleCollectionDto.setResultType(lab.getResultType().getResultType());
					}

					if (lab.getMachine() != null) {
						artSampleCollectionDto.setTestMachineName(lab.getMachine().getMachineName());
					}
					if (lab.getBeneficiary().getHivStatusId() != null) {
						artSampleCollectionDto.setHivStatus(lab.getBeneficiary().getHivStatusId().getName());
					}

					artDispatchSamplesDto.setStatus(lab.getArtcSampleStatus());

					ArtSampleCollectionDtoList.add(artSampleCollectionDto);
				});
				artDispatchSamplesDto.setArtSampleCollectionDto(ArtSampleCollectionDtoList);
				artDispatchSamplesDto.setDispatchDate(String.valueOf(sample.getDispatchDate()));
				artDispatchSamplesDto.setFacilityId(sample.getFacility().getId());
				artDispatchSamplesDto.setFacilityName(sample.getFacility().getName());
				artDispatchSamplesDto.setFacilityCode(sample.getFacility().getCode());
				artDispatchSamplesDto.setDispatchToLabId(sample.getLab().getId());
				artDispatchSamplesDto.setDispatchToLabFacilityTypeId(sample.getLab().getFacilityType().getId());
				artDispatchSamplesDto.setDispatchToLabName(sample.getLab().getName());
				artDispatchSamplesDto.setDispatchToLabCode(sample.getLab().getCode());
				artDispatchSamplesDto.setBdnSerialNumber(sample.getBdnSerialNumber());
				artDispatchSamplesDto.setNumOfSamples(sample.getNumOfSamples());
				artDispatchSamplesDto.setReceivedDate(String.valueOf(sample.getReceivedDate()));
				artDispatchSamplesDto.setAcceptedSamples(sample.getAcceptedSamples());
				artDispatchSamplesDto.setRejectedSamples(sample.getRejectedSamples());
				artDispatchSamplesDto.setArtcLabTechUserId(sample.getArtcLabTechUser().getId());

				Address labAddress = sample.getLab().getAddress();
				String labAddressString = (labAddress.getAddressLineOne() != null ? labAddress.getAddressLineOne() : "")
						+ (labAddress.getAddressLineTwo() != null ? ", " + labAddress.getAddressLineTwo() : "");

				artDispatchSamplesDto.setLabAddress(labAddressString);
				artDispatchSamplesDto.setArtcLabTechUserName(sample.getArtcLabTechUser().getFirstname() + " "
						+ (sample.getArtcLabTechUser().getLastname() != null ? sample.getArtcLabTechUser().getLastname()
								: ""));
				artDispatchSamplesDto.setArtcLabTechUserContact(sample.getArtcLabTechUser().getMobileNumber());
				if (sample.getVlLabTechUser() != null) {
					artDispatchSamplesDto.setVlLabTechUserId(sample.getVlLabTechUser().getId());
					artDispatchSamplesDto.setVlLabTechUserName(sample.getVlLabTechUser().getFirstname() + " "
							+ (sample.getVlLabTechUser().getLastname() != null ? sample.getVlLabTechUser().getLastname()
									: ""));
					artDispatchSamplesDto.setVlLabTechUserContact(sample.getVlLabTechUser().getMobileNumber());
				}
				sampleDtos.add(artDispatchSamplesDto);
			});
		}
		return sampleDtos;

	}

}
