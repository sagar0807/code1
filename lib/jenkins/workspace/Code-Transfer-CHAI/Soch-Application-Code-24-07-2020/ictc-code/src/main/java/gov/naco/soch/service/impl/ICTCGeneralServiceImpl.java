package gov.naco.soch.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gov.naco.soch.config.Constants;
import gov.naco.soch.domain.ArtBeneficiary;
import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.domain.BeneficiaryMultiFacilityService;
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.domain.UserMaster;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.repository.BeneficiaryMultiFacilityServiceRepository;
import gov.naco.soch.repository.ICTCBeneficiaryRepository;
import gov.naco.soch.repository.ICTCFollowUpRepository;
import gov.naco.soch.service.AddressService;
import gov.naco.soch.service.BeneficiaryFacilityMappingService;
import gov.naco.soch.service.BeneficiaryFamilyDetailsService;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.BeneficiaryReferralService;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.FacilityService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCFollowUpService;
import gov.naco.soch.service.ICTCGeneralService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.IctcPartnerDetailsService;
import gov.naco.soch.service.dto.AddressDTO;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;
import gov.naco.soch.service.dto.ICTCPregancyFollowUpDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.dto.IctcBeneficiaryDeleteDTO;
import gov.naco.soch.service.dto.IctcPartnerDetailsDTO;
import gov.naco.soch.service.dto.InfantMotherDetailsDTO;
import gov.naco.soch.service.dto.UpdateRelationshipDTO;
import gov.naco.soch.service.dto.UpdateTestResultDTO;
import gov.naco.soch.service.mapper.AddressMapper;
import gov.naco.soch.service.mapper.BeneficiaryMapper;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;
import gov.naco.soch.service.mapper.ICTCFollowUpMapper;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;
import gov.naco.soch.service.mapper.ICTCTestResultMapper;
import gov.naco.soch.service.mapper.ICTCVisitMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

@Service
public class ICTCGeneralServiceImpl implements ICTCGeneralService {
	
	private final Logger log = LoggerFactory.getLogger(ICTCGeneralServiceImpl.class);
	
	private static final String ENTITY_NAME = "SOCH_ICTC_BENEFICIARY";

    private final AddressService addressService;
    
    private final BeneficiaryService beneficiaryService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCVisitService ictcVisitService;
    
    private final ICTCSampleCollectionService ictcSampleCollectionService;
    
    private final ICTCTestResultService ictcTestResultService;
    
    private final ICTCTestResultMapper ictcTestResultMapper;
    
    private final ICTCVisitMapper ictcVisitMapper;
    
    private final ICTCSampleCollectionMapper ictcSampleCollectionMapper;
    
    private final ICTCBeneficiaryMapper ictcBeneficiaryMapper;
    
    private final BeneficiaryMapper beneficiaryMapper;
    
    private final AddressMapper addressMapper;
    
    private final ICTCBeneficiaryRepository ictcBeneficiaryRepository;
    
    private final ICTCFollowUpService followUpService;
    
    private final ICTCFollowUpMapper followUpMapper;
    
    private final ICTCFollowUpRepository followUpRepository;
    
    private final BeneficiaryReferralService referralService;
    
    private final FacilityService facilityService;
    
    private final IctcPartnerDetailsService partnerDetailsService;
    
    private final BeneficiaryFacilityMappingService beneficiaryFacilityMappingService;
    
    private final BeneficiaryFamilyDetailsService familyDetailsService;
    
    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;
    
    private final ArtBeneficiaryRepository artBeneficiaryRepository;
    
    private final BeneficiaryMultiFacilityServiceRepository beneficiaryMultiFacilityServiceRepository;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
    
    public ICTCGeneralServiceImpl(AddressService addressService, BeneficiaryService beneficiaryService, 
    		ICTCBeneficiaryService ictcBeneficiaryService, ICTCVisitService ictcVisitService, 
    		ICTCSampleCollectionService ictcSampleCollectionService, ICTCTestResultService ictcTestResultService,
    		ICTCTestResultMapper ictcTestResultMapper, ICTCVisitMapper ictcVisitMapper, ICTCSampleCollectionMapper ictcSampleCollectionMapper,
    		ICTCBeneficiaryMapper ictcBeneficiaryMapper, BeneficiaryMapper beneficiaryMapper, AddressMapper addressMapper,
    		ICTCBeneficiaryRepository ictcBeneficiaryRepository, ICTCFollowUpService followUpService,
    		ICTCFollowUpMapper followUpMapper, ICTCFollowUpRepository followUpRepository, BeneficiaryReferralService referralService, 
    		FacilityService facilityService, IctcPartnerDetailsService partnerDetailsService, 
    		BeneficiaryFacilityMappingService beneficiaryFacilityMappingService, BeneficiaryFamilyDetailsService familyDetailsService,
    		BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository, ArtBeneficiaryRepository artBeneficiaryRepository,
    		BeneficiaryMultiFacilityServiceRepository beneficiaryMultiFacilityServiceRepository, BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService) {
    	this.addressService = addressService;
    	this.beneficiaryService = beneficiaryService;
    	this.ictcBeneficiaryService = ictcBeneficiaryService;
    	this.ictcVisitService = ictcVisitService;
    	this.ictcSampleCollectionService = ictcSampleCollectionService;
    	this.ictcTestResultService = ictcTestResultService;
    	this.ictcTestResultMapper = ictcTestResultMapper;
    	this.ictcVisitMapper = ictcVisitMapper;
    	this.ictcSampleCollectionMapper = ictcSampleCollectionMapper;
    	this.ictcBeneficiaryMapper = ictcBeneficiaryMapper;
    	this.beneficiaryMapper = beneficiaryMapper;
    	this.addressMapper = addressMapper;
    	this.ictcBeneficiaryRepository =ictcBeneficiaryRepository;
    	this.followUpService = followUpService;
    	this.followUpMapper = followUpMapper;
    	this.followUpRepository = followUpRepository;
    	this.referralService = referralService;
    	this.facilityService = facilityService;
    	this.partnerDetailsService = partnerDetailsService;
    	this.beneficiaryFacilityMappingService = beneficiaryFacilityMappingService;
    	this.familyDetailsService = familyDetailsService;
    	this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
    	this.artBeneficiaryRepository = artBeneficiaryRepository;
    	this.beneficiaryMultiFacilityServiceRepository = beneficiaryMultiFacilityServiceRepository;
    	this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
    }
    
    /**
     * To save ICTC beneficiary
     * 
     * @param beneficiaryDO beneficiaryDO
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDTO createICTCBeneficiary(ICTCBeneficiaryDO beneficiaryDO) {
    	AddressDTO addressDTO = beneficiaryDO.getAddress();
    	addressDTO.setIsActive(true);
    	addressDTO.setIsDelete(false);
    	addressDTO = addressService.save(addressDTO);
    	BeneficiaryDTO beneficiaryDTO = beneficiaryDO.getBeneficiary();
    	beneficiaryDTO.setIsActive(true);
    	beneficiaryDTO.setIsDelete(false);
    	beneficiaryDTO.setAddressId(addressDTO.getId());
    	beneficiaryDTO.setPid(beneficiaryDO.getIctcBeneficiary().getPid());
    	ICTCBeneficiaryDTO ictcBeneficiaryDTO = beneficiaryDO.getIctcBeneficiary();
    	if(ictcBeneficiaryRepository.countByInfantCode(ictcBeneficiaryDTO.getInfantCode()) > 0 && (Constants.BENEFICIARY_CATEGORY_INFANT.equalsIgnoreCase(beneficiaryDTO.getCategory()) || beneficiaryDTO.getCategoryId() == 1) 
    			&& ictcBeneficiaryDTO.getInfantCode()!=null) {
    		throw new BadRequestAlertException("Duplicate Infant Code", ENTITY_NAME, "DUPLICATE_INFANT_CODE");
    	}
    	if(ictcBeneficiaryRepository.countByPidAndDeleteReasonNot(ictcBeneficiaryDTO.getPid()) > 0) {
    		throw new BadRequestAlertException("Duplicate PID", ENTITY_NAME, "DUPLICATE_PID");
    	}
    	temporaryFix(beneficiaryDTO); //to remove
    	if(beneficiaryDO.getBeneficiaryReferralId() != null) {
    		updateBeneficiaryReferralDetails(beneficiaryDO);
    	}
    	beneficiaryDTO = beneficiaryService.save(beneficiaryDTO);
		if (beneficiaryDTO != null 
				&& beneficiaryDTO.getUid() == null) {
			beneficiaryDTO.setUid("U" + Long.valueOf(beneficiaryDTO.getId()));
			beneficiaryDTO = beneficiaryService.save(beneficiaryDTO);
		}
		
		if(beneficiaryDO.getFollowUpId() != null) {
    		followUpRepository.markEntryAsInActive(beneficiaryDO.getFollowUpId());
    		Optional<ICTCFollowUp> optionalFollowUp = followUpService.find(beneficiaryDO.getFollowUpId());
    		if(optionalFollowUp.isPresent()) {
    			ICTCFollowUp followUp = optionalFollowUp.get();
    			if(followUp.getFollowUpType() == 2) {
    				BeneficiaryFamilyDetailsDTO familyDetails = new BeneficiaryFamilyDetailsDTO();
    				familyDetails.setBeneficiaryId(followUp.getIctcBeneficiary().getBeneficiary().getId());
    				familyDetails.setMemberBeneficiaryId(beneficiaryDTO.getId());
    				familyDetails.setRelationshipId(19);
    				familyDetails.setFamilyUid(followUp.getIctcBeneficiary().getBeneficiary().getId().toString());
    				familyDetails.setCreatedTime(LocalDate.now());
    				familyDetails.setIsActive(true);
    				familyDetails.setIsDelete(false);
    				familyDetails.setFamilyUid("UID-" + RandomUtils.nextDouble());
    				familyDetails.setIsBeneficiary(true);
    				familyDetailsService.save(familyDetails);
    				
    				BeneficiaryFamilyDetailsDTO familyDetailsPartner = new BeneficiaryFamilyDetailsDTO();
    				familyDetailsPartner.setMemberBeneficiaryId(followUp.getIctcBeneficiary().getBeneficiary().getId());
    				familyDetailsPartner.setBeneficiaryId(beneficiaryDTO.getId());
    				familyDetailsPartner.setRelationshipId(19);
    				familyDetailsPartner.setFamilyUid(followUp.getIctcBeneficiary().getBeneficiary().getId().toString());
    				familyDetailsPartner.setCreatedTime(LocalDate.now());
    				familyDetailsPartner.setIsActive(true);
    				familyDetailsPartner.setIsDelete(false);
    				familyDetailsPartner.setIsBeneficiary(true);
    				familyDetails.setFamilyUid("UID-" + RandomUtils.nextDouble());
    				familyDetailsService.save(familyDetailsPartner);
    			}
    		}
    	}
		
    	
    	ictcBeneficiaryDTO.setBeneficiaryId(beneficiaryDTO.getId());
    	ictcBeneficiaryDTO.setIsActive(true);
    	ictcBeneficiaryDTO.setIsDeleted(false);
    	ictcBeneficiaryDTO.setCreatedTime(LocalDate.now());
    	if (ictcBeneficiaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new iCTCBeneficiary cannot already have an ID", ENTITY_NAME, "idexists");
        }
    	
    	ictcBeneficiaryDTO = ictcBeneficiaryService.save(ictcBeneficiaryDTO);
    	beneficiaryDO.setIctcBeneficiary(ictcBeneficiaryDTO);
    	
//    	LocalDate dateOfBirth = beneficiaryDTO.getDateOfBirth();
//    	Period age = Period.between(dateOfBirth, LocalDate.now());
//    	long weeks = ChronoUnit.WEEKS.between(dateOfBirth, LocalDate.now());
    	
//    	if(beneficiaryDTO.getCategory().equalsIgnoreCase("INFANT") && weeks < 6) {
//    		throw new BadRequestAlertException("Infant under 6 weeks cannot be registered", "", "Invalid DOB");
//    	}
    	ICTCVisitDTO visit = beneficiaryDO.getVisit();
    	visit.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
    	if(!beneficiaryDO.getIctcBeneficiary().getIsConsentDocumented()) {
        	visit.setBeneficiaryStatus(4);
        	ictcBeneficiaryDTO.setBeneficiaryStatus(4);
        	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(beneficiaryDTO.getId(), 4, null, ictcBeneficiaryDTO.getFacilityId(), null);
    	}
    	else {
    		visit.setBeneficiaryStatus(1);
    		ictcBeneficiaryDTO.setBeneficiaryStatus(1);
    		beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(beneficiaryDTO.getId(), 1, null, ictcBeneficiaryDTO.getFacilityId(), null);
    	}
    	visit.setIsActive(true);
    	visit.setIsDeleted(false);
    	visit.setIsMultiFacilityService(false);
    	visit = ictcVisitService.save(visit);
    	updateBeneficiaryMultiFacilityLinking(beneficiaryDTO.getId(), ictcBeneficiaryDTO.getFacilityId(), ictcBeneficiaryDTO, visit);
    	
    	BeneficiaryFacilityMappingDTO beneficiaryFacilityMapping = new BeneficiaryFacilityMappingDTO();
    	beneficiaryFacilityMapping.setBeneficiaryId(beneficiaryDTO.getId());
    	beneficiaryFacilityMapping.setFacilityId(visit.getFacilityId());
    	beneficiaryFacilityMapping.setCreatedTime(LocalDate.now());
    	beneficiaryFacilityMapping.setIsActive(true);
    	beneficiaryFacilityMapping.setIsDelete(false);
    	beneficiaryFacilityMapping.setMappingDate(LocalDate.now());
    	beneficiaryFacilityMappingService.save(beneficiaryFacilityMapping);
    	
    	if(Constants.BENEFICIARY_CATEGORY_INFANT.equalsIgnoreCase(beneficiaryDTO.getCategory()) || beneficiaryDTO.getCategoryId() == 1) {
    		log.debug("Inside create sample for infant");
    	} else {
    		ICTCSampleCollectionDTO sample = new ICTCSampleCollectionDTO();
        	sample.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
        	sample.setVisitId(visit.getId());
        	sample.setIsActive(true);
    		sample.setIsDeleted(false);
    		sample.setFacilityId(visit.getFacilityId());
    		sample.setTestType(11);
    		sample.setCreatedTime(LocalDate.now());
    		sample.setSampleCollectionDate(getCurrentTimeInIndia().toLocalDateTime());
    		System.out.println(sample.getSampleCollectionDate());
    		sample = ictcSampleCollectionService.save(sample);
        	
        	ICTCTestResultDTO result = new ICTCTestResultDTO();
        	result.setResultStatus(1);
        	result.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
        	result.setVisitId(visit.getId());
        	result.setIsActive(true);
        	result.setIsDeleted(false);
    		result.setSampleId(sample.getId());
    		result = ictcTestResultService.save(result);

    		ictcBeneficiaryDTO.setCurrentTestResultId(result.getId());
    	}
    	if(beneficiaryDO.getReferrals() != null) {
    		for(BeneficiaryReferralDTO referral : beneficiaryDO.getReferrals()) {
    			Integer type = referral.getReferralTypeId();
    			referral.setIsActive(true);
    			referral.setIsDelete(false);
    			referral.setReferralStatusId(2);
    			referral.setCreatedTime(LocalDate.now());
//    			referral.setReferDate(LocalDate.now());
    			referral.setBeneficiaryId(beneficiaryDTO.getId());
    			referral = referralService.save(referral);
    			switch(type) {
    			case 1: ictcBeneficiaryDTO.setArtReferralId(referral.getId());
    					ictcBeneficiaryDTO.setArtReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			case 2: ictcBeneficiaryDTO.setTiReferralId(referral.getId());
    					ictcBeneficiaryDTO.setTiReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			case 3: ictcBeneficiaryDTO.setDsrcReferralId(referral.getId());
    					ictcBeneficiaryDTO.setDsrcReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			case 4: ictcBeneficiaryDTO.setRntcpReferralId(referral.getId());
    					ictcBeneficiaryDTO.setRntcpReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			default: break;
    			}
    		}
    	}
    	ictcBeneficiaryDTO.setRecentVisitId(visit.getId());
    	ictcBeneficiaryService.save(ictcBeneficiaryDTO);
    	if(beneficiaryDO.getInfantMotherDetails() != null) {
    		if(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId() != null) {
	    		List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(beneficiaryDTO.getId(), 4);
	    		if(!motherDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
	    			motherDetail.setMemberBeneficiaryId(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId());
	    			motherDetail.isBeneficiary(true);
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		} else {
	    			BeneficiaryFamilyDetails motherDetail = new BeneficiaryFamilyDetails();
	    			motherDetail.setBeneficiaryId(beneficiaryDTO.getId());
	    			motherDetail.setMemberBeneficiaryId(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId());
	    			motherDetail.setIsActive(true);
	    			motherDetail.setIsDelete(false);
	    			motherDetail.isBeneficiary(true);
	    			motherDetail.setRelationshipId(4);
	    			motherDetail.setCreatedTime(LocalDate.now());
	    			motherDetail.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		}
	    		List<BeneficiaryFamilyDetails> mothersRelationToInfantDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId(), beneficiaryDTO.getId());
	    		if(!mothersRelationToInfantDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherRelationToInfant = mothersRelationToInfantDetails.get(0);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(Constants.BENEFICIARY_GENDER_MALE.equalsIgnoreCase(beneficiaryDTO.getGender()) || beneficiaryDTO.getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (Constants.BENEFICIARY_GENDER_FEMALE.equalsIgnoreCase(beneficiaryDTO.getGender()) || beneficiaryDTO.getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		} else {
	    			BeneficiaryFamilyDetails motherRelationToInfant = new BeneficiaryFamilyDetails();
	    			motherRelationToInfant.setBeneficiaryId(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId());
	    			motherRelationToInfant.setMemberBeneficiaryId(beneficiaryDTO.getId());
	    			motherRelationToInfant.setIsActive(true);
	    			motherRelationToInfant.setIsDelete(false);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(Constants.BENEFICIARY_GENDER_MALE.equalsIgnoreCase(beneficiaryDTO.getGender()) || beneficiaryDTO.getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (Constants.BENEFICIARY_GENDER_FEMALE.equalsIgnoreCase(beneficiaryDTO.getGender()) || beneficiaryDTO.getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			motherRelationToInfant.setCreatedTime(LocalDate.now());
	    			motherRelationToInfant.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		}
    		}
    	}
        return ictcBeneficiaryDTO;
    }
    
    
    /**
     * Update beneficiary referal details
     * 
     * @param beneficiaryReferralId beneficiaryReferralId
     */
    public void updateBeneficiaryReferralDetails(ICTCBeneficiaryDO beneficiaryDO) {
    	Optional<BeneficiaryReferralDTO> optional = referralService.findOne(beneficiaryDO.getBeneficiaryReferralId());
    	if(!optional.isPresent()) {
    		throw new BadRequestAlertException("Invalid beneficiary referral id", "", "Invalid beneficiary referral id");
    	}
    	BeneficiaryReferralDTO referral = optional.get();
    	referral.setAcceptedDate(LocalDate.now());
    	referral.setReferralStatusId(3);
    	referral.setIctcBeneficiaryId(beneficiaryDO.getIctcBeneficiary().getId());
    	validateDuplicateIctcRecord(referral.getBeneficiaryId());
    	referralService.save(referral);
    }
    
    public void validateDuplicateIctcRecord(Long beneficiaryId) {
    	if(ictcBeneficiaryRepository.countByBeneficiaryId(beneficiaryId) > 0) {
    		throw new BadRequestAlertException("Duplicate Referral", ENTITY_NAME, "DUPLICATE_REFERRAL");
    	}
    }
    
    /**
     * Get ICTC Beneficiary Details
     * 
     * @param ictcBeneficiaryId ictcBeneficiaryId
     * @return
     */
    public ICTCBeneficiaryDO getICTCBeneficiaryDetails(Long ictcBeneficiaryId) {
    	Optional<ICTCBeneficiary> ictcBeneficiaryOptional = ictcBeneficiaryService.find(ictcBeneficiaryId);
    	if(!ictcBeneficiaryOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid ICTCBeneficiaryId", "", "Invalid ICTCBeneficiaryId");
    	}
    	ICTCBeneficiaryDO response = new ICTCBeneficiaryDO();
    	ICTCBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
    	response.setIctcBeneficiary(ictcBeneficiaryMapper.toDto(ictcBeneficiary));
    	response.setBeneficiary(beneficiaryMapper.toDto(ictcBeneficiary.getBeneficiary()));
    	response.setAddress(addressMapper.toDto(ictcBeneficiary.getBeneficiary().getAddress()));
    	if(ictcBeneficiary.getCurrentTestResultId() != null) {
    		Optional<ICTCTestResult> resultOptional = ictcTestResultService.find(ictcBeneficiary.getCurrentTestResultId());
    		if(resultOptional.isPresent()) {
    			response.setResult(ictcTestResultMapper.toDto(resultOptional.get()));
    			response.setSample(ictcSampleCollectionMapper.toDto(resultOptional.get().getSample()));
    		}
    	}
    	if(ictcBeneficiary.getRecentVisitId() != null) {
    		Optional<ICTCVisitDTO> visitOptional = ictcVisitService.findOne(ictcBeneficiary.getRecentVisitId());
    		if(visitOptional.isPresent()) {
    			response.setVisit(visitOptional.get());
    		}
    	}
    	
    	if(Constants.BENEFICIARY_CATEGORY_INFANT.equalsIgnoreCase(ictcBeneficiary.getBeneficiary().getCategory()) || ictcBeneficiary.getBeneficiary().getCategoryId() == 1) {
    		List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(ictcBeneficiary.getBeneficiary().getId(), 4);
    		if(!motherDetails.isEmpty()) {
    			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
    			Optional<ArtBeneficiary> artOptional = artBeneficiaryRepository.findByBeneficiaryId(motherDetail.getMemberBeneficiary().getId());
    			InfantMotherDetailsDTO details = new InfantMotherDetailsDTO();
    			details.setFirstName(motherDetail.getMemberBeneficiary().getFirstName());
    			details.setMiddleName(motherDetail.getMemberBeneficiary().getMiddleName());
    			details.setLastName(motherDetail.getMemberBeneficiary().getLastName());
    			details.setBeneficiaryId(motherDetail.getMemberBeneficiary().getId());
    			details.setArtDetailsFound(false);
    			if(artOptional.isPresent()) {
    				details.setArtDetailsFound(true);
    				ArtBeneficiary artBeneficiary = artOptional.get();
    				details.setArtNumber(motherDetail.getMemberBeneficiary().getArtNumber());
        			details.setPreArtNumber(motherDetail.getMemberBeneficiary().getPreArtNumber());
        			details.setArtCenterId(artBeneficiary.getFacility().getId());
        			details.setArtCode(artBeneficiary.getFacility().getCode());
        			details.setMotherArtCenter(artBeneficiary.getFacility());
    			}
    			response.setInfantMotherDetails(details);
    		}
    	}
    	return response;
    }
    
    /**
     * Update beneficiary details
     * 
     * @param details
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDO updateICTCBeneficiaryDetails(ICTCBeneficiaryDO details) {
    	if(details.getIctcBeneficiary() != null) {
    		if(details.getIctcBeneficiary().getId() != null) {
    			ICTCBeneficiaryDTO ictcBeneficiaryDTO = details.getIctcBeneficiary();
    			if(details.getReferrals() != null) {
    	    		for(BeneficiaryReferralDTO referral : details.getReferrals()) {
    	    			Integer type = referral.getReferralTypeId();
    	    			referral.setIsActive(true);
    	    			referral.setIsDelete(false);
    	    			referral.setReferralStatusId(2);
    	    			referral.setCreatedTime(LocalDate.now());
//    	    			referral.setReferDate(LocalDate.now());
    	    			referral.setBeneficiaryId(details.getBeneficiary().getId());
    	    			referral = referralService.save(referral);
    	    			switch(type) {
    	    			case 1: ictcBeneficiaryDTO.setArtReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setArtReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			case 2: ictcBeneficiaryDTO.setTiReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setTiReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			case 3: ictcBeneficiaryDTO.setDsrcReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setDsrcReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			case 4: ictcBeneficiaryDTO.setRntcpReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setRntcpReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			default: break;
    	    			}
    	    		}
    	    	}
    			ictcBeneficiaryService.save(details.getIctcBeneficiary());
    		}
    	}
    	if(details.getBeneficiary() != null) {
    		if(details.getBeneficiary().getId() != null) {
    			beneficiaryService.save(details.getBeneficiary());
    		}
    	}
    	if(details.getAddress() != null) {
    		if(details.getAddress().getId() != null) {
    			addressService.save(details.getAddress());
    		}
    	}
    	if(details.getVisit() != null) {
    		if(details.getVisit().getId() != null) {
    			ICTCVisitDTO visit = details.getVisit();
    			if(visit.getIsMultiFacilityService() == null) {
    				visit.setIsMultiFacilityService(false);
    			}
    			details.setVisit(ictcVisitService.save(visit));
    		}
    	}
    	if(details.getSample() != null) {
    		if(details.getSample().getId() != null) {
    			ictcSampleCollectionService.save(details.getSample());
    		}
    	}
    	if(details.getResult() != null) {
    		if(details.getResult().getId() != null) {
    			ictcTestResultService.save(details.getResult());
    		}
    	}
    	
//    	if(details.getReferrals() != null && details.getReferrals().size() != 0) {
//    		for(int i=0; i<details.getReferrals().size(); i++) {
//    			referralService.save(details.getReferrals().get(i));
//    		}
//    	}
    	
       	if(details.getFollowups() != null) {
    		for(ICTCFollowUpDTO followUpDTO : details.getFollowups()) {
    			followUpDTO.setCreatedTime(LocalDate.now());
    			followUpDTO.setIsCompleted(false);
    			followUpDTO.setIsActive(true);
    			followUpDTO.setIsDeleted(false);
    			followUpService.save(followUpDTO);
    		}
    	}
       	if(details.getInfantMotherDetails() != null) {
       		if(details.getInfantMotherDetails().getBeneficiaryId() != null) {
	    		List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(details.getBeneficiary().getId(), 4);
	    		if(!motherDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
	    			motherDetail.setIsBeneficiary(true);
	    			motherDetail.setMemberBeneficiaryId(details.getInfantMotherDetails().getBeneficiaryId());
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		} else {
	    			BeneficiaryFamilyDetails motherDetail = new BeneficiaryFamilyDetails();
	    			motherDetail.setBeneficiaryId(details.getBeneficiary().getId());
	    			motherDetail.setMemberBeneficiaryId(details.getInfantMotherDetails().getBeneficiaryId());
	    			motherDetail.setIsActive(true);
	    			motherDetail.setIsDelete(false);
	    			motherDetail.setRelationshipId(4);
	    			motherDetail.setIsBeneficiary(true);
	    			motherDetail.setCreatedTime(LocalDate.now());
	    			motherDetail.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		}
	    		List<BeneficiaryFamilyDetails> mothersRelationToInfantDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(details.getInfantMotherDetails().getBeneficiaryId(), details.getBeneficiary().getId());
	    		if(!mothersRelationToInfantDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherRelationToInfant = mothersRelationToInfantDetails.get(0);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(Constants.BENEFICIARY_GENDER_MALE.equalsIgnoreCase(details.getBeneficiary().getGender()) || details.getBeneficiary().getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (Constants.BENEFICIARY_GENDER_FEMALE.equalsIgnoreCase(details.getBeneficiary().getGender()) || details.getBeneficiary().getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		} else {
	    			BeneficiaryFamilyDetails motherRelationToInfant = new BeneficiaryFamilyDetails();
	    			motherRelationToInfant.setBeneficiaryId(details.getInfantMotherDetails().getBeneficiaryId());
	    			motherRelationToInfant.setMemberBeneficiaryId(details.getBeneficiary().getId());
	    			motherRelationToInfant.setIsActive(true);
	    			motherRelationToInfant.setIsDelete(false);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(Constants.BENEFICIARY_GENDER_MALE.equalsIgnoreCase(details.getBeneficiary().getGender()) || details.getBeneficiary().getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (Constants.BENEFICIARY_GENDER_FEMALE.equalsIgnoreCase(details.getBeneficiary().getGender()) || details.getBeneficiary().getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			motherRelationToInfant.setCreatedTime(LocalDate.now());
	    			motherRelationToInfant.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		}
	       	}
    	}
    	
    	return details;
    }
    
    /**
     * Update Test Result
     * 
     * @param updateTestResultDTO updateTestResultDTO
     * @return
     */
    @Transactional
    public UpdateTestResultDTO updateTestResult(UpdateTestResultDTO updateTestResultDTO) {
    	 log.debug("REST request to update test result : {}", updateTestResultDTO);
         if (updateTestResultDTO.getResultId() == null) {
             throw new BadRequestAlertException("Invalid Test Result id", ENTITY_NAME, "id null");
         }
    	 Optional<ICTCTestResult> resultOptional = ictcTestResultService.find(updateTestResultDTO.getResultId());
    	 if(!resultOptional.isPresent()) {
    		 throw new BadRequestAlertException("Result not found", ENTITY_NAME, "Result not found");
    	 }
    	 ICTCTestResult result = resultOptional.get();
    	 result.setHivStatus(updateTestResultDTO.getHivStatus());
    	 result.setHivType(updateTestResultDTO.getHivType());
    	 
    	 LocalDateTime testedDateTime = getCurrentTimeInIndia().toLocalDateTime();
    	 testedDateTime = testedDateTime.withYear(updateTestResultDTO.getTestedDate().getYear());
    	 testedDateTime = testedDateTime.withMonth(updateTestResultDTO.getTestedDate().getMonthValue());
    	 testedDateTime = testedDateTime.withDayOfMonth(updateTestResultDTO.getTestedDate().getDayOfMonth());
    	 result.setTestedDate(testedDateTime);
    	 
    	 result.setReportDeliveryDate(updateTestResultDTO.getReportDeliveryDate());
    	 result.setReportReceivedDate(updateTestResultDTO.getReportReceivedDate());
    	 result.setResultStatus(2);
    	 if(updateTestResultDTO.getLabInchargeId() != null) {
    		 ICTCSampleCollection sample = result.getSample();
    		 sample.setLabIncharge(new UserMaster(updateTestResultDTO.getLabInchargeId()));
    		 ictcSampleCollectionService.save(ictcSampleCollectionMapper.toDto(sample));
    	 }
    	 ICTCVisit visit = result.getVisit();
    	 
    	 Integer prevStatus = visit.getBeneficiaryStatus();
    	 visit.setBeneficiaryStatus(2); //"PENDING_POST_TC"
    	 ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
    	 ictcBeneficiary.setBeneficiaryStatus(2);
    	 
    	 Beneficiary beneficiary = result.getIctcBeneficiary().getBeneficiary();
    	 beneficiary.setHivStatusId(result.getHivStatus());
    	 beneficiary.setHivTypeId(result.getHivType());
    	 beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
    	 
    	 if(Constants.BENEFICIARY_CATEGORY_INFANT.equalsIgnoreCase(beneficiary.getCategory()) || beneficiary.getCategoryId() == 1) {
    		 visit.setBeneficiaryStatus(11);
    		 ictcBeneficiary.setBeneficiaryStatus(11);
    		 result.setResultStatus(4);
    	 }
    	 
    	 beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), visit.getBeneficiaryStatus(), prevStatus, visit.getFacility().getId(), null);
    	 
    	 ictcVisitService.save(ictcVisitMapper.toDto(visit));
    	 ictcTestResultService.save(ictcTestResultMapper.toDto(result));
    	 ictcBeneficiaryService.save(ictcBeneficiary);
    	 return updateTestResultDTO;
    }
    
    /**
     * Revoke Test Result
     * 
     * @param testResultId testResultId
     */
    @Transactional
    public void revokeTestResult(Long testResultId) {
         if (testResultId == null) {
             throw new BadRequestAlertException("Invalid Test Result id", ENTITY_NAME, "id null");
         }
    	 Optional<ICTCTestResult> resultOptional = ictcTestResultService.find(testResultId);
    	 if(!resultOptional.isPresent()) {
    		 throw new BadRequestAlertException("Result not found", ENTITY_NAME, "Result not found");
    	 }
    	 ICTCTestResult result = resultOptional.get();
    	 result.setHivStatus(null);
    	 result.setHivType(null);
    	 result.setTestedDate(null);
    	 result.setReportDeliveryDate(null);
    	 result.setReportReceivedDate(null);
    	 result.setResultStatus(1);
    	 ICTCVisit visit = result.getVisit();
    	 
    	 beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), 1, visit.getBeneficiaryStatus(), visit.getFacility().getId(), null);
    	 
    	 visit.setBeneficiaryStatus(1); //"PENDING"
    	 
    	 ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
    	 ictcBeneficiary.setBeneficiaryStatus(1);
    	 
    	 Beneficiary beneficiary = result.getIctcBeneficiary().getBeneficiary();
    	 beneficiary.setHivStatusId(null);
    	 beneficiary.setHivTypeId(null);
    	 beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
    	 
    	 ictcVisitService.save(ictcVisitMapper.toDto(visit));
    	 ictcTestResultService.save(ictcTestResultMapper.toDto(result));
    	 ictcBeneficiaryService.save(ictcBeneficiary);
    }
    
    /**
     * Delete and entity(Soft Delete)
     * 
     * @param id id
     */
    @Transactional
    public void deleteICTCBeneficiary(Long id) {
    	ictcBeneficiaryRepository.markEntryAsDeletedAndInActive(id);
    }
    
    
    /**
     * Update post counselling details
     * 
     * @param details details
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDO updatePostCounselling(ICTCBeneficiaryDO details) {
    	ICTCVisitDTO visitForUpdate = null;
    	ICTCBeneficiaryDTO ictcBeneficiary = null;
    	Integer hivStatus = null;
    	Integer prevStatus = null;
    	Integer currentStatus = null;
    	if(details.getVisit() != null) {
    		ICTCVisitDTO visit = details.getVisit();
    		if(visit.getIsMultiFacilityService() == null) {
    			visit.setIsMultiFacilityService(false);
    		}
    		prevStatus = visit.getBeneficiaryStatus();
    		visit.setBeneficiaryStatus(5);
    		currentStatus = 5;
    		visit = ictcVisitService.save(visit);
    		visitForUpdate = visit;
    		details.setVisit(visit);
    	}
    	if(details.getIctcBeneficiary() != null) {
    		ictcBeneficiary = details.getIctcBeneficiary();
    		if(details.getReferrals() != null) {
    			List<BeneficiaryReferralDTO> referrals = new ArrayList<>();
        		for(BeneficiaryReferralDTO referral : details.getReferrals()) {
        			Integer type = referral.getReferralTypeId();
        			referral.setIsActive(true);
        			referral.setIsDelete(false);
        			referral.setReferralStatusId(2);
        			referral.setCreatedTime(LocalDate.now());
//        			referral.setReferDate(LocalDate.now());
        			referral = referralService.save(referral);
        			switch(type) {
        			case 1: ictcBeneficiary.setArtReferralId(referral.getId());
        					ictcBeneficiary.setArtReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					if(visitForUpdate != null) {
	        					visitForUpdate.setBeneficiaryStatus(6);
	        					currentStatus = 6;
	        					ictcVisitService.save(visitForUpdate);
        					}
        					break;
        			case 2: ictcBeneficiary.setTiReferralId(referral.getId());
        					ictcBeneficiary.setTiReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					break;
        			case 3: ictcBeneficiary.setDsrcReferralId(referral.getId());
        					ictcBeneficiary.setDsrcReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					break;
        			case 4: ictcBeneficiary.setRntcpReferralId(referral.getId());
        					ictcBeneficiary.setRntcpReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					break;
        			default: break;
        			}
        			referrals.add(referral);
        		}
        		details.setReferrals(referrals);
        	}
//    		ictcBeneficiary = ictcBeneficiaryService.save(ictcBeneficiary);
    		if(details.getPartnerDetails() != null) {
    			for(IctcPartnerDetailsDTO partnerDetails : details.getPartnerDetails()) {
    				partnerDetails.setCreatedDate(LocalDate.now());
    				partnerDetailsService.save(partnerDetails);
    			}
    		}
    		details.setIctcBeneficiary(ictcBeneficiary);
    	}
    	if(details.getResult() != null) {
    		ICTCTestResultDTO result = ictcTestResultService.save(details.getResult());
    		details.setResult(result);
    		hivStatus = result.getHivStatus();
    	}
    	if(details.getBeneficiary() != null) {
    		BeneficiaryDTO beneficiary = details.getBeneficiary();
    		if(hivStatus != null) {
    			beneficiary.setHivStatusId(hivStatus);
    		}
    		beneficiary = beneficiaryService.save(details.getBeneficiary());
    		details.setBeneficiary(beneficiary);
    	}
    	if(details.getSample() != null) {
    		ICTCSampleCollectionDTO sample = ictcSampleCollectionService.save(details.getSample());
    		details.setSample(sample);
    	}
    	if(details.getFollowups() != null) {
    		List<ICTCFollowUpDTO> followUps = new ArrayList<>();
    		for(ICTCFollowUpDTO followUpDTO : details.getFollowups()) {
    			if(visitForUpdate != null && followUpDTO.getFollowUpType() == 1) {
    				visitForUpdate.setBeneficiaryStatus(3);
    				currentStatus = 3;
    				ictcVisitService.save(visitForUpdate);
    			}
    			followUpDTO.setCreatedTime(LocalDate.now());
    			followUpDTO.setIsActive(true);
    			followUpDTO.setIsDeleted(false);
    			followUps.add(followUpService.save(followUpDTO));
    		}
    		details.setFollowups(followUps);
    	}
    	ictcBeneficiary.setBeneficiaryStatus(currentStatus);
    	ictcBeneficiaryService.save(ictcBeneficiary);
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(details.getBeneficiary().getId(), currentStatus, prevStatus, details.getVisit().getFacilityId(), null);
    	return details;
    }
    	
    /**
     * Update ictcbeneficiary relationship
     * 
     * @param ictcBeneficiaryId ictcBeneficiaryId
     * @param relationshipRecordId
     * @param relationshipType
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDTO updateInfantRelationship(UpdateRelationshipDTO relationship) {
    	if(relationship.getFollowUpId() != null) {
    		followUpRepository.markEntryAsInActive(relationship.getFollowUpId());
    	}
    	Optional<ICTCBeneficiary> beneficiaryOptional = ictcBeneficiaryService.find(relationship.getIctcBeneficiaryId());
    	if(!beneficiaryOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid ICTCBeneficiary Id", ENTITY_NAME, "Invalid ICTCBeneficiary Id");
    	}
    	Optional<ICTCBeneficiary> relationOptional = ictcBeneficiaryService.find(relationship.getRelationshipRecordId());
    	if(!relationOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid relationshipRecordId Id", ENTITY_NAME, "Invalid relationshipRecordId Id");
    	}
    	ICTCBeneficiary infant = beneficiaryOptional.get();
    	ICTCBeneficiary mother = relationOptional.get();
    	
    	List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(infant.getBeneficiary().getId(), 4);
		if(!motherDetails.isEmpty()) {
			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
			motherDetail.setMemberBeneficiaryId(mother.getBeneficiary().getId());
			motherDetail.setIsBeneficiary(true);
			beneficiaryFamilyDetailsRepository.save(motherDetail);
		} else {
			BeneficiaryFamilyDetails motherDetail = new BeneficiaryFamilyDetails();
			motherDetail.setBeneficiaryId(infant.getBeneficiary().getId());
			motherDetail.setMemberBeneficiaryId(mother.getBeneficiary().getId());
			motherDetail.setIsActive(true);
			motherDetail.setIsDelete(false);
			motherDetail.setIsBeneficiary(true);
			motherDetail.setRelationshipId(4);
			motherDetail.setCreatedTime(LocalDate.now());
			motherDetail.setFamilyUid("UID" + RandomUtils.nextDouble());
			beneficiaryFamilyDetailsRepository.save(motherDetail);
		}
		List<BeneficiaryFamilyDetails> mothersRelationToInfantDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(mother.getBeneficiary().getId(), infant.getBeneficiary().getId());
		if(!mothersRelationToInfantDetails.isEmpty()) {
			BeneficiaryFamilyDetails motherRelationToInfant = mothersRelationToInfantDetails.get(0);
			motherRelationToInfant.setIsBeneficiary(true);
			if(Constants.BENEFICIARY_GENDER_MALE.equalsIgnoreCase(infant.getBeneficiary().getGender()) || infant.getBeneficiary().getGenderId() == 1) {
				motherRelationToInfant.setRelationshipId(5);
			} else if (Constants.BENEFICIARY_GENDER_FEMALE.equalsIgnoreCase(infant.getBeneficiary().getGender()) || infant.getBeneficiary().getGenderId() == 2) {
				motherRelationToInfant.setRelationshipId(6);
			}
			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
		} else {
			BeneficiaryFamilyDetails motherRelationToInfant = new BeneficiaryFamilyDetails();
			motherRelationToInfant.setIsBeneficiary(true);
			motherRelationToInfant.setBeneficiaryId(mother.getBeneficiary().getId());
			motherRelationToInfant.setMemberBeneficiaryId(infant.getBeneficiary().getId());
			motherRelationToInfant.setIsActive(true);
			motherRelationToInfant.setIsDelete(false);
			if(Constants.BENEFICIARY_GENDER_MALE.equalsIgnoreCase(infant.getBeneficiary().getGender()) || infant.getBeneficiary().getGenderId() == 1) {
				motherRelationToInfant.setRelationshipId(5);
			} else if (Constants.BENEFICIARY_GENDER_FEMALE.equalsIgnoreCase(infant.getBeneficiary().getGender()) || infant.getBeneficiary().getGenderId() == 2) {
				motherRelationToInfant.setRelationshipId(6);
			}
			motherRelationToInfant.setCreatedTime(LocalDate.now());
			motherRelationToInfant.setFamilyUid("UID" + RandomUtils.nextDouble());
			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
		}
    
    	
//    	beneficiary.setRelationshipRecordId(relationship.getRelationshipRecordId());
//    	beneficiary.setRelationshipType(relationship.getRelationshipType());
    	infant = ictcBeneficiaryService.save(infant);
    	return ictcBeneficiaryMapper.toDto(infant);
    }
    
    /**
     * Initiate ICTC follow up
     * 
     * @param followUpId followUpId
     * @return ICTCBeneficiaryDO
     */
    @Transactional
    public ICTCBeneficiaryDTO initiateIctcFollowUpVisit(Long followUpId, Long facilityId) {
    	Optional<ICTCFollowUp> optional = followUpService.find(followUpId);
    	if(!optional.isPresent()) {
    		throw new BadRequestAlertException("Invalid Follow Up Id", ENTITY_NAME, "Invalid");
    	}
    	ICTCFollowUp ictcFollowUp = optional.get();
    	ictcFollowUp.setIsActive(false);
    	ictcFollowUp.setIsCompleted(true);
    	followUpService.save(followUpMapper.toDto(ictcFollowUp));
    	ICTCBeneficiary ictcBeneficiary = ictcFollowUp.getIctcBeneficiary();
    	
//    	LocalDate dateOfBirth = ictcBeneficiary.getBeneficiary().getDateOfBirth();
//    	Period age = Period.between(dateOfBirth, LocalDate.now());
//    	long weeks = ChronoUnit.WEEKS.between(dateOfBirth, LocalDate.now());
    	
    	ICTCVisitDTO visit = ictcVisitMapper.toDto(ictcFollowUp.getVisit());
    	visit.setId(null);
    	visit.setIsMultiFacilityService(false);
    	visit.setIctcBeneficiaryId(ictcBeneficiary.getId());
    	
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(ictcBeneficiary.getBeneficiary().getId(), 1, visit.getBeneficiaryStatus(), facilityId, null);
    	visit.setBeneficiaryStatus(1);
    	ictcBeneficiary.setBeneficiaryStatus(1);
    	
    	visit.setVisitDate(LocalDate.now());
    	visit.setIsActive(true);
    	visit.setIsDeleted(false);
    	visit = ictcVisitService.save(visit);
    	if(facilityId != null) {
    		updateBeneficiaryMultiFacilityLinking(ictcBeneficiary.getBeneficiary().getId(), facilityId, ictcBeneficiaryMapper.toDto(ictcBeneficiary), visit);
    	}
    	
    	ICTCSampleCollectionDTO sample = new ICTCSampleCollectionDTO();
    	sample.setIctcBeneficiaryId(ictcBeneficiary.getId());
    	sample.setVisitId(visit.getId());
    	sample.setIsActive(true);
		sample.setIsDeleted(false);
		sample.setCreatedTime(LocalDate.now());
		sample.setSampleCollectionDate(getCurrentTimeInIndia().toLocalDateTime());
		sample.setFacilityId(visit.getFacilityId());
    	
    	ICTCTestResultDTO result = new ICTCTestResultDTO();
    	result.setResultStatus(1);
    	result.setIctcBeneficiaryId(ictcBeneficiary.getId());
    	result.setVisitId(visit.getId());
    	result.setIsActive(true);
    	result.setIsDeleted(false);
    	
//    	if(Constants.BENEFICIARY_CATEGORY_INFANT.equalsIgnoreCase(ictcBeneficiary.getBeneficiary().getCategory())) {
//    		log.debug("Inside create sample for infant");
//    		if(age.toTotalMonths() < 6 && weeks >= 6) {
//    			sample.setTestType(1);
//        	} else if(age.toTotalMonths() > 6) {
//        		sample.setTestType(2);
//        	}
//    	} else {
    	sample.setTestType(11);
//    	}
    	sample = ictcSampleCollectionService.save(sample);
    	result.setSampleId(sample.getId());
    	result = ictcTestResultService.save(result);
    	ictcBeneficiary.setCurrentTestResultId(result.getId());
    	ictcBeneficiary.setRecentVisitId(visit.getId());
    	return ictcBeneficiaryService.save(ictcBeneficiaryMapper.toDto(ictcBeneficiary));
    }
    
    /**
     * To update pregnancy follow up details
     * 
     * @param details details
     * @return
     */
    @Transactional
    public ICTCPregancyFollowUpDTO updatePregrancyFollowUpDetails(ICTCPregancyFollowUpDTO details) {
    	if(details.getVisitId() == null) {
    		throw new BadRequestAlertException("Visit Id is null", "", "Visit Id is null");
    	}
    	Optional<ICTCVisitDTO> visitOptional = ictcVisitService.findOne(details.getVisitId());
    	if(!visitOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid visitId", "", "Invalid visitId");
    	}
    	ICTCVisitDTO visit = visitOptional.get();
    	if(visit.getIsMultiFacilityService() == null) {
    		visit.setIsMultiFacilityService(false);
    	}
    	visit.setDeliveryOutcome(details.getDeliveryOutcome());
    	visit.setGravida(details.getGravida());
    	visit.setDeliveryDate(details.getDeliveryDate());
    	ictcVisitService.save(visit);
    	if(details.getFollowUps()!=null) {
    		List<ICTCFollowUpDTO> followUps = new ArrayList<>();
    		for (ICTCFollowUpDTO followUp : details.getFollowUps()) {
    			followUp.setCreatedTime(LocalDate.now());
    			followUp.setIsActive(true);
    			followUp.setIsDeleted(false);
    			followUp.setFollowUpDate(LocalDate.now().plusWeeks(6));
    			followUps.add(followUpService.save(followUp));
    		}
    		details.setFollowUps(followUps);
    	}
    	if(details.getFollowUpId() == null) {
    		throw new BadRequestAlertException("Invalid follow up id", "", "Invalid follow up id");
    	}
    	followUpRepository.markEntryAsInActive(details.getFollowUpId());
    	return details;
    }
    
    /**
     * TO delete an ICTC beneficiary
     * 
     * @param beneficiaryDeleteDTO beneficiaryDeleteDTO details 
     */
    @Transactional
    public void deleteIctcBeneficiaryWithReason(IctcBeneficiaryDeleteDTO beneficiaryDeleteDTO) {
    	Optional<ICTCBeneficiary> ictcBeneficiaryOptional = ictcBeneficiaryService.find(beneficiaryDeleteDTO.getIctcBeneficiaryId());
    	if(!ictcBeneficiaryOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid follow up id", "", "INVALID_ICTC_BENEFICIARY");
    	}
    	ICTCBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
    	ictcBeneficiary.setIsActive(false);
    	ictcBeneficiary.setIsDeleted(true);
    	ictcBeneficiary.setDeleteReason(beneficiaryDeleteDTO.getDeletedReason());
    	ictcBeneficiary.setDeleteReasonComment(beneficiaryDeleteDTO.getDeletedReasonComment());
    	ictcBeneficiaryService.save(ictcBeneficiary);
    }
    
    //toremove
    private void temporaryFix(BeneficiaryDTO ben) {
    	if(ben.getCategory() != null) {
    		if(Constants.BENEFICIARY_CATEGORY_INFANT.equalsIgnoreCase(ben.getCategory())) {
    			ben.setCategoryId(1);
    		} else if (Constants.BENEFICIARY_CATEGORY_ADULT.equalsIgnoreCase(ben.getCategory())) {
    			ben.setCategoryId(3);
    		} else if (Constants.BENEFICIARY_CATEGORY_PED.equalsIgnoreCase(ben.getCategory())) {
    			ben.setCategoryId(2);
    		}
    	}
    }
    
    private ZonedDateTime getCurrentTimeInIndia() {
    	ZonedDateTime currentTime = ZonedDateTime.now();
    	ZoneId india = ZoneId.of("Asia/Kolkata");
    	currentTime = currentTime.withZoneSameInstant(india);
    	return currentTime;
    }
    
    private void updateBeneficiaryMultiFacilityLinking(Long beneficiaryId, Long facilityId, ICTCBeneficiaryDTO ictcBeneficiary, ICTCVisitDTO visit) {
    	List<BeneficiaryMultiFacilityService> list = beneficiaryMultiFacilityServiceRepository.findAllByBeneficiaryIdAndVisitedFacilityId(beneficiaryId, beneficiaryId);
    	if(list.isEmpty()) {
    		BeneficiaryMultiFacilityService beneficiaryMultiFacilityService = new BeneficiaryMultiFacilityService();
    		beneficiaryMultiFacilityService.setBeneficiaryId(beneficiaryId);
    		beneficiaryMultiFacilityService.setIctcVisitId(visit.getId());
    		beneficiaryMultiFacilityService.setRegisteredFacilityId(ictcBeneficiary.getFacilityId());
    		beneficiaryMultiFacilityService.setVisitedFacilityId(facilityId);
    		beneficiaryMultiFacilityService.setVisitDate(LocalDate.now());
    		beneficiaryMultiFacilityService.setCreatedBy(facilityId);
    		beneficiaryMultiFacilityService.setCreatedTime(LocalDate.now());
    		beneficiaryMultiFacilityService.setIsActive(true);
    		beneficiaryMultiFacilityService.setIsDeleted(false);
    		beneficiaryMultiFacilityServiceRepository.save(beneficiaryMultiFacilityService);
    		if(!ictcBeneficiary.getFacilityId().equals(facilityId)) {
	    		visit.setIsMultiFacilityService(true);
	    		ictcVisitService.save(visit);
    		}
    	}
    }
    
}
