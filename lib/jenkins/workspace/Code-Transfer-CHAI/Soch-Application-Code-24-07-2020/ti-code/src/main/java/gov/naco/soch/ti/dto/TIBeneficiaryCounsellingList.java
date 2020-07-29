package gov.naco.soch.ti.dto;

import java.time.LocalDate;

public interface TIBeneficiaryCounsellingList {
	Long getBeneficiaryId();
	String getBeneficiaryUId();
	String getTiCode();
	String getTypology();
	String getGender();
	Long getAge();
	String getClientStatus();
	LocalDate getLastCouncellingDate();
}
