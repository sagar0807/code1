package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCSampleCollectionViewDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ICTCSampleCollectionView and its DTO ICTCSampleCollectionViewDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ICTCSampleCollectionViewMapper extends EntityMapper<ICTCSampleCollectionViewDTO, ICTCSampleCollectionView> {



    default ICTCSampleCollectionView fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCSampleCollectionView iCTCSampleCollectionView = new ICTCSampleCollectionView();
        iCTCSampleCollectionView.setId(id);
        return iCTCSampleCollectionView;
    }
}
