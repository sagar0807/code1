package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the indent database table.
 * 
 */
@Entity
@GenericGenerator(name = "indent", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "indent_indent_id_seq"), @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })
@NamedQuery(name = "Indent.findAll", query = "SELECT i FROM Indent i")
public class Indent extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "indent")
	@Column(name = "indent_id")
	private Long indentId;

	@Column(name = "indent_date")
	private LocalDate indentDate;

	@Column(name = "indent_number")
	private String indentNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to IndentStatusMaster
	@ManyToOne
	@JoinColumn(name = "indent_status_id")
	private IndentStatusMaster indentStatusMaster;

	// bi-directional many-to-one association to IndentProduct
	@OneToMany(mappedBy = "indent", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<IndentProduct> indentProducts;

	public Indent() {
	}

	public Long getIndentId() {
		return this.indentId;
	}

	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}

	public LocalDate getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
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