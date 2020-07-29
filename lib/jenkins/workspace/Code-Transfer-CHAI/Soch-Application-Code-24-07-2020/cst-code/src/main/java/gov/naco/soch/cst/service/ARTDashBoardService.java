package gov.naco.soch.cst.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ARTDashBoardResponseDTO;
import gov.naco.soch.cst.dto.ARTDashboardGraphsDto;
import gov.naco.soch.cst.dto.ARTDashboardRequestDTO;
import gov.naco.soch.cst.dto.ARTSeries;
import gov.naco.soch.cst.dto.ARTWidgets;
import gov.naco.soch.dto.Category;
import gov.naco.soch.projection.StatisticsProjection;
import gov.naco.soch.repository.ARTDashboardRepository;

@Service
@Transactional
public class ARTDashBoardService {

	@Autowired
	ARTDashboardRepository artDashboardRepository;
	private static final Logger logger = LoggerFactory.getLogger(ARTDashBoardService.class);

	public ARTDashBoardResponseDTO getData(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashBoardResponseDTO artDashboardResponseDto = new ARTDashBoardResponseDTO();
		List<ARTDashboardGraphsDto> categoriesList = new ArrayList<ARTDashboardGraphsDto>();
		categoriesList.add(beneficiaryDueForVisitGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryVisitGraph(dashboardRequestDto));
		categoriesList.add(foursPlusDetectedByCCGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryMissedAppointmentsGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryNewRegistrationsGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryNewInitiationsGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryTransferOutVsTransferInGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryPendingTransferInGraph(dashboardRequestDto));
		categoriesList.add(numberOfDispensationGraph(dashboardRequestDto));
		categoriesList.add(numberOfDispensationdrugCountAsPerDrugCountGraph(dashboardRequestDto));
		categoriesList.add(numberOfTestsVlConductedGraph(dashboardRequestDto));
		categoriesList.add(referredFromICTC(dashboardRequestDto));
		categoriesList.add(investigationsInFacility(dashboardRequestDto));
		categoriesList.add(detectedByStaffNurse(dashboardRequestDto));
		categoriesList.add(cd4TestConducted(dashboardRequestDto));
		categoriesList.add(vlTestConducted(dashboardRequestDto));
		categoriesList.add(cd4TestLessThan350(dashboardRequestDto));
		categoriesList.add(cd4SamplesCollected(dashboardRequestDto));
		categoriesList.add(vlSamplesCollected(dashboardRequestDto));
		categoriesList.add(referredFromICTCSingleBarChart(dashboardRequestDto));
		categoriesList.add(attCompletionGraph(dashboardRequestDto));
		categoriesList.add(attStoppedOrOptedOutGraph(dashboardRequestDto));
		categoriesList.add(beneficiaryStatusBreakUpGraph(dashboardRequestDto));
		categoriesList.add(inventoryQuantityPerDrug(dashboardRequestDto));
		categoriesList.add(regimenBreakup(dashboardRequestDto));
		categoriesList.add(pregnantWomenDetectedVsReferred(dashboardRequestDto));
		categoriesList.add(fourSPlusReferredToNTEP(dashboardRequestDto));
		categoriesList.add(typeOfTB(dashboardRequestDto));
		categoriesList.add(iptInitiation(dashboardRequestDto));
		categoriesList.add(iptCompletion(dashboardRequestDto));
		categoriesList.add(iptStoppedOrOptedOut(dashboardRequestDto));
		categoriesList.add(attInitiation(dashboardRequestDto));
		artDashboardResponseDto.setCategories(categoriesList);
		return artDashboardResponseDto;
	}

	private ARTDashboardGraphsDto beneficiaryStatusBreakUpGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryStatusBreakUp = new ARTWidgets();
		widgetForBeneficiaryStatusBreakUp.setType("stack-bar-chart");
		widgetForBeneficiaryStatusBreakUp.setChartTitle("Beneficiary Status Break-up");
		widgetForBeneficiaryStatusBreakUp.setxAxisTitle("Dates");
		widgetForBeneficiaryStatusBreakUp.setyAxisTitle("Count of Beneficiary");
		widgetForBeneficiaryStatusBreakUp.setFilterType("multi-select");
		widgetForBeneficiaryStatusBreakUp.setFilterName("BeneficiaryStatusBreakUp");
		widgetForBeneficiaryStatusBreakUp.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryStatusBreakUp.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<ARTSeries> seriesList = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {

			ARTSeries seriesOfStatus = new ARTSeries();
			if (i == 1) {
				seriesOfStatus.setName("ART Preparedness Counselling");
			}
			if (i == 2) {
				seriesOfStatus.setName("MIS prior to ART initiation");
			}
			if (i == 3) {
				seriesOfStatus.setName("LFU prior to ART initiation");
			}
			if (i == 4) {
				seriesOfStatus.setName("Opted Out prior to ART initiation");
			}
			if (i == 5) {
				seriesOfStatus.setName("Died prior to ART initiation");
			}

			List<StatisticsProjection> widgetForBeneficiaryStatusBreakUpDetailsForStatus = new ArrayList<StatisticsProjection>();
			widgetForBeneficiaryStatusBreakUpDetailsForStatus = artDashboardRepository
					.getwidgetForbeneficiaryStatusBreakUpCountDetailsForStatus(dashboardRequestDto.getFacilityId(), i);
			List<BigInteger> resultOfStatus = new ArrayList<>();
			resultOfStatus = setMonthWiseCounts(monthNames, widgetForBeneficiaryStatusBreakUpDetailsForStatus,
					resultOfStatus);
			seriesOfStatus.setData(resultOfStatus);
			seriesList.add(seriesOfStatus);

		}

		widgetForBeneficiaryStatusBreakUp.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryStatusBreakUp);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto attStoppedOrOptedOutGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForAttStoppedOrOptedOut = new ARTWidgets();
		widgetForAttStoppedOrOptedOut.setType("single-bar-chart");
		widgetForAttStoppedOrOptedOut.setChartTitle("ATT Stopped/Opted-Out");
		widgetForAttStoppedOrOptedOut.setxAxisTitle("Dates");
		widgetForAttStoppedOrOptedOut.setyAxisTitle("Completions");
		widgetForAttStoppedOrOptedOut.setFilterType("date");
		widgetForAttStoppedOrOptedOut.setFilterName("ATTStoppedOptedOut");
		widgetForAttStoppedOrOptedOut.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForAttStoppedOrOptedOut.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> widgetForAttStoppedOrOptedOutDetails = new ArrayList<StatisticsProjection>();
		widgetForAttStoppedOrOptedOutDetails = artDashboardRepository
				.getwidgetForAttStoppedOrOptedOutCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, widgetForAttStoppedOrOptedOutDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Stopped");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForAttStoppedOrOptedOut.setSeries(seriesList);
		widgets.add(widgetForAttStoppedOrOptedOut);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto attCompletionGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForAttCompletion = new ARTWidgets();
		widgetForAttCompletion.setType("single-bar-chart");
		widgetForAttCompletion.setChartTitle("ATT Completion");
		widgetForAttCompletion.setxAxisTitle("Dates");
		widgetForAttCompletion.setyAxisTitle("No of ATTs");
		widgetForAttCompletion.setFilterType("date");
		widgetForAttCompletion.setFilterName("ATTCompletion");
		widgetForAttCompletion.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForAttCompletion.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> attCompletionDetails = new ArrayList<StatisticsProjection>();
		attCompletionDetails = artDashboardRepository
				.getAttCompletionDetailsCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, attCompletionDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Completions");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForAttCompletion.setSeries(seriesList);
		widgets.add(widgetForAttCompletion);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto referredFromICTCSingleBarChart(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForRefferedFromICTC = new ARTWidgets();
		widgetForRefferedFromICTC.setType("single-bar-chart");
		widgetForRefferedFromICTC.setChartTitle("Referred From ICTC");
		widgetForRefferedFromICTC.setxAxisTitle("Dates");
		widgetForRefferedFromICTC.setyAxisTitle("Number of Beneficiaries");
		widgetForRefferedFromICTC.setFilterType("date");
		widgetForRefferedFromICTC.setFilterName("ReferredFromICTC");
		widgetForRefferedFromICTC.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForRefferedFromICTC.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryRefferedFromIctcDetails = new ArrayList<StatisticsProjection>();
		benificiaryRefferedFromIctcDetails = artDashboardRepository
				.getreferredFromICTCCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryRefferedFromIctcDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Referred");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForRefferedFromICTC.setSeries(seriesList);
		widgets.add(widgetForRefferedFromICTC);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto regimenBreakup(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForInventory = new ARTWidgets();
		widgetForInventory.setType("line-chart");
		widgetForInventory.setChartTitle("Beneficiary Regimen Breakup");
		widgetForInventory.setxAxisTitle("Months");
		widgetForInventory.setyAxisTitle("Number of Beneficiaries");
		widgetForInventory.setFilterName("BeneficiaryRegimenBreakup");
		widgetForInventory.setFilterType("multi-select");
		widgetForInventory.setDefaultLabelsForCst(new ArrayList());

		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForInventory.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> regimenBreakupDetails = new ArrayList<StatisticsProjection>();
		regimenBreakupDetails = artDashboardRepository.getRegimenBreakup(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, regimenBreakupDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Regimen");
		series.setData(result);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForInventory.setSeries(seriesList);
		widgets.add(widgetForInventory);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto attInitiation(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForAttInitiation = new ARTWidgets();
		widgetForAttInitiation.setType("single-bar-chart");
		widgetForAttInitiation.setChartTitle("ATT Initiation");
		widgetForAttInitiation.setxAxisTitle("Dates");
		widgetForAttInitiation.setyAxisTitle("No of ATTs");
		widgetForAttInitiation.setFilterName("ATTInitiation");
		widgetForAttInitiation.setFilterType("date");
		widgetForAttInitiation.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForAttInitiation.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// ATT Initiation
		List<StatisticsProjection> attInitiationCountDetails = new ArrayList<StatisticsProjection>();
		attInitiationCountDetails = artDashboardRepository.getAttInitiationCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> attInitiationResult = new ArrayList<>();
		attInitiationResult = setMonthWiseCounts(monthNames, attInitiationCountDetails, attInitiationResult);
		ARTSeries seriesAttInitiation = new ARTSeries();
		seriesAttInitiation.setName("Initiations");
		seriesAttInitiation.setData(attInitiationResult);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesAttInitiation);
		widgetForAttInitiation.setSeries(seriesList);
		widgets.add(widgetForAttInitiation);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto iptStoppedOrOptedOut(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForIptStoppedOrOptedOut = new ARTWidgets();
		widgetForIptStoppedOrOptedOut.setType("single-bar-chart");
		widgetForIptStoppedOrOptedOut.setChartTitle("IPT Stopped/Opted-Out");
		widgetForIptStoppedOrOptedOut.setxAxisTitle("Dates");
		widgetForIptStoppedOrOptedOut.setyAxisTitle("Number of IPTs");
		widgetForIptStoppedOrOptedOut.setFilterName("IPTStoppedOptedOut");
		widgetForIptStoppedOrOptedOut.setFilterType("date");
		widgetForIptStoppedOrOptedOut.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForIptStoppedOrOptedOut.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// Ipt Stopped or Opted Out
		List<StatisticsProjection> iptStoppedOptedOutCountDetails = new ArrayList<StatisticsProjection>();
		iptStoppedOptedOutCountDetails = artDashboardRepository
				.getIptStoppedOrOptedOutCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> iptStoppedOptedOutResult = new ArrayList<>();
		iptStoppedOptedOutResult = setMonthWiseCounts(monthNames, iptStoppedOptedOutCountDetails,
				iptStoppedOptedOutResult);
		ARTSeries seriesIptStoppedOpted = new ARTSeries();
		seriesIptStoppedOpted.setName("Stopped");
		seriesIptStoppedOpted.setData(iptStoppedOptedOutResult);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesIptStoppedOpted);
		widgetForIptStoppedOrOptedOut.setSeries(seriesList);
		widgets.add(widgetForIptStoppedOrOptedOut);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto iptCompletion(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForIptCompletion = new ARTWidgets();
		widgetForIptCompletion.setType("single-bar-chart");
		widgetForIptCompletion.setChartTitle("IPT Completion");
		widgetForIptCompletion.setxAxisTitle("Dates");
		widgetForIptCompletion.setyAxisTitle("No of IPTs");
		widgetForIptCompletion.setFilterName("IPTCompletion");
		widgetForIptCompletion.setFilterType("date");
		widgetForIptCompletion.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForIptCompletion.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// Completions
		List<StatisticsProjection> iptInitiationCountDetails = new ArrayList<StatisticsProjection>();
		iptInitiationCountDetails = artDashboardRepository.getIptCompletionCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> iptCompletionResult = new ArrayList<>();
		iptCompletionResult = setMonthWiseCounts(monthNames, iptInitiationCountDetails, iptCompletionResult);
		ARTSeries seriesIptCompleted = new ARTSeries();
		seriesIptCompleted.setName("Completions");
		seriesIptCompleted.setData(iptCompletionResult);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesIptCompleted);
		widgetForIptCompletion.setSeries(seriesList);
		widgets.add(widgetForIptCompletion);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto iptInitiation(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForIptInitiation = new ARTWidgets();
		widgetForIptInitiation.setType("single-bar-chart");
		widgetForIptInitiation.setChartTitle("IPT Initiation");
		widgetForIptInitiation.setxAxisTitle("Dates");
		widgetForIptInitiation.setyAxisTitle("No of IPTs");
		widgetForIptInitiation.setFilterName("IPTInitiation");
		widgetForIptInitiation.setFilterType("date");
		widgetForIptInitiation.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForIptInitiation.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// Initiations
		List<StatisticsProjection> iptInitiationCountDetails = new ArrayList<StatisticsProjection>();
		iptInitiationCountDetails = artDashboardRepository.getIptInitiationCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> iptInitiationResult = new ArrayList<>();
		iptInitiationResult = setMonthWiseCounts(monthNames, iptInitiationCountDetails, iptInitiationResult);
		ARTSeries seriesIptInitiated = new ARTSeries();
		seriesIptInitiated.setName("Initiations");
		seriesIptInitiated.setData(iptInitiationResult);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesIptInitiated);
		widgetForIptInitiation.setSeries(seriesList);
		widgets.add(widgetForIptInitiation);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto typeOfTB(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForTypesOfTB = new ARTWidgets();
		widgetForTypesOfTB.setType("stack-bar-chart");
		widgetForTypesOfTB.setChartTitle("Type of TB");
		widgetForTypesOfTB.setxAxisTitle("Dates");
		widgetForTypesOfTB.setyAxisTitle("Number of Beneficiaries");
		widgetForTypesOfTB.setFilterName("TypeofTB");
		widgetForTypesOfTB.setFilterType("date");
		widgetForTypesOfTB.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForTypesOfTB.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<ARTSeries> seriesList = new ArrayList<>();
		for (int i = 1; i <= 4; i++) {
			ARTSeries seriesOfTB = new ARTSeries();
			if (i == 1) {
				seriesOfTB.setName("Pulmonary TB (Micro biologically confirmed)");
			}
			if (i == 2) {
				seriesOfTB.setName("Pulmonary TB (Clinically diagnosed)");
			}
			if (i == 3) {
				seriesOfTB.setName("Extra-Pulmonary TB (Micro biologically confirmed)");
			}
			if (i == 4) {
				seriesOfTB.setName("Extra Pulmonary TB (Clinically diagnosed)");
			}
			List<StatisticsProjection> tbTypeCountDetails = new ArrayList<StatisticsProjection>();
			tbTypeCountDetails = artDashboardRepository.getTBCount(dashboardRequestDto.getFacilityId(), i);
			List<BigInteger> tbResult = new ArrayList<>();
			tbResult = setMonthWiseCounts(monthNames, tbTypeCountDetails, tbResult);
			seriesOfTB.setData(tbResult);
			seriesList.add(seriesOfTB);

		}
		widgetForTypesOfTB.setSeries(seriesList);
		widgets.add(widgetForTypesOfTB);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto fourSPlusReferredToNTEP(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForNTEPreferral = new ARTWidgets();
		widgetForNTEPreferral.setType("single-bar-chart");
		widgetForNTEPreferral.setChartTitle("4S+ Referred to NTEP Facility");
		widgetForNTEPreferral.setxAxisTitle("Dates");
		widgetForNTEPreferral.setyAxisTitle("Number of Beneficiaries");
		widgetForNTEPreferral.setFilterName("4SReferredToNTEP");
		widgetForNTEPreferral.setFilterType("date");
		widgetForNTEPreferral.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForNTEPreferral.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// NTEP Referral
		List<StatisticsProjection> ntepReferralCountDetails = new ArrayList<StatisticsProjection>();
		ntepReferralCountDetails = artDashboardRepository.getNtepReferralCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> referredResult = new ArrayList<>();
		referredResult = setMonthWiseCounts(monthNames, ntepReferralCountDetails, referredResult);
		ARTSeries seriesReferred = new ARTSeries();
		seriesReferred.setName("Referred");
		seriesReferred.setData(referredResult);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesReferred);
		widgetForNTEPreferral.setSeries(seriesList);
		widgets.add(widgetForNTEPreferral);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto pregnantWomenDetectedVsReferred(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForPregnantWomen = new ARTWidgets();
		widgetForPregnantWomen.setType("double-bar-chart");
		widgetForPregnantWomen.setChartTitle("Pregnant Women Detected vs Referred to PPTCT");
		widgetForPregnantWomen.setxAxisTitle("Dates");
		widgetForPregnantWomen.setyAxisTitle("Number of Beneficiaries");
		widgetForPregnantWomen.setFilterName("PWDetectedReferred");
		widgetForPregnantWomen.setFilterType("date");
		widgetForPregnantWomen.setDefaultLabelsForCst(new ArrayList());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForPregnantWomen.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// Detected
		List<StatisticsProjection> pregnantDetectedCountDetails = new ArrayList<StatisticsProjection>();
		pregnantDetectedCountDetails = artDashboardRepository
				.getPregnantDetectedCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> detectedResult = new ArrayList<>();
		detectedResult = setMonthWiseCounts(monthNames, pregnantDetectedCountDetails, detectedResult);
		ARTSeries seriesDetected = new ARTSeries();
		seriesDetected.setName("Detected");
		seriesDetected.setData(detectedResult);
		// Referred
		List<StatisticsProjection> pregnantReferredCountDetails = new ArrayList<StatisticsProjection>();
		pregnantReferredCountDetails = artDashboardRepository
				.getPregnantReferredCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> referredResult = new ArrayList<>();
		referredResult = setMonthWiseCounts(monthNames, pregnantReferredCountDetails, referredResult);
		ARTSeries seriesReferred = new ARTSeries();
		seriesReferred.setName("Reffered");
		seriesReferred.setData(referredResult);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesDetected);
		seriesList.add(seriesReferred);
		widgetForPregnantWomen.setSeries(seriesList);
		widgets.add(widgetForPregnantWomen);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto inventoryQuantityPerDrug(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForInventory = new ARTWidgets();
		widgetForInventory.setType("pie-chart");
		widgetForInventory.setChartTitle("Inventory quantity remaining as per Drug");
		widgetForInventory.setxAxisTitle("Months");
		widgetForInventory.setyAxisTitle("Number of Beneficiaries");
		widgetForInventory.setFilterName("InventoryQuantityRemaining");
		widgetForInventory.setFilterType("multi-select");
		List<ARTSeries> artSeriesList = new ArrayList<ARTSeries>();

		List<StatisticsProjection> riskFactors = artDashboardRepository
				.getInventoryQuantityPerDrug(dashboardRequestDto.getFacilityId());
		List<StatisticsProjection> sorted5RiskFactors = sortValueByCountInDesc(riskFactors);
		artSeriesList = settingNameAndValue(sorted5RiskFactors, artSeriesList);
		int riskFactorSum = sumOfOthers(riskFactors);
		if (riskFactorSum > 0) {
			artSeriesList = setSumToValueForOthers(riskFactorSum, artSeriesList);
		}
		widgetForInventory.setSeries(artSeriesList);
		widgets.add(widgetForInventory);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto vlTestConducted(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of VL tests where the count is greater than 1000");
		widgetForcd4Lab.setxAxisTitle("Months");
		widgetForcd4Lab.setyAxisTitle("Number of Tests");
		widgetForcd4Lab.setFilterName("NumberOfVLTestsGT1000");
		widgetForcd4Lab.setFilterType("date");
		widgetForcd4Lab.setDefaultLabelsForCst(new ArrayList<>());

		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForcd4Lab.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> cd4TestCountDetails = new ArrayList<StatisticsProjection>();
		cd4TestCountDetails = artDashboardRepository.getVlTestConducted(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, cd4TestCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Tests");
		series.setData(result);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForcd4Lab.setSeries(seriesList);
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto cd4TestLessThan350(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of CD4 tests where the count is less than 350");
		widgetForcd4Lab.setxAxisTitle("Months");
		widgetForcd4Lab.setyAxisTitle("Number of Tests");
		widgetForcd4Lab.setFilterName("NumberOfcD4TestsLT350");
		widgetForcd4Lab.setFilterType("date");
		widgetForcd4Lab.setDefaultLabelsForCst(new ArrayList<>());

		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForcd4Lab.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> cd4TestCountDetails = new ArrayList<StatisticsProjection>();
		cd4TestCountDetails = artDashboardRepository.getcd4TestLessThan350(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, cd4TestCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Tests");
		series.setData(result);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForcd4Lab.setSeries(seriesList);
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto cd4SamplesCollected(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of CD4 samples collected and dispatched");
		widgetForcd4Lab.setxAxisTitle("Months");
		widgetForcd4Lab.setyAxisTitle("Number of Samples");
		widgetForcd4Lab.setFilterName("NumberOfCD4SamlesCollectedDispatched");
		widgetForcd4Lab.setFilterType("date");
		widgetForcd4Lab.setDefaultLabelsForCst(new ArrayList<>());

		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForcd4Lab.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> cd4TestCountDetails = new ArrayList<StatisticsProjection>();
		cd4TestCountDetails = artDashboardRepository.getcd4SamplesCollected(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, cd4TestCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Samples");
		series.setData(result);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForcd4Lab.setSeries(seriesList);
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto vlSamplesCollected(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of VL samples collected and dispatched");
		widgetForcd4Lab.setxAxisTitle("Months");
		widgetForcd4Lab.setyAxisTitle("Number of Samples");
		widgetForcd4Lab.setFilterName("NumberOfVLSamlesCollectedDispatched");
		widgetForcd4Lab.setFilterType("date");
		widgetForcd4Lab.setDefaultLabelsForCst(new ArrayList<>());

		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForcd4Lab.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> cd4TestCountDetails = new ArrayList<StatisticsProjection>();
		cd4TestCountDetails = artDashboardRepository.getVlSamplesCollected(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, cd4TestCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Samples");
		series.setData(result);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForcd4Lab.setSeries(seriesList);
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto cd4TestConducted(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Conducted = new ARTWidgets();
		widgetForcd4Conducted.setType("single-bar-chart");
		widgetForcd4Conducted.setChartTitle("Number of tests CD4 conducted");
		widgetForcd4Conducted.setxAxisTitle("Dates");
		widgetForcd4Conducted.setyAxisTitle("Number of Tests");
		widgetForcd4Conducted.setFilterName("NumberOfCD4Tests");
		widgetForcd4Conducted.setFilterType("date");
		widgetForcd4Conducted.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForcd4Conducted.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> cd4TestCountDetails = new ArrayList<StatisticsProjection>();
		cd4TestCountDetails = artDashboardRepository.getcd4TestConductedCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, cd4TestCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Tests Conducted");
		series.setData(result);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForcd4Conducted.setSeries(seriesList);
		widgets.add(widgetForcd4Conducted);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto detectedByStaffNurse(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetFor4sdetected = new ARTWidgets();
		widgetFor4sdetected.setType("stack-bar-chart");
		widgetFor4sdetected.setChartTitle("4S+ Detected By Staff Nurse");
		widgetFor4sdetected.setxAxisTitle("Dates");
		widgetFor4sdetected.setyAxisTitle("Number of Beneficiaries");
		widgetFor4sdetected.setFilterName("4SPlusDetected");
		widgetFor4sdetected.setFilterType("date");
		widgetFor4sdetected.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetFor4sdetected.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// Cough
		List<StatisticsProjection> coughDetectedCountDetails = new ArrayList<StatisticsProjection>();
		coughDetectedCountDetails = artDashboardRepository.getCoughDetectedCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> coughResult = new ArrayList<>();
		coughResult = setMonthWiseCounts(monthNames, coughDetectedCountDetails, coughResult);
		ARTSeries seriesforCough = new ARTSeries();
		seriesforCough.setName("Cough");
		seriesforCough.setData(coughResult);
		// Fever
		List<StatisticsProjection> feverDetectedCountDetails = new ArrayList<StatisticsProjection>();
		feverDetectedCountDetails = artDashboardRepository.getFeverDetectedCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> feverResult = new ArrayList<>();
		feverResult = setMonthWiseCounts(monthNames, feverDetectedCountDetails, feverResult);
		ARTSeries seriesForFever = new ARTSeries();
		seriesForFever.setName("Fever");
		seriesForFever.setData(feverResult);
		// Weight Loss
		List<StatisticsProjection> weightLossDetectedCountDetails = new ArrayList<StatisticsProjection>();
		weightLossDetectedCountDetails = artDashboardRepository
				.getWeightLossDetectedCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> weightLossResult = new ArrayList<>();
		weightLossResult = setMonthWiseCounts(monthNames, weightLossDetectedCountDetails, weightLossResult);
		ARTSeries seriesForWeightLoss = new ARTSeries();
		seriesForWeightLoss.setName("Weight Loss");
		seriesForWeightLoss.setData(weightLossResult);
		// Night Sweat
		List<StatisticsProjection> nightSweatDetectedCountDetails = new ArrayList<StatisticsProjection>();
		nightSweatDetectedCountDetails = artDashboardRepository
				.getNightSweatDetectedCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> nightSweatResult = new ArrayList<>();
		nightSweatResult = setMonthWiseCounts(monthNames, nightSweatDetectedCountDetails, nightSweatResult);
		ARTSeries seriesForNightSweat = new ARTSeries();
		seriesForNightSweat.setName("Night Sweats");
		seriesForNightSweat.setData(nightSweatResult);

		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesforCough);
		seriesList.add(seriesForFever);
		seriesList.add(seriesForWeightLoss);
		seriesList.add(seriesForNightSweat);
		widgetFor4sdetected.setSeries(seriesList);
		widgets.add(widgetFor4sdetected);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto investigationsInFacility(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForInvestigations = new ARTWidgets();
		widgetForInvestigations.setType("single-bar-chart");
		widgetForInvestigations.setChartTitle("Investigation in Facility");
		widgetForInvestigations.setxAxisTitle("Dates");
		widgetForInvestigations.setyAxisTitle("Number of Investigations");
		widgetForInvestigations.setFilterName("InvestigationsInFacility");
		widgetForInvestigations.setFilterType("date");
		widgetForInvestigations.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForInvestigations.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> investigationCountDetails = new ArrayList<StatisticsProjection>();
		investigationCountDetails = artDashboardRepository.getInvestigationCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, investigationCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Investigations");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForInvestigations.setSeries(seriesList);
		widgets.add(widgetForInvestigations);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto referredFromICTC(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		artDashboardGraphsDto.setTitle("Referred From ICTC");
		// Widget 1
		ARTWidgets artWidgets1 = new ARTWidgets();
		artWidgets1.setType("pie-chart");
		artWidgets1.setChartTitle("Facilitywise Breakup");
		artWidgets1.setFilterName("FacilitywiseBreakup");
		artWidgets1.setFilterType("multi-select");
		List<ARTSeries> artSeriesList = new ArrayList<ARTSeries>();
		List<StatisticsProjection> facilities = artDashboardRepository.getAllFacilities();
		List<StatisticsProjection> sorted5Values = sortValueByCountInDesc(facilities);
		artSeriesList = settingNameAndValue(sorted5Values, artSeriesList);
		int sum = sumOfOthers(facilities);
		if (sum > 0) {
			artSeriesList = setSumToValueForOthers(sum, artSeriesList);
		}
		artWidgets1.setSeries(artSeriesList);
		// Widget 2
		ARTWidgets artWidgets2 = new ARTWidgets();
		artWidgets2.setType("pie-chart");
		artWidgets2.setChartTitle("Breakup As Per Risk Factor");
		artWidgets2.setFilterName("RiskFactorBreakup");
		artWidgets2.setFilterType("multi-select");
		List<ARTSeries> artSeriesList2 = new ArrayList<ARTSeries>();
		List<StatisticsProjection> riskFactors = artDashboardRepository
				.getAllRiskFactorsByFacilityId(dashboardRequestDto.getFacilityId());
		List<StatisticsProjection> sorted5RiskFactors = sortValueByCountInDesc(riskFactors);
		artSeriesList2 = settingNameAndValue(sorted5RiskFactors, artSeriesList2);
		int riskFactorSum = sumOfOthers(riskFactors);
		if (riskFactorSum > 0) {
			artSeriesList2 = setSumToValueForOthers(riskFactorSum, artSeriesList2);
		}
		artWidgets2.setSeries(artSeriesList2);
		// Widget 3
		ARTWidgets artWidgets3 = new ARTWidgets();
		artWidgets3.setType("pie-chart");
		artWidgets3.setChartTitle("Breakup As Per Entry Point");
		artWidgets3.setFilterName("EntryPointBreakup");
		artWidgets3.setFilterType("multi-select");
		List<ARTSeries> artSeriesList3 = new ArrayList<ARTSeries>();
		List<StatisticsProjection> entryPoint = artDashboardRepository
				.getAllEntryPointsByFacilityId(dashboardRequestDto.getFacilityId());
		List<StatisticsProjection> sorted5EntryPoint = sortValueByCountInDesc(entryPoint);
		artSeriesList3 = settingNameAndValue(sorted5EntryPoint, artSeriesList3);
		int entryPointSum = sumOfOthers(entryPoint);
		if (entryPointSum > 0) {
			artSeriesList3 = setSumToValueForOthers(entryPointSum, artSeriesList3);
		}
		artWidgets3.setSeries(artSeriesList3);
		// Widget 4
		ARTWidgets artWidgets4 = new ARTWidgets();
		artWidgets4.setType("pie-chart");
		artWidgets4.setChartTitle("Breakup As Per Occupation");
		artWidgets4.setFilterName("OccupationBreakup");
		artWidgets4.setFilterType("multi-select");
		List<ARTSeries> artSeriesList4 = new ArrayList<ARTSeries>();
		List<StatisticsProjection> occupation = artDashboardRepository
				.getAllOccupationByFacilityId(dashboardRequestDto.getFacilityId());
		List<StatisticsProjection> sorted5Occupation = sortValueByCountInDesc(occupation);
		artSeriesList4 = settingNameAndValue(sorted5Occupation, artSeriesList4);
		int occupationSum = sumOfOthers(occupation);
		if (occupationSum > 0) {
			artSeriesList4 = setSumToValueForOthers(occupationSum, artSeriesList4);
		}
		artWidgets4.setSeries(artSeriesList4);
		// Widget 5
		ARTWidgets artWidgets5 = new ARTWidgets();
		artWidgets5.setType("pie-chart");
		artWidgets5.setChartTitle("Breakup As Per Education ");
		artWidgets5.setFilterName("EducationBreakup");
		artWidgets5.setFilterType("multi-select");
		List<ARTSeries> artSeriesList5 = new ArrayList<ARTSeries>();
		List<StatisticsProjection> education = artDashboardRepository
				.getAllEducationByFacilityId(dashboardRequestDto.getFacilityId());
		List<StatisticsProjection> sorted5Education = sortValueByCountInDesc(education);
		artSeriesList5 = settingNameAndValue(sorted5Education, artSeriesList5);

		int educationSum = sumOfOthers(education);
		if (educationSum > 0) {
			artSeriesList5 = setSumToValueForOthers(educationSum, artSeriesList5);
		}
		artWidgets5.setSeries(artSeriesList5);
		// Widget 6
		ARTWidgets artWidgets6 = new ARTWidgets();
		artWidgets6.setType("pie-chart");
		artWidgets6.setChartTitle("Breakup As Per Salary");
		artWidgets6.setFilterName("SalaryBreakup");
		artWidgets6.setFilterType("multi-select");
		List<ARTSeries> artSeriesList6 = new ArrayList<ARTSeries>();
		List<StatisticsProjection> salary = artDashboardRepository
				.getAllSalaryByFacilityId(dashboardRequestDto.getFacilityId());
		List<StatisticsProjection> sorted5Salary = sortValueByCountInDesc(salary);
		artSeriesList6 = settingNameAndValue(sorted5Salary, artSeriesList6);
		int salarySum = sumOfOthers(salary);
		if (salarySum > 0) {
			artSeriesList6 = setSumToValueForOthers(salarySum, artSeriesList6);
		}
		artWidgets6.setSeries(artSeriesList6);

		List<ARTWidgets> artWidgetsList = new ArrayList<ARTWidgets>();
		artWidgetsList.add(artWidgets1); // Facility breakup
		artWidgetsList.add(artWidgets2); // risk factor breakup
		artWidgetsList.add(artWidgets3); // entry point breakup
		artWidgetsList.add(artWidgets4); // occupation breakup
		artWidgetsList.add(artWidgets5); // education breakup
		artWidgetsList.add(artWidgets6); // salary breakup
		artDashboardGraphsDto.setWidgets(artWidgetsList);

		return artDashboardGraphsDto;

	}

	private ARTDashboardGraphsDto beneficiaryDueForVisitGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryDueVisit = new ARTWidgets();
		widgetForBeneficiaryDueVisit.setType("single-bar-chart");
		widgetForBeneficiaryDueVisit.setChartTitle("Beneficiaries Due For Visit");
		widgetForBeneficiaryDueVisit.setxAxisTitle("Dates");
		widgetForBeneficiaryDueVisit.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryDueVisit.setFilterType("date");
		widgetForBeneficiaryDueVisit.setFilterName("BeneficiaryDueForVisit");
		widgetForBeneficiaryDueVisit.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryDueVisit.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryDueForVisitCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryDueForVisitCountDetails = artDashboardRepository
				.getBenificiaryDueForVisit(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryDueForVisitCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Persons");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForBeneficiaryDueVisit.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryDueVisit);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryVisitGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryVisit = new ARTWidgets();
		widgetForBeneficiaryVisit.setType("single-bar-chart");
		widgetForBeneficiaryVisit.setChartTitle("Beneficiaries Visited");
		widgetForBeneficiaryVisit.setxAxisTitle("Dates");
		widgetForBeneficiaryVisit.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryVisit.setFilterType("date");
		widgetForBeneficiaryVisit.setFilterName("BeneficiaryVisited");
		widgetForBeneficiaryVisit.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryVisit.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryForVisitCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryForVisitCountDetails = artDashboardRepository
				.getBenificiaryForVisit(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryForVisitCountDetails, result);

		ARTSeries series = new ARTSeries();
		series.setName("Persons");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForBeneficiaryVisit.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryVisit);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto foursPlusDetectedByCCGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForFourPlusDetectedByCcVisit = new ARTWidgets();
		widgetForFourPlusDetectedByCcVisit.setType("single-bar-chart");
		widgetForFourPlusDetectedByCcVisit.setChartTitle("4S+ Detected by CC");
		widgetForFourPlusDetectedByCcVisit.setxAxisTitle("Dates");
		widgetForFourPlusDetectedByCcVisit.setyAxisTitle("Number of Beneficiaries");
		widgetForFourPlusDetectedByCcVisit.setFilterType("date");
		widgetForFourPlusDetectedByCcVisit.setFilterName("4SCCDetected");
		widgetForFourPlusDetectedByCcVisit.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForFourPlusDetectedByCcVisit.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> fourPlusDetectedCountByCc = new ArrayList<StatisticsProjection>();
		fourPlusDetectedCountByCc = artDashboardRepository
				.getFourPlusDetectedCountByCc(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, fourPlusDetectedCountByCc, result);

		ARTSeries series = new ARTSeries();
		series.setName("4S+");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForFourPlusDetectedByCcVisit.setSeries(seriesList);
		widgets.add(widgetForFourPlusDetectedByCcVisit);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryMissedAppointmentsGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();

		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryMissedAppointment = new ARTWidgets();
		widgetForBeneficiaryMissedAppointment.setType("single-bar-chart");
		widgetForBeneficiaryMissedAppointment.setChartTitle("Beneficiaries Missed Appointments");
		widgetForBeneficiaryMissedAppointment.setxAxisTitle("Dates");
		widgetForBeneficiaryMissedAppointment.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryMissedAppointment.setFilterType("date");
		widgetForBeneficiaryMissedAppointment.setFilterName("BeneficiaryMissedAppointment");
		widgetForBeneficiaryMissedAppointment.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryMissedAppointment.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryMissedAppoinmentsCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryMissedAppoinmentsCountDetails = artDashboardRepository
				.getBenificiaryMissedAppoinmentsCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryMissedAppoinmentsCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Missed Appointments");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForBeneficiaryMissedAppointment.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryMissedAppointment);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryNewRegistrationsGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryNewRegistrations = new ARTWidgets();
		widgetForBeneficiaryNewRegistrations.setType("single-bar-chart");
		widgetForBeneficiaryNewRegistrations.setChartTitle("New Registrations");
		widgetForBeneficiaryNewRegistrations.setxAxisTitle("Dates");
		widgetForBeneficiaryNewRegistrations.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryNewRegistrations.setFilterType("date");
		widgetForBeneficiaryNewRegistrations.setFilterName("NewRegistrations");
		widgetForBeneficiaryNewRegistrations.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryNewRegistrations.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryNewRegistrationsCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryNewRegistrationsCountDetails = artDashboardRepository
				.getBeneficiaryNewRegistrationsCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryNewRegistrationsCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Registrations");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForBeneficiaryNewRegistrations.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryNewRegistrations);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryNewInitiationsGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryNewInitiations = new ARTWidgets();
		widgetForBeneficiaryNewInitiations.setType("single-bar-chart");
		widgetForBeneficiaryNewInitiations.setChartTitle("New Initiations");
		widgetForBeneficiaryNewInitiations.setxAxisTitle("Dates");
		widgetForBeneficiaryNewInitiations.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryNewInitiations.setFilterType("date");
		widgetForBeneficiaryNewInitiations.setFilterName("NewInitiations");
		widgetForBeneficiaryNewInitiations.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryNewInitiations.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryNewInitiationsCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryNewInitiationsCountDetails = artDashboardRepository
				.getBeneficiaryNewInitiationsCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryNewInitiationsCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Initiations");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForBeneficiaryNewInitiations.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryNewInitiations);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryTransferOutVsTransferInGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryTransferOutVsTransferIn = new ARTWidgets();
		widgetForBeneficiaryTransferOutVsTransferIn.setType("double-bar-chart");
		widgetForBeneficiaryTransferOutVsTransferIn.setChartTitle("Beneficiary Transfer Out vs Transfer In");
		widgetForBeneficiaryTransferOutVsTransferIn.setxAxisTitle("Dates");
		widgetForBeneficiaryTransferOutVsTransferIn.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryTransferOutVsTransferIn.setFilterType("date");
		widgetForBeneficiaryTransferOutVsTransferIn.setFilterName("BeneficiaryTranferInOut");
		widgetForBeneficiaryTransferOutVsTransferIn.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryTransferOutVsTransferIn.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// TransferIn
		List<StatisticsProjection> benificiaryTransferInCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryTransferInCountDetails = artDashboardRepository
				.getBeneficiaryTransferInCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> tranferInResult = new ArrayList<>();
		tranferInResult = setMonthWiseCounts(monthNames, benificiaryTransferInCountDetails, tranferInResult);
		ARTSeries seriesForTransferIn = new ARTSeries();
		seriesForTransferIn.setName("Transfer-In");
		seriesForTransferIn.setData(tranferInResult);
		// TransferOut
		List<StatisticsProjection> benificiaryTransferOutCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryTransferOutCountDetails = artDashboardRepository
				.getBeneficiaryTransferOutCount(dashboardRequestDto.getFacilityId());
		List<BigInteger> tranferOutresult = new ArrayList<>();
		tranferOutresult = setMonthWiseCounts(monthNames, benificiaryTransferOutCountDetails, tranferOutresult);
		ARTSeries seriesForTransferOut = new ARTSeries();
		seriesForTransferOut.setName("Transfer-Out");
		seriesForTransferOut.setData(tranferOutresult);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(seriesForTransferIn);
		seriesList.add(seriesForTransferOut);
		widgetForBeneficiaryTransferOutVsTransferIn.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryTransferOutVsTransferIn);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryPendingTransferInGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryPendingTransferIn = new ARTWidgets();
		widgetForBeneficiaryPendingTransferIn.setType("single-bar-chart");
		widgetForBeneficiaryPendingTransferIn.setChartTitle("Beneficiary Pending Transfer In");
		widgetForBeneficiaryPendingTransferIn.setxAxisTitle("Dates");
		widgetForBeneficiaryPendingTransferIn.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryPendingTransferIn.setFilterType("date");
		widgetForBeneficiaryPendingTransferIn.setFilterName("BeneficiaryPendingTransferIn");
		widgetForBeneficiaryPendingTransferIn.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryPendingTransferIn.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> benificiaryPendingTransferInCountDetails = new ArrayList<StatisticsProjection>();
		benificiaryPendingTransferInCountDetails = artDashboardRepository
				.getBeneficiaryPendingTransferInCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, benificiaryPendingTransferInCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Transfer-In");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForBeneficiaryPendingTransferIn.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryPendingTransferIn);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto numberOfDispensationGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetFornumberOfDispensation = new ARTWidgets();
		widgetFornumberOfDispensation.setType("single-bar-chart");
		widgetFornumberOfDispensation.setChartTitle("Number of Dispensation");
		widgetFornumberOfDispensation.setxAxisTitle("Dates");
		widgetFornumberOfDispensation.setyAxisTitle("Number of Dispensation");
		widgetFornumberOfDispensation.setFilterType("date");
		widgetFornumberOfDispensation.setFilterName("NumberOfDispensation");
		widgetFornumberOfDispensation.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetFornumberOfDispensation.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> numberOfDispensationCountDetails = new ArrayList<StatisticsProjection>();
		numberOfDispensationCountDetails = artDashboardRepository
				.getNumberOfDispensationCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, numberOfDispensationCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Dispensation");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetFornumberOfDispensation.setSeries(seriesList);
		widgets.add(widgetFornumberOfDispensation);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto numberOfDispensationdrugCountAsPerDrugCountGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForNumberOfDispensationdrugCountAsPerDrugCount = new ARTWidgets();
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setType("single-bar-chart");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount
				.setChartTitle("Number of dispensation as per Drug count");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setxAxisTitle("Dates");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setyAxisTitle("Number of Beneficiaries");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setFilterType("date");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setFilterName("NumberOfDispensationPerDrugCount");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setDefaultLabelsForCst(new ArrayList<String>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForNumberOfDispensationdrugCountAsPerDrugCount
				.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> NumberOfDispensationdrugCountAsPerDrugCountDetails = new ArrayList<StatisticsProjection>();
		NumberOfDispensationdrugCountAsPerDrugCountDetails = artDashboardRepository
				.getNumberOfDispensationdrugCountAsPerDrugCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, NumberOfDispensationdrugCountAsPerDrugCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Dispensation");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setSeries(seriesList);
		widgets.add(widgetForNumberOfDispensationdrugCountAsPerDrugCount);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto numberOfTestsVlConductedGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForNumberOfTestsVlConducted = new ARTWidgets();
		widgetForNumberOfTestsVlConducted.setType("single-bar-chart");
		widgetForNumberOfTestsVlConducted.setChartTitle("Number of tests VL conducted");
		widgetForNumberOfTestsVlConducted.setxAxisTitle("Dates");
		widgetForNumberOfTestsVlConducted.setyAxisTitle("Number of Tests");
		widgetForNumberOfTestsVlConducted.setFilterType("date");
		widgetForNumberOfTestsVlConducted.setFilterName("NumberOfTestsVLConducted");
		widgetForNumberOfTestsVlConducted.setDefaultLabelsForCst(new ArrayList<String>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForNumberOfTestsVlConducted.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> numberOfTestsVlConductedCountDetails = new ArrayList<StatisticsProjection>();
		numberOfTestsVlConductedCountDetails = artDashboardRepository
				.getnumberOfTestsVlConductedCountDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> result = new ArrayList<>();
		result = setMonthWiseCounts(monthNames, numberOfTestsVlConductedCountDetails, result);
		ARTSeries series = new ARTSeries();
		series.setName("Tests Conducted");
		series.setData(result);
		List<ARTSeries> seriesList = new ArrayList<>();
		seriesList.add(series);
		widgetForNumberOfTestsVlConducted.setSeries(seriesList);
		widgets.add(widgetForNumberOfTestsVlConducted);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;

	}

	private List<BigInteger> setMonthWiseCounts(List<String> monthNames, List<StatisticsProjection> results,
			List<BigInteger> value) {
		for (String monthName : monthNames) {
			switch (monthName.toLowerCase()) {

			case "january":
				value = insertRegistrationCount("january", results, value);
				break;
			case "february":
				value = insertRegistrationCount("february", results, value);
				break;
			case "march":
				value = insertRegistrationCount("march", results, value);
				break;
			case "april":
				value = insertRegistrationCount("april", results, value);
				break;
			case "may":
				value = insertRegistrationCount("may", results, value);
				break;
			case "june":
				value = insertRegistrationCount("june", results, value);
				break;
			case "july":
				value = insertRegistrationCount("july", results, value);
				break;
			case "august":
				value = insertRegistrationCount("august", results, value);
				break;
			case "september":
				value = insertRegistrationCount("september", results, value);
				break;
			case "october":
				value = insertRegistrationCount("october", results, value);
				break;
			case "november":
				value = insertRegistrationCount("november", results, value);
				break;
			case "december":
				value = insertRegistrationCount("dece", results, value);
				break;
			default:
				break;

			}
		}
		return value;
	}

	private List<BigInteger> insertRegistrationCount(String monthName, List<StatisticsProjection> result,
			List<BigInteger> countValue) {
		Optional<StatisticsProjection> matchingMonthDetails = null;
		Stream<StatisticsProjection> stream = null;
		try {
			if (result != null && result.size() > 0 && monthName != null) {
				stream = result.stream().filter(x -> x.getName().trim().equalsIgnoreCase(monthName.trim()));

			}
			if (stream != null) {
				matchingMonthDetails = stream.findAny();
			}
		} catch (Exception e) {
			matchingMonthDetails = null;
		}

		if (matchingMonthDetails != null && matchingMonthDetails.isPresent() && matchingMonthDetails.get() != null) {
			countValue.add(matchingMonthDetails.get().getValue());
		} else {
			countValue.add(BigInteger.valueOf(0l));
		}
		return countValue;
	}

	public ARTDashBoardResponseDTO getFilteredData(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashBoardResponseDTO artDashboardResponseDto = new ARTDashBoardResponseDTO();
		List<ARTDashboardGraphsDto> categoriesList = new ArrayList<ARTDashboardGraphsDto>();
		if (!dashboardRequestDto.getFilterName().equals(null)) {

			switch (dashboardRequestDto.getFilterName()) {

			case "BeneficiaryDueForVisit":

				try {
					categoriesList.add(createFilteredBeneficiaryDueForVisit(dashboardRequestDto));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;

			case "BeneficiaryVisited":

				categoriesList.add(createFilteredBeneficiaryVisitgraph(dashboardRequestDto));
				break;

			case "4SCCDetected":
				categoriesList.add(filteredFourPlusDetectedByCCGraph(dashboardRequestDto));
				break;
			case "BeneficiaryMissedAppointment":
				categoriesList.add(beneficiaryMissedAppointmentsFilterGraph(dashboardRequestDto));
				break;
			case "NewRegistrations":
				categoriesList.add(beneficiaryNewRegistrationsFilterGraph(dashboardRequestDto));
				break;
			case "NewInitiations":
				categoriesList.add(beneficiaryNewInitiationsFilterGraph(dashboardRequestDto));
				break;

			case "FacilitywiseBreakup":
				categoriesList.add(ictcReferredBreakupWithFilters(dashboardRequestDto, "FacilitywiseBreakup"));
				break;
			case "RiskFactorBreakup":
				categoriesList.add(ictcReferredBreakupWithFilters(dashboardRequestDto, "RiskFactorBreakup"));
				break;
			case "EntryPointBreakup":
				categoriesList.add(ictcReferredBreakupWithFilters(dashboardRequestDto, "EntryPointBreakup"));
				break;
			case "OccupationBreakup":
				categoriesList.add(ictcReferredBreakupWithFilters(dashboardRequestDto, "OccupationBreakup"));
				break;
			case "EducationBreakup":
				categoriesList.add(ictcReferredBreakupWithFilters(dashboardRequestDto, "EducationBreakup"));
				break;
			case "SalaryBreakup":
				categoriesList.add(ictcReferredBreakupWithFilters(dashboardRequestDto, "SalaryBreakup"));
				break;
			case "BeneficiaryTranferInOut":
				categoriesList.add(beneficiaryTransferOutVsTransferInFilterGraph(dashboardRequestDto));
				break;
			case "BeneficiaryPendingTransferIn":
				categoriesList.add(beneficiaryPendingTransferInFilterGraph(dashboardRequestDto));
				break;
			case "NumberOfDispensation":
				categoriesList.add(numberOfDispensationFilterGraph(dashboardRequestDto));
				break;
			case "NumberOfDispensationPerDrugCount":
				categoriesList.add(numberOfDispensationdrugCountAsPerDrugCountFilterGraph(dashboardRequestDto));
				break;
			case "NumberOfTestsVLConducted":
				categoriesList.add(numberOfTestsVlConductedFilterGraph(dashboardRequestDto));
				break;
			case "ReferredFromICTC":
				categoriesList.add(referredFromICTCSingleBarChartFilterGraph(dashboardRequestDto));
				break;
			case "ATTCompletion":
				categoriesList.add(attCompletionFilterGraph(dashboardRequestDto));
				break;
			case "ATTStoppedOptedOut":
				categoriesList.add(attStoppedOrOptedOutFilterGraph(dashboardRequestDto));
				break;
			case "InvestigationsInFacility":
				categoriesList.add(investigationsInFacilityWithFilters(dashboardRequestDto));
				break;
			case "4SPlusDetected":
				categoriesList.add(detectedByStaffNurseWithFilters(dashboardRequestDto));
				break;
			case "NumberOfVLTestsGT1000":
				categoriesList.add(filteredVlTestConducted(dashboardRequestDto));
				break;
			case "NumberOfcD4TestsLT350":
				categoriesList.add(filteredCd4TestLessThan350(dashboardRequestDto));
				break;
			case "NumberOfCD4SamlesCollectedDispatched":
				categoriesList.add(filteredCd4SamplesCollected(dashboardRequestDto));
				break;
			case "NumberOfVLSamlesCollectedDispatched":
				categoriesList.add(filteredVlSamplesCollected(dashboardRequestDto));
				break;
			case "NumberOfCD4Tests":
				categoriesList.add(cd4TestConductedWithFilters(dashboardRequestDto));
				break;
			case "PWDetectedReferred":
				categoriesList.add(pregnantWomenDetectedVsReferredWithFilters(dashboardRequestDto));
				break;
			case "4SReferredToNTEP":
				categoriesList.add(fourSPlusReferredToNTEPWithFilters(dashboardRequestDto));
				break;
			case "TypeofTB":
				categoriesList.add(typesOfTBWithFilters(dashboardRequestDto));
				break;
			case "IPTInitiation":
				categoriesList.add(iptInitiationWithFilters(dashboardRequestDto));
				break;
			case "IPTCompletion":
				categoriesList.add(iptCompletionWithFilters(dashboardRequestDto));
				break;
			case "IPTStopppedOptedOut":
				categoriesList.add(iptStoppedOrOptedOutWithFilters(dashboardRequestDto));
				break;
			case "ATTInitiation":
				categoriesList.add(attInitiationWithFilters(dashboardRequestDto));
				break;
			case "BeneficiaryStatusBreakUp":
				categoriesList.add(beneficiaryStatusBreakUpFilterGraph(dashboardRequestDto));
				break;
			case "BeneficiaryRegimenBreakup":
				categoriesList.add(beneficiaryRegimenBreakUpFilterGraph(dashboardRequestDto));
				break;
			case "InventoryQuantityRemaining":
				categoriesList.add(inventoryQuantityPerDrugFilterGraph(dashboardRequestDto));
				break;
			}
		}
		artDashboardResponseDto.setCategories(categoriesList);
		return artDashboardResponseDto;
	}

	private ARTDashboardGraphsDto inventoryQuantityPerDrugFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> artWidgetsList = new ArrayList<ARTWidgets>();

		ARTWidgets widgetsForFacilityWise = new ARTWidgets();
		widgetsForFacilityWise.setType("pie-chart");
		widgetsForFacilityWise.setChartTitle("Inventory quantity remaining as per Drug");
		widgetsForFacilityWise.setFilterType("multi-select");
		widgetsForFacilityWise.setFilterName("InventoryQuantityRemaining");
		List<ARTSeries> artSeriesFacilities = new ArrayList<ARTSeries>();
		List<String> facilityNames = dashboardRequestDto.getItems();
		List<StatisticsProjection> facilitywiseBreakup = artDashboardRepository
				.getInventoryQuantityPerDrugForFilters(dashboardRequestDto.getFacilityId(), facilityNames);
		List<StatisticsProjection> sortedFacilities = sortValueByCountInDesc(facilitywiseBreakup);
		artSeriesFacilities = settingNameAndValue(sortedFacilities, artSeriesFacilities);

		widgetsForFacilityWise.setSeries(artSeriesFacilities);
		artWidgetsList.add(widgetsForFacilityWise);
		artDashboardGraphsDto.setWidgets(artWidgetsList);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryRegimenBreakUpFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryStatusBreakUp = new ARTWidgets();
		widgetForBeneficiaryStatusBreakUp.setType("line-select");
		widgetForBeneficiaryStatusBreakUp.setChartTitle("Beneficiary Regimen Breakup");
		widgetForBeneficiaryStatusBreakUp.setxAxisTitle("Dates");
		widgetForBeneficiaryStatusBreakUp.setyAxisTitle("Count of Beneficiary");
		widgetForBeneficiaryStatusBreakUp.setFilterType("multi-select");
		widgetForBeneficiaryStatusBreakUp.setFilterName("BeneficiaryRegimenBreakup");
		widgetForBeneficiaryStatusBreakUp.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryStatusBreakUp.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<ARTSeries> seriesList = new ArrayList<>();
		if (!dashboardRequestDto.getItems().isEmpty()) {
			for (String str : dashboardRequestDto.getItems()) {
				if (str.equals("Regimen 1")) {
					ARTSeries seriesOfStatus1 = new ARTSeries();
					seriesOfStatus1.setName("Regimen 1");
					List<StatisticsProjection> widgetForBeneficiaryStatusBreakUpDetailsForStatus1 = new ArrayList<StatisticsProjection>();
					widgetForBeneficiaryStatusBreakUpDetailsForStatus1 = artDashboardRepository
							.getBeneficiaryRegimenBreakupCountDetailsForRegimen1(dashboardRequestDto.getFacilityId());
					List<BigInteger> resultOfStatus1 = new ArrayList<>();
					resultOfStatus1 = setMonthWiseCounts(monthNames, widgetForBeneficiaryStatusBreakUpDetailsForStatus1,
							resultOfStatus1);
					seriesOfStatus1.setData(resultOfStatus1);
					seriesList.add(seriesOfStatus1);
				}
				if (str.equals("Regimen 2")) {
					ARTSeries seriesOfStatus2 = new ARTSeries();
					seriesOfStatus2.setName("Regimen 2");
					List<StatisticsProjection> widgetForBeneficiaryStatusBreakUpDetailsForStatus2 = new ArrayList<StatisticsProjection>();
					widgetForBeneficiaryStatusBreakUpDetailsForStatus2 = artDashboardRepository
							.getBeneficiaryRegimenBreakupCountDetailsForRegimen2(dashboardRequestDto.getFacilityId());
					List<BigInteger> resultOfStatus2 = new ArrayList<>();
					resultOfStatus2 = setMonthWiseCounts(monthNames, widgetForBeneficiaryStatusBreakUpDetailsForStatus2,
							resultOfStatus2);
					seriesOfStatus2.setData(resultOfStatus2);
					seriesList.add(seriesOfStatus2);
				}
				if (str.equals("Regimen 3")) {
					ARTSeries seriesOfStatus3 = new ARTSeries();
					seriesOfStatus3.setName("Regimen 3");
					List<StatisticsProjection> widgetForBeneficiaryStatusBreakUpDetailsForStatus3 = new ArrayList<StatisticsProjection>();
					widgetForBeneficiaryStatusBreakUpDetailsForStatus3 = artDashboardRepository
							.getBeneficiaryRegimenBreakupCountDetailsForRegimen3(dashboardRequestDto.getFacilityId());
					List<BigInteger> resultOfStatus3 = new ArrayList<>();
					resultOfStatus3 = setMonthWiseCounts(monthNames, widgetForBeneficiaryStatusBreakUpDetailsForStatus3,
							resultOfStatus3);
					seriesOfStatus3.setData(resultOfStatus3);
					seriesList.add(seriesOfStatus3);
				}
			}
		}

		widgetForBeneficiaryStatusBreakUp.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryStatusBreakUp);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;

	}

	private ARTDashboardGraphsDto beneficiaryStatusBreakUpFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryStatusBreakUp = new ARTWidgets();
		widgetForBeneficiaryStatusBreakUp.setType("stack-bar-chart");
		widgetForBeneficiaryStatusBreakUp.setChartTitle("Beneficiary Status Break-up");
		widgetForBeneficiaryStatusBreakUp.setxAxisTitle("Dates");
		widgetForBeneficiaryStatusBreakUp.setyAxisTitle("Count of Beneficiary");
		widgetForBeneficiaryStatusBreakUp.setFilterType("multi-select");
		widgetForBeneficiaryStatusBreakUp.setFilterName("BeneficiaryStatusBreakUp");
		widgetForBeneficiaryStatusBreakUp.setDefaultLabelsForCst(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetForBeneficiaryStatusBreakUp.setCategoriesForCst(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<ARTSeries> seriesList = new ArrayList<>();
		if (!dashboardRequestDto.getItems().isEmpty()) {

			for (String str : dashboardRequestDto.getItems()) {

				String statusName = artDashboardRepository.getStatusName(Integer.parseInt(str));
				ARTSeries seriesOfStatus1 = new ARTSeries();
				seriesOfStatus1.setName("" + statusName + "");
				List<StatisticsProjection> widgetForBeneficiaryStatusBreakUpDetailsForStatus = new ArrayList<StatisticsProjection>();
				widgetForBeneficiaryStatusBreakUpDetailsForStatus = artDashboardRepository
						.getwidgetForbeneficiaryStatusBreakUpCountDetailsForStatus(dashboardRequestDto.getFacilityId(),
								Integer.parseInt(str));
				List<BigInteger> resultOfStatus = new ArrayList<>();
				resultOfStatus = setMonthWiseCounts(monthNames, widgetForBeneficiaryStatusBreakUpDetailsForStatus,
						resultOfStatus);
				seriesOfStatus1.setData(resultOfStatus);
				seriesList.add(seriesOfStatus1);
			}

		}

		widgetForBeneficiaryStatusBreakUp.setSeries(seriesList);
		widgets.add(widgetForBeneficiaryStatusBreakUp);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;

	}

	private ARTDashboardGraphsDto attInitiationWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForAttInitiation = new ARTWidgets();
		widgetForAttInitiation.setType("single-bar-chart");
		widgetForAttInitiation.setChartTitle("ATT Initiation");
		widgetForAttInitiation.setxAxisTitle("Dates");
		widgetForAttInitiation.setyAxisTitle("No of ATTs");
		widgetForAttInitiation.setFilterName("ATTInitiation");
		widgetForAttInitiation.setFilterType("date");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForAttInitiation.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// ATT Initiations
				List<StatisticsProjection> attInitiationCountDetails = new ArrayList<StatisticsProjection>();
				attInitiationCountDetails = artDashboardRepository
						.getAttInitiationCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> attInitiationResult = new ArrayList<>();
				attInitiationResult = setMonthWiseCounts(monthNames, attInitiationCountDetails, attInitiationResult);
				ARTSeries seriesAttInitiation = new ARTSeries();
				seriesAttInitiation.setName("Stopped");
				seriesAttInitiation.setData(attInitiationResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesAttInitiation);
				widgetForAttInitiation.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForAttInitiation.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// Initiations
					List<StatisticsProjection> attInitiationountDetails = new ArrayList<StatisticsProjection>();
					attInitiationountDetails = artDashboardRepository
							.getAttInitiationCountForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> attInitiationResult = new ArrayList<>();
					attInitiationResult = setDateWiseCounts(dates, attInitiationountDetails, attInitiationResult);
					ARTSeries seriesAttInitiation = new ARTSeries();
					seriesAttInitiation.setName("Initiations");
					seriesAttInitiation.setData(attInitiationResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesAttInitiation);
					widgetForAttInitiation.setSeries(seriesList);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		}
		widgets.add(widgetForAttInitiation);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto iptStoppedOrOptedOutWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForIptStoppedOrOptedOut = new ARTWidgets();
		widgetForIptStoppedOrOptedOut.setType("single-bar-chart");
		widgetForIptStoppedOrOptedOut.setChartTitle("IPT Stopped/Opted-Out");
		widgetForIptStoppedOrOptedOut.setxAxisTitle("Dates");
		widgetForIptStoppedOrOptedOut.setyAxisTitle("Number of IPTs");
		widgetForIptStoppedOrOptedOut.setFilterName("IPTStoppedOptedOut");
		widgetForIptStoppedOrOptedOut.setFilterType("date");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForIptStoppedOrOptedOut.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// Ipt Stopped or Opted Out
				List<StatisticsProjection> iptStoppedOptedOutCountDetails = new ArrayList<StatisticsProjection>();
				iptStoppedOptedOutCountDetails = artDashboardRepository
						.getIptStoppedOrOptedOutCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> iptStoppedOptedOutResult = new ArrayList<>();
				iptStoppedOptedOutResult = setMonthWiseCounts(monthNames, iptStoppedOptedOutCountDetails,
						iptStoppedOptedOutResult);
				ARTSeries seriesIptStoppedOpted = new ARTSeries();
				seriesIptStoppedOpted.setName("Stopped");
				seriesIptStoppedOpted.setData(iptStoppedOptedOutResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesIptStoppedOpted);
				widgetForIptStoppedOrOptedOut.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForIptStoppedOrOptedOut.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// Initiations
					List<StatisticsProjection> ntepReferralCountDetails = new ArrayList<StatisticsProjection>();
					ntepReferralCountDetails = artDashboardRepository
							.getIptStoppedOrOptedOutForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> iptStoppedResult = new ArrayList<>();
					iptStoppedResult = setDateWiseCounts(dates, ntepReferralCountDetails, iptStoppedResult);
					ARTSeries seriesIptStoppedOpted = new ARTSeries();
					seriesIptStoppedOpted.setName("Stopped");
					seriesIptStoppedOpted.setData(iptStoppedResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesIptStoppedOpted);
					widgetForIptStoppedOrOptedOut.setSeries(seriesList);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		}

		widgets.add(widgetForIptStoppedOrOptedOut);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto iptCompletionWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForIptCompletion = new ARTWidgets();
		widgetForIptCompletion.setType("single-bar-chart");
		widgetForIptCompletion.setChartTitle("IPT Completion");
		widgetForIptCompletion.setxAxisTitle("Dates");
		widgetForIptCompletion.setyAxisTitle("No of IPTs");
		widgetForIptCompletion.setFilterName("IPTCompletion");
		widgetForIptCompletion.setFilterType("date");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForIptCompletion.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// Initiations
				List<StatisticsProjection> iptCompletitionCountDetails = new ArrayList<StatisticsProjection>();
				iptCompletitionCountDetails = artDashboardRepository
						.getIptCompletionCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> iptCompletionResult = new ArrayList<>();
				iptCompletionResult = setMonthWiseCounts(monthNames, iptCompletitionCountDetails, iptCompletionResult);
				ARTSeries seriesIptCompleted = new ARTSeries();
				seriesIptCompleted.setName("Completions");
				seriesIptCompleted.setData(iptCompletionResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesIptCompleted);
				widgetForIptCompletion.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForIptCompletion.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// Completion
					List<StatisticsProjection> iptCompletitionCountDetails = new ArrayList<StatisticsProjection>();
					iptCompletitionCountDetails = artDashboardRepository
							.getIptCompletionCountForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> iptCompletionResult = new ArrayList<>();
					iptCompletionResult = setDateWiseCounts(dates, iptCompletitionCountDetails, iptCompletionResult);
					ARTSeries seriesIptCompleted = new ARTSeries();
					seriesIptCompleted.setName("Completions");
					seriesIptCompleted.setData(iptCompletionResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesIptCompleted);
					widgetForIptCompletion.setSeries(seriesList);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForIptCompletion);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto iptInitiationWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForIptInitiation = new ARTWidgets();
		widgetForIptInitiation.setType("single-bar-chart");
		widgetForIptInitiation.setChartTitle("IPT Initiation");
		widgetForIptInitiation.setxAxisTitle("Dates");
		widgetForIptInitiation.setyAxisTitle("No of IPTs");
		widgetForIptInitiation.setFilterName("IPTInitiation");
		widgetForIptInitiation.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForIptInitiation.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// Initiations
				List<StatisticsProjection> iptInitiationCountDetails = new ArrayList<StatisticsProjection>();
				iptInitiationCountDetails = artDashboardRepository
						.getIptInitiationCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> iptInitiationResult = new ArrayList<>();
				iptInitiationResult = setMonthWiseCounts(monthNames, iptInitiationCountDetails, iptInitiationResult);
				ARTSeries seriesIptInitiated = new ARTSeries();
				seriesIptInitiated.setName("Initiations");
				seriesIptInitiated.setData(iptInitiationResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesIptInitiated);
				widgetForIptInitiation.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForIptInitiation.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// Initiations
					List<StatisticsProjection> ntepReferralCountDetails = new ArrayList<StatisticsProjection>();
					ntepReferralCountDetails = artDashboardRepository
							.getIptInitiationCountForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> iptInitiationResult = new ArrayList<>();
					iptInitiationResult = setDateWiseCounts(dates, ntepReferralCountDetails, iptInitiationResult);
					ARTSeries seriesIptInitiated = new ARTSeries();
					seriesIptInitiated.setName("Initiations");
					seriesIptInitiated.setData(iptInitiationResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesIptInitiated);
					widgetForIptInitiation.setSeries(seriesList);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForIptInitiation);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto typesOfTBWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForTypesOfTB = new ARTWidgets();
		widgetForTypesOfTB.setType("stack-bar-chart");
		widgetForTypesOfTB.setChartTitle("Type of TB");
		widgetForTypesOfTB.setxAxisTitle("Dates");
		widgetForTypesOfTB.setyAxisTitle("Number of Beneficiaries");
		widgetForTypesOfTB.setFilterName("TypeofTB");
		widgetForTypesOfTB.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForTypesOfTB.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<ARTSeries> seriesList = new ArrayList<>();
				for (int i = 1; i <= 4; i++) {
					ARTSeries seriesOfTB = new ARTSeries();
					if (i == 1) {
						seriesOfTB.setName("Pulmonary TB (Micro biologically confirmed)");
					}
					if (i == 2) {
						seriesOfTB.setName("Pulmonary TB (Clinically diagnosed)");
					}
					if (i == 3) {
						seriesOfTB.setName("Extra-Pulmonary TB (Micro biologically confirmed)");
					}
					if (i == 4) {
						seriesOfTB.setName("Extra Pulmonary TB (Clinically diagnosed)");
					}
					List<StatisticsProjection> tbTypeCountDetails = new ArrayList<StatisticsProjection>();
					tbTypeCountDetails = artDashboardRepository.getTBCountForMonths(dashboardRequestDto.getFacilityId(),
							i, dateFrom, dateTo);
					List<BigInteger> tbResult = new ArrayList<>();
					tbResult = setMonthWiseCounts(monthNames, tbTypeCountDetails, tbResult);
					seriesOfTB.setData(tbResult);
					seriesList.add(seriesOfTB);
				}
				widgetForTypesOfTB.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForTypesOfTB.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<ARTSeries> seriesList = new ArrayList<>();
					for (int i = 1; i <= 4; i++) {
						ARTSeries seriesOfTB = new ARTSeries();
						if (i == 1) {
							seriesOfTB.setName("Pulmonary TB (Micro biologically confirmed)");
						}
						if (i == 2) {
							seriesOfTB.setName("Pulmonary TB (Clinically diagnosed)");
						}
						if (i == 3) {
							seriesOfTB.setName("Extra-Pulmonary TB (Micro biologically confirmed)");
						}
						if (i == 4) {
							seriesOfTB.setName("Extra Pulmonary TB (Clinically diagnosed)");
						}
						List<StatisticsProjection> tbTypeCountDetails = new ArrayList<StatisticsProjection>();
						tbTypeCountDetails = artDashboardRepository
								.getTBCountForDays(dashboardRequestDto.getFacilityId(), i, dateFrom, dateTo);
						List<BigInteger> tbResult = new ArrayList<>();
						tbResult = setMonthWiseCounts(dates, tbTypeCountDetails, tbResult);
						seriesOfTB.setData(tbResult);
						seriesList.add(seriesOfTB);
						widgetForTypesOfTB.setSeries(seriesList);

					}
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}

		}
		widgets.add(widgetForTypesOfTB);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto fourSPlusReferredToNTEPWithFilters(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForNTEPreferral = new ARTWidgets();
		widgetForNTEPreferral.setType("single-bar-chart");
		widgetForNTEPreferral.setChartTitle("4S+ Referred to NTEP Facility");
		widgetForNTEPreferral.setxAxisTitle("Dates");
		widgetForNTEPreferral.setyAxisTitle("Number of Beneficiaries");
		widgetForNTEPreferral.setFilterName("4SReferredToNTEP");
		widgetForNTEPreferral.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForNTEPreferral.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// detected
				List<StatisticsProjection> ntepReferralCountDetails = new ArrayList<StatisticsProjection>();
				ntepReferralCountDetails = artDashboardRepository
						.getNtepReferralCountDetailsForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> referredResult = new ArrayList<>();
				referredResult = setMonthWiseCounts(monthNames, ntepReferralCountDetails, referredResult);
				ARTSeries seriesReferred = new ARTSeries();
				seriesReferred.setName("Referred");
				seriesReferred.setData(referredResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesReferred);
				widgetForNTEPreferral.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForNTEPreferral.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// detected
					List<StatisticsProjection> ntepReferralCountDetails = new ArrayList<StatisticsProjection>();
					ntepReferralCountDetails = artDashboardRepository
							.getNtepReferralCountDetailsForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> referredResult = new ArrayList<>();
					referredResult = setDateWiseCounts(dates, ntepReferralCountDetails, referredResult);
					ARTSeries seriesReferred = new ARTSeries();
					seriesReferred.setName("Beneficiaries");
					seriesReferred.setData(referredResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesReferred);
					widgetForNTEPreferral.setSeries(seriesList);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForNTEPreferral);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto pregnantWomenDetectedVsReferredWithFilters(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForPregnantWomen = new ARTWidgets();
		widgetForPregnantWomen.setType("double-bar-chart");
		widgetForPregnantWomen.setChartTitle("Pregnant Women Detected vs Referred to PPTCT");
		widgetForPregnantWomen.setxAxisTitle("Dates");
		widgetForPregnantWomen.setyAxisTitle("Number of Beneficiaries");
		widgetForPregnantWomen.setFilterName("PWDetectedReferred");
		widgetForPregnantWomen.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForPregnantWomen.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// detected
				List<StatisticsProjection> pregnantWomenDetectedCountDetails = new ArrayList<StatisticsProjection>();
				pregnantWomenDetectedCountDetails = artDashboardRepository
						.getPregnantDetectedCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> detectedResult = new ArrayList<>();
				detectedResult = setMonthWiseCounts(monthNames, pregnantWomenDetectedCountDetails, detectedResult);
				ARTSeries seriesDetected = new ARTSeries();
				seriesDetected.setName("Detected");
				seriesDetected.setData(detectedResult);
				// referred
				List<StatisticsProjection> pregnantWomenReferredCountDetails = new ArrayList<StatisticsProjection>();
				pregnantWomenReferredCountDetails = artDashboardRepository
						.getPregnantReferredCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> refferedResult = new ArrayList<>();
				refferedResult = setMonthWiseCounts(monthNames, pregnantWomenDetectedCountDetails, refferedResult);
				ARTSeries seriesReferred = new ARTSeries();
				seriesReferred.setName("Detected");
				seriesReferred.setData(refferedResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesDetected);
				seriesList.add(seriesReferred);
				widgetForPregnantWomen.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForPregnantWomen.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// detected
					List<StatisticsProjection> pregnantWomenDetectedCountForDays = new ArrayList<StatisticsProjection>();
					pregnantWomenDetectedCountForDays = artDashboardRepository.getPregnantWomenDetectedCountForDays(
							dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> detectedResult = new ArrayList<>();
					detectedResult = setDateWiseCounts(dates, pregnantWomenDetectedCountForDays, detectedResult);
					ARTSeries seriesDetected = new ARTSeries();
					seriesDetected.setName("Detected");
					seriesDetected.setData(detectedResult);
					// Referred
					List<StatisticsProjection> pregnantWomenReferredCountForDays = new ArrayList<StatisticsProjection>();
					pregnantWomenReferredCountForDays = artDashboardRepository.getPregnantWomenRefferedCountForDays(
							dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> refferedResult = new ArrayList<>();
					refferedResult = setDateWiseCounts(dates, pregnantWomenDetectedCountForDays, refferedResult);
					ARTSeries seriesReferred = new ARTSeries();
					seriesReferred.setName("Referred");
					seriesReferred.setData(refferedResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesDetected);
					seriesList.add(seriesReferred);
					widgetForPregnantWomen.setSeries(seriesList);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForPregnantWomen);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto cd4TestConductedWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Conducted = new ARTWidgets();
		widgetForcd4Conducted.setType("single-bar-chart");
		widgetForcd4Conducted.setChartTitle("Number of tests CD4 conducted");
		widgetForcd4Conducted.setxAxisTitle("Dates");
		widgetForcd4Conducted.setyAxisTitle("Number of Tests");
		widgetForcd4Conducted.setFilterName("NumberOfCD4Tests");
		widgetForcd4Conducted.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForcd4Conducted.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> cd4TestCountDetails = new ArrayList<StatisticsProjection>();
				cd4TestCountDetails = artDashboardRepository
						.getcd4TestConductedCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, cd4TestCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Tests Conducted");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForcd4Conducted.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForcd4Conducted.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> cd4TestCountDetailsForDays = new ArrayList<StatisticsProjection>();
					cd4TestCountDetailsForDays = artDashboardRepository
							.getcd4TestConductedCountForDates(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, cd4TestCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Tests Conducted");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForcd4Conducted.setSeries(seriesList);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForcd4Conducted);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto filteredVlTestConducted(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of VL tests where the count is greater than 1000");
		widgetForcd4Lab.setxAxisTitle("Dates");
		widgetForcd4Lab.setyAxisTitle("Number of Tests");
		widgetForcd4Lab.setFilterName("NumberOfVLTestsGT1000");
		widgetForcd4Lab.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForcd4Lab.setLabelWithMonthInDuration(new ArrayList<String>(), dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				List<StatisticsProjection> vlTestData = new ArrayList<StatisticsProjection>();
				vlTestData = artDashboardRepository
						.getFilteredVlTestConductedForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, vlTestData, result);
				ARTSeries series = new ARTSeries();
				series.setName("Tests");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForcd4Lab.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForcd4Lab.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> vlTestDataCountDetailsForDays = new ArrayList<StatisticsProjection>();
					vlTestDataCountDetailsForDays = artDashboardRepository
							.getFilteredVlTestConductedForDates(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, vlTestDataCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Persons");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForcd4Lab.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto filteredCd4TestLessThan350(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of CD4 tests where the count is less than 350");
		widgetForcd4Lab.setxAxisTitle("Dates");
		widgetForcd4Lab.setyAxisTitle("Number of Tests");
		widgetForcd4Lab.setFilterName("NumberOfcD4TestsLT350");
		widgetForcd4Lab.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForcd4Lab.setLabelWithMonthInDuration(new ArrayList<String>(), dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				List<StatisticsProjection> cd4TestData = new ArrayList<StatisticsProjection>();
				cd4TestData = artDashboardRepository
						.getFilteredCd4TestLessThan350ForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, cd4TestData, result);
				ARTSeries series = new ARTSeries();
				series.setName("Tests");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForcd4Lab.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForcd4Lab.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> cd4TestDataCountDetailsForDays = new ArrayList<StatisticsProjection>();
					cd4TestDataCountDetailsForDays = artDashboardRepository.getFilteredCd4TestLessThan350ForDates(
							dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, cd4TestDataCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Persons");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForcd4Lab.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto filteredCd4SamplesCollected(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of CD4 samples collected and dispatched");
		widgetForcd4Lab.setxAxisTitle("Dates");
		widgetForcd4Lab.setyAxisTitle("Number of Samples");
		widgetForcd4Lab.setFilterName("NumberOfCD4SamlesCollectedDispatched");
		widgetForcd4Lab.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForcd4Lab.setLabelWithMonthInDuration(new ArrayList<String>(), dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				List<StatisticsProjection> cd4TestData = new ArrayList<StatisticsProjection>();
				cd4TestData = artDashboardRepository
						.getFilteredCd4SamplesCollectedForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, cd4TestData, result);
				ARTSeries series = new ARTSeries();
				series.setName("Samples");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForcd4Lab.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForcd4Lab.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> cd4TestDataCountDetailsForDays = new ArrayList<StatisticsProjection>();
					cd4TestDataCountDetailsForDays = artDashboardRepository.getFilteredCd4SamplesCollectedForDates(
							dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, cd4TestDataCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Persons");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForcd4Lab.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto filteredVlSamplesCollected(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForcd4Lab = new ARTWidgets();
		widgetForcd4Lab.setType("single-bar-chart");
		widgetForcd4Lab.setChartTitle("Number of VL samples collected and dispatched");
		widgetForcd4Lab.setxAxisTitle("Dates");
		widgetForcd4Lab.setyAxisTitle("Number of Samples");
		widgetForcd4Lab.setFilterName("NumberOfVLSamlesCollectedDispatched");
		widgetForcd4Lab.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForcd4Lab.setLabelWithMonthInDuration(new ArrayList<String>(), dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				List<StatisticsProjection> vlTestData = new ArrayList<StatisticsProjection>();
				vlTestData = artDashboardRepository
						.getFilteredVlSamplesCollectedForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, vlTestData, result);
				ARTSeries series = new ARTSeries();
				series.setName("Samples");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForcd4Lab.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForcd4Lab.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> vlTestDataCountDetailsForDays = new ArrayList<StatisticsProjection>();
					vlTestDataCountDetailsForDays = artDashboardRepository.getFilteredVlSamplesCollectedForDates(
							dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, vlTestDataCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Persons");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForcd4Lab.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForcd4Lab);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto attStoppedOrOptedOutFilterGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForAttStoppedOrOptedOut = new ARTWidgets();
		widgetForAttStoppedOrOptedOut.setType("single-bar-chart");
		widgetForAttStoppedOrOptedOut.setChartTitle("ATT Stopped/Opted-Out");
		widgetForAttStoppedOrOptedOut.setxAxisTitle("Dates");
		widgetForAttStoppedOrOptedOut.setyAxisTitle("Number of Beneficiaries");
		widgetForAttStoppedOrOptedOut.setFilterType("date");
		widgetForAttStoppedOrOptedOut.setFilterName("ATTStoppedOptedOut");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForAttStoppedOrOptedOut.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> widgetForAttStoppedOrOptedOutDetails = new ArrayList<StatisticsProjection>();
				widgetForAttStoppedOrOptedOutDetails = artDashboardRepository
						.getwidgetForAttStoppedOrOptedOutFilterByMonthCountDetails(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, widgetForAttStoppedOrOptedOutDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Stopped");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForAttStoppedOrOptedOut.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForAttStoppedOrOptedOut.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> widgetForAttStoppedOrOptedOutDetails = new ArrayList<StatisticsProjection>();
					widgetForAttStoppedOrOptedOutDetails = artDashboardRepository
							.getwidgetForAttStoppedOrOptedOutFilterByDatesCountDetails(
									dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, widgetForAttStoppedOrOptedOutDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Stopped");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForAttStoppedOrOptedOut.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForAttStoppedOrOptedOut);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto attCompletionFilterGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForAttCompletion = new ARTWidgets();
		widgetForAttCompletion.setType("single-bar-chart");
		widgetForAttCompletion.setChartTitle("ATT Stopped/Opted-Out");
		widgetForAttCompletion.setxAxisTitle("Dates");
		widgetForAttCompletion.setyAxisTitle("Number of Beneficiaries");
		widgetForAttCompletion.setFilterType("date");
		widgetForAttCompletion.setFilterName("ATTStoppedOptedOut");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForAttCompletion.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> widgetForAttCompletionDetails = new ArrayList<StatisticsProjection>();
				widgetForAttCompletionDetails = artDashboardRepository
						.getwidgetForAttCompletionFilterByMonthGraphCountDetails(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, widgetForAttCompletionDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Stopped");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForAttCompletion.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForAttCompletion.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> widgetForAttCompletionDetails = new ArrayList<StatisticsProjection>();
					widgetForAttCompletionDetails = artDashboardRepository
							.getwidgetForAttCompletionFilterByDateGraphCountDetails(dashboardRequestDto.getFacilityId(),
									dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, widgetForAttCompletionDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Stopped");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForAttCompletion.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForAttCompletion);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto referredFromICTCSingleBarChartFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForRefferedFromICTC = new ARTWidgets();
		widgetForRefferedFromICTC.setType("single-bar-chart");
		widgetForRefferedFromICTC.setChartTitle("Referred From ICTC");
		widgetForRefferedFromICTC.setxAxisTitle("Dates");
		widgetForRefferedFromICTC.setyAxisTitle("Number of Beneficiaries");
		widgetForRefferedFromICTC.setFilterType("date");
		widgetForRefferedFromICTC.setFilterName("ReferredFromICTC");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForRefferedFromICTC.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryRefferedFromIctcDetails = new ArrayList<StatisticsProjection>();
				benificiaryRefferedFromIctcDetails = artDashboardRepository
						.getreferredFromICTCCountDetailsByMonthFilter(dashboardRequestDto.getFacilityId(), dateFrom,
								dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryRefferedFromIctcDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Referred");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForRefferedFromICTC.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForRefferedFromICTC.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryRefferedFromIctcDetails = new ArrayList<StatisticsProjection>();
					benificiaryRefferedFromIctcDetails = artDashboardRepository
							.getreferredFromICTCCountDetailsByDateFilter(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryRefferedFromIctcDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Referred");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForRefferedFromICTC.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForRefferedFromICTC);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;

	}

	private ARTDashboardGraphsDto detectedByStaffNurseWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetFor4sdetected = new ARTWidgets();
		widgetFor4sdetected.setType("stack-bar-chart");
		widgetFor4sdetected.setChartTitle("4S+ Detected By Staff Nurse");
		widgetFor4sdetected.setxAxisTitle("Dates");
		widgetFor4sdetected.setyAxisTitle("Number of Beneficiaries");
		widgetFor4sdetected.setFilterName("4SPlusDetected");
		widgetFor4sdetected.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetFor4sdetected.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());

				List<StatisticsProjection> coughDetectedCountDetails = new ArrayList<StatisticsProjection>();
				coughDetectedCountDetails = artDashboardRepository
						.getCoughDetectedCountDetailsForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> coughResult = new ArrayList<>();
				coughResult = setMonthWiseCounts(monthNames, coughDetectedCountDetails, coughResult);
				ARTSeries seriesForCough = new ARTSeries();
				seriesForCough.setName("Cough");
				seriesForCough.setData(coughResult);

				List<StatisticsProjection> feverDetectedCountDetails = new ArrayList<StatisticsProjection>();
				feverDetectedCountDetails = artDashboardRepository
						.getfeverDetectedCountDetailsForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> feverResult = new ArrayList<>();
				feverResult = setMonthWiseCounts(monthNames, feverDetectedCountDetails, feverResult);
				ARTSeries seriesForFever = new ARTSeries();
				seriesForFever.setName("Fever");
				seriesForFever.setData(feverResult);

				List<StatisticsProjection> weightLossDetectedCountDetails = new ArrayList<StatisticsProjection>();
				weightLossDetectedCountDetails = artDashboardRepository
						.getWeightLossDetectedCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> weightLossResult = new ArrayList<>();
				weightLossResult = setMonthWiseCounts(monthNames, weightLossDetectedCountDetails, weightLossResult);
				ARTSeries seriesForWeightLoss = new ARTSeries();
				seriesForWeightLoss.setName("Weight Loss");
				seriesForWeightLoss.setData(weightLossResult);

				List<StatisticsProjection> nightSweatDetectedCountDetails = new ArrayList<StatisticsProjection>();
				nightSweatDetectedCountDetails = artDashboardRepository
						.getNightSweatDetectedCountForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> nightSweatResult = new ArrayList<>();
				nightSweatResult = setMonthWiseCounts(monthNames, nightSweatDetectedCountDetails, nightSweatResult);
				ARTSeries seriesForNightSweat = new ARTSeries();
				seriesForNightSweat.setName("Night Sweats");
				seriesForNightSweat.setData(nightSweatResult);

				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesForCough);
				seriesList.add(seriesForFever);
				seriesList.add(seriesForWeightLoss);
				seriesList.add(seriesForNightSweat);
				widgetFor4sdetected.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetFor4sdetected.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());

					// Cough
					List<StatisticsProjection> coughDetectedCountDetailsForDays = new ArrayList<StatisticsProjection>();
					coughDetectedCountDetailsForDays = artDashboardRepository
							.getCoughDetectedCountDetailsForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> coughResult = new ArrayList<>();
					coughResult = setDateWiseCounts(dates, coughDetectedCountDetailsForDays, coughResult);
					ARTSeries seriesForCough = new ARTSeries();
					seriesForCough.setName("Cough");
					seriesForCough.setData(coughResult);
					// Fever
					List<StatisticsProjection> feverDetectedCountDetailsForDays = new ArrayList<StatisticsProjection>();
					feverDetectedCountDetailsForDays = artDashboardRepository
							.getFeverDetectedCountDetailsForDays(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> feverResult = new ArrayList<>();
					feverResult = setDateWiseCounts(dates, feverDetectedCountDetailsForDays, feverResult);
					ARTSeries seriesForFever = new ARTSeries();
					seriesForFever.setName("Fever");
					seriesForFever.setData(coughResult);
					// Weight Loss
					List<StatisticsProjection> weightLossDetectedCountDetailsForDays = new ArrayList<StatisticsProjection>();
					weightLossDetectedCountDetailsForDays = artDashboardRepository
							.getWeightLossDetectedCountDetailsForDays(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> weightLossResult = new ArrayList<>();
					weightLossResult = setDateWiseCounts(dates, weightLossDetectedCountDetailsForDays,
							weightLossResult);
					ARTSeries seriesForWeightLoss = new ARTSeries();
					seriesForWeightLoss.setName("Weight Loss");
					seriesForWeightLoss.setData(coughResult);
					// Night Sweat
					List<StatisticsProjection> nightSweatDetectedCountDetailsForDays = new ArrayList<StatisticsProjection>();
					nightSweatDetectedCountDetailsForDays = artDashboardRepository
							.getNightSweatDetectedCountDetailsForDays(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> nightSweatResult = new ArrayList<>();
					nightSweatResult = setDateWiseCounts(dates, nightSweatDetectedCountDetailsForDays,
							nightSweatResult);
					ARTSeries seriesForNightSweat = new ARTSeries();
					seriesForNightSweat.setName("Night Sweat");
					seriesForNightSweat.setData(coughResult);

					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesForCough);
					seriesList.add(seriesForFever);
					seriesList.add(seriesForWeightLoss);
					seriesList.add(seriesForNightSweat);
					widgetFor4sdetected.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetFor4sdetected);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto investigationsInFacilityWithFilters(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForInvestigations = new ARTWidgets();
		widgetForInvestigations.setType("single-bar-chart");
		widgetForInvestigations.setChartTitle("Investigation in Facility");
		widgetForInvestigations.setxAxisTitle("Dates");
		widgetForInvestigations.setyAxisTitle("Number of Investigations");
		widgetForInvestigations.setFilterName("InvestigationsInFacility");
		widgetForInvestigations.setFilterType("date");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForInvestigations.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> investigationCountDetails = new ArrayList<StatisticsProjection>();
				investigationCountDetails = artDashboardRepository
						.getInvestigationCountDetailsForMonths(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, investigationCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Investigations");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForInvestigations.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForInvestigations.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryNewInitiationsFilterCountDetailsForDays = new ArrayList<StatisticsProjection>();
					benificiaryNewInitiationsFilterCountDetailsForDays = artDashboardRepository
							.getInvestigationCountDetailsForDates(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryNewInitiationsFilterCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Investigations");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForInvestigations.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		widgets.add(widgetForInvestigations);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto numberOfTestsVlConductedFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForNumberOfTestsVlConducted = new ARTWidgets();
		widgetForNumberOfTestsVlConducted.setType("single-bar-chart");
		widgetForNumberOfTestsVlConducted.setChartTitle("Number of tests VL conducted");
		widgetForNumberOfTestsVlConducted.setxAxisTitle("Dates");
		widgetForNumberOfTestsVlConducted.setyAxisTitle("Number of Tests");
		widgetForNumberOfTestsVlConducted.setFilterType("date");
		widgetForNumberOfTestsVlConducted.setFilterName("NumberOfTestsVLConducted");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForNumberOfTestsVlConducted.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> numberOfTestsVlConductedCountDetails = new ArrayList<StatisticsProjection>();
				numberOfTestsVlConductedCountDetails = artDashboardRepository
						.getnumberOfTestsVlConductedCountDetailsFilteredByMonth(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, numberOfTestsVlConductedCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Tests Conducted");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForNumberOfTestsVlConducted.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForNumberOfTestsVlConducted.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> numberOfTestsVlConductedCountDetails = new ArrayList<StatisticsProjection>();
					numberOfTestsVlConductedCountDetails = artDashboardRepository
							.getnumberOfTestsVlConductedCountDetailsFilteredByDate(dashboardRequestDto.getFacilityId(),
									dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, numberOfTestsVlConductedCountDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Stopped");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForNumberOfTestsVlConducted.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForNumberOfTestsVlConducted);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto numberOfDispensationdrugCountAsPerDrugCountFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForNumberOfDispensationdrugCountAsPerDrugCount = new ARTWidgets();
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setType("single-bar-chart");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount
				.setChartTitle("Number of dispensation as per Drug count");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setxAxisTitle("Dates");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setyAxisTitle("Number of Beneficiaries");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setFilterType("date");
		widgetForNumberOfDispensationdrugCountAsPerDrugCount.setFilterName("NumberOfDispensationPerDrugCount");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForNumberOfDispensationdrugCountAsPerDrugCount.setLabelWithMonthInDuration(
						new ArrayList<String>(), dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> NumberOfDispensationdrugCountAsPerDrugCountDetails = new ArrayList<StatisticsProjection>();
				NumberOfDispensationdrugCountAsPerDrugCountDetails = artDashboardRepository
						.getNumberOfDispensationdrugCountAsPerDrugCountDetailsByMonthFilter(
								dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, NumberOfDispensationdrugCountAsPerDrugCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Dispensation");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForNumberOfDispensationdrugCountAsPerDrugCount.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForNumberOfDispensationdrugCountAsPerDrugCount.setLabelsWithDatesCst(new ArrayList<String>(),
							numberOfDays, dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> NumberOfDispensationdrugCountAsPerDrugCountDetails = new ArrayList<StatisticsProjection>();
					NumberOfDispensationdrugCountAsPerDrugCountDetails = artDashboardRepository
							.getNumberOfDispensationdrugCountAsPerDrugCountDetailsByDateFilter(
									dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, NumberOfDispensationdrugCountAsPerDrugCountDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Stopped");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForNumberOfDispensationdrugCountAsPerDrugCount.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForNumberOfDispensationdrugCountAsPerDrugCount);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto numberOfDispensationFilterGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetFornumberOfDispensation = new ARTWidgets();
		widgetFornumberOfDispensation.setType("single-bar-chart");
		widgetFornumberOfDispensation.setChartTitle("Number of Dispensation");
		widgetFornumberOfDispensation.setxAxisTitle("Dates");
		widgetFornumberOfDispensation.setyAxisTitle("Number of Dispensation");
		widgetFornumberOfDispensation.setFilterType("date");
		widgetFornumberOfDispensation.setFilterName("NumberOfDispensation");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetFornumberOfDispensation.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> numberOfDispensationCountDetails = new ArrayList<StatisticsProjection>();
				numberOfDispensationCountDetails = artDashboardRepository
						.getNumberOfDispensationCountFilterByMonthDetails(dashboardRequestDto.getFacilityId(), dateFrom,
								dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, numberOfDispensationCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Transfer-In");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetFornumberOfDispensation.setSeries(seriesList);

			} else {

				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetFornumberOfDispensation.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> numberOfDispensationCountDetails = new ArrayList<StatisticsProjection>();
					numberOfDispensationCountDetails = artDashboardRepository
							.getNumberOfDispensationCountFilterByDateDetails(dashboardRequestDto.getFacilityId(),
									dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, numberOfDispensationCountDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Dispensation");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetFornumberOfDispensation.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		widgets.add(widgetFornumberOfDispensation);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryPendingTransferInFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryPendingTransferIn = new ARTWidgets();
		widgetForBeneficiaryPendingTransferIn.setType("single-bar-chart");
		widgetForBeneficiaryPendingTransferIn.setChartTitle("Beneficiary Pending Transfer In");
		widgetForBeneficiaryPendingTransferIn.setxAxisTitle("Dates");
		widgetForBeneficiaryPendingTransferIn.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryPendingTransferIn.setFilterType("date");
		widgetForBeneficiaryPendingTransferIn.setFilterName("BeneficiaryPendingTransferIn");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {

				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryPendingTransferIn.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryPendingTransferInFilterByMonthCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryPendingTransferInFilterByMonthCountDetails = artDashboardRepository
						.getBeneficiaryPendingTransferInFilterByMonthCountDetails(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryPendingTransferInFilterByMonthCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Transfer-In");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryPendingTransferIn.setSeries(seriesList);
			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForBeneficiaryPendingTransferIn.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryPendingTransferInFilterDateCountDetails = new ArrayList<StatisticsProjection>();
					benificiaryPendingTransferInFilterDateCountDetails = artDashboardRepository
							.getBeneficiaryPendingTransferInFilterByDateCountDetails(
									dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryPendingTransferInFilterDateCountDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Transfer-In");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForBeneficiaryPendingTransferIn.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		widgets.add(widgetForBeneficiaryPendingTransferIn);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryTransferOutVsTransferInFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryTransferOutVsTransferIn = new ARTWidgets();
		widgetForBeneficiaryTransferOutVsTransferIn.setType("double-bar-chart");
		widgetForBeneficiaryTransferOutVsTransferIn.setChartTitle("Beneficiary Transfer Out vs Transfer In");
		widgetForBeneficiaryTransferOutVsTransferIn.setxAxisTitle("Dates");
		widgetForBeneficiaryTransferOutVsTransferIn.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryTransferOutVsTransferIn.setFilterType("date");
		widgetForBeneficiaryTransferOutVsTransferIn.setFilterName("BeneficiaryTranferInOut");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryTransferOutVsTransferIn.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				// TransferIn
				List<StatisticsProjection> benificiaryTransferInFilterCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryTransferInFilterCountDetails = artDashboardRepository
						.getBeneficiaryTransferInFilterCount(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> tranferInResult = new ArrayList<>();
				tranferInResult = setMonthWiseCounts(monthNames, benificiaryTransferInFilterCountDetails,
						tranferInResult);
				ARTSeries seriesForTransferIn = new ARTSeries();
				seriesForTransferIn.setName("Transfer-In");
				seriesForTransferIn.setData(tranferInResult);
				// TransferOut
				List<StatisticsProjection> benificiaryTransferOutFilterCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryTransferOutFilterCountDetails = artDashboardRepository
						.getBeneficiaryTransferOutFilterCount(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> tranferOutresult = new ArrayList<>();
				tranferOutresult = setMonthWiseCounts(monthNames, benificiaryTransferOutFilterCountDetails,
						tranferOutresult);
				ARTSeries seriesForTransferOut = new ARTSeries();
				seriesForTransferOut.setName("Transfer-Out");
				seriesForTransferOut.setData(tranferOutresult);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(seriesForTransferIn);
				seriesList.add(seriesForTransferOut);
				widgetForBeneficiaryTransferOutVsTransferIn.setSeries(seriesList);
			} else {

				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForBeneficiaryTransferOutVsTransferIn.setLabelsWithDatesCst(new ArrayList<String>(),
							numberOfDays, dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					// TransferIn
					List<StatisticsProjection> benificiaryTransferInFilterCountDetails = new ArrayList<StatisticsProjection>();
					benificiaryTransferInFilterCountDetails = artDashboardRepository
							.getBeneficiaryTransferInFilterCountByDate(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> tranferInResult = new ArrayList<>();
					tranferInResult = setDateWiseCounts(dates, benificiaryTransferInFilterCountDetails,
							tranferInResult);
					ARTSeries seriesForTransferIn = new ARTSeries();
					seriesForTransferIn.setName("Transfer-In");
					seriesForTransferIn.setData(tranferInResult);
					// TransferOut
					List<StatisticsProjection> benificiaryTransferOutFilterCountDetails = new ArrayList<StatisticsProjection>();
					benificiaryTransferOutFilterCountDetails = artDashboardRepository
							.getBeneficiaryTransferOutFilterCountByDate(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> tranferOutresult = new ArrayList<>();
					tranferInResult = setDateWiseCounts(dates, benificiaryTransferOutFilterCountDetails,
							tranferOutresult);
					ARTSeries seriesForTransferOut = new ARTSeries();
					seriesForTransferOut.setName("Transfer-Out");
					seriesForTransferOut.setData(tranferOutresult);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(seriesForTransferIn);
					seriesList.add(seriesForTransferOut);
					widgetForBeneficiaryTransferOutVsTransferIn.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		widgets.add(widgetForBeneficiaryTransferOutVsTransferIn);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryNewInitiationsFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {
		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryNewInitiations = new ARTWidgets();
		widgetForBeneficiaryNewInitiations.setType("single-bar-chart");
		widgetForBeneficiaryNewInitiations.setChartTitle("New Initiations");
		widgetForBeneficiaryNewInitiations.setxAxisTitle("Dates");
		widgetForBeneficiaryNewInitiations.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryNewInitiations.setFilterType("date");
		widgetForBeneficiaryNewInitiations.setFilterName("NewInitiations");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryNewInitiations.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryNewInitiationsFilterCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryNewInitiationsFilterCountDetails = artDashboardRepository
						.getBeneficiaryNewInitiationsCountDetailsForMonths(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryNewInitiationsFilterCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Initiations");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryNewInitiations.setSeries(seriesList);

			} else {
				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForBeneficiaryNewInitiations.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryNewInitiationsFilterCountDetailsForDays = new ArrayList<StatisticsProjection>();
					benificiaryNewInitiationsFilterCountDetailsForDays = artDashboardRepository
							.getBeneficiaryNewInitiationsCountDetailsForDates(dashboardRequestDto.getFacilityId(),
									dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryNewInitiationsFilterCountDetailsForDays, result);
					ARTSeries series = new ARTSeries();
					series.setName("Registrations");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForBeneficiaryNewInitiations.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		widgets.add(widgetForBeneficiaryNewInitiations);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryNewRegistrationsFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryNewRegistrations = new ARTWidgets();
		widgetForBeneficiaryNewRegistrations.setType("single-bar-chart");
		widgetForBeneficiaryNewRegistrations.setChartTitle("New Registrations");
		widgetForBeneficiaryNewRegistrations.setxAxisTitle("Dates");
		widgetForBeneficiaryNewRegistrations.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryNewRegistrations.setFilterType("date");
		widgetForBeneficiaryNewRegistrations.setFilterName("NewRegistrations");
		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {

			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {

				// query for months

				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryNewRegistrations.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryNewRegistrationsFilterCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryNewRegistrationsFilterCountDetails = artDashboardRepository
						.getBeneficiaryNewRegistrationsCountDetailsForMonths(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryNewRegistrationsFilterCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Registrations");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryNewRegistrations.setSeries(seriesList);

			} else {

				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForBeneficiaryNewRegistrations.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryNewRegistrationsFilterCountDetailsByDates = new ArrayList<StatisticsProjection>();
					benificiaryNewRegistrationsFilterCountDetailsByDates = artDashboardRepository
							.getBeneficiaryNewRegistrationsCountDetailsForDates(dashboardRequestDto.getFacilityId(),
									dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryNewRegistrationsFilterCountDetailsByDates, result);
					ARTSeries series = new ARTSeries();
					series.setName("Registrations");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForBeneficiaryNewRegistrations.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		widgets.add(widgetForBeneficiaryNewRegistrations);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto beneficiaryMissedAppointmentsFilterGraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryMissedAppointment = new ARTWidgets();
		widgetForBeneficiaryMissedAppointment.setType("single-bar-chart");
		widgetForBeneficiaryMissedAppointment.setChartTitle("Beneficiaries Missed Appointments");
		widgetForBeneficiaryMissedAppointment.setxAxisTitle("Dates");
		widgetForBeneficiaryMissedAppointment.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryMissedAppointment.setFilterType("date");
		widgetForBeneficiaryMissedAppointment.setFilterName("BeneficiaryMissedAppointment");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {

			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				// query for months

				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryMissedAppointment.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryMissedAppoinmentsFilterCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryMissedAppoinmentsFilterCountDetails = artDashboardRepository
						.getBenificiaryMissedAppoinmentsFilterCountDetails(dashboardRequestDto.getFacilityId(),
								dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryMissedAppoinmentsFilterCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Missed Appointments");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryMissedAppointment.setSeries(seriesList);

			} else {
				// query for dates

				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForBeneficiaryMissedAppointment.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryMissedAppoinmentsFilterCountDetails = new ArrayList<StatisticsProjection>();
					benificiaryMissedAppoinmentsFilterCountDetails = artDashboardRepository
							.getBenificiaryMissedAppoinmentsFilterByDateCountDetails(
									dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryMissedAppoinmentsFilterCountDetails, result);
					ARTSeries series = new ARTSeries();
					series.setName("Missed Appointments");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForBeneficiaryMissedAppointment.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForBeneficiaryMissedAppointment);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;
	}

	private ARTDashboardGraphsDto filteredFourPlusDetectedByCCGraph(@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForFourPlusDetectedByCcVisit = new ARTWidgets();
		widgetForFourPlusDetectedByCcVisit.setType("single-bar-chart");
		widgetForFourPlusDetectedByCcVisit.setChartTitle("4S+ Detected by CC");
		widgetForFourPlusDetectedByCcVisit.setxAxisTitle("Dates");
		widgetForFourPlusDetectedByCcVisit.setyAxisTitle("Number of Beneficiaries");
		widgetForFourPlusDetectedByCcVisit.setFilterType("date");
		widgetForFourPlusDetectedByCcVisit.setFilterName("4SCCDetected");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {

			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				// query for months

				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForFourPlusDetectedByCcVisit.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> fourPlusDetectedCountByCc = new ArrayList<StatisticsProjection>();
				fourPlusDetectedCountByCc = artDashboardRepository.getFourPlusDetectedCountByCcFilteredByMonth(
						dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, fourPlusDetectedCountByCc, result);
				ARTSeries series = new ARTSeries();
				series.setName("4S+");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForFourPlusDetectedByCcVisit.setSeries(seriesList);

			} else {
				// query for dates

				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForFourPlusDetectedByCcVisit.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryVisitCountDetailsForDateFilter = new ArrayList<StatisticsProjection>();
					benificiaryVisitCountDetailsForDateFilter = artDashboardRepository
							.getFourPlusDetectedCountByCcFilteredByDates(dashboardRequestDto.getFacilityId(), dateFrom,
									dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryVisitCountDetailsForDateFilter, result);
					ARTSeries series = new ARTSeries();
					series.setName("4S+");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForFourPlusDetectedByCcVisit.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForFourPlusDetectedByCcVisit);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;

	}

	private ARTDashboardGraphsDto createFilteredBeneficiaryVisitgraph(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryVisit = new ARTWidgets();
		widgetForBeneficiaryVisit.setType("single-bar-chart");
		widgetForBeneficiaryVisit.setChartTitle("Beneficiaries Visited");
		widgetForBeneficiaryVisit.setxAxisTitle("Dates");
		widgetForBeneficiaryVisit.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryVisit.setFilterType("date");
		widgetForBeneficiaryVisit.setFilterName("BeneficiaryVisited");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {

			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);
			Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
			Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
			if (numberOfDays > 12) {
				// query for months

				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryVisit.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryForVisitFilteredCountDetails = new ArrayList<StatisticsProjection>();
				benificiaryForVisitFilteredCountDetails = artDashboardRepository
						.getFilteredBenificiaryForVisit(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryForVisitFilteredCountDetails, result);
				ARTSeries series = new ARTSeries();
				series.setName("Persons");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryVisit.setSeries(seriesList);

			} else {
				// query for dates

				List<String> dates;
				try {
					dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					widgetForBeneficiaryVisit.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
							dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
					List<StatisticsProjection> benificiaryVisitCountDetailsForDateFilter = new ArrayList<StatisticsProjection>();
					benificiaryVisitCountDetailsForDateFilter = artDashboardRepository
							.getBenificiaryVisitDaysFilterList(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
					List<BigInteger> result = new ArrayList<>();
					result = setDateWiseCounts(dates, benificiaryVisitCountDetailsForDateFilter, result);
					ARTSeries series = new ARTSeries();
					series.setName("Persons");
					series.setData(result);
					List<ARTSeries> seriesList = new ArrayList<>();
					seriesList.add(series);
					widgetForBeneficiaryVisit.setSeries(seriesList);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		widgets.add(widgetForBeneficiaryVisit);
		artDashboardGraphsDto.setWidgets(widgets);
		return artDashboardGraphsDto;

	}

	private ARTDashboardGraphsDto createFilteredBeneficiaryDueForVisit(
			@Valid ARTDashboardRequestDTO dashboardRequestDto) throws ParseException {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		List<ARTWidgets> widgets = new ArrayList<ARTWidgets>();
		ARTWidgets widgetForBeneficiaryDueVisit = new ARTWidgets();
		widgetForBeneficiaryDueVisit.setType("single-bar-chart");
		widgetForBeneficiaryDueVisit.setChartTitle("Beneficiaries Due For Visit");
		widgetForBeneficiaryDueVisit.setxAxisTitle("Dates");
		widgetForBeneficiaryDueVisit.setyAxisTitle("Number of Beneficiaries");
		widgetForBeneficiaryDueVisit.setFilterType("date");
		widgetForBeneficiaryDueVisit.setFilterName("BeneficiaryDueForVisit");

		if (!dashboardRequestDto.getFromDate().equals(null) && !dashboardRequestDto.getToDate().equals(null)) {
			// List<Category> categoryForMonth = new ArrayList<Category>();
			// categoryForMonth = widgetForBeneficiaryDueVisit.setCategoriesForCst(new
			// ArrayList<Category>());

			Long dateDifference = getDateDifference(dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
			Long numberOfDays = TimeUnit.DAYS.convert(dateDifference, TimeUnit.MILLISECONDS);

			if (numberOfDays > 12) {
				// query for months
				Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
				Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
				List<String> monthNames = setFilterMonthNames(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryDueVisit.setLabelWithMonthInDuration(new ArrayList<String>(),
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryDueForVisitCountDetailsForFilter = new ArrayList<StatisticsProjection>();
				benificiaryDueForVisitCountDetailsForFilter = artDashboardRepository
						.getBenificiaryDueForVisitMonthFilterList(dashboardRequestDto.getFacilityId(), dateFrom,
								dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setMonthWiseCounts(monthNames, benificiaryDueForVisitCountDetailsForFilter, result);
				ARTSeries series = new ARTSeries();
				series.setName("Persons");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryDueVisit.setSeries(seriesList);

			} else {
				// query for dates
				Timestamp dateFrom = convertToTimestamp(dashboardRequestDto.getFromDate());
				Timestamp dateTo = convertToTimestamp(dashboardRequestDto.getToDate());
				List<String> dates = setDynamicListOfDates(dashboardRequestDto.getFromDate(),
						dashboardRequestDto.getToDate());
				widgetForBeneficiaryDueVisit.setLabelsWithDatesCst(new ArrayList<String>(), numberOfDays,
						dashboardRequestDto.getFromDate(), dashboardRequestDto.getToDate());
				List<StatisticsProjection> benificiaryDueForVisitCountDetailsForFilter = new ArrayList<StatisticsProjection>();
				benificiaryDueForVisitCountDetailsForFilter = artDashboardRepository
						.getBenificiaryDueForVisitDaysFilterList(dashboardRequestDto.getFacilityId(), dateFrom, dateTo);
				List<BigInteger> result = new ArrayList<>();
				result = setDateWiseCounts(dates, benificiaryDueForVisitCountDetailsForFilter, result);
				ARTSeries series = new ARTSeries();
				series.setName("Persons");
				series.setData(result);
				List<ARTSeries> seriesList = new ArrayList<>();
				seriesList.add(series);
				widgetForBeneficiaryDueVisit.setSeries(seriesList);

			}

			widgets.add(widgetForBeneficiaryDueVisit);
			artDashboardGraphsDto.setWidgets(widgets);
			return artDashboardGraphsDto;

		}
		return null;
	}

	private ARTDashboardGraphsDto ictcReferredBreakupWithFilters(@Valid ARTDashboardRequestDTO dashboardRequestDto,
			String filterName) {

		ARTDashboardGraphsDto artDashboardGraphsDto = new ARTDashboardGraphsDto();
		artDashboardGraphsDto.setTitle("Referred From ICTC");
		List<ARTWidgets> artWidgetsList = new ArrayList<ARTWidgets>();
		// Facility
		if ("FacilitywiseBreakup".equalsIgnoreCase(filterName)) {
			ARTWidgets widgetsForFacilityWise = new ARTWidgets();
			widgetsForFacilityWise.setType("pie-chart");
			widgetsForFacilityWise.setChartTitle("Facilitywise Breakup");
			widgetsForFacilityWise.setFilterType("multi-select");
			widgetsForFacilityWise.setFilterName("FacilitywiseBreakup");
			List<ARTSeries> artSeriesFacilities = new ArrayList<ARTSeries>();
			List<String> facilityNames = dashboardRequestDto.getItems();
			List<StatisticsProjection> facilitywiseBreakup = artDashboardRepository
					.facilitywiseBreakupUsingFilters(facilityNames);
			List<StatisticsProjection> sortedFacilities = sortValueByCountInDesc(facilitywiseBreakup);
			artSeriesFacilities = settingNameAndValue(sortedFacilities, artSeriesFacilities);
			// Others
			List<StatisticsProjection> facilitywiseBreakupOthers = artDashboardRepository
					.facilitywiseBreakupOthersUsingFilters(facilityNames);
			if (facilitywiseBreakupOthers.get(0).getValue().intValue() > 0) {
				artSeriesFacilities = settingNameAndValue(facilitywiseBreakupOthers, artSeriesFacilities);
			}
			widgetsForFacilityWise.setSeries(artSeriesFacilities);
			artWidgetsList.add(widgetsForFacilityWise);
		}
		// RiskFactor
		else if ("RiskFactorBreakup".equalsIgnoreCase(filterName)) {
			ARTWidgets widgetsForRiskFactors = new ARTWidgets();
			widgetsForRiskFactors.setType("pie-chart");
			widgetsForRiskFactors.setChartTitle("Breakup As Per Risk Factor");
			widgetsForRiskFactors.setFilterType("multi-select");
			widgetsForRiskFactors.setFilterName("RiskFactorBreakup");
			List<ARTSeries> artSeriesRiskFactors = new ArrayList<ARTSeries>();
			List<String> riskFactors = dashboardRequestDto.getItems();
			List<StatisticsProjection> riskFactorBreakup = artDashboardRepository
					.riskFactorBreakupUsingFilters(dashboardRequestDto.getFacilityId(), riskFactors);
			List<StatisticsProjection> sortedRiskFactors = sortValueByCountInDesc(riskFactorBreakup);
			artSeriesRiskFactors = settingNameAndValue(sortedRiskFactors, artSeriesRiskFactors);
			// Others
			List<StatisticsProjection> riskFactorBreakupOthers = artDashboardRepository
					.riskFactorBreakupOthersUsingFilters(dashboardRequestDto.getFacilityId(), riskFactors);
			if (riskFactorBreakupOthers.get(0).getValue().intValue() > 0) {
				artSeriesRiskFactors = settingNameAndValue(riskFactorBreakupOthers, artSeriesRiskFactors);
			}
			widgetsForRiskFactors.setSeries(artSeriesRiskFactors);
			artWidgetsList.add(widgetsForRiskFactors);
		}
		// EntryPoint
		else if ("EntryPointBreakup".equalsIgnoreCase(filterName)) {
			ARTWidgets widgetsForEntryPoint = new ARTWidgets();
			widgetsForEntryPoint.setType("pie-chart");
			widgetsForEntryPoint.setChartTitle("Breakup As Per Entry Point");
			widgetsForEntryPoint.setFilterType("multi-select");
			widgetsForEntryPoint.setFilterName("EntryPointBreakup");
			List<ARTSeries> artSeriesentryPoints = new ArrayList<ARTSeries>();
			List<String> entryPoints = dashboardRequestDto.getItems();
			List<StatisticsProjection> entryPointBreakup = artDashboardRepository
					.entryPointBreakupUsingFilters(dashboardRequestDto.getFacilityId(), entryPoints);
			List<StatisticsProjection> sortedEntryPoint = sortValueByCountInDesc(entryPointBreakup);
			artSeriesentryPoints = settingNameAndValue(sortedEntryPoint, artSeriesentryPoints);
			// Others
			List<StatisticsProjection> entryPointBreakupOthers = artDashboardRepository
					.entryPointBreakupOthersUsingFilters(dashboardRequestDto.getFacilityId(), entryPoints);
			if (entryPointBreakupOthers.get(0).getValue().intValue() > 0) {
				artSeriesentryPoints = settingNameAndValue(entryPointBreakupOthers, artSeriesentryPoints);
			}
			widgetsForEntryPoint.setSeries(artSeriesentryPoints);
			artWidgetsList.add(widgetsForEntryPoint);
		}
		// Occupation
		else if ("OccupationBreakup".equalsIgnoreCase(filterName)) {
			ARTWidgets widgetsForOccupation = new ARTWidgets();
			widgetsForOccupation.setType("pie-chart");
			widgetsForOccupation.setChartTitle("Breakup As Per Occupation");
			widgetsForOccupation.setFilterType("multi-select");
			widgetsForOccupation.setFilterName("OccupationBreakup");
			List<ARTSeries> artSeriesOccupations = new ArrayList<ARTSeries>();
			List<String> occupations = dashboardRequestDto.getItems();
			List<StatisticsProjection> occupationBreakup = artDashboardRepository
					.occupationBreakupUsingFilters(dashboardRequestDto.getFacilityId(), occupations);
			List<StatisticsProjection> sortedOccupation = sortValueByCountInDesc(occupationBreakup);
			artSeriesOccupations = settingNameAndValue(sortedOccupation, artSeriesOccupations);
			// Others
			List<StatisticsProjection> occupationBreakupOthers = artDashboardRepository
					.occupationBreakupOthersUsingFilters(dashboardRequestDto.getFacilityId(), occupations);
			if (occupationBreakupOthers.get(0).getValue().intValue() > 0) {
				artSeriesOccupations = settingNameAndValue(occupationBreakupOthers, artSeriesOccupations);
			}
			widgetsForOccupation.setSeries(artSeriesOccupations);
			artWidgetsList.add(widgetsForOccupation);
		}
		// for Education
		else if ("EducationBreakup".equalsIgnoreCase(filterName)) {
			ARTWidgets widgetsForEducation = new ARTWidgets();
			widgetsForEducation.setType("pie-chart");
			widgetsForEducation.setChartTitle("Breakup As Per Education");
			widgetsForEducation.setFilterType("multi-select");
			widgetsForEducation.setFilterName("EducationBreakup");
			List<ARTSeries> artSeriesEducations = new ArrayList<ARTSeries>();
			List<String> educations = dashboardRequestDto.getItems();
			List<StatisticsProjection> educationBreakup = artDashboardRepository
					.educationBreakupUsingFilters(dashboardRequestDto.getFacilityId(), educations);
			List<StatisticsProjection> sortedEducation = sortValueByCountInDesc(educationBreakup);
			artSeriesEducations = settingNameAndValue(sortedEducation, artSeriesEducations);
			// Others
			List<StatisticsProjection> educationBreakupOthers = artDashboardRepository
					.educationBreakupOthersUsingFilters(dashboardRequestDto.getFacilityId(), educations);
			if (educationBreakupOthers.get(0).getValue().intValue() > 0) {
				artSeriesEducations = settingNameAndValue(educationBreakupOthers, artSeriesEducations);
			}
			widgetsForEducation.setSeries(artSeriesEducations);
			artWidgetsList.add(widgetsForEducation);
		}
		// Salary
		else if ("SalaryBreakup".equalsIgnoreCase(filterName)) {
			ARTWidgets widgetsForSalary = new ARTWidgets();
			widgetsForSalary.setType("pie-chart");
			widgetsForSalary.setChartTitle("Breakup As Per Salary");
			widgetsForSalary.setFilterType("multi-select");
			widgetsForSalary.setFilterName("SalaryBreakup");
			List<ARTSeries> artSeriesSalaries = new ArrayList<ARTSeries>();
			List<String> salaries = dashboardRequestDto.getItems();
			List<StatisticsProjection> salaryBreakup = artDashboardRepository
					.salaryBreakupUsingFilters(dashboardRequestDto.getFacilityId(), salaries);
			List<StatisticsProjection> sortedSalary = sortValueByCountInDesc(salaryBreakup);
			artSeriesSalaries = settingNameAndValue(sortedSalary, artSeriesSalaries);
			// Others
			List<StatisticsProjection> salaryOthersBreakup = artDashboardRepository
					.salaryBreakupOthersUsingFilters(dashboardRequestDto.getFacilityId(), salaries);
			if (salaryOthersBreakup.get(0).getValue().intValue() > 0) {
				artSeriesSalaries = settingNameAndValue(salaryOthersBreakup, artSeriesSalaries);
			}
			widgetsForSalary.setSeries(artSeriesSalaries);
			artWidgetsList.add(widgetsForSalary);
		}

		artDashboardGraphsDto.setWidgets(artWidgetsList);
		return artDashboardGraphsDto;
	}

	private List<BigInteger> setDateWiseCounts(List<String> dates, List<StatisticsProjection> result,
			List<BigInteger> countValue) {

		for (String dt : dates) {
			Optional<StatisticsProjection> matchingDateDetails = result.stream()
					.filter(x -> x.getName().trim().equalsIgnoreCase(dt.trim())).findAny();
			if (matchingDateDetails.isPresent()) {
				countValue.add(matchingDateDetails.get().getValue());
			} else {
				countValue.add(BigInteger.valueOf(0l));
			}

		}
		// TODO Auto-generated method stub
		return countValue;
	}

	private Timestamp convertToTimestamp(String fromDate) {
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			// you can change format of date
			Date date = formatter.parse(fromDate);
			Timestamp timeStampDate = new Timestamp(date.getTime());
			return timeStampDate;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;
		}
	}

	private Long getDateDifference(String fromDate, String toDate) {
		SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
		long diff = 0L;
		try {
			Date date1 = myFormat.parse(fromDate);
			Date date2 = myFormat.parse(toDate);
			diff = date2.getTime() - date1.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diff;
	}

	public List<String> setFilterMonthNames(String dateFrom, String dateTo) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate fromDate = LocalDate.parse(dateFrom, formatter);
		LocalDate toDate = LocalDate.parse(dateTo, formatter);
		Period age = Period.between(fromDate, toDate);
		int months = age.getMonths();
		List<String> monthNames = new ArrayList<String>();

		monthNames.add(fromDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US));
		for (int i = 1; i <= months; i++) {
			LocalDate earlier = fromDate.plusMonths(i);
			monthNames.add(earlier.getMonth().getDisplayName(TextStyle.FULL, Locale.US));
		}

		return monthNames;

	}

	public List<String> setDynamicListOfDates(String dateFrom, String dateTo) throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate start = LocalDate.parse(dateFrom, formatter);
		LocalDate end = LocalDate.parse(dateTo, formatter);
		List<String> dates = new ArrayList<String>();
		while (!start.isAfter(end)) {
			dates.add(start.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			start = start.plusDays(1);
		}
		return dates;
	}

	private List<StatisticsProjection> sortValueByCountInDesc(List<StatisticsProjection> projectionList) {
		projectionList.sort((p1, p2) -> p2.getValue().compareTo(p1.getValue())); // sort value in desc order
		List<StatisticsProjection> first5Value = new ArrayList<StatisticsProjection>();
		for (StatisticsProjection projection : projectionList) {
			if (first5Value.size() < 5) { // to add first 5 elements after sort
				first5Value.add(projection);
			}
		}
		return first5Value;
	}

	private int sumOfOthers(List<StatisticsProjection> projectionList) {
		int sum = 0;
		projectionList.sort((f1, f2) -> f2.getValue().compareTo(f1.getValue())); // sort values in desc order
		if (projectionList.size() > 5) { // sum is needed only if the list has more than 5 elements
			List<StatisticsProjection> first5Value = new ArrayList<StatisticsProjection>();
			for (StatisticsProjection projection : projectionList) {
				if (first5Value.size() < 5) { // adding the first 5 elements after sort
					first5Value.add(projection);
				} else {
					sum = sum + projection.getValue().intValue(); // sum of rest of the values and assign it to Others
				}
			}
		}
		return sum;
	}

	private List<ARTSeries> settingNameAndValue(List<StatisticsProjection> projectionList,
			List<ARTSeries> artSeriesList) {
		for (StatisticsProjection val : projectionList) {
			ARTSeries artSeries = new ARTSeries();
			artSeries.setName(val.getName());
			val.getValue();
			List<BigInteger> value = new ArrayList<BigInteger>();
			value.add(val.getValue());
			artSeries.setData(value);
			artSeriesList.add(artSeries);
		}
		return artSeriesList;
	}

	private List<ARTSeries> setSumToValueForOthers(int sum, List<ARTSeries> artSeriesList) {
		ARTSeries artSeries = new ARTSeries();
		artSeries.setName("Others");
		BigInteger sumB = BigInteger.valueOf(sum); // converted to BigInteger
		List<BigInteger> value = new ArrayList<BigInteger>();
		value.add(sumB);
		artSeries.setData(value);
		artSeriesList.add(artSeries);
		return artSeriesList;
	}

}
