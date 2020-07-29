package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.OstAssessmentDto;
import gov.naco.soch.ti.entity.OstAssessment;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMOstAssessmentReason;
@Mapper(componentModel = "spring", uses = {OstBenSubMapper.class,MMOstAssessmentReason.class,
DrugUsageMapper.class,DrugComplicationMapper.class,OstPrescriptionMapper.class })
public interface OstAssessmentMapper extends EntityMapper<OstAssessmentDto, OstAssessment> {
    @Mapping(source="facilityId",target="facility.id")
    @Mapping(source="tiOstBeneficiary.beneficiary",target="tiOstBeneficiary.masterBeneficiary")
    @Mapping(source="tiOstBeneficiary.facilityId",target="tiOstBeneficiary.facility.id")
    OstAssessmentDto toDto(OstAssessment tIOstAssess);
}
