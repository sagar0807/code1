package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenExtDetails} entity.
 */
public class TIBenExtDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String withinTheDistrictNoOfTimes;

	private String withinTheDistrictNoOfDays;

	private String withinTheStateNoOfTimes;

	private String withinTheStateNoOfDays;

	private String outsideTheStateNoOfTimes;

	private String outsideTheStateNoOfDays;

	private Boolean mondayAvbl;

	private Boolean tuesdayAvbl;

	private Boolean wednesdayAvbl;

	private Boolean thursdayAvbl;

	private Boolean fridayAvbl;

	private Boolean saturdayAvbl;

	private String referredFacility;

	private String referredTo;

	private String referralStatus;

	private Boolean isOutwardReferal;

	private String guardianName;

	private String relation;

	private String guardianContactNumber;

	private Long beneficiaryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWithinTheDistrictNoOfTimes() {
		return withinTheDistrictNoOfTimes;
	}

	public void setWithinTheDistrictNoOfTimes(String withinTheDistrictNoOfTimes) {
		this.withinTheDistrictNoOfTimes = withinTheDistrictNoOfTimes;
	}

	public String getWithinTheDistrictNoOfDays() {
		return withinTheDistrictNoOfDays;
	}

	public void setWithinTheDistrictNoOfDays(String withinTheDistrictNoOfDays) {
		this.withinTheDistrictNoOfDays = withinTheDistrictNoOfDays;
	}

	public String getWithinTheStateNoOfTimes() {
		return withinTheStateNoOfTimes;
	}

	public void setWithinTheStateNoOfTimes(String withinTheStateNoOfTimes) {
		this.withinTheStateNoOfTimes = withinTheStateNoOfTimes;
	}

	public String getWithinTheStateNoOfDays() {
		return withinTheStateNoOfDays;
	}

	public void setWithinTheStateNoOfDays(String withinTheStateNoOfDays) {
		this.withinTheStateNoOfDays = withinTheStateNoOfDays;
	}

	public String getOutsideTheStateNoOfTimes() {
		return outsideTheStateNoOfTimes;
	}

	public void setOutsideTheStateNoOfTimes(String outsideTheStateNoOfTimes) {
		this.outsideTheStateNoOfTimes = outsideTheStateNoOfTimes;
	}

	public String getOutsideTheStateNoOfDays() {
		return outsideTheStateNoOfDays;
	}

	public void setOutsideTheStateNoOfDays(String outsideTheStateNoOfDays) {
		this.outsideTheStateNoOfDays = outsideTheStateNoOfDays;
	}

	public Boolean isMondayAvbl() {
		return mondayAvbl;
	}

	public void setMondayAvbl(Boolean mondayAvbl) {
		this.mondayAvbl = mondayAvbl;
	}

	public Boolean isTuesdayAvbl() {
		return tuesdayAvbl;
	}

	public void setTuesdayAvbl(Boolean tuesdayAvbl) {
		this.tuesdayAvbl = tuesdayAvbl;
	}

	public Boolean isWednesdayAvbl() {
		return wednesdayAvbl;
	}

	public void setWednesdayAvbl(Boolean wednesdayAvbl) {
		this.wednesdayAvbl = wednesdayAvbl;
	}

	public Boolean isThursdayAvbl() {
		return thursdayAvbl;
	}

	public void setThursdayAvbl(Boolean thursdayAvbl) {
		this.thursdayAvbl = thursdayAvbl;
	}

	public Boolean isFridayAvbl() {
		return fridayAvbl;
	}

	public void setFridayAvbl(Boolean fridayAvbl) {
		this.fridayAvbl = fridayAvbl;
	}

	public Boolean isSaturdayAvbl() {
		return saturdayAvbl;
	}

	public void setSaturdayAvbl(Boolean saturdayAvbl) {
		this.saturdayAvbl = saturdayAvbl;
	}

	public String getReferredFacility() {
		return referredFacility;
	}

	public void setReferredFacility(String referredFacility) {
		this.referredFacility = referredFacility;
	}

	public String getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public String getReferralStatus() {
		return referralStatus;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public Boolean isIsOutwardReferal() {
		return isOutwardReferal;
	}

	public void setIsOutwardReferal(Boolean isOutwardReferal) {
		this.isOutwardReferal = isOutwardReferal;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getGuardianContactNumber() {
		return guardianContactNumber;
	}

	public void setGuardianContactNumber(String guardianContactNumber) {
		this.guardianContactNumber = guardianContactNumber;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long tIBeneficiaryId) {
		this.beneficiaryId = tIBeneficiaryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBenExtDetailsDTO tIBenExtDetailsDTO = (TIBenExtDetailsDTO) o;
		if (tIBenExtDetailsDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBenExtDetailsDTO.getId());
	}

	@Override
	public String toString() {
		return "TIBenExtDetailsDTO [id=" + id + ", withinTheDistrictNoOfTimes=" + withinTheDistrictNoOfTimes
				+ ", withinTheDistrictNoOfDays=" + withinTheDistrictNoOfDays + ", withinTheStateNoOfTimes="
				+ withinTheStateNoOfTimes + ", withinTheStateNoOfDays=" + withinTheStateNoOfDays
				+ ", outsideTheStateNoOfTimes=" + outsideTheStateNoOfTimes + ", outsideTheStateNoOfDays="
				+ outsideTheStateNoOfDays + ", mondayAvbl=" + mondayAvbl + ", tuesdayAvbl=" + tuesdayAvbl
				+ ", wednesdayAvbl=" + wednesdayAvbl + ", thursdayAvbl=" + thursdayAvbl + ", fridayAvbl=" + fridayAvbl
				+ ", saturdayAvbl=" + saturdayAvbl + ", referredFacility=" + referredFacility + ", referredTo="
				+ referredTo + ", referralStatus=" + referralStatus + ", isOutwardReferal=" + isOutwardReferal
				+ ", guardianName=" + guardianName + ", relation=" + relation + ", guardianContactNumber="
				+ guardianContactNumber + ", beneficiaryId=" + beneficiaryId + "]";
	}

}
