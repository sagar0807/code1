package gov.naco.soch.cst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ArtBeneficiaryOpportunisticInfectionDto;
import gov.naco.soch.cst.dto.TbOiDetailsDto;
import gov.naco.soch.cst.mapper.TbOiDetailsMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.projection.ArtTbOiDetailProjection;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryOpportunisticInfectionRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class TbOiDetailsService {

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	@Autowired
	private ArtBeneficiaryOpportunisticInfectionRepository artBeneficiaryOpportunisticInfectionRepository;
	@Autowired
	private ArtBeneficiaryFollowupRepository artBeneficiaryFollowupRepository;

	private static final Logger logger = LoggerFactory.getLogger(TbOiDetailsService.class);

	public TbOiDetailsDto saveBeneficiaryTbOiDetails(TbOiDetailsDto tbOiDetailsDto) {

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository.findById(tbOiDetailsDto.getBeneficiaryId());
		if (beneficiaryOptional.isPresent()) {
			Beneficiary beneficiary = beneficiaryOptional.get();
			BeneficiaryVisitRegister visitRegister = null;
			Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOptional = beneficiaryVisitRegisterRepository
					.findByfacilityIdAndBeneficiaryId(loginResponseDto.getFacilityId(),
							tbOiDetailsDto.getBeneficiaryId(), tbOiDetailsDto.getVisitDate());
			if (beneficiaryVisitRegisterOptional.isPresent()) {
				visitRegister = beneficiaryVisitRegisterOptional.get();
			} else {
				visitRegister = new BeneficiaryVisitRegister();
				visitRegister.setBeneficiary(beneficiary);
				Facility facility = new Facility();
				facility.setId(loginResponseDto.getFacilityId());
				visitRegister.setFacility(facility);
				visitRegister.setIsActive(true);
				visitRegister.setIsDelete(false);
				visitRegister.setVisitDate(tbOiDetailsDto.getVisitDate());
				visitRegister = beneficiaryVisitRegisterRepository.save(visitRegister);

			}

			List<ArtBeneficiaryOpportunisticInfection> existingInfectionList = artBeneficiaryOpportunisticInfectionRepository
					.findByBeneficiaryIdAndVisitRegisterId(tbOiDetailsDto.getBeneficiaryId(), visitRegister.getId());
			if (existingInfectionList != null && !existingInfectionList.isEmpty()) {
				artBeneficiaryOpportunisticInfectionRepository.deleteAll(existingInfectionList);
				Optional<ArtBeneficiaryFollowup> followup = artBeneficiaryFollowupRepository
						.findByVisitRegisterId(visitRegister.getId());
				if (followup.isPresent()) {
					artBeneficiaryFollowupRepository.deleteById(followup.get().getId());
				}
			}

			List<ArtBeneficiaryOpportunisticInfection> infectionList = TbOiDetailsMapper
					.mapTbOiDetailsDtoToOpportunisticInfection(visitRegister, tbOiDetailsDto);
			if (infectionList != null && !infectionList.isEmpty()) {
				artBeneficiaryOpportunisticInfectionRepository.saveAll(infectionList);
			}

			ArtBeneficiaryFollowup followup = TbOiDetailsMapper.mapTbOiDetailsToFollowUp(loginResponseDto, beneficiary,
					visitRegister, tbOiDetailsDto);
			artBeneficiaryFollowupRepository.save(followup);

		}
		return tbOiDetailsDto;
	}

	public List<TbOiDetailsDto> getBeneficiaryTbOiDetails(Long beneficiaryId) {
		List<TbOiDetailsDto> tbOiDetailsDtoList = new ArrayList<TbOiDetailsDto>();
		TbOiDetailsDto tbOiDetailsDto = null;
		Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository.findById(beneficiaryId);
		if (beneficiaryOptional.isPresent()) {

			List<ArtTbOiDetailProjection> optIptAttDetails = artBeneficiaryOpportunisticInfectionRepository
					.findTbOiByBeneficiaryId(beneficiaryId);
			List<ArtBeneficiaryOpportunisticInfectionDto> infectionDto = null;

			if (optIptAttDetails != null && !optIptAttDetails.isEmpty()) {

				for (ArtTbOiDetailProjection tbOi : optIptAttDetails) {

					List<ArtBeneficiaryOpportunisticInfection> infection = artBeneficiaryOpportunisticInfectionRepository
							.findByVisitRegisterId(tbOi.getVisitorRegisterId());
					if (infection != null && !infection.isEmpty()) {
						infectionDto = TbOiDetailsMapper.mapArtBeneficiaryOpportunisticInfectionToDto(infection);
					}

					tbOiDetailsDto = TbOiDetailsMapper.mapTbOiDetailsToProjection(tbOi, beneficiaryId, infectionDto);

					tbOiDetailsDtoList.add(tbOiDetailsDto);
				}
			}
		}
		return tbOiDetailsDtoList;
	}

}
