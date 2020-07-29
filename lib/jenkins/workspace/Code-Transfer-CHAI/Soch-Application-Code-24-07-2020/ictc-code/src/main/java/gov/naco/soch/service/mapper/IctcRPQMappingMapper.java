package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.IctcRPQMappingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IctcRPQMapping} and its DTO {@link IctcRPQMappingDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IctcRPQMappingMapper extends EntityMapper<IctcRPQMappingDTO, IctcRPQMapping> {



    default IctcRPQMapping fromId(Long id) {
        if (id == null) {
            return null;
        }
        IctcRPQMapping ictcRPQMapping = new IctcRPQMapping();
        ictcRPQMapping.setId(id);
        return ictcRPQMapping;
    }
}
