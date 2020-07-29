package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.BeneficiaryTransitFacility;
import gov.naco.soch.ti.dto.BeneficiaryTransitFacilityDto;

@Mapper(componentModel = "spring")
public interface BeneficiaryTransitFacilityMapper extends EntityMapper<BeneficiaryTransitFacilityDto, BeneficiaryTransitFacility>  {
	
	

	@Mapping(source="facilityId",target="facility.id")
	@Mapping(source="beneficiaryId",target="tiOstBeneficiary.id")
	BeneficiaryTransitFacility toEntity(BeneficiaryTransitFacilityDto beneficiaryTransitFacilityDto);
	

	@Mapping(source="facility.id",target="facilityId")
	@Mapping(source="tiOstBeneficiary.id",target="beneficiaryId")
	BeneficiaryTransitFacilityDto toDto(BeneficiaryTransitFacility beneficiaryTransitFacility);
	
	
	default BeneficiaryTransitFacility fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryTransitFacility beneficiaryTransitFacility = new BeneficiaryTransitFacility();
		beneficiaryTransitFacility.setId(id);
		return beneficiaryTransitFacility;
	}

}
