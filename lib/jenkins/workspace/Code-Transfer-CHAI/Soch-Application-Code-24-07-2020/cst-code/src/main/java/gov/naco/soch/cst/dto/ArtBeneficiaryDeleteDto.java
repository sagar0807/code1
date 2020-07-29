package gov.naco.soch.cst.dto;

public class ArtBeneficiaryDeleteDto {
	
	private Long beneficiaryId;
	private Long facilityId;
	private Long deleteReasonId;
	private String deleteReason;
	private String firstName;
	
	
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public Long getDeleteReasonId() {
		return deleteReasonId;
	}
	public void setDeleteReasonId(Long deleteReasonId) {
		this.deleteReasonId = deleteReasonId;
	}
	public String getDeleteReason() {
		return deleteReason;
	}
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "ArtBeneficiaryDeleteDto [beneficiaryId=" + beneficiaryId + ", facilityId=" + facilityId
				+ ", deleteReasonId=" + deleteReasonId + ", deleteReason=" + deleteReason + ", firstName=" + firstName
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
