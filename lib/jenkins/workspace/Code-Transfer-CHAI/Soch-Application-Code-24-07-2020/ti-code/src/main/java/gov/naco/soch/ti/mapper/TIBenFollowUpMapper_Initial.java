package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.ti.dto.TiBenFollowUpDTO_Initial;

@Mapper(componentModel = "spring",uses={TIOstPrescriptionFollowUpMapper.class,TiFacilityMapper.class,TiOstFollowUpByMapper.class})
public interface TIBenFollowUpMapper_Initial extends EntityMapper<TiBenFollowUpDTO_Initial, TiOstFollowUp> {
	
	@Mapping(source = "tiOstBeneficiary.id", target = "beneficiaryId")
	TiBenFollowUpDTO_Initial toDto(TiOstFollowUp tIBenFollowUp);

	@InheritInverseConfiguration
	TiOstFollowUp toEntity(TiBenFollowUpDTO_Initial tIBenFollowUpDTO);

    default TiOstFollowUp fromId(Long id) {
        if (id == null) {
            return null;
        }
        TiOstFollowUp tiOstFollowUp = new TiOstFollowUp();
        tiOstFollowUp.setId(id);
        return tiOstFollowUp;
    }
}