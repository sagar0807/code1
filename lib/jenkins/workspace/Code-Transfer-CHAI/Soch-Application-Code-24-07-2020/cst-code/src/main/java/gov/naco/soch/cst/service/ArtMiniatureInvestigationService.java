package gov.naco.soch.cst.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.InvestigationCountDto;
import gov.naco.soch.cst.dto.InvestigationDetailsDto;
import gov.naco.soch.cst.dto.MasterInvestigationDto;
import gov.naco.soch.projection.StatisticsProjection;
import gov.naco.soch.repository.ArtMiniatureInvestigationRepository;

@Transactional
@Service
public class ArtMiniatureInvestigationService {

	@Autowired
	private ArtMiniatureInvestigationRepository artMiniatureInvestigationRepository;
	
	public InvestigationDetailsDto getInvestigationDetails(Long beneficiaryId, Long facilityId,Long investigationId) {
		
		InvestigationDetailsDto investigationDetailsDto =new InvestigationDetailsDto();
		List<StatisticsProjection> investigationCountProjectionList = new ArrayList<StatisticsProjection>();
		List<InvestigationCountDto> investigationCountDtoList = new ArrayList<InvestigationCountDto>();
		if(investigationId==0) {
			// on page load fetch the first investigation id and pass that
			Long id = artMiniatureInvestigationRepository.getFirstInvestigationId();
			investigationDetailsDto.setInvestigationId(id);
			investigationCountProjectionList = artMiniatureInvestigationRepository.getInvestigationDetails(beneficiaryId,facilityId,id);
		}
		else {
			investigationCountProjectionList = artMiniatureInvestigationRepository.getInvestigationDetails(beneficiaryId,facilityId,investigationId);
			investigationDetailsDto.setInvestigationId(investigationId);
		}
		if(investigationCountProjectionList !=null && investigationCountProjectionList.size()>0 ) {
			for(StatisticsProjection investigationCount:investigationCountProjectionList) {
				InvestigationCountDto investigationCountDto = new InvestigationCountDto();
				investigationCountDto.setCount(investigationCount.getValue());
				investigationCountDto.setMonth(investigationCount.getName());
				investigationCountDtoList.add(investigationCountDto);
			}
		}
		investigationDetailsDto.setInvestigationCountDtoList(investigationCountDtoList);
		return investigationDetailsDto;
	}

	public List<MasterInvestigationDto> getmasterInvestigation() {
		
		List<MasterInvestigationDto> masterInvestigationDtoList = new ArrayList<MasterInvestigationDto>();
		List<StatisticsProjection> masterInvestigationProjectionList = artMiniatureInvestigationRepository.getMasterInvestigationDetails();
		if(masterInvestigationProjectionList!=null && masterInvestigationProjectionList.size()>0) {
			for(StatisticsProjection master:masterInvestigationProjectionList) {
				MasterInvestigationDto masterInvestigationDto = new MasterInvestigationDto();
				masterInvestigationDto.setInvestigationId(master.getValue());
				masterInvestigationDto.setInvestigationName(master.getName());
				masterInvestigationDtoList.add(masterInvestigationDto);
			}
		}
		
		return masterInvestigationDtoList;
	}
	

}
