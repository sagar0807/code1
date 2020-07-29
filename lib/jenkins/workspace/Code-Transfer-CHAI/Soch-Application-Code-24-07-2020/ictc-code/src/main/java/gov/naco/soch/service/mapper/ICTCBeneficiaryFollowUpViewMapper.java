package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.ICTCBeneficiaryFollowUpViewDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ICTCBeneficiaryFollowUpView and its DTO ICTCBeneficiaryFollowUpViewDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ICTCBeneficiaryFollowUpViewMapper extends EntityMapper<ICTCBeneficiaryFollowUpViewDTO, ICTCBeneficiaryFollowUpView> {



    default ICTCBeneficiaryFollowUpView fromId(Long id) {
        if (id == null) {
            return null;
        }
        ICTCBeneficiaryFollowUpView iCTCBeneficiaryFollowUpView = new ICTCBeneficiaryFollowUpView();
        iCTCBeneficiaryFollowUpView.setId(id);
        return iCTCBeneficiaryFollowUpView;
    }
}
