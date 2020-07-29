package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstPrescription;
import gov.naco.soch.ti.dto.TIOstPrescriptionDTO;

@Mapper(componentModel = "spring",uses=MMMasterDrugMapper.class)
public interface TIOstPrescriptionAssessmentMapper { //extends EntityMapper<TIOstPrescriptionDTO, TiOstPrescription> {
	
	@Mapping(source="facility.id",target="facilityId")
	@Mapping(source="tiOstBeneficiary.id",target="beneficiaryId")
	@Mapping(target="product",qualifiedByName="masterDrug")
	TIOstPrescriptionDTO toDto(TiOstPrescription tiOstPrescription);

    @InheritInverseConfiguration
	@Mapping(source="assessmentId",target="tiOstAssessment.id")
    TiOstPrescription toEntity(TIOstPrescriptionDTO tiOstPrescription);

    default TiOstPrescription fromId(Long id) {
        if (id == null) {
            return null;
        }
        TiOstPrescription tiOstPrescription = new TiOstPrescription();
        tiOstPrescription.setId(id);
        return tiOstPrescription;
    }

}

