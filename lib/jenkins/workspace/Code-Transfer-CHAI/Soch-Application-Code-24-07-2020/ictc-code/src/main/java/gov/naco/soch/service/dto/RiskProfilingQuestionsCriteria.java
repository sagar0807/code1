package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.RiskProfilingQuestions} entity. This class is used
 * in {@link gov.naco.soch.web.rest.RiskProfilingQuestionsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /risk-profiling-questions?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RiskProfilingQuestionsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter question;

    private StringFilter answers;

    public RiskProfilingQuestionsCriteria() {
    }

    public RiskProfilingQuestionsCriteria(RiskProfilingQuestionsCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.question = other.question == null ? null : other.question.copy();
        this.answers = other.answers == null ? null : other.answers.copy();
    }

    @Override
    public RiskProfilingQuestionsCriteria copy() {
        return new RiskProfilingQuestionsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getQuestion() {
        return question;
    }

    public void setQuestion(StringFilter question) {
        this.question = question;
    }

    public StringFilter getAnswers() {
        return answers;
    }

    public void setAnswers(StringFilter answers) {
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
        final RiskProfilingQuestionsCriteria that = (RiskProfilingQuestionsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(question, that.question) &&
            Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        question,
        answers
        );
    }

    @Override
    public String toString() {
        return "RiskProfilingQuestionsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (question != null ? "question=" + question + ", " : "") +
                (answers != null ? "answers=" + answers + ", " : "") +
            "}";
    }

}
