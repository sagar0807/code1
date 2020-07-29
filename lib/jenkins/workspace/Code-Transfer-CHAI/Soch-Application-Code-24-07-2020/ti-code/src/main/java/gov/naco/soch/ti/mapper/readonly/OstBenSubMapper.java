package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.OstBenSubDto;
import gov.naco.soch.ti.entity.OstBenSubEntity;
import gov.naco.soch.ti.mapper.MMOstBenStatusMapper;
import gov.naco.soch.ti.mapper.MMOstStatusMapper;

@Mapper(componentModel="spring",uses= {OstPrescriptionMapper.class,MMOstStatusMapper.class, MMOstBenStatusMapper.class})
public interface OstBenSubMapper {
    @Mapping(source="beneficiary",target="masterBeneficiary")
    @Mapping(source="facilityId",target="facility.id")
    OstBenSubDto toDto(OstBenSubEntity entity);
    

}
