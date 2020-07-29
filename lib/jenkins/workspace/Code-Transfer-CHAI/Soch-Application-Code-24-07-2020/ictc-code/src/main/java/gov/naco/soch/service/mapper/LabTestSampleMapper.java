package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.LabTestSampleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link LabTestSample} and its DTO {@link LabTestSampleDTO}.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class})
public interface LabTestSampleMapper extends EntityMapper<LabTestSampleDTO, LabTestSample> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    LabTestSampleDTO toDto(LabTestSample labTestSample);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    LabTestSample toEntity(LabTestSampleDTO labTestSampleDTO);

    default LabTestSample fromId(Long id) {
        if (id == null) {
            return null;
        }
        LabTestSample labTestSample = new LabTestSample();
        labTestSample.setId(id);
        return labTestSample;
    }
}
