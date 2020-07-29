package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.TransferDto;
import gov.naco.soch.entity.Transfer;

@Mapper(componentModel = "spring")
public interface TransferMapper extends EntityMapper<TransferDto, Transfer> {

	Transfer toEntity(TransferDto transferDto);

	@Mapping(source="beneficiary.id",target="beneficiaryId")
	@Mapping(source="facilityTo.id",target="destinationFacilityId")
	@Mapping(source="facilityFrom.id",target="sourceFacilityId")
	TransferDto toDto(Transfer transfer);

}
