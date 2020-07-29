package gov.naco.soch.dto;

public class BeneficiaryFamilyDetailsDto {
	
	private Long id;

	private Integer ageMonths;

	private Integer ageYears;

	private String familyUid;

	private Boolean isActive;
	
	private Boolean isDelete;

	private Boolean isAlive;

	private Boolean isBeneficiary;

	private Boolean onArt;

	private Long partnerBeneficiaryId;
	
	private String partnerName;
	
	private String partnerUid;
	
	private MiniMasterDto masterGender;

	private MiniMasterDto masterHivStatus;

	private MiniMasterDto masterRelationship;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}

	public Integer getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
	}

	public String getFamilyUid() {
		return familyUid;
	}

	public void setFamilyUid(String familyUid) {
		this.familyUid = familyUid;
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
	
	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerUid() {
		return partnerUid;
	}

	public void setPartnerUid(String partnerUid) {
		this.partnerUid = partnerUid;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Boolean getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getOnArt() {
		return onArt;
	}

	public void setOnArt(Boolean onArt) {
		this.onArt = onArt;
	}

	public Long getPartnerBeneficiaryId() {
		return partnerBeneficiaryId;
	}

	public void setPartnerBeneficiaryId(Long partnerBeneficiaryId) {
		this.partnerBeneficiaryId = partnerBeneficiaryId;
	}

	public MiniMasterDto getMasterGender() {
		return masterGender;
	}

	public void setMasterGender(MiniMasterDto masterGender) {
		this.masterGender = masterGender;
	}

	public MiniMasterDto getMasterHivStatus() {
		return masterHivStatus;
	}

	public void setMasterHivStatus(MiniMasterDto masterHivStatus) {
		this.masterHivStatus = masterHivStatus;
	}

	public MiniMasterDto getMasterRelationship() {
		return masterRelationship;
	}

	public void setMasterRelationship(MiniMasterDto masterRelationship) {
		this.masterRelationship = masterRelationship;
	}
	
	
	
	

}
