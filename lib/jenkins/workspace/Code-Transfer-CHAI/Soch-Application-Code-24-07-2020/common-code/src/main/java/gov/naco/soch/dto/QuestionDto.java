package gov.naco.soch.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class QuestionDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	public QuestionDto() {
		super();
	}

	private Integer id;

	@NotEmpty(message = "Name is mandatory")
	@Size(max = 15, message = "name field size shouldn't exceed 15 characters")
	private String name;

	private String title;
	private String choiceType;
	private ArrayList<ChoiceDetailsDto> choiceDetailss;
//	private String visibleIf;
	private String visibleIfCondition;
	private String visibleIfOption;
	private String visibleIfQuestion;
	private String choices;
	private String answers;
	private boolean isEditable;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public ArrayList<ChoiceDetailsDto> getChoiceDetailss() {
		return choiceDetailss;
	}

	public void setChoiceDetailss(ArrayList<ChoiceDetailsDto> choiceDetailss) {
		this.choiceDetailss = choiceDetailss;
	}

	public String getChoiceType() {
		return choiceType;
	}

	public void setChoiceType(String choiceType) {
		this.choiceType = choiceType;
	}

	public String getVisibleIfCondition() {
		return visibleIfCondition;
	}

	public void setVisibleIfCondition(String visibleIfCondition) {
		this.visibleIfCondition = visibleIfCondition;
	}

	public String getVisibleIfOption() {
		return visibleIfOption;
	}

	public void setVisibleIfOption(String visibleIfOption) {
		this.visibleIfOption = visibleIfOption;
	}

	public String getVisibleIfQuestion() {
		return visibleIfQuestion;
	}

	public void setVisibleIfQuestion(String visibleIfQuestion) {
		this.visibleIfQuestion = visibleIfQuestion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getChoices() {
		return choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}
	
}

