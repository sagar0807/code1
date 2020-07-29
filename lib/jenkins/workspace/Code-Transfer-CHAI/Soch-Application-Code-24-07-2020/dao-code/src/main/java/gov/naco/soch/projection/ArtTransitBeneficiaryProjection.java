package gov.naco.soch.projection;

public interface ArtTransitBeneficiaryProjection {

	Long getBeneficiaryId();

	String getBeneficiaryUId();

	String getFirstname();
	
	String getMiddlename();

	String getLastname();

	String getGender();

	String getPreArtNumber();

	String getArtNumber();

	void setBeneficiaryId(Long beneficiaryId);

	void setBeneficiaryUId(String beneficiaryUId);

	void setFirstname(String firstname);
	
	void setMiddlename(String lastname);

	void setLastname(String lastname);

	void setGender(String gender);

	void setPreArtNumber(String preArtNumber);

	void setArtNumber(String artNumber);

}
