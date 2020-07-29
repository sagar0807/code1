package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtBeneficiaryInvestigationDto;
import gov.naco.soch.cst.dto.InvestigationDataDto;
import gov.naco.soch.cst.dto.InvestigationsDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryInvestigation;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterInvestigation;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.projection.ArtBeneficiaryInvestigationProjection;
import gov.naco.soch.repository.ArtBeneficiaryInvestigationRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class ArtBeneficiaryInvestigationService {

	@Autowired
	private ArtBeneficiaryInvestigationRepository artBeneficiaryInvestigationRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	public ArtBeneficiaryInvestigationDto getAllInvestigationListByBeneficiary(Long beneficiaryId) {

		ArtBeneficiaryInvestigationDto dto = new ArtBeneficiaryInvestigationDto();

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		List<BeneficiaryVisitRegister> visitDetails = beneficiaryVisitRegisterRepository.getVisitedId(beneficiaryId,
				loginResponseDto.getFacilityId());
		if (!CollectionUtils.isEmpty(visitDetails)) {
			List<Long> visitIds = visitDetails.stream().map(v -> v.getId()).collect(Collectors.toList());
			List<ArtBeneficiaryInvestigationProjection> investigationDates = artBeneficiaryInvestigationRepository
					.findInvestigationDates(beneficiaryId, loginResponseDto.getFacilityId(), visitIds);
			List<LocalDate> investigationDatesList = investigationDates.stream().map(v -> v.getInvestigationDate())
					.collect(Collectors.toList());
			if (!CollectionUtils.isEmpty(investigationDates)) {
				dto.setInvestigationDates(investigationDatesList);
			}

			List<ArtBeneficiaryInvestigationProjection> investigationList = artBeneficiaryInvestigationRepository
					.findInvestigationByBeneficiaryIdAndVisitRegisterIds(beneficiaryId,
							loginResponseDto.getFacilityId(), visitIds);
			investigationList = investigationList.stream()
					.sorted(Comparator.comparing(ArtBeneficiaryInvestigationProjection::getInvestigationDate))
					.collect(Collectors.toList());

			Map<Long, List<ArtBeneficiaryInvestigationProjection>> investigationDataGroupById = investigationList
					.stream().collect(Collectors.groupingBy(ArtBeneficiaryInvestigationProjection::getInvestigationId));

			List<InvestigationsDto> investigationsDtoList = new ArrayList<InvestigationsDto>();

			investigationDataGroupById.forEach((k, v) -> {

				InvestigationsDto investigationsDto = new InvestigationsDto();
				investigationsDto.setInvestigationId(k);

				List<InvestigationDataDto> investigationData = v.stream().map(i -> {
					InvestigationDataDto data = new InvestigationDataDto();
					data.setInvestigationDate(i.getInvestigationDate());
					data.setInvestigationValue(i.getInvestigationValue());
					return data;
				}).sorted(Comparator.comparing(InvestigationDataDto::getInvestigationDate))
						.collect(Collectors.toList());

				investigationsDto.setInvestigationData(investigationData);
				investigationsDtoList.add(investigationsDto);
			});
			dto.setInvestigations(investigationsDtoList);
		}

		return dto;
	}

	public Long getVisitRegisterIdForTodayExist(Long beneficiaryId) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitId;
		Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOptional = beneficiaryVisitRegisterRepository
				.findByfacilityIdAndBeneficiaryId(loginResponseDto.getFacilityId(), beneficiaryId, LocalDate.now());
		if (beneficiaryVisitRegisterOptional.isPresent()) {
			BeneficiaryVisitRegister visitRegister = beneficiaryVisitRegisterOptional.get();
			visitId = visitRegister.getId();
			return visitId;
		} else {
			return null;
		}
	}

	public ArtBeneficiaryInvestigationDto saveInvestigation(ArtBeneficiaryInvestigationDto dto) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Optional<Facility> facilityOpt = facilityRepository.findById(loginResponseDto.getFacilityId());
		Optional<Beneficiary> beneficiaryOpt = beneficiaryRepository.findById(dto.getBeneficiaryId());
		// Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOpt =
		// beneficiaryVisitRegisterRepository
		// .findById(dto.getVisitRegisterId());
		// if (beneficiaryVisitRegisterOpt.isEmpty()) {
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				dto.getBeneficiaryId());
		// }
		// if (beneficiaryVisitRegisterOpt.isPresent()) {
		if (visitRegisterId != null) {
			if (!CollectionUtils.isEmpty(dto.getInvestigations())) {

				List<ArtBeneficiaryInvestigation> existingInvestigations = artBeneficiaryInvestigationRepository
						.findExistingInvestigationByVisitRegisterId(visitRegisterId);

				if (!CollectionUtils.isEmpty(existingInvestigations)) {
					artBeneficiaryInvestigationRepository.deleteAll(existingInvestigations);
				}

				List<ArtBeneficiaryInvestigation> investigationList = dto.getInvestigations().stream().map(i -> {

					MasterInvestigation investigation = new MasterInvestigation();
					investigation.setId(i.getInvestigationId());

					List<ArtBeneficiaryInvestigation> iList = i.getInvestigationData().stream().map(data -> {

						ArtBeneficiaryInvestigation artBeneficiaryInvestigation = new ArtBeneficiaryInvestigation();
						artBeneficiaryInvestigation.setBeneficiary(beneficiaryOpt.get());
						artBeneficiaryInvestigation.setMasterInvestigation(investigation);
						artBeneficiaryInvestigation.setFacility(facilityOpt.get());
						artBeneficiaryInvestigation.setVisitRegisterId(visitRegisterId);
						artBeneficiaryInvestigation.setInvestigationDate(data.getInvestigationDate());
						artBeneficiaryInvestigation.setInvestigationValue(data.getInvestigationValue());
						return artBeneficiaryInvestigation;
					}).collect(Collectors.toList());

					return iList;
				}).flatMap(iEntry -> iEntry.stream()).collect(Collectors.toList());

				artBeneficiaryInvestigationRepository.saveAll(investigationList);

			} else {
				throw new ServiceException("No investigation to save", null, HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new ServiceException("Invalid Visit Register Id", null, HttpStatus.BAD_REQUEST);
		}

		return dto;
	}

}
