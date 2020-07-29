package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;

import gov.naco.soch.cst.criteria.SearchOperation;
import gov.naco.soch.cst.criteria.SearchSpecficationBuilder;
import gov.naco.soch.cst.dto.ArtBeneficiaryDeleteDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryIptAttDetailsDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryListDto;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.cst.dto.ArtSearchResultDto;
import gov.naco.soch.cst.dto.BeneficiaryLabTestDetailsDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryIptAttDetailsMapper;
import gov.naco.soch.cst.mapper.BeneficiaryRegistrationMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.Address;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.entity.ArtBeneficiaryLinkagePurposes;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtDispensation;
import gov.naco.soch.entity.ArtDispensationItem;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryArtStatusTracking;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryFamilyDetail;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;
import gov.naco.soch.entity.BeneficiaryTransitFacility;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.District;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityLinkedFacilityBeneficiary;
import gov.naco.soch.entity.IctcBeneficiary;
import gov.naco.soch.entity.IctcTestResult;
import gov.naco.soch.entity.MasterArtBeneficiaryDeleteReason;
import gov.naco.soch.entity.MasterArtBeneficiaryStatus;
import gov.naco.soch.entity.MasterArtFollowupCriteria;
import gov.naco.soch.entity.MasterBeneficiaryArtTransferredFrom;
import gov.naco.soch.entity.MasterBeneficiaryCategory;
import gov.naco.soch.entity.MasterClinicalStage;
import gov.naco.soch.entity.MasterEducationLevel;
import gov.naco.soch.entity.MasterEntryPoint;
import gov.naco.soch.entity.MasterFunctionalStatus;
import gov.naco.soch.entity.MasterGender;
import gov.naco.soch.entity.MasterMonthlyIncome;
import gov.naco.soch.entity.MasterOccupation;
import gov.naco.soch.entity.MasterPregnancyTypeCase;
import gov.naco.soch.entity.MasterRelationType;
import gov.naco.soch.entity.MasterRiskFactor;
import gov.naco.soch.entity.MasterTreatmentLine;
import gov.naco.soch.entity.Pincode;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.State;
import gov.naco.soch.entity.Subdistrict;
import gov.naco.soch.entity.Town;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.entity.UserMaster;
//import gov.naco.soch.entity.BeneficiaryDetailsPerVisit;
import gov.naco.soch.enums.BeneficiaryCategoryEnum;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;
import gov.naco.soch.repository.ArtBeneficiaryClinicalDetailRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryLinkagePurposesRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryArtStatusTrackingRepository;
//import gov.naco.soch.repository.BeneficiaryDetailsPerVisitRepository;
import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;
import gov.naco.soch.repository.BeneficiaryFamilyDetailRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiarySocialWelfareSchemeRepository;
import gov.naco.soch.repository.BeneficiaryTransitFacilityRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.DistrictRepository;
import gov.naco.soch.repository.FacilityLinkedFacilityBeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.IctcBeneficiaryRepository;
import gov.naco.soch.repository.MasterArtFollowupCriteriaRepository;
import gov.naco.soch.repository.PincodeRepository;
import gov.naco.soch.repository.StateRepository;
import gov.naco.soch.repository.SubdistrictRepository;
import gov.naco.soch.repository.TownRespository;
import gov.naco.soch.repository.TransferRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.util.DateUtil;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class ArtBeneficiaryService {
    public static final String PAEDIATRIC = "Paediatric";
    private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryService.class);

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private ArtBeneficiaryRepository artBeneficiaryRepository;

    @Autowired
    private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

    @Autowired
    private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

    @Autowired
    private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

    @Autowired
    private MasterArtFollowupCriteriaRepository masterArtFollowupCriteriaRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private TownRespository townRespository;

    @Autowired
    private SubdistrictRepository subdistrictRepository;

    @Autowired
    private PincodeRepository pincodeRepository;

    @Autowired
    private FacilityLinkedFacilityBeneficiaryRepository linkedFacilityBeneficiaryRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private BeneficiaryTransitFacilityRepository beneficiaryTransitFacilityRepository;

    @Autowired
    private BeneficiaryFacilityMappingRepository beneficiaryFacilityMappingRepository;

    @Autowired
    private BeneficiaryReferralRepository beneficiaryReferralRepository;

    @Autowired
    private ArtBeneficiaryLinkagePurposesRepository artBeneficiaryLinkagePurposesRepository;

    @Autowired
    BeneficiaryLabTestDetailsService beneficiaryLabTestDetailsService;

    @Autowired
    ArtBeneficiaryClinicalDetailRepository artBeneficiaryClinicalDetailRepository;

    @Autowired
    BeneficiarySocialWelfareSchemeRepository beneficiarySocialWelfareSchemeRepository;

    @Autowired
    IctcBeneficiaryRepository ictcBeneficiaryRepository;

    @Autowired
    BeneficiaryFamilyDetailRepository beneficiaryFamilyDetailRepository;

    @Autowired
    BeneficiaryArtStatusTrackingRepository beneficiaryArtStatusTrackingRepository;

    @Autowired
    private BeneficiaryArtStatusTrackingService beneficiaryArtStatusTrackingService;

    /**
     * Method to Edit/Add Beneficiary
     *
     * @return artRegistrationDto
     */

    public ArtRegistrationDto saveBeneficiary(ArtRegistrationDto artRegistrationDto) {
        if (artRegistrationDto.getBeneficiaryId() != null && artRegistrationDto.getBeneficiaryId() != 0) {
            Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository
                    .findById(artRegistrationDto.getBeneficiaryId());
            if (beneficiaryOptional.isPresent()) {
                Beneficiary beneficiary = beneficiaryOptional.get();
                LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
                Optional<Facility> facility = facilityRepository.findById(loginResponseDto.getFacilityId());
                Optional<UserMaster> user = userMasterRepository.findById(loginResponseDto.getUserId());

                logger.debug("Duplicate PreARTNumber check in edit called");
                Optional<ArtBeneficiaryRegistrationProjection> preArtNumDuplicationCheck = beneficiaryRepository
                        .findByPreArtNumber(artRegistrationDto.getPreArtNumber(), loginResponseDto.getFacilityId());
                if (preArtNumDuplicationCheck.isPresent() && artRegistrationDto.getBeneficiaryId()
                        .longValue() != preArtNumDuplicationCheck.get().getBeneficiaryId().longValue()) {
                    throw new ServiceException("Duplicate PreARTNumber", null, HttpStatus.BAD_REQUEST);
                }

                logger.debug("Duplicate ARTNumber check in edit called");
                if (artRegistrationDto.getArtNumber() != null && !artRegistrationDto.getArtNumber().isEmpty()) {
                    Optional<ArtBeneficiaryRegistrationProjection> artNumberDuplicationCheck = beneficiaryRepository
                            .findByArtNumber(artRegistrationDto.getArtNumber(), loginResponseDto.getFacilityId());
                    if (artNumberDuplicationCheck.isPresent() && artRegistrationDto.getBeneficiaryId()
                            .longValue() != artNumberDuplicationCheck.get().getBeneficiaryId().longValue()) {
                        throw new ServiceException("Duplicate ART Number", null, HttpStatus.BAD_REQUEST);
                    }
                }

                logger.debug("maptoBeneficiary method called");
                beneficiary = BeneficiaryRegistrationMapper.maptoBeneficiary(artRegistrationDto, beneficiary);

                logger.debug("mapToAddress method called");
                if (artRegistrationDto.getState() != null && (artRegistrationDto.getDistrict() != null)) {
                    Optional<State> state = stateRepository.findById(artRegistrationDto.getState());
                    Optional<District> district = districtRepository.findById(artRegistrationDto.getDistrict());
                    Town town = null;
                    Subdistrict subdistrict = null;
                    Pincode pincode = null;
                    if (artRegistrationDto.getTown() != null) {
                        Optional<Town> townOpt = townRespository.findById(artRegistrationDto.getTown());
                        if (townOpt.isPresent()) {
                            town = townOpt.get();
                        }
                    }
                    if (artRegistrationDto.getSubDistrictId() != null) {
                        Optional<Subdistrict> subdistrictOpt = subdistrictRepository
                                .findById(artRegistrationDto.getSubDistrictId());
                        if (subdistrictOpt.isPresent()) {
                            subdistrict = subdistrictOpt.get();
                        }
                    }
                    if (artRegistrationDto.getPinCode() != null && artRegistrationDto.getPinCode() != "") {
                        Optional<Pincode> pincodeOpt = pincodeRepository.findByPincode(artRegistrationDto.getPinCode());
                        if (!pincodeOpt.isPresent()) {
                            pincode = new Pincode();
                            pincode.setPincode(artRegistrationDto.getPinCode());
                            pincode.setIsActive(true);
                            pincode.setIsDelete(false);
                            pincode = pincodeRepository.save(pincode);
                        } else {
                            pincode = pincodeOpt.get();
                        }
                    }
                    logger.debug("maptoAddress method called");
                    Address address = beneficiary.getAddress();
                    address = BeneficiaryRegistrationMapper.mapToAddress(address, artRegistrationDto, state.get(),
                            district.get(), town, subdistrict, pincode);
                    logger.debug("maptoAddress method returns with artRegistrationDto", artRegistrationDto);
                    beneficiary.setAddress(address);
                }
                // edit Caregiver address
                if (artRegistrationDto.getCaregiverState() != null
                        && artRegistrationDto.getCaregiverDistrict() != null) {
                    Optional<State> careGiverstate = stateRepository.findById(artRegistrationDto.getCaregiverState());
                    Optional<District> careGiverdistrict = districtRepository
                            .findById(artRegistrationDto.getCaregiverDistrict());
                    Town careGivertown = null;
                    Subdistrict careGiversubdistrict = null;
                    Pincode careGiverpincode = null;
                    if (artRegistrationDto.getTown() != null) {
                        Optional<Town> townOpt = townRespository.findById(artRegistrationDto.getCaregivertown());
                        if (townOpt.isPresent()) {
                            careGivertown = townOpt.get();
                        }

                    }
                    if (artRegistrationDto.getCaregiverSubDistrictId() != null) {
                        Optional<Subdistrict> subdistrictOpt = subdistrictRepository
                                .findById(artRegistrationDto.getCaregiverSubDistrictId());
                        if (subdistrictOpt.isPresent()) {
                            careGiversubdistrict = subdistrictOpt.get();
                        }

                    }
                    if (artRegistrationDto.getCaregiverPinCode() != null
                            && artRegistrationDto.getCaregiverPinCode() != "") {
                        Optional<Pincode> pincodeOpt = pincodeRepository
                                .findByPincode(artRegistrationDto.getCaregiverPinCode());
                        if (!pincodeOpt.isPresent()) {
                            careGiverpincode = new Pincode();
                            careGiverpincode.setPincode(artRegistrationDto.getCaregiverPinCode());
                            careGiverpincode.setIsActive(true);
                            careGiverpincode.setIsDelete(false);
                            careGiverpincode = pincodeRepository.save(careGiverpincode);
                        } else {
                            careGiverpincode = pincodeOpt.get();
                        }
                    }
                    logger.debug("maptoAddress method called");
                    Address caregiveraddress = beneficiary.getCaregiverAddressId();
                    caregiveraddress = BeneficiaryRegistrationMapper.mapToAddress(caregiveraddress, artRegistrationDto,
                            careGiverstate.get(), careGiverdistrict.get(), careGivertown, careGiversubdistrict,
                            careGiverpincode);
                    logger.debug("maptoAddress method returns with artRegistrationDto", artRegistrationDto);
                    beneficiary.setCaregiverAddressId(caregiveraddress);
                }

                logger.debug("mapToIctcBeneficiary method called");
                Optional<IctcBeneficiary> ictcBeneficiaryOptional = ictcBeneficiaryRepository
                        .findByBeneficiaryAndIsDeleted(beneficiary.getId(), facility.get().getId(), false);
                if (ictcBeneficiaryOptional.isPresent()) {
                    IctcBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
                    ictcBeneficiary = BeneficiaryRegistrationMapper.mapToIctcBeneficiary(artRegistrationDto,
                            ictcBeneficiary);
                    ictcBeneficiary.setBeneficiary(beneficiary);
                    ictcBeneficiaryRepository.save(ictcBeneficiary);
                }

                logger.debug("mapToBeneficiaryVisitRegister method called");
                Long visterRegister = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
                        artRegistrationDto.getBeneficiaryId());
                Optional<BeneficiaryVisitRegister> beneficiaryVisitRegister = beneficiaryVisitRegisterRepository
                        .findById(visterRegister);
                if (beneficiaryVisitRegister.isPresent()) {
                    BeneficiaryVisitRegister beneficiaryVisitRegisterDetails = beneficiaryVisitRegister.get();
                    beneficiaryVisitRegisterDetails = BeneficiaryRegistrationMapper
                            .mapToBeneficiaryVisitRegister(artRegistrationDto, beneficiaryVisitRegisterDetails);
                    beneficiaryVisitRegisterRepository.save(beneficiaryVisitRegisterDetails);
                }

                logger.debug("mapToArtBeneficiary method called");
                ArtBeneficiary artBeneficary = artBeneficiaryRepository
                        .findByBeneficiaryIdAndAndIsDelete(artRegistrationDto.getBeneficiaryId(), false);
                artBeneficary = BeneficiaryRegistrationMapper.mapToArtBeneficiary(artRegistrationDto, artBeneficary);
                artBeneficary.setFacility(facility.get());
                artBeneficary.setUserId(user.get());
                artBeneficary.setBeneficiary(beneficiary);
                artBeneficiaryRepository.save(artBeneficary);

                /*
                 * logger.debug("Save ArtBeneficiaryQueue method "); if
                 * (artRegistrationDto.getAssignedTo() != null) { UserMaster nextUser = new
                 * UserMaster(); nextUser.setId(artRegistrationDto.getAssignedTo());
                 * Optional<ArtBeneficiaryQueue> currentQueueOpt = artBeneficiaryQueueRepository
                 * .findBeneficiaryAssignedTo(artRegistrationDto.getBeneficiaryId(),
                 * artRegistrationDto.getAssignedTo(), loginResponseDto.getFacilityId(),
                 * LocalDate.now()); if (currentQueueOpt.isPresent()) { ArtBeneficiaryQueue
                 * currentQueue = currentQueueOpt.get();
                 * currentQueue.setAssignedToUser(nextUser); currentQueue.setIsVisited(true);
                 * currentQueue.setIsActive(false); currentQueue.setIsDelete(true);
                 * artBeneficiaryQueueRepository.save(currentQueue); } else {
                 *
                 * ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
                 * artBeneficiaryQueue.setAssignedToUser(nextUser);
                 * artBeneficiaryQueue.setEntryUser(user.get());
                 * artBeneficiaryQueue.setFacility(facility.get());
                 * artBeneficiaryQueue.setVisitDate(LocalDate.now());
                 * artBeneficiaryQueue.setIsVisited(false);
                 * artBeneficiaryQueue.setIsActive(true);
                 * artBeneficiaryQueue.setIsDelete(false);
                 * artBeneficiaryQueue.setBeneficiary(beneficiary);
                 * artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get(
                 * )); artBeneficiaryQueueRepository.save(artBeneficiaryQueue); } }
                 */

                logger.debug("Save ArtBeneficiaryQueue method ");
                if (artRegistrationDto.getAssignedTo() != null) {
                    ArtBeneficiaryQueue artBeneficiaryQueue = artBeneficiaryQueueRepository
                            .findByBeneficiaryIdAndCurrentDateAndIsvisitedAndFacilityId(
                                    artRegistrationDto.getBeneficiaryId(), loginResponseDto.getFacilityId());
                    UserMaster nextUser = new UserMaster();
                    nextUser.setId(artRegistrationDto.getAssignedTo());
                    if (artBeneficiaryQueue != null) {
                        artBeneficiaryQueue.setAssignedToUser(nextUser);
                        artBeneficiaryQueue.setEntryUser(user.get());
                        artBeneficiaryQueue.setFacility(facility.get());
                        artBeneficiaryQueue.setVisitDate(LocalDate.now());
                        artBeneficiaryQueue.setIsVisited(false);
                        artBeneficiaryQueue.setIsActive(true);
                        artBeneficiaryQueue.setIsDelete(false);
                        artBeneficiaryQueue.setBeneficiary(beneficiary);
                        artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
                        artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
                    } else {
                        ArtBeneficiaryQueue artBeneficiaryQueue1 = new ArtBeneficiaryQueue();
                        artBeneficiaryQueue1.setAssignedToUser(nextUser);
                        artBeneficiaryQueue1.setEntryUser(user.get());
                        artBeneficiaryQueue1.setFacility(facility.get());
                        artBeneficiaryQueue1.setVisitDate(LocalDate.now());
                        artBeneficiaryQueue1.setIsVisited(false);
                        artBeneficiaryQueue1.setIsActive(true);
                        artBeneficiaryQueue1.setIsDelete(false);
                        artBeneficiaryQueue1.setBeneficiary(beneficiary);
                        artBeneficiaryQueue1.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
                        artBeneficiaryQueueRepository.save(artBeneficiaryQueue1);
                    }
                }

                logger.debug("mapToBeneficiaryArtBeneficiaryDueList method called");
                if (artRegistrationDto.getNextVisitDate() != null) {
                    Optional<ArtBeneficiaryDueList> artBeneficiaryDueListOptional = artBeneficiaryDueListRepository
                            .findByBeneficiaryNextVisitDateAndIsDelete(artRegistrationDto.getBeneficiaryId(),
                                    loginResponseDto.getFacilityId(), artRegistrationDto.getNextVisitDate(), false);
                    if (!artBeneficiaryDueListOptional.isPresent()) {
                        logger.debug("mapToBeneficiaryArtBeneficiaryDueList method called");
                        ArtBeneficiaryDueList artBeneficiaryDueList = BeneficiaryRegistrationMapper
                                .mapToBeneficiaryArtBeneficiaryDueList(artRegistrationDto);
                        artBeneficiaryDueList.setBeneficiary(beneficiary);
                        artBeneficiaryDueList.setFacility(facility.get());
                        artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
                        artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
                    }
                }

                Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
                        .findByBeneficiaryIdAndVisitRegisterId(artRegistrationDto.getBeneficiaryId(),
                                beneficiaryVisitRegister.get().getId());
                ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail = null;
                if (optClinicalDetails.isPresent()) {
                    artBeneficiaryClinicalDetail = optClinicalDetails.get();
                    if (artRegistrationDto.getMasterTreatmentLine() != null) {
                        MasterTreatmentLine treatmentLine = new MasterTreatmentLine();
                        treatmentLine.setId(artRegistrationDto.getMasterTreatmentLine());
                        artBeneficiaryClinicalDetail.setMasterTreatmentLine(treatmentLine);
                    } else {
                        artBeneficiaryClinicalDetail.setMasterTreatmentLine(null);
                    }
                    artBeneficiaryClinicalDetail.setPapSmear(artRegistrationDto.getPapSmear());
                    artBeneficiaryClinicalDetail.setIspptctReferred(artRegistrationDto.getPptctReferred());
                    artBeneficiaryClinicalDetail
                            .setPptctPregnancyRemarks(artRegistrationDto.getPptctPregnancyRemarks());
                    artBeneficiaryClinicalDetailRepository.save(artBeneficiaryClinicalDetail);
                } else {
                    if (artRegistrationDto.getMasterTreatmentLine() != null || artRegistrationDto.getPapSmear() != null
                            || artRegistrationDto.getPptctPregnancyRemarks() != null
                            || artRegistrationDto.getPptctReferred() != null) {
                        artBeneficiaryClinicalDetail = new ArtBeneficiaryClinicalDetail();
                        logger.debug("mapToArtBeneficiaryClinicalDetail method called");
                        ArtBeneficiaryClinicalDetail beneficiaryClinicalDetail = BeneficiaryRegistrationMapper
                                .mapToArtBeneficiaryClinicalDetail(artRegistrationDto);
                        beneficiaryClinicalDetail.setFacility(facility.get());
                        beneficiaryClinicalDetail.setEntryUser(user.get());
                        beneficiaryClinicalDetail.setBeneficiary(beneficiary);
                        beneficiaryClinicalDetail.setBeneficiaryVisitRegister(beneficiaryVisitRegister.get());
                        artBeneficiaryClinicalDetailRepository.save(beneficiaryClinicalDetail);
                    }
                }

                logger.debug("mapToBeneficiaryFacilityMapping method called");
                BeneficiaryFacilityMapping beneficiaryFacilityMapping = beneficiaryFacilityMappingRepository
                        .findByBeneficiaryAndFacilityAndIsDelete(beneficiary.getId(), facility.get().getId(), false,
                                true);
                beneficiaryFacilityMapping = BeneficiaryRegistrationMapper.mapToBeneficiaryFacilityMapping(
                        artRegistrationDto, facility.get(), beneficiaryFacilityMapping);
                Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings = new HashSet<>();
                beneficiaryFacilityMapping.setBeneficiary(beneficiary);
                beneficiaryFacilityMappings.add(beneficiaryFacilityMapping);
                beneficiary.setBeneficiaryFacilityMappings(beneficiaryFacilityMappings);
                beneficiaryRepository.save(beneficiary);

                logger.debug("getArtBeneficiaryStatusId method called");
                if (artRegistrationDto.getArtBeneficiaryStatusId() != null) {
                    beneficiaryArtStatusTrackingService.getBeneficiaryArtStatusTracking(
                            artRegistrationDto.getBeneficiaryId(), facility.get().getId(),
                            artRegistrationDto.getArtBeneficiaryStatusId());

                }

                // Link art
                logger.debug("FacilityLinkedFacilityBeneficiary method called");
                FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary = new FacilityLinkedFacilityBeneficiary();
                Optional<FacilityLinkedFacilityBeneficiary> linkedFacilityBeneficiaryOpt = linkedFacilityBeneficiaryRepository
                        .findByBeneficiaryAndIsDelete(beneficiary.getId(), loginResponseDto.getFacilityId(), false);
                if (linkedFacilityBeneficiaryOpt.isPresent()) {
                    facilityLinkedFacilityBeneficiary = linkedFacilityBeneficiaryOpt.get();
                    linkedFacilityBeneficiaryRepository.delete(facilityLinkedFacilityBeneficiary);
                }
                if (artRegistrationDto.getLinkedFacilityId() != null) {
                    facilityLinkedFacilityBeneficiary = BeneficiaryRegistrationMapper
                            .mapToFacilityLinkedFacilityBeneficiary(artRegistrationDto);
                    facilityLinkedFacilityBeneficiary.setBeneficiary(beneficiary);
                    linkedFacilityBeneficiaryRepository.save(facilityLinkedFacilityBeneficiary);
                }

                // Transfer
                Transfer artPatientTransfer = new Transfer();
                Optional<Transfer> artPatientTransferOpt = transferRepository
                        .findByBeneficiaryAndIsDeleted(beneficiary.getId(), loginResponseDto.getFacilityId(), false);
                if (artPatientTransferOpt.isPresent()) {
                    artPatientTransfer = artPatientTransferOpt.get();
                    transferRepository.delete(artPatientTransfer);
                }
                if (artRegistrationDto.getDestinationFacilityId() != null) {
                    artPatientTransfer = BeneficiaryRegistrationMapper.mapToTransfer(artRegistrationDto);
                    artPatientTransfer.setBeneficiary(beneficiary);
                    artPatientTransfer.setTransferStatus("PENDING");
                    artPatientTransfer.setInitiationDate(LocalDate.now());
                    transferRepository.save(artPatientTransfer);
                }

                // Refferal

                BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
                Optional<BeneficiaryReferral> beneficiaryReferraloptional = beneficiaryReferralRepository
                        .findByBeneficiaryAndIsDelete(beneficiary.getId(), loginResponseDto.getFacilityId(), false);
                if (beneficiaryReferraloptional.isPresent()) {
                    beneficiaryReferral = beneficiaryReferraloptional.get();
                    beneficiaryReferralRepository.delete(beneficiaryReferral);
                }
                if (artRegistrationDto.getReferTo() != null) {
                    beneficiaryReferral = BeneficiaryRegistrationMapper.mapToBeneficiaryReferral(artRegistrationDto);
                    beneficiaryReferral.setBeneficiary(beneficiary);
                    beneficiaryReferralRepository.save(beneficiaryReferral);
                }
                // transit
                List<Long> transistFacilityId = artRegistrationDto.getTransistFacilityId();
                List<BeneficiaryTransitFacility> beneficiaryTransitFacilities = beneficiaryTransitFacilityRepository
                        .findByBeneficiaryIdAndIsDelete(artRegistrationDto.getBeneficiaryId(), false);
                if (beneficiaryTransitFacilities != null && !beneficiaryTransitFacilities.isEmpty()) {
                    beneficiaryTransitFacilityRepository.deleteAll(beneficiaryTransitFacilities);
                }
                if (transistFacilityId != null && !transistFacilityId.isEmpty()) {
                    List<BeneficiaryTransitFacility> transitFacility = BeneficiaryRegistrationMapper
                            .mapToBeneficiaryTransitFacility(artRegistrationDto);
                    for (BeneficiaryTransitFacility beneficiaryTransitFacility1 : transitFacility) {
                        beneficiaryTransitFacility1.setBeneficiary(beneficiary);
                        beneficiaryTransitFacilityRepository.save(beneficiaryTransitFacility1);
                    }
                }
                // Linkage
                List<Long> linkagePurposeIdList = artRegistrationDto.getLinkagePurposesId();
                if (linkagePurposeIdList != null && !linkagePurposeIdList.isEmpty()) {
                    List<ArtBeneficiaryLinkagePurposes> linkagePurposList = artBeneficiaryLinkagePurposesRepository
                            .findByBeneficaryId(artRegistrationDto.getBeneficiaryId());
                    if (linkagePurposList != null && !linkagePurposList.isEmpty()) {
                        artBeneficiaryLinkagePurposesRepository.deleteAll(linkagePurposList);
                    }
                    List<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposesList = BeneficiaryRegistrationMapper
                            .mapToArtBeneficiaryLinkagePurposes(artRegistrationDto);
                    for (ArtBeneficiaryLinkagePurposes linkagePurposes : artBeneficiaryLinkagePurposesList) {
                        linkagePurposes.setBeneficiary(beneficiary);
                    }
                    artBeneficiaryLinkagePurposesRepository.saveAll(artBeneficiaryLinkagePurposesList);
                }
                // SocialWelfareScheme
                List<Long> socialwelfareSchemeIds = artRegistrationDto.getMasterSocialWelfare();
                if (socialwelfareSchemeIds != null && !socialwelfareSchemeIds.isEmpty()) {
                    List<BeneficiarySocialWelfareScheme> welfareSchemesList = beneficiarySocialWelfareSchemeRepository
                            .findByBeneficiaryId(artRegistrationDto.getBeneficiaryId());
                    if (welfareSchemesList != null && !welfareSchemesList.isEmpty()) {
                        beneficiarySocialWelfareSchemeRepository.deleteAll(welfareSchemesList);
                    }
                    List<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemesList = BeneficiaryRegistrationMapper
                            .mapToBeneficiarySocialWelfareScheme(artRegistrationDto);
                    for (BeneficiarySocialWelfareScheme welfareScheme : beneficiarySocialWelfareSchemesList) {
                        welfareScheme.setBeneficiary(beneficiary);
                    }
                    beneficiarySocialWelfareSchemeRepository.saveAll(beneficiarySocialWelfareSchemesList);
                }
            }
        } else {
            LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
            Optional<Facility> facility = facilityRepository.findById(loginResponseDto.getFacilityId());
            Optional<UserMaster> user = userMasterRepository.findById(loginResponseDto.getUserId());

            Optional<ArtBeneficiaryRegistrationProjection> preArtNumDuplicationCheck = beneficiaryRepository
                    .findByPreArtNumber(artRegistrationDto.getPreArtNumber(), loginResponseDto.getFacilityId());
            if (preArtNumDuplicationCheck.isPresent()) {
                throw new ServiceException("Duplicate PreARTNumber", null, HttpStatus.BAD_REQUEST);
            }
            if (artRegistrationDto.getArtNumber() != null && !artRegistrationDto.getArtNumber().isEmpty()) {
                Optional<ArtBeneficiaryRegistrationProjection> artNumberDuplicationCheck = beneficiaryRepository
                        .findByArtNumber(artRegistrationDto.getArtNumber(), loginResponseDto.getFacilityId());
                if (artNumberDuplicationCheck.isPresent()) {
                    throw new ServiceException("Duplicate ART Number", null, HttpStatus.BAD_REQUEST);
                }
            }

            Optional<ArtBeneficiaryRegistrationProjection> beneficiaryPidDuplicationCheck = ictcBeneficiaryRepository
                    .findByBeneficiaryPid(artRegistrationDto.getPatientPid(), loginResponseDto.getFacilityId());
            if (beneficiaryPidDuplicationCheck.isPresent()) {
                throw new ServiceException("Duplicate Beneficiary PID", null, HttpStatus.BAD_REQUEST);
            }

            logger.debug("maptoBeneficiary method called");
            Beneficiary beneficiary = BeneficiaryRegistrationMapper.maptoBeneficiary(artRegistrationDto);

            Optional<State> state = stateRepository.findById(artRegistrationDto.getState());
            Optional<District> district = districtRepository.findById(artRegistrationDto.getDistrict());
            Town town = null;
            Subdistrict subdistrict = null;
            Pincode pincode = null;
            if (artRegistrationDto.getTown() != null) {
                Optional<Town> townOpt = townRespository.findById(artRegistrationDto.getTown());
                if (townOpt.isPresent()) {
                    town = townOpt.get();
                }

            }
            if (artRegistrationDto.getSubDistrictId() != null) {
                Optional<Subdistrict> subdistrictOpt = subdistrictRepository
                        .findById(artRegistrationDto.getSubDistrictId());
                if (subdistrictOpt.isPresent()) {
                    subdistrict = subdistrictOpt.get();
                }

            }
            if (artRegistrationDto.getPinCode() != null && artRegistrationDto.getPinCode() != "") {
                Optional<Pincode> pincodeOpt = pincodeRepository.findByPincode(artRegistrationDto.getPinCode());
                if (!pincodeOpt.isPresent()) {
                    pincode = new Pincode();
                    pincode.setPincode(artRegistrationDto.getPinCode());
                    pincode.setIsActive(true);
                    pincode.setIsDelete(false);
                    pincode = pincodeRepository.save(pincode);
                } else {
                    pincode = pincodeOpt.get();
                }
            }
            logger.debug("maptoAddress method called");
            Address address = BeneficiaryRegistrationMapper.mapToAddress(artRegistrationDto, state.get(),
                    district.get(), town, subdistrict, pincode);
            logger.debug("maptoAddress method returns with artRegistrationDto", artRegistrationDto);

            // Caregiver address
            if (artRegistrationDto.getCaregiverState() != null && artRegistrationDto.getCaregiverDistrict() != null) {
                Optional<State> careGiverstate = stateRepository.findById(artRegistrationDto.getCaregiverState());
                Optional<District> careGiverdistrict = districtRepository
                        .findById(artRegistrationDto.getCaregiverDistrict());
                Town careGivertown = null;
                Subdistrict careGiversubdistrict = null;
                Pincode careGiverpincode = null;
                if (artRegistrationDto.getTown() != null) {
                    Optional<Town> townOpt = townRespository.findById(artRegistrationDto.getCaregivertown());
                    if (townOpt.isPresent()) {
                        careGivertown = townOpt.get();
                    }

                }
                if (artRegistrationDto.getCaregiverSubDistrictId() != null) {
                    Optional<Subdistrict> subdistrictOpt = subdistrictRepository
                            .findById(artRegistrationDto.getCaregiverSubDistrictId());
                    if (subdistrictOpt.isPresent()) {
                        careGiversubdistrict = subdistrictOpt.get();
                    }

                }
                if (artRegistrationDto.getCaregiverPinCode() != null
                        && artRegistrationDto.getCaregiverPinCode() != "") {
                    Optional<Pincode> pincodeOpt = pincodeRepository
                            .findByPincode(artRegistrationDto.getCaregiverPinCode());
                    if (!pincodeOpt.isPresent()) {
                        careGiverpincode = new Pincode();
                        careGiverpincode.setPincode(artRegistrationDto.getCaregiverPinCode());
                        careGiverpincode.setIsActive(true);
                        careGiverpincode.setIsDelete(false);
                        careGiverpincode = pincodeRepository.save(careGiverpincode);
                    } else {
                        careGiverpincode = pincodeOpt.get();
                    }
                }
                logger.debug("maptoAddress method called");
                Address caregiveraddress = BeneficiaryRegistrationMapper.mapToAddress(artRegistrationDto,
                        careGiverstate.get(), careGiverdistrict.get(), careGivertown, careGiversubdistrict,
                        careGiverpincode);
                logger.debug("maptoAddress method returns with artRegistrationDto", artRegistrationDto);
                beneficiary.setCaregiverAddressId(caregiveraddress);
            }

            beneficiary.setAddress(address);
            beneficiary = beneficiaryRepository.save(beneficiary);
            beneficiary.setUid("U" + beneficiary.getId());
            beneficiaryRepository.save(beneficiary);

            logger.debug("getArtBeneficiaryStatusId method called");
            if (artRegistrationDto.getArtBeneficiaryStatusId() != null) {
                BeneficiaryArtStatusTracking artStatusTracking = new BeneficiaryArtStatusTracking();
                artStatusTracking.setBeneficiary(beneficiary);
                artStatusTracking.setFacility(facility.get());
                artStatusTracking.setStatusDate(DateUtil.getTodayDateInIST());
                artStatusTracking.setStatusChangedBy((long) 0);
                artStatusTracking.setIsActive(true);
                artStatusTracking.setIsDelete(false);
                MasterArtBeneficiaryStatus artBeneficiaryStatus = new MasterArtBeneficiaryStatus();
                artBeneficiaryStatus.setId(artRegistrationDto.getArtBeneficiaryStatusId());
                artStatusTracking.setCurrentArtBeneficiaryStatus(artBeneficiaryStatus);
                beneficiaryArtStatusTrackingRepository.save(artStatusTracking);

            }

            // ICTC
            IctcBeneficiary ictcBeneficiary = BeneficiaryRegistrationMapper.mapToIctcBeneficiary(artRegistrationDto);
            ictcBeneficiary.setBeneficiary(beneficiary);
            // ictcBeneficiary.setFacility(facility.get());
            ictcBeneficiaryRepository.save(ictcBeneficiary);

            BeneficiaryVisitRegister visitRegister = saveBeneficiaryVisitRegisterDetails(artRegistrationDto,
                    beneficiary, facility.get());

            logger.debug("mapToArtBeneficiary method called");
            ArtBeneficiary artBeneficary = BeneficiaryRegistrationMapper.mapToArtBeneficiary(artRegistrationDto);
            artBeneficary.setFacility(facility.get());
            artBeneficary.setUserMaster1(user.get());
            artBeneficary.setBeneficiary(beneficiary);
            artBeneficiaryRepository.save(artBeneficary);

            if (artRegistrationDto.getNextVisitDate() != null) {
                ArtBeneficiaryDueList artBeneficiaryDueList = BeneficiaryRegistrationMapper
                        .mapToBeneficiaryArtBeneficiaryDueList(artRegistrationDto);
                artBeneficiaryDueList.setBeneficiary(beneficiary);
                artBeneficiaryDueList.setFacility(facility.get());
                artBeneficiaryDueList.setBeneficiaryVisitRegister(visitRegister);
                artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
            }

            logger.debug("mapToBeneficiaryQueue method called");
            if (artRegistrationDto.getAssignedTo() != null) {
                ArtBeneficiaryQueue artBeneficiaryQueue = BeneficiaryRegistrationMapper
                        .mapToBeneficiaryQueue(artRegistrationDto);
                artBeneficiaryQueue.setBeneficiary(beneficiary);
                artBeneficiaryQueue.setBeneficiaryVisitRegister(visitRegister);
                artBeneficiaryQueue.setEntryUser(user.get());
                artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
            }
            logger.debug("mapToBeneficiaryFacilityMapping method called");
            BeneficiaryFacilityMapping beneficiaryFacilityMapping = BeneficiaryRegistrationMapper
                    .mapToBeneficiaryFacilityMapping(artRegistrationDto, facility.get());
            Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings = new HashSet<>();
            beneficiaryFacilityMapping.setBeneficiary(beneficiary);
            beneficiaryFacilityMappings.add(beneficiaryFacilityMapping);
            beneficiary.setBeneficiaryFacilityMappings(beneficiaryFacilityMappings);

            logger.debug("mapToArtBeneficiaryClinicalDetail method called");
            if (artRegistrationDto.getMasterTreatmentLine() != null || artRegistrationDto.getPapSmear() != null
                    || artRegistrationDto.getPptctPregnancyRemarks() != null
                    || artRegistrationDto.getPptctReferred() != null) {
                ArtBeneficiaryClinicalDetail beneficiaryClinicalDetail = BeneficiaryRegistrationMapper
                        .mapToArtBeneficiaryClinicalDetail(artRegistrationDto);
                beneficiaryClinicalDetail.setFacility(facility.get());
                beneficiaryClinicalDetail.setEntryUser(user.get());
                beneficiaryClinicalDetail.setBeneficiary(beneficiary);
                beneficiaryClinicalDetail.setBeneficiaryVisitRegister(visitRegister);
                artBeneficiaryClinicalDetailRepository.save(beneficiaryClinicalDetail);
            }
            List<Long> socialwelfareSchemeIds = artRegistrationDto.getMasterSocialWelfare();
            if (socialwelfareSchemeIds != null && !socialwelfareSchemeIds.isEmpty()) {
                List<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemesList = BeneficiaryRegistrationMapper
                        .mapToBeneficiarySocialWelfareScheme(artRegistrationDto);
                for (BeneficiarySocialWelfareScheme welfareScheme : beneficiarySocialWelfareSchemesList) {
                    welfareScheme.setBeneficiary(beneficiary);
                }
                beneficiarySocialWelfareSchemeRepository.saveAll(beneficiarySocialWelfareSchemesList);
            }
        }
        return artRegistrationDto;
    }

    private BeneficiaryVisitRegister saveBeneficiaryVisitRegisterDetails(ArtRegistrationDto artRegistrationDto,
                                                                         Beneficiary beneficiary, Facility facility) {
        BeneficiaryVisitRegister visitRegister = BeneficiaryRegistrationMapper
                .mapToBeneficiaryVisitRegister(artRegistrationDto);
        visitRegister.setBeneficiary(beneficiary);
        visitRegister.setFacility(facility);
        visitRegister = beneficiaryVisitRegisterRepository.save(visitRegister);
        return visitRegister;
    }

    public ArtSearchResultDto getArtBeneficiaryList(String searchParameters, Long beneficiaryCategoryId,
                                                    Integer pageNumber, Integer pageSize, String fieldName, String sortOrder) {

        Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();

        SearchSpecficationBuilder builder = new SearchSpecficationBuilder();
        ArtSearchResultDto setSearchResult = new ArtSearchResultDto();
        Facility presentFacility = facilityRepository.findById(UserUtils.getLoggedInUserDetails().getFacilityId())
                .get();

        Specification<Beneficiary> beneficiarySpecification = Specification.where(null)
                .and(builder.join("artBeneficiary", "isDelete", false))
                .and(builder.getBeneficiariesInPresentFacility(facilityId));

        Pageable pageable = getPaginationAndSortOrder(pageNumber, pageSize, fieldName, sortOrder);

        Specification<Beneficiary> allBeneficiarySpecification = null;
        if (beneficiaryCategoryId == BeneficiaryCategoryEnum.PAEDIATRIC.getCategoryType()) {
            Specification<Beneficiary> pediatricSpecification = beneficiarySpecification
                    .and(builder.lessThan("categoryId", "id", BeneficiaryCategoryEnum.ADULT.getCategoryType()));
            allBeneficiarySpecification = pediatricSpecification;
        } else if (beneficiaryCategoryId == BeneficiaryCategoryEnum.BENEFICIARY_WITH_DISPENSATION_HISTORY
                .getCategoryType()) {
            Specification<Beneficiary> beneficiaryWithDispensationHistory = beneficiarySpecification
                    .and(builder.getBeneficiaryDispensationHistory(facilityId));
            allBeneficiarySpecification = beneficiaryWithDispensationHistory;
        } else if (beneficiaryCategoryId == BeneficiaryCategoryEnum.BENEFICIARY_IN_PRESENT_FACILITY.getCategoryType()) {
            allBeneficiarySpecification = beneficiarySpecification;
        } else {
            Specification<Beneficiary> transferSpecification = Specification.where(null);
            transferSpecification = transferSpecification.and(builder.getTransferredBeneficiaries(facilityId));
            Specification<Beneficiary> combinedSpecification = beneficiarySpecification.or(transferSpecification);
            allBeneficiarySpecification = combinedSpecification;
        }

        if (searchParameters != null) {
            allBeneficiarySpecification = allBeneficiarySpecification
                    .and(resolveSpecification(searchParameters, builder));
        }
        Page beneficiaryPage = beneficiaryRepository.findAll(allBeneficiarySpecification, pageable);

        Optional<List> beneficiaryListOptional = Optional.ofNullable(beneficiaryPage.getContent());
        if (beneficiaryListOptional.isPresent()) {
            List<Beneficiary> sortedPageableBeneficiaryList = beneficiaryListOptional.get();

            List<ArtBeneficiaryListDto> artBeneficiaries = sortedPageableBeneficiaryList.stream()
                    .map(this::mapToBeneficiaryDtoList).collect(Collectors.toList());
            setSearchResult.setSearchResultList(artBeneficiaries);
            setSearchResult.setPageSize(pageSize);
            setSearchResult.setTotalResultCount(beneficiaryPage.getTotalElements());
            setSearchResult.setPageCount(beneficiaryPage.getTotalPages());
            setSearchResult.setFacilityId(facilityId);
        }
        return setSearchResult;
    }

    private Pageable getPaginationAndSortOrder(Integer pageNumber, Integer pageSize, String fieldName, String direction) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("modifiedTime").descending());

        if (fieldName != null && !"".equalsIgnoreCase(fieldName) && direction != null && !"".equalsIgnoreCase(direction)) {
            if (direction.equalsIgnoreCase("asc")) {
                pageable = PageRequest.of(pageNumber, pageSize, Sort.by(fieldName).ascending());
            } else if (direction.equalsIgnoreCase("desc")) {
                pageable = PageRequest.of(pageNumber, pageSize, Sort.by(fieldName).descending());
            }
        }

        return pageable;
    }

    public ArtBeneficiaryListDto mapToBeneficiaryDtoList(Beneficiary beneficiary) {
        ArtBeneficiaryListDto artBeneficiaryDto = new ArtBeneficiaryListDto();
        artBeneficiaryDto.setBeneficiaryId(beneficiary.getId());
        artBeneficiaryDto.setFirstName(Objects.toString(beneficiary.getFirstName(), ""));
        artBeneficiaryDto.setMiddleName(Objects.toString(beneficiary.getMiddleName(), ""));
        artBeneficiaryDto.setLastName(Objects.toString(beneficiary.getLastName(), ""));
        artBeneficiaryDto.setArtNumber(Objects.toString(beneficiary.getArtNumber(), ""));
        // artBeneficiaryDto.setContactNumber(Objects.toString(beneficiary.getMobileNumber(),
        // ""));

        artBeneficiaryDto.setPreArtNumber(Objects.toString(beneficiary.getPreArtNumber(), ""));
        artBeneficiaryDto.setAge(beneficiary.getAge());

        if (beneficiary.getGenderId() != null) {
            artBeneficiaryDto.setGender(Objects.toString(beneficiary.getGenderId().getName(), ""));
        } else {
            artBeneficiaryDto.setGender("");
        }

        Set artBeneficiarySet = beneficiary.getArtBeneficiary();
        Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiarySet.stream().findFirst();
        ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
        if (artBeneficiary != null) {
            artBeneficiaryDto.setLacLinked(artBeneficiary.getLacLinked());
            artBeneficiaryDto.setIsTransit(artBeneficiary.getIsTransit());
            // artBeneficiaryDto.setRegistrationDate(artBeneficiary.getArtRegistrationDate());
            // artBeneficiaryDto.setArtStartDate(artBeneficiary.getArtStartDate());
        }
        artBeneficiaryDto.setStatus(getArtBeneficiaryStatus(artBeneficiary));
        // artBeneficiaryDto.setAdhernceToArt(getAdherenceToArt(Optional.ofNullable(beneficiary.getArtBeneficiaryFollowups())));
        getTransferStatus(Optional.ofNullable(beneficiary.getTransfers()), artBeneficiaryDto);
        // artBeneficiaryDto.setRegimen(getRegimen(Optional.ofNullable(beneficiary.getArtBeneficiaryClinicalDetails())));
        artBeneficiaryDto.setUid(beneficiary.getUid());
        artBeneficiaryDto.setBeneficiaryId(beneficiary.getId());
        return artBeneficiaryDto;
    }

    private String getRegimen(Optional<Set<ArtBeneficiaryClinicalDetail>> artBeneficiaryClinicalDetails) {
        String regimenName = "";
        if (artBeneficiaryClinicalDetails.isPresent()) {
            Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetailSet = artBeneficiaryClinicalDetails.get();
            Optional<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetail = artBeneficiaryClinicalDetailSet
                    .stream().max(Comparator.comparing(ArtBeneficiaryClinicalDetail::getId));
            if (artBeneficiaryClinicalDetail.isPresent()) {
                Regimen regimen = artBeneficiaryClinicalDetail.get().getRegimen();
                if (regimen != null) {
                    regimenName = regimen.getRegimenName();
                }
            }
        }
        return regimenName;
    }

    public Long getAdherenceToArt(Optional<Set<ArtBeneficiaryFollowup>> artBeneficiaryFollowups) {
        Long adherenceToArt = 0L;
        if (artBeneficiaryFollowups.isPresent()) {
            Set<ArtBeneficiaryFollowup> artBeneficiaryFollowupSet = artBeneficiaryFollowups.get();
            Optional<ArtBeneficiaryFollowup> artBeneficiaryFollowupOpt = artBeneficiaryFollowupSet.stream()
                    .max(Comparator.comparing(ArtBeneficiaryFollowup::getId));

            if (artBeneficiaryFollowupOpt.isPresent()) {
                ArtBeneficiaryFollowup artBeneficiaryFollowup = artBeneficiaryFollowupOpt.get();
                adherenceToArt = artBeneficiaryFollowup.getAdherenceToArt();
            }
        }
        return adherenceToArt;
    }

    public static String getArtBeneficiaryStatus(ArtBeneficiary artBeneficiary) {
        String artBeneficiaryStatus = "";
        if (artBeneficiary != null) {

            Optional<MasterArtBeneficiaryStatus> masterArtBeneficiaryStatusOptional = Optional
                    .ofNullable(artBeneficiary.getMasterArtBeneficiaryStatus());
            if (masterArtBeneficiaryStatusOptional.isPresent()) {
                artBeneficiaryStatus = masterArtBeneficiaryStatusOptional.get().getName();
            }
        }
        return artBeneficiaryStatus;
    }

    private ArtRegistrationDto mapToArtBeneficiariesDto(Beneficiary beneficiary) {
        ArtRegistrationDto artRegistrationDto = new ArtRegistrationDto();
        try {
            artRegistrationDto = getBeneficiaryBasicData(beneficiary, artRegistrationDto);
            setArtBeneficiaryFields(beneficiary, artRegistrationDto);
            setBeneficiaryVisitRegister(Optional.ofNullable(beneficiary.getBeneficiaryVisitRegisters()),
                    artRegistrationDto);
            setBeneficiaryTransferFields(Optional.ofNullable(beneficiary.getTransfers()), artRegistrationDto);
            setFacilityLinkedBeneficiaryFields(
                    Optional.ofNullable(beneficiary.getFacilityLinkedFacilityBeneficiaries()), artRegistrationDto);
            setBeneficiaryTransitFacilityFields(Optional.ofNullable(beneficiary.getBeneficiaryTransitFacilities()),
                    artRegistrationDto);

            setBeneficiaryQueueList(Optional.ofNullable(beneficiary.getArtBeneficiaryQueues()), artRegistrationDto);
            setBeneficiaryDueListFields(Optional.ofNullable(beneficiary.getArtBeneficiaryDueLists()),
                    artRegistrationDto);
            setBeneficiaryReferralFields(Optional.ofNullable(beneficiary.getBeneficiaryReferral()), artRegistrationDto);
            setBeneficiaryFacilityMappingFields(Optional.ofNullable(beneficiary.getBeneficiaryFacilityMappings()),
                    artRegistrationDto);
            setBeneficiaryDispensationDetails(Optional.ofNullable(beneficiary.getArtDispensations()),
                    artRegistrationDto);
            setArtBeneficiaryClinicalFields(Optional.ofNullable(beneficiary.getArtBeneficiaryClinicalDetails()),
                    artRegistrationDto);
            setArtBeneficiaryFollowupFields(Optional.ofNullable(beneficiary.getArtBeneficiaryFollowups()),
                    artRegistrationDto);
            setArtBeneficiaryIptAttDetails(Optional.ofNullable(beneficiary.getArtBeneficiaryIptAttDetails()),
                    artRegistrationDto);
            setIctcBeneficiaryDetails(Optional.ofNullable(beneficiary.getIctcBeneficiary()), artRegistrationDto);
            setBeneficiarySocialWelfareScheme(Optional.ofNullable(beneficiary.getBeneficiarySocialWelfareSchemes()),
                    artRegistrationDto);
            setBeneficiaryLinkagePurposes(Optional.ofNullable(beneficiary.getArtBeneficiaryLinkagePurposes()),
                    artRegistrationDto);
            setIctcTestResult(Optional.ofNullable(beneficiary.getIctcBeneficiary().getIctcTestResult()), artRegistrationDto);
        } catch (Exception e) {
            logger.info("Error while mapping to ArtRegistrationDto, {} , {} ", e.getMessage(), e.getCause());
            e.printStackTrace();
        }
        return artRegistrationDto;
    }

    private void setIctcTestResult(Optional<Set<IctcTestResult>> ictcTestResults,
                                   ArtRegistrationDto artRegistrationDto) {
        if (ictcTestResults.isPresent()) {
            Set<IctcTestResult> ictcTestResultsSet = ictcTestResults.get();
            Optional<IctcTestResult> ictcTestResultOpt = ictcTestResultsSet.stream()
                    .max(Comparator.comparing(IctcTestResult::getId));
            if (ictcTestResultOpt.isPresent()) {
                IctcTestResult ictcIctcTestResult = ictcTestResultOpt.get();
                artRegistrationDto.setHivDate(ictcIctcTestResult.getTestedDate());
            }
        }
    }

    private ArtRegistrationDto getBeneficiaryBasicData(Beneficiary beneficiary, ArtRegistrationDto artRegistrationDto) {

        artRegistrationDto.setUidNumber(beneficiary.getUid());
        artRegistrationDto.setBeneficiaryId(beneficiary.getId());
        artRegistrationDto.setFirstName(beneficiary.getFirstName());
        artRegistrationDto.setMiddleName(beneficiary.getMiddleName());
        artRegistrationDto.setLastName(beneficiary.getLastName());
        artRegistrationDto.setContactNumber(beneficiary.getMobileNumber());
        artRegistrationDto.setAlternatePhoneNumber(beneficiary.getAlternatePhonenumber());
        artRegistrationDto.setBirthDate(beneficiary.getDateOfBirth());
        artRegistrationDto.setDeathDate(beneficiary.getDeathDate());
        artRegistrationDto.setDeathReason(beneficiary.getDeathReason());
        artRegistrationDto.setPreArtNumber(beneficiary.getPreArtNumber());
        artRegistrationDto.setArtNumber(beneficiary.getArtNumber());
        artRegistrationDto.setAlternatePhoneNumber(beneficiary.getAlternatePhonenumber());
        artRegistrationDto.setAge(beneficiary.getAge());
        artRegistrationDto.setCaregiverName(beneficiary.getCaregiverName());
        artRegistrationDto.setCaregiverPhoneNumber(beneficiary.getCaregiverPhoneNumber());
        artRegistrationDto.setBankAccountName(beneficiary.getBankAccountName());
        artRegistrationDto.setBankAccountNumber(beneficiary.getBankAccountNumber());
        artRegistrationDto.setBankIfsc(beneficiary.getBankIfsc());
        artRegistrationDto.setClosePersonName(beneficiary.getClosePersonName());
        MasterRelationType masterRelationType = beneficiary.getMasterRelationType();
        if (masterRelationType != null) {
            artRegistrationDto.setMasterClosePersonRelationType(beneficiary.getMasterRelationType().getId());
        }

        if (beneficiary.getHivTypeId() != null) {
            artRegistrationDto.setHivTypeId(beneficiary.getHivTypeId().getId());
            artRegistrationDto.setHivTypeName(beneficiary.getHivTypeId().getName());
        }

        if (beneficiary.getMasterEmploymentStatus() != null) {
            artRegistrationDto.setMasterEmploymentStatus(beneficiary.getMasterEmploymentStatus().getId());
        }
        if (beneficiary.getHivStatusId() != null) {
            artRegistrationDto.setHivStatusId(beneficiary.getHivStatusId().getId());
        }
        MasterGender gender = beneficiary.getGenderId();
        if (gender != null) {
            artRegistrationDto.setGenderId(gender.getId());
            artRegistrationDto.setGenderName(gender.getName());
        }
        MasterEducationLevel masterEducationLevel = beneficiary.getEducationLevelId();
        if (masterEducationLevel != null) {
            artRegistrationDto.setEducationLevelId(masterEducationLevel.getId());
            artRegistrationDto.setEducationLevelName(masterEducationLevel.getName());
        }

        if (beneficiary.getMaritalStatusId() != null) {
            artRegistrationDto.setMaritalStatusId(beneficiary.getMaritalStatusId().getId());
        }
        MasterOccupation masterOccupation = beneficiary.getOccupationId();
        if (masterOccupation != null) {
            artRegistrationDto.setOccupationId(masterOccupation.getId());
            artRegistrationDto.setOccupationName(masterOccupation.getName());
        }

        MasterMonthlyIncome monthlyIncome = beneficiary.getMonthlyIncomeId();
        if (monthlyIncome != null) {
            artRegistrationDto.setMonthlyIncome(monthlyIncome.getId());
            artRegistrationDto.setMonthlyIncomeName(monthlyIncome.getName());
        }

        artRegistrationDto.setBankAccountName(beneficiary.getBankAccountName());
        artRegistrationDto.setBankAccountNumber(beneficiary.getBankAccountNumber());
        artRegistrationDto.setBankIfsc(beneficiary.getBankIfsc());
        MasterBeneficiaryCategory category = beneficiary.getCategoryId();

        if (category != null) {
            artRegistrationDto.setCategoryId(category.getId());
            artRegistrationDto.setCategoryName(category.getName());
        }

        if (beneficiary.getAddress() != null) {
            Address address = beneficiary.getAddress();
            artRegistrationDto.setAddressLineOne(address.getAddressLineOne());
            artRegistrationDto.setAddressLineTwo(address.getAddressLineTwo());
            Town town = address.getTown();
            if (town != null) {
                artRegistrationDto.setTown(town.getTownId());
            }

            State state = address.getState();
            if (state != null) {
                artRegistrationDto.setState(state.getId());
                artRegistrationDto.setStateName(state.getName());
            }
            if (address.getDistrict() != null) {
                District district = address.getDistrict();
                artRegistrationDto.setDistrict(district.getId());
                artRegistrationDto.setDistrictName(district.getName());
            }
            if (address.getSubdistrict() != null) {
                Subdistrict subdistrict = address.getSubdistrict();
                artRegistrationDto.setSubDistrictId(subdistrict.getSubdistrictId());
                artRegistrationDto.setSubDistrictName(subdistrict.getSubdistrictName());
            }

            if (address.getPincodeEntity() != null) {
                artRegistrationDto.setPinCode(address.getPincodeEntity().getPincode());
            } else {
                artRegistrationDto.setPinCode(address.getPincode());
            }

        }

        if (beneficiary.getStayingWithId() != null) {
            artRegistrationDto.setStayingWithId(beneficiary.getStayingWithId().getId());
        }
        artRegistrationDto.setCaregiverName(beneficiary.getCaregiverName());
        artRegistrationDto.setCaregiverPhoneNumber(beneficiary.getCaregiverPhoneNumber());

        Address caregiverAddress = beneficiary.getCaregiverAddressId();
        if (caregiverAddress != null) {
            artRegistrationDto.setCaregiveraddressLineOne(caregiverAddress.getAddressLineOne());
            artRegistrationDto.setCaregiveraddressLineTwo(caregiverAddress.getAddressLineTwo());
            if (caregiverAddress.getState() != null) {
                artRegistrationDto.setCaregiverState(caregiverAddress.getState().getId());
            }
            if (caregiverAddress.getSubdistrict() != null) {
                artRegistrationDto.setCaregiverSubDistrictId(caregiverAddress.getSubdistrict().getSubdistrictId());
            }

        }

        return artRegistrationDto;

    }

    private void setBeneficiaryLinkagePurposes(
            Optional<Set<ArtBeneficiaryLinkagePurposes>> artBeneficiaryLinkagePurposesOpt,
            ArtRegistrationDto artRegistrationDto) {
        if (artBeneficiaryLinkagePurposesOpt.isPresent()) {
            Set<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposesSet = artBeneficiaryLinkagePurposesOpt
                    .get();
            Set<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposes = artBeneficiaryLinkagePurposesSet.stream()
                    .filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toSet());

            if (artBeneficiaryLinkagePurposes != null && artBeneficiaryLinkagePurposes.size() > 0) {

                List<Long> linkagePurposeList = new ArrayList();
                artBeneficiaryLinkagePurposes.forEach(linkagePurposes -> {
                    if (linkagePurposes.getMasterPurpos() != null) {
                        linkagePurposeList.add(linkagePurposes.getMasterPurpos().getId());
                    }
                });

                artRegistrationDto.setLinkagePurposesId(linkagePurposeList);

            }
        }
    }

    private void setBeneficiarySocialWelfareScheme(
            Optional<Set<BeneficiarySocialWelfareScheme>> beneficiarySocialWelfareSchemesOpt,
            ArtRegistrationDto artRegistrationDto) {
        if (beneficiarySocialWelfareSchemesOpt.isPresent()) {
            Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemesSet = beneficiarySocialWelfareSchemesOpt
                    .get();
            if (beneficiarySocialWelfareSchemesSet.size() > 0) {
                Set<BeneficiarySocialWelfareScheme> activeBeneficiarySocialWelfareSchemes = beneficiarySocialWelfareSchemesSet
                        .stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toSet());
                if (activeBeneficiarySocialWelfareSchemes != null && activeBeneficiarySocialWelfareSchemes.size() > 0) {
                    List<Long> socialWelfareSchemeList = new ArrayList();
                    activeBeneficiarySocialWelfareSchemes.forEach(bnfSwfScheme -> {
                        socialWelfareSchemeList.add(bnfSwfScheme.getMasterSocialWelfare().getId());
                    });

                    artRegistrationDto.setMasterSocialWelfare(socialWelfareSchemeList);
                }
            }
        }

    }

    private void setIctcBeneficiaryDetails(Optional<IctcBeneficiary> ictcBeneficiaryOptional,
                                           ArtRegistrationDto artRegistrationDto) {

        if (ictcBeneficiaryOptional.isPresent()) {
            IctcBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
            artRegistrationDto.setPatientPid(ictcBeneficiary.getPid());
            Facility ictcCenter = ictcBeneficiary.getFacility();
            if (ictcCenter != null) {
                artRegistrationDto.setIctcCenters(ictcBeneficiary.getFacility().getId());
                artRegistrationDto.setIctcCenterName(ictcBeneficiary.getFacility().getName());
            }
        }

    }

    private ArtRegistrationDto mapBasicDataToArtBeneficiaryDto(Beneficiary beneficiary) {
        ArtRegistrationDto artRegistrationDto = new ArtRegistrationDto();
        try {
            artRegistrationDto = getBeneficiaryBasicData(beneficiary, artRegistrationDto);
            Set artBeneficiarySet = beneficiary.getArtBeneficiary();
            Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiarySet.stream().findFirst();
            ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
            artRegistrationDto.setArtBeneficiaryStatusName(getArtBeneficiaryStatus(artBeneficiary));
            artRegistrationDto.setArtRegistration_date(artBeneficiary.getArtRegistrationDate());
            artRegistrationDto.setArtEligibilityDate(artBeneficiary.getArtEligibilityDate());
            artRegistrationDto.setArtStartDate(artBeneficiary.getArtStartDate());
            MasterEntryPoint entryPoint = artBeneficiary.getEntryPointId();
            if (entryPoint != null) {
                artRegistrationDto.setEntryPointId(entryPoint.getId());
                artRegistrationDto.setEntryPointName(entryPoint.getName());
            }
            MasterRiskFactor riskFactor = artBeneficiary.getMasterRiskFactor();
            if (riskFactor != null) {
                artRegistrationDto.setMasterRiskFactor(riskFactor.getId());
                artRegistrationDto.setMasterRiskFactorName(riskFactor.getName());
            }
            getPreviousArtAndPreArtNumber(Optional.ofNullable(beneficiary.getBeneficiaryFacilityMappings()),
                    artRegistrationDto);
            setIctcBeneficiaryDetails(Optional.ofNullable(beneficiary.getIctcBeneficiary()), artRegistrationDto);
            setBeneficiaryReferralFields(Optional.ofNullable(beneficiary.getBeneficiaryReferral()), artRegistrationDto);
            setArtBeneficiaryClinicalFields(Optional.ofNullable(beneficiary.getArtBeneficiaryClinicalDetails()),
                    artRegistrationDto);
            setBeneficiaryVisitRegister(Optional.ofNullable(beneficiary.getBeneficiaryVisitRegisters()),
                    artRegistrationDto);
            setBeneficiaryDispensationDetails(Optional.ofNullable(beneficiary.getArtDispensations()),
                    artRegistrationDto);
            setArtBeneficiaryIptAttDetails(Optional.ofNullable(beneficiary.getArtBeneficiaryIptAttDetails()),
                    artRegistrationDto);
            setBeneficiaryVisitRegister(Optional.ofNullable(beneficiary.getBeneficiaryVisitRegisters()),
                    artRegistrationDto);
            setIctcTestResult(Optional.ofNullable(beneficiary.getIctcBeneficiary().getIctcTestResult()), artRegistrationDto);
        } catch (Exception e) {
            logger.error("Error while mapping to ArtRegistrationDto, {} , {} ", e.getMessage(), e.getCause());

        }
        return artRegistrationDto;
    }

    private void setArtBeneficiaryClinicalFields(
            Optional<Set<ArtBeneficiaryClinicalDetail>> artBeneficiaryClinicalDetails,
            ArtRegistrationDto artRegistrationDto) {
        if (artBeneficiaryClinicalDetails.isPresent()) {
            Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetailSet = artBeneficiaryClinicalDetails.get();
            Optional<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetail = artBeneficiaryClinicalDetailSet
                    .stream().max(Comparator.comparing(ArtBeneficiaryClinicalDetail::getId));
            if (artBeneficiaryClinicalDetail.isPresent()) {
                Regimen regimen = artBeneficiaryClinicalDetail.get().getRegimen();
                if (regimen != null) {
                    artRegistrationDto.setRegimenId(regimen.getId());
                    artRegistrationDto.setRegimenName(regimen.getRegimenName());
                }
                MasterTreatmentLine treatmentLine = artBeneficiaryClinicalDetail.get().getMasterTreatmentLine();
                if (treatmentLine != null) {
                    artRegistrationDto.setMasterTreatmentLine(treatmentLine.getId());
                }
                artRegistrationDto.setPapSmear(artBeneficiaryClinicalDetail.get().getPapSmear());
                artRegistrationDto.setPptctReferred(artBeneficiaryClinicalDetail.get().getIspptctReferred());
                artRegistrationDto
                        .setPptctPregnancyRemarks(artBeneficiaryClinicalDetail.get().getPptctPregnancyRemarks());
            }
        }

    }

    private void setArtBeneficiaryFollowupFields(Optional<Set<ArtBeneficiaryFollowup>> artBeneficiaryFollowups,
                                                 ArtRegistrationDto artRegistrationDto) {
        if (artBeneficiaryFollowups.isPresent()) {
            Set<ArtBeneficiaryFollowup> artBeneficiaryFollowupSet = artBeneficiaryFollowups.get();
            Optional<ArtBeneficiaryFollowup> artBeneficiaryFollowupOpt = artBeneficiaryFollowupSet.stream()
                    .max(Comparator.comparing(ArtBeneficiaryFollowup::getId));

            if (artBeneficiaryFollowupOpt.isPresent()) {
                ArtBeneficiaryFollowup artBeneficiaryFollowup = artBeneficiaryFollowupOpt.get();
                artRegistrationDto.setAdherenceToArt(artBeneficiaryFollowup.getAdherenceToArt());

                MasterFunctionalStatus functionalStatus = artBeneficiaryFollowupOpt.get().getFunctionalStatusId();
                if (functionalStatus != null) {
                    artRegistrationDto.setPreviousFunctionalStatus(functionalStatus.getName());
                }

                MasterClinicalStage clinicalStage = artBeneficiaryFollowupOpt.get().getClinicalStageId();

                if (clinicalStage != null) {
                    artRegistrationDto.setPreviousClinicalStage(clinicalStage.getName());
                }
            }

        }

    }

    private void setBeneficiaryDispensationDetails(Optional<Set<ArtDispensation>> dispensations,
                                                   ArtRegistrationDto artRegistrationDto) {

        if (dispensations.isPresent()) {
            Set<ArtDispensation> dispensationsSet = dispensations.get();
            Optional<ArtDispensation> dispensationOpt = dispensationsSet.stream()
                    .max(Comparator.comparing(ArtDispensation::getId));
            if (dispensationOpt.isPresent()) {

                ArtDispensation dispensation = dispensationOpt.get();
                artRegistrationDto.setLastDispenseDate(dispensation.getDispenseDate());
                if (dispensation.getArtDispensationItems() != null) {
                    Optional<ArtDispensationItem> dispensationItemOpt = dispensation.getArtDispensationItems().stream()
                            .max(Comparator.comparing(ArtDispensationItem::getId));
                    if (dispensationItemOpt.isPresent()) {
                        ArtDispensationItem artDispensationItem = dispensationItemOpt.get();
                        artRegistrationDto.setLastDispensedQty(artDispensationItem.getDispenseQuantity());
                        artRegistrationDto.setDispensationLatestAdherenceValue(artDispensationItem.getAdherenceToArt());
                        artRegistrationDto.setRemainingPills(artDispensationItem.getRemainingPills());
                        artRegistrationDto.setDosageQty(artDispensationItem.getDosageQty());
                        if (artDispensationItem.getRegimen() != null) {
                            artRegistrationDto
                                    .setDispensationRegimenName(artDispensationItem.getRegimen().getRegimenName());
                            artRegistrationDto.setDispensationRegimenId(artDispensationItem.getRegimen().getId());
                        }

                    }

                }
            }
        }
    }

    private void setBeneficiaryQueueList(Optional<Set<ArtBeneficiaryQueue>> artBeneficiaryQueuesOpt,
                                         ArtRegistrationDto artRegistrationDto) {
        if (artBeneficiaryQueuesOpt.isPresent()) {
            Set<ArtBeneficiaryQueue> artBeneficiaryQueuesSet = artBeneficiaryQueuesOpt.get();

            Long currentFacility = UserUtils.getLoggedInUserDetails().getFacilityId();
            Optional<ArtBeneficiaryQueue> artBeneficiaryQueueOpt = artBeneficiaryQueuesSet.stream()
                    .filter(t -> t.getFacility().getId().equals(currentFacility) && !(t.getIsDelete()) && t.getIsActive())
                    .max(Comparator.comparing(ArtBeneficiaryQueue::getId));

            if (artBeneficiaryQueueOpt.isPresent()) {
                ArtBeneficiaryQueue artBeneficiaryQueue = artBeneficiaryQueueOpt.get();
                UserMaster AssignedToUser = artBeneficiaryQueue.getAssignedToUser();
                if (AssignedToUser != null) {
                    artRegistrationDto.setAssignedTo(AssignedToUser.getId());
                }
            }

        }
    }

    private ArtRegistrationDto setBeneficiaryFacilityMappingFields(
            Optional<Set<BeneficiaryFacilityMapping>> beneficiaryFacilityMappingsOpt,
            ArtRegistrationDto artRegistrationDto) {
        Long currentFacility = UserUtils.getLoggedInUserDetails().getFacilityId();
        if (beneficiaryFacilityMappingsOpt.isPresent()) {
            Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappingSet = beneficiaryFacilityMappingsOpt.get();

            Optional<BeneficiaryFacilityMapping> BeneficiaryFacilityMappingOpt = beneficiaryFacilityMappingSet.stream()
                    .filter(t -> t.getFacility().getId().equals(currentFacility) && !(t.getIsDelete()) && t.getIsActive())
                    .findFirst();

            if (BeneficiaryFacilityMappingOpt.isPresent()) {
                BeneficiaryFacilityMapping beneficiaryFacilityMapping = BeneficiaryFacilityMappingOpt.get();
                artRegistrationDto.setPreviousClinic(beneficiaryFacilityMapping.getArtPreviousClinic());
                artRegistrationDto.setDateTransferredIn(beneficiaryFacilityMapping.getMappingDate());
                if (Optional.ofNullable(beneficiaryFacilityMapping.getPreviousNotTransferredArtId()).isPresent()) {
                    Facility facility = beneficiaryFacilityMapping.getPreviousNotTransferredArtId();
                    artRegistrationDto.setPreviousNotTransferredArtId(facility.getId());
                }
            }

        }
        return artRegistrationDto;
    }

    private ArtRegistrationDto getPreviousArtAndPreArtNumber(
            Optional<Set<BeneficiaryFacilityMapping>> beneficiaryFacilityMappingsOpt,
            ArtRegistrationDto artRegistrationDto) {

        if (beneficiaryFacilityMappingsOpt.isPresent()) {
            Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappingSet = beneficiaryFacilityMappingsOpt.get();
            if (beneficiaryFacilityMappingSet.size() > 1) {
                Optional<BeneficiaryFacilityMapping> beneficiaryFacilityMappingOpt = beneficiaryFacilityMappingSet
                        .stream().distinct().sorted(Comparator.comparing(BeneficiaryFacilityMapping::getId).reversed())
                        .limit(2).skip(1).findFirst();
                if (beneficiaryFacilityMappingOpt.isPresent()) {
                    BeneficiaryFacilityMapping previouBFacMapping = beneficiaryFacilityMappingOpt.get();
                    Boolean isTransffered = previouBFacMapping.getIsTransferred();
                    if (previouBFacMapping.getIsTransferred() != null && previouBFacMapping.getIsTransferred()) {
                        if (previouBFacMapping.getFacility() != null) {
                            artRegistrationDto.setTransferredFrom(previouBFacMapping.getFacility().getName());
                        }
                        artRegistrationDto.setDateTransferredIn(previouBFacMapping.getMappingUpdatedDate());
                        artRegistrationDto.setPreviousArtNumber(previouBFacMapping.getArtNumber());
                        artRegistrationDto.setPreviousPreArtNumber(previouBFacMapping.getPreArtNumber());
                    }
                }
            }
        }
        return artRegistrationDto;
    }

    private void setBeneficiaryDueListFields(Optional<Set<ArtBeneficiaryDueList>> beneficairyDueSet,
                                             ArtRegistrationDto artRegistrationDto) {
        Long currentFacility = UserUtils.getLoggedInUserDetails().getFacilityId();
        if (beneficairyDueSet.isPresent()) {
            Set<ArtBeneficiaryDueList> beneficiaryDueListSet = beneficairyDueSet.get();
            Optional<ArtBeneficiaryDueList> beneficiaryDueListOpt = beneficiaryDueListSet.stream()
                    .filter(t -> Objects.nonNull(t.getExpectedVisitDate()))
                    .filter(t -> t.getFacility().getId().equals(currentFacility) && !(t.getIsDelete()) && t.getIsActive()
                            && ((!t.getIsVisited() && t.getExpectedVisitDate().isEqual(LocalDate.now()))
                            || t.getExpectedVisitDate().isAfter(LocalDate.now())))
                    .sorted(Comparator.comparing(ArtBeneficiaryDueList::getExpectedVisitDate)).limit(1).findFirst();
            if (beneficiaryDueListOpt.isPresent()) {
                ArtBeneficiaryDueList artBeneficiaryDueList = beneficiaryDueListOpt.get();
                artRegistrationDto.setNextVisitDate(artBeneficiaryDueList.getExpectedVisitDate());
            }

        }
    }

    private void getTransferStatus(Optional<Set<Transfer>> transfersOpt, ArtBeneficiaryListDto beneficiaryListDto) {

        Long currentFacility = UserUtils.getLoggedInUserDetails().getFacilityId();
        if (transfersOpt.isPresent()) {
            Set<Transfer> transferSet = transfersOpt.get();
            Optional<Transfer> bnfTransferOpt = transferSet.stream().filter(
                    t -> t.getFacilityFrom().getId().equals(currentFacility) && !(t.getIsDeleted()) && t.getIsActive())
                    .max(Comparator.comparing(Transfer::getId));

            if (bnfTransferOpt.isPresent()) {
                Transfer transfer = bnfTransferOpt.get();
                if (transfer.getFacilityTo() != null) {
                    beneficiaryListDto.setTransferredTo(transfer.getFacilityTo().getName());

                }
                if (transfer.getTransferStatus() != null && transfer.getTransferStatus().equalsIgnoreCase("PENDING")) {
                    beneficiaryListDto.setArtTransferStatus("Transferred-Out");
                } else if (transfer.getTransferStatus() != null && transfer.getTransferStatus().equalsIgnoreCase("ACCEPTED")) {
                    boolean transferredToSameFacility = false;

                    Optional<Transfer> bnfTransferOptDestination = transferSet.stream()
                            .filter(t -> Objects.nonNull(t.getFacilityTo()))
                            .filter(t -> t.getFacilityTo().getId().equals(currentFacility) && !(t.getIsDeleted()) && t.getIsActive())
                            .max(Comparator.comparing(Transfer::getId));
                    if (bnfTransferOptDestination.isPresent()) {
                        Transfer destTransferToCurrFacility = bnfTransferOptDestination.get();
                        if (destTransferToCurrFacility.getAcceptedTime() != null && transfer.getAcceptedTime() != null) {
                            if (destTransferToCurrFacility.getAcceptedTime().isAfter(transfer.getAcceptedTime())) {
                                transferredToSameFacility = true;
                            }
                        }
                    }
                    if (!transferredToSameFacility) {
                        beneficiaryListDto.setArtTransferStatus("Transferred-Out-Accepted");
                    }
                }

            }
        }
    }

    private void setBeneficiaryTransferFields(Optional<Set<Transfer>> transfersOpt,
                                              ArtRegistrationDto artRegistrationDto) {
        if (transfersOpt.isPresent()) {
            Set<Transfer> transferSet = transfersOpt.get();
            Optional<Transfer> bnfTransferOpt = transferSet.stream().filter(t -> !(t.getIsDeleted()) && t.getIsActive())
                    .max(Comparator.comparing(Transfer::getId));

            if (bnfTransferOpt.isPresent()) {
                Transfer transfer = bnfTransferOpt.get();
                Facility failityTo = transfer.getFacilityTo();
                if (Optional.ofNullable(failityTo).isPresent() && failityTo.getIsActive()) {
                    artRegistrationDto.setDestinationFacilityId(failityTo.getId());
                }
                Address facilityAddress = transfer.getFacilityTo().getAddress();
                if (Optional.ofNullable(facilityAddress).isPresent()) {
                    if (facilityAddress.getIsActive()) {
                        if (Optional.ofNullable(facilityAddress.getState()).isPresent()) {
                            artRegistrationDto.setTransferStateId(facilityAddress.getState().getId());
                        }
                        if (Optional.ofNullable(facilityAddress.getState()).isPresent()) {

                            artRegistrationDto.setTransferDistrictId(facilityAddress.getDistrict().getId());
                        }

                    }
                }

                if (transfer.getTransferStatus().equalsIgnoreCase("PENDING")) {
                    artRegistrationDto.setArtTransferStatus("Transferred-Out");
                } else if (transfer.getTransferStatus().equalsIgnoreCase("ACCEPTED")) {
                    artRegistrationDto.setArtTransferStatus("Transferred-Out-Accepted");
                }

            }
        }
    }

    private void setBeneficiaryReferralFields(Optional<Set<BeneficiaryReferral>> BeneficiaryReferralsOpt,
                                              ArtRegistrationDto artRegistrationDto) {
        Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
        if (BeneficiaryReferralsOpt.isPresent()) {

            Set<BeneficiaryReferral> BeneficiaryReferralSet = BeneficiaryReferralsOpt.get();
            Optional<BeneficiaryReferral> bnfBeneficiaryReferralOpt = BeneficiaryReferralSet.stream()
                    .filter(t -> t.getFacility2().getId().equals(facilityId))
                    .max(Comparator.comparing(BeneficiaryReferral::getId));
            if (bnfBeneficiaryReferralOpt.isPresent()) {
                BeneficiaryReferral beneficiaryReferral = bnfBeneficiaryReferralOpt.get();
                // artRegistrationDto.setHivDate(beneficiaryReferral.getDateOfHivTest());
                if (Optional.ofNullable(beneficiaryReferral.getBeneficiaryReferralStatusMaster()).isPresent()) {

                    if (Optional.ofNullable(beneficiaryReferral.getFacility1()).isPresent()) {

                        artRegistrationDto.setIctcCenters(beneficiaryReferral.getFacility1().getId());
                        artRegistrationDto.setIctcCenterName(beneficiaryReferral.getFacility1().getName());
                    }
                }

            }

            Optional<BeneficiaryReferral> bnfBeneficiaryReferralOutOpt = BeneficiaryReferralSet.stream()
                    .filter(t -> t.getFacility1().getId().equals(facilityId))
                    .max(Comparator.comparing(BeneficiaryReferral::getId));
            if (bnfBeneficiaryReferralOutOpt.isPresent()) {
                BeneficiaryReferral beneficiaryReferralOut = bnfBeneficiaryReferralOutOpt.get();
                artRegistrationDto.setReferTo(beneficiaryReferralOut.getFacility2().getId());
                if (Optional.ofNullable(beneficiaryReferralOut.getBeneficiaryReferralStatusMaster()).isPresent()) {
                    artRegistrationDto
                            .setRefferalStatusId(beneficiaryReferralOut.getBeneficiaryReferralStatusMaster().getId());
                    artRegistrationDto
                            .setRefferalStatus(beneficiaryReferralOut.getBeneficiaryReferralStatusMaster().getName());
                }
            }
        }

    }

    private void setFacilityLinkedBeneficiaryFields(Optional<Set> facilityLinkedBeneficiarySetOpt,
                                                    ArtRegistrationDto artRegistrationDto) {
        if (facilityLinkedBeneficiarySetOpt.isPresent()) {
            Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiarySet = facilityLinkedBeneficiarySetOpt
                    .get();
            Optional<FacilityLinkedFacilityBeneficiary> bnfTransferOpt = facilityLinkedFacilityBeneficiarySet.stream()
                    .filter(t -> !(t.getIsDelete()) && t.getIsActive()).findFirst();
            if (bnfTransferOpt.isPresent()) {
                FacilityLinkedFacilityBeneficiary facilityLinkedBeneficiary = bnfTransferOpt.get();
                if (facilityLinkedBeneficiary.getIsLinked()) {
                    if (Optional.ofNullable(facilityLinkedBeneficiary.getLinkedFacilityId()).isPresent()) {
                        if (facilityLinkedBeneficiary.getLinkedFacilityId().getIsActive()) {
                            artRegistrationDto
                                    .setLinkedFacilityId(facilityLinkedBeneficiary.getLinkedFacilityId().getId());
                        }
                    }
                }

            }

        }
    }

    private void setArtBeneficiaryIptAttDetails(
            Optional<Set<ArtBeneficiaryIptAttDetails>> beneficiaryIptAttDetailsOptional,
            ArtRegistrationDto artRegistrationDto) {
        if (beneficiaryIptAttDetailsOptional.isPresent()) {
            Set<ArtBeneficiaryIptAttDetails> beneficiaryIptAttDetailsSet = beneficiaryIptAttDetailsOptional.get();
            Optional<ArtBeneficiaryIptAttDetails> artBeneficiaryIptAttDetailsOptional = beneficiaryIptAttDetailsSet
                    .stream().filter(t -> !t.getIsDelete())
                    .max(Comparator.comparing(ArtBeneficiaryIptAttDetails::getId));

            if (artBeneficiaryIptAttDetailsOptional.isPresent()) {
                ArtBeneficiaryIptAttDetails artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetailsOptional.get();
                ArtBeneficiaryIptAttDetailsDto artBeneficiaryIptAttDetailsDto = ArtBeneficiaryIptAttDetailsMapper
                        .mapArtBeneficiaryIptAttDetailsToArtBeneficiaryIptAttDetailsDto(artBeneficiaryIptAttDetails);
                artRegistrationDto.setArtBeneficiaryIptAttDetails(artBeneficiaryIptAttDetailsDto);
            }

        }
    }

    private void setBeneficiaryTransitFacilityFields(
            Optional<Set<BeneficiaryTransitFacility>> beneficiaryTransitFacilitySetOptional,
            ArtRegistrationDto artRegistrationDto) {
        if (beneficiaryTransitFacilitySetOptional.isPresent()) {
            Set<BeneficiaryTransitFacility> beneficiaryTransitFacilitySet = beneficiaryTransitFacilitySetOptional.get();
            Set<BeneficiaryTransitFacility> bnfTransitSet = beneficiaryTransitFacilitySet.stream()
                    .filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toSet());

            List benfTransitFacilityList = new ArrayList();
            bnfTransitSet.forEach(bnfTransit -> {
                Facility transitFacility = bnfTransit.getFacility();
                if (Optional.ofNullable(transitFacility).isPresent() && transitFacility.getIsActive()) {
                    benfTransitFacilityList.add(transitFacility.getId());
                }

            });
            artRegistrationDto.setTransistFacilityId(benfTransitFacilityList);
        }
    }

    private ArtRegistrationDto setBeneficiaryVisitRegister(
            Optional<Set<BeneficiaryVisitRegister>> beneficiaryVisitRegisterSetOpt,
            ArtRegistrationDto artRegsitrationDto) {
        if (beneficiaryVisitRegisterSetOpt.isPresent()) {
            Set<BeneficiaryVisitRegister> beneficiaryVisitRegisterSet = beneficiaryVisitRegisterSetOpt.get();
            BeneficiaryVisitRegister beneficiaryVisitRegister = beneficiaryVisitRegisterSet.stream()
                    .max(Comparator.comparing(BeneficiaryVisitRegister::getId)).get();
            if (beneficiaryVisitRegisterSet.size() > 1) {
                Optional<BeneficiaryVisitRegister> previousBeneficiaryVisitRegister = beneficiaryVisitRegisterSet
                        .stream().distinct().sorted(Comparator.comparing(BeneficiaryVisitRegister::getId).reversed())
                        .limit(2).skip(1).findFirst();
                if (previousBeneficiaryVisitRegister.isPresent()) {
                    artRegsitrationDto.setPreviousVisitDate(previousBeneficiaryVisitRegister.get().getVisitDate());
                    artRegsitrationDto.setPreviousHeight(previousBeneficiaryVisitRegister.get().getHeight());
                    artRegsitrationDto.setPreviousWeight(previousBeneficiaryVisitRegister.get().getWeight());
                }
            }
            artRegsitrationDto.setVisitRegisterId(beneficiaryVisitRegister.getId());
            artRegsitrationDto.setWeight(beneficiaryVisitRegister.getWeight());
            artRegsitrationDto.setHeight(beneficiaryVisitRegister.getHeight());
            artRegsitrationDto.setIsPregnant(beneficiaryVisitRegister.getIsPregnant());
            artRegsitrationDto.setLmp(beneficiaryVisitRegister.getLmp());
            Optional<MasterPregnancyTypeCase> optionalPregnancyTypeCase = Optional
                    .ofNullable(beneficiaryVisitRegister.getMasterPregnancyTypeCase());
            if (optionalPregnancyTypeCase.isPresent()) {
                MasterPregnancyTypeCase pregnancyTypeCase = optionalPregnancyTypeCase.get();
                artRegsitrationDto.setPregnantCaseTypeId(pregnancyTypeCase.getId());
                artRegsitrationDto.setPregnantCaseTypeName(pregnancyTypeCase.getName());
            }

            if (beneficiaryVisitRegister.getDeliveryOutcome() != null) {
                artRegsitrationDto.setDeliveryOutcomeId(beneficiaryVisitRegister.getDeliveryOutcome().getId());
            }

        }
        return artRegsitrationDto;
    }

    private ArtRegistrationDto setArtBeneficiaryFields(Beneficiary beneficiary, ArtRegistrationDto artRegsitrationDto) {

        Optional<Set> artBeneficiarySetOptional = Optional.ofNullable(beneficiary.getArtBeneficiary());

        if (artBeneficiarySetOptional.isPresent()) {

            Set<ArtBeneficiary> artBeneficiarySet = artBeneficiarySetOptional.get();
            Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiarySet.stream().findFirst();
            ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
            if (artBeneficiaryOptional.isPresent()) {
                artRegsitrationDto.setIsActive(artBeneficiary.getIsActive());
                // artRegsitrationDto.setPreviousClinic(artBeneficiary.getPreviousClinic());
                artRegsitrationDto.setIsTransit(artBeneficiary.getIsTransit());
                artRegsitrationDto.setTransitEndDate(artBeneficiary.getTransitEndDate());
                artRegsitrationDto.setTransitStartDate(artBeneficiary.getTransitStartDate());
                artRegsitrationDto.setIsLinked(artBeneficiary.getLacLinked());
                artRegsitrationDto.setIsConsentTaken(artBeneficiary.getIsConsentTaken());
                if (Optional.ofNullable(artBeneficiary.getMasterArtTreatmentStatus()).isPresent()
                        && artBeneficiary.getMasterArtTreatmentStatus().getIsActive()) {
                    artRegsitrationDto
                            .setMasterArtTreatmentStatus(artBeneficiary.getMasterArtTreatmentStatus().getId());
                }

                Optional<MasterArtBeneficiaryStatus> masterArtBeneficiaryStatusOptional = Optional
                        .ofNullable(artBeneficiary.getMasterArtBeneficiaryStatus());
                if (masterArtBeneficiaryStatusOptional.isPresent()) {
                    artRegsitrationDto.setArtBeneficiaryStatusId(masterArtBeneficiaryStatusOptional.get().getId());
                    artRegsitrationDto.setArtBeneficiaryStatusName(masterArtBeneficiaryStatusOptional.get().getName());
                }
                Optional<MasterBeneficiaryArtTransferredFrom> artTransferredFrom = Optional
                        .ofNullable(artBeneficiary.getMasterBeneficiaryArtTransferredFrom());
                if (artTransferredFrom.isPresent()) {
                    artRegsitrationDto.setArtTransferredFrom(artTransferredFrom.get().getId());
                }

                artRegsitrationDto.setArtRegistration_date(artBeneficiary.getArtRegistrationDate());
                artRegsitrationDto.setArtEligibilityDate(artBeneficiary.getArtEligibilityDate());
                artRegsitrationDto.setArtStartDate(artBeneficiary.getArtStartDate());
                Optional<MasterEntryPoint> masterEntryPointOpt = Optional.ofNullable(artBeneficiary.getEntryPointId());
                if (masterEntryPointOpt.isPresent()) {
                    artRegsitrationDto.setEntryPointId(masterEntryPointOpt.get().getId());
                    artRegsitrationDto.setEntryPointName(masterEntryPointOpt.get().getName());
                }

                Optional<MasterRiskFactor> masterRiskFactorOptional = Optional
                        .ofNullable(artBeneficiary.getMasterRiskFactor());
                if (masterRiskFactorOptional.isPresent()) {
                    artRegsitrationDto.setMasterRiskFactor(masterRiskFactorOptional.get().getId());
                    artRegsitrationDto.setMasterRiskFactorName(masterRiskFactorOptional.get().getName());
                }
                artRegsitrationDto.setLinkageInstituteName(artBeneficiary.getLinkageInstituteName());
                if (artBeneficiary.getMasterOrganisationType() != null) {
                    artRegsitrationDto.setLinkageOrganiationTypeId(artBeneficiary.getMasterOrganisationType().getId());
                }

            }

        }

        return artRegsitrationDto;
    }

    public Integer deleteArtBeneficiary(Long beneficiaryId, Long facilityId) {
        List<BeneficiaryFamilyDetail> beneficiaryFamilyDetails = beneficiaryFamilyDetailRepository
                .findByPartnerBeneficiary_Id(beneficiaryId);
        beneficiaryFamilyDetails.forEach(beneficiaryFamilyDetail -> {
            beneficiaryFamilyDetail.setIsDelete(true);
        });
        beneficiaryFamilyDetailRepository.saveAll(beneficiaryFamilyDetails);
        beneficiaryRepository.deleteBeneficiary(beneficiaryId);
        return artBeneficiaryRepository.deleteArtBeneficiary(beneficiaryId, facilityId);
    }

    public ArtRegistrationDto getArtBeneficiaryById(Long beneficiaryId) {
        ArtRegistrationDto artRegistrationDto = new ArtRegistrationDto();
        Optional<Beneficiary> beneficiaryOptional = executeBeneficiarySpecification(beneficiaryId);
        if (beneficiaryOptional.isPresent()) {
            Beneficiary beneficiary = beneficiaryOptional.get();
            artRegistrationDto = mapToArtBeneficiariesDto(beneficiary);

            BeneficiaryLabTestDetailsDto beneficiaryLabTestDetailsDto = beneficiaryLabTestDetailsService
                    .getBeneficiaryLabTestDetils(beneficiaryId);

            artRegistrationDto.setBeneficiaryLabTestDetils(beneficiaryLabTestDetailsDto);
        }
        return artRegistrationDto;
    }

    private Optional<Beneficiary> executeBeneficiarySpecification(Long beneficiaryId) {
        SearchSpecficationBuilder builder = new SearchSpecficationBuilder();
        Specification<Beneficiary> beneficiarySpecification = Specification.where(null)
                .and(builder.join("artBeneficiary", "isDelete", false)).and(builder.equalsLong("id", beneficiaryId));

        return beneficiaryRepository.findOne(beneficiarySpecification);
    }

    private boolean checkIfBeneficiaryUnStable(String cd4Value, String vlValue) {

        boolean ifUnStable = false;
        SearchSpecficationBuilder builder = new SearchSpecficationBuilder();
        Specification<MasterArtFollowupCriteria> artFollowupCriteriaSpecification = Specification.where(null);
        artFollowupCriteriaSpecification = artFollowupCriteriaSpecification.and(builder.equals("name", "CD4 below"))
                .or(builder.equals("name", "VL above"));

        List<MasterArtFollowupCriteria> masterArtFollowupCriteriaList = masterArtFollowupCriteriaRepository
                .findAll(artFollowupCriteriaSpecification);
        if (masterArtFollowupCriteriaList != null && masterArtFollowupCriteriaList.size() > 0) {
            MasterArtFollowupCriteria cd4Below = masterArtFollowupCriteriaList.get(0);
            MasterArtFollowupCriteria vlAbove = masterArtFollowupCriteriaList.get(1);
            if (cd4Value != null && cd4Below != null && !cd4Value.equalsIgnoreCase("")
                    && Long.parseLong(cd4Value) < cd4Below.getCriteriaParameterValue()) {
                ifUnStable = true;
            }
            if (vlValue != null && vlAbove != null && !vlValue.equalsIgnoreCase("")
                    && Long.parseLong(vlValue) > vlAbove.getCriteriaParameterValue()) {
                ifUnStable = true;
            }

        }
        return ifUnStable;
    }

    public ArtRegistrationDto getArtBeneficiaryBasicData(Long beneficiaryId) {
        ArtRegistrationDto artRegistrationDto = new ArtRegistrationDto();
        Optional<Beneficiary> beneficiaryOptional = executeBeneficiarySpecification(beneficiaryId);
        if (beneficiaryOptional.isPresent()) {

            Beneficiary beneficiary = beneficiaryOptional.get();
            artRegistrationDto = mapBasicDataToArtBeneficiaryDto(beneficiary);

            BeneficiaryLabTestDetailsDto beneficiaryLabTestDetailsDto = beneficiaryLabTestDetailsService
                    .getBeneficiaryLabTestDetils(beneficiaryId);
            if (beneficiaryLabTestDetailsDto != null) {
                artRegistrationDto.setIfBeneficiaryUnStable(
                        checkIfBeneficiaryUnStable(beneficiaryLabTestDetailsDto.getLastCD4Count(),
                                beneficiaryLabTestDetailsDto.getLastViralCount()));
            } else {
                artRegistrationDto.setIfBeneficiaryUnStable(false);
            }
            artRegistrationDto.setBeneficiaryLabTestDetils(beneficiaryLabTestDetailsDto);

        }

        return artRegistrationDto;
    }

    private Specification<Beneficiary> resolveSpecification(String searchParameters,
                                                            SearchSpecficationBuilder builder) {
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\p{Punct}?)(\\w+?)(~|!)([^\\s#]+?)#");
        Matcher matcher = pattern.matcher(searchParameters + "#");
        while (matcher.find()) {
           builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
        }

        return builder.build();
    }

    public ArtBeneficiaryDeleteDto deleteArtBeneficiary(ArtBeneficiaryDeleteDto artBeneficiaryDeleteDto) {
        if (artBeneficiaryDeleteDto.getBeneficiaryId() != null && artBeneficiaryDeleteDto.getBeneficiaryId() != 0) {
            Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiaryRepository.findByBeneficiaryId(
                    artBeneficiaryDeleteDto.getBeneficiaryId(), artBeneficiaryDeleteDto.getFacilityId());
            Optional<ArtBeneficiaryQueue> beneficiaryQueueOptional = artBeneficiaryQueueRepository
                    .findByBeneficiaryIdandFacilityId(artBeneficiaryDeleteDto.getBeneficiaryId(),
                            artBeneficiaryDeleteDto.getFacilityId());
            List<BeneficiaryFamilyDetail> beneficiaryFamilyDetails = beneficiaryFamilyDetailRepository
                    .findByPartnerBeneficiary_Id(artBeneficiaryDeleteDto.getBeneficiaryId());
            beneficiaryFamilyDetails.forEach(beneficiaryFamilyDetail -> {
                beneficiaryFamilyDetail.setIsDelete(true);
                beneficiaryFamilyDetail.setIsActive(Boolean.FALSE);
            });
            beneficiaryFamilyDetailRepository.saveAll(beneficiaryFamilyDetails);
            Optional<ArtBeneficiaryDueList> beneficiaryDueListOptional = artBeneficiaryDueListRepository
                    .findByBeneficiaryIdandFacilityId(artBeneficiaryDeleteDto.getBeneficiaryId(),
                            artBeneficiaryDeleteDto.getFacilityId());
            if (artBeneficiaryOptional.isPresent()) {
                ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
                artBeneficiary.setIsDelete(Boolean.TRUE);
                artBeneficiary.setIsActive(Boolean.FALSE);
                if (artBeneficiaryDeleteDto.getDeleteReason() != null) {
                    artBeneficiary.setDeleteReason(artBeneficiaryDeleteDto.getDeleteReason());
                    MasterArtBeneficiaryDeleteReason masterArtBeneficiaryDeleteReason = mapToArtBeneficiary(
                            artBeneficiaryDeleteDto.getDeleteReasonId());
                    artBeneficiary.setMasterArtBeneficiaryDeleteReason(masterArtBeneficiaryDeleteReason);
                }

                artBeneficiaryRepository.save(artBeneficiary);
                artBeneficiaryDeleteDto.setFirstName(artBeneficiary.getBeneficiary().getFirstName());
            }
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

        }
        return artBeneficiaryDeleteDto;
    }

    private MasterArtBeneficiaryDeleteReason mapToArtBeneficiary(Long deleteReasonId) {
        MasterArtBeneficiaryDeleteReason masterArtBeneficiaryDeleteReason = new MasterArtBeneficiaryDeleteReason();
        masterArtBeneficiaryDeleteReason.setId(deleteReasonId);
        return masterArtBeneficiaryDeleteReason;
    }
}
