package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class InventoryRelocateDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long facilityId;
	private Long to_facility;
	private List<InventoryDispatchDto> dispatchDetails;
	private LocalDate indentDate;
	private LocalDate expectedDispatchDate;
	private LocalDate expectedArrivalDate;
	private String courierName;
	private String driverName;
	private String mobileNumber;
	private String remarks;

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getTo_facility() {
		return to_facility;
	}

	public void setTo_facility(Long to_facility) {
		this.to_facility = to_facility;
	}

	public List<InventoryDispatchDto> getDispatchDetails() {
		return dispatchDetails;
	}

	public void setDispatchDetails(List<InventoryDispatchDto> dispatchDetails) {
		this.dispatchDetails = dispatchDetails;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public LocalDate getExpectedDispatchDate() {
		return expectedDispatchDate;
	}

	public void setExpectedDispatchDate(LocalDate expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public LocalDate getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
