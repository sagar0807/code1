package gov.naco.soch.service.dto;

public class IctcBeneficiaryDeleteDTO {
	
	private Long ictcBeneficiaryId;
	
	private Integer deletedReason;
	
	private String deletedReasonComment;

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Integer getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(Integer deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String getDeletedReasonComment() {
		return deletedReasonComment;
	}

	public void setDeletedReasonComment(String deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
	}

	@Override
	public String toString() {
		return "IctcBeneficiaryDeleteDTO [ictcBeneficiaryId=" + ictcBeneficiaryId + ", deletedReason=" + deletedReason
				+ ", deletedReasonComment=" + deletedReasonComment + "]";
	}
	
}
