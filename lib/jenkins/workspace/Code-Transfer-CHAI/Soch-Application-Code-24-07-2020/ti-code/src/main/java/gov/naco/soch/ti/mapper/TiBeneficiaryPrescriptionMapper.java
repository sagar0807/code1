package gov.naco.soch.ti.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DivisionDto;
import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.dto.TiBeneficiaryPrescriptionDto;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.Product;
import gov.naco.soch.mapper.BeneficiaryMapperUtil;
import gov.naco.soch.mapper.FacilityMapperUtil;
import gov.naco.soch.mapper.FacilityTypeMapperUtil;
import gov.naco.soch.mapper.ProductMapper;

public class TiBeneficiaryPrescriptionMapper {

	public static List<MasterDto> maProductToMasterDto(List<Product> productList) {
		List<MasterDto> medicineList = new ArrayList<MasterDto>();
		if (!CollectionUtils.isEmpty(productList)) {
			productList.stream().forEach(product -> {
				MasterDto medicine = new MasterDto();
				medicine.setId(product.getId());
				medicine.setName(product.getProductName());
				medicineList.add(medicine);
			});
		}
		return medicineList;
	}

	

}
