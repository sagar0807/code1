package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.CounsellingDto;
import gov.naco.soch.ti.entity.TiCounsellingSubEntity;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMGenderMapper;
import gov.naco.soch.ti.mapper.MMHrgSecondaryMapper;
import gov.naco.soch.ti.mapper.MMTypologyMapper;
import gov.naco.soch.ti.mapper.TiBenCounsellingTypeMapper;

@Mapper(componentModel="spring",uses={TiBenCounsellingTypeMapper.class,MMTypologyMapper.class,MMHrgSecondaryMapper.class,
	MMGenderMapper.class})
public interface CounsellingMapper  extends EntityMapper<CounsellingDto,TiCounsellingSubEntity>{
    
    @Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
    @Mapping(source="beneficiary.beneficiary.genderId",target="beneficiary.masterBeneficiary.genderId",qualifiedByName="gender")
    @Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
    @Mapping(target="beneficiary.hrgSecondary",source="beneficiary.hrgSecondary",qualifiedByName="hrgSecondary")
    CounsellingDto toDto(TiCounsellingSubEntity entity);

}
