package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ArtBeneficiaryDispensationDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryDispensationListDto;
import gov.naco.soch.cst.dto.LastDispensationDetailsDto;
import gov.naco.soch.cst.dto.LastDispensationProductDto;
import gov.naco.soch.cst.dto.TodaysDispensedDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryDispensationMapperUtil;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtDispensationItem;
import gov.naco.soch.entity.ArtPepDispensation;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.ProductDosage;
import gov.naco.soch.projection.ArtDispensationItemProjection;
import gov.naco.soch.repository.ArtBeneficiaryClinicalDetailRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.ArtDispensationItemRepository;
import gov.naco.soch.repository.ArtDispensationRepository;
import gov.naco.soch.repository.ArtPepDispensationItemRepository;
import gov.naco.soch.repository.ArtPepDispensationRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;
import gov.naco.soch.repository.ProductDosageRepository;
import gov.naco.soch.util.UserUtils;

/**
 * Service class that handle dispensation related methods
 *
 */
@Service
@Transactional
public class ArtBeneficiaryDispensationService {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryDispensationService.class);

	@Autowired
	private ArtBeneficiaryRepository artBeneficiaryRepository;

	@Autowired
	private ArtDispensationRepository artDispensationRepository;

	@Autowired
	private ArtDispensationItemRepository artDispensationItemRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private ArtPepDispensationRepository artPepDispensationRepository;

	@Autowired
	private ArtPepDispensationItemRepository artPepDispensationItemRepository;

	@Autowired
	private ProductDosageRepository productDosageRepository;

	@Autowired
	private ArtBeneficiaryClinicalDetailRepository artBeneficiaryClinicalDetailRepository;

	public ArtBeneficiaryDispensationListDto getBeneficiaryDetailsForDispensation(Long beneficiaryId) {
		logger.debug("In getBeneficiaryDetailsForDispensation() of ArtBeneficiaryDispensationService");
		ArtBeneficiaryDispensationListDto artBeneficiaryDispensationDto = new ArtBeneficiaryDispensationListDto();

		// mapping art beneficiary details from at_beneficiary and beneficiary table
		Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiaryRepository.findByBeneficiaryId(beneficiaryId);
		if (artBeneficiaryOptional.isPresent()) {
			ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
			logger.debug("mapToArtBeneficiaryDispensationDto() of ArtBeneficiaryDispensationMapperUtil is invoked");
			artBeneficiaryDispensationDto = ArtBeneficiaryDispensationMapperUtil
					.mapToArtBeneficiaryDispensationDto(artBeneficiary);
		}

		// method to get latest record from art_beneficiary_due_list table for
		// next_app_date and last_visit_date
		ArtBeneficiaryDueList artBeneficiaryDueList = artBeneficiaryDueListRepository
				.findLatestbyBeneficiaryId(beneficiaryId);
		if (artBeneficiaryDueList != null) {
			artBeneficiaryDispensationDto.setNextAppoinmentDate(artBeneficiaryDueList.getExpectedVisitDate());
			artBeneficiaryDispensationDto.setLastVisitDate(artBeneficiaryDueList.getVisitedDate());
		}

		BeneficiaryVisitRegister beneficiaryVisitRegister = beneficiaryVisitRegisterRepository
				.findAllByBeneficiaryIdAndIsDelete(beneficiaryId, false);

		if (beneficiaryVisitRegister != null) {
			// method to get art_beneficiary_clinical_details for finding regimen
			Optional<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetailOptional = artBeneficiaryClinicalDetailRepository
					.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, beneficiaryVisitRegister.getId());
			if (artBeneficiaryClinicalDetailOptional.isPresent()) {
				ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail = artBeneficiaryClinicalDetailOptional.get();
				if (artBeneficiaryClinicalDetail.getRegimen() != null) {
					artBeneficiaryDispensationDto
							.setRegimen(artBeneficiaryClinicalDetail.getRegimen().getRegimenName());
					artBeneficiaryDispensationDto.setReimenId(artBeneficiaryClinicalDetail.getRegimen().getId());
					List<LastDispensationProductDto> regimenProducts = ArtBeneficiaryDispensationMapperUtil
							.mapToRegimenProducts(artBeneficiaryClinicalDetail.getRegimen());
					artBeneficiaryDispensationDto.setRegimenProducts(regimenProducts);
				}
			}
		}
		// method to find last three dispensation details of a beneficiary
		List<ArtDispensation> artDispensationDetails = artDispensationRepository
				.findByLastDispensationdetails(beneficiaryId);
		logger.debug("mapToLastDispensationDetailsDto() of ArtBeneficiaryDispensationService is invoked");
		List<LastDispensationDetailsDto> lastDispensationDetails = mapToLastDispensationDetailsDto(
				artDispensationDetails);
		logger.debug("mapToLastDispensationDetailsDto() method returns with parameters->{}" + lastDispensationDetails);
		artBeneficiaryDispensationDto.setLastDispensationDetails(lastDispensationDetails);
		return artBeneficiaryDispensationDto;
	}

	// method to map List<ArtDispensation> to List<LastDispensationDetailsDto>
	private List<LastDispensationDetailsDto> mapToLastDispensationDetailsDto(
			List<ArtDispensation> artDispensationDetails) {
		logger.debug("In mapToLastDispensationDetailsDto() of ArtBeneficiaryDispensationService");
		List<LastDispensationDetailsDto> lastDispensationDetailsDtos = new ArrayList<LastDispensationDetailsDto>();
		artDispensationDetails.forEach(artDispensationDetail -> {
			LastDispensationDetailsDto lastDispensationDetailsDto = new LastDispensationDetailsDto();
			if (artDispensationDetail.getBeneficiaryVisitRegister() != null) {
				lastDispensationDetailsDto.setVisitDate(artDispensationDetail.getDispenseDate());
			}
			logger.debug("mapToLastDispensationProductDto() of ArtBeneficiaryDispensationService is invoked");
			List<LastDispensationProductDto> products = mapToLastDispensationProductDto(artDispensationDetail);
			logger.debug("mapToLastDispensationProductDto() method returns with parameters->{}" + products);
			lastDispensationDetailsDto.setProducts(products);
			lastDispensationDetailsDtos.add(lastDispensationDetailsDto);
		});
		return lastDispensationDetailsDtos;
	}

	private List<LastDispensationProductDto> mapToLastDispensationProductDto(ArtDispensation artDispensationDetail) {
		logger.debug("In mapToLastDispensationProductDto() of ArtBeneficiaryDispensationService");
		List<LastDispensationProductDto> products = new ArrayList<>();
		artDispensationDetail.getArtDispensationItems().forEach(artDispensationItem -> {
			LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
			LastDispensationProductDto lastDispensationProductDto = new LastDispensationProductDto();
			lastDispensationProductDto.setArtDispensationItemId(artDispensationItem.getId());
			lastDispensationProductDto.setAdherance(artDispensationItem.getAdherenceToArt());
			lastDispensationProductDto.setBatchNumber(artDispensationItem.getBatchNumber());
			if (artDispensationItem.getDispenseQuantity() != null && artDispensationItem.getReturnQty() != null) {
				lastDispensationProductDto.setDispensedQuantity(
						artDispensationItem.getDispenseQuantity() - artDispensationItem.getReturnQty());
			} else {
				lastDispensationProductDto.setDispensedQuantity(artDispensationItem.getDispenseQuantity());
			}
			if (artDispensationItem.getProduct() != null) {
				lastDispensationProductDto.setProductId(artDispensationItem.getProduct().getId());
				lastDispensationProductDto.setProductName(artDispensationItem.getProduct().getProductName());

				// to get batch details from facility stock table
				FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
						artDispensationItem.getBatchNumber(), artDispensationItem.getProduct().getId(),
						loginResponseDto.getFacilityId());
				if (facilityStock != null) {
					lastDispensationProductDto.setExpiryDate(facilityStock.getExpiredDate());
					lastDispensationProductDto.setManufactureDate(facilityStock.getManufacturingDate());
					if(facilityStock.getCurrentQuantity()!=null) {
						lastDispensationProductDto.setAvailabaleQuantity(facilityStock.getCurrentQuantity().longValue());	
					}
					lastDispensationProductDto.setFacilityStockId(facilityStock.getId());
				}

				// to find product dosage of a particular product from product_dosage table
				Optional<ProductDosage> productDosageOptional = productDosageRepository
						.findByProduct_Id(artDispensationItem.getProduct().getId());
				if (productDosageOptional.isPresent()) {
					ProductDosage productDosage = productDosageOptional.get();
					lastDispensationProductDto.setProductDosage(productDosage.getDosageQtyPerMonth());
				}
			}
			lastDispensationProductDto.setRemainingPills(artDispensationItem.getRemainingPills());
			products.add(lastDispensationProductDto);
		});
		return products;
	}

	public @Valid ArtBeneficiaryDispensationDto saveDispensationDetails(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {
		logger.debug("In saveDispensationDetails() of ArtBeneficiaryDispensationService");

		BeneficiaryVisitRegister beneficiaryVisitRegister = new BeneficiaryVisitRegister();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();

		ArtDispensation artDispensation = ArtBeneficiaryDispensationMapperUtil
				.mapToArtDispensation(artBeneficiaryDispensationDto);

		logger.debug("getVisitRegisterIdForToday() of VisitRegisterService is invoked");
		Long visitRegsiterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				artBeneficiaryDispensationDto.getBeneficiaryId());
		logger.debug("getVisitRegisterIdForToday() method returns with parameter->" + visitRegsiterId);
		if (visitRegsiterId != null) {
			beneficiaryVisitRegister.setId(visitRegsiterId);
			artDispensation.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
			Optional<BeneficiaryVisitRegister> visitRegisterOptional = beneficiaryVisitRegisterRepository
					.findById(visitRegsiterId);
			if (visitRegisterOptional.isPresent()) {
				BeneficiaryVisitRegister visitRegister = visitRegisterOptional.get();
				visitRegister.setVisitBy(artBeneficiaryDispensationDto.getDispensedTo());
				beneficiaryVisitRegisterRepository.save(visitRegister);
			}
		}
		artDispensationRepository.save(artDispensation);

		// Que
		SharedService.saveQueDetails(artBeneficiaryDispensationDto.getBeneficiaryId(), loginResponseDto.getUserId(),
				loginResponseDto.getFacilityId());

		// Due List
		SharedService.saveDueList(artBeneficiaryDispensationDto.getBeneficiaryId(),
				artBeneficiaryDispensationDto.getNextAppointmentDate(), visitRegsiterId, loginResponseDto.getUserId(),
				loginResponseDto.getFacilityId());

		// Stock adjustment
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {
			FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					product.getBatchNumber(), product.getProductId(), loginResponseDto.getFacilityId());
			facilityStock = ArtBeneficiaryDispensationMapperUtil.mapToFacilityStock(facilityStock, product,
					loginResponseDto.getFacilityId(), "dispense");
			facilityStockRepository.save(facilityStock);
		});

		// Stock tracking
		List<FacilityStockTracking> facilityStockTrackings = new ArrayList<FacilityStockTracking>();
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {
			FacilityStockTracking facilityStockTracking = ArtBeneficiaryDispensationMapperUtil
					.mapToFacilityStockTracking(product, loginResponseDto.getFacilityId(), artDispensation.getId(),
							"dispense");
			facilityStockTrackings.add(facilityStockTracking);
		});
		facilityStockTrackingRepository.saveAll(facilityStockTrackings);
		return artBeneficiaryDispensationDto;
	}

	public List<TodaysDispensedDto> getTodaysDispensedList(@Valid Long facilityId) {
		logger.debug("In getTodaysDispensedList() of ArtBeneficiaryDispensationService");
		// get todays dispensed details from art_dispensation table
		List<ArtDispensation> artDispensations = artDispensationRepository
				.findAllByFacility_IdAndDispenseDate(facilityId, LocalDate.now());
		logger.debug("mapArtDispensationToTodaysDispensedDto() of ArtBeneficiaryDispensationMapperUtil is invoked");
		List<TodaysDispensedDto> todaysDispensedDtos = ArtBeneficiaryDispensationMapperUtil
				.mapArtDispensationToTodaysDispensedDto(artDispensations);
		logger.debug(
				"mapArtDispensationToTodaysDispensedDto() method returns with parameters->{}" + todaysDispensedDtos);
		todaysDispensedDtos.forEach(todaysDispensedDto -> {
			List<ArtDispensationItemProjection> products = artDispensationItemRepository
					.findDispensedProductDetails(todaysDispensedDto.getArtDispensationId());
			List<LastDispensationProductDto> productDtos = new ArrayList<>();
			products.forEach(product -> {
				LastDispensationProductDto lastDispensationProductDto = new LastDispensationProductDto();
				lastDispensationProductDto.setProductId(product.getProductId());
				lastDispensationProductDto.setProductName(product.getProductName());
				lastDispensationProductDto.setDispensedQuantity(product.getDispensedQuantity());
				productDtos.add(lastDispensationProductDto);
			});
			todaysDispensedDto.setProduct(productDtos);
			ArtBeneficiaryDueList artBeneficiaryDueList = artBeneficiaryDueListRepository
					.findLatestbyBeneficiaryId(todaysDispensedDto.getBeneficiaryId());
			if (artBeneficiaryDueList != null) {
				todaysDispensedDto.setNextAppointmentDate(artBeneficiaryDueList.getExpectedVisitDate());
			}

		});

		// get todays pep dispensation details from art_pep_dispensation table
		List<ArtPepDispensation> artPepDispensations = artPepDispensationRepository
				.findAllByFacility_IdAndDispenseDate(facilityId, LocalDate.now());
		logger.debug("mapArtDispensationToTodaysDispensedDto() of ArtBeneficiaryDispensationMapperUtil is invoked");
		List<TodaysDispensedDto> todaysPepDispensedDtos = ArtBeneficiaryDispensationMapperUtil
				.mapArtPepDispensationToTodaysDispensedDto(artPepDispensations);
		logger.debug(
				"mapArtDispensationToTodaysDispensedDto() method returns with parameters->{}" + todaysDispensedDtos);
		todaysPepDispensedDtos.forEach(todaysPepDispensedDto -> {
			List<ArtDispensationItemProjection> products = artPepDispensationItemRepository
					.findDispensedProductDetails(todaysPepDispensedDto.getArtPepDispensedId());
			List<LastDispensationProductDto> productDtos = new ArrayList<>();
			products.forEach(product -> {
				LastDispensationProductDto lastDispensationProductDto = new LastDispensationProductDto();
				lastDispensationProductDto.setProductId(product.getProductId());
				lastDispensationProductDto.setProductName(product.getProductName());
				lastDispensationProductDto.setDispensedQuantity(product.getDispensedQuantity());
				productDtos.add(lastDispensationProductDto);
			});
			todaysPepDispensedDto.setProduct(productDtos);
		});
		if (!todaysPepDispensedDtos.isEmpty()) {
			todaysDispensedDtos.addAll(todaysPepDispensedDtos);
		}
		return todaysDispensedDtos;
	}

	public @Valid ArtBeneficiaryDispensationDto savePepDispensation(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {
		logger.debug("In getTodaysDispensedList() of ArtBeneficiaryDispensationService");
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		ArtPepDispensation artPepDispensation = ArtBeneficiaryDispensationMapperUtil
				.mapToArtPepDispensation(artBeneficiaryDispensationDto);
		artPepDispensationRepository.save(artPepDispensation);

		// Stock adjustment
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {
			FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					product.getBatchNumber(), product.getProductId(), loginResponseDto.getFacilityId());
			facilityStock = ArtBeneficiaryDispensationMapperUtil.mapToFacilityStock(facilityStock, product,
					loginResponseDto.getFacilityId(), "dispense");
			facilityStockRepository.save(facilityStock);
		});

		// Stock tracking
		List<FacilityStockTracking> facilityStockTrackings = new ArrayList<FacilityStockTracking>();
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {
			FacilityStockTracking facilityStockTracking = ArtBeneficiaryDispensationMapperUtil
					.mapToFacilityStockTracking(product, loginResponseDto.getFacilityId(), artPepDispensation.getId(),
							"dispense");
			facilityStockTrackings.add(facilityStockTracking);
		});
		facilityStockTrackingRepository.saveAll(facilityStockTrackings);
		return artBeneficiaryDispensationDto;
	}

	public @Valid ArtBeneficiaryDispensationDto returnFromPatient(
			@Valid ArtBeneficiaryDispensationDto artBeneficiaryDispensationDto) {
		logger.debug("In returnFromPatient() of ArtBeneficiaryDispensationService");
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		artBeneficiaryDispensationDto.getProducts().forEach(product -> {

			// updating return_qty column in art_dipensation item table
			ArtDispensationItem artDispensationItem = new ArtDispensationItem();
			Optional<ArtDispensationItem> artDispensationItemOptional = artDispensationItemRepository
					.findById(product.getArtDispensationItemId());
			if (artDispensationItemOptional.isPresent()) {
				artDispensationItem = artDispensationItemOptional.get();
				artDispensationItem.setReturnQty(product.getReturnQuantity());
				artDispensationItemRepository.save(artDispensationItem);
			}

			// Stock Adjustment
			FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
					product.getBatchNumber(), product.getProductId(), loginResponseDto.getFacilityId());
			facilityStock = ArtBeneficiaryDispensationMapperUtil.mapToFacilityStock(facilityStock, product,
					loginResponseDto.getFacilityId(), "returnfrompatient");
			facilityStockRepository.save(facilityStock);

			// Stock Tracking
			FacilityStockTracking facilityStockTracking = ArtBeneficiaryDispensationMapperUtil
					.mapToFacilityStockTracking(product, loginResponseDto.getFacilityId(), artDispensationItem.getId(),
							"returnfrompatient");
			facilityStockTrackingRepository.save(facilityStockTracking);
		});

		return artBeneficiaryDispensationDto;
	}

	public List<TodaysDispensedDto> getTodaysDispensedListBySearch(@Valid Long facilityId, String name,
			String artNumber, String preArtNumber, String uid, String pepName, String pepNumber) {
		List<TodaysDispensedDto> dispensedDtos = new ArrayList<>();
		List<TodaysDispensedDto> pepDsipensedDtos = new ArrayList<>();
		if (pepName == null && pepNumber == null) {
			String searchQuery = ArtBeneficiaryDispensationMapperUtil.createSerachQuery(facilityId, name, artNumber,
					preArtNumber, uid);
			List<ArtDispensation> dispensedList = artDispensationRepository.dispensationAdvanceSerach(searchQuery);
			dispensedDtos = ArtBeneficiaryDispensationMapperUtil.mapArtDispensationToTodaysDispensedDto(dispensedList);
		} else if (pepName != null || pepNumber != null) {
			String searchQuery = ArtBeneficiaryDispensationMapperUtil.createPepSearchQuery(facilityId,pepName, pepNumber);
			List<ArtPepDispensation> artPepDispensations = artPepDispensationRepository.pepDispensationAdvanceSearch(searchQuery);
			pepDsipensedDtos = ArtBeneficiaryDispensationMapperUtil
					.mapArtPepDispensationToTodaysDispensedDto(artPepDispensations);
		}

		if (!pepDsipensedDtos.isEmpty()) {
			dispensedDtos.addAll(pepDsipensedDtos);
		}

		return dispensedDtos;
	}

}
