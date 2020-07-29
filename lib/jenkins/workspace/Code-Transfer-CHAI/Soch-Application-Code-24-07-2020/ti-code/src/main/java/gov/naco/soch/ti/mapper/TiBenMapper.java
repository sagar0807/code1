package gov.naco.soch.ti.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiBeneficiaryReadOnly;
import gov.naco.soch.ti.dto.TiBenDto;


@Mapper(componentModel = "spring", uses = { TiBenChildDetailsMapperReadOnly.class, MMTypologyMapper.class,
	MMHrgSecondaryMapper.class, BeneficiaryMapperReadOnly.class, TiBenExtDetailsMapperReadOnly.class,
	HotspotTiBenMapperReadOnly.class, MMFSWSubCategoryMapper.class,
	MMTGSubCategoryMapper.class, MMMSMSubCategoryMapper.class, MMIDUSubCategoryMapper.class,
	MMMigrantOccupation.class, MMDestinationDurationMapper.class, MMMobilityTypeMapper.class,
	MMStayingWithMapper.class, MMRegistrationDoneAtMapper.class, MMTiStatusMapper.class,MMTruckerOccupation.class,MMMigrationPatternMapper.class })
public interface TiBenMapper extends EntityMapper<TiBenDto, TiBeneficiaryReadOnly> {

    List<TiBenDto> toDto(List<TiBeneficiaryReadOnly> tiBeneficiary);

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
    @Mapping(target = "status", qualifiedByName = "tiBenStatus")
    @Mapping(target = "masterBeneficiary", source = "beneficiary")
    @Mapping(source="facilityId",target="facility.id")
    TiBenDto toDto(TiBeneficiaryReadOnly tiBeneficiary);

}
