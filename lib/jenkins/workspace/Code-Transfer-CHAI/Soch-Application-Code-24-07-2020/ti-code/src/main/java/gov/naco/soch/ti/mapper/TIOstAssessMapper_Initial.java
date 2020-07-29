package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.ti.dto.TIOstAssessDTO_Initial;

@Mapper(componentModel = "spring", uses = { TIOstPrescriptionAssessmentMapper.class,MMOstAssessmentReason.class,
		TiFacilityMapper.class,TiOstAssessmentDrugUsageMapper.class,TiOstAssessmentDrugComplicationMapper.class })
public interface TIOstAssessMapper_Initial extends EntityMapper<TIOstAssessDTO_Initial, TiOstAssessment> {
	
	@Mapping(source = "tiOstBeneficiary.id", target = "beneficiaryId")
	@Mapping(target="followUpReason",qualifiedByName="followUpReason")
	TIOstAssessDTO_Initial toDto(TiOstAssessment tIOstAssess);

    @InheritInverseConfiguration
    TiOstAssessment toEntity(TIOstAssessDTO_Initial tIOstAssessDTO);

    default TiOstAssessment fromId(Long id) {
        if (id == null) {
            return null;
        }
        TiOstAssessment tIOstAssess = new TiOstAssessment();
        tIOstAssess.setId(id);
        return tIOstAssess;
    }
}