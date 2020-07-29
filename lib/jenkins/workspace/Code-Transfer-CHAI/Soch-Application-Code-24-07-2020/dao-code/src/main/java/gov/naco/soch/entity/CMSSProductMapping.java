package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@GenericGenerator(name = "cmss_product_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_product_mapping_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "cmss_product_mapping")
@NamedQuery(name = "CMSSProductMapping.findAll", query = "SELECT c FROM CMSSProductMapping c")
public class CMSSProductMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_product_mapping")
	private Long id;

	@Column(name = "cmss_product_name")
	private String cmssProductName;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@CreatedBy
	@Column(name = "created_by")
	protected Long createdBy;

	@CreatedDate
	@Column(name = "created_time")
	protected LocalDateTime createdTime;

	@LastModifiedBy
	@Column(name = "modified_by")
	protected Long modifiedBy;

	@LastModifiedDate
	@Column(name = "modified_time")
	private LocalDateTime modifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCmssProductName() {
		return cmssProductName;
	}

	public void setCmssProductName(String cmssProductName) {
		this.cmssProductName = cmssProductName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
