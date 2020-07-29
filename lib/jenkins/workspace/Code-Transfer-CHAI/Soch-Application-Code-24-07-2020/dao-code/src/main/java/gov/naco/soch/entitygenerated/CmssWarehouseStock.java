package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the cmss_warehouse_stock database table.
 * 
 */
@Entity
@Table(name="cmss_warehouse_stock")
@NamedQuery(name="CmssWarehouseStock.findAll", query="SELECT c FROM CmssWarehouseStock c")
public class CmssWarehouseStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="batch_no")
	private String batchNo;

	@Column(name="brand_id")
	private String brandId;

	@Column(name="cmss_product_name")
	private String cmssProductName;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="expiry_date")
	private Date expiryDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Temporal(TemporalType.DATE)
	@Column(name="manufacture_date")
	private Date manufactureDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="po_no")
	private String poNo;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="qty_active")
	private Integer qtyActive;

	@Column(name="qty_quarantine")
	private Integer qtyQuarantine;

	@Column(name="qty_rejected")
	private Integer qtyRejected;

	@Column(name="store_id")
	private String storeId;

	@Column(name="store_name")
	private String storeName;

	public CmssWarehouseStock() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBrandId() {
		return this.brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getCmssProductName() {
		return this.cmssProductName;
	}

	public void setCmssProductName(String cmssProductName) {
		this.cmssProductName = cmssProductName;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getPoNo() {
		return this.poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQtyActive() {
		return this.qtyActive;
	}

	public void setQtyActive(Integer qtyActive) {
		this.qtyActive = qtyActive;
	}

	public Integer getQtyQuarantine() {
		return this.qtyQuarantine;
	}

	public void setQtyQuarantine(Integer qtyQuarantine) {
		this.qtyQuarantine = qtyQuarantine;
	}

	public Integer getQtyRejected() {
		return this.qtyRejected;
	}

	public void setQtyRejected(Integer qtyRejected) {
		this.qtyRejected = qtyRejected;
	}

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}