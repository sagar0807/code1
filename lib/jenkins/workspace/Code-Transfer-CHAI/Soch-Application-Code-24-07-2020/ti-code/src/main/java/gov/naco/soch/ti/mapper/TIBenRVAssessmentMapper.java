package gov.naco.soch.ti.mapper;


import org.mapstruct.*;

import gov.naco.soch.entity.TIBenRVAssessment;
import gov.naco.soch.ti.dto.TIBenRVAssessmentDTO;

/**
 * Mapper for the entity {@link TIBenRVAssessment} and its DTO {@link TIBenRVAssessmentDTO}.
 */
@Mapper(componentModel = "spring",uses={BeneficiaryMapper.class,TIBeneficiaryMapper.class,BeneficiaryFacilityMapper.class,MMRVAssessmentMapper.class,MMTypologyMapper.class})
public interface TIBenRVAssessmentMapper extends EntityMapper<TIBenRVAssessmentDTO, TIBenRVAssessment> {

	@Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
	@Mapping(source="facility.id",target="facilityId")
	@Mapping(source="beneficiary.beneficiary.address.state.id",target="beneficiary.masterBeneficiary.address.stateId")
	@Mapping(source="beneficiary.beneficiary.address.district.id",target="beneficiary.masterBeneficiary.address.districtId")
	@Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
	@Mapping(source="beneficiary.tiCounselling",target="beneficiary.tiCounselling",ignore=true)
	@Mapping(source="beneficiary.tiAssessment",target="beneficiary.tiAssessment",ignore=true)
	@Mapping(source="beneficiary.tiStiTreatment",target="beneficiary.tiStiTreatment",ignore=true)
	@Mapping(source="beneficiary.tiScreening",target="beneficiary.tiScreening",ignore=true)
    TIBenRVAssessmentDTO toDto(TIBenRVAssessment tIBenRVAssessment);
    @InheritInverseConfiguration
    TIBenRVAssessment toEntity(TIBenRVAssessmentDTO tIBenRVAssessmentDTO);

    default TIBenRVAssessment fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenRVAssessment tIBenRVAssessment = new TIBenRVAssessment();
        tIBenRVAssessment.setId(id);
        return tIBenRVAssessment;
    }
}
