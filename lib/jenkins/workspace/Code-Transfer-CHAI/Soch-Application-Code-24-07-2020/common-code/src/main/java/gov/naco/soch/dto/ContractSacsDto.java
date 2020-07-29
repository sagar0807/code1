package gov.naco.soch.dto;

import java.util.List;

public class ContractSacsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Integer sacsId;
	private Long facilityId;
	private String toFacility;
	private Long stateId;
	private List<LotContractDto> lots;

	public Integer getSacsId() {
		return sacsId;
	}

	public void setSacsId(Integer sacsId) {
		this.sacsId = sacsId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getToFacility() {
		return toFacility;
	}

	public void setToFacility(String toFacility) {
		this.toFacility = toFacility;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public List<LotContractDto> getLots() {
		return lots;
	}

	public void setLots(List<LotContractDto> lots) {
		this.lots = lots;
	}

}
