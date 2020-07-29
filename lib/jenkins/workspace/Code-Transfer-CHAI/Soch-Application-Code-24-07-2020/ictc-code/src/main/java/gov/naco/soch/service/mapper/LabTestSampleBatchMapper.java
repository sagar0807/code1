package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.LabTestSampleBatchDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link LabTestSampleBatch} and its DTO {@link LabTestSampleBatchDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface LabTestSampleBatchMapper extends EntityMapper<LabTestSampleBatchDTO, LabTestSampleBatch> {



    default LabTestSampleBatch fromId(Long id) {
        if (id == null) {
            return null;
        }
        LabTestSampleBatch labTestSampleBatch = new LabTestSampleBatch();
        labTestSampleBatch.setId(id);
        return labTestSampleBatch;
    }
}
