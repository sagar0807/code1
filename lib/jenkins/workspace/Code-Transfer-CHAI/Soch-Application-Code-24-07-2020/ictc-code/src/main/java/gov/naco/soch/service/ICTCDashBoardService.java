package gov.naco.soch.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import gov.naco.soch.constant.ICTCDashBoardConstant;
import gov.naco.soch.projection.InventoryProjection;
import gov.naco.soch.projection.StatisticsProjection;
import gov.naco.soch.repository.ICTCDashBordRepository;
import gov.naco.soch.service.dto.Category;
import gov.naco.soch.service.dto.DashBoardFilterDTO;
import gov.naco.soch.service.dto.DashBoardSummaryDTO;
import gov.naco.soch.service.dto.DashboardGraphsDto;
import gov.naco.soch.service.dto.Filters;
import gov.naco.soch.service.dto.ICTCDashBoardResponseDTO;
import gov.naco.soch.service.dto.ICTCDashboardRequestDTO;
import gov.naco.soch.service.dto.Series;
import gov.naco.soch.service.dto.Widgets;

@Service
public class ICTCDashBoardService {

	@Autowired
	private ICTCDashBordRepository dashBordRepository;

	public ICTCDashBoardResponseDTO getData(ICTCDashboardRequestDTO dashboardRequestDto) throws Exception {

		ICTCDashBoardResponseDTO dashBoardResponseDto = new ICTCDashBoardResponseDTO();

		List<DashBoardSummaryDTO> summary = getSummaryDashboardDetails(dashboardRequestDto);
		List<DashboardGraphsDto> categoriesList = new ArrayList<DashboardGraphsDto>();
		categoriesList.add(selfInitiatedProviderInitiatedGraph(dashboardRequestDto));
		categoriesList.add((clientFollowupVsRepeatTestGraph(dashboardRequestDto)));
		categoriesList.add(partnerFollowUpVsPartnersTested(dashboardRequestDto));
		categoriesList.add(infantHivPositiveVsTested(dashboardRequestDto));
		categoriesList.add(clientTestedVsClientTreatedForSyphilis(dashboardRequestDto));
		categoriesList.add(infantTurnupAtSixweeksVsInfantOfPositiveMothers(dashboardRequestDto));
		categoriesList.add(tbResultBreakUpGraph(dashboardRequestDto));
		categoriesList.add(inventoryForHivAndSyphilis(dashboardRequestDto));
		dashBoardResponseDto.setSummary(summary);
		dashBoardResponseDto.setCategories(categoriesList);

		return dashBoardResponseDto;

	}

	List<BigInteger> setValuesToData(int remainingQuantity, int average, List<BigInteger> HIVFirstKITdataCount) {

		if (average != 0) {
			int noOfmonthsWithAverageValue = remainingQuantity / average;
			int remainder = remainingQuantity % average;
			if (noOfmonthsWithAverageValue >= 12) {
				for (int i = 0; i < 12; i++) {
					HIVFirstKITdataCount.add(BigInteger.valueOf(average));
				}

			} else if (noOfmonthsWithAverageValue < 12 && remainder == 0) {
				for (int i = 1; i <= noOfmonthsWithAverageValue; i++) {
					HIVFirstKITdataCount.add(BigInteger.valueOf(average));
				}
				// set the remaining as 0
				for (int i = noOfmonthsWithAverageValue + 1; i <= 12; i++) {
					HIVFirstKITdataCount.add(BigInteger.valueOf(0));
				}
			} else if (noOfmonthsWithAverageValue < 12 && remainder != 0) {
				for (int i = 1; i <= noOfmonthsWithAverageValue; i++) {
					HIVFirstKITdataCount.add(BigInteger.valueOf(average));
				}

				int adjacentMonth = noOfmonthsWithAverageValue + 1;
				HIVFirstKITdataCount.add(BigInteger.valueOf(remainder));

				for (int i = adjacentMonth + 1; i <= 12; i++) {
					HIVFirstKITdataCount.add(BigInteger.valueOf(0));
				}
			}
		} else if (average == 0) {
			for (int i = 0; i < 12; i++) {
				HIVFirstKITdataCount.add(BigInteger.valueOf(0));
			}
		}
		return HIVFirstKITdataCount;
	}

	private DashboardGraphsDto inventoryTable(ICTCDashboardRequestDTO dashboardRequestDto) {
		// TODO Auto-generated method stub
		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		List<Widgets> widgetList = new ArrayList<>();
		Widgets widgets = new Widgets();
		widgets.setType("inventory-table");
		List<Series> seriesList = new ArrayList<>();
		InventoryProjection HIVFirstAntigenKIT = dashBordRepository
				.getHIVFirstKITdata(dashboardRequestDto.getFacilityId());
		InventoryProjection HIVSecondAntigenKIT = dashBordRepository
				.getHIVSecondKITdata(dashboardRequestDto.getFacilityId());
		InventoryProjection HIVThirdAntigenKIT = dashBordRepository
				.getHIVThirdKITdata(dashboardRequestDto.getFacilityId());
		InventoryProjection SyphilisRPRKIT = dashBordRepository
				.getSyphilisFirstKITdata(dashboardRequestDto.getFacilityId());

		// InventoryDto inventoryDto =
		// beneficiaryRepository.getInventoryDetails(dashboardRequestDto.getFacilityId());
		List<BigInteger> datalist = new ArrayList<BigInteger>();
		if (HIVFirstAntigenKIT != null) {

			datalist.add(HIVFirstAntigenKIT.getTotalQuantity());
			if (!HIVFirstAntigenKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result = new Double(0.0);
				result = ((Double.valueOf(HIVFirstAntigenKIT.getTotalQuantity().intValue())
						/ (Double.valueOf(HIVFirstAntigenKIT.getAverageCount().intValue()))));
				BigInteger k = BigDecimal.valueOf(result).toBigInteger();
				datalist.add(k);
			} else {
				datalist.add(BigInteger.valueOf(-1));
			}
		} else {
			datalist.add(BigInteger.valueOf(0));
		}

		Series series1 = new Series();
		series1.setName("HIV (Rapid) Kits - 1st Antigen(Combaids)");
		series1.setData(datalist);
		List<BigInteger> datalist2 = new ArrayList<BigInteger>();
		if (HIVSecondAntigenKIT != null) {
			datalist2.add(HIVSecondAntigenKIT.getTotalQuantity());
			if (!HIVSecondAntigenKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result1 = new Double(0.0);
				result1 = ((Double.valueOf(HIVSecondAntigenKIT.getTotalQuantity().toString())
						/ (Double.valueOf(HIVSecondAntigenKIT.getAverageCount().toString()))));
				BigInteger k1 = BigDecimal.valueOf(result1).toBigInteger();
				datalist2.add(k1);
			} else {
				datalist2.add(BigInteger.valueOf(-1));
			}
		} else {
			datalist2.add(BigInteger.valueOf(0));
		}
		Series series2 = new Series();
		series2.setName("HIV (Rapid) Kits - 2nd Antigen(Meriscreen)");
		series2.setData(datalist2);
		List<BigInteger> datalist3 = new ArrayList<BigInteger>();
		if (HIVThirdAntigenKIT != null) {
			datalist3.add(HIVFirstAntigenKIT.getTotalQuantity());
			if (!HIVThirdAntigenKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result2 = new Double(0.0);
				result2 = ((Double.valueOf(HIVThirdAntigenKIT.getTotalQuantity().toString())
						/ (Double.valueOf(HIVThirdAntigenKIT.getAverageCount().toString()))));
				BigInteger k2 = BigDecimal.valueOf(result2).toBigInteger();
				datalist2.add(k2);
			} else {
				datalist3.add(BigInteger.valueOf(-1));
			}
		} else {
			datalist3.add(BigInteger.valueOf(0));
		}
		Series series3 = new Series();
		series3.setName("HIV (Rapid) Kits -3rd Antigen(Signal)");
		series3.setData(datalist3);
		List<BigInteger> datalist4 = new ArrayList<BigInteger>();
		if (SyphilisRPRKIT != null) {
			datalist4.add(SyphilisRPRKIT.getTotalQuantity());
			if (SyphilisRPRKIT != null && !SyphilisRPRKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result3 = new Double(0.0);
				result3 = ((Double.valueOf(SyphilisRPRKIT.getTotalQuantity().toString())
						/ (Double.valueOf(SyphilisRPRKIT.getAverageCount().toString()))));
				BigInteger k3 = BigDecimal.valueOf(result3).toBigInteger();
				datalist2.add(k3);
			} else {
				datalist4.add(BigInteger.valueOf(0));
			}
		} else {
			datalist4.add(BigInteger.valueOf(0));
		}
		Series series4 = new Series();
		series4.setName("RPR Kit (Syphilis)");
		series4.setData(datalist4);
		seriesList.add(series1);
		seriesList.add(series2);
		seriesList.add(series3);
		seriesList.add(series4);
		widgets.setSeries(seriesList);
		widgetList.add(widgets);
		dashboardGraphsDto.setWidgets(widgetList);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto inventoryForHivAndSyphilis(ICTCDashboardRequestDTO dashboardRequestDto) {

		int averageCount = 0;
		int totalQuantity = 0;
		// add filteryear , filtermonth ,hivkit/syphilis in all repository methods
		Widgets widgetsForHIV = new Widgets();
		widgetsForHIV.setType("single-bar-chart");
		widgetsForHIV.setChartTitle("HIV Kits");
		widgetsForHIV.setxAxisTitle("Months");
		widgetsForHIV.setyAxisTitle("Count");
		// widgetsForHIV.setLabelForICTC(new ArrayList<>());
		widgetsForHIV.setDefaultLabelsForICTC(new ArrayList<>());
		List<Category> categoryForMonth = new ArrayList<Category>();
		categoryForMonth = widgetsForHIV.setCategoriesForICTC(new ArrayList<Category>());
		List<String> monthNames = categoryForMonth.stream().map(Category::getName).collect(Collectors.toList());

		List<StatisticsProjection> productStockGroupForHivFirstKit = new ArrayList<StatisticsProjection>();
		productStockGroupForHivFirstKit = dashBordRepository
				.getHIVFirstKITConsumptionData(dashboardRequestDto.getFacilityId());
		List<BigInteger> HIVFirstKITConsumptionCount = new ArrayList<>();
		HIVFirstKITConsumptionCount = setMonthWiseConsumptionCounts(monthNames, productStockGroupForHivFirstKit,
				HIVFirstKITConsumptionCount);
		Series seriesHIVFirstKIT = new Series();
		seriesHIVFirstKIT.setName("HIV Kits");
		seriesHIVFirstKIT.setData(HIVFirstKITConsumptionCount);
		List<Series> seriesHIVFirstKITConsumptionList = new ArrayList<>();
		seriesHIVFirstKITConsumptionList.add(seriesHIVFirstKIT);

		List<StatisticsProjection> productStockGroupForHivSecondKit = new ArrayList<StatisticsProjection>();
		productStockGroupForHivSecondKit = dashBordRepository
				.getHIVSecondKITConsumptionData(dashboardRequestDto.getFacilityId());
		List<BigInteger> HIVSecondKITConsumptionCount = new ArrayList<>();
		HIVSecondKITConsumptionCount = setMonthWiseCounts(monthNames, productStockGroupForHivSecondKit,
				HIVSecondKITConsumptionCount);
		Series seriesHIVSecondKIT = new Series();
		seriesHIVSecondKIT.setName("HIV Kits");
		seriesHIVSecondKIT.setData(HIVSecondKITConsumptionCount);
		List<Series> seriesHIVSecondKITConsumptionList = new ArrayList<>();
		seriesHIVSecondKITConsumptionList.add(seriesHIVSecondKIT);

		List<StatisticsProjection> productStockGroupForHivThirdKit = new ArrayList<StatisticsProjection>();
		productStockGroupForHivThirdKit = dashBordRepository
				.getHIVThirdKITConsumptionData(dashboardRequestDto.getFacilityId());
		List<BigInteger> HIVThirdKITConsumptionCount = new ArrayList<>();
		HIVThirdKITConsumptionCount = setMonthWiseCounts(monthNames, productStockGroupForHivThirdKit,
				HIVThirdKITConsumptionCount);
		Series seriesHIVThirdKIT = new Series();
		seriesHIVThirdKIT.setName("HIV Kits");
		seriesHIVThirdKIT.setData(HIVThirdKITConsumptionCount);
		List<Series> seriesHIVThirdKITConsumptionList = new ArrayList<>();
		seriesHIVThirdKITConsumptionList.add(seriesHIVThirdKIT);

		Filters filterforFirstHIVKit = new Filters();
		filterforFirstHIVKit.setName("HIV (Rapid) Kits - 1st Antigen(Combaids)");
		filterforFirstHIVKit.setSeries(seriesHIVFirstKITConsumptionList); // kit1 series for hiv

		Filters filterforSecondHIVKit = new Filters();
		filterforSecondHIVKit.setName("HIV (Rapid) Kits - 2nd Antigen(Meriscreen)");
		filterforSecondHIVKit.setSeries(seriesHIVSecondKITConsumptionList); // kit2 series for hiv

		Filters filterforThirdHIVKit = new Filters();
		filterforThirdHIVKit.setName("HIV (Rapid) Kits -3rd Antigen(Signal)");
		filterforThirdHIVKit.setSeries(seriesHIVThirdKITConsumptionList); // kit3 series for hiv

		List<Filters> filtersHIVList = new ArrayList<>();
		filtersHIVList.add(filterforFirstHIVKit);
		filtersHIVList.add(filterforSecondHIVKit);
		filtersHIVList.add(filterforThirdHIVKit);
		widgetsForHIV.setFilters(filtersHIVList);

		// For Syphilis:
		Widgets widgetsForSyphilis = new Widgets();
		widgetsForSyphilis.setType("single-bar-chart");
		widgetsForSyphilis.setChartTitle("Syphilis Kits");
		widgetsForSyphilis.setxAxisTitle("Months");
		widgetsForSyphilis.setyAxisTitle("Count");
		// widgetsForSyphilis.setLabelForICTC(new ArrayList<>());
		widgetsForSyphilis.setDefaultLabelsForICTC(new ArrayList<>());
		categoryForMonth = widgetsForSyphilis.setCategoriesForICTC(new ArrayList<Category>());
		List<Category> categoryForMonthSyphilis = new ArrayList<Category>();
		List<String> monthNamesSyphilis = categoryForMonthSyphilis.stream().map(Category::getName)
				.collect(Collectors.toList());

		List<StatisticsProjection> syphilisFirstKITdata = dashBordRepository
				.getSyphilisFirstKITConsumptionData(dashboardRequestDto.getFacilityId());
		List<BigInteger> syphilisFirstKITdataCount = new ArrayList<>();
		syphilisFirstKITdataCount = setMonthWiseConsumptionCounts(monthNames, syphilisFirstKITdata,
				syphilisFirstKITdataCount);
		Series seriesSyphilisFirstKIT = new Series();
		seriesSyphilisFirstKIT.setName("Syphilis Kits");
		seriesSyphilisFirstKIT.setData(syphilisFirstKITdataCount); // from query for syphilis 1st kit
		List<Series> seriesSyphilisFirstKITList = new ArrayList<>();
		seriesSyphilisFirstKITList.add(seriesSyphilisFirstKIT);

		Filters filterforFirstSyphilisKit = new Filters();
		filterforFirstSyphilisKit.setName("RPR Kit (Syphilis)");
		filterforFirstSyphilisKit.setSeries(seriesSyphilisFirstKITList); // kit1 series for syphilis

		List<Filters> filtersSyphilisList = new ArrayList<>();
		filtersSyphilisList.add(filterforFirstSyphilisKit);
		widgetsForSyphilis.setFilters(filtersSyphilisList);
		List<Widgets> widgetsList = new ArrayList<Widgets>();
		widgetsList.add(widgetsForHIV);
		widgetsList.add(widgetsForSyphilis); // for syphilis

		// inventory table

		Widgets widgets = new Widgets();
		widgets.setType("inventory-table");
		List<Series> seriesList = new ArrayList<>();
		InventoryProjection HIVFirstAntigenKIT = dashBordRepository
				.getHIVFirstKITdata(dashboardRequestDto.getFacilityId());
		InventoryProjection HIVSecondAntigenKIT = dashBordRepository
				.getHIVSecondKITdata(dashboardRequestDto.getFacilityId());
		InventoryProjection HIVThirdAntigenKIT = dashBordRepository
				.getHIVThirdKITdata(dashboardRequestDto.getFacilityId());
		InventoryProjection SyphilisRPRKIT = dashBordRepository
				.getSyphilisFirstKITdata(dashboardRequestDto.getFacilityId());

		List<BigInteger> datalist = new ArrayList<BigInteger>();
		if (HIVFirstAntigenKIT != null) {

			datalist.add(HIVFirstAntigenKIT.getTotalQuantity());
			if (!HIVFirstAntigenKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result = new Double(0.0);
				result = ((Double.valueOf(HIVFirstAntigenKIT.getTotalQuantity().intValue())
						/ (Double.valueOf(HIVFirstAntigenKIT.getAverageCount().intValue()))));
				BigInteger k = BigDecimal.valueOf(result).toBigInteger();
				datalist.add(k);
			} else {
				datalist.add(BigInteger.valueOf(0));
			}
		} else {
			datalist.add(BigInteger.valueOf(0));
		}

		Series series1 = new Series();
		series1.setName("HIV (Rapid) Kits - 1st Antigen(Combaids)");
		series1.setData(datalist);
		List<BigInteger> datalist2 = new ArrayList<BigInteger>();
		if (HIVSecondAntigenKIT != null) {
			datalist2.add(HIVSecondAntigenKIT.getTotalQuantity());
			if (!HIVSecondAntigenKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result1 = new Double(0.0);
				result1 = ((Double.valueOf(HIVSecondAntigenKIT.getTotalQuantity().toString())
						/ (Double.valueOf(HIVSecondAntigenKIT.getAverageCount().toString()))));
				BigInteger k1 = BigDecimal.valueOf(result1).toBigInteger();
				datalist2.add(k1);
			} else {
				datalist2.add(BigInteger.valueOf(0));
			}
		} else {
			datalist2.add(BigInteger.valueOf(0));
		}
		Series series2 = new Series();
		series2.setName("HIV (Rapid) Kits - 2nd Antigen(Meriscreen)");
		series2.setData(datalist2);
		List<BigInteger> datalist3 = new ArrayList<BigInteger>();
		if (HIVThirdAntigenKIT != null) {
			datalist3.add(HIVThirdAntigenKIT.getTotalQuantity());
			if (!HIVThirdAntigenKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result2 = new Double(0.0);
				result2 = ((Double.valueOf(HIVThirdAntigenKIT.getTotalQuantity().toString())
						/ (Double.valueOf(HIVThirdAntigenKIT.getAverageCount().toString()))));
				BigInteger k2 = BigDecimal.valueOf(result2).toBigInteger();
				datalist3.add(k2);
			} else {
				datalist3.add(BigInteger.valueOf(0));
			}
		} else {
			datalist3.add(BigInteger.valueOf(0));
		}
		Series series3 = new Series();
		series3.setName("HIV (Rapid) Kits -3rd Antigen(Signal)");
		series3.setData(datalist3);
		List<BigInteger> datalist4 = new ArrayList<BigInteger>();
		if (SyphilisRPRKIT != null) {
			datalist4.add(SyphilisRPRKIT.getTotalQuantity());
			if (SyphilisRPRKIT != null && !SyphilisRPRKIT.getAverageCount().equals(BigInteger.valueOf(0))) {
				Double result3 = new Double(0.0);
				result3 = ((Double.valueOf(SyphilisRPRKIT.getTotalQuantity().toString())
						/ (Double.valueOf(SyphilisRPRKIT.getAverageCount().toString()))));
				BigInteger k3 = BigDecimal.valueOf(result3).toBigInteger();
				datalist4.add(k3);
			} else {
				datalist4.add(BigInteger.valueOf(0));
			}
		} else {
			datalist4.add(BigInteger.valueOf(0));
		}
		Series series4 = new Series();
		series4.setName("RPR Kit (Syphilis)");
		series4.setData(datalist4);
		seriesList.add(series1);
		seriesList.add(series2);
		seriesList.add(series3);
		seriesList.add(series4);
		widgets.setSeries(seriesList);
		widgetsList.add(widgets);

		// inventoryTable

		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		dashboardGraphsDto.setTitle("Inventory");
		dashboardGraphsDto.setWidgets(widgetsList);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto tbResultBreakUpGraph(ICTCDashboardRequestDTO dashboardRequestDto) {
		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		List<Widgets> widgets = new ArrayList<Widgets>();
		Widgets widgetForGraph1 = new Widgets();
		widgetForGraph1.setType("pie-chart");
		widgetForGraph1.setChartTitle("TB Result Breakup");
		List<Filters> filterList = new ArrayList<Filters>();
		Filters filterForGC = new Filters();
		Filters filterForPW = new Filters();
		Filters filterForInfant = new Filters();

		// filterForGC
		filterForGC.setName("GC");
		List<Series> seriesList = new ArrayList<Series>();
		Series series1 = new Series();
		Series series2 = new Series();
		Series series3 = new Series();
		Series series4 = new Series();

		series1.setName("Pulmonary TB (Micro biologically confirmed)");
		series2.setName("Pulmonary TB (Clinically diagnosed)");
		series3.setName("Extra-Pulmonary TB (Micro biologically confirmed)");
		series4.setName("Extra Pulmonary TB (Clinically diagnosed)");

		List<BigInteger> pulmonaryMicroTBCount = dashBordRepository.getpulmonaryMicroTBCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> pulmonaryClinicalTBCount = dashBordRepository.getpulmonaryClinicalTBCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> extraPulmonaryCount = dashBordRepository.getextraPulmonaryMicroCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> extraPulmonaryClinicCount = dashBordRepository.getextraPulmonaryClinicalCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());

		series1.setData(pulmonaryMicroTBCount);
		series2.setData(pulmonaryClinicalTBCount);
		series3.setData(extraPulmonaryCount);
		series4.setData(extraPulmonaryClinicCount);
		seriesList.add(series1);
		seriesList.add(series2);
		seriesList.add(series3);
		seriesList.add(series4);
		filterForGC.setSeries(seriesList);
		filterList.add(filterForGC);

		// filterForPW
		filterForPW.setName("PW");
		List<Series> seriesListPW = new ArrayList<Series>();
		Series seriesPW1 = new Series();
		Series seriesPW2 = new Series();
		Series seriesPW3 = new Series();
		Series seriesPW4 = new Series();
		seriesPW1.setName("Pulmonary TB (Micro biologically confirmed)");
		seriesPW2.setName("Pulmonary TB (Clinically diagnosed)");
		seriesPW3.setName("Extra-Pulmonary TB (Micro biologically confirmed)");
		seriesPW4.setName("Extra Pulmonary TB (Clinically diagnosed)");

		List<BigInteger> pulmonaryMicroTBCountForPW = dashBordRepository.getpulmonaryMicroTBCountForPW(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> pulmonaryClinicalTBCountForPW = dashBordRepository.getpulmonaryClinicalTBCountForPW(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> extraPulmonaryMicroCountForPW = dashBordRepository.getextraPulmonaryMicroCountForPW(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> extraPulmonaryClinicCountForPW = dashBordRepository.getextraPulmonaryClinicCountForPW(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());

		seriesPW1.setData(pulmonaryMicroTBCountForPW);
		seriesPW2.setData(pulmonaryClinicalTBCountForPW);
		seriesPW3.setData(extraPulmonaryMicroCountForPW);
		seriesPW4.setData(extraPulmonaryClinicCountForPW);
		seriesListPW.add(seriesPW1);
		seriesListPW.add(seriesPW2);
		seriesListPW.add(seriesPW3);
		seriesListPW.add(seriesPW4);
		filterForPW.setSeries(seriesListPW);
		filterList.add(filterForPW);

		widgetForGraph1.setFilters(filterList);
		widgets.add(widgetForGraph1);
		dashboardGraph.setWidgets(widgets);
		return dashboardGraph;
	}

	private DashboardGraphsDto infantTurnupAtSixweeksVsInfantOfPositiveMothers(
			ICTCDashboardRequestDTO dashboardRequestDto) {

		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		List<Widgets> widgets = new ArrayList<Widgets>();
		Widgets widgetForGraph1 = new Widgets();
		widgetForGraph1.setType("bar-pie-chart");
		widgetForGraph1.setChartTitle("Infant turn up at 6 weeks Vs Infant for +ve mothers");
		widgetForGraph1.setyAxisTitle("Count");
		List<Series> seriesLs = new ArrayList<Series>();
		Series seriesForPositiveMother = new Series();
		Series seriesForSixWeekInfant = new Series();
		seriesForPositiveMother.setName("+ve Mothers");
		seriesForSixWeekInfant.setName("6 Weeks");

		List<BigInteger> positiveMotherCount = dashBordRepository.getPositiveMotherCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> sixWeekInfantCount = dashBordRepository.getSixWeekInfantCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());

		seriesForPositiveMother.setData(positiveMotherCount);
		seriesForSixWeekInfant.setData(sixWeekInfantCount);
		seriesLs.add(seriesForSixWeekInfant);
		seriesLs.add(seriesForPositiveMother);
		widgetForGraph1.setSeries(seriesLs);
		widgets.add(widgetForGraph1);
		dashboardGraph.setWidgets(widgets);

		return dashboardGraph;

	}

	private DashboardGraphsDto clientTestedVsClientTreatedForSyphilis(ICTCDashboardRequestDTO dashboardRequestDto) {
		// --- Tested for infant ,PW and GC ----
		List<BigInteger> PWTestedForSyphilis = dashBordRepository.getPWTestedForSyphilis(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> GCTestedForSyphilis = dashBordRepository.getGCTestedForSyphilis(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());

		// -- Treated for infant ,PW and GC
		List<BigInteger> PWTreatedForSyphilis = dashBordRepository.getPWTreatedForSyphilis(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> GCTreatedForSyphilis = dashBordRepository.getGCTreatedForSyphilis(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());

		// ------------PW-----------------
		Series seriesPWTested = new Series();
		seriesPWTested.setName("Tested");
		seriesPWTested.setData(PWTestedForSyphilis); // Query
		Series seriesPWTreated = new Series();
		seriesPWTreated.setName("DSRC Treatment");
		seriesPWTreated.setData(PWTreatedForSyphilis); // Query
		List<Series> seriesPWList = new ArrayList<Series>();
		seriesPWList.add(seriesPWTested);
		seriesPWList.add(seriesPWTreated);
		Filters filterPW = new Filters();
		filterPW.setName("PW");
		filterPW.setSeries(seriesPWList);

		// ----------------GC-------------------
		Series seriesGCTested = new Series();
		seriesGCTested.setName("Tested");
		seriesGCTested.setData(GCTestedForSyphilis); // Query
		Series seriesGCTreated = new Series();
		seriesGCTreated.setName("DSRC Treatment");
		seriesGCTreated.setData(GCTreatedForSyphilis); // Query
		List<Series> seriesGCList = new ArrayList<Series>();
		seriesGCList.add(seriesGCTested);
		seriesGCList.add(seriesGCTreated);
		Filters filtersGC = new Filters();
		filtersGC.setName("GC");
		filtersGC.setSeries(seriesGCList);

		List<Filters> filtersList = new ArrayList<Filters>();
		filtersList.add(filtersGC);
		filtersList.add(filterPW);

		Widgets widgets = new Widgets();
		widgets.setType("bar-pie-chart");
		widgets.setChartTitle("Clients tested Vs Clients on treatment");
		widgets.setxAxisTitle("");
		widgets.setyAxisTitle("Count");
		widgets.setFilters(filtersList);
		List<Widgets> widgetsList = new ArrayList<Widgets>();
		widgetsList.add(widgets);

		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		dashboardGraphsDto.setTitle("Syphilis");
		dashboardGraphsDto.setWidgets(widgetsList);

		return dashboardGraphsDto;
	}

	private DashboardGraphsDto infantHivPositiveVsTested(ICTCDashboardRequestDTO dashboardRequestDto) {
		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		List<Widgets> widgets = new ArrayList<Widgets>();
		Widgets widgetForGraph1 = new Widgets();
		widgetForGraph1.setType("bar-pie-chart");
		widgetForGraph1.setChartTitle("Infant confirmed +ve Vs Tested");
		widgetForGraph1.setyAxisTitle("Count");
		List<Series> seriesLs = new ArrayList<Series>();
		Series seriesForConfirmed = new Series();
		Series seriesForTested = new Series();
		seriesForConfirmed.setName("Positive");
		seriesForTested.setName("Tested");

		List<BigInteger> confirmedPositiveCount = dashBordRepository.getConfirmedPositiveCount(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> testedCount = dashBordRepository.getTestedCount(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());

		seriesForConfirmed.setData(confirmedPositiveCount);
		seriesForTested.setData(testedCount);
		seriesLs.add(seriesForConfirmed);
		seriesLs.add(seriesForTested);
		widgetForGraph1.setSeries(seriesLs);
		widgets.add(widgetForGraph1);
		dashboardGraph.setWidgets(widgets);

		return dashboardGraph;

	}

	private DashboardGraphsDto partnerFollowUpVsPartnersTested(ICTCDashboardRequestDTO dashboardRequestDto) {

		int followUpPartnersGC = dashBordRepository.getPartnersFollowedUpGC(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());
		List<BigInteger> followUpPartnerGCList = new ArrayList<>();
		BigInteger bigIntegerFollowedUpPartnersGC = BigInteger.valueOf(followUpPartnersGC);
		followUpPartnerGCList.add(bigIntegerFollowedUpPartnersGC);

		int followUpPartnersPW = dashBordRepository.getPartnersFollowedUpPW(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());
		List<BigInteger> followUpPartnerPWList = new ArrayList<>();
		BigInteger bigIntegerFollowedUpPartnersPW = BigInteger.valueOf(followUpPartnersPW);
		followUpPartnerPWList.add(bigIntegerFollowedUpPartnersPW);

		/*
		 * int followUpPartnersInfant =
		 * dashBordRepository.getPartnersFollowedUpInfant(dashboardRequestDto.
		 * getFacilityId(), dashboardRequestDto.getFilterYear(),
		 * dashboardRequestDto.getFilterMonth()); List<BigInteger>
		 * followUpPartnerInfantList = new ArrayList<>(); BigInteger
		 * bigIntegerFollowedUpPartnersInfant =
		 * BigInteger.valueOf(followUpPartnersInfant);
		 * followUpPartnerInfantList.add(bigIntegerFollowedUpPartnersInfant);
		 */

		int partnersTestedGC = dashBordRepository.getPartnersTestedGC(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());
		List<BigInteger> testedPartnerGCList = new ArrayList<>();
		BigInteger bigIntegerPartnersTestedGC = BigInteger.valueOf(partnersTestedGC);
		testedPartnerGCList.add(bigIntegerPartnersTestedGC);

		int partnersTestedPW = dashBordRepository.getPartnersTestedPW(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());
		List<BigInteger> testedPartnerPWList = new ArrayList<>();
		BigInteger bigIntegerPartnersTestedPW = BigInteger.valueOf(partnersTestedPW);
		testedPartnerPWList.add(bigIntegerPartnersTestedPW);

		/*
		 * int partnersTestedInfant =
		 * dashBordRepository.getPartnersTestedInfant(dashboardRequestDto.getFacilityId(
		 * ), dashboardRequestDto.getFilterYear(),
		 * dashboardRequestDto.getFilterMonth()); List<BigInteger>
		 * testedPartnerInfantList = new ArrayList<>(); BigInteger
		 * bigIntegerPartnersTestedInfant = BigInteger.valueOf(partnersTestedInfant);
		 * testedPartnerInfantList.add(bigIntegerPartnersTestedInfant);
		 */

		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		// dashboardGraphsDto.setTitle("Partner for follow-up Vs Partner Tested");

		List<Widgets> widgetsList = new ArrayList<Widgets>();

		List<Series> seriesListGC = new ArrayList<Series>();
		Series seriesGCFollowup = new Series();
		seriesGCFollowup.setName("Follow Up");
		seriesGCFollowup.setData(followUpPartnerGCList);
		Series seriesGCTested = new Series();
		seriesGCTested.setName("Tested");
		seriesGCTested.setData(testedPartnerGCList);
		seriesListGC.add(seriesGCFollowup);
		seriesListGC.add(seriesGCTested);

		List<Series> seriesListPW = new ArrayList<Series>();
		Series seriesPWFollowup = new Series();
		seriesPWFollowup.setName("Follow Up");
		seriesPWFollowup.setData(followUpPartnerPWList);
		Series seriesPWTested = new Series();
		seriesPWTested.setName("Tested");
		seriesPWTested.setData(testedPartnerPWList);
		seriesListPW.add(seriesPWFollowup);
		seriesListPW.add(seriesPWTested);

		/*
		 * List<Series> seriesListInfant = new ArrayList<Series>(); Series
		 * seriesInfantFollowup = new Series();
		 * seriesInfantFollowup.setName("Followup");
		 * seriesInfantFollowup.setData(followUpPartnerInfantList); Series
		 * seriesInfantTested = new Series(); seriesInfantTested.setName("Tested");
		 * seriesInfantTested.setData(testedPartnerInfantList);
		 * seriesListInfant.add(seriesInfantFollowup);
		 * seriesListInfant.add(seriesInfantTested);
		 */

		List<Filters> filterList = new ArrayList<Filters>();
		Filters filtersGC = new Filters();
		Filters filtersPW = new Filters();
		// Filters filtersInfants = new Filters();

		filtersGC.setName("GC");
		filtersGC.setSeries(seriesListGC);

		filtersPW.setName("PW");
		filtersPW.setSeries(seriesListPW);

		// filtersInfants.setName("Infant");
		// filtersInfants.setSeries(seriesListInfant);

		filterList.add(filtersGC);
		filterList.add(filtersPW);
		// filterList.add(filtersInfants);

		Widgets widgets1 = new Widgets();
		widgets1.setType("bar-pie-chart");
		widgets1.setChartTitle("Partner for follow-up Vs Partners Tested");
		widgets1.setxAxisTitle("");
		widgets1.setyAxisTitle("Count");
		widgets1.setFilters(filterList);
		widgetsList.add(widgets1);
		dashboardGraphsDto.setWidgets(widgetsList);
		return dashboardGraphsDto;
	}

	private DashboardGraphsDto clientFollowupVsRepeatTestGraph(ICTCDashboardRequestDTO dashboardRequestDto) {
		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		List<Widgets> widgets = new ArrayList<Widgets>();
		Widgets widgetForGraph1 = new Widgets();
		widgetForGraph1.setType("bar-pie-chart");
		widgetForGraph1.setChartTitle("Clients for follow-up Vs Repeat testing turn up");
		widgetForGraph1.setyAxisTitle("Count");
		List<Series> seriesLs = new ArrayList<Series>();
		Series seriesForFollowUp = new Series();
		Series seriesForRepeatTesting = new Series();
		seriesForFollowUp.setName("Followup");
		seriesForRepeatTesting.setName("Repeat Testing");

		List<BigInteger> followupCount = dashBordRepository.getFollowupCount(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());
		List<BigInteger> repeatTestCount = dashBordRepository.getRepeatTestCount(dashboardRequestDto.getFacilityId(),
				dashboardRequestDto.getFilterYear(), dashboardRequestDto.getFilterMonth());

		seriesForFollowUp.setData(followupCount);
		seriesForRepeatTesting.setData(repeatTestCount);
		seriesLs.add(seriesForFollowUp);
		seriesLs.add(seriesForRepeatTesting);
		widgetForGraph1.setSeries(seriesLs);
		widgets.add(widgetForGraph1);
		dashboardGraph.setWidgets(widgets);

		return dashboardGraph;
	}

	private DashboardGraphsDto selfInitiatedProviderInitiatedGraph(ICTCDashboardRequestDTO dashboardRequestDto) {

		DashboardGraphsDto dashboardGraph = new DashboardGraphsDto();
		List<Widgets> widgets = new ArrayList<Widgets>();
		Widgets widgetForGraph1 = new Widgets();
		widgetForGraph1.setType("bar-pie-chart");
		widgetForGraph1.setChartTitle("Self Initiated VS Provider Initiated");
		widgetForGraph1.setyAxisTitle("Count");
		List<Filters> filter = new ArrayList<>();
		Filters filter1 = new Filters();
		filter1.setName("Positive");
		List<Series> seriesListForPositive = new ArrayList<Series>();
		Series series1 = new Series();
		Series series2 = new Series();
		series1.setName("Self");
		series2.setName("Provider");

		Filters filter2 = new Filters();
		filter2.setName("Negative");
		List<Series> seriesListForNegative = new ArrayList<Series>();
		Series seriesN1 = new Series();
		Series seriesN2 = new Series();
		seriesN1.setName("Self");
		seriesN2.setName("Provider");

		Filters filter3 = new Filters();
		filter3.setName("Indeterminate");
		List<Series> seriesListForIntermediate = new ArrayList<Series>();
		Series seriesIn1 = new Series();
		Series seriesIn2 = new Series();
		seriesIn1.setName("Self");
		seriesIn2.setName("Provider");

		List<BigInteger> selfCount1 = dashBordRepository.getSelfInitiatedCountForPositive(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> selfCount2 = dashBordRepository.getSelfInitiatedCountForNegative(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> selfCount3 = dashBordRepository.getSelfInitiatedCountForIntermediate(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> providerCount1 = dashBordRepository.getProviderInitiatedCountForPositive(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> providerCount2 = dashBordRepository.getProviderInitiatedCountForNegative(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());
		List<BigInteger> providerCount3 = dashBordRepository.getProviderInitiatedCountForIntermediate(
				dashboardRequestDto.getFacilityId(), dashboardRequestDto.getFilterYear(),
				dashboardRequestDto.getFilterMonth());

		series1.setData(selfCount1);
		series2.setData(providerCount1);

		seriesListForPositive.add(series1);
		seriesListForPositive.add(series2);
		filter1.setSeries(seriesListForPositive);

		seriesN1.setData(selfCount2);
		seriesN2.setData(providerCount2);

		seriesListForNegative.add(seriesN1);
		seriesListForNegative.add(seriesN2);
		filter2.setSeries(seriesListForNegative);

		seriesIn1.setData(selfCount3);
		seriesIn2.setData(providerCount3);

		seriesListForIntermediate.add(seriesIn1);
		seriesListForIntermediate.add(seriesIn2);
		filter3.setSeries(seriesListForIntermediate);
		filter.add(filter1);
		filter.add(filter2);
		filter.add(filter3);
		widgetForGraph1.setFilters(filter);
		widgets.add(widgetForGraph1);
		dashboardGraph.setWidgets(widgets);
		return dashboardGraph;
	}

	public List<DashBoardSummaryDTO> getSummaryDashboardDetails(ICTCDashboardRequestDTO dashboardRequestDto)
			throws Exception {

		List<DashBoardSummaryDTO> dashBoardSummaryDTOs = new ArrayList<DashBoardSummaryDTO>();
		try {
			Object summaryDataObject = dashBordRepository.getSummaryData(dashboardRequestDto.getFacilityId());
			if (summaryDataObject instanceof Object[]) {
				Object[] summaryItemList = (Object[]) summaryDataObject;
				for (int i = 0; i < summaryItemList.length; i++) {
					String componentFilterJson = ICTCDashBoardConstant.CHART_COMPONENT_FILTER_MAP.get(i);
					JsonObject jsonObjectForFilterComponent = JsonParser.parseString(componentFilterJson)
							.getAsJsonObject();
					int componentId = jsonObjectForFilterComponent.get("chartId").getAsInt();
					String componentJson = ICTCDashBoardConstant.CHART_COMPONENT_MAP.get(componentId);
					if (!componentJson.isEmpty()) {
						DashBoardSummaryDTO summaryDTO = new DashBoardSummaryDTO();
						int index = getMatchIndex(dashBoardSummaryDTOs, componentId);
						if (index == -1) {
							JsonObject jsonObjectForComponent = JsonParser.parseString(componentJson).getAsJsonObject();
							summaryDTO.setId(componentId);
							summaryDTO.setName(jsonObjectForComponent.get("name").getAsString());
							summaryDTO.setTitle(jsonObjectForComponent.get("title").getAsString());
							if (!jsonObjectForComponent.get("isFilter").getAsBoolean()) {
								summaryDTO.setValue((BigInteger) summaryItemList[i]);
								dashBoardSummaryDTOs.add(summaryDTO);
							} else {
								if (!componentFilterJson.isEmpty()) {
									List<DashBoardFilterDTO> filterDTOs = new ArrayList<DashBoardFilterDTO>();
									DashBoardFilterDTO filterDTO = new DashBoardFilterDTO();
									filterDTO.setName(jsonObjectForFilterComponent.get("name").getAsString());
									filterDTO.setTitle(jsonObjectForFilterComponent.get("title").getAsString());
									filterDTO.setValue((BigInteger) summaryItemList[i]);
									filterDTOs.add(filterDTO);
									summaryDTO.setFilters(filterDTOs);
									dashBoardSummaryDTOs.add(summaryDTO);

								}
							}
						} else {
							if (dashBoardSummaryDTOs.get(index) != null) {
								if (!componentFilterJson.isEmpty()) {
									JsonObject jsonObjectForFilter = JsonParser.parseString(componentFilterJson)
											.getAsJsonObject();
									DashBoardFilterDTO filterDTO = new DashBoardFilterDTO();
									filterDTO.setName(jsonObjectForFilter.get("name").getAsString());
									filterDTO.setTitle(jsonObjectForFilter.get("title").getAsString());
									filterDTO.setValue((BigInteger) summaryItemList[i]);
									dashBoardSummaryDTOs.get(index).getFilters().add(filterDTO);

								}
							}
						}

					}

				}
			}
		} catch (

		Exception e) {
			throw e;
		}

		return dashBoardSummaryDTOs;
	}

	public int getMatchIndex(List<DashBoardSummaryDTO> dashBoardSummaryDTOs, int id) {
		int index = 0;
		try {
			index = IntStream.range(0, dashBoardSummaryDTOs.size())
					.filter(i -> dashBoardSummaryDTOs.get(i).getId() == id).findFirst().orElse(-1);
		} catch (Exception e) {
			return -1;
		}
		return index;
	}

	private List<BigInteger> insertRegistrationCount(int index, String monthName,
			List<StatisticsProjection> monthWiseRegistrationCountDetails, List<BigInteger> registrationCounts) {

		// always starts from 0
		Optional<StatisticsProjection> matchingMonthDetails = monthWiseRegistrationCountDetails.stream()
				.filter(x -> x.getName().trim().equalsIgnoreCase(monthName.trim())).findAny();

		if (matchingMonthDetails.isPresent()) {
			if (registrationCounts.size() > 0) {
				registrationCounts.add(registrationCounts.size(), matchingMonthDetails.get().getValue());
			} else {
				registrationCounts.add(0, matchingMonthDetails.get().getValue()); // place the first element at '0'
																					// index
			}
		} else {
			if (registrationCounts.size() > 0) {
				registrationCounts.add(registrationCounts.size(), BigInteger.valueOf(0l));
			} else {
				registrationCounts.add(0, BigInteger.valueOf(0l)); // place the first element at '0' index
			}

		}
		return registrationCounts;
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

	private List<BigInteger> setMonthWiseConsumptionCounts(List<String> monthNames, List<StatisticsProjection> results,
			List<BigInteger> value) {
		for (String monthName : monthNames) {
			switch (monthName.toLowerCase()) {

			case "january":
				value = insertRegistrationConsumptionCount("january", results, value);
				break;
			case "february":
				value = insertRegistrationConsumptionCount("february", results, value);
				break;
			case "march":
				value = insertRegistrationConsumptionCount("march", results, value);
				break;
			case "april":
				value = insertRegistrationConsumptionCount("april", results, value);
				break;
			case "may":
				value = insertRegistrationConsumptionCount("may", results, value);
				break;
			case "june":
				value = insertRegistrationConsumptionCount("june", results, value);
				break;
			case "july":
				value = insertRegistrationConsumptionCount("july", results, value);
				break;
			case "august":
				value = insertRegistrationConsumptionCount("august", results, value);
				break;
			case "september":
				value = insertRegistrationConsumptionCount("september", results, value);
				break;
			case "october":
				value = insertRegistrationConsumptionCount("october", results, value);
				break;
			case "november":
				value = insertRegistrationConsumptionCount("november", results, value);
				break;
			case "december":
				value = insertRegistrationConsumptionCount("dece", results, value);
				break;
			default:
				break;

			}
		}
		return value;
	}

	private List<BigInteger> insertRegistrationConsumptionCount(String monthName, List<StatisticsProjection> result,
			List<BigInteger> countValue) {

		Optional<StatisticsProjection> matchingMonthDetails = result.stream()
				.filter(x -> x.getName().trim().equalsIgnoreCase(monthName.trim())).findAny();
		if (matchingMonthDetails.isPresent()) {
			countValue.add(matchingMonthDetails.get().getValue());
		} else {
			countValue.add(BigInteger.valueOf(0l));
		}
		return countValue;
	}

}
