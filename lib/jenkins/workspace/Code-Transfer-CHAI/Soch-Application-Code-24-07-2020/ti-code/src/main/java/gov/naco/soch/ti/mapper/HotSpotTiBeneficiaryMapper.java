package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiBeneficiaryHotspotMapping;
import gov.naco.soch.ti.dto.HotspotBenMappingDto;

@Mapper(componentModel = "spring")
public interface HotSpotTiBeneficiaryMapper extends EntityMapper<HotspotBenMappingDto, TiBeneficiaryHotspotMapping>{

	@Mapping(source="tiBeneficiaryId",target="tiBeneficiary.id")
	@Mapping(source="hotspotId",target="hotspot.id")
	TiBeneficiaryHotspotMapping toEntity(HotspotBenMappingDto hotspotBenMappingDto);
	
	@InheritInverseConfiguration
	HotspotBenMappingDto toDto(TiBeneficiaryHotspotMapping tiBeneficiaryHotspotMapping);
	
	default TiBeneficiaryHotspotMapping fromId(Long id) {
        if (id == null) {
            return null;
        }
        TiBeneficiaryHotspotMapping tiBeneficiaryHotspotMapping = new TiBeneficiaryHotspotMapping();
        tiBeneficiaryHotspotMapping.setId(id);
        return tiBeneficiaryHotspotMapping;
    }
}

