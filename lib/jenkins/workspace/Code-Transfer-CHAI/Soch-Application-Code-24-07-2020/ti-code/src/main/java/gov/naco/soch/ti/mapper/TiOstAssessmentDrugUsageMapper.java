package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstAssessmentDrugUsage;
import gov.naco.soch.ti.dto.TiOstAssessmentDrugUsageDTO;

@Mapper(componentModel = "spring",uses=MMMasterPrimaryDrugMapper.class)
public interface TiOstAssessmentDrugUsageMapper extends EntityMapper<TiOstAssessmentDrugUsageDTO, TiOstAssessmentDrugUsage> {

	@Mapping(target="drugUsage",qualifiedByName={"drug","primaryDrug"})
	TiOstAssessmentDrugUsageDTO toDto(TiOstAssessmentDrugUsage tiOstAssessmentDrugUsage);

	@InheritInverseConfiguration
	@Mapping(source="assessmentId",target="tiOstAssessment.id")
	TiOstAssessmentDrugUsage toEntity(TiOstAssessmentDrugUsageDTO tiOstAssessmentDrugUsageDTO);

	default TiOstAssessmentDrugUsage fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiOstAssessmentDrugUsage tiOstAssessmentDrugUsage = new TiOstAssessmentDrugUsage();
		tiOstAssessmentDrugUsage.setId(id);
		return tiOstAssessmentDrugUsage;
	}

}
