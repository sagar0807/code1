package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the product_dosage database table.
 * 
 */
@Entity
@Table(name="product_dosage")
@NamedQuery(name="ProductDosage.findAll", query="SELECT p FROM ProductDosage p")
public class ProductDosage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dosage_qty_per_month")
	private Integer dosageQtyPerMonth;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String status;

	//bi-directional many-to-one association to MasterWeightBand
	@ManyToOne
	@JoinColumn(name="weight_band")
	private MasterWeightBand masterWeightBand;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to ProductDosageCategoryMaster
	@ManyToOne
	@JoinColumn(name="age_category")
	private ProductDosageCategoryMaster productDosageCategoryMaster;

	public ProductDosage() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getDosageQtyPerMonth() {
		return this.dosageQtyPerMonth;
	}

	public void setDosageQtyPerMonth(Integer dosageQtyPerMonth) {
		this.dosageQtyPerMonth = dosageQtyPerMonth;
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

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
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

	public MasterWeightBand getMasterWeightBand() {
		return this.masterWeightBand;
	}

	public void setMasterWeightBand(MasterWeightBand masterWeightBand) {
		this.masterWeightBand = masterWeightBand;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDosageCategoryMaster getProductDosageCategoryMaster() {
		return this.productDosageCategoryMaster;
	}

	public void setProductDosageCategoryMaster(ProductDosageCategoryMaster productDosageCategoryMaster) {
		this.productDosageCategoryMaster = productDosageCategoryMaster;
	}

}