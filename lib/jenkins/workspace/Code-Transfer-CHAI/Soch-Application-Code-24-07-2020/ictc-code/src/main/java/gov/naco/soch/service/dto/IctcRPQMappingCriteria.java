package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.IctcRPQMapping} entity. This class is used
 * in {@link gov.naco.soch.web.rest.IctcRPQMappingResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-rpq-mappings?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class IctcRPQMappingCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter pid;

    private LongFilter visitId;

    private LongFilter rpqId;

    private StringFilter answer;

    public IctcRPQMappingCriteria() {
    }

    public IctcRPQMappingCriteria(IctcRPQMappingCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.pid = other.pid == null ? null : other.pid.copy();
        this.visitId = other.visitId == null ? null : other.visitId.copy();
        this.rpqId = other.rpqId == null ? null : other.rpqId.copy();
        this.answer = other.answer == null ? null : other.answer.copy();
    }

    @Override
    public IctcRPQMappingCriteria copy() {
        return new IctcRPQMappingCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getPid() {
        return pid;
    }

    public void setPid(LongFilter pid) {
        this.pid = pid;
    }

    public LongFilter getVisitId() {
        return visitId;
    }

    public void setVisitId(LongFilter visitId) {
        this.visitId = visitId;
    }

    public LongFilter getRpqId() {
        return rpqId;
    }

    public void setRpqId(LongFilter rpqId) {
        this.rpqId = rpqId;
    }

    public StringFilter getAnswer() {
        return answer;
    }

    public void setAnswer(StringFilter answer) {
        this.answer = answer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IctcRPQMappingCriteria that = (IctcRPQMappingCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(pid, that.pid) &&
            Objects.equals(visitId, that.visitId) &&
            Objects.equals(rpqId, that.rpqId) &&
            Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        pid,
        visitId,
        rpqId,
        answer
        );
    }

    @Override
    public String toString() {
        return "IctcRPQMappingCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (pid != null ? "pid=" + pid + ", " : "") +
                (visitId != null ? "visitId=" + visitId + ", " : "") +
                (rpqId != null ? "rpqId=" + rpqId + ", " : "") +
                (answer != null ? "answer=" + answer + ", " : "") +
            "}";
    }

}
