package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String formulation;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_batchnumber_mandatory")
	private Boolean isBatchnumberMandatory;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="minimum_shelf_life")
	private String minimumShelfLife;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_detail")
	private String productDetail;

	@Column(name="product_image")
	private byte[] productImage;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_short_code")
	private String productShortCode;

	//bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy="product")
	private Set<ArtDispensationItem> artDispensationItems;

	//bi-directional many-to-one association to ArtPepDispensationItem
	@OneToMany(mappedBy="product")
	private Set<ArtPepDispensationItem> artPepDispensationItems;

	//bi-directional many-to-one association to ContractProduct
	@OneToMany(mappedBy="product")
	private Set<ContractProduct> contractProducts;

	//bi-directional many-to-one association to FacilityAggregateStock
	@OneToMany(mappedBy="product")
	private Set<FacilityAggregateStock> facilityAggregateStocks;

	//bi-directional many-to-one association to FacilityDispatchProduct
	@OneToMany(mappedBy="product")
	private Set<FacilityDispatchProduct> facilityDispatchProducts;

	//bi-directional many-to-one association to FacilityReceiptProduct
	@OneToMany(mappedBy="product")
	private Set<FacilityReceiptProduct> facilityReceiptProducts;

	//bi-directional many-to-one association to FacilityReconciliation
	@OneToMany(mappedBy="product")
	private Set<FacilityReconciliation> facilityReconciliations;

	//bi-directional many-to-one association to FacilityStock
	@OneToMany(mappedBy="product")
	private Set<FacilityStock> facilityStocks;

	//bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy="product")
	private Set<FacilityStockAdjustment> facilityStockAdjustments;

	//bi-directional many-to-one association to FacilityStockDailyBalance
	@OneToMany(mappedBy="product")
	private Set<FacilityStockDailyBalance> facilityStockDailyBalances;

	//bi-directional many-to-one association to FacilityStockTracking
	@OneToMany(mappedBy="product")
	private Set<FacilityStockTracking> facilityStockTrackings;

	//bi-directional many-to-one association to GoodsRequest
	@OneToMany(mappedBy="product")
	private Set<GoodsRequest> goodsRequests;

	//bi-directional many-to-one association to IndentProduct
	@OneToMany(mappedBy="product")
	private Set<IndentProduct> indentProducts;

	//bi-directional many-to-one association to Division
	@ManyToOne
	private Division division;

	//bi-directional many-to-one association to ProductCommodityTypeMaster
	@ManyToOne
	@JoinColumn(name="product_commodity_type_id")
	private ProductCommodityTypeMaster productCommodityTypeMaster;

	//bi-directional many-to-one association to ProductDrugLineMaster
	@ManyToOne
	@JoinColumn(name="product_drug_line_id")
	private ProductDrugLineMaster productDrugLineMaster;

	//bi-directional many-to-one association to ProductRecipientTypeMaster
	@ManyToOne
	@JoinColumn(name="product_recipient_type_id")
	private ProductRecipientTypeMaster productRecipientTypeMaster;

	//bi-directional many-to-one association to ProductTypesMaster
	@ManyToOne
	@JoinColumn(name="product_type_id")
	private ProductTypesMaster productTypesMaster;

	//bi-directional many-to-one association to ProductUomMaster
	@ManyToOne
	@JoinColumn(name="uom_id")
	private ProductUomMaster productUomMaster;

	//bi-directional many-to-one association to ProductDosage
	@OneToMany(mappedBy="product")
	private Set<ProductDosage> productDosages;

	//bi-directional many-to-one association to ProductLabTypesMapping
	@OneToMany(mappedBy="product")
	private Set<ProductLabTypesMapping> productLabTypesMappings;

	//bi-directional many-to-one association to RegimenConstituent
	@OneToMany(mappedBy="product")
	private Set<RegimenConstituent> regimenConstituents;

	//bi-directional many-to-one association to SupplierStock
	@OneToMany(mappedBy="product")
	private Set<SupplierStock> supplierStocks;

	//bi-directional many-to-one association to TiOstBulkDispensation
	@OneToMany(mappedBy="product")
	private Set<TiOstBulkDispensation> tiOstBulkDispensations;

	//bi-directional many-to-one association to TiOstDispensation
	@OneToMany(mappedBy="product")
	private Set<TiOstDispensation> tiOstDispensations;

	//bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy="product")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

	//bi-directional many-to-one association to TiOstDrugDispensation
	@OneToMany(mappedBy="product")
	private Set<TiOstDrugDispensation> tiOstDrugDispensations;

	//bi-directional many-to-one association to TiOstPrescription
	@OneToMany(mappedBy="product")
	private Set<TiOstPrescription> tiOstPrescriptions;

	public Product() {
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

	public String getFormulation() {
		return this.formulation;
	}

	public void setFormulation(String formulation) {
		this.formulation = formulation;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsBatchnumberMandatory() {
		return this.isBatchnumberMandatory;
	}

	public void setIsBatchnumberMandatory(Boolean isBatchnumberMandatory) {
		this.isBatchnumberMandatory = isBatchnumberMandatory;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getMinimumShelfLife() {
		return this.minimumShelfLife;
	}

	public void setMinimumShelfLife(String minimumShelfLife) {
		this.minimumShelfLife = minimumShelfLife;
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

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDetail() {
		return this.productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public byte[] getProductImage() {
		return this.productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShortCode() {
		return this.productShortCode;
	}

	public void setProductShortCode(String productShortCode) {
		this.productShortCode = productShortCode;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setProduct(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setProduct(null);

		return artDispensationItem;
	}

	public Set<ArtPepDispensationItem> getArtPepDispensationItems() {
		return this.artPepDispensationItems;
	}

	public void setArtPepDispensationItems(Set<ArtPepDispensationItem> artPepDispensationItems) {
		this.artPepDispensationItems = artPepDispensationItems;
	}

	public ArtPepDispensationItem addArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().add(artPepDispensationItem);
		artPepDispensationItem.setProduct(this);

		return artPepDispensationItem;
	}

	public ArtPepDispensationItem removeArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().remove(artPepDispensationItem);
		artPepDispensationItem.setProduct(null);

		return artPepDispensationItem;
	}

	public Set<ContractProduct> getContractProducts() {
		return this.contractProducts;
	}

	public void setContractProducts(Set<ContractProduct> contractProducts) {
		this.contractProducts = contractProducts;
	}

	public ContractProduct addContractProduct(ContractProduct contractProduct) {
		getContractProducts().add(contractProduct);
		contractProduct.setProduct(this);

		return contractProduct;
	}

	public ContractProduct removeContractProduct(ContractProduct contractProduct) {
		getContractProducts().remove(contractProduct);
		contractProduct.setProduct(null);

		return contractProduct;
	}

	public Set<FacilityAggregateStock> getFacilityAggregateStocks() {
		return this.facilityAggregateStocks;
	}

	public void setFacilityAggregateStocks(Set<FacilityAggregateStock> facilityAggregateStocks) {
		this.facilityAggregateStocks = facilityAggregateStocks;
	}

	public FacilityAggregateStock addFacilityAggregateStock(FacilityAggregateStock facilityAggregateStock) {
		getFacilityAggregateStocks().add(facilityAggregateStock);
		facilityAggregateStock.setProduct(this);

		return facilityAggregateStock;
	}

	public FacilityAggregateStock removeFacilityAggregateStock(FacilityAggregateStock facilityAggregateStock) {
		getFacilityAggregateStocks().remove(facilityAggregateStock);
		facilityAggregateStock.setProduct(null);

		return facilityAggregateStock;
	}

	public Set<FacilityDispatchProduct> getFacilityDispatchProducts() {
		return this.facilityDispatchProducts;
	}

	public void setFacilityDispatchProducts(Set<FacilityDispatchProduct> facilityDispatchProducts) {
		this.facilityDispatchProducts = facilityDispatchProducts;
	}

	public FacilityDispatchProduct addFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		getFacilityDispatchProducts().add(facilityDispatchProduct);
		facilityDispatchProduct.setProduct(this);

		return facilityDispatchProduct;
	}

	public FacilityDispatchProduct removeFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		getFacilityDispatchProducts().remove(facilityDispatchProduct);
		facilityDispatchProduct.setProduct(null);

		return facilityDispatchProduct;
	}

	public Set<FacilityReceiptProduct> getFacilityReceiptProducts() {
		return this.facilityReceiptProducts;
	}

	public void setFacilityReceiptProducts(Set<FacilityReceiptProduct> facilityReceiptProducts) {
		this.facilityReceiptProducts = facilityReceiptProducts;
	}

	public FacilityReceiptProduct addFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		getFacilityReceiptProducts().add(facilityReceiptProduct);
		facilityReceiptProduct.setProduct(this);

		return facilityReceiptProduct;
	}

	public FacilityReceiptProduct removeFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		getFacilityReceiptProducts().remove(facilityReceiptProduct);
		facilityReceiptProduct.setProduct(null);

		return facilityReceiptProduct;
	}

	public Set<FacilityReconciliation> getFacilityReconciliations() {
		return this.facilityReconciliations;
	}

	public void setFacilityReconciliations(Set<FacilityReconciliation> facilityReconciliations) {
		this.facilityReconciliations = facilityReconciliations;
	}

	public FacilityReconciliation addFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().add(facilityReconciliation);
		facilityReconciliation.setProduct(this);

		return facilityReconciliation;
	}

	public FacilityReconciliation removeFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().remove(facilityReconciliation);
		facilityReconciliation.setProduct(null);

		return facilityReconciliation;
	}

	public Set<FacilityStock> getFacilityStocks() {
		return this.facilityStocks;
	}

	public void setFacilityStocks(Set<FacilityStock> facilityStocks) {
		this.facilityStocks = facilityStocks;
	}

	public FacilityStock addFacilityStock(FacilityStock facilityStock) {
		getFacilityStocks().add(facilityStock);
		facilityStock.setProduct(this);

		return facilityStock;
	}

	public FacilityStock removeFacilityStock(FacilityStock facilityStock) {
		getFacilityStocks().remove(facilityStock);
		facilityStock.setProduct(null);

		return facilityStock;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments() {
		return this.facilityStockAdjustments;
	}

	public void setFacilityStockAdjustments(Set<FacilityStockAdjustment> facilityStockAdjustments) {
		this.facilityStockAdjustments = facilityStockAdjustments;
	}

	public FacilityStockAdjustment addFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().add(facilityStockAdjustment);
		facilityStockAdjustment.setProduct(this);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().remove(facilityStockAdjustment);
		facilityStockAdjustment.setProduct(null);

		return facilityStockAdjustment;
	}

	public Set<FacilityStockDailyBalance> getFacilityStockDailyBalances() {
		return this.facilityStockDailyBalances;
	}

	public void setFacilityStockDailyBalances(Set<FacilityStockDailyBalance> facilityStockDailyBalances) {
		this.facilityStockDailyBalances = facilityStockDailyBalances;
	}

	public FacilityStockDailyBalance addFacilityStockDailyBalance(FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().add(facilityStockDailyBalance);
		facilityStockDailyBalance.setProduct(this);

		return facilityStockDailyBalance;
	}

	public FacilityStockDailyBalance removeFacilityStockDailyBalance(FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().remove(facilityStockDailyBalance);
		facilityStockDailyBalance.setProduct(null);

		return facilityStockDailyBalance;
	}

	public Set<FacilityStockTracking> getFacilityStockTrackings() {
		return this.facilityStockTrackings;
	}

	public void setFacilityStockTrackings(Set<FacilityStockTracking> facilityStockTrackings) {
		this.facilityStockTrackings = facilityStockTrackings;
	}

	public FacilityStockTracking addFacilityStockTracking(FacilityStockTracking facilityStockTracking) {
		getFacilityStockTrackings().add(facilityStockTracking);
		facilityStockTracking.setProduct(this);

		return facilityStockTracking;
	}

	public FacilityStockTracking removeFacilityStockTracking(FacilityStockTracking facilityStockTracking) {
		getFacilityStockTrackings().remove(facilityStockTracking);
		facilityStockTracking.setProduct(null);

		return facilityStockTracking;
	}

	public Set<GoodsRequest> getGoodsRequests() {
		return this.goodsRequests;
	}

	public void setGoodsRequests(Set<GoodsRequest> goodsRequests) {
		this.goodsRequests = goodsRequests;
	}

	public GoodsRequest addGoodsRequest(GoodsRequest goodsRequest) {
		getGoodsRequests().add(goodsRequest);
		goodsRequest.setProduct(this);

		return goodsRequest;
	}

	public GoodsRequest removeGoodsRequest(GoodsRequest goodsRequest) {
		getGoodsRequests().remove(goodsRequest);
		goodsRequest.setProduct(null);

		return goodsRequest;
	}

	public Set<IndentProduct> getIndentProducts() {
		return this.indentProducts;
	}

	public void setIndentProducts(Set<IndentProduct> indentProducts) {
		this.indentProducts = indentProducts;
	}

	public IndentProduct addIndentProduct(IndentProduct indentProduct) {
		getIndentProducts().add(indentProduct);
		indentProduct.setProduct(this);

		return indentProduct;
	}

	public IndentProduct removeIndentProduct(IndentProduct indentProduct) {
		getIndentProducts().remove(indentProduct);
		indentProduct.setProduct(null);

		return indentProduct;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public ProductCommodityTypeMaster getProductCommodityTypeMaster() {
		return this.productCommodityTypeMaster;
	}

	public void setProductCommodityTypeMaster(ProductCommodityTypeMaster productCommodityTypeMaster) {
		this.productCommodityTypeMaster = productCommodityTypeMaster;
	}

	public ProductDrugLineMaster getProductDrugLineMaster() {
		return this.productDrugLineMaster;
	}

	public void setProductDrugLineMaster(ProductDrugLineMaster productDrugLineMaster) {
		this.productDrugLineMaster = productDrugLineMaster;
	}

	public ProductRecipientTypeMaster getProductRecipientTypeMaster() {
		return this.productRecipientTypeMaster;
	}

	public void setProductRecipientTypeMaster(ProductRecipientTypeMaster productRecipientTypeMaster) {
		this.productRecipientTypeMaster = productRecipientTypeMaster;
	}

	public ProductTypesMaster getProductTypesMaster() {
		return this.productTypesMaster;
	}

	public void setProductTypesMaster(ProductTypesMaster productTypesMaster) {
		this.productTypesMaster = productTypesMaster;
	}

	public ProductUomMaster getProductUomMaster() {
		return this.productUomMaster;
	}

	public void setProductUomMaster(ProductUomMaster productUomMaster) {
		this.productUomMaster = productUomMaster;
	}

	public Set<ProductDosage> getProductDosages() {
		return this.productDosages;
	}

	public void setProductDosages(Set<ProductDosage> productDosages) {
		this.productDosages = productDosages;
	}

	public ProductDosage addProductDosage(ProductDosage productDosage) {
		getProductDosages().add(productDosage);
		productDosage.setProduct(this);

		return productDosage;
	}

	public ProductDosage removeProductDosage(ProductDosage productDosage) {
		getProductDosages().remove(productDosage);
		productDosage.setProduct(null);

		return productDosage;
	}

	public Set<ProductLabTypesMapping> getProductLabTypesMappings() {
		return this.productLabTypesMappings;
	}

	public void setProductLabTypesMappings(Set<ProductLabTypesMapping> productLabTypesMappings) {
		this.productLabTypesMappings = productLabTypesMappings;
	}

	public ProductLabTypesMapping addProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().add(productLabTypesMapping);
		productLabTypesMapping.setProduct(this);

		return productLabTypesMapping;
	}

	public ProductLabTypesMapping removeProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().remove(productLabTypesMapping);
		productLabTypesMapping.setProduct(null);

		return productLabTypesMapping;
	}

	public Set<RegimenConstituent> getRegimenConstituents() {
		return this.regimenConstituents;
	}

	public void setRegimenConstituents(Set<RegimenConstituent> regimenConstituents) {
		this.regimenConstituents = regimenConstituents;
	}

	public RegimenConstituent addRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().add(regimenConstituent);
		regimenConstituent.setProduct(this);

		return regimenConstituent;
	}

	public RegimenConstituent removeRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().remove(regimenConstituent);
		regimenConstituent.setProduct(null);

		return regimenConstituent;
	}

	public Set<SupplierStock> getSupplierStocks() {
		return this.supplierStocks;
	}

	public void setSupplierStocks(Set<SupplierStock> supplierStocks) {
		this.supplierStocks = supplierStocks;
	}

	public SupplierStock addSupplierStock(SupplierStock supplierStock) {
		getSupplierStocks().add(supplierStock);
		supplierStock.setProduct(this);

		return supplierStock;
	}

	public SupplierStock removeSupplierStock(SupplierStock supplierStock) {
		getSupplierStocks().remove(supplierStock);
		supplierStock.setProduct(null);

		return supplierStock;
	}

	public Set<TiOstBulkDispensation> getTiOstBulkDispensations() {
		return this.tiOstBulkDispensations;
	}

	public void setTiOstBulkDispensations(Set<TiOstBulkDispensation> tiOstBulkDispensations) {
		this.tiOstBulkDispensations = tiOstBulkDispensations;
	}

	public TiOstBulkDispensation addTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		getTiOstBulkDispensations().add(tiOstBulkDispensation);
		tiOstBulkDispensation.setProduct(this);

		return tiOstBulkDispensation;
	}

	public TiOstBulkDispensation removeTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		getTiOstBulkDispensations().remove(tiOstBulkDispensation);
		tiOstBulkDispensation.setProduct(null);

		return tiOstBulkDispensation;
	}

	public Set<TiOstDispensation> getTiOstDispensations() {
		return this.tiOstDispensations;
	}

	public void setTiOstDispensations(Set<TiOstDispensation> tiOstDispensations) {
		this.tiOstDispensations = tiOstDispensations;
	}

	public TiOstDispensation addTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().add(tiOstDispensation);
		tiOstDispensation.setProduct(this);

		return tiOstDispensation;
	}

	public TiOstDispensation removeTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().remove(tiOstDispensation);
		tiOstDispensation.setProduct(null);

		return tiOstDispensation;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return this.tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setProduct(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setProduct(null);

		return tiOstDispensationItem;
	}

	public Set<TiOstDrugDispensation> getTiOstDrugDispensations() {
		return this.tiOstDrugDispensations;
	}

	public void setTiOstDrugDispensations(Set<TiOstDrugDispensation> tiOstDrugDispensations) {
		this.tiOstDrugDispensations = tiOstDrugDispensations;
	}

	public TiOstDrugDispensation addTiOstDrugDispensation(TiOstDrugDispensation tiOstDrugDispensation) {
		getTiOstDrugDispensations().add(tiOstDrugDispensation);
		tiOstDrugDispensation.setProduct(this);

		return tiOstDrugDispensation;
	}

	public TiOstDrugDispensation removeTiOstDrugDispensation(TiOstDrugDispensation tiOstDrugDispensation) {
		getTiOstDrugDispensations().remove(tiOstDrugDispensation);
		tiOstDrugDispensation.setProduct(null);

		return tiOstDrugDispensation;
	}

	public Set<TiOstPrescription> getTiOstPrescriptions() {
		return this.tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setProduct(this);

		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setProduct(null);

		return tiOstPrescription;
	}

}