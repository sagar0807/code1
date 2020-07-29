package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Objects;

import gov.naco.soch.dto.MiniMasterDto;

public class TIOstPrescriptionDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Double dosageQty;

	private Boolean isActive;

	private Boolean isDelete;

	private LocalDate ostPrescriptionDate;

	private MiniMasterDto product;

	private Long facilityId;
	
	private Long beneficiaryId;
	
    private Long assessmentId;
    
    private Long followUpId;
    
public TIOstPrescriptionDTO() {

}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDosageQty() {
		return dosageQty;
	}

	public void setDosageQty(Double dosageQty) {
		this.dosageQty = dosageQty;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LocalDate getOstPrescriptionDate() {
		return ostPrescriptionDate;
	}

	public void setOstPrescriptionDate(LocalDate ostPrescriptionDate) {
		this.ostPrescriptionDate = ostPrescriptionDate;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}


	public MiniMasterDto getProduct() {
		return product;
	}

	public void setProduct(MiniMasterDto product) {
		this.product = product;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
	

//    public TIOstAssessDTO getTiOstAssessment() {
//		return tiOstAssessment;
//	}
//
//	public void setTiOstAssessment(TIOstAssessDTO tiOstAssessment) {
//		this.tiOstAssessment = tiOstAssessment;
//	}
//
//	public TIBenFollowUpDTO getTiOstFollowUp() {
//		return tiOstFollowUp;
//	}
//
//	public void setTiOstFollowUp(TIBenFollowUpDTO tiOstFollowUp) {
//		this.tiOstFollowUp = tiOstFollowUp;
//	}

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIOstPrescriptionDTO tIOstPrescriptionDTO = (TIOstPrescriptionDTO) o;
		if (tIOstPrescriptionDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIOstPrescriptionDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
