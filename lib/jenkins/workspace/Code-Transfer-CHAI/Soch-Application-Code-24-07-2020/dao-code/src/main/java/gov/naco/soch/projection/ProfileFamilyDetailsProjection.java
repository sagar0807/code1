package gov.naco.soch.projection;

public interface ProfileFamilyDetailsProjection {
	Long getBeneficiaryId();

	String getBeneficiaryName();

	String getRelationType();

	String getArtStatus();

	Long getArtNumber();

	Long getPreArtNumber();
}
