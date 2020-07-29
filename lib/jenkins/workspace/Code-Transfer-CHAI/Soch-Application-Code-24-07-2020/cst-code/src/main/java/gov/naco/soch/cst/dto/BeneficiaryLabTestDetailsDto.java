
package gov.naco.soch.cst.dto;

import java.time.LocalDate;

public class BeneficiaryLabTestDetailsDto {

	private String baselineCD4Count;
	private LocalDate baselineCD4Date;
	private LocalDate latestCD4Date;
	private LocalDate nextCD4Duedate;
	private String lastCD4Count;
	private String viralLoadBaselineCount;
	private String viralLoadBaselineCountValue;
	private LocalDate viralLoadBaselineDate;
	private LocalDate latestViralLoadDate;
	private LocalDate viralLoadNextDate;
	private String lastViralCount;
	private String lastViralCountValue;

	public String getBaselineCD4Count() {
		return baselineCD4Count;
	}

	public void setBaselineCD4Count(String baselineCD4Count) {
		this.baselineCD4Count = baselineCD4Count;
	}

	public LocalDate getBaselineCD4Date() {
		return baselineCD4Date;
	}

	public void setBaselineCD4Date(LocalDate baselineCD4Date) {
		this.baselineCD4Date = baselineCD4Date;
	}

	public LocalDate getLatestCD4Date() {
		return latestCD4Date;
	}

	public void setLatestCD4Date(LocalDate latestCD4Date) {
		this.latestCD4Date = latestCD4Date;
	}

	public LocalDate getNextCD4Duedate() {
		return nextCD4Duedate;
	}

	public void setNextCD4Duedate(LocalDate nextCD4Duedate) {
		this.nextCD4Duedate = nextCD4Duedate;
	}

	public String getLastCD4Count() {
		return lastCD4Count;
	}

	public void setLastCD4Count(String lastCD4Count) {
		this.lastCD4Count = lastCD4Count;
	}

	public String getViralLoadBaselineCount() {
		return viralLoadBaselineCount;
	}

	public void setViralLoadBaselineCount(String viralLoadBaselineCount) {
		this.viralLoadBaselineCount = viralLoadBaselineCount;
	}

	public String getViralLoadBaselineCountValue() {
		return viralLoadBaselineCountValue;
	}

	public void setViralLoadBaselineCountValue(String viralLoadBaselineCountValue) {
		this.viralLoadBaselineCountValue = viralLoadBaselineCountValue;
	}

	public LocalDate getViralLoadBaselineDate() {
		return viralLoadBaselineDate;
	}

	public void setViralLoadBaselineDate(LocalDate viralLoadBaselineDate) {
		this.viralLoadBaselineDate = viralLoadBaselineDate;
	}

	public LocalDate getLatestViralLoadDate() {
		return latestViralLoadDate;
	}

	public void setLatestViralLoadDate(LocalDate latestViralLoadDate) {
		this.latestViralLoadDate = latestViralLoadDate;
	}

	public LocalDate getViralLoadNextDate() {
		return viralLoadNextDate;
	}

	public void setViralLoadNextDate(LocalDate viralLoadNextDate) {
		this.viralLoadNextDate = viralLoadNextDate;
	}

	public String getLastViralCount() {
		return lastViralCount;
	}

	public void setLastViralCount(String lastViralCount) {
		this.lastViralCount = lastViralCount;
	}

	public String getLastViralCountValue() {
		return lastViralCountValue;
	}

	public void setLastViralCountValue(String lastViralCountValue) {
		this.lastViralCountValue = lastViralCountValue;
	}

}
