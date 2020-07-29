package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ReferralsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Referrals} and its DTO {@link ReferralsDTO}.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class, FacilityMapper.class})
public interface ReferralsMapper extends EntityMapper<ReferralsDTO, Referrals> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source = "sourceFacility.id", target = "sourceFacilityId")
    @Mapping(source = "destinationFacility.id", target = "destinationFacilityId")
    ReferralsDTO toDto(Referrals referrals);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    @Mapping(source = "sourceFacilityId", target = "sourceFacility")
    @Mapping(source = "destinationFacilityId", target = "destinationFacility")
    Referrals toEntity(ReferralsDTO referralsDTO);

    default Referrals fromId(Long id) {
        if (id == null) {
            return null;
        }
        Referrals referrals = new Referrals();
        referrals.setId(id);
        return referrals;
    }
}
