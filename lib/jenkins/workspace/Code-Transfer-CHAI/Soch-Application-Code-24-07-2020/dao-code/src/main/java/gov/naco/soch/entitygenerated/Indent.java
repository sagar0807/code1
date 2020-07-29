package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the indent database table.
 * 
 */
@Entity
@NamedQuery(name="Indent.findAll", query="SELECT i FROM Indent i")
public class Indent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="indent_id")
	private Integer indentId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="indent_date")
	private Date indentDate;

	@Column(name="indent_number")
	private String indentNumber;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to IndentStatusMaster
	@ManyToOne
	@JoinColumn(name="indent_status_id")
	private IndentStatusMaster indentStatusMaster;

	//bi-directional many-to-one association to IndentProduct
	@OneToMany(mappedBy="indent")
	private Set<IndentProduct> indentProducts;

	public Indent() {
	}

	public Integer getIndentId() {
		return this.indentId;
	}

	public void setIndentId(Integer indentId) {
		this.indentId = indentId;
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

	public Date getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public String getIndentNumber() {
		return this.indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
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

	public IndentStatusMaster getIndentStatusMaster() {
		return this.indentStatusMaster;
	}

	public void setIndentStatusMaster(IndentStatusMaster indentStatusMaster) {
		this.indentStatusMaster = indentStatusMaster;
	}

	public Set<IndentProduct> getIndentProducts() {
		return this.indentProducts;
	}

	public void setIndentProducts(Set<IndentProduct> indentProducts) {
		this.indentProducts = indentProducts;
	}

	public IndentProduct addIndentProduct(IndentProduct indentProduct) {
		getIndentProducts().add(indentProduct);
		indentProduct.setIndent(this);

		return indentProduct;
	}

	public IndentProduct removeIndentProduct(IndentProduct indentProduct) {
		getIndentProducts().remove(indentProduct);
		indentProduct.setIndent(null);

		return indentProduct;
	}

}