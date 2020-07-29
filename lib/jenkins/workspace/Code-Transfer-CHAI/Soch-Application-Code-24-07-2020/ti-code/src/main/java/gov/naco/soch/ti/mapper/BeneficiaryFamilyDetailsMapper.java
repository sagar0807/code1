package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.dto.BeneficiaryFamilyDetailsDto;
import gov.naco.soch.entity.BeneficiaryFamilyDetail;

@Mapper(componentModel = "spring")
public interface BeneficiaryFamilyDetailsMapper extends EntityMapper<BeneficiaryFamilyDetailsDto, BeneficiaryFamilyDetail>  {
	
	@Mapping(source="partnerBeneficiary.id",target="partnerBeneficiaryId")
	BeneficiaryFamilyDetailsDto toDto(BeneficiaryFamilyDetail beneficiaryFamilyDetail);
	
	
	default BeneficiaryFamilyDetail fromId(Long id) {
		if (id == null) {
			return null;
		}
		BeneficiaryFamilyDetail beneficiaryFamilyDetail = new BeneficiaryFamilyDetail();
		beneficiaryFamilyDetail.setId(id);
		return beneficiaryFamilyDetail;
	}

}