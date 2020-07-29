package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.TransfersDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Transfers} and its DTO {@link TransfersDTO}.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class, FacilityMapper.class})
public interface TransfersMapper extends EntityMapper<TransfersDTO, Transfers> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source = "sourceFacility.id", target = "sourceFacilityId")
    @Mapping(source = "destinationFacility.id", target = "destinationFacilityId")
    TransfersDTO toDto(Transfers transfers);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    @Mapping(source = "sourceFacilityId", target = "sourceFacility")
    @Mapping(source = "destinationFacilityId", target = "destinationFacility")
    Transfers toEntity(TransfersDTO transfersDTO);

    default Transfers fromId(Long id) {
        if (id == null) {
            return null;
        }
        Transfers transfers = new Transfers();
        transfers.setId(id);
        return transfers;
    }
}
