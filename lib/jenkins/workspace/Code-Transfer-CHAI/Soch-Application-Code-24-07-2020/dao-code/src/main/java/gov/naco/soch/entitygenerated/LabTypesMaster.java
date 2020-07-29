package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the lab_types_master database table.
 * 
 */
@Entity
@Table(name="lab_types_master")
@NamedQuery(name="LabTypesMaster.findAll", query="SELECT l FROM LabTypesMaster l")
public class LabTypesMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="lab_type_name")
	private String labTypeName;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="national_id")
	private String nationalId;

	//bi-directional many-to-one association to ProductLabTypesMapping
	@OneToMany(mappedBy="labTypesMaster")
	private Set<ProductLabTypesMapping> productLabTypesMappings;

	public LabTypesMaster() {
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

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLabTypeName() {
		return this.labTypeName;
	}

	public void setLabTypeName(String labTypeName) {
		this.labTypeName = labTypeName;
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

	public String getNationalId() {
		return this.nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public Set<ProductLabTypesMapping> getProductLabTypesMappings() {
		return this.productLabTypesMappings;
	}

	public void setProductLabTypesMappings(Set<ProductLabTypesMapping> productLabTypesMappings) {
		this.productLabTypesMappings = productLabTypesMappings;
	}

	public ProductLabTypesMapping addProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().add(productLabTypesMapping);
		productLabTypesMapping.setLabTypesMaster(this);

		return productLabTypesMapping;
	}

	public ProductLabTypesMapping removeProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().remove(productLabTypesMapping);
		productLabTypesMapping.setLabTypesMaster(null);

		return productLabTypesMapping;
	}

}