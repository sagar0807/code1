package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.ti.dto.LinkedBeneficiaryDTO;

@Mapper(componentModel = "spring")
public interface LinkBeneficiaryMapper extends EntityMapper<LinkedBeneficiaryDTO, LinkedFacilityBeneficiary> {

	@Mapping(source="tiOstBeneficiary.id",target="ostBeneficiaryId")
	@Mapping(source="parentFacility.id",target="parentFacilityId")
	@Mapping(source="linkedFacility.id",target="linkedFacilityId")
	@Mapping(source="facilityType.id",target="facilityTypeId")
	LinkedBeneficiaryDTO toDto(LinkedFacilityBeneficiary LinkedFacilityBeneficiary);

	@InheritInverseConfiguration
	LinkedFacilityBeneficiary toEntity(LinkedBeneficiaryDTO linkedBeneficiaryDTO);

	default LinkedFacilityBeneficiary fromId(Long id) {
		if (id == null) {
			return null;
		}
		LinkedFacilityBeneficiary linkedFacilityBeneficiary = new LinkedFacilityBeneficiary();
		linkedFacilityBeneficiary.setId(id);
		return linkedFacilityBeneficiary;
	}

}
