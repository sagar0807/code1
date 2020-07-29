package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstAssessmentDrugComplication;
import gov.naco.soch.ti.dto.TiOstAssessmentDrugComplicationDTO;

@Mapper(componentModel = "spring",uses=MMDrugComplicationMapper.class)
public interface TiOstAssessmentDrugComplicationMapper extends EntityMapper<TiOstAssessmentDrugComplicationDTO, TiOstAssessmentDrugComplication> {

	@Mapping(target="complication",qualifiedByName="drugComplication")
	TiOstAssessmentDrugComplicationDTO toDto(TiOstAssessmentDrugComplication tiOstAssessmentDrugComplication);

	@InheritInverseConfiguration
	@Mapping(source="assessmentId",target="tiOstAssessment.id")
	TiOstAssessmentDrugComplication toEntity(TiOstAssessmentDrugComplicationDTO tiOstAssessmentDrugComplicationDTO);

	default TiOstAssessmentDrugComplication fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiOstAssessmentDrugComplication tiOstAssessmentDrugComplication = new TiOstAssessmentDrugComplication();
		tiOstAssessmentDrugComplication.setId(id);
		return tiOstAssessmentDrugComplication;
	}

}

