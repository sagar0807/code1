package gov.naco.soch.ti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.MasterDto;
import gov.naco.soch.dto.TiBeneficiaryPrescriptionDto;
import gov.naco.soch.entity.Product;
import gov.naco.soch.repository.ProductRepository;
import gov.naco.soch.ti.mapper.TiBeneficiaryPrescriptionMapper;

@Transactional
@Service
public class TiBeneficiaryPrescriptionService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<MasterDto> getMedicineList() {
		List<Product> product=productRepository.findSubstituitionDrugs();
		List<MasterDto> medicineDetails=TiBeneficiaryPrescriptionMapper.maProductToMasterDto(product);
		return medicineDetails;
	}

}
