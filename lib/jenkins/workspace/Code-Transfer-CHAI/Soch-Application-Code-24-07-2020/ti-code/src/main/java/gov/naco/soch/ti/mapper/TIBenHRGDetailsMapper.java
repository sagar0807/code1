package gov.naco.soch.ti.mapper;



import org.mapstruct.*;

import gov.naco.soch.entity.TIBenHRGDetails;
import gov.naco.soch.ti.dto.TIBenHRGDetailsDTO;

/**
 * Mapper for the entity {@link TIBenHRGDetails} and its DTO {@link TIBenHRGDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {TIBeneficiaryMapper.class})
public interface TIBenHRGDetailsMapper extends EntityMapper<TIBenHRGDetailsDTO, TIBenHRGDetails> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    TIBenHRGDetailsDTO toDto(TIBenHRGDetails tIBenHRGDetails);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    TIBenHRGDetails toEntity(TIBenHRGDetailsDTO tIBenHRGDetailsDTO);

    default TIBenHRGDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenHRGDetails tIBenHRGDetails = new TIBenHRGDetails();
        tIBenHRGDetails.setId(id);
        return tIBenHRGDetails;
    }
}
