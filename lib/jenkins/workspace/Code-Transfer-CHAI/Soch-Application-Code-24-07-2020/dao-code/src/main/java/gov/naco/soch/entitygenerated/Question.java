package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="choice_type")
	private Integer choiceType;

	private String choices;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String name;

	private String title;

	@Column(name="visible_if")
	private String visibleIf;

	//bi-directional many-to-one association to Questionnaire
	@ManyToOne
	private Questionnaire questionnaire;

	//bi-directional many-to-one association to SurveyAnswer
	@OneToMany(mappedBy="question")
	private Set<SurveyAnswer> surveyAnswers;

	public Question() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChoiceType() {
		return this.choiceType;
	}

	public void setChoiceType(Integer choiceType) {
		this.choiceType = choiceType;
	}

	public String getChoices() {
		return this.choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVisibleIf() {
		return this.visibleIf;
	}

	public void setVisibleIf(String visibleIf) {
		this.visibleIf = visibleIf;
	}

	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Set<SurveyAnswer> getSurveyAnswers() {
		return this.surveyAnswers;
	}

	public void setSurveyAnswers(Set<SurveyAnswer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public SurveyAnswer addSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().add(surveyAnswer);
		surveyAnswer.setQuestion(this);

		return surveyAnswer;
	}

	public SurveyAnswer removeSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().remove(surveyAnswer);
		surveyAnswer.setQuestion(null);

		return surveyAnswer;
	}

}