package gov.naco.soch.service.dto;

import java.time.LocalDate;
import java.util.List;

public class ICTCPregancyFollowUpDTO {
	
	private Long followUpId;
	
	private Long visitId;
	
	private LocalDate deliveryDate;
	
	private Integer deliveryOutcome;
	
	private Integer gravida;
	
	private List<ICTCFollowUpDTO> followUps;

	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(Integer deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public Integer getGravida() {
		return gravida;
	}

	public void setGravida(Integer gravida) {
		this.gravida = gravida;
	}

	public List<ICTCFollowUpDTO> getFollowUps() {
		return followUps;
	}

	public void setFollowUps(List<ICTCFollowUpDTO> followUps) {
		this.followUps = followUps;
	}

	@Override
	public String toString() {
		return "ICTCPregancyFollowUpDTO [followUpId=" + followUpId + ", visitId=" + visitId + ", deliveryDate="
				+ deliveryDate + ", deliveryOutcome=" + deliveryOutcome + ", gravida=" + gravida + ", followUps="
				+ followUps + "]";
	}
	
}
