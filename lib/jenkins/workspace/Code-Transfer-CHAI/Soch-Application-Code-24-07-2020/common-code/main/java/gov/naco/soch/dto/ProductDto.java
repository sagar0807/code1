package gov.naco.soch.dto;

import java.util.List;

public class ProductDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String productName;
	private MasterDto uom;
	private Boolean batchNo;
	private String shortCode;
	private MasterDto productType;
	private String minShelfLife;

	private String commodityTypeName;
	private Long commodityTypeId;
	private String drugLineName;
	private Long drugLineId;
	private String recepientTypeName;
	private Long recepientTypeId;

	private MasterDto division;
	private List<MasterDto> facilityTypes;
	private List<MasterDto> labTypes;

	private byte[] productImage;
	private String formulationComposition;
	private String productDetails;
	private Boolean isActive;
	private Integer availableQuantity;
	private Integer dispensedQuantity;

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Integer getDispensedQuantity() {
		return dispensedQuantity;
	}

	public void setDispensedQuantity(Integer dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	public Long getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public MasterDto getUom() {
		return uom;
	}

	public void setUom(MasterDto uom) {
		this.uom = uom;
	}

	public String getShortCode() {
		return shortCode;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public MasterDto getProductType() {
		return productType;
	}

	public void setProductType(MasterDto productType) {
		this.productType = productType;
	}

	public MasterDto getDivision() {
		return division;
	}

	public void setDivision(MasterDto division) {
		this.division = division;
	}

	public List<MasterDto> getFacilityTypes() {
		return facilityTypes;
	}

	public void setFacilityTypes(List<MasterDto> facilityTypes) {
		this.facilityTypes = facilityTypes;
	}

	public List<MasterDto> getLabTypes() {
		return labTypes;
	}

	public void setLabTypes(List<MasterDto> labTypes) {
		this.labTypes = labTypes;
	}

	public String getMinShelfLife() {
		return minShelfLife;
	}

	public void setMinShelfLife(String minShelfLife) {
		this.minShelfLife = minShelfLife;
	}

	public String getFormulationComposition() {
		return formulationComposition;
	}

	public void setFormulationComposition(String formulationComposition) {
		this.formulationComposition = formulationComposition;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityTypeName() {
		return commodityTypeName;
	}

	public void setCommodityTypeName(String commodityTypeName) {
		this.commodityTypeName = commodityTypeName;
	}

	public Long getCommodityTypeId() {
		return commodityTypeId;
	}

	public void setCommodityTypeId(Long commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
	}

	public String getDrugLineName() {
		return drugLineName;
	}

	public void setDrugLineName(String drugLineName) {
		this.drugLineName = drugLineName;
	}

	public Long getDrugLineId() {
		return drugLineId;
	}

	public Boolean getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(Boolean batchNo) {
		this.batchNo = batchNo;
	}

	public void setDrugLineId(Long drugLineId) {
		this.drugLineId = drugLineId;
	}

	public String getRecepientTypeName() {
		return recepientTypeName;
	}

	public void setRecepientTypeName(String recepientTypeName) {
		this.recepientTypeName = recepientTypeName;
	}

	public Long getRecepientTypeId() {
		return recepientTypeId;
	}

	public void setRecepientTypeId(Long recepientTypeId) {
		this.recepientTypeId = recepientTypeId;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", productName=" + productName + ", uom=" + uom + ", batchNo=" + batchNo
				+ ", shortCode=" + shortCode + ", productType=" + productType + ", minShelfLife=" + minShelfLife
				+ ", commodityTypeName=" + commodityTypeName + ", commodityTypeId=" + commodityTypeId
				+ ", drugLineName=" + drugLineName + ", drugLineId=" + drugLineId + ", recepientTypeName="
				+ recepientTypeName + ", recepientTypeId=" + recepientTypeId + ", division=" + division
				+ ", facilityTypes=" + facilityTypes + ", labTypes=" + labTypes + ", productImage=" + productImage
				+ ", formulationComposition=" + formulationComposition + ", productDetails=" + productDetails
				+ ", isActive=" + isActive + ", availableQuantity=" + availableQuantity + ", dispensedQuantity="
				+ dispensedQuantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		if (availableQuantity == null) {
			if (other.availableQuantity != null)
				return false;
		} else if (!availableQuantity.equals(other.availableQuantity))
			return false;
		if (batchNo != other.batchNo)
			return false;
		if (commodityTypeId == null) {
			if (other.commodityTypeId != null)
				return false;
		} else if (!commodityTypeId.equals(other.commodityTypeId))
			return false;
		if (commodityTypeName == null) {
			if (other.commodityTypeName != null)
				return false;
		} else if (!commodityTypeName.equals(other.commodityTypeName))
			return false;
		if (dispensedQuantity == null) {
			if (other.dispensedQuantity != null)
				return false;
		} else if (!dispensedQuantity.equals(other.dispensedQuantity))
			return false;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (drugLineId == null) {
			if (other.drugLineId != null)
				return false;
		} else if (!drugLineId.equals(other.drugLineId))
			return false;
		if (drugLineName == null) {
			if (other.drugLineName != null)
				return false;
		} else if (!drugLineName.equals(other.drugLineName))
			return false;
		if (facilityTypes == null) {
			if (other.facilityTypes != null)
				return false;
		} else if (!facilityTypes.equals(other.facilityTypes))
			return false;
		if (formulationComposition == null) {
			if (other.formulationComposition != null)
				return false;
		} else if (!formulationComposition.equals(other.formulationComposition))
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
		if (labTypes == null) {
			if (other.labTypes != null)
				return false;
		} else if (!labTypes.equals(other.labTypes))
			return false;
		if (minShelfLife == null) {
			if (other.minShelfLife != null)
				return false;
		} else if (!minShelfLife.equals(other.minShelfLife))
			return false;
		if (productDetails == null) {
			if (other.productDetails != null)
				return false;
		} else if (!productDetails.equals(other.productDetails))
			return false;
		if (productImage == null) {
			if (other.productImage != null)
				return false;
		} else if (!productImage.equals(other.productImage))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (recepientTypeId == null) {
			if (other.recepientTypeId != null)
				return false;
		} else if (!recepientTypeId.equals(other.recepientTypeId))
			return false;
		if (recepientTypeName == null) {
			if (other.recepientTypeName != null)
				return false;
		} else if (!recepientTypeName.equals(other.recepientTypeName))
			return false;
		if (shortCode == null) {
			if (other.shortCode != null)
				return false;
		} else if (!shortCode.equals(other.shortCode))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		return true;
	}

}
