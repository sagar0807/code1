package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.Transfer;
import gov.naco.soch.ti.dto.TiBenTransferDto;

@Mapper(componentModel = "spring", uses = {})
public interface TiTransferMapper extends EntityMapper<TiBenTransferDto, Transfer> {

	@Mapping(source = "facilityTo.id" ,target = "transferToId")
	@Mapping(source = "facilityTo.name" ,target = "transferTo")
	@Mapping(source = "facilityFrom.id" ,target = "transferFromId")
	@Mapping(source = "facilityFrom.name" ,target = "transferFrom")
	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "beneficiary.firstName", target = "firstName")
	@Mapping(source = "beneficiary.lastName", target = "lastName")
	@Mapping(source = "beneficiary.uid", target = "uId")
	@Mapping(source = "beneficiary.age", target = "age")
	@Mapping(source = "transferStatus", target = "status")
	@Mapping(source = "tiBeneficiary.id", target = "tiBeneficiaryId")
	@Mapping(source = "initiationDate", target = "transferDate")
	@Mapping(source = "beneficiary.ostBeneficiary.id", target = "ostBeneficiaryId")
	@Mapping(source="beneficiary.masterClientStatus.id",target="masterClientStatus.id")
	@Mapping(source="beneficiary.masterClientStatus.name",target="masterClientStatus.name")
	@Mapping(source="beneficiary.genderId.id",target="genderId.id")
	@Mapping(source="beneficiary.genderId.name",target="genderId.name")
	@Mapping(source="beneficiary.ostBeneficiary.ostNumber",target="ostNumber")
	TiBenTransferDto toDto(Transfer transfer);

	
}
