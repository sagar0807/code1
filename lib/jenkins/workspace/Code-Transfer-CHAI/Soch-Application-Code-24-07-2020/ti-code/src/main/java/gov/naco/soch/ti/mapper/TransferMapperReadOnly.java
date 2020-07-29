package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.TransferDto;
import gov.naco.soch.entity.TransferReadOnly;

@Mapper(componentModel = "spring")
public interface TransferMapperReadOnly extends EntityMapper<TransferDto, TransferReadOnly> {
    
	@Mapping(source="facilityTo",target="destinationFacilityId")
	@Mapping(source="facilityFrom",target="sourceFacilityId")
	@Mapping(source="beneficiary.id",target="beneficiaryId")
	TransferDto toDto(TransferReadOnly transfer);

}
