package gov.naco.soch.ti.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;

@Mapper(componentModel = "spring")
public interface BenFacMapperReadOnly
		extends EntityMapper<BeneficiaryFacilityMappingDto, BeneficiaryFacilityMappingReadOnly> {

	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "facility.id", target = "facilityId")
	@Mapping(source="facility.facilityTypeId",target="facilityTypeId")
	BeneficiaryFacilityMappingDto toDto(BeneficiaryFacilityMappingReadOnly beneficiaryFacilityMapping);

	
	default BeneficiaryFacilityMappingReadOnly fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryFacilityMappingReadOnly benificiaryFacilityMappingReadOnly = new BeneficiaryFacilityMappingReadOnly();
		benificiaryFacilityMappingReadOnly.setId(id);
		return benificiaryFacilityMappingReadOnly;
	}

}
