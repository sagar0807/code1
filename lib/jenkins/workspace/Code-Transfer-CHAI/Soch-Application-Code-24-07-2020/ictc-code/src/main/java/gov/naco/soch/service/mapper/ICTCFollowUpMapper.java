package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ICTCFollowUp} and its DTO {@link ICTCFollowUpDTO}.
 */
@Mapper(componentModel = "spring", uses = {ICTCVisitMapper.class, FacilityMapper.class, ICTCBeneficiaryMapper.class, ICTCTestResultMapper.class})
public interface ICTCFollowUpMapper extends EntityMapper<ICTCFollowUpDTO, ICTCFollowUp> {

    @Mapping(source = "visit.id", target = "visitId")
    @Mapping(source = "facility.id", target = "facilityId")
    @Mapping(source = "ictcBeneficiary.id", target = "ictcBeneficiaryId")
    @Mapping(source = "testResult.id", target = "testResultId")
    ICTCFollowUpDTO toDto(ICTCFollowUp iCTCFollowUp);

    @Mapping(source = "visitId", target = "visit")
    @Mapping(source = "facilityId", target = "facility")
    @Mapping(source = "ictcBeneficiaryId", target = "ictcBeneficiary")
    @Mapping(source = "testResultId", target = "testResult")
    ICTCFollowUp toEntity(ICTCFollowUpDTO iCTCFollowUpDTO);

    default ICTCFollowUp fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCFollowUp iCTCFollowUp = new ICTCFollowUp();
        iCTCFollowUp.setId(id);
        return iCTCFollowUp;
    }
}
