package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIBenCounselling;
import gov.naco.soch.ti.dto.TIBenCounsellingDTO_Initial;

@Mapper(componentModel = "spring")
public interface TIBenCounsellingMapper_Initial extends EntityMapper<TIBenCounsellingDTO_Initial, TIBenCounselling> {
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source="facility.id",target="facilityId")
	TIBenCounsellingDTO_Initial toDto(TIBenCounselling tIBenCounselling);

	@InheritInverseConfiguration
	TIBenCounselling toEntity(TIBenCounsellingDTO_Initial tIBenCounsellingDTO);

	default TIBenCounselling fromId(Long id) {
		if (id == null) {
			return null;
		}
		TIBenCounselling tIBenCounselling = new TIBenCounselling();
		tIBenCounselling.setId(id);
		return tIBenCounselling;
	}
}