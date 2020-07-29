package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.readonly.ScreeningDto;
import gov.naco.soch.ti.entity.Screening;
import gov.naco.soch.ti.mapper.BeneficiaryScreeningReferralMapper;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMGenderMapper;
import gov.naco.soch.ti.mapper.MMHivStatusMapper;
import gov.naco.soch.ti.mapper.MMHrgSecondaryMapper;
import gov.naco.soch.ti.mapper.MMInfectionTypeMapper;
import gov.naco.soch.ti.mapper.MMSyphilisStatusMapper;
import gov.naco.soch.ti.mapper.MMTbStatusMapper;
import gov.naco.soch.ti.mapper.MMTypologyMapper;

@Mapper(componentModel="spring",uses={ReferralMapper.class,MMTypologyMapper.class,MMHrgSecondaryMapper.class,
	MMGenderMapper.class,MMInfectionTypeMapper.class,MMHivStatusMapper.class,MMSyphilisStatusMapper.class,MMTbStatusMapper.class})
public interface ScreeningMapper  extends EntityMapper<ScreeningDto,Screening>{
    
    @Mapping(source="beneficiary.beneficiary",target="beneficiary.masterBeneficiary")
    @Mapping(source="beneficiary.beneficiary.genderId",target="beneficiary.masterBeneficiary.genderId",qualifiedByName="gender")
    @Mapping(target="beneficiary.hrgPrimary",source="beneficiary.hrgPrimary",qualifiedByName="typology")
    @Mapping(target="beneficiary.hrgSecondary",source="beneficiary.hrgSecondary",qualifiedByName="hrgSecondary")
    @Mapping(target="infection",qualifiedByName="infectionType")
    @Mapping(target="screeningStatusHiv",qualifiedByName="hivStatus")
  @Mapping(target="screeningStatusSyphilis",qualifiedByName="syphilisStatus")
    @Mapping(target="tbStatus",qualifiedByName="tbStatus")
    ScreeningDto toDto(Screening entity);

}
