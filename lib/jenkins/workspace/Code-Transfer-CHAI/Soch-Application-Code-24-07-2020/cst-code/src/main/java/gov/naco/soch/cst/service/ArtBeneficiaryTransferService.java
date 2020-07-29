package gov.naco.soch.cst.service;

import gov.naco.soch.cst.criteria.SearchOperation;
import gov.naco.soch.cst.criteria.SearchSpecficationBuilder;
import gov.naco.soch.cst.dto.TransferDto;
import gov.naco.soch.cst.mapper.BeneficiaryRegistrationMapper;
import gov.naco.soch.entity.*;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;
import gov.naco.soch.repository.*;
import gov.naco.soch.util.DateUtil;
import gov.naco.soch.util.UserUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.LocalDateTime;



@Transactional
@Service
public class ArtBeneficiaryTransferService {

	public static final String PRESENT = "transferOut";
	@Autowired
	private TransferRepository transferRepository;
	@Autowired
	private ArtBeneficiaryRepository artBeneficiaryRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	@Autowired
	private BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryReferralService.class);

	public List<TransferDto> getTransferList(String transferType, String searchType,
											 MultiValueMap<String, String> searchParams) {
		logger.info("inside Transfer  listing service");
		String queryParams = "";
		Long presentFacilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
		SearchSpecficationBuilder<Transfer> builder = new SearchSpecficationBuilder();
		Specification<Transfer> transferSpecification = null;

		if (transferType.contains("transferIn")) {
			queryParams = "transferStatus~PENDING#isDeleted~false";
			if (searchType != null && searchType.equalsIgnoreCase("advanced")) {
				transferSpecification = Specification.where(builder.joinNumericFields("facilityTo", "id",
						Long.parseLong(searchParams.getFirst("facilityId"))));
				transferSpecification = transferSpecification
						.and(builder.notEquals("facilityFrom", "id", presentFacilityId));
			} else if (searchType != null && searchType.equalsIgnoreCase("basic")) {
				transferSpecification = Specification.where(null);
				Specification<Transfer> searchSpecification = Specification.where(null);
				if (searchParams.getFirst("fullName") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "fullName", searchParams.getFirst("fullName").toString()));
				}

				if (searchParams.getFirst("preArtNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "preArtNumber", searchParams.getFirst("preArtNumber")));
				}
				if (searchParams.getFirst("artNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "artNumber", searchParams.getFirst("artNumber")));
				}
				transferSpecification = transferSpecification
						.and(builder.notEquals("facilityFrom", "id", presentFacilityId));
				transferSpecification = transferSpecification.and(searchSpecification);

			} else {

				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityTo", "id", presentFacilityId));
				transferSpecification = transferSpecification
						.and(builder.notEquals("facilityFrom", "id", presentFacilityId));

			}

		} else if (transferType.contains("transferOut")) {
			queryParams = "transferStatus~ACCEPTED#isDeleted~false";
			Specification<Transfer> searchSpecification = Specification.where(null);
			if (searchType != null && searchType.equalsIgnoreCase("advanced")) {

				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
				if (searchParams.getFirst("fullName") != null) {
					searchSpecification = searchSpecification
							.and(builder.like("beneficiary", "fullName", searchParams.getFirst("fullName").toString()));
				}
				if (searchParams.getFirst("uidNumber") != null) {
					searchSpecification = searchSpecification
							.and(builder.join("beneficiary", "uid", searchParams.getFirst("uidNumber")));
				}
				if (searchParams.getFirst("preArtNumber") != null) {
					searchSpecification = searchSpecification
							.and(builder.like("beneficiary", "preArtNumber", searchParams.getFirst("preArtNumber")));
				}

				if (searchParams.getFirst("artNumber") != null) {
					searchSpecification = searchSpecification
							.and(builder.like("beneficiary", "artNumber", searchParams.getFirst("artNumber")));
				}

				/*if (searchParams.getFirst("fromDate") != null && searchParams.getFirst("toDate") != null) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

					LocalDate fromLocalDate = LocalDate.parse(searchParams.getFirst("fromDate"), formatter);
					LocalDate toLocalDate = LocalDate.parse(searchParams.getFirst("toDate"), formatter);
					searchSpecification = searchSpecification
							.and(builder.dateInBetween("initiationDate", fromLocalDate, toLocalDate));
				}*/

				transferSpecification = transferSpecification.and(searchSpecification);

			} else if (searchType != null && searchType.equalsIgnoreCase("basic")) {

				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
				if (searchParams.getFirst("fullName") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "fullName", searchParams.getFirst("fullName").toString()));
				}
				if (searchParams.getFirst("uidNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.join("beneficiary", "uid", searchParams.getFirst("uidNumber")));
				}
				if (searchParams.getFirst("preArtNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "preArtNumber", searchParams.getFirst("preArtNumber")));
				}
				if (searchParams.getFirst("artNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "artNumber", searchParams.getFirst("artNumber")));
				}
				/*if (searchParams.getFirst("fromDate") != null && searchParams.getFirst("toDate") != null) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

					LocalDate fromLocalDate = LocalDate.parse(searchParams.getFirst("fromDate"), formatter);
					LocalDate toLocalDate = LocalDate.parse(searchParams.getFirst("toDate"), formatter);
					searchSpecification = searchSpecification
							.and(builder.dateInBetween("initiationDate", fromLocalDate, toLocalDate));
				}*/

				transferSpecification = transferSpecification.and(searchSpecification);

			} else {
				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
			}

		} else if (transferType.equalsIgnoreCase("dueForTransferOut")) {
			transferSpecification = Specification
					.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
			Specification<Transfer> searchSpecification = Specification.where(null);
			queryParams = "transferStatus~PENDING#isDeleted~false";
			if (searchType != null && searchType.equalsIgnoreCase("advanced")) {

				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
				if (searchParams.getFirst("fullName") != null) {
					searchSpecification = searchSpecification
							.and(builder.like("beneficiary", "fullName", searchParams.getFirst("fullName").toString()));
				}
				if (searchParams.getFirst("uidNumber") != null) {
					searchSpecification = searchSpecification
							.and(builder.join("beneficiary", "uid", searchParams.getFirst("uidNumber")));
				}
				if (searchParams.getFirst("preArtNumber") != null) {
					searchSpecification = searchSpecification
							.and(builder.like("beneficiary", "preArtNumber", searchParams.getFirst("preArtNumber")));
				}

				if (searchParams.getFirst("artNumber") != null) {
					searchSpecification = searchSpecification
							.and(builder.like("beneficiary", "artNumber", searchParams.getFirst("artNumber")));
				}

				transferSpecification = transferSpecification.and(searchSpecification);

			} else if (searchType != null && searchType.equalsIgnoreCase("basic")) {

				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
				if (searchParams.getFirst("fullName") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "fullName", searchParams.getFirst("fullName").toString()));
				}
				if (searchParams.getFirst("uidNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.join("beneficiary", "uid", searchParams.getFirst("uidNumber")));
				}
				if (searchParams.getFirst("preArtNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "preArtNumber", searchParams.getFirst("preArtNumber")));
				}
				if (searchParams.getFirst("artNumber") != null) {
					searchSpecification = searchSpecification
							.or(builder.like("beneficiary", "artNumber", searchParams.getFirst("artNumber")));
				}

				transferSpecification = transferSpecification.and(searchSpecification);
			} else {
				transferSpecification = Specification
						.where(builder.joinNumericFields("facilityFrom", "id", presentFacilityId));
			}
		}

		Specification<Transfer> finalTransferSpecification = transferSpecification
				.and(resolveSpecification(queryParams, builder));
		List<Transfer> beneficiaryList = transferRepository.findAll(finalTransferSpecification,
				Sort.by("id").descending());
		logger.info("Transfers List , {}", beneficiaryList.toString());

		return beneficiaryList.stream().map(this::mapToArtBeneficiariesDto).collect(Collectors.toList());
	}

	public boolean acceptTransfer(Long transferId, String preArtNumber, String artNumber) {
		Optional<Transfer> transferToBeAcceptedOptional = transferRepository.findById(transferId);

		if (transferToBeAcceptedOptional.isPresent()) {

			Transfer transferToBeAccepted = transferToBeAcceptedOptional.get();
			Beneficiary beneficiary = transferToBeAccepted.getBeneficiary();
			Facility sourceFacility = transferToBeAccepted.getFacilityFrom();
			Facility newFacility = facilityRepository.findById(UserUtils.getLoggedInUserDetails().getFacilityId())
					.get();

			Optional<ArtBeneficiaryRegistrationProjection> findDuplicatePreArtNumberPrj = beneficiaryRepository
					.findByPreArtNumber(preArtNumber, newFacility.getId());
			Optional<ArtBeneficiaryQueue> beneficiaryQueueOptional = artBeneficiaryQueueRepository
					.findByBeneficiaryIdandFacilityId(beneficiary.getId(), sourceFacility.getId());
			Optional<ArtBeneficiaryDueList> beneficiaryDueListOptional = artBeneficiaryDueListRepository
					.findByBeneficiaryIdandFacilityId(beneficiary.getId(), sourceFacility.getId());
			if (findDuplicatePreArtNumberPrj.isPresent() && !preArtNumber.isEmpty()
					&& preArtNumber.equalsIgnoreCase(findDuplicatePreArtNumberPrj.get().getPreArtNumber())) {
				throw new ServiceException("Duplicate PreARTNumber", null, HttpStatus.BAD_REQUEST);
			}
			if(artNumber !=null && !artNumber.isEmpty()) {
				Optional<ArtBeneficiaryRegistrationProjection> findDuplicateArtNumberPrj = beneficiaryRepository
						.findByArtNumber(artNumber, newFacility.getId());
				if (findDuplicateArtNumberPrj.isPresent()
						&& artNumber.equalsIgnoreCase(findDuplicateArtNumberPrj.get().getArtNumber())) {
					throw new ServiceException("Duplicate ARTNumber", null, HttpStatus.BAD_REQUEST);
				}
			}

			// BeneficiaryFacilityMapping beneficiaryFacilityMapping =
			// beneficiary.getBeneficiaryFacilityMappings().stream().filter(t->t.getIsActive()
			// && !t.getIsDelete()).findFirst().get();
			BeneficiaryFacilityMapping updateBeneficiaryFacilityMapping = beneficiaryFacilityMappingRepository
					.findByFacilityIdAndBeneficiaryIdAndIsDelete(transferToBeAccepted.getFacilityFrom().getId(),
							beneficiary.getId(), false);

			BeneficiaryFacilityMapping newBeneficiaryFacilityMapping = createNewBeneficiaryFacilityMapping(preArtNumber,
					artNumber, newFacility, updateBeneficiaryFacilityMapping);
			updateBeneficiaryFacilityMapping.setMappingUpdatedDate(java.time.LocalDate.now());
			updateBeneficiaryFacilityMapping.setTransferred(true);
			updateBeneficiaryFacilityMapping.setIsActive(false);
			updateBeneficiaryFacilityMapping.setIsDelete(true);

			beneficiaryFacilityMappingRepository.save(updateBeneficiaryFacilityMapping);
			beneficiaryFacilityMappingRepository.save(newBeneficiaryFacilityMapping);

			ArtBeneficiary artBeneficiary = transferToBeAccepted.getBeneficiary().getArtBeneficiary().stream()
					.filter(t -> t.getIsActive() && !t.getIsDelete()).findFirst().get();

			artBeneficiary.setFacility(newFacility);
			MasterArtTreatmentStatus masterArtTreatmentStatus = BeneficiaryRegistrationMapper.mapToMasterArtTreatmentStatus(
					1L);
			artBeneficiary.setMasterArtTreatmentStatus(masterArtTreatmentStatus);
			MasterBeneficiaryArtTransferredFrom artTransferredFrom = new MasterBeneficiaryArtTransferredFrom();
			artTransferredFrom.setId(1L);
			artBeneficiary.setMasterBeneficiaryArtTransferredFrom(artTransferredFrom);
			artBeneficiaryRepository.save(artBeneficiary);

			beneficiary.setPreArtNumber(preArtNumber);
			beneficiary.setArtNumber(artNumber);
			beneficiaryRepository.save(beneficiary);
			transferToBeAccepted.setFacilityTo(newFacility);
			transferToBeAccepted.setTransferStatus("ACCEPTED");
			transferToBeAccepted.setAcceptedTime(LocalDateTime.now());
			Transfer transferAccepted = transferRepository.save(transferToBeAccepted);

			if (transferAccepted != null && transferAccepted.getTransferStatus().equalsIgnoreCase("ACCEPTED")) {
				if (beneficiaryQueueOptional.isPresent()) {
					ArtBeneficiaryQueue artBeneficiaryQueue = beneficiaryQueueOptional.get();
					artBeneficiaryQueue.setIsDelete(Boolean.TRUE);
					artBeneficiaryQueue.setIsActive(Boolean.FALSE);
					artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
				}
				if (beneficiaryDueListOptional.isPresent()) {
					ArtBeneficiaryDueList artBeneficiaryDueList = beneficiaryDueListOptional.get();
					artBeneficiaryDueList.setIsDelete(Boolean.TRUE);
					artBeneficiaryDueList.setIsActive(Boolean.FALSE);
					artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
				}
				return true;
			}
		}
		return false;
	}

	private BeneficiaryFacilityMapping createNewBeneficiaryFacilityMapping(String preArtNumber, String artNumber,
																		   Facility newFacility, BeneficiaryFacilityMapping updateBeneficiaryFacilityMapping) {
		BeneficiaryFacilityMapping newBeneficiaryFacilityMapping = new BeneficiaryFacilityMapping();
		newBeneficiaryFacilityMapping.setIsActive(true);
		newBeneficiaryFacilityMapping.setIsDelete(false);
		newBeneficiaryFacilityMapping.setFacility(newFacility);
		newBeneficiaryFacilityMapping.setMappingDate(DateUtil.getTodayDateInIST());
		newBeneficiaryFacilityMapping.setPreArtNumber(preArtNumber);
		newBeneficiaryFacilityMapping.setArtNumber(artNumber);
		newBeneficiaryFacilityMapping.setBeneficiary(updateBeneficiaryFacilityMapping.getBeneficiary());

		newBeneficiaryFacilityMapping.setPid(updateBeneficiaryFacilityMapping.getPid());
		newBeneficiaryFacilityMapping.setArtPreviousClinic(updateBeneficiaryFacilityMapping.getArtPreviousClinic());
		newBeneficiaryFacilityMapping.setRegistrationDate(updateBeneficiaryFacilityMapping.getRegistrationDate());
		newBeneficiaryFacilityMapping
				.setPreviousNotTransferredArtId(updateBeneficiaryFacilityMapping.getFacility());
		return newBeneficiaryFacilityMapping;
	}

	private TransferDto mapToArtBeneficiariesDto(Transfer transfer) {

		Beneficiary beneficiary = transfer.getBeneficiary();
		TransferDto transferDto =  new 	TransferDto();
		transferDto.setPreArtNumber(beneficiary.getPreArtNumber());
		transferDto.setBeneficiaryId(beneficiary.getId());
		transferDto.setArtNumber(beneficiary.getArtNumber());
		Facility facilityFrom = transfer.getFacilityFrom();
		if(facilityFrom!=null) {
			transferDto.setFacilityFrom(facilityFrom.getName());
		}
		Facility facilityTo = transfer.getFacilityTo();
		if(facilityTo!=null) {
			transferDto.setFacilityTo(facilityTo.getName());
		}
		MasterGender gender = beneficiary.getGenderId();
		if(gender!=null) {
			transferDto.setGender(gender.getName());
		}
		transferDto.setAge(beneficiary.getAge());
		transferDto.setUid(beneficiary.getUid());
		transferDto.setFirstName(beneficiary.getFirstName());
		transferDto.setMiddleName(beneficiary.getMiddleName());
		transferDto.setLastName(beneficiary.getLastName());
		transferDto.setTransferStatus(transfer.getTransferStatus());
		transferDto.setTransferDate(transfer.getInitiationDate());
		transferDto.setId(transfer.getId());

		return transferDto;
	}

	private Specification<Transfer> resolveSpecification(String searchParameters, SearchSpecficationBuilder builder) {


		Pattern pattern = Pattern
				.compile("(\\p{Punct}?)(\\w+?)(~|!)([^\\s#]+?)#");
		Matcher matcher = pattern.matcher(searchParameters + "#");
		while (matcher.find()) {
			//System.out.println("1"+ matcher.group(1)  + " 2"+ matcher.group(2)+ "3"+matcher.group(3)+"4"+matcher.group(4));
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3),matcher.group(4));
		}

		return builder.build();
	}

	public Long cancelTransfer(Long transferId) {
		Optional<Transfer> transferToBeCancelled = transferRepository.findById(transferId);
		if (transferToBeCancelled.isPresent()) {
			Transfer transfer = transferToBeCancelled.get();
			transfer.setIsActive(false);
			transfer.setIsDeleted(true);
			Transfer transferCancelled = transferRepository.save(transfer);
			if (transferCancelled != null) {
				Long transferCancelledId = transferCancelled.getId();
				logger.info("transfer Cancelled for id ,transferId", transferCancelledId);
				return transferCancelled.getId();
			}
		}
		return 0L;

	}
}