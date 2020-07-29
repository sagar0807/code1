package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.RiskProfilingQuestions} entity.
 */
public class RiskProfilingQuestionsDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String question;

    private String answers;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RiskProfilingQuestionsDTO riskProfilingQuestionsDTO = (RiskProfilingQuestionsDTO) o;
        if (riskProfilingQuestionsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), riskProfilingQuestionsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RiskProfilingQuestionsDTO{" +
            "id=" + getId() +
            ", question='" + getQuestion() + "'" +
            ", answers='" + getAnswers() + "'" +
            "}";
    }
}
