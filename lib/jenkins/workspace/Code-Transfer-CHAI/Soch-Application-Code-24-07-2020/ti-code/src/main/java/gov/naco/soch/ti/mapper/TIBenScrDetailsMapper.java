package gov.naco.soch.ti.mapper;



import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.*;

import gov.naco.soch.entity.TIBenScrDetails;
import gov.naco.soch.ti.dto.TIBenScrDetailsDTO;

/**
 * Mapper for the entity {@link TIBenScrDetails} and its DTO {@link TIBenScrDetailsDTO}.
 */
@Mapper(componentModel = "spring",uses={BeneficiaryScreeningReferralMapper.class,TIBeneficiaryMapper.class,BeneficiaryMapper.class,BeneficiaryFacilityMapper.class,
		MMInfectionTypeMapper.class,MMHivStatusMapper.class,MMSyphilisStatusMapper.class,MMTbStatusMapper.class,MMTypologyMapper.class})
public interface TIBenScrDetailsMapper extends EntityMapper<TIBenScrDetailsDTO, TIBenScrDetails> {
	
	@Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
	@Mapping(source="facility.id",target="facilityId")
	@Mapping(source="beneficiary.beneficiary.address.state.id",target="beneficiary.masterBeneficiary.address.stateId")
	@Mapping(source="beneficiary.beneficiary.address.district.id",target="beneficiary.masterBeneficiary.address.districtId")
	@Mapping(source="beneficiary.tiCounselling",target="beneficiary.tiCounselling",ignore=true)
	@Mapping(source="beneficiary.tiAssessment",target="beneficiary.tiAssessment",ignore=true)
	@Mapping(source="beneficiary.tiStiTreatment",target="beneficiary.tiStiTreatment",ignore=true)
	@Mapping(source="beneficiary.tiScreening",target="beneficiary.tiScreening",ignore=true)
	@Mapping(target="infection",qualifiedByName="infectionType")
	@Mapping(target="screeningStatusHiv",qualifiedByName="hivStatus")
	@Mapping(target="screeningStatusSyphilis",qualifiedByName="syphilisStatus")
	@Mapping(target="tbStatus",qualifiedByName="tbStatus")
	@Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
    TIBenScrDetailsDTO toDto(TIBenScrDetails tIBenScrDetails);

    @InheritInverseConfiguration
    TIBenScrDetails toEntity(TIBenScrDetailsDTO tIBenScrDetailsDTO);
    
    @InheritInverseConfiguration
    List<TIBenScrDetailsDTO> toDtoList(Stream<TIBenScrDetails>tIBenScrDetails);

    default TIBenScrDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenScrDetails tIBenScrDetails = new TIBenScrDetails();
        tIBenScrDetails.setId(id);
        return tIBenScrDetails;
    }
}
