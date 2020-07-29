package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the indent_product database table.
 * 
 */
@Entity
@Table(name="indent_product")
@NamedQuery(name="IndentProduct.findAll", query="SELECT i FROM IndentProduct i")
public class IndentProduct implements Serializable {
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

	//bi-directional many-to-one association to Indent
	@ManyToOne
	@JoinColumn(name="indent_id")
	private Indent indent;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to IndentProductSchedule
	@OneToMany(mappedBy="indentProduct")
	private Set<IndentProductSchedule> indentProductSchedules;

	public IndentProduct() {
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

	public Indent getIndent() {
		return this.indent;
	}

	public void setIndent(Indent indent) {
		this.indent = indent;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<IndentProductSchedule> getIndentProductSchedules() {
		return this.indentProductSchedules;
	}

	public void setIndentProductSchedules(Set<IndentProductSchedule> indentProductSchedules) {
		this.indentProductSchedules = indentProductSchedules;
	}

	public IndentProductSchedule addIndentProductSchedule(IndentProductSchedule indentProductSchedule) {
		getIndentProductSchedules().add(indentProductSchedule);
		indentProductSchedule.setIndentProduct(this);

		return indentProductSchedule;
	}

	public IndentProductSchedule removeIndentProductSchedule(IndentProductSchedule indentProductSchedule) {
		getIndentProductSchedules().remove(indentProductSchedule);
		indentProductSchedule.setIndentProduct(null);

		return indentProductSchedule;
	}

}