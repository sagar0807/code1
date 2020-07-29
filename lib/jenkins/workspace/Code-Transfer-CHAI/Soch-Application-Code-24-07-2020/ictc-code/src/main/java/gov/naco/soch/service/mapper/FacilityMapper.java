package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.FacilityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Facility} and its DTO {@link FacilityDTO}.
 */
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface FacilityMapper extends EntityMapper<FacilityDTO, Facility> {

    @Mapping(source = "address.id", target = "addressId")
    FacilityDTO toDto(Facility facility);

    @Mapping(source = "addressId", target = "address")
    Facility toEntity(FacilityDTO facilityDTO);

    default Facility fromId(Long id) {
        if (id == null) {
            return null;
        }
        Facility facility = new Facility();
        facility.setId(id);
        return facility;
    }
}
