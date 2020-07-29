package gov.naco.soch.cst.dto;

public class CounsellingNoteOptionsDto {

	private Long id;
	private Long counsellingNoteId;
	private String counsellingOption;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCounsellingNoteId() {
		return counsellingNoteId;
	}
	public void setCounsellingNoteId(Long counsellingNoteId) {
		this.counsellingNoteId = counsellingNoteId;
	}
	public String getCounsellingOption() {
		return counsellingOption;
	}
	public void setCounsellingOption(String counsellingOption) {
		this.counsellingOption = counsellingOption;
	}

}
