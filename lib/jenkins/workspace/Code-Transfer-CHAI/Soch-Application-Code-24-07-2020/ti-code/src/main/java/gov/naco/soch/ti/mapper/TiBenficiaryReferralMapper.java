package gov.naco.soch.ti.mapper;

import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.repository.FacilityTypeRepository;
import gov.naco.soch.ti.dto.TiBenReferralDtoNew;
import gov.naco.soch.ti.service.FacilityTypeNameQualifier;

@Mapper(componentModel = "spring", uses = { BeneficiaryMapper.class, TIBenScrDetailsMapper.class,
	MMSyphilisStatusMapper.class, MMTbStatusMapper.class, MMHivStatusMapper.class,FacilityTypeNameQualifier.class })
public interface TiBenficiaryReferralMapper extends EntityMapper<TiBenReferralDtoNew, BeneficiaryReferral> {

    @Mapping(source = "referDate", target = "dateOfReferral")
    @Mapping(source = "beneficiaryReferralStatusMaster.name", target = "status")
    @Mapping(source = "facility1.id", target = "referredFacilityFrom")
    @Mapping(source = "facility2.id", target = "referredFacilityTo")
    @Mapping(source = "facility1.name", target = "referredFacilityFromName")
    @Mapping(source = "facility2.name", target = "referredFacilityToName")
    @Mapping(source = "beneficiary.id", target = "beneficiaryId")
    @Mapping(source = "beneficiary.firstName", target = "name")
    @Mapping(source = "beneficiary.uid", target = "uId")
    @Mapping(source = "beneficiary.age", target = "age")
    @Mapping(source = "beneficiary.mobileNumber", target = "mobileNumber")
    @Mapping(source = "referralReason", target = "referralReason")
    @Mapping(source = "facilityType", target = "facilityType")
    @Mapping(source = "facility2.facilityType.facilityTypeName", target = "facilityTypeName")
    @Mapping(source = "beneficiary.masterClientStatus.id", target = "masterClientStatus.id")
    @Mapping(source = "beneficiary.masterClientStatus.name", target = "masterClientStatus.name")
    @Mapping(source = "beneficiary.genderId.id", target = "genderId.id")
    @Mapping(source = "beneficiary.genderId.name", target = "genderId.name")
    @Mapping(source = "beneficiary.hivStatusId.name", target = "hivStatus")
    @Mapping(source = "beneficiary.hivTypeId.name", target = "typeOfHiv")
    @Mapping(source = "tiBenScrDetails.infection.id", target = "infectionId")
    @Mapping(source = "tiBenScrDetails.infection.name", target = "infectionName")
    @Mapping(source="facilityType",target="facilityType_Name",qualifiedByName = "facilityTypeName")
    TiBenReferralDtoNew toDto(BeneficiaryReferral tIBenReferral);

    @Mapping(source = "referredFacilityFrom", target = "facility1.id")
    @Mapping(source = "referredFacilityTo", target = "facility2.id")
    @Mapping(source = "beneficiaryId", target = "beneficiary.id")
    BeneficiaryReferral toEntity(TiBenReferralDtoNew tIBenReferralDTO);

    default BeneficiaryReferral fromId(Long id) {
	if (id == null) {
	    return null;
	}
	BeneficiaryReferral tIBenReferral = new BeneficiaryReferral();
	tIBenReferral.setId(id);
	return tIBenReferral;
    }

    @AfterMapping
    default void setReferralBeneficiary(@MappingTarget TiBenReferralDtoNew benReferralDtoNew,
	    BeneficiaryReferral beneficiaryReferral) {
	Beneficiary beneficiary = beneficiaryReferral.getBeneficiary();
	if (beneficiary.getLastName() != null) {
	    benReferralDtoNew.setName(beneficiary.getFirstName() + " " + beneficiary.getLastName());
	} else {
	    benReferralDtoNew.setName(beneficiary.getFirstName());
	}
//	   Optional<FacilityType> facilityTypeOptional=facilityTypeRepository.findById(beneficiaryReferral.getFacilityType().longValue());
//	   if(facilityTypeOptional.isPresent())
//	   {
//	       benReferralDtoNew.setFacilityType_Name(facilityTypeOptional.get().getFacilityTypeName());
//	   }
    }
}