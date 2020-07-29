package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ArtRegistrationDto;
import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.dto.BeneficiaryRegistrationDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.IctcDetail;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.projection.ReferralProjection;

public class BeneficiaryRegistrationMapper {

	// 1. method to map BeneficiaryRegistrationDto class to
	// BeneficiaryRegistration
	// class
	/*public static BeneficiaryRegistration mapToBeneficiaryReg(BeneficiaryRegistrationDto beneficiaryRegistrationDto) {
		BeneficiaryRegistration beneficiaryRegistration = new BeneficiaryRegistration();

		if (beneficiaryRegistrationDto != null) {

			beneficiaryRegistration.setAddiction(beneficiaryRegistrationDto.getAddiction());
			beneficiaryRegistration.setAlcoholConsume(beneficiaryRegistrationDto.getAlcoholConsume());
			beneficiaryRegistration.setAverageNumberofSexualActsUponRegistration(
					beneficiaryRegistrationDto.getAverageNumberofSexualActsUponRegistration());
			beneficiaryRegistration.setClientStatus(beneficiaryRegistrationDto.getClientStatus());
			beneficiaryRegistration.setCondomUsage(beneficiaryRegistrationDto.getCondomUsage());
			beneficiaryRegistration.setConsentDocumented(beneficiaryRegistrationDto.getConsentDocumented());
			beneficiaryRegistration.setDateOfRegistration(beneficiaryRegistrationDto.getDateOfRegistration());
			beneficiaryRegistration.setDurationOfTheStays(beneficiaryRegistrationDto.getDurationOfTheStays());
			beneficiaryRegistration.setFacilityCode(beneficiaryRegistrationDto.getFacilityCode());
			beneficiaryRegistration.setHrgPrimaryCategory(beneficiaryRegistrationDto.getHrgPrimaryCategory());
			beneficiaryRegistration.setHrgSecondaryCategory(beneficiaryRegistrationDto.getHrgSecondaryCategory());
			beneficiaryRegistration.setIsActive(beneficiaryRegistrationDto.getIsActive());
			beneficiaryRegistration.setIsBeneficiary(beneficiaryRegistrationDto.getIsBeneficiary());
			beneficiaryRegistration.setIsDelete(beneficiaryRegistrationDto.getIsDelete());
			beneficiaryRegistration.setNoOfSexualActivity(beneficiaryRegistrationDto.getNoOfSexualActivity());
			beneficiaryRegistration.setNumberOfPartners(beneficiaryRegistrationDto.getNumberOfPartners());
			beneficiaryRegistration.setNumberOfYearsInSexWork(beneficiaryRegistrationDto.getNumberOfYearsInSexWork());
			beneficiaryRegistration.setOutsideTheStateNoOfDays(beneficiaryRegistrationDto.getOutsideTheStateNoOfDays());
			beneficiaryRegistration
					.setOutsideTheStateNoOfTimes(beneficiaryRegistrationDto.getOutsideTheStateNoOfTimes());
			beneficiaryRegistration.setRegistrationPlace(beneficiaryRegistrationDto.getRegistrationPlace());
			beneficiaryRegistration.setRegularPartners(beneficiaryRegistrationDto.getRegularPartners());
			beneficiaryRegistration.setSexOtherThanSpouse(beneficiaryRegistrationDto.getSexOtherThanSpouse());
			beneficiaryRegistration.setStayingWith(beneficiaryRegistrationDto.getStayingWith());
			beneficiaryRegistration.setSubCategory(beneficiaryRegistrationDto.getSubCategory());
			beneficiaryRegistration.setTypeOfMobility(beneficiaryRegistrationDto.getTypeOfMobility());
			// beneficiaryRegistration.setViewPastActivity(beneficiaryRegistrationDto.getViewPastActivity());
			beneficiaryRegistration
					.setWithinTheDistrictNoOfDays(beneficiaryRegistrationDto.getWithinTheDistrictNoOfDays());
			beneficiaryRegistration
					.setWithinTheDistrictNoOfTimes(beneficiaryRegistrationDto.getWithinTheDistrictNoOfTimes());
			beneficiaryRegistration.setWithinTheStateNoOfDays(beneficiaryRegistrationDto.getWithinTheStateNoOfDays());
			beneficiaryRegistration.setWithinTheStateNoOfTimes(beneficiaryRegistrationDto.getWithinTheStateNoOfTimes());
			beneficiaryRegistration.setHowManyDaysAWeekIfAlcoholConsuming(
					beneficiaryRegistrationDto.getHowManyDaysAWeekIfAlcoholConsuming());

			beneficiaryRegistration.setTransitEndDate(beneficiaryRegistrationDto.getTransitEndDate());
			beneficiaryRegistration.setTransitStartDate(beneficiaryRegistrationDto.getTransitStartDate());
			beneficiaryRegistration.setIsTransit(beneficiaryRegistrationDto.getIsTransit());

			beneficiaryRegistration.setOutwardReferal(beneficiaryRegistrationDto.isOutwardReferal());
			beneficiaryRegistration.setInwardReferal(beneficiaryRegistrationDto.isInwardReferal());
			beneficiaryRegistration.setTransferInReferal(beneficiaryRegistrationDto.isTransferInReferal());
			beneficiaryRegistration.setTransferOutDueForTransferReferal(
					beneficiaryRegistrationDto.isTransferOutDueForTransferReferal());
			beneficiaryRegistration
					.setTransferOutTransferredReferal(beneficiaryRegistrationDto.isTransferOutTransferredReferal());
			beneficiaryRegistration.setTransitReferal(beneficiaryRegistrationDto.isTransferInReferal());

			if (beneficiaryRegistrationDto.getBeneficiaryId() != null) {
				Beneficiary beneficiary = null;
				beneficiary = BeneficiaryMapperUtil.mapToBeneficiaryId(beneficiaryRegistrationDto.getBeneficiaryId());
				beneficiaryRegistration.setBeneficiary(beneficiary);
			}
			beneficiaryRegistration.setId(beneficiaryRegistrationDto.getId());
		}
		return beneficiaryRegistration;
	}*/

	// 2. method to map BeneficiaryRegistrationDto class to Beneficiary class
	public static Beneficiary maptoBeneficiary(BeneficiaryRegistrationDto beneficiaryRegistrationDto) {

		Beneficiary beneficiary = new Beneficiary();
		if (beneficiaryRegistrationDto != null) {

			beneficiary.setAge(beneficiaryRegistrationDto.getAge());
			//beneficiary.setBarcode(beneficiaryRegistrationDto.getBarcode());
			beneficiary.setBeneficiaryType(beneficiaryRegistrationDto.getBeneficiaryType());
			//beneficiary.setDateOfBirth(beneficiaryRegistrationDto.getDateOfBirth());
			beneficiary.setEducationLevel(beneficiaryRegistrationDto.getEducationLevel());
			beneficiary.setEmploymentStatus(beneficiaryRegistrationDto.getEmploymentStatus());
			//beneficiary.setOtherEmploymentStatus(beneficiaryRegistrationDto.getOtherEmploymentStatus());
			beneficiary.setFirstName(beneficiaryRegistrationDto.getFirstName());
			beneficiary.setGender(beneficiaryRegistrationDto.getGender());
			beneficiary.setIsActive(beneficiaryRegistrationDto.getIsActive());
			beneficiary.setIsDelete(beneficiaryRegistrationDto.getIsDelete());
			//beneficiary.setIsPlhiv(beneficiaryRegistrationDto.getIsPlhiv());
			beneficiary.setLastName(beneficiaryRegistrationDto.getLastName());
			beneficiary.setMaritalStatus(beneficiaryRegistrationDto.getMaritalStatus());
			beneficiary.setMiddleName(beneficiaryRegistrationDto.getMiddleName());
			beneficiary.setMobileNumber(beneficiaryRegistrationDto.getMobileNumber());
			beneficiary.setOccupation(beneficiaryRegistrationDto.getOccupation());
			beneficiary.setStatus(beneficiaryRegistrationDto.getStatus());
			beneficiary.setUid(beneficiaryRegistrationDto.getUidNumber());
			beneficiary.setBeneficiaryActivityStatus(beneficiaryRegistrationDto.getBeneficiaryActivityStatus());
			//beneficiary.setTiCode(beneficiaryRegistrationDto.getTiCode());
			// beneficiary.setOstCode(beneficiaryRegistrationDto.getOstCode());
			beneficiary.setId(beneficiaryRegistrationDto.getBeneficiaryId());
		}
		return beneficiary;
	}

	// 3. method to map BeneficiaryRegistrationDto class to
	// BeneficiaryFacilityMapping class
	public static BeneficiaryFacilityMapping mapToBeneficiaryFacilityMapping(
			BeneficiaryRegistrationDto beneficiaryRegistrationDto) {

		BeneficiaryFacilityMapping beneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
		if (beneficiaryRegistrationDto != null) {

			beneficiaryFacilityMapping.setIsActive(beneficiaryRegistrationDto.getIsActive());
			beneficiaryFacilityMapping.setIsDelete(beneficiaryRegistrationDto.getIsDelete());
			// beneficiaryFacilityMapping.setId(beneficiaryRegistrationDto.getBeneficiaryFacilityMapId());

			Facility facility = new Facility();
			if (beneficiaryRegistrationDto.getFacilityId() != null) {
				facility = mapToFacilityDtoId(beneficiaryRegistrationDto.getFacilityId());
			}
			beneficiaryFacilityMapping.setFacility(facility);

		}
		return beneficiaryFacilityMapping;
	}

	// Function to set facilityId
	private static Facility mapToFacilityDtoId(long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	// 6. to map BeneficiaryRegistrationDto class to Address class
	public static Address maptoAddress(BeneficiaryRegistrationDto beneficiaryRegistrationDto) {

		Address address = new Address();
		if (beneficiaryRegistrationDto != null) {

			address.setBlock(beneficiaryRegistrationDto.getBlock());
			address.setHouseNo(beneficiaryRegistrationDto.getHouseNo());
			address.setPincode(beneficiaryRegistrationDto.getPincode());
			address.setIsActive(beneficiaryRegistrationDto.getIsActive());
			address.setIsDelete(beneficiaryRegistrationDto.getIsDelete());
			address.setId(beneficiaryRegistrationDto.getAddressId());
		}
		return address;
	}




	// 9. method to set userId
	private static UserMaster mapToUserMasterDtoId(long userId) {
		UserMaster userMaster = new UserMaster();
		userMaster.setId(userId);
		return userMaster;

	}

	// 12. method to map list of ChildrenAgeGenderMapping to list of
	// ChildrenAgeGenderMappingDto
	// 14. method to map list of referrals and transfers in to DTO class
	public static List<BeneficiaryRegistrationDto> mapToBeneficiaryReferralDto(List<ReferralProjection> beneficiaries) {
		List<BeneficiaryRegistrationDto> beneficiaryRegDtos = new ArrayList<BeneficiaryRegistrationDto>();
		if (!CollectionUtils.isEmpty(beneficiaries)) {
			beneficiaries.forEach(beneficiaryRegistration -> {

				BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();

				beneficiaryRegistrationDto.setAge(beneficiaryRegistration.getAge());
				beneficiaryRegistrationDto.setFirstName(beneficiaryRegistration.getFirstName());
				beneficiaryRegistrationDto.setGender(beneficiaryRegistration.getGender());
				beneficiaryRegistrationDto.setLastName(beneficiaryRegistration.getLastName());
				beneficiaryRegistrationDto.setMiddleName(beneficiaryRegistration.getMiddleName());
				beneficiaryRegistrationDto.setMobileNumber(beneficiaryRegistration.getMobileNumber());
				beneficiaryRegistrationDto.setUidNumber(beneficiaryRegistration.getUid());
				beneficiaryRegistrationDto.setBeneficiaryId(beneficiaryRegistration.getBeneficiaryId());
				beneficiaryRegistrationDto.setReferralFacility(beneficiaryRegistration.getReferralFacility());
				beneficiaryRegistrationDto.setReferralStatus(beneficiaryRegistration.getReferralStatus());
				beneficiaryRegistrationDto.setReferredFacility(beneficiaryRegistration.getReferredFacility());
				beneficiaryRegistrationDto.setTransferDate(beneficiaryRegistration.getTransferDate());
				beneficiaryRegistrationDto.setTransferFrom(beneficiaryRegistration.getTransferFrom());
				beneficiaryRegistrationDto.setTransferTo(beneficiaryRegistration.getTransferStatus());
				beneficiaryRegistrationDto.setTransferStatus(beneficiaryRegistration.getTransferTo());
				beneficiaryRegistrationDto.setDateOfReferral(beneficiaryRegistration.getDateOfReferral());
				beneficiaryRegistrationDto.setBeneficiaryId(beneficiaryRegistration.getId());
				beneficiaryRegDtos.add(beneficiaryRegistrationDto);
			});
		}
		return beneficiaryRegDtos;
	}

	public static Address maptoAddress(ArtRegistrationDto artRegistrationDto, State state, District district) {

		Address address = new Address();
		if (artRegistrationDto != null) {
			if (artRegistrationDto.getDistrict() != null) {
				address.setDistrict(district);
				address.setBlock(artRegistrationDto.getBlock());
				address.setHouseNo(artRegistrationDto.getHouseNumber());
				address.setPincode(artRegistrationDto.getPinCode());
				address.setState(state);

				// address.setCreatedBy(1);
				// address.setCreatedTime(DateUtil.getCurrentUTCDateTime());
				address.setIsActive(true);
				address.setIsDelete(false);
				// address.setModifiedBy(1);
				// address.setModifiedTime(DateUtil.getCurrentUTCDateTime());
				// address.setId(artRegistrationDto.getAddressId());
			}
		}
		return address;
	}

	public static Beneficiary maptoBeneficiary(ArtRegistrationDto artRegistrationDto) {
		Beneficiary beneficiary = new Beneficiary();
		Random rand = new Random(); // instance of random class
		int upperbound = 10000;
		if (artRegistrationDto != null) {
			beneficiary.setAge(artRegistrationDto.getAge());
			//beneficiary.setBarcode(artRegistrationDto.getBarCode());
			beneficiary.setBeneficiaryType(artRegistrationDto.getCategory());
			beneficiary.setCategory(artRegistrationDto.getCategory());
			// beneficiary.setCreatedTime(DateUtil.getCurrentUTCDateTime());
			//beneficiary.setDateOfBirth(artRegistrationDto.getDateOfBirth());
			beneficiary.setEducationLevel(artRegistrationDto.getEducation());
			beneficiary.setFirstName(artRegistrationDto.getFirstName());
			beneficiary.setGender(artRegistrationDto.getGender());
			beneficiary.setIsActive(true);
			beneficiary.setIsDelete(false);
			beneficiary.setLastName(artRegistrationDto.getLastName());
			beneficiary.setMaritalStatus(artRegistrationDto.getMaritalStatus());
			beneficiary.setMiddleName(artRegistrationDto.getMiddleName());
			beneficiary.setMobileNumber(artRegistrationDto.getContactNumber());
			// beneficiary.setModifiedBy(1);
			// beneficiary.setModifiedTime(DateUtil.getCurrentUTCDateTime());
			beneficiary.setOccupation(artRegistrationDto.getOccupation());
			beneficiary.setStatus(artRegistrationDto.getPatientStatus());
			beneficiary.setUid("U" + rand.nextInt(upperbound));
			// beneficiary.setId(artRegistrationDto.getBeneficiaryId());

		}
		return beneficiary;
	}

	/*public static BeneficiaryRegistration mapToBeneficiaryRegistration(ArtRegistrationDto artRegistrationDto) {
		BeneficiaryRegistration beneficiaryRegistration = new BeneficiaryRegistration();
		if (artRegistrationDto != null) {
			// beneficiaryRegistration.setCreatedBy(1);
			// beneficiaryRegistration.setCreatedTime(DateUtil.getCurrentUTCDateTime());
			beneficiaryRegistration.setIsActive(true);
			beneficiaryRegistration.setIsDelete(false);
			// beneficiaryRegistration.setModifiedBy(1);
			// beneficiaryRegistration.setModifiedTime(DateUtil.getCurrentUTCDateTime());
			beneficiaryRegistration.setConsentDocumented(artRegistrationDto.getConsentDocumented());
			beneficiaryRegistration.setDateOfRegistration(artRegistrationDto.getDateOfReg());
			beneficiaryRegistration.setPregnant(artRegistrationDto.getPregnant());
			beneficiaryRegistration.setEntryPoint(artRegistrationDto.getEntryPoint());
			beneficiaryRegistration.setMonthlyHouseholdIncome(artRegistrationDto.getMonthlyHouseholdIncome());
			beneficiaryRegistration.setRiskFactorForHiv(artRegistrationDto.getHivRiskFactor());
			beneficiaryRegistration.setNumberOfPartners(0);
			beneficiaryRegistration.setIsTransit(String.valueOf(artRegistrationDto.getOnTransit()));
			beneficiaryRegistration.setTransitStartDate(artRegistrationDto.getTransitStartDate());
			beneficiaryRegistration.setTransitEndDate(artRegistrationDto.getTransitEndDate());

		}

		return beneficiaryRegistration;

	}*/

	/*public static BeneficiaryArtMapping mapToBeneficiaryArtMapping(ArtRegistrationDto artRegistrationDto,
			Optional<UserMaster> user, Optional<Role> role) {
		BeneficiaryArtMapping beneficiaryArtMapping = new BeneficiaryArtMapping();
		beneficiaryArtMapping.setCounsellorSpecialty(artRegistrationDto.getCounsellorSpeciality());
		beneficiaryArtMapping.setWeightBand(artRegistrationDto.getWeightBand());
		if (user.isPresent()) {
			beneficiaryArtMapping.setUserMaster(user.get());
		}
		if (role.isPresent()) {
			beneficiaryArtMapping.setRole(role.get());
		}
		return beneficiaryArtMapping;
	}*/

	public static IctcDetail mapToIctcDetailMapping(ArtRegistrationDto artRegistrationDto) {
		IctcDetail ictcDetail = new IctcDetail();
		ictcDetail.setPatientPid(artRegistrationDto.getPatientPid());
		ictcDetail.setHivTestDate(artRegistrationDto.getHivDate());
		ictcDetail.setHivTestType(artRegistrationDto.getHivTestType());
		ictcDetail.setIctcCenters(artRegistrationDto.getIctccenter());
		return ictcDetail;
	}

	/*public static ArtBeneficiaryDetail mapToArtBeneficiary(ArtRegistrationDto artRegistrationDto) {
		ArtBeneficiaryDetail artBeneficary = new ArtBeneficiaryDetail();
		artBeneficary.setArtDispensationDate(artRegistrationDto.getLastArtDispensationDate());
		artBeneficary.setArtNumber(artRegistrationDto.getArtNumber());
		artBeneficary.setArtEligibilityDate(artRegistrationDto.getArtEligibilityDate());
		artBeneficary.setArtStartDate(artRegistrationDto.getArtStartDate());
		artBeneficary.setPreArtNumber(artRegistrationDto.getPreArtNumber());
		artBeneficary.setPatientArtStatus(artRegistrationDto.getPatientArtStatus());
		artBeneficary.setOnTransit(artRegistrationDto.getOnTransit());
		artBeneficary.setOnTransitStartDate(artRegistrationDto.getTransitStartDate());
		artBeneficary.setOnTransitEndDate(artRegistrationDto.getTransitEndDate());

		return artBeneficary;
	}*/

	// Function to map ArtRegistrationDto class to
	// BeneficiaryFacilityMapping class
	public static BeneficiaryFacilityMapping mapToBeneficiaryFacilityMapping(ArtRegistrationDto artRegistrationDto,
			Facility facility) {
		BeneficiaryFacilityMapping beneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
		if (artRegistrationDto != null) {

			beneficiaryFacilityMapping.setIsActive(true);
			beneficiaryFacilityMapping.setIsDelete(false);
			beneficiaryFacilityMapping.setFacility(facility);

		}
		return beneficiaryFacilityMapping;
	}

	// Function to map ArtRegistrationDto class to
	// BeneficiaryFacilityMapping class
	public static BeneficiaryFacilityMapping mapToBeneficiaryFacilityMapping(ArtRegistrationDto artRegistrationDto,
			Facility facility, BeneficiaryFacilityMapping beneficiaryFacilityMapping) {

		if (artRegistrationDto != null) {

			beneficiaryFacilityMapping.setIsActive(true);
			beneficiaryFacilityMapping.setIsDelete(false);
			beneficiaryFacilityMapping.setFacility(facility);

		}
		return beneficiaryFacilityMapping;
	}

	public static Address maptoAddress(ArtRegistrationDto artRegistrationDto, Address address, State state,
			District district) {
		if (artRegistrationDto != null) {

			address.setBlock(artRegistrationDto.getBlock());
			address.setHouseNo(artRegistrationDto.getHouseNumber());
			address.setPincode(artRegistrationDto.getPinCode());
			address.setState(state);
			address.setDistrict(district);
			// address.setCreatedBy(1);
			// address.setCreatedTime(DateUtil.getCurrentUTCDateTime());
			address.setIsActive(true);
			address.setIsDelete(false);
			// address.setModifiedBy(1);
			// address.setModifiedTime(DateUtil.getCurrentUTCDateTime());
			// address.setId(artRegistrationDto.getAddressId());
		}
		return address;
	}

	public static Beneficiary maptoBeneficiary(ArtRegistrationDto artRegistrationDto, Beneficiary beneficiary) {
		if (artRegistrationDto != null) {
			beneficiary.setAge(artRegistrationDto.getAge());
			//beneficiary.setBarcode(artRegistrationDto.getBarCode());
			beneficiary.setBeneficiaryType(artRegistrationDto.getCategory());
			beneficiary.setCategory(artRegistrationDto.getCategory());
			// beneficiary.setCreatedBy(1);
			// beneficiary.setCreatedTime(DateUtil.getCurrentUTCDateTime());
			//beneficiary.setDateOfBirth(artRegistrationDto.getDateOfBirth());
			beneficiary.setEducationLevel(artRegistrationDto.getEducation());
			beneficiary.setFirstName(artRegistrationDto.getFirstName());
			beneficiary.setGender(artRegistrationDto.getGender());
			beneficiary.setIsActive(true);
			beneficiary.setIsDelete(false);
			beneficiary.setLastName(artRegistrationDto.getLastName());
			beneficiary.setMaritalStatus(artRegistrationDto.getMaritalStatus());
			beneficiary.setMiddleName(artRegistrationDto.getMiddleName());
			beneficiary.setMobileNumber(artRegistrationDto.getContactNumber());
			// beneficiary.setModifiedBy(1);
			// beneficiary.setModifiedTime(DateUtil.getCurrentUTCDateTime());
			beneficiary.setOccupation(artRegistrationDto.getOccupation());
			beneficiary.setStatus(artRegistrationDto.getPatientStatus());
			// beneficiary.setId(artRegistrationDto.getBeneficiaryId());

		}
		return beneficiary;
	}

	/*public static BeneficiaryRegistration mapToBeneficiaryRegistration(ArtRegistrationDto artRegistrationDto,
			BeneficiaryRegistration beneficiaryRegistration) {
		if (artRegistrationDto != null) {
			// beneficiaryRegistration.setCreatedBy(1);
			// beneficiaryRegistration.setCreatedTime(DateUtil.getCurrentUTCDateTime());
			beneficiaryRegistration.setIsActive(true);
			beneficiaryRegistration.setIsDelete(false);
			// beneficiaryRegistration.setModifiedBy(1);
			// beneficiaryRegistration.setModifiedTime(DateUtil.getCurrentUTCDateTime());
			beneficiaryRegistration.setConsentDocumented(artRegistrationDto.getConsentDocumented());
			beneficiaryRegistration.setDateOfRegistration(artRegistrationDto.getDateOfReg());
			beneficiaryRegistration.setPregnant(artRegistrationDto.getPregnant());
			beneficiaryRegistration.setEntryPoint(artRegistrationDto.getEntryPoint());
			beneficiaryRegistration.setMonthlyHouseholdIncome(artRegistrationDto.getMonthlyHouseholdIncome());
			beneficiaryRegistration.setRiskFactorForHiv(artRegistrationDto.getHivRiskFactor());
			beneficiaryRegistration.setNumberOfPartners(0);
			beneficiaryRegistration.setIsTransit(String.valueOf(artRegistrationDto.getOnTransit()));
			beneficiaryRegistration.setTransitStartDate(artRegistrationDto.getTransitStartDate());
			beneficiaryRegistration.setTransitEndDate(artRegistrationDto.getTransitEndDate());

		}
		return beneficiaryRegistration;
	}*/

	/*public static BeneficiaryArtMapping mapToBeneficiaryArtMapping(ArtRegistrationDto artRegistrationDto,
			Optional<UserMaster> user, Optional<Role> role, BeneficiaryArtMapping beneficiaryArtMapping) {
		beneficiaryArtMapping.setCounsellorSpecialty(artRegistrationDto.getCounsellorSpeciality());
		beneficiaryArtMapping.setWeightBand(artRegistrationDto.getWeightBand());
		if (user.isPresent()) {
			beneficiaryArtMapping.setUserMaster(user.get());
		}
		if (role.isPresent()) {
			beneficiaryArtMapping.setRole(role.get());
		}
		return beneficiaryArtMapping;
	}*/

	public static IctcDetail mapToIctcDetailMapping(ArtRegistrationDto artRegistrationDto, IctcDetail ictcDetail) {
		ictcDetail.setPatientPid(artRegistrationDto.getPatientPid());
		ictcDetail.setHivTestDate(artRegistrationDto.getHivDate());
		ictcDetail.setHivTestType(artRegistrationDto.getHivTestType());
		ictcDetail.setIctcCenters(artRegistrationDto.getIctccenter());
		return ictcDetail;
	}


	public static List<BeneficiaryRegistrationDto> mapToBeneficiaryDto(List<Beneficiary> beneficiaries) {
		List<BeneficiaryRegistrationDto> beneficiaryRegDtos = new ArrayList<BeneficiaryRegistrationDto>();
		if (!CollectionUtils.isEmpty(beneficiaries)) {
			beneficiaries.forEach(beneficiaryRegistration -> {

				BeneficiaryRegistrationDto beneficiaryRegistrationDto = new BeneficiaryRegistrationDto();

				/*beneficiaryRegistrationDto
						.setAddiction(beneficiaryRegistration.getBeneficiaryRegistration().getAddiction());
				beneficiaryRegistrationDto
						.setAlcoholConsume(beneficiaryRegistration.getBeneficiaryRegistration().getAlcoholConsume());
				beneficiaryRegistrationDto.setAverageNumberofSexualActsUponRegistration(beneficiaryRegistration
						.getBeneficiaryRegistration().getAverageNumberofSexualActsUponRegistration());
				beneficiaryRegistrationDto
						.setClientStatus(beneficiaryRegistration.getBeneficiaryRegistration().getClientStatus());
				beneficiaryRegistrationDto
						.setCondomUsage(beneficiaryRegistration.getBeneficiaryRegistration().getCondomUsage());
				beneficiaryRegistrationDto.setConsentDocumented(
						beneficiaryRegistration.getBeneficiaryRegistration().getConsentDocumented());
				beneficiaryRegistrationDto.setDateOfRegistration(
						beneficiaryRegistration.getBeneficiaryRegistration().getDateOfRegistration());
				beneficiaryRegistrationDto.setDurationOfTheStays(
						beneficiaryRegistration.getBeneficiaryRegistration().getDurationOfTheStays());
				beneficiaryRegistrationDto
						.setFacilityCode(beneficiaryRegistration.getBeneficiaryRegistration().getFacilityCode());
				beneficiaryRegistrationDto.setHrgPrimaryCategory(
						beneficiaryRegistration.getBeneficiaryRegistration().getHrgPrimaryCategory());
				beneficiaryRegistrationDto.setHrgSecondaryCategory(
						beneficiaryRegistration.getBeneficiaryRegistration().getHrgSecondaryCategory());
				beneficiaryRegistrationDto
						.setIsActive(beneficiaryRegistration.getBeneficiaryRegistration().getIsActive());
				beneficiaryRegistrationDto
						.setIsBeneficiary(beneficiaryRegistration.getBeneficiaryRegistration().getIsBeneficiary());
				beneficiaryRegistrationDto.setIsDelete(beneficiaryRegistration.getIsDelete());
				beneficiaryRegistrationDto.setNoOfSexualActivity(
						beneficiaryRegistration.getBeneficiaryRegistration().getNoOfSexualActivity());
				beneficiaryRegistrationDto.setNumberOfPartners(
						beneficiaryRegistration.getBeneficiaryRegistration().getNumberOfPartners());
				beneficiaryRegistrationDto.setNumberOfYearsInSexWork(
						beneficiaryRegistration.getBeneficiaryRegistration().getNumberOfYearsInSexWork());
				beneficiaryRegistrationDto.setOutsideTheStateNoOfDays(
						beneficiaryRegistration.getBeneficiaryRegistration().getOutsideTheStateNoOfDays());
				beneficiaryRegistrationDto.setOutsideTheStateNoOfTimes(
						beneficiaryRegistration.getBeneficiaryRegistration().getOutsideTheStateNoOfTimes());
				beneficiaryRegistrationDto.setRegistrationPlace(
						beneficiaryRegistration.getBeneficiaryRegistration().getRegistrationPlace());
				beneficiaryRegistrationDto
						.setRegularPartners(beneficiaryRegistration.getBeneficiaryRegistration().getRegularPartners());
				beneficiaryRegistrationDto.setSexOtherThanSpouse(
						beneficiaryRegistration.getBeneficiaryRegistration().getSexOtherThanSpouse());
				beneficiaryRegistrationDto
						.setStayingWith(beneficiaryRegistration.getBeneficiaryRegistration().getStayingWith());
				beneficiaryRegistrationDto
						.setSubCategory(beneficiaryRegistration.getBeneficiaryRegistration().getSubCategory());
				beneficiaryRegistrationDto
						.setTypeOfMobility(beneficiaryRegistration.getBeneficiaryRegistration().getTypeOfMobility());
				// beneficiaryRegistrationDto.setViewPastActivity(beneficiaryRegistration.getViewPastActivity());
				beneficiaryRegistrationDto.setWithinTheDistrictNoOfDays(
						beneficiaryRegistration.getBeneficiaryRegistration().getWithinTheDistrictNoOfDays());
				beneficiaryRegistrationDto.setWithinTheDistrictNoOfTimes(
						beneficiaryRegistration.getBeneficiaryRegistration().getWithinTheDistrictNoOfTimes());
				beneficiaryRegistrationDto.setWithinTheStateNoOfDays(
						beneficiaryRegistration.getBeneficiaryRegistration().getWithinTheStateNoOfDays());
				beneficiaryRegistrationDto.setWithinTheStateNoOfTimes(
						beneficiaryRegistration.getBeneficiaryRegistration().getWithinTheStateNoOfTimes());
				beneficiaryRegistrationDto.setHowManyDaysAWeekIfAlcoholConsuming(
						beneficiaryRegistration.getBeneficiaryRegistration().getHowManyDaysAWeekIfAlcoholConsuming());
				beneficiaryRegistrationDto
						.setTransitEndDate(beneficiaryRegistration.getBeneficiaryRegistration().getTransitEndDate());
				beneficiaryRegistrationDto.setTransitStartDate(
						beneficiaryRegistration.getBeneficiaryRegistration().getTransitStartDate());
				beneficiaryRegistrationDto
						.setIsTransit(beneficiaryRegistration.getBeneficiaryRegistration().getIsTransit());
				beneficiaryRegistrationDto
						.setOutwardReferal(beneficiaryRegistration.getBeneficiaryRegistration().isOutwardReferal());
				beneficiaryRegistrationDto
						.setInwardReferal(beneficiaryRegistration.getBeneficiaryRegistration().isInwardReferal());
				beneficiaryRegistrationDto.setTransferInReferal(
						beneficiaryRegistration.getBeneficiaryRegistration().isTransferInReferal());
				beneficiaryRegistrationDto.setTransferOutDueForTransferReferal(
						beneficiaryRegistration.getBeneficiaryRegistration().isTransferOutDueForTransferReferal());
				beneficiaryRegistrationDto.setTransferOutTransferredReferal(
						beneficiaryRegistration.getBeneficiaryRegistration().isTransferOutTransferredReferal());
				beneficiaryRegistrationDto
						.setTransitReferal(beneficiaryRegistration.getBeneficiaryRegistration().isTransitReferal());
				beneficiaryRegistrationDto
						.setInwardReferal(beneficiaryRegistration.getBeneficiaryRegistration().isInwardReferal());
				beneficiaryRegistrationDto
						.setOutwardReferal(beneficiaryRegistration.getBeneficiaryRegistration().isOutwardReferal());
				beneficiaryRegistrationDto.setTransferInReferal(
						beneficiaryRegistration.getBeneficiaryRegistration().isTransferInReferal());
				beneficiaryRegistrationDto.setTransferOutDueForTransferReferal(
						beneficiaryRegistration.getBeneficiaryRegistration().isTransferOutDueForTransferReferal());
				beneficiaryRegistrationDto.setTransferOutTransferredReferal(
						beneficiaryRegistration.getBeneficiaryRegistration().isTransferOutTransferredReferal());
				beneficiaryRegistrationDto.setId(beneficiaryRegistration.getBeneficiaryRegistration().getId()); */
				/*
				 * beneficiaryRegistrationDto
				 * .setBeneficiaryId(beneficiaryRegistration.getId());
				 */
				
				beneficiaryRegistrationDto.setAadharNumber(beneficiaryRegistration.getAadharNumber());
				beneficiaryRegistrationDto.setAge(beneficiaryRegistration.getAge());
				//beneficiaryRegistrationDto.setBarcode(beneficiaryRegistration.getBarcode());
				beneficiaryRegistrationDto.setBeneficiaryType(beneficiaryRegistration.getBeneficiaryType());
				//beneficiaryRegistrationDto.setDateOfBirth(beneficiaryRegistration.getDateOfBirth());
				beneficiaryRegistrationDto.setEducationLevel(beneficiaryRegistration.getEducationLevel());
				beneficiaryRegistrationDto.setEmploymentStatus(beneficiaryRegistration.getEmploymentStatus());
				//beneficiaryRegistrationDto.setOtherEmploymentStatus(beneficiaryRegistration.getOtherEmploymentStatus());
				beneficiaryRegistrationDto.setFirstName(beneficiaryRegistration.getFirstName());
				beneficiaryRegistrationDto.setGender(beneficiaryRegistration.getGender());
				// beneficiaryRegistrationDto.setIsPlhiv(beneficiaryRegistration.getIsPlhiv());
				beneficiaryRegistrationDto.setLastName(beneficiaryRegistration.getLastName());
				beneficiaryRegistrationDto.setMaritalStatus(beneficiaryRegistration.getMaritalStatus());
				beneficiaryRegistrationDto.setMiddleName(beneficiaryRegistration.getMiddleName());
				beneficiaryRegistrationDto.setMobileNumber(beneficiaryRegistration.getMobileNumber());
				beneficiaryRegistrationDto.setOccupation(beneficiaryRegistration.getOccupation());
				beneficiaryRegistrationDto.setStatus(beneficiaryRegistration.getStatus());
				beneficiaryRegistrationDto.setUidNumber(beneficiaryRegistration.getUid());
				beneficiaryRegistrationDto
						.setBeneficiaryActivityStatus(beneficiaryRegistration.getBeneficiaryActivityStatus());
				//beneficiaryRegistrationDto.setTiCode(beneficiaryRegistration.getTiCode());
				beneficiaryRegistrationDto.setBeneficiaryId(beneficiaryRegistration.getId());

				Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDto = mapToBeneficiaryFacilityMappingDto(
						beneficiaryRegistration.getBeneficiaryFacilityMappings());
				beneficiaryRegistrationDto.setBeneficiaryFacilityMappingDto(beneficiaryFacilityMappingDto);

//				Set<TiOstDetailDto> tiOstDetailDto = mapToTiOstDetailDto(beneficiaryRegistration.getTiOstDetails());
//				beneficiaryRegistrationDto.setTiOstDetailDto(tiOstDetailDto);

				if (beneficiaryRegistrationDto.getBlock() != null) {
					beneficiaryRegistrationDto.setBlock(beneficiaryRegistration.getAddress().getBlock());
				}
				beneficiaryRegistrationDto.setHouseNo(beneficiaryRegistration.getAddress().getHouseNo());
				beneficiaryRegistrationDto.setPincode(beneficiaryRegistration.getAddress().getPincode());
				beneficiaryRegistrationDto.setAddressId(beneficiaryRegistration.getAddress().getId());

				beneficiaryRegDtos.add(beneficiaryRegistrationDto);
			});
		}
		return beneficiaryRegDtos;
	}


//	private static Set<TiScreeningDetailDto> mapToTiScreeningDetailDto(Set<TiScreeningDetail> tiScreeningDetails) {
//		Set<TiScreeningDetailDto> tiScreeningDetailDtoSet = new HashSet<TiScreeningDetailDto>();
//		if (!CollectionUtils.isEmpty(tiScreeningDetails)) {
//			tiScreeningDetails.forEach(tiScreeningDetail -> {
//
//				TiScreeningDetailDto tiScreeningDetailDto = new TiScreeningDetailDto();
//
//				tiScreeningDetailDto
//						.setLastRiskVulnerabilityAssessment(tiScreeningDetail.getLastRiskVulnerabilityAssessment());
//				tiScreeningDetailDto.setScreeningStatusHiv(tiScreeningDetail.getScreeningStatusHiv());
//				tiScreeningDetailDto.setScreeningStatusSyphilis(tiScreeningDetail.getScreeningStatusSyphilis());
//				tiScreeningDetailDto.setTbStatus(tiScreeningDetail.getTbStatus());
//				tiScreeningDetailDto.setScreeningId(tiScreeningDetail.getScreeningId());
//
//				tiScreeningDetailDtoSet.add(tiScreeningDetailDto);
//			});
//		}
//		return tiScreeningDetailDtoSet;
//	}

//	private static Set<TiOstDetailDto> mapToTiOstDetailDto(Set<TIOstDetails> tiOstDetails) {
//
//		Set<TiOstDetailDto> tiOstDetailDtoSet = new HashSet<TiOstDetailDto>();
//		if (!CollectionUtils.isEmpty(tiOstDetails)) {
//			tiOstDetails.forEach(tiOstDetail -> {
//
//				TiOstDetailDto tiOstDetailDto = new TiOstDetailDto();
//
//				tiOstDetailDto.setCurrentDose(tiOstDetail.getCurrentDose());
//				tiOstDetailDto.setCurrentOstStatus(tiOstDetail.getCurrentOstStatus());
//				tiOstDetailDto.setDispensationStatus(tiOstDetail.getDispensationStatus());
//				tiOstDetailDto.setDispensedLastDate(tiOstDetail.getDispensedLastDate());
//				tiOstDetailDto.setNextFollowUpDate(tiOstDetail.getNextFollowUpDate());
//				tiOstDetailDto.setOstInitiated(tiOstDetail.getOstInitiated());
//				tiOstDetailDto.setOstNumber(tiOstDetail.getOstNumber());
//				tiOstDetailDto.setOstId(tiOstDetail.getOstId());
//
//				tiOstDetailDtoSet.add(tiOstDetailDto);
//			});
//		}
//		return tiOstDetailDtoSet;
//	}


	private static Set<BeneficiaryFacilityMappingDto> mapToBeneficiaryFacilityMappingDto(
			Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings) {
		Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDtoSet = new HashSet<BeneficiaryFacilityMappingDto>();
		if (!CollectionUtils.isEmpty(beneficiaryFacilityMappings)) {
			beneficiaryFacilityMappings.forEach(beneficiaryFacilityMapping -> {

				BeneficiaryFacilityMappingDto beneficiaryFacilityMappingDto = new BeneficiaryFacilityMappingDto();

				beneficiaryFacilityMappingDto.setIsActive(beneficiaryFacilityMapping.getIsActive());
				beneficiaryFacilityMappingDto.setIsDelete(beneficiaryFacilityMapping.getIsDelete());
				beneficiaryFacilityMappingDto.setId(beneficiaryFacilityMapping.getId());

				beneficiaryFacilityMappingDtoSet.add(beneficiaryFacilityMappingDto);
			});
		}
		return beneficiaryFacilityMappingDtoSet;
	}


}
