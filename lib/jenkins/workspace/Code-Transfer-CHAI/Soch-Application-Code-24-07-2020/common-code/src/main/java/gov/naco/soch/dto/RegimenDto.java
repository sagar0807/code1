package gov.naco.soch.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RegimenDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String regimenName;
	private boolean active;
	private Long adultPedId;
	private String adultPed;
	private Long lineId;
	private String line;
	private List<RegimenConstituentDto> regimenConstituentList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegimenName() {
		return regimenName;
	}
	public void setRegimenName(String regimenName) {
		this.regimenName = regimenName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAdultPed() {
		return adultPed;
	}
	public void setAdultPed(String adultPed) {
		this.adultPed = adultPed;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
	public Long getAdultPedId() {
		return adultPedId;
	}
	public void setAdultPedId(Long adultPedId) {
		this.adultPedId = adultPedId;
	}
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public void setRegimenConstituentList(List<RegimenConstituentDto> regimenConstituentList) {
		this.regimenConstituentList = regimenConstituentList;
	}
	public List<RegimenConstituentDto> getRegimenConstituentList() {
		return regimenConstituentList;
	}
	@Override
	public String toString() {
		return "RegimenDto [id=" + id + ", regimenName=" + regimenName + ", active=" + active + ", adultPedId="
				+ adultPedId + ", adultPed=" + adultPed + ", lineId=" + lineId + ", line=" + line
				+ ", regimenConstituentList=" + regimenConstituentList + "]";
	}
	
	
}
