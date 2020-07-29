package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the product_uom_master database table.
 * 
 */
@Entity
@Table(name="product_uom_master")
@NamedQuery(name="ProductUomMaster.findAll", query="SELECT p FROM ProductUomMaster p")
public class ProductUomMaster implements Serializable {
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

	@Column(name="uom_code")
	private String uomCode;

	@Column(name="uom_description")
	private String uomDescription;

	@Column(name="uom_name")
	private String uomName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productUomMaster")
	private Set<Product> products;

	//bi-directional many-to-one association to RegimenConstituent
	@OneToMany(mappedBy="productUomMaster")
	private Set<RegimenConstituent> regimenConstituents;

	public ProductUomMaster() {
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

	public String getUomCode() {
		return this.uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public String getUomDescription() {
		return this.uomDescription;
	}

	public void setUomDescription(String uomDescription) {
		this.uomDescription = uomDescription;
	}

	public String getUomName() {
		return this.uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductUomMaster(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductUomMaster(null);

		return product;
	}

	public Set<RegimenConstituent> getRegimenConstituents() {
		return this.regimenConstituents;
	}

	public void setRegimenConstituents(Set<RegimenConstituent> regimenConstituents) {
		this.regimenConstituents = regimenConstituents;
	}

	public RegimenConstituent addRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().add(regimenConstituent);
		regimenConstituent.setProductUomMaster(this);

		return regimenConstituent;
	}

	public RegimenConstituent removeRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().remove(regimenConstituent);
		regimenConstituent.setProductUomMaster(null);

		return regimenConstituent;
	}

}