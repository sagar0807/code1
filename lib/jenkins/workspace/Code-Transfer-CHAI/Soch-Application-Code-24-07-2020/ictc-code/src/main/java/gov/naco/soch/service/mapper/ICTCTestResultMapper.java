package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCTestResultDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ICTCTestResult and its DTO ICTCTestResultDTO.
 */
@Mapper(componentModel = "spring", uses = {ICTCBeneficiaryMapper.class, ICTCSampleCollectionMapper.class, ICTCVisitMapper.class})
public interface ICTCTestResultMapper extends EntityMapper<ICTCTestResultDTO, ICTCTestResult> {

    @Mapping(source = "ictcBeneficiary.id", target = "ictcBeneficiaryId")
    @Mapping(source = "sample.id", target = "sampleId")
    @Mapping(source = "visit.id", target = "visitId")
    ICTCTestResultDTO toDto(ICTCTestResult iCTCTestResult);

    @Mapping(source = "ictcBeneficiaryId", target = "ictcBeneficiary")
    @Mapping(source = "sampleId", target = "sample")
    @Mapping(source = "visitId", target = "visit")
    ICTCTestResult toEntity(ICTCTestResultDTO iCTCTestResultDTO);

    default ICTCTestResult fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCTestResult iCTCTestResult = new ICTCTestResult();
        iCTCTestResult.setId(id);
        return iCTCTestResult;
    }
}
