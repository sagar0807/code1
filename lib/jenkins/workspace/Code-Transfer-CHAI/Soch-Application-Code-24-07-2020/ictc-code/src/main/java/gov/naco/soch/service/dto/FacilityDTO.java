package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.Facility} entity.
 */
public class FacilityDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String name;

    private String code;

    private Long facilityTypeId;


    private Long addressId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Long facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FacilityDTO facilityDTO = (FacilityDTO) o;
        if (facilityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), facilityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FacilityDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", facilityTypeId=" + getFacilityTypeId() +
            ", addressId=" + getAddressId() +
            "}";
    }
}
