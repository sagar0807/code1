package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.TiOstAssessmentDrugComplicationDTO;
import gov.naco.soch.ti.entity.OstAssessmentDrugComplication;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMDrugComplicationMapper;

@Mapper(componentModel = "spring",uses=MMDrugComplicationMapper.class)
public interface DrugComplicationMapper extends EntityMapper<TiOstAssessmentDrugComplicationDTO, OstAssessmentDrugComplication> {

	@Mapping(target="complication",qualifiedByName="drugComplication")
	TiOstAssessmentDrugComplicationDTO toDto(OstAssessmentDrugComplication tiOstAssessmentDrugComplication);


}