package gov.naco.soch.ti.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.OstBeneficiaryReadOnly;
import gov.naco.soch.ti.dto.OstBenDto;

@Mapper(componentModel = "spring", uses = {MMReferredFromMapper.class, MMTypologyMapper.class,
	MMRelationshipMapper.class, MMOstStatusMapper.class, BeneficiaryMapperReadOnly.class, HotspotOstBenMapperReadOnly.class,
	BenTransFacMapperReadOnly.class, MMOstBenStatusMapper.class })
public interface OstBenMapper extends EntityMapper<OstBenDto, OstBeneficiaryReadOnly> {

    @Mapping(source = "beneficiary", target = "masterBeneficiary")
    @Mapping(target = "referredFrom", qualifiedByName = "referredFrom")
    @Mapping(target = "hrgPrimary", qualifiedByName = "typology")
    @Mapping(target = "guardianRelationshipType", qualifiedByName = "relationship")
    @Mapping(target = "ostStatus", qualifiedByName = "ostStatus")
    @Mapping(target = "status", qualifiedByName = "ostBenStatus")
    @Mapping(target = "facility.id", source="facilityId", qualifiedByName = "ostBenStatus")
    OstBenDto toDto(OstBeneficiaryReadOnly tiOstBeneficiary);

    List<OstBenDto> toDto(List<OstBeneficiaryReadOnly> tiOstBeneficiary);

}
