package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.ExtDetailsTimeAvailabilityMapping;
import gov.naco.soch.ti.dto.ExtDetailsTimeAvailabilityMappingDto;


@Mapper(componentModel = "spring",uses=MMBenificiaryTimeAvailability.class)
public interface ExtDetailsTimeAvailabilityMapper extends EntityMapper<ExtDetailsTimeAvailabilityMappingDto, ExtDetailsTimeAvailabilityMapping>{
	
	@Mapping(source="tiBeneficiaryExtDetails.id",target="tiBeneficiaryExtDetailsId")
	@Mapping(target="masterBenificiaryTimeAvailability",qualifiedByName="timeAvailability")
	ExtDetailsTimeAvailabilityMappingDto toDto(ExtDetailsTimeAvailabilityMapping extDetailsTimeAvailabilityMapping);
	
	@InheritInverseConfiguration
	ExtDetailsTimeAvailabilityMapping toEntity(ExtDetailsTimeAvailabilityMappingDto extDetailsTimeAvailabilityMappingDto);
	
	default ExtDetailsTimeAvailabilityMapping fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        ExtDetailsTimeAvailabilityMapping extDetailsTimeAvailabilityMapping = new ExtDetailsTimeAvailabilityMapping();
	        extDetailsTimeAvailabilityMapping.setId(id);
	        return extDetailsTimeAvailabilityMapping;
	    }
}
