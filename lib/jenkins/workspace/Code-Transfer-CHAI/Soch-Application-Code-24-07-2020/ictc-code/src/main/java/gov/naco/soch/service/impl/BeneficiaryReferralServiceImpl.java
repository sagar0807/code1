package gov.naco.soch.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.BeneficiaryReferralService;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.FacilityService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.mapper.BeneficiaryReferralMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link BeneficiaryReferral}.
 */
@Service
@Transactional
public class BeneficiaryReferralServiceImpl implements BeneficiaryReferralService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryReferralServiceImpl.class);

    private final BeneficiaryReferralRepository beneficiaryReferralRepository;

    private final BeneficiaryReferralMapper beneficiaryReferralMapper;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCVisitService visitService;
    
    private final FacilityService facilityService;
    
    private final BeneficiaryService beneficiaryService;
    
    private final ICTCTestResultService ictcTestResultService;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;

    public BeneficiaryReferralServiceImpl(BeneficiaryReferralRepository beneficiaryReferralRepository, BeneficiaryReferralMapper beneficiaryReferralMapper,
    		ICTCBeneficiaryService ictcBeneficiaryService, FacilityService facilityService, ICTCVisitService visitService, BeneficiaryService beneficiaryService,
    		ICTCTestResultService ictcTestResultService, BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService) {
        this.beneficiaryReferralRepository = beneficiaryReferralRepository;
        this.beneficiaryReferralMapper = beneficiaryReferralMapper;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
        this.facilityService = facilityService;
        this.visitService = visitService;
        this.beneficiaryService = beneficiaryService;
        this.ictcTestResultService = ictcTestResultService;
        this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
    }

    /**
     * Save a beneficiaryReferral.
     *
     * @param beneficiaryReferralDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    @Transactional
	public BeneficiaryReferralDTO saveReferral(BeneficiaryReferralDTO beneficiaryReferralDTO) {

		log.debug("Request to save BeneficiaryReferral : {}", beneficiaryReferralDTO);
		BeneficiaryReferral beneficiaryReferral = beneficiaryReferralMapper.toEntity(beneficiaryReferralDTO);
		beneficiaryReferral.setIsActive(true);
		beneficiaryReferral.setIsDelete(false);
		beneficiaryReferral.setReferralStatusId(beneficiaryReferralDTO.getReferralStatusId());
		beneficiaryReferral.setCreatedTime(LocalDate.now());
		beneficiaryReferral.setReferDate(LocalDate.now());
		beneficiaryReferral = beneficiaryReferralRepository.save(beneficiaryReferral);

		Optional<Beneficiary> beneficiaryOptional = beneficiaryService
				.find(beneficiaryReferralDTO.getBeneficiaryId());
		if (beneficiaryOptional.isPresent()) {
			Beneficiary beneficiary = beneficiaryOptional.get();
			beneficiary.setHivStatusId(2);
			Optional<ICTCTestResultDTO> testResultOptional = ictcTestResultService.findOne(beneficiary.getIctcBeneficiary().getCurrentTestResultId());
			if(testResultOptional.isPresent()) {
				beneficiary.setHivTypeId(testResultOptional.get().getHivType());
			}
			beneficiaryService.saveBeneficiary(beneficiary);
		}
		if (beneficiaryReferralDTO.getIctcBeneficiaryId() != null) {
			Optional<ICTCBeneficiaryDTO> optional = ictcBeneficiaryService
					.findOne(beneficiaryReferralDTO.getIctcBeneficiaryId());
			ICTCBeneficiaryDTO ictcBeneficiaryDTO = optional.get();
			if (optional.isPresent()) {
				// throw new BadRequestAlertException("Invalid ICTCBeneficiary Id", "ICTC",
				// "Invalid ICTCBeneficiary Id");
				ictcBeneficiaryDTO.setArtReferralId(beneficiaryReferral.getId());
				ictcBeneficiaryDTO.setArtReferralName(
						facilityService.getFacilityFromFacilityId(beneficiaryReferralDTO.getReferedTo()));
				ictcBeneficiaryDTO.setBeneficiaryStatus(6);
				ictcBeneficiaryService.save(ictcBeneficiaryDTO);
			}

			Optional<ICTCVisitDTO> visitOptional = visitService.findOne(ictcBeneficiaryDTO.getRecentVisitId());
			if (visitOptional.isPresent()) {
				ICTCVisitDTO visit = visitOptional.get();
				beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(beneficiaryReferralDTO.getBeneficiaryId(), 6, visit.getBeneficiaryStatus(), beneficiaryReferralDTO.getReferedFrom(), null);
				visit.setBeneficiaryStatus(6);
			}
		}

		return beneficiaryReferralMapper.toDto(beneficiaryReferral);
	}
    
    /**
     * Save a beneficiaryReferral.
     *
     * @param beneficiaryReferralDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    @Transactional
    public BeneficiaryReferralDTO save(BeneficiaryReferralDTO beneficiaryReferralDTO) {
    	log.debug("Request to save BeneficiaryReferral : {}", beneficiaryReferralDTO);
        BeneficiaryReferral beneficiaryReferral = beneficiaryReferralMapper.toEntity(beneficiaryReferralDTO);
//        BeneficiaryDTO beneficiary = beneficiaryService.findOne(beneficiaryReferral.getBeneficiary().getId()).get();
//        if(beneficiary.getHivStatusId() != null) {
//        	beneficiaryReferral.setHivStatus(beneficiary.getHivStatusId().toString());
//        }
//        if(beneficiary.getHivTypeId() != null) {
//        	beneficiaryReferral.setHivStatus(beneficiary.getHivTypeId().toString());
//        }
        beneficiaryReferral = beneficiaryReferralRepository.save(beneficiaryReferral);
        return beneficiaryReferralMapper.toDto(beneficiaryReferral);
    }

    /**
     * Get all the beneficiaryReferrals.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BeneficiaryReferralDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BeneficiaryReferrals");
        return beneficiaryReferralRepository.findAll(pageable)
            .map(beneficiaryReferralMapper::toDto);
    }

    /**
     * Get one beneficiaryReferral by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BeneficiaryReferralDTO> findOne(Long id) {
        log.debug("Request to get BeneficiaryReferral : {}", id);
        return beneficiaryReferralRepository.findById(id)
            .map(beneficiaryReferralMapper::toDto);
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Optional<BeneficiaryReferral> find(Long id) {
        log.debug("Request to get BeneficiaryReferral : {}", id);
        return beneficiaryReferralRepository.findById(id);
    }

    /**
     * Delete the beneficiaryReferral by id.
     *
     * @param id the id of the entity.
     */
    @Override
    @Transactional
    public void delete(Long id) {
        log.debug("Request to delete BeneficiaryReferral : {}", id);
        Optional<BeneficiaryReferral> referralOptional = beneficiaryReferralRepository.findById(id);
        if(!referralOptional.isPresent()) {
        	throw new BadRequestAlertException("Invalid Referral Id", "ICTC","INVALID_ID");
        }
        BeneficiaryReferral referral = referralOptional.get();
        referral.setIsDelete(true);
        referral.setIsActive(false);
        referral.setModifiedTime(LocalDate.now());
        beneficiaryReferralRepository.save(referral);
    }
    
    /**
     * Decline the beneficiaryReferral by id.
     *
     * @param id the id of the entity.
     */
    public void declineBeneficiaryReferral(Long id) {
    	log.debug("Request to decline BeneficiaryReferral : {}", id);
    	Optional<BeneficiaryReferralDTO> optional = findOne(id);
    	if(optional.isPresent()) {
    		BeneficiaryReferralDTO referral = optional.get();
    		referral.setDeclinedDate(LocalDate.now());
    		referral.setReferralStatusId(4);
    		save(referral);
    	}
    }
    
    
    /**
     * Get all active beneficiary referrals for a beneficiay
     * 
     * @param beneficiaryId beneficiaryId
     * @return beneficiary referrals
     */
    public List<BeneficiaryReferralDTO> getActiveReferralsForABeneficiary(Long beneficiaryId){
    	return beneficiaryReferralRepository.findAllActiveReferralsForABeneficiary(beneficiaryId)
    			.stream()
    			.map(beneficiaryReferralMapper::toDto)
    			.collect(Collectors.toList());
    }
}

