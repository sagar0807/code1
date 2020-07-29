package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.Facility} entity.
 */
public class FacilityDTO implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private Long id;

    private String name;

    private String code;

    private Long addressId;

    private Long divisionId;

    private Long facilityTypeId;

    private Long parentFacilityId;

    private Boolean isActive;

    private Boolean isDelete;

    private String status;

   
public FacilityDTO() {
    
}
    
    public FacilityDTO(Long id) {
	super();
	this.id = id;
    }

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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public Long getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Long facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public Long getParentFacilityId() {
        return parentFacilityId;
    }

    public void setParentFacilityId(Long parentFacilityId) {
        this.parentFacilityId = parentFacilityId;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

   
}
