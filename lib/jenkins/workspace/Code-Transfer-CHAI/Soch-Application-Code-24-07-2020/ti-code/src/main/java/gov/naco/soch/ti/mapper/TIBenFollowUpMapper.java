package gov.naco.soch.ti.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import gov.naco.soch.entity.TiOstFollowUp;
import gov.naco.soch.ti.dto.TIBenFollowUpDTO;

/**
 * Mapper for the entity {@link TIBenFollowUp} and its DTO
 * {@link TIBenFollowUpDTO}.
 */


@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class,MMFollowUpTypeMapper.class,TiFacilityMapper.class,MMOstStatusMapper.class,
		MMMasterPrimaryDrugMapper.class,BeneficiaryFacilityMapper.class, TIOstPrescriptionFollowUpMapper.class, TiOstFollowUpByMapper.class,
		TiOstFollowUpReasonMapper.class,TiOstFollowUpSideEffectMapper.class})
public interface TIBenFollowUpMapper extends EntityMapper<TIBenFollowUpDTO, TiOstFollowUp> {

	@Mapping(source = "tiOstBeneficiary.beneficiary", target = "tiOstBeneficiary.masterBeneficiary")
	@Mapping(source = "tiOstBeneficiary.beneficiary.address.state.id", target = "tiOstBeneficiary.masterBeneficiary.address.stateId")
	@Mapping(source = "tiOstBeneficiary.beneficiary.address.district.id", target = "tiOstBeneficiary.masterBeneficiary.address.districtId")
	@Mapping(target="tiOstBeneficiary.ostStatus",qualifiedByName="ostStatus")
	@Mapping(source = "tiOstBeneficiary.ostFollowUp", target = "tiOstBeneficiary.ostFollowUp", ignore = true)
	@Mapping(source = "tiOstBeneficiary.ostAssess", target = "tiOstBeneficiary.ostAssess")
	@Mapping(target="primaryDrug",qualifiedByName={"drug","primaryDrug"})
	@Mapping(target="otherDrug",qualifiedByName={"drug","otherDrug"})
	@Mapping(target="followUpType",qualifiedByName="followUpType")
	TIBenFollowUpDTO toDto(TiOstFollowUp tIBenFollowUp);

	@InheritInverseConfiguration
	@Mapping(target = "tiOstBeneficiary.ostAssess",ignore=true)
	TiOstFollowUp toEntity(TIBenFollowUpDTO tIBenFollowUpDTO);

   // @InheritInverseConfiguration
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(source="primaryDrug",target="primaryDrug",qualifiedByName={"drug","primaryDrug"})
	@Mapping(source="otherDrug",target="otherDrug",qualifiedByName={"drug","otherDrug"})
	@Mapping(source="followUpType",target="followUpType",qualifiedByName="followUpType")
	@Mapping(target="tiOstBeneficiary.ostStatus",qualifiedByName="ostStatus")
        @Mapping(target = "tiOstBeneficiary.ostAssess",ignore=true)
	TiOstFollowUp toUpdateEntity(TIBenFollowUpDTO tIBenFollowUpDTO, @MappingTarget TiOstFollowUp tiOstFollowUp);

	default TiOstFollowUp fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiOstFollowUp tiOstFollowUp = new TiOstFollowUp();
		tiOstFollowUp.setId(id);
		return tiOstFollowUp;
	}

}
