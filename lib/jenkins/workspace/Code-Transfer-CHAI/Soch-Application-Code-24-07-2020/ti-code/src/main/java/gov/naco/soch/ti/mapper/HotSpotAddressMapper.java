package gov.naco.soch.ti.mapper;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.entity.Address;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring",uses={StateMapper.class,TownMapper.class,SubdistrictMapper.class,DistrictMapper.class})
public interface HotSpotAddressMapper extends EntityMapper<TiBeneficiaryAddressDto, Address> {

    Address toEntity(TiBeneficiaryAddressDto addressDTO);
	
    @InheritInverseConfiguration
    TiBeneficiaryAddressDto toDto(Address address);

    default Address fromId(Long id) {
        if (id == null) {
            return null;
        }
        Address address = new Address();
        address.setId(id);
        return address;
    }
}
