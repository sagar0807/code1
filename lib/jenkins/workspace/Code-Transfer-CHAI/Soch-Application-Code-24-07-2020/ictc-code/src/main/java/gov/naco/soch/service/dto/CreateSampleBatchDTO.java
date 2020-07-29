package gov.naco.soch.service.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class CreateSampleBatchDTO {

	private String consignmentId;
	
	private Long labId;
	
	private Long facilityId;
	
	private Set<Long> sampleIds;
	
	private LocalDateTime dispatchDate;

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Set<Long> getSampleIds() {
		return sampleIds;
	}

	public void setSampleIds(Set<Long> sampleIds) {
		this.sampleIds = sampleIds;
	}
	
	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	@Override
	public String toString() {
		return "CreateSampleBatchDTO [consignmentId=" + consignmentId + ", labId=" + labId + ", facilityId="
				+ facilityId + ", sampleIds=" + sampleIds + "]";
	}

}
