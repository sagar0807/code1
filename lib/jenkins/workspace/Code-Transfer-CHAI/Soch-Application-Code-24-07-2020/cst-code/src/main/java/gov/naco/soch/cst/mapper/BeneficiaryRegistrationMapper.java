package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryLinkagePurposes;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.Beneficiary;
//import gov.naco.soch.entity.BeneficiaryDetailsPerVisit;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;
import gov.naco.soch.entity.BeneficiaryTransitFacility;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityLinkedFacilityBeneficiary;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.IctcBeneficiary;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.entity.MasterArtBeneficiaryStatus;
import gov.naco.soch.entity.MasterArtTreatmentStatus;
import gov.naco.soch.entity.MasterBeneficiaryArtTransferredFrom;
import gov.naco.soch.entity.MasterBeneficiaryCategory;
import gov.naco.soch.entity.MasterDeliveryOutcome;
import gov.naco.soch.entity.MasterEducationLevel;
import gov.naco.soch.entity.MasterEmploymentStatus;
import gov.naco.soch.entity.MasterEntryPoint;
import gov.naco.soch.entity.MasterFourSScreening;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterHivStatus;
import gov.naco.soch.entity.MasterHivType;
import gov.naco.soch.entity.MasterMaritalStatus;
import gov.naco.soch.entity.MasterMonthlyIncome;
import gov.naco.soch.entity.MasterOccupation;
import gov.naco.soch.entity.MasterOrganisationType;
import gov.naco.soch.entity.MasterPregnancyTypeCase;
import gov.naco.soch.entity.MasterPurpos;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.MasterRelationType;
import gov.naco.soch.entity.MasterRiskFactor;
import gov.naco.soch.entity.MasterSocialWelfare;
import gov.naco.soch.entity.MasterStayingWith;
import gov.naco.soch.entity.MasterTreatmentLine;
import gov.naco.soch.entity.Pincode;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.Town;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.RefferalStatusEnum;
import gov.naco.soch.util.DateUtil;
import gov.naco.soch.util.UserUtils;

public class BeneficiaryRegistrationMapper {

	public static Beneficiary maptoBeneficiary(ArtRegistrationDto artRegistrationDto) {
		Beneficiary beneficiary = new Beneficiary();
		if (artRegistrationDto != null) {
			beneficiary.setFirstName(artRegistrationDto.getFirstName());
			beneficiary.setIsActive(true);
			beneficiary.setIsDelete(false);
			beneficiary.setMiddleName(artRegistrationDto.getMiddleName());
			beneficiary.setLastName(artRegistrationDto.getLastName());
			beneficiary.setMobileNumber(artRegistrationDto.getContactNumber());
			beneficiary.setDateOfBirth(artRegistrationDto.getBirthDate());
			beneficiary.setAge(artRegistrationDto.getAge());
			beneficiary.setAadharNumber(artRegistrationDto.getAadharNumber());
			beneficiary.setPreArtNumber(artRegistrationDto.getPreArtNumber());
			beneficiary.setArtNumber(artRegistrationDto.getArtNumber());
			beneficiary.setAlternatePhonenumber(artRegistrationDto.getAlternatePhoneNumber());
			beneficiary.setCaregiverName(artRegistrationDto.getCaregiverName());
			beneficiary.setCaregiverPhoneNumber(artRegistrationDto.getCaregiverPhoneNumber());
			beneficiary.setDeathDate(artRegistrationDto.getDeathDate());
			beneficiary.setDeathReason(artRegistrationDto.getDeathReason());
			beneficiary.setBankAccountName(artRegistrationDto.getBankAccountName());
			beneficiary.setBankAccountNumber(artRegistrationDto.getBankAccountNumber());
			beneficiary.setBankIfsc(artRegistrationDto.getBankIfsc());
			beneficiary.setClosePersonName(artRegistrationDto.getClosePersonName());
			beneficiary.setRegDate(artRegistrationDto.getArtRegistration_date());
			if(artRegistrationDto.getMasterClosePersonRelationType()!=null) {
				MasterRelationType relationType=new MasterRelationType();
				relationType.setId(artRegistrationDto.getMasterClosePersonRelationType());
				beneficiary.setMasterRelationType(relationType);	
			}
			if (artRegistrationDto.getGenderId() != null) {
				MasterGender gender = mapToMasterGender(artRegistrationDto.getGenderId());
				beneficiary.setGenderId(gender);
			}
			if (artRegistrationDto.getCategoryId() != null) {
				MasterBeneficiaryCategory beneficiaryCategory = mapToMasterBeneficiaryCategory(
						artRegistrationDto.getCategoryId());
				beneficiary.setCategoryId(beneficiaryCategory);
			}
			if (artRegistrationDto.getMonthlyIncome() != null) {
				MasterMonthlyIncome masterMonthlyIncome = mapToMasterMonthlyIncome(
						artRegistrationDto.getMonthlyIncome());
				beneficiary.setMonthlyIncomeId(masterMonthlyIncome);
			}
			if (artRegistrationDto.getMaritalStatusId() != null) {
				MasterMaritalStatus maritalStatus = mapToMasterMaritalStatus(artRegistrationDto.getMaritalStatusId());
				beneficiary.setMaritalStatusId(maritalStatus);
			}

			if (artRegistrationDto.getHivStatusId() != null) {
				MasterHivStatus hivStatusId = mapToMasterHivStatus(artRegistrationDto.getHivStatusId());
				beneficiary.setHivStatusId(hivStatusId);
			}

			if (artRegistrationDto.getHivTypeId() != null) {
				MasterHivType hivTypeId = mapToMasterHivType(artRegistrationDto.getHivTypeId());
				beneficiary.setHivTypeId(hivTypeId);
			}

			if (artRegistrationDto.getStayingWithId() != null) {
				MasterStayingWith stayingWithId = mapToMasterStayingWith(artRegistrationDto.getStayingWithId());
				beneficiary.setStayingWithId(stayingWithId);
			}

			if (artRegistrationDto.getOccupationId() != null) {
				MasterOccupation masterOccupation = mapToMasterOccupation(artRegistrationDto.getOccupationId());
				beneficiary.setOccupationId(masterOccupation);
			}

			if (artRegistrationDto.getEducationLevelId() != null) {
				MasterEducationLevel educationLevelId = mapToMasterEducationLevel(
						artRegistrationDto.getEducationLevelId());
				beneficiary.setEducationLevelId(educationLevelId);
			}

			if (artRegistrationDto.getMasterEmploymentStatus() != null) {
				MasterEmploymentStatus employmentStatus = mapToMasterEmploymentStatus(
						artRegistrationDto.getMasterEmploymentStatus());
				beneficiary.setMasterEmploymentStatus(employmentStatus);
			}

		}
		return beneficiary;
	}

	public static ArtBeneficiary mapToArtBeneficiary(ArtRegistrationDto artRegistrationDto) {
		ArtBeneficiary artBeneficary = new ArtBeneficiary();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		artBeneficary.setUserId(userMaster);
		artBeneficary.setIsActive(Boolean.TRUE);
		artBeneficary.setIsDelete(Boolean.FALSE);
		artBeneficary.setArtEligibilityDate(artRegistrationDto.getArtEligibilityDate());
		artBeneficary.setArtRegistrationDate(artRegistrationDto.getArtRegistration_date());
		artBeneficary.setIsTransit(artRegistrationDto.getIsTransit());
		artBeneficary.setTransitStartDate(artRegistrationDto.getTransitStartDate());
		artBeneficary.setTransitEndDate(artRegistrationDto.getTransitEndDate());
		artBeneficary.setArtStartDate(artRegistrationDto.getArtStartDate());
		artBeneficary.setLacLinked(artRegistrationDto.getIsLinked());
		artBeneficary.setRecordCreationDate(artRegistrationDto.getArtRegistration_date());
		artBeneficary.setLinkageInstituteName(artRegistrationDto.getLinkageInstituteName());
		artBeneficary.setInfantRegisteredThroughEid(artRegistrationDto.getInfantRegisteredThroughEid());
		artBeneficary.setIsConsentTaken(artRegistrationDto.getIsConsentTaken());
		if (artRegistrationDto.getInfantBeneficiaryId() != null) {
			Beneficiary infantBeneficiary = new Beneficiary();
			infantBeneficiary.setId(artRegistrationDto.getInfantBeneficiaryId());
			artBeneficary.setInfantBeneficiaryId(infantBeneficiary);
		}
		if (artRegistrationDto.getInfantEidLabId() != null) {
			Facility infantEidLab = new Facility();
			infantEidLab.setId(artRegistrationDto.getInfantEidLabId());
			artBeneficary.setInfantEidLabId(infantEidLab);
		}

		if (artRegistrationDto.getLinkageOrganiationTypeId() != null) {
			MasterOrganisationType masterOrganisationType = new MasterOrganisationType();
			masterOrganisationType.setId(artRegistrationDto.getLinkageOrganiationTypeId());
			artBeneficary.setMasterOrganisationType(masterOrganisationType);
		}

		if (artRegistrationDto.getMasterArtTreatmentStatus() != null) {
			MasterArtTreatmentStatus masterArtTreatmentStatus = mapToMasterArtTreatmentStatus(
					artRegistrationDto.getMasterArtTreatmentStatus());
			artBeneficary.setMasterArtTreatmentStatus(masterArtTreatmentStatus);
		}
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficary.setFacility(facility);
		if (artRegistrationDto.getArtBeneficiaryStatusId() != null) {
			MasterArtBeneficiaryStatus masterArtBeneficiaryStatus = mapToMasterArtBeneficiaryStatus(
					artRegistrationDto.getArtBeneficiaryStatusId());
			artBeneficary.setMasterArtBeneficiaryStatus(masterArtBeneficiaryStatus);
		}

		if (artRegistrationDto.getEntryPointId() != null) {
			MasterEntryPoint entryPoint = mapToMasterEntryPoint(artRegistrationDto.getEntryPointId());
			artBeneficary.setEntryPointId(entryPoint);
		}

		if (artRegistrationDto.getMasterRiskFactor() != null) {
			MasterRiskFactor masterRiskFactor = mapToMasterRiskFactor(artRegistrationDto.getMasterRiskFactor());
			artBeneficary.setMasterRiskFactor(masterRiskFactor);
		}

		if (artRegistrationDto.getFourSScreening() != null) {
			MasterFourSScreening fourSScreening = mapToMasterFourSScreening(artRegistrationDto.getFourSScreening());
			artBeneficary.setFourSScreening(fourSScreening);
		}

		if (artRegistrationDto.getArtTransferredFrom() != null) {
			MasterBeneficiaryArtTransferredFrom artTransferredFrom = mapToMasterBeneficiaryArtTransferredFrom(
					artRegistrationDto.getArtTransferredFrom());
			artBeneficary.setMasterBeneficiaryArtTransferredFrom(artTransferredFrom);
		}

//		if (artRegistrationDto.getRegimenId() != null) {
//			Regimen regimen = mapToRegimenId(artRegistrationDto.getRegimenId());
//			artBeneficary.setRegimenId(regimen);
//		}

		return artBeneficary;
	}

	// method to set userId
	public static UserMaster mapToUserMasterDtoId(long userId) {
		UserMaster userMaster = new UserMaster();
		userMaster.setId(userId);
		return userMaster;
	}

	// method to set facilityId
	private static Facility mapToFacilityDtoId(long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	/**
	 * @param artRegistrationDto
	 * @return artBeneficiaryQueue
	 */
	public static ArtBeneficiaryQueue mapToBeneficiaryQueue(ArtRegistrationDto artRegistrationDto) {
		ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficiaryQueue.setEntryUser(userMaster);
		artBeneficiaryQueue.setFacility(facility);
		artBeneficiaryQueue.setVisitDate(DateUtil.getTodayDateInIST());
		UserMaster assignedUser = mapToUserMasterDtoId(artRegistrationDto.getAssignedTo());
		artBeneficiaryQueue.setAssignedToUser(assignedUser);
		artBeneficiaryQueue.setIsVisited(Boolean.FALSE);
		artBeneficiaryQueue.setIsActive(Boolean.TRUE);
		artBeneficiaryQueue.setIsDelete(Boolean.FALSE);
		return artBeneficiaryQueue;
	}

	/**
	 * @param beneficiaryArtStatus
	 * @return MasterArtBeneficiaryStatus
	 */
	public static MasterArtBeneficiaryStatus mapToMasterArtBeneficiaryStatus(long beneficiaryArtStatus) {
		MasterArtBeneficiaryStatus masterbeneficiaryArtStatus = new MasterArtBeneficiaryStatus();
		masterbeneficiaryArtStatus.setId(beneficiaryArtStatus);
		return masterbeneficiaryArtStatus;
	}

	/**
	 * @param genderId
	 * @return MasterGender
	 */
	public static MasterGender mapToMasterGender(long genderId) {
		MasterGender masterGender = new MasterGender();
		masterGender.setId(genderId);
		return masterGender;
	}

	/**
	 * @param categoryId
	 * @return MasterBeneficiaryCategory
	 */
	public static MasterBeneficiaryCategory mapToMasterBeneficiaryCategory(long categoryId) {
		MasterBeneficiaryCategory masterBeneficiaryCategory = new MasterBeneficiaryCategory();
		masterBeneficiaryCategory.setId(categoryId);
		return masterBeneficiaryCategory;
	}

	/**
	 * @param address
	 * @return Address
	 */
	public static Address mapToAddress(ArtRegistrationDto artRegistrationDto, State state, District district, Town town,
			Subdistrict subdistrict, Pincode pincode) {
		Address address = new Address();
		address.setAddressLineOne(artRegistrationDto.getAddressLineOne());
		address.setAddressLineTwo(artRegistrationDto.getAddressLineTwo());
		// address.setCity(artRegistrationDto.getCity());
		address.setDistrict(district);
		address.setCountry("India");
		address.setIsActive(true);
		address.setIsDelete(false);
		address.setPincodeEntity(pincode);
		if (pincode != null) {
			address.setPincode(pincode.getPincode());
		} else {
			address.setPincode(null);
		}
		address.setState(state);
		address.setSubdistrict(subdistrict);
		address.setTown(town);
		return address;
	}

	/**
	 * @param maritalStatusId
	 * @return MasterMaritalStatus
	 */
	public static MasterMaritalStatus mapToMasterMaritalStatus(long maritalStatusId) {
		MasterMaritalStatus masterMaritalStatus = new MasterMaritalStatus();
		masterMaritalStatus.setId(maritalStatusId);
		return masterMaritalStatus;
	}

	/**
	 * @param monthlyIncomeId
	 * @return MasterMonthlyIncome
	 */
	public static MasterMonthlyIncome mapToMasterMonthlyIncome(long monthlyIncomeId) {
		MasterMonthlyIncome masterMonthlyIncomes = new MasterMonthlyIncome();
		masterMonthlyIncomes.setId(monthlyIncomeId);
		return masterMonthlyIncomes;
	}

	/**
	 * @param hivTypeId
	 * @return MasterHivType
	 */
	public static MasterHivType mapToMasterHivType(long hivTypeId) {
		MasterHivType masterHivType = new MasterHivType();
		masterHivType.setId(hivTypeId);
		return masterHivType;
	}

	/**
	 * @param hivTypeId
	 * @return MasterStayingWith
	 */
	public static MasterStayingWith mapToMasterStayingWith(long stayingWithId) {
		MasterStayingWith stayingWith = new MasterStayingWith();
		stayingWith.setId(stayingWithId);
		return stayingWith;
	}

	/**
	 * @param hivTypeId
	 * @return MasterHivStatus
	 */
	public static MasterHivStatus mapToMasterHivStatus(long hivStatusId) {
		MasterHivStatus hivStatus = new MasterHivStatus();
		hivStatus.setId(hivStatusId);
		return hivStatus;
	}

	public static BeneficiaryFacilityMapping mapToBeneficiaryFacilityMapping(ArtRegistrationDto artRegistrationDto,
			Facility facility) {
		BeneficiaryFacilityMapping beneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
		if (artRegistrationDto != null) {
			beneficiaryFacilityMapping.setIsActive(true);
			beneficiaryFacilityMapping.setIsDelete(false);
			beneficiaryFacilityMapping.setFacility(facility);
			//beneficiaryFacilityMapping.setMappingDate(DateUtil.getTodayDateInIST());
			beneficiaryFacilityMapping.setMappingDate(artRegistrationDto.getDateTransferredIn());
			beneficiaryFacilityMapping.setPreArtNumber(artRegistrationDto.getPreArtNumber());
			beneficiaryFacilityMapping.setArtNumber(artRegistrationDto.getArtNumber());
			beneficiaryFacilityMapping.setPid(artRegistrationDto.getPatientPid());
			beneficiaryFacilityMapping.setArtPreviousClinic(artRegistrationDto.getPreviousClinic());
			beneficiaryFacilityMapping.setRegistrationDate(artRegistrationDto.getArtRegistration_date());
			if (artRegistrationDto.getPreviousNotTransferredArtId() != null) {
				Facility previousNotTransferredArtId = mapToFacilityDtoId(
						artRegistrationDto.getPreviousNotTransferredArtId());
				beneficiaryFacilityMapping.setPreviousNotTransferredArtId(previousNotTransferredArtId);
			}
		}
		return beneficiaryFacilityMapping;
	}

	/**
	 * @param artRegistrationDto
	 * @param beneficiaryVisitRegister2
	 * @return BeneficiaryDetailsPerVisit
	 */
	public static BeneficiaryVisitRegister mapToBeneficiaryVisitRegister(ArtRegistrationDto artRegistrationDto,
			BeneficiaryVisitRegister beneficiaryVisitRegister) {
		beneficiaryVisitRegister.setWeight(artRegistrationDto.getWeight());
		beneficiaryVisitRegister.setHeight(artRegistrationDto.getHeight());
		beneficiaryVisitRegister.setLmp(artRegistrationDto.getLmp());
		beneficiaryVisitRegister.setIsPregnant(artRegistrationDto.getIsPregnant());
		beneficiaryVisitRegister.setIsActive(true);
		beneficiaryVisitRegister.setIsDelete(false);
		beneficiaryVisitRegister.setVisitDate(DateUtil.getTodayDateInIST());
		if (artRegistrationDto.getDeliveryOutcomeId() != null) {
			MasterDeliveryOutcome deliveryOutcome = new MasterDeliveryOutcome();
			deliveryOutcome.setId(artRegistrationDto.getDeliveryOutcomeId());
			beneficiaryVisitRegister.setDeliveryOutcome(deliveryOutcome);
		}
		if (artRegistrationDto.getPregnantCaseTypeId() != null) {
			MasterPregnancyTypeCase masterPregnancyTypeCase = mapToMasterPregnancyTypeCase(
					artRegistrationDto.getPregnantCaseTypeId());
			beneficiaryVisitRegister.setMasterPregnancyTypeCase(masterPregnancyTypeCase);
		}
		return beneficiaryVisitRegister;
	}

	/**
	 * @param entryPointId
	 * @return MasterEntryPoint
	 */
	public static MasterEntryPoint mapToMasterEntryPoint(long entryPointId) {
		MasterEntryPoint masterEntryPoint = new MasterEntryPoint();
		masterEntryPoint.setId(entryPointId);
		return masterEntryPoint;
	}

	/**
	 * @param riskFactorId
	 * @return MasterRiskFactor
	 */
	public static MasterRiskFactor mapToMasterRiskFactor(long riskFactorId) {
		MasterRiskFactor masterRiskFactor = new MasterRiskFactor();
		masterRiskFactor.setId(riskFactorId);
		return masterRiskFactor;
	}

	/**
	 * @param occupationId
	 * @return MasterOccupation
	 */
	public static MasterOccupation mapToMasterOccupation(long occupationId) {
		MasterOccupation masterOccupation = new MasterOccupation();
		masterOccupation.setId(occupationId);
		return masterOccupation;
	}

	/**
	 * @param educationLevelId
	 * @return MasterEducationLevel
	 */
	public static MasterEducationLevel mapToMasterEducationLevel(long educationLevelId) {
		MasterEducationLevel masterEducationLevel = new MasterEducationLevel();
		masterEducationLevel.setId(educationLevelId);
		return masterEducationLevel;
	}

	/**
	 * @param masterEmploymentStatusId
	 * @return MasterEmploymentStatus
	 */
	public static MasterEmploymentStatus mapToMasterEmploymentStatus(long masterEmploymentStatusId) {
		MasterEmploymentStatus masterEmploymentStatus = new MasterEmploymentStatus();
		masterEmploymentStatus.setId(masterEmploymentStatusId);
		return masterEmploymentStatus;
	}

	/**
	 * @param pregnancyTypeCaseId
	 * @return MasterPregnancyTypeCase
	 */
	public static MasterPregnancyTypeCase mapToMasterPregnancyTypeCase(long pregnancyTypeCaseId) {
		MasterPregnancyTypeCase pregnancyTypeCase = new MasterPregnancyTypeCase();
		pregnancyTypeCase.setId(pregnancyTypeCaseId);
		return pregnancyTypeCase;
	}

	/**
	 * @param fourSScreeningId
	 * @return MasterFourSScreening
	 */
	public static MasterFourSScreening mapToMasterFourSScreening(long fourSScreeningId) {
		MasterFourSScreening fourSScreening = new MasterFourSScreening();
		fourSScreening.setId(fourSScreeningId);
		return fourSScreening;
	}

	/**
	 * @param regimenId
	 * @return Regimen
	 */
	public static Regimen mapToRegimenId(long regimenId) {
		Regimen regimen = new Regimen();
		regimen.setId(regimenId);
		return regimen;
	}

	/**
	 * @param masterArtTreatmentStatusId
	 * @return MasterArtTreatmentStatus
	 */
	public static MasterArtTreatmentStatus mapToMasterArtTreatmentStatus(long masterArtTreatmentStatusId) {
		MasterArtTreatmentStatus artTreatmentStatus = new MasterArtTreatmentStatus();
		artTreatmentStatus.setId(masterArtTreatmentStatusId);
		return artTreatmentStatus;
	}

	
	// edit ArtBeneficiary
	public static ArtBeneficiary mapToArtBeneficiary(ArtRegistrationDto artRegistrationDto,
			ArtBeneficiary artBeneficary) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		artBeneficary.setUserId(userMaster);
		artBeneficary.setIsActive(true);
		artBeneficary.setIsDelete(false);
		artBeneficary.setArtEligibilityDate(artRegistrationDto.getArtEligibilityDate());
		artBeneficary.setArtRegistrationDate(artRegistrationDto.getArtRegistration_date());
		artBeneficary.setIsTransit(artRegistrationDto.getIsTransit());
		artBeneficary.setTransitStartDate(artRegistrationDto.getTransitStartDate());
		artBeneficary.setTransitEndDate(artRegistrationDto.getTransitEndDate());
		artBeneficary.setArtStartDate(artRegistrationDto.getArtStartDate());
		artBeneficary.setLacLinked(artRegistrationDto.getIsLinked());
		artBeneficary.setRecordCreationDate(artRegistrationDto.getArtRegistration_date());
		artBeneficary.setLinkageInstituteName(artRegistrationDto.getLinkageInstituteName());
		artBeneficary.setInfantRegisteredThroughEid(artRegistrationDto.getInfantRegisteredThroughEid());
		artBeneficary.setIsConsentTaken(artRegistrationDto.getIsConsentTaken());
		if (artRegistrationDto.getInfantBeneficiaryId() != null) {
			Beneficiary infantBeneficiary = new Beneficiary();
			infantBeneficiary.setId(artRegistrationDto.getInfantBeneficiaryId());
			artBeneficary.setInfantBeneficiaryId(infantBeneficiary);
		}
		if (artRegistrationDto.getInfantEidLabId() != null) {
			Facility infantEidLab = new Facility();
			infantEidLab.setId(artRegistrationDto.getInfantEidLabId());
			artBeneficary.setInfantEidLabId(infantEidLab);
		}

		if (artRegistrationDto.getLinkageOrganiationTypeId() != null) {
			MasterOrganisationType masterOrganisationType = new MasterOrganisationType();
			masterOrganisationType.setId(artRegistrationDto.getLinkageOrganiationTypeId());
			artBeneficary.setMasterOrganisationType(masterOrganisationType);
		}
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficary.setFacility(facility);
		if (artRegistrationDto.getArtBeneficiaryStatusId() != null) {
			MasterArtBeneficiaryStatus masterArtBeneficiaryStatus = mapToMasterArtBeneficiaryStatus(
					artRegistrationDto.getArtBeneficiaryStatusId());
			artBeneficary.setMasterArtBeneficiaryStatus(masterArtBeneficiaryStatus);
		}
		if (artRegistrationDto.getMasterArtTreatmentStatus() != null) {
			MasterArtTreatmentStatus masterArtTreatmentStatus = mapToMasterArtTreatmentStatus(
					artRegistrationDto.getMasterArtTreatmentStatus());
			artBeneficary.setMasterArtTreatmentStatus(masterArtTreatmentStatus);
		}
		if (artRegistrationDto.getEntryPointId() != null) {
			MasterEntryPoint entryPoint = mapToMasterEntryPoint(artRegistrationDto.getEntryPointId());
			artBeneficary.setEntryPointId(entryPoint);
		}

		if (artRegistrationDto.getMasterRiskFactor() != null) {
			MasterRiskFactor masterRiskFactor = mapToMasterRiskFactor(artRegistrationDto.getMasterRiskFactor());
			artBeneficary.setMasterRiskFactor(masterRiskFactor);
		}
		if (artRegistrationDto.getFourSScreening() != null) {
			MasterFourSScreening fourSScreening = mapToMasterFourSScreening(artRegistrationDto.getFourSScreening());
			artBeneficary.setFourSScreening(fourSScreening);
		}
//		if (artRegistrationDto.getRegimenId() != null) {
//			Regimen regimen = mapToRegimenId(artRegistrationDto.getRegimenId());
//			artBeneficary.setRegimenId(regimen);
//		}
		if (artRegistrationDto.getArtTransferredFrom() != null) {
			MasterBeneficiaryArtTransferredFrom artTransferredFrom = mapToMasterBeneficiaryArtTransferredFrom(
					artRegistrationDto.getArtTransferredFrom());
			artBeneficary.setMasterBeneficiaryArtTransferredFrom(artTransferredFrom);
		}
		return artBeneficary;
	}

	private static MasterBeneficiaryArtTransferredFrom mapToMasterBeneficiaryArtTransferredFrom(
			long artTransferredFromId) {
		MasterBeneficiaryArtTransferredFrom artTransferredFrom = new MasterBeneficiaryArtTransferredFrom();
		artTransferredFrom.setId(artTransferredFromId);
		return artTransferredFrom;
	}

	// edit address
	public static Address mapToAddress(Address address, ArtRegistrationDto artRegistrationDto, State state,
			District district, Town town, Subdistrict subdistrict, Pincode pincode) {
		address.setAddressLineOne(artRegistrationDto.getAddressLineOne());
		address.setAddressLineTwo(artRegistrationDto.getAddressLineTwo());
		// address.setCity(artRegistrationDto.getCity());
		address.setDistrict(district);
		address.setCountry("India");
		address.setIsActive(true);
		address.setIsDelete(false);
		address.setPincodeEntity(pincode);
		if (pincode != null) {
			address.setPincode(pincode.getPincode());
		} else {
			address.setPincode(null);
		}
		address.setState(state);
		address.setSubdistrict(subdistrict);
		address.setTown(town);
		return address;
	}

	// edit beneficiary
	public static Beneficiary maptoBeneficiary(ArtRegistrationDto artRegistrationDto, Beneficiary beneficiary) {
		if (artRegistrationDto != null) {
			beneficiary.setFirstName(artRegistrationDto.getFirstName());
			beneficiary.setIsActive(true);
			beneficiary.setIsDelete(false);
			beneficiary.setMiddleName(artRegistrationDto.getMiddleName());
			beneficiary.setLastName(artRegistrationDto.getLastName());
			beneficiary.setMobileNumber(artRegistrationDto.getContactNumber());
			beneficiary.setDateOfBirth(artRegistrationDto.getBirthDate());
			beneficiary.setAge(artRegistrationDto.getAge());
			beneficiary.setAadharNumber(artRegistrationDto.getAadharNumber());
			beneficiary.setPreArtNumber(artRegistrationDto.getPreArtNumber());
			beneficiary.setArtNumber(artRegistrationDto.getArtNumber());
			beneficiary.setAlternatePhonenumber(artRegistrationDto.getAlternatePhoneNumber());
			beneficiary.setCaregiverName(artRegistrationDto.getCaregiverName());
			beneficiary.setCaregiverPhoneNumber(artRegistrationDto.getCaregiverPhoneNumber());
			beneficiary.setDeathDate(artRegistrationDto.getDeathDate());
			beneficiary.setDeathReason(artRegistrationDto.getDeathReason());
			beneficiary.setBankAccountName(artRegistrationDto.getBankAccountName());
			beneficiary.setBankAccountNumber(artRegistrationDto.getBankAccountNumber());
			beneficiary.setBankIfsc(artRegistrationDto.getBankIfsc());
			beneficiary.setClosePersonName(artRegistrationDto.getClosePersonName());
			if(artRegistrationDto.getMasterClosePersonRelationType()!=null) {
				MasterRelationType relationType=new MasterRelationType();
				relationType.setId(artRegistrationDto.getMasterClosePersonRelationType());
				beneficiary.setMasterRelationType(relationType);	
			}
			if (artRegistrationDto.getGenderId() != null) {
				MasterGender gender = mapToMasterGender(artRegistrationDto.getGenderId());
				beneficiary.setGenderId(gender);
			}
			if (artRegistrationDto.getCategoryId() != null) {
				MasterBeneficiaryCategory beneficiaryCategory = mapToMasterBeneficiaryCategory(
						artRegistrationDto.getCategoryId());
				beneficiary.setCategoryId(beneficiaryCategory);
			}
			if (artRegistrationDto.getMonthlyIncome() != null) {
				MasterMonthlyIncome masterMonthlyIncome = mapToMasterMonthlyIncome(
						artRegistrationDto.getMonthlyIncome());
				beneficiary.setMonthlyIncomeId(masterMonthlyIncome);
			}
			if (artRegistrationDto.getMaritalStatusId() != null) {
				MasterMaritalStatus maritalStatus = mapToMasterMaritalStatus(artRegistrationDto.getMaritalStatusId());
				beneficiary.setMaritalStatusId(maritalStatus);
			}

			if (artRegistrationDto.getHivStatusId() != null) {
				MasterHivStatus hivStatusId = mapToMasterHivStatus(artRegistrationDto.getHivStatusId());
				beneficiary.setHivStatusId(hivStatusId);
			}

			if (artRegistrationDto.getHivTypeId() != null) {
				MasterHivType hivTypeId = mapToMasterHivType(artRegistrationDto.getHivTypeId());
				beneficiary.setHivTypeId(hivTypeId);
			}

			if (artRegistrationDto.getStayingWithId() != null) {
				MasterStayingWith stayingWithId = mapToMasterStayingWith(artRegistrationDto.getStayingWithId());
				beneficiary.setStayingWithId(stayingWithId);
			}

			if (artRegistrationDto.getOccupationId() != null) {
				MasterOccupation masterOccupation = mapToMasterOccupation(artRegistrationDto.getOccupationId());
				beneficiary.setOccupationId(masterOccupation);
			}

			if (artRegistrationDto.getEducationLevelId() != null) {
				MasterEducationLevel educationLevelId = mapToMasterEducationLevel(
						artRegistrationDto.getEducationLevelId());
				beneficiary.setEducationLevelId(educationLevelId);
			}

			if (artRegistrationDto.getMasterEmploymentStatus() != null) {
				MasterEmploymentStatus employmentStatus = mapToMasterEmploymentStatus(
						artRegistrationDto.getMasterEmploymentStatus());
				beneficiary.setMasterEmploymentStatus(employmentStatus);
			}
		}
		return beneficiary;
	}

	/**
	 * @return FacilityLinkedFacilityBeneficiary
	 */
	public static FacilityLinkedFacilityBeneficiary mapToFacilityLinkedFacilityBeneficiary(
			ArtRegistrationDto artRegistrationDto) {
		FacilityLinkedFacilityBeneficiary linkedFacilityBeneficiary = new FacilityLinkedFacilityBeneficiary();
		if (artRegistrationDto.getIsLinked() == true) {
			linkedFacilityBeneficiary.setIsActive(true);
			linkedFacilityBeneficiary.setIsDelete(false);
			linkedFacilityBeneficiary.setIsLinked(artRegistrationDto.getIsLinked());
			LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
			FacilityType facilityType = mapToFacilityTypeId(loginResponseDto.getFacilityTypeId());
			linkedFacilityBeneficiary.setFacilityTypeBean(facilityType);
			Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
			linkedFacilityBeneficiary.setParentFacility(facility);
			if (artRegistrationDto.getLinkedFacilityId() != null) {
				Facility LACfacility = mapToFacilityDtoId(artRegistrationDto.getLinkedFacilityId());
				linkedFacilityBeneficiary.setLinkedFacilityId(LACfacility);
			}

		} else {
			linkedFacilityBeneficiary.setIsActive(false);
			linkedFacilityBeneficiary.setIsLinked(artRegistrationDto.getIsLinked());
		}
		return linkedFacilityBeneficiary;
	}

	/**
	 * @param facilityTypeId
	 * @return FacilityType
	 */
	public static FacilityType mapToFacilityTypeId(long facilityTypeId) {
		FacilityType facilityType = new FacilityType();
		facilityType.setId(facilityTypeId);
		return facilityType;
	}

	/**
	 * @param linkedFacilityBeneficiaryId
	 * @return LinkedFacilityBeneficiary
	 */
	public static LinkedFacilityBeneficiary mapToLinkedFacilityBeneficiary(long linkedFacilityBeneficiaryId) {
		LinkedFacilityBeneficiary facilityBeneficiary = new LinkedFacilityBeneficiary();
		facilityBeneficiary.setId(linkedFacilityBeneficiaryId);
		return facilityBeneficiary;
	}

	/**
	 * 
	 * @return Transfer
	 */
	public static Transfer mapToTransfer(ArtRegistrationDto artRegistrationDto) {
		Transfer artPatientTransfer = new Transfer();
		artPatientTransfer.setDestinationFacilityType(artRegistrationDto.getDestinationFacilityType());
		if (artRegistrationDto.getDestinationFacilityId() != null) {
			Facility facility = mapToFacilityDtoId(artRegistrationDto.getDestinationFacilityId());
			artPatientTransfer.setFacilityTo(facility);
		}
		artPatientTransfer.setIsActive(true);
		artPatientTransfer.setIsDeleted(false);
		artPatientTransfer.setInitiationDate(DateUtil.getTodayDateInIST());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		FacilityType facilityType = mapToFacilityTypeId(loginResponseDto.getFacilityTypeId());
		artPatientTransfer.setSourceFacilityType(facilityType.getFacilityTypeName());
		// artPatientTransfer.setSourceFacilityType(Objects.toString(facilityType.getFacilityTypeName()));
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artPatientTransfer.setFacilityFrom(facility);
		return artPatientTransfer;

	}

	/**
	 * @return BeneficiaryReferral
	 */
	public static BeneficiaryReferral mapToBeneficiaryReferral(ArtRegistrationDto artRegistrationDto) {
		BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
		beneficiaryReferral.setIsActive(true);
		beneficiaryReferral.setIsDelete(false);
		beneficiaryReferral.setReferDate(DateUtil.getTodayDateInIST());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		beneficiaryReferral.setFacility1(facility);
		if (artRegistrationDto.getReferTo() != null) {
			Facility referFacility = mapToFacilityDtoId(artRegistrationDto.getReferTo());
			beneficiaryReferral.setFacility2(referFacility);
		}
		MasterReferralStatus masterReferralStatus = new MasterReferralStatus();
		masterReferralStatus.setId(RefferalStatusEnum.Pending.getReferalStatus());
		beneficiaryReferral.setBeneficiaryReferralStatusMaster(masterReferralStatus);
		return beneficiaryReferral;
	}

	/**
	 * @return BeneficiaryTransitFacility
	 */
	public static List<BeneficiaryTransitFacility> mapToBeneficiaryTransitFacility(
			ArtRegistrationDto artRegistrationDto) {
		List<BeneficiaryTransitFacility> beneficiaryTransitFacilityList = new ArrayList<BeneficiaryTransitFacility>();
		List<Long> transistFacilityId = artRegistrationDto.getTransistFacilityId();
		if (transistFacilityId != null && !transistFacilityId.isEmpty()) {
			for (Long facilityId : transistFacilityId) {
				BeneficiaryTransitFacility beneficiaryTransitFacility = new BeneficiaryTransitFacility();
				Facility facility = mapToFacilityDtoId(facilityId);
				beneficiaryTransitFacility.setFacility(facility);
				beneficiaryTransitFacility.setIsActive(true);
				beneficiaryTransitFacility.setIsDelete(false);
				//beneficiaryTransitFacility.setStatus("PENDING");
				beneficiaryTransitFacilityList.add(beneficiaryTransitFacility);
			}
		}
		return beneficiaryTransitFacilityList;
	}

	// edit BeneficiaryFacilityMapping
	public static BeneficiaryFacilityMapping mapToBeneficiaryFacilityMapping(ArtRegistrationDto artRegistrationDto,
			Facility facility, BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		beneficiaryFacilityMapping.setIsActive(true);
		beneficiaryFacilityMapping.setIsDelete(false);
		beneficiaryFacilityMapping.setFacility(facility);
		//beneficiaryFacilityMapping.setMappingDate(DateUtil.getTodayDateInIST());
		beneficiaryFacilityMapping.setMappingDate(artRegistrationDto.getDateTransferredIn());
		beneficiaryFacilityMapping.setPreArtNumber(artRegistrationDto.getPreArtNumber());
		beneficiaryFacilityMapping.setArtNumber(artRegistrationDto.getArtNumber());
		beneficiaryFacilityMapping.setPid(artRegistrationDto.getPatientPid());
		beneficiaryFacilityMapping.setArtPreviousClinic(artRegistrationDto.getPreviousClinic());
		beneficiaryFacilityMapping.setRegistrationDate(artRegistrationDto.getArtRegistration_date());
		if (artRegistrationDto.getPreviousNotTransferredArtId() != null) {
			Facility previousNotTransferredArtId = mapToFacilityDtoId(
					artRegistrationDto.getPreviousNotTransferredArtId());
			beneficiaryFacilityMapping.setPreviousNotTransferredArtId(previousNotTransferredArtId);
		}
		return beneficiaryFacilityMapping;
	}

	public static ArtBeneficiaryDueList mapToBeneficiaryArtBeneficiaryDueList(ArtRegistrationDto artRegistrationDto) {
		ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
		artBeneficiaryDueList.setIsDelete(false);
		artBeneficiaryDueList.setIsVisited(false);
		artBeneficiaryDueList.setIsActive(true);
		artBeneficiaryDueList.setExpectedVisitDate(artRegistrationDto.getNextVisitDate());
		artBeneficiaryDueList.setVisitedDate(LocalDate.now());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		artBeneficiaryDueList.setEntryUser(userMaster);
		return artBeneficiaryDueList;
	}

	public static ArtBeneficiaryDueList mapToBeneficiaryArtBeneficiaryDueList(ArtRegistrationDto artRegistrationDto,
			ArtBeneficiaryDueList artBeneficiaryDueList) {
		artBeneficiaryDueList.setIsDelete(false);
		artBeneficiaryDueList.setIsVisited(false);
		artBeneficiaryDueList.setIsActive(true);
		artBeneficiaryDueList.setVisitedDate(LocalDate.now());
		artBeneficiaryDueList.setExpectedVisitDate(artRegistrationDto.getNextVisitDate());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		artBeneficiaryDueList.setEntryUser(userMaster);
		return artBeneficiaryDueList;
	}

	public static BeneficiaryVisitRegister mapToBeneficiaryVisitRegister(ArtRegistrationDto artRegistrationDto) {
		BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
		beneficiaryVisitRegister.setWeight(artRegistrationDto.getWeight());
		beneficiaryVisitRegister.setHeight(artRegistrationDto.getHeight());
		beneficiaryVisitRegister.setLmp(artRegistrationDto.getLmp());
		beneficiaryVisitRegister.setIsPregnant(artRegistrationDto.getIsPregnant());
		beneficiaryVisitRegister.setIsActive(true);
		beneficiaryVisitRegister.setIsDelete(false);
		beneficiaryVisitRegister.setVisitDate(DateUtil.getTodayDateInIST());

		if (artRegistrationDto.getDeliveryOutcomeId() != null) {
			MasterDeliveryOutcome deliveryOutcome = new MasterDeliveryOutcome();
			deliveryOutcome.setId(artRegistrationDto.getDeliveryOutcomeId());
			beneficiaryVisitRegister.setDeliveryOutcome(deliveryOutcome);
		}

		if (artRegistrationDto.getPregnantCaseTypeId() != null) {
			MasterPregnancyTypeCase masterPregnancyTypeCase = mapToMasterPregnancyTypeCase(
					artRegistrationDto.getPregnantCaseTypeId());
			beneficiaryVisitRegister.setMasterPregnancyTypeCase(masterPregnancyTypeCase);
		}
		return beneficiaryVisitRegister;
	}

	public static List<ArtBeneficiaryLinkagePurposes> mapToArtBeneficiaryLinkagePurposes(
			ArtRegistrationDto artRegistrationDto) {
		List<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposesList = new ArrayList<ArtBeneficiaryLinkagePurposes>();
		List<Long> linkagePurposeId = artRegistrationDto.getLinkagePurposesId();
		if (linkagePurposeId != null && !linkagePurposeId.isEmpty()) {
			for (Long purpose : linkagePurposeId) {
				ArtBeneficiaryLinkagePurposes linkagePurposes = new ArtBeneficiaryLinkagePurposes();
				linkagePurposes.setIsActive(Boolean.TRUE);
				linkagePurposes.setIsDelete(Boolean.FALSE);
				MasterPurpos masterPurpos = new MasterPurpos();
				masterPurpos.setId(purpose);
				linkagePurposes.setMasterPurpos(masterPurpos);
				artBeneficiaryLinkagePurposesList.add(linkagePurposes);
			}
		}
		return artBeneficiaryLinkagePurposesList;

	}

	public static ArtBeneficiaryClinicalDetail mapToArtBeneficiaryClinicalDetail(
			ArtRegistrationDto artRegistrationDto) {
		ArtBeneficiaryClinicalDetail clinicalDetail = new ArtBeneficiaryClinicalDetail();
		clinicalDetail.setIsActive(Boolean.TRUE);
		clinicalDetail.setIsDelete(Boolean.FALSE);
		clinicalDetail.setPapSmear(artRegistrationDto.getPapSmear());
		clinicalDetail.setIspptctReferred(artRegistrationDto.getPptctReferred());
		clinicalDetail.setPptctPregnancyRemarks(artRegistrationDto.getPptctPregnancyRemarks());
		if (artRegistrationDto.getMasterTreatmentLine() != null) {
			MasterTreatmentLine treatmentLine = new MasterTreatmentLine();
			treatmentLine.setId(artRegistrationDto.getMasterTreatmentLine());
			clinicalDetail.setMasterTreatmentLine(treatmentLine);
		}
		return clinicalDetail;
	}

	public static List<BeneficiarySocialWelfareScheme> mapToBeneficiarySocialWelfareScheme(
			ArtRegistrationDto artRegistrationDto) {
		List<BeneficiarySocialWelfareScheme> welfareSchemesList = new ArrayList<BeneficiarySocialWelfareScheme>();
		List<Long> welfareSchemesIds = artRegistrationDto.getMasterSocialWelfare();
		if (welfareSchemesIds != null && !welfareSchemesIds.isEmpty()) {
			for (Long schemes : welfareSchemesIds) {
				BeneficiarySocialWelfareScheme socialWelfareScheme = new BeneficiarySocialWelfareScheme();
				socialWelfareScheme.setIsActive(Boolean.TRUE);
				socialWelfareScheme.setIsDelete(Boolean.FALSE);
				MasterSocialWelfare masterSocialWelfare = new MasterSocialWelfare();
				masterSocialWelfare.setId(schemes);
				socialWelfareScheme.setMasterSocialWelfare(masterSocialWelfare);
				welfareSchemesList.add(socialWelfareScheme);
			}
		}
		return welfareSchemesList;
	}

	public static IctcBeneficiary mapToIctcBeneficiary(ArtRegistrationDto artRegistrationDto) {
		IctcBeneficiary ictcBeneficiary=new IctcBeneficiary();
		ictcBeneficiary.setIsActive(Boolean.TRUE);
		ictcBeneficiary.setIsDeleted(Boolean.FALSE);
		ictcBeneficiary.setPid(artRegistrationDto.getPatientPid());
		if(artRegistrationDto.getIctcCenters()!=null) {
			Facility ictcCenter=mapToFacilityDtoId(artRegistrationDto.getIctcCenters());
			ictcBeneficiary.setFacility(ictcCenter);
		}
		return ictcBeneficiary;
	}

	public static IctcBeneficiary mapToIctcBeneficiary(ArtRegistrationDto artRegistrationDto,
			IctcBeneficiary ictcBeneficiary) {
		ictcBeneficiary.setIsActive(Boolean.TRUE);
		ictcBeneficiary.setIsDeleted(Boolean.FALSE);
		ictcBeneficiary.setPid(artRegistrationDto.getPatientPid());
		if(artRegistrationDto.getIctcCenters()!=null) {
			Facility ictcCenter=mapToFacilityDtoId(artRegistrationDto.getIctcCenters());
			ictcBeneficiary.setFacility(ictcCenter);
		}
		return ictcBeneficiary;
	}

}