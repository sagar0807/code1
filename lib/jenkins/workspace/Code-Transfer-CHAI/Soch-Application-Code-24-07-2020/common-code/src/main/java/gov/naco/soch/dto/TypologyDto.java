package gov.naco.soch.dto;

public class TypologyDto  extends BaseDto {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String typologyName;
    private Long typologyTarget;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypologyName() {
		return typologyName;
	}
	public void setTypologyName(String typologyName) {
		this.typologyName = typologyName;
	}
	
	public Long getTypologyTarget() {
		return typologyTarget;
	}
	public void setTypologyTarget(Long typologyTarget) {
		this.typologyTarget = typologyTarget;
	}
	@Override
	public String toString() {
		return "TypologyDto [id=" + id + ", typologyName=" + typologyName + ", typologyTarget=" + typologyTarget + "]";
	}


}
