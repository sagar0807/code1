package gov.naco.soch.cst.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.controller.ArtBeneficiaryDispensationController;
import gov.naco.soch.cst.dto.ArtBeneficiarySearchDto;
import gov.naco.soch.cst.dto.TodaysDispensedDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryDispensationMapperUtil;
import gov.naco.soch.cst.mapper.ArtBeneficiaryDueListMapper;
import gov.naco.soch.cst.mapper.ArtBeneficiaryQueueMapperUtil;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;

@Service
@Transactional
public class ArtBeneficiarySearchService {

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;
	
	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiarySearchService.class);

	public List<ArtBeneficiarySearchDto> getDueListBySearch(@Valid Long facilityId, String name, String artNumber,
			String preArtNumber, String uid, String gender) {
		List<ArtBeneficiarySearchDto> beneficiaryDueListDtos = new ArrayList<>();
			String searchQuery = ArtBeneficiaryDueListMapper.createSerachQuery(facilityId, name, artNumber,
					preArtNumber, uid, gender, false);
			List<ArtBeneficiaryDueList> beneficiaryDueList = artBeneficiaryDueListRepository
					.artBeneficiaryDueListAdvanceSearch(searchQuery);
			beneficiaryDueListDtos = ArtBeneficiaryDueListMapper.mapArtBeneficiarySearchDueListDto(beneficiaryDueList);
		return beneficiaryDueListDtos;
	}

	public List<ArtBeneficiarySearchDto> getDueListBySearchVisited(@Valid Long facilityId, String name,
			String artNumber, String preArtNumber, String uid, String gender) {
		List<ArtBeneficiarySearchDto> beneficiaryDueListDtos = new ArrayList<>();
			String searchQuery = ArtBeneficiaryDueListMapper.createSerachQuery(facilityId, name, artNumber,
					preArtNumber, uid, gender, true);
			List<ArtBeneficiaryDueList> beneficiaryDueList = artBeneficiaryDueListRepository
					.artBeneficiaryDueListAdvanceSearch(searchQuery);
			beneficiaryDueListDtos = ArtBeneficiaryDueListMapper.mapArtBeneficiarySearchDueListDto(beneficiaryDueList);
		return beneficiaryDueListDtos;
	}
	
	public List<ArtBeneficiarySearchDto> getQueueSearch(@Valid Long facilityId, String name,
			String artNumber, String preArtNumber, String uid, String gender) {
		List<ArtBeneficiarySearchDto> beneficiaryQueueDtos = new ArrayList<>();
			String searchQuery = ArtBeneficiaryQueueMapperUtil.createSerachQuery(facilityId, name, artNumber,
					preArtNumber, uid, gender, false);
			List<ArtBeneficiaryQueue> beneficiaryDueList = artBeneficiaryQueueRepository.artBeneficiaryQueueAdvanceSearch(searchQuery);
			beneficiaryQueueDtos = ArtBeneficiaryQueueMapperUtil.mapArtBeneficiarySearchQueueDto(beneficiaryDueList);
		return beneficiaryQueueDtos;
	}
	
	public List<ArtBeneficiarySearchDto> getQueueSearchVisited(@Valid Long facilityId, String name,
			String artNumber, String preArtNumber, String uid, String gender) {
		List<ArtBeneficiarySearchDto> beneficiaryQueueDtos = new ArrayList<>();
			String searchQuery = ArtBeneficiaryQueueMapperUtil.createSerachQuery(facilityId, name, artNumber,
					preArtNumber, uid, gender, true);
			List<ArtBeneficiaryQueue> beneficiaryDueList = artBeneficiaryQueueRepository.artBeneficiaryQueueAdvanceSearch(searchQuery);
			beneficiaryQueueDtos = ArtBeneficiaryQueueMapperUtil.mapArtBeneficiarySearchQueueDto(beneficiaryDueList);
		return beneficiaryQueueDtos;
	}
}
