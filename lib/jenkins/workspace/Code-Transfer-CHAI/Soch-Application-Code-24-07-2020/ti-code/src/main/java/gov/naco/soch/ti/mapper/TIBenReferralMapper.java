package gov.naco.soch.ti.mapper;



import org.mapstruct.*;

import gov.naco.soch.entity.TIBenReferral;
import gov.naco.soch.ti.dto.TIBenReferralDTO;

/**
 * Mapper for the entity {@link TIBenReferral} and its DTO {@link TIBenReferralDTO}.
 */
@Mapper(componentModel = "spring", uses = {TIBeneficiaryMapper.class})
public interface TIBenReferralMapper extends EntityMapper<TIBenReferralDTO, TIBenReferral> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    TIBenReferralDTO toDto(TIBenReferral tIBenReferral);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    TIBenReferral toEntity(TIBenReferralDTO tIBenReferralDTO);

    default TIBenReferral fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenReferral tIBenReferral = new TIBenReferral();
        tIBenReferral.setId(id);
        return tIBenReferral;
    }
}
