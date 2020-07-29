package gov.naco.soch.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.constructordto.GlobalReportsDto;
import gov.naco.soch.dto.ReportsDto;
import gov.naco.soch.dto.ReportsModuleDto;
import gov.naco.soch.dto.SubModuleDto;
import gov.naco.soch.repository.GlobalReportsRepository;

@Service
public class GlobalReportsService {

	@Autowired
	GlobalReportsRepository globalReportsRepository;

	public List<ReportsModuleDto> getReportsDetails(int roleId) {
		List<ReportsModuleDto> reportsModuleDtos = new ArrayList<ReportsModuleDto>();
		List<GlobalReportsDto> globalReportsDtos = new ArrayList<GlobalReportsDto>();
		globalReportsDtos = globalReportsRepository.getReportsDetails(roleId);
		reportsModuleDtos = constructReportList(globalReportsDtos);
		return reportsModuleDtos;

	}

	private static List<ReportsModuleDto> constructReportList(List<GlobalReportsDto> globalReportsDtos) {
		List<ReportsModuleDto> reportsModuleDtos = new ArrayList<ReportsModuleDto>();

		if (globalReportsDtos != null && globalReportsDtos.size() > 0) {
			for (int i = 0; i < globalReportsDtos.size(); i++) {
				GlobalReportsDto globalReportsDto = globalReportsDtos.get(i);
				ReportsModuleDto reportsModuleDto = new ReportsModuleDto();
				int moduleIndex = getModuleIndex(reportsModuleDtos, globalReportsDto.getModuleOrder());
				if (moduleIndex == -1) {
					reportsModuleDto.setOrderId(globalReportsDto.getModuleOrder());
					reportsModuleDto.setModuleName(globalReportsDto.getModuleName());
					List<SubModuleDto> subModuleDtos = new ArrayList<SubModuleDto>();
					SubModuleDto subModuleDto = new SubModuleDto();
					subModuleDto.setOrderId(globalReportsDto.getSubModuleOrder());
					subModuleDto.setSubModuleName(globalReportsDto.getSubModuleName());
					subModuleDtos.add(subModuleDto);
					List<ReportsDto> reportsDtos = new ArrayList<ReportsDto>();
					ReportsDto reportsDto = new ReportsDto();
					reportsDto.setOrderId(globalReportsDto.getReportOrder());
					reportsDto.setReportName(globalReportsDto.getReportName());
					reportsDto.setUrl(globalReportsDto.getUrl());
					reportsDtos.add(reportsDto);
					subModuleDto.setReports(reportsDtos);
					reportsModuleDto.setSubmodule(subModuleDtos);
					reportsModuleDtos.add(reportsModuleDto);
				} else {
					int subModuleIndex = getSubModuleIndex(reportsModuleDtos.get(moduleIndex).getSubmodule(),
							globalReportsDto.getSubModuleOrder());
					if (subModuleIndex == -1) {
						List<SubModuleDto> subModuleDtos = new ArrayList<SubModuleDto>();
						SubModuleDto subModuleDto = new SubModuleDto();
						subModuleDto.setOrderId(globalReportsDto.getSubModuleOrder());
						subModuleDto.setSubModuleName(globalReportsDto.getSubModuleName());
						subModuleDtos.add(subModuleDto);
						List<ReportsDto> reportsDtos = new ArrayList<ReportsDto>();
						ReportsDto reportsDto = new ReportsDto();
						reportsDto.setOrderId(globalReportsDto.getReportOrder());
						reportsDto.setReportName(globalReportsDto.getReportName());
						reportsDto.setUrl(globalReportsDto.getUrl());
						reportsDtos.add(reportsDto);
						subModuleDto.setReports(reportsDtos);
						reportsModuleDtos.get(moduleIndex).getSubmodule().add(subModuleDto);
					} else {
						ReportsDto reportsDto = new ReportsDto();
						reportsDto.setOrderId(globalReportsDto.getReportOrder());
						reportsDto.setReportName(globalReportsDto.getReportName());
						reportsDto.setUrl(globalReportsDto.getUrl());
						reportsModuleDtos.get(moduleIndex).getSubmodule().get(subModuleIndex).getReports()
								.add(reportsDto);
					}
				}

			}
		}

		return reportsModuleDtos;
	}

	public static int getModuleIndex(List<ReportsModuleDto> reportsModuleDtos, int orderId) {
		int index = -1;
		for (int i = 0; i < reportsModuleDtos.size(); i++) {
			if (reportsModuleDtos.get(i).getOrderId() == orderId) {
				index = i;
				return index;
			}
		}
		return index;
	}

	public static int getSubModuleIndex(List<SubModuleDto> subModuleDtos, int orderId) {
		int index = -1;
		for (int i = 0; i < subModuleDtos.size(); i++) {
			if (subModuleDtos.get(i).getOrderId() == orderId) {
				index = i;
				return index;
			}
		}
		return index;
	}

}
