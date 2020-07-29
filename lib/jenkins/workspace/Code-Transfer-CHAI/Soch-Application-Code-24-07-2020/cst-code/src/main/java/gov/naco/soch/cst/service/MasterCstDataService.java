package gov.naco.soch.cst.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.entity.MasterArtRegimenAction;
import gov.naco.soch.entity.MasterArtRegimenActionReasons;
import gov.naco.soch.repository.MasterArtRegimenActionReasonsRepository;
import gov.naco.soch.repository.MasterArtRegimenActionRepository;

@Transactional
@Service
public class MasterCstDataService {

	@Autowired
	private MasterArtRegimenActionRepository masterArtRegimenActionRepository;
	@Autowired
	private MasterArtRegimenActionReasonsRepository masterArtRegimenActionReasonsRepository;

	public List<MasterDto> getAllMasterArtRegimenAction() {
		
		List<MasterDto> masterDtoList = new ArrayList<MasterDto>();
		List<MasterArtRegimenAction> regimenActionList = masterArtRegimenActionRepository.findAll();
		if (regimenActionList != null) {
			for (MasterArtRegimenAction action : regimenActionList) {
				MasterDto master = new MasterDto();
				master.setCode(action.getCode());
				master.setDescription(action.getDescription());
				master.setId(action.getId());
				master.setName(action.getName());
				masterDtoList.add(master);
			}
		}
		return masterDtoList;
	}

	public List<MasterDto> getAllMasterArtRegimenActionReasonsByActionId(Long actionId) {
		
		List<MasterDto> masterDtoList = new ArrayList<MasterDto>();
		List<MasterArtRegimenActionReasons> actionReasonList = masterArtRegimenActionReasonsRepository.findAllByActionId(actionId);
		if (actionReasonList != null) {
			for (MasterArtRegimenActionReasons reason : actionReasonList) {
				MasterDto master = new MasterDto();
				master.setCode(reason.getCode());
				master.setDescription(reason.getDescription());
				master.setId(reason.getId());
				master.setName(reason.getName());
				masterDtoList.add(master);
			}
		}
		return masterDtoList;
	}

}
