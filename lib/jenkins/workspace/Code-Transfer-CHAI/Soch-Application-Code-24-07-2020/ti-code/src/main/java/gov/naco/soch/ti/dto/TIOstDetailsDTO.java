package gov.naco.soch.ti.dto;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIOstDetails} entity.
 */
public class TIOstDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String ostId;
	private String currentDose;
	private String dispensationStatus;
	private LocalDate dispensedLastDate;
	private LocalDate nextFollowUpDate;
	private String ostInitiated;
	private Integer ostNumber;
	private String currentOstStatus;
    private Long facilityId;
    private Long beneficiaryId;
  
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the ostId
	 */
	public String getOstId() {
		return ostId;
	}

	/**
	 * @param ostId the ostId to set
	 */
	public void setOstId(String ostId) {
		this.ostId = ostId;
	}

	/**
	 * @return the currentDose
	 */
	public String getCurrentDose() {
		return currentDose;
	}

	/**
	 * @param currentDose the currentDose to set
	 */
	public void setCurrentDose(String currentDose) {
		this.currentDose = currentDose;
	}

	/**
	 * @return the dispensationStatus
	 */
	public String getDispensationStatus() {
		return dispensationStatus;
	}

	/**
	 * @param dispensationStatus the dispensationStatus to set
	 */
	public void setDispensationStatus(String dispensationStatus) {
		this.dispensationStatus = dispensationStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dispensedLastDate
	 */
	public LocalDate getDispensedLastDate() {
		return dispensedLastDate;
	}

	/**
	 * @param dispensedLastDate the dispensedLastDate to set
	 */
	public void setDispensedLastDate(LocalDate dispensedLastDate) {
		this.dispensedLastDate = dispensedLastDate;
	}

	
	/**
	 * @return the nextFollowUpDate
	 */
	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	/**
	 * @param nextFollowUpDate the nextFollowUpDate to set
	 */
	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	/**
	 * @return the ostInitiated
	 */
	public String getOstInitiated() {
		return ostInitiated;
	}

	/**
	 * @param ostInitiated the ostInitiated to set
	 */
	public void setOstInitiated(String ostInitiated) {
		this.ostInitiated = ostInitiated;
	}

	/**
	 * @return the ostNumber
	 */
	public Integer getOstNumber() {
		return ostNumber;
	}

	/**
	 * @param ostNumber the ostNumber to set
	 */
	public void setOstNumber(Integer ostNumber) {
		this.ostNumber = ostNumber;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	/**
	 * @return the currentOstStatus
	 */
	public String getCurrentOstStatus() {
		return currentOstStatus;
	}

	/**
	 * @param currentOstStatus the currentOstStatus to set
	 */
	public void setCurrentOstStatus(String currentOstStatus) {
		this.currentOstStatus = currentOstStatus;
	}

	@Override
	public String toString() {
		return "TIOstDetailsDTO [ostId=" + ostId + ", currentDose=" + currentDose + ", dispensationStatus="
				+ dispensationStatus + ", dispensedLastDate=" + dispensedLastDate + ", nextFollowUpDate="
				+ nextFollowUpDate + ", ostInitiated=" + ostInitiated + ", ostNumber=" + ostNumber
				+ ", currentOstStatus=" + currentOstStatus + ", facilityId=" + facilityId + ", beneficiaryId="
				+ beneficiaryId + "]";
	}

	
	
	
	

	  
		

	
}
