package gov.naco.soch.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.domain.BeneficiaryMultiFacilityService;
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.repository.BeneficiaryMultiFacilityServiceRepository;
import gov.naco.soch.repository.ICTCBeneficiaryRepository;

@Service
public class TemporaryMigrationService {

	@Autowired
	private ICTCBeneficiaryRepository ictcBeneficiaryRepository;
	
	@Autowired
	private BeneficiaryMultiFacilityServiceRepository beneficiaryMultiFacilityServiceRepository;
	
	public void migrate() {
		List<ICTCBeneficiary> ictcBeneficiaryEntries = ictcBeneficiaryRepository.findAll();
		List<BeneficiaryMultiFacilityService> mappings = beneficiaryMultiFacilityServiceRepository.findAll();
		if(mappings.isEmpty()) {
			List<BeneficiaryMultiFacilityService> newMappings = new ArrayList<>();
			for(ICTCBeneficiary ictcBeneficiary : ictcBeneficiaryEntries) {
				BeneficiaryMultiFacilityService mapping = new BeneficiaryMultiFacilityService();
				mapping.setBeneficiaryId(ictcBeneficiary.getBeneficiary().getId());
				mapping.setIctcVisitId(ictcBeneficiary.getRecentVisitId());
				mapping.setRegisteredFacilityId(ictcBeneficiary.getFacility().getId());
				mapping.setVisitedFacilityId(ictcBeneficiary.getFacility().getId());
				mapping.setVisitDate(LocalDate.now());
				mapping.setCreatedBy(ictcBeneficiary.getFacility().getId());
				mapping.setCreatedTime(LocalDate.now());
				mapping.setIsActive(true);
				mapping.setIsDeleted(false);
				newMappings.add(mapping);
			}
			beneficiaryMultiFacilityServiceRepository.saveAll(newMappings);
		}
	}
}
