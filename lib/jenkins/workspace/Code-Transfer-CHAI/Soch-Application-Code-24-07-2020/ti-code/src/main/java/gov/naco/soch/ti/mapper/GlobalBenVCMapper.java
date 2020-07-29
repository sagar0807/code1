package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.ti.dto.GlobalBeneficiaryViewCardDTO;

@Mapper(componentModel = "spring", uses = { BeneficiaryFacilityMapper.class, BeneficiaryReferMapper.class,
		TIOstPrescriptionMapper.class, TransferMapper.class, AddressMapper.class, MMEducationLevelMapper.class,
		MMMaritalStatusMapper.class, BeneficiaryFamilyDetailsMapper.class, MMEmploymentStatusMapper.class,
		MMClientStatusMapper.class, MMOccupationMapper.class, MMGenderMapper.class })
@Component
public interface GlobalBenVCMapper extends EntityMapper<GlobalBeneficiaryViewCardDTO, Beneficiary> {

	@Mapping(source = "caregiverAddressId.id", target = "caregiverAddressId")
	@Mapping(target = "educationLevelId", qualifiedByName = "educationLevel")
	@Mapping(target = "maritalStatusId", qualifiedByName = "maritalStatus")
	@Mapping(target = "masterEmploymentStatus", qualifiedByName = "employmentStatus")
	@Mapping(target = "masterClientStatus", qualifiedByName = "clientStatus")
	@Mapping(target = "occupationId", qualifiedByName = "occupation")
	@Mapping(target = "genderId", qualifiedByName = "gender")
	@Mapping(source = "hivStatusId.name", target = "hivConfirmatoryStatus")
	GlobalBeneficiaryViewCardDTO toDto(Beneficiary beneficiary);

	default Beneficiary fromId(Long id) {
		if (id == null) {
			return null;
		}
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(id);
		return beneficiary;
	}

}
