package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the goods_request database table.
 * 
 */
@Entity
@Table(name="goods_request")
@NamedQuery(name="GoodsRequest.findAll", query="SELECT g FROM GoodsRequest g")
public class GoodsRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="approved_date")
	private Date approvedDate;

	@Column(name="approved_quantity")
	private Integer approvedQuantity;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="estimate_delivery_date")
	private Date estimateDeliveryDate;

	@Column(name="indent_num")
	private String indentNum;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_dispatched")
	private Boolean isDispatched;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="requested_date")
	private Date requestedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="requested_delivery_date")
	private Date requestedDeliveryDate;

	@Column(name="requested_quantity")
	private Integer requestedQuantity;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="sacs_id")
	private Facility facility2;

	//bi-directional many-to-one association to IndentReasonsMaster
	@ManyToOne
	@JoinColumn(name="indent_reason_id")
	private IndentReasonsMaster indentReasonsMaster;

	//bi-directional many-to-one association to IndentRequestStatusMaster
	@ManyToOne
	@JoinColumn(name="goods_request_status_id")
	private IndentRequestStatusMaster indentRequestStatusMaster;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public GoodsRequest() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Integer getApprovedQuantity() {
		return this.approvedQuantity;
	}

	public void setApprovedQuantity(Integer approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
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

	public Date getEstimateDeliveryDate() {
		return this.estimateDeliveryDate;
	}

	public void setEstimateDeliveryDate(Date estimateDeliveryDate) {
		this.estimateDeliveryDate = estimateDeliveryDate;
	}

	public String getIndentNum() {
		return this.indentNum;
	}

	public void setIndentNum(String indentNum) {
		this.indentNum = indentNum;
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

	public Boolean getIsDispatched() {
		return this.isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
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

	public Date getRequestedDate() {
		return this.requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getRequestedDeliveryDate() {
		return this.requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(Date requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public Integer getRequestedQuantity() {
		return this.requestedQuantity;
	}

	public void setRequestedQuantity(Integer requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public IndentReasonsMaster getIndentReasonsMaster() {
		return this.indentReasonsMaster;
	}

	public void setIndentReasonsMaster(IndentReasonsMaster indentReasonsMaster) {
		this.indentReasonsMaster = indentReasonsMaster;
	}

	public IndentRequestStatusMaster getIndentRequestStatusMaster() {
		return this.indentRequestStatusMaster;
	}

	public void setIndentRequestStatusMaster(IndentRequestStatusMaster indentRequestStatusMaster) {
		this.indentRequestStatusMaster = indentRequestStatusMaster;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}