package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.District} entity.
 */
public class DistrictDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String alternateName;

    private String name;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistrictDTO districtDTO = (DistrictDTO) o;
        if (districtDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), districtDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistrictDTO{" +
            "id=" + getId() +
            ", alternateName='" + getAlternateName() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
