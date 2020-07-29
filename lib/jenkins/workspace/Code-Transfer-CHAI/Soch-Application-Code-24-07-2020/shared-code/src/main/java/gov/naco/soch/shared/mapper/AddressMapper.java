package gov.naco.soch.shared.mapper;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.entity.Address;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<TiBeneficiaryAddressDto, Address> {

	@Mapping(source="stateId",target="state.id")
	@Mapping(source="districtId",target="district.id")
    Address toEntity(TiBeneficiaryAddressDto addressDTO);
	
    @InheritInverseConfiguration
	@Mapping(source="subdistrict.subdistrictId",target="subDistrictId")
	@Mapping(source="town.townId",target="townId")
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
