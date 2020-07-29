package gov.naco.soch.ti.service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.dto.TiDemandEstimateDto;
import gov.naco.soch.entity.TIBenRVAssessment;
import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.repository.TIBenRVAssessmentRepository;
import gov.naco.soch.util.UserUtils;

@Service
public class TiDemandEstimationService {

	private static final Logger logger = LoggerFactory.getLogger(TiDemandEstimationService.class);

	@Autowired
	private TIBenRVAssessmentRepository tiBenRVAssessmentRepository;

	public TiDemandEstimateDto listDemandEstimation() {
		logger.debug("In listDemandEstimationService of TiDemandEstimationService");

		TiDemandEstimateDto dto = new TiDemandEstimateDto();

		Long weeklyNeedlesRequirement = 0L;
		Long weeklyCondomsRequirement = 0L;

		LoginResponseDto user = UserUtils.getLoggedInUserDetails();

		LocalDateTime today = LocalDateTime.now();
		LocalDateTime firstDayOfQuarter = LocalDateTime.of(today.getYear(), 1, 1, 0, 0, 0);

		LocalDateTime lastDayOfQuarter = firstDayOfQuarter.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth())
				.withHour(23).withMinute(59).withSecond(59);

		List<TIBenRVAssessment> beneficiaries = tiBenRVAssessmentRepository
				.findByFacilityIdAndDate(user.getFacilityId(), firstDayOfQuarter, lastDayOfQuarter);

		Map<TIBeneficiary, List<TIBenRVAssessment>> beneficiariesMap = beneficiaries.stream()
				.collect(Collectors.groupingBy(TIBenRVAssessment::getBeneficiary));

		List<TIBenRVAssessment> beneficiaryRVList = new ArrayList<TIBenRVAssessment>();

		beneficiariesMap.forEach((k, v) -> {

			Optional<TIBenRVAssessment> rvBeneficiary = v.stream()
					.sorted(Comparator.comparing(TIBenRVAssessment::getModifiedTime).reversed()).findFirst();

			if (rvBeneficiary.isPresent()) {
				beneficiaryRVList.add(rvBeneficiary.get());
			}
		});

		for (TIBenRVAssessment r : beneficiaryRVList) {

			if (r.getCondomRequirementPerWeek() != null) {
				weeklyCondomsRequirement = weeklyCondomsRequirement + r.getCondomRequirementPerWeek().longValue();
			}

			if (r.getNeedlesSyringesRequirementPerWeek() != null) {
				weeklyNeedlesRequirement = weeklyNeedlesRequirement
						+ r.getNeedlesSyringesRequirementPerWeek().longValue();
			}
		}

		dto.setWeeklyCondomsRequirement(weeklyCondomsRequirement);
		dto.setWeeklyNeedlesRequirement(weeklyNeedlesRequirement);

		return dto;
	}
}
