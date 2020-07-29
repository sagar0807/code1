package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the product_commodity_type_master database table.
 * 
 */
@Entity
@Table(name="product_commodity_type_master")
@NamedQuery(name="ProductCommodityTypeMaster.findAll", query="SELECT p FROM ProductCommodityTypeMaster p")
public class ProductCommodityTypeMaster implements Serializable {
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

	@Column(name="product_commodity_type_code")
	private String productCommodityTypeCode;

	@Column(name="product_commodity_type_name")
	private String productCommodityTypeName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productCommodityTypeMaster")
	private Set<Product> products;

	public ProductCommodityTypeMaster() {
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

	public String getProductCommodityTypeCode() {
		return this.productCommodityTypeCode;
	}

	public void setProductCommodityTypeCode(String productCommodityTypeCode) {
		this.productCommodityTypeCode = productCommodityTypeCode;
	}

	public String getProductCommodityTypeName() {
		return this.productCommodityTypeName;
	}

	public void setProductCommodityTypeName(String productCommodityTypeName) {
		this.productCommodityTypeName = productCommodityTypeName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductCommodityTypeMaster(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductCommodityTypeMaster(null);

		return product;
	}

}