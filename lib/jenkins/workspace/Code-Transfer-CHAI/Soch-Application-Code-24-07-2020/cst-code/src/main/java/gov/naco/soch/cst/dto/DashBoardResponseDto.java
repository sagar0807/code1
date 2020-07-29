package gov.naco.soch.cst.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import gov.naco.soch.dto.DashBoardGraphDto;

@JsonInclude(Include.NON_EMPTY)
public class DashBoardResponseDto {

	private DashBoardGraphDto beneficiaryVisited = new DashBoardGraphDto();
	private DashBoardGraphDto beneficiaryDueForVisit = new DashBoardGraphDto();
	private DashBoardGraphDto beneficiaryMissedAppointment = new DashBoardGraphDto();
	private DashBoardGraphDto newBeneficiary = new DashBoardGraphDto();
	private DashBoardGraphDto newBeneficiaryInitiated = new DashBoardGraphDto();
	private DashBoardGraphDto artTransferInOut = new DashBoardGraphDto();
	private DashBoardGraphDto referredNotLinked = new DashBoardGraphDto();


	public DashBoardGraphDto getBeneficiaryVisited() {
		return beneficiaryVisited;
	}

	public void setBeneficiaryVisited(DashBoardGraphDto beneficiaryVisited) {
		this.beneficiaryVisited = beneficiaryVisited;
	}

	public DashBoardGraphDto getBeneficiaryDueForVisit() {
		return beneficiaryDueForVisit;
	}

	public void setBeneficiaryDueForVisit(DashBoardGraphDto beneficiaryDueForVisit) {
		this.beneficiaryDueForVisit = beneficiaryDueForVisit;
	}

	public DashBoardGraphDto getBeneficiaryMissedAppointment() {
		return beneficiaryMissedAppointment;
	}

	public void setBeneficiaryMissedAppointment(DashBoardGraphDto beneficiaryMissedAppointment) {
		this.beneficiaryMissedAppointment = beneficiaryMissedAppointment;
	}

	public DashBoardGraphDto getNewBeneficiary() {
		return newBeneficiary;
	}

	public void setNewBeneficiary(DashBoardGraphDto newBeneficiary) {
		this.newBeneficiary = newBeneficiary;
	}

	public DashBoardGraphDto getNewBeneficiaryInitiated() {
		return newBeneficiaryInitiated;
	}

	public void setNewBeneficiaryInitiated(DashBoardGraphDto newBeneficiaryInitiated) {
		this.newBeneficiaryInitiated = newBeneficiaryInitiated;
	}

	public DashBoardGraphDto getArtTransferInOut() {
		return artTransferInOut;
	}

	public void setArtTransferInOut(DashBoardGraphDto artTransferInOut) {
		this.artTransferInOut = artTransferInOut;
	}

	public DashBoardGraphDto getReferredNotLinked() {
		return referredNotLinked;
	}

	public void setReferredNotLinked(DashBoardGraphDto referredNotLinked) {
		this.referredNotLinked = referredNotLinked;
	}

}
