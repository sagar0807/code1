package gov.naco.soch.cst.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ArtBeneficiaryDueListDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryDueListMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.util.UserUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ArtBeneficiaryDueListService {
	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	/**
	 * @return
	 */

	public List<ArtBeneficiaryDueListDto> getAllArtBeneficiaryDueListLhs() {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryDueListDto> artBeneficiaryDueListDto = new ArrayList<ArtBeneficiaryDueListDto>();
		List<ArtBeneficiaryDueList> beneficiaryDueList = new ArrayList<ArtBeneficiaryDueList>();
		beneficiaryDueList = artBeneficiaryDueListRepository.findAllByFacilityId(loginResponseDto.getFacilityId(),
				false, LocalDate.now());
		beneficiaryDueList.forEach(beneficiary -> {
			ArtBeneficiaryDueListDto beneficiaryDueListDto = ArtBeneficiaryDueListMapper
					.mapArtBeneficiaryDueListDto(beneficiary);
			artBeneficiaryDueListDto.add(beneficiaryDueListDto);
		});

		return artBeneficiaryDueListDto;
	}

	public List<ArtBeneficiaryDueListDto> getAllArtBeneficiaryDueListRhs() {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryDueListDto> artBeneficiaryDueListDto = new ArrayList<ArtBeneficiaryDueListDto>();
		List<ArtBeneficiaryDueList> beneficiaryDueList = new ArrayList<ArtBeneficiaryDueList>();
		beneficiaryDueList = artBeneficiaryDueListRepository.findAllByFacilityIdVisited(loginResponseDto.getFacilityId(), true,
				LocalDate.now());
		beneficiaryDueList.forEach(beneficiary -> {
			ArtBeneficiaryDueListDto beneficiaryDueListDto = ArtBeneficiaryDueListMapper
					.mapArtBeneficiaryDueListDto(beneficiary);
			artBeneficiaryDueListDto.add(beneficiaryDueListDto);
		});

		return artBeneficiaryDueListDto;
	}

	public List<ArtBeneficiaryDueListDto> getBeneficiaryTodaysList(LocalDate fromDate, LocalDate toDate) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryDueListDto> artBeneficiaryDueListDto = new ArrayList<ArtBeneficiaryDueListDto>();
		List<ArtBeneficiaryDueList> beneficiaryDueList = new ArrayList<ArtBeneficiaryDueList>();
		beneficiaryDueList = artBeneficiaryDueListRepository.findAllByTodaysList(loginResponseDto.getFacilityId(),
				LocalDate.from(fromDate), LocalDate.from(toDate));
		beneficiaryDueList.forEach(beneficiary -> {
			ArtBeneficiaryDueListDto beneficiaryDueListDto = ArtBeneficiaryDueListMapper
					.mapArtBeneficiaryDueListDto(beneficiary);
			artBeneficiaryDueListDto.add(beneficiaryDueListDto);
		});

		return artBeneficiaryDueListDto;
	}

	public List<ArtBeneficiaryDueListDto> getBeneficiaryVisitedList(LocalDate fromDate, LocalDate toDate) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryDueListDto> artBeneficiaryDueListDto = new ArrayList<ArtBeneficiaryDueListDto>();
		List<ArtBeneficiaryDueList> beneficiaryDueList = new ArrayList<ArtBeneficiaryDueList>();
		beneficiaryDueList = artBeneficiaryDueListRepository.findAllByBeneficiaryDueList(
				loginResponseDto.getFacilityId(), LocalDate.from(fromDate), LocalDate.from(toDate), true);
		beneficiaryDueList.forEach(beneficiary -> {
			ArtBeneficiaryDueListDto beneficiaryDueListDto = ArtBeneficiaryDueListMapper
					.mapArtBeneficiaryDueListDto(beneficiary);
			artBeneficiaryDueListDto.add(beneficiaryDueListDto);
		});

		return artBeneficiaryDueListDto;
	}

	public List<ArtBeneficiaryDueListDto> getBeneficiaryMissedList(LocalDate fromDate, LocalDate toDate) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<ArtBeneficiaryDueListDto> artBeneficiaryDueListDto = new ArrayList<ArtBeneficiaryDueListDto>();
		List<ArtBeneficiaryDueList> beneficiaryDueList = new ArrayList<ArtBeneficiaryDueList>();
		beneficiaryDueList = artBeneficiaryDueListRepository.findAllByBeneficiaryDueList(
				loginResponseDto.getFacilityId(), LocalDate.from(fromDate), LocalDate.from(toDate), false);
		beneficiaryDueList.forEach(beneficiary -> {
			ArtBeneficiaryDueListDto beneficiaryDueListDto = ArtBeneficiaryDueListMapper
					.mapArtBeneficiaryDueListDto(beneficiary);
			artBeneficiaryDueListDto.add(beneficiaryDueListDto);
		});

		return artBeneficiaryDueListDto;
	}
}
