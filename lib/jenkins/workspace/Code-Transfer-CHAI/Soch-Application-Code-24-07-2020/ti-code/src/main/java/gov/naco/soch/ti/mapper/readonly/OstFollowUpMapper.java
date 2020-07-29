package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.OstFollowUpDto;
import gov.naco.soch.ti.entity.OstFollowUp;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMFollowUpTypeMapper;

@Mapper(componentModel = "spring", uses = {OstBenSubMapper.class,OstPrescriptionMapper.class,MMFollowUpTypeMapper.class,
	FollowUpByMapper.class,
	FollowUpReasonMapper.class,SideEffectMapper.class})
public interface OstFollowUpMapper extends EntityMapper<OstFollowUpDto, OstFollowUp> {
    @Mapping(source="facilityId",target="facility.id")
    @Mapping(source="tiOstBeneficiary.beneficiary",target="tiOstBeneficiary.masterBeneficiary")
    OstFollowUpDto toDto(OstFollowUp tIOstAssess);
}
