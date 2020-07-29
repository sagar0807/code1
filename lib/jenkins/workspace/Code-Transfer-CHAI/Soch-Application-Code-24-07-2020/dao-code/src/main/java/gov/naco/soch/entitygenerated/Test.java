package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="collection_center")
	private String collectionCenter;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_barcode_required")
	private Boolean isBarcodeRequired;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String status;

	@Column(name="testing_center")
	private String testingCenter;

	@Column(name="type_of_test")
	private String typeOfTest;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="test")
	private Set<LabTestSample> labTestSamples;

	public Test() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollectionCenter() {
		return this.collectionCenter;
	}

	public void setCollectionCenter(String collectionCenter) {
		this.collectionCenter = collectionCenter;
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

	public Boolean getIsBarcodeRequired() {
		return this.isBarcodeRequired;
	}

	public void setIsBarcodeRequired(Boolean isBarcodeRequired) {
		this.isBarcodeRequired = isBarcodeRequired;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestingCenter() {
		return this.testingCenter;
	}

	public void setTestingCenter(String testingCenter) {
		this.testingCenter = testingCenter;
	}

	public String getTypeOfTest() {
		return this.typeOfTest;
	}

	public void setTypeOfTest(String typeOfTest) {
		this.typeOfTest = typeOfTest;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return this.labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public LabTestSample addLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().add(labTestSample);
		labTestSample.setTest(this);

		return labTestSample;
	}

	public LabTestSample removeLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().remove(labTestSample);
		labTestSample.setTest(null);

		return labTestSample;
	}

}