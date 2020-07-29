package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.dto.ProductDto;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductCommodityTypeMaster;
import gov.naco.soch.entity.ProductDrugLineMaster;
import gov.naco.soch.entity.ProductFacilityTypeMapping;
import gov.naco.soch.entity.ProductLabTypesMapping;
import gov.naco.soch.entity.ProductRecipientTypeMaster;
import gov.naco.soch.projection.ProductInventoryProjection;

public class ProductMapper {

	/*
	 * function to map list of ProductDto class to Product
	 */
	public static Product mapToProduct(ProductDto productDto, Product product) {
		if (product == null) {
			product = new Product();
		}
		product.setProductName(productDto.getProductName());
		product.setIsBatchNumber(productDto.getBatchNo());
		product.setProductShortCode(productDto.getShortCode());
		product.setMinimumShelfLife(productDto.getMinShelfLife());
		product.setFormulation(productDto.getFormulationComposition());
		product.setProductDetail(productDto.getProductDetails());

		ProductCommodityTypeMaster commodityTypeMaster = null;
		if (productDto.getCommodityTypeId() != null && productDto.getCommodityTypeId() != 0) {
			commodityTypeMaster = new ProductCommodityTypeMaster();
			commodityTypeMaster.setId(productDto.getCommodityTypeId());
		}

		ProductRecipientTypeMaster master = null;
		if (productDto.getRecepientTypeId() != null && productDto.getRecepientTypeId() != 0) {
			master = new ProductRecipientTypeMaster();
			master.setId(productDto.getRecepientTypeId());
		}

		ProductDrugLineMaster drugLineMaster = null;
		if (productDto.getDrugLineId() != null && productDto.getDrugLineId() != 0) {
			drugLineMaster = new ProductDrugLineMaster();
			drugLineMaster.setId(productDto.getDrugLineId());
		}

		product.setProductCommodityTypeMaster(commodityTypeMaster);
		product.setProductRecipientTypeMaster(master);
		product.setProductDrugLineMaster(drugLineMaster);

		product.setIsActive(productDto.getIsActive());
		product.setIsDelete(false);
		return product;
	}

	/*
	 * function to map list of ProductDto class to Product
	 */
	public static ProductDto mapToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setProductName(product.getProductName());
		productDto.setProductImage(product.getProductImage() != null ? product.getProductImage() : null);
		if (product.getIsBatchNumber() != null) {
			productDto.setBatchNo(product.getIsBatchNumber());
		}
		productDto.setShortCode(product.getProductShortCode());
		productDto.setMinShelfLife(product.getMinimumShelfLife());
		productDto.setFormulationComposition(product.getFormulation());
		productDto.setProductDetails(product.getProductDetail());

		if (product.getProductUomMaster() != null) {
			MasterDto masterDto = new MasterDto();
			masterDto.setId(product.getProductUomMaster().getId());
			masterDto.setName(product.getProductUomMaster().getUomName());
			productDto.setUom(masterDto);
		}

		if (product.getProductTypesMaster() != null) {
			MasterDto masterDto = new MasterDto();
			masterDto.setId(product.getProductTypesMaster().getId());
			masterDto.setName(product.getProductTypesMaster().getProductTypeName());
			productDto.setProductType(masterDto);
		}

		if (product.getDivision() != null) {
			MasterDto masterDto = new MasterDto();
			masterDto.setId(product.getDivision().getId());
			masterDto.setName(product.getDivision().getName());
			productDto.setDivision(masterDto);
		}

		if (product.getProductLabTypesMappings() != null && !product.getProductLabTypesMappings().isEmpty()) {
			List<MasterDto> labTypeList = new ArrayList<MasterDto>();
			for (ProductLabTypesMapping productLabTypesMapping : product.getProductLabTypesMappings()) {
				MasterDto masterDto = new MasterDto();
				masterDto.setId(productLabTypesMapping.getLabTypesMaster().getId());
				masterDto.setName(productLabTypesMapping.getLabTypesMaster().getLabTypeName());
				labTypeList.add(masterDto);
			}
			productDto.setLabTypes(labTypeList);
		}

		if (product.getProductFacilityTypeMappings() != null && !product.getProductFacilityTypeMappings().isEmpty()) {
			List<MasterDto> facilitytypeList = new ArrayList<MasterDto>();
			for (ProductFacilityTypeMapping productFacilityTypeMapping : product.getProductFacilityTypeMappings()) {
				MasterDto masterDto = new MasterDto();
				masterDto.setId(productFacilityTypeMapping.getFacilityType().getId());
				masterDto.setName(productFacilityTypeMapping.getFacilityType().getFacilityTypeName());
				facilitytypeList.add(masterDto);
			}
			productDto.setFacilityTypes(facilitytypeList);
		}

		if (product.getProductCommodityTypeMaster() != null) {
			productDto.setCommodityTypeId(product.getProductCommodityTypeMaster().getId());
			productDto.setCommodityTypeName(product.getProductCommodityTypeMaster().getProductCommodityTypeName());
		}

		if (product.getProductRecipientTypeMaster() != null) {
			productDto.setRecepientTypeId(product.getProductRecipientTypeMaster().getId());
			productDto.setRecepientTypeName(product.getProductRecipientTypeMaster().getProductRecipientTypeName());
		}

		if (product.getProductDrugLineMaster() != null) {
			productDto.setDrugLineId(product.getProductDrugLineMaster().getId());
			productDto.setDrugLineName(product.getProductDrugLineMaster().getProductDrugLineName());
		}

		productDto.setIsActive(product.getIsActive());

		return productDto;
	}

	public static Product mapToProductId(Long productId) {
		Product product = new Product();
		product.setId(productId);
		return product;
	}

	public static String advanceSearchQueryCreator(Map<String, String> searchValue) {
		String productName = searchValue.get("productname");
		String shortCode = searchValue.get("shortcode");
		String uom = searchValue.get("uom");
		String productType = searchValue.get("producttype");
		String searchQuery = "select p.* from soch.product p where p.is_delete=false ";

		if (productName != null && productName != "") {
			searchQuery = searchQuery.concat("and lower(p.product_name) Like lower('%" + productName + "%') ");
		}
		if (shortCode != null && shortCode != "") {
			searchQuery = searchQuery.concat("and lower(p.product_short_code) Like lower('%" + shortCode + "%') ");
		}
		if (uom != null && uom != "") {
			searchQuery = searchQuery.concat("and p.uom_id=" + uom + " ");
		}
		if (productType != null && productType != "") {
			searchQuery = searchQuery.concat("and p.product_type_id=" + productType + " ");
		}
		searchQuery = searchQuery.concat("order by p.product_name asc");
		return searchQuery;
	}

	public static List<ProductDto> mapProjectionListToProductDtoList(List<ProductInventoryProjection> products) {
		List<ProductDto> productList = new ArrayList<>();
		for (ProductInventoryProjection projection : products) {
			ProductDto productDto = new ProductDto();
			productDto.setId(projection.getProductId() != null ? projection.getProductId() : null);
			productDto.setProductName(projection.getProductName() != null ? projection.getProductName() : null);
			productDto.setShortCode(projection.getProductCode() != null ? projection.getProductCode() : null);
			if (projection.getUomId() != null) {
				MasterDto productUom = new MasterDto();
				productUom.setId(projection.getUomId());
				productUom.setName(projection.getUomName() != null ? projection.getUomName() : null);
				productDto.setUom(productUom);
			}
			productList.add(productDto);
		}
		return productList;
	}

}
