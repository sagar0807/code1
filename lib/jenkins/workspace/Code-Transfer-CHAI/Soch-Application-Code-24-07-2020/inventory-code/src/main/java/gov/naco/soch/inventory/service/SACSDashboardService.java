package gov.naco.soch.inventory.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.constructordto.SACSSummaryDto;
import gov.naco.soch.dto.DashboardRequestDto;
import gov.naco.soch.dto.FacilityReconciliationDto;
import gov.naco.soch.dto.Series;
import gov.naco.soch.inventory.dto.DashBoardResponseDto;
import gov.naco.soch.inventory.dto.DashboardGraphsDto;
import gov.naco.soch.inventory.dto.SACSDashboardReponseDto;
import gov.naco.soch.inventory.dto.SACSDispatchAndAdjustDto;
import gov.naco.soch.inventory.dto.Widgets;
import gov.naco.soch.projection.DashboardStockAdjustProjection;
import gov.naco.soch.projection.StatisticsProjection;
import gov.naco.soch.repository.SACSDashboardRepository;

@Service
@Transactional
public class SACSDashboardService {

	@Autowired
	private SACSDashboardRepository sacsDashboardRepository;
	@Autowired
	FacilityReconcilationService facilityReconcilationService;

	public SACSDashboardReponseDto getData(DashboardRequestDto dashboardRequestDto) {
		SACSDashboardReponseDto sacsDashboardReponseDto = new SACSDashboardReponseDto();
		DashBoardResponseDto dashBoardResponseDto = new DashBoardResponseDto();
		SACSSummaryDto summary = sacsDashboardRepository
				.getSummaryDashboardDetails(dashboardRequestDto.getFacilityId());
		List<FacilityReconciliationDto> facilityReconciliationDtos = facilityReconcilationService
				.getReconcilationList(dashboardRequestDto.getFacilityId());
		if (facilityReconciliationDtos != null && facilityReconciliationDtos.size() > 0) {
			BigInteger reconsilationItemSize = BigInteger.valueOf(facilityReconciliationDtos.size());
			BigInteger sum = BigInteger
					.valueOf(facilityReconciliationDtos.stream().mapToLong(FacilityReconciliationDto::getGit).sum());
			summary.setPendingReconsile(reconsilationItemSize);
			summary.setProductReconsile(sum);
		}
		List<DashboardGraphsDto> categoriesList = new ArrayList<DashboardGraphsDto>();
		categoriesList.add(getFacilityDispatchAndCountData(dashboardRequestDto.getFacilityId()));
		dashBoardResponseDto.setSummary(summary);
		dashBoardResponseDto.setCategories(categoriesList);
		sacsDashboardReponseDto.setResponseDto(dashBoardResponseDto);
		sacsDashboardReponseDto
				.setDispatchAndAdjustDtos(getAllSacsDispatchAndAdjustData(dashboardRequestDto.getFacilityId()));
		return sacsDashboardReponseDto;

	}

	public DashboardGraphsDto getFacilityDispatchAndCountData(Long facilityId) {
		DashboardGraphsDto dashboardGraphsDto = new DashboardGraphsDto();
		List<Widgets> sacsWidgetlist = new ArrayList<Widgets>();
		Widgets dispatchWidgets = new Widgets();
		dispatchWidgets.setType("pie-chart");
		dispatchWidgets.setChartTitle("Dispatch Summary(Last 30 days)");
		dispatchWidgets.setxAxisTitle("count");
		List<StatisticsProjection> dispatchProjections = sacsDashboardRepository.getDispatchSumamry(facilityId);
		List<Series> dispatchSeriesList = new ArrayList<Series>();
		try {

			if (dispatchProjections != null && !dispatchProjections.isEmpty()) {
				for (int i = 0; i < dispatchProjections.size(); i++) {
					Series series = new Series();
					series.setName(dispatchProjections.get(i).getName());
					List<BigInteger> dispatchBrkupList = new ArrayList<>();
					dispatchBrkupList.add(dispatchProjections.get(i).getValue());
					series.setData(dispatchBrkupList);
					dispatchSeriesList.add(series);
				}

			}

		} catch (Exception e) {
		}
		dispatchWidgets.setSeries(dispatchSeriesList);
		Widgets facilityCreationWidget = new Widgets();
		facilityCreationWidget.setType("pie-chart");
		facilityCreationWidget.setChartTitle("Facility Creation Count");
		facilityCreationWidget.setxAxisTitle("count");
		List<StatisticsProjection> facilityCountProjection = sacsDashboardRepository.getFacilityCount(facilityId);
		List<Series> facilityCountSeriesList = new ArrayList<Series>();
		try {

			if (facilityCountProjection != null && !facilityCountProjection.isEmpty()) {
				for (int i = 0; i < facilityCountProjection.size(); i++) {
					Series series = new Series();
					series.setName(facilityCountProjection.get(i).getName());
					List<BigInteger> facilityCountStatuslist = new ArrayList<>();
					facilityCountStatuslist.add(facilityCountProjection.get(i).getValue());
					series.setData(facilityCountStatuslist);
					facilityCountSeriesList.add(series);
				}

			}

		} catch (Exception e) {
		}
		facilityCreationWidget.setSeries(facilityCountSeriesList);
		sacsWidgetlist.add(dispatchWidgets);
		sacsWidgetlist.add(facilityCreationWidget);
		dashboardGraphsDto.setWidgets(sacsWidgetlist);
		return dashboardGraphsDto;

	}

	public List<SACSDispatchAndAdjustDto> getAllSacsDispatchAndAdjustData(Long facilityId) {
		List<SACSDispatchAndAdjustDto> dispatchAndAdjustDtos = new ArrayList<SACSDispatchAndAdjustDto>();
		List<DashboardStockAdjustProjection> dashboardStockAdjustProjections = sacsDashboardRepository
				.getStockAdjustData(facilityId);
		if (dashboardStockAdjustProjections != null && dashboardStockAdjustProjections.size() > 0) {
			for (DashboardStockAdjustProjection dashboardStockAdjustProjection : dashboardStockAdjustProjections) {
				SACSDispatchAndAdjustDto dispatchAndAdjustDto = new SACSDispatchAndAdjustDto();
				dispatchAndAdjustDto.setGetSlNo(dashboardStockAdjustProjection.getSlNo());
				dispatchAndAdjustDto.setGetPName(dashboardStockAdjustProjection.getPName());
				dispatchAndAdjustDto.setGetAdjustDate(dashboardStockAdjustProjection.getAdjustDate());
				dispatchAndAdjustDto.setGetAdjustreason(dashboardStockAdjustProjection.getAdjustreason());
				dispatchAndAdjustDto.setGetQuantity(dashboardStockAdjustProjection.getQuantity());
				dispatchAndAdjustDto.setGetUom(dashboardStockAdjustProjection.getUom());
				dispatchAndAdjustDtos.add(dispatchAndAdjustDto);
			}
		}
		return dispatchAndAdjustDtos;
	}

}
