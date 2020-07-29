package gov.naco.soch.dto;

import java.util.List;

public class SurveyResponseDto extends BaseDto {

	private Integer id;
	private List<SurveyAnswerDto> answers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<SurveyAnswerDto> getAnswers() {
		return this.answers;
	}
	public void setAnswers(List<SurveyAnswerDto> answers) {
		this.answers = answers;
	}
	public String getAnswerForQuestionId( Integer questionId ) {
		SurveyAnswerDto response = answers.stream()
				.filter(ans -> questionId.equals(ans.id)).findAny().orElse(null);
		
		return (response==null) ? null :response.answer;
	}

	private static final long serialVersionUID = 1L;

	public SurveyResponseDto() {
		super();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
