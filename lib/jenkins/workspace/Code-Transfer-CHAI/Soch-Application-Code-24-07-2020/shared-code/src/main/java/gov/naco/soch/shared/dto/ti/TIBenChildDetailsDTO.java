package gov.naco.soch.shared.dto.ti;
import java.io.Serializable;
import java.util.Objects;

import gov.naco.soch.dto.MiniMasterDto;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenChildDetails} entity.
 */
public class TIBenChildDetailsDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer age;


    private MiniMasterDto genderId;

   
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

    public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long tIBeneficiaryId) {
        this.beneficiaryId = tIBeneficiaryId;
    }

    public MiniMasterDto getGenderId() {
		return genderId;
	}

	public void setGenderId(MiniMasterDto genderId) {
		this.genderId = genderId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TIBenChildDetailsDTO tIBenChildDetailsDTO = (TIBenChildDetailsDTO) o;
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
		return "TIBenChildDetailsDTO [id=" + id + ", age=" + age + ", genderId=" + genderId + ", facilityId="
				+ facilityId + ", beneficiaryId=" + beneficiaryId + "]";
	}

	

   
}
