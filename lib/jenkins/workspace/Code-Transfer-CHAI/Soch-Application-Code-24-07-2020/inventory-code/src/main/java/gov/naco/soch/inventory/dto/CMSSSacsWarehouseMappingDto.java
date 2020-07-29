package gov.naco.soch.inventory.dto;

import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class CMSSSacsWarehouseMappingDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long sacsId;
	private String sacsCode;
	private String sacsName;
	private Integer numberOfWarehouses;
	private List<CMSSWarehouseDto> mappedWarehouses;

	public Long getSacsId() {
		return sacsId;
	}

	public void setSacsId(Long sacsId) {
		this.sacsId = sacsId;
	}

	public String getSacsCode() {
		return sacsCode;
	}

	public void setSacsCode(String sacsCode) {
		this.sacsCode = sacsCode;
	}

	public String getSacsName() {
		return sacsName;
	}

	public void setSacsName(String sacsName) {
		this.sacsName = sacsName;
	}

	public Integer getNumberOfWarehouses() {
		return numberOfWarehouses;
	}

	public void setNumberOfWarehouses(Integer numberOfWarehouses) {
		this.numberOfWarehouses = numberOfWarehouses;
	}

	public List<CMSSWarehouseDto> getMappedWarehouses() {
		return mappedWarehouses;
	}

	public void setMappedWarehouses(List<CMSSWarehouseDto> mappedWarehouses) {
		this.mappedWarehouses = mappedWarehouses;
	}

}
