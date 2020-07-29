package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the indent_reasons_master database table.
 * 
 */
@Entity
@Table(name = "indent_reasons_master")
@NamedQuery(name = "IndentReasonsMaster.findAll", query = "SELECT i FROM IndentReasonsMaster i")
public class IndentReasonsMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "indent_reasons_name", length = 99)
	private String indentReasonsName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public IndentReasonsMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndentReasonsName() {
		return this.indentReasonsName;
	}

	public void setIndentReasonsName(String indentReasonsName) {
		this.indentReasonsName = indentReasonsName;
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

}