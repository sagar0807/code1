package gov.naco.soch.dto;

import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class DashboardRequestDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long facilityId;
	private Integer interval;
	private List<Integer> gender;
	private List<Integer> typology;
	
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public Integer getInterval() {
		return interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public List<Integer> getGender() {
		return gender;
	}
	public void setGender(List<Integer> gender) {
		this.gender = gender;
	}
	public List<Integer> getTypology() {
		return typology;
	}
	public void setTypology(List<Integer> typology) {
		this.typology = typology;
	}

}
