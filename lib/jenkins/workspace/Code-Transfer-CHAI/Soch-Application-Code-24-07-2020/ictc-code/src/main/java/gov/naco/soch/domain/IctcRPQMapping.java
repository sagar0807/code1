package gov.naco.soch.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A IctcRPQMapping.
 */
@Entity
@Table(name = "ictc_rpq_mapping")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class IctcRPQMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "rpq_id")
    private Long rpqId;

    @Column(name = "answer")
    private String answer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public IctcRPQMapping pid(Long pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVisitId() {
        return visitId;
    }

    public IctcRPQMapping visitId(Long visitId) {
        this.visitId = visitId;
        return this;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getRpqId() {
        return rpqId;
    }

    public IctcRPQMapping rpqId(Long rpqId) {
        this.rpqId = rpqId;
        return this;
    }

    public void setRpqId(Long rpqId) {
        this.rpqId = rpqId;
    }

    public String getAnswer() {
        return answer;
    }

    public IctcRPQMapping answer(String answer) {
        this.answer = answer;
        return this;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IctcRPQMapping)) {
            return false;
        }
        return id != null && id.equals(((IctcRPQMapping) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "IctcRPQMapping{" +
            "id=" + getId() +
            ", pid=" + getPid() +
            ", visitId=" + getVisitId() +
            ", rpqId=" + getRpqId() +
            ", answer='" + getAnswer() + "'" +
            "}";
    }
}
