package gov.naco.soch.cst.dto;

import java.util.List;

public class ProfileWidgetDashBoardDto {

	private List<ProfileWidgetDto> cdFourTable;
	private List<ProfileWidgetDto> vlValueTable;
	private ProfileTestCountDto cdTestCount;
	private ProfileTestCountDto vlTestCount;

	public List<ProfileWidgetDto> getCdFourTable() {
		return cdFourTable;
	}

	public void setCdFourTable(List<ProfileWidgetDto> cdFourTable) {
		this.cdFourTable = cdFourTable;
	}

	public List<ProfileWidgetDto> getVlValueTable() {
		return vlValueTable;
	}

	public void setVlValueTable(List<ProfileWidgetDto> vlValueTable) {
		this.vlValueTable = vlValueTable;
	}

	public ProfileTestCountDto getCdTestCount() {
		return cdTestCount;
	}

	public void setCdTestCount(ProfileTestCountDto cdTestCount) {
		this.cdTestCount = cdTestCount;
	}

	public ProfileTestCountDto getVlTestCount() {
		return vlTestCount;
	}

	public void setVlTestCount(ProfileTestCountDto vlTestCount) {
		this.vlTestCount = vlTestCount;
	}

}
