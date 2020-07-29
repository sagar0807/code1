package gov.naco.soch.dto;

public class TownDto  extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	
	private Long townId;
	private String townName;
	public Long getTownId() {
		return townId;
	}
	public void setTownId(Long townId) {
		this.townId = townId;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	@Override
	public String toString() {
		return "TownDto [townId=" + townId + ", townName=" + townName + "]";
	}
	
	

}
