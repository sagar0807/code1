package gov.naco.soch.cst.mapper;

import java.util.Objects;

import gov.naco.soch.cst.dto.LinkedFacilityBeneficiaryDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;

public class LinkedFacilityBeneficiaryMapper {
	
	public static LinkedFacilityBeneficiaryDto mapLinkedFacilityBeneficiaryDto(LinkedFacilityBeneficiary linkedFacilityBeneficiary) {
		LinkedFacilityBeneficiaryDto linkedFacilityBeneficiaryDto = new LinkedFacilityBeneficiaryDto();
		Beneficiary beneficiary = linkedFacilityBeneficiary.getBeneficiary();
		Facility facility = linkedFacilityBeneficiary.getLinkedFacility();
		linkedFacilityBeneficiaryDto.setFirstName(Objects.toString(beneficiary.getFirstName(), "") + " "
				+ Objects.toString(beneficiary.getMiddleName(), "") + " "
				+ Objects.toString(beneficiary.getLastName(), ""));
		linkedFacilityBeneficiaryDto.setArtNumber(Objects.toString(beneficiary.getArtNumber(), ""));
		linkedFacilityBeneficiaryDto.setPreArtNumber(Objects.toString(beneficiary.getPreArtNumber(), ""));
		linkedFacilityBeneficiaryDto.setAddress(Objects.toString(beneficiary.getAddress().getAddress(), ""));
		linkedFacilityBeneficiaryDto.setContactNumber(Objects.toString(beneficiary.getMobileNumber(), ""));
		linkedFacilityBeneficiaryDto.setLacName(Objects.toString(facility.getName(), ""));
		linkedFacilityBeneficiaryDto.setAge(Objects.toString(beneficiary.getAge(), ""));
		linkedFacilityBeneficiaryDto.setGender(Objects.toString(beneficiary.getGenderId().getName(), ""));
		linkedFacilityBeneficiaryDto.setId(linkedFacilityBeneficiary.getId());
		linkedFacilityBeneficiaryDto.setLacId(facility.getId());
		linkedFacilityBeneficiaryDto.setBeneficiary(beneficiary.getId());
		return linkedFacilityBeneficiaryDto;
	}

	public static Facility mapToFacilityDto(Long facilityId) {
		Facility facility=new Facility();
		facility.setId(facilityId);
		return facility;
	}

}
