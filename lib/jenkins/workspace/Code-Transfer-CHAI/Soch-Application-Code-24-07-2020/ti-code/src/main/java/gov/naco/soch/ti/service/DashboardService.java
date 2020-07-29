package gov.naco.soch.ti.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.constructordto.SummaryDto;
import gov.naco.soch.dto.Category;
import gov.naco.soch.dto.DashboardRequestDto;
import gov.naco.soch.dto.Series;
import gov.naco.soch.projection.FacilityTargetProjection;
import gov.naco.soch.projection.InventoryProjection;
import gov.naco.soch.projection.StatisticsProjection;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.ti.dto.DashBoardResponseDto;
import gov.naco.soch.ti.dto.DashboardGraphsDto;
import gov.naco.soch.ti.dto.Filters;
import gov.naco.soch.ti.dto.Widgets;

@Service
@Transactional
public class DashboardService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	public DashBoardResponseDto getData(DashboardRequestDto dashboardRequestDto) {

		DashBoardResponseDto dashBoardResponseDto = new DashBoardResponseDto();

		SummaryDto summary = beneficiaryRepository.getSummaryDashboardDetails(dashboardRequestDto.getFacilityId());
		List<DashboardGraphsDto> categoriesList = new ArrayList<DashboardGraphsDto>();
		categoriesList.add(createGeneralInformationGraph(dashboardRequestDto));
		categoriesList.add(createHIVTestingAndTreatmentInformationGraph(dashboardRequestDto));
		categoriesList.add(createStiInformationGraph(dashboardRequestDto));
		categoriesList.add(createCommoditiesGraph(dashboardRequestDto));
		categoriesList.add(createInventory(dashboardRequestDto));
		categoriesList.add(createCounsellingTable(dashboardRequestDto));
		dashBoardResponseDto.setSummary(summary);
		dashBoardResponseDto.setCategories(categoriesList);
		return dashBoardResponseDto;

	}

	public DashBoardResponseDto getDataForSummary(DashboardRequestDto dashboardRequestDto) {
		DashBoardResponseDto dashBoardResponseDto = new DashBoardResponseDto();
		SummaryDto summary = beneficiaryRepository.getSummaryDashboardDetails(dashboardRequestDto.getFacilityId());
		dashBoardResponseDto.setSummary(summary);
		return dashBoardResponseDto;
	}

	private DashboardGraphsDto createCounsellingTable(DashboardRequestDto dashboardRequestDto) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		List<StatisticsProjection> HRGSCounselledThisMonth = new ArrayList<StatisticsProjection>();
		List<Widgets> widgetList = new ArrayList<>();
		Widgets widgets = new Widgets();
		widgets.setType("full-width-table");

		List<Series> seriesList = new ArrayList<>();
		Series series1 = new Series();
		series1.setName("HRGS Counselled");
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			HRGSCounselledThisMonth = beneficiaryRepository.getHRGSCounselled(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			HRGSCounselledThisMonth = beneficiaryRepository.getHRGSCounselledByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			HRGSCounselledThisMonth = beneficiaryRepository
					.getHRGSCounselledByGender(dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			HRGSCounselledThisMonth = beneficiaryRepository.getHRGSCounselledByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}

		List<BigInteger> datalist = new ArrayList<BigInteger>();
		if (HRGSCounselledThisMonth.size() > 0) {
			datalist.add(HRGSCounselledThisMonth.get(0).getValue());
		} else {
			datalist.add(new BigInteger("0"));
		}
		series1.setData(datalist);
		Series series2 = new Series();
		series2.setName("Total contact this month");
		List<StatisticsProjection> totalContactThisMonth = new ArrayList<StatisticsProjection>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			totalContactThisMonth = beneficiaryRepository.getTotalContact(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			totalContactThisMonth = beneficiaryRepository.getTotalContactByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			totalContactThisMonth = beneficiaryRepository.getTotalContactByGender(dashboardRequestDto.getFacilityId(),
					dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			totalContactThisMonth = beneficiaryRepository.getTotalContactByTypology(dashboardRequestDto.getFacilityId(),
					dashboardRequestDto.getTypology());
		}
		List<BigInteger> datalist2 = new ArrayList<BigInteger>();
		if (totalContactThisMonth.size() > 0) {
			datalist2.add(totalContactThisMonth.get(0).getValue());
		} else {
			datalist2.add(new BigInteger("0"));
		}
		series2.setData(datalist2);
		Series series3 = new Series();
		List<StatisticsProjection> oneToOneThisMonth = new ArrayList<StatisticsProjection>();
		series3.setName("1-1 contact This month");
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			oneToOneThisMonth = beneficiaryRepository.getOneToOneContact(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			oneToOneThisMonth = beneficiaryRepository.getOneToOneContactByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			oneToOneThisMonth = beneficiaryRepository.getOneToOneContactByGender(dashboardRequestDto.getFacilityId(),
					dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			oneToOneThisMonth = beneficiaryRepository.getOneToOneContactByTypology(dashboardRequestDto.getFacilityId(),
					dashboardRequestDto.getTypology());
		}

		List<BigInteger> datalist3 = new ArrayList<BigInteger>();
		if (oneToOneThisMonth.size() > 0) {
			datalist3.add(oneToOneThisMonth.get(0).getValue());
		} else {
			datalist3.add(new BigInteger("0"));
		}
		series3.setData(datalist3);
		seriesList.add(series1);
		seriesList.add(series2);
		seriesList.add(series3);
		widgets.setSeries(seriesList);
		widgetList.add(widgets);
		dashboardGraphsDto.setWidgets(widgetList);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto createInventory(DashboardRequestDto dashboardRequestDto) {

		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		dashboardGraphsDto.setTitle("Inventory");
		List<Widgets> widgetList = new ArrayList<>();
		Widgets widgets = new Widgets();
		widgets.setType("inventory-table");
		List<Series> seriesList = new ArrayList<>();
		InventoryProjection condomInventoryDetails = beneficiaryRepository
				.getCondomInventoryDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> condomCount = new ArrayList<>();
		int noOfMonthsOfCondomInventory = 0;
		if (condomInventoryDetails.getAverageCount().intValue() > 0) {
			noOfMonthsOfCondomInventory = condomInventoryDetails.getTotalQuantity().intValue()
					/ condomInventoryDetails.getAverageCount().intValue();
		} else {
			noOfMonthsOfCondomInventory = -1;
		}
		condomCount.add(condomInventoryDetails.getTotalQuantity());
		condomCount.add(BigInteger.valueOf(noOfMonthsOfCondomInventory));
		Series series1 = new Series();
		series1.setName("CONDOMS");
		series1.setData(condomCount);

		InventoryProjection hivInventoryDetails = beneficiaryRepository
				.getHivInventoryDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> hivCount = new ArrayList<BigInteger>();
		int noOfMonthsOfHivInventory = 0;
		if (hivInventoryDetails.getAverageCount().intValue() > 0) {
			noOfMonthsOfHivInventory = hivInventoryDetails.getTotalQuantity().intValue()
					/ hivInventoryDetails.getAverageCount().intValue();
		} else {
			noOfMonthsOfHivInventory = -1;
		}
		hivCount.add(hivInventoryDetails.getTotalQuantity());
		hivCount.add(BigInteger.valueOf(noOfMonthsOfHivInventory));
		Series series2 = new Series();
		series2.setName("HIV KITS");
		series2.setData(hivCount);

		InventoryProjection needleInventoryDetails = beneficiaryRepository
				.getNeedleInventoryDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> needleCount = new ArrayList<BigInteger>();
		int noOfMonthsOfNeedleInventory = 0;
		if (needleInventoryDetails.getAverageCount().intValue() > 0) {
			noOfMonthsOfNeedleInventory = needleInventoryDetails.getTotalQuantity().intValue()
					/ needleInventoryDetails.getAverageCount().intValue();
		} else {
			noOfMonthsOfNeedleInventory = -1;
		}
		needleCount.add(needleInventoryDetails.getTotalQuantity());
		needleCount.add(BigInteger.valueOf(noOfMonthsOfNeedleInventory));
		Series series3 = new Series();
		series3.setName("NEEDLES");
		series3.setData(needleCount);

		seriesList.add(series1);
		seriesList.add(series2);
		seriesList.add(series3);
		widgets.setSeries(seriesList);
		widgetList.add(widgets);
		dashboardGraphsDto.setWidgets(widgetList);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto createCommoditiesGraph(DashboardRequestDto dashboardRequestDto) {
		// TODO Auto-generated method stub
		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		dashboardGraphsDto.setTitle("Commodities");
		Widgets widgets = new Widgets();
		widgets.setType("double-bar-chart");
		widgets.setChartTitle("Commodities");
		widgets.setxAxisTitle("Months");
		widgets.setyAxisTitle("No of commodities");
		widgets.setLabelForTI(new ArrayList<>());

		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgets.setCategoriesForTI(categoryForMonth);
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());

		List<StatisticsProjection> monthwiseCondomsDistributed = beneficiaryRepository
				.getMonthWiseCondomsDistributed(dashboardRequestDto.getFacilityId());
		List<BigInteger> monthlyDistributedCondoms = new ArrayList<>();
		monthlyDistributedCondoms = setMonthWiseCounts(monthNames, monthwiseCondomsDistributed,
				monthlyDistributedCondoms);

		List<StatisticsProjection> monthwiseNeedlesDistributed = beneficiaryRepository
				.getMonthWiseNeedlesDistributed(dashboardRequestDto.getFacilityId());
		List<BigInteger> monthlyDistributedNeedles = new ArrayList<>();
		monthlyDistributedNeedles = setMonthWiseCounts(monthNames, monthwiseNeedlesDistributed,
				monthlyDistributedNeedles);

		List<StatisticsProjection> monthwiseCondomsDemand = beneficiaryRepository
				.getMonthwiseCondomDemand(dashboardRequestDto.getFacilityId());
		List<BigInteger> monthlyDemandCondoms = new ArrayList<>();
		monthlyDemandCondoms = setMonthWiseCounts(monthNames, monthwiseCondomsDemand, monthlyDemandCondoms);

		List<StatisticsProjection> monthwiseNeedlesDemand = beneficiaryRepository
				.getMonthwiseNeedlesDemand(dashboardRequestDto.getFacilityId());
		List<BigInteger> monthlyDemandNeedles = new ArrayList<>();
		monthlyDemandNeedles = setMonthWiseCounts(monthNames, monthwiseNeedlesDemand, monthlyDemandNeedles);

		Series series1 = new Series();
		series1.setName("Condoms");
		series1.setData(monthlyDemandCondoms);
		Series series2 = new Series();
		series2.setName("Needle & Syringes");
		series2.setData(monthlyDemandNeedles);
		List<Series> serieslist = new ArrayList<>();
		serieslist.add(series1);
		serieslist.add(series2);
		widgets.setSeries(serieslist);

		Filters filters1 = new Filters();
		Series seriesfilter1 = new Series();
		Series seriesfilter2 = new Series();
		List<Series> seriesFilterList = new ArrayList<>();
		filters1.setName("Demand");
		seriesfilter1.setName("Condoms");
		seriesfilter1.setData(monthlyDemandCondoms);
		seriesfilter2.setName("Needle & Syringes");
		seriesfilter2.setData(monthlyDemandNeedles);
		seriesFilterList.add(seriesfilter1);
		seriesFilterList.add(seriesfilter2);
		filters1.setSeries(seriesFilterList);

		Filters filters2 = new Filters();
		Series seriesfilter3 = new Series();
		Series seriesfilter4 = new Series();
		List<Series> seriesFilterList2 = new ArrayList<>();
		filters2.setName("Distributed");
		seriesfilter3.setName("Condoms");
		seriesfilter3.setData(monthlyDistributedCondoms);
		seriesfilter4.setName("Needle & Syringes");
		seriesfilter4.setData(monthlyDistributedNeedles);
		seriesFilterList2.add(seriesfilter3);
		seriesFilterList2.add(seriesfilter4);
		filters2.setSeries(seriesFilterList2);

		List<Filters> filterlist = new ArrayList<>();
		filterlist.add(filters1);
		filterlist.add(filters2);
		widgets.setFilters(filterlist);
		List<Widgets> widgetslist = new ArrayList<>();
		widgetslist.add(widgets);
		dashboardGraphsDto.setWidgets(widgetslist);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto createStiInformationGraph(DashboardRequestDto dashboardRequestDto) {
		// TODO Auto-generated method stub
		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		List<Widgets> widgets = new ArrayList<Widgets>();
		dashboardGraph.setTitle("STI Information");
		// Widget1 details

		Widgets widget1 = new Widgets();
		widget1.setType("double-bar-chart");
		widget1.setChartTitle("Syphilis Tested");
		widget1.setxAxisTitle("Months");
		widget1.setyAxisTitle("Number of Beneficiaries");
		widget1.setLabelForTI(new ArrayList<String>());
		List<Series> series = new ArrayList<>();
		Series series1 = new Series();
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widget1.setCategoriesForTI(categoryForMonth);
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> monthWiseTreatedCountDetails = new ArrayList<>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseTreatedCountDetails = beneficiaryRepository
					.getMonthwiseTestingCount(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseTreatedCountDetails = beneficiaryRepository.getMonthwiseTreatedCountByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());

		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseTreatedCountDetails = beneficiaryRepository.getMonthwiseTreatedCountByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseTreatedCountDetails = beneficiaryRepository.getMonthwiseTreatedCountByTopology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());

		}

		List<BigInteger> treatedCounts = new ArrayList<>();
		treatedCounts = setMonthWiseCounts(monthNames, monthWiseTreatedCountDetails, treatedCounts);
		series1.setName("Tested");
		series1.setData(treatedCounts);
		series.add(series1);

		widget1.setSeries(series);
		widgets.add(widget1);

		// Widget2 detail

		Widgets widget2 = new Widgets();
		widget2.setType("double-bar-chart");
		widget2.setChartTitle("STI Detected");
		widget2.setxAxisTitle("Months");
		widget2.setyAxisTitle("Number of Beneficiaries");
		widget2.setLabelForTI(new ArrayList<String>());
		List<Series> seriesForSecdGraph = new ArrayList<>();
		Series seriesForSecdGraph1 = new Series();
		seriesForSecdGraph1.setName("Detected");

		List<StatisticsProjection> monthWiseDDetectedCount = new ArrayList<>();

		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseDDetectedCount = beneficiaryRepository
					.getMonthwiseDetectedCount(dashboardRequestDto.getFacilityId());

		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseDDetectedCount = beneficiaryRepository.getMonthwiseDetectedCountByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());

		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseDDetectedCount = beneficiaryRepository.getMonthwiseDetectedCountByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());

		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseDDetectedCount = beneficiaryRepository.getMonthwiseDetectedCountByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());

		}
		List<BigInteger> detectedCounts = new ArrayList<>();
		detectedCounts = setMonthWiseCounts(monthNames, monthWiseDDetectedCount, detectedCounts);

		seriesForSecdGraph1.setData(detectedCounts);
		seriesForSecdGraph.add(seriesForSecdGraph1);
		widget2.setSeries(seriesForSecdGraph);
		widgets.add(widget2);

		Widgets widget3 = new Widgets();
		widget3.setType("table");
		widget3.setLabelForTI(new ArrayList<String>());
		List<Series> syphilisSeries = new ArrayList<>();
		Series seariesFotTable = new Series();
		seariesFotTable.setName("Reactive");
		List<StatisticsProjection> monthWiseSyphilisReactiveCount = new ArrayList<>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseSyphilisReactiveCount = beneficiaryRepository
					.getMonthwiseSyphilisReactiveCount(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseSyphilisReactiveCount = beneficiaryRepository.getMonthwiseSyphilisReactiveCountByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseSyphilisReactiveCount = beneficiaryRepository.getMonthwiseSyphilisReactiveCountByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseSyphilisReactiveCount = beneficiaryRepository.getMonthwiseSyphilisReactiveCountByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}
		List<BigInteger> reactiveCount = new ArrayList<>();
		reactiveCount = setMonthWiseCounts(monthNames, monthWiseSyphilisReactiveCount, reactiveCount);
		seariesFotTable.setData(reactiveCount);
		syphilisSeries.add(seariesFotTable);
		widget3.setSeries(syphilisSeries);
		widgets.add(widget3);
		dashboardGraph.setWidgets(widgets);
		return dashboardGraph;
	}

	private DashboardGraphsDto createHIVTestingAndTreatmentInformationGraph(DashboardRequestDto dashboardRequestDto) {
		// TODO Auto-generated method stub
		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		dashboardGraphsDto.setTitle("HIV Testing & Treatment Information");
		List<Widgets> widgetlist = new ArrayList<Widgets>();

		Widgets widgets1 = new Widgets();
		widgets1.setType("double-bar-chart");
		widgets1.setChartTitle("Target Vs Tested");
		widgets1.setxAxisTitle("Months");
		widgets1.setyAxisTitle("Number of Beneficiaries");
		widgets1.setLabelForTI(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgets1.setCategoriesForTI(categoryForMonth);
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		// List<StatisticsProjection> monthwiseMonthlyTarget =
		// beneficiaryRepository.getMonthwiseMonthlyTarget(dashboardRequestDto.getFacilityId());
		// getMonthlyActiveTargetByFacilityIdAndTypology
		FacilityTargetProjection facilitytargetObject = null;
		if (dashboardRequestDto.getTypology().isEmpty()) {
			facilitytargetObject = beneficiaryRepository
					.getMonthlyActiveTargetByFacilityId(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getTypology().isEmpty()) {
			facilitytargetObject = beneficiaryRepository.getMonthlyActiveTargetByFacilityIdAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());

		}
		Integer monthlyTarget = 0;
		int month = -1;
		int endMonth = 0;
		int endyear = 0;
		try {
			if (facilitytargetObject != null) {
				month = facilitytargetObject.getMonth();
				endMonth = facilitytargetObject.getEndMonth();
				int year = facilitytargetObject.getYear();
				endyear = facilitytargetObject.getEndYear();
				Date today = new Date();
				Calendar todaysDate = Calendar.getInstance();
				todaysDate.setTime(today);
				int getCurrentYear = todaysDate.get(Calendar.YEAR);
				if (getCurrentYear != year) {
					month = -1;
				}
				endMonth = (endyear == year && endMonth >= month) ? endMonth : 12;

				monthlyTarget = facilitytargetObject.getTargets();
			}
		} catch (Exception e) {
			monthlyTarget = 0;
		}

		List<BigInteger> targetList = setDataForMonthlyTarget(monthlyTarget, month, endMonth);

		List<StatisticsProjection> monthwiseHivTested = new ArrayList<StatisticsProjection>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivTested = beneficiaryRepository.getMonthwiseHivTested(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivTested = beneficiaryRepository.getMonthwiseHivTestedByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivTested = beneficiaryRepository.getMonthwiseHivTestedByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivTested = beneficiaryRepository.getMonthwiseHivTestedByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}

		List<BigInteger> monthlyHivTested = new ArrayList<>();
		monthlyHivTested = setMonthWiseCounts(monthNames, monthwiseHivTested, monthlyHivTested);

		List<StatisticsProjection> monthwiseHivreactive = new ArrayList<StatisticsProjection>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivreactive = beneficiaryRepository.getMonthwiseHivReactive(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivreactive = beneficiaryRepository.getMonthwiseHivReactiveByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivreactive = beneficiaryRepository.getMonthwiseHivReactiveByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivreactive = beneficiaryRepository.getMonthwiseHivReactiveByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}

		List<BigInteger> monthlyHivreactive = new ArrayList<>();
		monthlyHivreactive = setMonthWiseCounts(monthNames, monthwiseHivreactive, monthlyHivreactive);
		List<StatisticsProjection> monthwiseHivlinkage = new ArrayList<StatisticsProjection>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivlinkage = beneficiaryRepository.getMonthwiseHivLinked(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivlinkage = beneficiaryRepository.getMonthwiseHivLinkedByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivreactive = beneficiaryRepository.getMonthwiseHivLinkedByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthwiseHivlinkage = beneficiaryRepository.getMonthwiseHivLinkedByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}
		List<BigInteger> monthlyHivLinked = new ArrayList<BigInteger>(); // hardcoding
		monthlyHivLinked = setMonthWiseCounts(monthNames, monthwiseHivlinkage, monthlyHivLinked);
		Series series1 = new Series();
		series1.setName("Target");
		series1.setData(targetList);
		Series series2 = new Series();
		series2.setName("Tested");
		series2.setData(monthlyHivTested);
		List<Series> serieslist = new ArrayList<Series>();
		serieslist.add(series1);
		serieslist.add(series2);
		widgets1.setSeries(serieslist);

		Widgets widgets2 = new Widgets();
		widgets2.setType("double-bar-chart");
		widgets2.setChartTitle("Reactive Vs Linked");
		widgets2.setxAxisTitle("Months");
		widgets2.setyAxisTitle("Number of Beneficiaries");
		widgets2.setLabelForTI(new ArrayList<String>());
		Series series3 = new Series();
		series3.setName("Reactive");
		series3.setData(monthlyHivreactive);
		Series series4 = new Series();
		series4.setName("Linked");
		series4.setData(monthlyHivLinked);
		List<Series> serieslist2 = new ArrayList<Series>();
		serieslist2.add(series3);
		serieslist2.add(series4);
		widgets2.setSeries(serieslist2);

		Widgets widgets3 = new Widgets();
		widgets3.setType("table");
		widgets3.setChartTitle("");
		widgets3.setLabelForTI(new ArrayList<>());
		Series series5 = new Series();
		series5.setName("HIV Tested");
		series5.setData(monthlyHivTested);
		Series series6 = new Series();
		series6.setName("Reactive");
		series6.setData(monthlyHivreactive);
		Series series7 = new Series();
		series7.setName("Linked");
		series7.setData(monthlyHivLinked);
		List<Series> serieslist3 = new ArrayList<Series>();
		serieslist3.add(series5);
		serieslist3.add(series6);
		serieslist3.add(series7);
		widgets3.setSeries(serieslist3);

		// pie-chart
		Widgets widgets4 = new Widgets();
		widgets4.setType("pie-chart");
		widgets4.setChartTitle("Registered PLHIV on ART");
		widgets4.setxAxisTitle("count");

		List<StatisticsProjection> artBenStatusList = new ArrayList<StatisticsProjection>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			artBenStatusList = beneficiaryRepository.getArtBeneficiaryStatusFromTI(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			artBenStatusList = beneficiaryRepository.getArtBeneficiaryStatusFromTIByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			artBenStatusList = beneficiaryRepository.getArtBeneficiaryStatusFromTIByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			artBenStatusList = beneficiaryRepository.getArtBeneficiaryStatusFromTIByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}
		List<Series> artBenStatusSeriesList = new ArrayList<Series>();
		try {

			if (artBenStatusList != null && !artBenStatusList.isEmpty()) {
				for (int i = 0; i < artBenStatusList.size(); i++) {
					Series series = new Series();
					series.setName(artBenStatusList.get(i).getName());
					List<BigInteger> artStatuslist = new ArrayList<>();
					artStatuslist.add(artBenStatusList.get(i).getValue());
					series.setData(artStatuslist);
					artBenStatusSeriesList.add(series);
				}
			}

		} catch (Exception e) {
		}

		widgets4.setSeries(artBenStatusSeriesList);

		widgetlist.add(widgets1);
		widgetlist.add(widgets2);
		widgetlist.add(widgets3);
		widgetlist.add(widgets4);
		dashboardGraphsDto.setWidgets(widgetlist);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto createGeneralInformationGraph(DashboardRequestDto dashboardRequestDto) {
		// TODO Auto-generated method stub
		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		dashboardGraph.setTitle("General Information");
		// Widget1 details

		List<Widgets> widgets = new ArrayList<Widgets>();
		Widgets widget1 = new Widgets();
		widget1.setType("double-bar-chart");
		widget1.setChartTitle("Target Vs Active");
		widget1.setxAxisTitle("Months");
		widget1.setyAxisTitle("Number of Beneficiaries");
		widget1.setLabelForTI(new ArrayList<String>());
		List<Series> series = new ArrayList<>();
		Series series1 = new Series();
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widget1.setCategoriesForTI(categoryForMonth);
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());
		List<StatisticsProjection> monthWiseActiveCountDetails = new ArrayList<StatisticsProjection>();

		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseActiveCountDetails = beneficiaryRepository
					.getMonthwiseActiveCount(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseActiveCountDetails = beneficiaryRepository.getMonthwiseActiveCountByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseActiveCountDetails = beneficiaryRepository.getMonthwiseActiveCountByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseActiveCountDetails = beneficiaryRepository.getMonthwiseActiveCountByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}
		List<BigInteger> activeCounts = new ArrayList<>();
		activeCounts = setMonthWiseCounts(monthNames, monthWiseActiveCountDetails, activeCounts);
		series1.setName("Active");
		series1.setData(activeCounts);
		series.add(series1);
		Series series2 = new Series();
		series2.setName("Target");
		// getMonthlyActiveTargetByFacilityIdAndTypology
		FacilityTargetProjection facilitytargetObject = null;
		if (dashboardRequestDto.getTypology().isEmpty()) {
			facilitytargetObject = beneficiaryRepository
					.getMonthlyActiveTargetByFacilityId(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getTypology().isEmpty()) {
			facilitytargetObject = beneficiaryRepository.getMonthlyActiveTargetByFacilityIdAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());

		}

		Integer monthlyTarget = 0;
		int month = -1;
		int endMonth = 0;
		int endyear = 0;
		int year = 0;
		try {
			if (facilitytargetObject != null) {
				month = facilitytargetObject.getMonth();
				endMonth = facilitytargetObject.getEndMonth();
				endyear = facilitytargetObject.getEndYear();
				year = facilitytargetObject.getYear();
				Date today = new Date();
				Calendar todaysDate = Calendar.getInstance();
				todaysDate.setTime(today);
				int getCurrentYear = todaysDate.get(Calendar.YEAR);
				if (getCurrentYear != year) {
					month = -1;
				}
				endMonth = (endyear == year && endMonth >= month) ? endMonth : 12;
				monthlyTarget = facilitytargetObject.getTargets();
			}
		} catch (Exception e) {
			monthlyTarget = 0;
		}

		List<BigInteger> targetList = setDataForMonthlyTarget(monthlyTarget, month, endMonth);
		series2.setData(targetList);
		series.add(series2);
		widget1.setSeries(series);
		widgets.add(widget1);

		// Widget2 detail

		Widgets widget2 = new Widgets();
		widget2.setType("table");
		widget2.setLabelForTI(new ArrayList<>());
		List<Series> seriesForTable = new ArrayList<>();
		Series seriesForTable1 = new Series();
		Series seriesForTable2 = new Series();
		Series seriesForTable3 = new Series();
		
		String yearName =  String.valueOf(year);
		String monthName = getMonth(month);

		seriesForTable1.setName("New Reg"+"_"+yearName+"_"+monthName);
		seriesForTable2.setName("DropOuts");
		seriesForTable3.setName("Target Achieved (%)");

		List<StatisticsProjection> monthWiseNewRegistrationount = new ArrayList<>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseNewRegistrationount = beneficiaryRepository
					.getMonthwiseRegistrationCount(dashboardRequestDto.getFacilityId());

		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseNewRegistrationount = beneficiaryRepository.getMonthwiseRegistrationCountByGenderAndTopology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseNewRegistrationount = beneficiaryRepository.getMonthwiseRegistrationCountByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		} else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseNewRegistrationount = beneficiaryRepository.getMonthwiseRegistrationCountByTopology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}
		List<BigInteger> newRegCounts = new ArrayList<>();
		newRegCounts = setMonthWiseCounts(monthNames, monthWiseNewRegistrationount, newRegCounts);
		seriesForTable1.setData(newRegCounts);

		List<StatisticsProjection> monthWiseDropoutCount = new ArrayList<>();
		if (dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {
			monthWiseDropoutCount = beneficiaryRepository.getMonthwiseDropoutCount(dashboardRequestDto.getFacilityId());
		} else if (!dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseDropoutCount = beneficiaryRepository.getMonthwiseDropoutCountByGenderAndTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender(),
					dashboardRequestDto.getTypology());
		} else if (!dashboardRequestDto.getGender().isEmpty() && dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseDropoutCount = beneficiaryRepository.getMonthwiseDropoutCountByGender(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getGender());
		}

		else if (dashboardRequestDto.getGender().isEmpty() && !dashboardRequestDto.getTypology().isEmpty()) {

			monthWiseDropoutCount = beneficiaryRepository.getMonthwiseDropoutCountByTypology(
					dashboardRequestDto.getFacilityId(), dashboardRequestDto.getTypology());
		}
		List<BigInteger> dropoutCounts = new ArrayList<>();
		dropoutCounts = setMonthWiseCounts(monthNames, monthWiseDropoutCount, dropoutCounts);

		seriesForTable2.setData(dropoutCounts);
		List<BigInteger> targetAchieved = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			if (targetList.get(i) != BigInteger.valueOf(0) && targetList.get(i) != null) {
				Double result = new Double(0.0);
				result = ((Double.valueOf(newRegCounts.get(i).toString())
						/ (Double.valueOf(targetList.get(i).toString()))) * (Double.valueOf(100)));
				BigInteger k = BigDecimal.valueOf(result).toBigInteger();
				targetAchieved.add(k);
			} else {
				targetAchieved.add(BigInteger.valueOf(0));
			}
		}
		seriesForTable3.setData(targetAchieved);
		seriesForTable.add(seriesForTable1);
		seriesForTable.add(seriesForTable2);
		seriesForTable.add(seriesForTable3);
		widget2.setSeries(seriesForTable);
		widgets.add(widget2);
		dashboardGraph.setWidgets(widgets);
		return dashboardGraph;
	}

	private List<BigInteger> setDataForMonthlyTarget(Integer monthlyTarget, int facilityCreatedDateIndex,
			int endIndex) {
		List<BigInteger> targetList = new ArrayList<>();
		facilityCreatedDateIndex = facilityCreatedDateIndex == -1 ? 0 : facilityCreatedDateIndex - 1;
		if (null != monthlyTarget) {
			for (int i = 0; i < 12; i++) {
				if (i >= facilityCreatedDateIndex && i < endIndex) {
					targetList.add(BigInteger.valueOf(monthlyTarget));
				} else {
					targetList.add(BigInteger.valueOf(0));
				}

			}
		} else {
			for (int i = 0; i < 12; i++) {

				targetList.add(BigInteger.valueOf(0));
			}
		}
		return targetList;
	}

	private List<BigInteger> setMonthWiseCounts(List<String> monthNames,
			List<StatisticsProjection> monthWiseRegistrationCountDetails, List<BigInteger> registrationCounts) {
		for (String monthName : monthNames) {
			switch (monthName.toLowerCase()) {

			case "january":
				registrationCounts = insertRegistrationCount(0, "january", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "february":
				registrationCounts = insertRegistrationCount(1, "february", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "march":
				registrationCounts = insertRegistrationCount(2, "march", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "april":
				registrationCounts = insertRegistrationCount(3, "april", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "may":
				registrationCounts = insertRegistrationCount(4, "may", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "june":
				registrationCounts = insertRegistrationCount(5, "june", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "july":
				registrationCounts = insertRegistrationCount(6, "july", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "august":
				registrationCounts = insertRegistrationCount(7, "august", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "september":
				registrationCounts = insertRegistrationCount(8, "september", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "october":
				registrationCounts = insertRegistrationCount(9, "october", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "november":
				registrationCounts = insertRegistrationCount(10, "november", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			case "december":
				registrationCounts = insertRegistrationCount(11, "december", monthWiseRegistrationCountDetails,
						registrationCounts);
				break;
			default:
				break;

			}
		}
		return registrationCounts;
	}

	private List<BigInteger> insertRegistrationCount(int index, String monthName,
			List<StatisticsProjection> monthWiseRegistrationCountDetails, List<BigInteger> registrationCounts) {

		Optional<StatisticsProjection> matchingMonthDetails = monthWiseRegistrationCountDetails.stream()
				.filter(x -> x.getName().trim().equalsIgnoreCase(monthName.trim())).findAny();
		if (matchingMonthDetails.isPresent()) {
			registrationCounts.add(index, matchingMonthDetails.get().getValue());
		} else {
			registrationCounts.add(index, BigInteger.valueOf(0l));
		}
		return registrationCounts;
	}

	public DashBoardResponseDto getOstData(DashboardRequestDto dashboardRequestDto) {
		DashBoardResponseDto dashBoardResponseDto = new DashBoardResponseDto();
		SummaryDto summary = beneficiaryRepository.getSummaryOstDashboardDetails(dashboardRequestDto.getFacilityId());
		dashBoardResponseDto.setSummary(summary);
		return dashBoardResponseDto;

	}
	
	
	public String getMonth(int month) {
	    return new DateFormatSymbols().getMonths()[month-1];
	}
}
