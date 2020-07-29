package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.StiTreatmentDto;
import gov.naco.soch.ti.entity.StiTreatment;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMGenderMapper;
import gov.naco.soch.ti.mapper.MMHrgSecondaryMapper;
import gov.naco.soch.ti.mapper.MMKittypeMapper;
import gov.naco.soch.ti.mapper.MMTypologyMapper;
import gov.naco.soch.ti.mapper.MMdiagnosisTypeMapper;

@Mapper(componentModel="spring",uses={MMTypologyMapper.class,MMHrgSecondaryMapper.class,
	MMGenderMapper.class,MMdiagnosisTypeMapper.class,MMKittypeMapper.class})
public interface StiTreatmentMapper  extends EntityMapper<StiTreatmentDto,StiTreatment>{
    
    @Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
    @Mapping(source="beneficiary.beneficiary.genderId",target="beneficiary.masterBeneficiary.genderId",qualifiedByName="gender")
    @Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
    @Mapping(target="beneficiary.hrgSecondary",source="beneficiary.hrgSecondary",qualifiedByName="hrgSecondary")
    StiTreatmentDto toDto(StiTreatment entity);

}