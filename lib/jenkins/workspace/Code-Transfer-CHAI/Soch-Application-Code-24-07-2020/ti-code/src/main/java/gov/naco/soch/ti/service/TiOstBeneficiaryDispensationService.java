package gov.naco.soch.ti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.BeneficiaryDispensationDto;
import gov.naco.soch.dto.TiOstBeneficiaryDispensationDto;
import gov.naco.soch.dto.TiOstDispensationDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstBulkDispensation;
import gov.naco.soch.entity.TiOstDispensationItem;
import gov.naco.soch.enums.FacilityTypeEnum;
import gov.naco.soch.enums.MasterDrugEnum;
import gov.naco.soch.projection.TIDispensationExpectedList;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;
import gov.naco.soch.repository.ProductRepository;
import gov.naco.soch.repository.TiDispensationCustomRepository;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.repository.TiOstBulkDispensationRepository;
import gov.naco.soch.repository.TiOstDispensationItemRepository;
import gov.naco.soch.ti.mapper.TiOstBeneficiaryDispensationMapper;

@Service
@Transactional
public class TiOstBeneficiaryDispensationService {

    @Autowired
    private TiOstBulkDispensationRepository tiOstBulkDispensationRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TiOstDispensationItemRepository tiOstDispensationItemRepository;

    @Autowired
    private FacilityStockTrackingRepository facilityStockTrackingRepository;

    @Autowired
    private FacilityStockRepository facilityStockRepository;

    @Autowired
    private TiDispensationCustomRepository tiDispensationCustomRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private TiOstBeneficiaryRepository ostBenefRepo;

    public Page<TiOstBeneficiaryDispensationDto> getExpectedClientsForDispensationSearch(Long facilityId,
	    String drugtype, String name, LocalDate date, Boolean isTransit, String param, String uid, String ostNo,
	    String mobile, Pageable page) {
	List<TIDispensationExpectedList> expectedBeneficiaryList = new ArrayList<TIDispensationExpectedList>();
	List<TIDispensationExpectedList> expectedBeneficiaryPageList = new ArrayList<TIDispensationExpectedList>();
	List<TIDispensationExpectedList> removedBeneficiaries = new ArrayList<TIDispensationExpectedList>();
	List<TIDispensationExpectedList> removedBeneficiariesForPage = new ArrayList<TIDispensationExpectedList>();
	List<TiOstBeneficiaryDispensationDto> expectedBeneficiaryDtoList = new ArrayList<>();
	List<TiOstBeneficiaryDispensationDto> expectedBeneficiaryDtoPageList = new ArrayList<>();

	List<TiOstBeneficiaryDispensationDto> todaysDispensedList = new ArrayList<>();
	List<TiOstBeneficiaryDispensationDto> todaysDispensedPageList = new ArrayList<>();
	Facility facility = new Facility();
	Long drugTypeId = 0L;

	Optional<Facility> facilityOptional = facilityRepository.findById(facilityId);
	if (facilityOptional.isPresent()) {
	    facility = facilityOptional.get();
	}
	if (drugtype.equalsIgnoreCase("Buprenorphine")) {
	    drugTypeId = MasterDrugEnum.Buprenorphine.getMasterDrugId();
	} else if (drugtype.equalsIgnoreCase("Methadone")) {
	    drugTypeId = MasterDrugEnum.methadone.getMasterDrugId();
	}
	String searchQuery = TiOstBeneficiaryDispensationMapper.createSearchQuerySearch(facilityId, drugtype, name,
		date, isTransit, param, uid, ostNo, mobile);

	if (searchQuery != null) {
	    expectedBeneficiaryList = tiDispensationCustomRepository.findBeneficiaryList(searchQuery, page);
	    expectedBeneficiaryPageList = tiDispensationCustomRepository.findBeneficiaryList(searchQuery);
	    for (TIDispensationExpectedList expectedBeneficiary : expectedBeneficiaryList) {
		if (facility != null
			&& facility.getFacilityType().getId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()
			&& expectedBeneficiary.getLinkedfacilityid() != null) {
		    removedBeneficiaries.add(expectedBeneficiary);

		}
	    }
	    expectedBeneficiaryList.removeAll(removedBeneficiaries);
	    expectedBeneficiaryDtoList = TiOstBeneficiaryDispensationMapper
		    .mapTiOstProjectionToTiOstBeneficiary(expectedBeneficiaryList, drugTypeId, date);

	    for (TIDispensationExpectedList expectedBeneficiary : expectedBeneficiaryPageList) {
		if (facility != null
			&& facility.getFacilityType().getId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()
			&& expectedBeneficiary.getLinkedfacilityid() != null) {
		    removedBeneficiariesForPage.add(expectedBeneficiary);

		}
	    }
	    expectedBeneficiaryPageList.removeAll(removedBeneficiariesForPage);
	    expectedBeneficiaryDtoPageList = TiOstBeneficiaryDispensationMapper
		    .mapTiOstProjectionToTiOstBeneficiary(removedBeneficiariesForPage, drugTypeId, date);

	}
	if (!expectedBeneficiaryDtoList.isEmpty()) {
	    for (TiOstBeneficiaryDispensationDto beneficiary : expectedBeneficiaryDtoList) {
		List<TiOstDispensationItem> dispensationItems = tiOstDispensationItemRepository
			.findAllByTiOstBeneficiary_IdAndDispensationDate(beneficiary.getTiOstBeneficiaryId(), date);
		if (!dispensationItems.isEmpty()) {
		    todaysDispensedList.add(beneficiary);
		} else {
		    LocalDate dispensationDate = tiOstDispensationItemRepository
			    .findLastdispensationdate(beneficiary.getTiOstBeneficiaryId());
		    beneficiary.setLastDispensationDate(dispensationDate);
		}
	    }
	}

	if (!expectedBeneficiaryDtoPageList.isEmpty()) {
	    for (TiOstBeneficiaryDispensationDto beneficiary : expectedBeneficiaryDtoPageList) {
		List<TiOstDispensationItem> dispensationItems = tiOstDispensationItemRepository
			.findAllByTiOstBeneficiary_IdAndDispensationDate(beneficiary.getTiOstBeneficiaryId(), date);
		if (!dispensationItems.isEmpty()) {
		    todaysDispensedPageList.add(beneficiary);
		} else {
		    LocalDate dispensationDate = tiOstDispensationItemRepository
			    .findLastdispensationdate(beneficiary.getTiOstBeneficiaryId());
		    beneficiary.setLastDispensationDate(dispensationDate);
		}
	    }
	}

	expectedBeneficiaryDtoList.removeAll(todaysDispensedList);
	expectedBeneficiaryDtoPageList.removeAll(todaysDispensedPageList);
	final Page<TiOstBeneficiaryDispensationDto> response = new PageImpl<>(expectedBeneficiaryDtoList);
	if (!response.getContent().isEmpty()) {
	    response.getContent().get(0)
		    .setCount(expectedBeneficiaryDtoPageList == null ? 0 : expectedBeneficiaryDtoPageList.size());
	}

	return response;
    }

    public Page<TiOstBeneficiaryDispensationDto> getExpectedClientsForDispensation(Long facilityId, String drugtype,
			String name, LocalDate date, Boolean isTransit, Pageable page) {
		List<TIDispensationExpectedList> expectedBeneficiaryList = new ArrayList<TIDispensationExpectedList>();
		List<TIDispensationExpectedList> expectedBeneficiaryPageList = new ArrayList<TIDispensationExpectedList>();
		List<TIDispensationExpectedList> removedBeneficiaries = new ArrayList<TIDispensationExpectedList>();
		List<TIDispensationExpectedList> removedBeneficiariesForPage = new ArrayList<TIDispensationExpectedList>();
		List<TiOstBeneficiaryDispensationDto> expectedBeneficiaryDtoList = new ArrayList<>();
		List<TiOstBeneficiaryDispensationDto> expectedBeneficiaryDtoPageList = new ArrayList<>();
		List<TiOstBeneficiaryDispensationDto> todaysDispensedList = new ArrayList<>();
		List<TiOstBeneficiaryDispensationDto> todaysDispensedPageList = new ArrayList<>();
		Facility facility = new Facility();
		Long drugTypeId = 0L;

		Optional<Facility> facilityOptional = facilityRepository.findById(facilityId);
		if (facilityOptional.isPresent()) {
			facility = facilityOptional.get();
		}
		if (drugtype.equalsIgnoreCase("Buprenorphine")) {
			drugTypeId = MasterDrugEnum.Buprenorphine.getMasterDrugId();
		} else if (drugtype.equalsIgnoreCase("Methadone")) {
			drugTypeId = MasterDrugEnum.methadone.getMasterDrugId();
		}

		String searchQuery = TiOstBeneficiaryDispensationMapper.createSearchQuery(facilityId, name, drugTypeId, date,
				isTransit);

		if (searchQuery != null) {
			expectedBeneficiaryList = tiDispensationCustomRepository.findBeneficiaryList(searchQuery,page);
			expectedBeneficiaryPageList = tiDispensationCustomRepository.findBeneficiaryList(searchQuery);
			for (TIDispensationExpectedList expectedBeneficiary : expectedBeneficiaryList) {
				if (facility != null
						&& facility.getFacilityType().getId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()
						&& expectedBeneficiary.getLinkedfacilityid() != null) {
					removedBeneficiaries.add(expectedBeneficiary);
				}
			}
			expectedBeneficiaryList.removeAll(removedBeneficiaries);
			expectedBeneficiaryDtoList = TiOstBeneficiaryDispensationMapper
					.mapTiOstProjectionToTiOstBeneficiary(expectedBeneficiaryList, drugTypeId, date);
			
			for (TIDispensationExpectedList expectedBeneficiary : expectedBeneficiaryPageList) {
				if (facility != null
						&& facility.getFacilityType().getId() == FacilityTypeEnum.OST_FACILITY.getFacilityType()
						&& expectedBeneficiary.getLinkedfacilityid() != null) {
					removedBeneficiariesForPage.add(expectedBeneficiary);
				}
			}
			expectedBeneficiaryPageList.removeAll(removedBeneficiariesForPage);
			expectedBeneficiaryDtoPageList = TiOstBeneficiaryDispensationMapper
					.mapTiOstProjectionToTiOstBeneficiary(expectedBeneficiaryPageList, drugTypeId, date);

		}
		if (!expectedBeneficiaryDtoList.isEmpty()) {
			for (TiOstBeneficiaryDispensationDto beneficiary : expectedBeneficiaryDtoList) {
				List<TiOstDispensationItem> dispensationItems = tiOstDispensationItemRepository
						.findAllByTiOstBeneficiary_IdAndDispensationDate(beneficiary.getTiOstBeneficiaryId(), date);
				if (!dispensationItems.isEmpty()) {
					todaysDispensedList.add(beneficiary);
				} else {
					LocalDate dispensationDate = tiOstDispensationItemRepository
							.findLastdispensationdate(beneficiary.getTiOstBeneficiaryId());
					beneficiary.setLastDispensationDate(dispensationDate);
				}
			}
		}
		
		if (!expectedBeneficiaryDtoPageList.isEmpty()) {
			for (TiOstBeneficiaryDispensationDto beneficiary : expectedBeneficiaryDtoPageList) {
				List<TiOstDispensationItem> dispensationItems = tiOstDispensationItemRepository
						.findAllByTiOstBeneficiary_IdAndDispensationDate(beneficiary.getTiOstBeneficiaryId(), date);
				if (!dispensationItems.isEmpty()) {
					todaysDispensedPageList.add(beneficiary);
				} else {
					LocalDate dispensationDate = tiOstDispensationItemRepository
							.findLastdispensationdate(beneficiary.getTiOstBeneficiaryId());
					beneficiary.setLastDispensationDate(dispensationDate);
				}
			}
		}
		
		expectedBeneficiaryDtoList.removeAll(todaysDispensedList);
		expectedBeneficiaryDtoPageList.removeAll(todaysDispensedPageList);
		final Page<TiOstBeneficiaryDispensationDto> response = new PageImpl<>(expectedBeneficiaryDtoList);
		if (!response.getContent().isEmpty()) {
			response.getContent().get(0).setCount(expectedBeneficiaryDtoList == null ? 0 : expectedBeneficiaryDtoList.size());
			}
		 
		return response;
	}

    public TiOstDispensationDto saveDispensationDetails(@Valid TiOstDispensationDto tiOstDispensationDto) {
	Long methadoneId = productRepository.findProductIdByProductName("Methadone Syrup (5mg/ml)");
	Long buprenorphine2mgId = productRepository.findProductIdByProductName("Buprenorphine 2 Mg");
	Long buprenorphine4mgId = productRepository.findProductIdByProductName("Buprenorphine 0.4 Mg");
	Set<TiOstDispensationItem> tiOstDispensationItems = new HashSet<>();

	TiOstBulkDispensation tiOstBulkDispensation = TiOstBeneficiaryDispensationMapper
		.mapToTiOstBulkDispensation(tiOstDispensationDto);
	tiOstBulkDispensationRepository.save(tiOstBulkDispensation);
	if (tiOstDispensationDto.getSubstituitionDrugId() == 2) {
	    tiOstDispensationItems = TiOstBeneficiaryDispensationMapper.mapToTiOstDispensationItem(tiOstDispensationDto,
		    tiOstBulkDispensation, methadoneId, "methadone");
	} else if (tiOstDispensationDto.getSubstituitionDrugId() == 1) {
	    tiOstDispensationItems = TiOstBeneficiaryDispensationMapper.mapToTiOstDispensationItem(tiOstDispensationDto,
		    tiOstBulkDispensation, buprenorphine2mgId, "buprenorphine2mg");
	    Set<TiOstDispensationItem> tiOstDispensationNewItems = TiOstBeneficiaryDispensationMapper
		    .mapToTiOstDispensationItem(tiOstDispensationDto, tiOstBulkDispensation, buprenorphine4mgId,
			    "buprenorphine4mg");
	    tiOstDispensationItems.addAll(tiOstDispensationNewItems);
	}
	tiOstDispensationItemRepository.saveAll(tiOstDispensationItems);

	List<FacilityStockTracking> facilityStockTrackings = TiOstBeneficiaryDispensationMapper
		.mapToFacilityStockTracking(tiOstDispensationDto, tiOstBulkDispensation);
	facilityStockTrackingRepository.saveAll(facilityStockTrackings);

	Long facilityId = tiOstDispensationDto.getFacilityId();
	tiOstDispensationDto.getBatchDetails().forEach(batch -> {
	    FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
		    batch.getBatchNumber(), batch.getProductId(), facilityId);
	    if (facilityStock != null) {
		facilityStock.setCurrentQuantity(facilityStock.getCurrentQuantity() - batch.getDispensedQuantity());
		facilityStockRepository.save(facilityStock);
	    }
	});

	return tiOstDispensationDto;
    }

    public Page<TiOstBeneficiaryDispensationDto> getTodaysDispensedBeneficiaryListSearch(Long facilityId,
	    String drugType, String name, LocalDate date, String param, String uid, String ostNo, String mobile,
	    Pageable page) {
	List<TiOstDispensationItem> todaysDispensedList = new ArrayList<>();
	List<TiOstDispensationItem> todaysDispensedPageList = new ArrayList<>();
	List<Long> productIds = new ArrayList<>();
	Long methadoneId = productRepository.findProductIdByProductName("Methadone Syrup (5mg/ml)");
	Long buprenorphine2mgId = productRepository.findProductIdByProductName("Buprenorphine 2 Mg");
	Long buprenorphine4mgId = productRepository.findProductIdByProductName("Buprenorphine 0.4 Mg");

	if (drugType.equalsIgnoreCase("Methadone")) {
	    productIds.add(methadoneId);
	} else if (drugType.equalsIgnoreCase("Buprenorphine")) {
	    productIds.add(buprenorphine2mgId);
	    productIds.add(buprenorphine4mgId);
	}

	if (drugType != null && date != null && name == null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByProduct_IdInAndFacility_IdAndDispensationDateOrProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    productIds, facilityId, date, productIds, facilityId, date, page);

	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByProduct_IdInAndFacility_IdAndDispensationDateOrProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    productIds, facilityId, date, productIds, facilityId, date);

	} else if (drugType != null && date != null && name != null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    name, productIds, facilityId, date, name, productIds, facilityId, date, page);
	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    name, productIds, facilityId, date, name, productIds, facilityId, date);
	} else if (drugType != null && date != null && param != null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    param, param, param, param, param, productIds, facilityId, date, param, param, param, param,
			    param, productIds, facilityId, date, page);

	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidOrTiOstBeneficiary_Beneficiary_FirstNameOrTiOstBeneficiary_Beneficiary_LastNameOrTiOstBeneficiary_Beneficiary_MiddleNameOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    param, param, param, param, param, productIds, facilityId, date, param, param, param, param,
			    param, productIds, facilityId, date);

	} else if (drugType != null && date != null && uid != null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    uid, productIds, facilityId, date, uid, productIds, facilityId, date, page);
	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_UidAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    uid, productIds, facilityId, date, uid, productIds, facilityId, date);

	} else if (drugType != null && date != null && ostNo != null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_OstNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_OstNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    ostNo, productIds, facilityId, date, ostNo, productIds, facilityId, date, page);

	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_OstNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_OstNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    ostNo, productIds, facilityId, date, ostNo, productIds, facilityId, date);
	} else if (drugType != null && date != null && mobile != null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    mobile, productIds, facilityId, date, mobile, productIds, facilityId, date, page);

	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_MobileNumberAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    mobile, productIds, facilityId, date, mobile, productIds, facilityId, date);

	}

	Map<TiOstBeneficiary, List<TiOstDispensationItem>> todaysDispensedMapById = todaysDispensedList.stream()
		.collect(Collectors.groupingBy(TiOstDispensationItem::getTiOstBeneficiary));

	Map<TiOstBeneficiary, List<TiOstDispensationItem>> todaysDispensedMapByIdForPage = todaysDispensedPageList
		.stream().collect(Collectors.groupingBy(TiOstDispensationItem::getTiOstBeneficiary));

	List<TiOstBeneficiaryDispensationDto> todaysDispensedDtoList = new ArrayList<>();
	todaysDispensedMapById.forEach((k, v) -> todaysDispensedDtoList.add(
		TiOstBeneficiaryDispensationMapper.mapTiOstDispensationItemToTiOstBeneficiaryDispensationDto(k, v)));

	List<TiOstBeneficiaryDispensationDto> todaysDispensedDtoPageList = new ArrayList<>();
	todaysDispensedMapByIdForPage.forEach((k, v) -> todaysDispensedDtoPageList.add(
		TiOstBeneficiaryDispensationMapper.mapTiOstDispensationItemToTiOstBeneficiaryDispensationDto(k, v)));

	final Page<TiOstBeneficiaryDispensationDto> response = new PageImpl<>(todaysDispensedDtoList);
	if (!response.getContent().isEmpty()) {
	    response.getContent().get(0)
		    .setCount(todaysDispensedMapByIdForPage == null ? 0 : todaysDispensedMapByIdForPage.size());
	}

	return response;
    }

    public Page<TiOstBeneficiaryDispensationDto> getTodaysDispensedBeneficiaryList(Long facilityId, String drugType,
	    String name, LocalDate date, Pageable page) {
	List<TiOstDispensationItem> todaysDispensedList = new ArrayList<>();
	List<TiOstDispensationItem> todaysDispensedPageList = new ArrayList<>();
	List<Long> productIds = new ArrayList<>();
	Long methadoneId = productRepository.findProductIdByProductName("Methadone Syrup (5mg/ml)");
	Long buprenorphine2mgId = productRepository.findProductIdByProductName("Buprenorphine 2 Mg");
	Long buprenorphine4mgId = productRepository.findProductIdByProductName("Buprenorphine 0.4 Mg");

	if (drugType.equalsIgnoreCase("Methadone")) {
	    productIds.add(methadoneId);
	} else if (drugType.equalsIgnoreCase("Buprenorphine")) {
	    productIds.add(buprenorphine2mgId);
	    productIds.add(buprenorphine4mgId);
	}

	if (drugType != null && date != null && name == null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByProduct_IdInAndFacility_IdAndDispensationDateOrProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    productIds, facilityId, date, productIds, facilityId, date, page);

	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByProduct_IdInAndFacility_IdAndDispensationDateOrProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    productIds, facilityId, date, productIds, facilityId, date);

	} else if (drugType != null && date != null && name != null) {
	    todaysDispensedList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    name, productIds, facilityId, date, name, productIds, facilityId, date, page);

	    todaysDispensedPageList = tiOstDispensationItemRepository
		    .findAllByTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndFacility_IdAndDispensationDateOrTiOstBeneficiary_Beneficiary_FirstNameAndProduct_IdInAndTiOstBeneficiary_Facility_IdAndDispensationDate(
			    name, productIds, facilityId, date, name, productIds, facilityId, date);
	}

	Map<TiOstBeneficiary, List<TiOstDispensationItem>> todaysDispensedMapById = todaysDispensedList.stream()
		.collect(Collectors.groupingBy(TiOstDispensationItem::getTiOstBeneficiary));

	Map<TiOstBeneficiary, List<TiOstDispensationItem>> todaysDispensedMapByIdForPage = todaysDispensedPageList
		.stream().collect(Collectors.groupingBy(TiOstDispensationItem::getTiOstBeneficiary));

	List<TiOstBeneficiaryDispensationDto> todaysDispensedDtoList = new ArrayList<>();
	todaysDispensedMapById.forEach((k, v) -> todaysDispensedDtoList.add(
		TiOstBeneficiaryDispensationMapper.mapTiOstDispensationItemToTiOstBeneficiaryDispensationDto(k, v)));

	List<TiOstBeneficiaryDispensationDto> todaysDispensedDtoPageList = new ArrayList<>();
	todaysDispensedMapByIdForPage.forEach((k, v) -> todaysDispensedDtoPageList.add(
		TiOstBeneficiaryDispensationMapper.mapTiOstDispensationItemToTiOstBeneficiaryDispensationDto(k, v)));

	final Page<TiOstBeneficiaryDispensationDto> response = new PageImpl<>(todaysDispensedDtoList);
	if (!response.getContent().isEmpty()) {
	    response.getContent().get(0)
		    .setCount(todaysDispensedDtoPageList == null ? 0 : todaysDispensedDtoPageList.size());
	}

	return response;
    }

    public int validateClientStatus(List<BeneficiaryDispensationDto> list) {
	List<Long> beneficiaryIds = list.stream().map(BeneficiaryDispensationDto::getTiOstBeneficiaryId)
		.collect(Collectors.toList());
	List<Long> ids = new ArrayList<>();
	beneficiaryIds.forEach(id -> {
	    boolean check = ostBenefRepo.checkActiveOrRelapseStatus(id);
	    if (!check) {
		ids.add(id);
	    }
	});
	return ids.size();

    }

}
