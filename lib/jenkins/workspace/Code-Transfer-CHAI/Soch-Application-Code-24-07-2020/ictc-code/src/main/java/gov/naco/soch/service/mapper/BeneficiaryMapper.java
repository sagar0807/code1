package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.BeneficiaryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Beneficiary} and its DTO {@link BeneficiaryDTO}.
 */
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface BeneficiaryMapper extends EntityMapper<BeneficiaryDTO, Beneficiary> {

    @Mapping(source = "address.id", target = "addressId")
    BeneficiaryDTO toDto(Beneficiary beneficiary);

    @Mapping(source = "addressId", target = "address")
    Beneficiary toEntity(BeneficiaryDTO beneficiaryDTO);

    default Beneficiary fromId(Long id) {
        if (id == null) {
            return null;
        }
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setId(id);
        return beneficiary;
    }
}
