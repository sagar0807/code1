
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ProductTypesDto;
import gov.naco.soch.entity.ProductTypesMaster;


public class ProductTypesMapperUtil {

	// function to map productTypes list to  ProductTypesDto list 
	public static List<ProductTypesDto> mapProductTypesDtoList(List<ProductTypesMaster> productTypesList) {
		List<ProductTypesDto> productTypesDtoList = new ArrayList<ProductTypesDto>();
		if (!CollectionUtils.isEmpty(productTypesList)) {
			productTypesList.forEach(productTypesRow -> {
				ProductTypesDto productTypesDtoRow = new ProductTypesDto();
				productTypesDtoRow.setId(productTypesRow.getId());
				productTypesDtoRow.setProductTypeName(productTypesRow.getProductTypeName().trim());
				productTypesDtoList.add(productTypesDtoRow);
			});
		}

		return productTypesDtoList;
	}

	// function to map ProductTypesDto class to ProductTypes class.
	public static ProductTypesMaster mapToProductTypes(ProductTypesDto productTypesDto,ProductTypesMaster productTypes) {
		if(productTypes==null) {
			productTypes = new ProductTypesMaster();
		}
		if (productTypesDto != null) {
			productTypes.setId(productTypesDto.getId());
			productTypes.setProductTypeName(productTypesDto.getProductTypeName().trim());
		}
		return productTypes;
	}
}
