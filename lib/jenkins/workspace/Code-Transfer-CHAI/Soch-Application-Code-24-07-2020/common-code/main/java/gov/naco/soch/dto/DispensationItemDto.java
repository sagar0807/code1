package gov.naco.soch.dto;

public class DispensationItemDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String batchId;
	private Long dispensationId;
	private Boolean isActive;
	private Boolean isDelete;
	private String qtyDispensed;
	private Long productId;
	private Long regimenId;
	
	private ProductDto productDto;
	private RegimenDto regimenDto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public Long getDispensationId() {
		return dispensationId;
	}
	public void setDispensationId(Long dispensationId) {
		this.dispensationId = dispensationId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getQtyDispensed() {
		return qtyDispensed;
	}
	public void setQtyDispensed(String qtyDispensed) {
		this.qtyDispensed = qtyDispensed;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getRegimenId() {
		return regimenId;
	}
	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	public RegimenDto getRegimenDto() {
		return regimenDto;
	}
	public void setRegimenDto(RegimenDto regimenDto) {
		this.regimenDto = regimenDto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DispensationItemDto [id=" + id + ", batchId=" + batchId + ", dispensationId=" + dispensationId
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", qtyDispensed=" + qtyDispensed
				+ ", productId=" + productId + ", regimenId=" + regimenId + ", productDto=" + productDto
				+ ", regimenDto=" + regimenDto + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispensationItemDto other = (DispensationItemDto) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (dispensationId == null) {
			if (other.dispensationId != null)
				return false;
		} else if (!dispensationId.equals(other.dispensationId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (productDto == null) {
			if (other.productDto != null)
				return false;
		} else if (!productDto.equals(other.productDto))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (qtyDispensed == null) {
			if (other.qtyDispensed != null)
				return false;
		} else if (!qtyDispensed.equals(other.qtyDispensed))
			return false;
		if (regimenDto == null) {
			if (other.regimenDto != null)
				return false;
		} else if (!regimenDto.equals(other.regimenDto))
			return false;
		if (regimenId == null) {
			if (other.regimenId != null)
				return false;
		} else if (!regimenId.equals(other.regimenId))
			return false;
		return true;
	}

	
}
