package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the survey database table.
 * 
 */
@Entity
@NamedQuery(name="Survey.findAll", query="SELECT s FROM Survey s")
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

	//bi-directional many-to-one association to Questionnaire
	@ManyToOne
	private Questionnaire questionnaire;

	//bi-directional many-to-one association to SurveyAnswer
	@OneToMany(mappedBy="survey")
	private Set<SurveyAnswer> surveyAnswers;

	public Survey() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		surveyAnswer.setSurvey(this);

		return surveyAnswer;
	}

	public SurveyAnswer removeSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().remove(surveyAnswer);
		surveyAnswer.setSurvey(null);

		return surveyAnswer;
	}

}