package gov.naco.soch.mapper;

import java.util.HashSet;
import java.util.Set;

import gov.naco.soch.dto.BeneficiaryAddressDto;
import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.dto.DistrictDto;
import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.dto.StateDto;
import gov.naco.soch.dto.SubdistrictDto;
import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.dto.TownDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterClientStatus;
import gov.naco.soch.entity.MasterEducationLevel;
import gov.naco.soch.entity.MasterEmploymentStatus;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterMaritalStatus;
import gov.naco.soch.entity.MasterOccupation;

public class BeneficiaryMapperUtil {

	// Mapper class to convert entity to Dto class

	public static BeneficiaryDto mapToBeneficiary(Beneficiary beneficiary) {
		BeneficiaryDto beneficiaryDto = new BeneficiaryDto();
		if (beneficiary != null) {
			beneficiaryDto = new BeneficiaryDto();
			beneficiaryDto.setId(beneficiary.getId());
			if(beneficiary.getRegularPartners() != null && beneficiary.getRegularPartners()) {
				beneficiaryDto.setRegularPartners(beneficiary.getRegularPartners());
			}
			if (beneficiary.getTiBeneficiary()!=null) {
				if(beneficiary.getTiBeneficiary().getNumberOfPartners() != null && !beneficiary.getTiBeneficiary().getNumberOfPartners().isEmpty()) {
					beneficiaryDto.setRegularPartnersNumber(Integer.parseInt(beneficiary.getTiBeneficiary().getNumberOfPartners())); 
				}
			}
			if(beneficiary.getDateOfBirth()!=null) {
				beneficiaryDto.setDateOfBirth(beneficiary.getDateOfBirth());
			}
			if(beneficiary.getMobileNumber()!=null) {
				beneficiaryDto.setMobileNumber(beneficiary.getMobileNumber());
			}
			// beneficiaryDto.setGender(beneficiary.getGender());
			if(beneficiary.getAadharNumber()!=null) {
				beneficiaryDto.setAadharNumber(beneficiary.getAadharNumber());
			}
			if(beneficiary.getAge()!=null) {
				beneficiaryDto.setAge(beneficiary.getAge());
			}
			// beneficiaryDto.setBarcode(beneficiary.getBarcode());
			beneficiaryDto.setBeneficiaryType(beneficiary.getBeneficiaryType());
			if (beneficiary.getEducationLevelId() != null) {
				MiniMasterDto educationLevel = new MiniMasterDto();
				educationLevel.setId(beneficiary.getEducationLevelId().getId());
				educationLevel.setName(beneficiary.getEducationLevelId().getName());
				beneficiaryDto.setEducationLevelId(educationLevel);
			}

			if (beneficiary.getMasterClientStatus() != null) {
				MiniMasterDto mmDto = new MiniMasterDto();
				mmDto.setId(beneficiary.getMasterClientStatus().getId());
				mmDto.setName(beneficiary.getMasterClientStatus().getName());
				beneficiaryDto.setMasterClientStatus(mmDto);
			}
			if (beneficiary.getMasterEmploymentStatus() != null) {
				MiniMasterDto mmDto = new MiniMasterDto();
				mmDto.setId(beneficiary.getMasterEmploymentStatus().getId());
				mmDto.setName(beneficiary.getMasterEmploymentStatus().getName());
				beneficiaryDto.setMasterEmploymentStatus(mmDto);
			}
			beneficiaryDto.setOtherEmploymentStatus(beneficiary.getOtherEmploymentStatus());
			beneficiaryDto.setFirstName(beneficiary.getFirstName());
			if (beneficiary.getGenderId() != null) {
				MiniMasterDto mmDto = new MiniMasterDto();
				mmDto.setId(beneficiary.getGenderId().getId());
				mmDto.setName(beneficiary.getGenderId().getName());
				beneficiaryDto.setGenderId(mmDto);
			}
			if(beneficiary.getIsActive() != null && beneficiary.getIsActive()) {
				beneficiaryDto.setIsActive(beneficiary.getIsActive());
			}
			if(beneficiary.getIsDelete() != null && beneficiary.getIsDelete()) {
				beneficiaryDto.setIsDelete(beneficiary.getIsDelete());
			}
			// beneficiaryDto.setIsPlhiv(beneficiary.getIsPlhiv());
			if(beneficiary.getLastName() != null && !beneficiary.getLastName().isEmpty()) {
				beneficiaryDto.setLastName(beneficiary.getLastName());
			}
			if (beneficiary.getMaritalStatusId() != null) {
				MiniMasterDto mmDto = new MiniMasterDto();
				mmDto.setId(beneficiary.getMaritalStatusId().getId());
				mmDto.setName(beneficiary.getMaritalStatusId().getName());
				beneficiaryDto.setMaritalStatusId(mmDto);
			}
			if(beneficiary.getMiddleName() != null && !beneficiary.getMiddleName().isEmpty()) {
				beneficiaryDto.setLastName(beneficiary.getMiddleName());
			}
			if (beneficiary.getOccupationId() != null) {
				MiniMasterDto mmDto = new MiniMasterDto();
				mmDto.setId(beneficiary.getOccupationId().getId());
				mmDto.setName(beneficiary.getOccupationId().getName());
				beneficiaryDto.setOccupationId(mmDto);
			}
			if(beneficiary.getStatus() != null && !beneficiary.getStatus().isEmpty()) {
				beneficiaryDto.setStatus(beneficiary.getStatus());
			}
			if(beneficiary.getUid() != null && !beneficiary.getUid().isEmpty()) {
				beneficiaryDto.setUid(beneficiary.getUid());
			}
			beneficiaryDto.setBeneficiaryActivityStatus(beneficiary.getBeneficiaryActivityStatus());
			BeneficiaryAddressDto addressDto = new BeneficiaryAddressDto();
			if (beneficiary.getAddress() != null) {
				addressDto.setId(beneficiary.getAddress().getId());
				addressDto.setAddressLineOne(beneficiary.getAddress().getAddressLineOne());
				addressDto.setAddressLineTwo(beneficiary.getAddress().getAddressLineTwo());
				if (beneficiary.getAddress().getState()!=null) {
					addressDto.setStateId(beneficiary.getAddress().getState().getId());
					StateDto stateDto = new StateDto();
					stateDto.setId(beneficiary.getAddress().getState().getId());
					stateDto.setName(beneficiary.getAddress().getState().getName());
					addressDto.setState(stateDto);
				}
				if (beneficiary.getAddress().getDistrict()!=null) {
					addressDto.setDistrictId(beneficiary.getAddress().getDistrict().getId());
					addressDto.setPincode(beneficiary.getAddress().getPincode());
					DistrictDto  districtDto = new DistrictDto();
					districtDto.setId(beneficiary.getAddress().getDistrict().getId());
					districtDto.setName(beneficiary.getAddress().getDistrict().getName());
					addressDto.setDistrict(districtDto);
				}
				if (beneficiary.getAddress().getSubdistrict() != null) {
					SubdistrictDto subdistrictDto = new SubdistrictDto();
					subdistrictDto.setSubdistrictId(beneficiary.getAddress().getSubdistrict().getSubdistrictId());
					subdistrictDto.setSubDistrictName(beneficiary.getAddress().getSubdistrict().getSubdistrictName());
					addressDto.setSubdistrict(subdistrictDto);
				}
				if (beneficiary.getAddress().getTown() != null) {
					TownDto townDto = new TownDto();
					townDto.setTownId(beneficiary.getAddress().getTown().getTownId());
					townDto.setTownName(beneficiary.getAddress().getTown().getTownName());
					addressDto.setTown(townDto);
					addressDto.setTownId(beneficiary.getAddress().getTown().getTownId());
				}
				if (beneficiary.getAddress().getTaluk() != null) { 
					addressDto.setTaluk(beneficiary.getAddress().getTaluk());
				}

			}
			beneficiaryDto.setAddressDto(addressDto);
			// beneficiaryDto.setTiCode(beneficiary.getTiCode());
			// Beneficiary Facility mapping
			Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDtos = new HashSet<BeneficiaryFacilityMappingDto>();
			for (BeneficiaryFacilityMapping beneficiaryFacilityMapping : beneficiary.getBeneficiaryFacilityMappings()) {
				BeneficiaryFacilityMappingDto beneficiaryFacilityMappingDto = new BeneficiaryFacilityMappingDto();
				beneficiaryFacilityMappingDto.setId(beneficiaryFacilityMapping.getId());
				beneficiaryFacilityMappingDto.setIsActive(beneficiaryFacilityMapping.getIsActive());
				beneficiaryFacilityMappingDto.setBeneficiaryId(beneficiaryFacilityMapping.getBeneficiary().getId());
				beneficiaryFacilityMappingDto.setFacilityId(beneficiaryFacilityMapping.getFacility().getId());
				beneficiaryFacilityMappingDtos.add(beneficiaryFacilityMappingDto);
			}
			beneficiaryDto.setBeneficiaryFacilityMappings(beneficiaryFacilityMappingDtos);
                       beneficiaryDto.setIsLivingInRelationship(beneficiary.getIsLivingInRelationship());
		}
		return beneficiaryDto;
	}

	public static Beneficiary mapToBeneficiaryId(Long beneficiaryId) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(beneficiaryId);
		return beneficiary;
	}

	public static Beneficiary mapToDto(BeneficiaryDto masterBeneficiary, Beneficiary beneficiary, Facility facility) {
		beneficiary.setId(masterBeneficiary.getId());
		beneficiary.setFirstName(masterBeneficiary.getFirstName());
		beneficiary.setLastName(masterBeneficiary.getMiddleName());
		beneficiary.setLastName(masterBeneficiary.getLastName());
		beneficiary.setOtherEmploymentStatus(masterBeneficiary.getOtherEmploymentStatus());
		if (masterBeneficiary.getMaritalStatusId() != null) {
			MasterMaritalStatus maritalStatus = new MasterMaritalStatus();
			maritalStatus.setId(masterBeneficiary.getMaritalStatusId().getId());
			beneficiary.setMaritalStatusId(maritalStatus);
		}

		if (masterBeneficiary.getEducationLevelId() != null) {
			MasterEducationLevel educationLevel = new MasterEducationLevel();
			educationLevel.setId(masterBeneficiary.getEducationLevelId().getId());
			beneficiary.setEducationLevelId(educationLevel);
		}

		if (masterBeneficiary.getMasterEmploymentStatus() != null) {
			MasterEmploymentStatus employmentStatus = new MasterEmploymentStatus();
			employmentStatus.setId(masterBeneficiary.getMasterEmploymentStatus().getId());
			beneficiary.setMasterEmploymentStatus(employmentStatus);
		}
		if (masterBeneficiary.getMasterClientStatus() != null) {
			MasterClientStatus clientStatus = new MasterClientStatus();
			clientStatus.setId(masterBeneficiary.getMasterClientStatus().getId());
			beneficiary.setMasterClientStatus(clientStatus);
		}
		if (masterBeneficiary.getOccupationId() != null) {
			MasterOccupation masterOccupation = new MasterOccupation();
			masterOccupation.setId(masterBeneficiary.getOccupationId().getId());
			beneficiary.setOccupationId(masterOccupation);
		}
		if (masterBeneficiary.getGenderId() != null) {
			MasterGender gender = new MasterGender();
			gender.setId(masterBeneficiary.getGenderId().getId());
			beneficiary.setGenderId(gender);
		}
		Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings = beneficiary.getBeneficiaryFacilityMappings();
		BeneficiaryFacilityMapping beneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
		beneficiaryFacilityMapping.setFacility(facility);
		beneficiaryFacilityMapping.setBeneficiary(beneficiary);
		beneficiaryFacilityMapping.setIsActive(true);
		beneficiaryFacilityMappings.add(beneficiaryFacilityMapping);
		Address address = beneficiary.getAddress();
		TiBeneficiaryAddressDto addressDto = masterBeneficiary.getAddress();
		address.setAddress(addressDto.getAddress());
		beneficiary.setAddress(address);
		return beneficiary;
	}

}
