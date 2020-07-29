package gov.naco.soch.dto;

import java.util.List;

public class ArtDispatchBDNDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String BDN;
	private List<ArtDispatchSamplesDto> dispatchList;

	public String getBDN() {
		return BDN;
	}

	public List<ArtDispatchSamplesDto> getDispatchList() {
		return dispatchList;
	}

	public void setBDN(String bDN) {
		BDN = bDN;
	}

	public void setDispatchList(List<ArtDispatchSamplesDto> dispatchList) {
		this.dispatchList = dispatchList;
	}

}
