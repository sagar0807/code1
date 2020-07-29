package gov.naco.soch.ti.dto;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIOstDrugDispensation} entity.
 */
public class TIOstDrugDispensationDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer productId;

    private LocalDate nextFollowUpDate;

    private Boolean hivTestingDue;

    private String clientStatus;

    private Boolean isActive;

    private Boolean isDelete;

    private Long beneficiaryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LocalDate getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public Boolean isHivTestingDue() {
        return hivTestingDue;
    }

    public void setHivTestingDue(Boolean hivTestingDue) {
        this.hivTestingDue = hivTestingDue;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
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

   

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long tIBeneficiaryId) {
        this.beneficiaryId = tIBeneficiaryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TIOstDrugDispensationDTO tIOstDrugDispensationDTO = (TIOstDrugDispensationDTO) o;
        if (tIOstDrugDispensationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIOstDrugDispensationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "TIOstDrugDispensationDTO [id=" + id + ", productId=" + productId + ", nextFollowUpDate="
				+ nextFollowUpDate + ", hivTestingDue=" + hivTestingDue + ", clientStatus=" + clientStatus
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", beneficiaryId=" + beneficiaryId + "]";
	}

   
}
