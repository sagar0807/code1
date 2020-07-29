package gov.naco.soch.cst.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import gov.naco.soch.cst.dto.BeneficiaryLabTestDetailsDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.LabTestSample;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class BeneficiaryLabTestDetailsService {

	@Autowired
	private LabTestSampleRepository labTestSampleRepository;

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryLabTestDetailsService.class);

	public @ResponseBody BeneficiaryLabTestDetailsDto getBeneficiaryLabTestDetils(Long beneficiaryId) {

		logger.debug("In getBeneficiaryLabTestDetils() of BeneficiaryLabTestDetailsService");

		BeneficiaryLabTestDetailsDto testDetails = new BeneficiaryLabTestDetailsDto();

		LoginResponseDto curentUser = UserUtils.getLoggedInUserDetails();
		List<LabTestSample> cd4TestDetails = labTestSampleRepository
				.findAllCD4TestResultsOfBeneficiary(curentUser.getFacilityId(), beneficiaryId);

		if (!CollectionUtils.isEmpty(cd4TestDetails)) {
			Optional<LabTestSample> optInitalCD4Test = cd4TestDetails.stream()
					.sorted(Comparator.comparing(LabTestSample::getId)).findFirst();
			if (optInitalCD4Test.isPresent()) {
				testDetails.setBaselineCD4Count(optInitalCD4Test.get().getResultValue());
				if (optInitalCD4Test.get().getResultApprovedDate() != null) {
					testDetails.setBaselineCD4Date(optInitalCD4Test.get().getResultApprovedDate().toLocalDate());
				}
			}
			Optional<LabTestSample> optLastCD4Test = cd4TestDetails.stream()
					.sorted(Comparator.comparing(LabTestSample::getId).reversed()).findFirst();
			if (optLastCD4Test.isPresent()) {
				testDetails.setLastCD4Count(optLastCD4Test.get().getResultValue());
				if (optLastCD4Test.get().getResultApprovedDate() != null) {
					testDetails.setLatestCD4Date(optLastCD4Test.get().getResultApprovedDate().toLocalDate());
				}
				testDetails.setNextCD4Duedate(optLastCD4Test.get().getNextAppointmentDate());
			}
		}

		List<LabTestSample> vlTestDetails = labTestSampleRepository
				.findAllVLTestResultsOfBeneficiary(curentUser.getFacilityId(), beneficiaryId);

		if (!CollectionUtils.isEmpty(vlTestDetails)) {
			Optional<LabTestSample> optInitalVLTest = vlTestDetails.stream()
					.sorted(Comparator.comparing(LabTestSample::getId)).findFirst();
			if (optInitalVLTest.isPresent()) {
				if (optInitalVLTest.get().getResultApprovedDate() != null) {
					testDetails.setViralLoadBaselineDate(optInitalVLTest.get().getResultApprovedDate().toLocalDate());
				}
				if (optInitalVLTest.get().getResultType() != null) {
					testDetails.setViralLoadBaselineCount(optInitalVLTest.get().getResultType().getResultType());
					if (optInitalVLTest.get().getResultType().getId() == 4L) {
						testDetails.setViralLoadBaselineCountValue(optInitalVLTest.get().getResultValue());
					}
				}

			}
			Optional<LabTestSample> optLastVLTest = cd4TestDetails.stream()
					.sorted(Comparator.comparing(LabTestSample::getId).reversed()).findFirst();
			if (optLastVLTest.isPresent()) {
				if (optLastVLTest.get().getResultApprovedDate() != null) {
					testDetails.setLatestViralLoadDate(optLastVLTest.get().getResultApprovedDate().toLocalDate());
				}
				if (optLastVLTest.get().getResultType() != null) {
					testDetails.setLastViralCount(optLastVLTest.get().getResultType().getResultType());
					if (optLastVLTest.get().getResultType().getId() == 4L) {
						testDetails.setLastViralCountValue(optLastVLTest.get().getResultValue());
					}
				}
				testDetails.setViralLoadNextDate(optLastVLTest.get().getNextAppointmentDate());
			}
		}

		return testDetails;
	}
}
