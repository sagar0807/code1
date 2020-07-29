package gov.naco.soch.shared.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.entity.Beneficiary;

/**
 * Mapper for the entity {@link Beneficiary} and its DTO {@link BeneficiaryDTO}.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryFacilityMapper.class, MMEducationLevelMapper.class,MMMaritalStatusMapper.class,
		BeneficiaryFamilyDetailsMapper.class,TiOstBeneficiaryMapper.class,
		MMEmploymentStatusMapper.class,MMClientStatusMapper.class,MMOccupationMapper.class,MMGenderMapper.class,
		BeneficiaryReferMapper.class, TransferMapper.class, AddressMapper.class })
public interface BeneficiaryMapper extends EntityMapper<BeneficiaryDto, Beneficiary> {
      
	@Mapping(target="educationLevelId",qualifiedByName="educationLevel")
	@Mapping(target="maritalStatusId",qualifiedByName="maritalStatus")
	@Mapping(target="masterEmploymentStatus",qualifiedByName="employmentStatus")
	@Mapping(target="masterClientStatus",qualifiedByName="clientStatus")
	@Mapping(target="occupationId",qualifiedByName="occupation")
	@Mapping(target="genderId",qualifiedByName="gender")
	Beneficiary toEntity(BeneficiaryDto beneficiaryDTO);
    
	@Mapping(target="educationLevelId",qualifiedByName="educationLevel")
	@Mapping(target="maritalStatusId",qualifiedByName="maritalStatus")
	@Mapping(target="masterEmploymentStatus",qualifiedByName="employmentStatus")
	@Mapping(target="masterClientStatus",qualifiedByName="clientStatus")
	@Mapping(target="occupationId",qualifiedByName="occupation")
	@Mapping(target="genderId",qualifiedByName="gender")
	@Mapping(source="hivTypeId.name",target="hivType")
	@Mapping(source="hivStatusId.name",target="hivConfirmatoryStatus")
	@Mapping(source="ostBeneficiary.ostStatus.name",target="ostStatus")
	BeneficiaryDto toDto(Beneficiary beneficiary);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(source="educationLevelId",target="educationLevelId",qualifiedByName="educationLevel")
	@Mapping(source="maritalStatusId",target="maritalStatusId",qualifiedByName="maritalStatus")
	@Mapping(source="masterEmploymentStatus",target="masterEmploymentStatus",qualifiedByName="employmentStatus")
	@Mapping(source="masterClientStatus",target="masterClientStatus",qualifiedByName="clientStatus")
	@Mapping(source="occupationId",target="occupationId",qualifiedByName="occupation")
	@Mapping(source="genderId",target="genderId",qualifiedByName="gender")
	Beneficiary toUpdateEntity(BeneficiaryDto beneficiaryDTO,@MappingTarget Beneficiary beneficiary);
	

	default Beneficiary fromId(Long id) {
		if (id == null) {
			return null;
		}
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(id);
		return beneficiary;
	}

}
