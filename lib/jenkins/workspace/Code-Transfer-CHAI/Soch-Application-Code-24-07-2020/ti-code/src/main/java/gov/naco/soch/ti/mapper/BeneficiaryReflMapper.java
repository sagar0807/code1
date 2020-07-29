package gov.naco.soch.ti.mapper;

import org.mapstruct.*;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.ti.dto.TiBenReferralDtoNew;
@Mapper(componentModel = "spring", uses = {})
public interface BeneficiaryReflMapper  extends EntityMapper<TiBenReferralDtoNew, BeneficiaryFacilityMapping> {

	@Mapping(source = "beneficiary.id", target = "beneficiaryId")
	@Mapping(source = "beneficiary.firstName", target = "name")
	@Mapping(source = "beneficiary.uid", target = "uId")
	@Mapping(source = "beneficiary.age", target = "age")
	@Mapping(source = "beneficiary.mobileNumber", target = "mobileNumber")
	@Mapping(source = "facility.id", target = "registeredFacility")
	@Mapping(source = "facility.name", target = "registeredFacilityName")
	@Mapping(source="beneficiary.masterClientStatus.id",target="masterClientStatus.id")
	@Mapping(source="beneficiary.masterClientStatus.name",target="masterClientStatus.name")
	@Mapping(source="beneficiary.genderId.id",target="genderId.id")
	@Mapping(source="beneficiary.genderId.name",target="genderId.name")
	TiBenReferralDtoNew toDto(BeneficiaryFacilityMapping beneficiaryFacilityMapping);

	
	  default BeneficiaryFacilityMapping fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        BeneficiaryFacilityMapping beneficiaryFacility = new BeneficiaryFacilityMapping();
	        beneficiaryFacility.setId(id);
	        return beneficiaryFacility;
	    }
}
