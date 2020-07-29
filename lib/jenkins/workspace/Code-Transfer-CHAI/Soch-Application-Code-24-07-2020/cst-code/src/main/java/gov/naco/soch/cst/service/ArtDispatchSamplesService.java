package gov.naco.soch.cst.service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.mapper.ArtDispatchSamplesMapper;
import gov.naco.soch.dto.ArtDispatchSamplesDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.ViralLoadPreviousDispatchDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.entity.LabTestSampleBatch;
import gov.naco.soch.entity.MasterBatchStatus;
import gov.naco.soch.entity.MasterSampleStatus;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.repository.LabTestSampleBatchRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.repository.MasterBatchStatusRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtDispatchSamplesService {

	private static final Logger logger = LoggerFactory.getLogger(ArtDispatchSamplesService.class);

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Autowired
	private LabTestSampleBatchRepository labTestSampleBatchRepository;

	@Autowired
	LabTestSampleRepository labTestSampleRepository;

	@Autowired
	MasterBatchStatusRepository masterBatchStatusRepository;

	/**
	 * method to save cd4 dispatch sample details into table
	 * 
	 * @param artDispatchSamplesDtos
	 */
	public void dispatchCd4Samples(@Valid List<ArtDispatchSamplesDto> artDispatchSamplesDtos) {
		logger.debug("In dispatchSamples() of ArtDispatchSamplesService");

		if (!CollectionUtils.isEmpty(artDispatchSamplesDtos)) {

			List<LabTestSampleBatch> labTestSampleBatchlist = new ArrayList<>();

			for (ArtDispatchSamplesDto artDispatchSamplesDto : artDispatchSamplesDtos) {
				artDispatchSamplesDto.setDispatchDate(String.valueOf(LocalDateTime.now()));
				LabTestSampleBatch labTestSampleBatch = new LabTestSampleBatch();
				labTestSampleBatch = ArtDispatchSamplesMapper.mapToArtDispatchSamples(artDispatchSamplesDto);

				Set<LabTestSample> artSampleCollectionSet = new HashSet<>();
				LabTestSample artSampleCollection = labTestSampleRepository
						.findById(artDispatchSamplesDto.getSampleId()).get();
				artSampleCollection.setArtcSampleStatus("Dispatched");
				artSampleCollection.setSampleDispatchDate(LocalDateTime.now());
				artSampleCollection.setDispatchedToLab(labTestSampleBatch.getLab());
				artSampleCollection.setLabTestSampleBatch(labTestSampleBatch);
				artSampleCollectionSet.add(artSampleCollection);

				labTestSampleBatch.setLabTestSamples(artSampleCollectionSet);
				labTestSampleBatchlist.add(labTestSampleBatch);
			}
			labTestSampleBatchRepository.saveAll(labTestSampleBatchlist);
		}

	}

	/**
	 * method to save viral load dispatch sample details into table
	 * 
	 * @param artDispatchSamplesDtos
	 */
	// public void dispatchViralSamples(@Valid List<ArtDispatchSamplesDto>
	// artDispatchSamplesDtos) {
	//
	// Long id = labTestSampleRepository.findMaxOfId();
	// DecimalFormat df = new DecimalFormat("0000");
	// String BDN = "BDN" + df.format(id);
	// for (ArtDispatchSamplesDto artDispatchSamplesDto : artDispatchSamplesDtos) {
	// artDispatchSamplesDto.setBDN(BDN);
	// artDispatchSamplesDto.setDispatchDate(String.valueOf(LocalDateTime.now()));
	// LabTestSampleBatch labTestSampleBatch = new LabTestSampleBatch();
	// labTestSampleBatch =
	// ArtDispatchSamplesMapper.mapToArtDispatchSamples(artDispatchSamplesDto);
	// labTestSampleBatch = labTestSampleBatchRepository.save(labTestSampleBatch);
	//
	// if (labTestSampleBatch.getId() != null) {
	// LabTestSample artSampleCollection = labTestSampleRepository
	// .findById(artDispatchSamplesDto.getSampleId()).get();
	// artSampleCollection.setArtcSampleStatus("Dispatched");
	// artSampleCollection.setSampleDispatchDate(LocalDateTime.now());
	// artSampleCollection.setLabTestSampleBatch(labTestSampleBatch);
	// labTestSampleRepository.save(artSampleCollection);
	// }
	// }
	// }
	public void dispatchViralSamples(@Valid List<ArtDispatchSamplesDto> artDispatchSamplesDtos) {

		LoginResponseDto loginDetils = UserUtils.getLoggedInUserDetails();

		Long id = labTestSampleBatchRepository.findMaxOfId();
		if (id == null) {
			id = 1l;
		} else {
			id = id + 1;
		}
		DecimalFormat df = new DecimalFormat("0000");
		String BDN = "BDN" + df.format(id);

		MasterBatchStatus masterBatchStatus = masterBatchStatusRepository.findByStatusAndIsDelete("DISPATCHED",
				Boolean.FALSE);

		LocalDateTime dispatchDate = LocalDateTime.parse(artDispatchSamplesDtos.get(0).getSampleDispatchDate(),
				formatter);

		LabTestSampleBatch labTestSampleBatch = new LabTestSampleBatch();
		labTestSampleBatch.setBdnSerialNumber(BDN);
		labTestSampleBatch.setDispatchDate(dispatchDate);
		labTestSampleBatch.setMasterBatchStatus(masterBatchStatus);
		labTestSampleBatch.setNumOfSamples(Long.valueOf(artDispatchSamplesDtos.size()));
		labTestSampleBatch.setIsDelete(false);
		Facility facility = ArtDispatchSamplesMapper.mapToFacilityId(loginDetils.getFacilityId());
		labTestSampleBatch.setFacility(facility);
		Facility dispatchTo = ArtDispatchSamplesMapper.mapToFacilityId(artDispatchSamplesDtos.get(0).getDisapatchTo());
		labTestSampleBatch.setLab(dispatchTo);
		UserMaster artcLabTechUser = ArtDispatchSamplesMapper.mapToUserId(loginDetils.getUserId());
		labTestSampleBatch.setArtcLabTechUser(artcLabTechUser);

		MasterSampleStatus masterSampleStatus = new MasterSampleStatus();
		masterSampleStatus.setId(3l);

		List<Long> ids = artDispatchSamplesDtos.stream().map(s -> s.getSampleId()).collect(Collectors.toList());

		List<LabTestSample> labTestSamplesList = labTestSampleRepository.findAllById(ids);

		Set<LabTestSample> labTestSamplesSet = labTestSamplesList.stream().map(s -> {
			s.setLabTestSampleBatch(labTestSampleBatch);
			s.setArtcSampleStatus("Dispatched");
			s.setSampleDispatchDate(dispatchDate);
			s.setDispatchedToLab(dispatchTo);
			s.setMasterSampleStatus(masterSampleStatus);
			return s;
		}).collect(Collectors.toSet());

		labTestSampleBatch.setLabTestSamples(labTestSamplesSet);
		LabTestSampleBatch labTestSampleBatchSaved = labTestSampleBatchRepository.save(labTestSampleBatch);
	}

	/**
	 * method to list all previous dispatched cd4 samples
	 * 
	 * @return artDispatchSampleDtos
	 */
	public List<ArtDispatchSamplesDto> getAllCD4PreviouDispatchedSamples() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<LabTestSampleBatch> labTestSampleBatch = labTestSampleBatchRepository
				.findAllCD4(currentUser.getFacilityId());
		List<ArtDispatchSamplesDto> artDispatchSampleDtos = ArtDispatchSamplesMapper
				.mapToArtDispatchSamplesDtoList(labTestSampleBatch);
		return artDispatchSampleDtos;
	}

	/**
	 * method to list all previous dispatched viral load samples
	 * 
	 * @return artDispatchSampleDtos
	 */
	public List<ViralLoadPreviousDispatchDto> getAllViralLoadPreviouDispatchedSamples() {
		LoginResponseDto currentUser = UserUtils.getLoggedInUserDetails();
		List<LabTestSampleBatch> labTestSampleBatch = labTestSampleBatchRepository
				.findAllViralLoad(currentUser.getFacilityId());
		List<ViralLoadPreviousDispatchDto> artDispatchSampleDtos = ArtDispatchSamplesMapper
				.mapToViralLoadPreviousDispatchDto(labTestSampleBatch);
		return artDispatchSampleDtos.stream()
				.sorted(Comparator.comparing(ViralLoadPreviousDispatchDto::getId).reversed())
				.collect(Collectors.toList());
	}

}
