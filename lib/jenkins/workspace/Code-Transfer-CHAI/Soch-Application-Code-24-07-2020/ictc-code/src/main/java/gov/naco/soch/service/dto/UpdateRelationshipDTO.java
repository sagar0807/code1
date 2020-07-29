package gov.naco.soch.service.dto;

public class UpdateRelationshipDTO {
	
	private Long ictcBeneficiaryId;
	
	private Long relationshipRecordId;
	
	private Integer relationshipType;
	
	private Long followUpId;

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long getRelationshipRecordId() {
		return relationshipRecordId;
	}

	public void setRelationshipRecordId(Long relationshipRecordId) {
		this.relationshipRecordId = relationshipRecordId;
	}

	public Integer getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(Integer relationshipType) {
		this.relationshipType = relationshipType;
	}
	
	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}

	@Override
	public String toString() {
		return "UpdateRelationshipDTO [ictcBeneficiaryId=" + ictcBeneficiaryId + ", relationshipRecordId="
				+ relationshipRecordId + ", relationshipType=" + relationshipType + ", followUpId=" + followUpId + "]";
	}

}
