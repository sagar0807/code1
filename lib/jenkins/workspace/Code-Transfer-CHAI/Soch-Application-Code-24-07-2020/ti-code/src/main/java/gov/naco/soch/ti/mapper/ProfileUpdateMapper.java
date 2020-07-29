package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.entity.TiProfileUpdate;
import gov.naco.soch.ti.dto.ProfileUpdateDto;

@Mapper(componentModel = "spring")
public interface ProfileUpdateMapper extends EntityMapper<ProfileUpdateDto, TiProfileUpdate>{
    
    ProfileUpdateDto toDto(TiProfileUpdate profileUpdate);
    TiProfileUpdate toEntity(ProfileUpdateDto profileUpdateDto);
    

}
