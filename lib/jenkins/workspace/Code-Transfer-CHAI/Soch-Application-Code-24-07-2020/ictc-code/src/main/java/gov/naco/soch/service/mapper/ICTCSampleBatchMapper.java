package gov.naco.soch.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.domain.ICTCSampleBatch;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;

/**
 * Mapper for the entity {@link ICTCSampleBatch} and its DTO {@link ICTCSampleBatchDTO}.
 */
@Mapper(componentModel = "spring", uses = { FacilityMapper.class })
public interface ICTCSampleBatchMapper extends EntityMapper<ICTCSampleBatchDTO, ICTCSampleBatch> {
	
	@Mapping(source = "facility.id", target = "facilityId")
	@Mapping(source = "lab.id", target = "labId")
    ICTCSampleBatchDTO toDto(ICTCSampleBatch ictcSampleBatch);

    @Mapping(source = "facilityId", target = "facility")
    @Mapping(source = "labId", target = "lab")
    ICTCSampleBatch toEntity(ICTCSampleBatchDTO ictcSampleBatchDTO);

    default ICTCSampleBatch fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCSampleBatch iCTCSampleBatch = new ICTCSampleBatch();
        iCTCSampleBatch.setId(id);
        return iCTCSampleBatch;
    }
}
