package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the cmss_indent_dispatch database table.
 * 
 */
@Entity
@Table(name="cmss_indent_dispatch")
@NamedQuery(name="CmssIndentDispatch.findAll", query="SELECT c FROM CmssIndentDispatch c")
public class CmssIndentDispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="batch_no")
	private String batchNo;

	@Column(name="cmss_product_name")
	private String cmssProductName;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="damaged_qty")
	private Integer damagedQty;

	@Temporal(TemporalType.DATE)
	@Column(name="expiry_date")
	private Date expiryDate;

	@Column(name="indent_no")
	private String indentNo;

	@Column(name="indent_store")
	private String indentStore;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;

	@Column(name="issue_no")
	private String issueNo;

	@Column(name="issue_qty")
	private Integer issueQty;

	@Column(name="issuing_store")
	private String issuingStore;

	@Temporal(TemporalType.DATE)
	@Column(name="manufacture_date")
	private Date manufactureDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="receipt_remarks")
	private String receiptRemarks;

	@Column(name="received_qty")
	private Integer receivedQty;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="sacs_id")
	private Facility facility;

	//bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne
	@JoinColumn(name="receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	public CmssIndentDispatch() {
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

	public Integer getDamagedQty() {
		return this.damagedQty;
	}

	public void setDamagedQty(Integer damagedQty) {
		this.damagedQty = damagedQty;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIndentNo() {
		return this.indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public String getIndentStore() {
		return this.indentStore;
	}

	public void setIndentStore(String indentStore) {
		this.indentStore = indentStore;
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

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssueNo() {
		return this.issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public Integer getIssueQty() {
		return this.issueQty;
	}

	public void setIssueQty(Integer issueQty) {
		this.issueQty = issueQty;
	}

	public String getIssuingStore() {
		return this.issuingStore;
	}

	public void setIssuingStore(String issuingStore) {
		this.issuingStore = issuingStore;
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

	public String getReceiptRemarks() {
		return this.receiptRemarks;
	}

	public void setReceiptRemarks(String receiptRemarks) {
		this.receiptRemarks = receiptRemarks;
	}

	public Integer getReceivedQty() {
		return this.receivedQty;
	}

	public void setReceivedQty(Integer receivedQty) {
		this.receivedQty = receivedQty;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return this.receiptStatusMaster;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

}