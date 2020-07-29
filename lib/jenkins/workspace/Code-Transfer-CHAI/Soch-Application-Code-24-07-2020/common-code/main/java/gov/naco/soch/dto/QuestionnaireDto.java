package gov.naco.soch.dto;

import java.util.List;
import java.util.Map;

public class QuestionnaireDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Integer id;
	private String surveyName;
	private String description;
	private boolean isActive;
	private List<QuestionDto> questions;
	private Map<String, String> editAnswer;
	public QuestionnaireDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<QuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Map<String, String> getEditAnswer() {
		return editAnswer;
	}

	public void setEditAnswer(Map<String, String> editAnswer) {
		this.editAnswer = editAnswer;
	}
	

}
