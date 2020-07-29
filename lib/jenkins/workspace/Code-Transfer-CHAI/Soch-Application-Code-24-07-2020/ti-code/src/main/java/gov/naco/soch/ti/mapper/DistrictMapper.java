package gov.naco.soch.ti.mapper;




import org.mapstruct.*;

import gov.naco.soch.dto.DistrictDto;
import gov.naco.soch.entity.District;

/**
 * Mapper for the entity {@link District} and its DTO {@link DistrictDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DistrictMapper extends EntityMapper<DistrictDto, District> {


    District toEntity(DistrictDto districtDTO);
    
	@InheritInverseConfiguration
    DistrictDto toDto(District district);

 


    default District fromId(Long id) {
        if (id == null) {
            return null;
        }
        District district = new District();
        district.setId(id);
        return district;
    }
}
