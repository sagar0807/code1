package gov.naco.soch.ti.mapper;

import org.mapstruct.*;

import gov.naco.soch.entity.TIBenPresc;
import gov.naco.soch.ti.dto.TIBenPrescDTO;

/**
 * Mapper for the entity {@link TIBenPresc} and its DTO {@link TIBenPrescDTO}.
 */
@Mapper(componentModel = "spring", uses = {TIBeneficiaryMapper.class})
public interface TIBenPrescMapper extends EntityMapper<TIBenPrescDTO, TIBenPresc> {

    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    TIBenPrescDTO toDto(TIBenPresc tIBenPresc);

    @Mapping(source = "beneficiaryId", target = "beneficiary")
    TIBenPresc toEntity(TIBenPrescDTO tIBenPrescDTO);

    default TIBenPresc fromId(Long id) {
        if (id == null) {
            return null;
        }
        TIBenPresc tIBenPresc = new TIBenPresc();
        tIBenPresc.setId(id);
        return tIBenPresc;
    }
}
