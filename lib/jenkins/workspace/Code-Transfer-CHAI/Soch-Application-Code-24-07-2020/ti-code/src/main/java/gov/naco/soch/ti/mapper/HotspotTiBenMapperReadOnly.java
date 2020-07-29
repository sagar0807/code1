package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiBeneficiaryHotSpotReadOnly;
import gov.naco.soch.ti.dto.HotspotBenMappingDto;

@Mapper(componentModel = "spring")
public interface HotspotTiBenMapperReadOnly extends EntityMapper<HotspotBenMappingDto, TiBeneficiaryHotSpotReadOnly>{

	@Mapping(source="tiBeneficiaryId",target="tiBeneficiary.id")
	@Mapping(source="hotspotId",target="hotspot.id")
	TiBeneficiaryHotSpotReadOnly toEntity(HotspotBenMappingDto hotspotBenMappingDto);
	
	@InheritInverseConfiguration
	HotspotBenMappingDto toDto(TiBeneficiaryHotSpotReadOnly tiBeneficiaryHotspotMapping);
	
	default TiBeneficiaryHotSpotReadOnly fromId(Long id) {
        if (id == null) {
            return null;
        }
        TiBeneficiaryHotSpotReadOnly tiBeneficiaryHotSpotReadOnly = new TiBeneficiaryHotSpotReadOnly();
        tiBeneficiaryHotSpotReadOnly.setId(id);
        return tiBeneficiaryHotSpotReadOnly;
    }
}

