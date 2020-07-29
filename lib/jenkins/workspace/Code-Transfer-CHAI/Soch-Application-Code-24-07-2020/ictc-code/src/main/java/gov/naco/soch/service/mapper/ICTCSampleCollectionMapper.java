package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ICTCSampleCollection} and its DTO {@link ICTCSampleCollectionDTO}.
 */
@Mapper(componentModel = "spring", uses = {FacilityMapper.class, ICTCBeneficiaryMapper.class, ICTCVisitMapper.class, ICTCSampleBatchMapper.class})
public interface ICTCSampleCollectionMapper extends EntityMapper<ICTCSampleCollectionDTO, ICTCSampleCollection> {

    @Mapping(source = "facility.id", target = "facilityId")
    @Mapping(source = "ictcBeneficiary.id", target = "ictcBeneficiaryId")
    @Mapping(source = "visit.id", target = "visitId")
    @Mapping(source = "batch.id", target = "batchId")
    ICTCSampleCollectionDTO toDto(ICTCSampleCollection iCTCSampleCollection);

    @Mapping(source = "facilityId", target = "facility")
    @Mapping(source = "ictcBeneficiaryId", target = "ictcBeneficiary")
    @Mapping(source = "visitId", target = "visit")
    @Mapping(source = "batchId", target = "batch")
    ICTCSampleCollection toEntity(ICTCSampleCollectionDTO iCTCSampleCollectionDTO);

    default ICTCSampleCollection fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCSampleCollection iCTCSampleCollection = new ICTCSampleCollection();
        iCTCSampleCollection.setId(id);
        return iCTCSampleCollection;
    }
}
