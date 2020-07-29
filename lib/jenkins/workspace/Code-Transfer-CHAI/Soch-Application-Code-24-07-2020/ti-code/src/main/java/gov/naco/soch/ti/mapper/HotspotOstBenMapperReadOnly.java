package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiBeneficiaryHotSpotReadOnly;
import gov.naco.soch.ti.dto.HotspotBenMappingDto;

@Mapper(componentModel = "spring")
public interface HotspotOstBenMapperReadOnly extends EntityMapper<HotspotBenMappingDto, TiBeneficiaryHotSpotReadOnly>{
	
	@Mapping(target="tiOstBeneficiaryId",source="tiOstBeneficiary.id")
	@Mapping(target="hotspotId",source="hotspot.id")
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
