package gov.naco.soch.shared.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import gov.naco.soch.entity.BeneficiaryFamilyDetail;
import gov.naco.soch.dto.PartnerLinkageDTO;


@Mapper(componentModel = "spring" , uses={BeneficiaryMapper.class,MMGenderMapper.class,MMHivStatusMapper.class,MMRelationshipMapper.class})
public interface PartnerLinkageMapper extends EntityMapper<PartnerLinkageDTO,BeneficiaryFamilyDetail>{
	
	@Mapping(target="masterGender",qualifiedByName="gender")
	@Mapping(target="masterHivStatus",qualifiedByName="hivStatus")
	@Mapping(target="masterRelationship",qualifiedByName="relationship")
	PartnerLinkageDTO toDto(BeneficiaryFamilyDetail beneficiaryFamilyDetail);
	
	@Mapping(target="masterGender",qualifiedByName="gender")
	@Mapping(target="masterHivStatus",qualifiedByName="hivStatus")
	@Mapping(target="masterRelationship",qualifiedByName="relationship")
	BeneficiaryFamilyDetail toEntity(PartnerLinkageDTO partnerLinkageDTO);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(source="masterGender",target="masterGender",qualifiedByName="gender")
	@Mapping(source="masterHivStatus",target="masterHivStatus",qualifiedByName="hivStatus")
	@Mapping(source="masterRelationship",target="masterRelationship",qualifiedByName="relationship")
	BeneficiaryFamilyDetail toUpdateEntity(PartnerLinkageDTO partnerLinkageDTO,@MappingTarget BeneficiaryFamilyDetail beneficiaryFamilyDetail);

}
