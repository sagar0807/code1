package gov.naco.soch.ti.mapper;

import java.util.ArrayList;
import java.util.List;

import gov.naco.soch.projection.TIDispensationExpectedList;
import gov.naco.soch.ti.dto.TIDispensationExpectedListDTO;



public class TIDispensationListMapper {
	public static List<TIDispensationExpectedListDTO> mapToArtPatientReferralDto(List<TIDispensationExpectedList> tiDispensationExpectedList) {
		List<TIDispensationExpectedListDTO> dispensationList=new ArrayList<>();
		
		for(TIDispensationExpectedList tiDispensationList:tiDispensationExpectedList) {
			
			/*TIDispensationExpectedListDTO tiDispensationExpectedListDTO=new TIDispensationExpectedListDTO();
			tiDispensationExpectedListDTO.setBenficiaryId(tiDispensationList.getBeneficiaryId());
			tiDispensationExpectedListDTO.setChooseDrug(tiDispensationList.getChooseDrug());
			tiDispensationExpectedListDTO.setDosage(tiDispensationList.getDosage());
			tiDispensationExpectedListDTO.setFirstName(tiDispensationList.getFirstName());
			tiDispensationExpectedListDTO.setLastName(tiDispensationList.getLastName());
			tiDispensationExpectedListDTO.setMiddleName(tiDispensationList.getMiddleName());
			dispensationList.add(tiDispensationExpectedListDTO);*/
		}
		return dispensationList;
	}
}
