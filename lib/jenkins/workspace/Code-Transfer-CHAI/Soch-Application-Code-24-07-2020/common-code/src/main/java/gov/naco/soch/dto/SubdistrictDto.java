package gov.naco.soch.dto;

import java.util.List;

public class SubdistrictDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private Long districtId;
	private String districtName;
	private Long subdistrictId;
	private String subDistrictName;
	private List<TownDto> towns;
	
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Long getSubdistrictId() {
		return subdistrictId;
	}
	public void setSubdistrictId(Long subdistrictId) {
		this.subdistrictId = subdistrictId;
	}
	public String getSubDistrictName() {
		return subDistrictName;
	}
	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}
	public List<TownDto> getTowns() {
		return towns;
	}
	public void setTowns(List<TownDto> towns) {
		this.towns = towns;
	}
	@Override
	public String toString() {
		return "SubdistrictDto [subdistrictId=" + subdistrictId + ", subDistrictName=" + subDistrictName + ", towns="
				+ towns + "]";
	}
	
	

}
