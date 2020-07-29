package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import gov.naco.soch.cst.dto.ArtBeneficiaryDispensationDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryDispensationListDto;
import gov.naco.soch.cst.dto.LastDispensationProductDto;
import gov.naco.soch.cst.dto.TodaysDispensedDto;
import gov.naco.soch.cst.enums.ModeOfDispensationEnum;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtDispensationItem;
import gov.naco.soch.entity.ArtPep;
import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.entity.ArtPepDispensationItem;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.MasterModeOfDispensation;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;
import gov.naco.soch.enums.MasterBeneficiarycategoryEnum;
import gov.naco.soch.util.UserUtils;

public class ArtBeneficiaryDispensationMapperUtil {

	public static ArtBeneficiaryDispensationListDto mapToArtBeneficiaryDispensationDto(ArtBeneficiary artBeneficiary) {

		ArtBeneficiaryDispensationListDto artBeneficiaryDispensationDto = new ArtBeneficiaryDispensationListDto();

		if (artBeneficiary.getBeneficiary() != null) {
			artBeneficiaryDispensationDto.setAge(artBeneficiary.getBeneficiary().getAge());
			artBeneficiaryDispensationDto.setArtNumber(artBeneficiary.getBeneficiary().getArtNumber());
			artBeneficiaryDispensationDto.setPreArtNumber(artBeneficiary.getBeneficiary().getPreArtNumber());
			artBeneficiaryDispensationDto.setBeneficiaryFirstName(artBeneficiary.getBeneficiary().getFirstName());
			artBeneficiaryDispensationDto.setBeneficiaryId(artBeneficiary.getBeneficiary().getId());
			artBeneficiaryDispensationDto.setBeneficiaryLastName(artBeneficiary.getBeneficiary().getLastName());
			artBeneficiaryDispensationDto.setAge(artBeneficiary.getBeneficiary().getAge());
			artBeneficiaryDispensationDto.setGender(artBeneficiary.getBeneficiary().getGenderId().getName());
		}
		if (artBeneficiary.getMasterArtBeneficiaryStatus() != null) {
			artBeneficiaryDispensationDto.setArtStatus(artBeneficiary.getMasterArtBeneficiaryStatus().getName());
		}
		return artBeneficiaryDispensationDto;
	}

	public static ArtDispensation mapToArtDispensation(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {
		ArtDispensation artDispensation = new ArtDispensation();
		Beneficiary beneficiary = new Beneficiary();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		beneficiary.setId(artBeneficiaryDispensationDto.getBeneficiaryId());
		artDispensation.setBeneficiary(beneficiary);
		artDispensation.setDispenseDate(LocalDate.now());
		Facility facility = new Facility();
		facility.setId(loginResponseDto.getFacilityId());
		artDispensation.setFacility(facility);
		artDispensation.setIsActive(true);
		artDispensation.setIsDelete(false);

		UserMaster userMaster = new UserMaster();
		userMaster.setId(loginResponseDto.getUserId());
		artDispensation.setUserMaster(userMaster);
		artDispensation.setIsTransit(artBeneficiaryDispensationDto.getIsTransit());
		MasterModeOfDispensation masterModeOfDispensation = new MasterModeOfDispensation();
		if (artBeneficiaryDispensationDto.getIsTransit() == Boolean.FALSE && artBeneficiaryDispensationDto
				.getDispensationType().equalsIgnoreCase(ModeOfDispensationEnum.REPEAT_NAME.getModeOfDispensation())) {
			masterModeOfDispensation.setId(ModeOfDispensationEnum.REPEAT.getModeOfDispensationId());
			artDispensation.setMasterModeOfDispensation(masterModeOfDispensation);
		} else if (artBeneficiaryDispensationDto.getIsTransit() == Boolean.FALSE && artBeneficiaryDispensationDto
				.getDispensationType().equalsIgnoreCase(ModeOfDispensationEnum.REGIMEN_NAME.getModeOfDispensation())) {
			masterModeOfDispensation.setId(ModeOfDispensationEnum.REGIMEN.getModeOfDispensationId());
			artDispensation.setMasterModeOfDispensation(masterModeOfDispensation);
		} else if (artBeneficiaryDispensationDto.getIsTransit() == Boolean.FALSE
				&& artBeneficiaryDispensationDto.getDispensationType()
						.equalsIgnoreCase(ModeOfDispensationEnum.PRESCRIPTION_NAME.getModeOfDispensation())) {
			masterModeOfDispensation.setId(ModeOfDispensationEnum.PRESCRIPTION.getModeOfDispensationId());
			artDispensation.setMasterModeOfDispensation(masterModeOfDispensation);
		}
		Set<ArtDispensationItem> artDispensationItems = mapToArtDispensationItem(artBeneficiaryDispensationDto,
				artDispensation);
		artDispensation.setArtDispensationItems(artDispensationItems);
		return artDispensation;
	}

	private static Set<ArtDispensationItem> mapToArtDispensationItem(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto, ArtDispensation artDispensation) {
		Set<ArtDispensationItem> artDispensationItems = new HashSet<>();
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {
			ArtDispensationItem artDispensationItem = new ArtDispensationItem();
			FacilityStock facilityStock = new FacilityStock();
			Regimen regimen = new Regimen();
			artDispensationItem.setArtDispensation(artDispensation);
			artDispensationItem.setAdherenceToArt(product.getAdherance());
			artDispensationItem.setBatchNumber(product.getBatchNumber());
			artDispensationItem.setDispenseQuantity(product.getDispensedQuantity());
			facilityStock.setId(product.getFacilityStockId());
			artDispensationItem.setFacilityStock(facilityStock);
			artDispensationItem.setIsActive(true);
			artDispensationItem.setDosageQty(product.getProductDosage());
			artDispensationItem.setIsDelete(false);
			Product productEntity = new Product();
			productEntity.setId(product.getProductId());
			artDispensationItem.setProduct(productEntity);
			artDispensationItem.setRemainingPills(product.getRemainingPills());
			if (artBeneficiaryDispensationDto.getIsTransit() == Boolean.FALSE
					&& artBeneficiaryDispensationDto.getDispensationType()
							.equalsIgnoreCase(ModeOfDispensationEnum.REGIMEN_NAME.getModeOfDispensation())
					&& artBeneficiaryDispensationDto.getRegimenId() != null) {
				regimen.setId(artBeneficiaryDispensationDto.getRegimenId());
				artDispensationItem.setRegimen(regimen);
			}
			artDispensationItems.add(artDispensationItem);
		});
		return artDispensationItems;
	}

	public static FacilityStock mapToFacilityStock(FacilityStock facilityStock, LastDispensationProductDto product,
			Long facilityId, String type) {
		if (facilityStock != null) {
			if (type.equalsIgnoreCase("dispense") && facilityStock.getCurrentQuantity() != null
					&& product.getDispensedQuantity() != null) {
				facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() - product.getDispensedQuantity());
			} else if (type.equalsIgnoreCase("returnfrompatient") && facilityStock.getCurrentQuantity() != null
					&& product.getReturnQuantity() != null) {
				facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() + product.getReturnQuantity());
			}
		} else {
			facilityStock = new FacilityStock();
			facilityStock.setBatchNumber(product.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(facilityId);
			facilityStock.setFacility(facility);
			Product productEntity = new Product();
			productEntity.setId(product.getProductId());
			facilityStock.setProduct(productEntity);
			facilityStock.setManufacturingDate(product.getManufactureDate());
			facilityStock.setExpiredDate(product.getExpiryDate());
			if (product.getDispensedQuantity() != null) {
				facilityStock.setCurrentQuantity(product.getDispensedQuantity().doubleValue());
			}
		}
		return facilityStock;
	}

	public static FacilityStockTracking mapToFacilityStockTracking(LastDispensationProductDto product, Long facilityId,
			Long artDispensationId, String type) {

		FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
		facilityStockTracking.setBatchNumber(product.getBatchNumber());
		Facility facility = new Facility();
		facility.setId(facilityId);
		facilityStockTracking.setFacility(facility);
		FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
		if (type.equalsIgnoreCase("dispense")) {
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Art_drug_dispensation.getFacilityStockTrackingTypeId());
			if (product.getDispensedQuantity() != null) {
				facilityStockTracking.setQuantity(-product.getDispensedQuantity().doubleValue());
			}
		} else if (type.equalsIgnoreCase("returnfrompatient")) {
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.ART_Return_From_Beneficiary.getFacilityStockTrackingTypeId());
			if (product.getReturnQuantity() != null) {
				facilityStockTracking.setQuantity(product.getReturnQuantity().doubleValue());
			}
		}
		facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
		Product productEntity = new Product();
		productEntity.setId(product.getProductId());
		facilityStockTracking.setProduct(productEntity);
		facilityStockTracking.setTransactionDate(LocalDate.now());
		facilityStockTracking.setReferenceNo(artDispensationId);

		return facilityStockTracking;
	}

	public static ArtBeneficiaryDueList mapToArtBeneficiaryDueList(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto, LoginResponseDto loginResponseDto,
			Long visitRegsiterId) {
		ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(artBeneficiaryDispensationDto.getBeneficiaryId());
		artBeneficiaryDueList.setBeneficiary(beneficiary);
		BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
		beneficiaryVisitRegister.setId(visitRegsiterId);
		artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
		artBeneficiaryDueList.setExpectedVisitDate(artBeneficiaryDispensationDto.getNextAppointmentDate());
		Facility facility = new Facility();
		facility.setId(loginResponseDto.getFacilityId());
		artBeneficiaryDueList.setFacility(facility);
		artBeneficiaryDueList.setIsVisited(false);
		UserMaster userMaster = new UserMaster();
		userMaster.setId(loginResponseDto.getUserId());
		artBeneficiaryDueList.setEntryUser(userMaster);

		return artBeneficiaryDueList;
	}

	public static List<TodaysDispensedDto> mapArtDispensationToTodaysDispensedDto(
			List<ArtDispensation> artDispensations) {
		List<TodaysDispensedDto> todaysDispensedDtos = new ArrayList<TodaysDispensedDto>();
		artDispensations.forEach(artDispensation -> {
			TodaysDispensedDto todaysDispensedDto = new TodaysDispensedDto();
			todaysDispensedDto.setArtDispensationId(artDispensation.getId());
			if (artDispensation.getBeneficiary() != null) {
				todaysDispensedDto.setArtNumber(artDispensation.getBeneficiary().getArtNumber());
				todaysDispensedDto.setBeneficiaryId(artDispensation.getBeneficiary().getId());
				todaysDispensedDto.setBeneficiaryName(artDispensation.getBeneficiary().getFirstName() + " "
						+ artDispensation.getBeneficiary().getLastName());
				todaysDispensedDto.setGender(artDispensation.getBeneficiary().getGenderId().getName());
				todaysDispensedDto.setPreArtNumber(artDispensation.getBeneficiary().getPreArtNumber());
				todaysDispensedDto = calculateAgeAndCategory(todaysDispensedDto,
						artDispensation.getBeneficiary().getDateOfBirth());
			}
			todaysDispensedDto.setDispenseDate(artDispensation.getDispenseDate());
			if (artDispensation.getBeneficiaryVisitRegister() != null) {
				todaysDispensedDto.setVisitRegisterId(artDispensation.getBeneficiaryVisitRegister().getId());
				if (artDispensation.getBeneficiaryVisitRegister() != null
						&& artDispensation.getBeneficiaryVisitRegister().getVisitBy() != null) {
					if (artDispensation.getBeneficiaryVisitRegister().getVisitBy().equalsIgnoreCase("Proxy")) {
						todaysDispensedDto.setIsProxy("YES");
					} else if (artDispensation.getBeneficiaryVisitRegister().getVisitBy()
							.equalsIgnoreCase("Beneficiary")) {
						todaysDispensedDto.setIsProxy("NO");
					}
				}
			}
			if (artDispensation.getIsTransit() == Boolean.TRUE) {
				todaysDispensedDto.setModeOfDispensation("Transit");
			}
			todaysDispensedDtos.add(todaysDispensedDto);
		});
		return todaysDispensedDtos;
	}

	public static List<TodaysDispensedDto> mapArtPepDispensationToTodaysDispensedDto(
			List<ArtPepDispensation> artPepDispensations) {
		List<TodaysDispensedDto> todaysDispensedDtos = new ArrayList<TodaysDispensedDto>();
		artPepDispensations.forEach(artPepDispensation -> {
			TodaysDispensedDto todaysDispensedDto = new TodaysDispensedDto();
			if (artPepDispensation.getArtPep() != null) {
				todaysDispensedDto.setArtPepDispensedId(artPepDispensation.getId());
				todaysDispensedDto.setArtNumber(artPepDispensation.getArtPep().getPepNumber());
				todaysDispensedDto.setPreArtNumber("PEP");
				todaysDispensedDto.setBeneficiaryId(artPepDispensation.getArtPep().getId());
				todaysDispensedDto.setBeneficiaryName(artPepDispensation.getArtPep().getExposedStaffName());
				if (artPepDispensation.getArtPep().getMasterGender() != null) {
					todaysDispensedDto.setGender(artPepDispensation.getArtPep().getMasterGender().getName());
				}
				todaysDispensedDto = calculateAgeAndCategory(todaysDispensedDto,
						artPepDispensation.getArtPep().getDateOfBirth());
			}
			todaysDispensedDto.setDispenseDate(artPepDispensation.getDispenseDate());
			todaysDispensedDto.setIsProxy("NO");
			todaysDispensedDto.setModeOfDispensation("PEP");
			todaysDispensedDtos.add(todaysDispensedDto);
		});
		return todaysDispensedDtos;
	}

	private static TodaysDispensedDto calculateAgeAndCategory(TodaysDispensedDto todaysDispensedDto,
			LocalDate dateOfBirth) {
		LocalDate currentDate = LocalDate.now();
		LocalDate birthday = LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		Period p = Period.between(birthday, currentDate);
		todaysDispensedDto.setAge(p.getYears() + " Years " + p.getMonths() + " Months ");
		// Integer yearDifference = currentDate.getYear() - dateOfBirth.getYear();
		if (p.getYears() == 0 || p.getYears() <= 2) {
			todaysDispensedDto.setCategory(MasterBeneficiarycategoryEnum.INFANT.getCategory());
		} else if (p.getYears() == 3 || p.getYears() <= 15) {
			todaysDispensedDto.setCategory(MasterBeneficiarycategoryEnum.PED.getCategory());
		}
		if (p.getYears() > 15) {
			todaysDispensedDto.setCategory(MasterBeneficiarycategoryEnum.ADULT.getCategory());
		}
		return todaysDispensedDto;
	}

	public static ArtPepDispensation mapToArtPepDispensation(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {
		ArtPepDispensation artPepDispensation = new ArtPepDispensation();
		UserMaster entryUser = new UserMaster();
		Facility facility = new Facility();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		ArtPep artPep = new ArtPep();

		artPep.setId(artBeneficiaryDispensationDto.getArtPepId());
		artPepDispensation.setArtPep(artPep);
		artPepDispensation.setDispenseDate(LocalDate.now());
		entryUser.setId(loginResponseDto.getUserId());
		artPepDispensation.setUserMaster(entryUser);
		facility.setId(loginResponseDto.getFacilityId());
		artPepDispensation.setFacility(facility);
		artPepDispensation.setIsActive(true);
		artPepDispensation.setIsDelete(false);
		Set<ArtPepDispensationItem> artPepDispensationItems = mapToArtPepDispensationItem(artBeneficiaryDispensationDto,
				artPepDispensation);
		artPepDispensation.setArtPepDispensationItems(artPepDispensationItems);
		return artPepDispensation;
	}

	private static Set<ArtPepDispensationItem> mapToArtPepDispensationItem(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto, ArtPepDispensation artPepDispensation) {
		Set<ArtPepDispensationItem> artPepDispensationItems = new HashSet<>();
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {
			ArtPepDispensationItem artPepDispensationItem = new ArtPepDispensationItem();
			FacilityStock facilityStock = new FacilityStock();
			artPepDispensationItem.setBatchNumber(product.getBatchNumber());
			artPepDispensationItem.setDispenseQuantity(product.getDispensedQuantity());
			facilityStock.setId(product.getFacilityStockId());
			artPepDispensationItem.setFacilityStock(facilityStock);
			Product productEntity = new Product();
			productEntity.setId(product.getProductId());
			artPepDispensationItem.setProduct(productEntity);
			artPepDispensationItem.setArtPepDispensation(artPepDispensation);
			artPepDispensationItems.add(artPepDispensationItem);
		});
		return artPepDispensationItems;
	}

	public static List<LastDispensationProductDto> mapToRegimenProducts(Regimen regimen) {
		List<LastDispensationProductDto> regimenProducts = new ArrayList<LastDispensationProductDto>();
		regimen.getRegimenConstituents().forEach(regimenConstitiuent -> {
			LastDispensationProductDto lastDispensationProductDto = new LastDispensationProductDto();
			lastDispensationProductDto.setProductId(regimenConstitiuent.getProduct().getId());
			lastDispensationProductDto.setProductName(regimenConstitiuent.getProduct().getProductName());
			regimenProducts.add(lastDispensationProductDto);
		});
		return regimenProducts;
	}

	public static String createSerachQuery(@Valid Long facilityId, String name, String artNumber, String preArtNumber,
			String uid) {

		String subQuery = null;

		String searchQuery = "select * from soch.art_dispensation ad join soch.beneficiary b\r\n"
				+ "on(ad.beneficiary_id=b.id) where ad.facility_id=" + facilityId + " and ad.dispense_date='"
				+ LocalDate.now() + "'\r\n";
		if (name != null && artNumber == null && preArtNumber == null && uid == null) {
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%')";
		} else if (artNumber != null && name == null && preArtNumber == null && uid == null) {
			artNumber = artNumber.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%'";
		} else if (preArtNumber != null && artNumber == null && name == null && uid == null) {
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'";
		} else if (uid != null && preArtNumber == null && artNumber == null && name == null) {
			uid = uid.toLowerCase();
			subQuery = "and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name != null && artNumber != null && preArtNumber == null && uid == null) {
			name = name.toLowerCase();
			artNumber = artNumber.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'or LOWER(b.last_name) like '%" + name + "%') and LOWER(b.art_number)\r\n" + " like '%"
					+ artNumber + "%'";
		} else if (name != null && preArtNumber != null && artNumber == null && uid == null) {
			name = name.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%') and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'";
		} else if (name != null && uid != null && preArtNumber == null && artNumber == null) {
			name = name.toLowerCase();
			uid = uid.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%') and LOWER(b.uid) like '%" + uid + "%'";
		} else if (artNumber != null && preArtNumber != null && uid == null && name == null) {
			artNumber = artNumber.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%' and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'";
		} else if (artNumber != null && preArtNumber == null && uid != null && name == null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			subQuery = "and LOWER(b.art_number) like '%" + artNumber + "%' and LOWER(b.uid) like '%" + uid + "%'";
		} else if (preArtNumber != null && uid != null && name == null && artNumber == null) {
			preArtNumber = preArtNumber.toLowerCase();
			uid = uid.toLowerCase();
			subQuery = "and LOWER(b.pre_art_number) like '%" + preArtNumber + "%' and LOWER(b.uid) like '%" + uid
					+ "%'";
		} else if (name != null && artNumber != null && preArtNumber != null && uid == null) {
			artNumber = artNumber.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%') and LOWER(b.art_number) like '%"
					+ artNumber + "%' and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'";
		} else if (name != null && artNumber != null && preArtNumber == null && uid != null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%') and LOWER(b.art_number) like '%"
					+ artNumber + "%' and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name != null && artNumber == null && preArtNumber != null && uid != null) {
			uid = uid.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%')" + " and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'" + "and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name == null && artNumber != null && preArtNumber != null && uid != null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			subQuery = " and LOWER(b.art_number) like '%" + artNumber + "%' and LOWER(b.pre_art_number) like '%"
					+ preArtNumber + "%'" + "and LOWER(b.uid) like '%" + uid + "%'";
		} else if (name != null && artNumber != null && preArtNumber != null && uid != null) {
			artNumber = artNumber.toLowerCase();
			uid = uid.toLowerCase();
			preArtNumber = preArtNumber.toLowerCase();
			name = name.toLowerCase();
			subQuery = "and (LOWER(b.first_name) like '%" + name + "%' or LOWER(b.middle_name) like '%" + name
					+ "%'\r\n" + "or LOWER(b.last_name) like '%" + name + "%') and LOWER(b.art_number) like '%"
					+ artNumber + "%' and LOWER(b.pre_art_number) like '%" + preArtNumber + "%'"
					+ "and LOWER(b.uid) like '%" + uid + "%'";
		}

		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	}

	public static String createPepSearchQuery(Long facilityId, String pepName, String pepNumber) {
		String searchQuery = "select * from soch.art_pep_dispensation apd join soch.art_pep ap\r\n"
				+ "on(apd.pep_id=ap.id) where apd.facility_id=" + facilityId + " and apd.dispense_date='"
				+ LocalDate.now() + "'\r\n";
		String subQuery = null;
		if (pepName != null && pepNumber == null) {
			pepName = pepName.toLowerCase();
			subQuery = "and LOWER(ap.exposed_staff_name) like '%" + pepName + "%'";
		} else if (pepNumber != null && pepName == null) {
			pepNumber = pepNumber.toLowerCase();
			subQuery = "and LOWER(ap.pep_number) like '%" + pepNumber + "%'";
		} else if (pepNumber != null && pepName != null) {
			pepName = pepName.toLowerCase();
			pepNumber = pepNumber.toLowerCase();
			subQuery = "and LOWER(ap.exposed_staff_name) like '%" + pepName + "%' and LOWER(ap.pep_number) like '%"
					+ pepNumber + "%' ";
		}
		if (subQuery != null) {
			searchQuery += subQuery;
		}
		return searchQuery;
	}

}
