package gov.naco.soch.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gov.naco.soch.entity.Question;

@Entity
public class Questionnaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String surveyName;
	private String description;

	@OneToMany(mappedBy = "questionnaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Question> questions = new ArrayList<Question>();
	
	public Questionnaire() {
		super();
	}
	
	public Questionnaire(String surveyName) {
		super();
		this.surveyName = surveyName;
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
	
	public Question addQuestion(Question question) {
		questions.add(question);
		question.setQuestionnaire(this);
		return question;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question removeQuestion(Question question) {
		questions.remove(question);
		question.setQuestionnaire(null);
		return question;
	}
	
	public void removeAllQuestions() {
		for (Question question : questions) {
			question.setQuestionnaire(null);
		}
		questions.clear();
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
}

