package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_dna_pcr_result database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_dna_pcr_result")
@NamedQuery(name="ArtBeneficiaryDnaPcrResult.findAll", query="SELECT a FROM ArtBeneficiaryDnaPcrResult a")
public class ArtBeneficiaryDnaPcrResult implements Serializable {
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

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to MasterDnaPcrResult
	@ManyToOne
	@JoinColumn(name="dna_pcr_result_id")
	private MasterDnaPcrResult masterDnaPcrResult;

	//bi-directional many-to-one association to MasterDnaPcrTest
	@ManyToOne
	@JoinColumn(name="dna_pcr_test_id")
	private MasterDnaPcrTest masterDnaPcrTest;

	public ArtBeneficiaryDnaPcrResult() {
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterDnaPcrResult getMasterDnaPcrResult() {
		return this.masterDnaPcrResult;
	}

	public void setMasterDnaPcrResult(MasterDnaPcrResult masterDnaPcrResult) {
		this.masterDnaPcrResult = masterDnaPcrResult;
	}

	public MasterDnaPcrTest getMasterDnaPcrTest() {
		return this.masterDnaPcrTest;
	}

	public void setMasterDnaPcrTest(MasterDnaPcrTest masterDnaPcrTest) {
		this.masterDnaPcrTest = masterDnaPcrTest;
	}

}