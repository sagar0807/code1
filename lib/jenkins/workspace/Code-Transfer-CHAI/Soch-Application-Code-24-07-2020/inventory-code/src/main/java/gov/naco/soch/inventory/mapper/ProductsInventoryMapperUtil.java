package gov.naco.soch.inventory.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gov.naco.soch.dto.BatchDetailsDto;
import gov.naco.soch.dto.ProductsInventoryDto;
import gov.naco.soch.entity.FacilityAggregateStock;
import gov.naco.soch.projection.FacilityAggregateStockProjection;
import gov.naco.soch.projection.ProductInventoryProjection;

public class ProductsInventoryMapperUtil {

	/**
	 * @param facilityAggregateStockList
	 * @return
	 */
	/*
	 * public static List<ProductsInventoryDto>
	 * mapFacilityAggregateStockListToSacsProductsInventoryDtoList(
	 * List<FacilityAggregateStock> facilityAggregateStockList) {
	 * 
	 * String image = ""; List<ProductsInventoryDto> sacsProductsInventoryDtos = new
	 * ArrayList<ProductsInventoryDto>(); for (FacilityAggregateStock
	 * facilityAggregateStock : facilityAggregateStockList) { image = "";
	 * ProductsInventoryDto sacsProductsInventoryDto = new ProductsInventoryDto();
	 * sacsProductsInventoryDto.setFacilityAggregateStockId(facilityAggregateStock.
	 * getId());
	 * sacsProductsInventoryDto.setAvailableQuantity(facilityAggregateStock.
	 * getAvailableQuantity());
	 * sacsProductsInventoryDto.setExpiredQuantity(facilityAggregateStock.
	 * getExpiredQuantity());
	 * sacsProductsInventoryDto.setGit(facilityAggregateStock.getGit());
	 * sacsProductsInventoryDto.setFacilityId(facilityAggregateStock.getFacility().
	 * getId());
	 * sacsProductsInventoryDto.setFacilityCode(facilityAggregateStock.getFacility()
	 * .getCode());
	 * sacsProductsInventoryDto.setFacilityName(facilityAggregateStock.getFacility()
	 * .getName());
	 * sacsProductsInventoryDto.setProductId(facilityAggregateStock.getProduct().
	 * getId());
	 * sacsProductsInventoryDto.setProductCode(facilityAggregateStock.getProduct().
	 * getProductCode());
	 * sacsProductsInventoryDto.setProductName(facilityAggregateStock.getProduct().
	 * getProductName()); if (facilityAggregateStock.getProduct().getProductImage()
	 * != null) { image =
	 * String.valueOf(facilityAggregateStock.getProduct().getProductImage()); }
	 * sacsProductsInventoryDto.setProductImage(image);
	 * 
	 * sacsProductsInventoryDtos.add(sacsProductsInventoryDto); } return
	 * sacsProductsInventoryDtos; }
	 */

	/**
	 * @param facilityAggregateStock
	 * @return
	 */
	/*
	 * public static ProductsInventoryDto
	 * mapFacilityAggregateStockToSacsProductsInventoryDto( FacilityAggregateStock
	 * facilityAggregateStock) { String image = "";
	 * 
	 * ProductsInventoryDto sacsProductsInventoryDto = new ProductsInventoryDto();
	 * if (facilityAggregateStock != null) {
	 * sacsProductsInventoryDto.setFacilityAggregateStockId(facilityAggregateStock.
	 * getId());
	 * sacsProductsInventoryDto.setAvailableQuantity(facilityAggregateStock.
	 * getAvailableQuantity());
	 * sacsProductsInventoryDto.setExpiredQuantity(facilityAggregateStock.
	 * getExpiredQuantity());
	 * sacsProductsInventoryDto.setGit(facilityAggregateStock.getGit());
	 * sacsProductsInventoryDto.setFacilityId(facilityAggregateStock.getFacility().
	 * getId());
	 * sacsProductsInventoryDto.setFacilityCode(facilityAggregateStock.getFacility()
	 * .getCode());
	 * sacsProductsInventoryDto.setFacilityName(facilityAggregateStock.getFacility()
	 * .getName());
	 * sacsProductsInventoryDto.setProductId(facilityAggregateStock.getProduct().
	 * getId());
	 * sacsProductsInventoryDto.setProductCode(facilityAggregateStock.getProduct().
	 * getProductCode());
	 * sacsProductsInventoryDto.setProductName(facilityAggregateStock.getProduct().
	 * getProductName()); if (facilityAggregateStock.getProduct().getProductImage()
	 * != null) { image =
	 * String.valueOf(facilityAggregateStock.getProduct().getProductImage()); }
	 * sacsProductsInventoryDto.setProductImage(image); } return
	 * sacsProductsInventoryDto; }
	 */

	/**
	 * @param sacsProductInventoryProjectionList
	 * @return
	 */
	public static List<ProductsInventoryDto> mapFacsProductInventoryProjectionListToSacsProductsInventoryDtoList(
			List<ProductInventoryProjection> sacsProductInventoryProjectionList) {

		List<ProductsInventoryDto> SacsProductsInventoryDtoList = new ArrayList<>();
		for (ProductInventoryProjection sacsProductInventoryProjection : sacsProductInventoryProjectionList) {

			ProductsInventoryDto sacsProductsInventoryDto = new ProductsInventoryDto();

			sacsProductsInventoryDto.setProductName(sacsProductInventoryProjection.getProductName());
			sacsProductsInventoryDto.setProductId(sacsProductInventoryProjection.getProductId());
			sacsProductsInventoryDto.setProductCode(sacsProductInventoryProjection.getProductCode());
			sacsProductsInventoryDto.setProductImage(sacsProductInventoryProjection.getProductImage() != null
					? sacsProductInventoryProjection.getProductImage()
					: null);
			sacsProductsInventoryDto.setAvailableQuantity(sacsProductInventoryProjection.getAvailableQuantity());
			sacsProductsInventoryDto.setExpiredQuantity(sacsProductInventoryProjection.getExpiredQuantity());
			sacsProductsInventoryDto.setFacilityId(sacsProductInventoryProjection.getFacilityId());
			sacsProductsInventoryDto.setGit(sacsProductInventoryProjection.getGit());
			sacsProductsInventoryDto.setDamagedQuantity(sacsProductInventoryProjection.getDamagedQuantity());

			SacsProductsInventoryDtoList.add(sacsProductsInventoryDto);
		}

		return SacsProductsInventoryDtoList;
	}

	/**
	 * @param sacsProductInventoryProjection
	 * @return
	 */
	public static ProductsInventoryDto mapSacsProductInventoryProjectionToSacsProductsInventoryDto(
			ProductInventoryProjection sacsProductInventoryProjection) {
		ProductsInventoryDto sacsProductsInventoryDto = new ProductsInventoryDto();

		sacsProductsInventoryDto.setProductName(sacsProductInventoryProjection.getProductName());
		sacsProductsInventoryDto.setProductId(sacsProductInventoryProjection.getProductId());
		sacsProductsInventoryDto.setProductCode(sacsProductInventoryProjection.getProductCode());
		sacsProductsInventoryDto.setProductImage(sacsProductInventoryProjection.getProductImage() != null
				? sacsProductInventoryProjection.getProductImage()
				: null);
		sacsProductsInventoryDto.setAvailableQuantity(sacsProductInventoryProjection.getAvailableQuantity());
		sacsProductsInventoryDto.setExpiredQuantity(sacsProductInventoryProjection.getExpiredQuantity());
		sacsProductsInventoryDto.setFacilityId(sacsProductInventoryProjection.getFacilityId());
		sacsProductsInventoryDto.setGit(sacsProductInventoryProjection.getGit());
		sacsProductsInventoryDto.setDamagedQuantity(sacsProductInventoryProjection.getDamagedQuantity());

		return sacsProductsInventoryDto;
	}

	/**
	 * @param facilityAggregateStockList
	 * @param sacsProductsInventoryDto
	 * @return
	 */
	public static ProductsInventoryDto mapFacilityAggregateStockListToSacsProductsInventoryDto(
			List<FacilityAggregateStock> facilityAggregateStockList, ProductsInventoryDto sacsProductsInventoryDto) {

		List<BatchDetailsDto> activeBatchDetails = new ArrayList<>();
		List<BatchDetailsDto> expiredBatchDetails = new ArrayList<>();

		for (FacilityAggregateStock facilityAggregateStock : facilityAggregateStockList) {
			BatchDetailsDto batchDetailsDto = new BatchDetailsDto();
			if (facilityAggregateStock.getBatchExpiryDate().isAfter(LocalDate.now())) {

				if (facilityAggregateStock.getBatchNumber() != null) {
					batchDetailsDto.setBatchNumber(String.valueOf(facilityAggregateStock.getBatchNumber()));
				}
				if (facilityAggregateStock.getBatchExpiryDate() != null) {
					batchDetailsDto.setExpiryDate(String.valueOf(facilityAggregateStock.getBatchExpiryDate()));
				}
				if (facilityAggregateStock.getBatchManufactureDate() != null) {
					batchDetailsDto
							.setManufactureDate(String.valueOf(facilityAggregateStock.getBatchManufactureDate()));
				}
				batchDetailsDto.setQuantity(facilityAggregateStock.getAvailableQuantity());
				batchDetailsDto.setDamagedQuantity(facilityAggregateStock.getDamagedQuantity());
				Double GoodQuantity=facilityAggregateStock.getAvailableQuantity();
				if(facilityAggregateStock.getDamagedQuantity()!=null) {
					 GoodQuantity=facilityAggregateStock.getAvailableQuantity()-facilityAggregateStock.getDamagedQuantity();
				}
				batchDetailsDto.setGoodQuantity(GoodQuantity);

				if (facilityAggregateStock.getProduct() != null) {
					if (facilityAggregateStock.getProduct().getProductTypesMaster() != null) {
						batchDetailsDto
								.setProductTypeId(facilityAggregateStock.getProduct().getProductTypesMaster().getId());
						batchDetailsDto.setProductType(
								facilityAggregateStock.getProduct().getProductTypesMaster().getProductTypeName());
					}
					if (facilityAggregateStock.getProduct().getProductUomMaster() != null) {
						batchDetailsDto.setUomId(facilityAggregateStock.getProduct().getProductUomMaster().getId());
						batchDetailsDto.setUom(facilityAggregateStock.getProduct().getProductUomMaster().getUomName());
					}
				}

				activeBatchDetails.add(batchDetailsDto);
			} else if (facilityAggregateStock.getBatchExpiryDate().isBefore(LocalDate.now())) {

				if (facilityAggregateStock.getBatchNumber() != null) {
					batchDetailsDto.setBatchNumber(String.valueOf(facilityAggregateStock.getBatchNumber()));
				}
				if (facilityAggregateStock.getBatchExpiryDate() != null) {
					batchDetailsDto.setExpiryDate(String.valueOf(facilityAggregateStock.getBatchExpiryDate()));
				}
				if (facilityAggregateStock.getBatchManufactureDate() != null) {
					batchDetailsDto
							.setManufactureDate(String.valueOf(facilityAggregateStock.getBatchManufactureDate()));
				}
				batchDetailsDto.setQuantity(facilityAggregateStock.getAvailableQuantity());
				batchDetailsDto.setDamagedQuantity(facilityAggregateStock.getDamagedQuantity());
				Double GoodQuantity=facilityAggregateStock.getAvailableQuantity();
				if(facilityAggregateStock.getDamagedQuantity()!=null) {
					 GoodQuantity=facilityAggregateStock.getAvailableQuantity()-facilityAggregateStock.getDamagedQuantity();
				}
				batchDetailsDto.setGoodQuantity(GoodQuantity);

				if (facilityAggregateStock.getProduct() != null) {
					if (facilityAggregateStock.getProduct().getProductTypesMaster() != null) {
						batchDetailsDto
								.setProductTypeId(facilityAggregateStock.getProduct().getProductTypesMaster().getId());
						batchDetailsDto.setProductType(
								facilityAggregateStock.getProduct().getProductTypesMaster().getProductTypeName());
					}
					if (facilityAggregateStock.getProduct().getProductUomMaster() != null) {
						batchDetailsDto.setUomId(facilityAggregateStock.getProduct().getProductUomMaster().getId());
						batchDetailsDto.setUom(facilityAggregateStock.getProduct().getProductUomMaster().getUomName());
					}
				}

				expiredBatchDetails.add(batchDetailsDto);
			} else if (facilityAggregateStock.getBatchExpiryDate().isEqual(LocalDate.now())) {

				if (facilityAggregateStock.getBatchNumber() != null) {
					batchDetailsDto.setBatchNumber(String.valueOf(facilityAggregateStock.getBatchNumber()));
				}
				if (facilityAggregateStock.getBatchExpiryDate() != null) {
					batchDetailsDto.setExpiryDate(String.valueOf(facilityAggregateStock.getBatchExpiryDate()));
				}
				if (facilityAggregateStock.getBatchManufactureDate() != null) {
					batchDetailsDto
							.setManufactureDate(String.valueOf(facilityAggregateStock.getBatchManufactureDate()));
				}
				batchDetailsDto.setQuantity(facilityAggregateStock.getAvailableQuantity());
				batchDetailsDto.setDamagedQuantity(facilityAggregateStock.getDamagedQuantity());
				Double GoodQuantity=facilityAggregateStock.getAvailableQuantity();
				if(facilityAggregateStock.getDamagedQuantity()!=null) {
					 GoodQuantity=facilityAggregateStock.getAvailableQuantity()-facilityAggregateStock.getDamagedQuantity();
				}
				batchDetailsDto.setGoodQuantity(GoodQuantity);

				if (facilityAggregateStock.getProduct() != null) {
					if (facilityAggregateStock.getProduct().getProductTypesMaster() != null) {
						batchDetailsDto
								.setProductTypeId(facilityAggregateStock.getProduct().getProductTypesMaster().getId());
						batchDetailsDto.setProductType(
								facilityAggregateStock.getProduct().getProductTypesMaster().getProductTypeName());
					}
					if (facilityAggregateStock.getProduct().getProductUomMaster() != null) {
						batchDetailsDto.setUomId(facilityAggregateStock.getProduct().getProductUomMaster().getId());
						batchDetailsDto.setUom(facilityAggregateStock.getProduct().getProductUomMaster().getUomName());
					}
				}

				activeBatchDetails.add(batchDetailsDto);
			} else {
				activeBatchDetails.add(batchDetailsDto);
				expiredBatchDetails.add(batchDetailsDto);
			}

		}
		sacsProductsInventoryDto.setActiveBatchDetails(activeBatchDetails);
		sacsProductsInventoryDto.setExpiredBatchDetails(expiredBatchDetails);
		sacsProductsInventoryDto.setStatus("Active");

		return sacsProductsInventoryDto;
	}

	public static String createSearchQuery(Long facilityId, String productName, String productCode) {
		String searchQuery = "select p.product_name as productName, p.product_code as productCode, "
				+ "fas.product_id as productId,fas.facility_id as facilityId,sum(fas.available_quantity) as availableQuantity,"
				+ "sum(fas.expired_quantity) as expiredQuantity,sum(fas.damaged_quantity) as damagedQuantity,sum(fas.git) as git from (select product_id, facility_id, git,damaged_quantity,"
				+ "case when date(batch_expiry_date) < date(now()) then 0 else available_quantity end as available_quantity, "
				+ "case when date(batch_expiry_date) < date(now()) then available_quantity else 0 end as expired_quantity"
				+ " from soch.facility_aggregate_stock where facility_id =" + facilityId
				+ ") as fas join soch.product as p on "
				+ "p.id = fas.product_id group by fas.product_id,fas.facility_id,p.product_name,p.product_image,p.product_code"
				+ " having fas.facility_id =" + facilityId;
		String subQuery = null;
		if (productName != null && productCode == null) {
			productName=productName.toLowerCase().trim();
			subQuery = " and LOWER(p.product_name) like '%" + productName + "%'";
		} else if (productName == null && productCode != null) {
			productCode=productCode.toLowerCase().trim();
			subQuery = " and LOWER(p.product_code) like '%" + productCode + "%'";
		} else if (productName != null && productCode != null) {
			productName=productName.toLowerCase().trim();
			productCode=productCode.toLowerCase().trim();
			subQuery = " and LOWER(p.product_name) like '%" + productName + "%' and LOWER(p.product_code) like '%" + productCode
					+ "%'";
		}
		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	}

	public static List<ProductsInventoryDto> mapFacilityAggregateStockProjectionToSacsProductsInventoryDtoList(
			List<FacilityAggregateStockProjection> sacsProductInventoryProjectionList) {
		List<ProductsInventoryDto> SacsProductsInventoryDtoList = new ArrayList<>();
		for (FacilityAggregateStockProjection sacsProductInventoryProjection : sacsProductInventoryProjectionList) {

			ProductsInventoryDto sacsProductsInventoryDto = new ProductsInventoryDto();

			sacsProductsInventoryDto.setProductName(sacsProductInventoryProjection.getProductname());
			if (sacsProductInventoryProjection.getProductid() != null) {
				sacsProductsInventoryDto.setProductId(sacsProductInventoryProjection.getProductid().longValue());
			}
			sacsProductsInventoryDto.setProductCode(sacsProductInventoryProjection.getProductcode());
			sacsProductsInventoryDto
					.setAvailableQuantity(sacsProductInventoryProjection.getAvailablequantity().doubleValue());
			sacsProductsInventoryDto
					.setExpiredQuantity(sacsProductInventoryProjection.getExpiredquantity().doubleValue());
			if (sacsProductInventoryProjection.getFacilityid() != null) {
				sacsProductsInventoryDto.setFacilityId(sacsProductInventoryProjection.getFacilityid().longValue());
			}
			sacsProductsInventoryDto.setGit(sacsProductInventoryProjection.getGit());
			sacsProductsInventoryDto.setDamagedQuantity(sacsProductInventoryProjection.getDamagedquantity());

			SacsProductsInventoryDtoList.add(sacsProductsInventoryDto);
		}

		return SacsProductsInventoryDtoList;
	}

}
