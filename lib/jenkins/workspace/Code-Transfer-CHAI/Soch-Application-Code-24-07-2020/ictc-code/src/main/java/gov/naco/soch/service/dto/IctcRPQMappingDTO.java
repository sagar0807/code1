package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.IctcRPQMapping} entity.
 */
public class IctcRPQMappingDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Long pid;

    private Long visitId;

    private Long rpqId;

    private String answer;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getRpqId() {
        return rpqId;
    }

    public void setRpqId(Long rpqId) {
        this.rpqId = rpqId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
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

        IctcRPQMappingDTO ictcRPQMappingDTO = (IctcRPQMappingDTO) o;
        if (ictcRPQMappingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ictcRPQMappingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IctcRPQMappingDTO{" +
            "id=" + getId() +
            ", pid=" + getPid() +
            ", visitId=" + getVisitId() +
            ", rpqId=" + getRpqId() +
            ", answer='" + getAnswer() + "'" +
            "}";
    }
}
