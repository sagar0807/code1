package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.WorkLoadTilesDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.UserRoleMapping;
import gov.naco.soch.enums.RoleEnum;
import gov.naco.soch.projection.ArtBeneficiaryDueListProjection;
import gov.naco.soch.projection.ArtBeneficiaryQueueProjection;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.UserRoleMappingRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class WorkLoadTilesService {
	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;
	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueRepository;
	@Autowired
	private UserRoleMappingRepository userRoleMappingRepository;

	private static final Logger logger = LoggerFactory.getLogger(WorkLoadTilesService.class);

	public List<WorkLoadTilesDto> getWorkLoadTileCountList() {
		logger.debug("getWorkLoadTileCountList() is invoked");
		WorkLoadTilesDto workLoadTilesDtoCare = new WorkLoadTilesDto();
		WorkLoadTilesDto workLoadTilesDtoPh = new WorkLoadTilesDto();
		WorkLoadTilesDto workLoadTilesDtoLab = new WorkLoadTilesDto();
		WorkLoadTilesDto workLoadTilesDtoMed = new WorkLoadTilesDto();
		WorkLoadTilesDto workLoadTilesDtoCoun = new WorkLoadTilesDto();
		WorkLoadTilesDto workLoadTilesDtoStaffN = new WorkLoadTilesDto();
		Long artPha = RoleEnum.ART_PHARMACIST.getRole();
		Long artLab = RoleEnum.ART_LAB_TECHNICIAN.getRole();
		Long artMO = RoleEnum.ART_MEDICAL_OFFICER.getRole();
		Long artSN = RoleEnum.ART_STAFF_NURSE.getRole();
		Long artCN = RoleEnum.ART_COUNSELLOR.getRole();
		Long artCO = RoleEnum.ART_CARE_COORDINATOR.getRole();

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();

		List<WorkLoadTilesDto> workLoadTilesDtoList = new ArrayList<WorkLoadTilesDto>();
		
		List<UserRoleMapping> userDetailsCO = userRoleMappingRepository.findUserIdByRole(artCO);
		List<UserRoleMapping> userDetailsCN = userRoleMappingRepository.findUserIdByRole(artCN);
		List<UserRoleMapping> userDetailsMO = userRoleMappingRepository.findUserIdByRole(artMO);
		List<UserRoleMapping> userDetailsSN = userRoleMappingRepository.findUserIdByRole(artSN);
		List<UserRoleMapping> userDetailsPh = userRoleMappingRepository.findUserIdByRole(artPha);
		List<UserRoleMapping> userDetailsLab = userRoleMappingRepository.findUserIdByRole(artLab);
	
		List<ArtBeneficiaryQueueProjection> queueCountCO = null;
		List<ArtBeneficiaryQueueProjection> queueVisitedCountCO = null;
		List<ArtBeneficiaryDueListProjection> dueCountCO = null;
		List<ArtBeneficiaryDueListProjection> dueVisitedCountCO = null;
		List<ArtBeneficiaryQueueProjection> countCN = null;
		List<ArtBeneficiaryQueueProjection> visitedCountCN = null;
		List<ArtBeneficiaryQueueProjection> countMO = null;
		List<ArtBeneficiaryQueueProjection> visitedCountMO = null;
		List<ArtBeneficiaryQueueProjection> countSN = null;
		List<ArtBeneficiaryQueueProjection> visitedCountSN = null;
		List<ArtBeneficiaryQueueProjection> countPh = null;
		List<ArtBeneficiaryQueueProjection> visitedCountPh = null;
		List<ArtBeneficiaryQueueProjection> countLab = null;
		List<ArtBeneficiaryQueueProjection> visitedCountLab = null;

		if (!CollectionUtils.isEmpty(userDetailsCO)) {
			List<Long> userIds = userDetailsCO.stream().map(v -> v.getUserMaster().getId())
					.collect(Collectors.toList());
			queueCountCO = artBeneficiaryQueueRepository.getQueueCount(userIds, loginResponseDto.getFacilityId(), false,
					LocalDate.now());
			queueVisitedCountCO = artBeneficiaryQueueRepository.getVisitedQueueCount(userIds,
					loginResponseDto.getFacilityId(), true, LocalDate.now());
		}

		dueCountCO = artBeneficiaryDueRepository.getVisitDueCount(loginResponseDto.getFacilityId(), false,
				LocalDate.now());
		dueVisitedCountCO = artBeneficiaryDueRepository.getVisitedDueCount(loginResponseDto.getFacilityId(), true,
				LocalDate.now());
		Integer countCare = 0;
		Integer visitedcountCare = 0;

		if (queueCountCO.size() != 0) {
			countCare = dueCountCO.size() + queueCountCO.size();
		} else {
			countCare = dueCountCO.size();
		}
		if (queueVisitedCountCO.size() != 0) {
			visitedcountCare = dueVisitedCountCO.size() + queueVisitedCountCO.size();
		} else {
			visitedcountCare = dueVisitedCountCO.size();
		}

		if (!CollectionUtils.isEmpty(userDetailsCN)) {
			List<Long> userIds = userDetailsCN.stream().map(v -> v.getUserMaster().getId())
					.collect(Collectors.toList());
			countCN = artBeneficiaryQueueRepository.getQueueCount(userIds, loginResponseDto.getFacilityId(), false,
					LocalDate.now());
			visitedCountCN = artBeneficiaryQueueRepository.getVisitedQueueCount(userIds,
					loginResponseDto.getFacilityId(), true, LocalDate.now());
		}

		if (!CollectionUtils.isEmpty(userDetailsMO)) {
			List<Long> userIds = userDetailsMO.stream().map(v -> v.getUserMaster().getId())
					.collect(Collectors.toList());
			countMO = artBeneficiaryQueueRepository.getQueueCount(userIds, loginResponseDto.getFacilityId(), false,
					LocalDate.now());
			visitedCountMO = artBeneficiaryQueueRepository.getVisitedQueueCount(userIds,
					loginResponseDto.getFacilityId(), true, LocalDate.now());
		}
		if (!CollectionUtils.isEmpty(userDetailsSN)) {
			List<Long> userIds = userDetailsSN.stream().map(v -> v.getUserMaster().getId())
					.collect(Collectors.toList());
			countSN = artBeneficiaryQueueRepository.getQueueCount(userIds, loginResponseDto.getFacilityId(), false,
					LocalDate.now());
			visitedCountSN = artBeneficiaryQueueRepository.getVisitedQueueCount(userIds,
					loginResponseDto.getFacilityId(), true, LocalDate.now());
		}
		if (!CollectionUtils.isEmpty(userDetailsPh)) {
			List<Long> userIds = userDetailsPh.stream().map(v -> v.getUserMaster().getId())
					.collect(Collectors.toList());
			countPh = artBeneficiaryQueueRepository.getQueueCount(userIds, loginResponseDto.getFacilityId(), false,
					LocalDate.now());
			visitedCountPh = artBeneficiaryQueueRepository.getVisitedQueueCount(userIds,
					loginResponseDto.getFacilityId(), true, LocalDate.now());
		}
		if (!CollectionUtils.isEmpty(userDetailsLab)) {
			List<Long> userIds = userDetailsLab.stream().map(v -> v.getUserMaster().getId())
					.collect(Collectors.toList());
			countLab = artBeneficiaryQueueRepository.getQueueCount(userIds, loginResponseDto.getFacilityId(), false,
					LocalDate.now());
			visitedCountLab = artBeneficiaryQueueRepository.getVisitedQueueCount(userIds,
					loginResponseDto.getFacilityId(), true, LocalDate.now());
		}

		workLoadTilesDtoCare.setQueueCount(countCare);
		workLoadTilesDtoCare.setVisitedQueueCount(visitedcountCare);
		workLoadTilesDtoCare.setRoleName("CARE COORDINATOR");

		workLoadTilesDtoCoun.setQueueCount(countCN.size());
		workLoadTilesDtoCoun.setVisitedQueueCount(visitedCountCN.size());
		workLoadTilesDtoCoun.setRoleName("COUNSELLOR");

		workLoadTilesDtoMed.setQueueCount(countMO.size());
		workLoadTilesDtoMed.setVisitedQueueCount(visitedCountMO.size());
		workLoadTilesDtoMed.setRoleName("MEDICAL OFFICER");

		workLoadTilesDtoStaffN.setQueueCount(countSN.size());
		workLoadTilesDtoStaffN.setVisitedQueueCount(visitedCountSN.size());
		workLoadTilesDtoStaffN.setRoleName("STAFF NURSE");

		workLoadTilesDtoPh.setQueueCount(countPh.size());
		workLoadTilesDtoPh.setVisitedQueueCount(visitedCountPh.size());
		workLoadTilesDtoPh.setRoleName("PHARMACIST");

		workLoadTilesDtoLab.setQueueCount(countLab.size());
		workLoadTilesDtoLab.setVisitedQueueCount(visitedCountLab.size());
		workLoadTilesDtoLab.setRoleName("LAB TECHNICIAN");

		List<WorkLoadTilesDto> finalListCO = new ArrayList<WorkLoadTilesDto>();
		finalListCO.add(workLoadTilesDtoCare);
		List<WorkLoadTilesDto> finalListCN = new ArrayList<WorkLoadTilesDto>();
		finalListCN.add(workLoadTilesDtoCoun);
		List<WorkLoadTilesDto> finalListMO = new ArrayList<WorkLoadTilesDto>();
		finalListMO.add(workLoadTilesDtoMed);
		List<WorkLoadTilesDto> finalListSN = new ArrayList<WorkLoadTilesDto>();
		finalListSN.add(workLoadTilesDtoStaffN);
		List<WorkLoadTilesDto> finalListPh = new ArrayList<WorkLoadTilesDto>();
		finalListPh.add(workLoadTilesDtoPh);
		List<WorkLoadTilesDto> finalListLab = new ArrayList<WorkLoadTilesDto>();
		finalListLab.add(workLoadTilesDtoLab);

		workLoadTilesDtoList.addAll(finalListCO);
		workLoadTilesDtoList.addAll(finalListCN);
		workLoadTilesDtoList.addAll(finalListMO);
		workLoadTilesDtoList.addAll(finalListSN);
		workLoadTilesDtoList.addAll(finalListPh);
		workLoadTilesDtoList.addAll(finalListLab);

		return workLoadTilesDtoList;

	}

}
