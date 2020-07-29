package gov.naco.soch.ti.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenHRGDetails} entity.
 */
public class TIBenHRGDetailsDTO implements Serializable {

    private Long id;

    private String hrgPrimaryCategory;

    private String hrgSecondaryCategory;

    private String subCategory;

    private Integer avgNoSexualActsUponReg;

    private Integer noYearsInSexWork;

    private Boolean consumeAlcohol;

    private Integer alcoholConsDaysInWeek;

    private Integer createdBy;

    private ZonedDateTime createdTime;

    private Integer modifiedBy;

    private ZonedDateTime modifiedTime;


    private Long beneficiaryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHrgPrimaryCategory() {
        return hrgPrimaryCategory;
    }

    public void setHrgPrimaryCategory(String hrgPrimaryCategory) {
        this.hrgPrimaryCategory = hrgPrimaryCategory;
    }

    public String getHrgSecondaryCategory() {
        return hrgSecondaryCategory;
    }

    public void setHrgSecondaryCategory(String hrgSecondaryCategory) {
        this.hrgSecondaryCategory = hrgSecondaryCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getAvgNoSexualActsUponReg() {
        return avgNoSexualActsUponReg;
    }

    public void setAvgNoSexualActsUponReg(Integer avgNoSexualActsUponReg) {
        this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
    }

    public Integer getNoYearsInSexWork() {
        return noYearsInSexWork;
    }

    public void setNoYearsInSexWork(Integer noYearsInSexWork) {
        this.noYearsInSexWork = noYearsInSexWork;
    }

    public Boolean isConsumeAlcohol() {
        return consumeAlcohol;
    }

    public void setConsumeAlcohol(Boolean consumeAlcohol) {
        this.consumeAlcohol = consumeAlcohol;
    }

    public Integer getAlcoholConsDaysInWeek() {
        return alcoholConsDaysInWeek;
    }

    public void setAlcoholConsDaysInWeek(Integer alcoholConsDaysInWeek) {
        this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
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

        TIBenHRGDetailsDTO tIBenHRGDetailsDTO = (TIBenHRGDetailsDTO) o;
        if (tIBenHRGDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIBenHRGDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TIBenHRGDetailsDTO{" +
            "id=" + getId() +
            ", hrgPrimaryCategory='" + getHrgPrimaryCategory() + "'" +
            ", hrgSecondaryCategory='" + getHrgSecondaryCategory() + "'" +
            ", subCategory='" + getSubCategory() + "'" +
            ", avgNoSexualActsUponReg=" + getAvgNoSexualActsUponReg() +
            ", noYearsInSexWork=" + getNoYearsInSexWork() +
            ", consumeAlcohol='" + isConsumeAlcohol() + "'" +
            ", alcoholConsDaysInWeek=" + getAlcoholConsDaysInWeek() +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", beneficiary=" + getBeneficiaryId() +
            "}";
    }
}
