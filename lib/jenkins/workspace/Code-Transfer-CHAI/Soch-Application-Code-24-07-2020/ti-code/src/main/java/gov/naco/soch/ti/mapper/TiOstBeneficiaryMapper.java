package gov.naco.soch.ti.mapper;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import gov.naco.soch.entity.TiBeneficiaryHotspotMapping;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.ti.dto.HotspotBenMappingDto;
import gov.naco.soch.ti.dto.TIOstBeneficiaryDTO;

@Mapper(componentModel = "spring", uses = { TIOstPrescriptionMapper.class, TiFacilityMapper.class,
		MMReferredFromMapper.class, MMTypologyMapper.class, MMRelationshipMapper.class, MMOstStatusMapper.class,
		BeneficiaryReferMapper.class, TransferMapper.class, BeneficiaryMapper.class, HotspotOstBeneficiaryMapper.class,
		BeneficiaryTransitFacilityMapper.class, TIOstAssessMapper_Initial.class, TIBenFollowUpMapper_Initial.class,MMOstBenStatusMapper.class})
public interface TiOstBeneficiaryMapper extends EntityMapper<TIOstBeneficiaryDTO, TiOstBeneficiary> {

	@Mapping(source = "masterBeneficiary", target = "beneficiary")
	@Mapping(target = "referredFrom", qualifiedByName = "referredFrom")
	@Mapping(target = "hrgPrimary", qualifiedByName = "typology")
	@Mapping(target = "guardianRelationshipType", qualifiedByName = "relationship")
	@Mapping(target = "ostStatus", qualifiedByName = "ostStatus")
	@Mapping( target = "status", qualifiedByName = "ostBenStatus")
	TiOstBeneficiary toEntity(TIOstBeneficiaryDTO tiBeneficiaryDTO);

	@Mapping(source = "beneficiary", target = "masterBeneficiary")
	@Mapping(source = "linkedFacility.id", target = "linkedFacilityId")
	@Mapping(target = "referredFrom", qualifiedByName = "referredFrom")
	@Mapping(target = "hrgPrimary", qualifiedByName = "typology")
	@Mapping(target = "guardianRelationshipType", qualifiedByName = "relationship")
	@Mapping(target = "ostStatus", qualifiedByName = "ostStatus")
	@Mapping( target = "status", qualifiedByName = "ostBenStatus")
	TIOstBeneficiaryDTO toDto(TiOstBeneficiary tiBeneficiary);

	@Mapping(source = "masterBeneficiary", target = "beneficiary")
	@Mapping(source = "referredFrom", target = "referredFrom", qualifiedByName = "referredFrom")
	@Mapping(source = "hrgPrimary", target = "hrgPrimary", qualifiedByName = "typology")
	@Mapping(source = "referredFrom", target = "guardianRelationshipType", qualifiedByName = "relationship")
	@Mapping(source = "ostStatus", target = "ostStatus", qualifiedByName = "ostStatus")
	@Mapping(source = "status", target = "status", qualifiedByName = "ostBenStatus")
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	TiOstBeneficiary toUpdateEntity(TIOstBeneficiaryDTO tiBeneficiaryDTO,
			@MappingTarget TiOstBeneficiary tiOstBeneficiary);

	default TiOstBeneficiary fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiOstBeneficiary tIBeneficiary = new TiOstBeneficiary();
		tIBeneficiary.setId(id);
		return tIBeneficiary;
	}

	@AfterMapping
	default void setHotspotDetails(@MappingTarget TIOstBeneficiaryDTO tiOstBeneficiaryDTO,
			TiOstBeneficiary tiOstBeneficiary) {
		if (tiOstBeneficiary.getHotspotBenMapping() != null) {
			Set<TiBeneficiaryHotspotMapping> hotspotMappings = tiOstBeneficiary.getHotspotBenMapping();
			Map<Long, Optional<TiBeneficiaryHotspotMapping>> groupedByBeneficiaryId = hotspotMappings.stream()
					.collect(Collectors.groupingBy(x -> x.getTiOstBeneficiary().getId(), LinkedHashMap::new,
							Collectors.maxBy(Comparator.comparing(TiBeneficiaryHotspotMapping::getId))));
			Set<TiBeneficiaryHotspotMapping> latestHotspot = groupedByBeneficiaryId.entrySet().stream()
					.map(x -> x.getValue().get()).collect(Collectors.toSet());
			Set<HotspotBenMappingDto> hotspotSet = new HashSet<>();
			latestHotspot.forEach(y -> {
				HotspotBenMappingDto hotspotBenMapping = new HotspotBenMappingDto();
				hotspotBenMapping.setTiOstBeneficiaryId(y.getTiOstBeneficiary().getId());
				hotspotBenMapping.setHotspotId(y.getHotspot().getId());
				hotspotBenMapping.setId(y.getId());
				hotspotBenMapping.setIsActive(y.getIsActive());
				hotspotBenMapping.setIsDelete(y.getIsDelete());
				hotspotSet.add(hotspotBenMapping);
			});
			tiOstBeneficiaryDTO.getHotspotBenMapping().clear();
			tiOstBeneficiaryDTO.getHotspotBenMapping().addAll(hotspotSet);
		}
	}
}