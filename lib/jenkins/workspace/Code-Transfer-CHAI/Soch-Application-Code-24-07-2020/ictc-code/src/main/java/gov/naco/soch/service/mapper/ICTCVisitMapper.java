package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCVisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ICTCVisit} and its DTO {@link ICTCVisitDTO}.
 */
@Mapper(componentModel = "spring", uses = { ICTCBeneficiaryMapper.class, ArtBeneficiaryMapper.class, FacilityMapper.class})
public interface ICTCVisitMapper extends EntityMapper<ICTCVisitDTO, ICTCVisit> {

//    @Mapping(source = "partnerArtCenter.id", target = "partnerArtCenterId")
    @Mapping(source = "facility.id", target = "facilityId")
    @Mapping(source = "ictcBeneficiary.id", target = "ictcBeneficiaryId")
    ICTCVisitDTO toDto(ICTCVisit iCTCVisit);

//    @Mapping(source = "partnerArtCenterId", target = "partnerArtCenter")
    @Mapping(source = "facilityId", target = "facility")
    @Mapping(source = "ictcBeneficiaryId", target = "ictcBeneficiary")
    ICTCVisit toEntity(ICTCVisitDTO iCTCVisitDTO);

    default ICTCVisit fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCVisit iCTCVisit = new ICTCVisit();
        iCTCVisit.setId(id);
        return iCTCVisit;
    }
}
