package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the indent_product_schedule database table.
 * 
 */
@Entity
@Table(name="indent_product_schedule")
@NamedQuery(name="IndentProductSchedule.findAll", query="SELECT i FROM IndentProductSchedule i")
public class IndentProductSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private Integer quantity;

	@Column(name="schedule_number")
	private String scheduleNumber;

	@Column(name="unit_price")
	private BigDecimal unitPrice;

	//bi-directional many-to-one association to IndentProduct
	@ManyToOne
	@JoinColumn(name="indent_product_id")
	private IndentProduct indentProduct;

	//bi-directional many-to-one association to IndentProductScheduleSac
	@OneToMany(mappedBy="indentProductSchedule")
	private Set<IndentProductScheduleSac> indentProductScheduleSacs;

	public IndentProductSchedule() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getScheduleNumber() {
		return this.scheduleNumber;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public IndentProduct getIndentProduct() {
		return this.indentProduct;
	}

	public void setIndentProduct(IndentProduct indentProduct) {
		this.indentProduct = indentProduct;
	}

	public Set<IndentProductScheduleSac> getIndentProductScheduleSacs() {
		return this.indentProductScheduleSacs;
	}

	public void setIndentProductScheduleSacs(Set<IndentProductScheduleSac> indentProductScheduleSacs) {
		this.indentProductScheduleSacs = indentProductScheduleSacs;
	}

	public IndentProductScheduleSac addIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		getIndentProductScheduleSacs().add(indentProductScheduleSac);
		indentProductScheduleSac.setIndentProductSchedule(this);

		return indentProductScheduleSac;
	}

	public IndentProductScheduleSac removeIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		getIndentProductScheduleSacs().remove(indentProductScheduleSac);
		indentProductScheduleSac.setIndentProductSchedule(null);

		return indentProductScheduleSac;
	}

}