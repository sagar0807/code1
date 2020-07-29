package gov.naco.soch.cst.dto;

import java.util.List;

public class CounsellingNoteDto {
	
	private Long id;
	private Long beneficiaryId;
	private String cousellingNote;
	private List<CounsellingNoteOptionsDto> counsellingOptions;
	private List<CounsellingNoteAnswersDto> counsellingNoteAnswer;
	private String questionKey;
	private String cousellingSection;
	private Boolean firstVisit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getCousellingNote() {
		return cousellingNote;
	}
	public void setCousellingNote(String cousellingNote) {
		this.cousellingNote = cousellingNote;
	}
	
	public String getQuestionKey() {
		return questionKey;
	}
	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}
	public String getCousellingSection() {
		return cousellingSection;
	}
	public void setCousellingSection(String cousellingSection) {
		this.cousellingSection = cousellingSection;
	}
	public List<CounsellingNoteOptionsDto> getCounsellingOptions() {
		return counsellingOptions;
	}
	public void setCounsellingOptions(List<CounsellingNoteOptionsDto> counsellingOptions) {
		this.counsellingOptions = counsellingOptions;
	}
	
	public List<CounsellingNoteAnswersDto> getCounsellingNoteAnswer() {
		return counsellingNoteAnswer;
	}
	public void setCounsellingNoteAnswer(List<CounsellingNoteAnswersDto> counsellingNoteAnswer) {
		this.counsellingNoteAnswer = counsellingNoteAnswer;
	}
	public Boolean getFirstVisit() {
		return firstVisit;
	}
	public void setFirstVisit(Boolean firstVisit) {
		this.firstVisit = firstVisit;
	}
	
	
	@Override
	public String toString() {
		return "ArtRegistrationDto [id=" + id + ", beneficiaryId=" + beneficiaryId + ", cousellingNote=" + cousellingNote
				+", questionKey=" + questionKey
				+ ", cousellingSection=" + cousellingSection + ",firstVisit=" + firstVisit +"]";
	}
	

}
