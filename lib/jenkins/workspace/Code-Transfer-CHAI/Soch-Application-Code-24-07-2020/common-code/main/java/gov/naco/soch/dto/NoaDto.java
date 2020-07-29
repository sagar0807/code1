package gov.naco.soch.dto;

import java.util.List;

public class NoaDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long contractProductId;
	private Long contractId;
	private String noaNumber;
	private List<LotContractDto> lots;

	public String getNoaNumber() {
		return noaNumber;
	}

	public List<LotContractDto> getLots() {
		return lots;
	}

	public void setNoaNumber(String noaNumber) {
		this.noaNumber = noaNumber;
	}

	public void setLots(List<LotContractDto> lots) {
		this.lots = lots;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getContractProductId() {
		return contractProductId;
	}

	public void setContractProductId(Long contractProductId) {
		this.contractProductId = contractProductId;
	}

	@Override
	public String toString() {
		return "NoaDto [noaNumber=" + noaNumber + ", lots=" + lots + "]";
	}

}
