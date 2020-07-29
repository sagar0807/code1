package gov.naco.soch.dto;

import java.io.Serializable;
import java.util.Objects;

public class TIBenChildrenDetailsDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer age;

    private String gender;
    
    private Long facilityId;

    private Long beneficiaryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long tIBeneficiaryId) {
        this.beneficiaryId = tIBeneficiaryId;
    }

    
    
    public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TIBenChildrenDetailsDTO tIBenChildDetailsDTO = (TIBenChildrenDetailsDTO) o;
        if (tIBenChildDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIBenChildDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "TIBenChildrenDetailsDTO [id=" + id + ", age=" + age + ", gender=" + gender + ", facilityId="
				+ facilityId + ", beneficiaryId=" + beneficiaryId + "]";
	}

}

