package gov.naco.soch.shared.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gov.naco.soch.constructordto.ArtDetailsDTO;
import gov.naco.soch.constructordto.IctcDetailsDTO;
import gov.naco.soch.constructordto.TiOstDispensationItemDTO;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.IctcTestResultRepository;
import gov.naco.soch.repository.TiOstDispensationItemRepository;
import gov.naco.soch.shared.dto.GlobalBeneficiaryViewCardDTO;
import gov.naco.soch.shared.mapper.GlobalBenVCMapper;
import gov.naco.soch.specifications.GlobalViewCardSpecification;

@Service
@Transactional
public class BeneficiaryViewCardService {

	private final BeneficiaryRepository beneficiaryRepository;

	private final GlobalBenVCMapper benVCMapper;

	private final TiOstDispensationItemRepository dispensationItemRepository;

	private final ArtBeneficiaryFollowupRepository artFollowupRepository;

	private final ArtBeneficiaryRepository artBeneficiaryRepository;

	private final IctcTestResultRepository ictcTestResultRepository;

	private final BeneficiaryReferralRepository beneficiaryReferralRepository;

	public BeneficiaryViewCardService(BeneficiaryRepository beneficiaryRepository, GlobalBenVCMapper benVCMapper,
			TiOstDispensationItemRepository dispensationItemRepository,
			ArtBeneficiaryFollowupRepository artFollowupRepository,
			BeneficiaryReferralRepository beneficiaryReferralRepository,
			IctcTestResultRepository ictcTestResultRepository, ArtBeneficiaryRepository artBeneficiaryRepository) {

		this.beneficiaryRepository = beneficiaryRepository;
		this.benVCMapper = benVCMapper;
		this.dispensationItemRepository = dispensationItemRepository;
		this.artFollowupRepository = artFollowupRepository;
		this.ictcTestResultRepository = ictcTestResultRepository;
		this.artBeneficiaryRepository = artBeneficiaryRepository;
		this.beneficiaryReferralRepository = beneficiaryReferralRepository;
	}

	public GlobalBeneficiaryViewCardDTO findOne(Long beneficiaryId) {
		Optional<Beneficiary> benef = beneficiaryRepository.findById(beneficiaryId);
		if (benef.isPresent()) {
			Beneficiary beneficiary = benef.get();
			GlobalBeneficiaryViewCardDTO response = benVCMapper.toDto(beneficiary);
			setDispensationStatus(response);
			setArtAndIctcDetails(response);
			return response;
		}
		return null;

	}

	private void setArtAndIctcDetails(GlobalBeneficiaryViewCardDTO response) {
		ArtDetailsDTO artDetails = artBeneficiaryRepository.getArtStatusAndArtCentre(response.getId(), false);
		Long adherence = artFollowupRepository.getAdherence(response.getId(), false);
		artDetails = artDetails != null ? artDetails : new ArtDetailsDTO();
		artDetails.setAdherence(adherence);
		response.setArtDetails(artDetails);
		Optional<BeneficiaryReferral> referral = beneficiaryReferralRepository
				.findOne(GlobalViewCardSpecification.getLatestIctcReferralDetails(response.getId()));
		if (referral.isPresent()) {
			if (response.getIctcDetails() != null) {

				IctcDetailsDTO ictcDetails = response.getIctcDetails();
				ictcDetails.setReferDate(referral.get().getReferDate());
				ictcDetails.setReferredCentre(referral.get().getFacility2().getName());
				response.setIctcDetails(ictcDetails);
			} else {
				IctcDetailsDTO ictcDetails = new IctcDetailsDTO();
				ictcDetails.setReferDate(referral.get().getReferDate());
				ictcDetails.setReferredCentre(referral.get().getFacility2().getName());
				response.setIctcDetails(ictcDetails);
			}
		}

		LocalDate hivTestDate = ictcTestResultRepository.getHivTestedDate(response.getId());
		if (response.getIctcDetails() != null) {
			response.getIctcDetails().setHivTestDate(hivTestDate);
		} else {
			IctcDetailsDTO ictcDetails = new IctcDetailsDTO();
			ictcDetails.setHivTestDate(hivTestDate);
			response.setIctcDetails(ictcDetails);
		}
	}

	private void setDispensationStatus(GlobalBeneficiaryViewCardDTO response) {
		if (response.getOstBeneficiary() != null) {
			TiOstDispensationItemDTO latestDispensationOfBeneficiary = dispensationItemRepository
					.getLatestDispensationDateOfBeneficiary(response.getOstBeneficiary().getId());
			String status = dispensationItemRepository
					.findDispensationStatusByBeneficiary(response.getOstBeneficiary().getId());
			if (latestDispensationOfBeneficiary == null) {
				TiOstDispensationItemDTO disp = new TiOstDispensationItemDTO();
				disp.setStatus(status);
				response.getOstBeneficiary().setDispensation(disp);
			} else {
				latestDispensationOfBeneficiary.setStatus(status);
				response.getOstBeneficiary().setDispensation(latestDispensationOfBeneficiary);
			}

		}
	}

}
