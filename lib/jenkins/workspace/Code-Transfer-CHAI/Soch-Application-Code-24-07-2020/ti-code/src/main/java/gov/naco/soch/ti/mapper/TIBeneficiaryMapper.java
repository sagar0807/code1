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

import gov.naco.soch.entity.TIBeneficiary;
import gov.naco.soch.entity.TiBeneficiaryHotspotMapping;
import gov.naco.soch.ti.dto.HotspotBenMappingDto;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;

/**
 * Mapper for the entity {@link TIBeneficiary} and its DTO
 * {@link TIBeneficiaryDTO}.
 */

@Mapper(componentModel = "spring", uses = { BeneficiaryMapper.class, TIBenExtDetailsMapper.class,
		HotSpotTiBeneficiaryMapper.class, TiFacilityMapper.class, BeneficiaryReferMapper.class, TransferMapper.class,
		TIBenCounsellingMapper_Initial.class, TIBenChildDetailsMapper.class, TIBenRVAssessmentMapper_Initial.class,
		TIStiTreatmentMapper_Initial.class, TIBenScrDetailsMapper_Initial.class, TIOstAssessMapper_Initial.class,
		TIBenFollowUpMapper_Initial.class, MMTypologyMapper.class, MMHrgSecondaryMapper.class,
		MMFSWSubCategoryMapper.class, MMTGSubCategoryMapper.class, MMMSMSubCategoryMapper.class,
		MMIDUSubCategoryMapper.class, MMMigrantOccupation.class, MMDestinationDurationMapper.class,
		MMMobilityTypeMapper.class, MMStayingWithMapper.class, MMRegistrationDoneAtMapper.class,MMTiStatusMapper.class,
		MMTruckerOccupation.class,MMMigrationPatternMapper.class})
public interface TIBeneficiaryMapper extends EntityMapper<TIBeneficiaryDTO, TIBeneficiary> {

	@Mapping(source = "masterBeneficiary", target = "beneficiary")
	@Mapping(target = "hrgPrimary", qualifiedByName = "typology")
	@Mapping(target = "hrgSecondary", qualifiedByName = "hrgSecondary")
	@Mapping(target = "masterDestinationDuration", qualifiedByName = "destinationDuration")
	@Mapping(target = "masterMobilityType", qualifiedByName = "mobilityType")
	@Mapping(target = "masterStayingWith", qualifiedByName = "stayingWith")
	@Mapping(target = "masterRegistrationDoneAt", qualifiedByName = "registrationDoneAt")
	@Mapping(target = "fswSubCategory", qualifiedByName = "fswSubCategory")
	@Mapping(target = "msmSubCategory", qualifiedByName = "msmSubCategory")
	@Mapping(target = "iduSubCategory", qualifiedByName = "iduSubCategory")
	@Mapping(target = "tgSubCategory", qualifiedByName = "tgSubCategory")
	@Mapping(target = "migrantOccupation", qualifiedByName = "migrant")
	@Mapping(target = "truckerOccupation", qualifiedByName = "truckerOccupation")
	@Mapping(target = "migrationPattern", qualifiedByName = "migrationPattern")
	TIBeneficiary toEntity(TIBeneficiaryDTO tiBeneficiaryDTO);

	@Mapping(target = "masterBeneficiary", source = "beneficiary")
	@Mapping(target = "hrgPrimary", qualifiedByName = "typology")
	@Mapping(target = "hrgSecondary", qualifiedByName = "hrgSecondary")
	@Mapping(target = "masterDestinationDuration", qualifiedByName = "destinationDuration")
	@Mapping(target = "masterMobilityType", qualifiedByName = "mobilityType")
	@Mapping(target = "masterStayingWith", qualifiedByName = "stayingWith")
	@Mapping(target = "masterRegistrationDoneAt", qualifiedByName = "registrationDoneAt")
	@Mapping(target = "fswSubCategory", qualifiedByName = "fswSubCategory")
	@Mapping(target = "msmSubCategory", qualifiedByName = "msmSubCategory")
	@Mapping(target = "iduSubCategory", qualifiedByName = "iduSubCategory")
	@Mapping(target = "tgSubCategory", qualifiedByName = "tgSubCategory")
	@Mapping(target = "migrantOccupation", qualifiedByName = "migrant")
	@Mapping(target = "truckerOccupation", qualifiedByName = "truckerOccupation")
	@Mapping(target = "migrationPattern", qualifiedByName = "migrationPattern")
	TIBeneficiaryDTO toDto(TIBeneficiary tiBeneficiary);

	@Mapping(source = "masterBeneficiary", target = "beneficiary")
	@Mapping(source = "hrgPrimary", target = "hrgPrimary", qualifiedByName = "typology")
	@Mapping(source = "hrgSecondary", target = "hrgSecondary", qualifiedByName = "hrgSecondary")
	@Mapping(source = "masterDestinationDuration", target = "masterDestinationDuration", qualifiedByName = "destinationDuration")
	@Mapping(source = "masterMobilityType", target = "masterMobilityType", qualifiedByName = "mobilityType")
	@Mapping(source = "masterStayingWith", target = "masterStayingWith", qualifiedByName = "stayingWith")
	@Mapping(source = "masterRegistrationDoneAt", target = "masterRegistrationDoneAt", qualifiedByName = "registrationDoneAt")
	@Mapping(target = "fswSubCategory", source = "fswSubCategory", qualifiedByName = "fswSubCategory")
	@Mapping(target = "msmSubCategory", source = "msmSubCategory", qualifiedByName = "msmSubCategory")
	@Mapping(target = "iduSubCategory", source = "iduSubCategory", qualifiedByName = "iduSubCategory")
	@Mapping(target = "tgSubCategory", source = "tgSubCategory", qualifiedByName = "tgSubCategory")
	@Mapping(source = "migrantOccupation", target = "migrantOccupation", qualifiedByName = "migrant")
	@Mapping(source = "truckerOccupation",target = "truckerOccupation", qualifiedByName = "truckerOccupation")
	@Mapping(source = "migrationPattern",target = "migrationPattern", qualifiedByName = "migrationPattern")
	@Mapping(source = "status", target = "status", qualifiedByName = "tiBenStatus")
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	TIBeneficiary toUpdateEntity(TIBeneficiaryDTO tIBeneficiaryDTO, @MappingTarget TIBeneficiary tiBeneficiary);

	default TIBeneficiary fromId(Long id) {
		if (id == null) {
			return null;
		}
		TIBeneficiary tIBeneficiary = new TIBeneficiary();
		tIBeneficiary.setId(id);
		return tIBeneficiary;
	}

	@AfterMapping
	default void setHotspotDetails(@MappingTarget TIBeneficiaryDTO tiBeneficiaryDTO, TIBeneficiary tiBeneficiary) {
		if (tiBeneficiary.getHotspotBenMapping() != null) {
			Set<TiBeneficiaryHotspotMapping> hotspotMappings = tiBeneficiary.getHotspotBenMapping();
			Map<Long, Optional<TiBeneficiaryHotspotMapping>> groupedByBeneficiaryId = hotspotMappings.stream()
					.collect(Collectors.groupingBy(x -> x.getTiBeneficiary().getId(), LinkedHashMap::new,
							Collectors.maxBy(Comparator.comparing(TiBeneficiaryHotspotMapping::getId))));
			Set<TiBeneficiaryHotspotMapping> latestHotspot = groupedByBeneficiaryId.entrySet().stream()
					.map(x -> x.getValue().get()).collect(Collectors.toSet());
			Set<HotspotBenMappingDto> hotspotSet = new HashSet<>();
			latestHotspot.forEach(y -> {
				HotspotBenMappingDto hotspotBenMapping = new HotspotBenMappingDto();
				hotspotBenMapping.setTiBeneficiaryId(y.getTiBeneficiary().getId());
				hotspotBenMapping.setHotspotId(y.getHotspot().getId());
				hotspotBenMapping.setId(y.getId());
				hotspotBenMapping.setIsActive(y.getIsActive());
				hotspotBenMapping.setIsDelete(y.getIsDelete());
				hotspotSet.add(hotspotBenMapping);
			});
			tiBeneficiaryDTO.getHotspotBenMapping().clear();
			tiBeneficiaryDTO.getHotspotBenMapping().addAll(hotspotSet);
		}
	}

}