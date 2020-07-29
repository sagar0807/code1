package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.AddressDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring", uses = {StateMapper.class, DistrictMapper.class, SubdistrictMapper.class, TownMapper.class, PincodeMapper.class})
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {

    @Mapping(source = "state.id", target = "stateId")
    @Mapping(source = "district.id", target = "districtId")
    @Mapping(source = "subdistrict.subdistrictId", target = "subdistrictId")
    @Mapping(source = "town.townId", target = "townId")
    @Mapping(source = "pincodeEntity.id", target = "pincodeId")
    AddressDTO toDto(Address address);

    @Mapping(source = "stateId", target = "state")
    @Mapping(source = "districtId", target = "district")
    @Mapping(source = "subdistrictId", target = "subdistrict")
    @Mapping(source = "townId", target = "town")
    @Mapping(source = "pincodeId", target = "pincodeEntity")
    Address toEntity(AddressDTO addressDTO);

    default Address fromId(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        address.setId(id);
        return address;
    }
}
