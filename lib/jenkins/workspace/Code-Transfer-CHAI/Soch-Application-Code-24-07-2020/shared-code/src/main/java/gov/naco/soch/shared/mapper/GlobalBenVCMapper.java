package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.shared.dto.GlobalBeneficiaryViewCardDTO;



@Mapper(componentModel = "spring", uses = { BeneficiaryFacilityMapper.class,BeneficiaryReferMapper.class,
		TransferMapper.class,AddressMapper.class,BeneficiaryFamilyDetailsMapper.class,TiOstBeneficiaryMapper.class,
		TIBeneficiaryMapper.class,
		MMEducationLevelMapper.class,MMMaritalStatusMapper.class,
		MMEmploymentStatusMapper.class,MMClientStatusMapper.class,MMOccupationMapper.class,MMGenderMapper.class })

public interface GlobalBenVCMapper extends EntityMapper<GlobalBeneficiaryViewCardDTO, Beneficiary> {
	@Mapping(source="caregiverAddressId.id",target="caregiverAddressId")
	@Mapping(target="educationLevelId",qualifiedByName="educationLevel")
	@Mapping(target="maritalStatusId",qualifiedByName="maritalStatus")
	@Mapping(target="masterEmploymentStatus",qualifiedByName="employmentStatus")
	@Mapping(target="masterClientStatus",qualifiedByName="clientStatus")
	@Mapping(target="occupationId",qualifiedByName="occupation")
	@Mapping(target="genderId",qualifiedByName="gender")
	@Mapping(source="ictcBeneficiary.pid",target="ictcDetails.pid")
	@Mapping(source="hivStatusId.name",target="ictcDetails.hivConfirmatoryStatus")
	@Mapping(source="ictcBeneficiary.facility.name",target="ictcDetails.linkedIctcCentre")
	@Mapping(source="hivTypeId.name",target="ictcDetails.hivType")
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
