package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import gov.naco.soch.dto.ProductDosageDto;
import gov.naco.soch.entity.MasterWeightBand;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.entity.ProductDosageCategoryMaster;

public class ProductDosageMapper {

	/**
	 * @param productDosageDto
	 * @param product
	 * @param productDosage
	 * @return
	 */
	public static ProductDosage mapToProductDosageDto(ProductDosageDto productDosageDto, Product product,
			ProductDosage productDosage) {

		if (productDosage == null) {
			productDosage = new ProductDosage();
			productDosage.setIsActive(Boolean.TRUE);
			productDosage.setIsDelete(Boolean.FALSE);
		}
		productDosage.setDosageQtyPerMonth(productDosageDto.getDosagePerMonth());
		productDosage.setProduct(product);

		ProductDosageCategoryMaster productDosageCategoryMaster = null;
		if (productDosageDto.getCategoryId() != null) {
			productDosageCategoryMaster = new ProductDosageCategoryMaster();
			productDosageCategoryMaster.setId(productDosageDto.getCategoryId());
		}

		MasterWeightBand weightBandMaster = null;
		if (productDosageDto.getWeightBandId() != null) {
			weightBandMaster = new MasterWeightBand();
			weightBandMaster.setId(productDosageDto.getWeightBandId());
		}
		productDosage.setProductDosageCategoryMaster(productDosageCategoryMaster);
		productDosage.setMasterWeightBand(weightBandMaster);

		return productDosage;
	}

	/**
	 * @param dosageList
	 * @return
	 */
	public static List<ProductDosageDto> mapToProductDosageDtoList(List<ProductDosage> dosageList) {
		List<ProductDosageDto> dosageDtos = new ArrayList<>();
		for (ProductDosage productDosage : dosageList) {
			ProductDosageDto productDosageDto = new ProductDosageDto();

			productDosageDto.setDosageId(productDosage.getId());
			productDosageDto.setDosagePerMonth(productDosage.getDosageQtyPerMonth());
			if (productDosage.getProduct() != null) {
				productDosageDto.setProductId(productDosage.getProduct().getId());
				productDosageDto.setProductName(productDosage.getProduct().getProductName());
				productDosageDto.setShortCode(productDosage.getProduct().getProductShortCode());
			}
			if (productDosage.getProductDosageCategoryMaster() != null) {
				productDosageDto.setCategoryId(productDosage.getProductDosageCategoryMaster().getId());
				productDosageDto
						.setCategoryName(productDosage.getProductDosageCategoryMaster().getProductDosageCategoryName());
			}
			if (productDosage.getMasterWeightBand() != null) {
				productDosageDto.setWeightBandId(productDosage.getMasterWeightBand().getId());
				productDosageDto.setWeightBand(productDosage.getMasterWeightBand().getName());
			}
			dosageDtos.add(productDosageDto);
		}

		return dosageDtos;
	}

	public static String countQueryCreator(ProductDosageDto productDosageDto) {
		String countQuery = "";
		if (productDosageDto.getDosageId() != null && productDosageDto.getDosageId() != 0) {
			countQuery = "select count(pd.id) from soch.product_dosage pd where pd.is_delete=false and pd.product_id="
					+ productDosageDto.getProductId() + " and pd.age_category=" + productDosageDto.getCategoryId()
					+ " and pd.dosage_qty_per_month=" + productDosageDto.getDosagePerMonth() + " and pd.weight_band="
					+ productDosageDto.getWeightBandId() + " and pd.id!=" + productDosageDto.getDosageId() + " ";
		} else {
			countQuery = "select count(pd.id) from soch.product_dosage pd where pd.is_delete=false and pd.product_id="
					+ productDosageDto.getProductId() + " and pd.age_category=" + productDosageDto.getCategoryId()
					+ " and pd.dosage_qty_per_month=" + productDosageDto.getDosagePerMonth() + " and pd.weight_band="
					+ productDosageDto.getWeightBandId() + " ";
		}
		return countQuery;
	}

	public static String findQueryCreator(ProductDosageDto productDosageDto) {
		String findQuery = "select pd.* from soch.product_dosage pd where pd.is_delete=true and pd.product_id="
				+ productDosageDto.getProductId() + " and pd.age_category=" + productDosageDto.getCategoryId()
				+ " and pd.dosage_qty_per_month=" + productDosageDto.getDosagePerMonth() + " and pd.weight_band="
				+ productDosageDto.getWeightBandId() + " ";
		return findQuery;
	}
}
