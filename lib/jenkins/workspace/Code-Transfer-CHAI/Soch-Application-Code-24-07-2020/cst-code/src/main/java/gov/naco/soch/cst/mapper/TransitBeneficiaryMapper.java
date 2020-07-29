package gov.naco.soch.cst.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.TransitBeneficiaryDto;
import gov.naco.soch.projection.ArtTransitBeneficiaryProjection;

public class TransitBeneficiaryMapper {

	public static List<TransitBeneficiaryDto> mapToTransitBeneficiaryDto(
			List<ArtTransitBeneficiaryProjection> beneficiaries, Long facilityId) {
		List<TransitBeneficiaryDto> beneficiaryDtos = new ArrayList<TransitBeneficiaryDto>();
		if (!CollectionUtils.isEmpty(beneficiaries)) {
			beneficiaries.forEach(beneficiary -> {
				TransitBeneficiaryDto beneficiaryDto = new TransitBeneficiaryDto();
				beneficiaryDto.setId(beneficiary.getBeneficiaryId());
				beneficiaryDto.setUid(beneficiary.getBeneficiaryUId());
				beneficiaryDto.setFirstName(beneficiary.getFirstname());
				beneficiaryDto.setMiddleName(beneficiary.getMiddlename());
				beneficiaryDto.setLastName(beneficiary.getLastname());
				beneficiaryDto.setFacilityId(facilityId);
				beneficiaryDto.setArtNumber(beneficiary.getArtNumber());
				beneficiaryDto.setPreArtNumber(beneficiary.getPreArtNumber());
				beneficiaryDto.setIsSelect(Boolean.FALSE);
				beneficiaryDtos.add(beneficiaryDto);

			});
		}
		return beneficiaryDtos;
	}

}
