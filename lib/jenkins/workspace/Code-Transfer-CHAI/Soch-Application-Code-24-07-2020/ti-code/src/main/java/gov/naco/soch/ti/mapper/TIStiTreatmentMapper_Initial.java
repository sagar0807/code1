package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TIStiTreatment;
import gov.naco.soch.ti.dto.TIStiTreatmentDTO_Initial;

@Mapper(componentModel = "spring",uses={MMdiagnosisTypeMapper.class,MMKittypeMapper.class})
public interface TIStiTreatmentMapper_Initial extends EntityMapper<TIStiTreatmentDTO_Initial, TIStiTreatment> {
	
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source="facility.id",target="facilityId")
	TIStiTreatmentDTO_Initial toDto(TIStiTreatment tIStiTreatment);

	@InheritInverseConfiguration
	TIStiTreatment toEntity(TIStiTreatmentDTO_Initial tIStiTreatmentDTO);

	default TIStiTreatment fromId(Long id) {
		if (id == null) {
			return null;
		}
		TIStiTreatment tIStiTreatment = new TIStiTreatment();
		tIStiTreatment.setId(id);
		return tIStiTreatment;
	}
}
