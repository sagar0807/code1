package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IctcLinkedFacility} and its DTO {@link IctcLinkedFacilityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IctcLinkedFacilityMapper extends EntityMapper<IctcLinkedFacilityDTO, IctcLinkedFacility> {



    default IctcLinkedFacility fromId(Long id) {
        if (id == null) {
            return null;
        }
        IctcLinkedFacility ictcLinkedFacility = new IctcLinkedFacility();
        ictcLinkedFacility.setId(id);
        return ictcLinkedFacility;
    }
}
