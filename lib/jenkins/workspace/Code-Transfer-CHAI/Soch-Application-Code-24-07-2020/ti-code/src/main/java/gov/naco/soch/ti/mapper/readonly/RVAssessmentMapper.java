package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.RvAssessmentDto;
import gov.naco.soch.ti.entity.RVAssessment;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMGenderMapper;
import gov.naco.soch.ti.mapper.MMHrgSecondaryMapper;
import gov.naco.soch.ti.mapper.MMTypologyMapper;

@Mapper(componentModel="spring",uses={MMTypologyMapper.class,MMHrgSecondaryMapper.class,
	MMGenderMapper.class})
public interface RVAssessmentMapper  extends EntityMapper<RvAssessmentDto,RVAssessment>{
    
    @Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
    @Mapping(source="beneficiary.beneficiary.genderId",target="beneficiary.masterBeneficiary.genderId",qualifiedByName="gender")
    @Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
    @Mapping(target="beneficiary.hrgSecondary",source="beneficiary.hrgSecondary",qualifiedByName="hrgSecondary")
    RvAssessmentDto toDto(RVAssessment entity);

}
