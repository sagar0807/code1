package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.TiOstAssessmentDrugUsageDTO;
import gov.naco.soch.ti.entity.OstAssessmentDrugUsage;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMMasterPrimaryDrugMapper;

@Mapper(componentModel = "spring",uses=MMMasterPrimaryDrugMapper.class)
public interface DrugUsageMapper extends EntityMapper<TiOstAssessmentDrugUsageDTO, OstAssessmentDrugUsage> {

	@Mapping(target="drugUsage",qualifiedByName={"drug","primaryDrug"})
	TiOstAssessmentDrugUsageDTO toDto(OstAssessmentDrugUsage tiOstAssessmentDrugUsage);



}