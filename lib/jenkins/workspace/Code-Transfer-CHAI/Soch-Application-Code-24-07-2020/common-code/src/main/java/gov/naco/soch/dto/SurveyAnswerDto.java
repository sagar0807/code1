package gov.naco.soch.dto;

public class SurveyAnswerDto {
	
	public Integer id;
	public String answer;
	
	public SurveyAnswerDto() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
