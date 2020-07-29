package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;

@Mapper(componentModel = "spring")
public interface BeneficiaryFacilityMapper
		extends EntityMapper<BeneficiaryFacilityMappingDto, BeneficiaryFacilityMapping> {

	@Mapping(source = "beneficiaryId", target = "beneficiary.id")
	@Mapping(source = "facilityId", target = "facility.id")
	BeneficiaryFacilityMapping toEntity(BeneficiaryFacilityMappingDto beneficiaryFacilityMappingDto);

	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "facility.id", target = "facilityId")
	@Mapping(source="facility.facilityType.id",target="facilityTypeId")
	BeneficiaryFacilityMappingDto toDto(BeneficiaryFacilityMapping beneficiaryFacilityMapping);

	
//	Set<BeneficiaryFacilityMapping> toEntity(Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDto);
//
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//	Set<BeneficiaryFacilityMapping> toUpdateEntity(Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDto,
//			@MappingTarget Set<BeneficiaryFacilityMapping> beneficiaryFacilityMapping);

	default BeneficiaryFacilityMapping fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryFacilityMapping beneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
		beneficiaryFacilityMapping.setId(id);
		return beneficiaryFacilityMapping;
	}

}
