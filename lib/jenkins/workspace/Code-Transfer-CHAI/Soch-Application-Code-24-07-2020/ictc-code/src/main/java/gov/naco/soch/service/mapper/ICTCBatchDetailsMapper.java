package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCBatchDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ICTCBatchDetails} and its DTO {@link ICTCBatchDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ICTCBatchDetailsMapper extends EntityMapper<ICTCBatchDetailsDTO, ICTCBatchDetails> {



    default ICTCBatchDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCBatchDetails iCTCBatchDetails = new ICTCBatchDetails();
        iCTCBatchDetails.setId(id);
        return iCTCBatchDetails;
    }
}
