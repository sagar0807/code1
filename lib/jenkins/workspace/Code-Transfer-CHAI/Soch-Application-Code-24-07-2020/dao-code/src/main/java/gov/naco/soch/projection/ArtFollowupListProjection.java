package gov.naco.soch.projection;

public interface ArtFollowupListProjection {

	//uid
	String getUid();
	void setUid(String uid);
	
	//benficiaryName
	String getBenficiaryName();
	void setBenficiaryName(String benficiaryName);
	
	//preArtNumber
	String getPreArtNumber();
	void setPreArtNumber(String preArtNumber);
	
	//mobileNumber
	String getMobileNumber();
	void setMobileNumber(String mobileNumber);
	
	//artNumber
	String getArtNumber();
	void setArtNumber(String artNumber);
	
	//age
	String getAge();
	void setAge(String age);
	
	//beneficiaryId
	Integer getBeneficiaryId();
	void setBeneficiaryId(Integer beneficiaryId);
	
	//facilityId
	Integer getFacilityId();
	void setFacilityId(Integer facilityId);
	
	//artBeneficiaryStatusId
	Integer getArtBeneficiaryStatusId();
	void setArtBeneficiaryStatusId(Integer artBeneficiaryStatusId);
	
	//artBeneficiaryStatusName
	String getArtBeneficiaryStatusName();
	void setArtBeneficiaryStatusName(String artBeneficiaryStatusName);
	
	//genderId
	Integer getGenderId();
	void setGenderId(Integer genderId);
	
	//genderName
	String getGenderName();
	void setGenderName(String genderName );
	
	
	
	
	
}
