package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_beneficiary_dispensation_status database table.
 * 
 */
@Entity
@Table(name="ti_beneficiary_dispensation_status")
@NamedQuery(name="TiBeneficiaryDispensationStatus.findAll", query="SELECT t FROM TiBeneficiaryDispensationStatus t")
public class TiBeneficiaryDispensationStatus implements Serializable {
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

	private String monthvalue;

	private String status;

	//bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	public TiBeneficiaryDispensationStatus() {
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

	public String getMonthvalue() {
		return this.monthvalue;
	}

	public void setMonthvalue(String monthvalue) {
		this.monthvalue = monthvalue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

}