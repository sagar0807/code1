package gov.naco.soch.cst.dto;

import java.util.List;

public class ProfileTableDataDto {

	private List<ProfileFamilyDetailsDto> familyDetails;
	private List<ProfileDispensationDetailsDto> dispensationDetails;

	public List<ProfileFamilyDetailsDto> getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(List<ProfileFamilyDetailsDto> familyDetails) {
		this.familyDetails = familyDetails;
	}

	public List<ProfileDispensationDetailsDto> getDispensationDetails() {
		return dispensationDetails;
	}

	public void setDispensationDetails(List<ProfileDispensationDetailsDto> dispensationDetails) {
		this.dispensationDetails = dispensationDetails;
	}

}
