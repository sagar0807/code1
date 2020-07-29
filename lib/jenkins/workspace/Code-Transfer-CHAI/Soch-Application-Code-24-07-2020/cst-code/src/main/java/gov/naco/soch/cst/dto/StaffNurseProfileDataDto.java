package gov.naco.soch.cst.dto;

import java.util.List;

public class StaffNurseProfileDataDto {

	private List<MiniProfileOIDto> miniProfileOIData;
	private ProfileIptStatusDto iptStatus;
	private ProfileTbStatusDto tbStatus;

	public List<MiniProfileOIDto> getMiniProfileOIData() {
		return miniProfileOIData;
	}

	public void setMiniProfileOIData(List<MiniProfileOIDto> miniProfileOIData) {
		this.miniProfileOIData = miniProfileOIData;
	}

	public ProfileIptStatusDto getIptStatus() {
		return iptStatus;
	}

	public void setIptStatus(ProfileIptStatusDto iptStatus) {
		this.iptStatus = iptStatus;
	}

	public ProfileTbStatusDto getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(ProfileTbStatusDto tbStatus) {
		this.tbStatus = tbStatus;
	}

}
