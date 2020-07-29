package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ICTCBeneficiaryVisit} and its DTO {@link ICTCBeneficiaryVisitDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ICTCBeneficiaryVisitMapper extends EntityMapper<ICTCBeneficiaryVisitDTO, ICTCBeneficiaryVisit> {



    default ICTCBeneficiaryVisit fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCBeneficiaryVisit iCTCBeneficiaryVisit = new ICTCBeneficiaryVisit();
        iCTCBeneficiaryVisit.setId(id);
        return iCTCBeneficiaryVisit;
    }
}
