package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.ExtDetailsTimeAvailabilityReadOnly;
import gov.naco.soch.ti.dto.ExtDetailsTimeAvailabilityMappingDto;


@Mapper(componentModel = "spring",uses=MMBenificiaryTimeAvailability.class)
public interface ExtDetailsAvailMapperReadOnly extends EntityMapper<ExtDetailsTimeAvailabilityMappingDto, ExtDetailsTimeAvailabilityReadOnly>{
	
	@Mapping(source="tiBeneficiaryExtDetails.id",target="tiBeneficiaryExtDetailsId")
	@Mapping(target="masterBenificiaryTimeAvailability",qualifiedByName="timeAvailability")
	ExtDetailsTimeAvailabilityMappingDto toDto(ExtDetailsTimeAvailabilityReadOnly extDetailsTimeAvailabilityMapping);
	

	
	default ExtDetailsTimeAvailabilityReadOnly fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        ExtDetailsTimeAvailabilityReadOnly extDetailsTimeAvailabilityReadOnly = new ExtDetailsTimeAvailabilityReadOnly();
	        extDetailsTimeAvailabilityReadOnly.setId(id);
	        return extDetailsTimeAvailabilityReadOnly;
	    }
}
