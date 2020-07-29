package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCTestResultViewDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ICTCTestResultView and its DTO ICTCTestResultViewDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ICTCTestResultViewMapper extends EntityMapper<ICTCTestResultViewDTO, ICTCTestResultView> {



    default ICTCTestResultView fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCTestResultView iCTCTestResultView = new ICTCTestResultView();
        iCTCTestResultView.setId(id);
        return iCTCTestResultView;
    }
}
