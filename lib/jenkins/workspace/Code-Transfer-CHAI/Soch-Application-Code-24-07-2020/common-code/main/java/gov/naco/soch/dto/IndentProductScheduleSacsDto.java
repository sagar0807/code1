package gov.naco.soch.dto;

import java.util.List;

public class IndentProductScheduleSacsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	Long scheduleSacsId;
	Long facilityId;
	String facilityName;
	List<IndentProductScheduleSacsLotDto> lots;

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public List<IndentProductScheduleSacsLotDto> getLots() {
		return lots;
	}

	public void setLots(List<IndentProductScheduleSacsLotDto> lots) {
		this.lots = lots;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getScheduleSacsId() {
		return scheduleSacsId;
	}

	public void setScheduleSacsId(Long scheduleSacsId) {
		this.scheduleSacsId = scheduleSacsId;
	}

}
