package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import gov.naco.soch.ti.dto.TIOstPrescriptionDTO;
import gov.naco.soch.ti.entity.OstPrescription;
import gov.naco.soch.ti.mapper.MMMasterDrugMapper;

@Mapper(componentModel = "spring", uses = MMMasterDrugMapper.class)
public interface OstPrescriptionMapper{

    @Mapping(source="tiOstBeneficiary.id",target="beneficiaryId")
    @Mapping(target = "product", qualifiedByName = "masterDrug")
    TIOstPrescriptionDTO toDto(OstPrescription entity);

}
