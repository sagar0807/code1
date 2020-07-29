package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ArtBeneficiaryIptAttDetailsDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryIptAttDetailsMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.repository.ArtBeneficiaryIptAttDetailsRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class ArtBeneficiaryIptAttDetailService {

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	@Autowired
	private ArtBeneficiaryIptAttDetailsRepository artBeneficiaryIptAttDetailsRepository;

	public ArtBeneficiaryIptAttDetailsDto saveBeneficiaryIPTATTDetails(
			ArtBeneficiaryIptAttDetailsDto artBeneficiaryIptAttDetailsDto) {

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		ArtBeneficiaryIptAttDetails artBeneficiaryIptAttDetails = null;
		Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository
				.findById(artBeneficiaryIptAttDetailsDto.getBeneficiaryId());
		if (beneficiaryOptional.isPresent()) {
			Beneficiary beneficiary = beneficiaryOptional.get();
			BeneficiaryVisitRegister visitRegister = null;
			Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOptional = beneficiaryVisitRegisterRepository
					.findByfacilityIdAndBeneficiaryId(loginResponseDto.getFacilityId(),
							artBeneficiaryIptAttDetailsDto.getBeneficiaryId(), LocalDate.now());
			if (beneficiaryVisitRegisterOptional.isPresent()) {
				visitRegister = beneficiaryVisitRegisterOptional.get();
			} else {
				visitRegister = beneficiaryVisitRegisterRepository.save(
						ArtBeneficiaryIptAttDetailsMapper.mapArtBeneficiaryIptAttDetailsDtoToBeneficiaryVisitRegister(
								artBeneficiaryIptAttDetailsDto, beneficiary, loginResponseDto.getFacilityId()));

			}
			Optional<ArtBeneficiaryIptAttDetails> optIptAttDetails = artBeneficiaryIptAttDetailsRepository
					.findByBeneficiaryIdAndVisitRegisterId(artBeneficiaryIptAttDetailsDto.getBeneficiaryId(),
							visitRegister.getId());
			artBeneficiaryIptAttDetails = ArtBeneficiaryIptAttDetailsMapper
					.mapArtBeneficiaryIPTATTDetailsDtoToArtBeneficiaryIPTATTDetails(artBeneficiaryIptAttDetailsDto,
							visitRegister, loginResponseDto.getFacilityId(), loginResponseDto.getUserId(), beneficiary,
							optIptAttDetails);
			if (artBeneficiaryIptAttDetails != null) {
				artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetailsRepository.save(artBeneficiaryIptAttDetails);
				artBeneficiaryIptAttDetailsDto = ArtBeneficiaryIptAttDetailsMapper
						.mapArtBeneficiaryIptAttDetailsToArtBeneficiaryIptAttDetailsDto(artBeneficiaryIptAttDetails);
			}
		}
		return artBeneficiaryIptAttDetailsDto;
	}

	public ArtBeneficiaryIptAttDetailsDto getBeneficiaryIptAttDetailsForToday(Long beneficiaryId) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		ArtBeneficiaryIptAttDetailsDto artBeneficiaryIptAttDetailsDto = new ArtBeneficiaryIptAttDetailsDto();
		Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository.findById(beneficiaryId);
		if (beneficiaryOptional.isPresent()) {
			Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
					beneficiaryId);

			Optional<ArtBeneficiaryIptAttDetails> optIptAttDetails = artBeneficiaryIptAttDetailsRepository
					.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);

			if (optIptAttDetails.isPresent()) {
				artBeneficiaryIptAttDetailsDto = ArtBeneficiaryIptAttDetailsMapper
						.mapArtBeneficiaryIptAttDetailsToArtBeneficiaryIptAttDetailsDto(optIptAttDetails.get());
			}
		}
		return artBeneficiaryIptAttDetailsDto;
	}

}
