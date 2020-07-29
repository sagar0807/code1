package gov.naco.soch.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.domain.Facility;
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.FacilityRepository;

@Service
public class ICTCBeneficiaryStatusUpdateService {

	@Autowired 
	private BeneficiaryReferralRepository beneficiaryReferralRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Autowired
	private ICTCVisitService visitService;
	
	@Autowired
	private BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
	
	@Autowired
	private ICTCBeneficiaryService ictcBeneficiaryService;
	
	@Transactional
	public void updateStatus() {
		Long ictc[] = {11L, 13L};
		Set<Long> ictcFacilityTypeIds = new HashSet<>(Arrays.asList(ictc));
		List<Facility> ictcFacilities = facilityRepository.findAllByFacilityTypeIdIn(ictcFacilityTypeIds);
		Set<Long> ictcFacilityIds = ictcFacilities.stream().map(Facility::getId).collect(Collectors.toSet());
		
		Long art[] = {15L, 16L, 17L, 18L};
		Set<Long> artFacilityTypeIds = new HashSet<>(Arrays.asList(art));
		List<Facility> artFacilities = facilityRepository.findAllByFacilityTypeIdIn(artFacilityTypeIds);
		Set<Long> artFacilityIds = artFacilities.stream().map(Facility::getId).collect(Collectors.toSet());
		
		LocalDateTime currentDateTime = getCurrentTimeInIndia().toLocalDateTime();
		LocalDate currentDate = currentDateTime.toLocalDate();
		List<BeneficiaryReferral> referrals = beneficiaryReferralRepository.findAllByFacilityAndDateForStatusUpdateByReferredFrom(currentDate.minusDays(9), currentDate.minusDays(7), ictcFacilityIds);
		processBeneficiaryReferralStatus(referrals, artFacilityIds);
	}
	
	private void processBeneficiaryReferralStatus(List<BeneficiaryReferral> referrals, Set<Long> artFacilityIds) {
		for(BeneficiaryReferral referral : referrals) {
			referral.setReferralStatusId(1);
			beneficiaryReferralRepository.save(referral);
			if(artFacilityIds.contains(referral.getReferedTo().getId())) {
				ICTCBeneficiary ictcBeneficiary = referral.getBeneficiary().getIctcBeneficiary();
				ictcBeneficiary.setBeneficiaryStatus(7);
				ictcBeneficiaryService.save(ictcBeneficiary);
				Optional<ICTCVisit> optionalVisit = visitService.find(referral.getBeneficiary().getIctcBeneficiary().getRecentVisitId());
				if(optionalVisit.isPresent()) {
					ICTCVisit visit = optionalVisit.get();
					beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(referral.getBeneficiary().getId(), 7, visit.getBeneficiaryStatus(), null, null);
					visit.setBeneficiaryStatus(7);
					visitService.save(visit);
				}
			}
		}
	}
	
	private ZonedDateTime getCurrentTimeInIndia() {
    	ZonedDateTime currentTime = ZonedDateTime.now();
    	ZoneId india = ZoneId.of("Asia/Kolkata");
    	currentTime = currentTime.withZoneSameInstant(india);
    	return currentTime;
    }
}
