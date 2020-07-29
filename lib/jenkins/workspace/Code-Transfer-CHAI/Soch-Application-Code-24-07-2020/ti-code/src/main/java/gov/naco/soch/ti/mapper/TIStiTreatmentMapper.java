package gov.naco.soch.ti.mapper;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIStiTreatment;
import gov.naco.soch.ti.dto.TIStiTreatmentDTO;



/**
 * Mapper for the entity {@link TIStiTreatment} and its DTO {@link TIStiTreatmentDTO}.
 */
@Mapper(componentModel = "spring",uses={BeneficiaryMapper.class,TIBeneficiaryMapper.class,BeneficiaryFacilityMapper.class,MMdiagnosisTypeMapper.class,MMKittypeMapper.class,
		MMTypologyMapper.class})
public interface TIStiTreatmentMapper extends EntityMapper<TIStiTreatmentDTO, TIStiTreatment> {

	@Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
	@Mapping(source="facility.id",target="facilityId")
	@Mapping(source="beneficiary.beneficiary.address.state.id",target="beneficiary.masterBeneficiary.address.stateId")
	@Mapping(source="beneficiary.beneficiary.address.district.id",target="beneficiary.masterBeneficiary.address.districtId")
	@Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
	@Mapping(source="beneficiary.tiCounselling",target="beneficiary.tiCounselling",ignore=true)
	@Mapping(source="beneficiary.tiAssessment",target="beneficiary.tiAssessment",ignore=true)
	@Mapping(source="beneficiary.tiStiTreatment",target="beneficiary.tiStiTreatment",ignore=true)
	@Mapping(source="beneficiary.tiScreening",target="beneficiary.tiScreening",ignore=true)
    TIStiTreatmentDTO toDto(TIStiTreatment tIStiTreatment);

    @InheritInverseConfiguration
    TIStiTreatment toEntity(TIStiTreatmentDTO tIStiTreatmentDTO);

    default TIStiTreatment fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIStiTreatment tIStiTreatment = new TIStiTreatment();
        tIStiTreatment.setId(id);
        return tIStiTreatment;
    }
}
