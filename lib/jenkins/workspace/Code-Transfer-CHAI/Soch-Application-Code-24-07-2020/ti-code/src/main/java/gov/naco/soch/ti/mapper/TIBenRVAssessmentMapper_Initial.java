package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBenRVAssessment;
import gov.naco.soch.ti.dto.TIBenRVAssessmentDTO_Initial;

@Mapper(componentModel = "spring")
public interface TIBenRVAssessmentMapper_Initial extends EntityMapper<TIBenRVAssessmentDTO_Initial, TIBenRVAssessment> {
	
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source="facility.id",target="facilityId")
    TIBenRVAssessmentDTO_Initial toDto(TIBenRVAssessment tIBenRVAssessment);

	@InheritInverseConfiguration
    TIBenRVAssessment toEntity(TIBenRVAssessmentDTO_Initial tIBenRVAssessmentDTO);

    default TIBenRVAssessment fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenRVAssessment tIBenRVAssessment = new TIBenRVAssessment();
        tIBenRVAssessment.setId(id);
        return tIBenRVAssessment;
    }
}