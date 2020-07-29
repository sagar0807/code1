package gov.naco.soch.ti.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.ti.dto.TIOstAssessDTO;

/**
 * Mapper for the entity {@link TiOstAssessment} and its DTO
 * {@link TIOstAssessDTO}.
 */
@Mapper(componentModel = "spring", uses = {TiOstBeneficiaryMapper.class,MMOstStatusMapper.class,MMOstAssessmentReason.class,
	       MMOstBenStatusMapper.class,
		TiFacilityMapper.class,MMClientStatusMapper.class,BeneficiaryFacilityMapper.class,BeneficiaryMapper.class,TIOstPrescriptionAssessmentMapper.class,TiOstAssessmentDrugUsageMapper.class,TiOstAssessmentDrugComplicationMapper.class })
public interface TIOstAssessMapper extends EntityMapper<TIOstAssessDTO, TiOstAssessment> {

	@Mapping(source = "tiOstBeneficiary.beneficiary", target = "tiOstBeneficiary.masterBeneficiary")
	@Mapping(source = "tiOstBeneficiary.beneficiary.address.state.id", target = "tiOstBeneficiary.masterBeneficiary.address.stateId")
	@Mapping(source = "tiOstBeneficiary.beneficiary.address.district.id", target = "tiOstBeneficiary.masterBeneficiary.address.districtId")
	@Mapping(source = "tiOstBeneficiary.ostFollowUp", target = "tiOstBeneficiary.ostFollowUp", ignore = true)
	@Mapping(source = "tiOstBeneficiary.ostAssess", target = "tiOstBeneficiary.ostAssess", ignore = true)
	@Mapping(target="tiOstBeneficiary.masterBeneficiary.masterClientStatus",qualifiedByName="clientStatus")
	@Mapping(target="tiOstBeneficiary.ostStatus",qualifiedByName="ostStatus")
	@Mapping(target="followUpReason",qualifiedByName="followUpReason")
	@Mapping(target="tiOstBeneficiary.status",qualifiedByName="ostBenStatus")
	TIOstAssessDTO toDto(TiOstAssessment tIOstAssess);

	@InheritInverseConfiguration
	@Mapping(target="tiOstBeneficiary.beneficiary.masterClientStatus",qualifiedByName="clientStatus")
	@Mapping(target="tiOstBeneficiary.ostStatus",qualifiedByName="ostStatus")
	@Mapping(target="followUpReason",qualifiedByName="followUpReason")
	@Mapping(target="tiOstBeneficiary.status",qualifiedByName="ostBenStatus")
	TiOstAssessment toEntity(TIOstAssessDTO tIOstAssessDTO);


	//@InheritInverseConfiguration
	@Mapping(source="tiOstBeneficiary.ostStatus",target="tiOstBeneficiary.ostStatus",qualifiedByName="ostStatus")
	@BeanMapping(nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE,nullValueCheckStrategy=NullValueCheckStrategy.ALWAYS)
	@Mapping(target = "tiOstBeneficiary.ostFollowUp", source = "tiOstBeneficiary.ostFollowUp", ignore = true)
	@Mapping(target = "tiOstBeneficiary.ostAssess", source = "tiOstBeneficiary.ostAssess", ignore = true)
	@Mapping(source="followUpReason",target="followUpReason",qualifiedByName="followUpReason")
	@Mapping(source="tiOstBeneficiary.status",target="tiOstBeneficiary.status",qualifiedByName="ostBenStatus")
	TiOstAssessment toUpdateEntity(TIOstAssessDTO tIOstAssessDTO, @MappingTarget TiOstAssessment tiOstAssessment);

	default TiOstAssessment fromId(Long id) {
		if (id == null) {
			return null;
		}
		TiOstAssessment tiOstAssessment = new TiOstAssessment();
		tiOstAssessment.setId(id);
		return tiOstAssessment;
	}

}
