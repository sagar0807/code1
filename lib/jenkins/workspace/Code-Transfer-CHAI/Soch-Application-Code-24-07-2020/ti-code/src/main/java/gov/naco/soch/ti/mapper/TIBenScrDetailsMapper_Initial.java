package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBenScrDetails;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO_Initial;

@Mapper(componentModel = "spring",uses={MMHivStatusMapper.class,MMInfectionTypeMapper.class,MMSyphilisStatusMapper.class,MMTbStatusMapper.class})
public interface TIBenScrDetailsMapper_Initial extends EntityMapper<TIBenScrDetailsDTO_Initial, TIBenScrDetails> {
	
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source="facility.id",target="facilityId")
	@Mapping(target="screeningStatusHiv",qualifiedByName="hivStatus")
	@Mapping(target="screeningStatusSyphilis",qualifiedByName="syphilisStatus")
	@Mapping(target="tbStatus",qualifiedByName="tbStatus")
	@Mapping(target="infection",qualifiedByName="infectionType")
	TIBenScrDetailsDTO_Initial toDto(TIBenScrDetails tIBenScrDetails);

    @InheritInverseConfiguration
    TIBenScrDetails toEntity(TIBenScrDetailsDTO_Initial tIBenScrDetailsDTO);

    default TIBenScrDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenScrDetails tIBenScrDetails = new TIBenScrDetails();
        tIBenScrDetails.setId(id);
        return tIBenScrDetails;
    }
}
