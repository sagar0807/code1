package gov.naco.soch.ti.service;

import java.util.Optional;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.repository.FacilityTypeRepository;

@Component
public class FacilityTypeNameQualifier {

    private FacilityTypeRepository facilityTypeRepo;

    public FacilityTypeNameQualifier(FacilityTypeRepository facilityTypeRepo) {
	this.facilityTypeRepo = facilityTypeRepo;
    }

    @Named("facilityTypeName")
    public String getFacilityTypeName(Integer facilityTypeId) {
	if (facilityTypeId != null) {
	    Optional<FacilityType> facilityTypeOptional = facilityTypeRepo.findById(facilityTypeId.longValue());
	    if (facilityTypeOptional.isPresent()) {
		return facilityTypeOptional.get().getFacilityTypeName();
	    }
	}
	return null;
    }

}
