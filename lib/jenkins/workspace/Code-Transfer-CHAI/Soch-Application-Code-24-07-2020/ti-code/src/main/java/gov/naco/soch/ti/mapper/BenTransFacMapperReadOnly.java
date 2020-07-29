package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.BeneficiaryTransitFacilityReadOnly;
import gov.naco.soch.ti.dto.BeneficiaryTransitFacilityDto;

@Mapper(componentModel = "spring")
public interface BenTransFacMapperReadOnly extends EntityMapper<BeneficiaryTransitFacilityDto, BeneficiaryTransitFacilityReadOnly>  {
	
	@Mapping(source="tiOstBeneficiary.id",target="beneficiaryId")
	BeneficiaryTransitFacilityDto toDto(BeneficiaryTransitFacilityReadOnly beneficiaryTransitFacility);
	
	
	default BeneficiaryTransitFacilityReadOnly fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryTransitFacilityReadOnly beneficiaryTransitFacilityReadOnly = new BeneficiaryTransitFacilityReadOnly();
		beneficiaryTransitFacilityReadOnly.setId(id);
		return beneficiaryTransitFacilityReadOnly;
	}

}
