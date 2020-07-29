package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.entity.BeneficiaryReadOnly;
import gov.naco.soch.ti.dto.MasterBenDto;

@Mapper(componentModel="spring",uses= {MMEducationLevelMapper.class,MMMaritalStatusMapper.class,MMEmploymentStatusMapper.class,
	BenFacMapperReadOnly.class,MMOccupationMapper.class,MMGenderMapper.class,
	BeneficiaryReferMapperReadOnly.class, TransferMapperReadOnly.class, AddressMapperReadOnly.class })
public interface BeneficiaryMapperReadOnly extends EntityMapper<MasterBenDto, BeneficiaryReadOnly>{
    
    MasterBenDto toDto(BeneficiaryReadOnly beneficiary);

}
