package gov.naco.soch.cst.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtBeneficiaryCoexistingConditionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryContraceptionDto;
import gov.naco.soch.cst.dto.CounsellingDto;
import gov.naco.soch.cst.dto.CounsellingNoteAnswersDto;
import gov.naco.soch.cst.dto.CounsellingNoteDto;
import gov.naco.soch.cst.mapper.CounsellingNoteMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryCoexistingCondition;
import gov.naco.soch.entity.ArtBeneficiaryContraception;
import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotes;
import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotesAnswers;
import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.CounsellingNote;
import gov.naco.soch.entity.MasterContraception;
import gov.naco.soch.entity.MasterDeliveryOutcome;
import gov.naco.soch.entity.MasterOtherAilment;
import gov.naco.soch.repository.ArtBeneficiaryClinicalDetailRepository;
import gov.naco.soch.repository.ArtBeneficiaryCoexistingConditionRepository;
import gov.naco.soch.repository.ArtBeneficiaryContraceptionRepository;
import gov.naco.soch.repository.ArtBeneficiaryCounsellingNoteRepository;
import gov.naco.soch.repository.ArtBeneficiaryIptAttDetailsRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.CounsellingNoteRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class ArtBeneficiaryCounsellingNoteService {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryCounsellingNoteService.class);

	@Autowired
	private CounsellingNoteRepository counsellingNoteRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private ArtBeneficiaryCounsellingNoteRepository artBeneficiaryCounsellingNoteRepository;

	@Autowired
	private ArtBeneficiaryContraceptionRepository contraceptionRepository;

	@Autowired
	private ArtBeneficiaryCoexistingConditionRepository coexistingConditionRepository;

	@Autowired
	private ArtBeneficiaryClinicalDetailRepository artBeneficiaryClinicalDetailRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private ArtBeneficiaryIptAttDetailsRepository artBeneficiaryIptAttDetailsRepository;

	public CounsellingDto getAllCounsellingNotes(Long beneficiaryId) {

		logger.debug("In getAllCounsellingNotes() of ArtBeneficiaryCounsellingNoteService");
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();

		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				beneficiaryId);

		CounsellingDto dto = new CounsellingDto();
		List<CounsellingNoteDto> counsellingNoteDtos = new ArrayList<CounsellingNoteDto>();
		List<CounsellingNote> counsellingNotes = new ArrayList<CounsellingNote>();
		List<ArtBeneficiaryCounsellingNotes> artcounsellingNoteList = artBeneficiaryCounsellingNoteRepository
				.findByBeneficiaryId(beneficiaryId);
		if (CollectionUtils.isEmpty(artcounsellingNoteList)) {
			counsellingNotes = counsellingNoteRepository.findAll();
			for (CounsellingNote counsellingNote : counsellingNotes) {
				CounsellingNoteDto counsellingNoteDto = CounsellingNoteMapper
						.maptoCounsellingNoteListDto(counsellingNote);
				counsellingNoteDto.setBeneficiaryId(beneficiaryId);
				counsellingNoteDtos.add(counsellingNoteDto);
			}
			dto.setCounsellingNotesList(counsellingNoteDtos);

		} else {
			for (ArtBeneficiaryCounsellingNotes artBeneficiaryCounsellingNote : artcounsellingNoteList) {

				CounsellingNoteDto counsellingNoteDto = CounsellingNoteMapper
						.maptoCounsellingNoteDto(artBeneficiaryCounsellingNote);
				counsellingNoteDto.setBeneficiaryId(beneficiaryId);
				counsellingNoteDtos.add(counsellingNoteDto);

			}
			dto.setCounsellingNotesList(counsellingNoteDtos);
		}

		Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
				.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);

		List<ArtBeneficiaryCoexistingCondition> coexistingConditionList = coexistingConditionRepository
				.findByVisitRegisterId(visitRegisterId);

		List<ArtBeneficiaryContraception> contraceptionList = contraceptionRepository
				.findByVisitRegisterId(visitRegisterId);

		dto = CounsellingNoteMapper.mapClinicalDetailsToCounsellingDto(dto, optClinicalDetails, coexistingConditionList,
				contraceptionList);

		Optional<ArtBeneficiaryIptAttDetails> optIptAttDetails = artBeneficiaryIptAttDetailsRepository
				.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);

		if (optIptAttDetails.isPresent()) {
			dto.setCptInitiatedDate(optIptAttDetails.get().getCptStartDate());
		}

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);

		if (optVisitDetails.isPresent()) {

			BeneficiaryVisitRegister visit = optVisitDetails.get();
			if (visit.getDeliveryOutcome() != null) {
				dto.setDeliveryOutcome(visit.getDeliveryOutcome().getId());
			}
			dto.setLastMenstrualPeriod(visit.getLmp());
			dto.setPregnantNow(visit.getIsPregnant());
		}

		return dto;
	}

	public CounsellingDto saveCounsellingNote(CounsellingDto counsellingDto) {

		List<ArtBeneficiaryCounsellingNotes> artcounsellingNoteList = new ArrayList<ArtBeneficiaryCounsellingNotes>();
		Long beneficiaryId = counsellingDto.getBeneficiaryId();
		if (!CollectionUtils.isEmpty(counsellingDto.getCounsellingNotesList())) {

			artcounsellingNoteList = artBeneficiaryCounsellingNoteRepository.findByBeneficiaryId(beneficiaryId);

			if (!CollectionUtils.isEmpty(artcounsellingNoteList)) {
				artBeneficiaryCounsellingNoteRepository.deleteAll(artcounsellingNoteList);
			}

			Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository.findById(beneficiaryId);

			List<CounsellingNote> counsellingNotes = counsellingNoteRepository.findAll();
			Map<Long, CounsellingNote> counsellingNotesMap = new HashMap<>();
			for (CounsellingNote note : counsellingNotes) {
				counsellingNotesMap.put(note.getId(), note);
			}

			List<ArtBeneficiaryCounsellingNotes> notesToSave = new ArrayList<ArtBeneficiaryCounsellingNotes>();

			for (CounsellingNoteDto dto : counsellingDto.getCounsellingNotesList()) {
				ArtBeneficiaryCounsellingNotes beneficiaryCounsellingNotes = new ArtBeneficiaryCounsellingNotes();
				Beneficiary beneficiary = beneficiaryOptional.get();
				CounsellingNote counsellingNote = counsellingNotesMap.get(dto.getId());
				beneficiaryCounsellingNotes.setBeneficiary(beneficiary);
				beneficiaryCounsellingNotes.setCounsellingNote(counsellingNote);

				Set<ArtBeneficiaryCounsellingNotesAnswers> notesAnswerSet = new HashSet<>();

				for (CounsellingNoteAnswersDto answersDto : dto.getCounsellingNoteAnswer()) {
					ArtBeneficiaryCounsellingNotesAnswers answers = new ArtBeneficiaryCounsellingNotesAnswers();
					answers.setArtCounsellingNoteAnswer(answersDto.getArtCounsellingNoteAnswer());
					answers.setArtBeneficiaryCounsellingNotes(beneficiaryCounsellingNotes);
					notesAnswerSet.add(answers);
				}
				beneficiaryCounsellingNotes.setArtBeneficiaryCounsellingNotesAnswers(notesAnswerSet);
				notesToSave.add(beneficiaryCounsellingNotes);
			}
			artBeneficiaryCounsellingNoteRepository.saveAll(notesToSave);
		}

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();

		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				counsellingDto.getBeneficiaryId());

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);

		BeneficiaryVisitRegister visit = optVisitDetails.get();

		Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
				.findByBeneficiaryIdAndVisitRegisterId(counsellingDto.getBeneficiaryId(), visitRegisterId);

		ArtBeneficiaryClinicalDetail clinicalDetails = CounsellingNoteMapper
				.mapCounsellingDtoToArtBeneficiaryClinicalDetails(optClinicalDetails, counsellingDto,
						loginResponseDto.getUserId(), loginResponseDto.getFacilityId(), visit);

		artBeneficiaryClinicalDetailRepository.save(clinicalDetails);

		List<ArtBeneficiaryCoexistingCondition> oldCoexistingConditionList = coexistingConditionRepository
				.findByVisitRegisterId(visitRegisterId);
		coexistingConditionRepository.deleteAll(oldCoexistingConditionList);

		List<ArtBeneficiaryContraception> oldContraceptionList = contraceptionRepository
				.findByVisitRegisterId(visitRegisterId);
		contraceptionRepository.deleteAll(oldContraceptionList);

		List<ArtBeneficiaryCoexistingCondition> coexistingConditionList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(counsellingDto.getCoexistingConditionsList())) {

			for (ArtBeneficiaryCoexistingConditionDto dto : counsellingDto.getCoexistingConditionsList()) {
				ArtBeneficiaryCoexistingCondition coexistingCondition = new ArtBeneficiaryCoexistingCondition();
				MasterOtherAilment otherAilment = new MasterOtherAilment();
				otherAilment.setId(dto.getOtherAilmentId());
				coexistingCondition.setMasterOtherAilment(otherAilment);
				coexistingCondition.setBeneficiaryVisitRegister(visit);
				coexistingCondition.setIsActive(Boolean.TRUE);
				coexistingCondition.setIsDelete(Boolean.FALSE);
				coexistingConditionList.add(coexistingCondition);
			}
			coexistingConditionRepository.saveAll(coexistingConditionList);
		}

		List<ArtBeneficiaryContraception> contraceptionList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(counsellingDto.getContraceptionsList())) {
			for (ArtBeneficiaryContraceptionDto dto : counsellingDto.getContraceptionsList()) {
				ArtBeneficiaryContraception contraception = new ArtBeneficiaryContraception();
				MasterContraception masterContraception = new MasterContraception();
				masterContraception.setId(dto.getContraceptionId());
				contraception.setMasterContraception(masterContraception);
				contraception.setBeneficiaryVisitRegister(visit);
				contraception.setIsActive(Boolean.TRUE);
				contraception.setIsDelete(Boolean.FALSE);
				contraceptionList.add(contraception);
			}
			contraceptionRepository.saveAll(contraceptionList);
		}

		if (counsellingDto.getCptInitiatedDate() != null) {

			Optional<ArtBeneficiaryIptAttDetails> optIptAttDetails = artBeneficiaryIptAttDetailsRepository
					.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);

			if (optIptAttDetails.isPresent()) {
				ArtBeneficiaryIptAttDetails artBeneficiaryIptAttDetails = optIptAttDetails.get();
				artBeneficiaryIptAttDetails.setCptStartDate(counsellingDto.getCptInitiatedDate());
				artBeneficiaryIptAttDetailsRepository.save(artBeneficiaryIptAttDetails);
			} else {
				ArtBeneficiaryIptAttDetails artBeneficiaryIptAttDetails = CounsellingNoteMapper
						.mapToArtBeneficiaryIptAttDetails(counsellingDto, loginResponseDto.getUserId(),
								loginResponseDto.getFacilityId(), visit);
				artBeneficiaryIptAttDetailsRepository.save(artBeneficiaryIptAttDetails);
			}
		}

		if (counsellingDto.getDeliveryOutcome() != null) {
			MasterDeliveryOutcome masterDeliveryOutcome = new MasterDeliveryOutcome();
			masterDeliveryOutcome.setId(counsellingDto.getDeliveryOutcome());
			visit.setDeliveryOutcome(masterDeliveryOutcome);
		}

		visit.setLmp(counsellingDto.getLastMenstrualPeriod());
		visit.setIsPregnant(counsellingDto.getPregnantNow());

		beneficiaryVisitRegisterRepository.save(visit);

		return counsellingDto;
	}

}
