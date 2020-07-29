package gov.naco.soch.ti.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.entity.AddressReadOnly;


@Mapper(componentModel = "spring",uses={StateMapperReadOnly.class,TownMapperReadOnly.class,SubDistrictMapperReadOnly.class,DistrictMapperReadOnly.class})
public interface AddressMapperReadOnly extends EntityMapper<TiBeneficiaryAddressDto, AddressReadOnly> {
    
    
    @Mapping(target="stateId",source="state.id")
    @Mapping(target="districtId",source="district.id")
    TiBeneficiaryAddressDto toDto(AddressReadOnly address);


   

    default AddressReadOnly fromId(Long id) {
        if (id == null) {
            return null;
        }
        AddressReadOnly addressReadOnly = new AddressReadOnly();
        addressReadOnly.setId(id);
        return addressReadOnly;
    }
}
