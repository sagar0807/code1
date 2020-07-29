
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ProductUomDto;
import gov.naco.soch.entity.ProductUomMaster;

public class ProductUomMapperUtil {

	// function to map ProductUom list to ProductUomDto list
	public static List<ProductUomDto> mapToProductUomDto(List<ProductUomMaster> productUomList) {
		List<ProductUomDto> productUomDtos = new ArrayList<ProductUomDto>();
		if (!CollectionUtils.isEmpty(productUomList)) {
			productUomList.forEach(productUom -> {
				ProductUomDto productUomDto = new ProductUomDto();
				productUomDto.setId(productUom.getId());
				productUomDto.setUomName(productUom.getUomName());
				productUomDtos.add(productUomDto);
			});
		}
		return productUomDtos;
	}

	// function to map ProductUomDto class to ProductUom class.
	public static ProductUomMaster mapToProductUom(ProductUomDto productUomDto, ProductUomMaster productUom) {

		if (productUom == null) {
			productUom = new ProductUomMaster();
		}
		if (productUomDto != null) {
			productUom.setId(productUomDto.getId());
			productUom.setUomName(productUomDto.getUomName());
		}
		return productUom;
	}
}
